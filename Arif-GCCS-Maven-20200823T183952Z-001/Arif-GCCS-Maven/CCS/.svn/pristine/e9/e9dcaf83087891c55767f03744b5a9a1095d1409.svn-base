package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateExpressionsUtil;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;


/**
 * Created by Arturo Gonzalez.
 * User: arturog
 * Date: 30-12-2004
 * Time: 04:23:23 PM
 */
public class AdminMainTablesForm extends ActionForm implements Serializable{

    private Collection tables;
    private Collection columnToSelect;
    private Collection columnToUpdate;
    private Collection columnToFilter;
    private Collection dataToShow;
    private String sqlCondition;
    private String tableSelected;
    private String columnSelected;
    private String primaryKey;
    private String[] conditions;
    private int currentPageNumber;
    private int pageNumber;
    private String orderByColumn1;
    private String orderByColumn2;
    private String orderByColumn3;
    private String conditionValue;
    private String inputPatterns;

    public Collection getTables() {
        return tables;
    }

    public void setTables(Collection tables) {
        this.tables = tables;
    }

    public Collection getColumnToSelect() {
        return columnToSelect;
    }

    public void setColumnToSelect(Collection columnToSelect) {
        this.columnToSelect = columnToSelect;
    }

    public Collection getColumnToUpdate() {
        return columnToUpdate;
    }

    public void setColumnToUpdate(Collection columnToUpdate) {
        this.columnToUpdate = columnToUpdate;
    }

    public Collection getColumnToFilter() {
        return columnToFilter;
    }

    public void setColumnToFilter(Collection columnToFilter) {
        this.columnToFilter = columnToFilter;
    }

    public Collection getDataToShow() {
        return dataToShow;
    }

    public void setDataToShow(Collection dataToShow) {
        this.dataToShow = dataToShow;
    }

    public String getSqlCondition() {
        return sqlCondition;
    }

    public void setSqlCondition(String sqlCondition) {
        this.sqlCondition = sqlCondition;
    }

    public String getTableSelected() {
        return tableSelected;
    }

    public void setTableSelected(String tableSelected) {
        this.tableSelected = tableSelected;
    }

    public String getColumnSelected() {
        return columnSelected;
    }

    public void setColumnSelected(String columnSelected) {
        this.columnSelected = columnSelected;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String[] getConditions() {
        return conditions;
    }

    public void setConditions(String[] conditions) {
        this.conditions = conditions;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public String getOrderByColumn1() {
        return orderByColumn1;
    }

    public void setOrderByColumn1(String orderByColumn1) {
        this.orderByColumn1 = orderByColumn1;
    }

    public String getOrderByColumn2() {
        return orderByColumn2;
    }

    public void setOrderByColumn2(String orderByColumn2) {
        this.orderByColumn2 = orderByColumn2;
    }

    public String getOrderByColumn3() {
        return orderByColumn3;
    }

    public void setOrderByColumn3(String orderByColumn3) {
        this.orderByColumn3 = orderByColumn3;
    }

    /**
     * Validate form values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request being processed
    */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request)
    {

       ActionErrors errors = super.validate(mapping, request);
       String action = (String)request.getParameter("action");
       String URI = ((HttpServletRequest)request).getRequestURI();
       if (action.equals("data"))
       {
           ValidateExpressionsUtil valUtil = ValidateExpressionsUtil.getInstance();

           if (errors == null) errors = new ActionErrors();

           //String expressions[] = {"ForbiddenCharacters02.wl"};
           //errors = ValidateInputValues( valUtil, expressions, this.getInputValues());

           String expressions2[] = {"TableName.wl"};
           if(errors.isEmpty() && !valUtil.isValid(expressions2,this.getTableSelected()))
                    errors.add("conditionValue",new ActionError("wl.error.noValidChars"));
       }
       return errors;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    public String getInputPatterns() {
        return inputPatterns;
    }

    public void setInputPatterns(String inputPatterns) {
        this.inputPatterns = inputPatterns;
    }

}
