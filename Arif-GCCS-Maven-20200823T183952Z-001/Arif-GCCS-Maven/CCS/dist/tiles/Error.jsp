<%@page contentType="text/html"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:form action="/Error.do" method="post">

    <html:hidden property="accion" value=""/>

    <table border="0" width="100%" bgcolor="#000000" cellspacing="1" cellpadding="0">
        <tr>
            <td bgcolor="#73148C" colspan="2" height="18">
            </td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" width="20%">
              <b><font color="red" face="Arial">
                      <bean:message key="app.messages.unexpectedError"/>
                 </font>
              </b>
            </td>
        </tr>

        <tr>
            <td colspan="2" bgcolor="#FFFF9C" align="center">
            </td>
        </tr>
    </table>

</html:form>

