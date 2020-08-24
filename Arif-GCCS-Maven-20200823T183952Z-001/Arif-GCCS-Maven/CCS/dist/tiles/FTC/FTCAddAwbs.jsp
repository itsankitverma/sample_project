<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.prestier.helper.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<% 
   String elementFocus=null;
   if("deleteAWB".equals(request.getParameter("action")) || "addAWB".equals(request.getParameter("action"))){
       elementFocus="awbsList[0].recAwbNumber";
   }else{
           elementFocus="currentCurrency";
        }
 
    EmployeeProfile ep=(EmployeeProfile)session.getAttribute("userProfile");  
 
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>

<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>

	function setRecAmount()
	{	var ftcAmountValue;
		var ansChargeValue;
		var frm;
		frm = document.forms['FTCAddAwbsForm'];
		
		ftcAmountValue = frm.elements['awbsList[0].ftcAmt'].value;
		ansChargeValue = frm.elements['awbsList[0].ancChargeAmt'].value;

		if(isNaN((ftcAmountValue - 0) + (ansChargeValue - 0)))
		{	frm.elements['awbsList[0].recAmount'].value = "<%= formatter.format(0)%>";
		}else
			{ frm.elements['awbsList[0].recAmount'].value = (ftcAmountValue - 0) + (ansChargeValue - 0);}
			
		return;
	}
    
	function addAwbs(){
        var form=document.forms['FTCAddAwbsForm']; 
        var msg=validateAddAwb();

          if(msg==""){
                    form.elements['action'].value='addAWB';
                    form.submit();
                }else{
                    alert(msg);
                }
    }

    function validateAddAwb(){
        var form=document.forms['FTCAddAwbsForm'];

        if(form.elements['awbsList[0].recAwbNumber'].value=="")
	{  return "<bean:message key="app.messages.js.MustEnterAwbNumber" />";}

	if(!(validaAWBNbr(form.elements['awbsList[0].recAwbNumber'].value)))
	{  return "<bean:message key="errors.messages.js.AwbInvalid"/>";}

        if(isNaN(Number(form.elements['awbsList[0].ftcAmt'].value)) || Number(form.elements['awbsList[0].ftcAmt'].value)<0)
		{ form.elements['awbsList[0].ftcAmt'].focus();
		  return "<bean:message key="app.messages.js.BadFTCAmt"/>";	   
		}

        if(isNaN(Number(form.elements['awbsList[0].ancChargeAmt'].value)) || Number(form.elements['awbsList[0].ancChargeAmt'].value)<0)
		{	form.elements['awbsList[0].ancChargeAmt'].focus();
			return "<bean:message key="app.messages.js.BadAncChargeAmt"/>";
		}
		
		return "";
/*        if((isNaN(Number(form.elements['awbsList[0].recAmount']).value)) || Number(form.elements['awbsList[0].recAmount'].value)<0)
		{   return "<bean:message key="app.messages.js.BadMonto" />";}
	*/	
    }
	
    function closeWindow(){
        if(confirm('<bean:message key="app.messages.js.CloseSave" />')){
            saveAwbs();
        }else{
            window.close();
        }
    }

    function saveAwbs(){
        var form=document.forms['FTCAddAwbsForm']; 
        var msg=validateAwbs();
		
        if(msg==""){
		    form.elements['action'].value='saveAwbs';
            form.submit();
        }else{
            alert(msg);
        }
    }

    function validateAwbs(){
        var form=document.forms['FTCAddAwbsForm'];
        var msg="";

		if((form.elements['currentCurrency'].value).length == 0)
		{  msg=msg+"-<bean:message key="app.messages.js.MustSelectCurrency" />\n";}
		
		if(form.elements['currentCurrency'].selectedIndex>0){
           var error=0;
           var errorUsd		= <bean:write name="userProfile" property="errorThresholdUsd" />;
           var errorLocal	= <bean:write name="userProfile" property="errorThresholdLocal" />;

           if(form.elements['currentCurrency'].options[form.elements['currentCurrency'].selectedIndex].value=="USD"){
                error=errorUsd;
           }else{
                error=errorLocal;
           }
        }

        if(form.elements['exchRate'].value <=0 || isNaN(form.elements['exchRate'].value)){
            msg=msg+"-<bean:message key="app.messages.js.ValidExchRate" />\n";
        }

        if(form.elements['totalAmount'].value<=0){
            msg=msg+"-<bean:message key="app.messages.js.MustEnterAtLeastOneAwb" />\n";
        }

        if(msg!=""){
             return "<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;
        }else{
             return "";
        }
    }

    function deleteAwb(idx){
        var form=document.forms['FTCAddAwbsForm'];
        form.elements['action'].value='deleteAwb';
        form.elements['delIndex'].value=idx;
        form.submit();
        
    }

    function handlePress(e,obj) {    
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            obj.focus();
      }
    }

    function handlePressLink(e,name) {    
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            for(i=0;i<document.links.length;i++){
                if(document.links[i].name==name){
                    document.links[i].focus();
                    break;
                }
            }            
      }
    }
</script>

<nested:form action="/FTC/FTCAddAwbs.do" focus="<%=elementFocus%>" >

<bean:define id="frm" name="FTCAddAwbsForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.FTCAddAwbsForm"/>

    <nested:hidden property="totalAmount" />
    <input type="hidden" name="action" value="">
    <input type="hidden" name="delIndex" value="">

<table width="102%" align="center" >
	  <tr>
      	<td align="center">
		  <table border="0" width="100%" cellspacing="0"  cellpadding="0" align="center" bgcolor="#808080">
		  <tr>
            <td  width="96" bgcolor="#808080" height="2"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
            <td  width="789" bgcolor="#808080" height="2"><img src="<html:rewrite page="/images/spacer.gif" />" height="1"></td>
            <td  width="84" bgcolor="#808080" height="2"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
		  </tr>
                  <tr> 
                        <td bgcolor="#73148C" colspan="3" align="center"><b><font color="#FFFFFF" face="Arial" size="3">
                           <bean:message key="app.AddFTCAwbs" />
                        </font></b></td>
                  </tr>
                  <tr>
                        <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
                        <td bgcolor="#FFFF9C">&nbsp; </td>
                        <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
                  </tr>
		  <tr>
		   <td  width="90" bgcolor="#808080" >
		   <td  width="100%" bgcolor="#FFFF9C" align="center"> 
                <table width="257" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000">
                  <tr width="100">
                    <td height="26" width="40%" bgcolor="#C0C0C0" ><div align="center"><font face="Arial" size="1"><bean:message key="app.messages.Currency" /></font></div></td>
                    <td height="26" width="60%"  align="left" bgcolor="#FFFFFF" > <nested:select property="currentCurrency" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" >
                      <option value="">Select</option>
                      <html:optionsCollection name="userProfile" property="supportedCurrencies" label="currencyCode" value="currencyCode" /> </nested:select> </td>
                  </tr>
                  <tr>
                    <td height="26" width="40%" bgcolor="#C0C0C0"><div align="center"><font face="Arial" size="1"><bean:message key="app.messages.ExchangeRate" /></font></div></td>
                    <td height="26" width="60%" align="left" bgcolor="#FFFFFF" ><font face="Arial" size="1"><nested:text property="exchRate" value="<%=formatter.format(frm.getExchRate())%>"/></font></td>
                  </tr>
                </table>
                <hr>
                <table width="257" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000" >
                  <tr with="100">
                    <td height="26" width="40%" bgcolor="#C0C0C0" align="center">
                        <html:checkbox property="cosmosScansEnabled"/>
                        <font face="Arial" size="1"><b><bean:message key="app.messages.cosmosScansEnabled" /></b></font></td>
                  </tr>
             </table>
             <hr>
             <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000" >
                  <tr>
                    <td colspan="5" height="14" bgcolor="#73148C" align="center">
                      <p align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.AwbsReceived" /></b></font></td>
                  </tr>
                  <tr>
                    <td width="17%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.AWBNumber" /></b></font></td>
                    <td width="17%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.ftcAmount" /></b></font></td>
					<td width="17%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.ancillaryChargeAmount" /></b></font></td>
					<td width="17%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.Amount" /></b></font></td>
                    <td width="32%" height="12" bgcolor="#73148C" align="center"><font face="Arial" size="1" color="#FFFFFF"><b><bean:message key="app.messages.Action" /></b></font></td>
                  </tr>
				  
                  <nested:iterate property="awbsList" id="awbsList" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.FTC_RecChangesFromScans">
				  <nested:equal name="idx" value="0">
					  <tr>
						<% FTC_RecChangesFromScans sc= (FTC_RecChangesFromScans)(frm.getAwbsList().get(0));%>
						<td width="17%" height="23" bgcolor="#FFFF9C"><div align="center"><nested:text property="recAwbNumber" onkeypress="handlePress(event,document.forms['FTCAddAwbsForm'].elements['awbsList[0].awbNumber'])" size="12" value="" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt"/></div></td>
						<td width="17%" height="23" bgcolor="#FFFF9C"><div align="center"><nested:text property="ftcAmt" value="<%= formatter.format(sc.getFtcAmt())%>" onblur="JavaScript:setRecAmount()" onkeypress="handlePress(event,document.forms['FTCAddAwbsForm'].elements['awbsList[0].ftcAmt'])" size="12" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt"/></div></td>
						<td width="17%" height="23" bgcolor="#FFFF9C"><div align="center"><nested:text property="ancChargeAmt" value="<%= formatter.format(sc.getAncChargeAmt())%>" onblur="JavaScript:setRecAmount()" onkeypress="handlePress(event,document.forms['FTCAddAwbsForm'].elements['awbsList[0].ancChargeAmt'])" size="12" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt"/></div></td>
						<td width="17%" height="23" bgcolor="#FFFF9C"><div align="center"><nested:text property="recAmount" value="<%= formatter.format(sc.getRecAmount())%>" size="12" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur()"/></div></td>
						<td width="32%" height="23" bgcolor="#FFFF9C"><div align="center"><a  name="addAwbsLink" href="javascript:addAwbs();" ><img name="addInvoiceImg" border="0" src="<html:rewrite page="/images/Add" /><bean:message key="app.Language" />.gif" width="105" height="38"></a></div></td>
					  </tr>
                  </nested:equal>
				  <nested:notEqual name="idx" value="0">
                  <tr>

                    <td width="17%" height="18" bgcolor="#FFFF9C" align="right"><font face="Arial" size=1><nested:write property="recAwbNumber" /><nested:hidden property="recAwbNumber" /></font></td>
                    <td width="17%" height="18" bgcolor="#FFFF9C" align="right"><font face="Arial" size="1"><nested:write property="ftcAmt" formatKey="app.format.NumberFormat"/><nested:hidden property="ftcAmt" /></font></td>
                    <td width="17%" height="18" bgcolor="#FFFF9C" align="right"><font face="Arial" size="1"><nested:write property="ancChargeAmt" formatKey="app.format.NumberFormat"/><nested:hidden property="ancChargeAmt" /></font></td>
                    <td width="17%" height="18" bgcolor="#FFFF9C" align="right"><font face="Arial" size="1"><nested:write property="recAmount" formatKey="app.format.NumberFormat"/><nested:hidden property="recAmount" /></font></td>
                    <td width="32%" height="18" bgcolor="#FFFF9C">
                      		<p align="center"><a href="javascript:deleteAwb(<%=idx%>)"><font face="Arial" size="1"><bean:message key="app.messages.Delete" /></font></a></p>
                    </td>
                  </tr>
                  </nested:notEqual></nested:iterate>
                  <tr>
                    <td width="17%" height="18" bgcolor="#FFFF9C">
                      <p align="right"><font face="Arial" size="1"><b>Total</b></font></td>
                    <td width="17%" height="18" bgcolor="#FFFF9C">&nbsp; </td>
                    <td width="17%" height="18" bgcolor="#FFFF9C">&nbsp; </td>
                    <td width="17%" height="18" bgcolor="#FFFF9C">
                      <p align="right"><font face="Arial" size="1"><nested:write property="totalAmount" formatKey="app.format.NumberFormat" /></font></td>
                    <td width="32%" height="18" bgcolor="#FFFF9C">&nbsp; </td>
                  </tr>

             </table>
	</td>
	</tr>


                <tr>
                  <td  width="96" bgcolor="#808080" height="19"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
                  <td bgcolor="#FFFF9C" height="19" colspan="3">
                <p align="center"><html:link href="javascript:saveAwbs();" ><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link><html:link href="javascript:closeWindow();" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38"></html:link></p>            
                  </td>
                  <td  width="84" bgcolor="#808080" height="19"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
                </tr>
                <tr>
                        <td  width="96" bgcolor="#808080" height="5"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
                        <td  width="789" bgcolor="#808080" colspan="3" height="5"><img src="<html:rewrite page="/images/spacer.gif" />" height="1"></td>
                        <td  width="84" bgcolor="#808080" height="5"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
                </tr>


  </table>
   </td>
    </tr>
	<tr>
		<td colspan="3" >
			<font size="2">
			<html:errors />
			</font>
		</td>		
	</tr>
</table>
</p>
</nested:form>