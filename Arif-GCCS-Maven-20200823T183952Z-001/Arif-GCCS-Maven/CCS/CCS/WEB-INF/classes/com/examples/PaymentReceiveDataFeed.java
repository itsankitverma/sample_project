/**
 * PaymentReceiveDataFeed.java
 *
 * Created on April 7, 2003, 5:05 PM
 *
 * @author  Arturo Gonzalez
 */

package com.examples;

import com.fedex.lacitd.common.gccsftp.FTPClient;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;

import java.io.*;
import java.text.*;
import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class PaymentReceiveDataFeed {

    public static void main(String[] a) throws Exception{
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        
        new PaymentReceiveDataFeed().getDataToXmlFile(new Date(sdf1.parse("20080219").getTime()),"SCLC",208012);
        new PaymentReceiveDataFeed().getDataToXmlFile(new Date(sdf1.parse("20080219").getTime()),"SCLC",208014);
        new PaymentReceiveDataFeed().getDataToXmlFile(new Date(sdf1.parse("20080220").getTime()),"SCLC",208350);
        new PaymentReceiveDataFeed().getDataToXmlFile(new Date(sdf1.parse("20080221").getTime()),"SCLC",208635);
        new PaymentReceiveDataFeed().getDataToXmlFile(new Date(sdf1.parse("20080223").getTime()),"SCLC",209080);
        

    }

    public boolean getDataToXmlFile(Date recDate, String location,int eodId)
    {
        CallableStatement cs= null;
        Connection  conn    = null;
        boolean     result  = false;
        String      XML     = null;
        try{

            Clob clobObj=null;
            Properties prop=new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            prop.put(Context.PROVIDER_URL, "t3://gccsapp.prod.fedex.com:9999");

            InitialContext c=new InitialContext(prop);
           // InitialContext c=new InitialContext();
            DataSource ds=(DataSource)c.lookup(com.fedex.lacitd.cashcontrol.biztier.common.Constants.CCSDataSource);
            conn=ds.getConnection();


                cs=conn.prepareCall("BEGIN SP_DAILY_DATA_FEED_OUT(?,?,?,?); END;");
                cs.setDate(1,recDate);
                cs.setString(2,location);
                cs.setInt(3,eodId);
                cs.registerOutParameter(4,oracle.jdbc.OracleTypes.CLOB);
                cs.execute();
                clobObj = cs.getClob(4);


                InputStream is=cs.getClob(4).getAsciiStream();


                sendFeedOutFile(clobObj.getSubString(1,(int)clobObj.length()), recDate, location,eodId);

                result=true;
        }catch(Exception e){
               System.out.println(e);
        }finally{
              try{
                    if (cs!=null) cs.close();
              }catch(Exception e){}

              try{
                    if (conn!=null) conn.close();
               }catch(Exception e){}

              cs=null;
              conn=null;
         }
        return result;
    }//close the nmethod getDataToXmlFile()

    /**
     * This method send the xml stream to the respective ftp site
     */
    private void sendFeedOutFile(String XML, Date recDate, String location,int eodId){
       FTPClient clt = null;

       try {
            clt = new FTPClient("161.135.144.206");
            clt.login("test_sftpuser","test_sftpuser");

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
            String dateName       = sdf1.format(recDate);
            String fileName       = "data-feed-out" + "/" + location.toUpperCase() + eodId + "_" + dateName+".xml";

            clt.setType(FTPTransferType.ASCII);
            //Now transmit the xml stream to an xml file in the respective ftp site
            clt.put(XML.getBytes("UTF-8"),fileName);

           clt.quit(); // Quit the ftp site
        } catch(IOException e) {
             System.out.println(e);
        } catch(FTPException eftp){
            System.out.println(eftp);
        }
        return;
    }

}
