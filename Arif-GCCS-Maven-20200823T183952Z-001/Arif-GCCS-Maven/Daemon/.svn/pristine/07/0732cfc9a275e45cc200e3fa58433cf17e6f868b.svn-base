package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.common.gccsftp.FTPClient;
//import com.enterprisedt.net.ftp.FTPClient;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.RODBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.ReceivablesSurchargesVO;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.controller.RodFileProcLogController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RecExpSrchgVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RodFileProcLogVO;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableList;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableType;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.SurchargeType;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.Util;
import com.enterprisedt.net.ftp.FTPException;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
/**
 * This is a class runnable from a Thread that
 * is always monitoring an ftp site to import 
 * the xml files that are uploaded there. It is
 * used to the rod xml file import
 * @author  ccardenas
 */
public class ImportFromXMLRunnable implements java.io.Serializable,java.lang.Runnable {
    private String[] files=new String[0];
    
    
    /** Holds value of property prop. */
    private ServletContext servletCtx;
    
    /** Holds value of property thread. */
    private java.lang.Thread thread;
    
    /** Creates a new instance of InCageExceptionsRunnable */
    public ImportFromXMLRunnable() {
    }
    
    /**
     * This methods is started in his own thread.
     * This code is running all the time monitoring
     * an ftp site to import the files that are being
     * 
     */
    public void run()  {
            Iterator iterFiles=null;
            Properties prop=null;
            FTPClient clt=null;
            RODBizDelegate biz=null;
            
            String currentFile=null;
            
            while(!"STOP_THREAD".equals(thread.getName())){
                try{                    
                    biz=new RODBizDelegate();                    
                    
                    prop=new Properties();
                    prop=Utils.getProperties("P");
					
                    clt=new FTPClient(prop.getProperty("rod.xmlimport.ftpServer"));
                    clt.login(prop.getProperty("rod.xmlimport.ftpUserName"),prop.getProperty("rod.xmlimport.ftpPwd"));                
                    for(int idx=0;idx<files.length;idx++){                    
                         if(files[idx].toLowerCase().indexOf(".xml")!=-1){
                         	 currentFile=files[idx];

                             byte[] bf = clt.get(prop.getProperty("rod.xmlimport.dir")+"/"+files[idx]);

                             Collection colRec=processFile( bf, clt, prop, files[idx]);
                             
                             if(colRec!=null){
                                 if(!biz.loadInvoices(colRec,files[idx])){
                                    Constants.logger.debug(prop.getProperty("rod.xmlimport.dir")+"/"+files[idx]+" file was processed with errors.");                                 
                                 }else{
                                 	Constants.logger.debug(prop.getProperty("rod.xmlimport.dir")+"/"+files[idx]+" file was processed successfully.");
                                 }
                             }
                             
                             /***Moving the file to processed****/
                             clt.rename(prop.getProperty("rod.xmlimport.dir")+"/"+files[idx],prop.getProperty("rod.xmlimport.processedDir")+"/"+files[idx]);
                         }
                         try{
                            Thread.sleep(3001); //to avoid having 2 files in the same "second"
                         }catch(InterruptedException ie){}                          
                         
                    }
                    
               }catch(Exception e){
                     Constants.logger.debug(Utils.stackTraceToString(e));
                     notifyError(currentFile,Utils.stackTraceToString(e));
                     
                     try{
                        Thread.sleep(Constants.ImportXMLFilesTaskInterval);
                     }catch(InterruptedException ie){}                     
               } 
               
               files=new String[0];               
               
               try{ 
                   clt.chdir(prop.getProperty("rod.xmlimport.dir"));
                   files=clt.dir();
                   clt.quit();
                   clt=null;
                   biz=null;                
                   Thread.sleep(Constants.ImportXMLFilesTaskInterval);                    
               }catch(Exception e){
                   try{
                       Thread.sleep(Constants.ImportXMLFilesTaskInterval);
                   }catch(InterruptedException ie){}                   
               }   
            }
    }

    /**
     * This methods will process the file and will
     * produce a object tree representing the information
     * in the XML file
     * 
     *
     * @param    Input stream to the file being processed
     * @param    file name to be specified in the log
     */
    private Collection processFile(byte[] bf, FTPClient clt, Properties prop, String filename){
        Collection result=null;
        RodFileProcLogVO rlog=new RodFileProcLogVO();
        Date now=new Date();
        rlog.setFileNm(filename);        
        rlog.setProcessDt(now); 
        
     try{
        JAXBContext jc  = JAXBContext.newInstance( "com.fedex.lacitd.cashcontrol.interfaces.clearance"); //this is a workaround because of one bug in beta of jaxb.
        Unmarshaller um = jc.createUnmarshaller(); 
               
        um.setValidating(true);

        ReceivableList rl = unmarshallXMLFile(um, bf, clt, prop, filename);

        Collection colRec=rl.getReceivable();
        Collection colLoc=new ArrayList();
        Iterator iterRec=colRec.iterator();
        result=new ArrayList(); 
        double surChargesTotal=0.0;
        DecimalFormat fmt=new DecimalFormat("###########0.00##");
       
        while(iterRec.hasNext()){ 
            ReceivablesVO recVO=new ReceivablesVO();
            ReceivableType rec=(ReceivableType)iterRec.next();
            recVO.setRecId(new Integer(0));
            recVO.setAwbNbr(rec.getMtn());
            recVO.setRecNbr(rec.getRecNumber());
            rec.getRecDate().setTimeZone(TimeZone.getDefault());
            recVO.setRecDt(rec.getRecDate()==null?null:rec.getRecDate().getTime());            
            recVO.setLocationCd(rec.getLocation());            
            recVO.setCustomerNm(rec.getCustomer()==null?"Unknown":rec.getCustomer().length()>50?rec.getCustomer().substring(0,50):rec.getCustomer());
            recVO.setRecAmt(rec.getRecAmount()==null?0:rec.getRecAmount().doubleValue());
            recVO.setAncChargeAmt(rec.getAnchargeAmount()==null?0:rec.getAnchargeAmount().doubleValue());
            recVO.setRodAmt(rec.getRodAmount()==null?0:rec.getRodAmount().doubleValue());
            recVO.setExchRateClnUsed(rec.getExchRate()==null?0:rec.getExchRate().doubleValue());

            //Validate Currency for the country
              String curResult = Utils.validateCountryCurencyInProcess(recVO.getLocationCd(),rec.getRecCurrency());
              if(curResult==null){
                 recVO.setInvCurrency(rec.getRecCurrency());
              }else{recVO.setInvCurrency(curResult);}


            recVO.setRcptNbr(rec.getReceiptNo()==null?null:rec.getReceiptNo().length()>20?rec.getReceiptNo().substring(0,20):rec.getReceiptNo());
            recVO.setEmployeeId("000000");
            recVO.setStatusId(0);
            recVO.setRodXmlImpDt(now);
            recVO.setRecvPrepyAmt(rec.getRecPrepAmt()==null?0:rec.getRecPrepAmt().doubleValue());
            
            ReceivablesSurchargesVO rsVO=new ReceivablesSurchargesVO();
            rsVO.setReceivable(recVO);
            
            Collection colSurCharges=null;
            if(rec.getSurcharges()!=null) colSurCharges=rec.getSurcharges().getSurcharge();
            
            //validate surcharges
            if (colSurCharges!=null && !colSurCharges.isEmpty()){
            	Iterator surCharges=colSurCharges.iterator();
            
	            surChargesTotal=0.0;
	            Collection recSurcharges=new ArrayList();
	            while(surCharges.hasNext()){
	            	RecExpSrchgVO sVO=new RecExpSrchgVO();
	            	SurchargeType st=(SurchargeType)surCharges.next();
	            	surChargesTotal=surChargesTotal+st.getAmount().doubleValue();
	            	
	            	sVO.setSurchargeCd(st.getType());
	            	sVO.setAppliedAmt(st.getAmount().doubleValue());
	            	
	            	recSurcharges.add(sVO);
	            }
         
	            //if(surChargesTotal==recVO.getRecAmt()){
	            if(fmt.format(surChargesTotal).equals(fmt.format(recVO.getRecAmt()))){
	            	rsVO.setRecExpSurcharges(recSurcharges);
	            }else{
	            	
	            	rlog.setMessage("The surcharges total does not match the total of the invoice. AWB: "+recVO.getAwbNbr());
	            	rlog.setStatusCd(0);
	            	rlog.setLocationCd("");
	            	try{
	            		new RodFileProcLogController().setRodFileProcLog(rlog);   
	            	}catch(Exception e){
	            		Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(e));
	            	}
	            	
	            	return null; 	            	
	            }	
            }
            result.add(rsVO);
        }
        
   
     }catch( UnmarshalException je ) {
     	notifyError(filename,Utils.stackTraceToString(je));
        Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(je));
        rlog.setMessage("Error unmarshalling file. May be the file is not valid.");
        String errDtl=Utils.stackTraceToString(je);
        rlog.setErrorDtlDesc(errDtl.length()>3999?errDtl.substring(0,3999):errDtl);
        rlog.setStatusCd(0);
        rlog.setLocationCd("");
        try{
             new RodFileProcLogController().setRodFileProcLog(rlog);   
        }catch(Exception e){
             Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(e));
        }    
         return null;           
     }catch( JAXBException je ) { 
     	notifyError(filename,Utils.stackTraceToString(je));
        Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n" + Utils.stackTraceToString(je));
        rlog.setMessage("Unknown error parsing the file.");
        String errDtl=Utils.stackTraceToString(je);
        rlog.setErrorDtlDesc(errDtl.length()>3999?errDtl.substring(0,3999):errDtl);
        rlog.setStatusCd(0);
        rlog.setLocationCd("");         
        try{
             new RodFileProcLogController().setRodFileProcLog(rlog);   
        }catch(Exception e){
             Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(e));
        }    
        
        return null;    
     }catch(Exception je){
     	notifyError(filename,Utils.stackTraceToString(je));
        Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(je));
        rlog.setMessage("Unknown error parsing the file.");
        String errDtl=Utils.stackTraceToString(je);
        rlog.setErrorDtlDesc(errDtl.length()>3999?errDtl.substring(0,3999):errDtl);
        rlog.setStatusCd(0);
        rlog.setLocationCd("");         
        try{
             new RodFileProcLogController().setRodFileProcLog(rlog);   
        }catch(Exception e){
             Constants.logger.debug("Exception ocurred in run() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(e));
        }   
         return null;   
     }    
     
     return result;          
   }

    private ReceivableList unmarshallXMLFile(Unmarshaller um, byte [] bf, FTPClient clt, Properties prop, String filename) throws JAXBException, Exception
    {
        InputStream is = new ByteArrayInputStream( bf);

        try
        {
            for(int i=0; i<2; i++)
            {
                try
                {
                    //unmarshalling the XML file into object tree
                    ReceivableList rl = (ReceivableList) um.unmarshal( is);
                    return rl;
                }
                catch(Exception e)
                {
                    // we only try one time
                    if(i==0)
                    {
                        RodFileProcLogVO rlog=new RodFileProcLogVO();
                        rlog.setMessage("Failed to unmarshal data file, try to clean up the file and reprocess.");
                        String errDtl=e.getMessage();
                        rlog.setFileNm(filename);
                        rlog.setProcessDt(new Date());

                        if(errDtl != null)
                            rlog.setErrorDtlDesc(errDtl.length()>3999?errDtl.substring(0,3999):errDtl);

                        rlog.setStatusCd( 2);
                        rlog.setLocationCd("");

                        try
                        {
                             new RodFileProcLogController().setRodFileProcLog(rlog);
                        }
                        catch(Exception RFPe)
                        {
                             Constants.logger.debug("RodFileProcLogController().setRodFileProcLog: " + Utils.stackTraceToString( RFPe));
                        }

                        byte [] bcis = cleanInputStream( bf);

                        sendFileToProcessedFolder( bcis, clt, prop, filename);

                        is = new ByteArrayInputStream( bcis); 
                    }
                    else
                        throw e;
                }
            }
        }
        catch (IOException IOe)
        {
            throw new JAXBException( IOe.getMessage());
        }
        catch (FTPException FTPe)
        {
            throw new JAXBException( FTPe.getMessage());
        }

        return null;
    }

    private static void sendFileToProcessedFolder(byte [] ba, FTPClient clt, Properties prop, String filename) throws IOException, FTPException
    {
        if(filename.indexOf(".")>0)
            filename = filename.substring(0, filename.indexOf( "."));

        filename += "_cdu.xml";

        clt.put( ba, prop.getProperty("rod.xmlimport.processedDir") + "/" + filename);
    }

    public static byte [] cleanInputStream(byte[] ba) throws IOException
    {
        StringBuffer out = new StringBuffer(); // Used to hold the output.
        StringBuffer in = new StringBuffer( (new String( ba)).replaceAll("[^\\p{ASCII}]","?"));

        for (int i = 0; i < in.length(); i++)
        {
           char current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.

           if ((current == 0x9) ||
               (current == 0xA) ||
               (current == 0xD) ||
               ((current >= 0x20) && (current <= 0xD7FF)) ||
               ((current >= 0xE000) && (current <= 0xFFFD)) ||
               ((current >= 0x10000) && (current <= 0x10FFFF)))
           {
               out.append(current);
           }
           else
           {
               out.append("?");
           }
        }

        return out.toString().getBytes();
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
    
    private void notifyError(String fileNm,String errorMessage){
    	try{
    		AdminBizDelegate adminBiz=new AdminBizDelegate();
    		String country=Utils.getCountryFileName(fileNm);
    		Iterator admins=adminBiz.getAdminEmployees(country).iterator();
    		String to="";
    		while(admins.hasNext()){
    			EmployeeVO evo=(EmployeeVO)admins.next();
                if(evo.getEmail()!=null){
    			    to=to+evo.getEmail()+",";
                }
    		}
    		
    		EmailSender1 es=new EmailSender1();
    		HashMap hm=new HashMap(); 
    		hm.put("TO:",to);
    		hm.put("Subject:","IMPORT XML FILE ERROR");
    		hm.put("Body:","File Name: "+fileNm+"\nError Details: "+errorMessage);
    		
    		es.setEmails(hm);
            es.send();
    	}catch(Exception e){
    		Constants.logger.debug("Exception ocurred in notifyError() method from ImportFromXMLRunnable: \n"+Utils.stackTraceToString(e));
    	}
    }
    
    
    public void run1()  {
        Iterator iterFiles=null;
        Properties prop=null;
        FTPClient clt=null;
        RODBizDelegate biz=null;
        
        String currentFile=null;
        
        
            try{                    
                biz=new RODBizDelegate();                    
                
                prop=new Properties();
                prop=Utils.getProperties("P");
				
                clt=new FTPClient(prop.getProperty("rod.xmlimport.ftpServer"));
                clt.login(prop.getProperty("rod.xmlimport.ftpUserName"),prop.getProperty("rod.xmlimport.ftpPwd"));

                files=clt.dir();

                for(int idx=0;idx<files.length;idx++){
                     if(files[idx].toLowerCase().indexOf(".xml")!=-1){
                     	 currentFile=files[idx];

                         byte [] bf = clt.get(prop.getProperty("rod.xmlimport.dir")+"/"+files[idx]);

                         Collection colRec=processFile(bf, clt, prop, files[idx]);
                         
                         if(colRec!=null){
                             if(!biz.loadInvoices(colRec,files[idx])){
                                Constants.logger.debug(prop.getProperty("rod.xmlimport.dir")+"/"+files[idx]+" file was processed with errors.");                                 
                             }else{
                             	Constants.logger.debug(prop.getProperty("rod.xmlimport.dir")+"/"+files[idx]+" file was processed successfully.");
                             }
                         }
                         
                         /***moving the file to processed****/
                         clt.rename(prop.getProperty("rod.xmlimport.dir")+"/"+files[idx],prop.getProperty("rod.xmlimport.processedDir")+"/"+files[idx]);
                     }
                }
                
           }catch(Exception e){
                 Constants.logger.debug(Utils.stackTraceToString(e));
                 notifyError(currentFile,Utils.stackTraceToString(e));
                 
           } 
           
           files=new String[0];               
           
           try{ 
               clt.chdir(prop.getProperty("rod.xmlimport.dir"));
               files=clt.dir();
               clt.quit();
               clt=null;
               biz=null;                
               Thread.sleep(Constants.ImportXMLFilesTaskInterval);                    
           }catch(Exception e){
                
           }   
        
}    
    
}
