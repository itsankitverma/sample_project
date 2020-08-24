/**
 * @(#)CountryCurrencyController.java			Tue Aug 02 15:38:53 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.controller;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.manager.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;

public class CountryCurrencyController {

    /**
     * This method create new CountryCurrency object
     * @param countryCurrencyVO a value object the CountryCurrency bean
     */
    public void setCountryCurrency(CountryCurrencyVO countryCurrencyVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (countryCurrencyVO == null) {
            throw new IllegalArgumentException("countryCurrencyVO parameter was null in setCountryCurrency() method from CountryCurrencyController class");
        }
        
        try {
            getCountryCurrencyManager().setCountryCurrency(countryCurrencyVO);
        }
        catch (CountryCurrencyException ex) {
            String errorMsg = "Error occurred in setCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a CountryCurrency object
     * @return countryCurrencyVO - a value object of the CountryCurrency bean
     */
    public CountryCurrencyVO getCountryCurrency(Integer cntryCurrencyId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (cntryCurrencyId == null) {
            throw new IllegalArgumentException("cntryCurrencyId parameter was null in getCountryCurrency() method from CountryCurrencyController class");
        }
        
        try {
            return getCountryCurrencyManager().getCountryCurrency(cntryCurrencyId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all ExchangeRate objects from the CountryCurrency object
     * @return Collection - a collection of the ExchangeRate objects
     */
    public Collection getExchangeRates(Integer cntryCurrencyId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (cntryCurrencyId == null) {
            throw new IllegalArgumentException("cntryCurrencyId parameter was null in getExchangeRates() method from CountryCurrencyController class");
        }
        
        try {
            return getCountryCurrencyManager().getExchangeRates(cntryCurrencyId);
        }
        catch (CountryCurrencyException ex) {
            String errorMsg = "Error occurred in getExchangeRates() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getExchangeRates() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCountryCurrency objects
     * @return java.util.Collection - a collection of the CountryCurrency objects
     */
    public Collection getAllCountryCurrency()
        throws BusinessDelegateException {
        try {
            return getCountryCurrencyManager().getAllCountryCurrency();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing CountryCurrency object
     * @param cntryCurrencyId - the CountryCurrency bean primary key
     */
    public void removeCountryCurrency(Integer cntryCurrencyId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (cntryCurrencyId == null) {
            throw new IllegalArgumentException("cntryCurrencyId parameter was null in removeCountryCurrency() method from CountryCurrencyController class");
        }
        
        try {
            getCountryCurrencyManager().removeCountryCurrency(cntryCurrencyId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing CountryCurrency object
     * @param countryCurrencyVO - the value object of the CountryCurrency bean
     */
    public void updateCountryCurrency(CountryCurrencyVO countryCurrencyVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (countryCurrencyVO == null) {
            throw new IllegalArgumentException("countryCurrencyVO parameter was null in updateCountryCurrency() method from CountryCurrencyController class");
        }
        
        try {
            getCountryCurrencyManager().updateCountryCurrency(countryCurrencyVO);
        }
        catch (CountryCurrencyException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateCountryCurrency() method from CountryCurrencyController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the CountryCurrencyManager remote interface
     */
    public CountryCurrencyManager getCountryCurrencyManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            CountryCurrencyManagerHome countryCurrencyManagerHome = (CountryCurrencyManagerHome)
            service.getEJBHome(ServiceConstants.COUNTRYCURRENCYMANAGER_JNDI, CountryCurrencyManagerHome.class);
            return countryCurrencyManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCountryCurrencyManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getCountryCurrencyManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCountryCurrencyManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
