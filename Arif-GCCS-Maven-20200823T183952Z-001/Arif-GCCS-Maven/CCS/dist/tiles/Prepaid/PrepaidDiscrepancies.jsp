<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@ taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic-el.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));

    Collection status=new ArrayList();
    status.add(new Entry("0","Open"));
    status.add(new Entry("1","Closed"));


    pageContext.setAttribute("status",status);
%>
<script>
    function savePrepaidDiscrepancies(){
        var valid=validate();

        if(valid==""){
            document.forms['PrepaidDiscrepanciesForm'].action.value='saveDscr';
            document.forms['PrepaidDiscrepanciesForm'].submit();
        }else{
            alert(valid);
        }    
    }

    function goToMenu(){
        document.location.href='<html:rewrite page="/pages/Menu.jsp" />'
    }

    function checkLine(index){
        var form=document.forms['PrepaidDiscrepanciesForm'];
        var msg="";
        if(eval("form.elements['prepaidDscr["+index+"].statusId']").selectedIndex==1){
                        comments=eval("form.elements['prepaidDscr["+index+"].comments']").value;                        

                        if(comments.length<3){
                              msg=msg+"-Prepaid Discr. "+ eval("form.elements['prepaidDscr["+index+"].prepaidDscrId']").value +": <bean:message key="app.messages.js.MustEnterCommentsToClose" />\n";
                              return msg;                              
                        }

        }
        return msg;
    }

    function findIndex(name,after){
        var from=name.indexOf("[",after)+1;
        var to=name.indexOf("]",after);
        return name.substr(from,to-from);
    }
    
    function validate(){
        var form=document.forms['PrepaidDiscrepanciesForm'];
        var msg="";
        var index=Number("0");
        var some=false;

        while(eval("form.elements['prepaidDscr["+index+"].prepaidDscrId']")){
            msg=msg+checkLine(index);
            index++;
        }
        if(msg==""){
            return "";
        }else{
            return "<bean:message key="errors.messages.js.ThereWereErrors" />\n\n"+msg;
        }    
    }

    function changeStatus(cbo){
        var form=document.forms['PrepaidDiscrepanciesForm'];
        var index=findIndex(cbo.name,1);
        var msg="";
        msg=checkLine(index);

        if(msg!=""){
            cbo.selectedIndex=0;
            alert(msg);
        }  
    }
</script>
<br>
<br>
<html:errors />
<table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
        <td align="center">
            <util:paging numberOfPages="${numberOfPages}" pageNumber="${PrepaidDiscrepanciesForm.pageNumber}" varStatus="std" style="font-family:Arial,Helvetica,Sans-Serif" >
                <c:url var="discrepanciesUrl" value="/Prepaid/Discrepancies.do">
                    <c:param name="pageNumber" value="${std.count}"/>
                </c:url>
                <html:link href="${discrepanciesUrl}"><c:out value="${std.count}"/></html:link>
            </util:paging>
        </td>
    </tr>
</table>
<nested:form action="/Prepaid/Discrepancies">
    <nested:hidden property="pageNumber"/>
    <input type="hidden" name="action">
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
                <p align="center">
                    <html:link href="javascript:savePrepaidDiscrepancies();" ><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link><html:link href="javascript:goToMenu();" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38"></html:link>
                </p>
            </td>
            <td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="3"></td>
        </tr>
        <tr>
            <td  width="1" bgcolor="#808080"><img src="/images/pixel.gif" width="1" height="1"></td>
            <td bgcolor="#FFFF9C" align="center">
                <table border="0" width="98%" bgcolor="#000000" cellspacing="1" cellpadding="0">
                    <tr>
                        <td align="center" bgcolor="#73148C" width="10%"  height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">AWB</font></td>
                        <td align="center" bgcolor="#73148C" width="10%" height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.date" /></font></td>
                        <td align="center" bgcolor="#73148C" width="10%" height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.CourierEmployeeID" /></font></td>
                        <td align="center" bgcolor="#73148C" width="25%" height="30" colspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Discrepancy" /></font></td>
                        <td align="center" bgcolor="#73148C" width="10%" height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.FreightAmt" /></font></td>
                        <td align="center" bgcolor="#73148C" width="10%" height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.PUX16Amount" /></font></td>
                        <td align="center" bgcolor="#73148C" width="10%" height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.CouponAmount" /></font></td>
                        <td align="center" bgcolor="#73148C" width="5%" height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Currency" /></font></td>
                        <td align="center" bgcolor="#73148C" width="10%" height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Comments" /></font></td>
                        <td align="center" bgcolor="#73148C" width="10%" height="30" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Status" /></font></td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#73148C" width="15%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Type" /></font></td>
                        <td align="center" bgcolor="#73148C" width="10%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Reason" /></font></td>
                    </tr>
                    <logic:present name="PrepaidDiscrepanciesForm" scope="request" >
                        <nested:iterate property="prepaidDscr" id="dscr" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.PrepaidDscrTableVO">
                            <nested:hidden property="prepaidDscrId" />
                            <nested:hidden property="statusIdPrev" />
                            <nested:hidden property="commentsPrev" />
                            <%
                                String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
                                String fontColor="#000000";
                            %>
                            <tr>
                                <td align="center" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="awbNbr" /></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="shipDate" formatKey="app.format.Date" /></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="courierId" /></font></td>
                                <td align="left" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="discrepancyFound" /></font></td>
                                <td align="left" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="discrepancyRsn" /></font></td>
                                <td align="right" bgcolor="<%=bgColor%>" height="19" ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="freightAmtInVisa" formatKey="app.format.NumberFormat" /></font></td>
                                <td align="right" bgcolor="<%=bgColor%>" height="19" ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="pux16Amount" formatKey="app.format.NumberFormat" /></font></td>
                                <td align="right" bgcolor="<%=bgColor%>" height="19" ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="couponAmount" formatKey="app.format.NumberFormat" /></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="paymentCurrency" /></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:text style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" property="comments" maxlength="35" /></font></td>
                                <td align="center" bgcolor="<%=bgColor%>" height="19" >
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