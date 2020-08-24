/**
 * Utils.java
 *
 * Created on 27 de diciembre de 2002, 15:53
 */

package com.fedex.lacitd.cashcontrol.common;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.SystemUtilsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.controller.CountryController;
import com.fedex.lacitd.cashcontrol.datatier.controller.LocationController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryCurrencyVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO;
import com.fedex.lacitd.cashcontrol.datatier.exception.LocationException;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.dao.LocationDaoUtils;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ccardenas
 */
public class Utils implements java.io.Serializable {

    /**
     * Creates a new instance of Utils
     */
    public Utils() {
    }

    public static String getThreadsNumber() {
        Properties prop=null;
        try {
            prop= Utils.getProperties("C");
        } catch (Exception e) {
            e.printStackTrace();   
            prop=new Properties();
            prop.setProperty("threadsNumber","85");
        }
        return prop.getProperty( "threadsNumber" );
    }
    
    public static String getUrlECQS() {
        Properties prop=null;

        try {
            prop= Utils.getProperties("C");
            System.out.println("prop.getProperty( newUrlEQS ) in try=" + prop.getProperty( "newUrlEQS" ));
        } catch (BizDelegateException e) {
            e.printStackTrace();
            prop=new Properties();
            prop.setProperty("newUrlEQS","http://ecqscons.prod.fedex.com:8011/ecqs/query");
        }
        System.out.println(prop.getProperty( "newUrlEQS" ));   
        return prop.getProperty( "newUrlEQS" );

        //eCQS International URL
        // urlECQS = "http://ecqsintl.prod.fedex.com:8011/ecqs/query";
        //eCQS DEV
        //public static String urlECQS="http://ecqsdev1.rmtc.fedex.com:7033/ecqs/query";
    }

    public static String stackTraceToString(Exception e) {
        StringWriter strwrite = new StringWriter();
        PrintWriter sout = new PrintWriter(strwrite);
        e.printStackTrace(sout);
        String exceptionStr = strwrite.toString();
        return exceptionStr;
    }

    public static java.util.Date changeDateToTZ(java.util.Date dt, String timeZone) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
            sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
            String dtTrg = sdf.format(dt);
            sdf.setTimeZone(TimeZone.getDefault());
            return sdf.parse(dtTrg);
        } catch (Exception e) {
            return dt;
        }
    }

    public static Properties getProperties(String category) throws BizDelegateException {
        Properties prop = new Properties();
        SystemUtilsBizDelegate sysutils = new SystemUtilsBizDelegate();

        try {
            prop = sysutils.getProperties(category);
        } catch (BizDelegateException bde) {
            throw bde;
        }
        return prop;
    }

    public static String generatePassword(int length) throws Exception {
        String password = "";

        try {
            String vowels = "aeiouAEIOU";            //10 vowels
            String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";//42 consonants
            String numbers = "0123456789";
            Random randomObject = new Random();

            int alt = 0;

            for (int i = 0; i < length; i++) {
                if (alt == 2) {
                    int n = Math.abs(randomObject.nextInt() % numbers.length());
                    password = password + String.valueOf(numbers.charAt(n));
                    alt = 1;
                } else if (alt == 1) {
                    int c = Math.abs(randomObject.nextInt() % consonants.length());
                    password = password + String.valueOf(consonants.charAt(c));
                    alt = 0;
                } else {
                    int v = Math.abs(randomObject.nextInt() % vowels.length());
                    password = password + String.valueOf(vowels.charAt(v));
                    alt = 2;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return password;
    }//Close generatePassword


    public static void notifyError(String to, String subject, String messg) {
        try {
            InitialContext ic = new InitialContext();
            Session session1 = (Session) ic.lookup(Constants.MAILSession);

            Message msg = new MimeMessage(session1);

            String from = session1.getProperty("mail.app");
            msg.setFrom(InternetAddress.parse(from)[0]);

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(subject);

            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setText(messg);

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp);

            msg.setContent(mp);

            Transport.send(msg);
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
    }

    /**
     * This method let the data in a collection that is not in the other.
     *
     * @param col1
     * @param col2
     * @return Collection result
     */
    public static Collection getElementFromCollection(Collection col1, Collection col2, Comparator comp) {
        Iterator col1It = col1.iterator();
        while (col1It.hasNext()) {
            if (Collections.binarySearch((List) col2, col1It.next(), comp) >= 0) {
                col1It.remove();
            }
        }
        return col1;
    }

    /**
     * This method tries to get info on what country is a file based in its name
     *
     * @param  
     * @return Collection result
     */
    public static String getCountryFileName(String fileNm) {
        fileNm = fileNm.toUpperCase();
        CountryController cc = new CountryController();
        LocationController lc = new LocationController();
        String fileNmSub = null;
        LocationVO lvo = null;
        CountryVO cvo = null;


        try {
            fileNmSub = fileNm.substring(0, 4);
            try {
                lvo = lc.getLocation(fileNmSub);
            } catch (Exception e) {
                lvo = null;
            }
            if (lvo != null) return lvo.getCountryCd();
            else {
                fileNmSub = fileNm.substring(0, 3) + "A";
                try {
                    lvo = lc.getLocation(fileNmSub);
                } catch (Exception e) {
                    lvo = null;
                }
                if (lvo != null) return lvo.getCountryCd();
                else {
                    fileNmSub = fileNm.substring(0, 2);
                    try {
                        cvo = cc.getCountry(fileNmSub);
                    } catch (Exception e) {
                        cvo = null;
                    }
                    if (cvo != null) return cvo.getCountryCd();
                    else {
                        fileNmSub = fileNm.substring(0, 3);
                        Iterator iter = cc.getAllCountry().iterator();
                        while (iter.hasNext()) {
                            cvo = (CountryVO) iter.next();
                            if (fileNmSub.equalsIgnoreCase(cvo.getCountryNm().substring(0, 3))) {
                                return cvo.getCountryCd();
                            }
                        }
                        return null;
                    }

                }


            }


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Method to check if a currency exist for the country or not.
     *
     * @param locationCd
     * @param currencyFile
     * @return null if currency exist for the country or currencyCd if currency does not exist for the country
     */
    public static String validateCountryCurencyInProcess(String locationCd, String currencyFile) {

        try {
            //Validate if cuyrrency is USD then return inmediately.
            if ("USD".equals(currencyFile))
                return currencyFile;

            LocationController locationCtrl = new LocationController();

            String countryCd = locationCtrl.getLocation(locationCd).getCountryCd();
            boolean exist = false;

            Collection countryCurrencyCollection = new CountryController().getCountryCurrency(countryCd);
            Iterator countryCurrencyIt = null;
            CountryCurrencyVO cntryCurr = null;

            if (countryCurrencyCollection != null) {
                countryCurrencyIt = countryCurrencyCollection.iterator();

                while (countryCurrencyIt.hasNext()) {
                    cntryCurr = (CountryCurrencyVO) countryCurrencyIt.next();

                    if (cntryCurr.getCurrencyCd().equals(currencyFile)) {
                        exist = true;
                        break;
                    }
                }
            }

            if (exist == true)//If exist return null
                return null;
            else
                return cntryCurr.getCurrencyCd(); //If doesn't exist then return the currency that belong to the country.

        } catch (Exception e) {
            return null;
        }

    }//Close the method validateCountryCurencyInProcess

    /**
     * Method to convert an amount from one currency to another.
     *
     * @param mnt Amount to be converted.
     * @param currencyFile the currency of the amount.
     * @return 
     */
    public static double convertToNewCurrency(double mnt, String currencyFile) {

        try {
            double paridad;
            int    decimales;

            String currency = "VEF";
            String paramName = "param.value.currecy.convert." + currencyFile + "to" + currency;

            Properties prop = getProperties("P");

            if(prop.containsKey( paramName))
                paridad = Double.parseDouble( prop.getProperty( paramName));
            else
                paridad = 0.001;

            if(prop.containsKey( "param.value.currecy.convert.decimals"))
                decimales = Integer.parseInt( prop.getProperty( "param.value.currecy.convert.decimals"));
            else
                decimales = 3;

            double newMnt = Math.round( mnt * paridad * Math.pow( 10.0, decimales)) / Math.pow( 10.0, decimales);

            return newMnt;

        } catch (Exception e) {
            e.printStackTrace();
            return mnt;
        }
    }//Close the method

    /**
     * Method to check if a currency exist for the country or not.
     *
     * @param locationCd
     * @param currencyFile
     * @return null if currency exist for the country or currencyCd if currency does not exist for the country
     */
    public static boolean currencyRequiresConvertion( String currencyFile) {

        try {
            Properties prop = getProperties("P");

            String currencies = prop.getProperty( "param.value.currecy.requires.convertion");

            return currencies.indexOf ( currencyFile) >= 0;
        } catch (Exception e) {
            return false;
        }
    }//Close the method


        /**
     * Method to check if a currency exist for the country or not.
     *
     * @param locationCd
     * @param currencyFile
     * @return null if currency exist for the country or currencyCd if currency does not exist for the country
     */
    public static boolean existLocation( String locCd) {

        try {

            return LocationDaoUtils.existLocation( locCd);

        } catch (Exception e) {
            Constants.logger.debug(" existLocation: " + Utils.stackTraceToString( e));
            return false;
        }
    }//Close the method
}

