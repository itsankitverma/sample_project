/**
 * @(#)LocationManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class LocationManagerBean implements SessionBean {

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
     * This method create new Location object
     * @param locationVO a value object the Location bean
     */
    public void setLocation(LocationVO locationVO)
        throws LocationException {
        //-- we do not accept null value for the parameter.
        if (locationVO == null) {
            throw new IllegalArgumentException("locationVO parameter was null in setLocation() method from LocationManager class");
        }
        
        try {
            //-- get Country local interface
            String countryCd = locationVO.getCountryCd();
            CountryLocal countryLocal = null;
            if (countryCd != null) {
                countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            }
            
            //-- create new Location object
            getLocationLocalHome().create(
                locationVO.getLocationCd(),
                locationVO.getLocationNm(),
                locationVO.getLocationType(),
                locationVO.getLocationTmZn(),
                locationVO.getLocationGmtOffset(),
                countryLocal,
                locationVO.getSplitDepBySrc(),
                locationVO.getSplitDepByCurr(),
                locationVO.getSplitDepByPymtType(),
                locationVO.getLocalDefaultAcc(),
                locationVO.getUsdDefaultAcc(),
                locationVO.getManCreditCard(),
                locationVO.getCreditCardPymtType(),
                locationVO.getAllowPrpDelay(),
                locationVO.getActiveLocation(),
                locationVO.getDepoCurrencyDef(),
                locationVO.getPrScanRfshFlg(),
                locationVO.getPrScanRfshIntvlNbr(),
                locationVO.getParentLocationCd());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in find the requested object to create in setLocation() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setLocation() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setLocation() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Location object
     * @return locationVO - a value object of the Location bean
     */
    public LocationVO getLocation(String locationCd)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getLocation() method from LocationManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            //-- create new value object to store the data
            LocationVO locationVO = new LocationVO();
            //-- populate the new value object
            locationVO.setLocationCd(locationLocal.getLocationCd());
            locationVO.setLocationNm(locationLocal.getLocationNm());
            locationVO.setLocationType(locationLocal.getLocationType());
            locationVO.setLocationTmZn(locationLocal.getLocationTmZn());
            locationVO.setLocationGmtOffset(locationLocal.getLocationGmtOffset());
            locationVO.setSplitDepBySrc(locationLocal.getSplitDepBySrc());
            locationVO.setSplitDepByCurr(locationLocal.getSplitDepByCurr());
            locationVO.setSplitDepByPymtType(locationLocal.getSplitDepByPymtType());
            locationVO.setLocalDefaultAcc(locationLocal.getLocalDefaultAcc());
            locationVO.setUsdDefaultAcc(locationLocal.getUsdDefaultAcc());
            locationVO.setManCreditCard(locationLocal.getManCreditCard());
            locationVO.setCreditCardPymtType(locationLocal.getCreditCardPymtType());
            locationVO.setAllowPrpDelay(locationLocal.getAllowPrpDelay());
            locationVO.setActiveLocation(locationLocal.getActiveLocation());
            locationVO.setDepoCurrencyDef(locationLocal.getDepoCurrencyDef());
            locationVO.setPrScanRfshFlg(locationLocal.getPrScanRfshFlg());
            locationVO.setPrScanRfshIntvlNbr(locationLocal.getPrScanRfshIntvlNbr());
            locationVO.setHoldLocation(locationLocal.getHoldLocation());
            locationVO.setDualCurrFlg(locationLocal.getDualCurrFlg());
            locationVO.setInCageTskIdNbr(locationLocal.getInCageTskIdNbr());
            locationVO.setRihTskIdNbr(locationLocal.getRihTskIdNbr());
            locationVO.setParentLocationCd(locationLocal.getParentLocationCd());
            //-- get the primary key of the Country object from the local interface
            CountryLocal countryLocal = locationLocal.getCountry();
            if (countryLocal != null) {
                String countryCd = (String) countryLocal.getPrimaryKey();
                locationVO.setCountryCd(countryCd);
            }
            return locationVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getLocation() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Employee object to the Location object
     * @param locationCd a primary key of Location object
     * @param employeeId a primary key of Employee object
     */
    public void addEmployee(String locationCd, String employeeId)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addEmployee() method from LocationManager class");
        }
        
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in addEmployee() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            EmployeeLocal employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            locationLocal.addEmployee(employeeLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addEmployee() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addEmployee() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Employee object to the Location object
     * @param locationCd a primary key of Location object
     * @param employeeId a primary key of Employee object
     */
    public void removeEmployee(String locationCd, String employeeId)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeEmployee() method from LocationManager class");
        }
        
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in removeEmployee() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            EmployeeLocal employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            locationLocal.removeEmployee(employeeLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removeEmployee() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeEmployee() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets Employee objects from the Location object
     * @return Collection - a collection of the Employee objects
     */
    public Collection getEmployees(String locationCd)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getEmployees() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            Set employeeCol = locationLocal.getEmployees();
            Collection list = new ArrayList();
            if (employeeCol != null) {
                Iterator it = employeeCol.iterator();
                while (it.hasNext()) {
                    EmployeeLocal employeeLocal = (EmployeeLocal) it.next();
                    String employeeId = (String)employeeLocal.getPrimaryKey();
                    EmployeeVO employeeVO = getEmployeeManager().getEmployee(employeeId);
                    list.add(employeeVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getEmployees() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmployees() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the PaymentType object to the Location object
     * @param locationCd a primary key of Location object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void addPaymentType(String locationCd, Integer paymentTypeId)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addPaymentType() method from LocationManager class");
        }
        
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in addPaymentType() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            locationLocal.addPaymentType(paymentTypeLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addPaymentType() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addPaymentType() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the PaymentType object to the Location object
     * @param locationCd a primary key of Location object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void removePaymentType(String locationCd, Integer paymentTypeId)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removePaymentType() method from LocationManager class");
        }
        
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removePaymentType() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            locationLocal.removePaymentType(paymentTypeLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removePaymentType() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePaymentType() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets PaymentType objects from the Location object
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypes(String locationCd)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getPaymentTypes() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            Set paymentTypeCol = locationLocal.getPaymentTypes();
            Collection list = new ArrayList();
            if (paymentTypeCol != null) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    PaymentTypeVO paymentTypeVO = getPaymentTypeManager().getPaymentType(paymentTypeId);
                    list.add(paymentTypeVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPaymentTypes() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypes() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the BankAcc object to the Location object
     * @param locationCd a primary key of Location object
     * @param bankAccountCd a primary key of BankAcc object
     */
    public void addBankAcc(String locationCd, Integer bankAccountCd)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addBankAcc() method from LocationManager class");
        }
        
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in addBankAcc() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            BankAccLocal bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            locationLocal.addBankAcc(bankAccLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addBankAcc() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addBankAcc() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the BankAcc object to the Location object
     * @param locationCd a primary key of Location object
     * @param bankAccountCd a primary key of BankAcc object
     */
    public void removeBankAcc(String locationCd, Integer bankAccountCd)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeBankAcc() method from LocationManager class");
        }
        
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in removeBankAcc() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            BankAccLocal bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            locationLocal.removeBankAcc(bankAccLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removeBankAcc() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeBankAcc() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets BankAcc objects from the Location object
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccs(String locationCd)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getBankAccs() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            Set bankAccCol = locationLocal.getBankAccs();
            Collection list = new ArrayList();
            if (bankAccCol != null) {
                Iterator it = bankAccCol.iterator();
                while (it.hasNext()) {
                    BankAccLocal bankAccLocal = (BankAccLocal) it.next();
                    Integer bankAccountCd = (Integer)bankAccLocal.getPrimaryKey();
                    BankAccVO bankAccVO = getBankAccManager().getBankAcc(bankAccountCd);
                    list.add(bankAccVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getBankAccs() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getBankAccs() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the DepTempl object to the Location object
     * @param locationCd a primary key of Location object
     * @param templId a primary key of DepTempl object
     */
    public void addDepTempl(String locationCd, Integer templId)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addDepTempl() method from LocationManager class");
        }
        
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in addDepTempl() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            locationLocal.addDepTempl(depTemplLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addDepTempl() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addDepTempl() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the DepTempl object to the Location object
     * @param locationCd a primary key of Location object
     * @param templId a primary key of DepTempl object
     */
    public void removeDepTempl(String locationCd, Integer templId)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeDepTempl() method from LocationManager class");
        }
        
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removeDepTempl() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            locationLocal.removeDepTempl(depTemplLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removeDepTempl() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets DepTempl objects from the Location object
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getDepTempls(String locationCd)
        throws LocationException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getDepTempls() method from LocationManager class");
        }
        
        try {
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            Set depTemplCol = locationLocal.getDepTempls();
            Collection list = new ArrayList();
            if (depTemplCol != null) {
                Iterator it = depTemplCol.iterator();
                while (it.hasNext()) {
                    DepTemplLocal depTemplLocal = (DepTemplLocal) it.next();
                    Integer templId = (Integer)depTemplLocal.getPrimaryKey();
                    DepTemplVO depTemplVO = getDepTemplManager().getDepTempl(templId);
                    list.add(depTemplVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getDepTempls() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepTempls() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Location object
     * @param locationCd - the Location bean primary key
     */
    public void removeLocation(String locationCd)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from LocationManager class");
        }
        
        try {
            getLocationLocalHome().remove(locationCd);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeLocation() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Location object
     * @param locationVO - the value object of the Location bean
     */
    public void updateLocation(LocationVO locationVO)
        throws LocationException {
        //-- we do not accept null value for the parameter.
        if (locationVO == null) {
            throw new IllegalArgumentException("locationVO parameter was null in updateLocation() method from LocationManager class");
        }
        
        try {
            String locationCd = locationVO.getLocationCd();
            
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            //-- update Location entity bean
            locationLocal.setLocationNm(locationVO.getLocationNm());
            locationLocal.setLocationType(locationVO.getLocationType());
            locationLocal.setLocationTmZn(locationVO.getLocationTmZn());
            locationLocal.setLocationGmtOffset(locationVO.getLocationGmtOffset());
            locationLocal.setSplitDepBySrc(locationVO.getSplitDepBySrc());
            locationLocal.setSplitDepByCurr(locationVO.getSplitDepByCurr());
            locationLocal.setSplitDepByPymtType(locationVO.getSplitDepByPymtType());
            locationLocal.setLocalDefaultAcc(locationVO.getLocalDefaultAcc());
            locationLocal.setUsdDefaultAcc(locationVO.getUsdDefaultAcc());
            locationLocal.setManCreditCard(locationVO.getManCreditCard());
            locationLocal.setCreditCardPymtType(locationVO.getCreditCardPymtType());
            locationLocal.setAllowPrpDelay(locationVO.getAllowPrpDelay());
            locationLocal.setActiveLocation(locationVO.getActiveLocation());
            locationLocal.setDepoCurrencyDef(locationVO.getDepoCurrencyDef());
            locationLocal.setPrScanRfshFlg(locationVO.getPrScanRfshFlg());
            locationLocal.setPrScanRfshIntvlNbr(locationVO.getPrScanRfshIntvlNbr());
            locationLocal.setHoldLocation(locationVO.getHoldLocation());
            locationLocal.setDualCurrFlg(locationVO.getDualCurrFlg());
            locationLocal.setInCageTskIdNbr(locationVO.getInCageTskIdNbr());
            locationLocal.setRihTskIdNbr(locationVO.getRihTskIdNbr());
            locationLocal.setParentLocationCd(locationVO.getParentLocationCd());
            //-- get country local interface and update Location entity bean
            //-- depending on your business need...you may have to remove the if statement
            String countryCd = locationVO.getCountryCd();
            CountryLocal countryLocal = null;
            if (countryCd != null) {
                countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            }
            locationLocal.setCountry(countryLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateLocation() method from LocationManager class";
            throw new LocationException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateLocation() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllLocations objects
     * @return Collection - a collection of the Location objects
     */
    public Collection getAllLocations() {
        try {
            //-- gets the local home interface and call the findAllLocations method
            Collection locationCol = getLocationLocalHome().findAllLocations();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (locationCol != null && locationCol.size() > 0) {
                Iterator it = locationCol.iterator();
                while (it.hasNext()) {
                    LocationLocal locationLocal = (LocationLocal) it.next();
                    //-- get the primary key of the Location EJB object
                    String locationCd = (String)locationLocal.getPrimaryKey();
                    //-- get the value object for the Location EJB using the primary key
                    if (locationCd != null) {
                        LocationVO locationVO = getLocation(locationCd);
                        //-- add the value object to the collection
                        list.add(locationVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllLocations() method from LocationManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllLocations() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByCountryCd objects
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocationByCountryCd(String countryCd) {
        try {
            //-- gets the local home interface and call the findByCountryCd method
            Collection locationCol = getLocationLocalHome().findByCountryCd(countryCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (locationCol != null && locationCol.size() > 0) {
                Iterator it = locationCol.iterator();
                while (it.hasNext()) {
                    LocationLocal locationLocal = (LocationLocal) it.next();
                    //-- get the primary key of the Location EJB object
                    String locationCd = (String)locationLocal.getPrimaryKey();
                    //-- get the value object for the Location EJB using the primary key
                    if (locationCd != null) {
                        LocationVO locationVO = getLocation(locationCd);
                        //-- add the value object to the collection
                        list.add(locationVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getLocationByCountryCd() method from LocationManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getLocationByCountryCd() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllParentLocations objects
     * @return Collection - a collection of the Location objects
     */
    public Collection getAllParentLocations(String employeeId) {
        try {
            //-- gets the local home interface and call the findAllParentLocations method
            Collection locationCol = getLocationLocalHome().findAllParentLocations(employeeId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (locationCol != null && locationCol.size() > 0) {
                Iterator it = locationCol.iterator();
                while (it.hasNext()) {
                    LocationLocal locationLocal = (LocationLocal) it.next();
                    //-- get the primary key of the Location EJB object
                    String locationCd = (String)locationLocal.getPrimaryKey();
                    //-- get the value object for the Location EJB using the primary key
                    if (locationCd != null) {
                        LocationVO locationVO = getLocation(locationCd);
                        //-- add the value object to the collection
                        list.add(locationVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllParentLocations() method from LocationManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllParentLocations() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPossibleParentLocationsByCountry objects
     * @return Collection - a collection of the Location objects
     */
    public Collection getAllPossibleParentLocationsByCountry(String locCd, String countryCd) {
        try {
            //-- gets the local home interface and call the findAllPossibleParentLocationsByCountry method
            Collection locationCol = getLocationLocalHome().findAllPossibleParentLocationsByCountry(locCd, countryCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (locationCol != null && locationCol.size() > 0) {
                Iterator it = locationCol.iterator();
                while (it.hasNext()) {
                    LocationLocal locationLocal = (LocationLocal) it.next();
                    //-- get the primary key of the Location EJB object
                    String locationCd = (String)locationLocal.getPrimaryKey();
                    //-- get the value object for the Location EJB using the primary key
                    if (locationCd != null) {
                        LocationVO locationVO = getLocation(locationCd);
                        //-- add the value object to the collection
                        list.add(locationVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPossibleParentLocationsByCountry() method from LocationManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPossibleParentLocationsByCountry() method from LocationManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Location local home interface
     */
    private LocationLocalHome getLocationLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (LocationLocalHome) service.getEJBLocalHome(ServiceConstants.LOCATION_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationLocalHome() method when lookup the local home interface";
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
     * This methods gets the Employee local home interface
     */
    private EmployeeLocalHome getEmployeeLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (EmployeeLocalHome) service.getEJBLocalHome(ServiceConstants.EMPLOYEE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PaymentType local home interface
     */
    private PaymentTypeLocalHome getPaymentTypeLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PaymentTypeLocalHome) service.getEJBLocalHome(ServiceConstants.PAYMENTTYPE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPaymentTypeLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the BankAcc local home interface
     */
    private BankAccLocalHome getBankAccLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (BankAccLocalHome) service.getEJBLocalHome(ServiceConstants.BANKACC_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankAccLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the DepTempl local home interface
     */
    private DepTemplLocalHome getDepTemplLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (DepTemplLocalHome) service.getEJBLocalHome(ServiceConstants.DEPTEMPL_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the EmployeeManager remote interface
     */
    public EmployeeManager getEmployeeManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            EmployeeManagerHome employeeManagerHome = (EmployeeManagerHome)
            service.getEJBHome(ServiceConstants.EMPLOYEEMANAGER_REMOTE_JNDI, EmployeeManagerHome.class);
            return employeeManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getEmployeeManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmployeeManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PaymentTypeManager remote interface
     */
    public PaymentTypeManager getPaymentTypeManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PaymentTypeManagerHome paymentTypeManagerHome = (PaymentTypeManagerHome)
            service.getEJBHome(ServiceConstants.PAYMENTTYPEMANAGER_REMOTE_JNDI, PaymentTypeManagerHome.class);
            return paymentTypeManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the BankAccManager remote interface
     */
    public BankAccManager getBankAccManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            BankAccManagerHome bankAccManagerHome = (BankAccManagerHome)
            service.getEJBHome(ServiceConstants.BANKACCMANAGER_REMOTE_JNDI, BankAccManagerHome.class);
            return bankAccManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the DepTemplManager remote interface
     */
    public DepTemplManager getDepTemplManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            DepTemplManagerHome depTemplManagerHome = (DepTemplManagerHome)
            service.getEJBHome(ServiceConstants.DEPTEMPLMANAGER_REMOTE_JNDI, DepTemplManagerHome.class);
            return depTemplManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
