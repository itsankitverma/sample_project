/**
 * ProcessRIHFileRunnable.java
 *
 * Created on 13 de mayo de 2004, 16:02
 */

package com.examples;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author  ccardenas
 */
public class DTRCUpload implements  java.io.Serializable {
	public static void main(String[] a) throws Exception{
        Connection conn=null;
        CallableStatement cs=null;
        ResultSet rs=null;
            Properties prop=new Properties();

            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@scldev01.sadev.fedex.com:1521:oradb01","ccsmigration","ccsm");

            cs=conn.prepareCall("BEGIN SP_DTRC_UPLOAD(?,?); END;");

            cs.setInt(1,2);
            cs.registerOutParameter(2,oracle.jdbc.OracleTypes.CURSOR);
            cs.execute();
                
            rs=(ResultSet)cs.getObject(2);

            while(rs.next()){
                System.out.print(rs.getString(1));
            }

            

		
	}
	
}