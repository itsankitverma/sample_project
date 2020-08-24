<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<logic:notPresent name="userProfile" scope="session">
    <logic:redirect forward="login" />
</logic:notPresent>
<logic:empty name="userProfile" property="locationCd">
       <logic:redirect forward="selectLocation" />
</logic:empty>

<% String ac = request.getParameter("accion"); %>
<% if(ac.equals("addLocationRole")){%>
      <tiles:insert definition="AdminNewLocationRole" flush="true" />
<%}else{%>
      <tiles:insert definition="AdminNewEditUser" flush="true" />
<%}%>