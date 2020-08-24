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

public class PaymentReceiveDataFeedAuxiliar {
    
    public static void main(String[] a){
        new PaymentReceiveDataFeedAuxiliar().getDataToXmlFileThin(new Date(System.currentTimeMillis()) ,"SAOA",23630);
        //new PaymentReceiveDataFeed().getDataToXmlFile(new Date(System.currentTimeMillis()) ,"BUEA",23766);
    }

    public boolean getDataToXmlFile(Date recDate, String location,int eodId)
    {
        CallableStatement cs= null; 
        Connection  conn    = null;
        boolean     result  = false;
        String      XML     = null;
        try{   /*
            Properties prop=new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		    prop.put(Context.PROVIDER_URL, "t3://161.135.40.171:9999");

                InitialContext c=new InitialContext(prop);
                DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);*/
                long before=System.currentTimeMillis();

            Clob clobObj=null;
            for (int i=0;i<10;i++) {
                Class.forName("oracle.jdbc.OracleDriver");
                conn=DriverManager.getConnection("jdbc:oracle:oci:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP) (HOST = oradb01.sadev.fedex.com)(PORT = 1521))) (CONNECT_DATA = (SERVICE_NAME = oradb01.sadev.fedex.com)))","ccs_report","fedexcc");

                cs=conn.prepareCall("BEGIN SP_DAILY_DATA_FEED_OUT(?,?,?,?); END;");
                cs.setDate(1,recDate);
                cs.setString(2,location);
                cs.setInt(3,eodId);
                cs.registerOutParameter(4,oracle.jdbc.OracleTypes.CLOB);
                cs.execute();
                clobObj = cs.getClob(4);


                InputStream is=cs.getClob(4).getAsciiStream();
            }

            System.out.println("OCI="+(System.currentTimeMillis()-before));

                //Convert to String the InputStream object that contains the xml data
                //BufferedReader d = new BufferedReader(new InputStreamReader(is));
                //XML = new String(new StringReader(
                
                
                /*BufferedInputStream bis =new BufferedInputStream(is,4000); 
                BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("c:/data.xml"));
                byte[] buffer=new byte[4000];
                int count=0;
                while ((count=bis.read(buffer))!=-1){                
                    bos.write(buffer,0,count);                
                }
                bos.flush();
                result = true;*/
 
                //Now send the xml to the ftp site
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
    
    
    public boolean getDataToXmlFileThin(Date recDate, String location,int eodId)
    {
        CallableStatement cs= null;
        Connection  conn    = null;
        boolean     result  = false;
        String      XML     = null;
        try{   /*
            Properties prop=new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		    prop.put(Context.PROVIDER_URL, "t3://161.135.40.171:9999");

                InitialContext c=new InitialContext(prop);
                DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);*/
                long before=System.currentTimeMillis();
            Clob clobObj=null;
        for (int i=0;i<10;i++) {
                Class.forName("oracle.jdbc.OracleDriver");
                //conn=DriverManager.getConnection("jdbc:oracle:thin:@oradb01.sadev.fedex.com:1521:oradb01","ccs_report","fedexcc");
                conn=DriverManager.getConnection("jdbc:oracle:thin:@161.135.40.170:1521:CCSMEMP","ccsuser","mystery");

                cs=conn.prepareCall("BEGIN SP_DAILY_DATA_FEED_OUT(?,?,?,?); END;");
                cs.setDate(1,recDate);
                cs.setString(2,location);
                cs.setInt(3,eodId);
                cs.registerOutParameter(4,oracle.jdbc.OracleTypes.CLOB);
                cs.execute();
                clobObj = cs.getClob(4);


                InputStream is=cs.getClob(4).getAsciiStream();
            }

            System.out.println("THIN="+(System.currentTimeMillis()-before));
                //Convert to String the InputStream object that contains the xml data
                //BufferedReader d = new BufferedReader(new InputStreamReader(is));
                //XML = new String(new StringReader(


                /*BufferedInputStream bis =new BufferedInputStream(is,4000);
                BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("c:/data.xml"));
                byte[] buffer=new byte[4000];
                int count=0;
                while ((count=bis.read(buffer))!=-1){
                    bos.write(buffer,0,count);
                }
                bos.flush();
                result = true;*/

                //Now send the xml to the ftp site
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
            clt = new FTPClient("sadev.fedex.com");
            clt.login("anonymous","dccs");
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");        
            String dateName       = sdf1.format(recDate);
            String fileName       = location.toUpperCase() + eodId + "_" + dateName+".xml";
            
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
