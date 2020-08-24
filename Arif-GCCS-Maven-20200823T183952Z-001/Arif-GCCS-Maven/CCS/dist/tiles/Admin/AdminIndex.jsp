<%@ page import="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix  = "bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix  = "html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix = "logic" %>
<bean:define id="userProfile" name="userProfile" scope="session" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />

<script language="JavaScript1.2">
<!--
offMessage = "<bean:message key="app.messages.MenuWelcome" />"

function boxOn(which,message){
   if (document.all||document.getElementById){
      which.className='BorderOn'
   }else{
      which.className='BorderOn'
   }
}

function boxOff(which){
   if (document.all||document.getElementById){
      which.className='BorderOff'
   }else{
      which.className='BorderOff'
   }
}
//-->
</script>

<%
    EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
    if (ep == null) response.sendRedirect("/Logout.do");
    
    
    if(ep!=null){
       String role="";
    	   		if(ep.isAdmin() || ep.isCountryAdmin() || userProfile.isFinController()){
        			role="Administrator";
	    		    }else if(userProfile.getEmployeeRole().get("Operation Manager")!=null){
        	        	   role="Operation Manager";
            			}else if(userProfile.getEmployeeRole().get("Research")!=null){
    	           			role="Research";
  			          		}
     
       pageContext.setAttribute("role",role);
    }else{
       pageContext.setAttribute("role","");
    }
    
%>


<!-- BEGINNING OF MENU //-->
<!-- Outer Container Table //-->
<!-- Set this table width to largest margin-left + largest width in <style> script //-->
<logic:equal name="role" value="Administrator">
	<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
	<tr>
	   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	<tr>
		<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
		<td align="center"> 
				<table cellpadding="3" cellspacing="0" bgcolor="#73148C" class="BorderOff">
				  <tr>
				    <td><p align="center"><font color="#FFFFFF" size="2" face="Arial"><b><bean:message key="app.AdminMenu" /></b></font></p></td>
				  </tr>
				</table>
				<img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5" border="0"><br>
			<!-- End Header Table //-->
			<!-- Menu Items Tables
			   - To add more, just follow the pattern
			   - Note class= in each <a href> to attach link style colors
			//-->
	
			<!-- Tabla de item de menu 1 //-->
			<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.AdminUserListByCountry" />')" onMouseout="boxOff(this)">
			  <tr>
			   <td><font color="#73148C" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminUserList.do?accion=showWindowsOnly" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.AdminUserListByCountry"/>')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.AdminUserListByCountry"/></a></font></td>
			  </tr>
			</table>  
			<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
			<!-- Tabla de item de menu 2 //-->
			<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.AdminLocation" />')" onMouseout="boxOff(this)">
			  <tr>
			    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminLocation.do?action=getLocation" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.AdminLocation"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.AdminLocation"/></a></font></td>
					<bean:define id="countryProfile" name="userProfile" property="countryCd" scope="session"/>
				</tr>
			</table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>		
			<!-- Tabla de item de menu 3 //-->
			<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.PaymentTypesAdmin" />')" onMouseout="boxOff(this)">
			  <tr>
			    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/PaymentTypesAdmin.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.PaymentTypesAdmin"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.PaymentTypesAdmin"/></a></font></td>
				</tr>
			</table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
			<!-- Tabla de item de menu 4 //-->
			<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.DepoTemplatesAdmin" />')" onMouseout="boxOff(this)">
			  <tr>
			    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/DepoTemplatesAdmin.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.DepoTemplatesAdmin"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.DepoTemplatesAdmin"/></a></font></td>
				</tr>
			</table>
	                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
			<!-- Tabla de item de menu 5 //-->
			<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.OtherPaymentsCategAdmin" />')" onMouseout="boxOff(this)">
			  <tr>
			    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/OtherPaymentsCategAdmin.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.OtherPaymentsCategAdmin"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.OtherPaymentsCategAdmin"/></a></font></td>
			  </tr>
			</table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
			<!-- Tabla de item de menu 6 Admin tables only showed for Admin users but not for Country Admin users//-->
	        <logic:equal name="userProfile" property="admin" value="true">
	            <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.MainTablesAdmin" />')" onMouseout="boxOff(this)">
	              <tr>
	                <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminMainTables.do?action=table" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.MainTablesAdmin"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.MainTablesAdmin"/></a></font></td>
	                </tr>
	            </table>
	        </logic:equal>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
	        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.EntitiesAdmin" />')" onMouseout="boxOff(this)">
	              <tr>
	                <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/EntitiesAdmin.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.EntitiesAdmin"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.EntitiesAdmin"/></a></font></td>
	                </tr>
	        </table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
			<logic:equal name="userProfile" property="admin" value="true">
			    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.BatchPaymentsAdmin" />')" onMouseout="boxOff(this)">
				  <tr>
				    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/BatchPaymentsAdmin.do" />" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.BatchPaymentsAdmin" /></a></font></td>
				  </tr>
				</table>
			    <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		    </logic:equal>
		    <logic:equal name="userProfile" property="finController" value="true">
			    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.BatchPaymentsAdmin" />')" onMouseout="boxOff(this)">
				  <tr>
				    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/BatchPaymentsAdmin.do" />" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.BatchPaymentsAdmin" /></a></font></td>
				  </tr>
				</table>
			    <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		    </logic:equal>
		    
		    <!-- Miscellaneous enhancements menu title //-->
			<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.StationsAdmin" />')" onMouseout="boxOff(this)">
			  <tr>
			    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/StationsAdmin.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.StationsAdmin"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.StationsAdmin"/></a></font></td>
				</tr>
			</table>
	        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
	        
	        
	       <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.GCCSReportingMessage" />')" onMouseout="boxOff(this)" >
	          <tr>
	            <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/GCCSReport.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.GCCSReportingMessage" /></a></font></td>
	          </tr>
	        </table>
	        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
	        <!-- Miscellaneous enhancements menu title END //-->
		</td>
		<td><img border="0" src="<html:rewrite page="/images/globalhome_background.jpg" />"></td>
		<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	<tr>
	   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	</table>
</logic:equal>
<!-- End Outer Container Table //--><!-- END OF MENU //-->


<!-- Adding new code for the Operational Manager - Kapil  -->
<logic:equal name="role" value="Operation Manager">
	<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
	<tr>
	   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	<tr>
		<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
		<td align="center"> 
				<table cellpadding="3" cellspacing="0" bgcolor="#73148C" class="BorderOff">
				  <tr>
				    <td><p align="center"><font color="#FFFFFF" size="2" face="Arial"><b><bean:message key="app.AdminMenu" /></b></font></p></td>
				  </tr>
				</table>
				<img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5" border="0"><br>
			<!-- End Header Table //-->
			<!-- Menu Items Tables
			   - To add more, just follow the pattern
			   - Note class= in each <a href> to attach link style colors
			//-->
			<!-- Tabla de item de menu 1 //>
			<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.AdminUserListByCountry" />')" onMouseout="boxOff(this)">
			  <tr>
			   <td><font color="#73148C" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminUserList.do?accion=showWindowsOnly" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.AdminUserListByCountry"/>')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.AdminUserListByCountry"/></a></font></td>
			  </tr>
			</table>  
			<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br -->
		    <!-- Miscellaneous enhancements menu title //-->
			<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.StationsAdmin" />')" onMouseout="boxOff(this)">
			  <tr>
			    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/StationsAdmin.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.StationsAdmin"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.StationsAdmin"/></a></font></td>
				</tr>
			</table>
	        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
	       <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.GCCSReportingMessage" />')" onMouseout="boxOff(this)" >
	          <tr>
	            <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/GCCSReport.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.GCCSReportingMessage" /></a></font></td>
	          </tr>
	        </table>
	        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
	        <!-- Miscellaneous enhancements menu title END //-->
		</td>
		<td><img border="0" src="<html:rewrite page="/images/globalhome_background.jpg" />"></td>
		<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	<tr>
	   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	</table>
</logic:equal>



<logic:equal name="role" value="Research">
	<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
	<tr>
	   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	<tr>
		<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
		<td align="center"> 
				<table cellpadding="3" cellspacing="0" bgcolor="#73148C" class="BorderOff">
				  <tr>
				    <td><p align="center"><font color="#FFFFFF" size="2" face="Arial"><b><bean:message key="app.AdminMenu" /></b></font></p></td>
				  </tr>
				</table>
				<img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5" border="0"><br>
		    <!-- Miscellaneous enhancements menu title //-->
			<!-- Tabla de item de menu 6 Admin tables only showed for Admin users but not for Country Admin users//-->

            <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.MainTablesAdmin" />')" onMouseout="boxOff(this)">
              <tr>
                <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminMainTables.do?action=table" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.MainTablesAdmin"/>')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.title.MainTablesAdmin"/></a></font></td>
                </tr>
            </table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
	        <!-- Miscellaneous enhancements menu title END //-->
		</td>
		<td><img border="0" src="<html:rewrite page="/images/globalhome_background.jpg" />"></td>
		<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	<tr>
	   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	</tr>
	</table>
</logic:equal>
