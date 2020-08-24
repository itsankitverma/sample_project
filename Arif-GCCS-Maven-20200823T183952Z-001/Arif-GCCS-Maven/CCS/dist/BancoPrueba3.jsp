<%@page contentType="text/html"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="java.sql.*,
                com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtilsHome,
                com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtils,
                com.fedex.lacitd.cashcontrol.datatier.dao.SystemUtilsDaoHome,
                com.fedex.lacitd.cashcontrol.datatier.dao.SystemUtilsDao,
                com.fedex.lacitd.cashcontrol.datatier.exception.DAOException" %>
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


      CallableStatement cs=null;
      Connection conn=null;
      ResultSet rs=null;
      try{   /*
        Properties prop=new Properties();
        prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        prop.put(Context.PROVIDER_URL, "t3://gccsapp1.prod.fedex.com:9999");

        InitialContext ic=new InitialContext(prop);
        DataSource ds=(DataSource)ic.lookup(Constants.CCSDataSource);

        conn=ds.getConnection();  */

        Class.forName("oracle.jdbc.OracleDriver");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@gccsdb.prod.fedex.com:1539:GCCSDB","CCSUSER","CCSUSERT");

        cs=conn.prepareCall("BEGIN SP_GET_CURRENCIES_BY_COUNTRY(?,?); END;");

        cs.setString(1,"AR");
        cs.registerOutParameter(2,oracle.jdbc.OracleTypes.CURSOR);

        cs.execute();

        rs=(ResultSet)cs.getObject(2);

        Collection colResults=new ArrayList();

        while(rs.next()){
             SupportedCurrencyVO sc=new SupportedCurrencyVO();
            out.println(rs.getString(1));
             sc.setCurrencyCode(rs.getString(1));
             sc.setCurrencyName(rs.getString(2));
             sc.setCurrencySymbol(rs.getString(3));
             sc.setDefaultCurrency(rs.getInt(4)==1);
             colResults.add(sc);
        }

      }catch(Exception e){
          throw new DAOException(e.getClass().getName() +" has ocurred in the  method of the SystemUtilsDaoBean class",e);
      }finally{
            try{
                if(rs!=null) rs.close();
            }catch(Exception e){}
            try{
                if (cs!=null) cs.close();
            }catch(Exception e){}
            try{
                if (conn!=null) conn.close();
            }catch(Exception e){}

           rs=null;
           cs=null;
           conn=null;
        }

  /*
        try{
            Properties prop=new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            prop.put(Context.PROVIDER_URL, "t3://gccsapp1.prod.fedex.com:9999");

            InitialContext c=new InitialContext(prop);
/*            //InitialContext c=new InitialContext();
            SystemUtilsHome suh=(SystemUtilsHome)javax.rmi.PortableRemoteObject.narrow(c.lookup("SystemUtilsEJB"),SystemUtilsHome.class);
            SystemUtils su=suh.create();
            out.println(su.login("504270","o1bI6BE3").size());
  *

            SystemUtilsDaoHome suh=(SystemUtilsDaoHome)javax.rmi.PortableRemoteObject.narrow(c.lookup("SystemUtilsDaoEJB"),SystemUtilsDaoHome.class);
            SystemUtilsDao su=suh.create();
            out.println(su.getCountryCurrencies("AR").size());

        }catch(Exception e){
            out.println(e);
        }

   */
%>
