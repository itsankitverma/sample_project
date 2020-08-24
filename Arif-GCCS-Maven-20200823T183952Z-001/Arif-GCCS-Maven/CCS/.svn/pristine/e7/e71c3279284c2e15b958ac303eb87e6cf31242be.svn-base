<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic-el.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%
    Integer requestID=(Integer)request.getSession().getAttribute("requestID");
    if(requestID==null) requestID=new Integer(-1);
      
    EmployeeProfile ep=(EmployeeProfile)session.getAttribute("userProfile");  
 
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>
   if(opener.document.forms['PoaAddPaymentForm']){
		opener.document.forms['PoaAddPaymentForm'].elements['requestID'].value="<%=requestID%>";
   }

   function addInvoices(){
	    var form=document.forms['PoaAddPaymentForm'];
	    if(validate()){
		    form.elements['action'].value='addFoundDetails';
			form.target="ParentPoa";
			form.submit();
			window.close();
		}
	}

	function validate(){
	    var form=document.forms['PoaAddPaymentForm'];
		var i=Number(0);
		var j=Number(0);

		while(eval("form.elements['invoices["+i+"].invoiceNbr']")){
			if(eval("form.elements['invoices["+i+"].selected']").checked){
	        	while(eval("form.elements['details["+j+"].poaDetail.invoiceNbr']")){
	        		if(eval("form.elements['invoices["+i+"].invoiceNbr']").value==eval("form.elements['details["+j+"].poaDetail.invoiceNbr']").value){
	        			alert('<bean:message key="app.messages.js.Invoice#" /> '+ eval("form.elements['invoices["+i+"].invoiceNbr']").value  +' <bean:message key="app.messages.js.DuplicateInvoices" />');
	        			return false;
	        		}
	        		j++;
	        	}
	        }
        	i++;
        }
        return true;
	}

    function goPage(page) {
        var form=document.forms['PoaAddPaymentForm'];
        form.elements['action'].value = 'findInvoicesByAccount';
        form.pageNumber.value = page;
        form.submit();
    }
</script>
<html:errors />
<nested:form action="/Poa/PoaAddPayment.do" method="post">
    <input type="hidden" name="requestID" value="<%=requestID%>">
    <nested:hidden property="pageNumber"/>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr>
            <td align="center">
                <util:paging numberOfPages="${numberOfPages}" pageNumber="${PoaAddPaymentForm.pageNumber}" varStatus="std" style="font-family:Arial,Helvetica,Sans-Serif" >
                    <html:link href="javascript:goPage(${std.count})"><c:out value="${std.count}"/></html:link>
                </util:paging>
            </td>
        </tr>
    </table>
    <table border="0" bgcolor="#000000" cellspacing="1" width="100%">
	    <tr>
            <td bgColor="#73148C" align="center" width="10%" height="11">
                <font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">
                    <bean:message key="app.messages.Number" />
                </font>
            </td>
    		<td bgColor="#73148C" align="center" width="10%" height="11">
                <font face="Verdana,Arial, Helvetica, sans-serif" size="1" color="#FFFFFF">
                    <bean:message key="app.date" />
                </font>
            </td>
    		<td bgColor="#73148C" align="center" width="15%" height="11">
                <font face="Verdana,Arial, Helvetica, sans-serif" size="1" color="#FFFFFF">
                    <bean:message key="app.messages.Account" />
                </font>
            </td>
		    <td bgColor="#73148C" align="center" width="20%" height="11">
                <font face="Verdana,Arial, Helvetica, sans-serif" size="1" color="#FFFFFF">
                    <bean:message key="app.messages.Customer" />
                </font>
            </td>
		    <td bgColor="#73148C" align="center" width="10%" height="11">
                <font face="Verdana,Arial, Helvetica, sans-serif" size="1" color="#FFFFFF">
                    <bean:message key="app.messages.Currency" />
                </font>
            </td>
		    <td bgColor="#73148C" align="center" width="15%" height="11">
                <font face="Verdana,Arial, Helvetica, sans-serif" size="1" color="#FFFFFF">
                    <bean:message key="app.messages.Amount" />
                </font>
            </td>
		    <td bgColor="#73148C" align="center" width="10%" height="11">
                <font face="Verdana,Arial, Helvetica, sans-serif" size="1" color="#FFFFFF">
                    <bean:message key="app.messages.Balance" />
                </font>
            </td>
    	    <td bgColor="#73148C" align="center" width="10%" height="11">
                <font face="Verdana,Arial, Helvetica, sans-serif" size="1" color="#FFFFFF">
                    Select
                </font>
            </td>
	    </tr>
        <nested:iterate property="invoices" indexId="idx" >
	        <%String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff"); %>
	        <nested:hidden property="fedexAccountNbr" />
	        <nested:hidden property="customerNm" />
	        <nested:hidden property="invoiceNbr" />
	        <nested:hidden property="currencyCd" />
	        <nested:hidden property="exchRate" />
	        <nested:hidden property="invoiceAmt" />
	        <nested:hidden property="amtDue" />
	        <nested:hidden property="invoiceAmtUsd" />
	        <nested:hidden property="amtDueUsd" />
	
	        <logic:present name="requestID">
		        <input type="hidden" name="requestID" value="<bean:write name="requestID" scope="session" />" >
	        </logic:present>
	        <tr>
    	        <td align="middle" bgColor="<%=bgColor%>" width="93" height="12">
                    <font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                        <nested:write property="invoiceNbr" />
                    </font>
                </td>
   		        <td align="middle" bgColor="<%=bgColor%>" width="86" height="12">
                    <font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                        <nested:write property="invoiceDt" formatKey="app.format.Date" />
                    </font>
                </td>
    	        <td align="middle" bgColor="<%=bgColor%>" width="85" height="12">
                    <font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                        <nested:write property="fedexAccountNbr" />
                    </font>
                </td>
    	        <td align="left" bgColor="<%=bgColor%>" width="157" height="12">
                    <font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                        <nested:write property="customerNm"/>
                    </font>
                </td>
    	        <td align="middle" bgColor="<%=bgColor%>" width="54" height="12">
                    <font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                        <nested:write property="currencyCd"/>
                    </font>
                </td>
            	<td align="right" bgColor="<%=bgColor%>" width="83" height="12">
                    <font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                        <nested:write property="invoiceAmt" formatKey="app.format.NumberFormat"/>
                    </font>
                </td>
            	<td align="right" bgColor="<%=bgColor%>" width="91" height="12">
                    <font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                        <nested:write property="amtDue" formatKey="app.format.NumberFormat" />
                    </font>
                </td>
                <td align=center bgColor="<%=bgColor%>" height="12" width="50">
                    <nested:checkbox property="selected" />
                </td>
            </tr>
        </nested:iterate>
        <tr>
            <td align="right" align=middle bgColor="#C0C0C0" colspan="8">
                <input type="button" value='<bean:message key="app.messages.Save" />' onclick="addInvoices();">
            </td>
        </tr>
    </table>
	<%--Maintain the values from the principal page--%>
    <input type="hidden" name="action" value="">
    <nested:hidden property="payment.poaPaymentsId" />
    <nested:hidden property="payment.coupPymtAmt" />
	<nested:hidden property="payment.chkinAgentComment"/>
	<nested:hidden property="payment.otherComment"/>
    <nested:hidden property="payment.courierId" />
	<nested:hidden property="payment.accountNbr" />
	<nested:hidden property="payment.exchRate" />	
	<nested:hidden property="payment.customerNm" />
    <nested:hidden property="payment.paymentCurrency"  />
    <nested:hidden property="payment.paymentType" />
    <nested:hidden property="payment.otherDocNbr" />
	<nested:hidden property="payment.paymentAmt" />
	<nested:iterate property="details" id="detail" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.PoaDetailSurchargesVO">    
		<nested:hidden property="poaDetail.poaDetailId" />
		<nested:hidden property="surChargesTotal" />
		<nested:hidden property="usdAmount"/>
		<nested:hidden property="poaDetail.invoiceNbr" />
		<nested:hidden property="poaDetail.amount" />
		<nested:hidden property="poaDetail.couponAmt" />
	</nested:iterate>
</nested:form>