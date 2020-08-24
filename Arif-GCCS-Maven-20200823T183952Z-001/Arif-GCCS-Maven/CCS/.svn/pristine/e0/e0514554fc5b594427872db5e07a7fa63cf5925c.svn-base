<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<logic:notPresent name="userProfile" scope="session">
    <logic:redirect forward="login" />
</logic:notPresent>
<logic:empty name="userProfile" property="locationCd">
       <logic:redirect forward="selectLocation" />
</logic:empty>
<html>
<head><title>Import ROD invoices</title></head>
<body>
<logic:present name="message">
<br>
<br>
<br>
<table align="center">
  <tr>
  <td><b><font color='blue'><bean:write name="message" /></b></font></td>
  </tr>
</table>
</logic:present>
<logic:notPresent  name="message">
<form action="<%=request.getContextPath()%>/LoadInvoices.do" method="post">
<table align="center">
  <tr>
  <td><html:submit value="Collect Invoices" /></td>
  </tr>
</table>
</form>
</logic:notPresent>

</body>
</html>
