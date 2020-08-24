<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<% double totalLocal=0.0,totalUsd=0.0;%>
<html:errors />
<br>
<br>
<br>
<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000" bordercolor="#000099">
  <tr>
    <td align="center" bgcolor="#660099" colspan="10"><font size="+2"color="#ffffff" ><b><bean:message key="app.messages.ExternalRODFilesImport" /></b></font></td>
  </tr>
  <tr>
	<td align="center" bgcolor="#660099" ><font color="#ffffff" ><b>#</b></font></td>  
    <td align="center" bgcolor="#660099" width="10%"><font color="#ffffff" ><b><bean:message key="app.messages.AWBNumber" /></b></font></td>
    <td align="center" bgcolor="#660099" width="8%"><font color="#ffffff" ><b><bean:message key="app.messages.Location" /></b></font></td>
    <td align="center" bgcolor="#660099" width="20%" ><font color="#ffffff" ><b><bean:message key="app.messages.CustomerInvoice" /></b></font></td>
    <td align="center" bgcolor="#660099" width="7%" ><font color="#ffffff" ><b><bean:message key="app.date" /></b></font></td>
    <td align="center" bgcolor="#660099" width="10%" ><font color="#ffffff" ><b><bean:message key="app.messages.Currency" /></b></font></td>
    <td align="center" bgcolor="#660099" width="10%" ><font color="#ffffff" ><b><bean:message key="app.messages.LocalCurrencyAmount" /></b></font></td>            
    <td align="center" bgcolor="#660099" width="10%" ><font color="#ffffff" ><b><bean:message key="app.messages.USDAmount1" /></b></font></td>    
    <td align="center" bgcolor="#660099" width="10%" ><font color="#ffffff" ><b><bean:message key="app.messages.ExchRate" /></b></font></td>
    <td align="center" bgcolor="#660099" width="10%"><font color="#ffffff" ><b><bean:message key="app.messages.Status" /></b></font></td>
  </tr>
<logic:present name="colRodFileDetails" scope="request" >
 <logic:iterate name="colRodFileDetails" id="elem" indexId="idx" type="com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO">    
    <%  
        String bgColor=((idx.intValue()%2)==0?"#c8ced7":"#ffffff");
        if(!"USD".equals(elem.getInvCurrency())){
	        totalLocal=totalLocal+elem.getRecAmt();
	    }else{    
    	    totalUsd=totalLocal+elem.getRecAmt();        
    	}    
    %>
  <tr>
	<td bgcolor="#660099" align="right" ><font  size="2"><b><font color="#ffffff" face="Verdana, Arial, Helvetica, sans-serif"><%=idx.intValue()+1%></font></td>  
    <td bgcolor="<%=bgColor%>" align="center" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="awbNbr" /></font></td>
    <td align="center" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="locationCd" /></font></b></td>
    <td align="center" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="customerNm" /> / <bean:write name="elem" property="recNbr" /></font></b></td>
    <td align="center" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="recDt" formatKey="app.format.Date" /></b></td>    
    <td align="center" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="invCurrency" /></b></td>     
	
	<logic:notEqual name="elem" property="invCurrency" value="USD">
	    <td align="right" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" formatKey="app.format.NumberFormat" property="recAmt" /></b></td>    
    	<td align="right" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">0.00	</b></td>    
    </logic:notEqual>
   	<logic:equal name="elem" property="invCurrency" value="USD">
	    <td align="right" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif">0.00</b></td>    
	    <td align="right" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" formatKey="app.format.NumberFormat" property="recAmt" /></b></td>    
    </logic:equal>    
    <td align="right" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" formatKey="app.format.NumberFormat" property="exchRateClnUsed" /></b></td>            
    <td align="left" bgcolor="<%=bgColor%>" ><font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="elem" property="chkinAgentComment"  />&nbsp;</font></b></td>    
  </tr>
  </logic:iterate>
  <% 
  	request.setAttribute("totalLocal",new Double(totalLocal));
  	request.setAttribute("totalUsd",new Double(totalUsd));
  %>
  <tr>
  		<td bgcolor="#ffffff" colspan="6" align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif">Total</font></b></td>
	    <td bgcolor="#ffffff" align="right" ><font  size="1"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="totalLocal" formatKey="app.format.NumberFormat" /></b></td>    
	    <td bgcolor="#ffffff" align="right" ><font  size="1"><b><font face="Verdana, Arial, Helvetica, sans-serif"><bean:write name="totalUsd" formatKey="app.format.NumberFormat" /></b></td>    
  		<td bgcolor="#ffffff" colspan="2" align="right">&nbsp;<td>	    
  </tr>
</logic:present>
</table>
