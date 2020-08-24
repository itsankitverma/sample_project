/* <P>
 * This software is the confidential and proprietary information of FedEx Inc.
 * (Confidential Information). You shall not disclose such confidential
 * information and shall use it only in accordance with the terms of the
 * license agreement you entered into with FedEx.
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;
import java.util.Hashtable ;
import java.util.Properties ;
import javax.jms.Session ;
import javax.jms.Connection ;
import javax.jms.MessageProducer ;
import java.io.File ;
import java.io.FileInputStream ;
import java.io.IOException ;
import java.io.FileNotFoundException ;

import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.common.j2ee.mcd.MCD ;

import java.io.File;

public class AppInit
{
  private static Properties configProp = null ;
  private static Properties errorProp = null ;
  private static Properties sqlProp = null ;
  private static Properties securityProp = null ;
  private static Properties surchargeProp=null;
 // private static Properties serviceProp=null;
  private static Properties mcdProp=null;
  private static Properties descriptionProp=null;
  private static Hashtable jmsSessionMap = null ;
  private static Hashtable jmsProducerMap = null ;
  private static Hashtable jmsConnectionMap = null ;
 // public static McDUtils mcdUtil = null ;
  private static boolean mcdFailed = false ;
  private static boolean mcdStarted = false ;
 
  /*--------------------------------------------------------------------------------------------------*/  
 /* public static McDUtils getMcDUtil() {
      if (mcdUtil == null)
          return mcdUtil = new McDUtils();
      else
          return mcdUtil ;
  }*/
  
 
  /*--------------------------------------------------------------------------------------------------*/
  public static void startMcd() {
      
      if (mcdStarted)
          return ;
      Properties prop=null;
      String host = null;
      String port = null;
      //String host = "wcc2tsmcd.rmtc.fedex.com" ;
      //String host = "wccprdmcd.prod.fedex.com" ;
      //String port = "9968" ;
      try {
    	  prop= Utils.getProperties("P");
    	  
    	  host = prop.getProperty("mcd.url");
    	  port = prop.getProperty("mcd.port");
    	  
          MCD.start(host,	// probably from some configuration
              Integer.parseInt(port),	//  ''
              null	// get this from WLS or use NULL if N/A
              );        
      } catch (InterruptedException ee) {
          //AppLogger.error("Can not start MCD", ee); // do not throw the exception after that
          System.out.println("Can not start MCD");
          mcdFailed = true ;
      } catch (Exception e) {
          //AppLogger.error("Can not start MCD", e); // do not throw the exception after that
    	  System.out.println("Can not start MCD");
          mcdFailed = true ;
   }
      mcdStarted = true ;
     // if (AppLogger.isDebugEnabled())
     //     AppLogger.debug ("Started McD") ;
  }
  /*--------------------------------------------------------------------------------------------------*/
  /* public static void stopMcd() {
      try {
          MCD.stop() ;
      } catch (InterruptedException ee) {
          AppLogger.error("Can not stop MCD", ee); // do not throw the exception after that
      } catch (Exception e) {
          AppLogger.error("Can not stop MCD", e); // do not throw the exception after that
   }
      mcdStarted = false ;
      if (AppLogger.isDebugEnabled())
          AppLogger.debug ("Stopped McD") ;
  }*/
   
 /*--------------------------------------------------------------------------------------------------*/
  /* public static boolean isMcDAvilable ()
   {
       if (mcdUtil == null || mcdFailed)
           return false ;
       else
           return true ;
   }*/
 /*--------------------------------------------------------------------------------------------------*/
  public static String getSurcharge(String key)
  {
	return surchargeProp.getProperty(key);  
  }
/*--------------------------------------------------------------------------------------------------*/
  public static String getDescription(String key)
  {
	return descriptionProp.getProperty(key);  
  }
///*--------------------------------------------------------------------------------------------------*/
//  public static String getService(String key)
//  {
//	return serviceProp.getProperty(key);  
//  }
//  /*--------------------------------------------------------------------------------------------------*/  
  public static String getProperty (String key)
  {
    return configProp.getProperty (key) ;
  }

  /*--------------------------------------------------------------------------------------------------*/  
  public static String getErrorMessage (String key)
  {
    return errorProp.getProperty (key) ;
  }
  /*--------------------------------------------------------------------------------------------------*/
  
  public static String getErrorType(String key)
  {
	   return errorProp.getProperty (key);
  }

  /*--------------------------------------------------------------------------------------------------*/  
  public static String getSQL (String key)
  {
    return sqlProp.getProperty (key) ;
  }
  
  /*--------------------------------------------------------------------------------------------------*/  
  public static String getAuthGroup (String key)
  {
    return securityProp.getProperty (key) ;
  }

  /*--------------------------------------------------------------------------------------------------*/  
  public static String getMcDHost (String key)
  {
    return mcdProp.getProperty (key) ;
  }
  
  /*--------------------------------------------------------------------------------------------------*/  
  public static String getMcDPort (String key)
  {
    return mcdProp.getProperty (key) ;
  }
  
  /*--------------------------------------------------------------------------------------------------*/  
  public static void setJmsSession (String key, Session session)
  {
    jmsSessionMap.put (key, session) ;
  }

  /*--------------------------------------------------------------------------------------------------*/  
  public static Session getJmsSession (String key)
  {
    return (Session) jmsSessionMap.get (key) ;
  }

  /*--------------------------------------------------------------------------------------------------*/  
  public static void setJmsProducer (String key, MessageProducer messageProducer)
  {
    jmsProducerMap.put (key, messageProducer) ;
  }

  /*--------------------------------------------------------------------------------------------------*/  
  public static MessageProducer getJmsProducer (String key)
  {
    return (MessageProducer) jmsProducerMap.get (key) ;
  }

  /*--------------------------------------------------------------------------------------------------*/  
  public static void setJmsConnection (String key, Connection connection)
  {
    jmsConnectionMap.put (key, connection) ;
  }

  /*--------------------------------------------------------------------------------------------------*/  
  public static Connection getJmsConnection (String key)
  {
    return (Connection) jmsConnectionMap.get (key) ;
  }  
  
  public static String getHostname()
	{
		String host = "unknown";
		try {
			host = java.net.InetAddress.getLocalHost().getHostName();
			int pos = host.indexOf('.');
		} catch (Exception ex) {
		}
		return host;
	}
}