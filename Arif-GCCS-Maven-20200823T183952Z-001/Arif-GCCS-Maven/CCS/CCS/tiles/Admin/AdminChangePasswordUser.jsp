<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<script>
		function closeWindow()
		{
			<% if("expiredPassword".equals(request.getAttribute("action"))){ %>
				 opener.document.location.href ="<html:rewrite page="/"/>";
			<% } %>   
			window.close();
		}
		
		function savePasswordUser(action)
		{   var f 		   = document.forms['ChangePasswordForm'];
		    f.action.value = action;
			f.action2.value= "<%=request.getAttribute("action")!=null?request.getAttribute("action"):""%>";
		    f.submit();
		}
</script>

<% com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile ep=
							(com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile)request.getSession().getAttribute("userProfile");
   String country=ep.getCountryCd(); 
   if(country==null)
   {  country = "dccs";}
%>
   
<html:errors />

<br>
<div align="center">
<nested:form action="/Admin/AdminChangePassword.do" method="GET" focus="passwordOld">
<nested:hidden property="action" value=""/>
<nested:hidden property="action2" value=""/>
<nested:hidden property="check"/>
	<table width="90%" border="0" cellspacing="1" cellpadding="0" bgcolor="#000000">
			<tr>
			  <td bgcolor="#73148C" colspan="4"><p align="center"><font color="#FFFFFF" face="Arial">
			  	<b><bean:message key="app.message.AdminUser" arg0="<%=country%>" /></b></font>
			  </td>
			</tr>
			<tr>
			  <td width="107" align="left" bgcolor="#C0C0C0"><font size="2" face="Arial" color="#000000">
				 <bean:message key="app.message.FedexId"/></font>
			  </td>
			  <td bgcolor="#FFFF9C" colspan="3">
				  <p align="left">
	        		 <nested:text  maxlength="10" property="userId" readonly="true"/>
				  </p> 
			  </td>
		  </tr>
		  <tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000"><bean:message key="app.userName"/></font></td>
            <td bgcolor="#FFFF9C" colspan="3">
				<nested:text  maxlength="35" property="userName" size="35" readonly="true"/>
			</td>
		  </tr>
		  <tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
				<bean:message key="app.OldPassword"/></font>
			</td>
			<td width="169" bgcolor="#FFFF9C" colspan="3">
				<nested:password maxlength="20" property="passwordOld" />
			</td>
		  </tr>
		  <tr>
			<td bgcolor="#C0C0C0" align="left">
				<font size="2" face="Arial" color="#000000">
					<bean:message key="app.NewPassword"/>
				</font>
			</td>
			<td bgcolor="#FFFF9C" colspan="3">
				<nested:password maxlength="20" property="passwordNew"/>
			</td>
		  </tr>
 		  <tr>
			<td bgcolor="#C0C0C0" align="left">
				<font size="2" face="Arial" color="#000000">
					<bean:message key="app.Password2"/>
				</font>
			</td>
			<td bgcolor="#FFFF9C" colspan="3">
				<nested:password maxlength="20" property="passwordNewAgain"/>
			</td>
	      </tr>
		  <tr>
			<td colspan="4" bgcolor="#FFFF9C">
				 <p align="center">
					<html:link href="javascript:savePasswordUser('savePassword');"><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
					<html:link href="javascript:closeWindow();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
				 </p>
			</td>
		   </tr>
		</table>
</nested:form>
</div>