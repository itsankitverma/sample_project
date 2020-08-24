/**
 * @(#)ServiceLocator.java			Tue Aug 02 15:38:55 VET 2005
 * 
 * FedEx
 * Cash Control
 * 
 * FedEx
 * Santiago, Chile
 * 
 * Copyright (c) 2001 FedEx, All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of FedEx. ("Confidential Information").
 * 
 * Visit our website at http://www.fedex.com for more information
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.common;

import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {

    private Map _homeCache;
    private Context _initial;
    private static ServiceLocator _serviceLocator;

    private ServiceLocator()
        throws NamingException {
    /*     Hashtable prop=new Hashtable();
         prop.put(Context.SECURITY_PRINCIPAL,"jndi_user");
         prop.put(Context.SECURITY_CREDENTIALS,"weblogic");*/
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
    /*            System.out.println("\n paso por el getInstance...");
                prop.put(Context.SECURITY_PRINCIPAL,"jndi_user");
                prop.put(Context.SECURITY_CREDENTIALS,"weblogic");*/
                _serviceLocator = new ServiceLocator();
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
                //System.out.println("\n paso por el getEJBLocalHome..." + serviceName);
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
    
    public static ServiceLocator getInstance(Hashtable<String, String> env) 
    throws ServiceLocatorException {
        if (_serviceLocator == null) {
        	try {
        		_serviceLocator = new ServiceLocator(env);
			} catch (NamingException e) {
				throw new ServiceLocatorException("Failed to return the EJBLocalHome for object", e);
			}
        }
        return _serviceLocator;
    }
    
    public static ServiceLocator getInstanceForTest(Context _initialContext) 
    throws ServiceLocatorException {
        if (_serviceLocator == null) {
        	try {
        		_serviceLocator = new ServiceLocator(_initialContext);
			} catch (Exception e) {
				throw new ServiceLocatorException("Failed to return the EJBLocalHome for object", e);
			}
        }
        return _serviceLocator;
    }
    
    private ServiceLocator(Context _initialContext) {
	    	_initial = _initialContext;
	    	_homeCache = Collections.synchronizedMap(new HashMap());
    	}

}
