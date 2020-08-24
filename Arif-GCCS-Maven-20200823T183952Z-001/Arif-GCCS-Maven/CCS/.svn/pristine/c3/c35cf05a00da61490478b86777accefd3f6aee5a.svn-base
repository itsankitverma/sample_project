<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<logic:notPresent name="userProfile" scope="session">
    <logic:redirect forward="login" />
</logic:notPresent>
<logic:empty name="userProfile" property="locationCd">
    <logic:redirect forward="selectLocation" />
</logic:empty>

<tiles:insert definition="AdminLocationSetup" flush="true" />
