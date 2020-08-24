<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
   if("updateValues".equals(request.getParameter("action"))){
        Properties prop=new Properties();
        prop.putAll(request.getParameterMap());
        prop.remove("action");

        prop.save(new FileOutputStream("WEB-INF/classes/CCS.properties"),"");


        /*Enumeration params=request.getParameterNames();
        while(params.hasMoreElements()){
            String paramNm=(String)params.nextElement();
            if(!"action".equals(paramNm)){
                prop.pu
            }
        }*/
   }else{ 
      Properties prop=new Properties();
      prop.load(session.getServletContext().getResourceAsStream("WEB-INF/classes/CCS.properties"));

      Set entries=prop.entrySet();

      request.setAttribute("entries",entries);

%>
<html:html> 
<form>
    <input type="hidden" name=action value="updateValues" >
    <table align="center">
        <logic:iterate id="entry" name="entries" >
            <tr>
                <td>
                    <bean:write name="entry" property="key"/>
                </td>
                <td>
                    <input type="text" name="<bean:write name="entry" property="key"/>" value="<bean:write name="entry" property="value"/>" >
                </td>
            </tr>
        </logic:iterate>
            <tr>
                <td colspan="2" align="center"><input type="submit" align="center"></td>
            </tr>
    </table>    
</form>
</html:html>
<%}%>