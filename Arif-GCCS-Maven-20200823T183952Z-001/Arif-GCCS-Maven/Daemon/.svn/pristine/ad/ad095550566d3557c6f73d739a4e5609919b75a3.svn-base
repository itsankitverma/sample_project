package com.fedex.lacitd.cashcontrol.prestier.helper;

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
import com.fedex.lacitd.cashcontrol.common.Utils;

/**
 * Created by IntelliJ IDEA.
 * User: arturog
 * Date: 17-06-2005
 * Time: 12:28:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class PurgeCosmosScansTriggering implements Job{

    Properties prop = null;

    public PurgeCosmosScansTriggering() {
        try{
            prop = Utils.getProperties("P");
        }catch(Exception e)
        {Constants.logger.debug("\n\n Exception when trying to get Parameters, Details : \n " + Utils.stackTraceToString(e));}
    }

    //This method will check the list of users every quarter to revoke or not
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try{
            SystemUtilsBizDelegate utilBizDelegate = new SystemUtilsBizDelegate();

            Constants.logger.debug("\n\n Start Process to Purge Cosmos Scans.");
            utilBizDelegate.runPurgeCosmosScans();
            Constants.logger.debug("\n\n Finish Process to Purge Cosmos Scans succesfully.");
        }catch (Exception e) {
            Constants.logger.debug("\n\n Exception when try to purge Cosmos Scans, Details : \n " + Utils.stackTraceToString(e));
        }
    }

    public void schedulePurgeCosmosScans() throws Exception
    {
        try{
            JobDetail jobDetail = new JobDetail ("Purge Cosmos Scan Job","General",PurgeCosmosScansTriggering.class);
            CronTrigger trigger = new CronTrigger("Purge Cosmos Scan Cron","Purge Cosmos Scans Cron");
            trigger.setCronExpression(prop.getProperty("COSMOS_SCANS_PURGING_DAYS"));
            jobDetail.setVolatility(true);
            Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
            sched.scheduleJob(jobDetail, trigger);
            Constants.logger.debug("\n\n *** NEXT PURGING OF COSMOS SCANS  : " + trigger.getNextFireTime() + " *** \n\n");
        }catch(Exception e){
            throw e;
    	}
    }

}
