<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<script type="text/javascript">
    function resetPagination() {
        var form=document.forms['FTCCourierCashRecapForm'];
        form.pageNumber.value = 1;
        form.sortColumn.value="";
        form.sortDirection.value="";
    }

    function changeTab(currencyCode){
            var valid=validate(false);
            if(valid==""){
                var form=document.forms['FTCCourierCashRecapForm'];

                form.elements['previousCurrencyCode'].value=form.elements['currentCurrency'].value;
                form.elements['currentCurrency'].value=currencyCode;
                form.elements['newCurr'].value=currencyCode;
                form.submit();
            }else{
                alert(valid);
            }
    }

    function nextCourier(){
        var form=document.forms['FTCCourierCashRecapForm'];
        if(form.elements['courier'].selectedIndex < form.elements['courier'].length-1){
            form.elements['courier'].selectedIndex++;
            changeCourier();
        }


    }

    function previousCourier(){
        var form=document.forms['FTCCourierCashRecapForm'];
        if(form.elements['courier'].selectedIndex>0){
            form.elements['courier'].selectedIndex--;
            changeCourier();
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


    function processScans(){
        var form=document.forms['FTCCourierCashRecapForm'];
        form.elements['action'].value='ProcessScans';
        form.submit();
    }

    function docNbrKey(e,obj) {
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            obj.blur();
      }
    }

    function closeEmployee(){
        var form=document.forms['FTCCourierCashRecapForm'];
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

    function updateInformation(){
        var form=document.forms['FTCCourierCashRecapForm'];
        var valid=validate(false);

            if(valid==""){
                //if(confirm('<bean:message key="app.messages.js.UpdateInformation" />')){
                    form.elements['action'].value='UpdateInformation';
                    form.submit();
                //}
            }else{
                alert(valid);
            }
    }

    function showPage(page){
        var form=document.forms['FTCCourierCashRecapForm'];
        var valid=validate(false);

        if(valid==""){
                form.elements['action'].value='showPage';
                form.elements['pageNumber'].value=page;
                form.submit();
        }else{
            alert(valid);
        }
    }

    function sortTable(column,direction){
        var form=document.forms['FTCCourierCashRecapForm'];
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

    function changeRecPaymentCurr(recId,newCurr){
        var form=document.forms['FTCCourierCashRecapForm'];
        if(confirm('<bean:message key="app.messages.js.TryToChangeRecPaymentCurrency" />')){
            form.elements['action'].value='ChangeRecPaymentCurr';
            form.elements['recId'].value=recId;
             form.elements['previousCurrencyCode'].value=form.elements['currentCurrency'].value;
             form.elements['currentCurrency'].value=form.elements['currentCurrency'].value;
            form.elements['newCurr'].value=newCurr;

            form.submit();
        }
    }
    function changeRecCurr(recId,newCurr){
        var form=document.forms['FTCCourierCashRecapForm'];
        if(confirm('<bean:message key="app.messages.js.TryToChangeRecCurrency" />')){
            form.elements['action'].value='ChangeRecCurr';
            form.elements['recId'].value=recId;
            form.elements['newCurr'].value=newCurr;
             form.elements['previousCurrencyCode'].value=form.elements['currentCurrency'].value;
             form.elements['currentCurrency'].value=form.elements['currentCurrency'].value;
            form.submit();
        }
    }

    function changeStatus(cbo){
        var form=document.forms['FTCCourierCashRecapForm'];
        var index=findIndex(cbo.name,1);
        var msg=""

        var status=eval("form.elements['receivables["+index+"].recStatusId']");
        if(status.options[status.selectedIndex].value==1){
			recAmount=Number(eval("form.elements['receivables["+index+"].recAmount']").value);
			recDex16Amount=Number(eval("form.elements['receivables["+index+"].recDex16Amount']").value);
			recCashPayment=eval("form.elements['receivables["+index+"].recCashPayment']").value;
			recOtherPayment=eval("form.elements['receivables["+index+"].recOtherPayment']").value;
			recOtherDocNumber=eval("form.elements['receivables["+index+"].recOtherDocNumber']").value;
                        var pt=eval("form.elements['receivables["+index+"].otherPaymentType']");
                        var ptIndex=pt.selectedIndex;
                        otherPaymentType=pymtCtgAssoc[pt.options[ptIndex].value];
			recComment=eval("form.elements['receivables["+index+"].recComment']").value;


            if(isNaN(recCashPayment) || isNaN(recOtherPayment)){
				eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=0;
				alert("<bean:message key="app.messages.js.BadMontos" />");
				return;
			}else{
				recCashPayment=Number(recCashPayment);
				recOtherPayment=Number(recOtherPayment);
                
                                if(recCashPayment<0 || recOtherPayment<0){
                                    eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=0;
                                    alert("<bean:message key="app.messages.js.BadMontos" />");
                                    return;
                                }
			}

            /* Chaca validaciones monto ingresado 12/2007:

                1.- el monto ingresado mayor al monto esperado.
                2.- el monto ingresado no sea la AWB.

            */

            AWB=eval("form.elements['receivables["+index+"].recAwbNumber']").value;

            if(AWB == recCashPayment || AWB == recOtherPayment || AWB == recAmount)
            {
                eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=0;
                alert("<bean:message key="app.messages.js.AmountEqualAwb" />");
                return;
            }

            var nTimes = <bean:write name="FTCCourierCashRecapForm" property="paramNTimes" />;

            
            //defect_177890
            if((recCashPayment + recOtherPayment) / nTimes >= recAmount)
            //if((recCashPayment + recOtherPayment) / nTimes >= recAmount || (recAmount > 0 && recCashPayment + recOtherPayment == 0))
            {
                alert("<bean:message key="app.messages.js.HigherThanExpected" />");
            }

            /* --------------- */


            var error=<logic:equal name="FTCCourierCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdUsd" /></logic:equal><logic:notEqual name="FTCCourierCashRecapForm" property="currentCurrency" value="USD"><bean:write name="userProfile" property="errorThresholdLocal" /></logic:notEqual>;

            if(Math.abs(recAmount-recDex16Amount)>error||
                           Math.abs(recAmount-(recCashPayment+recOtherPayment))>error){
					//check type of comment
					  if(recComment.length==0){
	 					 eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=0;
	 					 alert("<bean:message key="app.messages.js.CommentsNotEntered" />");
					return;
				}
			}

			if(recOtherPayment>0 && ptIndex==0){
					eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.MustSelectOtherPaymentType" />");
					return;
			}

			if(recOtherPayment==0 && ptIndex>0){
					eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.MustEnterOtherPayment" />");
					return;
			}

			if(recOtherPayment>0 && recOtherDocNumber.length<1){
					eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.DocNumberNotEntered" />");
					return;
			}

			if(otherPaymentType==3 && recOtherDocNumber.length>4){
					eval("form.elements['receivables["+index+"].recStatusId']").selectedIndex=0;
					alert("<bean:message key="app.messages.js.CreditCardNumberDigits" />");
					return;
			}

        }else if (status.options[status.selectedIndex].value==3){
               // alert("in FTCSplitCurrency.jsp");
        		var w=320;
            	var h=160;
            	if(w>screen.width)w=screen.width;
                if(h>screen.height)h=screen.height;
                var leftpos=(screen.width-w) / 2;
                var toppos=(screen.height-h) / 2;
				//var params = "index="+index;
				//alert("params="+params);
				billAccount=eval("form.elements['receivables["+index+"].billAccount']").value;
				var params = "formName=FTC&index="+index+"&billAccount="+billAccount;
				//window.open("<html:rewrite page="/tiles/FTC/BillToAccount1.jsp" />?"+params,"BillToAccount","scrollbars=no,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
				window.open("<html:rewrite page="/pages/FTC_BillToAccount.jsp" />?"+params,"BillToAccount","scrollbars=no,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
        }
    }

      function splitCurrency(){
        		var form=document.forms['FTCCourierCashRecapForm'];
                var w=320;
                var h=180;
                var index=Number(<bean:write name="offset" />);
                var count=Number(0);
                var empId;

    	        while(eval("form.elements['receivables["+index+"].recId']")){
    	            if(eval("form.elements['receivables["+index+"].selected']").checked){
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

    function findIndex(name,after){
        var from=name.indexOf("[",after)+1;
        var to=name.indexOf("]",after);
        return name.substr(from,to-from);
    }

        function toPrepaid() {
            var form=document.forms['FTCCourierCashRecapForm'];
            var valid=validate(false);
            if(valid==""){
                resetPagination();
                form.action.value="toPrepaid";
                form.submit();
            }else{
                alert(valid);
            }
        }

        function toPOA() {
            var form=document.forms['FTCCourierCashRecapForm'];
            var valid=validate(false);
            if(valid==""){
                resetPagination();
                form.action.value="toPOA";
                form.submit();
            }
            else {
                alert(valid);
            }
        }

        function toCOD() {
            var form=document.forms['FTCCourierCashRecapForm'];
            var valid=validate(false);
            if(valid==""){
                resetPagination();
                form.action.value="toCOD";
                form.submit();
            }
            else {
                alert(valid);
            }
        }
        
        
        function toROD() {
            var form=document.forms['FTCCourierCashRecapForm'];
            var valid=validate(false);
            if(valid==""){
                resetPagination();
                form.action.value="toROD";
                form.submit();
            }
            else {
                alert(valid);
            }
        }
        
        function changeCourier(){
            var form=document.forms['FTCCourierCashRecapForm'];
            var valid=validate(false);
            if(valid==""){
                resetPagination();
                form.action.value="changeCourier";
                form.submit();
            }
            else {
                alert(valid);
            }
        }

        function viewRecPrepayment(idx){
        var form=document.forms['FTCCourierCashRecapForm'];
		pop = window.open("","_blank","toolbar=no,menubar=no,location=no,status=no,width=320,height=100,scrollbars=no,left=350,top=250")

	  	document.onmousedown=pop.focus;
        document.onkeydown	=pop.focus;
		pop.document.write('<html>')
		pop.document.write('<head><title>')
		pop.document.write('<bean:message key="app.messages.js.PrepyRecWindow"/>')
		pop.document.write('</title></head>')
	 	pop.document.write('<script language=JavaScript>')
		pop.document.write('function SubmitCodes(indexItem){ ')
		pop.document.write('var prepy = document.forms[\'PrepyForm\'].elements[\'prepyAmt\'].value;')
		pop.document.write('var form  = self.opener.document.forms["FTCCourierCashRecapForm"];')
		pop.document.write('if (window.opener && !window.opener.closed){ ')
		pop.document.write('while(isNaN(prepy) || (prepy<0)) {')
		pop.document.write('	  alert(\"<bean:message key="app.messages.js.PrepyNumberNotZero"/>\", "0");')
		pop.document.write('	  document.prepyAmt.focus();  return;}')
		pop.document.write('self.opener.updateFieldPrepy(prepy,indexItem);')
		pop.document.write('window.close(); } }')
		pop.document.write('<\/script>')
		pop.document.write('<body><form name="PrepyForm" action="" method="POST" focus="prepyAmt">')
		pop.document.write('<table align="center" bgcolor="#808080">')
		pop.document.write('<tr><td bgColor="#73148C"><font face="Arial" color="#FFFFFF" size="2"><b><bean:message key="app.messages.js.PrepyRecAmount"/></b></font></td></tr>')
		pop.document.write('<tr><td align="center" bgColor="#73148C"><input align="right" type="text" name="prepyAmt" value="' + form.elements['receivables['+idx+'].recvPrepyAmt'].value +'" size="10" maxlength="10" onmousemove="javascript:prepyAmt.focus()"/></td></tr>')
		pop.document.write('<tr><td align="center" bgColor="#73148C"><input type="button" value="<bean:message key="app.submit"/>" name="accept" onClick = "javascript:SubmitCodes(' + idx + ');" />')
		pop.document.write('		<input type="button" value="<bean:message key="app.messages.Close"/>" name="cancel" onclick = "window.close();" /></td></tr>')
		pop.document.write('</table></form></body></html>')
	}

	function updateFieldPrepy(prepy,idx)
	{	var form=document.forms['FTCCourierCashRecapForm'];
		if(prepy>0){
	  	   form.elements['recPrepaymentImg'+idx].src='<html:rewrite page="/images/prepyGreen.gif"/>';
	  	   form.elements['receivables['+idx+'].recvPrepyAmt'].value=prepy;
	  	}else{ if(prepy==0){
	  			  form.elements['recPrepaymentImg'+idx].src='<html:rewrite page="/images/prepyGray.gif"/>';
 	   	  	      form.elements['receivables['+idx+'].recvPrepyAmt'].value=prepy;
	  		   }
	  		 }
	}

    function changeCustomerNm(idx){
        var cust=eval("document.forms['FTCCourierCashRecapForm'].elements['receivables["+idx+"].customerNm']");
        var custPrev=eval("document.forms['FTCCourierCashRecapForm'].elements['receivables["+idx+"].customerNmPrev']");
		var custName=prompt("<bean:message key="app.messages.js.EnterNewCust" />",cust.value);

		while(custName!=null && (custName=="" || custName.length>50)){
			custName=prompt("<bean:message key="app.messages.js.ReEnterNewCust" />",cust.value);
		}

		if(custName!=null){
			custPrev.value=cust.value;
			cust.value=custName;
		}
    }

    function changeRecAmt(idx){
        var recAmt=eval("document.forms['FTCCourierCashRecapForm'].elements['receivables["+idx+"].recAmount']");
        var recAmtPrev=eval("document.forms['FTCCourierCashRecapForm'].elements['receivables["+idx+"].recAmtPrev']");
		var newRecAmt=prompt("<bean:message key="app.messages.js.EnterNewAmount" />",recAmt.value);

		while(newRecAmt!=null && (newRecAmt=="" || isNaN(newRecAmt) || newRecAmt<=0)){
			newRecAmt=prompt("<bean:message key="app.messages.js.ReEnterNewAmount" />",recAmt.value);
		}

		if(newRecAmt!=null){
			recAmtPrev.value=recAmt.value;
			recAmt.value=newRecAmt;
		}
    }

    function changeReceiptNbr(idx){
        var rcptNbr=eval("document.forms['FTCCourierCashRecapForm'].elements['receivables["+idx+"].rcptNbr']");
        var rcptNbrPrev=eval("document.forms['FTCCourierCashRecapForm'].elements['receivables["+idx+"].rcptNbrPrev']");
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
                window.open("<html:rewrite page="/FTC/FTC_CourierCashRecap.do" />?action=showScans&awbNbr="+awb,"showScans","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, width="+w+", height="+h+",left="+leftpos+",top="+toppos);
	}

    function updateField(codeVal, index, otherComment)
    {
		if(codeVal.length > 0)
		{  document.forms['FTCCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasComment.gif"/>';
		   document.forms['FTCCourierCashRecapForm'].elements['imgComment'+index].alt=codeVal;
		}else{
			  document.forms['FTCCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasNoComment.gif"/>';
			  document.forms['FTCCourierCashRecapForm'].elements['imgComment'+index].alt="<bean:message key="app.messages.ViewAddComment"/>";
			 }
		document.forms['FTCCourierCashRecapForm'].elements['receivables['+index+'].recComment'].value=codeVal;

		if(otherComment.length>0)
		{  		if(codeVal.length == 0)
			    {  document.forms['FTCCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasComment.gif"/>';
				   document.forms['FTCCourierCashRecapForm'].elements['imgComment'+index].alt="";
				}
		}else{
				if(codeVal.length == 0)
				{  document.forms['FTCCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasNoComment.gif"/>';
				   document.forms['FTCCourierCashRecapForm'].elements['imgComment'+index].alt="<bean:message key="app.messages.ViewAddComment"/>";
				}
		}
		document.forms['FTCCourierCashRecapForm'].elements['receivables['+index+'].otherComment'].value=otherComment;
    }
/*
    function validateBillAccountComment()
    {
        var form    = document.forms['FTCCourierCashRecapForm'];
        var comment = "";

        var index=0;
        while(eval("form.elements['receivables["+index+"].recStatusId']")){
            var status=eval("form.elements['receivables["+index+"].recStatusId']");
            if(status.options[status.selectedIndex].value==3){
                comment = document.forms['FTCCourierCashRecapForm'].elements['receivables['+index+'].otherComment'].value;
                if(comment.length == 0){
                    return false;
                }
            }
            index++;
        }
        return true;
     }
*/
     function toGRND(){
            var valid=validate(false);

            if(valid==""){
                var form=document.forms['FTCCourierCashRecapForm'];
                form.action.value="toGround";
                form.submit();
            }else{
                alert(valid);
            }
        }
</script>

