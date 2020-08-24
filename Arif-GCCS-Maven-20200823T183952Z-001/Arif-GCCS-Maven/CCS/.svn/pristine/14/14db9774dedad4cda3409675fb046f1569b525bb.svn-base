/*
 * PrepaidReconcReport.java
 *
 * Created on 11 de diciembre de 2002, 19:55
 */

package com.fedex.lacitd.cashcontrol.prestier.servlets.reporting;

import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
/**
 *
 * @author  ccardenas
 */
public class PrepaidReconcReport extends GenericReportServlet {
    
    /** Creates a new instance of PendingRecByCourierReport */
    public PrepaidReconcReport() {
    }
    
    /**
     * Returns the input stream containing the XML to be used
     * on the Prepaid Reconciliation report generation
     *
     * @param     servlet request
     * @param     servlet response
     * @exception ServletException 
     */
    public InputStream getXMLInputStream(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        CallableStatement cs=null; 
        Connection conn=null;
        try{
            InitialContext c=new InitialContext();
            DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);
            conn=ds.getConnection();
            cs=conn.prepareCall("BEGIN SP_PREPAID_RECONC_REPORT(?,?); END;");
            cs.setString(1,request.getParameter("locationCd"));
            cs.registerOutParameter(2,oracle.jdbc.OracleTypes.CLOB);            
            cs.execute();
            
            /*This code is to write the xml to a file. For debugging purposes*
            InputStream is=cs.getClob(2).getAsciiStream();
      	    BufferedInputStream bis=new BufferedInputStream(is,4000); 
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("c:/data1.xml"));
            byte[] buffer=new byte[4000];
            int count=0;
            while ((count=bis.read(buffer))!=-1){                
                bos.write(buffer,0,count);                
            }
            bos.flush();  
            **/            
            
            return cs.getClob(2).getAsciiStream();
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            throw new ServletException(e);
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
    }
    
    
}
