<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<script language="JavaScript">
    opener.document.location.href ="<html:rewrite page="/Prepaid/PrepaidDetails.do" />";
    window.close();
</script>