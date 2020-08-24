<%@page import="java.util.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<% com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile ep=(com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile)request.getSession().getAttribute("userProfile");
   boolean adminOrNot = ep.isAdmin();
%>

<script language="JavaScript">
	//Variable to check if is admin the current user, in order to control the delete bank action.
	var admin = <%=adminOrNot%>;
	
	function sendToServer(action, arg1, arg2)
	{  var f 			= document.AdminBankAccountForm;
	   var country     = f.country.options[f.country.selectedIndex].value;
	   f.action.value  = action;
	   
	   if(country=="FF")
	   {  alert("<bean:message key="app.js.messages.EnterCountry"/>");	
	   	  return;
	   }else{	
                if(action == "deleteAccount"){
	               f.accountCd.value=arg1;
                }else if(action == "deleteBank"){ 
                		 //Check that the action was triggered by an Administrator
                		 if(admin==false)
                		 {  alert("<bean:message key="app.messages.js.DeleteBankOnlyAdmin"/>");
                		 	return;}
                		 if(!confirm("<bean:message key="app.messages.js.WantDeleteBank"/>"))
                		 	 return;
                		 	 	
						 f.bankMod.value=arg1;
                		}else if(action == "addBank" || action == "modBank")
			                 {  var w=530;
			                    var h=400;
            			        if(w>screen.width)w=screen.width;
			                    if(h>screen.height)h=screen.height;
            			        var leftpos=(screen.width-w) / 2;
			                    var toppos=(screen.height-h) / 2;
            			        window.open("<html:rewrite page="/Admin/AdminBank.do" />?action=" + action + "&countrySelected=" + country + "&bankId=" + arg1,"Bank", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes");
			                    return;
            			     }else if(action == "addAccount" || action=="modAccount")
        	               			{  f.accountCd.value=arg1;  
		    	                   	  f.bankMod.value=arg2;}	  
			f.submit();
		}	
	}//Close sendToServer function

</script>

<html:errors />
<br>
<br>

<nested:form action="/Admin/AdminBankAccount.do">
<input type="hidden" name="action">
<input type="hidden" name="bankMod">
<nested:hidden property="accountCd"/>
<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tbody>
    <tr> 
      <td width="30%" align=middle bgcolor="#73148c"> <font face=arial color="#ffffff" size="+1"><b><bean:message key="app.messages.BankAccountList" /></b></font> 
      </td>
      <td width="15%" align=middle bgcolor="#73148c"> <font face=arial color="#ffffff"><b><bean:message key="app.country" /></b></font> 
      </td>
      <td width="15%" align=middle bgcolor="#73148c"> <font face=arial color="#ffffff"><b><bean:message key="app.bank" /></b></font> 
      </td>
      <td width="15%" align=middle bgcolor="#73148c"> <font face=arial color="#ffffff"><b><bean:message key="app.location" /></b></font> 
      </td>
      <td width="25%" align=middle bgcolor="#73148c"> <font face=arial color="#ffffff">&nbsp;</font>	
      </td>
    </tr>
    <tr> 
      <td width="30%" align=middle bgcolor="#73148c">&nbsp;</td>
    <!-- Column to show the country select object -->
      <td width="15%" align=middle bgcolor="#73148c"> <font face=arial color="#ffffff" size="1"><b> 
        <nested:select property="country" onchange="javascript:sendToServer('selectBanks','','')"> 
        <logic:present name="countries" scope="session"> <html:options collection="countries" property="countryCd" name="countries" labelProperty="countryNm"/> 
        </logic:present> </nested:select> </b></font> </td>
    <!-- Column to show the bank select object -->        
      <td width="15%" align=middle bgcolor="#73148c"> <font face=arial color="#ffffff" size="1"><b> 
        <nested:select property="bank"> 
        <option value="0" ><bean:message key="app.all"/></option>
        <logic:present name="AdminBankAccountForm" property="banks" scope="request"> 
        <html:optionsCollection name="AdminBankAccountForm" property="banks" label="bankNm" value="bankId"/> 
        </logic:present> </nested:select> </b></font> </td>
    <!-- Column to show the location select object -->        
      <td width="15%" align=middle bgcolor="#73148c"> <font face=arial color="#ffffff" size="1"><b> 
        <nested:select property="location"> 
        <option value="all" ><bean:message key="app.all"/></option>
        <html:optionsCollection name="AdminBankAccountForm" property="locations" label="locationCd" value="locationCd"/> 
        </nested:select> </b></font> </td>
      <td width="25%" align=middle bgcolor="#73148c"> <html:button property="showAccounts" onclick="JavaScript:sendToServer('showAccounts')"><bean:message key='app.messages.showAccount'/></html:button> 
      </td>
    </tr>
    <tr> 
      <td width="30%" align="center" bgcolor="#73148c">
        <html:button property="addBank" onclick="JavaScript:sendToServer('addBank', '')"><bean:message key="app.messages.addBank" /></html:button> 
        <html:button property="addAccount" onclick="JavaScript:sendToServer('addAccount', '')"><bean:message key="app.messages.addAccount" /></html:button>
      </td>
      <td width="70%" colspan="4" bgcolor="#73148c">&nbsp;</td>
    </tr>
    <!-- Now the data of banks ant accounts are diplayed in teh following table -->
    <!-- Show the account information only if exist BankAccounts Collection -->
    <nested:notEmpty name="AdminBankAccountForm" property="bankAccounts" scope="request">
    	<tr bordercolor="#FFFF9C" bgcolor="#FFFF9C" align="center"> 
      		<td width="100%" colspan="5"><p align="center">&nbsp;</td></tr>
    	<tr bordercolor="#FFFF9C" bgcolor="#FFFF9C" align="center">
			<td colspan="5">
        		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000">
				  <nested:iterate id="bankElement" name="AdminBankAccountForm" property="bankAccounts">
				     <tr>
				        <td width="20%"  height="100%" align="center" valign="middle" bgcolor="#FFFFCC"> 
			              <a href="JavaScript:sendToServer('deleteBank',<nested:write property='bank.bankId'/>,'')"><img border="0" alt="<bean:message key="app.messages.Delete"/>" src="<html:rewrite page="/images/delete.gif"/>" align="left" valign="middle"></a> 
			              <a href="JavaScript:sendToServer('modBank',<nested:write property='bank.bankId'/>,'')"><nested:write name="bankElement" property="bank.bankNm"/></a> 
            			</td>
 		  				<nested:empty name="bankElement" property="bankAccount">
 						<td width="80%">
	        		  		<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="1">
		  						<tr>
		    		  				<td width="30%" height="100%" align="center" valign="middle" bgcolor="#FFFFFF">
			    		  				 <font face="Arial" size="1">&nbsp;</font>
						  			</td>	
									<td width="80%" height="100%" align="left" valign="middle" bgcolor="#FFFFFF">
							  			<font face="Arial" size="1">&nbsp;</font>
								  	</td>
    							</tr>
    						</table>	
        		  		</td>       		  					
	  					</nested:empty>
       		  			<nested:notEmpty name="bankElement" property="bankAccount">
        		  		<td width="80%">
	        		  			<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="1">
          					      <nested:present name="bankElement" property="bankAccount"> <nested:empty name="bankElement" property="bankAccount"> 
					                <tr> 
            					      <td width="20%" height="100%" align="center" valign="middle" bgcolor="#FFFFFF">&nbsp; 
					                  </td>
					                  <td width="80%" height="100%" align="left" valign="middle" bgcolor="#FFFFFF">&nbsp; 
					                  </td>
					                </tr>
				                </nested:empty> <nested:notEmpty name="bankElement" property="bankAccount"> 
                		<nested:iterate id="accounts" name="bankElement" property="bankAccount" indexId="idx"> 
                		<%  String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");%>
				                <tr> 
                				  <td width="30%" height="100%" align="center" valign="middle" bgcolor="<%=bgColor%>"> 
				                    <a href="JavaScript:sendToServer('deleteAccount',<nested:write property='bankAccountCd'/>,'')"><img border="0"  height="7" width="7" alt="<bean:message key="app.messages.Delete"/>"  src="<html:rewrite page="/images/delete.gif"/>" align="left" valign="middle"></a>
				                    <a href="JavaScript:sendToServer('modAccount', <nested:write property='bankAccountCd'/>,<nested:write name='bankElement' property='bank.bankId'/>)"> 
				                    <nested:write  name="accounts"  property="accountNbr"/></a> 
                				    <bean:define id="accountCd" name="accounts" property="bankAccountCd"/> 
				                  </td>
                				  <td width="70%" height="100%" align="left" valign="middle" bgcolor="<%=bgColor%>"> 
				                    <div align="justify">
				                    	<bean:define id="hashLocations" name="bankElement" property="accountLocations" type="java.util.HashMap"></bean:define> 
                				        <font face="Arial" size="1"><%= hashLocations.get(accountCd)!=null?(String)hashLocations.get(accountCd):""%></font> </div></td>
				                </tr>
                		</nested:iterate>
                		</nested:notEmpty>
                		</nested:present> </table>	        				  		
        		  		</td>
		        	 </nested:notEmpty>	
	        		 </tr>
				  </nested:iterate>
		        </table>
       		</td>
    	</tr>
    	<tr bordercolor="#FFFF9C" bgcolor="#FFFF9C">
		   	<td colspan="5" width="100%"> <p align="center">&nbsp;
	   </tr>	   
   </nested:notEmpty>
  <tbody>
</table>
 </nested:form>



