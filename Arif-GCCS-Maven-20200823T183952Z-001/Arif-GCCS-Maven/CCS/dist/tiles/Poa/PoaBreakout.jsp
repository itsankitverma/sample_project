<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>

<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>

	function save(){
        var form=document.forms['PoaBreakoutForm'];	
        var parentForm=opener.document.forms['PoaAddPaymentForm'];
        
        parentForm.elements['details[<bean:write name="PoaBreakoutForm" property="parentIndex" />].surChargesTotal'].value=form.elements['totalCollected'].value;
        if(form.elements['totalCollected'].value==Number(0)){
        	opener.document.images['surchrgImg<bean:write name="PoaBreakoutForm" property="parentIndex" />'].src="<html:rewrite page="/images/moneyGray.gif"/>";
        	form.submit();
        }else{
	        if(Number(form.elements['totalCollected'].value)!=Number(form.elements['parentTotal'].value)){
	        	opener.document.images['surchrgImg<bean:write name="PoaBreakoutForm" property="parentIndex" />'].src="<html:rewrite page="/images/moneyRed.gif"/>";
	        	if(confirm("<bean:message key="app.messages.js.TotalSurchNotMatch" />")){
	 				form.submit();       	
	        	}
	        }else{
	        	opener.document.images['surchrgImg<bean:write name="PoaBreakoutForm" property="parentIndex" />'].src="<html:rewrite page="/images/moneyGreen.gif"/>";
	        	form.submit();
	        }
	    }    
	}
	
    function amtChanged(){
        var form=document.forms['PoaBreakoutForm'];
        var total=Number(0.0);
        var index=Number(0);
        while(eval("form.elements['surcharges["+index+"].surchargeCd']")){
            if(!isNaN(eval("form.elements['surcharges["+index+"].collectedAmt']").value)){
                total=total+Number(eval("form.elements['surcharges["+index+"].collectedAmt']").value);
            }
            index++;
        }

        form.elements['totalCollected'].value=format_number(total,2);
    }
</script> 

<html:errors />
<bean:define id="frm" name="PoaBreakoutForm" toScope="page" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.PoaBreakoutForm" />
<nested:form action="/Poa/PoaBreakout.do" >
	<input type="hidden" name="action" value="save">
	
	<logic:present name="requestID">
		<input type="hidden" name="requestID" value="<bean:write name="requestID" scope="session" />" >
	</logic:present>
	
	
	<nested:hidden property="parentTotal" />	
	<nested:hidden property="parentIndex" />		
	<nested:hidden property="poaDetailId" />
	<nested:hidden property="invoiceNbr" />	
             <table width="275" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000" height="129" >
                  <tr>
                    <td colspan="2" height="19" bgcolor="#73148C" align="center" width="367">
                      <p align="center"><b>
                      <font face="Arial" size="2" color="#FFFFFF"><bean:message key="app.messages.InvoicePaymentBreakout" /></font></b></td>
                  </tr>
                  <tr>
                    <td width="120" height="19" bgcolor="#73148C" align="center">
                    <b><font face="Arial" size="2" color="#FFFFFF"><bean:message key="app.messages.Charge" /></font></b></td>
					<td width="127" height="19" bgcolor="#73148C" align="center">
                    <b><font face="Arial" size="2" color="#FFFFFF"><bean:message key="app.messages.CollectedAmt" /></font></b></td>
                  </tr>
<nested:iterate  property="surcharges" id="sur" type="com.fedex.lacitd.cashcontrol.biztier.common.GenericSurchargeVO" >                  
	<nested:hidden property="paymentId" />
	<nested:hidden property="surchargeCd" />	
	<nested:hidden property="newSurcharge" />
	<nested:hidden property="surchargeDesc" />				  
				  <tr>
						<td width="156" height="25" bgcolor="#FFFF9C" style="margin-right: 3">
							<font style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt; text-align:right">
                        	<div align="right"><font face="Arial" size="2">
                        		<nested:write property="surchargeDesc" />&nbsp;&nbsp;
                          	</font></div>
                          	</font>
                        </td>
						<td width="187" height="25" bgcolor="#FFFF9C">
							<div align="center">
								<nested:text property="collectedAmt" value="<%=formatter.format(sur.getCollectedAmt())%>" onchange="amtChanged();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt; text-align:right" />
							</div>
						</td>
				  </tr>					  
</nested:iterate>                   
                  <tr>
						<td width="156" height="25" bgcolor="#FFFF9C" style="margin-right: 3">
							<font style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt; text-align:right">
                        	<div align="right"><font face="Arial" size="2">
                        		<b>Total&nbsp;&nbsp;</b>
                          	</font></div>
                          	</font>
                        </td>
						<td width="187" height="25" bgcolor="#FFFF9C">
							<div align="center">
								<b><nested:text property="totalCollected" value="<%=formatter.format(frm.getTotalCollected())%>" onfocus="this.blur();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt; text-align:right; background-color: #FFFF9C" />
							</div>
						</td>
				  </tr>		
                  <tr>
                    <td width="515" height="39" bgcolor="#FFFF9C" colspan="2">
                      <p align="center">&nbsp;<input type="button" onclick="save();" value="<bean:message key="app.messages.Done" />" name="B1"></td>
                  </tr>
             </table>
</nested:form>
