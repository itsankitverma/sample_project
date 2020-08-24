<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic-el.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>


<SCRIPT>

        var notSavedChanges=false;

	function move(op){
		var frm=document.forms['PaymentsAdminForm'];
		var src;
		var trg;
                var selectedCount=Number(0);

                var sortingLimit=50;

		if(op=="add"){
			src=frm.allLocations;
			trg=frm.paymentLocations;
		}else{
			src=frm.paymentLocations;
			trg=frm.allLocations;
		}



		for(i=src.length-1;i>=0;i--){
			if(src.options[i].selected){
                                selectedCount++;
                                
                                if(selectedCount>sortingLimit || trg.length>sortingLimit){
                                     trg.options[trg.length]=new Option(src.options[i].text,src.options[i].value);
                                }else{
                                    for(j=trg.length;j>=0;j--){ //to keep the options sorted if this does not take so much time.

                                            if(j==0 || trg.options[j-1].text<=src.options[i].text){
                                                    trg.options[j]=new Option(src.options[i].text,src.options[i].value);
                                                    break;
                                            }else{
                                                    trg.options[j]=new Option(trg.options[j-1].text,trg.options[j-1].value);;
                                            }
                                    }
                                }
				src.options[i]=null;
			}
		}

                if(selectedCount>0) notSavedChanges=true;
	}

	function resetPayment(){

		var frm=document.forms['PaymentsAdminForm'];
		
		frm.elements['currentPayment.paymentTypeId'].selectedIndex=0;
		frm.elements['currentPayment.shtDesc'].value="";
        frm.elements['currentPayment.paymentCd'].value="";
        frm.elements['currentPayment.description'].value="";

		frm.elements['currentPayment.paymentCtgId'].selectedIndex=0;       

		var sel=frm.paymentLocations;
		var i;
        for(i=0;i<sel.length;i++) sel.options[i].selected=true;
        move("remove");
            
	}

	function moveAll(op){
            
            
		var frm=document.forms['PaymentsAdminForm'];
		var sel;
                var msg;

		if(op=="add"){
			sel=frm.allLocations;
                        msg="<bean:message key="app.messages.js.AddAllLocations" />";
		}else{
			sel=frm.paymentLocations;
                        msg="<bean:message key="app.messages.js.RemoveAllLocations" />";
		}
                
                if(confirm(msg)){
                    for(i=0;i<sel.length;i++) sel.options[i].selected=true;
                    move(op);
                }    


	}

        function editPayment(){
            if(!notSavedChanges || confirm("<bean:message key="app.messages.js.UnSavedChanges" />")){
                var frm=document.forms['PaymentsAdminForm'];
                
                if(frm.elements['currentPayment.paymentTypeId'].selectedIndex==0){
                	alert('<bean:message key="app.messages.MustSelectAPaymentType" />');
                	return;
                }

                //frm.elements['currentPayment.paymentTypeId'].value=paymentTypeId;
                prepareLocations();
                frm.submit();
            }    
        }

        function deletePayment(){
            if(!notSavedChanges || confirm("<bean:message key="app.messages.js.UnSavedChanges" />")){
                var frm=document.forms['PaymentsAdminForm'];
                
                if(frm.elements['currentPayment.paymentTypeId'].selectedIndex==0){
                	alert('<bean:message key="app.messages.MustSelectAPaymentType" />');
                	return;
                }
                

                //frm.elements['currentPayment.paymentTypeId'].value=paymentTypeId;
                prepareLocations();
                frm.action.value="delete";
                frm.submit();
            }    
        }

        function prepareLocations(){
                var frm=document.forms['PaymentsAdminForm'];
                var sel=frm.paymentLocations;
		for(i=0;i<sel.length;i++) sel.options[i].selected=true;

                frm.allLocations.selectedIndex=-1;
        }

        function validate(){
                var result=""; 
                var frm=document.forms['PaymentsAdminForm'];

                if(frm.elements['currentPayment.shtDesc'].value.length==0 ||
                   frm.elements['currentPayment.paymentCd'].value.length==0 ||
                   frm.elements['currentPayment.description'].value.length==0
                   ){
                        result="<bean:message key="app.messages.js.MustEnterAllField" />";
                }

                return result;
        }


        function save(){
                var frm=document.forms['PaymentsAdminForm'];
                var result=validate();
                if(result!=""){
                    alert(result);
                }else{
                    frm.action.value="save";
                    prepareLocations();
                    frm.submit();
                }                
        }

        function close(){
            if(!notSavedChanges || confirm("<bean:message key="app.messages.js.UnSavedChanges" />")){
                document.location.href="<html:rewrite page="/pages/Admin/AdminIndex.jsp" />";
            }    
        }

</SCRIPT>



<html:errors />
<nested:form method="post" action="/Admin/PaymentTypesAdmin.do">    
    <input type="hidden" name="action" >
<div align="center">
	<table border="0" width="800" cellspacing="0" cellpadding="0" bgcolor="#000000" style="border-collapse: collapse" bordercolor="#111111" height="219">
	  <tr>
			<td bgcolor="#808080" width="4" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="2" width="447" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="4" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="4" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="2" width="447" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="4" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>	  
	  <tr>
		<td bgcolor="#808080" width="4" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="223" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="224">
			&nbsp;</td>
		<td bgcolor="#808080" width="4" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="center" valign="middle" colspan="2" height="34">
			<b><font face="Arial" size="2"><br><p align="center"><bean:message key="app.messages.Payments" />:      


				<nested:select property="currentPayment.paymentTypeId">

                    <option value=""></option>
                    <c:forEach var="payment" items="${PaymentsAdminForm.allPayments}">
                        <c:if test="${payment.paymentTypeId gt 5}">
                            <html:option value="${payment.paymentTypeId}"><c:out value="${payment.paymentCd}"/></html:option>
                        </c:if>
                    </c:forEach>

                    <%--
                    <nested:greaterThan property="currentPayment.allPayments.paymentTypeId" value="5">
                         <nested:optionsCollection property="allPayments" label="paymentCd" value="paymentTypeId" />
                    </nested:greaterThan>
                    --%>
                </nested:select>

                <b><font face="Arial"><a href="javascript:editPayment();">
                    <font size="2"><bean:message key="app.messages.Edit" /></font></a><font size="2"> </font>
             <a href="javascript:deletePayment();"><font size="2" face="Arial"><bean:message key="app.messages.Delete" /></font></a>
             </font> <font size="2"> </font>
             <a href="javascript:resetPayment();"><font size="2" face="Arial"><bean:message key="app.messages.New" /></font></a></p>
             </font></b></p></td>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
	  </tr>	 	  
	  <tr>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22">
			<b><font face="Arial" size="2"><bean:message key="app.messages.Code" />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="224">
			<font face="Arial">
			<nested:text property="currentPayment.paymentCd" onchange="notSavedChanges=true;" maxlength="6" /></font></td>
		<td bgcolor="#808080" width="4" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22">
			<b><font face="Arial" size="2"><bean:message key="app.messages.ShortDescription" />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="224">
			<font face="Arial">
			<nested:text property="currentPayment.shtDesc" onchange="notSavedChanges=true;" maxlength="10" /></font></td>
		<td bgcolor="#808080" width="4" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22">
			<b><font face="Arial" size="2"><bean:message key="app.messages.Description"  />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="224">
			<font face="Arial">
			<nested:text property="currentPayment.description" onchange="notSavedChanges=true;" maxlength="30" /></font></td>
		<td bgcolor="#808080" width="4" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22">
			<b><font face="Arial" size="2"><bean:message key="app.messages.PaymentCategory" />&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="224">
			<font face="Arial">
                        <nested:select property="currentPayment.paymentCtgId" onchange="notSavedChanges=true;"  >
                            <html:optionsCollection name="PaymentsAdminForm" property="paymentCtg" label="description" value="paymentCtgId"  />
                        </nested:select></font></td>
		<td bgcolor="#808080" width="4" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="223" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="224">
			&nbsp;</td>
		<td bgcolor="#808080" width="4" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="200">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1"></font></td>
		<td bgcolor="#FFFF9C" align="center" colspan="2" height="200">
			<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" id="AutoNumber1" width="254" >
              <tr>
		<td bgcolor="#FFFF9C" height="230" width="106">
			<p align="center">
			<nested:select property="allLocations" multiple="true"  size="11"  style="width:80" >
                            <nested:options property="allLocations" />
                        </nested:select></td>
		<td bgcolor="#FFFF9C" height="230" width="103">
			<p align="center"><input type="button"  onclick="moveAll('add');" value="&gt;&gt;" name="B3"></p>
            <p align="center"><input type="button"  onclick="move('add');" value=" &gt; " name="B2"></p>
            <p align="center"><input type="button"  onclick="move('remove');" value=" &lt; " name="B1"></p>
            <p align="center"><input type="button"  onclick="moveAll('remove');" value="&lt;&lt;" name="B4"></td>
		<td bgcolor="#FFFF9C" height="230" width="103">
			<p align="center">                        
                        <nested:select property="paymentLocations" multiple="true" size="11" style="width:80" >
                            <nested:options property="paymentLocations" />
                        </nested:select>
</td>
		      </tr>
            </table>
		 </td>
		<td bgcolor="#808080" width="4" height="200"><img border="0" src="pixel.gif" width="1"></td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="4" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#FFFF9C" colspan="2"height="3"><p align="center"><html:link href="javascript:save();" ><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link><html:link href="javascript:close()" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38"></html:link></p></td>
			<td bgcolor="#808080" width="4" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
	  </tr>


         <tr>
 	     <td bgcolor="#808080" width="4" height="22"> &nbsp;</td>
               <td bgcolor="#FFFF9C" height="22" width="100%" colspan="2">
                    &nbsp;
               </td>
        <td bgcolor="#808080" width="4" height="22">&nbsp;</td>
    </tr>

           <tr>	
                <td bgcolor="#808080" width="4" height="66">
					&nbsp;
				</td>
				<td bgcolor="#FFFF9C" colspan="2" align="center">
					<TABLE border="0" width="500px">
						<TR>
							<TD>
								<font face="Arial" size="2" color="red"> <b>
                              <bean:message key="app.messages.LimitedShow" />
                                </b> </font>
							</TD>
						</TR>
					</TABLE>
				</td>
				<td bgcolor="#808080" width="4" height="22">
					&nbsp;
				</td>
			</tr>







      <tr>
		<td bgcolor="#808080" width="4" height="84">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1"></font></td>
		<td bgcolor="#FFFF9C" align="center" colspan="2" height="84">
		 <%--table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" id="AutoNumber2" align="center">
           <tr>
             <td width="25%" bgcolor="#800080" align="center"><b>
             <font color="#FFFFFF" face="Arial" size="2"><bean:message key="app.messages.Code" /></font></b></td>
             <td width="35%" bgcolor="#800080" align="center"><b>
             <font color="#FFFFFF" size="2" face="Arial"><bean:message key="app.messages.ShortDescription" /></font></b></td>
             <td width="25%" bgcolor="#800080" align="center"><b>
             <font face="Arial" color="#FFFFFF" size="2"><bean:message key="app.messages.Description" /></font></b></td>
             <td width="22%" bgcolor="#800080" align="center">&nbsp;</td>
           </tr>
           <nested:iterate property="allPayments">
           <tr>
             <td width="25%" align="center"><font face="Arial" size="2"><nested:write property="paymentCd" /></font></td>
             <td width="35%" align="center"><font face="Arial" size="2"><nested:write property="shtDesc" /></font></td>
             <td width="25%" align="center"><font face="Arial" size="2"><nested:write property="description" /></font></td>
             <td width="22%">
             <nested:equal property="canDeact" value="1"> 
             <p align="center"><b><font face="Arial"><a href="javascript:editPayment(<nested:write property="paymentTypeId" />);">
             <font size="2"><bean:message key="app.messages.Edit" /></font></a><font size="2"> </font></font>
             <a href="javascript:deletePayment(<nested:write property="paymentTypeId" />);"><font size="2" face="Arial"><bean:message key="app.messages.Delete" /></font></a></b>
             </nested:equal> 
            </td>
           </tr>
           </nested:iterate>
         </table--%>
		 </td>
		<td bgcolor="#808080" width="4" height="84"><img border="0" src="pixel.gif" width="1"></td>
	  </tr>	  
	  <tr>
		<td bgcolor="#808080" width="4" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="223" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="224">
			&nbsp;</td>
		<td bgcolor="#808080" width="4" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="447" colspan="2" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="4" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="447" colspan="2" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="4" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>

</table>
    </div>
</nested:form>
<script>
document.forms['PaymentsAdminForm'].allLocations.selectedIndex=-1;
document.forms['PaymentsAdminForm'].paymentLocations.selectedIndex=-1;
</script>