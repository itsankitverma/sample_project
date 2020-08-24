<%@page contentType="text/html"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="java.sql.*,
                com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CommonOpsBizDelegate" %>
<%@page import="javax.sql.*" %>
<%@page import="javax.naming.*" %>
<%@page import="java.util.*" %>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<logic:notPresent name="userProfile" scope="session">
    <logic:redirect forward="login" />
</logic:notPresent>
<%
  response.setHeader("Cache-Control","no-store"); 
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0); 
%>
<%!
    public void processIt(HttpServletRequest request,JspWriter out)throws Exception{
        try{
            new CommonOpsBizDelegate().moveToSYDX();
            out.println("<font color='blue'>AWB were processed successfully.</font>");
        }catch(Exception e){
            out.println("<font color='red'>"+e.toString()+"</font>");
        }
    }

%>

<%
    if("PROCESS".equals(request.getParameter("action"))){ 
	    	processIt(request,out);
    }
%>
<HTML>
<TITLE>Move X's Payments to SYDX</TITLE>
<form method="POST">
<input type="hidden" name="action" value="PROCESS">
<table border="1" align="center">
    <tr>
        <td colspan=2 align=center><input type="submit" value="Move to SYDX" ></td>
    </tr>    
</table>
</form>
    <table width='60%'>
        <tr>
			<td align=right><a href='<html:rewrite  page="/pages/Menu.jsp"/>'>Go to Menu</a></td>
        </tr> 
    </TABLE>
</HTML>