/*
 * LoadInvoicesAction.java
 *
 * Created on 16 de julio de 2002, 04:57 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.common.*;
import java.util.*;

/**
 *
 * @author  ccardenas
 */
public class LoadInvoicesAction extends Action implements java.io.Serializable{
    public LoadInvoicesAction() {
    }
    
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");   
            if(ep==null) return mapping.findForward("logout");
            RODBizDelegate biz=new RODBizDelegate();
            biz.loadInvoices(getInvoices(ep.getLocationCd()));
            request.setAttribute("message","The invoices were imported succesfully.");
            return mapping.findForward("Success");        
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            request.setAttribute("message","There was an error importing the invoices.");
            return mapping.findForward("Success");        
       }
    }
    
    
    private Collection getInvoices(String locationCd) throws Exception{/*
        try{
            JData2_0.sql.$Driver a;
            Driver drv = (Driver) Class.forName("JData2_0.sql.$Driver").newInstance();
            Connection c =DriverManager.getConnection("JData2_0.sql.$Driver","","");
            
            PreparedStatement s = c.prepareStatement("SELECT *, 710 as EXCH_RATE FROM SMMFCTA");
            ResultSet rs = s.executeQuery();                        
            Integer mtnPK=null;
            
            Collection colRec=new ArrayList();
            while (rs.next()) {
                ReceivablesVO recVO=new ReceivablesVO();
                recVO.setAwbNbr(rs.getString("PROCTA"));
                recVO.setRecNbr(rs.getString("NUMCTA"));
                recVO.setRecDt(rs.getDate("FECCTA"));
                recVO.setCustomerNm(rs.getString("CORCTA"));
                recVO.setRecAmt(rs.getFloat("DEBCTA"));
                recVO.setEmployeeId("000000");
                recVO.setLocationCd(locationCd);
                recVO.setStatusId(0);
                recVO.setExchRateClnUsed(rs.getFloat("EXCH_RATE"));
                recVO.setInvCurrency("CHP");
                
                colRec.add(recVO);
                
            }
            
            return colRec;
        }catch(Exception e){
               Constants.logger.debug(Utils.stackTraceToString(e));
               throw new Exception("errors.CouldNotImportInvoices");
        }   */
        return new ArrayList();
     }
    
    
    
}