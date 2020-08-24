<%@ page import="java.util.Collection,
                 com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminLocationForm"%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean1" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<script language="JavaScript">
		function closeWindow() {
            window.close();
        }

		function save(action) {
            var f = document.forms['AdminLocationForm'];
		    f.action.value = action;
		    f.submit();
		}
</script>
<html:errors/>
<html:form action="/Admin/AdminLocation.do">
    <bean1:define name="AdminLocationForm" property="locations" id="locations" />
    <input type="hidden" name="action" value="">
    <html:hidden property="countryCd"/>
    <html:hidden property="localDefaultAccount"/>
    <html:hidden property="usdDefaultAccount"/>

    <table border="0" width="100%" bgcolor="#000000" cellspacing="1" cellpadding="0">
        <tr>
            <td bgcolor="#73148C" colspan="2" height="18">
                <b><font color="#FFFFFF" face="Arial" size="2">&nbsp;
                <bean:message key="app.messages.addLocation"/></font></b>
            </td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" width="20%">
                <bean:message key="app.messages.baseLocationCode"/>
            </td>
            <td bgcolor="#FFFFFF" width="80%">
                <html:select property="locationCd">
                    <html:options collection="locations" property="locationCd" labelProperty="locationCd"/>
                </html:select>
            </td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" width="20%">
                <bean:message key="app.messages.locationName"/>
            </td>
            <td bgcolor="#FFFFFF">
                <html:text property="locationNm" size="5" maxlength="5"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" bgcolor="#FFFF9C" align="center">
                <html:link href="javascript:save('saveLocation');"><img align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
                <html:link href="javascript:closeWindow();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
            </td>
        </tr>
    </table>
</html:form>