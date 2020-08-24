<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.prestier.helper.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<nested:form action="/Prepaid/AddPrepaidAwbs.do" method="POST">
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>

<logic:present name="submitParent">
    opener.document.forms[0].submit();
</logic:present>


  function handlePress(e,obj) {
      obj.value=obj.value.trim();
      var whichCode = (window.Event) ? e.which : e.keyCode;
      if(whichCode==13){
            var form=document.forms['AddPrepaidAwbsForm'];
            var awbNbr=extractAWB(obj.value);

            if(validaAWBNbr(awbNbr)){
                obj.value=awbNbr;
                var index=Number(findIndex(obj.name,0))+1
                if (eval("form.elements['awbs["+index+"].awbNbr']")){
                        eval("form.elements['awbs["+index+"].awbNbr']").focus();
                }else{
                        document.links[0].focus();
                }
            }else{
                obj.value="";
            }
      }
    }


    function validateEnteredAwb(obj){
       obj.value=obj.value.trim();
        if(obj.value.length>0){
            var form=document.forms['AddPrepaidAwbsForm'];
            var awbNbr=extractAWB(obj.value);

            if(validaAWBNbr(awbNbr)){           
                obj.value=awbNbr;
            }else{
                obj.select();
                alert("Please enter a valid AWB field");
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
        var form=document.forms['AddPrepaidAwbsForm'];
        var msg="";
        /*
        if(form.elements['courierId'].value==""){
            msg=msg+"<bean:message key="app.messages.js.CourierRequired" />";
            return msg;
        }  
        */   
        var index=0;
        while(eval("form.elements['awbs["+index+"].awbNbr']")){
            if(validaAWBNbr(eval("form.elements['awbs["+index+"].awbNbr']").value)) return "";
            index++
        }

           return "<bean:message key="app.messages.js.MustEnterAtLeastOneAwb" />"; //it is executed only if the awbs are empty
    }

    function submitForm(){
        var form=document.forms['AddPrepaidAwbsForm'];
        var msg=validate();
        if(msg==""){
            document.forms['AddPrepaidAwbsForm'].submit();
        }else{
            alert(msg);
        }
    }
</script>
<input type="hidden" name="action" value="SaveAwbs">
<nested:hidden property="currentCurrency" />
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
	    	<bean:message key="app.messages.PickupsCashCollectedbyCourier:" /> 
                    <bean:define id="frm" name="AddPrepaidAwbsForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.AddPrepaidAwbsForm"/>
                        <% if(frm.getCourierName()!=null && !frm.getCourierName().equals("")){%>
                            <bean:write name="AddPrepaidAwbsForm" property="courierId"/><html:hidden name="AddPrepaidAwbsForm" property="courierId"/>&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="app.messages.Name:" /> <bean:write name="AddPrepaidAwbsForm" property="courierName"/><html:hidden name="AddPrepaidAwbsForm" property="courierName"/>
                        <%}else{%>    
                            <html:text name="AddPrepaidAwbsForm" property="courierId" size="10"/>
                        <%}%>    
                </font></b></td>
	    </tr>
	    <tr>
<nested:iterate property="awbs" indexId="idx">
              <%if(idx.intValue()!=0 && idx.intValue()%5==0) out.println("</tr><tr>");%>    
	      <td width="79" bgcolor="#C0C0C0" align="left"><font face="Arial" size="2">AWB</font></td>
	      <td width="79" bgcolor="#FFFFFF" align="center">
                 <nested:text property="awbNbr" size="12" maxlength="20" onkeypress="handlePress(event,this);" onblur="validateEnteredAwb(this)" />
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
                    <a name="saveLink" href="javascript:document.forms['AddPrepaidAwbsForm'].reset();"><img name="saveImg" border="0" src="<html:rewrite page="/images/Reset" /><bean:message key="app.Language" />.gif" width="114" height="38"></a>
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
    document.forms['AddPrepaidAwbsForm'].elements['awbs[0].awbNbr'].focus();
</script>
