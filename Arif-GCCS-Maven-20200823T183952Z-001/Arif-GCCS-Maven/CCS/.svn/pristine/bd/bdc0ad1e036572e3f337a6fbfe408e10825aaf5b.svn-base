<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%-- TODO: Please when the forms be in the request scope you have to remove this ugly code --%>
<%
    session.removeAttribute("RODCourierCashRecapForm");
    session.removeAttribute("PRPCourierCashRecapForm");
    session.removeAttribute("PoaSummaryForm");
    session.removeAttribute("GroundCashRecapForm");
%>
<%--TODO: Until here--%>
<script type="text/javascript">
    function submitForm() {
        if (document.forms['LoginForm'].locationCd.selectedIndex == 0) {
            alert("<bean:message key="app.messages.js.MustSelectALocation" />");
        } else {
            document.forms['LoginForm'].submit();
        }
    }
</script>
<html:errors/>
<html:form action="ChangeLocation.do" method="post">
    <!-- Tabla separadora-->
    <table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#808080">
        <tr>
            <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
        <tr>
            <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="3"/></td>
            <td bgcolor="#FFFF9C"><html:img page="/images/pixel.gif" width="1" height="3"/></td>
            <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="3"/></td>
        </tr>
        <tr>
            <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C" align="center">
                <table border="0" width="98%" cellspacing="1" cellpadding="0">
                    <tr>
                        <td colspan="2" align="center">
                            <b><font face="Arial" color="#73148C" size="5"><br>
                                <bean:message key="app.title"/><br>
                            </font></b>
                        </td>
                        <td rowspan="4" align="center">
                            <html:img page="/images/globalhome_background.jpg" border="0" width="307" height="236"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right"><font face="Arial" size="3"><b><bean:message key="app.EmployeeNumber"/></b></font></td>
                        <td align="center"><b><font face="Arial"><bean:write name="userProfile" property="employeeId"/></font></b></td>
                    </tr>
                    <tr>
                        <td align="right"><font face="Arial" size="3"><b><bean:message key="app.location"/>:</b></font></td>
                        <td align="center">
                            <bean:define id="locs" name="userProfile" property="locations"/>
                            <html:select name="userProfile" property="locationCd">
                                <option value=""><bean:message key="app.messages.Select"/></option>
                                <html:options collection="locs" property="locationCd" labelName="locationCd"/>
                            </html:select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                        </td>
                        <td>
                            <input type="button" onclick="submitForm();" value="<bean:message key="app.submit" />"></td>
                        </tr>
                </table>
            </td>
            <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
        <tr>
            <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C"><html:img page="/images/pixel.gif" width="1" height="5"/></td>
            <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
    </tr>
    <tr bgcolor="#808080">
        <td colspan="3" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
    </tr>
    </table>
</html:form>