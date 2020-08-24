<%@page import="java.util.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<bean:define id="userProfile" name="userProfile" scope="session" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />
<%
    /*com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminUserListForm a=(com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminUserListForm)request.getAttribute("AdminUserListForm");
   if (a==null) out.println("FORM NULO");
   else if (a.getProfiles()==null) out.println("prof NULO");
        else out.println(String.valueOf(a.getProfiles().size()));*/
%>
<script language="JavaScript">
	function sendToServer(action, userId, locationCD, roleId)
	{   var f 		= document.AdminUserListForm;
		var country     = f.country.options[f.country.selectedIndex].value;
		f.accion.value  = action;
		
		if(country=="FF" || country=='')
	    {  alert("<bean:message key="app.js.messages.EnterCountry"/>");
		   return;
		}
		
			   if(action == "editEmployeeRole"){
				  var w=430;
    	          var h=400; 
        	      if(w>screen.width)w=screen.width;
            	  if(h>screen.height)h=screen.height;
                  var leftpos=(screen.width-w) / 2;
                  var toppos=(screen.height-h) / 2;
	              window.open("<html:rewrite page="/Admin/AdminHandler.do" />?accion=" + action + "&userId=" + userId +"&locationCd=" + locationCD +"&roleDefault=" + roleId + "&country=" + country, "editUser", "scrollbars=no,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
    	          return;		
			   }if(action == "revokeEmployee"){
				  var checkRevoke=false;	
                  for(i=0;i<f.revokeEmployee.length;i++)	
                  {	  if(f.revokeEmployee[i].checked)	  
		              {	 checkRevoke=true; break;}
                  }
                  
				  if(checkRevoke==false)
				  {	 alert("<bean:message key='app.mesagge.js.SelectUserForRevoke'/>");
                     return;
                  }
	              
				  if(!(confirm("<bean:message key="app.message.js.QuestionRevokeUser"/>")))
                       return;
               }else if(action == "enterEmployee")
	                {   var w=530;
    	                var h=600;
        	            if(w>screen.width)w=screen.width;
            	        if(h>screen.height)h=screen.height;
                	    var leftpos=(screen.width-w) / 2;
                    	var toppos=(screen.height-h) / 2;
	                    window.open("<html:rewrite page="/Admin/AdminUserList.do" />?accion=" + action + "&countrySelected=" + country + "&userId=" + userId, "addUser", "scrollbars=no,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
    	                return;
        	        }else 
	                {    if(action == "seeUser" || action=="addLocationRole")
    	                {       var w=530;
        	                    var h=600;

            	                if(w>screen.width)w=screen.width;
                	            if(h>screen.height)h=screen.height;
                    	        var leftpos=(screen.width-w) / 2;
                        	    var toppos=(screen.height-h) / 2;
	                            window.open("<html:rewrite page="/Admin/AdminUserList.do" />?accion=" + action + "&countrySelected=" + country + "&userId=" + userId, "addUser", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes");
    	                        return;
        	            }else{ 
                              if(action != "seeProfile")
                              {
                              	  var checkRole=false;	
                              	  for(i=0;i<f.roleSelected.length;i++)	
                              	  {	  if(f.roleSelected[i].checked)	  
		                              {	 checkRole=true; break;}
                              	  }
                              	  
                              	  var checkLocation=false;	
                              	  for(i=0;i<f.locationAlreadySelected.length;i++)	
                              	  {	  if(f.locationAlreadySelected[i].checked)	  
		                              {	 checkLocation=true; break;}
                              	  }
                              	  
                                  switch(action)
                                  {   case "deleteUser":
                                                      if(!(confirm("<bean:message key="app.message.js.QuestionDeleteUser"/>")))
	                                                       return;
	                                                  f.userId.value=userId;
                                                      break;
                                      case "deleteLocation":

			                                          if(checkLocation==false)
					                              	  {	 alert("<bean:message key='app.mesagge.js.SelectLocationForUser' arg0='" + userId + "'/>");
                    						          	 return;
                    						          }
                    						          
                                                      if(!(confirm("<bean:message key="app.message.js.QuestionDeleteLocation"/>")))
                                                           return;
                                                           
                                                      f.userId.value=userId;
                                                      break;
                                      case "deleteRole":
                                                   	  if(checkRole==false)
					                              	  {	 alert("<bean:message key='app.mesagge.js.SelectRoleForLocation' arg0='" + locationCD + "' arg1='" + userId + "'/>");
                    						          	 return;
                    						          }
                    						          
                                                      if(!(confirm("<bean:message key="app.message.js.QuestionDeleteRole"/>")))
                                                           return;
                                                           
                                                      f.userId.value=userId;                                                      
                                                      f.locationCd.value=locationCD;
                                                      break;
                                      }
                                   	  f.submit();
                                      return;
                                    }
                             }		

                    if(action == "seeProfile")
                    {
                       if(f.country.options[f.country.selectedIndex].value = "")
                            { return "<bean:message key="app.message.js.MustSelectACountry"/>";	
                            }else{
                                            f.countrySelected.value = country;
                                     }	
                    }
                 }
		f.submit();
	}//Close sendToServer function
</script>

<html:errors />
<br>
<br>

<html:form action="/Admin/AdminUserList.do" name="AdminUserListForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminUserListForm" scope="request">
<table cellspacing=1 cellpadding=0 width="100%" bgcolor="#000000" border=0>
  <tbody>
    <tr> 
      <td align=middle bgcolor="#73148c" colspan="3"> <font face=arial color="#ffffff" size="+1"><b><bean:message key="app.messages.UserListByCountry" /></b></font></td>
      <td align=middle bgcolor="#73148c" colspan="3"> <font face=arial color="#ffffff" size="1"><b> 
        <html:select name="AdminUserListForm" property="country" onchange="sendToServer('seeProfile', '', '', '')"> 
            <option value="" >Select</option>
            <logic:present name="countries" scope="session">
                <html:options collection="countries" property="countryCd" name="countries" labelProperty="countryNm"/>
            </logic:present>
        </html:select> </b></font>
      </td>
      <td align="center" bgcolor="#73148c">
		  <font face=arial color="#ffffff" size=3><b><bean:message key="app.messages.Action"/></b></font>
  	  </td>
    </tr>
    <tr> 
      <td align=middle bgcolor="#73148c" colspan=3><font face=arial color="#ffffff" size=3>
	  		<b><bean:message key="app.userName" /></b></font>
	  </td>
      <td align=middle bgcolor="#73148c" colspan=3><font face=arial color="#ffffff" size=3>
	  		<b><bean:message key="app.RolByLocation" /></b></font></td>
      <td align=right bgcolor="#73148c">
  		  <html:button property="add User" onclick="JavaScript:sendToServer('enterEmployee', '', '', '')">Add User</html:button> 
	  </td>
    </tr>
    <tr> 
      <td align=middle width="111" bgcolor="#73148c">
	  	<font face=arial color="#ffffff" size=3><b><bean:message key="app.message.FedexId"/></b></font>
	  </td>
      <td align=middle width="205" bgcolor="#73148c"><font face=arial color="#ffffff" size=3><b><bean:message key="app.userName"/></b> </font></td>
      <td align=middle width="95" bgcolor="#73148c"><font face=arial color="#ffffff" size=3><bean:message key="app.messages.Action"/></font></td>
      <td colspan="2" align="center" bgcolor="#73148c">
	  	<font face=arial color="#ffffff" size="3">
			<b><bean:message key="app.location"/></b></font>
	  </td>
      <td align=middle width="223" bgcolor="#73148c">
	  	<font face=arial color="#ffffff" size=3>
	  		<b><bean:message key="app.Role"/></b></font>
	  </td>
	  <td align=right width="192" bgcolor="#73148c">
  		  <%if(userProfile.isAdmin() || userProfile.isFinController() || userProfile.isCountryAdmin()){%>
                <html:button property="revoke User" onclick="JavaScript:sendToServer('revokeEmployee', '', '', '')">revoke Users</html:button>
            <%}%>
      </td>
    </tr>
    <html:hidden property="accion" value=""/>
    <html:hidden property="userId" value=""/>
    <html:hidden property="locationCd" value=""/>
    <html:hidden property="countrySelected" value=""/>
    <logic:present name="AdminUserListForm" property="profiles"> <logic:iterate id="prof" name="AdminUserListForm" property="profiles" type="com.fedex.lacitd.cashcontrol.biztier.common.UserProfileToAdmin" indexId="idx"> 
    <tr height="100%"> 
      <td width="111" bgcolor="#ffffff" >
      	<div align="center"> 
          <input type="checkbox" name="revokeEmployee" value="<bean:write name='prof' property='employeeCodePk'/>" alt="<bean:message key='app.messages.Revoke'/>">
          <a href="JavaScript:sendToServer('seeUser', '<bean:write name="prof" property="employeeCodePk"/>', 
          '', '')"><strong><font color="#000066" size=2 face=arial ><bean:write name="prof" property="employeeCodePk"/></font></strong></a> 
        </div>
	  </td>
      <td width="205" bgcolor="#ffffff" > <font face=arial size=2><bean:write name="prof" property="employeeName"/></font> 
      </td>
      <td width="95" bgcolor="#ffffff" > <font face=arial size=1>
      	<a href="JavaScript:sendToServer('addLocationRole','<bean:write name="prof" property="employeeCodePk"/>', '','')"><bean:message key="app.messages.addLocationRole"/></a><br>
      <td colspan="3">
		  <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="1">
    	      <logic:present name="prof" property="locations">
			  <logic:iterate id="locs" name="prof" property="locations" indexId="idx2"> 
	          <tr> 
    	        <td width="41%" bgcolor="#ffffff">
    	        	<font face=arial size=1><input type="checkbox" name="locationAlreadySelected" value="<bean:write name='locs'/>"><bean:write name="locs"/></font>
				 </td>
				 <td bgcolor="#ffffff">
					 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
					 <logic:present name="prof" property="locationRoles">
					 	<% HashMap rolesByLocation = (HashMap)prof.getLocationRoles();
							 ArrayList roles		   = (ArrayList)rolesByLocation.get(locs);
							  if(roles == null)
							 	 roles = new ArrayList();
						   ListIterator rolIt = roles.listIterator();
						   com.fedex.lacitd.cashcontrol.datatier.valueobject.RoleVO	rolVO = new com.fedex.lacitd.cashcontrol.datatier.valueobject.RoleVO();
						   while(rolIt.hasNext())
						   { rolVO = (com.fedex.lacitd.cashcontrol.datatier.valueobject.RoleVO)rolIt.next();
						 %>
							 <tr bgcolor="#ffffff" valign="middle">
								 <td width="60%" align="left" bgcolor="#ffffff">
									 <font face=arial size=1>
									    <input type="checkbox" name="roleSelected" value="<%=rolVO.getRoleId()%>">
                                        <a href="JavaScript:sendToServer('editEmployeeRole','<bean:write name="prof" property="employeeCodePk"/>','<bean:write name="locs"/>', '<%=rolVO.getRoleId()%>')">
                                         <strong><font face=arial color="#006666"><%=rolVO.getRole()%></font></strong>
                                        </a>
                                    </font>
								 </td>
							 </tr>
						 	<%if(rolIt.nextIndex()==roles.size()){%>
							 <tr>
								 <td rowspan="<%=roles.size()%>" align="center" valign="middle" bgcolor="#ffffff">
									<font face=arial size=1>
								 	 <a href="JavaScript:sendToServer('deleteRole','<bean:write name="prof" property="employeeCodePk"/>','<bean:write name="locs"/>', '')">
										<bean:message key="app.messages.deleteRole"/>
									 </a>												
									</font>		
 
								 </td>
							 </tr>
							<%}%>	
						<% } %>
					</logic:present>	
					</table>
				 </td>
    	      </tr>
            </logic:iterate> </logic:present>
		 </table>
	 </td>
	 <td  colspan="2" bgcolor="#ffffff">
		  <table align="center">
		  	<tr>
				<td width="100%" heigth="100%" bgcolor="#ffffff">
					  <font face=arial size="2">
                         <%if(userProfile.isAdmin() || userProfile.isFinController() || userProfile.isCountryAdmin()){%>
                             <a href="JavaScript:sendToServer('deleteUser', '<bean:write name="prof" property="employeeCodePk"/>',  '', '')">
                             <bean:message key="app.messages.deleteUser"/></a><br><br>
                         <%}%>
					 	 <a href="JavaScript:sendToServer('deleteLocation','<bean:write name="prof" property="employeeCodePk"/>','<bean:write name="locs"/>', '')">
						 <bean:message key="app.messages.deleteLocation"/></a>
					 </font>
				</td>
			</tr>
		  </table>
	 </td>
   </tr>
   </logic:iterate> </logic:present> 
  </tbody>
</table>
</html:form>
 
<p>&nbsp;</p>


