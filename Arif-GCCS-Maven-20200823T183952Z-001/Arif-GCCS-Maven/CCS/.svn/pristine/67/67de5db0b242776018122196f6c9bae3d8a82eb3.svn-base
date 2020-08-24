package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.actions.LookupDispatchAction;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by IntelliJ IDEA.
 * User: paravena
 * Date: 22-mar-2005
 * Time: 18:09:06
 * To change this template use File | Settings | File Templates.
 */
public class AdminTablesManagerDispatcherAction extends LookupDispatchAction {
        protected Map getKeyMethodMap() {
        Map map = new HashMap();
        map.put("app.messages.createTable", "createAdminTable");
        map.put("app.messages.saveTable", "updateAdminTable");
        map.put("app.messages.removeTable", "removeAdminTable");            
        map.put("app.messages.addColumn", "addColumn");
        map.put("app.messages.removeColumn", "removeColumn");
        map.put("app.messages.createColumn","createColumn");
        return map;
    }

    public ActionForward createAdminTable(ActionMapping mapping,  ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("CreateAdminTable");
    }

    public ActionForward updateAdminTable(ActionMapping mapping,  ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("UpdateAdminTable");
    }

    public ActionForward removeAdminTable(ActionMapping mapping,  ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("RemoveAdminTable");
    }

    public ActionForward addColumn(ActionMapping mapping,  ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("AddColumn");
    }

    public ActionForward removeColumn(ActionMapping mapping,  ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("RemoveColumn");
    }

    public ActionForward createColumn(ActionMapping mapping,  ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("CreateColumn");
    }
}