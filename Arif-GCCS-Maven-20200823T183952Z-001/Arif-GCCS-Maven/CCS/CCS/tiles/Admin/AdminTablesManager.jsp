<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic-el.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<script language="JavaScript">
    function reload() {
        var form = document.forms['AdminTablesManagerForm'];
        form.action = "AdminTablesManager.do";
        form.submit();
    }
</script>
<html:errors/>
<html:form action="/Admin/AdminTablesManagerDispatcher.do">
    <table border="0" cellpadding="1" cellspacing="0" width="800" bgcolor="#73148C">
        <tr>
            <td>
                <b><font color="white"><bean:message key="app.title.AdminTablesManager"/></font></b>
            </td>
        </tr>
        <tr>
            <td>
                <table border="0" cellpadding="2" cellspacing="1" width="100%" bgcolor="#FFFF99">
                        <tr>
                            <td colspan="3">
                                <html:select property="tableName" onchange="reload()">
                                    <html:option key="app.messages.selectTable" value="0"/>
                                    <html:options collection="tables" property="TBL_NM" labelProperty="TBL_NM"/>
                                </html:select>
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                <html:button property="addTable" onclick="window.open('/GCCS/Admin/AddAdminTable.do','add','dependent=yes,width=500,height=300,titlebar=yes,scrollbars=yes,status=yes')"><bean:message key="app.messages.addTable"/></html:button>
                                <logic:present name="columns">
                                    <c:if test="${not empty columns}">
                                        <html:submit property="method"><bean:message key="app.messages.saveTable"/></html:submit>
                                        <html:submit property="method"><bean:message key="app.messages.removeTable"/></html:submit>
                                    </c:if>
                                </logic:present>
                            </td>
                        </tr>
                </table>
            </td>
        </tr>
    </table>
    <logic:present name="columns">
        <c:if test="${not empty columns}">
            <table border="0" cellpadding="2" cellspacing="1" width="800" bgcolor="white">
                <tr>
                    <td>
                        <table border="0" cellpadding="2" cellspacing="1" width="600" bgcolor="white">
                            <tr bgcolor="#73148C">
                                <th align="left" colspan="2"><font color="white">COLUMN</font></th>
                                <th align="left"><font color="white">SEL FLG</font></th>
                                <th align="left"><font color="white">UDP FLG</font></th>
                                <th align="left"><font color="white">SRCH FLG</font></th>
                                <th align="left"><font color="white">PRIM KEY FLG</font></th>
                            </tr>
                            <c:forEach var="column" items="${columns}" varStatus="status">
                                <c:choose>
                                    <c:when test="${status.count % 2 == 0}">
                                       <tr bgcolor="#EAEAEA">
                                    </c:when>
                                    <c:otherwise>
                                        <tr bgcolor="white">
                                    </c:otherwise>
                                </c:choose>
                                    <td>
                                        <html:multibox property="columns">
                                            <c:out value="${column.COL_NM}"/>
                                        </html:multibox>
                                    </td>
                                    <td>
                                        <c:out value="${column.COL_NM}"/>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${column.SEL_FLG eq 1}">

                                                <input type="checkbox" name='<c:out value="${AdminTablesManagerForm.tableName}" escapeXml="true" />;<c:out value="${column.COL_NM}" escapeXml="true" />;SEL_FLG' value="1" checked="yes">

                                            </c:when>
                                            <c:otherwise>
                                                <input type="checkbox" name='<c:out value="${AdminTablesManagerForm.tableName}" escapeXml="true" />;<c:out value="${column.COL_NM}" escapeXml="true" />;SEL_FLG' value="1" >

                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${column.UPD_FLG eq 1}">
                                                <input type="checkbox" name='<c:out value="${AdminTablesManagerForm.tableName}" escapeXml="true" />;<c:out value="${column.COL_NM}" escapeXml="true" />;UPD_FLG' value="1" checked="yes">

                                            </c:when>
                                            <c:otherwise>
                                                <input type="checkbox" name='<c:out value="${AdminTablesManagerForm.tableName}" escapeXml="true" />;<c:out value="${column.COL_NM}" escapeXml="true" />;UPD_FLG' value="1" >
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${column.SRCH_FLG eq 1}">
                                                <input type="checkbox" name='<c:out value="${AdminTablesManagerForm.tableName}" escapeXml="true" />;<c:out value="${column.COL_NM}" escapeXml="true" />;SRCH_FLG' value="1" checked="yes">

                                            </c:when>
                                            <c:otherwise>
                                                <input type="checkbox" name='<c:out value="${AdminTablesManagerForm.tableName}" escapeXml="true" />;<c:out value="${column.COL_NM}" escapeXml="true" />;SRCH_FLG' value="1" >
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${column.PRIM_KEY_FLG eq 1}">
                                                <input type="checkbox" name='<c:out value="${AdminTablesManagerForm.tableName}" escapeXml="true" />;<c:out value="${column.COL_NM}" escapeXml="true" />;PRIM_KEY_FLG' value="1" checked="yes">

                                            </c:when>
                                            <c:otherwise>
                                                <input type="checkbox" name='<c:out value="${AdminTablesManagerForm.tableName}" escapeXml="true" />;<c:out value="${column.COL_NM}" escapeXml="true" />;PRIM_KEY_FLG' value="1" >
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                    <td valign="top">
                        <html:button property="addColumn" onclick="window.open('/GCCS/Admin/AddAdminTableColumn.do?tableName=${AdminTablesManagerForm.tableName}','add','dependent=yes,width=500,height=300,titlebar=yes,scrollbars=yes,status=yes')"><bean:message key="app.messages.addColumn"/></html:button>
                        <br/>
                        <html:submit property="method"><bean:message key="app.messages.removeColumn"/></html:submit>
                    </td>
                </tr>
            </table>
        </c:if>
    </logic:present>
</html:form>
