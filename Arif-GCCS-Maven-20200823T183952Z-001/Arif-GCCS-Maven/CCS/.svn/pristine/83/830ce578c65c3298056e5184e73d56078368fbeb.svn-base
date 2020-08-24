/*
 * OpenReceivablesReport.java
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
import com.fedex.lacitd.cashcontrol.datatier.controller.LocationController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO;

/**
 *
 * @author  ccardenas
 */
public class OpenReceivablesReport extends GenericReportServlet {
    
    /** Creates a new instance of PendingRecByCourierReport */
    public OpenReceivablesReport() {
    }
    
    /**
     * Returns the input stream containing the XML to be used
     * on the Open Receivables report generation
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

            System.out.println("##########################");
            System.out.println(" ds : " + Constants.CCSDataSource);
            System.out.println(" ds : " + ds.toString());
            System.out.println("##########################");

            String locationCd = request.getParameter("locationCd");

            LocationController locCtrl = new LocationController();
            LocationVO locationVO = locCtrl.getLocation(locationCd);

            if(locationVO.getHoldLocation()==1)
               cs=conn.prepareCall("BEGIN SP_OPEN_ROD_HOLD_STATION(?,?); END;");
            else
                cs=conn.prepareCall("BEGIN SP_OPEN_RECEIVABLES_REPORT(?,?); END;");

            cs.setString(1,locationCd);
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
