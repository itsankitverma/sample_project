<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="calendar" %>

<%
    Integer requestID=(Integer)request.getSession().getAttribute("requestID");
    if(requestID==null) requestID = new Integer(-1);
    String elementFocus=null;
    if("deleteDetail".equals(request.getParameter("action")) || "addDetail".equals(request.getParameter("action"))) {
        elementFocus="details[0].poaDetail.invoiceNbr";
    }
    else if (request.getParameter("payment.courierId")==null || "".equals(request.getParameter("payment.courierId"))) {
        elementFocus="payment.courierId";
    }
    else {
        elementFocus="payment.accountNbr";
    }
    EmployeeProfile ep=(EmployeeProfile)session.getAttribute("userProfile");
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));

    DecimalFormat formatter1=new DecimalFormat("###########0.00######");
    formatter1.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>
<script type="text/javascript" src="<html:rewrite page="/scripts/ccs_scripts.js"/>"></script>

<script src="<html:rewrite page="/scripts/calendar.js" />"></script>
<script src="<html:rewrite page="/scripts/calendar-msgs-" /><bean:message key="app.Language" />.js"></script>
<script src="<html:rewrite page="/scripts/calendar-setup.js" />"></script>
<LINK REL ="stylesheet" TYPE="text/css" HREF="<html:rewrite page="/styles/calendar.css" />" TITLE="Style">

<script language="JavaScript" type="text/javascript">
    <bean:size id="paymenTypeCount" name="PoaAddPaymentForm" property="paymentTypes"/>
    var pymtCtgAssoc=new Array(<bean:write name="paymenTypeCount" />);
    <logic:iterate id="elem" name="PoaAddPaymentForm" property="paymentTypes">
        pymtCtgAssoc["<bean:write name="elem" property="paymentTypeId" />"] = "<bean:write name="elem" property="paymentCtgId" />";
    </logic:iterate>

    <bean:size id="banksCount" name="PoaAddPaymentForm" property="countryBanks"/>
    var countryBanksAssoc=new Array(<bean:write name="banksCount" />);
    <logic:iterate id="elem" name="PoaAddPaymentForm" property="countryBanks">
        <logic:present name="elem" property="bankCd" >
            countryBanksAssoc[String(Number("<bean:write name="elem" property="bankCd" />"))] = "<bean:write name="elem" property="bankShtDesc" />";
        </logic:present>
    </logic:iterate>
    <logic:present name="submitParent">
        opener.document.forms[0].submit();
    </logic:present>
    <bean:write name="checkDecodeJS" scope="session" />
	var exchRateMin=Number(<%=ep.getExchRateMin()%>);
	var exchRateMax=Number(<%=ep.getExchRateMax()%>);
    if (opener.document.forms['PoaSummaryForm']) {
        opener.document.forms['PoaSummaryForm'].elements['requestID'].value="<%=requestID%>";
    }

    function findIndex(name,after){
        var from=name.indexOf("[",after)+1;
        var to=name.indexOf("]",after);
        return name.substr(from,to-from);
    }

    function addDetail() {
        var form=document.forms['PoaAddPaymentForm'];
        var msg=validateAddDetail();
        if(msg=="") {
            form.elements['action'].value='addDetail';
            form.submit();
        }
        else {
            alert(msg);
        }
    }

    function changeCurrency() {
        var form=document.forms['PoaAddPaymentForm'];
        form.elements['details[0].poaDetail.invCurrency'].selectedIndex=form.elements['payment.paymentCurrency'].selectedIndex;
        var i=Number(0)
 		eval("form.elements['totalAmount']").value=0;
 		eval("form.elements['totalCoupon']").value=0;
 		eval("form.elements['totalUsd']").value=0;

        while(eval("form.elements['details["+i+"].usdAmount']")) {
	 		if(form.elements['payment.paymentCurrency'].options[form.elements['payment.paymentCurrency'].selectedIndex].value=="USD") {
				eval("form.elements['details["+i+"].poaDetail.amount']").value=format_number(Number(eval("form.elements['details["+i+"].poaDetail.amount']").value)/Number(form.elements('payment.exchRate').value),2);
				eval("form.elements['details["+i+"].poaDetail.couponAmt']").value=format_number(Number(eval("form.elements['details["+i+"].poaDetail.couponAmt']")).value/Number(form.elements('payment.exchRate').value),2);
	 		}
            else {
				eval("form.elements['details["+i+"].poaDetail.amount']").value=format_number(Number(eval("form.elements['details["+i+"].poaDetail.amount']").value)*Number(form.elements('payment.exchRate').value),2);
				eval("form.elements['details["+i+"].poaDetail.couponAmt']").value=format_number(Number(eval("form.elements['details["+i+"].poaDetail.couponAmt']").value)*Number(form.elements('payment.exchRate').value),2);
	 		}
	 		eval("form.elements['totalAmount']").value=Number(eval("form.elements['totalAmount']").value)+Number(eval("form.elements['details["+i+"].poaDetail.amount']").value);
	 		eval("form.elements['totalCoupon']").value=Number(eval("form.elements['totalCoupon']").value)+Number(eval("form.elements['details["+i+"].poaDetail.couponAmt']").value);
	 		eval("form.elements['totalUsd']").value=Number(eval("form.elements['totalUsd']").value)+Number(eval("form.elements['details["+i+"].usdAmount']").value);
	 		i++;
	 	}
        eval("form.elements['totalAmount']").value=format_number(Number(eval("form.elements['totalAmount']").value),2)
        eval("form.elements['totalCoupon']").value=format_number(Number(eval("form.elements['totalCoupon']").value),2);
        eval("form.elements['totalUsd']").value=format_number(Number(eval("form.elements['totalUsd']").value),2);
 	}

	function changeExchRate() {
        var form=document.forms['PoaAddPaymentForm'];
        form.elements['details[0].poaDetail.invCurrency'].selectedIndex=form.elements['payment.paymentCurrency'].selectedIndex;
        var i=Number(0)
 		eval("form.elements['totalAmount']").value=0;
 		eval("form.elements['totalCoupon']").value=0;
 		eval("form.elements['totalUsd']").value=0;

        while(eval("form.elements['details["+i+"].usdAmount']")) {
        	var amt=Number(eval("form.elements['details["+i+"].poaDetail.amount']").value);
        	var coupAmt=Number(eval("form.elements['details["+i+"].poaDetail.couponAmt']").value);
        	var usdAmt=Number(eval("form.elements['details["+i+"].usdAmount']").value);
            if(form.elements['payment.paymentCurrency'].options[form.elements['payment.paymentCurrency'].selectedIndex].value!="USD") {
	 			var prevExchRate=(amt+coupAmt)/usdAmt;
                if(eval("form.elements['details["+i+"].poaDetail.invCurrency']").value=='USD') {
                    eval("form.elements['details["+i+"].poaDetail.amount']").value=format_number((Number(eval("form.elements['details["+i+"].poaDetail.amount']").value)/prevExchRate)*Number(form.elements('payment.exchRate').value),2);
                    eval("form.elements['details["+i+"].poaDetail.couponAmt']").value=format_number((Number(eval("form.elements['details["+i+"].poaDetail.couponAmt']").value)/prevExchRate)*Number(form.elements('payment.exchRate').value),2);
                }
                else {
                    eval("form.elements['details["+i+"].usdAmount']").value=format_number((Number(eval("form.elements['details["+i+"].usdAmount']").value)*prevExchRate)/Number(form.elements('payment.exchRate').value),2);
                }
	 		}
	 		eval("form.elements['totalAmount']").value=Number(eval("form.elements['totalAmount']").value)+Number(eval("form.elements['details["+i+"].poaDetail.amount']").value);
	 		eval("form.elements['totalCoupon']").value=Number(eval("form.elements['totalCoupon']").value)+Number(eval("form.elements['details["+i+"].poaDetail.couponAmt']").value);
	 		eval("form.elements['totalUsd']").value=Number(eval("form.elements['totalUsd']").value)+Number(eval("form.elements['details["+i+"].usdAmount']").value);
	 		i++;
	 	}
        eval("form.elements['totalAmount']").value=format_number(Number(eval("form.elements['totalAmount']").value),2)
        eval("form.elements['totalCoupon']").value=format_number(Number(eval("form.elements['totalCoupon']").value),2);
        eval("form.elements['totalUsd']").value=format_number(Number(eval("form.elements['totalUsd']").value),2);
 	}

    function changeLine(idx) {
	    var form=document.forms['PoaAddPaymentForm'];
		if(form.elements('payment.paymentCurrency').value=="USD") {
			eval("form.elements['details["+idx+"].usdAmount']").value=format_number(Number(eval("form.elements['details["+idx+"].poaDetail.amount']").value)+Number(eval("form.elements['details["+idx+"].poaDetail.couponAmt']").value),2);
	 	}
        else {
	 		eval("form.elements['details["+idx+"].usdAmount']").value=format_number((Number(eval("form.elements['details["+idx+"].poaDetail.amount']").value)+Number(eval("form.elements['details["+idx+"].poaDetail.couponAmt']").value))/Number(form.elements('payment.exchRate').value),2);
	 	}
	 	if(idx>0) {
		 	if(Number(eval("form.elements['details["+idx+"].surChargesTotal']").value==0)) {
			 		eval("window.document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyGray.gif" />";
		 	}
            else {
			 	if(Number(eval("form.elements['details["+idx+"].surChargesTotal']").value)==(Number(eval("form.elements['details["+idx+"].poaDetail.amount']").value)+Number(eval("form.elements['details["+idx+"].poaDetail.couponAmt']").value))) {
			 		eval("window.document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyGreen.gif" />"
			 	}
                else {
			 		eval("window.document.images['surchrgImg"+idx+"']").src="<html:rewrite page="/images/moneyRed.gif" />"
			 	}   
			} 	
		}	
	}
	    
   function viewSurcharges(poaDetailId,invoiceNbr,idx) {
        var form=document.forms['PoaAddPaymentForm'];
        var w=400;
        var h=400;
        if(w > screen.width) w=screen.width;
        if(h > screen.height) h=screen.height;
        var leftpos=(screen.width-w) / 2;
		var toppos=(screen.height-h) / 2;
        var total=Number(eval("form.elements['details["+idx+"].poaDetail.amount']").value)+Number(eval("form.elements['details["+idx+"].poaDetail.couponAmt']").value);
        win=window.open("<html:rewrite page="/Poa/PoaBreakout.do" />?poaDetailId="+poaDetailId+"&parentTotal="+total+"&parentIndex="+idx+"&invoiceNbr="+invoiceNbr+"&requestID="+form.elements['requestID'].value,"surcharges","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, width="+w+", height="+h+",left="+leftpos+",top="+toppos);
        window.onfocus="win.focus();";
		document.onmousedown="win.focus;";
		document.onkeydown="win.focus;"
	}
	
   function find() {
        var form=document.forms['PoaAddPaymentForm'];
        if(form.elements['queryType'].value=="accountNbr"){
			//win=window.open("<html:rewrite page='/Poa/PoaAddPayment.do' />?action=findCustomer&filter=" + form.elements['filter'].value+"&requestID="+form.elements['requestID'].value,"findCustomer","width=400, height=400, left=10,scrollbars=yes,status=yes,location=yes,resizable=yes");  //outside the screen
	        win=window.open("<html:rewrite page='/Poa/PoaAddPayment.do' />?action=findCustomer&filter=" + form.elements['filter'].value+"&requestID="+form.elements['requestID'].value,"findCustomer","width=1, height=1, left=10000");  //outside the screen
        }
        else {
        	form.elements['action'].value='findInvoice';
        	window.name="ParentPoa";
	        var w=700;
	        var h=400;
	        if(w>screen.width)w=screen.width;
	        if(h>screen.height)h=screen.height;
	        var leftpos=(screen.width-w) / 2;
			var toppos=(screen.height-h) / 2;
            win = window.open("","new","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, width="+w+", height="+h+",left="+leftpos+",top="+toppos );
            form.target="new";
			form.submit();
	        window.onfocus="win.focus();";
			document.onmousedown="win.focus;";
			document.onkeydown="win.focus;"
		}
	}

	function findAll() {
        var form=document.forms['PoaAddPaymentForm'];
        form.elements['action'].value='findInvoicesByAccount';
        //form.method='get';
        window.name="ParentPoa";
        var w=700;
        var h=400;
        if(w>screen.width)w=screen.width;
        if(h>screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;
        win=window.open("","new","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, width="+w+", height="+h+",left="+leftpos+",top="+toppos);
        form.target="new";
        form.submit();
        window.onfocus="win.focus();";
        document.onmousedown="win.focus;";
        document.onkeydown="win.focus;"
	}

    function validateAddDetail(){
        var form=document.forms['PoaAddPaymentForm'];
        if(form.elements['details[0].poaDetail.invoiceNbr'].value=="" || form.elements['details[0].poaDetail.invoiceNbr'].value.length!=9 || isNaN(form.elements['details[0].poaDetail.invoiceNbr'].value)){
            return "<bean:message key="app.messages.js.MustEnterInvoiceNumber" />";
        }

        if(isNaN(form.elements['details[0].poaDetail.amount']).value || Number(form.elements['details[0].poaDetail.amount'].value)<0){
            return "<bean:message key="app.messages.js.BadMontos" />";
        }

        if(isNaN(form.elements['details[0].poaDetail.couponAmt'].value) || Number(form.elements['details[0].poaDetail.couponAmt'].value)<0){
            return "<bean:message key="app.messages.js.BadMontos" />";
        }

        if(Number(form.elements['details[0].poaDetail.amount'].value)+Number(form.elements['details[0].poaDetail.couponAmt'].value)<=0){
            return "<bean:message key="app.messages.js.MustEnterAnAmount" />";
        }
        
		var i=Number(1);
       	while(eval("form.elements['details["+i+"].poaDetail.invoiceNbr']")){
       		if(form.elements['details[0].poaDetail.invoiceNbr'].value==eval("form.elements['details["+i+"].poaDetail.invoiceNbr']").value){
	        	return '<bean:message key="app.messages.js.Invoice#" /> '+ form.elements['details[0].poaDetail.invoiceNbr'].value  +' <bean:message key="app.messages.js.DuplicateInvoices" />';
	        }
	        i++;
        }
        return "";
    }

    function closeWindow(){
        if(confirm('<bean:message key="app.messages.js.CloseSave" />')) {
            savePayment();
        }
        else {
            window.close();
        }
    }

    function savePayment() {
        var form=document.forms['PoaAddPaymentForm'];
        var msg=validatePayment();
        if(msg=="") {
            form.elements['action'].value='savePayment';
            form.submit();
        }
        else {
            alert(msg);
        }
    }

    function validatePayment() {
        var form=document.forms['PoaAddPaymentForm'];
        var msg="";
        
        if(form.elements['payment.courierId'].value=="") {
            msg=msg+"-<bean:message key="app.messages.js.CourierRequired" />\n";
        }  

        if(form.elements['payment.accountNbr'].value.replace(/-/g,'').length!=9 || !validaMod11(form.elements['payment.accountNbr'].value)){
            msg=msg+"-<bean:message key="app.messages.js.MustEnterAValidAccountNbr" />\n";
        }

        if(/* form.elements['payment.customerNm'].value == "" || */ form.elements['payment.customerNm'].value.length > 50)
        {
            msg=msg+"-<bean:message key="app.messages.js.CustomerNameTooLong" />.\n";    
        }

        if(form.elements['payment.paymentCurrency'].options[form.elements['payment.paymentCurrency'].selectedIndex].value!="USD"){
     	   if(Number(form.elements['payment.exchRate'].value)<exchRateMin || Number(form.elements['payment.exchRate'].value)>exchRateMax){
         		   msg=msg+"-<bean:message key="app.messages.ExchRateOutRange" />\n";
      	   }                 
      	}   

        var pt=form.elements['payment.paymentType'];
        var ptIndex=form.elements['payment.paymentType'].selectedIndex;
        if(pymtCtgAssoc[pt.options[ptIndex].value]==3 && form.elements['payment.otherDocNbr'].value.length>4) {
            msg=msg+"-<bean:message key="app.messages.js.CreditCardNumberDigits" />\n";
        }

        if(form.elements['payment.paymentType'].selectedIndex==0){
            msg=msg+"-<bean:message key="app.messages.js.MustSelectOtherPaymentType" />\n";
        }

        if(pymtCtgAssoc[pt.options[ptIndex].value]!=5 && form.elements['payment.otherDocNbr'].value.length<1) {
            msg=msg+"-<bean:message key="app.messages.js.DocNumberNotEntered" />\n";
        }

        if(isNaN(form.elements['payment.paymentAmt'].value) || Number(form.elements['payment.paymentAmt'].value)<=0) {
            msg=msg+"-<bean:message key="app.messages.js.BadMontos" />\n";
        }

        if(form.elements['payment.paymentCurrency'].selectedIndex>=0) {
            var error=0;
            var errorUsd=<bean:write name="userProfile" property="errorThresholdUsd" />;
            var errorLocal=<bean:write name="userProfile" property="errorThresholdLocal" />;

            if(form.elements['payment.paymentCurrency'].options[form.elements['payment.paymentCurrency'].selectedIndex].value=="USD") {
               error=errorUsd;
            }
            else {
                error=errorLocal;
            }
            var totalAmt;
            if(form.elements['details[0].poaDetail.invoiceNbr'].value!="" && form.elements['details[0].poaDetail.invoiceNbr'].value.length==9){
                 totalAmt=Number(form.elements['totalAmount'].value)+Number(form.elements['details[0].poaDetail.amount'].value);
            }
            else {
                 totalAmt=Number(form.elements['totalAmount'].value);
            }

			var paymentAmount= Math.abs(Number(form.elements['payment.paymentAmt'].value));

            if(Math.abs(paymentAmount-totalAmt)>error) {
                msg="<bean:message key="app.messages.js.PoaAmountsNotMatch" />";
                return msg;
                <%--if(form.elements['payment.chkinAgentComment'].value.length==0) {
                   msg=msg+"<!--bean:message key="app.messages.js.CommentsNotEntered" />\n";
                } --%>
            }
        }

        if(totalAmt<=0) {
            msg=msg+"-<bean:message key="app.messages.js.MustEnterAtLeastOneInvoice" />\n";
        }

        if(form.elements['details[0].poaDetail.invoiceNbr'].value!="") {
            if(form.elements['details[0].poaDetail.invoiceNbr'].value.length!=9) {
                msg=msg+"-<bean:message key="app.messages.js.MustEnterInvoiceNumber" />";
            }
            if(isNaN(form.elements['details[0].poaDetail.amount']).value || Number(form.elements['details[0].poaDetail.amount'].value)<0) {
                msg=msg+"-<bean:message key="app.messages.js.PoaDetailBadMontos" />";
            }
            if(isNaN(form.elements['details[0].poaDetail.couponAmt'].value) || Number(form.elements['details[0].poaDetail.couponAmt'].value)<0) {
                msg=msg+"-<bean:message key="app.messages.js.PoaDetailBadMontos" />";
            }
            if(Number(form.elements['details[0].poaDetail.amount'].value)+Number(form.elements['details[0].poaDetail.couponAmt'].value)<=0) {
                msg=msg+"-<bean:message key="app.messages.js.PoaDetailBadMontos" />";
            }
        }
        if(msg!="") {
             return "-<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;
        }
        else {
             return "";
        }
    }

    function deleteDetail(idx) {
        var form=document.forms['PoaAddPaymentForm'];
        form.elements['action'].value='deleteDetail';
        form.elements['delIndex'].value=idx;
        form.submit();
    }

    function changeAmounts(obj) {
    	var idx;
    	if(obj==-1) idx=obj;
    	else idx=findIndex(obj.name,1);
        var form=document.forms['PoaAddPaymentForm'];
        var totalAmt,totalCoupon,totalUsd;
        if(idx>=0) changeLine(idx);

        if(idx>0) {
        	var i=Number(1);
        	totalAmt=Number(0);
        	totalCoupon=Number(0);
        	totalUsd=Number(0);
	       	while(eval("form.elements['details["+i+"].poaDetail.invoiceNbr']")){
	       		totalAmt=totalAmt+Number(eval("form.elements['details["+i+"].poaDetail.amount']").value);
	       		totalCoupon=totalCoupon+Number(eval("form.elements['details["+i+"].poaDetail.couponAmt']").value);
	       		totalUsd=totalUsd+Number(eval("form.elements['details["+i+"].usdAmount']").value);
 		        i++;
	        }

	        form.elements['totalAmount'].value=format_number(totalAmt,2);
    	    form.elements['totalCoupon'].value=format_number(totalCoupon,2);
    	    form.elements['totalUsd'].value=format_number(totalUsd,2);
	    }
        else {
	        totalAmt=Number(form.elements['totalAmount'].value);
    	    totalCoupon=Number(form.elements['totalCoupon'].value);
    	    totalUsd=Number(form.elements['totalUsd'].value);
	    }

        var payment=Number(form.elements['payment.paymentAmt'].value);
        var totalAmount=totalAmt+totalCoupon;
        var amt=Number(form.elements['details[0].poaDetail.amount'].value)+Number(form.elements['details[0].poaDetail.couponAmt'].value);
        if(isNaN(payment)) payment=Number(0);
        if(isNaN(totalAmount)) totalAmount=Number(0);
        if(isNaN(amt)) amt=Number(0);

        var remainingAmount=Number(payment)-(Number(amt)+Number(totalAmount));
        if(Number(remainingAmount)<0) {
                form.elements['remainingAmount'].value=0.00
        }
        else {
                form.elements['remainingAmount'].value=format_number(remainingAmount,2);
        }
    }

    function docNbrKey(e,obj) {
        var whichCode = (window.Event) ? e.which : e.keyCode;
        if(whichCode==13){
            obj.blur();
        }
    }

    function handlePress(e,obj) {
        var whichCode = (window.Event) ? e.which : e.keyCode;
        if(whichCode==13){
            obj.focus();
        }
    }

    function handlePressLink(e,name) {
        var whichCode = (window.Event) ? e.which : e.keyCode;
        if(whichCode==13) {
            for(i=0;i<document.links.length;i++) {
                if(document.links[i].name==name) {
                    document.links[i].focus();
                    break;
                }
            }
        }
    }

	function updateField(codeVal, index, otherComment) {
		if(codeVal.length > 0) {
            document.forms['PoaAddPaymentForm'].elements['imgComment'].src='<html:rewrite page="/images/hasComment.gif"/>';
            document.forms['PoaAddPaymentForm'].elements['imgComment'].alt=codeVal;
		}
        else {
            document.forms['PoaAddPaymentForm'].elements['imgComment'].src='<html:rewrite page="/images/hasNoComment.gif"/>';
            document.forms['PoaAddPaymentForm'].elements['imgComment'].alt="<bean:message key="app.messages.js.ViewAddComment"/>";
        }
		document.forms['PoaAddPaymentForm'].elements['payment.otherComment'].value=otherComment;
		if(otherComment.length>0) {
            if(codeVal.length == 0) {
                document.forms['PoaAddPaymentForm'].elements['imgComment'].src='<html:rewrite page="/images/hasComment.gif"/>';
                document.forms['PoaAddPaymentForm'].elements['imgComment'].alt="";
            }
        }
        else {
            if(codeVal.length == 0) {
                document.forms['PoaAddPaymentForm'].elements['imgComment'].src='<html:rewrite page="/images/hasNoComment.gif"/>';
                document.forms['PoaAddPaymentForm'].elements['imgComment'].alt="<bean:message key="app.messages.js.ViewAddComment"/>";
            }
        }
		document.forms['PoaAddPaymentForm'].elements['payment.chkinAgentComment'].value=codeVal;	 
    }
   
    function changeReceiptNbr(idx) {
        var rcptNbr=eval("document.forms['PoaAddPaymentForm'].elements['payment.rcptNbr']");		
        var rcptNbrPrev=eval("document.forms['PoaAddPaymentForm'].elements['rcptNbrPrev']");		
		var newRcptNbr=prompt("<bean:message key="app.messages.js.EnterNewReceipt" />",rcptNbr.value);
		
		while(newRcptNbr!=null && !validRecNbr(newRcptNbr)) {
            newRcptNbr=prompt("<bean:message key="app.messages.js.ReEnterNewReceipt" />",rcptNbr.value);
        }

		if(newRcptNbr!=null) {
			rcptNbrPrev.value=rcptNbr.value;
			rcptNbr.value=newRcptNbr;
		}
    }

	function validRecNbr(newRcptNbr) {
		if(newRcptNbr=="" || newRcptNbr.length>20){
			return false;
		}
        else {
	    	var re=/^[a-zA-Z0-9/-\\]+$/;
	    	return re.test(newRcptNbr);
	    }
	}

	function checkRcptNbr(obj) {
        if(obj.value!=null && obj.value!="" && !validRecNbr(obj.value)) {
            obj.focus();
            alert("<bean:message key="app.messages.js.ReEnterNewReceipt" />");
        }
	}



 function prepareAmount(obj){
        obj.value=format_number(obj.value,2);
    }

</script>
<%-- Include comments functionality --%>
<jsp:include page="../Comments.jsp" flush="true" />
<html:errors />
<nested:form action="/Poa/PoaAddPayment.do" focus="<%=elementFocus%>" >
    <bean:define id="frm" name="PoaAddPaymentForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.PoaAddPaymentForm" />
    <input type="hidden" name="requestID" value="<%=requestID%>" >
    <nested:hidden property="payment.poaPaymentsId" />
    <nested:hidden property="rcptNbrPrev" />
    <nested:hidden property="payment.coupPymtAmt" />
    <nested:hidden property="payment.chkinAgentComment"/>
    <nested:hidden property="payment.otherComment"/>
    <nested:equal property="fixedCourier" value="yes">
        <nested:hidden property="payment.courierId" />
    </nested:equal>
    <input type="hidden" name="action" value="">
    <input type="hidden" name="delIndex" value="">
    <table width="100%" border="0">
        <tr>
            <td align="center">
                <table border="0" width="100%" cellspacing="0" cellpadding="0" align="center" bgcolor="#808080">
                    <tr>
                        <td bgcolor="#FFFF9C" align="center">
                            <b><font face="Arial" size="2">
                            <bean:message key="app.messages.PaymentReception" />
                            <nested:equal property="fixedCourier" value="yes">
                                <nested:write property="payment.courierId" />
                            </nested:equal>
                            <nested:notEqual property="fixedCourier" value="yes">
                                <nested:text property="payment.courierId" size="8" maxlength="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt"/>
                            </nested:notEqual>
                            </font></b>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#FFFF9C" align="center">
                            <table width="415" cellspacing="1" cellpadding="0" bgcolor="#000000">
                                <tr>
                                    <td colspan="3" bgcolor="#73148C" align="center" height="25">
                                        <font face="Arial" size="1" color="#FFFFFF"><b>
                                            <bean:message key="app.messages.Payment"/>
                                        </b></font>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="25" width="65" bgcolor="#73148C">
                                        <font face="Arial" size="1" color="#FFFFFF"><b>
                                            <bean:message key="app.messages.FindBy" />
                                        </b></font>
                                    </td>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1" color="#FFFFFF">
                                            <select name="queryType" style="font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt">
                                                <option value="accountNbr"><bean:message key="app.messages.Account#"/></option>
                                                <option value="invoiceNbr"><bean:message key="app.messages.Invoice#"/></option>
                                            </select>
                                        </font>
                                    </td>
                                    <td height="25" width="200" bgcolor="#FFFFFF" align="left">
                                        <font face="Arial" size="1">
                                            <input type="text" name="filter" size="12" style="font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8 pt">
                                            <a href="javascript:find();"><html:img page="/images/find.gif" border="0"/></a><html:img page="/images/blank.gif" border="0" imageName="notFound"/>
                                        </font>&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td rowspan="2" height="50" width="65" bgcolor="#73148C">
                                        <font face="Arial" size="1" color="#FFFFFF">
                                            <b><bean:message key="app.messages.Customer"/></b>
                                        </font>
                                    </td>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1">
                                            <bean:message key="app.messages.FedExAccount"/>
                                        </font>
                                    </td>
                                    <td height="25" width="200" bgcolor="#FFFFFF" align="left">
                                        <font face="Arial" size="1">
                                            <nested:text property="payment.accountNbr" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" size="12" />
                                        </font>&nbsp;&nbsp;
                                        <a href="javascript:findAll();"><html:img page="/images/bill.gif" border="0"/></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1">
                                            <bean:message key="app.messages.Name"/>
                                        </font>
                                    </td>
                                    <td height="25" width="200" align="left" bgcolor="#FFFFFF">
                                        <font face="Arial" size="1">
                                            <nested:text property="payment.customerNm" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" />
                                        </font>
                                    </td>
                                </tr>
                                <tr>
                                    <td rowspan="8" bgcolor="#73148C" height="125" width="65">
                                        <font face="Arial" size="1" color="#FFFFFF"><b>
                                            <bean:message key="app.messages.Detail" />
                                        </b></font>
                                    </td>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1"><bean:message key="app.messages.Currency" /></font>
                                    </td>
                                    <td height="25" width="200" align="left" bgcolor="#FFFFFF">

                                            <nested:select property="payment.paymentCurrency" style="font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt" onchange="changeCurrency();">
                                                <html:optionsCollection name="userProfile" property="supportedCurrencies" label="currencyCode" value="currencyCode"/>
                                            </nested:select>
                                        
                                        <font face="Arial" size="1">E.Rate($/USD)</font>
                                        <input type="text" name="payment.exchRate" size="5" onchange="changeExchRate()" value="<%=(frm.getPayment().getExchRate()==0?"1.00":formatter1.format(frm.getPayment().getExchRate()))%>" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt">
                                    </td>
                                </tr>
                                <tr>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1"><bean:message key="app.messages.Type" /></font>
                                    </td>
                                    <td height="25" width="200" align="left" bgcolor="#FFFFFF">
                                        <nested:select property="payment.paymentType" style="font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt">
                                            <option value="">Select</option>
                                            <html:optionsCollection name="PoaAddPaymentForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"/>
                                        </nested:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1"><bean:message key="app.messages.Number" /></font>
                                    </td>
                                    <td height="25" width="200" align="left" bgcolor="#FFFFFF">
                                        <font face="Arial" size="1">
                                            <nested:text property="payment.otherDocNbr" style="font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" />
                                        </font>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1"><bean:message key="app.messages.CustomerBankName" /></font>
                                    </td>
                                    <td height="25" width="200" align="left" bgcolor="#FFFFFF">
	                                    	<font face="Arial" size="1">
	                                            <nested:text property="payment.bankName" style="font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" />
	                                        </font>
	                                    	
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1"><bean:message key="app.messages.ChequeDt" /></font>
                                    </td>
                                    <td height="25" width="200" align="left" bgcolor="#FFFFFF">&nbsp;
                                    	<%String iconUrl=request.getContextPath()+"/images/cal.gif";%>
                                    	<calendar:calendar property="payment.chequeDt" srcIcon="<%=iconUrl%>" format="%m/%d/%Y"   /> <font face="Arial" size="1">(MM/DD/YYYY)</font>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1"><bean:message key="app.messages.ChequeOrigin" /></font>
                                    </td>
                                    <td height="25" width="200" align="left" bgcolor="#FFFFFF">
                                        <font face="Arial" size="1">
                                            <nested:text property="payment.chequeOrigin" style="font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" />
                                        </font>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td height="25" width="150" bgcolor="#C0C0C0">
                                        <font face="Arial" size="1">
                                            <bean:message key="app.messages.Amount"/>
                                        </font>
                                    </td>
                                    <td height="25" width="200" align="left" bgcolor="#FFFFFF">
                                        <font face="Arial" size="1">
                                            <nested:text property="payment.paymentAmt" size="12" onchange="changeAmounts(-1);prepareAmount(this)" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" value="<%=formatter.format(frm.getPayment().getPaymentAmt())%>"/>
                                        </font>
                                    </td>
                                </tr>
                                <tr>
                                <td height="25" width="150" bgcolor="#C0C0C0">
                                    <font face="Arial" size="1"><bean:message key="app.messages.ReceiptNbr" /></font>
                                </td>
                                <td height="25" width="200" align="left" bgcolor="#FFFFFF">
                                    <font face="Arial" size="1">
                                        <nested:notEmpty property="payment.rcptNbr">
                                            <a href="javascript:changeReceiptNbr()">
                                                <html:img page="/images/change.gif" border="0"/>
                                            </a>
                                            <nested:text property="payment.rcptNbr" maxlength="20" onfocus="blur()" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt;border:0;"/>
                                        </nested:notEmpty>
                                        <nested:empty property="payment.rcptNbr">
                                            <nested:text property="payment.rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt;"/>
                                        </nested:empty>
                                    </font>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" bgcolor="#73148C" height="25" width="215">
                                    <font face="Arial" size="1" color="#FFFFFF">
                                        <bean:message key="app.messages.Comments" />
                                    </font>
                                </td>
                                <td height="25" width="200" align="center" bgcolor="#FFFFFF">
                                    <%-- Pone la figura para indicar si tiene o no comentarios --%>
                                    <a href="javascript:showCommentsWindow('','payment','PoaAddPaymentForm','chkinAgentComment','otherComment','');">
                                        <logic:notEmpty name="frm" property="payment.chkinAgentComment">
                                            <%--<IMG border="0" name="imgComment" src="<html:rewrite page="/images/hasComment.gif"/>" alt="<bean:write name="frm" property="payment.chkinAgentComment"/>">--%>
                                            <html:img border="0" imageName="imgComment" page="/images/hasComment.gif" alt="${frm.payment.chkinAgentComment}"/>
                                        </logic:notEmpty>
                                        <logic:empty name="frm" property="payment.chkinAgentComment">
                                            <%if (frm.getPayment().getOtherComment() != null && frm.getPayment().getOtherComment().length()>0){%>
                                                <html:img border="0" imageName="imgComment" page="/images/hasComment.gif"/>
                                            <%}else{%>
                                                <%--<IMG border="0" name="imgComment" src="<html:rewrite page="/images/hasNoComment.gif"/>" alt="<bean:message key="app.messages.ViewAddComment"/>">--%>
                                                <html:img border="0" imageName="imgComment" page="/images/hasNoComment.gif" altKey="app.messages.ViewAddComment"/>
                                            <%}%>
                                        </logic:empty>
                                    </a>
                                </td>
                            </tr>
                        </table>
                        <hr>
                        <table border="0" width="415" bgcolor="#000000" cellspacing="1" cellpadding="0">
                            <tr>
                                <td width="80%" colspan="4" height="14" bgcolor="#73148C" align="center">
                                    <font face="Arial" size="1" color="#FFFFFF"><b>
                                        <bean:message key="app.messages.InvoicesReceivingPayment" />&nbsp;&nbsp;&nbsp;&nbsp;
                                    </b></font>
                                    <input type="text" onfocus="this.blur();" name="remainingAmount" size="12" value="<nested:write property="remainingAmount" format="############0.00" />" style="color:#ffffff;text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt;background-color:#73148C">
                                </td>
                                <td width="20%" rowspan="2" height="32" bgcolor="#73148C" align="center">
                                    <font face="Arial" size="1" color="#FFFFFF">
                                        <b><bean:message key="app.messages.Action" /></b>
                                    </font>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.Number" /></b></font></td>
                                <td width="20%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.Amount" /></b></font></td>
                                <td width="20%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.Coupon" /></b></font></td>
                                <td width="20%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.USDAmount" /></b></font></td>
                            </tr>
                            <nested:iterate property="details" id="detail" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.PoaDetailSurchargesVO">
                                <nested:hidden property="poaDetail.poaDetailId" />
                                <nested:hidden property="surChargesTotal" />
                                <nested:hidden property="poaDetail.invCurrency" />
                                <nested:equal name="idx" value="0">
                                    <tr>
                                        <td width="20%" height="25" bgcolor="#FFFF9C" align="center">
                                            <font face="Arial" size="1">
                                                <nested:text property="poaDetail.invoiceNbr" onkeypress="handlePress(event,document.forms['PoaAddPaymentForm'].elements['details[0].poaDetail.amount'])" size="9" value="" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt"/>
                                            </font>
                                        </td>
                                        <td width="20%" height="25" bgcolor="#FFFF9C" align="center">
                                            <font face="Arial" size="1">
                                          <nested:text property="poaDetail.amount" onchange="changeAmounts(this);prepareAmount(this)"  onkeypress="handlePress(event,document.forms['PoaAddPaymentForm'].elements['details[0].poaDetail.couponAmt'])" size="10" style="text-align:right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" value="" />
                                            </font>
                                        </td>
                                        <td width="20%" height="25" bgcolor="#FFFF9C" align="center">
                                            <font face="Arial" size="1">
                                                <nested:text property="poaDetail.couponAmt" onchange="changeAmounts(this);prepareAmount(this)" onkeypress="handlePressLink(event,'addInvoiceLink')" size="10" style="text-align:right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" value="" />
                                            </font>
                                        </td>
                                        <td width="20%" height="25" bgcolor="#FFFF9C" align="center">
                                            <font face="Arial" size="1">
                                                <nested:text property="usdAmount" onfocus="blur();" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt;background-color:#FFFF9C" value=""/>
                                            </font>
                                        </td>
                                        <%--td width="25%" height="23" bgcolor="#FFFF9C"><font face="Arial" size="1">
                                        <nested:select property="poaDetail.invCurrency" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" >
                                        <html:optionsCollection name="userProfile" property="supportedCurrencies" label="currencyCode" value="currencyCode" />
                                        </nested:select>
                                        </font></td--%>
                                        <td width="20%" height="25" bgcolor="#FFFF9C">
                                            <a name="addInvoiceLink" href="javascript:addDetail();"><img name="addInvoiceImg" border="0" src="<html:rewrite page="/images/Add" /><bean:message key="app.Language" />.gif" ></a>
                                        </td>
                                    </tr>
                                </nested:equal>
                                <nested:notEqual name="idx" value="0">
                                    <%
                                        String surchrgImg=null;                                                                                                
                                        if(detail.getSurChargesTotal()==0) {
                                            surchrgImg="/images/moneyGray.gif";
                                        }
                                        else if(detail.getSurChargesTotal()==(detail.getPoaDetail().getAmount()+detail.getPoaDetail().getCouponAmt())) {
                                            surchrgImg="/images/moneyGreen.gif";
                                        }
                                        else {
                                            surchrgImg="/images/moneyRed.gif";
                                        }
                                    %>
                                    <tr>
                                        <td width="20%" height="25" bgcolor="#FFFF9C" align="right">
                                            <font face="Arial" size="1">
                                                <nested:write property="poaDetail.invoiceNbr"/>
                                                <nested:hidden property="poaDetail.invoiceNbr"/>
                                            </font>
                                        </td>
                                        <td width="20%" height="25" bgcolor="#FFFF9C">
                                            <font face="Arial" size="1">
                                                <nested:text property="poaDetail.amount" onchange="changeAmounts(this);prepareAmount(this)" value="<%=formatter.format(detail.getPoaDetail().getAmount())%>" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt"/>
                                            </font>
                                        </td>
                                        <td width="20%" height="25" bgcolor="#FFFF9C">
                                            <font face="Arial" size="1">
                                                <nested:text property="poaDetail.couponAmt" onchange="changeAmounts(this);prepareAmount(this)" value="<%=formatter.format(detail.getPoaDetail().getCouponAmt())%>" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt"/>
                                            </font>
                                        </td>
                                        <td width="20%" height="25" bgcolor="#FFFF9C">
                                            <font face="Arial" size="1">
                                                <nested:text property="usdAmount" onfocus="blur();" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt;background-color:#FFFF9C" value="<%=formatter.format(detail.getUsdAmount())%>"/>
                                            </font>
                                        </td>
                                        <%--td width="25%" align="center" height="23" bgcolor="#FFFF9C"><font face="Arial" size="1"><b><nested:write property="poaDetail.invCurrency" /></font></td--%>
                                        <td width="20%" height="25" bgcolor="#FFFF9C">
                                            <a href="javascript:deleteDetail(<%=idx%>)">
                                                <font face="Arial" size="1"><html:img border="0" page="/images/trash.gif"/></font>
                                            </a>
                                            <a href="javascript:viewSurcharges(<nested:write property="poaDetail.poaDetailId" />,'<nested:write property="poaDetail.invoiceNbr" />',<%=idx%>)">
                                                <IMG name="surchrgImg<%=idx%>" border="0" src="<html:rewrite page="<%=surchrgImg%>"/>">
                                            </a>
                                        </td>
                                    </tr>
                                </nested:notEqual>
                            </nested:iterate>
                            <tr>
                                <td width="20%" height="25" bgcolor="#FFFF9C" align="center">
                                    <font face="Arial" size="1"><b>Total</b></font>
                                </td>
                                <td width="20%" height="25" bgcolor="#FFFF9C">
                                    <font face="Arial" size="1">
                                        <nested:text property="totalAmount" onfocus="blur();" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt;background-color:#FFFF9C" value="<%=formatter.format(frm.getTotalAmount())%>"/>
                                    </font>
                                </td>
                                <td width="20%" height="25" bgcolor="#FFFF9C">
                                    <font face="Arial" size="1">
                                        <nested:text property="totalCoupon" onfocus="blur();" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt;background-color:#FFFF9C" value="<%=formatter.format(frm.getTotalCoupon())%>"/>
                                    </font>
                                </td>
                                <td width="20%" height="25" bgcolor="#FFFF9C">
                                    <font face="Arial" size="1">
                                        <nested:text property="totalUsd" onfocus="blur();" size="10" style="text-align:right;font-family:Verdana,Arial,Helvetica,sans-serif;font-size:8pt;background-color:#FFFF9C" value="<%=formatter.format(frm.getTotalUsd())%>"/>
                                    </font>
                                </td>
                                <td width="20%" height="25" bgcolor="#FFFF9C">&nbsp;</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFF9C" align="center">
                        <html:link href="javascript:savePayment();">
                            <img align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link><html:link href="javascript:closeWindow();" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38">
                        </html:link>
                    </td>
                </tr>
            </table>
            <br>
        </td>
    </tr>
</table>
</nested:form>