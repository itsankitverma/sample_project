package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.common.monitoring.Monitoring;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 28, 2008
 * Time: 10:51:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class LogEventHelper {

    public static void logEvent(HttpServletRequest request, int eventType, String context, boolean status)
    {
        EmployeeProfile ep = getEmployeeProfile(request);

        Monitoring.event( eventType, ep.getEmployeeId(), context, status);
    }

    public static void logEvent(HttpServletRequest request, int eventType, String context, String param, boolean status)
    {
        EmployeeProfile ep = getEmployeeProfile(request);

        Monitoring.event( eventType, ep.getEmployeeId(), context, param, status);
    }

    public static void logEvent(HttpServletRequest request, int eventType, String context, String param1, String param2, boolean status)
    {
        EmployeeProfile ep = getEmployeeProfile(request);

        Monitoring.event( eventType, ep.getEmployeeId(), context, param1, param2, status);
    }

    private static EmployeeProfile getEmployeeProfile(HttpServletRequest request) 
    {
        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");

        return ep;
    }
}
