<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<bean:define id="userProfile" name="userProfile" scope="session" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />
<html:errors />                                                                        
<%

    
String role;
if(userProfile!=null && userProfile.isAdmin())
   role="Administrator";
else if(userProfile.getEmployeeRole()!=null && userProfile.getEmployeeRole().get("Research")!=null)
   role="Research";
else if((userProfile.getEmployeeRole()!=null && userProfile.getEmployeeRole().get("Operation Manager")!=null) || userProfile.isAdmin() || userProfile.isCountryAdmin())
   role="Operation Manager";
else if(userProfile.getEmployeeRole()!=null && userProfile.getEmployeeRole().get("Check-In Agent")!=null)
   role="Check-In Agent";
else
   role="";

pageContext.setAttribute("role",role);

%>
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>
    function handlePress(e,obj) {
    
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            createReport();  
      }
    }

    function createReport() {
        var form=document.forms['createReports'];
        var msg="";
        if(form.reportSelected.selectedIndex==0) {
            msg="<bean:message key="app.message.js.MustSelectAReport" />\n";
        }

        for (var i = 0; i < document.forms['createReports'].reportSelected.length; i++) {
            if (document.forms['createReports'].reportSelected.options[i].selected == true) {
                if(document.forms['createReports'].reportSelected.options[i].value!=1 && document.forms['createReports'].reportSelected.options[i].value!=5 && document.forms['createReports'].reportSelected.options[i].value!=10 && document.forms['createReports'].reportSelected.options[i].value!=11 && document.forms['createReports'].reportSelected.options[i].value!=7 && document.forms['createReports'].reportSelected.options[i].value!=8) {
                    if (!validateUSDate(form.reportDate.value)) {
                        msg=msg+"<bean:message key="app.message.js.MustEnterAValidDate" />\n";
                    }
                    if(document.forms['createReports'].reportSelected.options[i].value==10 || 
                    		document.forms['createReports'].reportSelected.options[i].value==11) {
                        if (!validateUSDate(form.endDate.value)) {
                            msg=msg+"<bean:message key="app.message.js.MustEnterAValidDate" />\n";
                        }
                    }
                }
                else {
                    if(document.forms['createReports'].reportSelected.options[i].value==5 && document.forms['createReports'].courierId.selectedIndex==0 ||
                    		document.forms['createReports'].reportSelected.options[i].value==10 && document.forms['createReports'].courierId.selectedIndex==0	||
                    		document.forms['createReports'].reportSelected.options[i].value==11 && document.forms['createReports'].courierId.selectedIndex==0) {
                        msg=msg+"Must select a courier.\n";
                    }
                }
            }
        }

        if(msg=="") {
            switch(form.reportSelected.selectedIndex) {
                case 1000:{//never
                         form.action="<html:rewrite page="/servlet/PODWithoutPaymentReport" />";
                         form.StyleSheet.value="XSLT/PODWithoutPaymentReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                        }
                case 1:{
                         form.action="<html:rewrite page="/servlet/DailyExceptionReport" />";
                         form.StyleSheet.value="XSLT/DailyExceptionReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                        }
                case 2:{
                         form.action="<html:rewrite page="/servlet/DailyCashRecapReport" />";
                         form.StyleSheet.value="XSLT/DailyCashRecapReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                        }
                case 3:{
                         form.action="<html:rewrite page="/servlet/CreditPaymentsReport" />";
                         form.StyleSheet.value="XSLT/CreditPaymentsReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                        }
                case 4:{
                         form.action="<html:rewrite page="/servlet/PendingRecByCourierReport" />";
                         form.StyleSheet.value="XSLT/PendingRecByCourierReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                        }               
                case 5:{
                         form.action="<html:rewrite page="/servlet/InCageExceptionsReport" />";
                         form.StyleSheet.value="XSLT/InCageExceptionsReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                       }
                case 6:{
                         form.action="<html:rewrite page="/servlet/OpenReceivablesReport" />";
                         form.StyleSheet.value="XSLT/OpenReceivablesReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                       }
                case 7:{
                         form.action="<html:rewrite page="/servlet/PrepaidReconcReport" />";
                         form.StyleSheet.value="XSLT/PrepaidReconcReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                        }
                case 8:{
                         form.action="<html:rewrite page="/servlet/ReceivablesReport" />";
                         form.StyleSheet.value="XSLT/ReceivablesReport.xsl";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
                         break;
                        }
                case 9:{
                    	form.action="<html:rewrite page="/servlet/PendingCODByCourierReport" />";
                    	form.StyleSheet.value="XSLT/PendingCODByCourierReport.xsl";
                    	form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                    	form.target="results";
                	/*
                         form.action="<html:rewrite page="/CreditCardPymtReport.do" />";
                         form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                         form.target="results";
					*/
                         break;
                        }

                case 10:{
                	form.action="<html:rewrite page="/servlet/PendingFTCByCourierReport" />";
                	form.StyleSheet.value="XSLT/PendingFTCByCourierReport.xsl";
                	form.onSubmit="window.open('','results','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=700, height=500,left='+((screen.width-700) /2)+',top='+((screen.height-500) / 2));";
                	form.target="results";

                     break;
                    }

               default:{
                        alert("default");
                         form.action="<html:rewrite page="/ROD/CreateReports.do" />";
                         form.onSubmit="";
                         form.target="";
                         break;
                       }
            }  //end switch
            form.submit();
        }
        else {
            alert("<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg);
        }
    }

    function changeReport(){

 		for (var i = 0; i < document.forms['createReports'].reportSelected.length; i++) {
			if (document.forms['createReports'].reportSelected.options[i].selected == true) {
                var d=new Date();
                var m="0"+(d.getMonth()+1);
                m=m.substr(m.length-2,2);
                var day="0"+d.getDate();
                day=day.substr(day.length-2,2);

				if(document.forms['createReports'].reportSelected.options[i].value==1 || document.forms['createReports'].reportSelected.options[i].value==7 || document.forms['createReports'].reportSelected.options[i].value==8){
					document.forms['createReports'].reportDate.disabled=true;
					document.forms['createReports'].reportDate.value="";
					document.forms['createReports'].reportDate.readonly=true;
                    document.forms['createReports'].endDate.disabled=true;
					document.forms['createReports'].endDate.value="";
					document.forms['createReports'].endDate.readonly=true;
                    document.forms['createReports'].batchId.disabled=true;
                    document.forms['createReports'].batchId.value="";
                    document.forms['createReports'].batchId.readonly=true;
                    document.forms['createReports'].courierId.disabled=true;
                    document.forms['createReports'].courierId.selectedIndex=0;
                    if(!document.all) document.forms['createReports'].courierId.onchange=clearCourierId;
				} else {
                        if(document.forms['createReports'].reportSelected.options[i].value==5 ||
                        		document.forms['createReports'].reportSelected.options[i].value==10|| 
                        			document.forms['createReports'].reportSelected.options[i].value==11) {
                            document.forms['createReports'].batchId.disabled=true;
                            document.forms['createReports'].batchId.value="";
                            document.forms['createReports'].batchId.readonly=true;
                            document.forms['createReports'].reportDate.disabled=true;
                            document.forms['createReports'].reportDate.value="";
                            document.forms['createReports'].reportDate.readonly=true;
                            document.forms['createReports'].endDate.disabled=true;
                            document.forms['createReports'].endDate.value="";
                            document.forms['createReports'].endDate.readonly=true;
                            document.forms['createReports'].entityCd.disabled=true;
                            document.forms['createReports'].courierId.disabled=false;
                            if(!document.all) document.forms['createReports'].courierId.onchange="";
                        } else {
                                if(document.forms['createReports'].reportSelected.options[i].value==3  ) {
                                    document.forms['createReports'].batchId.disabled=false;
                                    document.forms['createReports'].batchId.value="";
                                    document.forms['createReports'].batchId.readonly=false;
                                    document.forms['createReports'].endDate.disabled=true;
                                    document.forms['createReports'].endDate.value="";
                                    document.forms['createReports'].endDate.readonly=true;
                                    document.forms['createReports'].entityCd.disabled=true;
                                } else {
                                        if(document.forms['createReports'].reportSelected.options[i].value==10 || 
                                        		document.forms['createReports'].reportSelected.options[i].value==11) {
                                            document.forms['createReports'].batchId.disabled=true;
                                            document.forms['createReports'].batchId.value="";
                                            document.forms['createReports'].batchId.readonly=true;
                                            document.forms['createReports'].endDate.value=m+"/"+day+"/"+d.getFullYear();
                                            document.forms['createReports'].endDate.disabled=false;
                                            document.forms['createReports'].endDate.readonly=false;
                                            document.forms['createReports'].entityCd.disabled=false;
                                        } else {
                                            document.forms['createReports'].batchId.disabled=true;
                                            document.forms['createReports'].batchId.value="";
                                            document.forms['createReports'].batchId.readonly=true;
                                            document.forms['createReports'].endDate.disabled=true;
                                            document.forms['createReports'].endDate.value="";
                                            document.forms['createReports'].endDate.readonly=true;
                                            document.forms['createReports'].entityCd.disabled=true;
                                        }
                                }
                                document.forms['createReports'].reportDate.disabled=false;
                                document.forms['createReports'].reportDate.value=m+"/"+day+"/"+d.getFullYear();
                                document.forms['createReports'].courierId.disabled=true;
                                document.forms['createReports'].courierId.selectedIndex=0;
                                if(!document.all) document.forms['createReports'].courierId.onchange=clearCourierId;
                        }
                }
                break;
            }
        }
    }

    function clearCourierId(){
        document.forms['createReports'].courierId.selectedIndex=0;
    }

</script>
<br>
<br>
<br>
<br>
<form name="createReports" action="<html:rewrite page="/ROD/CreateReports.do" />" method="POST">
        <input type="HIDDEN" name="Format" value="PDF">
        <input type="HIDDEN" name="locationCd" value="<bean:write name="userProfile" property="locationCd" />">
        <input type="HIDDEN" name="StyleSheet" value="XSLT/PendingRecByCourierReport.xsl">
<TABLE align=center border=0 cellPadding=0 cellSpacing=1 width="100%">
  <TBODY>
  <TR>
    <TD align=right><FONT face=Arial><B><bean:message key="app.messages.AvailableReports" /></B></FONT></TD>
    <TD>
        <logic:equal name="role" value="Operation Manager">
            <SELECT name="reportSelected"  onchange="changeReport()">
                <OPTION value="0"><bean:message key="app.messages.SelectReport" /></OPTION>
                <!--OPTION value="1"><bean:message key="app.messages.PODNoPaymentReport" /></OPTION-->
                <OPTION value="2"><bean:message key="app.messages.DailyExceptionReport" /></OPTION>
                <OPTION value="3"><bean:message key="app.messages.DailyCashRecapReport" /></OPTION>
                <OPTION value="4"><bean:message key="app.messages.BillAccountReport" /></OPTION>
                <OPTION value="5"><bean:message key="app.messages.PendentReceivables" /></OPTION>
                <OPTION value="6"><bean:message key="app.messages.InCageExceptions" /></OPTION>
                <OPTION value="7"><bean:message key="app.messages.OpenReceivables" /></OPTION>
                <OPTION value="8"><bean:message key="app.messages.PrepaidDiscrepancies" /></OPTION>
                <OPTION value="9"><bean:message key="app.messages.ReceivablesReport" /></OPTION>
                <OPTION value="10"><bean:message key="app.messages.PendentCODReceivables" /></OPTION>
                <OPTION value="11"><bean:message key="app.messages.PendentFTCReceivables" /></OPTION>

            </SELECT>
        </logic:equal>
        <logic:equal name="role" value="Check-In Agent">
            <SELECT name="reportSelected"  onchange="changeReport()">
                <OPTION value="0"><bean:message key="app.messages.SelectReport" /></OPTION>
                <!--OPTION value="1"><bean:message key="app.messages.PODNoPaymentReport" /></OPTION-->
                <OPTION value="2"><bean:message key="app.messages.DailyExceptionReport" /></OPTION>
                <OPTION value="3"><bean:message key="app.messages.DailyCashRecapReport" /></OPTION>
                <OPTION value="4"><bean:message key="app.messages.BillAccountReport" /></OPTION>
                <OPTION value="5"><bean:message key="app.messages.PendentReceivables" /></OPTION>
                <OPTION value="6"><bean:message key="app.messages.InCageExceptions" /></OPTION>
                <OPTION value="7"><bean:message key="app.messages.OpenReceivables" /></OPTION>
                <OPTION value="8"><bean:message key="app.messages.PrepaidDiscrepancies" /></OPTION>
                <OPTION value="9"><bean:message key="app.messages.ReceivablesReport" /></OPTION>
	            <OPTION value="10"><bean:message key="app.messages.PendentCODReceivables" /></OPTION>
	            <OPTION value="11"><bean:message key="app.messages.PendentFTCReceivables" /></OPTION>

            </SELECT>
        </logic:equal>
        <logic:equal name="role" value="Research">
            <SELECT name="reportSelected"  onchange="changeReport()">
                <OPTION value="0"><bean:message key="app.messages.SelectReport" /></OPTION>
                <!--OPTION value="1"><bean:message key="app.messages.PODNoPaymentReport" /></OPTION-->
                <OPTION value="2"><bean:message key="app.messages.DailyExceptionReport" /></OPTION>
                <OPTION value="3"><bean:message key="app.messages.DailyCashRecapReport" /></OPTION>
                <OPTION value="4"><bean:message key="app.messages.BillAccountReport" /></OPTION>
                <OPTION value="5"><bean:message key="app.messages.PendentReceivables" /></OPTION>
                <OPTION value="6"><bean:message key="app.messages.InCageExceptions" /></OPTION>
                <OPTION value="7"><bean:message key="app.messages.OpenReceivables" /></OPTION>
                <OPTION value="8"><bean:message key="app.messages.PrepaidDiscrepancies" /></OPTION>
                <OPTION value="9"><bean:message key="app.messages.ReceivablesReport" /></OPTION>
                <!--<OPTION value="10"><bean:message key="app.messages.CreditCardPymtReport" /></OPTION>-->
                <OPTION value="10"><bean:message key="app.messages.PendentCODReceivables" /></OPTION>
                <OPTION value="11"><bean:message key="app.messages.PendentFTCReceivables" /></OPTION>

            </SELECT>
        </logic:equal>
        <logic:equal name="role" value="Administrator">
            <SELECT name="reportSelected"  onchange="changeReport()">
                <OPTION value="0"><bean:message key="app.messages.SelectReport" /></OPTION>
                <!--OPTION value="1"><bean:message key="app.messages.PODNoPaymentReport" /></OPTION-->
                <OPTION value="2"><bean:message key="app.messages.DailyExceptionReport" /></OPTION>
                <OPTION value="3"><bean:message key="app.messages.DailyCashRecapReport" /></OPTION>
                <OPTION value="4"><bean:message key="app.messages.BillAccountReport" /></OPTION>
                <OPTION value="5"><bean:message key="app.messages.PendentReceivables" /></OPTION>
                <OPTION value="6"><bean:message key="app.messages.InCageExceptions" /></OPTION>
                <OPTION value="7"><bean:message key="app.messages.OpenReceivables" /></OPTION>
                <OPTION value="8"><bean:message key="app.messages.PrepaidDiscrepancies" /></OPTION>
                <OPTION value="9"><bean:message key="app.messages.ReceivablesReport" /></OPTION>
                <!--<OPTION value="10"><bean:message key="app.messages.CreditCardPymtReport" /></OPTION>-->
                <OPTION value="10"><bean:message key="app.messages.PendentCODReceivables" /></OPTION>
        		<OPTION value="11"><bean:message key="app.messages.PendentFTCReceivables" /></OPTION>
        
            </SELECT>
        </logic:equal>
    </TD>
  </TR>
  <tr><td>&nbsp;</td></tr>  
  <TR>
    <TD align=right><FONT face=Arial><B><bean:message key="app.message.StartDate" /></B></FONT></TD>
    <TD><INPUT size=12 name="reportDate" onkeypress="handlePress(event,this);" onfocus="if(this.disabled)blur();" value="<%=new SimpleDateFormat("MM/dd/yyyy").format(new Date())%>">(MM/DD/YYYY)</TD></TR>
  <tr><td>&nbsp;</td></tr>  
  <TR>
    <TD align=right><FONT face=Arial><B><bean:message key="app.message.EndDate" /></B></FONT></TD>
    <TD><INPUT size=12 name="endDate" onkeypress="handlePress(event,this);" onfocus="if(this.disabled)blur();" value="<%=new SimpleDateFormat("MM/dd/yyyy").format(new Date())%>">(MM/DD/YYYY)</TD></TR>
  <tr><td>&nbsp;</td></tr>
  <tr>
        <TD align=right><FONT face=Arial><B><bean:message key="app.messages.CourierEmployeeID" /></B></FONT></TD>
        <td> 
           <select name="courierId" >
                <option value=""><bean:message key="app.messages.Select" /></option>
                <logic:iterate name="colCouriers" id="elem1">
                    <option value="<bean:write name="elem1" />"><bean:write name="elem1" /></option>
                </logic:iterate>
           </select>
        </td>
  </tr>
  <tr><td>&nbsp;</td></tr>
  <TR>
    <TD align=right><FONT face=Arial><B>Batch Id</B></FONT></TD>
    <TD><INPUT size=12 name="batchId" onfocus="if(this.disabled)blur();"></TD>
  </TR>
  <tr><td>&nbsp;</td></tr>
  <TR>
    <TD align=right><FONT face=Arial><B>Entity Cd</B></FONT></TD>
    <TD>
        <select name="entityCd" >
            <option value=""><bean:message key="app.messages.Select" /></option>
                <logic:iterate name="entities" id="ent">
                    <option value="<bean:write name="ent" />"><bean:write name="ent" /></option>
                </logic:iterate>
        </select>

    </TD>
  </TR>
  <tr><td>&nbsp;</td></tr>
  <tr><td>&nbsp;</td></tr>
  <TR>
    <TD align=middle colSpan=2><FONT face=Arial><B><INPUT type=button onclick="createReport();"  onfocus="if(this.disabled)this.blur();" value="<bean:message key="app.messages.CreateReport" />"></B>
</FONT>
</TD>
</TR>

</TBODY>
</TABLE>
<br><br><br><br><br>
<br><br><br><br><br>
<TABLE border='0' align='center'>
    <tr><td align='center'><font face="Arial" size=1><bean:message key="app.messages.AcrobatReader" /></font><br>
            <a href="ftp://lacftp.corp.fedex.com/pub/download/Acroread.exe"><html:img border="0" height="40" page="/images/AcrobatReader.gif"/></a></td></tr>
</TABLE>
</form>
