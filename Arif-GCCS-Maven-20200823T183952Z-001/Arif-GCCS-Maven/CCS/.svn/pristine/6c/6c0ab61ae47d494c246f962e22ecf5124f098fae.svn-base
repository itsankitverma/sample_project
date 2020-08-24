package com.examples;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: arturog
 * Date: 01-08-2005
 * Time: 03:20:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test_SP {
    public void test() {
        Connection conn = null;
        ResultSet res = null;
        CallableStatement cs = null;
        try	{

          Class.forName("oracle.jdbc.OracleDriver");
          String url = "jdbc:oracle:thin:@161.135.144.216:1521:oradb02";
          conn = DriverManager.getConnection(url,"ccsr34","ccsr34");

            /*
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            env.put(Context.PROVIDER_URL,"t3://161.135.144.222:8001");

            InitialContext ic = new InitialContext(env);
            DataSource ds=(DataSource)ic.lookup("jdbc/CashControlDS");
            conn=ds.getConnection();*/
            cs=conn.prepareCall("BEGIN SP_PAYMENTS_SUMMARY_BY_EMP(?,?,?,?); END;");


            cs.setString(1,"SCLA");
            cs.registerOutParameter(2,oracle.jdbc.OracleTypes.CURSOR);
            cs.registerOutParameter(3,oracle.jdbc.OracleTypes.DOUBLE);
            cs.registerOutParameter(4,oracle.jdbc.OracleTypes.DOUBLE);
            cs.execute();

            res=(ResultSet)cs.getObject(2);
            int i=0;
            while(res.next()){
                i++;
            }

            System.out.println("Nro. de Filas == " + i);
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
    public static void main(String[] args) 	{
        Test_SP sp = new Test_SP();
        //sp.test();
        sp.test();
    }

}
