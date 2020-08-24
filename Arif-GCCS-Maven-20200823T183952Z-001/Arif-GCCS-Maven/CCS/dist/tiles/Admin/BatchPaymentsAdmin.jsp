<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="calendar" %>
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));

    Collection status=new ArrayList();
    status.add(new Entry("0","Pending"));
    status.add(new Entry("1","Deposited"));


    pageContext.setAttribute("status",status);
%>

<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script src="<html:rewrite page="/scripts/calendar.js" />"></script>
<script src="<html:rewrite page="/scripts/calendar-msgs-" /><bean:message key="app.Language" />.js"></script>
<script src="<html:rewrite page="/scripts/calendar-setup.js" />"></script>
<LINK REL ="stylesheet" TYPE="text/css" HREF="<html:rewrite page="/styles/calendar.css" />" TITLE="Style">
<script>
    var todayDate="<bean:write name="TodayDate" />";

    function listDeposits(){
        var frm=document.forms['BatchPaymentsAdminForm'];
        if(frm.startDate.value!=null && frm.endDate.value!=null){
            document.forms['BatchPaymentsAdminForm'].action.value='listDeposits';
            document.forms['BatchPaymentsAdminForm'].submit();
        }else{
            alert("<bean:message key="app.message.MustEnterAValidDate" />");
        }
    }

    function needConfirm(eodId){
    		var form=document.forms['BatchPaymentsAdminForm'];
            var index=Number(0);
            var needConf=false;

	        while(eval("form.elements['deposits["+index+"].eodId']")){
                   if(eval("form.elements['deposits["+index+"].eodId']").value==eodId && eval("form.elements['deposits["+index+"].statusId']").value==1){
                        return true;
                   }

 	               index++;
	        }

            return false;
    }


    function reopenEOD(eodId){
        var msg="";
        if(needConfirm(eodId)){
            msg="Warning: This EOD has closed deposits. ";
        }

        msg=msg+"<bean:message key="app.message.js.WantToReopenEOD" />";

        if(confirm(msg)){
            document.forms['BatchPaymentsAdminForm'].action.value='reopenEOD';
            document.forms['BatchPaymentsAdminForm'].selectedEodId.value=eodId
            document.forms['BatchPaymentsAdminForm'].submit();
        }
    }

    function moveEOD(eodId,fromDt){
        var msg="";
        if(needConfirm(eodId)){
            msg="Warning: This EOD has closed deposits. ";
        }

        msg=msg+"<bean:message key="app.message.js.EnterNewEODDate" /> ";


            var dt=prompt(msg+eodId,fromDt);
            if(dt!=null){
                document.forms['BatchPaymentsAdminForm'].newDate.value=dt;
                document.forms['BatchPaymentsAdminForm'].action.value='moveEOD';
                document.forms['BatchPaymentsAdminForm'].selectedEodId.value=eodId;
                document.forms['BatchPaymentsAdminForm'].submit();
            }

    }

    function moveDeposit(depositCd,fromDt){
        var dt=prompt("<bean:message key="app.message.js.EnterNewDepDate" /> "+depositCd,fromDt);
        if(dt!=null){
            document.forms['BatchPaymentsAdminForm'].newDate.value=dt;
            document.forms['BatchPaymentsAdminForm'].action.value='moveDeposit';
            document.forms['BatchPaymentsAdminForm'].selectedDepositCd.value=depositCd
            document.forms['BatchPaymentsAdminForm'].submit();
        }
    }

</script>
<br>
<br>
<html:errors />
<nested:form action="/Admin/BatchPaymentsAdmin" method="POST">
        <input type="hidden" name="action">
        <nested:hidden property="selectedEodId" />
        <nested:hidden property="selectedDepositCd" />
        <nested:hidden property="newDate" />
<!-- TABLA CONTENEDORA DEL SUMMARY -->
<table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
<tr bgcolor="#808080" height="1">
	<td colspan=3><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
</tr>
<tr>
	<td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="3"></td>
	<td bgcolor="#FFFF9C"><img src="/images/pixel.gif" width="1" height="3"></td>
	<td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="3"></td>
</tr>
          <tr>
                 <td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="3"></td>
                 <td bgcolor="#FFFF9C">
                        <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber1">
                        <tr>
                          <td width="50%">
                          <p align="right"><font face="Arial"><b><bean:message key="app.messages.Location" />&nbsp; </b></font>
                          </td>
                          <td width="50%"><b><font face="Arial">&nbsp; <bean:write name="userProfile" property="locationCd" /></font></b></td>
                        </tr>
                        <tr>
                          <td width="50%" align="right"><b><font face="Arial"><bean:message key="app.message.StartDate" /></font></b></td>
                          <td width="50%"><font face="Arial"><b>&nbsp;
                          <%String iconUrl=request.getContextPath()+"/images/cal.gif";%>
                          <!--nested:text property="startDate"  style="width: 100" /--> <calendar:calendar property="startDate" srcIcon="<%=iconUrl%>" format="%m/%d/%Y"   /> (MM/DD/YYYY)</b></font></td>
                        </tr>
                        <tr>
                          <td width="50%" align="right"><b><font face="Arial"><bean:message key="app.message.EndDate" /></font></b></td>
                          <td width="50%"><font face="Arial"><b>&nbsp;
                          <!--nested:text property="endDate" style="width: 100" /--> <calendar:calendar property="endDate" srcIcon="<%=iconUrl%>" format="%m/%d/%Y"   /> (MM/DD/YYYY)</b></font></td>
                        </tr>
                        <tr>
                          <td width="100%" colspan="2" height="30">
                          <p align="center">
                          <input type="button" name="Get" value="<bean:message key="app.message.Get" />" style="width: 100" onclick="listDeposits()"></td>
                        </tr>
                      </table>
                 </td>
	<td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="3"></td>
          </tr>
<tr >
	<td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="1"></td>
	<td bgcolor="#FFFF9C">

    <div align="center">
	<!-- AQUI VA LA TABLA DEL SUMARY -->
	<table border="0" width="98%" bgcolor="#000000" cellspacing="1" cellpadding="0">
	  <tr>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">EOD ID</font></td>
        <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">Fedex ID</font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.date" /></font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Account" /></font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.ExternalId" /></font></td>
	    <td align="center"  colspan="3" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Type" /></font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Amount" /></font></td>
   	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.ActualAmount" /></font></td>
   	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.DepositDate" /> </font><font face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF"> MM/DD/YYYY</font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.BankAmount" /></font></td>
   	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.BankDate" /></font><font face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF"> MM/DD/YYYY</font></td>
   	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.CommentsAbbrv" /></font></td>
	    <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Status" /></font></td>
          </tr>
<% String bgColor="#ffffff";
   int lastEodId=-1;
   String fontColor="#000000";
%>

<logic:present name="BatchPaymentsAdminForm" scope="request" >
  <nested:define id="eodCount" name="eodCount" scope="request" toScope="page" type="java.util.HashMap" />

  <nested:iterate property="deposits" id="deposit" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.DepositSlipTableVO">
    <nested:hidden property="eodId" />
    <tr>
    <%
        if(lastEodId!=deposit.getEodId()){
            bgColor=bgColor=="#ffffff"?"#C0C0C0":"#ffffff"; %>
            <td align="right" bgcolor="<%=bgColor%>" height="19"  width="15%" rowspan="<%=eodCount.get(new Integer(deposit.getEodId()))%>"><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><a href="javascript:reopenEOD(<nested:write property="eodId" />)"><img border="0" src="<html:rewrite page="/images/open.gif" />" alt="Reopen"/></a><a href="javascript:moveEOD('<nested:write property="eodId" />','<nested:write property="depositSlipDt" format="MM/dd/yyyy" />')"><img border="0" src="<html:rewrite page="/images/calendar.gif" />" alt="Change Date"/></a><nested:write property="eodId" /></font></td>
        <%}
        lastEodId=deposit.getEodId();

    %>

   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="15%"><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1">
                <nested:notEqual property="statusId" value="1"><a href="javascript:moveDeposit('<nested:write property="depositSlipCd" />','<nested:write property="depositSlipDt" format="MM/dd/yyyy" />')"><img border="0" src="<html:rewrite page="/images/calendar.gif" />" alt="Change Date"/></a></nested:notEqual><nested:write property="depositSlipCd" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="depositSlipDtText" formatKey="app.format.Date" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif">
                        <nested:select property="bankAccountCd" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt;width: 140px" disabled="true" >
                              <html:options collection="BankAccounts" property="key" labelProperty="value"  />
                        </nested:select>
                 </font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="depositSlipNbr" /></font></td>
                 <nested:notPresent property="templCd" >
                     <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="srcType" /></font></td>
                     <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="currencyCd" /></font></td>
                     <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="pymtType" /></font></td>
                 </nested:notPresent>
                 <nested:present property="templCd" >
           		 <td align="center" bgcolor="<%=bgColor%>" height="19" colspan="3" width="27%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="templCd" /></font></td>
                 </nested:present>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="depositSlipTotAmt" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="actualAmt" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="depoDtText" formatKey="app.format.Date" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="bankAmt" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="bankDepoDtText" formatKey="app.format.Date"/></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:notEmpty property="comments" ><img src="<html:rewrite page="/images/info.gif" />" alt="<nested:write property="comments" />"/></nested:notEmpty></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19" width="8%">
                        <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" disabled="true">
                              <html:options collection="status" property="key" labelProperty="value" />
                        </nested:select>
                 </td>
	  </tr>
  </nested:iterate>
        </table>
        </div>
	<!-- ------------------------------>
	</td>
	<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="1"></td>
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
</logic:present>
</nested:form>
