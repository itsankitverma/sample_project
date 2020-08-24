package com.examples;

import java.util.Locale;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by Arturo Gonzalez.
 * User: arturog
 * Date: 03-02-2005
 * Time: 03:47:53 PM
 * Description :
 */
public class getDecimal {


    public static void main(String args[]) throws Exception {
        try{
            Locale locale = Locale.ENGLISH;
            String s = "235,030";
            NumberFormat nf = NumberFormat.getInstance(locale);
            nf.setParseIntegerOnly(true);
            ParsePosition pp = new ParsePosition(0);

            // probably a fine assumption
            pp.setIndex(pp.getIndex() + 1);
            long integerPart = nf.parse(s, pp).longValue();
            // probably a fine assumption
            System.out.println("\n\n parse = " + nf.parse(s, pp));
            pp.setIndex(pp.getIndex() + 1);
            int decimalPlaces = (s.length() - pp.getIndex());
            long decimalPart = nf.parse(s, pp).longValue();

            System.out.println(new StringBuffer().append("\n\n integer part = ").append(integerPart).append(" -  decimal part = ").append(decimalPart).toString());
        }catch(Exception e)
         {  System.out.println("\n Exception : \n");
            e.printStackTrace();}
    }

}
