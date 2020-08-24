<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%@taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean-el" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="calendar" %>

<script src="<html:rewrite page="/scripts/calendar.js" />"></script>
<script src="<html:rewrite page="/scripts/calendar-msgs-" /><bean:message key="app.Language" />.js"></script>
<script src="<html:rewrite page="/scripts/calendar-setup.js" />"></script>
<LINK REL ="stylesheet" TYPE="text/css" HREF="<html:rewrite page="/styles/calendar.css" />" TITLE="Style">

<bean:define toScope="page" id="userProfile" name="userProfile" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>

<%
	// to resolve the calendar discripancy 
	int id = 0;
%>

<html:errors />



<logic:present name="RODCourierCashRecapForm">
<script type="text/javascript" src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script type="text/javascript">
    <bean:size id="paymenTypeCount" name="RODCourierCashRecapForm" property="paymentTypes" />
    var pymtCtgAssoc=new Array(<bean:write name="paymenTypeCount" />);
    <logic:iterate id="elem" name="RODCourierCashRecapForm" property="paymentTypes">
        pymtCtgAssoc["<bean:write name="elem" property="paymentTypeId" />"] = "<bean:write name="elem" property="paymentCtgId" />";
    </logic:iterate>
        
    <bean:size id="banksCount" name="RODCourierCashRecapForm" property="countryBanks" />
    var countryBanksAssoc=new Array(<bean:write name="banksCount" />);
    <logic:iterate id="elem" name="RODCourierCashRecapForm" property="countryBanks">
        <logic:present name="elem" property="bankCd" >
            countryBanksAssoc[String(Number("<bean:write name="elem" property="bankCd" />"))] = "<bean:write name="elem" property="bankShtDesc" />";
        </logic:present>
    </logic:iterate>
    <bean:write name="checkDecodeJS" scope="session" />
    function reassignPayments() {
        var form=document.forms['RODCourierCashRecapForm'];
        var w=400;
        var h=200;
        var index=Number(<bean:write name="offset" />);
        var count=Number(0);
        var empId;

        while(eval("form.elements['receivables["+index+"].recId']") && count<1) {
            if(eval("form.elements['receivables["+index+"].selected']").checked) {
               count++;
            }
            index++;
        }

        if(count==0){
            alert("<bean:message key="app.messages.MustSelectPaymentReassign"/> ");
            return;
        }

        var params="summary=false&oldEmployee=<bean:write name="RODCourierCashRecapForm" property="courier"/>";
        if(w > screen.width)w=screen.width;
        if(h > screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;

        window.open("<html:rewrite page="/pages/ReassignPayments.jsp" />?"+params,"reassign","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }

    function validateForAlphanumeric(id) {
    	var value = document.getElementById(id).value;
    	
    	var pattern = new RegExp("^([0-9a-zA-Z]*)$");
    	
    	if(!pattern.test(value)) {
    		value = value.substring(0,value.length-1);
    		document.getElementById(id).value = value;
    	}
    	
    }
    
    function checkLine(index) {
        var form=document.forms['RODCourierCashRecapForm'];
        var msg="";
        var status=eval("form.elements['receivables["+index+"].recStatusId']");
        if(status.options[status.selectedIndex].value==1) {
			recAmount=Number(eval("form.elements['receivables["+index+"].recAmount']").value);
			recDex16Amount=Number(eval("form.elements['receivables["+index+"].recDex16Amount']").value);
			recCashPayment=eval("form.elements['receivables["+index+"].recCashPayment']").value;
			recOtherPayment=eval("form.elements['receivables["+index+"].recOtherPayment']").value;
            recOtherDocNumber=eval("form.elements['receivables["+index+"].recOtherDocNumber']").value;
            var pt=eval("form.elements['receivables["+index+"].otherPaymentType']");
            var ptIndex=pt.selectedIndex;
            otherPaymentType=pymtCtgAssoc[pt.options[ptIndex].value];
			recComment=eval("form.elements['receivables["+index+"].recComment']").value;

			if(isNaN(recCashPayment) || isNaN(recOtherPayment)) {
				msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
				return msg;
			}
            else {
				recCashPayment=Number(recCashPayment);
				recOtherPayment=Number(recOtherPayment);
                if(recCashPayment<0 || recOtherPayment<0) {
                    msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
                    return msg;
                }
			}
            var error=<logic:equal name="RODCourierCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdUsd" /></logic:equal><logic:notEqual name="RODCourierCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdLocal" /></logic:notEqual>;

			if(Math.abs(recAmount-recDex16Amount) > error || Math.abs(recAmount-(recCashPayment+recOtherPayment)) > error) {
                //Check type of comment
                if(recComment.length == 0) {
                    msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="app.messages.js.CommentsNotEntered" />\n";
                    return msg;
                }
			}

			if(recOtherPayment > 0 && ptIndex == 0) {
                msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="app.messages.js.MustSelectOtherPaymentType" />\n";
                return msg;
			}

			if(recOtherPayment==0 && ptIndex>0) {
                msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="app.messages.js.MustEnterOtherPayment" />\n";
                return msg;
			}

			if(recOtherPayment > 0 && recOtherDocNumber.length < 1) {
                msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="app.messages.js.DocNumberNotEntered" />\n";
                return msg;
			}

			if(otherPaymentType==3 && recOtherDocNumber.length>4){
      				msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="app.messages.js.CreditCardNumberDigits" />\n";
        			return msg;
			}

        }
        else if(status.options[status.selectedIndex].value == 3) {
            comment = document.forms['RODCourierCashRecapForm'].elements['receivables['+index+'].otherComment'].value;
            billAcct = document.forms['RODCourierCashRecapForm'].elements['receivables['+index+'].billAccount'].value;
            if(billAcct.length == 0){
                msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="app.messages.AddAccountNumber" />\n";
                return msg;
            }  

            if((billAcct == "999999999") && (comment.length == 0) ){
            	msg=msg+"-AWB "+ eval("form.elements['receivables["+index+"].recAwbNumber']").value +": <bean:message key="errors.messages.CommentMissing" />\n";
            	return msg;
            }
        }
        return msg;
    }

    function validate(isClosing) {
        var form=document.forms['RODCourierCashRecapForm'];
        var msg="";
        var index=Number(<bean:write name="offset" />);
        var some=false;
        var canClose=<bean:write name="RODCourierCashRecapForm" property="canClose"/>;
        
        while(eval("form.elements['receivables["+index+"].recId']")) {
            if(isClosing && (!canClose || eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex<=0)){
                msg="<bean:message key="errors.messages.js.AllInvoicesStateToClose" />";
                break;
            }
            msg=msg+checkLine(index);
            index++;
        }

        if(msg == "") {
           return "";
        }
        else {
            return "<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;
        }
    }


   function addReceivable(){
        var form=document.forms['RODCourierCashRecapForm'];
        var valid=validate(false);
        if(valid=="") {
            form.elements['action'].value='UpdateInformation';
            form.elements['reload'].value='YES';
            var w=700;
            var h=500;
            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;
            window.open("<html:rewrite page="/ROD/AddReceivable.do" />?recEmployeeId=<bean:write name="RODCourierCashRecapForm" property="courier"/>&currencyCode=<bean:write name="RODCourierCashRecapForm" property="currentCurrency"/>","addReceivableWindow","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, width="+w+", height="+h+",left="+leftpos+",top="+toppos);
            form.submit();
        }
        else {
            alert(valid);
        }
    }


    function cashChanged(obj) {
        var form=document.forms['RODCourierCashRecapForm'];
        var index=Number(<bean:write name="offset" />);
        var total=Number(<bean:write name="RODCourierCashRecapForm" property="cashSubTotal"/>);
        while(eval("form.elements['receivables["+index+"].recId']")){
            if(!isNaN(eval("form.elements['receivables["+index+"].recCashPayment']").value)){
                total=total+Number(eval("form.elements['receivables["+index+"].recCashPayment']").value);
            }
            index++;
        }

        form.cashTotal.value=format_number(total,2);
        form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.depositTotal.value),2);

        var idx=findIndex(obj.name,1);
        var totalLine=Number(eval("form.elements['receivables["+idx+"].recCashPayment']").value)+Number(eval("form.elements['receivables["+idx+"].recOtherPayment']").value);
        var totalSur=Number(eval("form.elements['receivables["+idx+"].surChargesTotal']").value);
        if(totalSur==0) {
        	eval("document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyGray.gif"/>";
        }
        else {
        	if(totalSur==totalLine) {
        		eval("document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyGreen.gif"/>";
        	}
            else {
        		eval("document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyRed.gif"/>";
        	}
        }
    }
    
	function quickApplyStatus() {
    	var form=document.forms['RODCourierCashRecapForm'];	
    	var index=Number(0);

	    //<bean:size id="recCount" name="RODCourierCashRecapForm" property="receivables" />
	    //if(recCount.intValue()>20){
	    <bean:size id="recCount" name="RODCourierCashRecapForm" property="receivables" />
    	var recCount1 = "<bean:write name='recCount'/>";
	    if(recCount1>20){
			 form.elements['action'].value="QuickApplyStatus";
			 form.submit();			 
	    }else{         
	        while(eval("form.elements['receivables["+index+"].recId']")){
	            if(Number(eval("form.elements['receivables["+index+"].recDex16Amount']").value)>0 &&
	               eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex==0 &&
	               Number(eval("form.elements['receivables["+index+"].recOtherPayment']").value)<=0){	 
	            	eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=1;   
	            }
	            index++;
	        }    
	    }
	}

    function otherChanged(obj) {
        var form=document.forms['RODCourierCashRecapForm'];
        var index=Number(<bean:write name="offset" />);
        var totalCheck=Number(<bean:write name="RODCourierCashRecapForm" property="checkSubTotal"/>);
        var totalCreditCard=Number(<bean:write name="RODCourierCashRecapForm" property="creditCardSubTotal"/>);
        var totalDepo=Number(<bean:write name="RODCourierCashRecapForm" property="depositSubTotal"/>);

        while(eval("form.elements['receivables["+index+"].recId']")){
            var pt=eval("form.elements['receivables["+index+"].otherPaymentType']");
            var ptIndex=pt.selectedIndex;            
            if(!isNaN(eval("form.elements['receivables["+index+"].recOtherPayment']").value)){
                switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                    case "1": totalCheck=totalCheck+Number(eval("form.elements['receivables["+index+"].recOtherPayment']").value);break;
                    case "2": totalDepo=totalDepo+Number(eval("form.elements['receivables["+index+"].recOtherPayment']").value);break;
                    case "3": totalCreditCard=totalCreditCard+Number(eval("form.elements['receivables["+index+"].recOtherPayment']").value);break;
                }
                
            }
            index++;
        }
        form.checkTotal.value=format_number(totalCheck,2);
        form.depositTotal.value=format_number(totalDepo,2);
        form.creditCardTotal.value=format_number(totalCreditCard,2);
        form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.depositTotal.value),2);
        var idx=findIndex(obj.name,1);
        var totalLine=Number(eval("form.elements['receivables["+idx+"].recCashPayment']").value)+Number(eval("form.elements['receivables["+idx+"].recOtherPayment']").value);
        var totalSur=Number(eval("form.elements['receivables["+idx+"].surChargesTotal']").value);
        if(totalSur==0) {
        	eval("document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyGray.gif"/>";
        }
        else {
        	if(totalSur==totalLine){
        		eval("document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyGreen.gif"/>";
        	}
            else {
        		eval("document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyRed.gif"/>";
        	}
        }
    }
</script>
<!-- Include comments functionality -->
<jsp:include page="RODSplitCurrency.jsp" flush="true" />
<jsp:include page="../Comments.jsp" flush="true" />
<nested:form action="/ROD/CourierCashRecap.do">
    <nested:define id="recStatus" property="recStatus" type="java.util.ArrayList"/>

    <input type="hidden" name="action">
    <input type="hidden" name="awbNbr">
    <input type="hidden" name="reload">
    <input type="hidden" name="recId">
    <input type="hidden" name="newCurr">

    <input type="hidden" name="newReassLocationCd">
    <input type="hidden" name="newEmployeeId">
    <input type="hidden" name="origEmployeeId">
    <input type="hidden" name="reassEmployeeId">

    <!-- Code for split currency operation -->
    <input type="hidden" name="exchangeRate">
    <input type="hidden" name="amountToChange">

    <nested:hidden property="currentCurrency" />
    <nested:hidden property="previousCurrencyCode" />
    <nested:hidden property="pageNumber" />
    <nested:hidden property="sortColumn" />
    <nested:hidden property="sortDirection" />
    <!-- TABLA DE TITULO Y BOTON CLOSE DE EMPLEADO-->
    <table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#808080">
        <tr>
            <td bgcolor="#FFFFFF" align="center" valign="middle">
                <b><font color="#73148C" face="Arial" size="3">
                    <html:link href="javascript:previousCourier();"><html:img page="/images/Back.gif"  border="0" width="17" height="17" /></html:link>&nbsp;&nbsp;&nbsp;<bean:message key="app.messages.AWBDetailsForEmployee" />
                    <nested:select property="courier" onchange="changeCourier();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                        <option value="ALL">ALL COURIERS</option>
                        <nested:root name="RODCourierCashRecapForm">
                            <nested:optionsCollection property="employeesWithPayments" label="value" value="key" />
                        </nested:root>
                    </nested:select></font></b>&nbsp;&nbsp;&nbsp;
                    <html:link href="javascript:nextCourier();"><html:img page="/images/Next.gif" width="17" height="17" border="0" /></html:link>
            </td>
            <td bgcolor="#FFFFFF">
                <p align="center"><a href="javascript:courierReceiptReport();"><img border="0" src="<html:rewrite page="/images/CreateReceipt" /><bean:message key="app.Language" />.gif" width="114" height="38"></a><A href="javascript:closeEmployee();"><img border="0" src="<html:rewrite page="/images/CloseEmployee" /><bean:message key="app.Language" />.gif" width="114" height="38"></A>
            </td>
        </tr>
    </table>
    <%-- TABLA DE TABS SUPERIORES --%>
    <div align="left">
        <!--  <table cellpadding="0" cellspacing="1" border="0" bgcolor="#808080" width="100%"> -->
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" width="100%">
            <tr>
	            <td colspan="1" width="5" bgcolor="#FFFFFF">&nbsp;</td>
	            <!--  <td rowspan="2" width="<%=userProfile.isGndUsedFlag()?"795":"560"%>"> --> <!--795:560 or "540":"305"-->
	            <td rowspan="2">	
	            	<img border="0" src="<html:rewrite page="/images/rod.gif" />" width="135" height="33">
	            	
	            	<html:link href="javascript:toPrepaid();" >
	            		<img border="0" src="<html:rewrite page="/images/prepaid1.gif" />" width="135" height="33">
	            	</html:link>
	            	
	            	<html:link href="javascript:toPOA();" >
	            		<img border="0" src="<html:rewrite page="/images/poa1.gif" />" width="135" height="33">
	            	</html:link>
	            	
	            	<logic:equal name="userProfile" property="gndUsedFlag" value="true" >
	            		<html:link href="javascript:toGRND();" >
	            			<img border="0" src="<html:rewrite page="/images/ground1.gif" />" width="135" height="33">
	            		</html:link>
	            	</logic:equal>
	            	
	            	<logic:equal name="userProfile" property="codUsedFlag" value="true" >
	            	<html:link href="javascript:toCOD();" >
	            		<img border="0" src="<html:rewrite page="/images/cod1.gif" />" width="135" height="33">
	            	</html:link>
	            	</logic:equal>
	            	
	           		<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >
	            	<html:link href="javascript:toFTC();" >
	            		<img border="0" src="<html:rewrite page="/images/ftc1.gif" />" width="135" height="33">
	            	</html:link>
	            	</logic:equal>
	            	
	            </td>
	            <td colspan="1" bgcolor="#FFFFFF" >&nbsp;</td>
            </tr>
			 <tr>
	            <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	            <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            </tr>
        </table>
    </div>
    <!-- tabla de contenidos del tab activo: tabs interiores, tabla de detalles y totales -->
    <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
        <tr>
            <!-- Fila para mantener color del tab activo-->
	        <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	        <td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="5"></td>
	        <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
        <tr>
            <!-- Aqui va la tabla de los tab internos -->
	        <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	        <td bgcolor="#FFFF9C">
	            <!-- TABS INTERNOS, TABLA DE DETALLES Y TABLA DE TOTALES -->
		        <!-- Tabs internos -->
                <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
		            <tr height="1">
			            <td width="8" bgcolor="#FFFF9C" align="left">&nbsp;</td>
                        <td bgcolor="#FFFF9C" align="left" width="300">
                            <nested:define id="currentCurrency1" property="currentCurrency" type="java.lang.String"/>
                            <c:forEach var="currency" items="${RODCourierCashRecapForm.currentlyUsedCurrencies}">
                                <c:choose>
                                    <c:when test="${currency.currencyCode eq RODCourierCashRecapForm.currentCurrency}">
                                        <c:choose>
                                            <c:when test="${currency.currencyCode eq 'USD'}">
                                               <html:img page="/images/usd.gif" border="0"/>
                                            </c:when>
                                            <c:otherwise>
                                                <html:img page="/images/local.gif" border="0"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${currency.currencyCode eq 'USD'}">
                                                <a href="javascript:changeTab('<c:out value="${currency.currencyCode}" escapeXml="true" />')"> <IMG src="<html:rewrite page="/images/usd1.gif" />" border="0"></a>

                                            </c:when>
                                            <c:otherwise>
                                                <a href="javascript:changeTab('<c:out value="${currency.currencyCode}" escapeXml="true" />')"> <IMG src="<html:rewrite page="/images/local1.gif" />" border="0"></a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <%-- code to support dual currency --%>
                            <c:if test="${RODCourierCashRecapForm.dualCurrency eq 'true'}">
                                <c:choose>
                                    <c:when test="${userProfile.splitCurrency eq 'true' and RODCourierCashRecapForm.currentCurrency ne 'split'}">
                                          <a href="javascript:changeTab('split')"> <IMG src="<html:rewrite page="/images/split1.gif" />" border="0"></a>
                                    </c:when>
                                    <c:when test="${userProfile.splitCurrency eq 'true' and RODCourierCashRecapForm.currentCurrency eq 'split'}">
                                          <html:img page="/images/split.gif" border="0"/>
                                    </c:when>
                                </c:choose>
                            </c:if>
                            <logic:notPresent name="alternativeCurrency" >
                                <c:forEach var="currency" items="${RODCourierCashRecapForm.supportedCurrencies}">
                                    <c:if test="${currency.currencyCode ne currentCurrency1}">
                                        <nested:define id="alternativeCurrency" name="currency" property="currencyCode"/>
                                    </c:if>
                                </c:forEach>
                            </logic:notPresent>
                        </td>
	                    <td colspan="1" bgcolor="#FFFF9C" >&nbsp;</td>
                    </tr>
		            <tr height="1">
                        <td bgcolor="#808080" colspan="1" height="1" width="8" align="left"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			            <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
		            </tr>
                </table>
		        <!-- Tabla interna para detalles y totales -->
		        <table cellpadding="0" cellspacing="0" border="0" ALIGN="CENTER" width="100%" bgcolor="#CE9AFF">
		            <tr>
		                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			            <td colspan=3 bgcolor="#FFFF9C">
                            <div align="left">
				                <table border="1" width="100%">
				                    <tr>
				                        <td>
			    			                <!-- Tabla DETALLES -->
                                            <table border="0" bgcolor="#000000" cellspacing="0" cellpadding="0" width="100%">
                                                <tr>
                                                    <td bgcolor="#FFFF9C" align="center">
                                                        <c:if test="${RODCourierCashRecapForm.currentCurrency ne 'split'}">
                                                           <html:link href="javascript:reassignPayments()">
                                                                 <img border="0" src="<html:rewrite page="/images/ReassignPayments" /><bean:message key="app.Language" />.gif" width="113" height="38" >
                                                            </html:link>
                                                        </c:if>
                                                        <c:if test="${userProfile.splitCurrency eq 'true' and RODCourierCashRecapForm.currentCurrency ne 'split'}">
                                                            <html:link href="javascript:splitCurrency()"><img border="0" src="<html:rewrite page="/images/SplitCurrency" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link>
                                                        </c:if>
                                                        <c:if test="${userProfile.quickStatus eq 'true'}">
                                                            <html:link href="javascript:quickApplyStatus()"><img border="0" src="<html:rewrite page="/images/QuickClearROD" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link>
                                                        </c:if>
                                                        <A href="javascript:processScans();"><img border="0" src="<html:rewrite page="/images/ProcessScan" /><bean:message key="app.Language" />.gif"></A>
                                                        <A href="javascript:addReceivable();"><img border="0" src="<html:rewrite page="/images/AddReassRec" /><bean:message key="app.Language" />.gif"></A>
                                                    </td>
                                                    <td bgcolor="#FFFF9C" align="left">
                                                         <%--<paging:pagesnav property="receivables" page="currentPage" length="length" showPage="javascript:showPage(${page},${length});"/>--%>
                                                         <util:paging numberOfPages="${RODCourierCashRecapForm.numberOfPages}" pageNumber="${RODCourierCashRecapForm.pageNumber}" varStatus="std">
                                                            <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                                                         </util:paging>
                                                    </td>
                                                    <td bgcolor="#FFFF9C" align="right">
                                                         <A href="javascript:updateInformation();"><img border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif"></A><html:link page="/ShowChkAgtCashRecap.do" ><img border="0" src="<html:rewrite page="/images/Summary" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link>
                                                    </td>
                                                </tr>
                                            </table>
                                            <div align="left" valign="top">
    						                    <table border="0" width="100%" bgcolor="#000000" cellspacing="1">
    						                    
    						                    
    						                    
							                        <tr>
                                                        <c:choose>
                                                            <c:when test="${RODCourierCashRecapForm.dualCurrency eq 'false' or RODCourierCashRecapForm.currentCurrency ne 'split'}">
                                                                        <td bgcolor="#C0C0C0" colspan="16">
                                                            </c:when>
                                                            <c:otherwise>
                                                                        <td bgcolor="#C0C0C0" colspan="17">
                                                            </c:otherwise>
                                                        </c:choose>
                                                            <b>
                                                                <FONT face="Verdana, Arial, Helvetica, sans-serif" color="#009900" size=1><bean:message key="app.messages.GreenDeliveredAndCash" /></FONT>&nbsp;&nbsp;&nbsp;
                                                                <FONT face="Verdana, Arial, Helvetica, sans-serif" color="#ff0000" size=1><bean:message key="app.messages.RedDeliveredWithoutCash" /></FONT>&nbsp;&nbsp;&nbsp;
                                                                <FONT face="Verdana, Arial, Helvetica, sans-serif" color="#3333ff" size=1><bean:message key="app.messages.BlueOnVan" /></FONT>
                                                            </b>
                                                        </td>
                                                    </tr>
                                                    
                                                    
                                                    
                                                    
                                                    
							                        <tr>
                                                        <td bgColor="#73148C" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">&nbsp;</font></p></b></td>
                                                        <td bgColor="#73148C" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">#</font></p></b></td>
                        							    <td bgColor="#73148C" rowspan="2">
                                                            <c:choose>
                                                                <c:when test="${RODCourierCashRecapForm.sortColumn ne 'awb_nbr'}">
                                                                    <a href="javascript:sortTable('awb_nbr','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.AWBNumber" /></font></b></a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:choose>
                                                                        <c:when test="${RODCourierCashRecapForm.sortDirection eq 'desc'}">
                                                                            <a href="javascript:sortTable('awb_nbr','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.AWBNumber"/></font></b>&nbsp;<html:img page="/images/desc.gif" border="0"/></a>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="javascript:sortTable('awb_nbr','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.AWBNumber" /></font></b>&nbsp;<html:img page="/images/asc.gif" border="0"/></a>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
							                            <td bgColor="#73148C" rowspan="2">
                                                            <c:choose>
                                                                <c:when test="${RODCourierCashRecapForm.sortColumn ne 'cust_nm'}">
                                                                    <a href="javascript:sortTable('cust_nm','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.CustomerInvoice" /></font></b></a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:choose>
                                                                        <c:when test="${RODCourierCashRecapForm.sortDirection eq 'desc'}">
                                                                            <a href="javascript:sortTable('cust_nm','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.CustomerInvoice" /></font></b>&nbsp;<html:img page="/images/desc.gif" border="0"/></a>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="javascript:sortTable('cust_nm','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.CustomerInvoice" /></font></b>&nbsp;<html:img page="/images/asc.gif" border="0"/></a>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
		                        					    <td bgColor="#73148C" rowspan="2">
                                                            <c:choose>
                                                                <c:when test="${RODCourierCashRecapForm.sortColumn ne 'awb_dt'}">
                                                                    <a href="javascript:sortTable('rec_dt','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font></b></a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:choose>
                                                                        <c:when test="${RODCourierCashRecapForm.sortDirection eq 'desc'}">
                                                                            <a href="javascript:sortTable('rec_dt','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font></b>&nbsp;<html:img border="0" page="/images/desc.gif"/></a>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="javascript:sortTable('rec_dt','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font></b>&nbsp;<html:img page="/images/asc.gif" border="0"/></a>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:otherwise>
                                                            </c:choose>
                                                         </td>
                        							    <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.ReceiptNbr" /></b></font></p></td>
						                        	    <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.ExpectedAmount" /></b></font></p></td>
							                            <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.SuperTrackerAmount" /></b></font></p></td>
                                                        <c:if test="${RODCourierCashRecapForm.dualCurrency eq 'true' and RODCourierCashRecapForm.currentCurrency eq 'split'}">
                                                            <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Currency" /></b></font></p></td>
                                                        </c:if>
							                            <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.CheckInCash" /></b></font></p></td>
                                                        <td bgColor="#73148C" colspan="3"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.PaymentDocument" /></b></font></p></td>
							                            <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Comments" /></b></font></p></td>
							                            <td bgColor="#73148C" rowspan="2">
                                                            <c:choose>
                                                                <c:when test="${RODCourierCashRecapForm.sortColumn ne 'status_id_nbr'}">
                                                                    <a href="javascript:sortTable('status_id_nbr','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font></b></a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:choose>
                                                                        <c:when test="${RODCourierCashRecapForm.sortDirection eq 'desc'}">
                                                                            <a href="javascript:sortTable('status_id_nbr','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font></b>&nbsp;<html:img page="/images/desc.gif" border="0"/></a>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="javascript:sortTable('status_id_nbr','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font></b>&nbsp;<html:img page="/images/asc.gif" border="0"/></a>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        <!--changes for MISCELLANEOUS_DATE  Saurabh: 08/06/2013-->
                                                        <td bgColor="#73148C" rowspan="2" colspan="1">
                                                        	<b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.MISCELLANEOUSDATE" /></font></b>
                                                        </td>
                                                        <td bgColor="#73148C" rowspan="2" colspan="1">
                                                        	<b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.MISCELLANEOUSNBR" /></font></b>
                                                        </td>                                                        
                                                        <!--changes for MISCELLANEOUS_DATE  Saurabh: 08/06/2013-->	                                                        
							                        </tr>
							                        <tr>
							                            <td bgColor="#73148C" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Amount" /></b></font></td>
                                                        <td bgColor="#73148C" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Number" /></b></font></td>
							                            <td bgColor="#73148C" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Type" /></b></font></td>
							                        </tr>
                                                    <nested:iterate property="receivables" id="rec" offset="offset" length="length" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.CourierCashRecapTableVO">
                                                        <nested:hidden property="recId" />
                                                        <nested:hidden property="recAmtPrev" />
                                                        <nested:hidden property="customerNmPrev" />
                                                        <nested:hidden property="rcptNbrPrev" />
                                                        <nested:hidden property="recAwbNumber" />
                                                        <nested:hidden property="recNbr" />
                                                        <nested:hidden property="recDex16Amount" />
                                                        <nested:hidden property="recComment"/>
                                                        <nested:hidden property="otherComment"/>
                                                        <nested:hidden property="recCashPaymentPrev" />
                                                        <nested:hidden property="recOtherPaymentPrev" />
                                                        <nested:hidden property="recOtherDocNumberPrev" />
                                                        <nested:hidden property="otherPaymentTypePrev" />
                                                        <nested:hidden property="recCommentPrev" />
                                                        <nested:hidden property="recStatusIdPrev" />
                                                        <nested:hidden property="recvPrepyAmtPrev" />
                                                        <nested:hidden property="billAccount" />
                                                        <nested:hidden property="billAccountPrev" />
                                                        <!-- Code to suuport dual currency -->
                                                        <c:choose>
                                                            <c:when test="${RODCourierCashRecapForm.currentCurrency eq 'split'}">
                                                                <input type="hidden" name='"<c:out value="${idx}" escapeXml="true" />".recPaymentCurrency' value='<c:out value="${rec.paymentCurrency}" escapeXml="true" />' />

                                                            </c:when>
                                                            <c:otherwise>
                                                                  <nested:hidden property="recPaymentCurrency" value="<%=currentCurrency1%>" />
                                                            </c:otherwise>
                                                        </c:choose>

                                                        <nested:hidden property="otherCommentPrev"/>
                                                        <nested:hidden property="surChargesTotal"/>
                                                        <nested:hidden property="rodAmt"/>
                                                        <nested:hidden property="ancCharges"/>
                                                        <nested:hidden property="recvPrepyAmt"/>
                                                        <nested:hidden property="manuallyEntered" />
                                                        <%
                                                            String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
                                                            String fontColor;
                                                            switch (rec.getRecTrackingStatus()) {
                                                                case 1:  fontColor="#3333ff"; break;
                                                                case 2:  fontColor="#ff0000"; break;
                                                                case 3:  fontColor="#009900"; break;
                                                                case 4:  fontColor="#9900CC"; break;
                                                                default: fontColor="#000000"; break;
                                                            }

                                                            String surchrgImg=null;
                                                            if(rec.getSurChargesTotal()==0){
                                                                surchrgImg="/images/moneyGray.gif";
                                                            }else{
                                                                if(rec.getSurChargesTotal()==(rec.getRecOtherPayment()+rec.getRecCashPayment())){
                                                                    surchrgImg="/images/moneyGreen.gif";
                                                                }else{
                                                                    surchrgImg="/images/moneyRed.gif";
                                                                }
                                                            }

                                                            String recPrepayment;
                                                            if(rec.getRecvPrepyAmt()==0){
                                                                recPrepayment="/images/prepyGray.gif";
                                                            }else{
                                                                    recPrepayment="/images/prepyGreen.gif";
                                                                }
                                                        %>
                                                               <tr>
                                                                    <!-- if for split currency operation -->
                                                                    <c:choose>
                                                                        <c:when test="${RODCourierCashRecapForm.dualCurrency ne 'true' or RODCourierCashRecapForm.currentCurrency ne 'split'}">
                                                                                <TD align="middle" bgColor="#73148C"><B><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF" ><nested:checkbox property="selected" /></FONT></B></TD>
                                                                                <TD align="middle" bgColor="#73148C"><B><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF" ><%=idx.intValue()+1%></FONT></B></TD>
                                                                                <TD nowrap align=middle bgColor="<%=bgColor%>">
                                                                                    <a name="<nested:write property="recAwbNumber"/>"/>
                                                                                    <a name="<%=rec.getRecNbr()%>"/>
                                                                                    <FONT face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>"><b><nested:write property="recAwbNumber" /></b></FONT>
                                                                                    <a href="javascript:showScans('<nested:write property="recAwbNumber"/>')"><html:img page="/images/scans.gif" border="0"/></a>
                                                                                </TD>
                                                                                <TD nowrap align=middle bgColor="<%=bgColor%>"><B><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>">
                                                                                        <a href="javascript:changeCustomerNm(<%=idx%>)"><html:img page="/images/change.gif" border="0"/></a>
                                                                                        <nested:text property="customerNm" maxlength="50" onfocus="blur()"  size="10" style="<%=\"TEXT-ALIGN: left;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; border: 0; font-weight: bold \"%>" /> /<br> <nested:write property="recNbr" /></FONT></B>
                                                                                </TD>
                                                                                <TD align=middle bgColor="<%=bgColor%>"><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" ><B><nested:write property="recDate" formatKey="app.format.Date"/></B></FONT></TD>
                                                                                <TD align=right bgColor="<%=bgColor%>" nowrap><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" ><B>
                                                                                        <nested:notEmpty property="rcptNbr">
                                                                                            <a href="javascript:changeReceiptNbr(<%=idx%>)"><html:img border="0" page="/images/change.gif"/></a>
                                                                                            <nested:text property="rcptNbr" maxlength="20" onfocus="blur()"  size="6" style="<%=\"TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; border: 0; font-weight: bold \"%>" />
                                                                                        </nested:notEmpty>
                                                                                        <nested:empty property="rcptNbr">
                                                                                            <nested:text property="rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="6" style="<%=\"TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; font-weight: bold \"%>" />
                                                                                        </nested:empty>
                                                                                    </B></FONT>
                                                                                </TD>
                                                                                <TD align=right nowrap  bgColor="<%=bgColor%>" nowrap><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" ><B>
                                                                                        <!--nested:equal property="manuallyEntered" value="true"-->
                                                                                            <a href="javascript:changeRecAmt(<%=idx%>)"><html:img page="/images/change.gif" border="0"/></a>
                                                                                        <!--/nested:equal-->
                                                                                        <nested:text property="recAmount" onfocus="blur()" value="<%=formatter.format(rec.getRecAmount())%>" size="8" style="<%=\"TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; border: 0; font-weight: bold \"%>" />
                                                                                        </B></FONT>
                                                                                    <logic:present name="alternativeCurrency" >
                                                                                        <nested:lessEqual property="recDex16Amount" value="0"><nested:lessEqual property="recCashPayment" value="0"><nested:lessEqual property="recOtherPayment" value="0"><a href="javascript:changeRecCurr(<nested:write property="recId" />,'<bean:write name="alternativeCurrency" />')"><IMG border="0" src="<html:rewrite page="/images/info.gif" />"></a></nested:lessEqual></nested:lessEqual></nested:lessEqual>
                                                                                    </logic:present>
                                                                                </TD>
                                                                                <TD align=right nowrap  bgColor="<%=bgColor%>"><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" ><B><nested:write property="recDex16Amount" formatKey="app.format.NumberFormat" /></B></FONT>
                                                                                            <logic:present name="alternativeCurrency" >
                                                                                                <A href="javascript:changeRecPaymentCurr(<nested:write property="recId" />,'<bean:write name="alternativeCurrency" />')"><IMG border="0" src="<html:rewrite page="/images/info.gif"/>"/></A>
                                                                                            </logic:present>
                                                                                </TD>
                                                                                    <TD align=right bgColor="<%=bgColor%>"><FONT face="Verdana, Arial, Helvetica, sans-serif" size=1><nested:text property="recCashPayment" onchange="cashChanged(this);" size="10" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" value="<%=formatter.format(rec.getRecCashPayment())%>" /></FONT></TD>
                                                                                    <TD align=right bgColor="<%=bgColor%>"><FONT face="Verdana, Arial, Helvetica, sans-serif" size=1><nested:text property="recOtherPayment" onchange="otherChanged(this);" size="10" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" value="<%=formatter.format(rec.getRecOtherPayment())%>" /></FONT></TD>
                                                                                    <TD align=right bgColor="<%=bgColor%>"><FONT face="Verdana, Arial, Helvetica, sans-serif" size=1><nested:text property="recOtherDocNumber" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onkeypress="docNbrKey(event,this)" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" /></FONT></TD>
                                                                                    <td bgColor="<%=bgColor%>"><font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                                                                                              <nested:select property="otherPaymentType" onchange="otherChanged(this);" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                                                                                 <option>None</option>
                                                                                                 <html:optionsCollection name="RODCourierCashRecapForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"  />
                                                                                              </nested:select>
                                                                                          </font>
                                                                                    </td>
                                                                                    <TD bgColor="<%=bgColor%>" align="center">
                                                                                        <FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
                                                                                            <!-- Pone la figura para indicar si tiene o no comentarios -->
                                                                                            <A href="javascript:showCommentsWindow(<%=idx.intValue()%>,'receivables','RODCourierCashRecapForm','recComment', 'otherComment',document.RODCourierCashRecapForm.elements['receivables['+<%=idx.intValue()%>+'].billAccount'].value);">
                                                                                                <logic:notEmpty name="rec" property="recComment">
                                                                                                    <IMG border="0" id="imgComment<%=idx%>" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>" alt="<bean:write name="rec" property="recComment"/>">
                                                                                                </logic:notEmpty>
                                                                                                <logic:empty name="rec" property="recComment">
                                                                                                    <logic:notEmpty name="rec" property="otherComment">
                                                                                                        <IMG border="0" id="imgComment<%=idx%>" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>">
                                                                                                    </logic:notEmpty>
                                                                                                    <logic:empty name="rec" property="otherComment">
                                                                                                        <IMG border="0" id="imgComment<%=idx%>"  name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasNoComment.gif"/>" alt="<bean:message key="app.messages.ViewAddComment"/>">
                                                                                                    </logic:empty>
                                                                                                </logic:empty>
                                                                                            </A>
                                                                                            <a href="javascript:viewSurcharges(<nested:write property="recId" />,<%=idx%>)">
                                                                                                <IMG name="surchrgImg<%=idx%>" border="0" src="<html:rewrite page="<%=surchrgImg%>"/>" >
                                                                                            </a>
                                                                                            <a href="javascript:viewRecPrepayment('<%=idx.intValue()%>')">
                                                                                                <IMG name="recPrepaymentImg<%=idx%>" border="0" src="<html:rewrite page="<%=recPrepayment%>"/>" >
                                                                                            </a>
                                                                                        </FONT>
                                                                                    </TD>
                                                                                    <TD align="center" bgColor="<%=bgColor%>"><FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
                                                                                            <nested:select property="recStatusId" onchange="changeStatus(this);" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                                                                                <nested:root name="RODCourierCashRecapForm">
                                                                                                    <html:options collection="recStatus" property="statusId" labelProperty="description" />
                                                                                                </nested:root>
                                                                                            </nested:select></FONT>
                                                                                    </TD>
                                                                                    
                                                                                    
				                                                                    <TD align="left" bgColor="<%=bgColor%>">
				                                                                    	<FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
				                                                                    		<!--calendar js  -->
				                                                                    		<%String iconUrl=request.getContextPath()+"/images/cal.gif";%>
				                                                                    		<input type="text" id="miscDate<%=id %>" name="receivables[<%=id%>].miscDate" value="<bean:write name="rec" property="miscDate"/>" maxlength="10" size="10"><a href="#"><img id="triggermiscDate<%=id %>" src="<%=iconUrl%>" border="0"/></a>
																								
																							<script type="text/javascript">
																								Calendar.setup({inputField     :    "miscDate<%=id %>",ifFormat       :    "%m/%d/%Y",button         :    "triggermiscDate<%=id %>",align          :    "Bl",singleClick    :    true});
																							</script>
				                                                                    		<!--calendar js  -->
				                                                                    		
				                                                                    	</FONT>
				                                                                    </TD>
				                                                                    <TD align="center" bgColor="<%=bgColor%>">
				                                                                    	<FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
				                                                                    		<input type="text" id="miscNbr<%=id %>" onkeyup="validateForAlphanumeric('miscNbr<%=id %>')" name="receivables[<%=id++ %>].miscNbr" value="<bean:write name="rec" property="miscNbr"/>" maxlength="15" size="15"/>
					                                                                    </FONT>
				                                                                    </TD>     
				                                                                    
				                                                                                                                                                     
                                                                       </c:when>
                                                                       <c:otherwise>
                                                                            <c:choose>
                                                                                    <c:when test="${idx%2 eq 0}">
                                                                                        <TD align=middle bgColor="#73148C" rowspan="2"><B><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF" ><nested:checkbox property="selected" /></FONT></B></TD>
                                                                                        <TD align=middle bgColor="#73148C" rowspan="2"><B><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF" >
                                                                                             <c:choose>
                                                                                                <c:when test="${idx eq 0}">
                                                                                                       <c:out value="${idx+1}"></c:out>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                        <% int intRow = (idx.intValue()/2) + 1;
                                                                                                           String strRow = new Integer(intRow).toString();
                                                                                                        %>
                                                                                                        <%=strRow%>
                                                                                                </c:otherwise>
                                                                                             </c:choose>
                                                                                        </FONT></B></TD>
                                                                                        <TD nowrap align=middle bgColor="<%=bgColor%>" rowspan="2">
                                                                                                <a name="<nested:write property="recAwbNumber"/>"/>
                                                                                                <a name="<%=rec.getRecNbr()%>"/>
                                                                                                <FONT face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>"><b><nested:write property="recAwbNumber" /></b></FONT>
                                                                                                <a href="javascript:showScans('<nested:write property="recAwbNumber"/>')"><IMG border="0" src="<html:rewrite page="/images/scans.gif" />"></a>
                                                                                        </TD>
                                                                                        <TD nowrap align=middle bgColor="<%=bgColor%>" rowspan="2"><B><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>">
                                                                                                <a href="javascript:changeCustomerNm(<%=idx%>)"><IMG border="0" src="<html:rewrite page="/images/change.gif" />"></a>
                                                                                                <nested:text property="customerNm" maxlength="50" onfocus="blur()"  size="10" style="<%=\"TEXT-ALIGN: left;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; border: 0; font-weight: bold \"%>" /> /<br> <nested:write property="recNbr" /></FONT></B>
                                                                                        </TD>
                                                                                        <TD align=middle bgColor="<%=bgColor%>" rowspan="2"><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" ><B><nested:write property="recDate" formatKey="app.format.Date"/></B></FONT></TD>
                                                                                        <TD align=right bgColor="<%=bgColor%>" nowrap rowspan="2"><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" ><B>
                                                                                                <nested:notEmpty property="rcptNbr">
                                                                                                    <a href="javascript:changeReceiptNbr(<%=idx%>)"><IMG border="0" src="<html:rewrite page="/images/change.gif" />"></a>
                                                                                                    <nested:text property="rcptNbr" maxlength="20" onfocus="blur()"  size="6" style="<%=\"TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; border: 0; font-weight: bold \"%>" />
                                                                                                </nested:notEmpty>
                                                                                                <nested:empty property="rcptNbr">
                                                                                                    <nested:text property="rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="6" style="<%=\"TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; font-weight: bold \"%>" />
                                                                                                </nested:empty>
                                                                                            </B></FONT>
                                                                                        </TD>
                                                                                        <TD align=right nowrap  bgColor="<%=bgColor%>" nowrap rowspan="2"><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" ><B>
                                                                                                <!--nested:equal property="manuallyEntered" value="true"-->
                                                                                                    <a href="javascript:changeRecAmt(<%=idx%>)"><IMG border="0" src="<html:rewrite page="/images/change.gif" />"></a>
                                                                                                <!--/nested:equal-->
                                                                                                <nested:text property="recAmount" onfocus="blur()" value="<%=formatter.format(rec.getRecAmount())%>" size="8" style="<%=\"TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; border: 0; font-weight: bold \"%>" />
                                                                                                </B></FONT>
                                                                                            <logic:present name="alternativeCurrency" >
                                                                                                <nested:lessEqual property="recDex16Amount" value="0"><nested:lessEqual property="recCashPayment" value="0"><nested:lessEqual property="recOtherPayment" value="0"><a href="javascript:changeRecCurr(<nested:write property="recId" />,'<bean:write name="alternativeCurrency" />')"><%--<IMG border="0" src="<html:rewrite page="/images/info.gif" />"/>--%></nested:lessEqual></nested:lessEqual></nested:lessEqual></TD>
                                                                                            </logic:present>
                                                                                        <TD align=right nowrap  bgColor="<%=bgColor%>" rowspan="2"><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" ><B>
                                                                                                <nested:write property="recDex16Amount" formatKey="app.format.NumberFormat" /></B></FONT>
                                                                                        </TD>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                        <nested:hidden property="recAwbNumber"/>
                                                                                        <nested:hidden property="customerNm"/>
                                                                                        <nested:hidden property="rcptNbr"/>
                                                                                        <nested:hidden property="recAmount"/>
                                                                                        <nested:hidden property="recDex16Amount"/>
                                                                                </c:otherwise>
                                                                           </c:choose>
                                                                        <TD align=center nowrap  bgColor="<%=bgColor%>">
                                                                            <FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="<%=fontColor%>" >
                                                                            <B><nested:write property="paymentCurrency"/></B>
                                                                            </FONT>
                                                                        </TD>
                                                                            <TD align=right bgColor="<%=bgColor%>"><FONT face="Verdana, Arial, Helvetica, sans-serif" size=1><nested:text property="recCashPayment" onchange="cashChanged(this);" size="10" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" value="<%=formatter.format(rec.getRecCashPayment())%>" /></FONT></TD>
                                                                            <TD align=right bgColor="<%=bgColor%>"><FONT face="Verdana, Arial, Helvetica, sans-serif" size=1><nested:text property="recOtherPayment" onchange="otherChanged(this);" size="10" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" value="<%=formatter.format(rec.getRecOtherPayment())%>" /></FONT></TD>
                                                                            <TD align=right bgColor="<%=bgColor%>"><FONT face="Verdana, Arial, Helvetica, sans-serif" size=1><nested:text property="recOtherDocNumber" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onkeypress="docNbrKey(event,this)" onfocus="this.style.backgroundColor='#FFFFBF'"/></FONT></TD>
                                                                            <td bgColor="<%=bgColor%>">
                                                                                 <font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                                                                                       <nested:select property="otherPaymentType" onchange="otherChanged(this);" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                                                                         <option>None</option>
                                                                                        <html:optionsCollection name="RODCourierCashRecapForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"  />
                                                                                      </nested:select>
                                                                                 </font>
                                                                            </td>
                                                                            <TD bgColor="<%=bgColor%>" align="center">
                                                                                <FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>

                                                                                    <A href="javascript:showCommentsWindow(<%=idx.intValue()%>,'receivables','RODCourierCashRecapForm','recComment', 'otherComment',document.RODCourierCashRecapForm.elements['receivables['+<%=idx.intValue()%>+'].billAccount'].value));">
                                                                                        <logic:notEmpty name="rec" property="recComment">
                                                                                            <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>" alt="<bean:write name="rec" property="recComment"/>">
                                                                                        </logic:notEmpty>
                                                                                        <logic:empty name="rec" property="recComment">
                                                                                            <logic:notEmpty name="rec" property="otherComment">
                                                                                                <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>">
                                                                                            </logic:notEmpty>
                                                                                            <logic:empty name="rec" property="otherComment">
                                                                                                <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasNoComment.gif"/>" alt="<bean:message key="app.messages.ViewAddComment"/>">
                                                                                            </logic:empty>
                                                                                        </logic:empty>
                                                                                    </A>
                                                                                    <a href="javascript:viewSurcharges(<nested:write property="recId" />,<%=idx%>)">
                                                                                        <IMG name="surchrgImg<%=idx%>" border="0" src="<html:rewrite page="<%=surchrgImg%>"/>" >
                                                                                    </a>
                                                                                    <a href="javascript:viewRecPrepayment('<%=idx.intValue()%>')">
                                                                                        <IMG name="recPrepaymentImg<%=idx%>" border="0" src="<html:rewrite page="<%=recPrepayment%>"/>" >
                                                                                    </a>
                                                                                </FONT>
                                                                            </TD>
                                                                            <TD align="center" bgColor="<%=bgColor%>"><FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
                                                                                    <nested:select property="recStatusId" onchange="changeStatus(this);" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                                                                        <nested:root name="RODCourierCashRecapForm">
                                                                                            <html:options collection="recStatus" property="statusId" labelProperty="description" />
                                                                                        </nested:root>
                                                                                    </nested:select></FONT>
                                                                            </TD>
                                                                       </c:otherwise>
                                                                    </c:choose>
                                                                </tr>
                                                    </nested:iterate>
                                                    <tr>
                                                        <td bgcolor="#FFFF9C" colspan="15" align="center">
                                                             <util:paging numberOfPages="${RODCourierCashRecapForm.numberOfPages}" pageNumber="${RODCourierCashRecapForm.pageNumber}" varStatus="std">
                                                                <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                                                             </util:paging>
                                                        </td>
                                                    </tr>
							                    </table>
                                            </div>
						                    <!-- Cierre DETALLES -->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
    						                <!-- En esta Columna para la tabla de totales -->
						                    <table border="0" width="100%" bgcolor="#000000" cellspacing="1">
                                            	<!-- Code to support Dual Currency -->

                                                <c:choose>
                                                    <c:when test="${RODCourierCashRecapForm.dualCurrency ne 'true' or RODCourierCashRecapForm.currentCurrency ne 'split'}"> <!-- If not Dual currency tab selected -->
                                                        <tr>
                                                           <td width="100%" bgColor="#FFFF9C" colspan="7">
                                                               <p align="left">&nbsp;</p>
                                                           </td>
                                                        </tr>
                                                        <tr>
                                                            <td bgColor="#73148C" colspan="7">
                                                                <p align="center"><b><font color="#FFFFFF" face="Arial"><bean:message key="app.messages.Totals" /></font></b></p>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td bgColor="#C0C0C0" >&nbsp;</td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CashTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CheckTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CreditCardTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.DepositTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.TotalPayments" arg0="<%=currentCurrency1%>" /></font> </b></td>
                                                            <td bgColor="#C0C0C0">&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <bean:define id="frm" name="RODCourierCashRecapForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.RODCourierCashRecapForm"/>
                                                            <td bgColor="#C0C0C0" >&nbsp;</td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="cashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCashTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="checkTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCheckTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="creditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCreditCardTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getDepositTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="totalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getTotalPayments())%>"></p></td>
                                                            <td bgColor="#C0C0C0">&nbsp;</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise> <!-- Else if it is Dual currency tab selected -->
                                                        <tr>
                                                           <td width="100%" bgColor="#FFFF9C" colspan="12">
                                                               <p align="left">&nbsp;</p>
                                                           </td>
                                                        </tr>
                                                        <tr>
                                                            <td bgColor="#73148C" colspan="12">
                                                                <p align="center"><b><font color="#FFFFFF" face="Arial"><bean:message key="app.messages.Totals" /></font></b></p>
                                                            </td>
                                                        </tr>

                                                        <c:set var="localCurrency" value="split" />
                                                        <c:forEach var="currency" items="${RODCourierCashRecapForm.currentlyUsedCurrencies}">
                                                                <c:if test="${currency.currencyCode ne 'USD'}">
                                                                      <c:set var="localCurrency" value="${currency.currencyCode}" />
                                                                </c:if>
                                                        </c:forEach>
                                                        <bean:define id="frm" name="RODCourierCashRecapForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.RODCourierCashRecapForm"/>
                                                        <tr>
                                                            <td bgColor="#73148C" align="center" rowspan="2" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><c:out value="${localCurrency}"/></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.CashTotal" arg0="${localCurrency}" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.CheckTotal" arg0="${localCurrency}" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.CreditCardTotal" arg0="${localCurrency}" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.DepositTotal" arg0="${localCurrency}" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.TotalPayments" arg0="${localCurrency}"/></font> </b></td>
                                                            <td bgColor="#C0C0C0">&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="cashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCashTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="checkTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCheckTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="creditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCreditCardTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getDepositTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="totalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getTotalPayments())%>"></p></td>
                                                            <td bgColor="#C0C0C0">&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td bgColor="#73148C" align="center" rowspan="2" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">USD</font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CashTotal" arg0="USD" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CheckTotal" arg0="USD" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CreditCardTotal" arg0="USD" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.DepositTotal" arg0="USD" /></font></b></td>
                                                            <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.TotalPayments" arg0="USD" /></font> </b></td>
                                                            <td bgColor="#C0C0C0">&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="cashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCashTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="checkTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCheckTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="creditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCreditCardTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdDepositTotal())%>"></p></td>
                                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="totalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdTotalPayments())%>"></p></td>
                                                            <td bgColor="#C0C0C0">&nbsp;</td>
                                                        </tr>
                                                    </c:otherwise>
                                                </c:choose>

							                </table>
						                    <!-- Cierre tabla totales -->
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                        <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                    </tr>
                    <tr bgcolor="#808080" height="1">
                        <td colspan=5><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                    </tr>
                </table>
                <!-- CIERRE TABLA TABS INTERNOS, DETALLES Y TOTALES -->
	        </td>
            <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
        <!--Fila para mantener color de borde (gris) -->
        <tr bgcolor="#808080" height="1">
	        <td colspan=3><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
    </table>
</nested:form>
</logic:present>
<form name="createReports" method="POST">
        <input type="HIDDEN" name="Format" value="PDF">
        <input type="HIDDEN" name="locationCd" value="<bean:write name="userProfile" property="locationCd" />">
        <input type="HIDDEN" name="employeeId" value="<bean:write name="RODCourierCashRecapForm" property="courier" />">
        <input type="HIDDEN" name="chkEmpId" value="<bean:write name="userProfile" property="employeeId" />">
        <input type="HIDDEN" name="StyleSheet" value="">
</form>