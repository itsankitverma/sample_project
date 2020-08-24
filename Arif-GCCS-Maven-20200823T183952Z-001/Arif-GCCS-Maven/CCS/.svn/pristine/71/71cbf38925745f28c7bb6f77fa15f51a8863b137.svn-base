package com.fedex.lacitd.cashcontrol.common.monitoring;

import com.fedex.lacitd.cashcontrol.common.monitoring.MonitoringPatterns;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 23, 2008
 * Time: 12:18:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringServiceImp implements MonitoringService {

    private static Logger logger;

    protected MonitoringServiceImp()
    {
        setConfiguration();
    }

    /**
     * setConfiguration
     * <p/>
     * Sets the configuration for the log4j..
     */
    private void setConfiguration() {
        try {
            URL searchPathURL = this.getClass().
                    getClassLoader().getResource("com/fedex/lacitd/cashcontrol/common/monitoring/logger.xml");

            DOMConfigurator.configure(searchPathURL);

            logger = Logger.getLogger( "MONITORING-EVENT");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void event(int eventType, String userid, String context, String param1, String param2, boolean status)
    {
        logger.info(
        "Monitoring Event: " + getEventDescription(eventType) + "(" + eventType + ")" + "\t" +
        "UserId: " + userid + "\t" +
        "Context: " + context + "\t" +
        "Action performed: " + makeMessage( getEventMessage( eventType), param1, param2) + "\t" +
        "Status: " + ((status)?"Success":"Failure"));
    }

    public void event(int eventType, String userid, String context, String param1, boolean status)
    {
        logger.info(
        "Monitoring Event: " + getEventDescription(eventType) + "(" + eventType + ")" + "\t" +
        "UserId: " + userid + "\t" +
        "Context: " + context + "\t" +
        "Action performed: " + makeMessage( getEventMessage( eventType), param1) + "\t" +
        "Status: " + ((status)?"Success":"Failure"));
    }

    public void event(int eventType, String userid, String context, boolean status)
    {
        logger.info(
        "Monitoring Event: " + getEventDescription(eventType) + "(" + eventType + ")" + "\t" +
        "UserId: " + userid + "\t" +
        "Context: " + context + "\t" +
        "Action performed: " + makeMessage( getEventMessage( eventType), null) + "\t" +
        "Status: " + ((status)?"Success":"Failure"));
    }

    public String makeMessage(String msg, String param1)
    {
        return makeMessage( msg, param1, null);
    }
    
    public String makeMessage(String msg, String param1, String param2)
    {
        if(msg.indexOf("%1")>1 && param1 != null)
          msg = msg.replaceFirst( "%1", param1);

        if(msg.indexOf("%2")>1 && param2 != null)
          msg = msg.replaceFirst( "%2", param2);

        return msg;
    }

    public String getEventDescription(int eventType)
    {
        switch(eventType)
        {
            case Monitoring.MONITORING_EVENT_INSERT:
                return MonitoringPatterns.getMessage( "app.monitoring.messages.insert.title");

            case Monitoring.MONITORING_EVENT_DELETE:
                return MonitoringPatterns.getMessage("app.monitoring.messages.delete.title");

            case Monitoring.MONITORING_EVENT_UPDATE:
                return MonitoringPatterns.getMessage("app.monitoring.messages.update.title");

            case Monitoring.MONITORING_EVENT_READ:
                return MonitoringPatterns.getMessage("app.monitoring.messages.read.title");

            case Monitoring.MONITORING_EVENT_REVOKE:
                return MonitoringPatterns.getMessage("app.monitoring.messages.revoke.title");

            case Monitoring.MONITORING_EVENT_GRANT:            
                return MonitoringPatterns.getMessage("app.monitoring.messages.grant.title");

            default:
                return "unknown event ";
        }
    }

    public String getEventMessage(int eventType)
    {
        switch(eventType)
        {
            case Monitoring.MONITORING_EVENT_INSERT:
                return MonitoringPatterns.getMessage( "app.monitoring.messages.insert.message");

            case Monitoring.MONITORING_EVENT_DELETE:
                return MonitoringPatterns.getMessage("app.monitoring.messages.delete.message");

            case Monitoring.MONITORING_EVENT_UPDATE:
                return MonitoringPatterns.getMessage("app.monitoring.messages.update.message");

            case Monitoring.MONITORING_EVENT_READ:
                return MonitoringPatterns.getMessage("app.monitoring.messages.read.message");

            case Monitoring.MONITORING_EVENT_REVOKE:
                return MonitoringPatterns.getMessage("app.monitoring.messages.revoke.message");

            case Monitoring.MONITORING_EVENT_GRANT:
                return MonitoringPatterns.getMessage("app.monitoring.messages.grant.message");

            default:
                return "unknown event %1 ";
        }
    }
}
