package com.fedex.lacitd.cashcontrol.prestier.servlets.reporting;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * Created by IntelliJ IDEA.
 * User: vladimir
 * Date: Nov 30, 2006
 * Time: 11:55:37 AM
 * To change this template use File | Settings | File Templates.
 */


public class GroundPrepaidReport extends GenericReportServlet {

    /** Creates a new instance of GroundPrepaidReport */
    public GroundPrepaidReport() {
    }

    /**
     * Returns the input stream containing the XML to be used
     * on the Credit Payments report generation
     *
     * @param     servlet request
     * @param     servlet response
     * @exception javax.servlet.ServletException
     */
    public InputStream getXMLInputStream(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        CallableStatement cs=null;
        Connection conn=null;
        try{
            InitialContext c=new InitialContext();
            DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);
            conn=ds.getConnection();
            cs=conn.prepareCall("BEGIN SP_CREDIT_PAYMENTS_REPORT(?,?,?); END;");
            cs.setString(1,request.getParameter("locationCd"));
            cs.setString(2,request.getParameter("reportDate"));
            cs.registerOutParameter(3,oracle.jdbc.OracleTypes.CLOB);
            cs.execute();

            /*This code is to write the xml to a file. For debugging purposes*
            InputStream is=cs.getClob(3).getAsciiStream();
      	    BufferedInputStream bis=new BufferedInputStream(is,4000);
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("data.xml"));
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

