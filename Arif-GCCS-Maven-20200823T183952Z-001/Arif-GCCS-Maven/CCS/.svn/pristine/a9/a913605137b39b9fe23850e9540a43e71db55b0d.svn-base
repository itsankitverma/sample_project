/*
 * Created on Nov 18, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.RoleVO;
import java.util.Comparator;

/**
 * @author arturog
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RoleToCompare implements Comparator {

    public int compare(Object roleOne, Object roleTwo)
    {
        if(roleOne!=null)
        {  String roleFirst  = ((RoleVO)roleOne).getRole();
           String roleSecond = ((RoleVO)roleTwo).getRole();

           if(roleFirst != null && roleSecond != null)
              return roleFirst.compareTo(roleSecond);
           else
              return -1;
        }else
            return -1;
    }
}
