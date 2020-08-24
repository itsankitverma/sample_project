<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<script>
function getDetails(imptId){
   var w=500;
   var h=550;
   if(w>screen.width)w=screen.width;

   if(h>screen.height)h=screen.height;
     var leftpos=(screen.width-w) / 2;
     var toppos=(screen.height-h) / 2;
	 var strutAction = "<html:rewrite page="/Import/ViewExternalFilesImportingStatus.do"/>";
     window.open(strutAction + "?action=details&id=" + imptId, "detailsWindow", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes");
}
</script>
<html:errors />
<br>
<br>
<br>
<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000" bordercolor="#000099">
  <tr>
    <td align="center" bgcolor="#660099" colspan="5"><font size="+2"color="#ffffff" ><b><bean:message key="app.messages.ExternalFilesImport" /></b></font></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#660099" width="15%"><font color="#ffffff"><b><bean:message key="app.messages.FileName"/></b></font></td>
    <td align="center" bgcolor="#660099" width="8%"><font color="#ffffff"><b><bean:message key="app.location"/></b></font></td>
    <td align="center" bgcolor="#660099" width="20%" ><font color="#ffffff"><b><bean:message key="app.messages.DateProcessed"/></b></font></td>
    <td align="center" bgcolor="#660099" width="15%" ><font color="#ffffff"><b><bean:message key="app.messages.Status"/></b></font></td>
    <td align="center" bgcolor="#660099" width="42%"><font color="#ffffff"><b><bean:message key="app.messages.Message"/></b></font></td>
  </tr>
<logic:present name="colExtFileStatus" scope="request" >
 <logic:iterate name="colExtFileStatus" id="elem" indexId="idx" type="com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptLogVO">    
    <%  
        String bgColor=((idx.intValue()%2)==0?"#c8ced7":"#ffffff");
    %>
  <tr>
    <td bgcolor="<%=bgColor%>" align="center" width="15%">
		<b><font  size="2" face="Verdana, Arial, Helvetica, sans-serif">
			<bean:write name="elem" property="imptFileNm" /></font></b>
	</td>
    <td align="center" bgcolor="<%=bgColor%>" width="8%"><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="locationCd" /></font></b>
	</td>
    <td align="center" bgcolor="<%=bgColor%>" width="20%"><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><%=elem.getImptDt().toGMTString()%></font></b>
	</td>
    <td align="center" bgcolor="<%=bgColor%>" width="15%"><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">
            <logic:equal name="elem" property="statusCd" value="2">
                <bean:message key="app.messages.ImportStatusOk" />
            </logic:equal>
			<logic:equal name="elem" property="statusCd" value="1">
                <bean:message key="app.messages.ImportStatusOk" />
            </logic:equal>
            <logic:equal name="elem" property="statusCd" value="0">
                <bean:message key="app.messages.ImportStatusErrors" />
            </logic:equal>
        </font></b>
	</td>
    <td align="left" bgcolor="<%=bgColor%>" width="42%">
		<table width="100%">
			 <tr>
				 <td width="80%">
					<b><font  size="2" face="Verdana, Arial, Helvetica, sans-serif">
					<bean:write name="elem" property="message"/>&nbsp;</font></b>
				</td>
				<td width="20%" align="center">
				   <logic:equal name="elem" property="statusCd" value="2">
						<a href="javascript:getDetails(<bean:write name="elem" property="imptId"/>);" >
						   <img  align="center" border="0" src="<html:rewrite page="/images/details.gif"/>" alt="<bean:message key="app.messages.Detail"/>"/>
						</a>
		           </logic:equal>
				</td>	
			 </tr>
		</table>
	</td>
  </tr>
  </logic:iterate>
</logic:present>
</table>
<br><br>
<table width="100%">
</table>
<p>&nbsp;</p>
