package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminTablesManagerForm;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;
import com.fedex.lacitd.cashcontrol.common.monitoring.Monitoring;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: paravena
 * Date: 23-mar-2005
 * Time: 11:58:11
 * To change this template use File | Settings | File Templates.
 */
public class RemoveAdminTableColumnsAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String tableName = ((AdminTablesManagerForm) form).getTableName();
        String[] columns = ((AdminTablesManagerForm) form).getColumns();
        AdminBizDelegate delegate = new AdminBizDelegate();
        for(int i=0;i < columns.length;i++) {
            delegate.removeAdminTableColumn(tableName,columns[i]);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "RemoveAdminTableColumnsAction removeAdminTableColumn() table: " + tableName,
                    columns[i], true);            
        }
        return mapping.findForward("Success");
    }
}
