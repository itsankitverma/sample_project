/**
 * PaymentReceiveDataFeed.java
 *
 * Created on April 7, 2003, 5:05 PM
 *
 * @author  Arturo Gonzalez
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.io.*;
import java.text.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.Properties;
import javax.servlet.ServletContext;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.common.*;

import com.fedex.lacitd.common.gccsftp.FTPClient;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FTPException;


public class PaymentReceiveDataFeed {
    
    private Properties props       = null;
    private ServletContext context = null;
    
    /** Creates a new instance of PaymentReceiveDataFeed */
    public PaymentReceiveDataFeed(ServletContext context) {
        try{
            props=new Properties();
            props = Utils.getProperties("P");
        }catch(Exception ioe)
        { Constants.logger.debug("Exception: PaymentReceiveDataFeed() \n" + ioe.getMessage());
        }
    }
    
    public boolean getDataToXmlFile(Date recDate, String location, int eodId)
    {
        CallableStatement cs= null; 
        Connection  conn    = null;
        boolean     result  = false;
        String      XML     = null;
        try{
                InitialContext c=new InitialContext();
                DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);
                conn=ds.getConnection();
                cs=conn.prepareCall("BEGIN SP_DAILY_DATA_FEED_OUT(?,?,?,?); END;");
                cs.setDate(1,recDate);
                cs.setString(2,location);            
                cs.setInt(3,eodId); 
                cs.registerOutParameter(4,oracle.jdbc.OracleTypes.CLOB);            
                cs.execute();
                Clob clobObj=cs.getClob(4);
                
                
                InputStream is=cs.getClob(4).getAsciiStream();
                
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
               Constants.logger.debug(Utils.stackTraceToString(e));
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
            clt = new FTPClient(props.getProperty("dfout.ftpServer") );
            clt.login(props.getProperty("dfout.ftpUserName"),props.getProperty("dfout.ftpPwd"));
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");        
            String dateName       = sdf1.format(recDate);
            String fileName       = props.getProperty("dfout.xmlExport.dir") + "/" + location.toUpperCase() + eodId + "_" + dateName+".xml";
            
            clt.setType(FTPTransferType.ASCII);

            //Now transmit the xml stream to an xml file in the respective ftp site
            clt.put(XML.getBytes("UTF-8"),fileName);
   
           clt.quit(); // Quit the ftp site
        } catch(IOException e) {
            Constants.logger.debug("Error: sendFile() \n" + e.toString());
        } catch(FTPException eftp){
            Constants.logger.debug("Error: sendFile() \n" + eftp.toString());
        }
        return;
    }

    
    public static InitialContext getInitialContext()
	throws NamingException
	{
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		p.put(Context.PROVIDER_URL, url);

		if (user != null) {
			p.put(Context.SECURITY_PRINCIPAL, user);
			if (password == null)
                            password = "";
			p.put(Context.SECURITY_CREDENTIALS, password);
		}
		return new InitialContext(p);
	}
     
	static String url  = "t3://161.135.144.202:7001";
	static String user     = null;
	static String password = null;
	
}
