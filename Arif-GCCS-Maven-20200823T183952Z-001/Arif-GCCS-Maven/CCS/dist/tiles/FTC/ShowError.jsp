<%@page import="java.text.*" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:errors />
<form>
<table>
    <tr>
        <td><input type="button" value="<bean:message key="app.messages.Close" />" onclick="opener.document.forms[0].submit();window.close();"></td>
    </tr>
</table>
</form>
