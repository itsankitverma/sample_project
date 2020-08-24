/**
 * @(#)CountryCurrencyManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class CountryCurrencyManagerBean implements SessionBean {

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
     * This method create new CountryCurrency object
     * @param countryCurrencyVO a value object the CountryCurrency bean
     */
    public void setCountryCurrency(CountryCurrencyVO countryCurrencyVO)
        throws CountryCurrencyException {
        //-- we do not accept null value for the parameter.
        if (countryCurrencyVO == null) {
            throw new IllegalArgumentException("countryCurrencyVO parameter was null in setCountryCurrency() method from CountryCurrencyManager class");
        }
        
        try {
            //-- get Country local interface
            String countryCd = countryCurrencyVO.getCountryCd();
            CountryLocal countryLocal = null;
            if (countryCd != null) {
                countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            }
            
            //-- create new CountryCurrency object
            getCountryCurrencyLocalHome().create(
                countryCurrencyVO.getCurrencyCd(),
                countryCurrencyVO.getCurrencyNm(),
                countryCurrencyVO.getCurrencyValidSince(),
                countryCurrencyVO.getCurrencySymbol(),
                countryCurrencyVO.getExchRateMin(),
                countryCurrencyVO.getExchRateMax(),
                countryLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in find the requested object to create in setCountryCurrency() method from CountryCurrencyManager class";
            throw new CountryCurrencyException(errorMsg, ex);
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setCountryCurrency() method from CountryCurrencyManager class";
            throw new CountryCurrencyException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setCountryCurrency() method from CountryCurrencyManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a CountryCurrency object
     * @return countryCurrencyVO - a value object of the CountryCurrency bean
     */
    public CountryCurrencyVO getCountryCurrency(Integer cntryCurrencyId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (cntryCurrencyId == null) {
            throw new IllegalArgumentException("cntryCurrencyId parameter was null in getCountryCurrency() method from CountryCurrencyManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            CountryCurrencyLocal countryCurrencyLocal = getCountryCurrencyLocalHome().findByPrimaryKey(cntryCurrencyId);
            //-- create new value object to store the data
            CountryCurrencyVO countryCurrencyVO = new CountryCurrencyVO();
            //-- populate the new value object
            countryCurrencyVO.setCntryCurrencyId(countryCurrencyLocal.getCntryCurrencyId());
            countryCurrencyVO.setCurrencyCd(countryCurrencyLocal.getCurrencyCd());
            countryCurrencyVO.setCurrencyNm(countryCurrencyLocal.getCurrencyNm());
            countryCurrencyVO.setCurrencyValidSince(countryCurrencyLocal.getCurrencyValidSince());
            countryCurrencyVO.setCurrencySymbol(countryCurrencyLocal.getCurrencySymbol());
            countryCurrencyVO.setExchRateMin(countryCurrencyLocal.getExchRateMin());
            countryCurrencyVO.setExchRateMax(countryCurrencyLocal.getExchRateMax());
            //-- get the primary key of the Country object from the local interface
            CountryLocal countryLocal = countryCurrencyLocal.getCountry();
            if (countryLocal != null) {
                String countryCd = (String) countryLocal.getPrimaryKey();
                countryCurrencyVO.setCountryCd(countryCd);
            }
            return countryCurrencyVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCountryCurrency() method from CountryCurrencyManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets ExchangeRate objects from the CountryCurrency object
     * @return Collection - a collection of the ExchangeRate objects
     */
    public Collection getExchangeRates(Integer cntryCurrencyId)
        throws CountryCurrencyException {
        //-- we do not accept null values for any parameters.
        if (cntryCurrencyId == null) {
            throw new IllegalArgumentException("cntryCurrencyId parameter was null in getExchangeRates() method from CountryCurrencyManager class");
        }
        
        try {
            CountryCurrencyLocal countryCurrencyLocal = getCountryCurrencyLocalHome().findByPrimaryKey(cntryCurrencyId);
            Set exchangeRateCol = countryCurrencyLocal.getExchangeRates();
            Collection list = new ArrayList();
            if (exchangeRateCol != null) {
                Iterator it = exchangeRateCol.iterator();
                while (it.hasNext()) {
                    ExchangeRateLocal exchangeRateLocal = (ExchangeRateLocal) it.next();
                    Integer exchRateId = (Integer)exchangeRateLocal.getPrimaryKey();
                    ExchangeRateVO exchangeRateVO = getExchangeRateManager().getExchangeRate(exchRateId);
                    list.add(exchangeRateVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getExchangeRates() method from CountryCurrencyManager class";
            throw new CountryCurrencyException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getExchangeRates() method from CountryCurrencyManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing CountryCurrency object
     * @param cntryCurrencyId - the CountryCurrency bean primary key
     */
    public void removeCountryCurrency(Integer cntryCurrencyId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (cntryCurrencyId == null) {
            throw new IllegalArgumentException("cntryCurrencyId parameter was null in removeCountryCurrency() method from CountryCurrencyManager class");
        }
        
        try {
            getCountryCurrencyLocalHome().remove(cntryCurrencyId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeCountryCurrency() method from CountryCurrencyManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing CountryCurrency object
     * @param countryCurrencyVO - the value object of the CountryCurrency bean
     */
    public void updateCountryCurrency(CountryCurrencyVO countryCurrencyVO)
        throws CountryCurrencyException {
        //-- we do not accept null value for the parameter.
        if (countryCurrencyVO == null) {
            throw new IllegalArgumentException("countryCurrencyVO parameter was null in updateCountryCurrency() method from CountryCurrencyManager class");
        }
        
        try {
            Integer cntryCurrencyId = countryCurrencyVO.getCntryCurrencyId();
            
            CountryCurrencyLocal countryCurrencyLocal = getCountryCurrencyLocalHome().findByPrimaryKey(cntryCurrencyId);
            //-- update CountryCurrency entity bean
            countryCurrencyLocal.setCurrencyCd(countryCurrencyVO.getCurrencyCd());
            countryCurrencyLocal.setCurrencyNm(countryCurrencyVO.getCurrencyNm());
            countryCurrencyLocal.setCurrencyValidSince(countryCurrencyVO.getCurrencyValidSince());
            countryCurrencyLocal.setCurrencySymbol(countryCurrencyVO.getCurrencySymbol());
            countryCurrencyLocal.setExchRateMin(countryCurrencyVO.getExchRateMin());
            countryCurrencyLocal.setExchRateMax(countryCurrencyVO.getExchRateMax());
            //-- get country local interface and update CountryCurrency entity bean
            //-- depending on your business need...you may have to remove the if statement
            String countryCd = countryCurrencyVO.getCountryCd();
            CountryLocal countryLocal = null;
            if (countryCd != null) {
                countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            }
            countryCurrencyLocal.setCountry(countryLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateCountryCurrency() method from CountryCurrencyManager class";
            throw new CountryCurrencyException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateCountryCurrency() method from CountryCurrencyManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCountryCurrency objects
     * @return Collection - a collection of the CountryCurrency objects
     */
    public Collection getAllCountryCurrency() {
        try {
            //-- gets the local home interface and call the findAllCountryCurrency method
            Collection countryCurrencyCol = getCountryCurrencyLocalHome().findAllCountryCurrency();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (countryCurrencyCol != null && countryCurrencyCol.size() > 0) {
                Iterator it = countryCurrencyCol.iterator();
                while (it.hasNext()) {
                    CountryCurrencyLocal countryCurrencyLocal = (CountryCurrencyLocal) it.next();
                    //-- get the primary key of the CountryCurrency EJB object
                    Integer cntryCurrencyId = (Integer)countryCurrencyLocal.getPrimaryKey();
                    //-- get the value object for the CountryCurrency EJB using the primary key
                    if (cntryCurrencyId != null) {
                        CountryCurrencyVO countryCurrencyVO = getCountryCurrency(cntryCurrencyId);
                        //-- add the value object to the collection
                        list.add(countryCurrencyVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllCountryCurrency() method from CountryCurrencyManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllCountryCurrency() method from CountryCurrencyManager class";
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

    /**
     * This methods gets the Country local home interface
     */
    private CountryLocalHome getCountryLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (CountryLocalHome) service.getEJBLocalHome(ServiceConstants.COUNTRY_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCountryLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the ExchangeRateManager remote interface
     */
    public ExchangeRateManager getExchangeRateManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            ExchangeRateManagerHome exchangeRateManagerHome = (ExchangeRateManagerHome)
            service.getEJBHome(ServiceConstants.EXCHANGERATEMANAGER_REMOTE_JNDI, ExchangeRateManagerHome.class);
            return exchangeRateManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getExchangeRateManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getExchangeRateManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getExchangeRateManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
