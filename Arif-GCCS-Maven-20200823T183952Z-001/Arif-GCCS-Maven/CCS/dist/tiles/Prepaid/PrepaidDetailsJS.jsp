<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean-el" %>

<script>
    <bean:size id="paymenTypeCount" name="PRPCourierCashRecapForm" property="paymentTypes" />
        var pymtCtgAssoc=new Array(<bean:write name="paymenTypeCount" />);
        <logic:iterate id="elem" name="PRPCourierCashRecapForm" property="paymentTypes">
              pymtCtgAssoc["<bean:write name="elem" property="paymentTypeId" />"] = "<bean:write name="elem" property="paymentCtgId" />";
        </logic:iterate>

        <bean:size id="banksCount" name="PRPCourierCashRecapForm" property="countryBanks" />
        var countryBanksAssoc=new Array(<bean:write name="banksCount" />);
        <logic:iterate id="elem" name="PRPCourierCashRecapForm" property="countryBanks">
            <logic:present name="elem" property="bankCd" >
	              countryBanksAssoc[String(Number("<bean:write name="elem" property="bankCd" />"))] = "<bean:write name="elem" property="bankShtDesc" />";
	        </logic:present>
        </logic:iterate>

    <bean:write name="checkDecodeJS" scope="session" />

   function validateOac(isClosing){
       var form=document.forms['PRPCourierCashRecapForm'];
       var msg="";
       var index=Number(<bean:write name="offset" />);
       var some=false;
       var canClose=<bean:write name="PRPCourierCashRecapForm" property="canClose" />;

       while(eval("form.elements['oacs["+index+"].oacId']")){
           if(isClosing && (!canClose || eval("form.elements['oacs["+index+"].statusId']").selectedIndex<=0)){
               msg="<bean:message key="errors.messages.js.AllInvoicesStateToClose" />";
               break;
           }
           msg=msg+checkLineOAC(index);
           index++;
       }
       if(msg==""){
           return "";
       }else{
           return "<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;

       }
   }

   function validateFreOac(isClosing){
       var showFreOac;

       if(document.forms['PRPCourierCashRecapForm'].showFreightOAC[0])
       {  if(document.forms['PRPCourierCashRecapForm'].showFreightOAC[0].checked==true){
             showFreOac=document.forms['PRPCourierCashRecapForm'].showFreightOAC[0].value;
          }else{
                showFreOac=document.forms['PRPCourierCashRecapForm'].showFreightOAC[1].value;
               }
       }

       if(showFreOac=='OAC'){
          return validateOac(isClosing);
       }else{
             return validate(isClosing);
       }
    }

    function toFreOac(source){
        var valid;

        if(source=='FRE'){
           valid=validate(false);
        }else{
              valid=validateOac(false);
             }

        if(valid==""){
            var form=document.forms['PRPCourierCashRecapForm'];
            form.pageNumber.value=1;
            form.sortColumn.value="paymentId";
            form.sortDirection.value="asc";
            form.submit();
        }else{
            var form=document.forms['PRPCourierCashRecapForm'];
            if(source=='FRE'){
                form.showFreightOAC[0].checked=true;
            }
            else {
                form.showFreightOAC[1].checked=true;
            }
            alert(valid);
        }
    }

    function docNbrKey(e,obj) {
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            obj.blur();
      }
    }

    function toROD(){
        var valid=validateFreOac(false);
        if(valid==""){
            var form=document.forms['PRPCourierCashRecapForm'];
            form.action.value="toROD";
            form.pageNumber.value=1;
            form.sortColumn.value="awb_nbr";
            form.sortDirection.value="asc";
            form.submit();
        }else{
            alert(valid);
        }
    }

    function toCOD(){
        var valid=validateFreOac(false);
        if(valid==""){
            var form=document.forms['PRPCourierCashRecapForm'];
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
        var valid=validateFreOac(false);
        if(valid==""){
            var form=document.forms['PRPCourierCashRecapForm'];
            form.action.value="toFTC";
            form.pageNumber.value=1;
            form.sortColumn.value="awb_nbr";
            form.sortDirection.value="asc";
            form.submit();
        }else{
            alert(valid);
        }
    }
    
	function quickApplyStatus(){
    	var form=document.forms['PRPCourierCashRecapForm'];
    	var index=Number(0);
    	var recCount=Number(0);
	    <bean:size id="recCount" name="PRPCourierCashRecapForm" property="awbs" />
	    //if(recCount.intValue()>20){
    	var recCount1 = "<bean:write name='recCount'/>";
	    if(recCount1>20){
			 form.elements['action'].value="QuickApplyStatus";
			 form.submit();
	    }else{        
	        while(eval("form.elements['awbs["+index+"].prepaidId']")){
	            if(Number(eval("form.elements['awbs["+index+"].scanAmount']").value)>0 &&
	               (eval("form.elements['awbs["+index+"].statusId']").selectedIndex==0 ||
	                eval("form.elements['awbs["+index+"].statusId']").selectedIndex==2)&&
	               Number(eval("form.elements['awbs["+index+"].otherPayment']").value)<=0){
	            	eval("form.elements['awbs["+index+"].statusId']").selectedIndex=1;
	            }
	            index++;
	        }
	    }

	}

   function viewSurcharges(prepaidId,idx){
        var form=document.forms['PRPCourierCashRecapForm'];
        var valid=validate(false);

        if(valid==""){
                form.elements['action'].value='UpdateInformation';
                form.elements['reload'].value='YES';
                var w=400;
                var h=400;
                if(w>screen.width)w=screen.width;
                if(h>screen.height)h=screen.height;
                var leftpos=(screen.width-w) / 2;
                var toppos=(screen.height-h) / 2;
                var total=Number(eval("form.elements['awbs["+idx+"].cashPayment']").value)+Number(eval("form.elements['awbs["+idx+"].otherPayment']").value)+Number(eval("form.elements['awbs["+idx+"].couponPayment']").value);
                win=window.open("<html:rewrite page="/Prepaid/PrepaidBreakout.do" />?prepaidId="+prepaidId+"&parentTotal="+total+"&parentIndex="+idx,"surcharges","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, width="+w+", height="+h+",left="+leftpos+",top="+toppos);

                window.onfocus="win.focus();";
		        document.onmousedown="win.focus;";
		        document.onkeydown="win.focus;"
        }else{
            alert(valid);
        }
	}

    function toPOA(){
        var valid=validateFreOac(false);

        if(valid==""){
            var form=document.forms['PRPCourierCashRecapForm'];
            form.action.value="toPOA";
            form.pageNumber.value=1;
            form.sortColumn.value="paymentId";
            form.sortDirection.value="asc";
            form.submit();
        }else{
            alert(valid);
        }

    }

    function nextCourier(){
        var form=document.forms['PRPCourierCashRecapForm'];
        if(form.elements['courier'].selectedIndex < form.elements['courier'].length-1){
            form.elements['courier'].selectedIndex++;
            changeCourier();
        }
    }

    function previousCourier(){
        var form=document.forms['PRPCourierCashRecapForm'];
        if(form.elements['courier'].selectedIndex>0){
            form.elements['courier'].selectedIndex--;
            changeCourier();
        }
    }

    function changeCourier(){
        var valid=validateFreOac(false);

        if(valid==""){
            var form=document.forms['PRPCourierCashRecapForm'];
            form.action.value="changeCourier";
            form.pageNumber.value=1;
            form.sortColumn.value="awb_nbr";
            form.sortDirection.value="asc";
            form.submit();
        }else{
            alert(valid);
        }
    }

    function changeTab(currencyCode){
        var valid=validateFreOac(false);
        if(valid==""){
            var form=document.forms['PRPCourierCashRecapForm'];
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
        var form=document.forms['PRPCourierCashRecapForm'];
        var valid=validateFreOac(false);

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
        var form=document.forms['PRPCourierCashRecapForm'];
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
        var form=document.forms['PRPCourierCashRecapForm'];
        var valid=validateFreOac(false);

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
        var valid=validateFreOac(false);
        if(valid==""){
            var form=document.forms['PRPCourierCashRecapForm'];
            form.action.value="toGround";
            form.submit();
        }else{
            alert(valid);
        }
    }

<c:choose>
    <c:when test="${PRPCourierCashRecapForm.dualCurrency ne 'true' or PRPCourierCashRecapForm.currentCurrency ne 'split'}"> <!-- If not Dual currency tab selected -->
            function cashChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="PRPCourierCashRecapForm" property="cashSubTotal"/>);
                while(eval("form.elements['awbs["+index+"].prepaidId']")){
                    if(!isNaN(eval("form.elements['awbs["+index+"].cashPayment']").value)){
                        total=total+Number(eval("form.elements['awbs["+index+"].cashPayment']").value);
                    }
                    index++;
                }

                form.cashTotal.value=format_number(total,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);
                form.grandCashTotal.value=format_number(Number(form.cashTotal.value)+Number(form.oacCashTotal.value),2);
                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);
            }

            function oacCashChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="PRPCourierCashRecapForm" property="oacCashSubTotal"/>);
                while(eval("form.elements['oacs["+index+"].oacId']")){
                    if(!isNaN(eval("form.elements['oacs["+index+"].cashPayment']").value)){
                        total=total+Number(eval("form.elements['oacs["+index+"].cashPayment']").value);
                    }
                    index++;
                }

                form.oacCashTotal.value=format_number(total,2);
                form.oacTotalPayments.value=format_number(Number(form.oacCashTotal.value)+Number(form.oacCheckTotal.value)+Number(form.oacCreditCardTotal.value)+Number(form.oacDepositTotal.value),2);
                form.grandCashTotal.value=format_number(Number(form.cashTotal.value)+Number(form.oacCashTotal.value),2);
                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);
            }



            function couponChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="PRPCourierCashRecapForm" property="couponSubTotal"/>);
                while(eval("form.elements['awbs["+index+"].prepaidId']")){
                    if(!isNaN(eval("form.elements['awbs["+index+"].couponPayment']").value)){
                        total=total+Number(eval("form.elements['awbs["+index+"].couponPayment']").value);
                    }
                    index++;
                }

                form.couponTotal.value=format_number(total,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);

                form.grandCouponTotal.value=format_number(Number(form.couponTotal.value),2);
                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);


            }

            function otherChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var totalCheck=Number(<bean:write name="PRPCourierCashRecapForm" property="checkSubTotal"/>);
                var totalCreditCard=Number(<bean:write name="PRPCourierCashRecapForm" property="creditCardSubTotal"/>);
                var totalDeposit=Number(<bean:write name="PRPCourierCashRecapForm" property="depositSubTotal"/>);

                while(eval("form.elements['awbs["+index+"].prepaidId']")){
                    var pt=eval("form.elements['awbs["+index+"].otherPaymentType']");
                    var ptIndex=pt.selectedIndex;

                    if(!isNaN(eval("form.elements['awbs["+index+"].otherPayment']").value)){
                        switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                            case "1": totalCheck=totalCheck+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
                            case "3": totalCreditCard=totalCreditCard+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
                            case "2": totalDeposit=totalDeposit+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
                        }

                    }
                    index++;
                }
                form.checkTotal.value=format_number(totalCheck,2);
                form.creditCardTotal.value=format_number(totalCreditCard,2);
                form.depositTotal.value=format_number(totalDeposit,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);

                form.grandCheckTotal.value=format_number(Number(form.checkTotal.value)+Number(form.oacCheckTotal.value),2);
                form.grandCreditCardTotal.value=format_number(Number(form.creditCardTotal.value)+Number(form.oacCreditCardTotal.value),2);
                form.grandDepositTotal.value=format_number(Number(form.depositTotal.value)+Number(form.oacDepositTotal.value),2);

                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);

            }

            function oacOtherChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var totalCheck=Number(<bean:write name="PRPCourierCashRecapForm" property="oacCheckSubTotal"/>);
                var totalCreditCard=Number(<bean:write name="PRPCourierCashRecapForm" property="oacCreditCardSubTotal"/>);
                var totalDeposit=Number(<bean:write name="PRPCourierCashRecapForm" property="oacDepositSubTotal"/>);

                while(eval("form.elements['oacs["+index+"].oacId']")){
                    var pt=eval("form.elements['oacs["+index+"].otherPaymentType']");
                    var ptIndex=pt.selectedIndex;

                    if(!isNaN(eval("form.elements['oacs["+index+"].otherPayment']").value)){
                        switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                            case "1": totalCheck=totalCheck+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                            case "3": totalCreditCard=totalCreditCard+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                            case "2": totalDeposit=totalDeposit+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                        }

                    }
                    index++;
                }
                form.oacCheckTotal.value=format_number(totalCheck,2);
                form.oacCreditCardTotal.value=format_number(totalCreditCard,2);
                form.oacDepositTotal.value=format_number(totalDeposit,2);
                form.oacTotalPayments.value=format_number(Number(form.oacCashTotal.value)+Number(form.oacCheckTotal.value)+Number(form.oacCreditCardTotal.value)+Number(form.oacDepositTotal.value),2);

                form.grandCheckTotal.value=format_number(Number(form.checkTotal.value)+Number(form.oacCheckTotal.value),2);
                form.grandCreditCardTotal.value=format_number(Number(form.creditCardTotal.value)+Number(form.oacCreditCardTotal.value),2);
                form.grandDepositTotal.value=format_number(Number(form.depositTotal.value)+Number(form.oacDepositTotal.value),2);

                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);

            }


    </c:when>
    <c:otherwise>

            function cashChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="PRPCourierCashRecapForm" property="cashSubTotal"/>);
                var usdTotal=Number(<bean:write name="PRPCourierCashRecapForm" property="usdCashSubTotal"/>);
                while(eval("form.elements['awbs["+index+"].prepaidId']")){
                    if(!isNaN(eval("form.elements['awbs["+index+"].cashPayment']").value)){
                        if(eval("form.elements['awbs["+index+"].paymentCurrency']").value=="USD"){
                            usdTotal=usdTotal+Number(eval("form.elements['awbs["+index+"].cashPayment']").value);
                        }else{
                            total=total+Number(eval("form.elements['awbs["+index+"].cashPayment']").value);
                        }


                    }
                    index++;
                }

                form.cashTotal.value=format_number(total,2);
                form.usdCashTotal.value=format_number(usdTotal,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);
                form.usdTotalPayments.value=format_number(Number(form.usdCashTotal.value)+Number(form.usdCheckTotal.value)+Number(form.usdCreditCardTotal.value)+Number(form.usdCouponTotal.value)+Number(form.usdDepositTotal.value),2);

                form.grandCashTotal.value=format_number(Number(form.cashTotal.value)+Number(form.oacCashTotal.value),2);
                form.usdGrandCashTotal.value=format_number(Number(form.usdCashTotal.value)+Number(form.usdOacCashTotal.value),2);

                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);
                form.usdGrandTotalPayments.value=format_number(Number(form.usdTotalPayments.value)+Number(form.usdOacTotalPayments.value),2);

            }

            function oacCashChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="PRPCourierCashRecapForm" property="oacCashSubTotal"/>);
                var usdTotal=Number(<bean:write name="PRPCourierCashRecapForm" property="usdOacCashSubTotal"/>);
                while(eval("form.elements['oacs["+index+"].oacId']")){
                    if(!isNaN(eval("form.elements['oacs["+index+"].cashPayment']").value)){
                        if(eval("form.elements['oacs["+index+"].paymentCurrency']").value=="USD"){
                            usdTotal=usdTotal+Number(eval("form.elements['oacs["+index+"].cashPayment']").value);
                        }else{
                            total=total+Number(eval("form.elements['oacs["+index+"].cashPayment']").value);
                        }
                    }
                    index++;
                }

                form.oacCashTotal.value=format_number(total,2);
                form.usdOacCashTotal.value=format_number(usdTotal,2);
                form.oacTotalPayments.value=format_number(Number(form.oacCashTotal.value)+Number(form.oacCheckTotal.value)+Number(form.oacCreditCardTotal.value)+Number(form.oacDepositTotal.value),2);
                form.usdOacTotalPayments.value=format_number(Number(form.usdOacCashTotal.value)+Number(form.usdOacCheckTotal.value)+Number(form.usdOacCreditCardTotal.value)+Number(form.usdOacDepositTotal.value),2);

                form.grandCashTotal.value=format_number(Number(form.cashTotal.value)+Number(form.oacCashTotal.value),2);
                form.usdGrandCashTotal.value=format_number(Number(form.usdCashTotal.value)+Number(form.usdOacCashTotal.value),2);

                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);
                form.usdGrandTotalPayments.value=format_number(Number(form.usdTotalPayments.value)+Number(form.usdOacTotalPayments.value),2);

            }

            function couponChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var total=Number(<bean:write name="PRPCourierCashRecapForm" property="couponSubTotal"/>);
                var usdTotal=Number(<bean:write name="PRPCourierCashRecapForm" property="usdCouponSubTotal"/>);
                while(eval("form.elements['awbs["+index+"].prepaidId']")){
                    if(!isNaN(eval("form.elements['awbs["+index+"].couponPayment']").value)){
                        if(eval("form.elements['awbs["+index+"].paymentCurrency']").value=="USD"){
                            usdTotal=usdTotal+Number(eval("form.elements['awbs["+index+"].couponPayment']").value);
                        }else{
                            total=total+Number(eval("form.elements['awbs["+index+"].couponPayment']").value);
                        }
                    }
                    index++;
                }

                form.couponTotal.value=format_number(total,2);
                form.usdCouponTotal.value=format_number(usdTotal,2);
                form.totalPayments.value=format_number(Number(form.cashTotal.value)+Number(form.checkTotal.value)+Number(form.creditCardTotal.value)+Number(form.couponTotal.value)+Number(form.depositTotal.value),2);
                form.usdTotalPayments.value=format_number(Number(form.usdCashTotal.value)+Number(form.usdCheckTotal.value)+Number(form.usdCreditCardTotal.value)+Number(form.usdCouponTotal.value)+Number(form.usdDepositTotal.value),2);

                form.grandCouponTotal.value=format_number(Number(form.couponTotal.value),2);
                form.usdGrandCouponTotal.value=format_number(Number(form.usdCouponTotal.value),2);

                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);
                form.usdGrandTotalPayments.value=format_number(Number(form.usdTotalPayments.value)+Number(form.usdOacTotalPayments.value),2);

            }

            function otherChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var totalCheck=Number(<bean:write name="PRPCourierCashRecapForm" property="checkSubTotal"/>);
                var totalCreditCard=Number(<bean:write name="PRPCourierCashRecapForm" property="creditCardSubTotal"/>);
                var totalDeposit=Number(<bean:write name="PRPCourierCashRecapForm" property="depositSubTotal"/>);
                var usdTotalCheck=Number(<bean:write name="PRPCourierCashRecapForm" property="usdCheckSubTotal"/>);
                var usdTotalCreditCard=Number(<bean:write name="PRPCourierCashRecapForm" property="usdCreditCardSubTotal"/>);
                var usdTotalDeposit=Number(<bean:write name="PRPCourierCashRecapForm" property="usdDepositSubTotal"/>);

                while(eval("form.elements['awbs["+index+"].prepaidId']")){
                    var pt=eval("form.elements['awbs["+index+"].otherPaymentType']");
                    var ptIndex=pt.selectedIndex;

                    if(!isNaN(eval("form.elements['awbs["+index+"].otherPayment']").value)){
                        if(eval("form.elements['awbs["+index+"].paymentCurrency']").value=="USD"){
                                switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                                    case "1": usdTotalCheck=usdTotalCheck+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
                                    case "3": usdTotalCreditCard=usdTotalCreditCard+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
                                    case "2": usdTotalDeposit=usdTotalDeposit+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
                                }
                        }else{
                                switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                                    case "1": totalCheck=totalCheck+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
                                    case "3": totalCreditCard=totalCreditCard+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
                                    case "2": totalDeposit=totalDeposit+Number(eval("form.elements['awbs["+index+"].otherPayment']").value);break;
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

                form.grandCheckTotal.value=format_number(Number(form.checkTotal.value)+Number(form.oacCheckTotal.value),2);
                form.grandCreditCardTotal.value=format_number(Number(form.creditCardTotal.value)+Number(form.oacCreditCardTotal.value),2);
                form.grandDepositTotal.value=format_number(Number(form.depositTotal.value)+Number(form.oacDepositTotal.value),2);

                form.usdGrandCheckTotal.value=format_number(Number(form.usdCheckTotal.value)+Number(form.usdOacCheckTotal.value),2);
                form.usdGrandCreditCardTotal.value=format_number(Number(form.usdCreditCardTotal.value)+Number(form.usdOacCreditCardTotal.value),2);
                form.usdGrandDepositTotal.value=format_number(Number(form.usdDepositTotal.value)+Number(form.usdOacDepositTotal.value),2);

                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);
                form.usdGrandTotalPayments.value=format_number(Number(form.usdTotalPayments.value)+Number(form.usdOacTotalPayments.value),2);

            }

            function oacOtherChanged(){
                var form=document.forms['PRPCourierCashRecapForm'];
                var index=Number(<bean:write name="offset" />);
                var totalCheck=Number(<bean:write name="PRPCourierCashRecapForm" property="oacCheckSubTotal"/>);
                var totalCreditCard=Number(<bean:write name="PRPCourierCashRecapForm" property="oacCreditCardSubTotal"/>);
                var totalDeposit=Number(<bean:write name="PRPCourierCashRecapForm" property="oacDepositSubTotal"/>);
                var usdTotalCheck=Number(<bean:write name="PRPCourierCashRecapForm" property="usdOacCheckSubTotal"/>);
                var usdTotalCreditCard=Number(<bean:write name="PRPCourierCashRecapForm" property="usdOacCreditCardSubTotal"/>);
                var usdTotalDeposit=Number(<bean:write name="PRPCourierCashRecapForm" property="usdOacDepositSubTotal"/>);


                while(eval("form.elements['oacs["+index+"].oacId']")){
                    var pt=eval("form.elements['oacs["+index+"].otherPaymentType']");
                    var ptIndex=pt.selectedIndex;

                    if(!isNaN(eval("form.elements['oacs["+index+"].otherPayment']").value)){
                        if(eval("form.elements['oacs["+index+"].paymentCurrency']").value=="USD"){
                                switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                                    case "1": usdTotalCheck=usdTotalCheck+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                                    case "3": usdTotalCreditCard=usdTotalCreditCard+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                                    case "2": usdTotalDeposit=usdTotalDeposit+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                                }
                        }else{
                                switch(pymtCtgAssoc[pt.options[ptIndex].value]){
                                    case "1": totalCheck=totalCheck+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                                    case "3": totalCreditCard=totalCreditCard+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                                    case "2": totalDeposit=totalDeposit+Number(eval("form.elements['oacs["+index+"].otherPayment']").value);break;
                                }
                        }

                    }
                    index++;
                }
                form.usdOacCheckTotal.value=format_number(usdTotalCheck,2);
                form.usdOacCreditCardTotal.value=format_number(usdTotalCreditCard,2);
                form.usdOacDepositTotal.value=format_number(usdTotalDeposit,2);

                form.oacCheckTotal.value=format_number(totalCheck,2);
                form.oacCreditCardTotal.value=format_number(totalCreditCard,2);
                form.oacDepositTotal.value=format_number(totalDeposit,2);

                form.oacTotalPayments.value=format_number(Number(form.oacCashTotal.value)+Number(form.oacCheckTotal.value)+Number(form.oacCreditCardTotal.value)+Number(form.oacDepositTotal.value),2);
                form.usdOacTotalPayments.value=format_number(Number(form.usdOacCashTotal.value)+Number(form.usdOacCheckTotal.value)+Number(form.usdOacCreditCardTotal.value)+Number(form.usdOacDepositTotal.value),2);

                form.grandCheckTotal.value=format_number(Number(form.checkTotal.value)+Number(form.oacCheckTotal.value),2);
                form.grandCreditCardTotal.value=format_number(Number(form.creditCardTotal.value)+Number(form.oacCreditCardTotal.value),2);
                form.grandDepositTotal.value=format_number(Number(form.depositTotal.value)+Number(form.oacDepositTotal.value),2);

                form.usdGrandCheckTotal.value=format_number(Number(form.usdCheckTotal.value)+Number(form.usdOacCheckTotal.value),2);
                form.usdGrandCreditCardTotal.value=format_number(Number(form.usdCreditCardTotal.value)+Number(form.usdOacCreditCardTotal.value),2);
                form.usdGrandDepositTotal.value=format_number(Number(form.usdDepositTotal.value)+Number(form.usdOacDepositTotal.value),2);

                form.grandTotalPayments.value=format_number(Number(form.totalPayments.value)+Number(form.oacTotalPayments.value),2);
                form.usdGrandTotalPayments.value=format_number(Number(form.usdTotalPayments.value)+Number(form.usdOacTotalPayments.value),2);

            }

    </c:otherwise>
</c:choose>


    function changePaymentCurr(rowId,newCurr){
        var form=document.forms['PRPCourierCashRecapForm'];
        if(confirm('<bean:message key="app.messages.js.TryToChangeRecPaymentCurrency" />')){
            form.elements['action'].value='ChangePaymentCurr';
            form.elements['newCurr'].value=newCurr;
            if(form.prepaidType.value=='OAC'){
               form.elements['oacId'].value=rowId;
            }else{
                form.elements['prepaidId'].value=rowId;}

            form.submit();
        }
    }

    function updateInformation(){
        var form=document.forms['PRPCourierCashRecapForm'];
        var valid=validateFreOac(false);


            if(valid==""){
                //if(confirm('<bean:message key="app.messages.js.UpdateInformation" />')){
                    form.elements['action'].value='UpdateInformation';
                    form.submit();
                //}
            }else{
                alert(valid);
            }

    }

    function changeStatus(cbo){        
        var form=document.forms['PRPCourierCashRecapForm'];
        var index=findIndex(cbo.name,1);
        var comment="";
        var msg=""
        var status=eval("form.elements['awbs["+index+"].statusId']");

        if(status.options[status.selectedIndex].value==1){
            scanAmount=Number(eval("form.elements['awbs["+index+"].scanAmount']").value);
			cashPayment=eval("form.elements['awbs["+index+"].cashPayment']").value;
			otherPayment=eval("form.elements['awbs["+index+"].otherPayment']").value;
			couponPayment=eval("form.elements['awbs["+index+"].couponPayment']").value;
                        var pt=eval("form.elements['awbs["+index+"].otherPaymentType']");
                        var ptIndex=pt.selectedIndex;
                        otherPaymentType=pymtCtgAssoc[pt.options[ptIndex].value];
			otherDocNumber=eval("form.elements['awbs["+index+"].otherDocNumber']").value;
			comment=eval("form.elements['awbs["+index+"].comment']").value;


			if(isNaN(cashPayment) || isNaN(otherPayment) || isNaN(couponPayment)){
				eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
				alert("<bean:message key="app.messages.js.BadMontos" />");
				return;
			}else{
				cashPayment=Number(cashPayment);
				otherPayment=Number(otherPayment);
                                couponPayment=Number(couponPayment);

                                if(cashPayment<0 || otherPayment<0 ||couponPayment<0){
                                    eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
                                    alert("<bean:message key="app.messages.js.BadMontos" />");
                                    return;
                                }

                                if(Number(cashPayment)==Number(0) && Number(otherPayment)==Number(0) && Number(couponPayment)==Number(0) && comment.length==0){
                                    eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
          			    alert("<bean:message key="app.messages.js.CommentsNotEntered" />");
                                    return;
                                }
			}

            /* Chaca validaciones monto ingresado 12/2007:

                1.- el monto ingresado mayor al monto esperado.
                2.- el monto ingresado no sea la AWB.

            */

            AWB=eval("form.elements['awbs["+index+"].awbNumber']").value;

            if(AWB == cashPayment || AWB == otherPayment || AWB == couponPayment)
            {
                eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
                alert("<bean:message key="app.messages.js.AmountEqualAwb" />");
                return;
            }

            /* --------------- */

            var error=<logic:equal name="PRPCourierCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdUsd" /></logic:equal><logic:notEqual name="PRPCourierCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdLocal" /></logic:notEqual>;

			if(Math.abs(scanAmount-(cashPayment+otherPayment+couponPayment))>error){
				if(comment.length==0){
					eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.CommentsNotEntered" />");
					return;
				}
			}
			if(otherPayment>0 && ptIndex==0){
					eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.MustSelectOtherPaymentType" />");
					return;
			}

			if(otherPayment==0 && ptIndex>0){
					eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.MustEnterOtherPayment" />");
					return;
			}


			if(otherPayment>0 && otherDocNumber.length<1){
					eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.DocNumberNotEntered" />");
					return;
			}

			if(otherPaymentType==3 && otherDocNumber.length>4){
					eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.CreditCardNumberDigits" />");
					return;
			}

        }else{
            	//alert("this is 2");
                if(eval("form.elements['awbs["+index+"].statusId']").selectedIndex==2){
					eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.CannotSetStatusVISA-Inserted" />");
					return;
                }
          		else {
                	//alert("this is in else of 2");
                    var valueBefore = eval("form.elements['awbs["+index+"].statusIdPrev']").value;
                    if(eval("form.elements['awbs["+index+"].statusId']").selectedIndex==3 && valueBefore != 2){
					    eval("form.elements['awbs["+index+"].statusId']").selectedIndex=0;
					    alert("<bean:message key="app.messages.js.CannotSetBillAccountStatus" />");
					    return;
                    }

                    if(status.options[status.selectedIndex].value==3){
                    	//alert("finally 3!!");
                        var w=320;
                        var h=160;
                        if(w>screen.width)w=screen.width;
                        if(h>screen.height)h=screen.height;
                        var leftpos=(screen.width-w) / 2;
                        var toppos=(screen.height-h) / 2;
                        billAccount=eval("form.elements['awbs["+index+"].billAccount']").value;
                        var params = "formName=Prepaid&index="+index+"&billAccount="+billAccount;
						//alert("params=="+params);
						window.open("<html:rewrite page="/pages/BillToAccount.jsp" />?"+params,"BillAccount","scrollbars=no,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
                    }                  
                }
        }

    }

    function checkLine(index){
        var form=document.forms['PRPCourierCashRecapForm'];
        var msg="";
        var status=eval("form.elements['awbs["+index+"].statusId']");

        if(status.options[status.selectedIndex].value==1){

            scanAmount=Number(eval("form.elements['awbs["+index+"].scanAmount']").value);
			cashPayment=eval("form.elements['awbs["+index+"].cashPayment']").value;
			otherPayment=eval("form.elements['awbs["+index+"].otherPayment']").value;
			couponPayment=eval("form.elements['awbs["+index+"].couponPayment']").value;
                        var pt=eval("form.elements['awbs["+index+"].otherPaymentType']");
                        var ptIndex=pt.selectedIndex;
                        otherPaymentType=pymtCtgAssoc[pt.options[ptIndex].value];
			otherDocNumber=eval("form.elements['awbs["+index+"].otherDocNumber']").value;
			comment=eval("form.elements['awbs["+index+"].comment']").value;


			if(isNaN(cashPayment) || isNaN(otherPayment) || isNaN(couponPayment)){
				msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
				return msg;
			}else{
				cashPayment=Number(cashPayment);
				otherPayment=Number(otherPayment);
				couponPayment=Number(couponPayment);

                                if(cashPayment<0 || otherPayment<0 ||couponPayment<0){
                                    msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
                                    return msg;
                                }

                                if(cashPayment==Number(0) && otherPayment==Number(0) && couponPayment==Number(0) && comment.length==0){
          			    msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.js.CommentsNotEntered" />\n";
                                    return msg;
                                }
			}

                        var error=<logic:equal name="PRPCourierCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdUsd" /></logic:equal><logic:notEqual name="PRPCourierCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdLocal" /></logic:notEqual>;

			if(Math.abs(scanAmount-(cashPayment+otherPayment+couponPayment))>error){
				if(comment.length==0){
        				msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.js.CommentsNotEntered" />\n";
					return msg;
				}
			}

			if(otherPayment>0 && ptIndex==0){
      				msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.js.MustSelectOtherPaymentType" />\n";
        			return msg;
			}

			if(otherPayment==0 && ptIndex>0){
      				msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.js.MustEnterOtherPayment" />\n";
        			return msg;
			}

            if(otherPayment>0 && otherDocNumber.length<1){
      				msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.js.DocNumberNotEntered" />\n";
        			return msg;
			}

			if(otherPaymentType==3 && otherDocNumber.length>4){
      				msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.js.CreditCardNumberDigits" />\n";
        			return msg;
			}
        }else if(status.options[status.selectedIndex].value==3){
        	var comment = document.forms['PRPCourierCashRecapForm'].elements['awbs['+index+'].otherComment'].value;
       	    /*var otherComment = document.forms['PRPCourierCashRecapForm'].elements['awbs['+index+'].otherComment'].value;
               if(otherComment.length == 0){
                msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.AddAccountNumber" />\n";
 		        return msg;*/
            	billAcct = document.forms['PRPCourierCashRecapForm'].elements['awbs['+index+'].billAccount'].value;
           		if(billAcct.length == 0){
                	msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="app.messages.AddAccountNumber" />\n";
    			return msg;               
                }
           		if( (billAcct == "999999999") && (comment.length == 0) ){
                	msg=msg+"-AWB "+ eval("form.elements['awbs["+index+"].awbNumber']").value +": <bean:message key="errors.messages.CommentMissing" />\n";
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

        var form=document.forms['PRPCourierCashRecapForm'];
        var msg="";
        var index=Number(<bean:write name="offset" />);
        var some=false;
        var canClose=<bean:write name="PRPCourierCashRecapForm" property="canClose" />;

        while(eval("form.elements['awbs["+index+"].prepaidId']")){
            if(isClosing && (!canClose || eval("form.elements['awbs["+index+"].statusId']").selectedIndex<=0)){
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
    		var form=document.forms['PRPCourierCashRecapForm'];
            var w=400;
            var h=200;
            var index=Number(<bean:write name="offset" />);
            var count=Number(0);
            var empId;

	        while(eval("form.elements['awbs["+index+"].prepaidId']") && count<1){
	            if(eval("form.elements['awbs["+index+"].selected']").checked){
	               count++;
	            }
	            index++;
	        }

	        if(count==0){
	        	alert("<bean:message key="app.messages.MustSelectPaymentReassign"/> ");
	        	return;
	        }

	        var params="summary=false&oldEmployee=<bean:write name="PRPCourierCashRecapForm" property="courier"/>";


            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;

            window.open("<html:rewrite page="/pages/ReassignPayments.jsp" />?"+params,"reassign","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }

    function splitCurrency(){
    		var form=document.forms['PRPCourierCashRecapForm'];
            var w=320;
            var h=180;
            var index=Number(<bean:write name="offset" />);
            var count=Number(0);
            var empId;

	        while(eval("form.elements['awbs["+index+"].prepaidId']")){
	            if(eval("form.elements['awbs["+index+"].selected']").checked){
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

    function splitCurrencyOAC(){
    		var form=document.forms['PRPCourierCashRecapForm'];
            var w=320;
            var h=180;
            var index=Number(<bean:write name="offset" />);
            var count=Number(0);
            var empId;

	        while(eval("form.elements['oacs["+index+"].oacId']")){
	            if(eval("form.elements['oacs["+index+"].selected']").checked){
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


   function addAwbs(){
        var form=document.forms['PRPCourierCashRecapForm'];
        var valid=validate(false);

        if(valid==""){
                form.elements['action'].value='UpdateInformation';
                form.elements['reload'].value='YES';
                var w=750;
                var h=400;
                if(w>screen.width)w=screen.width;
                if(h>screen.height)h=screen.height;
                var leftpos=(screen.width-w) / 2;
                var toppos=(screen.height-h) / 2;
                window.open("<html:rewrite page="/Prepaid/AddPrepaidAwbs.do" />?courierId=<bean:write name="PRPCourierCashRecapForm" property="courier"/>&courierName=<bean:write name="PRPCourierCashRecapForm" property="courierName"/>&currentCurrency=<bean:write name="PRPCourierCashRecapForm" property="currentCurrency"/>", "addAwbsWindow", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
                form.submit();
        }else{
            alert(valid);
        }
    }

	function processScans(){
        var form=document.forms['PRPCourierCashRecapForm'];
        form.elements['action'].value='ProcessScans';
        form.submit();
    }

    function changeReceiptNbr(idx){
        var rcptNbr=eval("document.forms['PRPCourierCashRecapForm'].elements['awbs["+idx+"].rcptNbr']");
        var rcptNbrPrev=eval("document.forms['PRPCourierCashRecapForm'].elements['awbs["+idx+"].rcptNbrPrev']");
		var newRcptNbr=prompt("<bean:message key="app.messages.js.EnterNewReceipt" />",rcptNbr.value);

		while(newRcptNbr!=null && !validRecNbr(newRcptNbr)){
			newRcptNbr=prompt("<bean:message key="app.messages.js.ReEnterNewReceipt" />",rcptNbr.value);
		}

		if(newRcptNbr!=null){
			rcptNbrPrev.value=rcptNbr.value;
			rcptNbr.value=newRcptNbr;
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

	function showScans(awb){
                var w=700;
                var h=500;
                if(w>screen.width)w=screen.width;
                if(h>screen.height)h=screen.height;
                var leftpos=(screen.width-w) / 2;
                var toppos=(screen.height-h) / 2;
                window.open("<html:rewrite page="/Prepaid/PrepaidDetails.do" />?action=showScans&awbNbr="+awb,"showScans","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, width="+w+", height="+h+",left="+leftpos+",top="+toppos);
	}
        /*
    function validateBillAccountComment()
    {
        var form    = document.forms['PRPCourierCashRecapForm'];
        var comment = "";

        var index=0;
        while(eval("form.elements['awbs["+index+"].statusId']")){
            if(eval("form.elements['awbs["+index+"].statusId']").selectedIndex==3){
                comment = document.forms['PRPCourierCashRecapForm'].elements['awbs['+index+'].otherComment'].value;
                if(comment.length == 0){
                    return false;
                }
            }
            index++;
        }
        return true;
     }
          */
     function checkLineOAC(index){
        var form=document.forms['PRPCourierCashRecapForm'];
        var msg="";
        if(eval("form.elements['oacs["+index+"].statusId']").selectedIndex==1){

			cashPayment=eval("form.elements['oacs["+index+"].cashPayment']").value;
			otherPayment=eval("form.elements['oacs["+index+"].otherPayment']").value;
            var pt=eval("form.elements['oacs["+index+"].otherPaymentType']");
            var ptIndex=pt.selectedIndex;
            otherPaymentType=pymtCtgAssoc[pt.options[ptIndex].value];
			otherDocNumber=eval("form.elements['oacs["+index+"].otherDocNumber']").value;
			comment=eval("form.elements['oacs["+index+"].comment']").value;


			if(isNaN(cashPayment) || isNaN(otherPayment)){
				msg=msg+"-OAC Receipt "+ eval("form.elements['oacs["+index+"].rcptNbr']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
				return msg;
			}else{
				cashPayment=Number(cashPayment);
				otherPayment=Number(otherPayment);

                                if(cashPayment<0 || otherPayment<0){
                                   msg=msg+"-OAC Receipt "+ eval("form.elements['oacs["+index+"].rcptNbr']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
                                   return msg;
                                }

                                if(cashPayment==Number(0) && otherPayment==Number(0) && couponPayment==Number(0) && comment.length==0){
          			               msg=msg+"-OAC Receipt "+ eval("form.elements['oacs["+index+"].rcptNbr']").value +": <bean:message key="app.messages.js.CommentsNotEntered" />\n";
                                   return msg;
                                }
			}

			if(otherPayment>0 && ptIndex==0){
      				msg=msg+"-OAC Receipt "+ eval("form.elements['oacs["+index+"].rcptNbr']").value +": <bean:message key="app.messages.js.MustSelectOtherPaymentType" />\n";
        			return msg;
			}

			if(otherPayment==0 && ptIndex>0){
      				msg=msg+"-OAC Receipt "+ eval("form.elements['oacs["+index+"].rcptNbr']").value +": <bean:message key="app.messages.js.MustEnterOtherPayment" />\n";
        			return msg;
			}

			if(otherPayment>0 && otherDocNumber.length<1){
      				msg=msg+"-OAC Receipt "+ eval("form.elements['oacs["+index+"].rcptNbr']").value +": <bean:message key="app.messages.js.DocNumberNotEntered" />\n";
        			return msg;
			}

			if(otherPaymentType==3 && otherDocNumber.length>4){
      				msg=msg+"-OAC Receipt "+ eval("form.elements['oacs["+index+"].rcptNbr']").value +": <bean:message key="app.messages.js.CreditCardNumberDigits" />\n";
        			return msg;
			}
        }
        return msg;
    }

    function changeOacStatus(cbo){
        var form=document.forms['PRPCourierCashRecapForm'];
        var index=findIndex(cbo.name,1);
        var msg=""
        if(eval("form.elements['oacs["+index+"].statusId']").selectedIndex==1){

			cashPayment=eval("form.elements['oacs["+index+"].cashPayment']").value;
			otherPayment=eval("form.elements['oacs["+index+"].otherPayment']").value;

            var pt=eval("form.elements['oacs["+index+"].otherPaymentType']");
            var ptIndex=pt.selectedIndex;
            otherPaymentType=pymtCtgAssoc[pt.options[ptIndex].value];
			otherDocNumber=eval("form.elements['oacs["+index+"].otherDocNumber']").value;
			comment=eval("form.elements['oacs["+index+"].comment']").value;


			if(isNaN(cashPayment) || isNaN(otherPayment)){
				eval("form.elements['oacs["+index+"].statusId']").selectedIndex=0;
				alert("<bean:message key="app.messages.js.BadMontos" />");
				return;
			}else{
				cashPayment=Number(cashPayment);
				otherPayment=Number(otherPayment);

                if(cashPayment<0 || otherPayment<0){
                    eval("form.elements['oacs["+index+"].statusId']").selectedIndex=0;
                    alert("<bean:message key="app.messages.js.BadMontos" />");
                    return;
                }

                if(Number(cashPayment)==Number(0) && Number(otherPayment)==Number(0) && comment.length==0){
                   eval("form.elements['oacs["+index+"].statusId']").selectedIndex=0;
          		   alert("<bean:message key="app.messages.js.CommentsNotEntered" />");
                   return;
               }
			}

			if(otherPayment>0 && ptIndex==0){
					eval("form.elements['oacs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.MustSelectOtherPaymentType" />");
					return;
			}

			if(otherPayment==0 && ptIndex>0){
					eval("form.elements['oacs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.MustEnterOtherPayment" />");
					return;
			}


			if(otherPayment>0 && otherDocNumber.length<1){
					eval("form.elements['oacs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.DocNumberNotEntered" />");
					return;
			}

			if(otherPaymentType==3 && otherDocNumber.length>4){
					eval("form.elements['oacs["+index+"].statusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.CreditCardNumberDigits" />");
					return;
			}

        }
    }

</script>