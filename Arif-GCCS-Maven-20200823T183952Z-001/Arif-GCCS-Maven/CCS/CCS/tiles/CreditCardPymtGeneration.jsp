<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));

    Collection status=new ArrayList();
    status.add(new Entry("0","Pending"));
    status.add(new Entry("1","Reimbursed"));


    pageContext.setAttribute("status",status);
%>
<script>
    function saveCreditCardBatchs(){
        var valid=validate();

        if(valid==""){
            document.forms['CreditCardPymtForm'].action.value='saveCreditCardBatchs';
            document.forms['CreditCardPymtForm'].submit();
        }else{
            alert(valid);
        }    
    }

    function goToMenu(){
        document.location.href='<html:rewrite page="/pages/Menu.jsp" />'
    }

    function addComment(index){
         var allForm=document.forms['CreditCardPymtForm'];
         var commentForm=document.forms['CreditCardPymtCommForm'];

         commentForm.oldComment.value=eval("allForm.elements['creditCardBatchs["+index+"].comments']").value;
         commentForm.currentBatchId.value=eval("allForm.elements['creditCardBatchs["+index+"].creditCardPymtId']").value;
         window.open('','newWindow','toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=500, height=500,left='+((screen.width-500) /2)+',top='+((screen.height-500) / 2));
         commentForm.submit();
    }

    function checkLine(index){
        var form=document.forms['CreditCardPymtForm'];
        var msg="";
        if(eval("form.elements['creditCardBatchs["+index+"].statusId']").selectedIndex==1){
			totalReimbursed=eval("form.elements['creditCardBatchs["+index+"].totalReimbursed']").value;
			paymentDocNbr=eval("form.elements['creditCardBatchs["+index+"].paymentDocNbr']").value;
                        comments=eval("form.elements['creditCardBatchs["+index+"].comments']").value;                        

			if(isNaN(totalReimbursed)){
				msg=msg+"-Credit Card Batch "+ eval("form.elements['creditCardBatchs["+index+"].creditCardPymtId']").value +": <bean:message key="app.messages.js.BadMontos" />\n";				
				return msg;
			}else{
                                totalReimbursed=Number(totalReimbursed);

                                if(totalReimbursed<0){
                                    msg=msg+"-Credit Card Batch "+ eval("form.elements['creditCardBatchs["+index+"].creditCardPymtId']").value +": <bean:message key="app.messages.js.BadMontos" />\n";
                                    return msg;
                                }

                                if(totalReimbursed==0){
                                    msg=msg+"-Credit Card Batch "+ eval("form.elements['creditCardBatchs["+index+"].creditCardPymtId']").value +": <bean:message key="app.messages.js.MustEnterAmounts" />\n";
                                    return msg;
                                }

			}

                        if(paymentDocNbr.length<=1){
                              msg=msg+"-Credit Card Batch "+ eval("form.elements['creditCardBatchs["+index+"].creditCardPymtId']").value +": <bean:message key="app.messages.js.DocNumberNotEntered" />\n";
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
        var form=document.forms['CreditCardPymtForm'];
        var msg="";
        var index=Number("0");
        var some=false;

        while(eval("form.elements['creditCardBatchs["+index+"].creditCardPymtId']")){
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
        var form=document.forms['CreditCardPymtForm'];
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
<nested:form action="/CreditCardPymt"> 
        <input type="hidden" name="action">   
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
                    <p align="center"><html:link href="javascript:saveCreditCardBatchs();" ><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link><html:link href="javascript:goToMenu();" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38"></html:link></p>
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
	    <td align="center" bgcolor="#73148C" width="10%"  height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF">ID</font></td>
	    <td align="center" bgcolor="#73148C" width="15%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.date" /></font></td>
	    <td align="center" bgcolor="#73148C" width="15%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Amount" /></font></td>
   	    <td align="center" bgcolor="#73148C" width="15%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.ReimbursedAmount" /></font></td>
	    <td align="center" bgcolor="#73148C" width="8%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Currency" /></font></td>
	    <td align="center" bgcolor="#73148C" width="8%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Payment" /></font></td>
	    <td align="center" bgcolor="#73148C" width="15%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.PaymentDocument" /></font></td>
   	    <td align="center" bgcolor="#73148C" width="15%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Comments" /></font></td>
	    <td align="center" bgcolor="#73148C" width="15%" height="30"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Status" /></font></td>
          </tr>
<logic:present name="CreditCardPymtForm" scope="request" >
  <nested:iterate property="creditCardBatchs" id="ccb" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.CreditCardPymtTableVO">    
        <nested:hidden property="comments" />
        <nested:hidden property="creditCardPymtId" />
        <nested:hidden property="totalReimbursedPrev" />
        <nested:hidden property="paymentDocNbrPrev" />
        <nested:hidden property="statusIdPrev" />
    <%  
        String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
        String fontColor="#000000";
    %>
	  <tr>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:write property="creditCardPymtId" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="batchDt" formatKey="app.format.Date" /></font></td>
   		 <td align="right" bgcolor="<%=bgColor%>" height="19" ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="totalAmt" formatKey="app.format.NumberFormat" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="totalReimbursed"  value="<%=formatter.format(ccb.getTotalReimbursed())%>" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" size="10"/></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19" ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="currencyCd" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19" ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:write property="paymentType" /></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19"  ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:text property="paymentDocNbr" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" size="20"/></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19" ><font color="<%=fontColor%>" size="1" face="Verdana, Arial, Helvetica, sans-serif"><nested:notEmpty property="comments"><html:img page="/images/info.gif" /></nested:notEmpty><a href="javascript:addComment(<%=idx%>);"><bean:message key="app.messages.ViewAdd" /></a></font></td>
   		 <td align="center" bgcolor="<%=bgColor%>" height="19" >
                        <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onchange="changeStatus(this);">
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
<nested:form action="/CreditCardPymtComm" target="newWindow" > 
    <nested:hidden property="oldComment" />
    <nested:hidden property="currentBatchId" />
</nested:form>