<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<br>
<html:errors />
<table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
<tr bgcolor="#808080" height="1">
	<td colspan=3><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
<tr>
	<td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="3"></td>
	<td bgcolor="#FFFF9C"><img src="/images/pixel.gif" width="1" height="3"></td>
	<td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="3"></td>
</tr>

<tr >
	<td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="1"></td>
	<td bgcolor="#FFFF9C">

    <div align="center">
	<!-- AQUI VA LA TABLA DEL SUMARY -->
	<table border="0" width="98%" bgcolor="#000000" cellspacing="1" cellpadding="0">
<tr>
	<td  colspan="5" align="center" bgcolor="#73148C"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="3" color="#FFFFFF"><bean:write name="pageTitle" /></font></td>
</tr>	
	  <r>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.ScanType" /></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Location" /></font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.EmployeeNumber" /></font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.date" /></font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Details" /></font></td>
      </tr>
<logic:present name="scans" scope="request" >
<logic:notEmpty name="scans" scope="request" >
  <logic:iterate name="scans" id="scan" indexId="idx">    

    <%  
        String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
        String fontColor="#000000";
    %>
	  <tr>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  width="15%"><b><font color="<bean:write name="scan" property="fontColor" />" face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:write name="scan" property="scanType" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  width="15%"><b><font color="<bean:write name="scan" property="fontColor" />" size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="scan" property="locationCd" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  width="15%"><b><font color="<bean:write name="scan" property="fontColor" />" size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="scan" property="employeeId" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  width="20%"><b><font color="<bean:write name="scan" property="fontColor" />" size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="scan" property="scanDtTm" format="MM/dd/yyyy hh:mm a" /></font></td>
   		 <td align="left" bgcolor="<%=bgColor%>" height="19"  width="35%"><b><font color="<bean:write name="scan" property="fontColor" />" size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="scan" property="details" /></font></td>
	  </tr>
  </logic:iterate>
</logic:notEmpty>
</logic:present>  
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
</table>

