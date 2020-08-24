/*
 * Utils.java
 *
 * Created on 27 de diciembre de 2002, 15:53
 */

package com.examples;

import java.util.*;
import java.text.*;
/**
 *
 * @author  ccardenas
 */
public class Utils implements java.io.Serializable {
    
    /** Creates a new instance of Utils */
    public Utils() {
    }    
   
    public static java.util.Date changeDateToTZ(java.util.Date dt,String timeZone){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
            sdf.setTimeZone(TimeZone.getTimeZone(timeZone));            
            String dtTrg=sdf.format(dt);
            sdf.setTimeZone(TimeZone.getDefault());            
            return sdf.parse(dtTrg);
        }catch(Exception e){
            return dt;
        }
    }
    
    public static void main(String args[]){
        //System.out.println(new Date("Sun, 12 Oct 2003 15:00:00").getTime());
        //System.out.println(changeDateToTZ(new Date(Long.parseLong(args[0])),args[1]));      
    }
}
