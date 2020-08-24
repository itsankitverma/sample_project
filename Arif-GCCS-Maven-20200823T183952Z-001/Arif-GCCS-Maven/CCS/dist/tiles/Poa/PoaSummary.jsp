<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.prestier.helper.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<bean:define toScope="page" id="userProfile" name="userProfile" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
    
    Integer requestID=(Integer)request.getSession().getAttribute("requestID");
    if(requestID==null) requestID=new Integer(-1);
%>
<html:errors />
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>
    function toROD(){
        var valid="";//validate(false);

        if(valid==""){
            var form=document.forms['PoaSummaryForm'];
            form.action.value="toROD";
            form.pageNumber.value=1;
            form.sortColumn.value="awb_nbr";
            form.sortDirection.value="asc";            
            form.submit();
        }else{
            alert(valid);
        }

    }

    function reassignPayments(){
    		var form=document.forms['PoaSummaryForm'];
            var w=400;
            var h=200;
            var index=Number(<bean:write name="offset" />);
            var count=Number(0);
            var empId;

	        while(eval("form.elements['payments["+index+"].poaPaymentsId']") && count<1){
	            if(eval("form.elements['payments["+index+"].selected']").checked){
	               count++;
	            }
	            index++;
	        }

	        if(count==0){
	        	alert("<bean:message key="app.messages.MustSelectPaymentReassign"/> ");
	        	return;
	        }
	        
	        var params="summary=false&oldEmployee=<bean:write name="PoaSummaryForm" property="courier"/>";
	                   
            
            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;
                   
            window.open("<html:rewrite page="/pages/ReassignPayments.jsp" />?"+params,"reassign","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }

    function toPrepaid(){
        var valid="";//validate(false);
        if(valid==""){
            var form=document.forms['PoaSummaryForm'];
            form.action.value="toPrepaid";
            form.pageNumber.value=1;
            form.sortColumn.value="awb_nbr";
            form.sortDirection.value="asc";
            form.submit();
        }else{
            alert(valid);
        }
    }

    function nextCourier(){
        var form=document.forms['PoaSummaryForm'];
        if(form.elements['courier'].selectedIndex < form.elements['courier'].length-1){
            form.elements['courier'].selectedIndex++;
            changeCourier();
        }
    }

    function previousCourier(){
        var form=document.forms['PoaSummaryForm'];
        if(form.elements['courier'].selectedIndex>0){
            form.elements['courier'].selectedIndex--;
            changeCourier();
        }
    }

    function changeCourier(){
        var form=document.forms['PoaSummaryForm'];
        form.pageNumber.value=1;
        form.sortColumn.value="paymentId";
        form.sortDirection.value="asc";
        form.submit();
    }

    function changeTab(currencyCode){
        var valid="";//validate(false);

        if(valid==""){
            var form=document.forms['PoaSummaryForm'];
            form.elements['previousCurrencyCode'].value=form.elements['currentCurrency'].value;
            form.elements['currentCurrency'].value=currencyCode;
            form.submit();
        }else{
            alert(valid);
        }
    }

    function courierReceiptReport(){
          var form=document.forms['createReports'];
          form.action="<html:rewrite page="/servlet/CourierReceiptReport" />";
          form.StyleSheet.value="XSLT/CourierReceiptReport.xsl";
          form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
          form.target="results";
          form.submit();
    } 


    function closeEmployee(){        
        var form=document.forms['PoaSummaryForm'];
        var valid="";//validate(true);

        if(valid==""){
            if(confirm('<bean:message key="app.messages.js.ConfirmCloseCourier" />')){ 
                 form.elements['action'].value='CloseEmployee';
                 form.submit();
            }    
        }else{
            alert(valid);
        }          
    }

    function changePaymentCurr(poaPaymentId,newCurr){        
        var form=document.forms['PoaSummaryForm'];
        if(confirm('<bean:message key="app.messages.js.TryToChangeRecPaymentCurrency" />')){ 
            form.elements['action'].value='ChangePaymentCurr';
            form.elements['poaPaymentId'].value=poaPaymentId;
            form.elements['newCurr'].value=newCurr;
            form.submit();
        }    
    }

    function deletePayment(idx){        
        if(confirm('<bean:message key="app.messages.js.PaymentDeletionConfirmation" />')){ 
            var form=document.forms['PoaSummaryForm'];

            if (form.elements['payments['+idx+'].poaPaymentsId']){
                    form.elements['poaPaymentsId'].value=form.elements['payments['+idx+'].poaPaymentsId'].value;
                    form.elements['action'].value='DeletePayment';
                    form.submit();
            }
        }
    }

    function findIndex(name,after){
        var from=name.indexOf("[",after)+1;
        var to=name.indexOf("]",after);
        return name.substr(from,to-from);
    }
    
    function addPoaPayment(poaPaymentId){
        var form=document.forms['PoaSummaryForm'];

        form.elements['action'].value='UpdateInformation';
        form.elements['reload'].value='YES';
        var w=500;
        var h=550;
        if(w>screen.width)w=screen.width;
        if(h>screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;
        if(poaPaymentId=='')
            window.open("<html:rewrite page="/Poa/PoaAddPayment.do" />?payment.courierId=<bean:write name="PoaSummaryForm" property="courier"/>&fixedCourier=yes&payment.paymentCurrency=<bean:write name="PoaSummaryForm" property="currentCurrency"/>&requestID="+form.elements['requestID'].value, "addAwbsWindow", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
        else
            window.open("<html:rewrite page="/Poa/PoaAddPayment.do" />?payment.courierId=<bean:write name="PoaSummaryForm" property="courier"/>&fixedCourier=yes&payment.paymentCurrency=<bean:write name="PoaSummaryForm" property="currentCurrency"/>&payment.poaPaymentsId="+poaPaymentId+"&requestID="+form.elements['requestID'].value, "addAwbsWindow", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
    }

    function showPage(page){
        var form=document.forms['PoaSummaryForm'];
        var valid="";//validate(false);
        if(valid==""){
                form.elements['action'].value='showPage';
                form.elements['pageNumber'].value=page;
                form.submit();
        }
        else {
            alert(valid);
        }
    }

    function sortTable(column,direction){
        var form=document.forms['PoaSummaryForm'];
        var valid="";//validate(false);

        if(valid==""){
                form.elements['action'].value='sortTable';
                form.elements['pageNumber'].value=1;
                form.elements['length'].value=length;
                form.elements['sortColumn'].value=column;
                form.elements['sortDirection'].value=direction;
                form.submit();
        }else{
            alert(valid);
        }
    }

    function toGRND(){
        var valid="";//validate(false);

        if(valid==""){
            var form=document.forms['PoaSummaryForm'];
            form.action.value="toGround";
            form.submit();
        }else{
            alert(valid);
        }
    }

    function toCOD(){
        var valid="";//validate(false);

        if(valid==""){
            var form=document.forms['PoaSummaryForm'];
            form.action.value="toCOD";
            form.pageNumber.value=1;
            form.sortColumn.value="awb_nbr";
            form.sortDirection.value="asc";            
            form.submit();
        }else{
            alert(valid);
        }

    }

    function toFTC(){
        var valid="";//validate(false);

        if(valid==""){
            var form=document.forms['PoaSummaryForm'];
            form.action.value="toFTC";
            form.pageNumber.value=1;
            form.sortColumn.value="awb_nbr";
            form.sortDirection.value="asc";            
            form.submit();
        }else{
            alert(valid);
        }

    }

</script>
<logic:present name="PoaSummaryForm">
    <nested:form action="/Poa/PoaSummary.do">
        <input type="hidden" name="action">
        <input type="hidden" name="reload">
        <input type="hidden" name="newCurr">
        <input type="hidden" name="length">

        <input type="hidden" name="newReassLocationCd">
        <input type="hidden" name="newEmployeeId">
        <input type="hidden" name="origEmployeeId">
        <input type="hidden" name="reassEmployeeId">

        <nested:hidden property="poaPaymentsId" />
        <nested:hidden property="currentCurrency" />
        <nested:hidden property="previousCurrencyCode" />
        <nested:hidden property="pageNumber" />
        <nested:hidden property="sortColumn" />
        <nested:hidden property="sortDirection" />
        <input type="hidden" name="requestID" value="<%=requestID%>" >

        <table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#808080">
            <tr>
                <td bgcolor="#FFFFFF" align="center">
                    <b><font color="#73148C" face="Arial" size="3">
                    <html:link href="javascript:previousCourier();"><html:img page="/images/Back.gif" border="0"  width="17" height="17" /></html:link>&nbsp;&nbsp;&nbsp;<b><bean:message key="app.messages.AWBDetailsForEmployee" />
                    <nested:select property="courier" onchange="changeCourier();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                        <nested:root name="PoaSummaryForm">
                            <nested:optionsCollection property="employeesWithPayments" label="value" value="key" />
                        </nested:root>
                    </nested:select></b>&nbsp;&nbsp;&nbsp;<html:link href="javascript:nextCourier();"><html:img page="/images/Next.gif" width="17" height="17" border="0"  /></html:link>
                    </font></b>
                </td>
                <td bgcolor="#FFFFFF" align="center">
                    <a href="javascript:courierReceiptReport();"><img border="0" src="<html:rewrite page="/images/CreateReceipt" /><bean:message key="app.Language"/>.gif" width="114" height="38"></a><a href="javascript:closeEmployee();"><img border="0" src="<html:rewrite page="/images/CloseEmployee" /><bean:message key="app.Language" />.gif" width="114" height="38"></a>
                </td>
            </tr>
        </table>
        <%-- TABLA DE TABS SUPERIORES --%>
        <table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#FFFFFF" align="left">
            <tr>
                <td width="5" bgcolor="#FFFFFF">&nbsp;</td>
                <td rowspan="2"><html:link href="javascript:toROD();"><html:img border="0" page="/images/rod1.gif" width="135" height="33"/></html:link><html:link href="javascript:toPrepaid();"><html:img border="0" page="/images/prepaid1.gif" width="135" height="33"/></html:link><html:img border="0" page="/images/poa.gif" width="135" height="33"/><logic:equal name="userProfile" property="gndUsedFlag" value="true" ><html:link href="javascript:toGRND();" ><html:img border="0" page="/images/ground1.gif" width="135" height="33"/></html:link></logic:equal><logic:equal name="userProfile" property="codUsedFlag" value="true" ><html:link href="javascript:toCOD();"><html:img border="0" page="/images/cod1.gif" width="135" height="33"/></html:link></logic:equal><logic:equal name="userProfile" property="ftcUsedFlag" value="true" ><html:link href="javascript:toFTC();"><html:img border="0" page="/images/ftc1.gif" width="135" height="33"/></html:link></logic:equal></td>
                <td bgcolor="#FFFFFF">&nbsp;</td>
            </tr>
            <tr height="1">
                <td bgcolor="#808080" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                <td bgcolor="#808080" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            </tr>
        </table>
        <br>
        <br>
        <%-- tabla de contenidos del tab activo: tabs interiores, tabla de detalles y totales --%>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF" align="left">
            <tr>
                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                <td bgcolor="#FFFF9C"><html:img page="/images/pixel.gif" width="1" height="5"/></td>
                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            </tr>
            <tr>
                <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                <td bgcolor="#FFFF9C">
                    <%-- TABS INTERNOS, TABLA DE DETALLES Y TABLA DE TOTALES --%>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
                        <tr>
                            <td colspan="1" width="8" bgcolor="#FFFF9C" align="left">&nbsp;</td>
                            <td bgcolor="#FFFF9C" align="left" width="300">
                                <nested:define id="currentCurrency1" property="currentCurrency" type="java.lang.String" />
                                <nested:iterate property="currentlyUsedCurrencies">
                                    <nested:equal property="currencyCode" value="<%=currentCurrency1%>" >
                                        <nested:equal property="currencyCode" value="USD" >
                                            <html:img page="/images/usd.gif" />
                                        </nested:equal>
                                        <nested:notEqual property="currencyCode" value="USD" >
                                            <html:img page="/images/local.gif" />
                                        </nested:notEqual>
                                    </nested:equal>
                                    <nested:notEqual property="currencyCode" value="<%=currentCurrency1%>" >
                                        <nested:equal property="currencyCode" value="USD" >
                                            <a href="javascript:changeTab('<nested:write property="currencyCode" />');"><IMG src="<html:rewrite page="/images/usd1.gif" />" border="0"></a>
                                        </nested:equal>
                                        <nested:notEqual property="currencyCode" value="USD" >
                                            <a href="javascript:changeTab('<nested:write property="currencyCode" />');"><IMG src="<html:rewrite page="/images/local1.gif" />" border="0"></a>
                                        </nested:notEqual>
                                        <nested:define id="alternativeCurrency" property="currencyCode" />
                                    </nested:notEqual>
                                </nested:iterate>
                                <logic:notPresent name="alternativeCurrency" >
                                    <nested:iterate property="supportedCurrencies">
                                        <nested:notEqual property="currencyCode" value="<%=currentCurrency1%>" >
                                            <nested:define id="alternativeCurrency" property="currencyCode" />
                                        </nested:notEqual>
                                    </nested:iterate>
                                </logic:notPresent>
                            </td>
                            <td colspan="1" bgcolor="#FFFF9C" >&nbsp;</td>
                        </tr>
                        <tr>
                            <td bgcolor="#808080" colspan="1" height="1" align="left"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                            <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                            <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                        </tr>
                    </table>
                    <%-- Tabla interna para detalles y totales --%>
                    <table cellpadding="0" cellspacing="0" border="0" ALIGN="CENTER" width="100%" bgcolor="#CE9AFF">
                        <tr>
                            <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                            <td colspan="3" bgcolor="#FFFF9C">
                                <table border="1" width="100%">
                                    <tr>
                                        <td>
                                            <table border="0" bgcolor="#000000" cellspacing="0" cellpadding="0" width="100%">
                                                <tr>
                                                    <td bgcolor="#FFFF9C" align="left">
                                                        <html:link href="javascript:reassignPayments('')"><img border="0" src="<html:rewrite page="/images/ReassignPayments" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link><html:link href="javascript:addPoaPayment('')"><img border="0" src="<html:rewrite page="/images/addPoaPayment" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link>
                                                    </td>
                                                    <td bgcolor="#FFFF9C" align="center">
                                                        <%--<paging:pagesnav property="payments" page="currentPage" length="length" showPage="javascript:showPage(${page},${length});"/>--%>
                                                        <util:paging numberOfPages="${PoaSummaryForm.numberOfPages}" pageNumber="${PoaSummaryForm.pageNumber}" varStatus="std">
                                                            <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                                                        </util:paging>
                                                    </td>
                                                    <td bgcolor="#FFFF9C" align="right">
                                                        <html:link page="/ShowChkAgtCashRecap.do" ><img border="0" src="<html:rewrite page="/images/Summary" /><bean:message key="app.Language" />.gif" width="113" height="38"></html:link>
                                                    </td>
                                                </tr>
                                            </table>
                                            <table border="0" width="100%" bgcolor="#000000" cellspacing="1">
                                                <tr>
                                                    <td bgColor="#73148C" rowspan="2">&nbsp;</td>
                                                    <td bgColor="#73148C" rowspan="2" align="center">
                                                        <c:choose>
                                                            <c:when test="${PoaSummaryForm.sortColumn ne 'paymentId'}">
                                                                <a href="javascript:sortTable('paymentId','asc');" ><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF">#</font></b></a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:choose>
                                                                    <c:when test="${PoaSummaryForm.sortDirection eq 'desc'}">
                                                                        <a href="javascript:sortTable('paymentId','asc');"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF">#</font>&nbsp;<html:img border="0" page="/images/desc.gif" /></b></a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a href="javascript:sortTable('paymentId','desc');"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF">#</font>&nbsp;<html:img border="0" page="/images/asc.gif"/></b></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td bgColor="#73148C" rowspan="2" width="113">
                                                        <c:choose>
                                                            <c:when test="${PoaSummaryForm.sortColumn ne 'account'}">
                                                                <a href="javascript:sortTable('account','asc');" ><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Account" /></font></b></a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:choose>
                                                                    <c:when test="${PoaSummaryForm.sortDirection eq 'desc'}">
                                                                        <a href="javascript:sortTable('account','asc');"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Account" /></font>&nbsp;<html:img border="0" page="/images/desc.gif" /></b></a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a href="javascript:sortTable('account','desc');"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Account" /></font>&nbsp;<html:img border="0" page="/images/asc.gif"/></b></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td bgColor="#73148C" rowspan="2" width="220">
                                                        <c:choose>
                                                            <c:when test="${PoaSummaryForm.sortColumn ne 'cust_nm'}">
                                                                <a href="javascript:sortTable('cust_nm','asc');" ><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Customer" /></font></b></a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:choose>
                                                                    <c:when test="${PoaSummaryForm.sortDirection eq 'desc'}">
                                                                        <a href="javascript:sortTable('cust_nm','asc');"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Customer" /></font>&nbsp;<html:img border="0" page="/images/desc.gif" /></b></a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a href="javascript:sortTable('cust_nm','desc');"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Customer" /></font>&nbsp;<html:img border="0" page="/images/asc.gif"/></b></a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td bgColor="#73148C" rowspan="2" width="113" width="360" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.ReceiptNbr"/></b></font></td>
                                                    <td bgColor="#73148C" colspan="4" width="360" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Payment" /></b></font></td>
                                                    <td bgColor="#73148C" rowspan="2" width="230" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Comments" /></b></font></td>
                                                    <td bgColor="#73148C" rowspan="2" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b>&nbsp;</b></font></td>
                                                </tr>
                                                <tr>
                                                    <td bgColor="#73148C" width="122" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Amount" /></b></font></td>
                                                    <td bgColor="#73148C" width="122" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Number" /></b></font></td>
                                                    <td bgColor="#73148C" width="122" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Type" /></b></font></td>
                                                    <td bgColor="#73148C" width="122" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.CouponAmount" /></b></font></td>
                                                </tr>
                                                <nested:iterate property="payments" id="payment" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.PoaSummaryTableVO">
                                                    <nested:hidden property="poaPaymentsId" />
                                                    <%
                                                        String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
                                                    %>
                                                    <tr>
                                                        <td align="middle" bgColor="#73148C"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF"><nested:checkbox property="selected"/></font></b></td>
                                                        <td align="middle" bgColor="#73148C"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF"><%=idx.intValue()+1%></font></b></td>
                                                        <td bgColor="<%=bgColor%>" align="center" width="113"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><b><a href="javascript:addPoaPayment(<nested:write property="poaPaymentsId"/>)"><nested:write property="accountNbr"/></a></font></td>
                                                        <td bgColor="<%=bgColor%>" width="220"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><b><nested:write property="customerNm" /></font></td>
                                                        <td bgColor="<%=bgColor%>" width="113"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><b><nested:write property="rcptNbr" /></font></td>
                                                        <td bgColor="<%=bgColor%>" width="122" align="right"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><b>
                                                            <nested:write property="paymentAmt" formatKey="app.format.NumberFormat" />
                                                                <logic:present name="alternativeCurrency" >
                                                                    <a href="javascript:changePaymentCurr(<nested:write property="poaPaymentsId" />,'<bean:write name="alternativeCurrency" />')"><IMG border="0" src="<html:rewrite page="/images/info.gif" />"></a>
                                                                </logic:present>
                                                            </font>
                                                        </td>
                                                        <td bgColor="<%=bgColor%>" width="122" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><b><nested:write property="otherDocNbr" /></font></td>
                                                        <td bgColor="<%=bgColor%>" width="122" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><b>
                                                            <c:forEach var="category" items="${PoaSummaryForm.paymentTypes}">
                                                                <c:if test="${category.paymentTypeId eq payment.paymentType}">
                                                                    <c:set var="categoryToChoose" value="${category.paymentCtgId}"/>
                                                                </c:if>
                                                            </c:forEach>
                                                            <c:choose>
                                                                <c:when test="${categoryToChoose eq 5}">
                                                                    <bean:message key="app.messages.Cash" />
                                                                </c:when>
                                                                <c:when test="${categoryToChoose eq 3}">
                                                                    <bean:message key="app.messages.CreditCard" />
                                                                </c:when>
                                                                <c:when test="${categoryToChoose eq 2}">
                                                                    <bean:message key="app.messages.Deposit" />
                                                                </c:when>
                                                                <c:when test="${categoryToChoose eq 4}">
                                                                    <bean:message key="app.messages.Coupon" />
                                                                </c:when>
                                                                <c:when test="${categoryToChoose eq 1}">
                                                                    <bean:message key="app.messages.Check" />
                                                                </c:when>
                                                            </c:choose>
                                                            <b></font>
                                                        </td>
                                                        <td bgColor="<%=bgColor%>" width="122" align="right"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><b>
                                                            <nested:write property="coupPymtAmt" formatKey="app.format.NumberFormat" />
                                                            </b></font>
                                                        </td>
                                                        <td bgColor="<%=bgColor%>" width="230"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="otherComment"/>&nbsp; - &nbsp;<nested:write property="chkinAgentComment" />&nbsp;</font></td>
                                                        <td bgColor="<%=bgColor%>"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><a href="javascript:deletePayment(<%=idx%>)"><bean:message key="app.messages.Delete" /></a></font></td>
                                                    </tr>
                                                </nested:iterate>
                                                <tr>
                                                    <td bgcolor="#FFFF9C" colspan="12" align="center">
                                                        <%--<paging:pagesnav property="payments" page="currentPage" length="length" showPage="javascript:showPage(${page},${length});"/>--%>
                                                        <util:paging numberOfPages="${PoaSummaryForm.numberOfPages}" pageNumber="${PoaSummaryForm.pageNumber}" varStatus="std">
                                                            <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                                                        </util:paging>
                                                    </td>
                                                </tr>
                                            </table>
                                            <%-- Cierre DETALLES --%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <%-- En esta Columna para la tabla de totales --%>
                                            <table border="0" width="100%" bgcolor="#000000" cellspacing="1">
                                                <tr>
                                                    <td width="100%" bgcolor="#FFFF9C" colspan="8">&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td bgColor="#73148C" colspan="8" align="center">
                                                        <b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Totals" arg0="<%=currentCurrency1%>" /></font></b>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td bgColor="#C0C0C0">&nbsp;</td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CashTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CheckTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CreditCardTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.DepositTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CouponTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.TotalPayments" arg0="<%=currentCurrency1%>" /></font> </b></td>
                                                    <td bgColor="#C0C0C0">&nbsp;</td>
                                                </tr>
                                                <bean:define id="frm" name="PoaSummaryForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.PoaSummaryForm"/>
                                                <tr>
                                                    <td bgColor="#C0C0C0" >&nbsp;</td>
                                                    <td bgColor="#C0C0C0" align="center"><input type="text" size="10" name="cashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCashTotal())%>"></td>
                                                    <td bgColor="#C0C0C0" align="center"><input type="text" size="10" name="checkTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCheckTotal())%>"></td>
                                                    <td bgColor="#C0C0C0" align="center"><input type="text" size="10" name="creditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCreditCardTotal())%>"></td>
                                                    <td bgColor="#C0C0C0" align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getDepositTotal())%>"></td>
                                                    <td bgColor="#C0C0C0" align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCoupTotal())%>"></td>
                                                    <td bgColor="#C0C0C0" align="center"><input type="text" size="10" name="totalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getTotalPayments())%>"></td>
                                                    <td bgColor="#C0C0C0">&nbsp;</td>
                                                </tr>
                                            </table>
                                            <%-- Cierre tabla totales --%>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                        </tr>
                        <tr bgcolor="#808080" height="1">
                            <td colspan=5><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                        </tr>
                    </table>
                    <%-- CIERRE TABLA TABS INTERNOS, DETALLES Y TOTALES --%>
                </td>
                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            </tr>
            <%--Fila para mantener color de borde (gris) --%>
            <tr bgcolor="#808080" height="1">
                <td colspan=3><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            </tr>
        </table>
    </nested:form>
</logic:present>
<form name="createReports" method="post">
        <input type="hidden" name="Format" value="PDF">
        <input type="hidden" name="locationCd" value="<bean:write name="userProfile" property="locationCd" />">
        <input type="hidden" name="employeeId" value="<bean:write name="PoaSummaryForm" property="courier" />">
        <input type="hidden" name="chkEmpId" value="<bean:write name="userProfile" property="employeeId" />">
        <input type="hidden" name="StyleSheet" value="">
</form>
