<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<bean:define toScope="page" id="userProfile" name="userProfile" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />
<script>
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
    <logic:present name="ProcessEndDay">
        window.open('<html:rewrite page="/pages/ShowProcessing.jsp" />','ShowProcessing','').close();

    </logic:present>
    var win;
    function controlPopUp(){
        var leftpos=(screen.width-472) / 2;
        var toppos=(screen.height-236) / 2;
        win=window.open('<html:rewrite page="/pages/ShowProcessing.jsp" />','ShowProcessing','toolbar=no, directories=no, location=no, status=no, menubar=no, resizable=no, titlebar=no,scrollbars=no, width=472, height=236,left='+leftpos+',top='+toppos);
        window.onfocus="win.focus();";
        document.onmousedown=win.focus;
        document.onkeydown=win.focus;
        document.onSubmit="";
    }


var counterEnd=0;
        function processEndDay(){

               if(counterEnd>1){
                    counterEnd=counterEnd+1;
                   alert("Please wait the end of process");

               }
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

                if(counterEnd<1){ controlPopUp();}
                 counterEnd=counterEnd+1;
                document.getElementById("buttonEnd").style.display='none';
                document.getElementById("buttonEndWhite").style.display='block';

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
        var atleastoneclosed=false;
        var closenewcourier=false;
        var count=Number("0");

        while(eval("form.elements['employeeSummaries["+index+"].employeeId']")){

            if(eval("form.elements['employeeSummaries["+index+"].closeCourier']") && eval("form.elements['employeeSummaries["+index+"].closeCourier']").checked){
               some=true;
            }else if(eval("form.elements['employeeSummaries["+index+"].closeCourier']") && (!eval("form.elements['employeeSummaries["+index+"].closed']"))){
                        if(!some){
                              // if there is any courier available for close option
                              closenewcourier=true;
                        }
            }else if(eval("form.elements['employeeSummaries["+index+"].closed']") && eval("form.elements['employeeSummaries["+index+"].closed']").checked){
               atleastoneclosed=true;
               count++;
            }
            index++;
        }

        if(index == count){
            alert("<bean:message key="errors.messages.js.AllCouriersAreClosed" />");
            return;
        }
        	
        if(some){
            form.elements['action'].value="CloseCourier";
            form.submit();
        }else if(closenewcourier){
            alert("<bean:message key="errors.messages.js.MustSelectNewCourierToClose" />");
        }else if(atleastoneclosed){
            return;
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
                   
            window.open("<html:rewrite page="/ReassignPayments.do" />?"+params,"reassign","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
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

   function addGround(){
            var w=750;
            var h=400;
            if(w>screen.width)w=screen.width;
            if(h>screen.height)h=screen.height;
            var leftpos=(screen.width-w) / 2;
            var toppos=(screen.height-h) / 2;
            window.open("<html:rewrite page="/Ground/AddGrndTrakNbrs.do" />?currentCurrency=<bean:write name="userProfile" property="defaultCurrency"/>","addAwbsWindow","scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");
    }

</script>

<html:errors />
<nested:form action="/ShowChkAgtCashRecap.do">
   <input type="hidden" name="action">

    <input type="hidden" name="reopenDeposits">

    <input type="hidden" name="newReassLocationCd">
    <input type="hidden" name="newEmployeeId">
    <input type="hidden" name="reassROD">
    <input type="hidden" name="reassPRP">
    <input type="hidden" name="reassPOA">
    <input type="hidden" name="reassGRN">

   <input type="hidden" name="SummSortColumn" value="<%=request.getParameter("SummSortColumn")%>">
   <input type="hidden" name="SummSortDirection" value="<%=request.getParameter("SummSortDirection")%>">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100%"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
  </tr>
</table>

<table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#808080">
<tr>
	<td bgcolor="#FFFFFF" >
      <p align="center" id="buttonEnd" style="display:block"><a href="javascript:processEndDay();" name="linkEOD" ><img border="0" src="<html:rewrite page="/images/EndOfDay" /><bean:message key="app.Language" />.gif" width="113" height="38"></a>&nbsp;&nbsp;&nbsp;</p>
      <p align="center" id="buttonEndWhite" style="display:none"> <img border="0" src="<html:rewrite page="/images/EndOfDay" /><bean:message key="app.Language" />.gif" width="113" height="38">&nbsp;&nbsp;&nbsp;</p>
    </td>
</tr>
</table>
<!-- Tabla separadora-->
<table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#808080">
<tr height="1">
	<td bgcolor="#808080" colspan="1" height="1"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
	<td bgcolor="#808080" colspan="1" height="1"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
</table>

<!-- TABLA CONTENEDORA DEL SUMMARY -->
<table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
<tr>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="3"></td>
	<td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="3"></td>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="3"></td>
</tr>
<tr >
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
	<td bgcolor="#FFFF9C">
	<!-- AQUI VA LA TABLA DEL SUMARY -->

    <div align="center">
      <center>
      <table border="0" width="98%" cellspacing="1" cellpadding="0">
        <tr>
          <td width="80%">
            <p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.title.CheckingAgentCashRecap" /></font></b></td>
        </center>
        <td width="50%" >
          <p align="right" ><html:link href="javascript:reassignPayments()"><img border="0" src="<html:rewrite page="/images/ReassignPayments" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link><a href="javascript:cashRecapReport();"><img border="0" src="<html:rewrite page="/images/CashRecap" /><bean:message key="app.Language" />.gif" width="113" height="38"></a><a href="javascript:reopenEndDay();"><img border="0" src="<html:rewrite page="/images/ReOpenDay" /><bean:message key="app.Language" />.gif" width="113" height="38"></a><a href="javascript:closeCourier();"><img border="0" src="<html:rewrite page="/images/CloseCouriers" /><bean:message key="app.Language" />.gif" width="113" height="38"></a><br><a href="javascript:addReceivable();"><img border="0" src="<html:rewrite page="/images/AddReassRec" /><bean:message key="app.Language" />.gif" width="113" height="38"></a><a href="javascript:addPrepaid();"><img border="0" src="<html:rewrite page="/images/addPrepaid" /><bean:message key="app.Language" />.gif" width="113" height="38"></a><logic:equal name="userProfile" property="gndUsedFlag" value="true" ><a href="javascript:addGround();"><img border="0" src="<html:rewrite page="/images/addGround" /><bean:message key="app.Language" />.gif" width="113" height="38"></a></logic:equal><html:link href="javascript:addPoaPayment('')"><img border="0" src="<html:rewrite page="/images/addPoaPayment" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link><logic:equal name="userProfile" property="quickStatus" value="true" ><html:link href="javascript:quickCollectLaters()"><img alt="Quick Collect Later" border="0" src="<html:rewrite page="/images/QuickScanMove" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link><html:link href="javascript:quickClear()"><img border="0" alt="Quick Clear" src="<html:rewrite page="/images/QuickClearAll" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link></logic:equal><html:link href="javascript:showMultipleInvoices()"><img alt="Payment Multiple Invoices" border="0" src="<html:rewrite page="/images/MultiInvoicePayment" /><bean:message key="app.Language" />.gif" width="113" height="38" ></html:link></td>
      </tr>
      </table>
    </div>

    <div align="center">
	<table border="0" width="98%" bgcolor="#000000" cellspacing="1" cellpadding="0">
	  <tr>
	  	<td rowspan="3" align="center" bgcolor="#73148C" height="57">&nbsp;</td>
	    <td rowspan="3" align="center" bgcolor="#73148C" height="57">
                           <% if("employeeNm".equals(request.getParameter("SummSortColumn"))){ %>
                                     <a href="javascript:sortTable('employeeId','asc');" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.CourierEmployeeID" /></font></a>
                           <% }else{
                                     if("desc".equals(request.getParameter("SummSortDirection"))){ %>            
                                            <a href="javascript:sortTable('employeeId','asc');" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.CourierEmployeeID" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/desc.gif" />"></p></b></a>
                           <%        }else{%>
                                            <a href="javascript:sortTable('employeeId','desc');" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.CourierEmployeeID" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/asc.gif" />"></p></b></a>
                           <%        }
                              }%>
            </td>
	    <td rowspan="3" align="center" bgcolor="#73148C" height="57">
                           <% if(!"employeeNm".equals(request.getParameter("SummSortColumn"))){ %>
                                      <a href="javascript:sortTable('employeeNm','asc');" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.EmployeeName" /></font></a>
                           <% }else{
                                    if("desc".equals(request.getParameter("SummSortDirection"))){ %>            
                                              <a href="javascript:sortTable('employeeNm','asc');" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.EmployeeName" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/desc.gif" />"></p></b></a>
                           <%       }else{%>
                                              <a href="javascript:sortTable('employeeNm','desc');" ><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.EmployeeName" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/asc.gif" />"></p></b></a>
                           <%       }
                              }%>
            </td>
	    <td align="center" colspan="4" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">R . O . D .</font></td>
	    <td align="center" colspan="2" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">Pre-Paid</font></td>
            <td align="center" colspan="2" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">P . O . A .</font></td>
<logic:equal name="userProfile" property="gndUsedFlag" value="true" >
            <td align="center" colspan="2" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">Ground</font></td>
</logic:equal>
<logic:equal name="userProfile" property="codUsedFlag" value="true" >
       <td align="center" colspan="4" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">C . O . D .</font></td>
</logic:equal>

<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >
       <td align="center" colspan="4" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">F . T . C .</font></td>
</logic:equal>

	    <td rowspan="3" align="center" bgcolor="#73148C" height="57"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Close" /></font><br><input type="checkbox" id="selectAllCloseCourier"  /></td>
	  </tr>

<script>
//select all the checkbox for quick process Close all courier
   $( document ).ready(function() {	
	    $("#selectAllCloseCourier").click(function() {
			   if(this.checked) {
			        $("input[type=checkbox]").prop('checked', $(this).prop('checked'));
				} else {
					 $("input[type=checkbox]").prop("checked", false);
				}//end if	
	    });
   });
   </script>	  
	  
          <tr>
   	    <td colspan="2" align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.LocalCurrencyAmount" /></font></td>
	    <td colspan="2" align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.USDAmount" /></font></td>
   	    <td align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.LocalCurrencyAmount" /></font></td>
	    <td align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.USDAmount" /></font></td>
   	    <td align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.LocalCurrencyAmount" /></font></td>
	    <td align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.USDAmount" /></font></td>
<logic:equal name="userProfile" property="gndUsedFlag" value="true" >
   	    <td align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.LocalCurrencyAmount" /></font></td>
	    <td align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.USDAmount" /></font></td>
</logic:equal>
<logic:equal name="userProfile" property="codUsedFlag" value="true" >
   	    <td colspan="2" align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.LocalCurrencyAmount" /></font></td>
	    <td colspan="2" align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.USDAmount" /></font></td>
</logic:equal>

<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >
   	    <td colspan="2" align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.LocalCurrencyAmount" /></font></td>
	    <td colspan="2" align="center" bgcolor="#73148C" height="18"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.USDAmount" /></font></td>
</logic:equal>


      </tr>
	  <tr>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Expected" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Expected" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
<logic:equal name="userProfile" property="gndUsedFlag" value="true" >
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
</logic:equal>
<logic:equal name="userProfile" property="codUsedFlag" value="true" >
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Expected" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Expected" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
</logic:equal>
<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Expected" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Expected" /></font></b></td>
   		 <td align="center" bgcolor="#73148C" height="19"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="2"><bean:message key="app.messages.Received" /></font></b></td>
</logic:equal>


	  </tr>
<logic:present name="CheckInAgentCashRecapForm" scope="request" >
 <nested:notEmpty property="employeeSummaries">
       <tr bgcolor="#ffffff">
         <td align="left" height="19"  >&nbsp;</td>
         <td align="center" width="8%">
             <font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1">
                    <a href="<html:rewrite page="/ShowChkAgtCashRecap.do" />?courier=ALL&action=GoDetails">ALL</a></font>
         </td>
   		 <td align="left" height="19"  width="15%"><font face="Verdana, Arial, Helvetica, sans-serif" size="1">ALL Couriers</font></td>
   		 <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalExpectedAmount" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalAppliedAmount" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdExpectedAmount" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdAppliedAmount" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalPrepaidLocal" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalPrepaidUsd" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalPoaLocal" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalPoaUsd" formatKey="app.format.NumberFormat" /></font></td>
<logic:equal name="userProfile" property="gndUsedFlag" value="true" >
   		 <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalGroundLocal" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalGroundUsd" formatKey="app.format.NumberFormat" /></font></td>
</logic:equal>
<logic:equal name="userProfile" property="codUsedFlag" value="true" >

   		 <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalExpectedAmount_COD" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalAppliedAmount_COD" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdExpectedAmount_COD" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdAppliedAmount_COD" formatKey="app.format.NumberFormat" /></font></td>
</logic:equal>
<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >

   		 <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalExpectedAmount_FTC" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalAppliedAmount_FTC" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdExpectedAmount_FTC" formatKey="app.format.NumberFormat" /></font></td>
         <td align="right" bgcolor="#FFFFFF" ><font  size="2"><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdAppliedAmount_FTC" formatKey="app.format.NumberFormat" /></font></td>
</logic:equal>
         <td  align="center" bgcolor="#FFFFFF" >&nbsp;</td>
      </tr>
 <nested:iterate property="employeeSummaries" id="empSummary" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.ExpressCheckinTableVO">
    <%  
        String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
        String fontColor=((empSummary.getLocalExpectedAmount()==empSummary.getLocalAppliedAmount() && empSummary.getUsdExpectedAmount()==empSummary.getUsdAppliedAmount())?"#009900":"#000000");
    %>
	  <tr>
    <nested:hidden property="employeeId" />
		 <td align="left" bgcolor="<%=bgColor%>" height="19"  ><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:checkbox property="selected" /></font></td>    
         <td bgcolor="<%=bgColor%>" align="center" width="8%">         
             <font  size="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><a href="<html:rewrite page="/ShowChkAgtCashRecap.do" />?courier=<nested:write property="employeeId" />&action=GoDetails" ><nested:write property="employeeId" /></a></b></font>
         </td>
   		 <td align="left" bgcolor="<%=bgColor%>" height="19"  width="15%"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="employeeName" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="localExpectedAmount" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="localAppliedAmount" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="usdExpectedAmount" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="usdAppliedAmount" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="prepaidLocalAmount" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="prepaidUsdAmount" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="poaLocalAmount" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="poaUsdAmount" formatKey="app.format.NumberFormat" /></font></td>
<logic:equal name="userProfile" property="gndUsedFlag" value="true" >
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="18%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="groundLocalAmount" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="18%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="groundUsdAmount" formatKey="app.format.NumberFormat" /></font></td>
</logic:equal>

<logic:equal name="userProfile" property="codUsedFlag" value="true" >
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="localExpectedAmount_COD" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="localAppliedAmount_COD" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="usdExpectedAmount_COD" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="usdAppliedAmount_COD" formatKey="app.format.NumberFormat" /></font></td>
</logic:equal>

<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="localExpectedAmount_FTC" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="localAppliedAmount_FTC" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="usdExpectedAmount_FTC" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="usdAppliedAmount_FTC" formatKey="app.format.NumberFormat" /></font></td>
</logic:equal>

   		 <td align="center" bgcolor="<%=bgColor%>" height="19" width="8%">
                      <nested:equal property="closed" value="true">
                          <nested:checkbox property="closed" onclick="this.checked=true;" />
                      </nested:equal>
                      <nested:notEqual property="closed" value="true">
                          <nested:equal property="canClose" value="true">
                              <nested:checkbox property="closeCourier" />
                          </nested:equal>
                      </nested:notEqual>
                      &nbsp;
                 </td>
	  </tr>
  </nested:iterate>
  <tr>
    <td colspan="2" bgcolor="#ffffff" align="center" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><B>&nbsp;</B></font></td>  
    <td bgcolor="#ffffff" align="right" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><B>Total</B></font></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalExpectedAmount" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalAppliedAmount" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdExpectedAmount" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdAppliedAmount" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalPrepaidLocal" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalPrepaidUsd" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalPoaLocal" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalPoaUsd" formatKey="app.format.NumberFormat" /></font></b></td>
<logic:equal name="userProfile" property="gndUsedFlag" value="true" >
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalGroundLocal" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalGroundUsd" formatKey="app.format.NumberFormat" /></font></b></td>
</logic:equal>
<logic:equal name="userProfile" property="codUsedFlag" value="true" >
	<td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalExpectedAmount_COD" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalAppliedAmount_COD" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdExpectedAmount_COD" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdAppliedAmount_COD" formatKey="app.format.NumberFormat" /></font></b></td>
</logic:equal>  
<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >
	<td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalExpectedAmount_FTC" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalLocalAppliedAmount_FTC" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdExpectedAmount_FTC" formatKey="app.format.NumberFormat" /></font></b></td>
    <td align="right" bgcolor="#FFFFFF" ><font  size="2"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalUsdAppliedAmount_FTC" formatKey="app.format.NumberFormat" /></font></b></td>
</logic:equal>    
    <td  align="center" bgcolor="#FFFFFF" >&nbsp;</td>
  </tr>
 </nested:notEmpty>
 <nested:empty property="employeeSummaries">
       <tr> 
            <td bgcolor="#ffffff" align="center" colspan="<%=userProfile.isGndUsedFlag()?"14":"12"%>">
                <font  size="2"><b><font color="red" face="Verdana, Verdana, Arial, Helvetica, sans-serif, Helvetica, sans-serif"><bean:message key="app.messages.EmptyBecauseClosedDay" /></font></b></font>
            </td>
       </tr> 
 </nested:empty>
</logic:present>
     </table>
</div>
	<!-- ------------------------------>
	</td>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>


<tr>
	<td  width="1" bgcolor="#808080">&nbsp;</td>
	<td bgcolor="#FFFF9C" align="right" >&nbsp;</td>
	<td  width="1" bgcolor="#808080">&nbsp;</td>
</tr>
<tr>
	<td  width="1" bgcolor="#808080">&nbsp;</td>
	<td bgcolor="#FFFF9C">
      <p align="center">&nbsp;</td>
	<td  width="1" bgcolor="#808080">&nbsp;</td>
</tr>
<tr>
	<td  width="1" bgcolor="#808080">&nbsp;</td>
	<td bgcolor="#FFFF9C">
      <div align="center">
        <center>
        <table border="0" width="70%" bgcolor="#000000" cellspacing="1" cellpadding="0" style="padding: 4">
          <tr>
            <td width="33%" rowspan="2" height="42" bgcolor="#73148C">
              <p align="center"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif">
                        <bean:message key="app.title.OtherPaymentsReceived" /></font></b></td>
            <td width="33%" height="20" bgcolor="#73148C" align="right"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2">
                    <b><bean:message key="app.messages.LocalCurrencyAmount" /></b></font></td>
            <td width="34%" height="20" bgcolor="#FFFFFF" align="right"><font face="Verdana, Arial, Helvetica, sans-serif"><b><nested:write property="localOtherPaymentAmt" formatKey="app.format.NumberFormat" /></b></font></td>
            <td width="34%" rowspan="2" height="42" bgcolor="#FFFF9C">
              <p align="center"><a href="javascript:addOtherPayment();" ><img border="0" src="<html:rewrite page="/images/AddOthers" /><bean:message key="app.Language" />.gif" width="113" height="38"></a></td>
          </tr>
          <tr>
            <td width="33%" height="20" bgcolor="#73148C" align="right"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>
                <bean:message key="app.messages.USDAmount" /></b></font></td>
            <td width="34%" height="20" bgcolor="#FFFFFF" align="right"><font face="Verdana, Arial, Helvetica, sans-serif"><b><nested:write property="usdOtherPaymentAmt" formatKey="app.format.NumberFormat" /></b></font></td>
          </tr>
        </table>
        </center>
      </div>
    </td>
	<td  width="1" bgcolor="#808080">&nbsp;</td>
</tr>



<tr>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
	<td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="5"></td>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
<tr bgcolor="#808080" height="1">
	<td colspan=3><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>

</nested:form>

<form name="createReports" method="POST">
        <input type="HIDDEN" name="Format" value="PDF">
        <input type="HIDDEN" name="locationCd" value="<bean:write name="userProfile" property="locationCd" />">        
        <input type="HIDDEN" name="employeeId" value="<bean:write name="userProfile" property="employeeId" />">  
        <input type="HIDDEN" name="StyleSheet" value="">
</form>