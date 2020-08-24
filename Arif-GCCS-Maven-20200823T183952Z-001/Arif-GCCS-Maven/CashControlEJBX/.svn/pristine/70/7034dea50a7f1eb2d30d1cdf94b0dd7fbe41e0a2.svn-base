/**
 * @(#)ExchangeRateController.java			Tue Aug 02 15:38:53 VET 2005
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

public class ExchangeRateController {

    /**
     * This method create new ExchangeRate object
     * @param exchangeRateVO a value object the ExchangeRate bean
     */
    public void setExchangeRate(ExchangeRateVO exchangeRateVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (exchangeRateVO == null) {
            throw new IllegalArgumentException("exchangeRateVO parameter was null in setExchangeRate() method from ExchangeRateController class");
        }
        
        try {
            getExchangeRateManager().setExchangeRate(exchangeRateVO);
        }
        catch (ExchangeRateException ex) {
            String errorMsg = "Error occurred in setExchangeRate() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setExchangeRate() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a ExchangeRate object
     * @return exchangeRateVO - a value object of the ExchangeRate bean
     */
    public ExchangeRateVO getExchangeRate(Integer exchRateId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (exchRateId == null) {
            throw new IllegalArgumentException("exchRateId parameter was null in getExchangeRate() method from ExchangeRateController class");
        }
        
        try {
            return getExchangeRateManager().getExchangeRate(exchRateId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getExchangeRate() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getExchangeRate() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllExchangeRates objects
     * @return java.util.Collection - a collection of the ExchangeRate objects
     */
    public Collection getAllExchangeRates()
        throws BusinessDelegateException {
        try {
            return getExchangeRateManager().getAllExchangeRates();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllExchangeRates() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing ExchangeRate object
     * @param exchRateId - the ExchangeRate bean primary key
     */
    public void removeExchangeRate(Integer exchRateId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (exchRateId == null) {
            throw new IllegalArgumentException("exchRateId parameter was null in removeExchangeRate() method from ExchangeRateController class");
        }
        
        try {
            getExchangeRateManager().removeExchangeRate(exchRateId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeExchangeRate() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeExchangeRate() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing ExchangeRate object
     * @param exchangeRateVO - the value object of the ExchangeRate bean
     */
    public void updateExchangeRate(ExchangeRateVO exchangeRateVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (exchangeRateVO == null) {
            throw new IllegalArgumentException("exchangeRateVO parameter was null in updateExchangeRate() method from ExchangeRateController class");
        }
        
        try {
            getExchangeRateManager().updateExchangeRate(exchangeRateVO);
        }
        catch (ExchangeRateException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateExchangeRate() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateExchangeRate() method from ExchangeRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the ExchangeRateManager remote interface
     */
    public ExchangeRateManager getExchangeRateManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            ExchangeRateManagerHome exchangeRateManagerHome = (ExchangeRateManagerHome)
            service.getEJBHome(ServiceConstants.EXCHANGERATEMANAGER_JNDI, ExchangeRateManagerHome.class);
            return exchangeRateManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getExchangeRateManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getExchangeRateManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getExchangeRateManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
