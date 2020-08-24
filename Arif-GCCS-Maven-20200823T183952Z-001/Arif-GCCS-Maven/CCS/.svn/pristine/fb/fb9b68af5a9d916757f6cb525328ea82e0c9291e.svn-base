package com.fedex.lacitd.cashcontrol.prestier.helper;
import java.util.*;
import java.io.IOException;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.common.gccsftp.FTPClient;

//import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FTPException;

/**
 * Created by IntelliJ IDEA.
 * User: ccardenas
 * Date: Jan 13, 2005
 * Time: 12:22:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PSCashInBankUpload {

    private Properties prop=null;

    public  PSCashInBankUpload(){
        try{
            prop=Utils.getProperties("P");
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            prop=new Properties();
        }
    }

   public void uploadJournalEntries(){
       AdminBizDelegate abd=new AdminBizDelegate();
       try{
            Collection colEnt=abd.getEntityPSActiveEnt("CASHBANK");
            Iterator iterEnt=colEnt.iterator();
            Collection colJE=new ArrayList();

            while(iterEnt.hasNext()){
                String entCd=(String) iterEnt.next();
                Collection colEntJE=null;
                try{
                    colEntJE=abd.getCashInBankPSUpload(entCd);
                }catch(Exception e){
                    Constants.logger.debug("ENTITY "+entCd+ ": "+Utils.stackTraceToString(e));
                }

                if(colEntJE!=null && colEntJE.size()>1)colJE.addAll(colEntJE);
            }

            sendFile(colJE);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
       }
   }

   public void sendFile(Collection colJE){
    	FTPClient clt = null;

           try {
                Iterator iterJE=colJE.iterator();
                StringBuffer sb=new StringBuffer();
                while(iterJE.hasNext()){
                    sb.append(iterJE.next()+"\n");
                }

                clt = new FTPClient(prop.getProperty("psupload.cashBank.ftp.server") );
                clt.login(prop.getProperty("psupload.cashBank.ftp.user"),prop.getProperty("psupload.cashBank.ftp.password"));

                String fileName       = prop.getProperty("psupload.cashBank.ftp.dir") + "GCCScashnbnkjrnl.dat";

                clt.setType(FTPTransferType.ASCII);
                //Now transmit the xml stream to an xml file in the respective ftp site
                clt.put(sb.toString().getBytes("UTF-8"),fileName);
                fileName       = prop.getProperty("psupload.woff.ftp.dir") + "GCCScashnbnkjrnl.end";
                clt.put("".getBytes("UTF-8"),fileName);

               clt.quit(); // Quit the ftp site
            } catch(IOException e) {
                Constants.logger.debug("Error: sendFile() \n" + e.toString());
            } catch(FTPException eftp){
                Constants.logger.debug("Error: sendFile() \n" + eftp.toString());
            }catch(Exception eftp){
                Constants.logger.debug("Error: sendFile() \n" + eftp.toString());
            }
            return;

   }
}
