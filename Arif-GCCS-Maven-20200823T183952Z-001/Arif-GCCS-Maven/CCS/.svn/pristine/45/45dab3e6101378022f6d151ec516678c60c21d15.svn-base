<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<SCRIPT>

	function save(){
		var frm=document.forms['EntitiesAcctAdminForm'];
        frm.action.value='save';
        frm.submit();
    }

	function cancel(){
		var frm=document.forms['EntitiesAcctAdminForm'];
        frm.elements['entity.entCd'].value='';
        frm.submit();
    }

	function showEntity(){
		var frm=document.forms['EntitiesAcctAdminForm'];
        frm.submit();
    }

	function deleteEntity(){
		var frm=document.forms['EntitiesAcctAdminForm'];
        frm.action.value='delete';
        frm.submit();
    }


</SCRIPT>
<html:errors />
<nested:form method="post" action="/Admin/EntitiesAcctAdmin.do">
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
		<td bgcolor="#FFFF9C" align="center" valign="middle" colspan="2" height="34" width="785">
			<b><font face="Arial" size="2"><br><p align="center">Entity:
				<nested:select property="entityAcct.entCd" onchange="showEntity()" >
                    <option value=""></option>
					<nested:optionsCollection property="entities" label="key" value="value" />
				</nested:select>
                <font face="Arial">
             <a href="javascript:deleteEntity();"><font size="2" face="Arial">Delete</font></a>
             </font> <font size="2"> </font>
             <a href="<html:rewrite page="/Admin/EntitiesAdmin.do" />"><font size="2" face="Arial">Cancel</font></a></p>
             </font></p></td>
		<td bgcolor="#808080" width="10" height="22">
			&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="center" valign="middle" colspan="2" height="34" width="785">
			<b><font face="Arial" size="2"><br><p align="center">Bank Account:
				<nested:select property="entityAcct.bankAccCd" onchange="showEntity()" >
                    <option value="0">ALL ACCOUNTS</option>
					<nested:optionsCollection property="accounts" label="value" value="key" />
				</nested:select>
        </td>
		<td bgcolor="#808080" width="10" height="22">
			&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">PS Loc Curr Dep Acc Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.depLocCurrAccNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">PS USD Dep Acc Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.depUsdCurrAccNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">Cost Center Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.costCenterNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">PS ROD Acc Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.rodAccNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">PS PRP Acc Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.prpAccNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">PS POA Acc Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.poaAccNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">PS WOFF ROD Dbt Acc Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.woffRodDbtAccNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">PS WOFF PRP Dbt Acc Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.woffPrpDbtAccNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="22">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right" height="22" width="392">
			<b><font face="Arial" size="2">PS WOFF Credit Acc Nbr</font>&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<font face="Arial">
			<nested:text property="entityAcct.woffCrdtAccNbr" maxlength="30" size="10"/></font></td>
		<td bgcolor="#808080" width="10" height="22">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2">PS Cash Activation&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<b><font face="Arial" size="2">
				<nested:select property="entityAcct.psCashActFlg" >
                    <html:option value="0">No</html:option>
                    <html:option value="1">Yes</html:option>
                </nested:select></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="7" height="10">
			&nbsp;</td>
		<td bgcolor="#FFFF9C" align="right"  height="22" width="392">
			<p dir="ltr">
			<b><font face="Arial" size="2">PS WOFF Activation&nbsp;&nbsp;&nbsp;</font></b>
		 </td>
		<td bgcolor="#FFFF9C" height="22" width="393">
			<b><font face="Arial" size="2">
				<nested:select property="entityAcct.psWoffActFlg" >
                    <html:option value="0">No</html:option>
                    <html:option value="1">Yes</html:option>
                </nested:select></td>
		<td bgcolor="#808080" width="10" height="10">&nbsp;</td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="7" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#FFFF9C" colspan="2"height="3" width="785"><p align="center"><a href="javascript:save();"><img  align="center" border="0" src="/GCCS/images/SaveEn.gif" align="left" width="114" height="38"></a><a href="<html:rewrite page="/pages/Menu.jsp" />"><img align="center" border="0" src="/GCCS/images/CloseEn.gif" align="left" width="113" height="38"></a></p></td>
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