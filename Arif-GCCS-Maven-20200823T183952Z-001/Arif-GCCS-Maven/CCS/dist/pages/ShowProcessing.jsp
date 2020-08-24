<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<script>
    window.onblur=window.focus;
</script>
<html:html locale="true">
<head>
<title>...</title>
</head>
<body onblur="this.focus();">
    <img src="<html:rewrite page="/images/" /><bean:message key="app.urls.processing" />">
</body>
</html:html>
