package com.fedex.lacitd.cashcontrol.prestier.servlets.daemons;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.prestier.helper.CanadaDTRCFile;
import com.fedex.lacitd.cashcontrol.prestier.helper.DTRCUploadRunnable;
import com.fedex.lacitd.cashcontrol.prestier.helper.EmailCertificationTriggering;
import com.fedex.lacitd.cashcontrol.prestier.helper.EmailSender1;
import com.fedex.lacitd.cashcontrol.prestier.helper.ExtPaymentProcessRunnable;
import com.fedex.lacitd.cashcontrol.prestier.helper.ImportDataFileToXMLFile;
import com.fedex.lacitd.cashcontrol.prestier.helper.ImportFromXMLRunnable;
import com.fedex.lacitd.cashcontrol.prestier.helper.InCageExceptionsRunnable;
import com.fedex.lacitd.cashcontrol.prestier.helper.PSAutomaticTriggering;
import com.fedex.lacitd.cashcontrol.prestier.helper.ProcessRIHFileRunnable;
import com.fedex.lacitd.cashcontrol.prestier.helper.ProcessVISAFileRunnable;
import com.fedex.lacitd.cashcontrol.prestier.helper.PurgeCosmosScansTriggering;
import com.fedex.lacitd.cashcontrol.prestier.helper.RIHPrepaidRequesterRunnable;
import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateUsersByQuarterWSSO;
import com.fedex.lacitd.cashcontrol.prestier.helper.WriteOffRunnable;
import com.fedex.lacitd.cashcontrol.prestier.helper.AppInit;

public class LoadApplicationDaemons extends HttpServlet {
    
    Collection colThreads=Collections.synchronizedCollection(new ArrayList());

    public void init(){
        try{
            //Check if the properties values correspond to the development server or production server
            //or testing server, and try to match with the jndi ENVIRONMENT variable.
        	
        	//===getting the host name to determine whether Daemon should be running on this manage server or not============
        	InetAddress ip;
            String hostname;
   			ip = InetAddress.getLocalHost();
   			hostname = ip.getHostName();
        	System.out.println("this server's hostname is: "+hostname);

   			//================================================================================================================
        	
                //Get ENVIRONMENT data from DB
        	System.out.println("here we have invoked Application Daemon --------------->>>>>>>>>>");
                Properties props = Utils.getProperties("P");
                String envDB = props.getProperty("ENVIRONMENT");
                
                //Get ENVIRONMENT data properties of MAIL
                EmailSender1 sender = new EmailSender1();
                //String env = sender.getSession().getProperty("ENVIRONMENT")==null?"GCCS_DEV":sender.getSession().getProperty("ENVIRONMENT");
                // For local setup
                String env = props.getProperty("ENVIRONMENT");
                System.out.println("--------------------");
                System.out.println("envDB :"+envDB);
                System.out.println("env :"+env);
                System.out.println("--------------------");
                
                /*
                    //Get ENVIRONMENT data from JNDI
                    InitialContext ctx = new InitialContext();
                    String envJNDI = (String)ctx.lookup("ENVIRONMENT");*/

                //IF values are different then send email to the admin users and do not starting up the deamons
                if(!env.equals(envDB))
                {   sender.setEmails(sender.selectEmail(null,Constants.SUBJECTCHECKENV,null,Constants.BODYCHECKENV + " \n\n Note: Weblogic Environment=" + env + " ==> DB Environment=" + envDB));
                    sender.send();
                    Constants.logger.error("\n\n ALERT !!!! >> \n " + Constants.BODYCHECKENV + "\n  << ALERT !!!! \n\n ");
                
                }else if(hostname.equals(props.getProperty("gccs.host.allow.daemonToRun"))){
                	
                	System.out.println("this hostname - "+hostname+" is allowed to run Daemon");
                	
                		System.out.println("here we are starting the thread---------");
                        InCageExceptionsRunnable r=new InCageExceptionsRunnable();
                        Thread task=new Thread(r);
                        r.setThread(task); //THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("In_Cage_Exception_Task");
                        colThreads.add(task);
                        task.start();

                        ImportFromXMLRunnable t=new ImportFromXMLRunnable();
                        t.setServletCtx(getServletContext());
                        task=new Thread(t);
                        t.setThread(task); //THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("Import_Invoices_from_XML_Task");
                        colThreads.add(task);
                        task.start();

                        System.out.println("Process Visa File --- Start here ------");
                        ProcessVISAFileRunnable pvf=new ProcessVISAFileRunnable();
                        pvf.setServletCtx(getServletContext());
                        task=new Thread(pvf);
                        pvf.setThread(task);//THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("Process_VISA_File_Task");
                        colThreads.add(task);
                        task.start();
                        System.out.println("Process Visa File --- End here ------");
                        
                        System.out.println("Process RIH File --- Start here ------");
                        ProcessRIHFileRunnable prf=new ProcessRIHFileRunnable();
                        prf.setServletCtx(getServletContext());
                        task=new Thread(prf);
                        prf.setThread(task);//THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("Process_RIH_File_Task");
                        colThreads.add(task);
                        task.start();
                        System.out.println("Process RIH File --- End here ------");
                        
                        System.out.println("Process RIH Prepaid File --- Start here ------");
                        RIHPrepaidRequesterRunnable rprr=new RIHPrepaidRequesterRunnable();
                        task=new Thread(rprr);
                        rprr.setThread(task);//THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("Request_RIH_Prepaids_Task");
                        colThreads.add(task);
                        task.start();
                        System.out.println("Process RIH Prepaid File --- End here ------");
                        
                        WriteOffRunnable worr=new WriteOffRunnable();
                        task=new Thread(worr);
                        worr.setThread(task);//THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("Write_Off_Task");
                        colThreads.add(task);
                        task.start();

                        DTRCUploadRunnable dtrcrr=new DTRCUploadRunnable();
                        task=new Thread(dtrcrr);
                        dtrcrr.setThread(task);//THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("DTRC_Upload_Task");
                        colThreads.add(task);
                        task.start();


                        //This code up the ImportDataFileToXMLFile class to get data from the DTRC file
                        //it had been done by Arturo Gonzalez
                        ImportDataFileToXMLFile dtrc=new ImportDataFileToXMLFile();
                        dtrc.setServletCtx(getServletContext());
                        task=new Thread(dtrc);
                        dtrc.setThread(task);//THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("Process_DTRC_File_Task");
                        colThreads.add(task);
                        task.start();

                        //This code up the ExtPaymentProcessRunnable class to get data from the XML file
                        //and update payments in the database
                        ExtPaymentProcessRunnable eppr=new ExtPaymentProcessRunnable();
                        eppr.setServletCtx(getServletContext());
                        task=new Thread(eppr);
                        eppr.setThread(task);//THE THREAD NAME IS USED TO STOP THE THREADS.
                        task.setName("Process_External_File_Task");
                        colThreads.add(task);
                        task.start();

                        //This code call to the method to schedule the task that validate the complete user list
                        //in GCCS

                        
                        //System.out.println("load validateUserList sep 9 without quartz");
                        //validateUserList();
                        //validateUserListNew();  //Jeena added this

                        
                        //This code call to the method to schedule the task that upload PS information
                        //about CASH IN BANK and WRITE OFF
                        PSAutomaticTriggering.schedulePSUpload();

                        //This code call to the method to schedule the task that purge COSMOS SCANS every quarter
                        PurgeCosmosScansTriggering purgeCs = new PurgeCosmosScansTriggering();
                        purgeCs.schedulePurgeCosmosScans();
                        
                        
                        
                        //MMMMMM
                        //This code call to the method to schedule the email certification task that goes off every year 2nd june .
                        EmailCertificationTriggering emailCert = new EmailCertificationTriggering();
                        System.out.println("Load app demon MMMMMM 1");
                        emailCert.scheduleEmailCertificationTriggering();
                        
                        
                        
                        

                        //This code call to the method to schedule the task that Trnasform CAN DTRC information to ROD XML file
                        dtrcTransform();
                        
                      //This is a call to the MCD methods .Jeena Paul 10/12/2009 
                        AppInit.startMcd();
                        System.out.println("here we are ending the thread");

                }

        }catch(Exception e){
        	System.out.println("---------------------");
        	e.printStackTrace();
        	System.out.println("---------------------");
            Constants.logger.debug("\n\n *** Exception in LoadApplicationDaemons class => " + Utils.stackTraceToString(e));
        }    
    } 
    
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException{
        try{
                        
            res.setContentType("text/html");
            
            PrintWriter out=res.getWriter();
            out.println("<html><head><title>Tasks Status</title></head><body>");
            out.println("<table align='center' border='1'>");
            out.println("<tr><td>Task</td><td>Status</td></tr>");
            Iterator iterThreads=colThreads.iterator();
            while(iterThreads.hasNext()){
                 Thread trh=(Thread)iterThreads.next();                 
                 out.println("<tr><td>" + trh.getName() + "</td><td>" + (trh.isAlive()?"RUNNING":"STOPPED") + "</td></tr>");
            }    

            out.println("</table>");            
            out.println("</body>");                        
            out.println("</html>");                                    
            out.flush();
        }catch(Exception e){
            throw new ServletException(e.toString());
        }
    }
    
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException{
          doGet(req,res);
    }
    
    
    public void destroy(){
            Iterator iterThreads=colThreads.iterator();
            while(iterThreads.hasNext()){
                 Thread trh=(Thread)iterThreads.next();                 
                 trh.setName("STOP_THREAD");
            }       
    }
    
    private void validateUserList() throws Exception
    {
        try{
            Constants.logger.debug("\n\n *** Start scheduler setting for Users Validation Process... ***");
            JobDetail jobDetail = new JobDetail ("Validate Users Job","Administration",ValidateUsersByQuarterWSSO.class);
            CronTrigger trigger = new CronTrigger("Ejecucion de Job","Ejecucion de Job");
            Properties prop = Utils.getProperties("P");
            trigger.setCronExpression(prop.getProperty("VALIDATE_USERS_QUARTER"));
            Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
            sched.scheduleJob(jobDetail, trigger);
            Constants.logger.debug("\n\n *** USERS LIST VALIDATION Next fire at : " + trigger.getNextFireTime() + " *** \n\n");
        }catch(Exception e){
            throw e;
    	}
    }


    private void validateUserListNew() throws Exception
    {
        try{
               System.out.println("\n\n *** NEW SETTING FOR VALIDATION USER... ***");            
            
            ValidateUsersByQuarterWSSO valUser = new ValidateUsersByQuarterWSSO();
            valUser.executeNew();
            System.out.println("After executeNew method !!");
            /*JobDetail jobDetail = new JobDetail ("Validate Users Job","Administration",ValidateUsersByQuarterWSSO.class);
            CronTrigger trigger = new CronTrigger("Ejecucion de Job","Ejecucion de Job");
            Properties prop = Utils.getProperties("P");
            trigger.setCronExpression(prop.getProperty("VALIDATE_USERS_QUARTER"));
            Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
            sched.scheduleJob(jobDetail, trigger);
            Constants.logger.debug("\n\n *** USERS LIST VALIDATION Next fire at : " + trigger.getNextFireTime() + " *** \n\n");
            System.out.println("\n\n *** USERS LIST VALIDATION Next fire at : " + trigger.getNextFireTime() + " *** \n\n");*/
            
        }catch(Exception e){
            throw e;
       }
    }
    
    
    private void dtrcTransform() throws Exception
    {
        try{
            Constants.logger.debug("\n\n *** Start scheduler setting for DTRC Download to GCCS... ***");
            JobDetail jobDetail = new JobDetail ("DTRC Download to GCCS","CanadaDTRC",CanadaDTRCFile.class);
            CronTrigger trigger = new CronTrigger("DTRC Download Job","DTRC Download Job");
            Properties prop = Utils.getProperties("P");
            trigger.setCronExpression(prop.getProperty("DTRC_DOWNLOAD_TO_GCCS"));
            Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
            sched.scheduleJob(jobDetail, trigger);
            Constants.logger.debug("\n\n *** DTRC Download to GCCS Next fire at : " + trigger.getNextFireTime() + " *** \n\n");
        }catch(Exception e){
            throw e;
    	}
    }
}
