<%@page contentType="text/html"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<script>
    function handlePress(e,index) {
      var form=document.forms[0];
      var whichCode = (window.Event) ? e.which : e.keyCode;

      if(whichCode==13){
          if(form.findByAwb[1].checked){
                var invNbr=eval("form.elements['awbInv["+(index-1)+"].value']").value
                if(invNbr.lastIndexOf("-")>=0){
                    invNbr=invNbr.substr(invNbr.lastIndexOf("-")+1);
                }

                if(invNbr!="" && !isNaN(invNbr)){
                    invNbr=Number(invNbr);
                }
                eval("form.elements['awbInv["+(index-1)+"].value']").value=invNbr;

          }


            if (eval("form.elements['awbInv["+index+"].value']")){
                   eval("form.elements['awbInv["+index+"].value']").focus();
            }else{
                   form.elements['submitButton'].focus();
            }
      }
    }

 function submitForm(){
    var msg="";
    var frm=document.forms[0];

    if(frm.elements['paymentType'].options[frm.elements['paymentType'].selectedIndex].value!=5 && frm.elements['docNbr'].value==""){
        msg=msg+"<bean:message key="app.messages.js.DocNumberNotEntered" />\n";
    }

    if(frm.elements['newReassLocationCd'].value==""){
       msg=msg+"<bean:message key="errors.messages.js.LocationRequired" />\n";
    }

    if(frm.elements['newEmployeeId'].value==""){
       msg=msg+"<bean:message key="errors.messages.js.CourierRequired" />\n";
    }

    if(msg!=""){
        alert("<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg);
        return;
    }

    frm.submit();
 }

 function parseDocNbr(obj){

 <nested:equal name="userProfile" property="countryCd" value="AR" >
	if(obj.value.length==31){
	   var bankCd=obj.value.substring(1,4);
	   var br=Number(obj.value.substring(7,11));
       var checkNbr=obj.value.substring(11,19);
       var ptValue=null;

       obj.value=bankCd+String.fromCharCode(45)+checkNbr;

       brModulus=br%2000;

       if(bankCd==String(0)+String(16)){
             if(brModulus==0 || br!=brModulus){
                ptValue=String(69); //Arg 48
             }else{
                ptValue=String(1); //check
             }
       }else{
             if((br==brModulus) || br==2804 || br==2812 || br==6706 || br==2806 || br==2814 || br==6700 || br==7240 || br==6600 || br==6605 || br==2760 || br==6720 || br==6612 || br==2800){
                ptValue=String(69); //Arg 48
             }else{
                ptValue=String(70); //Arg 72 hr
             }
       }

       for(var i=0;document.forms[0].elements['paymentType'].options[i];i++){
       		if(document.forms[0].elements['paymentType'].options[i].value==ptValue){
       			document.forms[0].elements['paymentType'].selectedIndex=i;
       			break;
       		}
       }
	}
    </nested:equal>
}


    function docNbrKey(e,obj) {
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            document.forms[0].elements['awbInv[0].value'].focus();
      }
    }

</script>
<HTML>
<nested:errors />
<nested:form action="/ShowChkAgtCashRecap.do">
   <input type="hidden" name="action" value="saveMultipleInvoices">
  <table cellspacing="1" cellpadding="0" bgcolor="#FFFF9C"  align="center">
    <tr><td bgcolor="#73148C" colspan="3">&nbsp;</td></tr>
    <tr>
      <td bgcolor="#73148C" rowspan="5"><font face="Arial" size="1" color="#FFFFFF"><bean:message key="app.messages.Payment" /></td>
      <td bgcolor="#C0C0C0"><font face="Arial" size="1" color="#000000"><bean:message key="app.messages.CourierEmployeeID" /></td>
      <td><nested:text property="newEmployeeId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" /></td>
    </tr>
    <tr> 
      <td bgcolor="#C0C0C0"><font face="Arial" size="1" color="#000000"><bean:message key="app.messages.Location" /></td>
      <td><nested:text property="newReassLocationCd" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" /></td>
    </tr>
    <tr> 
      <td bgcolor="#C0C0C0"><font face="Arial" size="1" color="#000000"><bean:message key="app.messages.Currency" /></td>
      <td>
         <nested:select property="currencyCd" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
            <html:optionsCollection name="userProfile" property="supportedCurrencies" label="currencyCode" value="currencyCode" />
         </nested:select>
      </td>
    </tr>
    <tr>
      <td bgcolor="#C0C0C0"><font face="Arial" size="1" color="#000000"><bean:message key="app.messages.Number" /></td>
      <td><input type="text" name="docNbr" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt"></td>
    </tr>
    <tr>
      <td bgcolor="#C0C0C0"><font face="Arial" size="1" color="#000000"><bean:message key="app.messages.Type" /></td>
      <td><nested:select property="paymentType" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
               <html:optionsCollection name="CheckInAgentCashRecapForm" property="rodPymtTypes" label="shtDesc" value="paymentTypeId"  />
          </nested:select></td>
    </tr>
    <tr><td colspan="3">
        <table>
            <tr>
            <td colspan="4" align="center" ><font face="Arial" size="2" color="#000000"><b><bean:message key="app.messages.InvoiceShipment" /> AWB <nested:radio property="findByAwb" value="true" /> Invoice <nested:radio property="findByAwb" value="false"/>
            </font></td></tr>
            <%	 int count=0;
                 for(int i=1; i<=10;i++){ %>
            <tr>
              <%	for(int j=1;j<=4;j++){%>
              <td>
                <input type="text" name="awbInv[<%=count%>].value" onkeypress="handlePress(event,<%=count+1%>);" ></td>

              <%       count++;
                    }%>
              <% }%>
            <tr>
         </table>
    </td></tr>
    </tr>
    <tr><td colspan="3" align="center"><input name="submitButton" value="Submit" type="button" onclick="submitForm()" ></td></tr>
  </table>
</nested:form>
</HTML>