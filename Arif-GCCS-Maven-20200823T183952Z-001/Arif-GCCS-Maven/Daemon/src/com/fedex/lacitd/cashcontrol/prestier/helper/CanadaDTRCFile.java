package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.PrepPoaBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.RODBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.ReceivablesByAwbVO;

import com.fedex.lacitd.cashcontrol.common.Utils;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RodFileProcLogVO;
import com.fedex.lacitd.cashcontrol.datatier.controller.ReceivablesController;
import com.fedex.lacitd.cashcontrol.datatier.controller.RodFileProcLogController;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.ObjectFactory;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.Receivable;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableList;


import com.fedex.lacitd.common.gccsftp.FTPClient;



/**
 * @author  Arturo Gonzalez
 *
 */
public class CanadaDTRCFile implements Job {
    private static final String KEY_dpd_qty = "validateDuplicatedROD_qty";
    private static final String KEY_dpd_ignored = "validateDuplicatedROD_ignored";
    private static final String KEY_dpd_update = "validateDuplicatedROD_update";
    private static final String KEY_location = "validateDuplicatedROD_location";

    /** Creates a new instance of CanadaDTRCFile */
    public CanadaDTRCFile() {
    }

   public void execute(JobExecutionContext context) throws JobExecutionException {
            Iterator iterFiles=null;
            Properties prop=null;
            FTPClient inFTP=null;
            FTPClient outFTP=null;
            PrepPoaBizDelegate biz=null;
            HashMap canSurchargesMap=null;
            HashMap xmlResult=null;
            String dtrcFile="";

                try{
                    prop= Utils.getProperties("P");
                    String xmlFile;

                    //Code to get the flat DTRC from Canada file
                    inFTP=new FTPClient(prop.getProperty("dtrc.ftpServer"));
                    inFTP.login(prop.getProperty("dtrc.ftpUserName"),prop.getProperty("dtrc.ftpPwd"));
                    inFTP.setType(FTPTransferType.ASCII);
                                inFTP.chdir(prop.getProperty("dtrc.downwload.dir"));

                    //Code to put the new XML DTRC Canada file
                    outFTP=new FTPClient(prop.getProperty("dtrc.ftpServer"));
                    outFTP.login(prop.getProperty("dtrc.ftpUserName"),prop.getProperty("dtrc.ftpPwd"));
                    outFTP.setType(FTPTransferType.ASCII);
                    outFTP.chdir(prop.getProperty("dtrc.xmlExport.dir"));

                    //Get the list of file into the folder
                    String [] files = inFTP.dir();
                    BufferedReader br;
                    String xml;

                    if(files.length==1 && files[0].toLowerCase().indexOf(".txt") == -1){
                       Constants.logger.debug("\n CanadaDTRCFile: There are no files to process.");
                    }else{
                        Constants.logger.debug("\n Number of files = " + files.length);
                        for(int idx=0;idx<files.length;idx++){
                            if(files[idx].toLowerCase().indexOf(".txt") != -1){
                                dtrcFile=files[idx];
                                br=new BufferedReader(new StringReader(new String(inFTP.get(files[idx]))));

                                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
                                xmlFile = "CAN"+sdf.format(new Date())+".xml";

                                xmlResult=parseString( br, canSurchargesMap, files[idx], xmlFile);

                                xml=(String)xmlResult.get("result");

                                if("badAmounts".equals(xml)){
                                    notifyError(dtrcFile,"ROD Amount plus Ancillary Amount doesn't match with REC Amount. Problem on AWB = " + xmlResult.get("awb"),prop);
                                    /***moving the file to processed****/
                                    inFTP.rename(files[idx],"processed/"+files[idx]);
                                    break;
                                }

                                outFTP.put(xml.getBytes("UTF-8"),xmlFile);

                                /***moving the file to processed****/

                                String dateName       = sdf.format(new Date());
                                inFTP.rename(files[idx],"processed/"+files[idx] + "_" + dateName);
                                Constants.logger.debug("\n\n CanadaDTRCFile: " + files[idx] + " Produced and Move as " + xmlFile + " ROD XML file successfully.\n" ) ;
                            }
                        }
                    }

                }catch(FTPException fe){
                    Constants.logger.debug("\n FTPException on CanadaDTRCFile = " + Utils.stackTraceToString(fe));
                    notifyError(dtrcFile,Utils.stackTraceToString(fe),prop);
                }catch(Exception e){
                    Constants.logger.debug("\n Exception on CanadaDTRCFile = " + Utils.stackTraceToString(e));
                    notifyError(dtrcFile,Utils.stackTraceToString(e),prop);
                }finally{
                    try{
                        inFTP.quit();
                    }catch(Exception e){}
                    try{
                        outFTP.quit();
                    }catch(Exception e){}

                }
            //}//Close While
    }

    private HashMap parseString(BufferedReader br,HashMap canSurchargesMap, String inputFile, String outputFile)throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Collection result=new ArrayList();
        String buf;
        String xmlInString="";
        HashMap results=new HashMap();
        HashMap validationDuplicatesLogs=new HashMap();

        // create a JAXBContext
        JAXBContext jc = JAXBContext.newInstance("com.fedex.lacitd.cashcontrol.interfaces.clearance");

        // create an empty ListReceivable
        ObjectFactory of=new ObjectFactory();
        ReceivableList rl = of.createReceivableList();
        List lisReceivable=null;
        int i=1;
        try{
            while((buf=br.readLine())!=null){
                try{
                  Receivable receivable = of.createReceivable();
                //Set the attribute num to the receivable
                  receivable.setNum(i++);

                  String locAppndr=buf.substring(15,16).trim();
                  locAppndr=(locAppndr==null || "".equals(locAppndr) || " ".equals(locAppndr))?"HZ":locAppndr;

                  receivable.setLocation(buf.substring(12,15).trim()+locAppndr);
                  receivable.setMtn(buf.substring(16,28).trim());
                  receivable.setCustomer(buf.substring(28,63).trim()==null || "".equals(buf.substring(28,63).trim())?"Unknown":buf.substring(28,63).trim());
                  SimpleDateFormat fmter2=new SimpleDateFormat("yyyyMMdd");
                  Date dateAfterParser   = fmter2.parse(buf.substring(0,8).trim());  //Date
                  GregorianCalendar gC   = new GregorianCalendar();
                  gC.setTime(dateAfterParser);
                  receivable.setRecDate(gC);
                  receivable.setRecNumber(buf.substring(63,69).trim());
                  receivable.setRecCurrency(buf.substring(69,72).trim());
                  receivable.setExchRate(new java.math.BigDecimal(buf.substring(72,73).trim()));
                  BigDecimal recAmt=new java.math.BigDecimal(buf.substring(74,83).trim()).divide(new BigDecimal(100),2,2);
                  BigDecimal ancAmt=new java.math.BigDecimal(buf.substring(84,93).trim()).divide(new BigDecimal(100),2,2);
                  BigDecimal rodAmt=new java.math.BigDecimal(buf.substring(94,103).trim()).divide(new BigDecimal(100),2,2);
/*
Constants.logger.debug("\n recAmt=" + recAmt);
Constants.logger.debug("\n ancAmt=" + ancAmt);
Constants.logger.debug("\n rodAmt=" + rodAmt);
Constants.logger.debug("\n sum ancAmt + rodAmt=" + (ancAmt.add(rodAmt)));
*/
                  if(recAmt.compareTo(ancAmt.add(rodAmt))!=0){
                     results.put("result","badAmounts");
                     results.put("awb",receivable.getMtn());
                     return results;
                  }
                  receivable.setRecAmount(recAmt);
                  receivable.setAnchargeAmount(ancAmt);
                  receivable.setRodAmount(rodAmt);


                  lisReceivable = rl.getReceivable();

                  /**SURCHARGES**/
                /*
                  receivable.setSurcharges(of.createSurchargesType());
                  List surList=receivable.getSurcharges().getSurcharge();
                  String surchargeType;

                  for(int offset=83;((offset+32)<buf.length());offset=offset+32){
                       java.math.BigDecimal surAmt=new java.math.BigDecimal(buf.substring(offset+23,offset+32).trim()).divide(new java.math.BigDecimal(100),2,2);
                       if(surAmt.floatValue()>0.0){
                            Surcharge sur=of.createSurcharge();
                            surchargeType=buf.substring(offset,offset+3).trim();

                            //Get the surcharge type
                            sur.setType((String)canSurchargesMap.get(surchargeType));
                            sur.setAmount(surAmt);
                            buf.substring(offset,offset+2).trim();
                            surList.add(sur);
                       }
                  }*/

                  // canada duplicated issue
                  if(validateDuplicatedROD( receivable, validationDuplicatesLogs, inputFile, outputFile))
                      lisReceivable.add(receivable);

                }catch(Exception e){
                    throw e;
                }
            }


            //PLEASE ADD HERE THE CANADA VALIDATION 
           // create a Marshaller and marshal to System.out
               Marshaller m = jc.createMarshaller();
               m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            

               StringWriter str = new StringWriter();
               m.marshal(rl, str);
               xmlInString      = new String(str.getBuffer());
        }catch(Exception e){
            throw e;
        }

        // we log:
            // file name
            // the AWB # that were deleted
            // the AWB # that were updated
        logValidationsResults( validationDuplicatesLogs, inputFile, outputFile);

        results.put("result",xmlInString);
        return results;
    }

    private void logValidationsResults( HashMap results, String inputFile, String outputFile)
    {
        String messageIgnored = (String) results.get(KEY_dpd_ignored);
        String messageUpdate = (String) results.get(KEY_dpd_update);
        String qty = (String) results.get(KEY_dpd_qty);

        if(qty == null || Integer.parseInt(qty) <= 0) return;

        if(messageIgnored != null && messageIgnored.length()>0) messageIgnored = messageIgnored.substring( 0, messageIgnored.length() -1);
        if(messageUpdate != null && messageUpdate.length()>0) messageUpdate = messageUpdate.substring( 0, messageUpdate.length() -1);

        try
        {
            RodFileProcLogVO rlog = new RodFileProcLogVO();

            rlog.setFileNm( inputFile);
            rlog.setProcessDt(new java.util.Date());
            rlog.setMessage( "File DTRC transformed to " + outputFile + ".");

            if(messageIgnored != null && messageUpdate != null && messageIgnored.length()>0&& messageUpdate.length()>0)
            {
                rlog.setErrorDtlDesc( "AWBS ignored \"" + messageIgnored + "\"");

                rlog.setErrorDtlDesc( rlog.getErrorDtlDesc() + "; AWBS updated \"" + messageUpdate + "\"");
            }
            else if(messageIgnored == null || messageIgnored.length() == 0)

                rlog.setErrorDtlDesc( "; AWBS updated \"" + messageUpdate + "\"");

            else if(messageIgnored != null && messageIgnored.length()>0)
                rlog.setErrorDtlDesc( "AWBS ignored \"" + messageIgnored + "\"");

            rlog.setStatusCd( 2);
            rlog.setLocationCd( (String)results.get(KEY_location));
            rlog.setAwbQty( Integer.parseInt(qty));

            new RodFileProcLogController().setRodFileProcLog( rlog);
        }
        catch (BusinessDelegateException e)
        {
            Constants.logger.debug( Utils.stackTraceToString( e));
        }
    }

    private boolean validateDuplicatedROD(Receivable rc, HashMap results, String inputFile, String outputFile)
    {
        if(results.get(KEY_dpd_ignored) == null) results.put(KEY_dpd_ignored, "");
        if(results.get(KEY_dpd_update) == null) results.put(KEY_dpd_update, "");
          
        try
        {
            ReceivablesController adminBiz = new ReceivablesController();

            ArrayList list = (ArrayList)adminBiz.getReceivablesReceivablesByAwbNbr( rc.getMtn());

            // there's no AWB into DataBase now.
            // no ---> not duplicated.
            if(list.size() == 0) return true;

            // we get the 1'st and the only one record.
            ReceivablesVO rod = (ReceivablesVO)list.iterator().next();

            if(results.get(KEY_dpd_qty) == null)
                results.put( KEY_dpd_qty, "1");
            else
                results.put( KEY_dpd_qty, (Integer.parseInt((String)results.get(KEY_dpd_qty)) + 1) + "");

            results.put( KEY_location, rod.getLocationCd());
            
            if(rod.getRecAmt() == rc.getRecAmount().doubleValue())
            {
              results.put(KEY_dpd_ignored, results.get(KEY_dpd_ignored) + rc.getMtn() + ",");
              return false;
            }

            // if the status is 1 "Clear"
            if(rod.getStatusId() == 1)
            {
              results.put(KEY_dpd_ignored, results.get(KEY_dpd_ignored) + rc.getMtn() + ",");
              return false;
            }

            // updating the record!!

            //RecAmount
            rod.setRecAmt( rc.getRecAmount().doubleValue());
            //Duty
            rod.setAncChargeAmt( rc.getAnchargeAmount().doubleValue());
            //Ancillary
            rod.setRodAmt( rc.getRodAmount().doubleValue());
            //Rec_dt
            rod.setRecDt( rc.getRecDate().getTime());

            adminBiz.updateReceivables( rod);

            results.put(KEY_dpd_update, results.get(KEY_dpd_update) + rc.getMtn() + ",");

            return false;
        }
        catch(Exception e)
        {
            try
            {
                RodFileProcLogVO rlog = new RodFileProcLogVO();

                rlog.setFileNm( inputFile);
                rlog.setProcessDt(new java.util.Date());
                rlog.setMessage( "DTRC file parsing file Error:");

                rlog.setErrorDtlDesc( Utils.stackTraceToString( e));

                rlog.setStatusCd( 2);
                rlog.setLocationCd( (String)results.get(KEY_location));

                new RodFileProcLogController().setRodFileProcLog( rlog);
            }
            catch(Exception e2)
            {
                Constants.logger.debug( Utils.stackTraceToString( e2));
            }
        }

        return true;
    }

    private void notifyError(String fileNm,String errorMessage,Properties prop){
    	try{
    		AdminBizDelegate adminBiz=new AdminBizDelegate();
    		//String country=Utils.getCountryFileName(fileNm);
            //Notify to Admins
            Iterator admins=adminBiz.getAdminEmployees(null).iterator();
    		String to="";
            String bodyMessage;

            while(admins.hasNext()){
    			EmployeeVO evo=(EmployeeVO)admins.next();
                if(evo.getEmail()!=null){
    			    to=to+evo.getEmail()+",";
                }
    		}

            //Add dtrc Email List to the recipients
            to= to + prop.getProperty("dtrc.emailList");

            EmailSender1 es=new EmailSender1();
    		HashMap hm=new HashMap();
    		hm.put("TO:",to);
    		hm.put("Subject:","CANADIAN DTRC IMPORT FILE");
            bodyMessage="An exception ocurred in importing the Canadian DTRC file to GCCS. File Name: "+fileNm+ "\n\n" +
                        "Please check this problem.\n\n CashControl System. \n\n Exception Details: \n" +
                        errorMessage;
            hm.put("Body:",bodyMessage);

            Constants.logger.debug(" msg: " + bodyMessage);

            es.setEmails(hm);
            es.send();
    	}catch(Exception e){
    		Constants.logger.debug("Exception ocurred in notifyError() method from CanadaDTRCFile: \n"+Utils.stackTraceToString(e));
    	}
    }
}
