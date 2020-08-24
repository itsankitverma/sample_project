<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.datatier.valueobject.*"%>

<script>
	function sendToServer(action)
	{ var f = document.forms['AdminBankForm'];
	  f.action.value=action;
	  
	  if(action == 'closeBank')
	     f.check.value=false;
	     
	  f.submit();
	}
</script>


<html:errors />
<br>
<br>
<div align="center">

<nested:form action="/Admin/AdminBank.do" focus="bankNm">
<nested:hidden property="bankId"/>
<nested:hidden property="check"/>
<input type="hidden" name="action">
	<table border="0" cellspacing="1" cellpadding="0" bgcolor="#000000">
		<tr>
			<td bgcolor="#73148C" colspan="4"><p align="center"><font color="#FFFFFF" face="Arial">
				<b><nested:message key="app.title.AdminBank"/></b></font>
			</td>
		</tr>
		
		<tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
				<nested:message key="app.country"/></font>
			</td>
			<td bgcolor="#C0C0C0" align="left">
				<nested:select property="countryCd">
		        	<logic:present name="countries" scope="session">
		        		<html:options collection="countries" property="countryCd" name="countries" labelProperty="countryNm"/> 
	        		</logic:present>
    	    	</nested:select>
   			</td>
 			
		</tr>
			<tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
				<nested:message key="app.message.BankNm"/></font>
			 </td>
			 <td bgcolor="#FFFF9C" colspan="3">
				<p align="left">
					<nested:text property="bankNm" size="35"/>
			 </td>
		</tr>
		<tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
				<nested:message key="app.message.ShortDesc"/></font>
			</td>
			 <td bgcolor="#FFFF9C" colspan="3">
				<p align="left">
					<nested:text property="bankShtDesc" size="15"/>
			 </td>
		</tr>
		<tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
				<nested:message key="app.message.BankCode"/></font>
			</td>
			 <td bgcolor="#FFFF9C" colspan="3">
				<p align="left">
				<nested:text property="bankCd" size="5"/>
			 </td>
		</tr>
		<tr>
			<td colspan="4" bgcolor="#FFFF9C">
			 	<p align="center">
           			<html:link href="javascript:sendToServer('saveBank');"><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
			        <html:link href="javascript:sendToServer('closeBank');"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
    		    </p>
			 </td>
		</tr>
	</table>
</nested:form>

</div> 
 

