<%@page import="java.text.*,java.util.*" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%  
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>
    function addReceivable(){
        var msg=validate();
        if(msg==""){
            document.forms['AddFTCReceivableForm'].action.value="SaveAssignThis";
            document.forms['AddFTCReceivableForm'].submit();        
        }else{
            alert(msg);
        }    
    }

    function validate(){
        var form=document.forms['AddFTCReceivableForm'];
        var msg="";

        msg=validateAWB(form.recAwbNumber.value);

        if (!validateUSDate(form.recDateText.value)) {
             msg=msg+"-<bean:message key="app.message.js.MustEnterAValidDate" />\n";
        }
        
        if(form.recCustomerName.value==""){
            msg=msg+"-<bean:message key="errors.messages.js.CustomerNameRequired" />\n";
        }

        if(form.locationCd.value==""){
            msg=msg+"-<bean:message key="errors.messages.js.LocationRequired" />\n";
        }
        if(form.recEmployeeId.value==""){
            msg=msg+"-<bean:message key="app.messages.js.CourierRequired" />\n";
        }

        if(form.recAmount.value==""){
            msg=msg+"-<bean:message key="errors.messages.js.RecAmountRequired" />\n";
        }else{
            if(isNaN(form.recAmount.value) || Number(form.recAmount.value)<=0){
                msg=msg+"-<bean:message key="errors.messages.js.RecAmountInvalid" />\n";
            }
        }

        if(form.exchangeRateUsed.value==""){
            msg=msg+"-<bean:message key="errors.messages.js.ExchangeRateUsedRequired" />\n";
        }else{
            if(isNaN(form.exchangeRateUsed.value) || Number(form.exchangeRateUsed.value)<=0){
                msg=msg+"-<bean:message key="errors.messages.js.ExchangeRateUsedInvalid" />\n";
            }
        }

        if(msg==""){
            return "";
        }else{
            return "<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;

        }  
    }

    function validateAWB(awbNumber){
        if(awbNumber==""){
            return "-<bean:message key="errors.messages.js.AWBRequired" />\n";
        }else{
            if(awbNumber.length<11 || awbNumber.length>12 || isNaN(awbNumber)){
                return "-<bean:message key="errors.messages.js.AWBInvalid" />\n";
            }
        }    
        return "";
    }
</script>
<body>
<html:errors />
<html:form action="/FTC/AddFTCReceivable.do">
    <html:hidden property="recId" />
    <html:hidden property="currencyCode" />
    <input type="hidden" name="action" value="SaveAssignThis">
<TABLE borderColor="#000099" cellSpacing=5 cellPadding=5 border="1" width="100%">
  <TBODY>
  <TR>
    <TD bgColor="#660099" colSpan=2>
      <DIV align=center><FONT color="#ff9933" size=3><B><bean:message key="app.messages.AddFTC" /></B></FONT></DIV></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.AWBNumber" /></B></TD>
    <TD><html:text property="recAwbNumber"/></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.InvoiceNumber" /></B></TD>
    <TD><html:text property="recNumber"/></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.CustomerName" /></B></TD>
    <TD><html:text property="recCustomerName"/></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.InvoiceDate" /></B></TD>
    <TD><html:text property="recDateText"  /> (MM/DD/YYYY)</TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.InvoiceAmt" /></B></TD>
    <TD>
        <logic:equal name="AddFTCReceivableForm" property="recAmount" value="0">
           <html:text property="recAmount" value="" />
        </logic:equal>   
        <logic:notEqual name="AddFTCReceivableForm" property="recAmount" value="0">
           <html:text property="recAmount" />
        </logic:notEqual>   
    </TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.messages.ExchangeRate" /></B></TD>
    <TD>
        <logic:equal name="AddFTCReceivableForm" property="exchangeRateUsed" value="0">
           <html:text property="exchangeRateUsed" value="" />
        </logic:equal>   
        <logic:notEqual name="AddFTCReceivableForm" property="exchangeRateUsed" value="0">
           <html:text property="exchangeRateUsed" />
        </logic:notEqual>   

    </TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.location" /></B></TD>
    <TD><html:text property="locationCd" onblur="this.value=this.value.toUpperCase();"/></TD></TR>
  <TR>
    <TD align=right><B><bean:message key="app.EmployeeNumber" /></B></TD>
    <TD><html:text property="recEmployeeId" /></TD></TR>
  <TR>
    <TD align=middle colSpan=2><INPUT type="button" onclick="addReceivable();" value="<bean:message key="app.messages.AddFTC" />"></TD>
  </TR>
</TBODY>
</TABLE>
</html:form>
</body>