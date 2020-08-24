<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<SCRIPT>
	function resetCtg(){

		var frm=document.forms['OtherPaymentsCategAdminForm'];
		
		frm.elements['currentCtg.otherPaymentCtgId'].selectedIndex=0;
		frm.elements['currentCtg.description'].value="";
        frm.elements['currentCtg.shortDescription'].value="";
	}

        function editCtg(){
                var frm=document.forms['OtherPaymentsCategAdminForm'];
                
                if(frm.elements['currentCtg.otherPaymentCtgId'].selectedIndex==0){
                	alert('<bean:message key="app.messages.MustSelectACategory" />');
                	return;
                }

                //frm.elements['currentPayment.paymentTypeId'].value=paymentTypeId;
                frm.submit();
        }

        function deleteCtg(){
                var frm=document.forms['OtherPaymentsCategAdminForm'];
                
                if(frm.elements['currentCtg.otherPaymentCtgId'].selectedIndex==0){
                	alert('<bean:message key="app.messages.MustSelectACategory" />');
                	return;
                }
                

                //frm.elements['currentPayment.paymentTypeId'].value=paymentTypeId;
                frm.action.value="delete";
                frm.submit();
        }


        function validate(){
                var result=""; 
                var frm=document.forms['OtherPaymentsCategAdminForm'];

                if(frm.elements['currentCtg.shortDescription'].value.length==0 ||
                   frm.elements['currentCtg.description'].value.length==0 
                   ){
                        result="<bean:message key="app.messages.js.MustEnterAllField" />";
                }

                return result;
        }


        function save(){
                var frm=document.forms['OtherPaymentsCategAdminForm'];
                var result=validate();
                if(result!=""){
                    alert(result);
                }else{
                    frm.action.value="save";
                    frm.submit();
                }                
        }

        function close(){
            document.location.href="<html:rewrite page="/Admin/AdminIndex.do" />";
            
        }

</SCRIPT>



<html:errors />
<nested:form method="post" action="/Admin/OtherPaymentsCategAdmin.do">    
    <input type="hidden" name="action" >
<div align="center">
	<table border="0" width="800" cellspacing="0" cellpadding="0" bgcolor="#000000" style="border-collapse: collapse" bordercolor="#111111" height="219">
	  <tr>
			<td bgcolor="#808080" width="4" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="2" width="447" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="4" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="4" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="2" width="447" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="4" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>	  
	  <tr>
		<td bgcolor="#808080" width="4" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="223" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="224">
			&nbsp;</td>
		<td bgcolor="#808080" width="4" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="center" valign="middle" colspan="2" height="34">
			<b><font face="Arial" size="2"><br><p align="center"><bean:message key="app.messages.PaymentCategory" />:      
				<nested:select property="currentCtg.otherPaymentCtgId">
					<option value=""></option>
			    	<nested:optionsCollection property="allCtgs" label="shortDescription" value="otherPaymentCtgId" />
			    </nested:select>         <b><font face="Arial"><a href="javascript:editCtg();">
                    <font size="2"><bean:message key="app.messages.Edit" /></font></a><font size="2"> </font>
             <a href="javascript:deleteCtg();"><font size="2" face="Arial"><bean:message key="app.messages.Delete" /></font></a>
             </font> <font size="2"> </font>
             <a href="javascript:resetCtg();"><font size="2" face="Arial"><bean:message key="app.messages.New" /></font></a></p>
             </font></b></p></td>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
	  </tr>	 	  
	  <tr>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22">
			<b><font face="Arial" size="2"><bean:message key="app.message.ShortDesc" />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="224">
			<font face="Arial">
			<nested:text property="currentCtg.shortDescription" maxlength="20" /></font></td>
		<td bgcolor="#808080" width="4" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22">
			<b><font face="Arial" size="2"><bean:message key="app.messages.Description" />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="224">
			<font face="Arial">
			<nested:text property="currentCtg.description" maxlength="50" /></font></td>
		<td bgcolor="#808080" width="4" height="22">&nbsp;</td>
	  </tr>

	  <tr>
		<td bgcolor="#808080" width="4" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="223" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="224">
			&nbsp;</td>
		<td bgcolor="#808080" width="4" height="10">&nbsp;</td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="4" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#FFFF9C" colspan="2"height="3"><p align="center"><html:link href="javascript:save();" ><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link><html:link href="javascript:close()" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38"></html:link></p></td>
			<td bgcolor="#808080" width="4" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
	  </tr>	  
	  <tr>
		<td bgcolor="#808080" width="4" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="447" colspan="2" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="4" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="447" colspan="2" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="4" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
</table>
    </div>
</nested:form>
