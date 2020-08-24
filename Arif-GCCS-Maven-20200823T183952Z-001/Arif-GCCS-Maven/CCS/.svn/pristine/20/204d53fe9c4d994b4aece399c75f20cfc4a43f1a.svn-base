<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
   String action  = (String)request.getAttribute("action");
   String locationCd  = (String)request.getAttribute("locationCd");
%>
<script language="JavaScript">
	     opener.document.location.href ="<html:rewrite page="/Admin/AdminLocation.do" />?action=<%=action%>&locationCd=<%=locationCd%>";
	     window.close();
</script>