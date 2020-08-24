package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;
import org.apache.struts.action.ActionError;

/**
 * Created by IntelliJ IDEA.
 * Autor: Andres Vasquez
 * Date: 12-06-2007
 * Time: 03:24:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidateExpressionsUtil {

    private static final ValidateExpressionsUtil INSTANCE = new ValidateExpressionsUtil();
    private Properties properties = null;

    private ValidateExpressionsUtil() {
        try{
            setProperties(new Properties());
            getProperties().load(new FileInputStream("BlackWhite.properties"));
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
    }

    public static final ValidateExpressionsUtil getInstance() {
      return INSTANCE;
    }

    public boolean isValid(String[] expressions, String value)
    {
         //TODO catch exceptions
         String propName = null;
         String propValue = null;
         String expression = null;
         Pattern pattern = null;
         boolean valid = true;

       try {
         if (value != null)
         {

             for(int i = 0; i < expressions.length; i++ ) {
                propName = expressions[i];
                propValue = this.getProperties().getProperty(propName);

                StringTokenizer st = new StringTokenizer(propValue, Constants.REG_EXP_SEPARATOR);

                // Iterate through and print out the tokens...
                while (st.hasMoreTokens()) {
                  expression = st.nextToken();
                  pattern = Pattern.compile(expression);
                  Matcher m = pattern.matcher(value);
                  //System.out.println(expression+ "--"+ value +"--"+ m.find()+"--"+ m.find() +"--"+ m.find());
                  boolean foundThat = m.find();
                  if (foundThat)
                  {
                    valid = false;
                    break;
                  }

                }

             }
         }
       } catch (Exception e)
       {
           Constants.logger.debug(Utils.stackTraceToString(e));
       }
        return valid;
    }



    public boolean isSoFar3Days(Date value)
    {
         //TODO catch exceptions

         boolean valid = false;
         try{
             GregorianCalendar todayPlus = new GregorianCalendar();
             
             todayPlus.setTime(new Date());
             
             /* roll function replaced by add function 
              * bug2. BR81138.2.002
              * 
              * todayPlus.roll(Calendar.DAY_OF_YEAR,3);
              * 
              */
             todayPlus.add(Calendar.DAY_OF_YEAR,3);

             //System.out.println(todayPlus.getTime() +"--"+ value.getTime());

             if(value.after(todayPlus.getTime())){
                valid = true;
             }
         }catch(Exception e){
             Constants.logger.debug(Utils.stackTraceToString(e));
         }

        return valid;
    }

    public boolean isOneYearBefore(Date value)
    {
         //TODO catch exceptions

         boolean valid = false;
         try{
             GregorianCalendar oneYearBefore = new GregorianCalendar();
             oneYearBefore.setTime(new Date());
             oneYearBefore.roll(Calendar.YEAR,-1);

             //System.out.println(todayPlus.getTime() +"--"+ value.getTime());

             if(value.before(oneYearBefore.getTime())){
                valid = true;
             }
         }catch(Exception e){
             Constants.logger.debug(Utils.stackTraceToString(e));
         }

        return valid;
    }


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
