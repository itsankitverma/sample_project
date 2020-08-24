/**
 * @(#)CountryController.java			Wed Aug 03 13:22:35 VET 2005
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

public class CountryController {

    /**
     * This method create new Country object
     * @param countryVO a value object the Country bean
     */
    public void setCountry(CountryVO countryVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (countryVO == null) {
            throw new IllegalArgumentException("countryVO parameter was null in setCountry() method from CountryController class");
        }
        
        try {
            getCountryManager().setCountry(countryVO);
        }
        catch (CountryException ex) {
            String errorMsg = "Error occurred in setCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Country object
     * @return countryVO - a value object of the Country bean
     */
    public CountryVO getCountry(String countryCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in getCountry() method from CountryController class");
        }
        
        try {
            return getCountryManager().getCountry(countryCd);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all Bank objects from the Country object
     * @return Collection - a collection of the Bank objects
     */
    public Collection getBanks(String countryCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in getBanks() method from CountryController class");
        }
        
        try {
            return getCountryManager().getBanks(countryCd);
        }
        catch (CountryException ex) {
            String errorMsg = "Error occurred in getBanks() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBanks() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all CountryCurrency objects from the Country object
     * @return Collection - a collection of the CountryCurrency objects
     */
    public Collection getCountryCurrency(String countryCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in getCountryCurrency() method from CountryController class");
        }
        
        try {
            return getCountryManager().getCountryCurrency(countryCd);
        }
        catch (CountryException ex) {
            String errorMsg = "Error occurred in getCountryCurrency() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCountryCurrency() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all Location objects from the Country object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(String countryCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in getLocations() method from CountryController class");
        }
        
        try {
            return getCountryManager().getLocations(countryCd);
        }
        catch (CountryException ex) {
            String errorMsg = "Error occurred in getLocations() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocations() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCountry objects
     * @return java.util.Collection - a collection of the Country objects
     */
    public Collection getAllCountry()
        throws BusinessDelegateException {
        try {
            return getCountryManager().getAllCountry();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Country object
     * @param countryCd - the Country bean primary key
     */
    public void removeCountry(String countryCd)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in removeCountry() method from CountryController class");
        }
        
        try {
            getCountryManager().removeCountry(countryCd);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Country object
     * @param countryVO - the value object of the Country bean
     */
    public void updateCountry(CountryVO countryVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (countryVO == null) {
            throw new IllegalArgumentException("countryVO parameter was null in updateCountry() method from CountryController class");
        }
        
        try {
            getCountryManager().updateCountry(countryVO);
        }
        catch (CountryException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateCountry() method from CountryController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the CountryManager remote interface
     */
    public CountryManager getCountryManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            CountryManagerHome countryManagerHome = (CountryManagerHome)
            service.getEJBHome(ServiceConstants.COUNTRYMANAGER_JNDI, CountryManagerHome.class);
            return countryManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCountryManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getCountryManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCountryManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
