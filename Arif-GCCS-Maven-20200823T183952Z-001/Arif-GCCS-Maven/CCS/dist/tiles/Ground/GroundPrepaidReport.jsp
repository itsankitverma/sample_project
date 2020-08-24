<%@page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.fedex.lacitd.cashcontrol.biztier.common.CreditCardPymtReportVO"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%@taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean-el" %>

<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
    response.setContentType("application/vnd.ms-excel");
%>
<HTML>
<BODY>
<table>
    <tr>
        <td align=center colspan=2><b><bean:message key="app.title.GroundPrepaidreport"/></b></td>
    </tr>
</table>
<br>
<table>
    <tr>
        <td align=right><b><bean:message key="app.message.StartDate"/></b></td>
        <td align=left><b><bean:write name="startDate" formatKey="app.format.Date"/></b></td>
    </tr>
    <tr>
        <td align=right><b><bean:message key="app.message.EndDate"/></b></td>
        <td align=left><b><bean:write name="endDate" formatKey="app.format.Date"/></b></td>
    </tr>
</table>
<br><br>
<table>
    <tr><td><b><bean:message key="app.title.RODPayments" /></b></td></tr>
</table>
<table border=1>
    <tr>
        <th><bean:message key="app.messages.Location"/></th>
        <th><bean:message key="app.messages.BatchID"/></th>
        <th><bean:message key="app.messages.AWBNumber"/></th>
        <th><bean:message key="app.messages.CloseDate"/></th>
        <th><bean:message key="app.messages.PaymentAmount"/></th>
        <th><bean:message key="app.messages.PaymentType"/></th>
        <th><bean:message key="app.messages.OtherNumber"/></th>
        <th><bean:message key="app.messages.CreditCardNumber"/></th>
        <th><bean:message key="app.messages.ExpirationDate"/></th>
        <th><bean:message key="app.messages.StatusId"/></th>
        <th><bean:message key="app.messages.Comment"/></th>
    </tr>
    <logic:iterate id="ccPymtVO" name="pymtRODList">
        <tr>

            <% Double amt = new Double(((CreditCardPymtReportVO)ccPymtVO).getPaymentAmt());
            pageContext.setAttribute("amt",amt); %>

            <td align=center><bean:write name="ccPymtVO" property="locationCd" /></td>
            <td align=center><bean:write name="ccPymtVO" property="batchId" /></td>
            <td align=center>'<bean:write name="ccPymtVO" property="awbNbr" /></td>
            <td align=center><bean:write name="ccPymtVO" property="closeDt" formatKey="app.format.Date"/></td>
            <td align=right><bean:write name="amt" format="###########0.00"/></td>
            <td align=right><bean:write name="ccPymtVO" property="paymentType" /></td>
            <td align=right><bean:write name="ccPymtVO" property="otherNbr" /></td>
            <td align=right>'<bean:write name="ccPymtVO" property="creditCardNbr" /></td>
            <td align=right><bean:write name="ccPymtVO" property="creditCardExpDt" /></td>
            <td align=center><bean:write name="ccPymtVO" property="statusId" /></td>
            <td align=left><bean:write name="ccPymtVO" property="comment" /></td>
        </tr>
    </logic:iterate>
</table>

<br><br>
<table>
    <tr>
        <td><b><bean:message key="app.title.PrepaidPayments" /></b></td>
    </tr>
</table>
<table border=1>
    <tr>
        <th><bean:message key="app.messages.Location"/></th>
        <th><bean:message key="app.messages.BatchID"/></th>
        <th><bean:message key="app.messages.AWBNumber"/></th>
        <th><bean:message key="app.messages.CloseDate"/></th>
        <th><bean:message key="app.messages.PaymentAmount"/></th>
        <th><bean:message key="app.messages.PaymentType"/></th>
        <th><bean:message key="app.messages.OtherNumber"/></th>
        <th><bean:message key="app.messages.CreditCardNumber"/></th>
        <th><bean:message key="app.messages.ExpirationDate"/></th>
        <th><bean:message key="app.messages.StatusId"/></th>
        <th><bean:message key="app.messages.Comment"/></th>
    </tr>
    <logic:iterate id="ccPymtVO" name="pymtPREPAIDList">
        <tr>
            <% Double amt = new Double(((CreditCardPymtReportVO)ccPymtVO).getPaymentAmt());
                pageContext.setAttribute("amt",amt); %>

        	<td align=center><bean:write name="ccPymtVO" property="locationCd" /></td>
            <td align=center><bean:write name="ccPymtVO" property="batchId" /></td>
            <td align=center>'<bean:write name="ccPymtVO" property="awbNbr" /></td>
            <td align=center><bean:write name="ccPymtVO" property="closeDt" formatKey="app.format.Date"/></td>
            <td align=right><bean:write name="amt" format="###########0.00"/></td>
            <td align=right><bean:write name="ccPymtVO" property="paymentType" /></td>
            <td align=right><bean:write name="ccPymtVO" property="otherNbr" /></td>
            <td align=right>'<bean:write name="ccPymtVO" property="creditCardNbr" /></td>
            <td align=right><bean:write name="ccPymtVO" property="creditCardExpDt" /></td>
            <td align=center><bean:write name="ccPymtVO" property="statusId" /></td>
            <td align=left><bean:write name="ccPymtVO" property="comment" /></td>
        </tr>
    </logic:iterate>
</table>
<br><br>
<table>
    <tr><td><b><bean:message key="app.title.OACPayments"/></b></td></tr>
</table>
<table border=1>
    <tr>
        <th><bean:message key="app.messages.Location"/></th>
        <th><bean:message key="app.messages.BatchID"/></th>
        <th><bean:message key="app.messages.AWBNumber"/></th>
        <th><bean:message key="app.messages.CloseDate"/></th>
        <th><bean:message key="app.messages.PaymentAmount"/></th>
        <th><bean:message key="app.messages.PaymentType"/></th>
        <th><bean:message key="app.messages.OtherNumber"/></th>
        <th><bean:message key="app.messages.StatusId"/></th>
        <th><bean:message key="app.messages.Comment"/></th>
    </tr>
    <logic:iterate id="ccPymtVO" name="pymtOACList">
        <tr>
            <% Double amt = new Double(((CreditCardPymtReportVO)ccPymtVO).getPaymentAmt());
                pageContext.setAttribute("amt",amt); %>
            <td align=center><bean:write name="ccPymtVO" property="locationCd" /></td>
            <td align=center><bean:write name="ccPymtVO" property="batchId" /></td>
            <td align=center>'<bean:write name="ccPymtVO" property="awbNbr" /></td>
            <td align=center><bean:write name="ccPymtVO" property="closeDt" formatKey="app.format.Date"/></td>
            <td align=right><bean:write name="amt" format="###########0.00"/></td>
            <td align=right><bean:write name="ccPymtVO" property="paymentType" /></td>
            <td align=right><bean:write name="ccPymtVO" property="otherNbr" /></td>
            <td align=center><bean:write name="ccPymtVO" property="statusId" /></td>
            <td align=left><bean:write name="ccPymtVO" property="comment" /></td>
        </tr>
    </logic:iterate>
</table>
<br><br>
<table>
    <tr><td><b><bean:message key="app.title.POAPayments"/></b></td></tr>
</table>
<table border=1>
    <tr>
        <th><bean:message key="app.messages.Location"/></th>
        <th><bean:message key="app.messages.BatchID"/></th>
        <th><bean:message key="app.messages.accountNbr"/></th>
        <th><bean:message key="app.messages.CloseDate"/></th>
        <th><bean:message key="app.messages.PaymentAmount"/></th>
        <th><bean:message key="app.messages.PaymentType"/></th>
        <th><bean:message key="app.messages.OtherNumber"/></th>
        <th><bean:message key="app.messages.Comment"/></th>
    </tr>
    <logic:iterate id="ccPymtVO" name="pymtPOAList">
        <tr>
            <% Double amt = new Double(((CreditCardPymtReportVO)ccPymtVO).getPaymentAmt());
                pageContext.setAttribute("amt",amt); %>

            <td align=center><bean:write name="ccPymtVO" property="locationCd" /></td>
            <td align=center><bean:write name="ccPymtVO" property="batchId" /></td>
            <td align=center>'<bean:write name="ccPymtVO" property="acctNbr" /></td>
            <td align=center><bean:write name="ccPymtVO" property="closeDt" formatKey="app.format.Date"/></td>
            <td align=right><bean:write name="amt" format="###########0.00"/></td>
            <td align=right><bean:write name="ccPymtVO" property="paymentType" /></td>
            <td align=right><bean:write name="ccPymtVO" property="otherNbr" /></td>
            <td align=left><bean:write name="ccPymtVO" property="comment" /></td>
        </tr>
    </logic:iterate>
</table>
<br><br>
<table>
    <tr><td><b><bean:message key="app.title.OtherPayments"/></b></td></tr>
</table>
<table border=1>
    <tr>
        <th><bean:message key="app.messages.Location"/></th>
        <th><bean:message key="app.messages.BatchID"/></th>
        <th><bean:message key="app.messages.Description"/></th>
        <th><bean:message key="app.messages.CloseDate"/></th>
        <th><bean:message key="app.messages.PaymentAmount"/></th>
        <th><bean:message key="app.messages.PaymentType"/></th>
        <th><bean:message key="app.messages.OtherNumber"/></th>
        <th><bean:message key="app.messages.Comment"/></th>
    </tr>
    <logic:iterate id="ccPymtVO" name="pymtOTHERList">
        <tr>
            <% Double amt = new Double(((CreditCardPymtReportVO)ccPymtVO).getPaymentAmt());
                pageContext.setAttribute("amt",amt); %>

            <td align=center><bean:write name="ccPymtVO" property="locationCd" /></td>
            <td align=center><bean:write name="ccPymtVO" property="batchId" /></td>
            <td align=center>'<bean:write name="ccPymtVO" property="description" /></td>
            <td align=center><bean:write name="ccPymtVO" property="closeDt" formatKey="app.format.Date"/></td>
            <td align=right><bean:write name="amt" format="###########0.00"/></td>
            <td align=right><bean:write name="ccPymtVO" property="paymentType" /></td>
            <td align=right><bean:write name="ccPymtVO" property="otherNbr" /></td>
            <td align=left><bean:write name="ccPymtVO" property="comment" /></td>
        </tr>
    </logic:iterate>
</table>
<br><br>
<table>
    <tr><td><b><bean:message key="app.title.GroundPayments"/></b></td></tr>
</table>
<table border=1>
    <tr>
        <th><bean:message key="app.messages.Location"/></th>
        <th><bean:message key="app.messages.BatchID"/></th>
        <th><bean:message key="app.messages.GroundTkNbr"/></th>
        <th><bean:message key="app.messages.CloseDate"/></th>
        <th><bean:message key="app.messages.PaymentAmount"/></th>
        <th><bean:message key="app.messages.PaymentType"/></th>
        <th><bean:message key="app.messages.OtherNumber"/></th>
        <th><bean:message key="app.messages.Comment"/></th>
    </tr>
    <logic:iterate id="ccPymtVO" name="pymtGROUNDList">
        <tr>
            <% Double amt = new Double(((CreditCardPymtReportVO)ccPymtVO).getPaymentAmt());
                pageContext.setAttribute("amt",amt); %>
            <td align=center><bean:write name="ccPymtVO" property="locationCd" /></td>
            <td align=center><bean:write name="ccPymtVO" property="batchId" /></td>
            <td align=center>'<bean:write name="ccPymtVO" property="gndTkNbr" /></td>
            <td align=center><bean:write name="ccPymtVO" property="closeDt" formatKey="app.format.Date"/></td>
            <td align=right><bean:write name="amt" format="###########0.00"/></td>
            <td align=right><bean:write name="ccPymtVO" property="paymentType" /></td>
            <td align=right><bean:write name="ccPymtVO" property="otherNbr" /></td>
             <td align=left><bean:write name="ccPymtVO" property="comment" /></td>
        </tr>
    </logic:iterate>
</table>
<br><br>
<table>
    <tr>
        <td align=center><b><bean:message key="app.title.PropietaryAndconfidential"/></b></td>
    </tr>
</table>
</BODY>
</HTML>