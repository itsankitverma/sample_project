/*
 * PendingRecByCourierReport.java
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
public class PendingCODByCourierReport extends GenericReportServlet {
    
    /** Creates a new instance of PendingCODRecByCourierReport */
    public PendingCODByCourierReport() {
    }
    
    /**
     * Returns the input stream containing the XML to be used
     * on the Pending Receivables By Courier report generation
     *
     * @param     servlet request
     * @param     servlet response
     * @exception ServletException 
     */
    public InputStream getXMLInputStream(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        CallableStatement cs=null; 
        Connection conn=null;
        try{
        	
        	System.out.println("Inside try block in PendingCODByCourierReport.java");
        	
            InitialContext c=new InitialContext();
            DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);
            conn=ds.getConnection();
            cs=conn.prepareCall("BEGIN SP_PENDING_COD_BY_COUR_REPORT(?,?,?); END;");
            cs.setString(1,request.getParameter("courierId"));
            cs.setString(2,request.getParameter("locationCd"));
            cs.registerOutParameter(3,oracle.jdbc.OracleTypes.CLOB);            
            cs.execute();
            
            /*This code is to write the xml to a file. For debugging purposes*           
            InputStream is=cs.getClob(3).getAsciiStream();
      	    BufferedInputStream bis=new BufferedInputStream(is,4000); 
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("c:/data.xml"));
            byte[] buffer=new byte[4000];
            int count=0;
            while ((count=bis.read(buffer))!=-1){                
                bos.write(buffer,0,count);                
            }
            bos.flush();  
            **/            
            
            return cs.getClob(3).getAsciiStream();
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
