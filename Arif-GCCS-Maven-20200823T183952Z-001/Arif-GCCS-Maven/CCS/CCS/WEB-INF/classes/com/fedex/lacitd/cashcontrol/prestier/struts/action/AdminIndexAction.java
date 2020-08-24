package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import java.io.Serializable;
import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;
import com.fedex.lacitd.cashcontrol.common.monitoring.Monitoring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class if for checking if session is still valid before going pages that were without action
 * @author  Claudio Lazo
 */
public class AdminIndexAction extends Action implements Serializable {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        //Here is checks the Session to know if there is an userProfile to follow the workflow
        //If there is not an user Profile return to logout page
        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
        if(ep==null)
           return mapping.findForward("logout");

        String url = request.getRequestURL().toString();

        if(url.endsWith("/Admin/AdminIndex.do"))
            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "AdminIndexAction execute()", "/Admin/AdminIndex.do", true);

        return mapping.findForward("Success");
    }
}
