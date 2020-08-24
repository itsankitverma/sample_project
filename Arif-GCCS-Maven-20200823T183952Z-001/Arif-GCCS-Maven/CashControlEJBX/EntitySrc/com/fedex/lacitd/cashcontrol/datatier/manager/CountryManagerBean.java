/**
 * @(#)CountryManagerBean.java			Wed Aug 03 13:22:32 VET 2005
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

public class CountryManagerBean implements SessionBean {

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
     * This method create new Country object
     * @param countryVO a value object the Country bean
     */
    public void setCountry(CountryVO countryVO)
        throws CountryException {
        //-- we do not accept null value for the parameter.
        if (countryVO == null) {
            throw new IllegalArgumentException("countryVO parameter was null in setCountry() method from CountryManager class");
        }
        
        try {
            
            //-- create new Country object
            getCountryLocalHome().create(
                countryVO.getCountryCd(),
                countryVO.getCountryNm(),
                countryVO.getErrThldLocCurr(),
                countryVO.getErrThldUsd(),
                countryVO.getQuickApplyFlg(),
                countryVO.getScanUsdDecNbr(),
                countryVO.getScanLocalDecNbr(),
                countryVO.getGndUsedFlag(),
                countryVO.getOacUsedFlag(),
            	countryVO.getCollectlaterFlag(),
            	countryVO.getCodUsedFlag(),
            	countryVO.getFtcUsedFlag() );
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setCountry() method from CountryManager class";
            throw new CountryException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setCountry() method from CountryManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Country object
     * @return countryVO - a value object of the Country bean
     */
    public CountryVO getCountry(String countryCd)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in getCountry() method from CountryManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            CountryLocal countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            //-- create new value object to store the data
            CountryVO countryVO = new CountryVO();
            //-- populate the new value object
            countryVO.setCountryCd(countryLocal.getCountryCd());
            countryVO.setCountryNm(countryLocal.getCountryNm());
            countryVO.setErrThldLocCurr(countryLocal.getErrThldLocCurr());
            countryVO.setErrThldUsd(countryLocal.getErrThldUsd());
            countryVO.setQuickApplyFlg(countryLocal.getQuickApplyFlg());
            countryVO.setScanUsdDecNbr(countryLocal.getScanUsdDecNbr());
            countryVO.setScanLocalDecNbr(countryLocal.getScanLocalDecNbr());
            countryVO.setGndUsedFlag(countryLocal.getGndUsedFlag());
            countryVO.setOacUsedFlag(countryLocal.getOacUsedFlag());
            countryVO.setCollectlaterFlag(countryLocal.getCollectlaterFlag());
            countryVO.setCodUsedFlag(countryLocal.getCodUsedFlag());
            countryVO.setFtcUsedFlag(countryLocal.getFtcUsedFlag());
            return countryVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCountry() method from CountryManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets Bank objects from the Country object
     * @return Collection - a collection of the Bank objects
     */
    public Collection getBanks(String countryCd)
        throws CountryException {
        //-- we do not accept null values for any parameters.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in getBanks() method from CountryManager class");
        }
        
        try {
            CountryLocal countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            Set bankCol = countryLocal.getBanks();
            Collection list = new ArrayList();
            if (bankCol != null) {
                Iterator it = bankCol.iterator();
                while (it.hasNext()) {
                    BankLocal bankLocal = (BankLocal) it.next();
                    Integer bankId = (Integer)bankLocal.getPrimaryKey();
                    BankVO bankVO = getBankManager().getBank(bankId);
                    list.add(bankVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getBanks() method from CountryManager class";
            throw new CountryException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getBanks() method from CountryManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets CountryCurrency objects from the Country object
     * @return Collection - a collection of the CountryCurrency objects
     */
    public Collection getCountryCurrency(String countryCd)
        throws CountryException {
        //-- we do not accept null values for any parameters.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in getCountryCurrency() method from CountryManager class");
        }
        
        try {
            CountryLocal countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            Set countryCurrencyCol = countryLocal.getCountryCurrency();
            Collection list = new ArrayList();
            if (countryCurrencyCol != null) {
                Iterator it = countryCurrencyCol.iterator();
                while (it.hasNext()) {
                    CountryCurrencyLocal countryCurrencyLocal = (CountryCurrencyLocal) it.next();
                    Integer cntryCurrencyId = (Integer)countryCurrencyLocal.getPrimaryKey();
                    CountryCurrencyVO countryCurrencyVO = getCountryCurrencyManager().getCountryCurrency(cntryCurrencyId);
                    list.add(countryCurrencyVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getCountryCurrency() method from CountryManager class";
            throw new CountryException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCountryCurrency() method from CountryManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets Location objects from the Country object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(String countryCd)
        throws CountryException {
        //-- we do not accept null values for any parameters.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in getLocations() method from CountryManager class");
        }
        
        try {
            CountryLocal countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            Set locationCol = countryLocal.getLocations();
            Collection list = new ArrayList();
            if (locationCol != null) {
                Iterator it = locationCol.iterator();
                while (it.hasNext()) {
                    LocationLocal locationLocal = (LocationLocal) it.next();
                    String locationCd = (String)locationLocal.getPrimaryKey();
                    LocationVO locationVO = getLocationManager().getLocation(locationCd);
                    list.add(locationVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getLocations() method from CountryManager class";
            throw new CountryException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getLocations() method from CountryManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Country object
     * @param countryCd - the Country bean primary key
     */
    public void removeCountry(String countryCd)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (countryCd == null) {
            throw new IllegalArgumentException("countryCd parameter was null in removeCountry() method from CountryManager class");
        }
        
        try {
            getCountryLocalHome().remove(countryCd);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeCountry() method from CountryManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Country object
     * @param countryVO - the value object of the Country bean
     */
    public void updateCountry(CountryVO countryVO)
        throws CountryException {
        //-- we do not accept null value for the parameter.
        if (countryVO == null) {
            throw new IllegalArgumentException("countryVO parameter was null in updateCountry() method from CountryManager class");
        }
        
        try {
            String countryCd = countryVO.getCountryCd();
            
            CountryLocal countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            //-- update Country entity bean
            countryLocal.setCountryNm(countryVO.getCountryNm());
            countryLocal.setErrThldLocCurr(countryVO.getErrThldLocCurr());
            countryLocal.setErrThldUsd(countryVO.getErrThldUsd());
            countryLocal.setQuickApplyFlg(countryVO.getQuickApplyFlg());
            countryLocal.setScanUsdDecNbr(countryVO.getScanUsdDecNbr());
            countryLocal.setScanLocalDecNbr(countryVO.getScanLocalDecNbr());
            countryLocal.setGndUsedFlag(countryVO.getGndUsedFlag());
            countryLocal.setOacUsedFlag(countryVO.getOacUsedFlag());
            countryLocal.setCollectlaterFlag(countryVO.getCollectlaterFlag());
            countryLocal.setCodUsedFlag(countryVO.getCodUsedFlag());
            countryLocal.setFtcUsedFlag(countryVO.getFtcUsedFlag());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateCountry() method from CountryManager class";
            throw new CountryException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateCountry() method from CountryManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCountry objects
     * @return Collection - a collection of the Country objects
     */
    public Collection getAllCountry() {
        try {
            //-- gets the local home interface and call the findAllCountry method
            Collection countryCol = getCountryLocalHome().findAllCountry();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (countryCol != null && countryCol.size() > 0) {
                Iterator it = countryCol.iterator();
                while (it.hasNext()) {
                    CountryLocal countryLocal = (CountryLocal) it.next();
                    //-- get the primary key of the Country EJB object
                    String countryCd = (String)countryLocal.getPrimaryKey();
                    //-- get the value object for the Country EJB using the primary key
                    if (countryCd != null) {
                        CountryVO countryVO = getCountry(countryCd);
                        //-- add the value object to the collection
                        list.add(countryVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllCountry() method from CountryManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllCountry() method from CountryManager class";
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
     * This method gets the BankManager remote interface
     */
    public BankManager getBankManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            BankManagerHome bankManagerHome = (BankManagerHome)
            service.getEJBHome(ServiceConstants.BANKMANAGER_REMOTE_JNDI, BankManagerHome.class);
            return bankManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getBankManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the CountryCurrencyManager remote interface
     */
    public CountryCurrencyManager getCountryCurrencyManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            CountryCurrencyManagerHome countryCurrencyManagerHome = (CountryCurrencyManagerHome)
            service.getEJBHome(ServiceConstants.COUNTRYCURRENCYMANAGER_REMOTE_JNDI, CountryCurrencyManagerHome.class);
            return countryCurrencyManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCountryCurrencyManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getCountryCurrencyManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCountryCurrencyManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the LocationManager remote interface
     */
    public LocationManager getLocationManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            LocationManagerHome locationManagerHome = (LocationManagerHome)
            service.getEJBHome(ServiceConstants.LOCATIONMANAGER_REMOTE_JNDI, LocationManagerHome.class);
            return locationManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
