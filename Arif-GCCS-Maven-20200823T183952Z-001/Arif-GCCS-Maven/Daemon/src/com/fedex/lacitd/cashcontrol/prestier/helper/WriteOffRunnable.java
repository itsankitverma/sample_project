/**
 * ProcessLastScanRunnable.java
 *
 * Created on September 28, 2002, 3:31 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;
import java.util.Properties;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CommonOpsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;

/**
 *
 * @author  ccardenas
 */
public class WriteOffRunnable implements Runnable, java.io.Serializable {
    
    private java.lang.Thread thread; 
    
    public void run() {
    	System.out.println("WriteOffRunnable");
        while(!"STOP_THREAD".equals(thread.getName())){        	
        	long beforeTime=System.currentTimeMillis();
	        try{
	        	Properties props=Utils.getProperties("P");
	        	if("true".equalsIgnoreCase(props.getProperty("writeOffMarking.active"))){
	        		Constants.logger.debug("Running Write Off Daemon");
	        		markWriteOff();
	        	}else{
	        		Constants.logger.debug("Write Off Daemon is not active.");	        		
	        	}	
	        	long elapsedTime=System.currentTimeMillis()-beforeTime;
	            Thread.sleep(Constants.WriteOffTaskInterval-elapsedTime);
	            
	        }catch(Exception e){
	            Constants.logger.debug(Utils.stackTraceToString(e));
                try{
    	        	long elapsedTime=System.currentTimeMillis()-beforeTime;
    	            Thread.sleep(Constants.WriteOffTaskInterval-elapsedTime);
                 }catch(InterruptedException ie){} 
	        }
        }    
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
	
	public void markWriteOff()throws Exception{
		System.out.println("Mark Write off method");
		new CommonOpsBizDelegate().markWriteOff();
	}	
}

