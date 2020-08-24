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

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: paravena
 * Date: 23-mar-2005
 * Time: 11:58:11
 * To change this template use File | Settings | File Templates.
 */
public class UpdateAdminTableAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String tableName = ((AdminTablesManagerForm) form).getTableName();
        AdminBizDelegate delegate = new AdminBizDelegate();
        Collection columns = delegate.getColumnsOfAdminTable(tableName);
        Iterator it = columns.iterator();
        while(it.hasNext()) {
            Hashtable row = (Hashtable) it.next();
            String column = row.get("COL_NM").toString();
            if(request.getParameter(tableName+";"+column+";SEL_FLG") != null)
                delegate.updateAdminTableColumn(tableName,column,"SEL_FLG","1");
            else
                delegate.updateAdminTableColumn(tableName,column,"SEL_FLG","0");

            if(request.getParameter(tableName+";"+column+";UPD_FLG") != null)
                delegate.updateAdminTableColumn(tableName,column,"UPD_FLG","1");
            else
                delegate.updateAdminTableColumn(tableName,column,"UPD_FLG","0");

            if(request.getParameter(tableName+";"+column+";SRCH_FLG") != null)
                delegate.updateAdminTableColumn(tableName,column,"SRCH_FLG","1");
            else
                delegate.updateAdminTableColumn(tableName,column,"SRCH_FLG","0");

            if(request.getParameter(tableName+";"+column+";PRIM_KEY_FLG") != null)
                delegate.updateAdminTableColumn(tableName,column,"PRIM_KEY_FLG","1");
            else
                delegate.updateAdminTableColumn(tableName,column,"PRIM_KEY_FLG","0");
        }
        return mapping.findForward("Success");
    }
}
