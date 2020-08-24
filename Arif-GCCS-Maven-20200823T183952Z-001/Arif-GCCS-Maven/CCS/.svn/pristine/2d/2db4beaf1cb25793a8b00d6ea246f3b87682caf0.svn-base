/*
 * CreateReportsAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import org.apache.struts.action.*;
import java.util.*;

/**
 * This class is used to manage the
 * request for the ReportSelector page
 * @author  ccardenas
 */
public class FTC_CreateReportsAction extends Action implements java.io.Serializable{
    public FTC_CreateReportsAction() {
    }
    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done. It has the code to provide all the information
     * to the ReportSelector Page.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */	
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
        
        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
        FTCBizDelegate biz=new FTCBizDelegate();
        CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();

        Collection colCouriers=biz.getCouriersWithPendents(ep.getLocationCd());
        Collection colEntities=null;

        if(ep.isAdmin()){
            colEntities = bizComm.getEntities();
        }
        else if(ep.getEmployeeRole()!=null && ep.getEmployeeRole().get("Research")!=null){
            colEntities = bizComm.getEntities(ep.getEmployeeId());
        }
        else
            colEntities = new ArrayList();

        request.setAttribute("colCouriers",colCouriers);
        request.setAttribute("entities",colEntities);
        return mapping.findForward("SelectReport");
    }
}

