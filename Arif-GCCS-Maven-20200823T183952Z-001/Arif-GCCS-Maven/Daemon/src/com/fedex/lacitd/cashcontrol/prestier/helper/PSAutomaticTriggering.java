/**
 * Created on Nov 30, 2004
 *
 */
package com.fedex.lacitd.cashcontrol.prestier.helper;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.common.Utils;

/**
 * @author arturog
 */
public class PSAutomaticTriggering implements Job {
    public PSAutomaticTriggering() {
    }

    //This method will check the list of users every quarter to revoke or not
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Properties prop=null;
        try {
            prop=Utils.getProperties("P");
        } catch (BizDelegateException e) {
            prop=null;
        }

        try{
            new ReadExchRateExcelFile().publishExchRates(null);
        }catch (Exception e) {
            Constants.logger.debug("\n\n Exception in GCCS PS UPLOAD, Details : \n " + Utils.stackTraceToString(e));
        }


        try{
            if(prop!=null && "true".equals(prop.getProperty("psupload.cashBank.automatic.active"))){
                new PSCashInBankUpload().uploadJournalEntries();
            }
        }catch (Exception e) {
            Constants.logger.debug("\n\n Exception in GCCS PS UPLOAD, Details : \n " + Utils.stackTraceToString(e));
        }


        try{
            if(prop!=null && "true".equals(prop.getProperty("psupload.woff.automatic.active"))){
                new PSWriteOffUpload().uploadJournalEntries();
            }
        }catch (Exception e) {
            Constants.logger.debug("\n\n Exception in GCCS PS UPLOAD, Details : \n " + Utils.stackTraceToString(e));
        }


        try{
            schedulePSUpload();
        }catch (Exception e) {
            Constants.logger.debug("\n\n Exception in GCCS PS UPLOAD, Details : \n " + Utils.stackTraceToString(e));
        }


    }

    public static void schedulePSUpload() throws Exception
    {
        try{
            JobDetail jobDetail = new JobDetail ("PS UPLOAD JOB","Administration",PSAutomaticTriggering.class);
            CronTrigger trigger = new CronTrigger("PS UPLOAD JOB","PS UPLOAD JOB");
            AdminBizDelegate abd=new AdminBizDelegate();

            GregorianCalendar gc=new GregorianCalendar();
            gc.setTime(abd.getNextClosingDate());

            trigger.setCronExpression("0 "+gc.get(GregorianCalendar.MINUTE)+" "+gc.get(GregorianCalendar.HOUR_OF_DAY)+" "+gc.get(GregorianCalendar.DAY_OF_MONTH)+" "+(gc.get(GregorianCalendar.MONTH)+1)+" ?");

            //to test
            //trigger.setCronExpression("0 0 17 * * ?");
            jobDetail.setVolatility(true);
            Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
            sched.scheduleJob(jobDetail, trigger);
            Constants.logger.debug("\n\n *** NEXT PS UPLOAD  : " + trigger.getNextFireTime() + " *** \n\n");
        }catch(Exception e){
            throw e;
    	}
    }
}



