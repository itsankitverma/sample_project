package com.fedex.lacitd.cashcontrol.common;

import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

public class ServiceLocator {

    private Map _homeCache;
    private Context _initial;
    private static ServiceLocator _serviceLocator;
    private ServiceLocator()
        throws NamingException {
        _initial = new InitialContext();
        _homeCache = Collections.synchronizedMap(new HashMap());
    }

    private ServiceLocator(Hashtable prop)
        throws NamingException {
        _initial = new InitialContext(prop);
        _homeCache = Collections.synchronizedMap(new HashMap());
    }

    public static ServiceLocator getInstance()
        throws ServiceLocatorException {
        try {
            Hashtable prop=new Hashtable();

            if (_serviceLocator == null) {
                prop.put(Context.SECURITY_PRINCIPAL,Constants.WLUSER);
                prop.put(Context.SECURITY_CREDENTIALS,Constants.WLPWD);
                _serviceLocator = new ServiceLocator(prop);
            }
            return _serviceLocator;
        }
        catch (NamingException ex) {
            throw new ServiceLocatorException("Failed to create ServiceLocator object", ex);
        }
    }

    public EJBHome getEJBHome(String serviceName, Class serviceClass)
        throws ServiceLocatorException {
        EJBHome home = (EJBHome) _homeCache.get(serviceName);
        if (home == null) {
            try {
                home = (EJBHome) javax.rmi.PortableRemoteObject.narrow (_initial.lookup (serviceName), serviceClass);
                _homeCache.put(serviceName, home);
            }
            catch (NamingException ex) {
                throw new ServiceLocatorException("Failed to return the EJBHome for " + serviceName + " object", ex);
            }
            catch (Exception ex) {
                throw new ServiceLocatorException("Failed to return the EJBHome for " + serviceName + " object", ex);
            }
        }
        return home;
    }

    public EJBLocalHome getEJBLocalHome(String serviceName)
        throws ServiceLocatorException {
        EJBLocalHome localHome = (EJBLocalHome) _homeCache.get(serviceName);
        if (localHome == null) {
            try {
                localHome = (EJBLocalHome) _initial.lookup(serviceName);
                _homeCache.put(serviceName, localHome);
            }
            catch (NamingException ex) {
                throw new ServiceLocatorException("Failed to return the EJBLocalHome for " + serviceName + " object", ex);
            }
            catch (Exception ex) {
                throw new ServiceLocatorException("Failed to return the EJBLocalHome for " + serviceName + " object", ex);
            }
        }
        return localHome;
    }

}
