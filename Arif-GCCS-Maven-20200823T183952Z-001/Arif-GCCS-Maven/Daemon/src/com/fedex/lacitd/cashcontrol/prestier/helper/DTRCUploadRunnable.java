/**
 * ProcessLastScanRunnable.java
 *
 * Created on September 28, 2002, 3:31 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FTPClient;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CommonOpsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

/**
 *
 * @author  ccardenas
 */
public class DTRCUploadRunnable implements Runnable, java.io.Serializable {
    
    private java.lang.Thread thread; 
    
    public void run() {
    	while(!"STOP_THREAD".equals(thread.getName())){
    		
        	long beforeTime=System.currentTimeMillis();
	        try{	        	
	        	Properties props=Utils.getProperties("P");
	        	if("true".equalsIgnoreCase(props.getProperty("dtrcUpload.active"))){
	        		Constants.logger.debug("DTRC Upload Daemon Running");
	        		int daysBeforeCount;
	        		try{ 
	        			daysBeforeCount=Integer.parseInt(props.getProperty("dtrcUpload.daysBeforeCount"));
					}catch(Exception e){
						daysBeforeCount=2;
					}
					
	        		uploadDailyDTRCFile(daysBeforeCount<1?2:daysBeforeCount);
	        	}else{
	        		Constants.logger.debug("DTRC Upload Daemon is not active");
	        	}	
	        	
	        		long elapsedTime=System.currentTimeMillis()-beforeTime;
	            Thread.sleep(Constants.DTRCUploadTaskInterval-elapsedTime);
	            
	        }catch(Exception e){
	            Constants.logger.debug(Utils.stackTraceToString(e));
                try{
    	            Thread.sleep(300000); //retry in 5 minutes in case of failure
                 }catch(InterruptedException ie){} 
	        }
        }    
    }
    
    public void uploadDailyDTRCFile(int daysBeforeCount) throws Exception{
		Collection colDTRC=new CommonOpsBizDelegate().getDailyDtrcUpload(daysBeforeCount);
		if(colDTRC.size()>0){		
			Iterator iterDTRC=colDTRC.iterator();
			StringBuffer sb=new StringBuffer();
			while(iterDTRC.hasNext()){
				sb.append((String)iterDTRC.next());
			}
		
			sendFtpFile(sb.toString());
		}	
    }

    private void sendFtpFile(String fileStr){
    	FTPClient clt = null;

           try {
           		Properties props=Utils.getProperties("P");           	
                clt = new FTPClient(props.getProperty("dtrcUpload.ftpServer") );
                clt.login(props.getProperty("dtrcUpload.userNm"),props.getProperty("dtrcUpload.password"));

                String fileName       = props.getProperty("dtrcUpload.dirName") + props.getProperty("dtrcUpload.fileName");

                clt.setType(FTPTransferType.ASCII);
                //append if file is present.
                clt.put(fileStr.getBytes("UTF-8"), fileName, true);

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
    
	/**
	 * @return Returns the thread.
	 */
	public java.lang.Thread getThread() {
		return thread;
	}
	/**
	 * @param thread The thread to set.
	 */
	public void setThread(java.lang.Thread thread) {
		this.thread = thread;
	}
}

