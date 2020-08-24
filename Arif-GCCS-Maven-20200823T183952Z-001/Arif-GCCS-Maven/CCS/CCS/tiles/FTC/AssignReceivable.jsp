<%@page import="java.text.*" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<script>
    function reassign(){
        var msg=validate();
        if(msg==""){
            document.forms['AddReceivableForm'].action.value="AssignThis";
            document.forms['AddReceivableForm'].submit();        
        }else{
            alert(msg);
        }    
    }

     function validate(){
        var form=document.forms['AddReceivableForm'];
        var msg="";        
        if(form.locationCd.value==""){
            msg=msg+"-<bean:message key="errors.messages.js.LocationRequired" />\n";
        }
        if(form.recEmployeeId.value==""){
            msg=msg+"-<bean:message key="app.messages.js.CourierRequired" />\n";
        }
        return msg;
    }

</script>
<body>
<html:errors />
<html:form action="/ROD/AddReceivable.do">
    <html:hidden property="recId" />
    <input type="hidden" name="action" value="AssignThis">
<TABLE borderColor="#000099" border="1" cellSpacing=5 cellPadding=5 width="100%">
  <TBODY>
  <TR>
    <TD bgColor="#660099" colSpan=2>
      <DIV align=center><FONT color="#ff9933" size=3><B><bean:message key="app.messages.AssignReceivable" /></B></FONT></DIV></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.AWBNumber" /></B></TD>
    <TD><bean:write name="AddReceivableForm" property="recAwbNumber"/><html:hidden property="recAwbNumber" /></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.InvoiceNumber" /></B></TD>
    <TD><bean:write name="AddReceivableForm" property="recNumber"/><html:hidden property="recNumber" /></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.InvoiceDate" /></B></TD>
    <TD><bean:write name="AddReceivableForm" property="recDateText" formatKey="app.format.Date" /><html:hidden property="recDateText" /></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.InvoiceAmt" /></B></TD>
    <TD><bean:write name="AddReceivableForm" property="recAmount" formatKey="app.format.NumberFormat" /> <bean:write name="AddReceivableForm" property="currencyCode" /><html:hidden property="recAmount" /><html:hidden property="currencyCode" /></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.CustomerName" /></B></TD>
    <TD><bean:write name="AddReceivableForm" property="recCustomerName"/><html:hidden property="recCustomerName" /></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.location" /></B></TD>
    <TD><html:text property="locationCd" onblur="this.value=this.value.toUpperCase();" /></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.EmployeeNumber" /></B></TD>
    <TD>
        <html:text property="recEmployeeId" />
    </TD></TR>
  <TR>
    <TD align=middle colSpan=2><INPUT type="button" onclick="reassign();" value="<bean:message key="app.messages.AssignReceivable" />"></TD>
  </TR>
</TBODY>
</TABLE>
</html:form>
</body>