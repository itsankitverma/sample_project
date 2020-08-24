<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<SCRIPT>

	function save(){
		var frm=document.forms['EntitiesAdminForm'];
        frm.action.value='save';
        frm.submit();
    }

	function cancel(){
		var frm=document.forms['EntitiesAdminForm'];
        frm.elements['entity.entCd'].value='';
        frm.submit();
    }

	function resetEntity(){
		var frm=document.forms['EntitiesAdminForm'];
        frm.action.value='newEnt';
        frm.submit();
    }

	function showEntity(){
		var frm=document.forms['EntitiesAdminForm'];
        frm.submit();
    }

	function deleteEntity(){
		var frm=document.forms['EntitiesAdminForm'];
        frm.action.value='delete';
        frm.submit();
    }

     function checkNerForPoa(){
      	var frm=document.forms['EntitiesAdminForm'];
        var ner= frm.elements['entity.nerCd'].value;
        if(ner=='')  {
             alert('You cannot change the poa upload flag to yes, when NER Code is blank');
             frm.elements['entity.poaUpldOceanFlg'].value=0;
        }
     }

</SCRIPT>
<html:errors />
<nested:form method="post" action="/Admin/EntitiesAdmin.do">
    <input type="hidden" name="action" >
<div align="center">
	<table border="0" width="802" cellspacing="0" cellpadding="0" bgcolor="#000000" style="border-collapse: collapse" bordercolor="#111111" height="238">
	  <tr>
			<td bgcolor="#808080" width="7" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="2" width="785" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="10" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="7" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="2" width="785" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="10" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="392" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="393">
			&nbsp;</td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">Entity &nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393"><% if("newEnt".equals(request.getParameter("action"))){%>
                <nested:text property="entity.entCd" maxlength="3" size="5"/>
<% }else{%>
				<nested:select property="entity.entCd" onchange="showEntity()" >
                    <option value=""></option>
					<nested:optionsCollection property="entities" label="key" value="value" />
				</nested:select>
<% }%>
                <font face="Arial">
             <a href="javascript:deleteEntity();"><font size="2" face="Arial">Delete</font></a>
             </font> <font size="2"> </font>
             <a href="javascript:resetEntity();"><font size="2" face="Arial">New</font></a>
            <font size="2"> </font>
             <a href="javascript:cancel();"><font size="2" face="Arial">Cancel</font></a>
             <a href="<html:rewrite page="/Admin/EntitiesAcctAdmin.do" />"><font size="2" face="Arial">PS Accounts Configuration</font></a>
             </td>
		<td bgcolor="#808080" width="10" height="22">
			&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">Country&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entity.cntryCd" maxlength="2" size="5"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">Region&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entity.regionCd" maxlength="10" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">Subregion&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entity.subRegionCd" maxlength="10" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392" dir="ltr">
			<b><font face="Arial" size="2">NER Code&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393" dir="ltr">
			<font face="Arial">
			<nested:text property="entity.nerCd" maxlength="10" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<b><font face="Arial" size="2">GL Entity Code&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entity.glEntCd" maxlength="3" size="5"/></font></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
      <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<b><font face="Arial" size="2">RIH Entity Code&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entity.rihEntCd" maxlength="3" size="5"/></font></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<b><font face="Arial" size="2">GL Currency Code&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entity.glCurrCd" maxlength="3" size="5"/></font></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<b><font face="Arial" size="2">PS Operator ID&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entity.psOprEmpId" maxlength="10" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
	  	<td bgcolor="#808080" width="7" height="10">&nbsp;</td>
	  	<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
	  	<p dir="ltr"><b><font face="Arial" size="2">DTRC Upload Activation&nbsp;&nbsp;&nbsp;</font></b></p>
	  	</td>
	  	<td bgcolor="#FFFF9C" height="22" width="393">
	  	<b><font face="Arial" size="2">
		  	<nested:select property="entity.dtrcUpldActFlg">
		  		<html:option value="0">No</html:option>
		  		<html:option value="1">Yes</html:option>
		  	</nested:select>
	  	</font></b>
	  	</td>
	  	<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  
	  <tr>
	  	<td bgcolor="#808080" width="7" height="10">&nbsp;</td>
	  	<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
	  	<p dir="ltr"><b><font face="Arial" size="2">POA Upload Activation&nbsp;&nbsp;&nbsp;</font></b></p>
	  	</td>
	  	<td bgcolor="#FFFF9C" height="22" width="393">
	  	<b><font face="Arial" size="2">
		  	<nested:select property="entity.poaUpldOceanFlg" onchange="checkNerForPoa()">
		  		<html:option value="0">No</html:option>
		  		<html:option value="1">Yes</html:option>
		  	</nested:select>
	  	</font></b>
	  	</td>
	  	<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  
	  <!-- 
		  Changes : Added some more fields in the form
		  Modified By : Kapil Rana
	      Fields Added : rodUpldActFlg, prpUpldActFlg, grdUpldActFlg, othUpldActFlg, ftcUpldActFlg, paymentAccountNbr 
	   -->
    	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2"><bean:message key="app.messages.RODUploadActivation" />&nbsp;&nbsp;&nbsp;</font></b>
			</p>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
	  	<b><font face="Arial" size="2">
		  	<nested:select property="entity.rodUpldActFlg" onchange="checkNerForPoa()">
		  		<html:option value="0">No</html:option>
		  		<html:option value="1">Yes</html:option>
		  	</nested:select>
	  	</font></b>
	  	</td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
    	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2"><bean:message key="app.messages.PRPUploadActivation" />&nbsp;&nbsp;&nbsp;</font></b>
			</p>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
	  	<b><font face="Arial" size="2">
		  	<nested:select property="entity.prpUpldActFlg" onchange="checkNerForPoa()">
		  		<html:option value="0">No</html:option>
		  		<html:option value="1">Yes</html:option>
		  	</nested:select>
	  	</font></b>
	  	</td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>

    	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2"><nested:message key="app.messages.GRDUploadActivation" />&nbsp;&nbsp;&nbsp;</font></b>
			</p>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<b><font face="Arial" size="2">
				<nested:select property="entity.grdUpldActFlg" >
                    <html:option value="0">No</html:option>
                    <html:option value="1">Yes</html:option>
                </nested:select>
                </font></b>
                </td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  
    	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2"><nested:message key="app.messages.OTHUploadActivation" />&nbsp;&nbsp;&nbsp;</font></b>
			</p>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<b><font face="Arial" size="2">
				<nested:select property="entity.othUpldActFlg" >
                    <html:option value="0">No</html:option>
                    <html:option value="1">Yes</html:option>
                </nested:select>
                </font></b>
                </td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  
    	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2"><nested:message key="app.messages.FTCUploadActivation" />&nbsp;&nbsp;&nbsp;</font></b>
			</p>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<b><font face="Arial" size="2">
				<nested:select property="entity.ftcUpldActFlg" >
                    <html:option value="0">No</html:option>
                    <html:option value="1">Yes</html:option>
                </nested:select></font></b></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2"><nested:message key="app.messages.paymentAccountNumber" />&nbsp;&nbsp;&nbsp;</font></b>
			</p>
		 </td>
		 <td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entity.paymentAccountNbr" maxlength="20" size="5"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <!--
	  Modification ends here 
	   -->
	  
      <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2">Locations&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<nested:textarea property="locations"/></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="7" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#FFFF9C" colspan="2"height="3" width="785"><p align="center"><a href="javascript:save();"><img  align="middle" border="0" src="/GCCS/images/SaveEn.gif" align="left" width="114" height="38"></a><a href="<html:rewrite page="/pages/Menu.jsp" />"><img align="middle" border="0" src="/GCCS/images/CloseEn.gif" align="left" width="113" height="38"></a></p></td>
			<td bgcolor="#808080" width="10" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="84">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1"></font></td>
		<td bgcolor="#FFFF9C" align="center" colspan="2" height="84" width="785">

		 </td>
		<td bgcolor="#808080" width="10" height="84"><img border="0" src="pixel.gif" width="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" width="392" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" height="10" width="393">
			&nbsp;</td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="785" colspan="2" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="10" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="785" colspan="2" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="10" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
</table>
    </div>
</nested:form>