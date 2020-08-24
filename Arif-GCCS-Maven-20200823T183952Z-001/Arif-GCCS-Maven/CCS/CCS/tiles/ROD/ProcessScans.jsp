<%@page import="java.util.*" %>
<%@page import="java.text.*" %>
<%@ page import="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" %>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<bean:define id="rInterval" scope="session" toScope="page" type="java.lang.Integer" name="userProfile" property="refreshInterval" />
<html:errors />

<%
    EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
    if (ep == null) response.sendRedirect("/Logout.do");
%>

<script>
    <logic:present name="NotProcessed">
        window.open('<html:rewrite page="/pages/ShowProcessing.jsp" />','ShowProcessing','').close();
    </logic:present>
    var win;
    function submitForm(){
        var leftpos=(screen.width-472) / 2;
        var toppos=(screen.height-236) / 2;
        win=window.open('<html:rewrite page="/pages/ShowProcessing.jsp" />','ShowProcessing','toolbar=no, directories=no, location=no, status=no, menubar=no, resizable=no, titlebar=no,scrollbars=no, width=472, height=236,left='+leftpos+',top='+toppos);
        window.onfocus="win.focus();";

        document.onmousedown=win.focus;
        document.onkeydown=win.focus;
       
        document.forms['processScans'].submitButton.onclick="";
        document.forms['processScans'].submitButton.onfocus="this.blur();";
        document.forms['processScans'].submit();
    }
    
function UpdateClock() {

   if(clockID) {
      clearTimeout(clockID);
      clockID  = 0;
   }

   secRemaining--;
  
   var min=secRemaining/60;
   var sec=secRemaining%60;   
   
   var secStr=String(sec<0?"00":sec<10?"0"+sec:sec);
   var minStr=String(parseInt(min));
  

   document.forms['processScans'].elements['clock'].value = minStr +":"+secStr;

   clockID = setTimeout("UpdateClock()", 1000);

}

function StartClock() {
   clockID = setTimeout("UpdateClock()", 1);
}

function KillClock() {
   if(clockID) {
      clearTimeout(clockID);
      clockID  = 0;
   }
}

    
</script>
<FORM  name="processScans" ACTION="<html:rewrite page="/ROD/ProcessScans.do" />" METHOD="POST" >
<bean:define id="rInterval" scope="session" toScope="page" type="java.lang.Integer" name="userProfile" property="refreshInterval" />
	<input type="hidden" name="firstTime" value="<%=request.getAttribute("firstTime")==null?"T":request.getAttribute("firstTime")%>">
<b><p align="right"><bean:message key="app.messages.RefreshEnabled" /> <html:checkbox disabled="true" name="userProfile" property="refreshEnable" />&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="app.messages.RefreshInterval" /> <bean:write name="userProfile" property="refreshInterval" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
<logic:present name="refreshStopped">
	<b><p align="right"><bean:message key="app.messages.RefreshStopped" /></p>	
</logic:present>

<logic:equal name="userProfile" property="refreshEnable" value="true">
	<logic:equal name="firstTime" value="F">
		<META HTTP-EQUIV="Refresh" CONTENT="<%=rInterval.intValue() * 60%>"> 		
<b><p align="right"><bean:message key="app.messages.PageWillRefresh" /> <input style="border=0;" size="4" type="text" name="clock"> </p>
	</logic:equal>
</logic:equal>	
<TABLE borderColor="#000099" cellSpacing=1 cellPadding=0 width="100%" align=center bgColor="#000000" border=0>
  <TBODY>
  <TR>
    <TD bgColor="#660099" colSpan=3><p align="center"><INPUT type="button" name="submitButton" onclick="submitForm();" value="<bean:message key="app.messages.RetrieveScansFromCOSMOS" />"><FONT color="#ffffff"></FONT></TD>
  </TR>
  <TR>
    <TD align=middle bgColor="#660099" width="20%"><FONT color="#ffffff"><B><bean:message key="app.messages.Type" /></B></FONT></TD>
    <TD align=middle bgColor="#660099" width="20%"><FONT color="#ffffff"><B><bean:message key="app.messages.AWBNumber" /></B></FONT></TD>
    <TD align=middle bgColor="#660099" width="80%"><FONT color="#ffffff"><B>Error</B></FONT></TD>
  </TR>

<logic:notPresent name="NotProcessed" scope="request">
  <TR>
    <TD align=center bgColor="#c8ced7" colspan="3"><FONT color="#ffffff"><B><bean:message key="app.messages.NotProcessedYet" /></B></FONT></TD>
  </TR>
</logic:notPresent>

<logic:present name="NotProcessed">
  <logic:equal name="NotProcessed" property="empty" value="true">
      <TR>
        <TD align=center bgColor="#c8ced7" colspan="3"><FONT color="#ffffff"><B><bean:message key="app.messages.NotErrorsProcessingScans" /></B></FONT></TD>
      </TR>
  </logic:equal>
  <logic:notEqual name="NotProcessed" property="empty" value="true">
      <logic:iterate name="NotProcessed" id="np" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.ScansProcessingError">
          <TR>
			<TD align=middle width="15%" bgColor="<%=(idx.intValue() % 2)==0?"c8ced7":"ffffff"%>"><FONT size=2><B><FONT face="Verdana, Arial, Helvetica, sans-serif">
				<logic:equal value="true" name="np" property="prepaid" >PREPAID</logic:equal>
				<logic:equal value="false" name="np" property="prepaid" >ROD</logic:equal>				
					</FONT></B></FONT>
			</TD>          
            <TD align=middle width="15%" bgColor="<%=(idx.intValue() % 2)==0?"c8ced7":"ffffff"%>"><FONT size=2><B><FONT face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="np" property="awbNumber" /></FONT></B></FONT></TD>
            <TD align=middle width="70%" bgColor="<%=(idx.intValue() % 2)==0?"c8ced7":"ffffff"%>"><FONT size=2><B><FONT face="Verdana, Arial, Helvetica, sans-serif">


              <logic:present name="np" property="errorMessage">

                  <bean:message key="<%=np.getErrorMessage()%>"
                                  arg0="<%=np.getArg0()%>"
                                  arg1="<%=np.getArg1()%>"
                                  arg2="<%=np.getArg2()%>" /></FONT></B></FONT></TD>

              </logic:present>

          </TR>
      </logic:iterate>
  </logic:notEqual>
</logic:present>
      
</TBODY>
</TABLE>
</FORM>
<BR><BR>
<P>&nbsp;</P></BODY></HTML>

<script>
var secRemaining=<%=rInterval.intValue() * 60%>+1;
var clockID = 0;   

if(document.forms['processScans'].elements['clock']){
	StartClock();
	document.onUnLoad=KillClock;
}
</script>