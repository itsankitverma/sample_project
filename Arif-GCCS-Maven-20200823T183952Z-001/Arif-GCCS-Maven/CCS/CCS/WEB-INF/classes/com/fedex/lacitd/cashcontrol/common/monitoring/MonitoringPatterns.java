package com.fedex.lacitd.cashcontrol.common.monitoring;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 25, 2008
 * Time: 7:06:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringPatterns {

    private static ResourceBundle p = initPatterns();

    private static ResourceBundle initPatterns()
    {
        return PropertyResourceBundle.getBundle("com.fedex.lacitd.cashcontrol.common.monitoring.MonitoringPatterns");
    }

    public static String getMessage(String key)
    {
        try
        {
            return p.getString( key);
        }
        catch(Exception e)
        {
            return key;
        }
    }
}
