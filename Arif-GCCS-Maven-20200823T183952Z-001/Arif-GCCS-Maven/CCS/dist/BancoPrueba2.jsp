<%@page contentType="text/html"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%@page import="javax.naming.*" %>
<%@page import="java.util.*" %>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*" %>
<%@page import="com.fedex.lacitd.cashcontrol.datatier.manager.*" %>
<%@page import="com.fedex.lacitd.cashcontrol.datatier.common.*" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%
  response.setHeader("Cache-Control","no-store"); 
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0); 
  

        Connection conn=null;
        CallableStatement cs=null;
        ResultSet rs=null;
        try{
            Properties prop=new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            prop.put(Context.PROVIDER_URL, "t3://161.135.161.107:9999");

            //InitialContext c=new InitialContext(prop);
            InitialContext c=new InitialContext();
            DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);
            conn=ds.getConnection();

			int count=0;
			StringBuffer sb=null;
  		    sb=new StringBuffer("" +
                      "DELETE FROM PARAMETER WHERE PARM_nM='dtrc.endLine' AND ROWNUM<3");
            cs=conn.prepareCall(sb.toString()) ;
   		   count=cs.executeUpdate();
		   out.println(count);

        }catch(Exception e){
            out.println("<font color='red'>"+e+"</font>");
        }finally{
            try{
                if(rs!=null) rs.close();
            }catch(Exception e){}
            try{
                if(cs!=null) cs.close();
            }catch(Exception e){}
            try{
                if (conn!=null) conn.close();
            }catch(Exception e){}

            rs=null;
            cs=null;
            conn=null;
        }


%>
