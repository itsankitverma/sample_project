<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="calendar" %>

<script src="<html:rewrite page="/scripts/calendar.js" />"></script>
<script src="<html:rewrite page="/scripts/calendar-msgs-" /><bean:message key="app.Language" />.js"></script>
<script src="<html:rewrite page="/scripts/calendar-setup.js" />"></script>
<LINK REL ="stylesheet" TYPE="text/css" HREF="<html:rewrite page="/styles/calendar.css" />" TITLE="Style">
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>

<script>
        <bean:size id="paymenTypeCount" name="OtherPaymentAddForm" property="paymentTypes" />
        var pymtCtgAssoc=new Array(<bean:write name="paymenTypeCount" />);       
        <logic:iterate id="elem" name="OtherPaymentAddForm" property="paymentTypes">
              pymtCtgAssoc["<bean:write name="elem" property="paymentTypeId" />"] = "<bean:write name="elem" property="paymentCtgId" />";
        </logic:iterate>
        
        <bean:size id="banksCount" name="OtherPaymentAddForm" property="countryBanks" />        
        var countryBanksAssoc=new Array(<bean:write name="banksCount" />);       
        <logic:iterate id="elem" name="OtherPaymentAddForm" property="countryBanks">
        	<logic:present name="elem" property="bankCd">
	              countryBanksAssoc[String(Number("<bean:write name="elem" property="bankCd" />"))] = "<bean:write name="elem" property="bankShtDesc" />";
        	</logic:present>	              
        </logic:iterate> 
                
<logic:present name="submitParent">
    opener.document.forms[0].submit();
</logic:present>

    <bean:write name="checkDecodeJS" scope="session" />    
    
    
    function docNbrKey(e,obj) {    
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            obj.blur();
      }
    }
        
    function savePayment(){
        var form=document.forms['OtherPaymentAddForm']; 
        var msg=validatePayment();
        if(msg==""){
            form.elements['action'].value='savePayment';
            form.submit();
        }else{
            alert(msg);
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
    
    function validatePayment(){
        var form=document.forms['OtherPaymentAddForm'];
        var msg="";
        
        /*
        if(form.elements['newPayment.awbNbr'].value=="")
    	{  msg=msg+ "-<bean:message key="app.messages.js.MustEnterAwbNumber" />\n";}
		*/
		
		if(form.elements['newPayment.otherPaymentCtgId'].selectedIndex==0)
    	{  msg=msg+ "-<bean:message key="app.messages.js.MustSelectPaymentCategory"/>\n";}
        
    	if(form.elements['newPayment.awbNbr'].value!="" && !(validaAWBNbr(form.elements['newPayment.awbNbr'].value)))
    	{  msg=msg+ "-<bean:message key="errors.messages.js.AwbInvalid"/>\n";}
            
        if(form.elements['newPayment.paymentCurrency'].selectedIndex==0){
            msg=msg+"-<bean:message key="app.messages.js.MustSelectCurrency" />\n";
        }  
        
        var pt=form.elements['newPayment.paymentType'];
        var ptIndex=pt.selectedIndex;
        if(pymtCtgAssoc[pt.options[ptIndex].value]==3 && form.elements['newPayment.paymentDocNbr'].value.length>4){
            msg=msg+"-<bean:message key="app.messages.js.CreditCardNumberDigits" />\n";
        } 

        if(form.elements['newPayment.paymentType'].selectedIndex==0){
            msg=msg+"-<bean:message key="app.messages.js.MustSelectOtherPaymentType" />\n";
        }

        if(pymtCtgAssoc[pt.options[ptIndex].value]!=5 && form.elements['newPayment.paymentDocNbr'].value.length<1){
            msg=msg+"-<bean:message key="app.messages.js.DocNumberNotEntered" />\n";
        }

        if(isNaN(form.elements['newPayment.paymentAmt'].value) || Number(form.elements['newPayment.paymentAmt'].value)<=0){
            msg=msg+"-<bean:message key="app.messages.js.BadMontos" />\n";
        }

        if(msg!=""){
             return "-<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;
        }else{
             return "";
        }


    }

    function deletePayment(idx){
        var form=document.forms['OtherPaymentAddForm'];
        form.elements['action'].value='deleteDetail';
        form.elements['newPayment.otherPymtId'].value=idx;
        form.submit();        
    }

</script>
<html:errors />
<nested:form action="/OtherPayments/AddPayment.do" focus="newPayment.description" name="OtherPaymentAddForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.OtherPaymentAddForm">
<nested:hidden property="newPayment.otherPymtId" />
<input type="hidden" name="action" >
<div align="center">
  <center>
<table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#000000">
  <tr>
    <td bgcolor="#808080"><font face="Arial"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></font></td>
    <td bgcolor="#808080"><font face="Arial"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" height="1"></font></td>
    <td bgcolor="#808080"><font face="Arial"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></font></td>
  </tr>
  <tr>
    <td bgcolor="#808080"><font face="Arial"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1"></font></td>
    <td bgcolor="#FFFF9C"><font face="Arial"><p align="center">&nbsp; </font></td>
    <td bgcolor="#808080"><font face="Arial"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1"></font></td>
  </tr>
  <tr>
    <td bgcolor="#808080"><font face="Arial"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1"></font></td>
    <td bgcolor="#FFFF9C">
          </center>
    <div align="center">
      <center>
      <table border="0" bgcolor="#000000" cellspacing="1" cellpadding="0" width="50%">
        <tr>
          <td bgcolor="#73148C" colspan="2" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif"><b><bean:message key="app.messages.OtherPaymentsDataEntering" /></b></font></td>
        </tr>
        
         <tr>
          <td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.AWBNumber" /></font></td>
          <td bgcolor="#FFFFFF"><font face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="newPayment.awbNbr" size="20" value="" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;text-align: left" /></font></td>
        </tr>
                
        <tr>
          <td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.PaymentCategory" /></font></b></td>
          <td bgcolor="#FFFFFF"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2">
                    <nested:select property="newPayment.otherPaymentCtgId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" >
                         <option value="">Select</option>                         
                         <html:optionsCollection name="OtherPaymentAddForm" property="otherPaymentsCtg" label="shortDescription" value="otherPaymentCtgId" />
                    </nested:select>          
          	</font></td>          	
        </tr>        

        <tr>
          <td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.Description" /></font></b></td>
          <td bgcolor="#FFFFFF"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:textarea property="newPayment.description" maxlength="2000" /></font></td>
        </tr>
        <tr>
          <td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.Currency" /></font></td>
          <td bgcolor="#FFFFFF"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2">
                    <nested:select property="newPayment.paymentCurrency" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" >
                         <option value="">Select</option>
                         <html:optionsCollection name="userProfile" property="supportedCurrencies" label="currencyCode" value="currencyCode" />
                    </nested:select>
                </font></td>
        </tr>
        <tr>
          <td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.Amount" /></font></td>
          <td bgcolor="#FFFFFF"><font face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="newPayment.paymentAmt" size="12" value="0.00" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;text-align: right" /></font></td>
        </tr>
        <tr>
          <td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.Type" /></font></td>
          <td bgcolor="#FFFFFF"><font face="Verdana, Arial, Helvetica, sans-serif">
                <bean:define id="paymentTypes" name="OtherPaymentAddForm" property="paymentTypes" type="java.util.ArrayList" />
                <nested:select property="newPayment.paymentType" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" >
                     <option value="">Select</option>
                     <nested:optionsCollection name="OtherPaymentAddForm" property="paymentTypes" label="shtDesc" value="paymentTypeId" />
                </nested:select>            
                </font></td>
        </tr>
        <tr>
          <td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.Number" /></font></td>
          <td bgcolor="#FFFFFF">
            <p align="left"><font face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="newPayment.paymentDocNbr" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" /></font></td>
        </tr>
        
        
        
        <!--changes for miscDate miscNbr  -->
		<tr>
			<td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.MISCELLANEOUSNBR" /></font></td>
			<td bgcolor="#FFFFFF">
				<p align="left"><font face="Verdana, Arial, Helvetica, sans-serif"><input type="text" id='miscNbr' name="newPayment.miscNbr" onkeyup="validateForAlphanumeric('miscNbr')" maxlength="15" size="15"/></font></td>
        </tr>   
		<tr>
			<td bgcolor="#73148C" align="right"><b><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><bean:message key="app.messages.MISCELLANEOUSDATE" /></font></td>
			<td bgcolor="#FFFFFF">
				<p align="left">
					<font face="Verdana, Arial, Helvetica, sans-serif">
						<!--calendar js  -->
						<%String iconUrl=request.getContextPath()+"/images/cal.gif";%>
						<input type="text" id="miscDate" name="miscDate" maxlength="10" size="10"><a href="#"><img id="triggermiscDate" src="<%=iconUrl%>" border="0"/></a>
							
						<script type="text/javascript">
							Calendar.setup({inputField     :    "miscDate",ifFormat       :    "%m/%d/%Y",button         :    "triggermiscDate",align          :    "Bl",singleClick    :    true});
						</script>
						<!--calendar js  -->					
					</font>
			</td>
        </tr>             
        <!--changes for miscDate miscNbr  -->
        
        
        
        <tr>          
          <td bgcolor="#FFFF9C" colspan="2" align="center"><a href="javascript:savePayment();" ><img name="addInvoiceImg" border="0" src="<html:rewrite page="/images/Add" /><bean:message key="app.Language" />.gif" width="113" height="38"></a></td>
        </tr>
      </table>
      </center>
    </div>
    <p>&nbsp;</p>
    <div align="center">
      <center>
      <table border="0" bgcolor="#000000" cellspacing="1" cellpadding="0">
        <tr>
          <td bgcolor="#73148C" align="center" colspan="8"><b>
                <font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="3">
                     <bean:message key="app.messages.TodayOthersPaymentsReceived" />
                </font></b></td>
        </tr>
        <tr>
          <td bgcolor="#73148C" rowspan="2" align="center">
                            <font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.Description" /></b></font></td>
          <td colspan="3" bgcolor="#73148C" align="center">
                            <font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.LocalCurrency" /></b></font></td>
          <td colspan="3" bgcolor="#73148C" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>USD</b></font></td>
          <td rowspan="2" bgcolor="#73148C" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.Action" /></b></font></td>
        </tr>
        <tr>
          <td bgcolor="#73148C" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.Amount" /></b></font></td>
          <td bgcolor="#73148C" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.Number" /></b></font></td>
          <td bgcolor="#73148C" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.Type" /></b></font></td>
          <td bgcolor="#73148C" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.Amount" /></b></font></td>
          <td bgcolor="#73148C" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.Number" /></b></font></td>
          <td bgcolor="#73148C" align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><bean:message key="app.messages.Type" /></b></font></td>
        </tr>
<nested:notEmpty property="payments">
<nested:iterate property="payments" id="payment" indexId="idx" type="com.fedex.lacitd.cashcontrol.datatier.valueobject.OtherPaymentVO">    
        <tr>
          <td bgcolor="#FFFFFF"  width="30%"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><nested:write property="description" /></b></font></td>
<nested:notEqual property="paymentCurrency" value="USD">         
          <td bgcolor="#FFFFFF" align="right" width="10%"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><nested:write property="paymentAmt" formatKey="app.format.NumberFormat" /></b></font></td>
          <td bgcolor="#FFFFFF" width="10%"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><nested:write property="paymentDocNbr" /></b></font></td>
          <td bgcolor="#FFFFFF" width="10%"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>
              <c:forEach var="category" items="${OtherPaymentAddForm.paymentTypes}">
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
          </b></font></td>
          <td bgcolor="#FFFFFF" align="right" width="10%">&nbsp;</td>
          <td bgcolor="#FFFFFF" width="10%">&nbsp;</td>
          <td bgcolor="#FFFFFF" width="10%">&nbsp;</td>
</nested:notEqual>
<nested:equal property="paymentCurrency" value="USD">         
          <td bgcolor="#FFFFFF" align="right" width="10%">&nbsp;</td>
          <td bgcolor="#FFFFFF" width="10%">&nbsp;</td>
          <td bgcolor="#FFFFFF" width="10%">&nbsp;</td>
          <td bgcolor="#FFFFFF" align="right" width="10%"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><nested:write property="paymentAmt" formatKey="app.format.NumberFormat" /></b></font></td>
          <td bgcolor="#FFFFFF" width="10%"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><b><nested:write property="paymentDocNbr" /></b></font></td>
          <td bgcolor="#FFFFFF" width="10%"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>
              <c:forEach var="category" items="${OtherPaymentAddForm.paymentTypes}">
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
          </b></font></td>
</nested:equal>
          <td bgcolor="#FFFFFF" align="center" width="10%"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><a href="javascript:deletePayment(<nested:write property="otherPymtId" />);"><bean:message key="app.messages.Delete" /></a></font></b></td>
        </tr>
</nested:iterate>
</nested:notEmpty>
      </table>
      </center>
    </div>
     </td>
    <td bgcolor="#808080"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
  </tr>
  <tr>
    <td bgcolor="#808080"><font face="Arial"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1"></font></td>
    <td bgcolor="#FFFF9C">&nbsp;</td>
    <td bgcolor="#808080"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
  </tr>
  <tr>
    <td bgcolor="#808080">
        <font face="Arial">
      	<img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></font></td>
    <td bgcolor="#808080">
        <font face="Arial">
    	<img border="0" src="<html:rewrite page="/images/pixel.gif" />" height="1"></font></td>
    <td bgcolor="#808080"><img border="0" src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
  </tr>
</table>
</div>
</nested:form>