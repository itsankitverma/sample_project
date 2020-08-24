<%@page import="java.util.*,
                com.fedex.lacitd.cashcontrol.prestier.helper.PSCashInBankUpload,
                com.fedex.lacitd.cashcontrol.prestier.helper.PSWriteOffUpload,
                com.fedex.lacitd.cashcontrol.prestier.helper.ReadExchRateExcelFile" %>
<%@page import="java.text.*" %>
<%@ page import="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" %>
<%@ page import="com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper" %>
<%@ page import="com.fedex.lacitd.cashcontrol.common.monitoring.*" %>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<bean:define id="rInterval" scope="session" toScope="page" type="java.lang.Integer" name="userProfile" property="refreshInterval" />
<html:errors />
<%
    EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
    if (ep == null) response.sendRedirect("/Logout.do");
%>

<script>
    var finishingProcess=false;

    <%
        if("CashInBank".equals(request.getParameter("action"))){
            new PSCashInBankUpload().uploadJournalEntries();

            LogEventHelper.logEvent( request, Monitoring.MONITORING_EVENT_READ, "PSUpload CashInBank", "report generated", true);

            out.println("finishingProcess=true");
        }else{
            if("WriteOff".equals(request.getParameter("action"))){
                new PSWriteOffUpload().uploadJournalEntries();

                LogEventHelper.logEvent( request, Monitoring.MONITORING_EVENT_READ, "PSUpload WriteOff", "report generated", true);

                out.println("finishingProcess=true");
            }else{
                if("ExchRates".equals(request.getParameter("action"))){
                    new ReadExchRateExcelFile().publishExchRates(request.getParameter("exchRateDt"));

                    LogEventHelper.logEvent( request, Monitoring.MONITORING_EVENT_READ, "PSUpload ExchRates", "report generated", true);

                    out.println("finishingProcess=true");
                }
            }
        }

    %>

    if(finishingProcess){
         window.open('<html:rewrite page="/pages/ShowProcessing.jsp" />','ShowProcessing','').close();
    }

    var win;
    function submitForm(action){
        document.forms['PSUpload'].action.value=action;
        if(action=='ExchRates'){
                document.forms['PSUpload'].exchRateDt.value=prompt('Enter closing month to import Exchange Rates(YYYY-MM): ',getFormattedDate())
        }
        
        var leftpos=(screen.width-472) / 2;
        var toppos=(screen.height-236) / 2;
        win=window.open('<html:rewrite page="/pages/ShowProcessing.jsp" />','ShowProcessing','toolbar=no, directories=no, location=no, status=no, menubar=no, resizable=no, titlebar=no,scrollbars=no, width=472, height=236,left='+leftpos+',top='+toppos);
        window.onfocus="win.focus();";

        document.onmousedown=win.focus;
        document.onkeydown=win.focus;

        document.forms['PSUpload'].submit();
    }

    function getFormattedDate(){
        var d=new Date();
        var m="0"+(d.getMonth()+1);
        m=m.substr(m.length-2,2);
        return d.getFullYear()+'-'+m;
    }
</script>
    <% if("CashInBank".equals(request.getParameter("action"))){%>
          <font face="Arial" color="blue"  >
                <bean:message key="app.messages.PSCashInBankSuccessful" />
          </font>
    <% }else if("WriteOff".equals(request.getParameter("action"))){%>
          <font face="Arial" color="blue"  >
                <bean:message key="app.messages.PSWOffSuccessful" />
          </font>
    <% }%>
<br><br><br><br>
<FORM name="PSUpload" action="<html:rewrite page="/Admin/PSUpload.do" />">
    <input type="hidden" name="action" >
    <input type="hidden" name="exchRateDt" >
<TABLE cellSpacing=1 cellPadding=0 width="100%" align=center  border=0>
  <TBODY>
  <TR>
    <TD ><p align="center"><font face="Arial"  ><a href="javascript:submitForm('ExchRates')">Exchange Rates</a></FONT></TD>
  </TR>
  <TR>
    <TD ><p align="center"><font face="Arial"  ><a href="javascript:submitForm('CashInBank')"><bean:message key="app.title.PSCashInBankUpload" /></a></FONT></TD>
  </TR>
  <TR>
    <TD><p align="center"><font face="Arial"  ><a href="javascript:submitForm('WriteOff')"><bean:message key="app.title.PSWoffUpload" /></a></FONT></TD>
  </TR>
</TABLE>
</FORM>
