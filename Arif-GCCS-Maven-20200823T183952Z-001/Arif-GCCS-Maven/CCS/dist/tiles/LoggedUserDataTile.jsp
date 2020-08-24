<%--
  LoggerUserData.jsp - This page shows the data related with the user logged in
                       the system.
  Requirements: <varname> <scope><type><description>
         1-  profile session com.fedex.lacitd.cashcontrol.common.EmployeeProfile - Profile of the user
--%>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>

<%@ page buffer="64kb"%>

<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*" %>
<%@page import="com.fedex.lacitd.cashcontrol.common.*" %>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
function logout(){
    document.location='<%=request.getContextPath()%>/Logout.do?accion=LOGOUT';
}
</script>

<logic:notPresent name="userProfile" scope="session">
<table border="0" width="100%" cellspacing="1" cellpadding="0" bgcolor="#808080">
  <tr>
    <td width="66%" bgcolor="#73148C">&nbsp;</td>
    <td width="11%" bgcolor="#73148C"><font size="1" color="#FFFFFF" face="Arial"><b> <bean:message key="app.date" /></b></font></td>
    <td width="11%" colspan="2" bgcolor="#FFFFFF"><font size="1" color="#000000" face="Arial"><%=new SimpleDateFormat("MMM. dd, yyyy HH:mm",request.getLocale()).format(Utils.changeDateToTZ(new Date(),"GMT"))%> GMT</font></td>
  </tr>
</table>
</logic:notPresent>
<logic:present name="userProfile" scope="session">
    <%
            String dt=null;
            String tz=((EmployeeProfile)session.getAttribute("userProfile")).getLocationTimeZone();
            if(tz==null){
                dt=new SimpleDateFormat("MMM. dd, yyyy HH:mm",request.getLocale()).format(Utils.changeDateToTZ(new Date(),"GMT"))+" GMT";
            }else{
                dt=new SimpleDateFormat("MMM. dd, yyyy HH:mm",request.getLocale()).format(Utils.changeDateToTZ(new Date(),tz));
            }
    %>
<table border="0" width="100%" cellspacing="1" cellpadding="0" bgcolor="#808080">
  <tr>
    <td width="10%" bgcolor="#73148C"><font size="1" color="#FFFFFF" face="Arial"><b><bean:message key="app.userName" /></b></font></td>
    <td width="15%" bgcolor="#FFFFFF"><font size="1" color="#000000" face="Arial"><bean:write name="userProfile" property="employeeName" /></font></td>
    <td width="8%" bgcolor="#73148C"><font size="1" color="#FFFFFF"  face="Arial"><b>FedEx ID</b></font></td>
    <td width="8%" bgcolor="#FFFFFF"><font size="1"   color="#000000" face="Arial"><bean:write name="userProfile" property="employeeId" /></font></td>
    <td width="8%" bgcolor="#73148C"><font size="1" color="#FFFFFF" face="Arial"><b><bean:message key="app.location" /></b></font></td>
    <td width="8%" bgcolor="#FFFFFF"><font size="1"  color="#000000" face="Arial"><bean:write name="userProfile" property="locationCd" /></font></td>
    <td width="8%" bgcolor="#73148C"><font size="1" color="#FFFFFF" face="Arial"><b><bean:message key="app.date" /></b></font></td>
    <td width="8%" nowrap bgcolor="#FFFFFF"><font size="1"  color="#000000" face="Arial"><%=dt%>

</font></td>
   </tr>
   <tr>
    <td width="30%" colspan="8" bgcolor="#FFFFFF">
      <p align="right"><font size="1" face="Arial"><a href="<%=request.getContextPath()%>/Menu.do" target='_top'><b><bean:message key="app.mainMenu" /></b></a>
                                    <bean:define id="locts" toScope="page" name="userProfile" property="locations" type="java.util.Collection" />
                                    <%if(locts.size()>1){%>
                                        &nbsp;&nbsp;<a  href="<html:rewrite page="/SelectLocation.do" />" target='_top'><b><bean:message key="app.messages.ChangeLocation" /></b></a>
                                    <%}%>        
                                        &nbsp;&nbsp;<a href="<html:rewrite page='/tiles/Logout.jsp'/>" target='_top'><b><bean:message key="app.logout" /></b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>
  </tr>
</table>
</logic:present>
<table border="0" width="100%" cellspacing="3" cellpadding="0" bgcolor="#FFFFFF">
  <tr>
    <td width="100%" bgcolor="#FFFFFF"><img src=pixel.gif width="1" height="1"></td>
  </tr>
</table>