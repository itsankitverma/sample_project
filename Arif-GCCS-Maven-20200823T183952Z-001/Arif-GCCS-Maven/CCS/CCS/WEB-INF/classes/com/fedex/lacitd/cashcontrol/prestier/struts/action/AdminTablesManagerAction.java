package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminTablesManagerForm;
import com.fedex.lacitd.cashcontrol.common.Utils;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: paravena
 * Date: 23-mar-2005
 * Time: 11:58:11
 * To change this template use File | Settings | File Templates.
 */
public class AdminTablesManagerAction extends Action {

    ActionErrors ae   = new ActionErrors();

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ae.clear();
        
        try
        {
            AdminTablesManagerForm frm = (AdminTablesManagerForm) form;
            AdminBizDelegate delegate = new AdminBizDelegate();
            Collection tables = delegate.getAllAdminTables();

            if(frm.getTableName() != null && !"0".equals(frm.getTableName())) {
                Collection columns = delegate.getColumnsOfAdminTable(frm.getTableName());
                request.setAttribute("columns",columns);
            }
            request.setAttribute("tables",tables);
            return mapping.findForward("Success");
        }
        catch(Exception e)
        {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetTableInformation"));
            saveErrors(request, ae);

            return mapping.findForward("Success");            
        }
    }
}
