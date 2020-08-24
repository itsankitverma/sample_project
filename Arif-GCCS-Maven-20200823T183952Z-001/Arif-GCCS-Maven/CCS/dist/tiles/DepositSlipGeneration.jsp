<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic-el.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
    SimpleDateFormat formatterDt=new SimpleDateFormat("MM/dd/yyyy");
    Collection status=new ArrayList();
    status.add(new Entry("0","Pending"));
    status.add(new Entry("1","Deposited"));
    pageContext.setAttribute("status",status);
%>
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>
    var todayDate=new Date('<bean:write name="TodayDate" format="MM/dd/yyyy" />');

    function saveDeposits(){
        var valid=validate();

        if(valid==""){
            document.forms['DepositSlipForm'].action.value='saveDeposits';
            document.forms['DepositSlipForm'].submit();
        }else{
            alert(valid);
        }    
    }

    function goToMenu(){
        document.location.href='<html:rewrite page="/pages/Menu.jsp" />'
    }

    function addComment(index){
         var allForm=document.forms['DepositSlipForm'];
         var commentForm=document.forms['DepSlipAddCommentForm'];

         commentForm.oldComment.value=eval("allForm.elements['deposits["+index+"].comments']").value;
         commentForm.currentDepositSlipId.value=eval("allForm.elements['deposits["+index+"].depositSlipCd']").value;
         window.open('','newWindow','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=500, height=500,left='+((screen.width-500) /2)+',top='+((screen.height-500) / 2));
         commentForm.submit();
    }

    function checkLine(index){
        var form=document.forms['DepositSlipForm'];
        var msg="";

        var depoDt=eval("form.elements['deposits["+index+"].depoDtText']").value;
        var bankDepoDt=eval("form.elements['deposits["+index+"].bankDepoDtText']").value;
        var depositSlipDt=new Date(eval("form.elements['deposits["+index+"].depositSlipDtText']").value);

        if(depoDt!="" && !validateUSDate(depoDt)){
              msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.message.js.MustEnterAValidDate" />\n";
        }else{
            if(depoDt==""){
                depoDt=null;
            }else{
                depoDt=new Date(depoDt);
            }
        }

        if(bankDepoDt!="" && !validateUSDate(bankDepoDt)){
              msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.message.js.MustEnterAValidDate" />\n";
        }else{
            if(bankDepoDt==""){
                bankDepoDt=null;
            }else{
                bankDepoDt=new Date(bankDepoDt);
            }
        }

/*
        if(depoDt!=null && depoDt>todayDate)
        {   msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.DepositDatesProblem" />\n";
        }
*/        

        var depSlipDtOneYear=new Date();
        depSlipDtOneYear.setTime(depositSlipDt.getTime());
        depSlipDtOneYear.setFullYear(depSlipDtOneYear.getFullYear()+1);

        var depSlipDtOneDayBef=new Date();
        depSlipDtOneDayBef.setTime(depositSlipDt-(1000 * 60 * 60 * 24));

        if(depoDt!=null && (depoDt<depSlipDtOneDayBef) || depoDt>depSlipDtOneYear)
        {
           msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.DepositDateProblem" />\n";
        }

        if(bankDepoDt!=null &&  (bankDepoDt<depositSlipDt || bankDepoDt>depSlipDtOneYear))
        {
           msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.BankDateProblem" />\n";
        }

        if((depoDt!=null && bankDepoDt!=null && depoDt>bankDepoDt))
        {
           msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.DepositBankDatesProblem" />\n";
        }
                    
        if(eval("form.elements['deposits["+index+"].statusId']").selectedIndex==1){
			depositSlipTotAmt=eval("form.elements['deposits["+index+"].depositSlipTotAmt']").value;
			actualAmt=Number(eval("form.elements['deposits["+index+"].actualAmt']").value);
			bankAmt=Number(eval("form.elements['deposits["+index+"].bankAmt']").value);
			comments=eval("form.elements['deposits["+index+"].comments']").value;

			if(isNaN(bankAmt) || isNaN(actualAmt)){
				msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
				//return msg;
			}else{
                depositSlipTotAmt=Number(depositSlipTotAmt);
				bankAmt=Number(bankAmt);
				actualAmt=Number(actualAmt);

                                if(bankAmt<0 || actualAmt<0){
                                    msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
                                    //return msg;
                                }
                                if((bankAmt==0 && comments.length==0) || actualAmt==0){
                                    msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.MustEnterAmounts" />\n";
                                    //return msg;
                                }
			}
			if((depositSlipTotAmt!=bankAmt || depositSlipTotAmt!=actualAmt || bankAmt==0) && comments.length==0){
        		msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.CommentsNotEntered" />\n";
				//return msg;
			}

            if(depoDt==null || bankDepoDt==null){
                msg=msg+"-Deposit "+ eval("form.elements['deposits["+index+"].depositSlipCd']").value +": <bean:message key="app.messages.js.MustEnterDepositDates" />\n";
            }
        }
        return msg;
    }

    function findIndex(name,after) {
        var from=name.indexOf("[",after)+1;
        var to=name.indexOf("]",after);
        return name.substr(from,to-from);
    }

    function validate(){
        var form=document.forms['DepositSlipForm'];
        var msg="";
        var index=Number("0");
        var some=false;
        while(eval("form.elements['deposits["+index+"].depositSlipCd']")){
            msg=msg+checkLine(index);
            index++;
        }
        if(msg==""){
            return "";
        }
        else {
            return "<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;
        }
    }

    function changeStatus(cbo){
        var form=document.forms['DepositSlipForm'];
        var index=findIndex(cbo.name,1);
        var msg="";
        msg=checkLine(index);
        if(msg!="") {
            cbo.selectedIndex=0;
            alert(msg);
        }
    }

    function validateBlackAmountDeposited(index){

    }

</script>
<br>
<br>
<html:errors />
<table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
        <td align="center">
            <util:paging numberOfPages="${numberOfPages}" pageNumber="${DepositSlipForm.pageNumber}" varStatus="std" style="font-family:Arial,Helvetica,Sans-Serif" >
                <c:url var="depositUrl" value="/DepositSlipGeneration.do">
                    <c:param name="pageNumber" value="${std.count}"/>
                </c:url>
                <html:link href="${depositUrl}"><c:out value="${std.count}"/></html:link>
            </util:paging>
        </td>
    </tr>
</table>
<nested:form action="/DepositSlipGeneration">
    <input type="hidden" name="action">
    <nested:hidden property="pageNumber"/>
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
                <p align="center"><html:link href="javascript:saveDeposits();" ><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link><html:link href="javascript:goToMenu();" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38"></html:link></p>
            </td>
            <td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="3"></td>
        </tr>
        <tr>
            <td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="1"></td>
            <td bgcolor="#FFFF9C" align="center">
                <table border="0" width="98%" bgcolor="#000000" cellspacing="1" cellpadding="0">
                    <tr>
                        <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">Fedex ID</font></td>
                        <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.date" /></font></td>
                        <td align="center" bgcolor="#73148C" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.SelectBankAccount" /></font></td>
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
                    <logic:present name="DepositSlipForm" scope="request" >
                        <nested:iterate property="deposits" id="deposit" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.DepositSlipTableVO">
                            <nested:hidden property="comments" />
                            <nested:hidden property="depositSlipCd" />
                            <nested:hidden property="bankAccountCdPrev" />
                            <nested:hidden property="depositSlipNbrPrev" />
                            <nested:hidden property="depositSlipTotAmt" />
                            <nested:hidden property="actualAmtPrev" />
                            <nested:hidden property="bankAmtPrev" />
                            <nested:hidden property="statusIdPrev" />
                            <nested:hidden property="depositSlipDtText" />
                            <nested:hidden property="depoDtPrevText" />
                            <nested:hidden property="bankDepoDtPrevText"  />
                            <%
                                String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
                                String fontColor="#000000";
                            %>
                            <tr>
                                <td align="right" bgcolor="<%=bgColor%>" height="19"  width="15%"><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="depositSlipCd" /></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="depositSlipDt" formatKey="app.format.Date" /></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif">
                                    <nested:select property="bankAccountCd" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt;width: 140px" >
                                       <html:options collection="BankAccounts" property="key" labelProperty="value"  />
                                    </nested:select></font>
                                </td>
                                <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="depositSlipNbr" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" size="10" maxlength="30" /></font></td>
                                <nested:notPresent property="templCd" >
                                    <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="srcType" /></font></td>
                                    <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="currencyCd" /></font></td>
                                    <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="pymtType" /></font></td>
                                </nested:notPresent>
                                <nested:present property="templCd" >
                                    <td align="center" bgcolor="<%=bgColor%>" height="19" colspan="3" width="27%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="templCd" /></font></td>
                                </nested:present>
                                <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="depositSlipTotAmt" formatKey="app.format.NumberFormat" /></font></td>
                                <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="actualAmt"  value="<%=formatter.format(deposit.getActualAmt())%>" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" size="10"/></font></td>
                                <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="depoDtText"  style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" size="10"/></font></td>
                                <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="bankAmt" value="<%=formatter.format(deposit.getBankAmt())%>" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" size="10"/></font></td>
                                <td align="right" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="bankDepoDtText" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" size="10"/></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19"  width="9%"><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:notEmpty property="comments"><html:img page="/images/info.gif" /></nested:notEmpty><a href="javascript:addComment(<%=idx%>);"><bean:message key="app.messages.ViewAdd" /></a></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19" width="8%">
                                    <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onchange="changeStatus(this);">
                                        <html:options collection="status" property="key" labelProperty="value" />
                                    </nested:select>
                                </td>
                            </tr>
                        </nested:iterate>
                    </table>
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
<nested:form action="/DepSlipAddComment" target="newWindow" > 
    <nested:hidden property="oldComment" />
    <nested:hidden property="currentDepositSlipId" />
</nested:form>