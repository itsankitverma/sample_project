<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<br>
<bean:define id="errorLog" name="logError" scope="request" type="com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptLogVO"/>

<table width="90%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000" bordercolor="#000099">
  <tr> 
    <td align="center" bgcolor="#660099" colspan="5"><font color="#ffffff"><b> 
      <bean:message key="app.messages.ExternalFilesImportDetails" /></b></font></td>
  </tr>
  <tr> 
    <td align="left" bgcolor="#660099" width="30%"><font color="#ffffff"><b><bean:message key="app.messages.FileName"/></b></font></td>
    <td width="70%" align="center" bgcolor="#FFFFFF"> <font size="2"><b><bean:write name="errorLog" property="imptFileNm"/></b></font></td>
  </tr>
  <tr> 
    <td align="left" bgcolor="#660099" width="30%"><font color="#ffffff"><b><bean:message key="app.location"/></b></font></td>
    <td align="center" bgcolor="#FFFFFF" width="70%"> <font size="2"><b><bean:write name="errorLog" property="locationCd"/></b></font></td>
  </tr>
  <tr> 
    <td align="left" bgcolor="#660099" width="30%" ><font color="#ffffff"><b><bean:message key="app.messages.DateProcessed"/></b></font></td>
    <td align="center" bgcolor="#FFFFFF" width="70%"> <font size="2"><b><bean:write name="errorLog" property="imptDt" formatKey="app.format.Date"/></b></font></td>
  </tr>
</table> 
<br>
<table width="100%" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000">
	<tr align="center" bgcolor="#660099" colspan="5">
		<td><font color="#ffffff"><bean:message key="app.tittle.ElementsDetails"/></font></td>
	</tr>
	<logic:present name="logErrorDetails" scope="request" >
	 <logic:iterate name="logErrorDetails" id="elem" indexId="idx" type="com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptErrorDtlVO">    
	 <tr>
	    <td align="left" bgcolor="#FFFFFF" width="70%">
		 <font size="2"><b>
             <c:out value="${elem.imptError}" escapeXml="false" ></c:out>
         </b></font>
		</td>
	 </tr>
	 </logic:iterate>
	</logic:present> 
</table>
<p>&nbsp;</p>
