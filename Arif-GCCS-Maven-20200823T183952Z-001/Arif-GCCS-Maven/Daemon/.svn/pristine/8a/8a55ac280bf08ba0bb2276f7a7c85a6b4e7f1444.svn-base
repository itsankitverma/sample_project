/**
 * ExtPaymentProcessRunnable.java
 *
 * 
 */ 
package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.common.gccsftp.FTPClient;

//import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPException;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CommonOpsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.PrepPoaBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceConstants;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.PoaPaymentLocal;
import com.fedex.lacitd.cashcontrol.datatier.entities.PoaPaymentLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.interfaces.importPayments.*;

import javax.ejb.CreateException;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * This class is in charge of importing the External payments
 * @author  Arturo Gonzalez
 */
public class ExtPaymentProcessRunnable implements java.io.Serializable,java.lang.Runnable {
    
    private ServletContext servletCtx =null;
    private Properties props          =null;
    private Date   XMLdate            =null;
    private java.lang.Thread thread;
    
   /** Creates a new instance of ExtPaymentProcessRunnable **/
   public ExtPaymentProcessRunnable() {
   }
    
    
   public void run() {
        //Gets properties
            props=new Properties();
        //Gets files from ftp site
            FTPClient clt       = null;
            String dir="";
            String file="";

            while(!"STOP_THREAD".equals(thread.getName())){
                getProperties();
                try{
                    clt = new FTPClient(props.getProperty("imPay.ftpServer"));
                    clt.login(props.getProperty("imPay.ftpUserName"),props.getProperty("imPay.ftpPwd"));

                    String pwd = clt.pwd().substring( 1);
                    
                    dir = props.getProperty("imPay.dir");

                    clt.chdir(dir);
                    String filesExt[] = clt.dir();

                    if(filesExt.length>0){
                        //Iterate over files to get data
                        for(int idx=0;idx<filesExt.length;idx++){
                            if(filesExt[idx].toLowerCase().indexOf(".xml")!=-1){   //Process xml Files
                               file = filesExt[idx];
                               
                               //Check if file is already processed
                               ByteArrayInputStream xmlStream=new ByteArrayInputStream(clt.get(file));
                               processFile(xmlStream, file);
                               //Constants.logger.debug("\n\n PROCESADO!!!");
                               //clt.chdir("~");//come back to the root
                               clt.chdir( pwd);//come back to the root

                               //Now move the file processed to the processed directory
                               clt.rename(props.getProperty("imPay.dir")+file,props.getProperty("imPay.dir.backup")+file);
                               clt.chdir(dir);
                               Constants.logger.debug("\n ExtPaymentProcess : File " + file + " processed.");
                            }
                        }//close for
                    }else{
                            //Constants.logger.debug("\n nro. files : " + filesExt.length + " " + filesExt);
                            Constants.logger.debug("\n ExtPaymentProcess : There are no files to process.");
                            //goSleep();
                         }
                    filesExt=null;
                    clt.quit();

                    goSleep();
                }catch(FTPException eftp){
                       Constants.logger.debug("\n ExtPaymentProcess : There are no more files to process. "+eftp.getMessage());

                       //Constants.logger.debug("\n Error FTP: run() " + eftp.getMessage()+" | "+dir+" | "+file);
                    goSleep();
                }catch(IOException e) {
                    Constants.logger.debug("\n Error IO: run() " + e.getMessage()+" | "+dir+" | "+file);
                    //Constants.logger.debug(Utils.stackTraceToString(e));
                    goSleep();
                }catch(Exception e){
                    //Constants.logger.debug(Utils.stackTraceToString(e));
                    goSleep();
                }
            }//Close while                
    }//Close method run
    
     private void goSleep()
     {   try{
            Thread.sleep(Constants.Process_External_File_Task);
         }catch(InterruptedException ie){}
     }
     
            
    /**
     * This method gets properties information to use into the class
     */
    private void getProperties() {
          try {
          	  props = Utils.getProperties("P");
          }catch (Exception e) {
                Constants.logger.debug("\n Error Exception in getProperties('P') : " + e.getMessage());
                Constants.logger.debug(Utils.stackTraceToString(e));
          }
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
    
   /**
    * This method process xml file as input stream and update database
    * @param InputStream is
    * @param String filename
    * @return Colletion result
    * @exception UnmarshalException, JAXBException, Exception
    */ 
   private Collection processFile(InputStream is, String filename){
     Collection result     = null;
     Exception excepFile   = null;	   
     String locationCd     = null;
     HashMap errorsDetails = new HashMap();
     JAXBContext jc        = null; 
     try{
          jc  = JAXBContext.newInstance("com.fedex.lacitd.cashcontrol.interfaces.importPayments"); //this is a workaround because of one bug in beta of jaxb.
          Unmarshaller um = jc.createUnmarshaller(); 
          um.setValidating(true);
          
       
          PaymentsReceived pr = (PaymentsReceived)um. unmarshal(is);

          locationCd = pr.getLocation();
          XMLdate    = pr.getDate().getTime();
          
          //Get list with the different payments data
          ArrayList rodPayments		 = new ArrayList();
		  ArrayList prepaidPayments  = new ArrayList();
		  ArrayList poaPayments		 = new ArrayList();
		  ArrayList otherPayments	 = new ArrayList();
          ArrayList oacPayments 	 = new ArrayList();
          ArrayList groundPayments	 = new ArrayList();

          if(pr.getRodPayments()!=null)
		  	 rodPayments =	pr.getRodPayments().getRodPayment()!=null?new ArrayList(pr.getRodPayments().getRodPayment()):new ArrayList();
		  if(pr.getPrepaidPayments()!=null)
          	 prepaidPayments = pr.getPrepaidPayments().getPrepaidPayment()!=null?new ArrayList(pr.getPrepaidPayments().getPrepaidPayment()):new ArrayList();
		  if(pr.getPoaPayments()!=null)
          	 poaPayments     = pr.getPoaPayments().getPoaPayment()!=null?new ArrayList(pr.getPoaPayments().getPoaPayment()):new ArrayList();
		  if(pr.getOtherPayments()!=null)
          	 otherPayments   = pr.getOtherPayments().getOtherPayment()!=null?new ArrayList(pr.getOtherPayments().getOtherPayment()):new ArrayList();
          if(pr.getOacPayments()!=null)
          	 oacPayments     = pr.getOacPayments().getOacPayment()!=null?new ArrayList(pr.getOacPayments().getOacPayment()):new ArrayList();
          if(pr.getGroundPayments()!=null)
          	 groundPayments   = pr.getGroundPayments().getGroundPayment()!=null?new ArrayList(pr.getGroundPayments().getGroundPayment()):new ArrayList();

          
          //Now we're going to call methods to update database with payments
          if(rodPayments.size()>0)
          {   //Constants.logger.debug("\n\n UPDATE ROD!!!");
              errorsDetails.put("ROD", updateRODPayments(rodPayments));
          }
          if(prepaidPayments.size()>0)
          {   //Constants.logger.debug("\n\n UPDATE PREPAID!!!");
              errorsDetails.put("PREPAID", updatePrepaidPayments(prepaidPayments, locationCd));
          }
          if(poaPayments.size()>0)
          {   //Constants.logger.debug("\n\n UPDATE POA!!!");
              errorsDetails.put("POA", updatePoaPayments(poaPayments, locationCd));
          }
          if(otherPayments.size()>0)
          {   //Constants.logger.debug("\n\n UPDATE OTHER!!!");
              errorsDetails.put("OTHER", updateOtherPayments(otherPayments, locationCd));
          }
          if(oacPayments.size()>0)
          {   //Constants.logger.debug("\n\n UPDATE OAC!!!");
              errorsDetails.put("OAC", updateOacPayments(oacPayments, locationCd));
          }
          if(groundPayments.size()>0)
          {   //Constants.logger.debug("\n\n UPDATE GROUND!!!");
              errorsDetails.put("GROUND", updateGroundPayments(groundPayments, locationCd));
          }
     }catch(UnmarshalException ue ) {
        Constants.logger.debug("\n Exception ocurred in processFile() method from ExtPaymentProcessRunnable: \n"+Utils.stackTraceToString(ue));
        errorsDetails.put("GENERAL", "Error unmarshalling file. May be the file is not valid.");
        excepFile=ue;
     }catch(JAXBException je ) { 
        Constants.logger.debug("\n Exception ocurred in processFile() method from ExtPaymentProcessRunnable: \n" + Utils.stackTraceToString(je));
        errorsDetails.put("GENERAL","JAXBException, error parsing the file.");
        excepFile=je;
     }catch(Exception e ) { 
        Constants.logger.debug("\n Exception ocurred in processFile() method from ExtPaymentProcessRunnable: \n" + Utils.stackTraceToString(e));
        errorsDetails.put("GENERAL","Unknown error parsing the file.");
        excepFile=e;
     }
     
     try{
         //Go to the method that save error of processing only.
           saveErrorLogs(errorsDetails, filename, locationCd, XMLdate, excepFile);
        //If General Exception ocurr then send an email to the administrators.
          if(!errorsDetails.isEmpty() && (
            !(errorsDetails.get("GENERAL")==null) ||
            !(errorsDetails.get("ROD")==null) ||
            !(errorsDetails.get("POA")==null) ||
            !(errorsDetails.get("OTHER")==null) ||
            !(errorsDetails.get("OAC")==null) ||
            !(errorsDetails.get("GROUND")==null)
          ))
          {
              String country = Utils.getCountryFileName(filename);
           	  EmailSender1 sender = new EmailSender1();
           	  sender.setEmails(sender.selectEmail(Constants.PROCESSFILE,filename,null,country));
           	  sender.setPersonalName(Constants.FROMADDRESS);
           	  sender.send();
          }
     }catch(Exception e)
      {Constants.logger.debug("\n Exception ocurred in processFile() method from ExtPaymentProcessRunnable: \n" + Utils.stackTraceToString(e));}
       
     return result;          
   }// Close Process method
   
   
   /**
    * This method save errors during processing of importing external files, this errors are registered into
    * database with details.
    * @param HashMap errorsDetails
    * @param String filename
    * @param String locationCd
    * @param Date xmlDate
    * @exception Exception
    */
   private void saveErrorLogs(HashMap errorsDetails, String filename, String locationCd, Date xmlDate, Exception excepFile) throws Exception
   {
       Collection errors               = new ArrayList();
       PymtImptLogVO plVO              = new PymtImptLogVO();
       PymtImptErrorDtlVO    pdtlVO    = null;
       ByteArrayOutputStream out       = null;
       
       CommonOpsBizDelegate biz = new CommonOpsBizDelegate();
       
       SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
       Date dateString = null;
       try{
           //CHECK I THERE IS ERRORS TO SAVE
             //Common data of logging
               plVO.setImptFileNm(filename);
               plVO.setLocationCd(locationCd);
               plVO.setImptDt(new Date());
    
               String genericError = (String)errorsDetails.get("GENERAL");
               
               if(genericError!=null)
               {  //Save state of the file
                    plVO.setStatusCd(2);
                    plVO.setMessage(genericError);
                    
                    if(excepFile!=null)
                    {  String htmlError="";
                       pdtlVO = new PymtImptErrorDtlVO();
                       
                       htmlError=htmlError.concat("StackTrace : <br><br>");
                       htmlError=htmlError.concat(Utils.stackTraceToString(excepFile));
                       if(htmlError.length()>3990)                      
                          htmlError=htmlError.substring(0,3990);
                       pdtlVO.setImptError(htmlError);
                       errors.add(pdtlVO);
                    }   

               }else{

                   int sizeRODErrors     = ((ArrayList)errorsDetails.get("ROD"))!=null?((ArrayList)errorsDetails.get("ROD")).size():0;
                   int sizePREPAIDErrors = ((ArrayList)errorsDetails.get("PREPAID"))!=null?((ArrayList)errorsDetails.get("PREPAID")).size():0;
                   int sizePOAErrors     = ((ArrayList)errorsDetails.get("POA"))!=null?((ArrayList)errorsDetails.get("POA")).size():0;
                   int sizeOTHERErrors   = ((ArrayList)errorsDetails.get("OTHER"))!=null?((ArrayList)errorsDetails.get("OTHER")).size():0;
                   int sizeGROUNDErrors  = ((ArrayList)errorsDetails.get("GROUND"))!=null?((ArrayList)errorsDetails.get("GROUND")).size():0;
                   int sizeOACErrors     = ((ArrayList)errorsDetails.get("OAC"))!=null?((ArrayList)errorsDetails.get("OAC")).size():0;

                   int sizeTotal = sizeRODErrors + sizePREPAIDErrors + sizePOAErrors + sizeOTHERErrors + sizeGROUNDErrors + sizeOACErrors;

                   //Constants.logger.debug("\n\n Nro. Total detalles de error: " + sizeTotal);

                   if(sizeTotal>0){
                      String htmlError="";

                       //Save rod payments errors
                       if(sizeRODErrors>0){
                          pdtlVO = new PymtImptErrorDtlVO(); 
                          RodPayment pay=null;
                          Iterator it=((ArrayList)errorsDetails.get("ROD")).iterator();
                          htmlError= htmlError.concat("<table border=1><tr><td width='100%' align='left'>ROD</td></tr>");
                          while(it.hasNext())
                          { ImportLogVO imptLog = (ImportLogVO)it.next();
                            pay=(RodPayment)(imptLog.getPay());
                            
                            htmlError=htmlError.concat("<tr bgcolor=\"#FF9900\"><td>"+
                                                        " Element : </td>" +
                                                        "<td>" + pay.getNum()+"</td></tr><br>");
                            htmlError=htmlError.concat("<tr><td colspan='2'>Error: "+imptLog.getMessage()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>AWB</td><td>"+pay.getAwb()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Check-In Agent</td><td>"+pay.getChkAgentId()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Courier Id</td><td>"+pay.getCourierId()+"</td></tr>");
                            String custNm = pay.getCustName()!=null?pay.getCustName():"&nbsp;";
                            htmlError=htmlError.concat("<tr><td>Customer</td><td>"+custNm+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Exchange Rate</td><td>"+pay.getExchRate()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Cash</td><td>"+pay.getPymtCashAmt()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Currency</td><td>"+pay.getPymtCurrCd()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Date</td><td>"+formatter.format(pay.getPymtDate().getTime())+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Amount</td><td>"+pay.getPymtDocAmt()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Number</td><td>"+pay.getPymtDocNbr()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Type</td><td>"+pay.getPymtDocType()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Ancillary Charge</td><td>"+pay.getRecAncChrgAmt()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Rec Currency</td><td>"+pay.getRecCurrCd()+"</td></tr>"); 
                            dateString = formatter.parse(formatter.format(pay.getRecDate().getTime()));
                            htmlError=htmlError.concat("<tr><td>Rec Date</td><td>"+formatter.format(pay.getRecDate().getTime())+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Rec Number</td><td>"+pay.getRecNbr()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Rec ROD Amount</td><td>"+pay.getRecRodAmt()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Rec Tot Amount</td><td>"+pay.getRecTotAmt()+"</td></tr>");
                            if(htmlError.length()>4000){//trunc to fit the db column
                            	htmlError=htmlError.substring(0,3990);
                            	break;
                            }
                          }
                          htmlError= htmlError.concat("</table>");
                          pdtlVO.setImptError(htmlError);
                          errors.add(pdtlVO);
                       }

                       //Save prepaid payments errors 
                       if(sizePREPAIDErrors>0){
                          pdtlVO = new PymtImptErrorDtlVO(); 
                          PrepaidPayment pay=null;
                          Iterator it=((ArrayList)errorsDetails.get("PREPAID")).iterator();
                          htmlError="";
                          htmlError= htmlError.concat("<table border=1><tr bgcolor=\"FFFFFF\"><td width='100%' align='left'>PREPAID</td></tr>");
                          while(it.hasNext())
                          { ImportLogVO imptLog = (ImportLogVO)it.next();
                            pay=(PrepaidPayment)imptLog.getPay();
                         
                            htmlError=htmlError.concat("<tr bgcolor=\"#FF9900\"><td>"+
                                                        " Element : </td>" +
                                                        "<td>" + pay.getNum()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td colspan='2'>Error: "+imptLog.getMessage()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>AWB</td><td>"+pay.getAwb()+"</td></tr>");
                            dateString = formatter.parse(formatter.format(pay.getAwbDt().getTime()));
                            htmlError=htmlError.concat("<tr><td>AWB Date</td><td>"+formatter.format(pay.getAwbDt().getTime())+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Check-In Agent</td><td>"+pay.getChkAgentId()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Courier Id</td><td>"+pay.getCourierId()+"</td></tr>");
                            String custNm = pay.getCustName()!=null?pay.getCustName():"&nbsp;";
                            htmlError=htmlError.concat("<tr><td>Customer</td><td>"+custNm+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Exchange Rate</td><td>"+pay.getExchRate()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Cash</td><td>"+pay.getPymtCashAmt()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Currency</td><td>"+pay.getPymtCurrCd()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Amount</td><td>"+pay.getPymtDocAmt()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Number</td><td>"+pay.getPymtDocNbr()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Type</td><td>"+pay.getPymtDocType()+"</td></tr>");
                            dateString = formatter.parse(formatter.format(pay.getPymtDt().getTime()));
                            htmlError=htmlError.concat("<tr><td>Payment Date</td><td>"+formatter.format(pay.getPymtDt().getTime())+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Total Amount</td><td>"+pay.getPymtTotAmt()+"</td></tr>");
                            if(htmlError.length()>4000){//trunc to fit the db column
                            	htmlError=htmlError.substring(0,3990);
                            	break;
                            }                            
                          }
                          htmlError= htmlError.concat("</table>");
                          pdtlVO.setImptError(htmlError);
                          errors.add(pdtlVO);
                       }

                       //Save poa payments errors
                       if(sizePOAErrors>0){
                          pdtlVO = new PymtImptErrorDtlVO();  
                          PoaPayment pay=null; 
                          Iterator it=((ArrayList)errorsDetails.get("POA")).iterator();
                          htmlError="";
                          htmlError= htmlError.concat("<table border=1><tr bgcolor='#FFFFFF'><td width='100%' align='left'>POA PAYMENT</td></tr>");
                          while(it.hasNext())
                          { ImportLogVO imptLog = (ImportLogVO)it.next();
                            pay=(PoaPayment)imptLog.getPay();
                            
                            htmlError=htmlError.concat("<tr bgcolor=\"#FF9900\"><td>"+
                                                        " Element : </td>" +
                                                        "<td>" + pay.getNum()+"</td></tr><br>");
                            htmlError=htmlError.concat("<tr><td colspan='2'>Error: "+imptLog.getMessage()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Check-In Agent</td><td>"+pay.getChkAgentId()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Courier Id</td><td>"+pay.getCourierId()+"</td></tr>"); 
                            String custNm = pay.getCustName()!=null?pay.getCustName():"&nbsp;";
                            htmlError=htmlError.concat("<tr><td>Customer</td><td>"+custNm+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Exchange Rate</td><td>"+pay.getExchRate()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Fedex Account Number</td><td>"+pay.getFedexAccNbr()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Payment Currency</td><td>"+pay.getPymtCurrCd()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Payment Doc Number</td><td>"+pay.getPymtDocNbr()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Payment Total Amount</td><td>"+pay.getPymtTotAmt()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Payment Type</td><td>"+pay.getPymtType()+"</td></tr>");
                            if(htmlError.length()>4000){//trunc to fit the db column
                            	htmlError=htmlError.substring(0,3990);
                            	break;
                            }                            

                          }
                          htmlError= htmlError.concat("</table>");
                          pdtlVO.setImptError(htmlError);
                          errors.add(pdtlVO);
                       }

                       //Save other payments errors
                       if(sizeOTHERErrors>0){
                          pdtlVO = new PymtImptErrorDtlVO();  
                          OtherPayment pay=null;
                          Iterator it=((ArrayList)errorsDetails.get("OTHER")).iterator(); 
                          htmlError="";
                          htmlError= htmlError.concat("<table border=1><tr bgcolor='#FFFFFF'><td width='100%' align='left'>OTHER PAYMENT</td></tr>");
                          while(it.hasNext())
                          { ImportLogVO imptLog = (ImportLogVO)it.next();
                            pay=(OtherPayment)imptLog.getPay();
                            
                            htmlError=htmlError.concat("<tr bgcolor=\"#FF9900\"><td>"+
                                                        " Element : </td>" +
                                                        "<td>" + pay.getNum()+"</td></tr><br>");
                            htmlError=htmlError.concat("<tr><td colspan='2'>Error: "+imptLog.getMessage()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Check-In Agent</td><td>"+pay.getChkAgentId()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Description</td><td>"+pay.getDescription()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Payment Currency</td><td>"+pay.getPymtCurrCd()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Payment Doc Number</td><td>"+pay.getPymtDocNbr()+"</td></tr>"); 
                            dateString = formatter.parse(formatter.format(pay.getPymtDt().getTime()));
                            htmlError=htmlError.concat("<tr><td>Payment Date</td><td>"+formatter.format(pay.getPymtDt().getTime())+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Payment Total Amount</td><td>"+pay.getPymtTotAmt()+"</td></tr>"); 
                            htmlError=htmlError.concat("<tr><td>Payment Type</td><td>"+pay.getPymtType()+"</td></tr>");
                            if(htmlError.length()>4000){//trunc to fit the db column
                            	htmlError=htmlError.substring(0,3990);
                            	break;
                            }                            
                          }
                          htmlError= htmlError.concat("</table>");
                          pdtlVO.setImptError(htmlError);
                          errors.add(pdtlVO);
                       }

                       //Save ground payments errors
                       if(sizeGROUNDErrors>0){
                          pdtlVO = new PymtImptErrorDtlVO();
                          GroundPayment pay=null;
                          Iterator it=((ArrayList)errorsDetails.get("GROUND")).iterator();
                          htmlError="";
                          htmlError= htmlError.concat("<table border=1><tr bgcolor=\"FFFFFF\"><td width='100%' align='left'>GROUND</td></tr>");
                          while(it.hasNext())
                          { ImportLogVO imptLog = (ImportLogVO)it.next();
                            pay=(GroundPayment)imptLog.getPay();

                            htmlError=htmlError.concat("<tr bgcolor=\"#FF9900\"><td>"+
                                                        " Element : </td>" +
                                                        "<td>" + pay.getGrndTrakNbr()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td colspan='2'>Error: "+imptLog.getMessage()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>TRK</td><td>"+pay.getGrndTrakNbr()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>SHP Date</td><td>"+formatter.format(pay.getShipDt().getTime())+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Check-In Agent</td><td>"+pay.getChkAgentId()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Courier Id</td><td>"+pay.getCourierId()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Cash</td><td>"+pay.getPymtCashAmt()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Currency</td><td>"+pay.getPymtCurrCd()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Amount</td><td>"+pay.getPymtDocAmt()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Type</td><td>"+pay.getPymtDocType()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Date</td><td>"+formatter.format(pay.getPymtDt().getTime())+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Total Amount</td><td>"+pay.getPymtTotAmt()+"</td></tr>");
                            if(htmlError.length()>4000){//trunc to fit the db column
                            	htmlError=htmlError.substring(0,3990);
                            	break;
                            }
                          }
                          htmlError= htmlError.concat("</table>");
                          pdtlVO.setImptError(htmlError);
                          errors.add(pdtlVO);
                       }

                       //Save oac payments errors
                       if(sizeOACErrors>0){
                          pdtlVO = new PymtImptErrorDtlVO();
                          OacPayment pay=null;
                          Iterator it=((ArrayList)errorsDetails.get("OAC")).iterator();
                          htmlError="";
                          htmlError= htmlError.concat("<table border=1><tr bgcolor=\"FFFFFF\"><td width='100%' align='left'>OAC</td></tr>");
                          while(it.hasNext())
                          { ImportLogVO imptLog = (ImportLogVO)it.next();
                            pay=(OacPayment)imptLog.getPay();

                            htmlError=htmlError.concat("<tr bgcolor=\"#FF9900\"><td>"+
                                                        " Element : </td>" +
                                                        "<td>" + formatter.format(pay.getOacDt().getTime())+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td colspan='2'>Error: "+imptLog.getMessage()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>AWB</td><td>  </td></tr>");
                            htmlError=htmlError.concat("<tr><td>OAC Date</td><td>"+formatter.format(pay.getOacDt().getTime())+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Courier Id</td><td>"+pay.getCourierId()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Currency</td><td>"+pay.getPymtCurrCd()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Amount</td><td>"+pay.getPymtDocAmt()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Doc Type</td><td>"+pay.getPymtDocType()+"</td></tr>");
                            htmlError=htmlError.concat("<tr><td>Payment Date</td><td>"+formatter.format(pay.getPymtDt().getTime())+"</td></tr>");
                            if(htmlError.length()>4000){//trunc to fit the db column
                            	htmlError=htmlError.substring(0,3990);
                            	break;
                            }
                          }
                          htmlError= htmlError.concat("</table>");
                          pdtlVO.setImptError(htmlError);
                          errors.add(pdtlVO);
                       }


                    //Save state of the file
                      plVO.setStatusCd(2);
                      plVO.setMessage("File Imported with errors.");

                   }else{//If no error exists the save a message of well processed
                        plVO.setStatusCd(1);
                        plVO.setMessage("No errors.");
                   }//Close if sizeTotal
               }//Close if GENERIC
           //Save log
             biz.saveErrorsPymtImpt(plVO, errors);
       }catch(Exception e)
        { Constants.logger.debug("\n Exception ocurred in saveErrorsLogs method from ExtPaymentProcessRunnable: \n" + Utils.stackTraceToString(e));
          throw e;}
   }
   
   /**
    * This method update the database with the information of rod payments
    * @param ArrayList  rodPayments
    * @exception Exception
    */
   private Collection updateRODPayments(ArrayList payments){
      ReceivablesController rc  = new ReceivablesController();
      ReceivablesVO receivable  = new ReceivablesVO();
      Collection errors         = new ArrayList();
            
      RodPayment pay = null;
      int sizeList = payments.size();
         //Now arm recievables object and update it into the database
           for(int i=0;i<sizeList;i++)
           { pay        = (RodPayment)payments.get(i);
             try{
                ArrayList recs = (ArrayList)rc.getReceivablesReceivablesByAwbNbr(pay.getAwb());
                Iterator it = recs.iterator();
                //Constants.logger.debug("\n\n Nro. recs for awb: " + pay.getAwb() + " = " + recs.size());
                while(it.hasNext())
                { receivable = (ReceivablesVO)it.next();
                  pay.getRecDate().setTimeZone(TimeZone.getDefault());
                  //Constants.logger.debug("\n\n receivables rec dt: " + receivable.getRecDt() + " pay rec dt : " + pay.getRecDate().getTime());
                  if(pay.getRecNbr()!=null || pay.getRecNbr().length() == 0)
                  {  if((receivable.getRecNbr().equals(pay.getRecNbr())) &&
                        (receivable.getRecDt().equals(pay.getRecDate().getTime())))
                     {   //Constants.logger.debug("\n\n break **** ");
                         break;         }
                  }else{receivable=null;
                        ImportLogVO imptLog = new ImportLogVO();
                        imptLog.setPay(pay);
                        imptLog.setMessage("Record Not Found in DataBase.");
                        errors.add(imptLog);
                        continue;}
                }
                
                //Check status not close <> 1 to update receivable
                if(receivable.getRecId()!=null && receivable.getStatusId()!=1)
                {
                   
                   receivable.setAwbNbr(pay.getAwb());
                   receivable.setRecNbr(pay.getRecNbr());
                   pay.getRecDate().setTimeZone(TimeZone.getDefault());
                   receivable.setRecDt(pay.getRecDate().getTime());
                   receivable.setCustomerNm(pay.getCustName());
                   receivable.setInvCurrency(pay.getRecCurrCd());
                   receivable.setExchRateClnUsed(pay.getExchRate().doubleValue());
                   receivable.setRecAmt(pay.getRecTotAmt().doubleValue());
                   receivable.setRodAmt(pay.getRecRodAmt().doubleValue());
                   receivable.setAncChargeAmt(pay.getRecAncChrgAmt().doubleValue());
                   receivable.setEmployeeId(String.valueOf(pay.getCourierId()));
                   receivable.setEodEmployeeId(String.valueOf(pay.getChkAgentId()));
                   receivable.setCloseDt(pay.getPymtDate().getTime());
                   receivable.setCashPaymentAmt(pay.getPymtCashAmt().doubleValue());
                   receivable.setOtherPaymentAmt(pay.getPymtDocAmt().doubleValue());
                   receivable.setOtherDocNbr(pay.getPymtDocNbr());
                   receivable.setOtherPaymentType(pay.getPymtDocType());
                   receivable.setPaymentCurrency(pay.getPymtCurrCd());
                   receivable.setPymtImpDt(Calendar.getInstance(TimeZone.getDefault()).getTime());
                   
                   if(receivable.getEodId()==0)
                   {  receivable.setEodId(-1);}/*** -1 to indicate automatic update ***/
                   
                   receivable.setStatusId(1); //status close
                   receivable.setChkinAgentComment("Automatic Payment");
                   //Now we'return going to update receivable
                     rc.updateReceivables(receivable);
                }else{
                      ImportLogVO imptLog = new ImportLogVO();
                      imptLog.setPay(pay);
                      if(receivable.getRecId()==null){
                         imptLog.setMessage("Record Not Found in DataBase.");
                      }else{
                            imptLog.setMessage("Record is Clear.");}
                      
                      errors.add(imptLog);
                      
                }   
             }catch(BusinessDelegateException bde)//If an exception occurs need register error into database
              {   ImportLogVO imptLog = new ImportLogVO();
                  imptLog.setPay(pay);
                  imptLog.setMessage("Error trying update record.");
                  errors.add(imptLog);
                  Constants.logger.debug("\n Error al procesar receivables : " + Utils.stackTraceToString(bde));
              }
           }//Close for
      return errors;
   }//Close method updateRODPayments*/
   
   /**
    * This method update the database with the information of prepaid payments
    * @param ArrayList  prepaidPayments
    * @exception Exception
    */
   private Collection updatePrepaidPayments(ArrayList payments, String locationCd){
        LocationController lc  = new LocationController();
        PrepaidController ppc  = new PrepaidController();
        LocationVO locationPay = new LocationVO();
        LocationVO locationPre = new LocationVO();
        PrepaidVO prepaid      = new PrepaidVO();
        PrepaidPayment pay     = null;
        Collection errors      = new ArrayList();
        
        int sizeList = payments.size();
           for(int i=0;i<sizeList;i++)
           { pay        = (PrepaidPayment)payments.get(i);
             try{
                ArrayList recs = (ArrayList)ppc.getPrepaidPrepaidByAwbNbr(pay.getAwb());
                //Constants.logger.debug("\n\n Nro. recs for awb: " + pay.getAwb() + " = " + recs.size());
                Iterator it = recs.iterator();
                while(it.hasNext())
                { prepaid = (PrepaidVO)it.next();
                  pay.getAwbDt().setTimeZone(TimeZone.getDefault());
                  //Constants.logger.debug("\n\n prepaid awb dt: " + prepaid.getAwbDt() + " pay awb dt : " + pay.getAwbDt().getTime());
                  if(prepaid.getAwbDt().equals(pay.getAwbDt().getTime()))
                  {  //Constants.logger.debug("\n\n break **** ");
                     break;}
                  else{
                       ImportLogVO imptLog = new ImportLogVO();
                       imptLog.setPay(pay);
                       imptLog.setMessage("Record Not Found in DataBase.");
                       errors.add(imptLog);
                       continue; }
                }
                
                if(prepaid.getPrepaidId() != null && prepaid.getStatusId()!=1 )
                {   //Check country
                      locationPay = lc.getLocation(prepaid.getLocationCd());//Location from database prepaid paid
                      locationPre = lc.getLocation(locationCd);//Location from xml
                
                      if(!locationPay.getCountryCd().equals(locationPre.getCountryCd())){
                          continue;
                      }
                    
                    prepaid.setAwbNbr(pay.getAwb());
                    pay.getAwbDt().setTimeZone(TimeZone.getDefault());
                    prepaid.setAwbDt(pay.getAwbDt().getTime());
                    prepaid.setCustomerNm(pay.getCustName());
                    prepaid.setCloseEmployeeId(String.valueOf(pay.getCourierId()));
                    prepaid.setChngStatusEmployeeId(String.valueOf(pay.getChkAgentId()));
                    prepaid.setCloseDt(pay.getPymtDt().getTime());
                    prepaid.setCashPaymentAmt(pay.getPymtCashAmt().doubleValue());
                    prepaid.setOtherPaymentAmt(pay.getPymtDocAmt().doubleValue());
                    prepaid.setOtherDocNbr(pay.getPymtDocNbr());
                    prepaid.setOtherPaymentType(pay.getPymtDocType());
                    prepaid.setPaymentCurrency(pay.getPymtCurrCd());
                    prepaid.setExchRate(pay.getExchRate().doubleValue());
                    prepaid.setPymtImpDt(Calendar.getInstance(TimeZone.getDefault()).getTime());
                    
                    if(prepaid.getEodId()==0)
                    {  prepaid.setEodId(-1);}/*** -1 to indicate automatic update ***/
                    
                    prepaid.setStatusId(1); //status close
                    prepaid.setChkinAgentComment("Automatic Payment");
                    //Now we'return going to update prepaid
                      ppc.updatePrepaid(prepaid);
                }else{
                      ImportLogVO imptLog = new ImportLogVO();
                      imptLog.setPay(pay);
                      if(prepaid.getPrepaidId() == null){
                         imptLog.setMessage("Record Not Found in DataBase.");
                      }else{
                            imptLog.setMessage("Record is Clear.");}
                      errors.add(imptLog);
                }   
             }catch(BusinessDelegateException bde)//If an exception occurs need register error into database
              {   ImportLogVO imptLog = new ImportLogVO();
                  imptLog.setPay(pay);
                  imptLog.setMessage("Error trying update record.");
                  errors.add(imptLog);
                  Constants.logger.debug("\n Error al procesar prepaid : " + Utils.stackTraceToString(bde));
              }
           }//Close for
      return errors;  
   }
  private  double doJust2DecimalsRound  (double param){
       double doubl= Math.round(param*100.00);
        doubl=doubl/100;
      return    doubl;
  }
  /**
   * This method update the database with the information of poa payments
   * @param ArrayList  poaPayments
   * @exception Exception
   */

    /*
     *
     * Release4.6-New Top issues
     *
     * Issue #251
     *
     *
     */

   private Collection updatePoaPayments(ArrayList payments, String locationCd) throws Exception {
        PoaPaymentVO poa         = new PoaPaymentVO();
        PoaPayment pay           = null;
        Collection errors        = new ArrayList();
        
        
        int sizeList = payments.size();
           for(int i=0;i<sizeList;i++)
           { pay    =   (PoaPayment)payments.get(i);
             try{
		
                poa.setPymtImpDt(Calendar.getInstance(TimeZone.getDefault()).getTime());
                
                if(poa.getEodId()==0)
                {  poa.setEodId(-1);}/*** -1 to indicate automatic update ***/
                
                //Now we're going to update prepaid
                /*
                 * ??? a bug ???
                 */
                //ppc.setPoaPayment(poa);

	                poa.setAccountNbr(pay.getFedexAccNbr());
	                poa.setCustomerNm(pay.getCustName());
	                poa.setPaymentDt(Calendar.getInstance(TimeZone.getDefault()).getTime());
	                poa.setLocationCd(locationCd);
	                poa.setPaymentCurrency(pay.getPymtCurrCd());
	                poa.setExchRate(pay.getExchRate().doubleValue());
	                poa.setPaymentAmt(doJust2DecimalsRound(pay.getPymtTotAmt().doubleValue()));
	                poa.setPaymentType(pay.getPymtType());
	                poa.setCoupPymtAmt(0);
	                poa.setOtherDocNbr(pay.getPymtDocNbr());
	                poa.setCourierId(String.valueOf(pay.getCourierId()));
	                poa.setCloseEmployeeId(String.valueOf(pay.getChkAgentId()));
	                poa.setCloseDt(null);
	                poa.setEodEmployeeId(null);
	                poa.setEodDt(null);
	                poa.setChkinAgentComment(null);
	                poa.setDepositSlipId(0);
	                poa.setDepositSlipNbr(null);
	                poa.setCreditCardBatchId(null);
	                poa.setReceivedEmpId(null);
	                poa.setEodId(0);
	                poa.setCouponBatchId(0);
//	                poa.setPymtImpDt(null);
	                poa.setOtherComment(null);
	                poa.setRcptNbr(null);
	                poa.setOrigRcptNbr(null);
	                poa.setRcptChngEmpId(null);
	                poa.setOrigEmployeeId(null);
	                poa.setReassEmpId(null);
                
                  List details = pay.getAppliedTo()!=null?pay.getAppliedTo().getPoaDetail(): new ArrayList();

                  Collection poaDetails    = new ArrayList();

                  for(int j=0;j<details.size();j++)
                  {
                    PoaDetailVO poaDetail=new PoaDetailVO();
                      
                  	poaDetail.setInvoiceNbr(((PoaDetail)details.get(j)).getInvNbr());
                  	poaDetail.setAmount(doJust2DecimalsRound(((PoaDetail)details.get(j)).getInvAmt().doubleValue()));          //   **
                  	poaDetail.setCouponAmt(doJust2DecimalsRound(((PoaDetail)details.get(j)).getInvCouponAmt().doubleValue()));   //**

					//Now we're goind to uopdate poadetail
					//ppdc.setPoaDetail(poaDetail);
                  	poaDetails.add( poaDetail);
                  }

                  new PrepPoaBizDelegate().savePoaPayment( poa, poaDetails);
                  
			 }
             catch(Exception e)
             {
				    ImportLogVO imptLog = new ImportLogVO();
                    imptLog.setPay(pay);
                    imptLog.setMessage( e.getMessage());
                    errors.add( imptLog);

                    /*
                     *
                     * Release4.6-New Top issues
                     *
                     * Issue #251
                     *
                     *
                     */
                    //throw e;
             }
           }//Close for

       return (errors.size() == 0) ? null:errors;
   }
   
  /**
   * This method update the database with the information of others payments
   * @param ArrayList  otherPayments
   * @exception Exception
   */
   private Collection updateOtherPayments(ArrayList payments, String locationCd){
        OtherPaymentController opc  = new OtherPaymentController();
        OtherPaymentVO other        = new OtherPaymentVO();
        OtherPayment pay = null;
        Collection errors         = new ArrayList();
        
        int sizeList = payments.size();
        for(int i=0;i<sizeList;i++)
        { pay=(OtherPayment)payments.get(i);
          try{
		other.setDescription(pay.getDescription());
		other.setChkinAgentId(String.valueOf(pay.getChkAgentId()));
                pay.getPymtDt().setTimeZone(TimeZone.getDefault());
		other.setPaymentDt(pay.getPymtDt().getTime());
		other.setPaymentAmt(pay.getPymtTotAmt().doubleValue());
		other.setPaymentDocNbr(pay.getPymtDocNbr());
		other.setPaymentType(pay.getPymtType());
                other.setPaymentCurrency(pay.getPymtCurrCd());
		other.setLocationCd(locationCd);
                other.setPymtImpDt(Calendar.getInstance(TimeZone.getDefault()).getTime());
                
                if(other.getEodId()==0)
                {  other.setEodId(-1);}/*** -1 to indicate automatic update ***/
                
                //Now we'return going to update prepaid
                  opc.setOtherPayment(other);
             }catch(BusinessDelegateException bde)//If an exception occurs need register error into database
              {   ImportLogVO imptLog = new ImportLogVO();
                  imptLog.setPay(pay);
                  imptLog.setMessage("Error trying insert record.");
                  errors.add(imptLog);
                  Constants.logger.debug("\n Error al procesar otherPayment : " + Utils.stackTraceToString(bde));} 
        }//close for
      return errors; 
   }

   /**
    * This method update the database with the information of oac payments
    * @param ArrayList  oacPayments
    * @exception Exception
    */
   private Collection updateOacPayments(ArrayList payments, String locationCd){
        LocationController lc  = new LocationController();
        OacController oc      = new OacController();
        LocationVO locationPay = new LocationVO();
        LocationVO locationPre = new LocationVO();
        OacVO oac          = new OacVO();
        OacPayment pay         = null;
        Collection errors      = new ArrayList();

        int sizeList = payments.size();
        for(int i=0;i<sizeList;i++)
           { pay        = (OacPayment)payments.get(i);
             try{
                    oac.setObAncSvcDt(pay.getOacDt().getTime());
                    oac.setCourEmpIdNbr(String.valueOf(pay.getCourierId()));
                    oac.setCloseEmpIdNbr(String.valueOf(pay.getCourierId()));
                    oac.setCloseDt(pay.getPymtDt().getTime());
                    oac.setOtherPymtAmt(pay.getPymtDocAmt().doubleValue());
                    oac.setOtherPymtTypeCd(pay.getPymtDocType());
                    oac.setPymtCurrCd(pay.getPymtCurrCd());
                    oac.setEodIdNbr(0);
                    oac.setStatusCd(1); //status clear
                    oac.setChkinAgentComDesc("Automatic Payment");
                    oac.setLocationCd(locationCd);
                 
                 //Now we're going to set ground
                   oc.setOac(oac);

             }catch(BusinessDelegateException bde)//If an exception occurs need register error into database
              {   ImportLogVO imptLog = new ImportLogVO();
                  imptLog.setPay(pay);
                  imptLog.setMessage("Error trying update record.");
                  errors.add(imptLog);
                  Constants.logger.debug("\n Error al procesar oac : " + Utils.stackTraceToString(bde));
              }
           }//Close for
      return errors;
   }//Close Update Oac Payments

   /**
    * This method update the database with the information of ground payments
    * @param ArrayList  groundPayments
    * @exception Exception
    */
   private Collection updateGroundPayments(ArrayList payments, String locationCd){
        LocationController lc  = new LocationController();
        GroundController grc   = new GroundController();
        LocationVO locationPay = new LocationVO();
        LocationVO locationPre = new LocationVO();
        GroundVO ground       = new GroundVO();
        GroundPayment pay      = null;
        Collection errors      = new ArrayList();

           int sizeList = payments.size();
           for(int i=0;i<sizeList;i++)
           { pay        = (GroundPayment)payments.get(i);
             try{
                    ground.setGrndTrakNbr(pay.getGrndTrakNbr());
                    ground.setGrndShpDt(pay.getShipDt().getTime());
                    ground.setCourEmpIdNbr(String.valueOf(pay.getCourierId()));
                    ground.setCloseEmpIdNbr(String.valueOf(pay.getCourierId()));
                    ground.setChngStatusEmpIdNbr(String.valueOf(pay.getChkAgentId()));
                    ground.setCloseDt(pay.getPymtDt().getTime());
                    ground.setCashPymtAmt(pay.getPymtCashAmt().doubleValue());
                    ground.setOtherPymtAmt(pay.getPymtDocAmt().doubleValue());
                    ground.setOtherPymtTypeCd(pay.getPymtDocType());
                    ground.setPaymentCurrency(pay.getPymtCurrCd());
                    ground.setEodIdNbr(0);
                    ground.setStatusCd(1); //status clear
                    ground.setChkinAgentComDesc("Automatic Payment");
                    ground.setLocationCd(locationCd);

                 //Now we're going to set ground
                   grc.setGround(ground);

             }catch(BusinessDelegateException bde)//If an exception occurs need register error into database
              {   ImportLogVO imptLog = new ImportLogVO();
                  imptLog.setPay(pay);
                  imptLog.setMessage("Error trying update record.");
                  errors.add(imptLog);
                  Constants.logger.debug("\n Error al procesar ground : " + Utils.stackTraceToString(bde));
              }
           }//Close for
      return errors;
   }//Close upadteGroundPayments


    public Thread getThread() {
        return this.thread;
    }

    public void setThread(Thread thread) {
        this.thread=thread;
    }
    
    /**
     * This method check if this file has been processed.
     * @param String file name
     * @return boolean true if exist, false in other case
     * @exception Exception
     */
  /*private boolean checkExistFile(String file)
    {   boolean exist = false;
        
        try{
            
            FTPClient clt = new FTPClient(props.getProperty("imPay.ftpServer"));
            clt.login(props.getProperty("imPay.ftpUserName"),props.getProperty("imPay.ftpPwd"));

            String dir = props.getProperty("imPay.dir.backup");
            clt.chdir(dir);
            String filesBackup[] = clt.dir();
            String fileBack      = null;
            
            for(int i=0; i<filesBackup.length; i++)
            {   fileBack=filesBackup[i];
                
                if(fileBack.equals(file))
                {  exist=true;
                   break;}
            }
            clt.quit();
        }catch(Exception e){
               Constants.logger.debug(Utils.stackTraceToString(e));
        }    
        return exist;
    }*/


  /**
   * This methods gets the PoaPayment local home interface
   */
   private PoaPaymentLocalHome getPoaPaymentLocalHome()throws Exception {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PoaPaymentLocalHome) service.getEJBLocalHome(ServiceConstants.POAPAYMENT_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPoaPaymentLocalHome() method when lookup the local home interface";
            throw new Exception(errorMsg, ex);
        }
    }
}//Close 