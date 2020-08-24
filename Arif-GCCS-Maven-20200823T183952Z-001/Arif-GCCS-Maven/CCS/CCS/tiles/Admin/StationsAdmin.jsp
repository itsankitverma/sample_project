<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="calendar" %>

<script src="<html:rewrite page="/scripts/calendar.js" />"></script>
<script src="<html:rewrite page="/scripts/calendar-msgs-" /><bean:message key="app.Language" />.js"></script>
<script src="<html:rewrite page="/scripts/calendar-setup.js" />"></script>
<LINK REL ="stylesheet" TYPE="text/css" HREF="<html:rewrite page="/styles/calendar.css" />" TITLE="Style">

<%System.out.println("I am in JSP 1"); %>
<SCRIPT>
/* Check for status "request.getAttribute("Done saving input")"  
Then once its there then show a popup saying that data saved.
Then after click ok on that popup route to <a href="<html:rewrite page="/pages/Menu.jsp" />">
*/

    
	function save(){
	if(document.StationsAdminForm.status.value=='0' && document.StationsAdminForm.dateEntered.value.length==0 || document.StationsAdminForm.status.value=='1' && document.StationsAdminForm.dateEntered.value.length==0 )
	{
			alert("Your feedback is valuable to us. Please include valid date");
			return ;
		}
		if(document.StationsAdminForm.status.value=='0' && document.StationsAdminForm.comments.value.length==0)
	{
			alert("Your feedback is valuable to us. Please include your comments for Reject");
			return ;
		}
	/*	if(document.StationsAdminForm.status.value=='1' && document.StationsAdminForm.comments.value.length > 0)
	{
			alert("Comments cannot be added for status \"confirm\"");
			return ;
			
		}*/
		else
		{
		var frm=document.forms['StationsAdminForm'];
        frm.action.value='save';
        frm.submit();
		}	
	}
	
		
</SCRIPT> 



<html:errors />

<nested:form method="post" action="/Admin/StationsAdmin.do">
    <input type="hidden" name="action" >
<div align="center">
	<table border="0" width="802" cellspacing="0" cellpadding="0" bgcolor="#000000" style="border-collapse: collapse" bordercolor="#111111" height="238">
	  <tr>
			<td bgcolor="#808080" width="7" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="2" width="785" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="10" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="7" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="2" width="785" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="10" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="392" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="393">
			&nbsp;</td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  		  <tr>
			<td bgcolor="#808080" width="7" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#FFFF9C" colspan="2" width="785" height="3" Align="center">
				<font face="Arial">Have reviewed the GCCS Payment Handling Controls and Procedures</font></td>
			<td bgcolor="#808080" width="10" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>


	  <tr >
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">Fedex Id&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393" background="#808080" >
			<font face="Arial" >
			<nested:text property="fedexId" maxlength="6" size="5" disabled="true" style="color : gray" /></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	
		<!-- CALENDAR  -->
		<tr>
         <td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">Date Entered&nbsp;&nbsp;&nbsp;</font></b></td>
			<td width="197" bgcolor="#FFFF9C" height="22"><font face="Arial" size="2">
                 <%String iconUrl=request.getContextPath()+"/images/cal.gif";%>
           <calendar:calendar property="dateEntered" srcIcon="<%=iconUrl%>" format="%m/%d/%Y"   /> (MM/DD/YYYY)
            </font>
           </td>
       <td bgcolor="#808080" width="10" height="22">&nbsp;</td>
         </tr>	
		<!--  -->
	  
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">Status&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:select property="status">
					<html:option value="0">Reject</html:option>
                    <html:option value="1">Confirm</html:option>
                </nested:select>
			</font></td>
			
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	<tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2">Comments&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<nested:textarea property="comments" /></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
		
		 
		
	  </tr>
	  
      <input type="hidden" name="certificationTypeDescription" value="EMPLOYEE_CLEARING">

	  <tr>
			<td bgcolor="#808080" width="7" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#FFFF9C" colspan="2"height="3" width="785">
			<p align="center">
			<a href="javascript:save();"><img  align="center" border="0" src="/GCCS/images/SaveEn.gif" align="left" width="114" height="38"></a>
			<a href="<html:rewrite page="/pages/Menu.jsp" />"><img align="center" border="0" src="/GCCS/images/CloseEn.gif" align="left" width="113" height="38"></a>
			</p>
			</td>
			<td bgcolor="#808080" width="10" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
	  </tr>
	    <tr>
	    <td bgcolor="#808080" width="7" height="84">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1"></font></td>
	  <td bgcolor="#FFFF9C" colspan="2"height="3" width="785">
	  <p align="center">
	  <logic:present name="messages">
	  <logic:iterate id="msg" name="messages">
	  <bean:write name="msg"/><br>
	  </logic:iterate>
	  </logic:present>
	  </p>
	  </td>
	  <td bgcolor="#808080" width="10" height="84"><img border="0" src="pixel.gif" width="1"></td>
	   </tr>
	

	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="392" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="393">
			&nbsp;</td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="785" colspan="2" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="10" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="785" colspan="2" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="10" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
</table>
    </div>
</nested:form>