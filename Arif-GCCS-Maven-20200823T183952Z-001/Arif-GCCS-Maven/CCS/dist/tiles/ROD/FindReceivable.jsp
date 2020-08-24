<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<nested:form action="/ROD/AddReceivable.do" method="POST">
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>

   function handlePress(e,obj) {
	   obj.value=obj.value.trim();
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            var form=document.forms['AddReceivableForm'];
            var awbNbr=extractAWB(obj.value);

            if(validaAWBNbr(awbNbr)){
                obj.value=awbNbr;
                var index=Number(findIndex(obj.name,0))+1
                if (eval("form.elements['awbs["+index+"].recAwbNumber']")){
                        eval("form.elements['awbs["+index+"].recAwbNumber']").focus();
                }else{
                        document.links[0].focus();
                }
            }else{
                obj.value="";
            }
      }
    }

   function validateEnteredAwb(obj){
	   obj.value=obj.value.trim();
        if(obj.value.length>0){
            var form=document.forms['AddReceivableForm'];
            var awbNbr=extractAWB(obj.value);

            if(validaAWBNbr(awbNbr)){
                obj.value=awbNbr;
            }else{
                obj.select();
                alert("Please enter a valid AWB field");
                obj.focus();
            }
        }
    }

    function findIndex(name,after){
        var from=name.indexOf("[",after)+1;
        var to=name.indexOf("]",after);
        return name.substr(from,to-from);
    }

    function validate(){
        var form=document.forms['AddReceivableForm'];
        var msg="";
        var index=0;
        while(eval("form.elements['awbs["+index+"].recAwbNumber']")){
            if(validaAWBNbr(eval("form.elements['awbs["+index+"].recAwbNumber']").value)) return "";
            index++
        }

           return "<bean:message key="app.messages.js.MustEnterAtLeastOneAwb" />"; //it is executed only if the awbs are empty
    }

    function submitForm(){
        var form=document.forms['AddReceivableForm'];
        var msg=validate();
        if(msg==""){
            document.forms['AddReceivableForm'].submit();
        }else{
            alert(msg);
        }
    }


</script>
<body >
<input type="hidden" name="action" value="FindReceivable">
<nested:hidden property="recEmployeeId" />
<nested:hidden property="locationCd" />
<nested:hidden property="currencyCode" />
	  <table border="0" bgcolor="#808080" cellspacing="1" cellpadding="0" width="99%" bordercolor="#000000" align="center">
  <TBODY>
      
  <TR>
    <TD bgcolor="#73148C" colSpan=10>
      <DIV align=center><FONT face="Arial" color="#FFFFFF" size=3><B><bean:message key="app.messages.FindReceivable" /></B></FONT></DIV>
    </TD>
  </TR>
  <tr>
<nested:iterate property="awbs" indexId="idx">
  <%if(idx.intValue()!=0 && idx.intValue()%5==0) out.println("</tr><tr>");%>
    <td width="79" bgcolor="#C0C0C0" align="left"><font face="Arial" size="2">AWB</font></td>
	<td width="79" bgcolor="#FFFFFF" align="center">
      <nested:text property="recAwbNumber" size="12" maxlength="20" onkeypress="handlePress(event,this);" onblur="validateEnteredAwb(this)" />
    </td>
</nested:iterate>
  </tr>
  <tr>
	      <td width="798" bgcolor="#FFFFFF" align="CENTER" colspan="10"><font face="Arial" size="2">
                 <bean:message key="app.messages.UseGun" /></font></td>
  </tr>
  <tr>
      <TD align=middle colSpan=10>
        <INPUT type=button onclick="submitForm();" value="<bean:message key="app.messages.FindReceivable" />">
    </TD>
  </TR>
</TBODY>
</TABLE>
</nested:form>
<html:errors />
<P>&nbsp;</P>
</body>
