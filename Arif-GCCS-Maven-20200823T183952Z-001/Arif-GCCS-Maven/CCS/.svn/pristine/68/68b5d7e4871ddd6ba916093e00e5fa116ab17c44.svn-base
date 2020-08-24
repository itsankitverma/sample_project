package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;
import java.util.Collection;
import javax.servlet.http.*;


public class AdminPrepaidAction extends Action {
    public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        String forward = "SearchPrepaid";
        String action = (String)request.getAttribute("action");
        if(action == null)
            action = request.getParameter("action");
        if("search".equals(action)) {
            Collection prepaids = searchPrepaid(form,request);
        }
        return mapping.findForward(forward);
    }

    private Collection searchPrepaid(ActionForm form, HttpServletRequest request) {
        Collection prepaids = null;
        return prepaids;
    }
}

