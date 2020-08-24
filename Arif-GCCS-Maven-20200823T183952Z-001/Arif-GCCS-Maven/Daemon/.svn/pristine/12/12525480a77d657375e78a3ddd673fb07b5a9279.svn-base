package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.SystemUtilsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.FedExEmployee;
import com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtilsBean;
import com.fedex.lacitd.cashcontrol.common.Utils;
//Miscellaneous enhancements
public class EmailCertificationTriggering implements Job {

	
	Properties prop = null;

    public EmailCertificationTriggering() {
        try{
            prop = Utils.getProperties("P");
        }catch(Exception e)
        {Constants.logger.debug("\n\n Exception when trying to get Parameters, Details : \n " + Utils.stackTraceToString(e));}
    }
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		String EmailAddressesString= null;
		StringBuffer sb = new StringBuffer();
		int secondLastEmail=0;
		try{
			System.out.println("Load app demon MMMMMM 3");
            SystemUtilsBizDelegate utilBizDelegate = new SystemUtilsBizDelegate();            
           //Station manager's role_id_nbr= 3
            List emailAddressList=utilBizDelegate.getEmailCertificationAddresses(3);
            Constants.logger.debug("\n\n Got Email Addresses For Email Certification.");
            int sizeOfEmailList=emailAddressList.size();
            Iterator iterator = emailAddressList.iterator();
            while (iterator.hasNext()) {
           	 sb.append(iterator.next());        	 
           	secondLastEmail++;
           	 if (sizeOfEmailList > secondLastEmail){
    				sb.append(",");
    				}
   			}
             EmailAddressesString=sb.toString();
          //CALL EMAILSENDER1.java
             //START
             
            EmailSender1 mail = new EmailSender1();
            mail.setPersonalName("GGCS_TEST_MMMMMM");

            
            String to = null;
            
            //to = EmailAddressesString;
            
            Constants.logger.debug("Mail to: " + to);

            if("YES".equals(Utils.getProperties("P").getProperty("VALID_USER_DEV")))
                to = "609358@fedex.com";

            HashMap emails = new HashMap();
            emails.put("Subject:",Constants.SUBJECT_EMAIL_CERTIFICATION);
            emails.put("Body:",Constants.BODY_EMAIL_CERTIFICATION);
            emails.put("TO:",to);
            emails.put("MIMETYPE:","text/html");
            mail.setEmails(emails);
            mail.send();
        
             //END             
            Constants.logger.debug("\n\n Finish Sending Email Certification succesfully.");
        }catch (Exception e) {
            Constants.logger.debug("\n\n Exception when try to Send Email Certification, Details : \n " + Utils.stackTraceToString(e));
        }		
	}
	
	 public void scheduleEmailCertificationTriggering() throws Exception
	    {
	        try{
	        	System.out.println("Load app demon MMMMMM 2");
	            JobDetail jobDetail = new JobDetail ("Email Cirtification Job","General",EmailCertificationTriggering.class);
	            CronTrigger trigger = new CronTrigger("Email Cirtification Cron","Email Cirtification Cron");
	         // EMAIL_CERTIFICATION_DAY l Fire every Feburary 2nd at 11:00am.
	            trigger.setCronExpression(prop.getProperty("EMAIL_CERTIFICATION_DAY"));
	            jobDetail.setVolatility(true);
	            Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
	            sched.scheduleJob(jobDetail, trigger);
	            Constants.logger.debug("\n\n *** NEXT EMAIL CERTIFICATION DAY  : " + trigger.getNextFireTime() + " *** \n\n");
	        }catch(Exception e){
	            throw e;
	    	}
	    }

	
	
	
	
	
}
