/**
 * CountryToCompare.java
 *
 * Created on May 27, 2003, 1:11 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryVO;
import java.util.Comparator;

/**
 *
 * @author  Arturo Gonzalez
 * This class implements a Comparator for CountryVO objects.
 */
public class CountryToCompare implements Comparator {
    
  /** Creates a new instance of CountryToCompare */
    public CountryToCompare() {
    }
    
    public int compare(Object countryOne, Object countryTwo)
    {
        if(countryOne!=null)
        {  String countryFirst  = ((CountryVO)countryOne).getCountryNm();
           String countrySecond = ((CountryVO)countryTwo).getCountryNm();

           if(countryFirst != null && countrySecond != null)
              return countryFirst.compareTo(countrySecond);
           else
              return -1;
        }else
            return -1;
    }
}