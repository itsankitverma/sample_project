package com.fedex.lacitd.cashcontrol.biztier.common;

import com.fedex.lacitd.cashcontrol.common.Utils;
import weblogic.logging.NonCatalogLogger;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Aug 13, 2008
 * Time: 11:40:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class NewLogger {

    NonCatalogLogger logger ;
    String tag;
    boolean stdout = false;


    public NewLogger(String tag)
    {
        this.logger = new NonCatalogLogger( tag);
        this.tag = tag;

        if("true".equals(System.getProperty("logToStdout")))
            stdout = true;
    }
    
    public void debug(String msg)
    {
        if(!stdout) logger.debug( msg);
        if(stdout)  System.out.println( tag + ": " + msg);
    }

    public void error(String msg)
    {
        if(!stdout) logger.error( msg);
        if(stdout)  System.out.println( tag + ": " + msg);
    }

    public void debug(String msg, Exception e)
    {
        if(!stdout) logger.debug( msg, e);
        if(stdout)  System.out.println( tag + ": " + msg + " - " + Utils.stackTraceToString(e));
    }
}
