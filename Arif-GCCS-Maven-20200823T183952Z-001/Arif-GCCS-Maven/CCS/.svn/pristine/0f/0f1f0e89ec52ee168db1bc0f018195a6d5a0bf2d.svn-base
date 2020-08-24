package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminTablesManagerForm;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: paravena
 * Date: 23-mar-2005
 * Time: 11:58:11
 * To change this template use File | Settings | File Templates.
 */
public class AddAdminTableAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdminBizDelegate delegate = new AdminBizDelegate();
        Collection tables = delegate.getAllTables();
        request.setAttribute("tables",tables);
        return mapping.findForward("Success");
    }
}
