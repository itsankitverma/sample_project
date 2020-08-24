<%@ page import="java.sql.CallableStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="com.fedex.lacitd.cashcontrol.biztier.common.Constants"%>
<%@ page import="com.fedex.lacitd.cashcontrol.common.Utils"%>
<%@ page import="java.io.BufferedInputStream"%>
<%@ page import="java.io.FileOutputStream"%>
<%@ page import="java.io.BufferedOutputStream"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.util.Properties"%>
<%@ page import="javax.naming.Context"%>
<%@page contentType="text/html"%>
<%
        CallableStatement cs=null;
        Connection conn=null;
        try{
            Properties prop=new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            prop.put(Context.PROVIDER_URL, "t3://146.18.31.83:9999");

            InitialContext c=new InitialContext(prop);
           // InitialContext c=new InitialContext();
            DataSource ds=(DataSource)c.lookup(Constants.CCSDataSource);
            conn=ds.getConnection();
            cs=conn.prepareCall("BEGIN SP_CURRENT_CASH_RECAP_REPORT(?,?,?); END;");
            cs.setString(1,"AEPA");
            cs.setString(2,"486284");
            cs.registerOutParameter(3,oracle.jdbc.OracleTypes.CLOB);
            cs.execute();

            /*This code is to write the xml to a file. For debugging purposes*/
            InputStream is=cs.getClob(3).getAsciiStream();
      	    BufferedInputStream bis=new BufferedInputStream(is,4000);
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("/opt/bea/data1.xml"));
            byte[] buffer=new byte[4000];
            int count=0;
            while ((count=bis.read(buffer))!=-1){
                bos.write(buffer,0,count);
            }
            bos.flush();


        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            throw new ServletException(e);
        }finally{
           try{
               if (cs!=null) cs.close();
           }catch(Exception e){}
           try{
               if (conn!=null) conn.close();
           }catch(Exception e){}
           cs=null;
           conn=null;
        }

%>
