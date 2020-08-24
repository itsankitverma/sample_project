<%--
  DateEmployee.jsp - Shows the date and the employee name.
  Requirements: <varname> <scope><type><description>
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%
    SimpleDateFormat sdf=new SimpleDateFormat("EEEEEEEEEEEEE , MMMMMMMMMMMM dd, yyyy",Locale.ENGLISH);
%>
<table align="center" class="ArialBold14Center" width="100%">
      <tr>
          <td class="ArialBold14Center"  bgcolor="orange" width="20%" align="right">Date: </td>
          <td class="ArialBold14Center" width="30%" align="left"><%=sdf.format(new Date())%></td>
          <td class="ArialBold14Center" bgcolor="orange" width="20%" align="right">Employee: </td>
          <td class="ArialBold14Center" width="30%" align="left">12345678</td>
      </tr>
</table>

