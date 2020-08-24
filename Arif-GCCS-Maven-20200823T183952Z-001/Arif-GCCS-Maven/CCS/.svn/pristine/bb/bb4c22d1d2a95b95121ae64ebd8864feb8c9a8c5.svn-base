/**
 * CourierReceiptReport.java
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
public class CourierReceiptReport extends GenericReportServlet {
    
    /** Creates a new instance of PendingRecByCourierReport */
    public CourierReceiptReport() {
    }
    
    /**
     * Returns the input stream containing the XML to be used
     * on the Pending Receivables by Courier report generation
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
            cs=conn.prepareCall("BEGIN SP_COURIER_RECEIPT_REPORT(?,?,?,?); END;");
            cs.setString(1,request.getParameter("locationCd"));
            cs.setString(2,request.getParameter("employeeId"));
            cs.setString(3,request.getParameter("chkEmpId"));            
            cs.registerOutParameter(4,oracle.jdbc.OracleTypes.CLOB);            
            cs.execute();
            
            /*This code is to write the xml to a file. For debugging purposes*
            InputStream is=cs.getClob(4).getAsciiStream();
      	    BufferedInputStream bis=new BufferedInputStream(is,4000); 
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("courierReceiptReport.xml"));
            byte[] buffer=new byte[4000];
            int count=0;
            while ((count=bis.read(buffer))!=-1){                
                bos.write(buffer,0,count);                
            }
            bos.flush();  
            **/            
            return cs.getClob(4).getAsciiStream();
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
