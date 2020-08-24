package com.examples;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.datatier.controller.LocationController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.Properties;
import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: arturog
 * Date: 06-02-2006
 * Time: 06:33:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestParameters {

    public static void main(String[] args) {

        CallableStatement cs=null;
        Connection conn=null;

        //ValidateUsersByQuarter valid = new ValidateUsersByQuarter();
        Properties prop=new Properties();

            prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            prop.put(Context.PROVIDER_URL, "t3://ccsap24.rmtc.fedex.com:8202");

        //prop.put(Context.SECURITY_PRINCIPAL,"weblogic");
        //prop.put(Context.SECURITY_CREDENTIALS,"weblogic");

        //prop.put(Context.PROVIDER_URL, "t3://161.135.144.202:7001");
        //prop.put(Context.PROVIDER_URL, "t3://161.135.40.171:9999");

        try{
            InitialContext c=new InitialContext(prop);
            DataSource ds = (DataSource)c.lookup("jdbc/CashControlDS");

            conn=ds.getConnection();

            System.out.println("##########################");
            System.out.println(" ds : " + ds.toString());
            System.out.println("##########################");

                cs=conn.prepareCall("BEGIN SP_OPEN_RECEIVABLES_REPORT('CCSA',?); END;");

            //cs.setString(1, "CCSA");
            cs.registerOutParameter(1,oracle.jdbc.OracleTypes.CLOB);
            cs.execute();

            System.out.println( "rsl: " + cs.getClob(1).getAsciiStream() );

            //SystemUtilsHome adHome = (SystemUtilsHome)c.lookup(Constants.SystemUtilsEJB_Remote);
            //SystemUtils sys = adHome.create();
            //valid.testLdapWorking("777777", sys);
        }catch(Exception e)
            {  System.out.println("\n Exception = " + com.fedex.lacitd.cashcontrol.common.Utils.stackTraceToString(e));
            }

    }
}
