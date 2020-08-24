<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<form action="<html:rewrite page="/Admin/AdminChangePassword.do"/>" name"lockPage" method="post">
<!-- Tabla separadora-->
<table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#808080">
<tr height="1">
	<td bgcolor="#808080" colspan="1" height="1"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
	<td bgcolor="#808080" colspan="1" height="1"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
</table>
<table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
<tr>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="3"></td>
	<td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="3"></td>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="3"></td>
</tr>
<tr >
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
	<td bgcolor="#FFFF9C">

    <div align="center"> <center> 
        <table border="0" width="98%" cellspacing="1" cellpadding="0">
          <tr> 
            <td colspan="2"> <p align="center">
				<b><font face="Arial" color="#73148C" size="5">LAC<br>
                <bean:message key="app.title" /><br><br></font><b>
			<br>
				<b><font face="Arial" color="#FF0000" size="3"><bean:message key="app.UserLockedQuestion" /></font></b>
            <td rowspan="4"> <p align="center"><img src="<%=request.getContextPath()%>/images/globalhome_background.jpg" border="0" width="307" height="236"></td>
          </tr>
          <tr> 
            <td align="center" colspan="2">
			<br><font color="#73148C"><b>
					<input type="radio" value="<bean:message key="app.message.Yes" />" name="reported">Yes &nbsp;&nbsp;
		            <input type="radio" value="<bean:message key="app.message.No" />"  name="reported" checked >No
					<input type="hidden" value="locked" name="action">
					<input type="hidden" value="<%=request.getAttribute("employeeId")%>" name="employeeId">
				</b></font>
			</td>	
		  </tr>
            <td align="center" colspan="2">
				<br><input name="submit" type="submit" value="   <bean:message key="app.submit"/>   ">
			</td>
          </tr>
        </table>
      </div>

	</td>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
<tr>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
	<td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="5"></td>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
<tr bgcolor="#808080" height="1">
	<td colspan=3><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
</table><form>
