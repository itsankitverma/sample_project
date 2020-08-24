package com.fedex.lacitd.cashcontrol.common.monitoring;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 24, 2008
 * Time: 1:36:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Monitoring {

    // modifications on any objects
    public static final int MONITORING_EVENT_INSERT = 1;
    public static final int MONITORING_EVENT_DELETE = 2;
    public static final int MONITORING_EVENT_UPDATE = 3;
    public static final int MONITORING_EVENT_READ = 4;

    // permission on any objects
    public static final int MONITORING_EVENT_REVOKE = 5;
    public static final int MONITORING_EVENT_GRANT = 6;


    private static MonitoringService service = new MonitoringServiceImp();

    public static void event(int eventType, String userid, String context, boolean status)
    {
        service.event( eventType, userid, context, status);
    }

    public static void event(int eventType, String userid, String context, String param1, boolean status)
    {
        service.event( eventType, userid, context, param1, status);
    }

    public static void event(int eventType, String userid, String context, String param1, String param2, boolean status)
    {
        service.event( eventType, userid, context, param1, param2, status);
    }
}
