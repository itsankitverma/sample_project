package com.examples;

import com.fedex.lacitd.cashcontrol.datatier.entities.OacLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceConstants;
import com.fedex.lacitd.cashcontrol.datatier.dao.SystemUtilsDaoHome;
import com.fedex.lacitd.cashcontrol.datatier.dao.SystemUtilsDao;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoHome;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDao;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtilsHome;
import com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtils;
import com.fedex.lacitd.cashcontrol.common.*;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.*;
import java.io.*;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;

public class SPTest4 {


    public void testSPOverlaps(){
        try{

            CallableStatement cs=null;
            Properties prop=null;
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            env.put(Context.PROVIDER_URL,"t3://161.135.144.222:8001");

            InitialContext ic = new InitialContext(env);

            System.out.println("TEST testSPOverlaps...");

            CommonOpsDaoHome utilBeanHome=(CommonOpsDaoHome) javax.rmi.PortableRemoteObject.narrow(ic.lookup(Constants.CommonOpsDaoEJB_Remote),CommonOpsDaoHome.class);
            CommonOpsDao utilBean=utilBeanHome.create();

            Collection colErrors=new ArrayList();
            colErrors = utilBean.validateTemplOverlaps(new Integer(210));

            //DataSource ds = (DataSource)ic.lookup(Constants.CCSDataSource);

                //Class.forName("oracle.jdbc.OracleDriver");
                //String url = "jdbc:oracle:thin:@161.135.144.216:1521:oradb02";
                //conn = DriverManager.getConnection(url,"ccsr33","ccsr33");


         /*   Connection conn=ds.getConnection();
            cs=conn.prepareCall("BEGIN SP_VALIDATE_TEMPL_OVERLAPS(?,?); END;");
            cs.setInt(1,210);
            cs.registerOutParameter(2,oracle.jdbc.OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs=(ResultSet)cs.getObject(2);


            while(rs.next()){
                  colErrors.add(rs.getString(1));
            }*/

            System.out.println("Error size : " +  colErrors.size());
           }catch(Exception e){
                e.printStackTrace(System.out);
            }
    }

    public void testParameters(){
        try{
            Properties prop=null;
            Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			env.put(Context.PROVIDER_URL,"t3://161.135.144.222:8001");

	        InitialContext ic = new InitialContext(env);

            SystemUtilsDaoHome utilBeanHome=(SystemUtilsDaoHome) javax.rmi.PortableRemoteObject.narrow(ic.lookup(Constants.SystemUtilsDaoEJB_Remote),SystemUtilsDaoHome.class);
            SystemUtilsDao utilBean=utilBeanHome.create();

            prop=utilBean.getProperties("R");

            System.out.println("Parameters : " + prop.toString());

        }catch(Exception e){
            e.printStackTrace(System.out);
        }

    }

    public void testEntity(){
        try{
            Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			env.put(Context.PROVIDER_URL,"t3://161.135.144.234:8001");

	        InitialContext ic = new InitialContext(env);

            OacLocalHome oacHome  =(OacLocalHome)ic.lookup("/OacEJB/OacLocalHome");

        }catch(Exception e){
            e.printStackTrace(System.out);
        }

    }
    public void test() {
		Connection conn = null;
		ResultSet res = null;
		CallableStatement cs = null;
		try	{
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@161.135.144.216:1521:oradb02";
			conn = DriverManager.getConnection(url,"ccsr33","ccsr33");
            cs=conn.prepareCall("BEGIN SP_SPLIT_OAC_PAYMENTS(?,?,?,?,?,?,?,?); END;");
            
            cs.setString(1,"SCLA");
            cs.setString(2,"194898");
            cs.setInt(3,1);
            cs.setInt(4,20);
            cs.setString(5,"OB_ANC_SVC_DT");
            cs.setString(6,"asc");
            cs.registerOutParameter(7,oracle.jdbc.OracleTypes.CURSOR);
            cs.registerOutParameter(8,oracle.jdbc.OracleTypes.INTEGER);
			cs.execute();

            ResultSet rs=(ResultSet)cs.getObject(7);
            Integer numberOfPages = (Integer) cs.getObject(8);

            Collection colDet=new ArrayList();
            while(rs.next()){
                Integer obId= new Integer(rs.getInt(1));
                Date obDate = rs.getDate(2);
                String currency = rs.getString(3);
                Double cashAmt = new Double(rs.getDouble(4));
                Double otherAmt = new Double(rs.getDouble(5));
                Integer pymtType = new Integer(rs.getInt(6));
                String otherDoc = rs.getString(7);
                String chkCom = rs.getString(8);
                Integer status = new Integer(rs.getInt(9));
                Double exchaRate = new Double(rs.getDouble(10));
                String otherCom = rs.getString(11);
                String receipt = rs.getString(12);
                String empNm = rs.getString(13);
                String empId = rs.getString(14);

            System.out.println("Oac Id: " + obId);
			System.out.println("Oac Date: " + obDate);
			System.out.println("Oac Curr: " + currency);
			System.out.println("Cash Amt: " + cashAmt);
			System.out.println("Other Amt: " + otherAmt);
			System.out.println("Pymt Type: " + pymtType);
			System.out.println("Other doc: " + otherDoc);
			System.out.println("check Com: " + chkCom);
			System.out.println("Status: " + status);
			System.out.println("Exch Rate: " + exchaRate);
            System.out.println("Other Com: " + otherCom);
            System.out.println("Receipt: " + receipt);
            System.out.println("Emp Name: " + empNm);
            System.out.println("Emp Id: " + empId);
            }

			conn.close();
		}
		catch (SQLException se)	{
			se.printStackTrace(System.out);
		}
		catch (Exception e)	{
			e.printStackTrace(System.out);
		}
		finally {
			try	{
				if(cs != null)
					cs.close();
			}
			catch (Exception e)	{}
			try	{
				if(res != null)
					res.close();
			}
			catch (Exception e)	{}
			try	{
				if(conn != null)
					conn.close();
			}
			catch (Exception e)	{}
		}
		
	}

    public void testDailyCashRecap() {
        CallableStatement cs=null;
        Connection conn=null;

        try{
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            //env.put(Context.PROVIDER_URL,"t3://gccsapp.prod.fedex.com:9999");
            //env.put(Context.PROVIDER_URL,"t3://161.135.144.201:8001");

            env.put(Context.PROVIDER_URL,"t3://199.81.123.85:8202");

            InitialContext ic = new InitialContext(env);

            DataSource ds = (DataSource)ic.lookup(Constants.CCSDataSource);

            //Class.forName("oracle.jdbc.OracleDriver");
            //String url = "jdbc:oracle:thin:@161.135.144.216:1521:oradb02";
            //conn = DriverManager.getConnection(url,"ccsr33","ccsr33");


            conn = ds.getConnection();
            cs=conn.prepareCall("BEGIN SP_DAILY_CASH_RECAP_REPORT(?,?,?,?); END;");
            cs.setString(1,"YAMA");
            cs.setString(2,"01/16/2007");
            try{
                int batchId=0;
                if(batchId==0) throw new NumberFormatException();
                cs.setInt(3,batchId);
            }catch(NumberFormatException e){
                cs.setNull(3,oracle.jdbc.OracleTypes.INTEGER);
            }

            cs.registerOutParameter(4,oracle.jdbc.OracleTypes.CLOB);
            cs.execute();

            /*This code is to write the xml to a file. For debugging purposes*
            InputStream is=cs.getClob(4).getAsciiStream();
      	    BufferedInputStream bis=new BufferedInputStream(is,4000);
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("dailyCashRecap.xml"));
            byte[] buffer=new byte[4000];
            int count=0;
            while ((count=bis.read(buffer))!=-1){
                bos.write(buffer,0,count);
            }
            bos.flush();
            **/

            Clob clobObj = cs.getClob(4);
            System.out.println(clobObj.getSubString(1,(int)clobObj.length()));
            
        }catch(Exception e){
            Constants.logger.debug(com.fedex.lacitd.cashcontrol.common.Utils.stackTraceToString(e));
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
    }

    public void testPrepaidDisc() {
        CallableStatement cs=null;
        Connection conn=null;

        try{
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            env.put(Context.PROVIDER_URL,"t3://gccsapp.prod.fedex.com:9999");

            InitialContext ic = new InitialContext(env);

            DataSource ds = (DataSource)ic.lookup(Constants.CCSDataSource);

            //Class.forName("oracle.jdbc.OracleDriver");
            //String url = "jdbc:oracle:thin:@161.135.144.216:1521:oradb02";
            //conn = DriverManager.getConnection(url,"ccsr33","ccsr33");

            conn=ds.getConnection();
            cs=conn.prepareCall("BEGIN SP_PREPAID_RECONC_REPORT(?,?); END;");
            cs.setString(1,"SAOA");
            cs.registerOutParameter(2,oracle.jdbc.OracleTypes.CLOB);
            cs.execute();

            /*This code is to write the xml to a file. For debugging purposes*
            InputStream is=cs.getClob(4).getAsciiStream();
      	    BufferedInputStream bis=new BufferedInputStream(is,4000);
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("dailyCashRecap.xml"));
            byte[] buffer=new byte[4000];
            int count=0;
            while ((count=bis.read(buffer))!=-1){
                bos.write(buffer,0,count);
            }
            bos.flush();
            **/

            Clob clobObj = cs.getClob(2);
            System.out.println(clobObj.getSubString(1,(int)clobObj.length()));

        }catch(Exception e){
            Constants.logger.debug(com.fedex.lacitd.cashcontrol.common.Utils.stackTraceToString(e));
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
    }


    public void testRoles(){
        Statement s=null;
        Connection conn=null;
        ResultSet rs = null;

        try{
            Properties prop=null;
            Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			env.put(Context.PROVIDER_URL,"t3://gccsapp.prod.fedex.com:9999");

	        InitialContext ic = new InitialContext(env);
            DataSource ds = (DataSource)ic.lookup(Constants.CCSDataSource);
            conn=ds.getConnection();
            s=conn.createStatement();
            rs=s.executeQuery("select count(*) from emp_x_location_x_role where emp_id_nbr='533828' and role_id_nbr=5");

            while(rs.next()){
                System.out.println("Role : " + rs.getString(rs.getRow()));
            }

        }catch(Exception e){
            e.printStackTrace(System.out);
        }

    }

    public static void main(String[] args) 	{
		SPTest4 sp = new SPTest4();

        sp.testDailyCashRecap();
        //sp.testEntity();
        //sp.testPrepaidDisc();
        //sp.testParameters();
        //sp.testRoles();
        //sp.testGCCSSnapshot();
        //sp.testSPOverlaps();
    }

    public void testGCCSSnapshot() {
           Connection conn = null;
           ResultSet res = null;
           CallableStatement cs = null;
           try	{
               Class.forName("oracle.jdbc.OracleDriver");
               String url = "jdbc:oracle:thin:@161.135.144.216:1521:oradb02";
               conn = DriverManager.getConnection(url,"GCCSCRD","fedex");
               cs=conn.prepareCall("BEGIN SP_GCCS_SNAPSHOT(?,?); END;");

               cs.setString(1,"LAC");
               cs.registerOutParameter(2,oracle.jdbc.OracleTypes.INTEGER);
               cs.execute();

               Integer result = (Integer) cs.getObject(2);

               System.out.println("result: " + result);

               conn.close();
           }
           catch (SQLException se)	{
               se.printStackTrace(System.out);
           }
           catch (Exception e)	{
               e.printStackTrace(System.out);
           }
           finally {
               try	{
                   if(cs != null)
                       cs.close();
               }
               catch (Exception e)	{}
               try	{
                   if(res != null)
                       res.close();
               }
               catch (Exception e)	{}
               try	{
                   if(conn != null)
                       conn.close();
               }
               catch (Exception e)	{}
           }

       }

}
