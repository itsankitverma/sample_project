<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>
<%@taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean-el" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="calendar" %>

<script src="<html:rewrite page="/scripts/calendar.js" />"></script>
<script src="<html:rewrite page="/scripts/calendar-msgs-" /><bean:message key="app.Language" />.js"></script>
<script src="<html:rewrite page="/scripts/calendar-setup.js" />"></script>
<LINK REL ="stylesheet" TYPE="text/css" HREF="<html:rewrite page="/styles/calendar.css" />" TITLE="Style">

<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>
<%
	// to resolve the calendar discripancy 
	int id = 0;
%>
<html:errors />
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>
        <bean:size id="paymenTypeCount" name="GroundCashRecapForm" property="paymentTypes" />
        var pymtCtgAssoc=new Array(<bean:write name="paymenTypeCount" />);
        <logic:iterate id="elem" name="GroundCashRecapForm" property="paymentTypes">
              pymtCtgAssoc["<bean:write name="elem" property="paymentTypeId" />"] = "<bean:write name="elem" property="paymentCtgId" />";
        </logic:iterate>

        <bean:size id="banksCount" name="GroundCashRecapForm" property="countryBanks" />
        var countryBanksAssoc=new Array(<bean:write name="banksCount" />);
        
        <logic:iterate id="elem" name="GroundCashRecapForm" property="countryBanks">
            <logic:present name="elem" property="bankCd" >
	              countryBanksAssoc[String(Number("<bean:write name="elem" property="bankCd" />"))] = "<bean:write name="elem" property="bankShtDesc" />";
	        </logic:present>
		</logic:iterate>

		 <bean:write name="checkDecodeJS" scope="session" />


    function docNbrKey(e,obj) {
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            obj.blur();
      }
    }

    function toROD(){
        var valid=validate(false);
        if(valid==""){
            var form=document.forms['GroundCashRecapForm'];
            form.pageNumber.value=1;
            form.sortColumn.value="paymentId";
            form.sortDirection.value="asc";
            form.action.value="toROD";
            form.submit();
        }else{
            alert(valid);
        }
    }
    
    function validateForAlphanumeric(id) {
    	var value = document.getElementById(id).value;
    	
    	var pattern = new RegExp("^([0-9a-zA-Z]*)$");
    	
    	if(!pattern.test(value)) {
    		value = value.substring(0,value.length-1);
    		document.getElementById(id).value = value;
    	}
    	
    }    
    
    function toCOD(){
        var valid=validate(false);
        if(valid==""){
            var form=document.forms['GroundCashRecapForm'];
            form.pageNumber.value=1;
            form.sortColumn.value="paymentId";
            form.sortDirection.value="asc";
            form.action.value="toCOD";
            form.submit();
        }else{
            alert(valid);
        }
    }
    
    function toFTC(){
        var valid=validate(false);

        if(valid==""){
            var form=document.forms['GroundCashRecapForm'];
            form.action.value="toFTC";
            form.submit();
        }else{
            alert(valid);
        }

    }
    
    function toPOA(){
        var valid=validate(false);

        if(valid==""){
            var form=document.forms['GroundCashRecapForm'];
            form.action.value="toPOA";
            form.submit();
        }else{
            alert(valid);
        }

    }

    function nextCourier(){
        var form=document.forms['GroundCashRecapForm'];
        if(form.elements['courier'].selectedIndex < form.elements['courier'].length-1){
            form.elements['courier'].selectedIndex++;
            changeCourier();
        }
    }

    function previousCourier(){
        var form=document.forms['GroundCashRecapForm'];
        if(form.elements['courier'].selectedIndex>0){
            form.elements['courier'].selectedIndex--;
            changeCourier();
        }
    }

    function changeCourier(){
        var valid=validate(false);

        if(valid==""){
            var form=document.forms['GroundCashRecapForm'];
            form.pageNumber.value=1;
            form.sortColumn.value="grnd_trak_nbr";
            form.sortDirection.value="asc";
            form.action.value="changeCourier";
            form.submit();
        }else{
            alert(valid);
        }
    }

    function changeTab(currencyCode){
        var valid=validate(false);
        if(valid==""){
            var form=document.forms['GroundCashRecapForm'];
            form.elements['previousCurrencyCode'].value=form.elements['currentCurrency'].value;
            form.elements['currentCurrency'].value=currencyCode;
            form.elements['pageNumber'].value=1;
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
        var form=document.forms['GroundCashRecapForm'];
        var valid=validate(true);

        if(valid==""){
            if(confirm('<bean:message key="app.messages.js.ConfirmCloseCourier" />')){
                 form.elements['action'].value='CloseEmployee';
                 form.submit();
            }
        }else{
            alert(valid);
        }
    }

    function showPage(page){
        var form=document.forms['GroundCashRecapForm'];
        var valid=validate(false);
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
        var form=document.forms['GroundCashRecapForm'];
        var valid=validate(false);

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

    function toPrepaid(){
        var valid=validate(false);

        if(valid==""){
            var form=document.forms['GroundCashRecapForm'];
            form.pageNumber.value=1;
            form.sortColumn.value="awb_nbr";
            form.sortDirection.value="asc";
            form.action.value="toPrepaid";
            form.submit();
        }else{
            alert(valid);
        }
    }

<c:choose>
    <c:when test="${GroundCashRecapForm.dualCurrency ne 'true' or GroundCashRecapForm.currentCurrency ne 'split'}"> <!-- If not Dual currency tab selected -->
            function cashChanged(){
                var form=document.forms['GroundCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="GroundCashRecapForm" property="cashSubTotal"/>);
                while(eval("form.elements['trackNbrs["+index+"].groundId']")){
                    if(!isNaN(eval("form.elements['trackNbrs["+index+"].cashPayment']").value)){
                        total=total+Number(eval("form.elements['trackNbrs["+index+"].cashPayment']").value);
                    }
                    index++;
                }

                form.cashTotal.value=format_number(total,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);

            }

            function couponChanged(){
                var form=document.forms['GroundCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="GroundCashRecapForm" property="couponSubTotal"/>);
                while(eval("form.elements['trackNbrs["+index+"].groundId']")){
                    if(!isNaN(eval("form.elements['trackNbrs["+index+"].couponPayment']").value)){
                        total=total+Number(eval("form.elements['trackNbrs["+index+"].couponPayment']").value);
                    }
                    index++;
                }

                form.couponTotal.value=format_number(total,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);

            }

            function otherChanged(){
                var form=document.forms['GroundCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var totalCheck=Number(<bean:write name="GroundCashRecapForm" property="checkSubTotal"/>);
                var totalCreditCard=Number(<bean:write name="GroundCashRecapForm" property="creditCardSubTotal"/>);
                var totalDeposit=Number(<bean:write name="GroundCashRecapForm" property="depositSubTotal"/>);

                while(eval("form.elements['trackNbrs["+index+"].groundId']")){
                    var pt=eval("form.elements['trackNbrs["+index+"].otherPaymentType']");
                    var ptIndex=pt.selectedIndex;

                    if(!isNaN(eval("form.elements['trackNbrs["+index+"].otherPayment']").value)){
                        switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                            case "1": totalCheck=totalCheck+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                            case "3": totalCreditCard=totalCreditCard+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                            case "2": totalDeposit=totalDeposit+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                        }

                    }
                    index++;
                }
                form.checkTotal.value=format_number(totalCheck,2);
                form.creditCardTotal.value=format_number(totalCreditCard,2);
                form.depositTotal.value=format_number(totalDeposit,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);
            }

    </c:when>
    <c:otherwise>

            function cashChanged(){
                var form=document.forms['GroundCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="GroundCashRecapForm" property="cashSubTotal"/>);
                var usdTotal=Number(<bean:write name="GroundCashRecapForm" property="usdCashSubTotal"/>);
                while(eval("form.elements['trackNbrs["+index+"].groundId']")){
                    if(!isNaN(eval("form.elements['trackNbrs["+index+"].cashPayment']").value)){
                        if(eval("form.elements['trackNbrs["+index+"].paymentCurrency']").value=="USD"){
                            usdTotal=usdTotal+Number(eval("form.elements['trackNbrs["+index+"].cashPayment']").value);
                        }else{
                            total=total+Number(eval("form.elements['trackNbrs["+index+"].cashPayment']").value);
                        }


                    }
                    index++;
                }

                form.cashTotal.value=format_number(total,2);
                form.usdCashTotal.value=format_number(usdTotal,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);
                form.usdTotalPayments.value=format_number(Number(form.usdCashTotal.value)+Number(form.usdCheckTotal.value)+Number(form.usdCreditCardTotal.value)+Number(form.usdCouponTotal.value)+Number(form.usdDepositTotal.value),2);

            }

            function couponChanged(){
                var form=document.forms['GroundCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="GroundCashRecapForm" property="couponSubTotal"/>);
                var usdTotal=Number(<bean:write name="GroundCashRecapForm" property="usdCouponSubTotal"/>);
                while(eval("form.elements['trackNbrs["+index+"].groundId']")){
                    if(!isNaN(eval("form.elements['trackNbrs["+index+"].couponPayment']").value)){
                        if(eval("form.elements['trackNbrs["+index+"].paymentCurrency']").value=="USD"){
                            usdTotal=usdTotal+Number(eval("form.elements['trackNbrs["+index+"].couponPayment']").value);
                        }else{
                            total=total+Number(eval("form.elements['trackNbrs["+index+"].couponPayment']").value);
                        }
                    }
                    index++;
                }

                form.couponTotal.value=format_number(total,2);
                form.usdCouponTotal.value=format_number(usdTotal,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);
                form.usdTotalPayments.value=format_number(Number(form.usdCashTotal.value)+Number(form.usdCheckTotal.value)+Number(form.usdCreditCardTotal.value)+Number(form.usdCouponTotal.value)+Number(form.usdDepositTotal.value),2);
            }

            function otherChanged(){
                var form=document.forms['GroundCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var totalCheck=Number(<bean:write name="GroundCashRecapForm" property="checkSubTotal"/>);
                var totalCreditCard=Number(<bean:write name="GroundCashRecapForm" property="creditCardSubTotal"/>);
                var totalDeposit=Number(<bean:write name="GroundCashRecapForm" property="depositSubTotal"/>);
                var usdTotalCheck=Number(<bean:write name="GroundCashRecapForm" property="usdCheckSubTotal"/>);
                var usdTotalCreditCard=Number(<bean:write name="GroundCashRecapForm" property="usdCreditCardSubTotal"/>);
                var usdTotalDeposit=Number(<bean:write name="GroundCashRecapForm" property="usdDepositSubTotal"/>);


                while(eval("form.elements['trackNbrs["+index+"].groundId']")){
                    var pt=eval("form.elements['trackNbrs["+index+"].otherPaymentType']");
                    var ptIndex=pt.selectedIndex;

                    if(!isNaN(eval("form.elements['trackNbrs["+index+"].otherPayment']").value)){
                        if(eval("form.elements['trackNbrs["+index+"].paymentCurrency']").value=="USD"){
                                switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                                    case "1": usdTotalCheck=usdTotalCheck+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                                    case "3": usdTotalCreditCard=usdTotalCreditCard+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                                    case "2": usdTotalDeposit=usdTotalDeposit+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                                }
                        }else{
                                switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                                    case "1": totalCheck=totalCheck+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                                    case "3": totalCreditCard=totalCreditCard+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                                    case "2": totalDeposit=totalDeposit+Number(eval("form.elements['trackNbrs["+index+"].otherPayment']").value);break;
                                }
                        }

                    }
                    index++;
                }
                form.usdCheckTotal.value=format_number(usdTotalCheck,2);
                form.usdCreditCardTotal.value=format_number(usdTotalCreditCard,2);
                form.usdDepositTotal.value=format_number(usdTotalDeposit,2);

                form.checkTotal.value=format_number(totalCheck,2);
                form.creditCardTotal.value=format_number(totalCreditCard,2);
                form.depositTotal.value=format_number(totalDeposit,2);

                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);
                form.usdTotalPayments.value=format_number(Number(form.usdCashTotal.value)+Number(form.usdCheckTotal.value)+Number(form.usdCreditCardTotal.value)+Number(form.usdCouponTotal.value)+Number(form.usdDepositTotal.value),2);
            }

    </c:otherwise>
</c:choose>


    function changePaymentCurr(groundId,newCurr){
        var form=document.forms['GroundCashRecapForm'];
        if(confirm('<bean:message key="app.messages.js.TryToChangeRecPaymentCurrency" />')){
            form.elements['action'].value='ChangePaymentCurr';
            form.elements['groundId'].value=groundId;
            form.elements['newCurr'].value=newCurr;
            form.submit();
        }
    }

    function updateInformation(){
        var form=document.forms['GroundCashRecapForm'];
        var valid=validate(false);

        if(validateBillAccountComment()){
            if(valid==""){
                //if(confirm('<bean:message key="app.messages.js.UpdateInformation" />')){
                    form.elements['action'].value='UpdateInformation';
                    form.submit();
                //}
            }else{
                alert(valid);
            }
        }else{
            alert("Please add Bill to Account number to comment field");
        }
    }

    function changeStatus(cbo){
        var form=document.forms['GroundCashRecapForm'];
        var index=findIndex(cbo.name,1);
        var msg=""
        if(eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex==1){
			cashPayment=eval("form.elements['trackNbrs["+index+"].cashPayment']").value;
			otherPayment=eval("form.elements['trackNbrs["+index+"].otherPayment']").value;
			couponPayment=eval("form.elements['trackNbrs["+index+"].couponPayment']").value;
                        var pt=eval("form.elements['trackNbrs["+index+"].otherPaymentType']");
                        var ptIndex=pt.selectedIndex;
                        otherPaymentType=pymtCtgAssoc[pt.options[ptIndex].value];
			otherDocNumber=eval("form.elements['trackNbrs["+index+"].otherDocNumber']").value;
			comment=eval("form.elements['trackNbrs["+index+"].comment']").value;


            if(isNaN(cashPayment) || isNaN(otherPayment) || isNaN(couponPayment)){
				eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
				alert("<bean:message key="app.messages.js.BadMontos" />");
				return;
			}else{
				cashPayment=Number(cashPayment);
				otherPayment=Number(otherPayment);
                                couponPayment=Number(couponPayment);

                                if(cashPayment<0 || otherPayment<0 ||couponPayment<0){
                                    eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
                                    alert("<bean:message key="app.messages.js.BadMontos" />");
                                    return;
                                }

                                if(Number(cashPayment)==Number(0) && Number(otherPayment)==Number(0) && Number(couponPayment)==Number(0) && comment.length==0){
                                    eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
          			    alert("<bean:message key="app.messages.js.CommentsNotEntered" />");
                                    return;
                                }

                                /* Chaca validaciones monto ingresado 12/2007:

                                    1.- el monto ingresado mayor al monto esperado.
                                    2.- el monto ingresado no sea la AWB.

                                */

                                groundTrackNumber=Number( eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value);

                                if(groundTrackNumber == cashPayment || groundTrackNumber == otherPayment || groundTrackNumber == couponPayment)
                                {
                                    eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
                                    alert("<bean:message key="app.messages.js.AmountEqualTrkNumber" />");
                                    return;
                                }                
            }

                        var error=<logic:equal name="GroundCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdUsd" /></logic:equal><logic:notEqual name="GroundCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdLocal" /></logic:notEqual>;

			if(otherPayment>0 && ptIndex==0){
					eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.MustSelectOtherPaymentType" />");
					return;
			}

			if(otherPayment==0 && ptIndex>0){
					eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.MustEnterOtherPayment" />");
					return;
			}


			if(otherPayment>0 && otherDocNumber.length<1){
					eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.DocNumberNotEntered" />");
					return;
			}

			if(otherPaymentType==3 && otherDocNumber.length>4){
					eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.CreditCardNumberDigits" />");
					return;
			}

        }else if (form.elements['trackNbrs['+index+'].statusId'].value==3){
        	var w=320;
        	var h=160;
        	if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;
            billAccount=eval("form.elements['trackNbrs["+index+"].billAccount']").value;
			var params = "formName=Ground&index="+index+"&billAccount="+billAccount;
			window.open("<html:rewrite page="/pages/BillToAccount.jsp" />?"+params,"BillAccount","scrollbars=no,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
        }
    }

    function checkLine(index){
        var form=document.forms['GroundCashRecapForm'];
        var msg="";
        if(eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex==1){
			cashPayment=eval("form.elements['trackNbrs["+index+"].cashPayment']").value;
			otherPayment=eval("form.elements['trackNbrs["+index+"].otherPayment']").value;
			couponPayment=eval("form.elements['trackNbrs["+index+"].couponPayment']").value;
                        var pt=eval("form.elements['trackNbrs["+index+"].otherPaymentType']");
                        var ptIndex=pt.selectedIndex;
                        otherPaymentType=pymtCtgAssoc[pt.options[ptIndex].value];
			otherDocNumber=eval("form.elements['trackNbrs["+index+"].otherDocNumber']").value;
			comment=eval("form.elements['trackNbrs["+index+"].comment']").value;


			if(isNaN(cashPayment) || isNaN(otherPayment) || isNaN(couponPayment)){
				msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
				return msg;
			}else{
				cashPayment=Number(cashPayment);
				otherPayment=Number(otherPayment);
				couponPayment=Number(couponPayment);

                                if(cashPayment<0 || otherPayment<0 ||couponPayment<0){
                                    msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
                                    return msg;
                                }

                                if(cashPayment==Number(0) && otherPayment==Number(0) && couponPayment==Number(0) && comment.length==0){
          			    msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="app.messages.js.CommentsNotEntered" />\n";
                                    return msg;
                                }
			}

                        var error=<logic:equal name="GroundCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdUsd" /></logic:equal><logic:notEqual name="GroundCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdLocal" /></logic:notEqual>;

			if(otherPayment>0 && ptIndex==0){
      				msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="app.messages.js.MustSelectOtherPaymentType" />\n";
        			return msg;
			}

			if(otherPayment==0 && ptIndex>0){
      				msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="app.messages.js.MustEnterOtherPayment" />\n";
        			return msg;
			}

			if(otherPayment>0 && otherDocNumber.length<1){
      				msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="app.messages.js.DocNumberNotEntered" />\n";
        			return msg;
			}

			if(otherPaymentType==3 && otherDocNumber.length>4){
      				msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="app.messages.js.CreditCardNumberDigits" />\n";
        			return msg;
			}
        }else if (form.elements['trackNbrs['+index+'].statusId'].value==3){
        	comment = document.forms['GroundCashRecapForm'].elements['trackNbrs['+index+'].otherComment'].value;
                billAcct = document.forms['GroundCashRecapForm'].elements['trackNbrs['+index+'].billAccount'].value;
                if(billAcct.length == 0){
                   eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex=0;
                   msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="app.messages.AddAccountNumber" />\n";
                   return msg;
                }
                if((billAcct == "999999999") && (comment.length == 0) ){
                	msg=msg+"-TRACK "+ eval("form.elements['trackNbrs["+index+"].groundTrackNumber']").value +": <bean:message key="errors.messages.CommentMissing" />\n";
                	return msg;
                }
        }
        return msg;
    }

    function findIndex(name,after){
        var from=name.indexOf("[",after)+1;
        var to=name.indexOf("]",after);
        return name.substr(from,to-from);
    }

    function validate(isClosing){
        var form=document.forms['GroundCashRecapForm'];
        var msg="";
        var index=Number(<bean:write name="offset" />);
        var some=false;
        var canClose=<bean:write name="GroundCashRecapForm" property="canClose" />;

        while(eval("form.elements['trackNbrs["+index+"].groundId']")){
            if(isClosing && (!canClose || eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex<=0)){
                msg="<bean:message key="errors.messages.js.AllInvoicesStateToClose" />";
                break;
            }
            msg=msg+checkLine(index);
            index++;
        }
        if(msg==""){
            return "";
        }else{
            return "<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;

        }
    }

    function reassignPayments(){
    		var form=document.forms['GroundCashRecapForm'];
            var w=400;
            var h=200;
            var index=Number(<bean:write name="offset" />);
            var count=Number(0);
            var empId;

	        while(eval("form.elements['trackNbrs["+index+"].groundId']") && count<1){
	            if(eval("form.elements['trackNbrs["+index+"].selected']").checked){
	               count++;
	            }
	            index++;
	        }

	        if(count==0){
	        	alert("<bean:message key="app.messages.MustSelectPaymentReassign"/> ");
	        	return;
	        }

	        var params="summary=false&oldEmployee=<bean:write name="GroundCashRecapForm" property="courier"/>";


            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;

            window.open("<html:rewrite page="/pages/ReassignPayments.jsp" />?"+params,"reassign","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }

    function splitCurrency(){
    		var form=document.forms['GroundCashRecapForm'];
            var w=320;
            var h=180;
            var index=Number(<bean:write name="offset" />);
            var count=Number(0);
            var empId;

	        while(eval("form.elements['trackNbrs["+index+"].groundId']")){
	            if(eval("form.elements['trackNbrs["+index+"].selected']").checked){
	               count++;
	            }
	            index++;
	        }

	        if(count==0){
	        	alert("<bean:message key="app.messages.MustSelectSplitCurrency"/> ");
	        	return;
	        }

	        var params="summary=false&count=" + count;


            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;

            window.open("<html:rewrite page="/pages/SplitCurrencyPayments.jsp" />?"+params,"SplitCurrency","scrollbars=no,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }

    function addGrndTrakNbrs(){
        var form=document.forms['GroundCashRecapForm'];
        var valid=validate(false);

        if(valid==""){
                form.elements['action'].value='UpdateInformation';
                form.elements['reload'].value='YES';
                var w=800;
                var h=450;
                if(w>screen.width)w=screen.width;
                if(h>screen.height)h=screen.height;
                var leftpos=(screen.width-w) / 2;
                var toppos=(screen.height-h) / 2;
                window.open("<html:rewrite page="/Ground/AddGrndTrakNbrs.do" />?courierId=<bean:write name="GroundCashRecapForm" property="courier"/>&courierName=<bean:write name="GroundCashRecapForm" property="courierName"/>&currentCurrency=<bean:write name="GroundCashRecapForm" property="currentCurrency"/>", "addTrackNbrsWindow", "scrollbars=no,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
                form.submit();
        }else{
            alert(valid);
        }
    }

	function updateField(codeVal, index, otherComment)
    {
		if(codeVal.length > 0)
		{  document.forms['GroundCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasComment.gif"/>';
		   document.forms['GroundCashRecapForm'].elements['imgComment'+index].alt=codeVal;
		}else{
				document.forms['GroundCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasNoComment.gif"/>';
			    document.forms['GroundCashRecapForm'].elements['imgComment'+index].alt='<bean:message key="app.messages.js.ViewAddComment"/>';
			}
		document.forms['GroundCashRecapForm'].elements['trackNbrs['+index+'].comment'].value=codeVal;

		if(otherComment.length>0)
		{  if(codeVal.length == 0)
	       {   document.forms['GroundCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasComment.gif"/>';
		   	   document.forms['GroundCashRecapForm'].elements['imgComment'+index].alt="";
		   }
		}else{
				if(codeVal.length == 0)
				{   document.forms['GroundCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasNoComment.gif"/>';
		   		   document.forms['GroundCashRecapForm'].elements['imgComment'+index].alt='<bean:message key="app.messages.js.ViewAddComment"/>';
				}
			 }
		document.forms['GroundCashRecapForm'].elements['trackNbrs['+index+'].otherComment'].value=otherComment;
    }

	function processScans(){
        var form=document.forms['GroundCashRecapForm'];
        form.elements['action'].value='ProcessScans';
        form.submit();
    }

    function changeReceiptNbr(idx){
        var rcptNbr=eval("document.forms['GroundCashRecapForm'].elements['trackNbrs["+idx+"].rcptNbr']");
        var rcptNbrPrev=eval("document.forms['GroundCashRecapForm'].elements['trackNbrs["+idx+"].rcptNbrPrev']");
		var newRcptNbr=prompt("<bean:message key="app.messages.js.EnterNewReceipt" />",rcptNbr.value);

        while(newRcptNbr!=null && !validRecNbr(newRcptNbr)){
			newRcptNbr=prompt("<bean:message key="app.messages.js.ReEnterNewReceipt" />",rcptNbr.value);
		}

		if(newRcptNbr!=null){
			rcptNbrPrev.value=rcptNbr.value;
			rcptNbr.value=newRcptNbr;
		}
    }
 function changeCustName(idx){

            var cust=eval("document.forms['GroundCashRecapForm'].elements['trackNbrs["+idx+"].custNm']");

            var custPrev=eval("document.forms['GroundCashRecapForm'].elements['trackNbrs["+idx+"].custNmPrev']");

            var custName=prompt("<bean:message key="app.messages.js.EnterNewCust" />",cust.value);

        while(custName!=null && (custName=="" || custName.length>50)){
			custName=prompt("<bean:message key="app.messages.js.ReEnterNewCust" />",cust.value);
		}

        if(custName!=null){
			custPrev.value=cust.value;
			cust.value=custName;
		}
}




    function validRecNbr(newRcptNbr) {
		if(newRcptNbr=="" || newRcptNbr.length>20){
			return false;
		}else{                                 
	    	var re=/^[a-zA-Z0-9/-\\]+$/;
	    	return re.test(newRcptNbr);
	    }
	}

	function checkRcptNbr(obj) {
		if(obj.value!=null && obj.value!="" && !validRecNbr(obj.value)){
			obj.focus();
			alert("<bean:message key="app.messages.js.ReEnterNewReceipt" />");
		}
	}

    function validateBillAccountComment()
    {
        var form    = document.forms['GroundCashRecapForm'];
        var comment = "";

        var index=0;
        while(eval("form.elements['trackNbrs["+index+"].statusId']")){
            if(eval("form.elements['trackNbrs["+index+"].statusId']").selectedIndex==3){
                comment = document.forms['GroundCashRecapForm'].elements['trackNbrs['+index+'].otherComment'].value;
                if(comment.length == 0){
                    return false;
                }
            }
            index++;
        }
        return true;
     }
</script>

<!-- Include comments functionality -->
<jsp:include page="../Comments.jsp" flush="true" />
<logic:present name="GroundCashRecapForm">
    <nested:form action="/Ground/GroundDetails.do">
        <input type="hidden" name="action">
        <input type="hidden" name="groundId">
        <input type="hidden" name="reload">
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
        <div align="left">
            <table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#808080">
                <tr>
                    <td bgcolor="#FFFFFF">
                        <p align="center">
                            <font color="#73148C"><font face="Arial" size="3"><b>
                            <html:link href="javascript:previousCourier();">
                                <html:img page="/images/Back.gif" border="0"  width="17" height="17"/>
                            </html:link>&nbsp;&nbsp;&nbsp;
                            <bean:message key="app.messages.AWBDetailsForEmployee" />
                            <nested:select property="courier" onchange="changeCourier();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                 <option value="ALL">ALL COURIERS</option>
                            <nested:root name="GroundCashRecapForm">
                                 <nested:optionsCollection property="employeesWithPayments" label="value" value="key" />
                            </nested:root>
                            </nested:select>
                            &nbsp;&nbsp;&nbsp;
                            <html:link href="javascript:nextCourier();">
                                <html:img page="/images/Next.gif" border="0"  width="17" height="17"/>
                            </html:link>
                            </b></font>
                        </p>
                    </td>
                    <td bgcolor="#FFFFFF">
                        <p align="center"><a href="javascript:courierReceiptReport();">
                            <img border="0" src="<html:rewrite page="/images/CreateReceipt"/><bean:message key="app.Language" />.gif" width="114" height="38"></a><A href="javascript:closeEmployee();"><img border="0" src="<html:rewrite page="/images/CloseEmployee" /><bean:message key="app.Language" />.gif" width="114" height="38"></A>
                        </p>
                    </td>
                </tr>
            </table>
        </div>
        <!-- Tabla separadora-->
        <!-- TABLA DE TABS SUPERIORES -->
        <div align="left">
        	<!--  <table cellpadding="0" cellspacing="1" border="0" bgcolor="#808080" width="100%"> -->
        	<table cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF" width="100%">
                <tr height="1">
	                <td colspan="1" width="5" bgcolor="#FFFFFF">&nbsp;</td>
	                <td rowspan="2"><!-- width="540" -->
	                	<html:link href="javascript:toROD();" >
	                		<img border="0" src="<html:rewrite page="/images/rod1.gif" />" width="135" height="33">
	                	</html:link>
	                	<html:link href="javascript:toPrepaid();" >
	                		<img border="0" src="<html:rewrite page="/images/prepaid1.gif" />" width="135" height="33">
	                	</html:link>
	                	<html:link href="javascript:toPOA();" >
	                		<img border="0" src="<html:rewrite page="/images/poa1.gif" />" width="135" height="33">
	                	</html:link>
	                	<img border="0" src="<html:rewrite page="/images/ground.gif"/>" width="135" height="33">
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
                <tr height="1">
	                <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	                <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                </tr>
            </table>
        </div>
        <!-- tabla de contenidos del tab activo: tabs interiores, tabla de detalles y totales -->
        <div align="left">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
                <tr>
                    <!-- Fila para mantener color del tab activo-->
	                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	                <td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="5"></td>
	                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                </tr>
                <tr>
	                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	                <td bgcolor="#FFFF9C">
	                <!-- TABS INTERNOS, TABLA DE DETALLES Y TABLA DE TOTALES -->
		            <!-- Tabs internos -->
		                <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
		                    <tr height="1">
			                    <td width="8" bgcolor="#FFFF9C" align="left">&nbsp;</td>
			                    <td bgcolor="#FFFF9C" align="left" width="300">
                                    <nested:define id="currentCurrency1" property="currentCurrency" type="java.lang.String"/>
                                    <c:forEach var="currency" items="${GroundCashRecapForm.currentlyUsedCurrencies}">
                                        <c:choose>
                                            <c:when test="${currency.currencyCode eq GroundCashRecapForm.currentCurrency}">
                                                <c:choose>
                                                    <c:when test="${currency.currencyCode eq 'USD'}">
                                                        <IMG src="<html:rewrite page="/images/usd.gif" />">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <IMG src="<html:rewrite page="/images/local.gif" />">
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
                                    <!-- code to support dual currency -->
                                    <c:if test="${GroundCashRecapForm.dualCurrency eq 'true' }">
                                        <c:choose>
                                            <c:when test="${userProfile.splitCurrency eq 'true' and GroundCashRecapForm.currentCurrency ne 'split'}">
                                                <a href="javascript:changeTab('split')"> <IMG src="<html:rewrite page="/images/split1.gif" />" border="0"></a>
                                                
                                            </c:when>
                                            <c:when test="${userProfile.splitCurrency eq 'true' and GroundCashRecapForm.currentCurrency eq 'split'}">
                                                  <IMG src="<html:rewrite page="/images/split.gif" />">
                                            </c:when>
                                        </c:choose>
                                    </c:if>
                                    <logic:notPresent name="alternativeCurrency" >
                                        <c:forEach var="currency" items="${GroundCashRecapForm.supportedCurrencies}">
                                            <c:if test="${currency.currencyCode ne currentCurrency1}">
                                                <nested:define id="alternativeCurrency" name="currency" property="currencyCode"/>
                                            </c:if>
                                        </c:forEach>
                                    </logic:notPresent>
                            </td>
			                <td bgcolor="#FFFF9C" >&nbsp;</td>
                        </tr>
		                <tr height="1">
			                <td bgcolor="#808080" colspan="1" height="1" width="9px" align="left"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			                <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			                <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
		                </tr>
		            </table>
		            <!-- Tabla interna para detalles y totales -->
                    <div align="center">
		                <table cellpadding="0" cellspacing="0" border="0" bgcolor="#808080" width="90%">
			                <tr>
				                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
				                <td bgcolor="#FFFF9C"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
				                <td bgcolor="#FFFF9C" width="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			                </tr>
                            <tr>
				                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
				                <td bgcolor="#FFFF9C" align="center">
				                <!-- AQUI VAN LOS DETALLES -->
                                <div align="center">
                    				<table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#000000">
                    				    <tr>
				                            <td bgcolor="#FFFF9C" align="left">
						                        <c:if test="${userProfile.splitCurrency ne 'true' or GroundCashRecapForm.currentCurrency ne 'split'}">
                                                      <html:link href="javascript:reassignPayments()">
                                                            <img border="0" src="<html:rewrite page="/images/ReassignPaymentsGround" /><bean:message key="app.Language" />.gif" width="113" height="38" >
                                                      </html:link>
                                               </c:if>
                                               <c:if test="${userProfile.splitCurrency eq 'true' and GroundCashRecapForm.currentCurrency ne 'split'}">
                                                     <html:link href="javascript:splitCurrency()">
                                                            <img border="0" src="<html:rewrite page="/images/SplitCurrency" /><bean:message key="app.Language" />.gif" width="113" height="38" >
                                                    </html:link>
                                               </c:if>
                                               <a href="javascript:addGrndTrakNbrs();"><img border="0" src="<html:rewrite page="/images/addGround"/><bean:message key="app.Language" />.gif"></a>
                                            </td>
                                            <td bgcolor="#FFFF9C" align="center">
                                               <util:paging numberOfPages="${GroundCashRecapForm.numberOfPages}" pageNumber="${GroundCashRecapForm.pageNumber}" varStatus="std">
                                                    <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                                               </util:paging>
                                            </td>
                                            <td bgcolor="#FFFF9C" align="right">
                                                <A href="javascript:updateInformation();"><img border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif"></A>
                                                <html:link page="/ShowChkAgtCashRecap.do" ><img border="0" src="<html:rewrite page="/images/Summary" /><bean:message key="app.Language" />.gif"></html:link>
                                            </td>
				                        </tr>
				                    </table>
                                </div>
                                <div align="left">
						            <table border="0" bgcolor="#000000" cellspacing="1">
							            <tr>
								            <td bgColor="#73148C" width="2%" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">&nbsp;</font></p></b></td>
                                            <td bgColor="#73148C" width="2%" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">#</font></p></b></td>
							                        <td bgColor="#73148C" width="8%" align="center" rowspan="2">
                                                <c:choose>
                                                    <c:when test="${GroundCashRecapForm.sortColumn ne 'grnd_trak_nbr'}">
                                                        <a href="javascript:sortTable('grnd_trak_nbr','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.TRKNumber" /></font></b></a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:choose>
                                                            <c:when test="${GroundCashRecapForm.sortDirection eq 'desc'}">
                                                                <a href="javascript:sortTable('grnd_trak_nbr','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.TRKNumber" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/desc.gif" />"></p></b></a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="javascript:sortTable('grnd_trak_nbr','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.TRKNumber" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/asc.gif" />"></p></b></a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                <td bgColor="#73148C" width="2%" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><bean:message key="app.messages.CustomerName" /></font></p></b></td>

                                            <td bgColor="#73148C" width="8%" align="center" rowspan="2"><b><p align="center"><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.DocNbr" /></font></b></td>
			            				    <td bgColor="#73148C" width="10%" align="center" rowspan="2">
                                                <c:choose>
                                                    <c:when test="${GroundCashRecapForm.sortColumn ne 'grnd_shp_dt'}">
                                                        <a href="javascript:sortTable('grnd_shp_dt','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font></b></a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:choose>
                                                            <c:when test="${GroundCashRecapForm.sortDirection eq 'desc'}">
                                                                <a href="javascript:sortTable('grnd_shp_dt','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/desc.gif" />"></p></b></a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="javascript:sortTable('grnd_shp_dt','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/asc.gif" />"></p></b></a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <c:if test="${RODCourierCashREcap.dualCurrency eq 'true' or GroundCashRecapForm.currentCurrency eq 'split'}">
                                                  <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Currency" /></b></font></p></td>
                                            </c:if>
				            			    <td bgColor="#73148C" width="8%" rowspan="2" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Coupon" /></font></b></td>
							                <td bgColor="#73148C" width="8%" rowspan="2" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Cash" /></font></b></td>
							                <td bgColor="#73148C" width="8%" colspan="3" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.PaymentDocument" /></font></b></td>
							                <td bgColor="#73148C" width="12%" rowspan="2" align="center"><b><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Comments" /></font></b></td>
                                            <td bgColor="#73148C" width="8%" rowspan="2" align="center">
                                                <c:choose>
                                                    <c:when test="${GroundCashRecapForm.sortColumn ne 'status_cd'}">
                                                        <a href="javascript:sortTable('status_cd','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font></b></a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:choose>
                                                            <c:when test="${GroundCashRecapForm.sortDirection eq 'desc'}">
                                                                <a href="javascript:sortTable('status_cd','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/desc.gif" />"></p></b></a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="javascript:sortTable('status_cd','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/asc.gif" />"></p></b></a>
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
							                <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Amount" /></font></b></td>
							                <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Number" /></font></b></td>
							                <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Type" /></font></b></td>
                                        </tr>
                                        <nested:iterate property="trackNbrs" id="rec" indexId="idx"  type="com.fedex.lacitd.cashcontrol.biztier.common.GroundDetailsTableVO">
                                            <nested:hidden property="groundId" />
                                            <nested:hidden property="groundTrackNumber" />
                                            <nested:hidden property="comment" />
                                            <nested:hidden property="otherComment" />
                                            <nested:hidden property="couponPaymentPrev" />
                                            <nested:hidden property="cashPaymentPrev" />
                                            <nested:hidden property="otherPaymentPrev" />
                                            <nested:hidden property="otherDocNumberPrev" />
                                            <nested:hidden property="otherPaymentTypePrev" />
                                            <nested:hidden property="commentPrev" />
	                                        <nested:hidden property="statusIdPrev" />
	                                        <nested:hidden property="billAccount" />
	                                        <nested:hidden property="billAccountPrev" />
                                            <%--
                                             <!-- Code to suuport dual currency -->
                                                <c:choose>
                                                    <c:when test="${GroundCashRecapForm.currentCurrency eq 'split'}">
                                                          <c:out value="<input type=\"hidden\" name=\"awbs[${idx}].paymentCurrency\" value=\"${rec.paymentCurrency}\">" escapeXml="true"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                          <nested:hidden property="paymentCurrency" value="<%=currentCurrency1%>" />
                                                    </c:otherwise>
                                                </c:choose>
                                            --%>
	                                        <nested:hidden property="otherCommentPrev" />
                                            <nested:hidden property="rcptNbrPrev" />
                                            <nested:hidden property="custNmPrev" />
                                            <nested:hidden property="paymentCurrency" />
                                        	<%
                                                String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
                                                String fontColor;
                                               fontColor="#000000";
                                               String styleStr2="TEXT-ALIGN: left;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: "+bgColor+"; color: "+fontColor+"; border: 0; font-weight: bold ";
                                            %>
                                                 <tr>
                                                  <!-- if for split currency operation -->
                                                   <c:choose>
                                                           <c:when test="${GroundCashRecapForm.dualCurrency ne 'true' or GroundCashRecapForm.currentCurrency ne 'split'}">
                                                                <td bgColor="#73148C"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><nested:checkbox property="selected" /></font></p></b></td>
                                                                <td bgColor="#73148C"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><%=idx.intValue()+1%></font></p></b></td>
                                                                <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="groundTrackNumber" /></font></b></td>
        
                                                                  <td nowrap bgColor="<%=bgColor%>" align="center">

                                                                    <nested:notEmpty property="custNm">
                                                                      <b>
                                                                   <font face="Verdana, Arial, Helvetica, sans-serif" color="<%=bgColor%>" size="1">
                                                                        <a href="javascript:changeCustName(<%=idx%>)"><html:img page="/images/change.gif" border="0"/></a>

                                                                        <nested:text property="custNm" size="9" onfocus="blur()"  style="<%=\"TEXT-ALIGN: left;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; border: 0; font-weight: bold \"%>" />
                                                                     </font></b>
                                                                    </nested:notEmpty>
                                                                    <nested:empty property="custNm">
                                                                         <b>
                                                                 <font face="Verdana, Arial, Helvetica, sans-serif" color="<%=bgColor%>" size="1">
                                                                        <nested:text property="custNm"   maxlength="50" size="9" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt;font-weight: bold"/>
                                                                 </font></b>
                                                                     </nested:empty>

                                                                </td>

                                                                <td nowrap bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="<%=fontColor%>" size="1">
                                                                    <nested:notEmpty property="rcptNbr">
                                                                        <a href="javascript:changeReceiptNbr(<%=idx%>)"><IMG border="0" src="<html:rewrite page="/images/change.gif" />"></a>

                                                                        <nested:text property="rcptNbr" maxlength="20" onfocus="blur()"  size="6"  style="<%=styleStr2%>"/>
                                                                    </nested:notEmpty>
                                                                    <nested:empty property="rcptNbr">
                                                                        <nested:text property="rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="9" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt;font-weight: bold"/>
                                                                    </nested:empty>
                                                                    </font></b>
                                                                </td>
                                                                <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="trackDate" formatKey="app.format.Date" /></font></b></td>
                                                                <td bgColor="<%=bgColor%>" align="center" nowrap><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                                                                        <logic:present name="alternativeCurrency" >
                                                                            <A href="javascript:changePaymentCurr(<nested:write property="groundId" />,'<bean:write name="alternativeCurrency" />')"><IMG border="0" src="<html:rewrite page="/images/info.gif" />"></A>
                                                                        </logic:present>
                                                                        <nested:text property="couponPayment" onchange="couponChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCouponPayment())%>" /></font></b>
                                                                </td>
                                                                <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="cashPayment" onchange="cashChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCashPayment())%>" /></font></p></b></td>
                                                                <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherPayment" onchange="otherChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getOtherPayment())%>" /></font></p></b></td>
                                                                <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherDocNumber" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" /></font></p></b></td>
                                                                <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                                                    <nested:select property="otherPaymentType"  onchange="otherChanged();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                                                        <option>None</option>
                                                                        <html:optionsCollection name="GroundCashRecapForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"  />
                                                                    </nested:select>
                                                                </td>
                                                                <td bgColor="<%=bgColor%>" align="center">
                                                                <!-- Pone la figura para indicar si tiene o no comentarios -->
                                                                    <A href="javascript:showCommentsWindow(<%=idx.intValue()%>,'trackNbrs','GroundCashRecapForm','comment', 'otherComment',document.GroundCashRecapForm.elements['trackNbrs['+<%=idx.intValue()%>+'].billAccount'].value);">
                                                                        <logic:notEmpty name="rec" property="comment">
                                                                            <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>" alt="<bean:write name="rec" property="comment"/>">
                                                                        </logic:notEmpty>
                                                                        <logic:empty name="rec" property="comment">
                                                                            <logic:notEmpty name="rec" property="otherComment">
                                                                                <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>">
                                                                            </logic:notEmpty>
                                                                            <logic:empty name="rec" property="otherComment">
                                                                                <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasNoComment.gif"/>" alt="<bean:message key="app.messages.ViewAddComment"/>">
                                                                            </logic:empty>
                                                                        </logic:empty>
                                                                    </A>
                                                                </td>
                                                                <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                                                        <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onchange="changeStatus(this);">
                                                                            <nested:root name="GroundCashRecapForm">
                                                                                <nested:optionsCollection property="grnStatus" label="statusDesc" value="statusIdNbr" />
                                                                            </nested:root>
                                                                    </nested:select>
                                                                    </font>
                                                                </td>
                                                                
                                                                 <TD align="left" bgColor="<%=bgColor%>">
                                                                 	<FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
                                                                 		<!--calendar js  -->
                                                                 		<%String iconUrl=request.getContextPath()+"/images/cal.gif";%>
                                                                 		<input type="text" id="miscDate<%=id %>" name="trackNbrs[<%=id%>].miscDate" value="<bean:write name="rec" property="miscDate"/>" maxlength="10" size="10"/><a href="#"><img id="triggermiscDate<%=id %>" src="<%=iconUrl%>" border="0"/></a>
																	
																		<script type="text/javascript">
																			Calendar.setup({inputField     :    "miscDate<%=id %>",ifFormat       :    "%m/%d/%Y",button         :    "triggermiscDate<%=id %>",align          :    "Bl",singleClick    :    true});
																		</script>
																		
                                                                 		<!--calendar js  -->
                                                                 	</FONT>
                                                                 </TD>
                                                                 <TD align="center" bgColor="<%=bgColor%>">
                                                                   	<FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
                                                                   		<input type="text" id="miscNbr<%=id %>" onkeyup="validateForAlphanumeric('miscNbr<%=id %>')" name="trackNbrs[<%=id++ %>].miscNbr" value="<bean:write name="rec" property="miscNbr"/>" maxlength="15" size="15"/>
                                                                    </FONT>
                                                                 </TD> 
                                                                
                                                          </c:when>
                                                          <c:otherwise>
                                                                     <c:choose>
                                                                        <c:when test="${idx%2 eq 0}">
                                                                                <td bgColor="#73148C" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><nested:checkbox property="selected" /></font></p></b></td>
                                                                                <td bgColor="#73148C" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">
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
                                                                                </font></p></b></td>
                                                                                <td bgColor="<%=bgColor%>" rowspan="2" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="groundTrackNumber" /></font></b></td>
                                                                                <td nowrap bgColor="<%=bgColor%>" align="center" rowspan="2">
                                                                                    <nested:notEmpty property="custNm">
                                                                                      <b>
                                                                                   <font face="Verdana, Arial, Helvetica, sans-serif" color="<%=bgColor%>" size="1">
                                                                                        <a href="javascript:changeCustName(<%=idx%>)"><html:img page="/images/change.gif" border="0"/></a>

                                                                                        <nested:text property="custNm" size="9" onfocus="blur()"  style="<%=\"TEXT-ALIGN: left;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\"; color: \"+fontColor+\"; border: 0; font-weight: bold \"%>" />
                                                                                     </font></b>
                                                                                    </nested:notEmpty>
                                                                                    <nested:empty property="custNm">
                                                                                         <b>
                                                                                        <font face="Verdana, Arial, Helvetica, sans-serif" color="<%=bgColor%>" size="1">
                                                                                        <nested:text property="custNm"   maxlength="50" size="9" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt;font-weight: bold"/>
                                                                                        </font></b>
                                                                                     </nested:empty>
                                                                                </td>
                                                                                <td nowrap bgColor="<%=bgColor%>" align="center" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                                                                    <nested:notEmpty property="rcptNbr">
                                                                                        <a href="javascript:changeReceiptNbr(<%=idx%>)"><IMG border="0" src="<html:rewrite page="/images/change.gif" />"></a>
                                                                                        <%String styleStr="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\";  border: 0; font-weight: bold";%>
                                                                                        <nested:text property="rcptNbr" maxlength="20" onfocus="blur()"  size="9" style="<%=styleStr%>"/></FONT></B>
                                                                                    </nested:notEmpty>
                                                                                    <nested:empty property="rcptNbr">
                                                                                        <nested:text property="rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="9" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; font-weight: bold"/></FONT></B>
                                                                                    </nested:empty>
                                                                                    </font></b>
                                                                                </td>
                                                                                <td bgColor="<%=bgColor%>" align="center" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="trackDate" formatKey="app.format.Date" /></font></b></td>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                                    <!-- Hidden fields to support dual currency -->
                                                                                    <nested:hidden property="groundTrackNumber"/>
                                                                                    <nested:hidden property="rcptNbr"/>

                                                                        </c:otherwise>
                                                                     </c:choose>
                                                                    <TD align=center nowrap  bgColor="<%=bgColor%>" align="center"><p align="center"><b>
                                                                                    <FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1">
                                                                                            <nested:write property="paymentCurrency"/></B>
                                                                                    </FONT></p>
                                                                    </TD>
                                                                    <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:text property="couponPayment" onchange="couponChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCouponPayment())%>" /></font></b></td>
                                                                    <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="cashPayment" onchange="cashChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCashPayment())%>" /></font></p></b></td>
                                                                    <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherPayment" onchange="otherChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getOtherPayment())%>" /></font></p></b></td>
                                                                    <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherDocNumber" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'"/></font></p></b></td>
                                                                    <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                                                        <nested:select property="otherPaymentType"  onchange="otherChanged();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                                                            <option>None</option>
                                                                            <html:optionsCollection name="GroundCashRecapForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"  />
                                                                        </nested:select>
                                                                    </td>
                                                                    <td bgColor="<%=bgColor%>" align="center">
                                                                    <!-- Pone la figura para indicar si tiene o no comentarios -->
                                                                        <A href="javascript:showCommentsWindow(<%=idx.intValue()%>,'trackNbrs','GroundCashRecapForm','comment', 'otherComment','document.GroundCashRecapForm.elements['trackNbrs['+<%=idx.intValue()%>+'].billAccount'].value);">
                                                                            <logic:notEmpty name="rec" property="comment">
                                                                                <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>" alt="<bean:write name="rec" property="comment"/>">
                                                                            </logic:notEmpty>
                                                                            <logic:empty name="rec" property="comment">
                                                                                <logic:notEmpty name="rec" property="otherComment">
                                                                                    <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>">
                                                                                </logic:notEmpty>
                                                                                <logic:empty name="rec" property="otherComment">
                                                                                    <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasNoComment.gif"/>" alt="<bean:message key="app.messages.ViewAddComment"/>">
                                                                                </logic:empty>
                                                                            </logic:empty>
                                                                        </A>
                                                                    </td>
                                                                    <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                                                        <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onchange="changeStatus(this);">
                                                                            <nested:root name="GroundCashRecapForm">
                                                                                <nested:optionsCollection property="grnStatus" label="statusDesc" value="statusIdNbr" />
                                                                            </nested:root>
                                                                        </nested:select>
                                                                        </font>
                                                                    </td>
                                                         </c:otherwise>
                                                   </c:choose>
                                                </tr>
                                        </nested:iterate>
                                        <td bgcolor="#FFFF9C" colspan="14" align="center">
                                           <util:paging numberOfPages="${GroundCashRecapForm.numberOfPages}" pageNumber="${GroundCashRecapForm.pageNumber}" varStatus="std">
                                                <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                                           </util:paging>
                                        </td>
							        </table>
                                </div>
				                <!-- AQUI TERMINAN LOS DETALLES -->
				            </td>
				            <td bgcolor="#FFFF9C" width="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                        </tr>
                        <tr>
				            <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
				            <td bgcolor="#FFFF9C">&nbsp;</td>
				            <td bgcolor="#FFFF9C" width="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                        </tr>
			            <tr>
				            <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
				            <td bgcolor="#FFFF9C">
				            <!-- comienzo tabla de totales -->
                            <div align="left">
				                <table border="0" width="100%" bgcolor="#000000" cellspacing="1" cellpadding="0">
                                    <!-- Code to support Dual Currency -->
                                    <c:choose>
                                        <c:when test="${GroundCashRecapForm.dualCurrency ne 'true' or GroundCashRecapForm.currentCurrency ne 'split'}"> <!-- If not Dual currency tab selected -->
                                            <tr>
                                                <td bgcolor="#FFFF9C" colspan="8" align="center">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td bgcolor="#73148C" colspan="8" align="center">
                                                    <p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Totals" arg0="<%=currentCurrency1%>" /></font></b>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                                <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CouponTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CashTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CheckTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CreditCardTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                <td bgColor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.DepositTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.TotalPayments" arg0="<%=currentCurrency1%>" /></font></b></td>
                                                <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                            </tr>
                                            <bean:define id="frm" name="GroundCashRecapForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.GroundCashRecapForm"/>
                                            <tr>
                                                <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                                <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="couponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCouponTotal())%>"></p></td>
                                                <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="cashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCashTotal())%>"></p></td>
                                                <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="checkTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCheckTotal())%>"></p></td>
                                                <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="creditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCreditCardTotal())%>"></p></td>
                                                <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getDepositTotal())%>"></p></td>
                                                <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="totalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getTotalPayments())%>"></p></td>
                                                <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise> <!-- Else if it is Dual currency tab selected -->
                                            <tr>
                                                    <td bgcolor="#FFFF9C" colspan="8" align="center">&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td bgcolor="#73148C" colspan="8" align="center">
                                                        <p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Totals" arg0="<%=currentCurrency1%>" /></font></b>
                                                    </td>
                                                </tr>
                                                <c:set var="localCurrency" value="split" />
                                                    <c:forEach var="currency" items="${GroundCashRecapForm.currentlyUsedCurrencies}">
                                                            <c:if test="${currency.currencyCode ne 'USD'}">
                                                                  <c:set var="localCurrency" value="${currency.currencyCode}" />
                                                            </c:if>
                                                    </c:forEach>
                                                <bean:define id="frm" name="GroundCashRecapForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.GroundCashRecapForm"/>
                                                <tr>
                                                    <td bgColor="#73148C" align="center" rowspan="2" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><c:out value="${localCurrency}"/></b></font></td>
                                                    <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean-el:message key="app.messages.CouponTotal" arg0="${localCurrency}" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.CashTotal" arg0="${localCurrency}" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.CheckTotal" arg0="${localCurrency}" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.CreditCardTotal" arg0="${localCurrency}" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.DepositTotal" arg0="${localCurrency}" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean-el:message key="app.messages.TotalPayments" arg0="${localCurrency}"/></font> </b></td>
                                                    <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="couponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCouponTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="cashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCashTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="checkTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCheckTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="creditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCreditCardTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getDepositTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="totalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getTotalPayments())%>"></p></td>
                                                    <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                                </tr>
                                                    <td bgColor="#73148C" align="center" rowspan="2" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">USD</b></font></td>
                                                    <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CouponTotal" arg0="USD" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CashTotal" arg0="USD" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CheckTotal" arg0="USD" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.CreditCardTotal" arg0="USD" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.DepositTotal" arg0="USD" /></font></b></td>
                                                    <td bgColor="#C0C0C0" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><bean:message key="app.messages.TotalPayments" arg0="USD" /></font> </b></td>
                                                    <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                                <tr>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdCouponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCouponTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdCashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCashTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdCheckTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCheckTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdCreditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCreditCardTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdDepositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdDepositTotal())%>"></p></td>
                                                    <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdTotalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdTotalPayments())%>"></p></td>
                                                    <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                                </tr>
                                        </c:otherwise>
                                   </c:choose>
				                </table>
                             </div>
                            </td>
				            <!-- fin tables de totales -->
 				            <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			            </tr>
			            <tr bgcolor="#808080" height="1">
				            <td colspan=3><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			            </tr>
		            </table>
               </div>
		        <!-- CIERRE TABLA TABS INTERNOS, DETALLES Y TOTALES -->
            </td>
	        <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
        <!--Fila para mantener color de borde (gris) -->
        <tr>
	        <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="5"></td>
	        <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
        <tr bgcolor="#808080" height="1">
	        <td colspan=3><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
    </table>
    </div>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
</nested:form>
</logic:present>
<form name="createReports" method="POST">
        <input type="HIDDEN" name="Format" value="PDF">
        <input type="HIDDEN" name="locationCd" value="<bean:write name="userProfile" property="locationCd" />">
        <input type="HIDDEN" name="employeeId" value="<bean:write name="GroundCashRecapForm" property="courier" />">
        <input type="HIDDEN" name="chkEmpId" value="<bean:write name="userProfile" property="employeeId" />">
        <input type="HIDDEN" name="StyleSheet" value="">
</form>