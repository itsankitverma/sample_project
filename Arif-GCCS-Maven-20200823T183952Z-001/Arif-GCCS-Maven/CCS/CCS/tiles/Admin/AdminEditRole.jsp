<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>

<script>
		function closeWindow(action)
		{   var f = document.forms['AdminUserListForm'];
            	  /*opener.document.location.href ="<html:rewrite page="/Admin/AdminUserList.do" />?accion=" + action + "&countrySelected=" + f.country.value;*/
            	    window.close();    
        }
		
		function saveRole(action)
		{   var f = document.forms['AdminUserListForm'];
		    f.accion.value	 = action;
		    f.submit();  
		}
</script>

<html:errors />
<br>
<div align="center">
<html:form action="/Admin/AdminHandler.do" name="AdminUserListForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminUserListForm" focus="userId">
    <html:hidden property="accion" value=""/>
    <html:hidden name="AdminUserListForm" property="country"/>
    <html:hidden name="AdminUserListForm" property="roleDefaultBefore"/>
		<table border="0" cellspacing="1" cellpadding="0" bgcolor="#000000" width="338">
			<tr>
			  <td bgcolor="#73148C" colspan="2"><p align="center"><font color="#FFFFFF" face="Arial">
				  <b><bean:message key="app.messages.editRole"/></b></font></td>
			</tr>
			<tr>
			  <td width="28%" align="left" bgcolor="#C0C0C0"><font size="2" face="Arial" color="#000000">
					<bean:message key="app.message.FedexId"/></font>
			  </td>
			  <td width="72%" bgcolor="#FFFF9C">
				  <p align="left">
				  <html:text  maxlength="10" name="AdminUserListForm" property="userId" tabindex="1" readonly="true"/>
	       	  </td>
		    </tr>
            <tr>
             <td width="28%" align="left" bgcolor="#C0C0C0"><font size="2" face="Arial" color="#000000">
                <bean:message key="app.messages.Location"/></font>
             </td>
             <td width="72%" bgcolor="#FFFF9C" >
                <html:text maxlength="5" name="AdminUserListForm" property="locationCd" tabindex="2" readonly="true"/>
             </td>
            </tr>

		  <tr>
			<td width="28%" align="left" bgcolor="#C0C0C0"><font size="2" face="Arial" color="#000000"><bean:message key="app.userName"/></font></td>
            <td width="72%" bgcolor="#FFFF9C">
                <html:text  maxlength="35" name="AdminUserListForm"  property="userName" tabindex="2" size="30" readonly="true"/></td>
		  </tr>
          <tr>
      		<td width="28%" align="left" bgcolor="#C0C0C0">
				<font size="2" face="Arial" color="#000000">
					<bean:message key="app.newRole"/>
				</font>
			</td>
            <td bgcolor="#FFFF9C" width="72%">
                <html:select property="roleDefault" name="AdminUserListForm" size="5">
                    <html:options collection="roles" name="AdminUserListForm" property="roleId" labelProperty="role"/>
                </html:select>
            </td>
          </tr>
          <tr>
			  <td colspan="2" bgcolor="#FFFF9C">
			  	<p align="center">
					<html:link href="javascript:saveRole('saveEmployeeRole');"><img align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
                    <html:link href="javascript:closeWindow('seeProfile');"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
                </p>
			  </td>
		  </tr>
		  </table>
    </html:form>
</div> 
 

