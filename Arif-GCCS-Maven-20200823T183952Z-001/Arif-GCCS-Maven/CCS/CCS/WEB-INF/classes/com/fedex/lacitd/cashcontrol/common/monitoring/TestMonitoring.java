package com.fedex.lacitd.cashcontrol.common.monitoring;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 24, 2008
 * Time: 12:10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMonitoring {

    public static void main(String[] a) throws Exception
    {
/*        Monitoring.event( Monitoring.MONITORING_EVENT_DELETE, "597125", "employee", "tabla 1", true);
        Monitoring.event( Monitoring.MONITORING_EVENT_DELETE, "597125", "empMonitoringoyee",  "tabla 1", false);
        Monitoring.event( Monitoring.MONITORING_EVENT_DELETE, "597125", "empMonitoringoyee",  "tabla 1", true);

        Monitoring.event( Monitoring.MONITORING_EVENT_INSERT, "597125", "admin tabMonitoringes",  "tabla 1", true);
        Monitoring.event( Monitoring.MONITORING_EVENT_INSERT, "597125", "admin tabMonitoringes",  "tabla 1", false);
        Monitoring.event( Monitoring.MONITORING_EVENT_INSERT, "597125", "admin tabMonitoringes",  "tabla 1", true);

        Monitoring.event( Monitoring.MONITORING_EVENT_READ, "597125", "admin tabMonitoringes",  "tabla 1", true);
        Monitoring.event( Monitoring.MONITORING_EVENT_READ, "597125", "admin tabMonitoringes",  "tabla 1", false);
        Monitoring.event( Monitoring.MONITORING_EVENT_READ, "597125", "admin tabMonitoringes",  "tabla 1", false);

        Monitoring.event( Monitoring.MONITORING_EVENT_UPDATE, "597125", "admin tabMonitoringes",  "tabla 1", true);
        Monitoring.event( Monitoring.MONITORING_EVENT_UPDATE, "597125", "admin tabMonitoringes",  "tabla 1", false);
        Monitoring.event( Monitoring.MONITORING_EVENT_UPDATE, "597125", "admin tabMonitoringes",  "tabla 1", true);

        Monitoring.event( Monitoring.MONITORING_EVENT_GRANT, "597125", "admin tabMonitoringes",  "user1", "table1", true);
        Monitoring.event( Monitoring.MONITORING_EVENT_GRANT, "597125", "admin tabMonitoringes",  "user1", "table1", true);
        Monitoring.event( Monitoring.MONITORING_EVENT_GRANT, "597125", "admin tabMonitoringes",  "user1", "table1", true);

        Monitoring.event( Monitoring.MONITORING_EVENT_REVOKE, "597125", "admin tabMonitoringes",  "user1", "table1", true);
        Monitoring.event( Monitoring.MONITORING_EVENT_REVOKE, "597125", "admin tabMonitoringes",  "user1", "table1", false);
        Monitoring.event( Monitoring.MONITORING_EVENT_REVOKE, "597125", "admin tabMonitoringes",  "user1", "table1", false);
*/
    	
        GregorianCalendar todayPlus = new GregorianCalendar();
        

        //System.out.println(todayPlus.getTime() +"--"+ value.getTime());
/*
 * 
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        
        Date today = sdf.parse( "12/29/2008");
        todayPlus.setTime( today);
        todayPlus.roll(Calendar.DAY_OF_YEAR, 3);

        System.out.println( "value!!! :" + today);
        System.out.println( "todayPlus!!! :" + todayPlus.getTime());
        
        if(today.after(todayPlus.getTime())){
           System.out.println( "isSoFar3Days!!! : YES (INCORRECT!!!)" );
        }
        else
            System.out.println( "isSoFar3Days!!! : NO! (CORRECT!!!)" );
        	*/
    	
    }
}
