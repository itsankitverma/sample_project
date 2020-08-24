<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<script>
		function recoverPasswordUser(action)
		{   var f 		   = document.forms['AdminUserListForm'];
		    f.action.value = action;
		    f.submit();
			this.close;  
		}
</script>

<% com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile ep=
							(com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile)request.getSession().getAttribute("userProfile");
							
   String country= ep!=null?ep.getCountryCd():""; %>
   
<html:errors />

<br>
<div align="center">
<nested:form action="/Admin/AdminForgotPassword.do" method="POST" focus="userId" scope="request">
<nested:hidden property="action" value=""/>
<nested:hidden property="reviewName" value="false"/>
<nested:hidden name="AdminUserListForm" property="reviewData"/>

	<table width="90%" border="0" cellspacing="1" cellpadding="0" bgcolor="#000000">
			<tr>
			  <td bgcolor="#73148C" colspan="4"><p align="center"><font color="#FFFFFF" face="Arial">
			  	<b><bean:message key="app.message.AdminUser" arg0="enter id." /></b></font>
			  </td>
			</tr>
			<tr>
			  <td width="107" align="left" bgcolor="#C0C0C0"><font size="2" face="Arial" color="#000000">
				 <bean:message key="app.message.FedexId"/></font>
			  </td>
			  <td bgcolor="#FFFF9C" colspan="3">
				  <p align="left">
	        		 <nested:text property="userId" maxlength="10" size="10"/>
				  </p> 
			  </td>
		  </tr>
		  <tr>
			<td bgcolor="#C0C0C0" align="left">
				<font size="2" face="Arial" color="#000000"><bean:message key="app.userName"/></font>
			</td>
            <td bgcolor="#FFFF9C" colspan="3">
					<nested:write property="userName"/>
			</td>
		  </tr>
		  <tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
					<bean:message key="app.Email"/></font>
			</td>
			<td width="169" bgcolor="#FFFF9C" colspan="3">
					<nested:write property="email" />
			</td>
		  </tr>
 		  <tr>
			<td colspan="4" bgcolor="#FFFF9C">
				 <p align="center">
					<html:link href="javascript:recoverPasswordUser('recoverPassword');"><img  align="center" border="0" src="<html:rewrite page="/images/Recover" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
					<html:link href="javascript: window.close();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
					<br><b><font size="3" face="Arial" color="#FF0000">
						<nested:notPresent property="email">
							<bean:message key="app.message.RecoverPassword"/>
						</nested:notPresent>		
						<nested:present property="email">
							<bean:message key="app.message.CouldChangePassword"/>
						</nested:present>		
					</font></b>
				 </p>
			</td>
		   </tr>
		</table>
  </nested:form>
</div>