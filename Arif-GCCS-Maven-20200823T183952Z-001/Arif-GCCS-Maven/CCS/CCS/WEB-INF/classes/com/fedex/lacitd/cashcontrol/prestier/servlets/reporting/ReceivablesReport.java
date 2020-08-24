/*
 * CreditPaymentsReport.java
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
public class ReceivablesReport extends GenericReportServlet {
    
    /** Creates a new instance of PendingRecByCourierReport */
    public ReceivablesReport() {
    }
    
    public InputStream getXMLInputStream(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        CallableStatement cs=null; 
        Connection conn=null;
        try{
            InitialContext c=new InitialContext();
            DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);
            conn=ds.getConnection();
            cs=conn.prepareCall("BEGIN SP_RECEIVABLES_REPORT(?,?); END;");
            cs.setString(1,request.getParameter("locationCd"));
            cs.registerOutParameter(2,oracle.jdbc.OracleTypes.CLOB);
            cs.execute();
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
