/**
 * Validator.java
 *
 * Created on June 6, 2003, 10:50 AM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.form.common;

import org.apache.oro.text.perl.Perl5Util;

/**
 *
 * @author  Arturo Gonzalez
 */
public class Validator {
    
    /** Creates a new instance of Validator */
    public Validator() {
    }
    
    /**
     * This method validate if parameter is number or not
     * @param String number
     * @return boolean true(if parameter is number)/false(if parameter is not number)
     */
    public static boolean isNumber(java.lang.String number)
    {  Perl5Util perl = new Perl5Util();
       boolean valid  = true;
       if(number!=null)
       {   if(perl.match("/^[0-9]+$/",number))
               valid=true;
            else
               valid=false;
        }
        return valid;
    }
    
    /**
     * This method validate if pbj parameter has only letters
     * @param String obj
     * @return boolean true(if parameter has only letters)/false(if parameter has not only letters)
     */
    public static boolean isLettersOnly(java.lang.String obj)
    {  Perl5Util perl = new Perl5Util();
       boolean valid  = true;
       if(obj!=null)
       {   if(perl.match("/^[a-zA-Z]+$/",obj))
               valid=true;
            else
               valid=false;
        }
        return valid;
    }

    
    /**This method validate format of a email field of the form
     * @param String eMail
     * @return boolean true(if format is well)/false(if it has an incorrect format)
     */
    public static boolean formatEMail(java.lang.String eMail)
    {  Perl5Util perl = new Perl5Util();
       boolean valid  = true;
       if(eMail!=null)
       {   if(perl.match("/^[a-zA-Z0-9._-]+@([a-zA-Z0-9._-]+\\.)+([a-zA-Z0-9_-]){2,3}$/",eMail))
               valid=true;
            else
               valid=false;
        }
        return valid;
    }
    
    /**
     * This method validate the format of a date.
     * @param String date
     * @return true (if format is like 'dd/mm/yyyy')/false (in any other case)
     */
    public static boolean validateDate(String date)
    {   Perl5Util perl = new Perl5Util();
        boolean valid  = true;
        if(date!=null)
        {  if(perl.match("/^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$/",date))
              valid=true;
            else
                valid=false;
        }
        return valid;
    }
    
}
