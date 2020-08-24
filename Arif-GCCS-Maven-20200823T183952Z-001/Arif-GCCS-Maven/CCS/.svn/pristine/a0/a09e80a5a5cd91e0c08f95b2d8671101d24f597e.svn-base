package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.RODBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CommonOpsBizDelegate;
import com.fedex.lacitd.cashcontrol.common.Utils;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Properties;

/**
 * This class is used to manage the
 * request for GCCSReport
 * @author  clazo
 */
public class GCCSReportAction extends Action implements java.io.Serializable{
    public GCCSReportAction() {
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

        Properties prop        = null;
        ActionErrors ae        = new ActionErrors();
        String GCCSReportURL   = null;

        try{
            prop= Utils.getProperties("P");
            GCCSReportURL = prop.getProperty("gccsreport.server.url");
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            e.printStackTrace();
        }

        Constants.logger.debug("\n GCCSReportURL: " + GCCSReportURL);

        if(GCCSReportURL!=null)
            response.sendRedirect(GCCSReportURL);
        else {
            ae.add(ActionErrors.GLOBAL_ERROR ,new ActionError("errors.messages.CouldNotGetDataFromDB"));
    	    saveErrors(request, ae);
        }

        Constants.logger.debug("Failure.");

        return mapping.findForward("Failure");
    }
}
