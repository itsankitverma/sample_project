function sortTable(column,direction){        
        var form=document.forms['CheckInAgentCashRecapForm'];
        var valid="";//validate(false);

        if(valid==""){
                form.elements['action'].value='sortTable';
                form.elements['SummSortColumn'].value=column;
                form.elements['SummSortDirection'].value=direction;
                form.submit();            
        }else{
            alert(valid);
        }    
    }

    function processEndDay(){

        var form=document.forms['CheckInAgentCashRecapForm'];
        var index=Number("0");
        var some=false;

        while(eval("form.elements['employeeSummaries["+index+"].employeeId']")){
            if((!eval("form.elements['employeeSummaries["+index+"].closed']") || !eval("form.elements['employeeSummaries["+index+"].closed']").checked) &&
               (!eval("form.elements['employeeSummaries["+index+"].closeCourier']") || !eval("form.elements['employeeSummaries["+index+"].closeCourier']").checked)){
               some=true;
               break;
            }
            index++;
        }
        if(some){
            alert("<bean:message key="errors.messages.js.ThereAreNotClosedCouriers" />");
        }else{
            form.elements['action'].value="ProcessEndDay";
            form.submit();            
        }
    }
    
    
    function reopenEndDay(){
        var w=380;
        var h=150;
        if(w>screen.width)w=screen.width;
        if(h>screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;
        window.open("<html:rewrite page="/tiles/ReopenDay.jsp" />","multiInvoiceWindow","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);

    }

    function quickCollectLaters(){
        var form=document.forms['CheckInAgentCashRecapForm'];
        form.elements['action'].value="quickCollectLaters";
        form.submit();
    }

    function quickClear(){
        var form=document.forms['CheckInAgentCashRecapForm'];
        form.elements['action'].value="quickClear";
        form.submit();
    }

    function showMultipleInvoices(){
        var w=700;
        var h=600;
        if(w>screen.width)w=screen.width;
        if(h>screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;
        window.open("<html:rewrite page="/ShowChkAgtCashRecap.do" />?action=showMultipleInvoices","multiInvoiceWindow","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }


    function cashRecapReport(){
          var form=document.forms['createReports'];
          form.action="<html:rewrite page="/servlet/CurrentCashRecapReport" />";
          form.StyleSheet.value="XSLT/CurrentCashRecapReport.xsl";
          form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
          form.target="results";
          form.submit();
    }      

    function addOtherPayment(){
            var w=700;
            var h=500;
            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;
            window.open("<html:rewrite page="/OtherPayments/AddPayment.do" />","addReceivableWindow","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }


    function closeCourier(){
        var form=document.forms['CheckInAgentCashRecapForm'];
        var index=Number("0");
        var some=false;

        while(eval("form.elements['employeeSummaries["+index+"].employeeId']")){
            if(eval("form.elements['employeeSummaries["+index+"].closeCourier']") && eval("form.elements['employeeSummaries["+index+"].closeCourier']").checked){
               some=true;
            }
            index++;
        }
        if(some){
            form.elements['action'].value="CloseCourier";
            form.submit();
        }else{
            alert("<bean:message key="errors.messages.js.MustSelectCourierToClose1" />");
        }    
    }
    function addReceivable(){
            var w=700;
            var h=500;
            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;
            window.open("<html:rewrite page="/ROD/AddReceivable.do" />","addReceivableWindow","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }
    
    function reassignPayments(){
    		var form=document.forms['CheckInAgentCashRecapForm'];
            var w=400;
            var h=200;
            var index=Number(0);
            var count=Number(0);
            var empId;
            
	        while(eval("form.elements['employeeSummaries["+index+"].employeeId']") && count<2){
	            if(eval("form.elements['employeeSummaries["+index+"].selected']").checked){
	               count++;
	               empId=eval("form.elements['employeeSummaries["+index+"].employeeId']").value;
	            }
	            index++;
	        } 
	        
	        if(count==0){
	        	alert("<bean:message key="app.messages.MustSelectCourierReassign"/> ");
	        	return;
	        }
	        
	        var params="summary=true&";
	        if(count>1){
	        	params=params+"multipleSelected=true&"
	        }else{
	        	params=params+"multipleSelected=false&oldEmployee="+empId+"&";
	        }           
            
            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;
                   
            window.open("<html:rewrite page="/pages/ReassignPayments.jsp" />?"+params,"reassign","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }    

   function addPrepaid(){
            var w=750;
            var h=400;
            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;
            window.open("<html:rewrite page="/Prepaid/AddPrepaidAwbs.do" />?currentCurrency=<bean:write name="userProfile" property="defaultCurrency"/>","addAwbsWindow","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
    }

   function addPoaPayment(){
        var w=500;
        var h=550;
        if(w>screen.width)w=screen.width;
        if(h>screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;
        window.open("<html:rewrite page="/Poa/PoaAddPayment.do" />", "addAwbsWindow", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
   }

   function morePayments(){
        var form=document.forms['CheckInAgentCashRecapForm'];
        form.elements['action'].value='goMorePayments';
        form.submit();
   }
    