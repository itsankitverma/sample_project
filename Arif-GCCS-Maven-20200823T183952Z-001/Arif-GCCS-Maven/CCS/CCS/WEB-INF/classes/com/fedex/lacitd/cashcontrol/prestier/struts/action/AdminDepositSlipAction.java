package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import java.util.*;
import org.apache.struts.action.*;

import javax.servlet.http.*;

public class AdminDepositSlipAction extends Action implements java.io.Serializable {
    public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        String forward = "SearchDepositSlip";
        String action = (String)request.getAttribute("action");
        if(action == null)
            action = request.getParameter("action");
        if("search".equals(action)) {
            Collection depositSlips = searchDepositSlips(form,request);
        }
        return mapping.findForward(forward);
    }

    private Collection searchDepositSlips(ActionForm form, HttpServletRequest request) {
        Collection depositSlips = null;
        return depositSlips;
    }
}