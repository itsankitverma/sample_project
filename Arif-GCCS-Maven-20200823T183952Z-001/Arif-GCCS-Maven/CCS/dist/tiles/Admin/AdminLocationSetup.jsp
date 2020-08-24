<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<script language="JavaScript">
    function sendToServer(action) {
        var f = document.forms['AdminLocationForm'];
        f.action.value=action;

        if(action=='getCountryCurrency') {
            document.location.href="AdminCountryCurrency.do?action="+action+"&countryCd="+f.countryCd.value+"&locationCd="+f.locationCd.value;
            return;
        }
        else if(action=='getBankAccounts') {
            document.location.href="AdminBankAccount.do?action=getBankAccount";
            return;
        }

        if(action=='updateLocation' && f.cosmosRefreshInterval.value<5) {
            alert("Refresh interval cannot be minor to 5.")
            return;
        }
        else {
            if(action=='updateLocation' && f.cosmosRefreshInterval.value>60) {
                alert("Refresh interval cannot be greater than 60.")
                return;
            }
        }
        f.submit();
    }

    function checkInCageButton(){
        var f=document.forms['AdminLocationForm'];

        if(f.inCage.checked){
           f.inCageButton.disabled=false;
        }else{
                f.inCageButton.disabled=true;
             }
    }

    function checkRihButton(){
        var f=document.forms['AdminLocationForm'];

        if(f.rih.checked){
           f.rihButton.disabled=false;
        }else{
                f.rihButton.disabled=true;
             }
    }

    function saveTask(typeTask,action){
        var f=document.forms['AdminLocationForm'];

        var w=300;
    	var h=260;
        if(w>screen.width)w=screen.width;
        if(h>screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;
        if(typeTask==1)
            taskId = f.inCageTskIdNumber.value;
        else
            taskId = f.rihTskIdNumber.value;            
	    window.open("<html:rewrite page="/Admin/AdminTasks.do" />?action=" + action + "&locCd=" + f.locationCd.value +"&taskId=" + taskId + "&taskType=" + typeTask, "Location", "scrollbars=no,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=no, menubar=no, resizable=no");
    	return;
    }
</script>
<div align="center">
    <nested:form action="/Admin/AdminLocation.do">
        <input type="hidden" name="action" value="">
        <html:hidden property="countryCd"/>
        <html:hidden property="localDefaultAccount"/>
        <html:hidden property="usdDefaultAccount"/>
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
                        <table bgcolor="#000000" border="0" cellpadding="0" cellspacing="1" style="padding: 4">
                            <tr>
                                <td width="172" bgcolor="#73148C">
                                    <p align="center">
                                        <b><font face="Arial" size="3" color="#FFFFFF">
                                            <bean:message key="app.title.LocationSetupElements"/>
                                        </font></b>
                                </td>
					            <td bgcolor="#73148C">
						            <p align="center"><b><font color="#FFFFFF" face="Arial" size="3">
						  		        <bean:message key="app.tittle.ElementsDetails" /></font></b>
	  				            </td>
                            </tr>
				            <tr>
					            <td bgcolor="#FFFFFF">
					                <font face="Arial" size="2"><b><bean:message key="app.location"/></b>
					                    <bean:define id="locs" name="AdminLocationForm" property="locations"/>
					  		            <nested:select size="1" property="locationCd" onchange="sendToServer('getLocation');">
                                                      <nested:options collection="locs" property="locationCd" labelProperty="locationCd"/>
					  		            </nested:select>
                                    </font>
	 					        </td>
					            <td bgcolor="#FFFFFF" rowspan="2">
					                &nbsp;
					                <div align="center">
					                <table border="0" width="98%" height="100%" bgcolor="#000000" cellspacing="1" cellpadding="0">
						                <tr>
						                    <td bgcolor="#73148C" colspan="3" height="18">
							                    <p align="center"><b><font color="#FFFFFF" face="Arial" size="2">&nbsp;
							                    <bean:message key="app.message.GeneralInformation"/></font></b>
    					                    </td>
					                    </tr>
                						<tr>
				                		    <td width="31%" height="79" rowspan="11" bgcolor="#FFFFFF">
						  	                    <b><font face="Arial" size="2">
						  		                <bean:message key="app.location"/>
							                    </font></b>
                                            </td>
						                    <td width="35%" height="13" bgcolor="#FFFFFF"><font face="Arial" size="2">
						  		                <b><bean:message key="app.Code"/></b></font>
					  		                </td>
						                    <td width="34%" height="13" bgcolor="#FFFFFF">
                    						   	<nested:write property="locationCd"/>
                                            </td>
						                </tr>
						                <tr>
						                    <td bgcolor="#FFFFFF" height="12"><font face="Arial" size="2">
						  		                <b><bean:message key="app.location.parentLocation"/></b></font>
					  		                </td>


                                            <td bgcolor="#FFFFFF" height="12"> <font face="Arial" size="2">
                                                    <bean:define id="parentLocations" name="AdminLocationForm" property="parentLocations"/>
                                                    <nested:notEmpty name="parentLocations">
                                                        <nested:select size="1" property="parentLocationCd">
                                                            <html:option value="NO PARENT">NO PARENT</html:option>
                                                            <nested:options collection="parentLocations" property="locationCd" labelProperty="locationCd"/>
                                                        </nested:select>
                                                    </nested:notEmpty>
                                                    <nested:empty name="parentLocations">
                                                        NO PARENT
                                                    </nested:empty>
							                    </font>
                                            </td>
						                </tr>
						                <tr>
						                    <td bgcolor="#FFFFFF" height="12"><font face="Arial" size="2">
						  		                <b><bean:message key="app.location.VISAActive"/></b></font>
					  		                </td>
						                    <td bgcolor="#FFFFFF" height="12"> <font face="Arial" size="2">
            						  			<nested:select size="1" property="activeLocation">
			    									<html:option value="1">Yes</html:option>
				    								<html:option  value="0">No</html:option>
					                		    </nested:select>
							                    </font>
                                            </td>
						                </tr>
                                        <tr>
						                    <td bgcolor="#FFFFFF" height="12"><font face="Arial" size="2">
						  		                <b><bean:message key="app.location.HoldLocation"/></b></font>
					  		                </td>
					                        <td bgcolor="#FFFFFF" height="12"> <font face="Arial" size="2">
                                                <nested:select size="1" property="holdLocation">
					            					<html:option value="1">Yes</html:option>
								            		<html:option  value="0">No</html:option>
								                </nested:select>
							                    </font>
                                            </td>
						                </tr>
                                        <tr>
						                    <td bgcolor="#FFFFFF" height="12"><font face="Arial" size="2">
						  		                <b><bean:message key="app.location.DualCurrency"/></b></font>
					  		                </td>
						                    <td bgcolor="#FFFFFF" height="12"> <font face="Arial" size="2">
                						  		<nested:select size="1" property="dualCurrencyLocation">
				            						<html:option value="1">Yes</html:option>
							            			<html:option  value="0">No</html:option>
								                </nested:select>
							                    </font>
						                    </td>
                						</tr>
                                     	<tr>
						                    <td bgcolor="#FFFFFF" height="12"><font face="Arial" size="2">
						  		                <b>COSMOS Refresh Enabled</b></font>
					  		                </td>
						                    <td bgcolor="#FFFFFF" height="12"> <font face="Arial" size="2">
            						  			<nested:select size="1" property="cosmosRefreshEnabled">
			        								<html:option value="1">Yes</html:option>
					    							<html:option  value="0">No</html:option>
						            		    </nested:select>
							                    </font>
                                            </td>
						                </tr>
						                <tr>
						                    <td bgcolor="#FFFFFF" height="12"><font face="Arial" size="2">
						  		                <b>COSMOS Refresh Interval (Minutes)</b></font>
					  		                </td>
                                            <td bgcolor="#FFFFFF" height="12"> <font face="Arial" size="2">
            						  			<nested:text size="1" property="cosmosRefreshInterval" />
			                    				</font>
                                            </td>
                						</tr>
                                        <tr>
						                    <td bgcolor="#FFFFFF" height="25"><font face="Arial" size="2">
						  		                <b><bean:message key="app.messages.Name" /></b></font>
					  		                </td>
						                    <td bgcolor="#FFFFFF" height="25"><font face="Arial" size="2">
                    						    <nested:text property="locationNm" size="25" maxlength="25"/> </font>
                                            </td>
                                        </tr>
                                        <tr>
						                    <td bgcolor="#FFFFFF" height="25"><font face="Arial" size="2">
                                                <b><bean:message key="app.message.TimeZone"/></b></font>
                                            </td>
                                            <td bgcolor="#FFFFFF" height="25"><font face="Arial" size="2">
                                                <nested:select size="1" property="locationTmZn">
                                                    <nested:options property="timeZones" />
                                                </nested:select>
                                                </font>
                                           </td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#FFFFFF" height="25"><font face="Arial" size="2">
                                                <b><bean:message key="app.location.InCageExceptions"/></b></font>
                                            </td>
                                            <td bgcolor="#FFFFFF" height="12"> <font face="Arial" size="2">
                                                <nested:equal value="0" property="inCageTskIdNumber">
                                                    <input type="checkbox"  name="inCage" onclick="checkInCageButton();" >
                                                    <input type="button" name="inCageButton" value="In-Cage timer" disabled="false" onclick="saveTask('1','getTasks');" />
                                                </nested:equal>
                                                <nested:notEqual value="0"  property="inCageTskIdNumber">
                                                    <input type="checkbox" name="inCage" onclick="checkInCageButton();" checked>
                                                    <input type="button" name="inCageButton" value="In-Cage timer" onclick="saveTask('1','getTasks');"/>
                                                </nested:notEqual>
							                    </font>
                                                <nested:hidden property="inCageTskIdNumber"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#FFFFFF" height="25"><font face="Arial" size="2">
                                                <b><bean:message key="app.location.rih"/></b></font>
                                            </td>
                                            <td bgcolor="#FFFFFF" height="12"> <font face="Arial" size="2">
                                                <nested:equal value="0" property="rihTskIdNumber">
                                                    <input type="checkbox"  name="rih" onclick="checkRihButton();" >
                                                    <input type="button" name="rihButton" value="RIH timer" disabled="false" onclick="saveTask('2','getTasks');" />
                                                </nested:equal>
                                                <nested:notEqual value="0"  property="rihTskIdNumber">
                                                    <input type="checkbox" name="rih" onclick="checkRihButton();" checked>
                                                    <input type="button" name="rihButton" value="RIH timer" onclick="saveTask('2','getTasks');"/>
                                                </nested:notEqual>
							                    </font>
                                                <nested:hidden property="rihTskIdNumber"/>
                                            </td>
                                        </tr>
                						<tr>
						                    <td bgcolor="#FFFFFF" height="25"><b><font face="Arial" size="2"><bean:message key="app.Prepaid"/></font></b></td>
						                    <td bgcolor="#FFFFFF" height="25"><b><font face="Arial" size="2"><bean:message key="app.prepaid.DelayDays"/></font></b></td>
						                    <td bgcolor="#FFFFFF" height="25"><font face="Arial" size="2">
					  			                <nested:select size="1" property="delayDaysAllowed">
										            <html:option value="0">0</html:option>
										            <html:option value="1">1</html:option>
										            <html:option value="2">2</html:option>
										            <html:option value="3">3</html:option>
										            <html:option value="4">4</html:option>
										            <html:option value="5">5</html:option>
										            <html:option value="6">6</html:option>
										            <html:option value="7">7</html:option>
								                </nested:select></font>
							                </td>
						                </tr>
						                <tr bgcolor="#FFFF9C">
		                                    <td  height="25" colspan="3"> <div align="center">
							  	                <a href="javascript:sendToServer('updateLocation')">
									            <img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language"/>.gif" align="left" width="114" height="38"></a></div>
							                </td>
						                </tr>
					                </table>
					            </div>
	                            <p>&nbsp;</p>
				            </td>
			            </tr>
                        <tr>
				            <td bgcolor="#FFFFFF">
					            <p><b><a href="JavaScript:sendToServer('getLocation')">
                                <font face="Arial" size="2">
                                <bean:message key="app.message.GeneralInformation"/></a>&nbsp;<br>
						        <bean:message key="app.messages.adminLocationSpecific"/></font></b></p>
					            <p><b><a href="JavaScript:sendToServer('getCountryCurrency')">
						        <font face="Arial" size="2">
						        <bean:message key="app.CountryConfig"/></a>&nbsp;<br>
						        <bean:message key="app.messages.adminLocationAllCountry"/></font></b></p>
					            <p><b><a href="JavaScript:sendToServer('getBankAccounts')"/>
						        <font face="Arial" size="2">
						        <bean:message key="app.BankAccount"/></a>&nbsp;<br>
					            <bean:message key="app.messages.adminLocationAllCountry"/></font></b></p>
                                <html:button property="addLocation" onclick="window.open('/GCCS/Admin/AdminLocation.do?action=addLocation','add','dependent=yes,width=500,height=300,titlebar=yes,scrollbars=yes,status=yes')"><bean:message key="app.messages.addLocation"/></html:button>
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