<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<script language="JavaScript">
    <%String tableName = (String) request.getAttribute("tableName"); %>
    opener.document.location.href ="<html:rewrite page="/Admin/AdminTablesManager.do"/>?tableName=<%=tableName%>";
    window.close();
</script>