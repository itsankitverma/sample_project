<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<script>
	function viewInvoices(logId){
		        var w=800;
                var h=500;
                if(w>screen.width)w=screen.width;
                if(h>screen.height)h=screen.height;
                var leftpos=(screen.width-w) / 2;
                var toppos=(screen.height-h) / 2;
                window.open("<html:rewrite page="/ROD/ViewRodFileImportingStatus.do" />?action=Details&logId="+logId,"addReceivableWindow","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, width="+w+", height="+h+",left="+leftpos+",top="+toppos);
		
	}
</script>

<html:errors />
<br>
<br>
<br>
<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000" bordercolor="#000099">
  <tr>
    <td align="center" bgcolor="#660099" colspan="9"><font size="+2"color="#ffffff" ><b><bean:message key="app.messages.ExternalRODFilesImport" /></b></font></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#660099" width="15%"><font color="#ffffff" ><b><bean:message key="app.messages.FileName" /></b></font></td>
    <td align="center" bgcolor="#660099" width="5%"><font color="#ffffff" ><b><bean:message key="app.location" /></b></font></td>
    <td align="center" bgcolor="#660099" width="15%" ><font color="#ffffff" ><b><bean:message key="app.messages.DateProcessed" /></b></font></td>
    <td align="center" bgcolor="#660099" width="7%" ><font color="#ffffff" ><b><bean:message key="app.messages.AWBCount" /></b></font></td>
    <td align="center" bgcolor="#660099" width="10%" ><font color="#ffffff" ><b><bean:message key="app.messages.LocalCurrencyAmount" /></b></font></td>
    <td align="center" bgcolor="#660099" width="10%" ><font color="#ffffff" ><b><bean:message key="app.messages.USDAmount1" /></b></font></td>            
    <td align="center" bgcolor="#660099" width="10%" ><font color="#ffffff" ><b><bean:message key="app.messages.Status" /></b></font></td>
    <td align="center" bgcolor="#660099" width="15%"><font color="#ffffff" ><b><bean:message key="app.messages.Message" /></b></font></td>
  </tr>
<logic:present name="colRodFileStatus" scope="request" >
 <logic:iterate name="colRodFileStatus" id="elem" indexId="idx" type="com.fedex.lacitd.cashcontrol.datatier.valueobject.RodFileProcLogVO">    
 	<html:hidden name="elem" property="errorDtlDesc" />
    <%  
        String bgColor=((idx.intValue()%2)==0?"#c8ced7":"#ffffff");
    %>
  <tr>
    <td bgcolor="<%=bgColor%>" align="center"  ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="fileNm" /></font></td>
    <td align="center" bgcolor="<%=bgColor%>" width="5%" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="locationCd" /></font></b></td>
    <td align="center" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><%=elem.getProcessDt().toGMTString()%></font></b></td>
    <td align="right" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">&nbsp; <a href="javascript:viewInvoices(<bean:write name="elem" property="rodFilePrLogId" />)"><img border="0" src="<html:rewrite page="/images/bill.gif" />"></a>&nbsp;<bean:write name="elem" property="awbQty" /></b></td>    
    <td align="right" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" formatKey="app.format.NumberFormat" property="totalLocalAmt" /></b></td>    
    <td align="right" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" formatKey="app.format.NumberFormat" property="totalUsdAmt" /></b></td>            
    <td align="center" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
            <logic:equal name="elem" property="statusCd" value="1">
                <bean:message key="app.messages.ImportStatusOk" />
            </logic:equal>
            <logic:equal name="elem" property="statusCd" value="0">
                <bean:message key="app.messages.ImportStatusErrors" />
            </logic:equal>
        </font></b></td>
    <td align="left" bgcolor="<%=bgColor%>" width="15%"><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="message"  />&nbsp;</font></b><logic:notEmpty name="elem" property="errorDtlDesc" ><img border="0" alt="<bean:write name="elem" property="errorDtlDesc" />" src="<html:rewrite page="/images/details.gif" />"></logic:notEmpty></td>
  </tr>
  </logic:iterate>
</logic:present>
</table>
<br><br>
<table width="100%">
</table>
<p>&nbsp;</p>
