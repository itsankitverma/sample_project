/*
* SystemUtils.java
*
* Created on September 26, 2002, 12:47 PM
*/

package com.fedex.lacitd.cashcontrol.biztier.bizdelegates;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtils;
import com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtilsHome;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;

import javax.ejb.CreateException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * @author ccardenas
 */
public class SystemUtilsBizDelegate implements java.io.Serializable {

    /**
     * Creates a new instance of SystemUtils
     */
    public SystemUtilsBizDelegate() {
    }

    public Collection login(String userName, String password) throws BizDelegateException {
        try {
            return getSystemUtils().login(userName, password);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in login() method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection login(String userName) throws BizDelegateException {
        try {
            return getSystemUtils().login(userName);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in login() method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }


    private SystemUtils getSystemUtils() throws ServiceLocatorException, CreateException, RemoteException {
        ServiceLocator service = ServiceLocator.getInstance();
        SystemUtilsHome home = (SystemUtilsHome) service.getEJBHome(Constants.SystemUtilsEJB_Remote, SystemUtilsHome.class);
        SystemUtils loc = home.create();
        return loc;
    }
    
   public EmployeeVO findFedExEmployee(java.lang.String empNbr) throws BizDelegateException {
        try {
            return getSystemUtils().findFedExEmployee(empNbr);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in findFedExEmployee() method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection findUsers(String empNbr) throws BizDelegateException {
        try {
            return getSystemUtils().findUsers(empNbr);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in findUsers() method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Properties getProperties(String category) throws BizDelegateException {
        try {
            return getSystemUtils().getProperties(category);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getProperties() method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public String getCheckDecodeJS(String countryCd) throws BizDelegateException {
        try {
            return getSystemUtils().getCheckDecodeJS(countryCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCheckDecodeJS() method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getCountryCurrencies(String countryCd) throws BizDelegateException {
        try {
            return getSystemUtils().getCountryCurrencies(countryCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCountryCurrencies(String countryCd) method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void runPurgeCosmosScans() throws BizDelegateException {
        try {
            getSystemUtils().runPurgeCosmosScans();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in runPurgeCosmosScans(String purgingDays) method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    //Miscellaneous enhancements
  //Station manager's role_id_nbr= 3
    public List getEmailCertificationAddresses(int role_id_nbr) throws BizDelegateException {
        try {
           return getSystemUtils().getEmailCertificationAddresses(role_id_nbr);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEmailCertificationAddresses(int role_id_nbr) method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }
    
    public HashMap getUrlsAndRoles() throws BizDelegateException {
        try {
            return getSystemUtils().getUrlsAndRoles();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getUrlsAndRoles() method from SystemUtilsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }
}
