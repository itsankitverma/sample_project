<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<bean:define id="userProfile" name="userProfile" scope="session" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />

<%-- TODO: Please when the forms be in the request scope you have to remove this ugly code --%>
<%
    session.removeAttribute("RODCourierCashRecapForm");
    session.removeAttribute("PRPCourierCashRecapForm");
    session.removeAttribute("PoaSummaryForm");
    session.removeAttribute("GroundCashRecapForm");
    session.removeAttribute("CourierCashRecapForm");
    session.removeAttribute("FTCCourierCashRecapForm");

%>
<%--TODO: Until here--%>
<%
if(userProfile!=null){
   String role="";
   

	   		if(userProfile.isAdmin() || userProfile.isCountryAdmin()){
    			role="Administrator";
		    }else if(userProfile.isFinController()){
		    	role = "Finance Controller";
			    }else if(userProfile.getEmployeeRole().get("Research")!=null){
	           			role="Research";
			          }else if(userProfile.getEmployeeRole().get("Operation Manager")!=null){
	        	        	   role="Operation Manager";
	            			}else{
				                	if(userProfile.getEmployeeRole().get("Check-In Agent")!=null){
	            			           role="Check-In Agent";
	                				}
	           					}
 
   pageContext.setAttribute("role",role);
}else{
   pageContext.setAttribute("role","");
}
%>

<script language="JavaScript1.2">
<!--
// (C) 2000 www.CodeLifter.com
// http://www.codelifter.com
// Free for all users, but leave in this header

offMessage = "<bean:message key="app.messages.MenuWelcome" />"

function boxOn(which,message){
   if (document.all||document.getElementById){
      which.className='BorderOn'
      if (document.getElementById) {document.getElementById("Message").innerHTML = message}
         else {Message.innerHTML = message}
   }else{
      which.className='BorderOn'
      document.layers['myILayer'].document.layers['myLayer'].document.open()
      document.layers['myILayer'].document.layers['myLayer'].document.write("<font id='Message' color='#73148C' size='2' face='Arial'>"+message+"</font>");
      document.layers['myILayer'].document.layers['myLayer'].document.close();
   }      
}

function boxOff(which){
   if (document.all||document.getElementById){
      which.className='BorderOff'
      if (document.getElementById) {document.getElementById("Message").innerHTML = offMessage}
         else {Message.innerHTML = offMessage}
   }else{
      which.className='BorderOff'
      document.layers['myILayer'].document.layers['myLayer'].document.open()
      document.layers['myILayer'].document.layers['myLayer'].document.write("<font id='Message' color='#73148C' size='2' face='Arial'>"+offMessage+"</font>");
      document.layers['myILayer'].document.layers['myLayer'].document.close();
   }  
}

function addRODAwbs(){
   var w=800;
   var h=550;
   if(w>screen.width)w=screen.width;

   if(h>screen.height)h=screen.height;
     var leftpos=(screen.width-w) / 2;
     var toppos=(screen.height-h) / 2;

     window.open("<html:rewrite page="/ROD/RODAddAwbs.do" />", "addAwbsWindow", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes");
}

function addCODAwbs(){
	   var w=800;
	   var h=550;
	   if(w>screen.width)w=screen.width;

	   if(h>screen.height)h=screen.height;
	     var leftpos=(screen.width-w) / 2;
	     var toppos=(screen.height-h) / 2;

	     window.open("<html:rewrite page="/COD/CODAddAwbs.do" />", "addAwbsWindow", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes");
	}

function addFTCAwbs(){
	   var w=800;
	   var h=550;
	   if(w>screen.width)w=screen.width;

	   if(h>screen.height)h=screen.height;
	     var leftpos=(screen.width-w) / 2;
	     var toppos=(screen.height-h) / 2;

	     window.open("<html:rewrite page="/FTC/FTCAddAwbs.do" />", "addAwbsWindow", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes");
	}
//-->
</script>
<html:errors/>
    <logic:equal name="role" value="Check-In Agent">
<!-- BEGINNING OF MENU //-->
<!-- Outer Container Table //-->
<!-- Set this table width to largest margin-left + largest width in <style> script //-->
<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	<td align="center"> 
		
		<!-- Header Table // -->
			<table cellpadding="3" cellspacing="0" bgcolor="#73148C" class="BorderOff">
			  <tr>
			    <td><p align="center"><font color="#FFFFFF" size="2" face="Arial"><b><bean:message key="app.checkinAgentMenu" /></b></font></p></td>
			  </tr>
			</table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5" border="0"><br>
		<!-- End Header Table //-->
		<!-- Menu Items Tables
		   - To add more, just follow the pattern
		   - Note class= in each <a href> to attach link style colors
		//-->

		<!-- Tabla de item de menu 1 //-->
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.receiveValidateMessage" />')" onMouseout="boxOff(this)">
		  <tr>
		   <td><font color="#73148C" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ShowChkAgtCashRecap.do"  />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.receiveValidateMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.receiveValidate" /></a></font></td>
		  </tr>
		</table>  
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<!-- Tabla de item de menu 2 //-->
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.operationalReportingMessage" />')" onMouseout="boxOff(this)">
          <tr>
            <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/CreateReports.do?action=select" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.operationalReportingMessage" /></a></font></td>
          </tr>
        </table>
   		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.GCCSReportingMessage" />')" onMouseout="boxOff(this)" >
          <tr>
            <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/GCCSReport.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.GCCSReportingMessage" /></a></font ></td>
          </tr>
        </table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<!-- Tabla de item de menu 3 //-->
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="if(!document.all) boxOff(this)"  href="<html:rewrite page="/ROD/ProcessScansPage.do" />" target="_top"><bean:message key="app.processCosmosScans" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 4 //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.RODFileImportStatusMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/ViewRodFileImportingStatus.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.RODFileImportStatusMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.RODFileImportStatus" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 6 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.ExternalFilesImportStatusMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Import/ViewExternalFilesImportingStatus.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.ExternalFilesImportStatusMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.ExternalFilesImportStatus" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 5 //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddRODAwbsMessage" />')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addRODAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddRODAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddRODAwbs" /></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>

<logic:equal name="userProfile" property="codUsedFlag" value="true" >		
		<!-- Tabla de item de menu 7 //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddCODAwbsMessage" />')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addCODAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddCODAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddCODAwbs" /></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
</logic:equal>

<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >		
		<!-- Tabla de item de menu 7 //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddFTCAwbsMessage" />')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addFTCAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddCODAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddFTCAwbs" /></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
</logic:equal>

<!--This link is provisory until locations hierarchy is implemented -->
<logic:equal name="userProfile" property="countryCd" value='AU'>
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'Move to SYDX')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="if(!document.all) boxOff(this)"  href="<html:rewrite page="/pages/MoveToSYDX.jsp" />" target="_top">Move to SYDX</a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 4 //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
</logic:equal>

		<!-- End Menu Items Tables //-->
		<!-- Message Table //-->
		<!-- Set the width= of this table the same as the overall
		     width in the <style> //-->
		<table cellpadding="1" cellspacing="0" bgcolor="#444444" width="310">
			<tr>
				<td>
				<!-- Set the width= of this table to the overall width
			     in the style table minus 2x the border width; set
			     the height= long (large) enough to accommodate your
			     longest message //-->
				<table cellpadding="3" cellspacing="0" bgcolor="#FFFF9C" width="306" height="50" align="center">
			  	<tr>
			  	  <td align="left" valign="top" bgcolor="#FFFFFF">
                                        <font id="Message" color="#73148C" size="2" face="Arial">
                                            <ilayer  id="myILayer" width="306" height="50">
                                                <layer id=myLayer width="306" height="50">
                                                  <bean:message key="app.messages.MenuWelcome" />
                                                </layer>
                                            </ilayer>
                                        </font>
                                 </td>
				  </tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- End Message Table //-->
	</td>
	<td><img border="0" src="<html:rewrite page="/images/globalhome_background.jpg" />"></td>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
</table>
<!-- End Outer Container Table //--><!-- END OF MENU //-->
</logic:equal>
<logic:equal name="role" value="Operation Manager">
<!-- BEGINNING OF MENU //-->
<!-- Outer Container Table //-->
<!-- Set this table width to largest margin-left + largest width in <style> script //-->
<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	<td align="center"> 
		
		<!-- Header Table // -->
			<table cellpadding="3" cellspacing="0" bgcolor="#73148C" class="BorderOff">
			  <tr>
			    <td><p align="center"><font color="#FFFFFF" size="2" face="Arial"><b><bean:message key="app.opsManagerMenu" /></b></font></p></td>
			  </tr>
			</table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5"><br>
		<!-- End Header Table //-->
		<!-- Menu Items Tables
		   - To add more, just follow the pattern
		   - Note class= in each <a href> to attach link style colors
		//-->

		<!-- Tabla de item de menu 1 //>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.receiveValidateMessage" />')" onMouseout="boxOff(this)">
		  <tr>
		   <td><font color="#73148C" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ShowChkAgtCashRecap.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.receiveValidateMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.receiveValidate" /></a></font></td>
		  </tr>
		</table>  
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br  -->
        <!-- Tabla de item de menu 2 //-->
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.operationalReportingMessage" />')" onMouseout="boxOff(this)">
          <tr>
            <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/CreateReports.do?action=select" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.operationalReportingMessage" /></a></font></td>
          </tr>
        </table>
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
        <!-- Tabla de item de menu 3 //-->
	    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.GCCSReportingMessage" />')" onMouseout="boxOff(this)" >
          <tr >
            <td ><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/GCCSReport.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.GCCSReportingMessage" /></a></font></td>
          </tr >
        </table >
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<!-- Tabla de item de menu 3 //-->
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/ProcessScansPage.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.processCosmosScans" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 4 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.RODFileImportStatusMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/ViewRodFileImportingStatus.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.RODFileImportStatusMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.RODFileImportStatus" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 7 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.ExternalFilesImportStatusMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Import/ViewExternalFilesImportingStatus.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.ExternalFilesImportStatusMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.ExternalFilesImportStatus" /></a></font></td>
		  </tr>
		</table>

		<!-- Tabla de item de menu 5 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.openDepositSlipMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/DepositSlipGeneration.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.openDepositSlipMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.openDepositSlip" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 5 //>
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.openCreditCardMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/CreditCardPymt.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.openCreditCardMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.openCreditCard" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 5 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.messages.PrepaidDiscrepancies" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Prepaid/Discrepancies.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.messages.PrepaidDiscrepanciesMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.messages.PrepaidDiscrepancies" /></a></font></td>
		  </tr>
		</table>
        <!-- Tabla de item de menu 6 //>
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddRODAwbsMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addRODAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddRODAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddRODAwbs" /></a></font></td>
		  </tr>
		</table -->
<logic:equal name="userProfile" property="codUsedFlag" value="true" >	
        <!-- Tabla de item de menu 7 //>
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddCODAwbsMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addCODAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddCODAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddCODAwbs" /></a></font></td>
		  </tr>
		</table -->
</logic:equal>

<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >	
        <!-- Tabla de item de menu 7 //>
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddFTCAwbsMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addFTCAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddFTCAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddFTCAwbs" /></a></font></td>
		  </tr>
		</table -->
</logic:equal>

		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<!-- Tabla de item de menu 1 //-->
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.AdminUserListByCountry" />')" onMouseout="boxOff(this)">
		  <tr>
		   <td><font color="#73148C" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminUserList.do" />?country=<bean:write name="userProfile" property="countryCd" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.AdminUserListByCountry"/>')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.AdminUserListByCountry"/></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>

		<!-- Tabla de item de menu 8 solo para efectos de administracion //-->
	    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminIndex.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.Administration" /></a></font></td>
		  </tr>
		</table>
	    <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>


<!--This link is provisory until locations hierarchy is implemented -->
<logic:equal name="userProfile" property="countryCd" value='AU'>
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'Move to SYDX')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="if(!document.all) boxOff(this)"  href="<html:rewrite page="/pages/MoveToSYDX.jsp" />" target="_top">Move to SYDX</a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 4 //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
</logic:equal>



		<!-- Tabla de item de menu para administrar pagos//-->
		<!-- End Menu Items Tables //-->
		<!-- Message Table //-->
		<!-- Set the width= of this table the same as the overall
		     width in the <style> //-->
		<table cellpadding="1" cellspacing="0" bgcolor="#444444" width="310">
			<tr>
				<td>
				<!-- Set the width= of this table to the overall width
			     in the style table minus 2x the border width; set
			     the height= long (large) enough to accommodate your
			     longest message //-->
				<table cellpadding="3" cellspacing="0" bgcolor="#FFFF9C" width="306" height="50" align="center">
			  	<tr>
			  	  <td align="left" valign="top" bgcolor="#FFFFFF">
                                            <font id="Message" color="#73148C" size="2" face="Arial">
                                            <ilayer  id="myILayer" width="306" height="50">
                                                <layer id=myLayer width="306" height="50">
                                                  <bean:message key="app.messages.MenuWelcome" />
                                                </layer>
                                            </ilayer></font></td>
				  </tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- End Message Table //-->
	</td>
	<td><img border="0" src="<html:rewrite page="/images/globalhome_background.jpg" />"></td>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
</table>
<!-- End Outer Container Table //--><!-- END OF MENU //-->

</logic:equal>
<logic:equal name="role" value="Research">
<!-- BEGINNING OF MENU //-->
<!-- Outer Container Table //-->
<!-- Set this table width to largest margin-left + largest width in <style> script //-->
<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	<td align="center"> 
		
		<!-- Header Table // -->
			<table cellpadding="3" cellspacing="0" bgcolor="#73148C" class="BorderOff">
			  <tr>
			    <td><p align="center"><font color="#FFFFFF" size="2" face="Arial"><b><bean:message key="app.messages.ControllerMenu" /></b></font></p></td>
			  </tr>
			</table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5"><br>
		<!-- End Header Table //-->
		<!-- Menu Items Tables
		   - To add more, just follow the pattern
		   - Note class= in each <a href> to attach link style colors
		//-->

        <!-- Tabla de item de menu 2 //-->
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.operationalReportingMessage" />')" onMouseout="boxOff(this)">
          <tr>
            <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/CreateReports.do?action=select" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.operationalReportingMessage" /></a></font></td>
          </tr>
        </table>
        <img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5"><br>
        
	    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.GCCSReportingMessage" />')" onMouseout="boxOff(this)">
          <tr >
            <td ><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/GCCSReport.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.GCCSReportingMessage" /></a></font></td>
          </tr>
        </table>
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
        <!-- Tabla de item de menu 8 solo para efectos de administracion //-->
	    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminIndex.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.Administration" /></a></font></td>
		  </tr>
		</table>
	    <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
	    
        <!-- End Menu Items Tables //-->
		<!-- Message Table //-->
		<!-- Set the width= of this table the same as the overall
		     width in the <style> //-->
		<table cellpadding="1" cellspacing="0" bgcolor="#444444" width="310">
			<tr>
				<td>
				<!-- Set the width= of this table to the overall width
			     in the style table minus 2x the border width; set
			     the height= long (large) enough to accommodate your
			     longest message //-->
				<table cellpadding="3" cellspacing="0" bgcolor="#FFFF9C" width="306" height="50" align="center">
			  	<tr>
			  	  <td align="left" valign="top" bgcolor="#FFFFFF">
						<font id="Message" color="#73148C" size="2" face="Arial">
							<ilayer  id="myILayer" width="306" height="50">
								<layer id=myLayer width="306" height="50">
								  <bean:message key="app.messages.MenuWelcome" />
								</layer>
							</ilayer>
						</font>
					</td>
				  </tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- End Message Table //-->
	</td>
	<td><img border="0" src="<html:rewrite page="/images/globalhome_background.jpg" />"></td>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
</table>
<!-- End Outer Container Table //--><!-- END OF MENU //-->
</logic:equal>
<logic:equal name="role" value="Administrator">
<!-- BEGINNING OF MENU //-->
<!-- Outer Container Table //-->
<!-- Set this table width to largest margin-left + largest width in <style> script //-->
<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	<td align="center"> 
		
		<!-- Header Table // -->
			<table cellpadding="3" cellspacing="0" bgcolor="#73148C" class="BorderOff">
			  <tr>
			    <td><p align="center"><font color="#FFFFFF" size="2" face="Arial"><b><bean:message key="app.message.AdminMenu" /></b></font></p></td>
			  </tr>
			</table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5"><br>
		<!-- End Header Table //-->
		<!-- Menu Items Tables
		   - To add more, just follow the pattern
		   - Note class= in each <a href> to attach link style colors
		//-->

		<!-- Tabla de item de menu 1 //-->
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.receiveValidateMessage" />')" onMouseout="boxOff(this)">
		  <tr>
		   <td><font color="#73148C" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ShowChkAgtCashRecap.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.receiveValidateMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.receiveValidate" /></a></font></td>
		  </tr>
		</table>  
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
        <!-- Tabla de item de menu 2 //-->
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.operationalReportingMessage" />')" onMouseout="boxOff(this)">
          <tr>
            <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/CreateReports.do?action=select" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.operationalReportingMessage" /></a></font></td>
          </tr>
        </table>
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.GCCSReportingMessage" />')" onMouseout="boxOff(this)" >
          <tr >
            <td ><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/GCCSReport.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.GCCSReportingMessage" /></a></font></td>
          </tr >
        </table >
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<!-- Tabla de item de menu 3 //-->
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/ProcessScansPage.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.processCosmosScans" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 4 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.RODFileImportStatusMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/ViewRodFileImportingStatus.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.RODFileImportStatusMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.RODFileImportStatus" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 7 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.ExternalFilesImportStatusMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Import/ViewExternalFilesImportingStatus.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.ExternalFilesImportStatusMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.ExternalFilesImportStatus" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 5 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.openDepositSlipMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/DepositSlipGeneration.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.openDepositSlipMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.openDepositSlip" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 5 //>
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.openCreditCardMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/CreditCardPymt.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.openCreditCardMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.openCreditCard" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 5 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.messages.PrepaidDiscrepancies" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Prepaid/Discrepancies.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.messages.PrepaidDiscrepanciesMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.messages.PrepaidDiscrepancies" /></a></font></td>
		  </tr>
		</table>
        <!-- Tabla de item de menu 6 //-->
              <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddRODAwbsMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addRODAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddRODAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddRODAwbs" /></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>

<logic:equal name="userProfile" property="codUsedFlag" value="true" >		
		 <!-- Tabla de item de menu 7 Add COD awb manually  //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddCODAwbsMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addCODAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddCODAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddCODAwbs" /></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
</logic:equal>
		
<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >		
		 <!-- Tabla de item de menu 7 Add COD awb manually  //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.AddFTCAwbsMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="Javascript:addFTCAwbs()" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.AddFTCAwbsMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.AddFTCAwbs" /></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
</logic:equal>
		
	<!-- Tabla de item de menu 8 solo para efectos de administracion //-->
	    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminIndex.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.Administration" /></a></font></td>
		  </tr>
		</table>
	    <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
     <%if(userProfile.isAdmin() || userProfile.isFinController()){%>
	    <!-- 
	    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.PSUpload" />')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/PSUpload.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.PSUpload" /></a></font></td>
		  </tr>
		</table>
	    <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
	     -->
	    
     <%}%>
		<!-- End Menu Items Tables //-->

<!--This link is provisory until locations hierarchy is implemented -->
<logic:equal name="userProfile" property="countryCd" value='AU'>
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'Move to SYDX')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="if(!document.all) boxOff(this)"  href="<html:rewrite page="/pages/MoveToSYDX.jsp" />" target="_top">Move to SYDX</a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 4 //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
</logic:equal>

		<!-- Message Table //-->
		<!-- Set the width= of this table the same as the overall
		     width in the <style> //-->
		<table cellpadding="1" cellspacing="0" bgcolor="#444444" width="310">
			<tr>
				<td>
				<!-- Set the width= of this table to the overall width
			     in the style table minus 2x the border width; set
			     the height= long (large) enough to accommodate your
			     longest message //-->
				<table cellpadding="3" cellspacing="0" bgcolor="#FFFF9C" width="306" height="50" align="center">
			  	 <tr>
			  	  <td align="left" valign="top" bgcolor="#FFFFFF">
						<font id="Message" color="#73148C" size="2" face="Arial">
						<ilayer  id="myILayer" width="306" height="50">
							<layer id=myLayer width="306" height="50">
							  <bean:message key="app.messages.MenuWelcome" />
							</layer>
						</ilayer></font>
				  </td>
				 </tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- End Message Table //-->
	</td>
	<td><img border="0" src="<html:rewrite page="/images/globalhome_background.jpg" />"></td>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
</table>
<!-- End Outer Container Table //--><!-- END OF MENU //-->
</logic:equal>



<!-- Newly Added by Kapil For Finance Controller -->

<logic:equal name="role" value="Finance Controller">
<!-- BEGINNING OF MENU //-->
<!-- Outer Container Table //-->
<!-- Set this table width to largest margin-left + largest width in <style> script //-->
<table cellpadding="0" cellspacing="0" width="310" bgcolor="#FFFF9C" ALIGN="CENTER">
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
	<td align="center"> 
		
		<!-- Header Table // -->
			<table cellpadding="3" cellspacing="0" bgcolor="#73148C" class="BorderOff">
			  <tr>
			    <td><p align="center"><font color="#FFFFFF" size="2" face="Arial"><b><bean:message key="app.message.ControlerFinMenu" /></b></font></p></td>
			  </tr>
			</table>
			<img src="<html:rewrite page="/images/spacer.gif" />" width="5" height="5"><br>
		<!-- End Header Table //-->
		<!-- Menu Items Tables
		   - To add more, just follow the pattern
		   - Note class= in each <a href> to attach link style colors
		//-->

		
        <!-- Tabla de item de menu 2 //-->
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.operationalReportingMessage" />')" onMouseout="boxOff(this)">
          <tr>
            <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/CreateReports.do?action=select" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.operationalReportingMessage" /></a></font></td>
          </tr>
        </table>
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.GCCSReportingMessage" />')" onMouseout="boxOff(this)" >
          <tr >
            <td ><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/GCCSReport.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.reportingMessage" />')" onMouseout="if(!document.all) boxOff(this)"  target="_top"><bean:message key="app.GCCSReportingMessage" /></a></font></td>
          </tr >
        </table >
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>

		<!-- Tabla de item de menu 4 //-->
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.RODFileImportStatusMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/ROD/ViewRodFileImportingStatus.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.RODFileImportStatusMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.RODFileImportStatus" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 7 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.ExternalFilesImportStatusMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Import/ViewExternalFilesImportingStatus.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.ExternalFilesImportStatusMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.ExternalFilesImportStatus" /></a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 5 //-->
                <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.openDepositSlipMessage" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/DepositSlipGeneration.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.openDepositSlipMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.openDepositSlip" /></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		
		<table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.messages.PrepaidDiscrepancies" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Prepaid/Discrepancies.do" />"  onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.messages.PrepaidDiscrepanciesMessage" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.messages.PrepaidDiscrepancies" /></a></font></td>
		  </tr>
		</table>
		<img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		
	<!-- Tabla de item de menu 8 solo para efectos de administracion //-->
	    <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="boxOff(this)">  
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" href="<html:rewrite page="/Admin/AdminIndex.do" />" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.title.Administration" />')" onMouseout="if(!document.all) boxOff(this)" target="_top"><bean:message key="app.title.Administration" /></a></font></td>
		  </tr>
		</table>
	    <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
		<!-- End Menu Items Tables //-->

<!--This link is provisory until locations hierarchy is implemented -->
<logic:equal name="userProfile" property="countryCd" value='AU'>
        <table cellpadding="3" cellspacing="0" class="BorderOff" onMouseover="boxOn(this,'Move to SYDX')" onMouseout="boxOff(this)">
		  <tr>
		    <td><font color="#000080" size="2" face="Arial"><a class="mBlue" onMouseover="if(!document.all) boxOn(this,'<bean:message key="app.processCosmosScansMessage" />')" onMouseout="if(!document.all) boxOff(this)"  href="<html:rewrite page="/pages/MoveToSYDX.jsp" />" target="_top">Move to SYDX</a></font></td>
		  </tr>
		</table>
		<!-- Tabla de item de menu 4 //-->
        <img src="<html:rewrite page="/images/spacer.gif" />" width="2" height="2"><br>
</logic:equal>

		<!-- Message Table //-->
		<!-- Set the width= of this table the same as the overall
		     width in the <style> //-->
		<table cellpadding="1" cellspacing="0" bgcolor="#444444" width="310">
			<tr>
				<td>
				<!-- Set the width= of this table to the overall width
			     in the style table minus 2x the border width; set
			     the height= long (large) enough to accommodate your
			     longest message //-->
				<table cellpadding="3" cellspacing="0" bgcolor="#FFFF9C" width="306" height="50" align="center">
			  	 <tr>
			  	  <td align="left" valign="top" bgcolor="#FFFFFF">
						<font id="Message" color="#73148C" size="2" face="Arial">
						<ilayer  id="myILayer" width="306" height="50">
							<layer id=myLayer width="306" height="50">
							  <bean:message key="app.messages.MenuWelcome" />
							</layer>
						</ilayer></font>
				  </td>
				 </tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- End Message Table //-->
	</td>
	<td><img border="0" src="<html:rewrite page="/images/globalhome_background.jpg" />"></td>
	<td width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
<tr>
   <td  width="4" bgcolor="#808080" colspan="5"><img src="<html:rewrite page="/images/pixel.gif" />" width="1"></td>
</tr>
</table>
<!-- End Outer Container Table //--><!-- END OF MENU //-->
</logic:equal>
