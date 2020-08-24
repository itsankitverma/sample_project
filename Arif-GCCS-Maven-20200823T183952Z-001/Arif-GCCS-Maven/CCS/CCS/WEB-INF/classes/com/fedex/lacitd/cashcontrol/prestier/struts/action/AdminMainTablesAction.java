package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.biztier.common.TablesAdminVO;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.common.monitoring.Monitoring;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;
import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateExpressionsUtil;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminMainTablesForm;

import org.apache.oro.text.perl.Perl5Util;
import org.apache.struts.action.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by Arturo Gonzalez
 * User: arturog
 * Date: 04-01-2005
 * Time: 03:30:05 PM
 */
public class AdminMainTablesAction extends Action implements Serializable
{
    AdminBizDelegate admBiz = new AdminBizDelegate();
    ActionErrors ae = new ActionErrors();
    private HashMap tableInfo = new HashMap();

    public AdminMainTablesAction ()
    {
    }

    public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        ActionForward forward = null;

        ae.clear(); //Clean errors collection

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

        if(ep == null)
        {
            return mapping.findForward("logout");
        }

        String action = (String) request.getParameter("action");

        //Constants.logger.debug("\n *** action = " + action);
        AdminMainTablesForm frm = (AdminMainTablesForm) form;
        ValidateExpressionsUtil util = ValidateExpressionsUtil.getInstance();
        frm.setInputPatterns(util.getProperties().getProperty("ForbiddenCharacters02.wl"));

        if(action.equals("data"))
        {
            forward = getDataInformation(mapping, form, request);
        }
        else if(action.equals("table"))
        {
            forward = getTableInformation(mapping, form, request);
        }
        else if(action.equals("update"))
        {
            forward = getDataToUpdate(mapping, form, request);
        }
        else if(action.equals("save"))
        {
            forward = saveData(mapping, form, request);
        }

        return forward;
    }
     //close execute

    private ActionForward getTableInformation (ActionMapping mapping, ActionForm form, HttpServletRequest request)
    {
        AdminMainTablesForm frm = (AdminMainTablesForm) form;

        String tableSelected = frm.getTableSelected();

        try
        {
            this.setTableInfo(admBiz.getAdminTableByTableName(tableSelected));

            //Constants.logger.debug("\n *** Table Selected = " + tableSelected);
            if(tableSelected != null)
            {
                frm.setColumnToSelect((Collection) getTableInfo().get("SELECT"));

                //Constants.logger.debug("\n *** Nro. col to select = " + frm.getColumnToSelect().size());
                frm.setColumnToUpdate((Collection) getTableInfo().get("UPDATE"));

                //Constants.logger.debug("\n *** Nro. col to update = " + frm.getColumnToUpdate().size());
                frm.setColumnToFilter((Collection) getTableInfo().get("FILTER"));

                //Constants.logger.debug("\n *** Nro. col to filter = " + frm.getColumnToFilter().size());
                frm.setTables((Collection) getTableInfo().get("TABLE_NAMES"));

                //Constants.logger.debug("\n *** Nro. tables to select  = " + frm.getTables().size());
                frm.setPrimaryKey((String) getTableInfo().get("PK"));
            }
            else
            {
                frm.setTables((Collection) getTableInfo().get("TABLE_NAMES"));

                //Constants.logger.debug("\n *** Nro. tables to select  = " + frm.getTables().size());
            }

            if(tableSelected != null)
            {
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "AdminMainTablesAction getTableInformation()", tableSelected, true);
            }
        }
        catch(Exception e)
        {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetTableInformation"));
            saveErrors(request, ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "AdminMainTablesAction getTableInformation()", tableSelected, false);
        }

        return mapping.findForward("ShowWindow");
    }

    private ActionForward getDataInformation (ActionMapping mapping, ActionForm form, HttpServletRequest request)
    {
        try
        {
            this.getTableInformation(mapping, form, request); //Fill the form

            AdminMainTablesForm frm = (AdminMainTablesForm) form;

            //Constants.logger.debug("\n\n trae conditions    =>  " + frm.getConditions().length);
            String sqlCondition = frm.getSqlCondition();
            String sql = null;
            String sqlColumns = "";
            String sqlCount = null;
            String orderBy = "";

            ArrayList columns = (ArrayList) frm.getColumnToSelect();
            int colNumber = columns.size();

            //Complete sql string for columns
            for(int i = 0; i < colNumber; i++)
            {
                sqlColumns = sqlColumns.concat((String) columns.get(i));

                if(i < (colNumber - 1))
                {
                    sqlColumns = sqlColumns + ",";
                }
            }

            //Constants.logger.debug("\n\n *** Veamos Columnas = " + sqlColumns + "****");
            //Constants.logger.debug("\n\n *** sqlCondition = " + sqlCondition + "****");
            sql = " SELECT Row_Number," + sqlColumns + " FROM (SELECT RowNum As Row_Number, " + sqlColumns + "       FROM " + frm.getTableSelected() +
                "       WHERE " + sqlCondition + ") " + " WHERE Row_Number BETWEEN ? AND ? ";

            //Now we're going to add the order by option
            if(!("none".equals(frm.getOrderByColumn1())))
            {
                orderBy = orderBy + frm.getOrderByColumn1() + " ASC,";
            }

            if(!("none".equals(frm.getOrderByColumn2())))
            {
                orderBy = orderBy + frm.getOrderByColumn2() + " ASC,";
            }

            if(!("none".equals(frm.getOrderByColumn3())))
            {
                orderBy = orderBy + frm.getOrderByColumn3() + " ASC";
            }

            //Add orderBy to teh SQL
            if(orderBy.length() > 0)
            {
                Perl5Util perl = new Perl5Util();
                orderBy = perl.substitute("s/,$//", orderBy);
                orderBy = " ORDER BY " + orderBy;
                sql = sql.concat(orderBy);
            }

            //Count to do the paging
            sqlCount = " SELECT COUNT(*) FROM " + frm.getTableSelected() + " WHERE " + sqlCondition;

            //Constants.logger.debug("\n *** Veamos SQL = " + sql);
            // Get parameter of page number to show
            int pageNumber = 0;
            int currentPageNumber = frm.getCurrentPageNumber();

            if(currentPageNumber == 0)
            {
                currentPageNumber = 1;
            }

            ArrayList dataToShow = (ArrayList) admBiz.getDataForTableAdmin(sql, frm.getTableSelected(), currentPageNumber, sqlCount);

            //Get pageNumber from collection of data, and remove it from collection
            pageNumber = ((Integer) dataToShow.get(dataToShow.size() - 1)).intValue();
            dataToShow.remove(dataToShow.size() - 1);

            frm.setPageNumber(pageNumber);

            //Constants.logger.debug("\n\n **** current page  :" + currentPageNumber);
            frm.setCurrentPageNumber(currentPageNumber);
            frm.setDataToShow(dataToShow);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "AdminMainTablesAction getDataInformation()",
                (sql != null) ? sql : frm.getTableSelected(), true);
        }
        catch(Exception e)
        {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetDataInformation"));
            saveErrors(request, ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "AdminMainTablesAction getDataInformation()", "", false);
        }

        return mapping.findForward("ShowWindow");
    }

    private ActionForward getDataToUpdate (ActionMapping mapping, ActionForm form, HttpServletRequest request)
    {
        AdminMainTablesForm frm = (AdminMainTablesForm) form;
        String pk = request.getParameter("pk");
        String table = request.getParameter("tableName");

        try
        {
            Collection row = admBiz.getRow(pk, table);
            frm.setTableSelected(table);
            frm.setColumnToUpdate(row);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminMainTablesAction getDataToUpdate()", table, true);
        }
        catch(Exception e)
        {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetDataInformation"));
            saveErrors(request, ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminMainTablesAction getDataToUpdate()", table, true);
        }

        return mapping.findForward("ShowUpdate");
    }

    private ActionForward saveData (ActionMapping mapping, ActionForm form, HttpServletRequest request)
    {
        ae = new ActionErrors();

        try
        {
            AdminMainTablesForm frm = (AdminMainTablesForm) form;
            HttpSession session = request.getSession();
            Collection row = (Collection) session.getAttribute("columnToUpdate");
            session.removeAttribute("columnToUpdate");

            //Constants.logger.debug("\n\n **** PK =" + frm.getPrimaryKey());
            ArrayList rowList = new ArrayList();

            TablesAdminVO col = null;
            String columnNewValue = null;

            //Get the field that are for update put into the rowList object
            Iterator itRow = row.iterator();

            while(itRow.hasNext())
            {
                col = (TablesAdminVO) itRow.next();

                if(col.isUpdate() || col.isPrimaryKey())
                {
                    rowList.add(col);
                }

                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminMainTablesAction saveData()", col.getTableName(), true);
            }

            //Iterate over the row to set the new values
            for(int j = 0; j < rowList.size(); j++)
            {
                col = (TablesAdminVO) rowList.get(j);
                columnNewValue = request.getParameter(col.getColumnName());
                //  code added by Sri Kalluri for replace  single quote
                columnNewValue = columnNewValue.replaceAll("'", " ");
                //col.setColumnValue(columnNewValue);

                //System.out.println("columnNewValue : " + columnNewValue);

                /* only the data intered by the user is validated 
                if(!validateInputData(columnNewValue))
                {
                    ae.add("conditionValue", new ActionError("wl.error.noValidCharsN", columnNewValue));
                } */
                
                col.setColumnValue(columnNewValue);
                rowList.set(j, col);
            }

            /* if some of the data entered by the user is not valid then we show the errors 
            if(ae.size() > 0)
            {
                saveErrors(request, ae);

                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminMainTablesAction saveData()", "", false);

                return getDataToUpdate(mapping, form, request);
            } */

            Iterator it = rowList.iterator();
            TablesAdminVO columnVO = null;
            boolean upd;

            while(it.hasNext())
            {
                columnVO = (TablesAdminVO) it.next();
                upd = columnVO.isUpdate();

                //Constants.logger.debug("\n\n **** column and update? <=>" + columnVO.getColumnName() + "<==>" + upd);
                //Constants.logger.debug("\n\n **** value <=>" + columnVO.getColumnValue());
            }

            admBiz.updateAdminMainTable(rowList);

            //Constants.logger.debug("\n\n Nro de columnas to update : => " + rowList.size());
        }
        catch(Exception e)
        {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveDataInformation"));
            saveErrors(request, ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminMainTablesAction saveData()", "", false);

            return getDataToUpdate(mapping, form, request);
        }

        //return getDataInformation(mapping,form,request);
        //request.setAttribute("submitParent","submitParent");
        return mapping.findForward("TableSaved");
    }
 /*
  * remove  validation for  comments
    private boolean validateInputData (String columnNewValue)
    {
        ValidateExpressionsUtil valUtil = ValidateExpressionsUtil.getInstance();

        String [] expressions = { "ForbiddenCharacters02.wl" };

        if(!valUtil.isValid(expressions, columnNewValue))
        {
            return false;
        }

        return true;
    }  */

    public HashMap getTableInfo ()
    {
        return tableInfo;
    }

    public void setTableInfo (Map map)
    {
        this.tableInfo = (HashMap) map;
    }
}
