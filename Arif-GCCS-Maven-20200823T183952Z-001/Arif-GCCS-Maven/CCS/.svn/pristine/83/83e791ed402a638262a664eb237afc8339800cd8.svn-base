package com.examples;

import com.fedex.lacitd.cashcontrol.common.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaCert{
    public static void main(String args[]){
            try{
                String bankDepoDtText = "00/00/0000";
                SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
                Date bankDepoDt=sdf.parse(bankDepoDtText);
                System.out.println("Date 1 parse = " + bankDepoDt.toString());

                bankDepoDt=sdf.parse(bankDepoDtText);
                System.out.println("Date 2 parse = " + sdf.format(bankDepoDt));

                //java.util.Date dt = com.fedex.lacitd.cashcontrol.common.Utils.changeDateToTZ(new java.util.Date(), ep.getLocationTimeZone());


            }catch(Exception e){
                e.printStackTrace();
            }
    }
}
