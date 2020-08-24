/**
 * @(#)ExchangeRateManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.manager;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class ExchangeRateManagerBean implements SessionBean {

    private SessionContext _ctx;
    /**
     * Called by Container. This method initialization the session
     */
    public void ejbCreate() {
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * EJB Container calls this method right before it remove the Session bean 
     */
    public void ejbRemove() {
    }

    /**
     * Called by Container. Associates this Bean instance with a particular context environment.
     */
    public void setSessionContext(SessionContext ctx) {
        _ctx = ctx;
    }

    /**
     * This method create new ExchangeRate object
     * @param exchangeRateVO a value object the ExchangeRate bean
     */
    public void setExchangeRate(ExchangeRateVO exchangeRateVO)
        throws ExchangeRateException {
        //-- we do not accept null value for the parameter.
        if (exchangeRateVO == null) {
            throw new IllegalArgumentException("exchangeRateVO parameter was null in setExchangeRate() method from ExchangeRateManager class");
        }
        
        try {
            //-- get CountryCurrency local interface
            Integer cntryCurrencyId = exchangeRateVO.getCntryCurrencyId();
            CountryCurrencyLocal countryCurrencyLocal = null;
            if (cntryCurrencyId != null) {
                countryCurrencyLocal = getCountryCurrencyLocalHome().findByPrimaryKey(cntryCurrencyId);
            }
            
            //-- create new ExchangeRate object
            getExchangeRateLocalHome().create(
                exchangeRateVO.getExchRate(),
                exchangeRateVO.getExchRtByUsd(),
                exchangeRateVO.getExchRateType(),
                countryCurrencyLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in find the requested object to create in setExchangeRate() method from ExchangeRateManager class";
            throw new ExchangeRateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setExchangeRate() method from ExchangeRateManager class";
            throw new ExchangeRateException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setExchangeRate() method from ExchangeRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a ExchangeRate object
     * @return exchangeRateVO - a value object of the ExchangeRate bean
     */
    public ExchangeRateVO getExchangeRate(Integer exchRateId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (exchRateId == null) {
            throw new IllegalArgumentException("exchRateId parameter was null in getExchangeRate() method from ExchangeRateManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            ExchangeRateLocal exchangeRateLocal = getExchangeRateLocalHome().findByPrimaryKey(exchRateId);
            //-- create new value object to store the data
            ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
            //-- populate the new value object
            exchangeRateVO.setExchRateId(exchangeRateLocal.getExchRateId());
            exchangeRateVO.setExchRate(exchangeRateLocal.getExchRate());
            exchangeRateVO.setExchRtByUsd(exchangeRateLocal.getExchRtByUsd());
            exchangeRateVO.setExchRateType(exchangeRateLocal.getExchRateType());
            //-- get the primary key of the CountryCurrency object from the local interface
            CountryCurrencyLocal countryCurrencyLocal = exchangeRateLocal.getCountryCurrency();
            if (countryCurrencyLocal != null) {
                Integer cntryCurrencyId = (Integer) countryCurrencyLocal.getPrimaryKey();
                exchangeRateVO.setCntryCurrencyId(cntryCurrencyId);
            }
            return exchangeRateVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getExchangeRate() method from ExchangeRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing ExchangeRate object
     * @param exchRateId - the ExchangeRate bean primary key
     */
    public void removeExchangeRate(Integer exchRateId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (exchRateId == null) {
            throw new IllegalArgumentException("exchRateId parameter was null in removeExchangeRate() method from ExchangeRateManager class");
        }
        
        try {
            getExchangeRateLocalHome().remove(exchRateId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeExchangeRate() method from ExchangeRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing ExchangeRate object
     * @param exchangeRateVO - the value object of the ExchangeRate bean
     */
    public void updateExchangeRate(ExchangeRateVO exchangeRateVO)
        throws ExchangeRateException {
        //-- we do not accept null value for the parameter.
        if (exchangeRateVO == null) {
            throw new IllegalArgumentException("exchangeRateVO parameter was null in updateExchangeRate() method from ExchangeRateManager class");
        }
        
        try {
            Integer exchRateId = exchangeRateVO.getExchRateId();
            
            ExchangeRateLocal exchangeRateLocal = getExchangeRateLocalHome().findByPrimaryKey(exchRateId);
            //-- update ExchangeRate entity bean
            exchangeRateLocal.setExchRate(exchangeRateVO.getExchRate());
            exchangeRateLocal.setExchRtByUsd(exchangeRateVO.getExchRtByUsd());
            exchangeRateLocal.setExchRateType(exchangeRateVO.getExchRateType());
            //-- get countryCurrency local interface and update ExchangeRate entity bean
            //-- depending on your business need...you may have to remove the if statement
            Integer cntryCurrencyId = exchangeRateVO.getCntryCurrencyId();
            CountryCurrencyLocal countryCurrencyLocal = null;
            if (cntryCurrencyId != null) {
                countryCurrencyLocal = getCountryCurrencyLocalHome().findByPrimaryKey(cntryCurrencyId);
            }
            exchangeRateLocal.setCountryCurrency(countryCurrencyLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateExchangeRate() method from ExchangeRateManager class";
            throw new ExchangeRateException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateExchangeRate() method from ExchangeRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllExchangeRates objects
     * @return Collection - a collection of the ExchangeRate objects
     */
    public Collection getAllExchangeRates() {
        try {
            //-- gets the local home interface and call the findAllExchangeRates method
            Collection exchangeRateCol = getExchangeRateLocalHome().findAllExchangeRates();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (exchangeRateCol != null && exchangeRateCol.size() > 0) {
                Iterator it = exchangeRateCol.iterator();
                while (it.hasNext()) {
                    ExchangeRateLocal exchangeRateLocal = (ExchangeRateLocal) it.next();
                    //-- get the primary key of the ExchangeRate EJB object
                    Integer exchRateId = (Integer)exchangeRateLocal.getPrimaryKey();
                    //-- get the value object for the ExchangeRate EJB using the primary key
                    if (exchRateId != null) {
                        ExchangeRateVO exchangeRateVO = getExchangeRate(exchRateId);
                        //-- add the value object to the collection
                        list.add(exchangeRateVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllExchangeRates() method from ExchangeRateManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllExchangeRates() method from ExchangeRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the ExchangeRate local home interface
     */
    private ExchangeRateLocalHome getExchangeRateLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (ExchangeRateLocalHome) service.getEJBLocalHome(ServiceConstants.EXCHANGERATE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getExchangeRateLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the CountryCurrency local home interface
     */
    private CountryCurrencyLocalHome getCountryCurrencyLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (CountryCurrencyLocalHome) service.getEJBLocalHome(ServiceConstants.COUNTRYCURRENCY_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCountryCurrencyLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
