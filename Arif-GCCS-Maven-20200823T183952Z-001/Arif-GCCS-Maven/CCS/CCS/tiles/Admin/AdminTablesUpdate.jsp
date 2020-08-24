<%@ page import="com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminMainTablesForm"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<script>
    function sendToServer(action)
    { var f = document.forms['AdminMainTablesForm'];
      f.action.value=action;
      f.submit();
      //window.close();
    }
</script>

<html:errors/>

<html:form action="/Admin/AdminMainTables.do" method="post">
    <input type="hidden" name="action"/>
    <html:hidden property="tableSelected"/>

    <input type="hidden" name="pk" value='<c:out value="${param.pk}" escapeXml="true" />' />
    <input type="hidden" name="tableName" value='<c:out value="${param.tableName}" escapeXml="true" />' />

	<table width="500" cellpadding="0" cellspacing="1" align="center" bgcolor="#000000">
		<tr bgcolor="#73148C">
			<td>
				<font color="white"><b>Update Table:</b> <c:out value="${AdminMainTablesForm.tableSelected}"/></font>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="1" cellpadding="2">
                    <!-- Put Collection on request object -->
                    <%  AdminMainTablesForm form = (AdminMainTablesForm) request.getAttribute("AdminMainTablesForm");
                        session.setAttribute("columnToUpdate", form.getColumnToUpdate());
                    %>
                    <c:forEach var="column" items="${AdminMainTablesForm.columnToUpdate}" varStatus="status">
                        <c:choose>
                            <c:when test="${column.primaryKey eq true}">
                                <input type="hidden" name='<c:out value="${column.columnName}" escapeXml="true" />' value='<c:out value="${column.columnValue}" escapeXml="true" />' />

                            </c:when>
                            <c:otherwise>
                                <tr bgcolor="#ffff99">
                                    <td align="left" width="20%" align="right" bgcolor="#999999">
                                        <font size="-1"><c:out value="${column.columnName}"/>:</font>
                                    </td>
                                    <c:choose>
                                        <c:when test="${column.update eq true}">
                                            <td width="30%" align="left">
                                                <font size="-1">
                                                    <input type="text" name='<c:out value="${column.columnName}" escapeXml="true" />' value='<c:out value="${column.columnValue}" escapeXml="true" />' />
                                                </font>
                                            </td>
                                            <td width="50%" align="right" >
                                                <font size="-1"><c:out value="${column.columnDescription}"/></font>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td width="30%" align="left">
                                                <font size="-1"><c:out value="${column.columnValue}"/></font>
                                            </td>
                                            <td width="50%" align="left" >
                                                <font size="-1"><c:out value="${column.columnDescription}"/></font>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <tr bgcolor="#ffff99">
                        <td colspan="3" align="center">
                            <input type="button" value="Save Information" onClick="javascript:sendToServer('save');">
                        </td>
                    </tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>
