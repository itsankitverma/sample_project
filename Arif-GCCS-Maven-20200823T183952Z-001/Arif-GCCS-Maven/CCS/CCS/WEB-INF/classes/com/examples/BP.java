package com.examples;
import java.util.*;
import java.sql.*;
import java.io.FileOutputStream;

import com.fedex.lacitd.cashcontrol.biztier.facades.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPTransferType;

import javax.naming.*;
import javax.sql.DataSource;

/**
 *
 * @author  ccardenas
 */
public class BP {

    /** Creates a new instance of DTRCUpload */
    public BP() {
    }

    /**
     * @param args the command line arguments
     */
public static void main(String[] args)throws Exception
{
    Class.forName("oracle.jdbc.OracleDriver");
    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@lac-findb01.corp.fedex.com:1522:ccsmiap","ccardenas","cardenas_c");


            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("          SELECT DISTINCT\n" +
                    "                 '    ' || 'DEX16' || TO_CHAR(SYSDATE,'YYYY') || TO_CHAR(SYSDATE,'DDD') || '                  ' ||\n" +
                    "                 LPAD(AWB_NBR,12,'0') || '    ' ||\n" +
                    "                 NVL(l.PARNT_LOC_CD,r.LOC_CD) || ' ' ||\n" +
                    "                 e.CNTRY_CD || ENT_CD ||'  Y                                                                           ' ||\n" +
                    "                 PYMT_CURR_CD || LPAD(TO_CHAR((OTHER_PYMT_AMT+CASH_PYMT_AMT)*100),11,'0') ||\n" +
                    "                 '                           ' || (SELECT PARM_VALUE_CD FROM PARAMETER WHERE PARM_NM='dtrc.endLine')\n" +
                    "          FROM RECEIVABLES r,LOCATION l,ENTITY e\n" +
                    "          WHERE trunc(DTRC_UPLOAD_DT)=trunc(sysdate-1)\n" +
                    "          AND r.LOC_CD=l.LOC_CD\n" +
                    "          AND (l.LOC_CD=e.LOC_CD OR l.PARNT_LOC_CD=e.LOC_CD)\n" +
                    "          AND e.DTRC_UPLD_ACT_FLG=1");

            Collection colDet=new ArrayList();

            while(rs.next()){
                colDet.add(rs.getString(1));
            }

            Iterator iter=colDet.iterator();
            StringBuffer sb=new StringBuffer();

            while(iter.hasNext()){
                String aa=(String)iter.next();
                sb.append(aa);
            }

                FTPClient clt = null;
                clt = new FTPClient("gccsapp.prod.fedex.com");
                clt.login("gccsftp1","GCCSpw_2");

                String fileName       = "dtrc-upload/aaaaaa.txt" ;

                clt.setType(FTPTransferType.BINARY);
                //append if file is present.
                clt.put(sb.toString().getBytes("UTF-8"),fileName,true);

               clt.quit(); // Quit the ftp site
            conn.close();

    System.out.println("Done.");




}

}