/**
 * LocationToCompare.java
 *
 * Created on May 27, 2003, 1:11 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO;
import java.util.Comparator;

/**
 *
 * @author  Arturo Gonzalez
 * This class implements a Comparator for LocationVO objects.
 */
public class LocationToCompare implements Comparator {
    
  /** Creates a new instance of CountryToCompare */
    public LocationToCompare() {
    }
    
    public int compare(Object locationOne, Object locationTwo)
    {
        if(locationOne!=null)
        {  String locationFirst  = ((LocationVO)locationOne).getLocationCd();
           String locationSecond = ((LocationVO)locationTwo).getLocationCd();

           if(locationFirst != null && locationSecond != null)
              return locationFirst.compareTo(locationSecond);
           else
              return -1;
        }else
            return -1;
    }
}