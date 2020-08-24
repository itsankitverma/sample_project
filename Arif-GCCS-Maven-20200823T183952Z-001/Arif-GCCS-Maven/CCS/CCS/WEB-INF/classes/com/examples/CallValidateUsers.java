/**
 * Created on Dec 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.examples;

import java.util.Properties;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.fedex.lacitd.cashcontrol.prestier.helper.*;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.facades.*;
import com.fedex.lacitd.cashcontrol.common.*;


/**
 * @author arturog
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CallValidateUsers {

    public static void main(String[] args) {

        //ValidateUsersByQuarter valid = new ValidateUsersByQuarter();
        Properties prop=new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            prop.put(Context.PROVIDER_URL, "t3://lac-memapp01.prod.fedex.com:9999");
        //prop.put(Context.SECURITY_PRINCIPAL,"weblogic");
        //prop.put(Context.SECURITY_CREDENTIALS,"weblogic");

		//prop.put(Context.PROVIDER_URL, "t3://161.135.144.202:7001");
        //prop.put(Context.PROVIDER_URL, "t3://161.135.40.171:9999");

        try{
            InitialContext c=new InitialContext(prop);
            DataSource ds = (DataSource)c.lookup(Constants.CCSDataSource);
            System.out.println("1");
            Connection conn = ds.getConnection();
            System.out.println("2");
            Statement st = conn.createStatement();
            System.out.println("3");
            ResultSet res = st.executeQuery("SELECT * FROM parameter ");
            System.out.println("4");
            ResultSetMetaData meta = res.getMetaData();
System.out.println("5");
            while(res.next()){
                  for(int i=1;i<=meta.getColumnCount();i++)
                  {   System.out.println("\n parameter data = " + meta.getColumnName(i) + " = " + res.getString(meta.getColumnName(i)));}
            }

            //SystemUtilsHome adHome = (SystemUtilsHome)c.lookup(Constants.SystemUtilsEJB_Remote);
            //SystemUtils sys = adHome.create();
            //valid.testLdapWorking("777777", sys);
        }catch(Exception e)
        	{  System.out.println("\n Exception = " + com.fedex.lacitd.cashcontrol.common.Utils.stackTraceToString(e));
            }

    }
}
