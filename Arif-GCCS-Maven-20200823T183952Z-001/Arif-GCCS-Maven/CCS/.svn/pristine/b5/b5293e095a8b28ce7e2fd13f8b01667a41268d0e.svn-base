<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<% String action  = (String)request.getAttribute("accion");
   String country = (String)request.getAttribute("countrySelected");
   String userId  = (String)request.getAttribute("userId");
%>    
<script>
		 <% action = "seeProfile";%>
	     opener.document.location.href ="<html:rewrite page="/Admin/AdminUserList.do" />?accion=<%=action%>&countrySelected=<%=country%>";
	     window.close();
</script>