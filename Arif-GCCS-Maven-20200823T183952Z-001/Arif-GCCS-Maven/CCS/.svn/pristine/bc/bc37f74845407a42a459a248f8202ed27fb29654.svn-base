<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.prestier.helper.*"%>
<%@ page import="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>
<nested:form action="/Ground/AddGrndTrakNbrs.do" method="POST">
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>

<logic:present name="submitParent">
    opener.document.forms[0].submit();
</logic:present>


    function handlePress(e,obj) {

      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            var form=document.forms['AddGrndTrakNbrsForm'];
            var trakNbr=obj.value; //extractAWB(obj.value);

            if (trakNbr.length > 15)
            {   trakNbr = trakNbr.substr(trakNbr.length - 15  , trakNbr.length);}

            if(validaGndTrakNbr(trakNbr)){
                obj.value=trakNbr;
                var index=Number(findIndex(obj.name,0))+1
                if (eval("form.elements['trakNbrs["+index+"].grndTrakNbr']")){
                        eval("form.elements['trakNbrs["+index+"].grndTrakNbr']").focus();
                }else{
                        document.links[0].focus();
                }
            }else{
                obj.value="";
            }
      }
    }


    function validateEnteredTrakNbr(obj){
        if(obj.value.length>0){
            var form=document.forms['AddGrndTrakNbrsForm'];
            var trakNbr=obj.value;

            if (trakNbr.length > 15)
            {   trakNbr = trakNbr.substr(trakNbr.length - 15  , trakNbr.length);}

            if(validaGndTrakNbr(trakNbr)){
                obj.value=trakNbr;
            }else{
                obj.select();
                alert("<bean:message key="app.messages.js.MustEnterAValidGroundTrakingNumber" />");
                obj.focus();
            }
        }
    }

    function findIndex(name,after){
        var from=name.indexOf("[",after)+1;
        var to=name.indexOf("]",after);
        return name.substr(from,to-from);
    }

    function validate(){
        var form=document.forms['AddGrndTrakNbrsForm'];
        var msg="";

        if(form.elements['courierId'].value=="" || form.elements['courierId'].length==0){
            msg=msg+"<bean:message key="app.messages.js.CourierRequired" />";
            return msg;
        }  

        if(isNaN(form.elements['exchRate'].value)){
            msg=msg+"<bean:message key="errors.messages.ExchangeRateUsedInvalid"/>";
            return msg;
        }else if(form.elements['exchRate'].value==""){
                 msg=msg+"<bean:message key="errors.messages.ExchangeRateUsedRequired" />";
                 return msg;
        }else if(form.elements['exchRate'].value<1){
            msg=msg+"<bean:message key="app.messages.ValidExchRate" />";
            return msg;
        }

        var index=0;
        while(eval("form.elements['trakNbrs["+index+"].grndTrakNbr']")){
            if(validaGndTrakNbr(eval("form.elements['trakNbrs["+index+"].grndTrakNbr']").value)) return "";
            index++
        }

        return "<bean:message key="app.messages.js.MustEnterAtLeastOneTrakNbr" />"; //it is executed only if the grndTrakNbr are empty
    }

    function submitForm(){
        var form=document.forms['AddGrndTrakNbrsForm'];
        var msg=validate();
        if(msg==""){
            document.forms['AddGrndTrakNbrsForm'].submit();
        }else{
            alert(msg);
        }
    }
</script>
<input type="hidden" name="action" value="SaveTrakNbrs">
<bean:define id="frm" name="AddGrndTrakNbrsForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.AddGrndTrakNbrsForm"/>
                <table width="257" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000">
                  <tr width="100">
                    <td height="26" width="40%" bgcolor="#C0C0C0" ><div align="center"><font face="Arial" size="1"><bean:message key="app.messages.Currency" /></font></div></td>
                    <td height="26" width="60%"  align="left" bgcolor="#FFFFFF" > <nested:select property="currentCurrency" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" >
                      <option value="">Select</option>
                      <html:optionsCollection name="userProfile" property="supportedCurrencies" label="currencyCode" value="currencyCode" /> </nested:select> </td>
                  </tr>
                  <tr>
                    <td height="26" width="40%" bgcolor="#C0C0C0"><div align="center"><font face="Arial" size="1"><bean:message key="app.messages.ExchangeRate" /></font></div></td>
                    <td height="26" width="60%" align="left" bgcolor="#FFFFFF" ><font face="Arial" size="1">
                        <nested:text property="exchRate" value="<%=formatter.format(frm.getExchRate()==0?1:frm.getExchRate())%>"/></font></td>
                  </tr>
                </table>
<table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#808080">
    <tr>
	   <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" height="1"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
    </tr>
    <tr>
	   <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
		<td  width="1" bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/spacer.gif" />" height="3"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
    </tr>

    <tr>
      <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
      <td bgcolor="#FFFF9C">

	<!--  ******************************************** -->     
	  <table border="0" bgcolor="#808080" cellspacing="1" cellpadding="0" width="99%" bordercolor="#000000" align="center">
	    <tr> 
	    	<td width="972" align="center" bgcolor="#73148C" colspan="10"><b><font color="#FFFFFF" face="Arial" size="3">
	    	<bean:message key="app.messages.GroundPickupsCashCollectedbyCourier" />
                        <c:choose>
                            <c:when test="${AddGrndTrakNbrsForm.courierId != null}">
                                <html:text name="AddGrndTrakNbrsForm" property="courierId" size="10"/>
                            </c:when>
                            <c:otherwise>
                                <bean:define id="checkInAgent" name="userProfile" property="employeeId" scope="session"/>
                                <html:text name="AddGrndTrakNbrsForm" property="courierId" value="${checkInAgent}"size="10"/>
                            </c:otherwise>
                        </c:choose>
                </font></b></td>
	    </tr>
	    <tr>
<nested:iterate property="trakNbrs" indexId="idx">
              <%if(idx.intValue()!=0 && idx.intValue()%5==0) out.println("</tr><tr>");%>    
	      <td width="79" bgcolor="#C0C0C0" align="left"><font face="Arial" size="2">NBR</font></td>
	      <td width="79" bgcolor="#FFFFFF" align="center">
                 <nested:text property="grndTrakNbr" size="15" maxlength="25" onkeypress="handlePress(event,this);" onblur="validateEnteredTrakNbr(this)"/>
              </td>   
</nested:iterate>    
            </tr>
	    <tr>
	      <td width="798" bgcolor="#FFFFFF" align="CENTER" colspan="10"><font face="Arial" size="2">
                 <bean:message key="app.messages.UseGun" /></font></td>
	    </tr>
	  </table>      
		 <p align="center">
                    <a name="saveLink" href="javascript:submitForm()"><img name="saveImg" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" width="114" height="38"></a>
                    <a name="saveLink" href="javascript:document.forms['AddGrndTrakNbrsForm'].reset();"><img name="saveImg" border="0" src="<html:rewrite page="/images/Reset" /><bean:message key="app.Language" />.gif" width="114" height="38"></a>
                 </p>
		 </form>
	 	<!--  ****************** END *********************** -->     
      </td>
      <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
    </tr>
    <tr>
	   <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" height="1"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
    </tr>
  </table>
</nested:form>
<br>
<html:errors />
<script>
    document.forms['AddGrndTrakNbrsForm'].elements['trakNbrs[0].grndTrakNbr'].focus();
</script>
