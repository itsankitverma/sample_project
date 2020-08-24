package com.examples;


import com.fedex.lacitd.cashcontrol.biztier.facades.AdminFacadeHome;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.datatier.dao.SystemUtilsDaoHome;
import com.fedex.lacitd.cashcontrol.datatier.dao.SystemUtilsDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Clob;
import java.sql.Connection;
import java.util.Properties;
import java.util.HashMap;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: 597125
 * Date: 19-04-2007
 * Time: 11:02:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetURLRoles {
    private static Connection conn;

    public static void main(String[] a) throws Exception{
        getDataURLROles();

    }

    public static void getDataURLROles()
    {
        try{
            HashMap urlRoles;
            Properties prop=new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            prop.put(Context.PROVIDER_URL, "t3://161.135.144.204:8200");

            InitialContext c=new InitialContext(prop);
            SystemUtilsDaoHome adHome = (SystemUtilsDaoHome)c.lookup(Constants.SystemUtilsDaoEJB_Remote);
            SystemUtilsDao sysu = adHome.create();

            urlRoles = sysu.getUrlsAndRoles();
            System.out.println("urlRoles =>" + urlRoles );

        }catch(Exception e){
               System.out.println(e);
        }
    }//close the nmethod getDataToXmlFile()
}
