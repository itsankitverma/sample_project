package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.util.MessageResources;
import org.apache.struts.action.Action;
import org.apache.struts.Globals;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;


/**
 * Created by Arturo Gonzalez.
 * User: arturog
 * Date: 30-12-2004
 * Time: 04:23:23 PM
 */
public class AdminTablesManagerForm extends ActionForm implements Serializable {
    private String tableName;
    private String method;
    private String[] columns;
    private String columnName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        MessageResources resources = (MessageResources) servlet.getServletContext().getAttribute(Globals.MESSAGES_KEY);
        ActionErrors errors = new ActionErrors();
        if(method.equals(resources.getMessage("app.messages.removeTable"))) {
            if(tableName == null || "0".equals(tableName))
                errors.add("tableName", new ActionError("errors.messages.select.required",resources.getMessage("app.messages.label.Table")));
        }
        else if(method.equals(resources.getMessage("app.messages.createTable"))) {
            if(tableName == null || "0".equals(tableName))
                errors.add("tableName", new ActionError("errors.messages.select.required",resources.getMessage("app.messages.label.Table")));
        }
        else if(method.equals(resources.getMessage("app.messages.createColumn"))) {
            if(columnName == null || "0".equals(columnName))
                errors.add("columnName", new ActionError("errors.messages.select.required",resources.getMessage("app.messages.label.Column")));
        }
        else if(method.equals(resources.getMessage("app.messages.removeColumn"))) {
            if(columns == null || (columns != null && columns.length == 0))
                errors.add("columnName", new ActionError("errors.messages.select.required",resources.getMessage("app.messages.label.Column")));
        }
        return errors;
    }
}

