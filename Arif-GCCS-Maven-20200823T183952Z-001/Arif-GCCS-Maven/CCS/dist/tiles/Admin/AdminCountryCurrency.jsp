<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>


<script>
			function sendToServer(action)
			{	var f = document.forms['AdminCountryCurrencyForm'];
				f.action.value	 =action;
				
				if(Number(f.exchRateMin.value)<0 || Number(f.exchRateMax.value)<0){
					alert("The exchange rate cannot be negative.");
					return;
				}else{
					if(Number(f.exchRateMin.value)>Number(f.exchRateMax.value)<0){
						alert("Minimum exchange rate must be less than Maximum exchange rate.");
						return;
					}
				}
				
				if(action=='getLocation')
				{ document.location.href="AdminLocation.do?action=getLocation&locationCd="+f.locationCd.value;
				}else if(action=='getBankAccounts')
				      {  document.location.href="AdminBankAccount.do?action=getBankAccount";
				      	 return;
				      }else{
                       			     f.submit();}
			}
</script>

<html:errors />
<div align="center">
<nested:form action="/Admin/AdminCountryCurrency.do" focus="currencyCd">  
<input type="hidden" name="action" value="">
<html:hidden property="countryCd"/>
<html:hidden property="cntryCurrencyId"/>
<html:hidden property="operation"/>
<html:hidden property="check"/>

	<table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#000000">
	  <tr>
			<td bgcolor="#808080">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080">
				<font face="Arial">
					<img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080"><font face="Arial"><img border="0" src="pixel.gif" width="1"></font></td>
		<td bgcolor="#FFFF9C">
		  <p align="center">&nbsp;</td>
		<td bgcolor="#808080"><img border="0" src="pixel.gif" width="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1"></font></td>
		<td bgcolor="#FFFF9C">
			<div align="center">
			<table bgcolor="#000000" border="0" cellpadding="0" cellspacing="1" style="padding: 4" > 
				<tr>
					<td width="172" bgcolor="#73148C"> 
					  	<p align="center"><b><font face="Arial" size="3" color="#FFFFFF">
							<bean:message key="app.title.LocationSetupElements"/>
						</font></b>
					</td>
					<td width="351" bgcolor="#73148C"> 
						  <p align="center"><b><font color="#FFFFFF" face="Arial" size="3">
						  		<bean:message key="app.tittle.ElementsDetails" /></font></b> 
	  				</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF"> 
					  <font face="Arial" size="2"><b><bean:message key="app.location"/></b>
					  <bean:define id="locs" name="AdminCountryCurrencyForm" property="locations"/>
					  		<nested:select size="1" property="locationCd" onchange="sendToServer('getCountryCurrency');">
									<nested:options collection="locs" property="locationCd" labelProperty="locationCd"/>
					  		</nested:select></font>
	 					</td>
					<td bgcolor="#FFFFFF" rowspan="2"> 
					  &nbsp;
					  <div align="center">
					  <table border="0" width="98%" height="100%" bgcolor="#000000" cellspacing="1" cellpadding="0">
				      <tr>
                      <td bgcolor="#73148C" colspan="3" height="18">
                        <p align="center"><b><font color="#FFFFFF" face="Arial" size="2">
						<bean:message key="app.CountryConfig"/></font></b>
					  </td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" rowspan="5" height="60"><b><bean:message key="app.messages.Currency"/></b></td>
                      <td bgcolor="#FFFFFF" height="13"><font face="Arial" size="2"><b><bean:message key="app.Code"/></b></font></td>
                      <td bgcolor="#FFFFFF" height="13"><nested:text property="currencyCd" size="3" maxlength="3"/> </td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="12"><b><font face="Arial" size="2"><bean:message key="app.messages.Name" /></font></b></td>
                      <td bgcolor="#FFFFFF" height="12"><nested:text property="currencyNm" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25"><b><font face="Arial" size="2"><bean:message key="app.messages.Symbol" /></font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:text property="currencySymbol" size="3" maxlength="3"/> </td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25"><b><font face="Arial" size="2">Min. Exchange Rate</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:text property="exchRateMin" size="8" /> </td>
                    </tr>                    
                    <tr>
                      <td bgcolor="#FFFFFF" height="25"><b><font face="Arial" size="2">Max. Exchange Rate</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:text property="exchRateMax" size="8" /> </td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" rowspan="10" height="60"><b><bean:message key="app.CountryConfig"/></b></td>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate Quick Status</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="quickStatus" >
                      										<html:option value="0">No</html:option>
                      										<html:option value="1">Yes</html:option>                      										
                      									</nested:select>
                      									</td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate DTRC Upload</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="dtrcUpldFlg" >
                      										<html:option value="0">No</html:option>
                      										<html:option value="1">Yes</html:option>
                      									</nested:select>
                      									</td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate Cash In Bank Upload</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="cashUpldFlg" >
                      										<html:option value="0">No</html:option>
                      										<html:option value="1">Yes</html:option>
                      									</nested:select>
                      									</td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate Write Off Upload</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="woffUpldFlg" >
                      										<html:option value="0">No</html:option>
                      										<html:option value="1">Yes</html:option>
                      									</nested:select>
                      									</td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">PS Operator ID</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:text property="psOperId" size="8" /></td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate Ground</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="actGroundFlg" >
                      										<html:option value="0">No</html:option>
                      										<html:option value="1">Yes</html:option>
                      									</nested:select>
                      									</td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate OAC</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="actOACFlg" >
                      										<html:option value="0">No</html:option>
                      										<html:option value="1">Yes</html:option>
                      									</nested:select>
                      									</td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate Collect Later</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="actCollectlaterFlg" >
                      										<html:option value="1">Yes</html:option>
                      										<html:option value="0">No</html:option>
                      									</nested:select>
                      									</td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate COD</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="actCODFlg" >
                      										<html:option value="0">No</html:option>
                      										<html:option value="1">Yes</html:option>
                      									</nested:select>
                      									</td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">Activate FTC</font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:select property="actFTCFlg" >
                      										<html:option value="0">No</html:option>
                      										<html:option value="1">Yes</html:option>
                      									</nested:select>
                      									</td>
                    </tr>                    
                    <tr>
                      <td bgcolor="#FFFFFF" rowspan="2" height="60"><b>Decimals in Scans</b></td>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">USD Amts </font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:text property="scanUsdDecimals" size="8" /></td>
                    </tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" ><b><font face="Arial" size="2">LOCAL Amts </font></b></td>
                      <td bgcolor="#FFFFFF" height="25"><nested:text property="scanLocalDecimals" size="8" /></td>
                    </tr>



  <center>
                  	<tr bgcolor="#FFFF9C">
		                      <td  height="25" colspan="3"> <div align="center">
							  	<a href="javascript:sendToServer('updateCountryCurrency')">
									<img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language"/>.gif" align="left" width="114" height="38"></a></div>
							  </td>
					</tr>
                    <tr>
                      <td bgcolor="#FFFFFF" height="25" colspan="3">
                        <p align="center"><b><font face="Arial" size="2" color="#FF0000">
							<bean:message key="app.Warning"/>
						</font></b>
						<font size="2"><br>
                          <bean:message key="app.messages.currencyWarning"/>
						</font></td>
                    </tr>
  
					</table>
					  </div>
	<p>&nbsp;</p>  
				  </td>
			</tr>
				<tr>
					<td bgcolor="#FFFFFF"> 
					  <p><b><font face="Arial" size="2">
					  		<a href="javascript:sendToServer('getLocation')">
					  		<bean:message key="app.message.GeneralInformation"/></a> 
							&nbsp;<br>
							<bean:message key="app.messages.adminLocationSpecific"/></font></b></p>
					  <p><b><font face="Arial" size="2">
					  		<a href="javascript:sendToServer('getCountryCurrency')">
					  		<bean:message key="app.CountryConfig"/></a>
							&nbsp;<br>
							<bean:message key="app.messages.adminLocationAllCountry"/></font></b></p>
					  <p><b><font face="Arial" size="2">
					  		<a href="JavaScript:sendToServer('getBankAccounts')">
					  		<bean:message key="app.BankAccount"/></a>
							&nbsp;<br>
							<bean:message key="app.messages.adminLocationAllCountry"/></font></b></p>
	 				</td>
			</tr>
			</table>
			</div>
		 </td>
		<td bgcolor="#808080"><img border="0" src="pixel.gif" width="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080"><font face="Arial"><img border="0" src="pixel.gif" width="1"></font></td>
		<td bgcolor="#FFFF9C">&nbsp;</td>
		<td bgcolor="#808080"><img border="0" src="pixel.gif" width="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	</table>
</nested:form>	
</div>
<p>&nbsp;</p>
