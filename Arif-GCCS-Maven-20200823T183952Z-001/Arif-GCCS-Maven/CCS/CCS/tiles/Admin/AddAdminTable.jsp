<%--
  Created by IntelliJ IDEA.
  User: paravena
  Date: 23-mar-2005
  Time: 17:39:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic-el.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<html:errors/>

<html:form action="/Admin/AdminTablesManagerDispatcher.do">
    <table border="0" cellpadding="2" cellspacing="1" width="600" bgcolor="white">
            <tr>
                <td>
                    <html:select property="tableName">
                        <html:option key="app.messages.selectTable" value="0"/>
                        <html:options collection="tables" property="OBJECT_NAME" labelProperty="OBJECT_NAME"/>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td>
                    <html:submit property="method"><bean:message key="app.messages.createTable"/></html:submit>
                    <html:button property="close" onclick="window.close()" ><bean:message key="app.messages.cancel"/></html:button>
                </td>
            </tr>
    </table>
</html:form>