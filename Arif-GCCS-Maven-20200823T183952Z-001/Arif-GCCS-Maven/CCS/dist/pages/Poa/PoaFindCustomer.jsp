<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page contentType="text/html"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%
  response.setHeader("Cache-Control","no-store"); 
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0); 
%>
<script>
<%  Integer requestID=(Integer)request.getSession().getAttribute("requestID");
    if(requestID==null) requestID=new Integer(-1);
    
	com.fedex.lacitd.cashcontrol.biztier.common.PoaOutstInvoicesVO oiVO=(PoaOutstInvoicesVO) request.getAttribute("CustomerInvoice");
	if(oiVO==null){ %>	
	    opener.document.images['notFound'].src="<html:rewrite page="/images/NotFound"/><bean:message key="app.Language" />.gif";
		opener.document.forms['PoaAddPaymentForm'].elements['payment.accountNbr'].value="";
		opener.document.forms['PoaAddPaymentForm'].elements['payment.customerNm'].value="";
		
		opener.document.forms['PoaAddPaymentForm'].elements['payment.chequeDt'].value="";
		opener.document.forms['PoaAddPaymentForm'].elements['payment.chequeOrigin'].value="";
		
<%  }else{ %>
		opener.document.forms['PoaAddPaymentForm'].elements['payment.accountNbr'].value='<%=oiVO.getFedexAccountNbr()%>';
		<% String customerName = oiVO.getCustomerNm();
		   customerName=customerName.replace('"',' '); %>
		opener.document.forms['PoaAddPaymentForm'].elements['payment.customerNm'].value="<%=customerName%>";
		opener.document.forms['PoaAddPaymentForm'].elements['filter'].value="";
	    opener.document.images['notFound'].src="<html:rewrite page="/images/blank.gif"/>";
	    
	    opener.document.forms['PoaAddPaymentForm'].elements['payment.chequeDt'].value="";
		opener.document.forms['PoaAddPaymentForm'].elements['payment.chequeOrigin'].value="";
		
<%  } %>
	opener.document.forms['PoaAddPaymentForm'].elements['requestID'].value=<%=requestID%>
	window.close();
</script>