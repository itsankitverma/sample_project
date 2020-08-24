/**
 * ProcessRIHFileRunnable.java
 *
 * Created on 13 de mayo de 2004, 16:02
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.common.gccsftp.FTPClient;
//import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FTPException;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.PrepPoaBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.PrepaidVISAFileVO;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.interfaces.rih.MDEResponse;
import com.fedex.lacitd.cashcontrol.interfaces.rih.ShipmentType;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipInputStream;
/**
 *
 * @author  ccardenas
 */
public class ProcessRIHFileRunnable implements java.lang.Runnable, java.io.Serializable {
    private String[] files=new String[0];    
    
    /** Holds value of property prop. */
    private ServletContext servletCtx;
    
    /** Holds value of property thread. */
    private java.lang.Thread thread;
    
    /** Creates a new instance of InCageExceptionsRunnable */
    public ProcessRIHFileRunnable() {
    }
    
    public void run() {
            Iterator iterFiles=null;
            Properties prop=null;
            FTPClient clt=null;
            PrepPoaBizDelegate biz=null;
            while(!"STOP_THREAD".equals(thread.getName())){

                try{
                    prop=new Properties();
                    prop=Utils.getProperties("P");
                    clt=new FTPClient(prop.getProperty("prepaid.rih.ftpServer"));
                    clt.login(prop.getProperty("prepaid.rih.ftpUserName"),prop.getProperty("prepaid.rih.ftpPwd"));                
                    clt.setType(FTPTransferType.BINARY);

                    biz=new PrepPoaBizDelegate();
                    for(int idx=0;idx<files.length;idx++){                    
                         if(files[idx].toLowerCase().indexOf(".zip")!=-1){
                         	 ZipInputStream zis=new ZipInputStream(new ByteArrayInputStream(clt.get(prop.getProperty("prepaid.rih.dir")+"/"+files[idx])));
                         	 ByteArrayOutputStream baos=new ByteArrayOutputStream();
                         	 
                         	 if(zis.getNextEntry()!=null){
                         	 	while(zis.available()>0){
                       	 			char ch=(char)zis.read();
                       	 			if((int) ch!=65535){ //the file was comming with a 0xff char
                       	 				baos.write(ch);
                       	 			}                       	 			
                         	 	}                         	 	
                         	 }
                         	 
                         	 zis.close();
                         	 
                             Collection colAwbs=parseXML(new ByteArrayInputStream(baos.toByteArray()),prop);

                             if(colAwbs!=null && !colAwbs.isEmpty()) {
                                     Collection notFound=biz.processVISAFile(colAwbs);

                                     if(!notFound.isEmpty()){
                                         Collection results=new ArrayList();
                                         PrepNotCheckedScanProc procScan=new PrepNotCheckedScanProc();
                                         procScan.processLastScans(notFound,results);
                                         biz.applyPrepNotCheckedScans(results);
                                     }
                             }
                             /***moving the file to processed****/
                             clt.rename(prop.getProperty("prepaid.rih.dir")+"/"+files[idx],prop.getProperty("prepaid.rih.processedDir")+"/"+files[idx]+new Date().toString().replace(' ','_').replace(':','_'));
                         }    
                    }
               }catch(Exception e){
               		 try{
	                     Constants.logger.debug(Utils.stackTraceToString(e));
	                     Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH File Importing Problem.",e.toString());	                     
               		 }catch(Exception e1){}
               		 
                     try{
                        Thread.sleep(Constants.VISAFileProcTaskInterval);
                     }catch(InterruptedException ie){}                       
               } 
               
               files=new String[0];                 
               
               try{ 
                   clt.chdir(prop.getProperty("prepaid.rih.dir"));

                    //Get the list of file into the folder
                    String [] files=clt.dir();

                   Constants.logger.debug("found files="+files.length);
                   clt.quit();
                   clt=null;
                   biz=null;    

                   Thread.sleep(Constants.RIHFileProcTaskInterval);                                      
               }catch(Exception e){
               		 try{
	               		 Constants.logger.debug(Utils.stackTraceToString(e));
	                     Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH File Importing Problem.",e.toString());
               		 }catch(Exception e1){}
               		 
                     try{
                        Thread.sleep(Constants.RIHFileProcTaskInterval);
                     }catch(InterruptedException ie){}                        
               }   
            }
    }

    private Collection parseXML(InputStream is,Properties prop){
    	Collection result=null;
    	try{
    		JAXBContext jc  = JAXBContext.newInstance( "com.fedex.lacitd.cashcontrol.interfaces.rih"); //this is a workaround because of one bug in beta of jaxb.
    		Unmarshaller um = jc.createUnmarshaller(); 
    		
    		um.setValidating(true);
    		
    		//unmarshalling the XML file into object tree
    		MDEResponse rl = (MDEResponse)um.unmarshal(is);
    		Date now=new Date();
    		Collection colShipment=rl.getShipment();
    		Iterator iterShipment=colShipment.iterator();
    		result=new ArrayList(); 

    		DecimalFormat fmt=new DecimalFormat("###########0.00##");
    		SimpleDateFormat sdf=new SimpleDateFormat("M/d/yyyy H:m:s");
    		
    		while(iterShipment.hasNext()){ 
    			PrepaidVISAFileVO pvf=new PrepaidVISAFileVO();
    			
    			ShipmentType st=(ShipmentType) iterShipment.next();
    			
    			pvf.setAwbNbr(st.getAwbNbr());
    			pvf.setOrigLocation(st.getOrigLocation());    			
    			pvf.setOrigCountry(st.getOrigCountry());
    			try{
    				pvf.setShipDate(sdf.parse(st.getShipDt()));
    			}catch(Exception e){
    				pvf.setShipDate(now);
    			}	
    			pvf.setCustomerNm(st.getShipperNm()==null?st.getShipperCompany():st.getShipperNm());
    			pvf.setFreightAmtInVisa(st.getFreightChargeAmt()==null?0:st.getFreightChargeAmt().doubleValue());
    			result.add(pvf);    	
    		}
    		
    		
    	}catch( UnmarshalException je ) {
    		Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(je));
    		Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH File Importing Problem.",je.toString());
    		return null;           
    	}catch( JAXBException je ) {
    		Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n" + Utils.stackTraceToString(je));
    		Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH File Importing Problem.",je.toString());
    		return null;    
    	}catch(Exception je){
    		Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(je));
    		Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH File Importing Problem.",je.toString());
    		return null;   
    	}    
    	
    	return result;     	
    }  
    
    /** Getter for property prop.
     * @return Value of property prop.
     */
    public ServletContext getServletCtx() {
        return this.servletCtx;
    }    

    /** Setter for property prop.
     * @param prop New value of property prop.
     */
    public void setServletCtx(ServletContext servletCtx) {
        this.servletCtx = servletCtx;
    }
    
    /** Getter for property thread.
     * @return Value of property thread.
     */
    public java.lang.Thread getThread() {
        return this.thread;
    }
    
    /** Setter for property thread.
     * @param thread New value of property thread.
     */
    public void setThread(java.lang.Thread thread) {
        this.thread = thread;
    }
}
