/**
 * @(#)LocationController.java			Tue Aug 02 15:38:53 VET 2005
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

public class LocationController {

    /**
     * This method create new Location object
     * @param locationVO a value object the Location bean
     */
    public void setLocation(LocationVO locationVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (locationVO == null) {
            throw new IllegalArgumentException("locationVO parameter was null in setLocation() method from LocationController class");
        }
        
        try {
            getLocationManager().setLocation(locationVO);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in setLocation() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setLocation() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Location object
     * @return locationVO - a value object of the Location bean
     */
    public LocationVO getLocation(String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getLocation() method from LocationController class");
        }
        
        try {
            return getLocationManager().getLocation(locationCd);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getLocation() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocation() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Employee object to the Location object
     * @param locationCd a primary key of Location object
     * @param employeeId a primary key of Employee object
     */
    public void addEmployee(String locationCd, String employeeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addEmployee() method from LocationController class");
        }
        
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in addEmployee() method from LocationController class");
        }
        
        try {
            getLocationManager().addEmployee(locationCd, employeeId);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in addEmployee() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addEmployee() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Employee object to the Location object
     * @param locationCd a primary key of Location object
     * @param employeeId a primary key of Employee object
     */
    public void removeEmployee(String locationCd, String employeeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeEmployee() method from LocationController class");
        }
        
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in removeEmployee() method from LocationController class");
        }
        
        try {
            getLocationManager().removeEmployee(locationCd, employeeId);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in removeEmployee() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeEmployee() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all Employee objects from the Location object
     * @return Collection - a collection of the Employee objects
     */
    public Collection getEmployees(String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getEmployees() method from LocationController class");
        }
        
        try {
            return getLocationManager().getEmployees(locationCd);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in getEmployees() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmployees() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the PaymentType object to the Location object
     * @param locationCd a primary key of Location object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void addPaymentType(String locationCd, Integer paymentTypeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addPaymentType() method from LocationController class");
        }
        
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in addPaymentType() method from LocationController class");
        }
        
        try {
            getLocationManager().addPaymentType(locationCd, paymentTypeId);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in addPaymentType() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addPaymentType() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the PaymentType object to the Location object
     * @param locationCd a primary key of Location object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void removePaymentType(String locationCd, Integer paymentTypeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removePaymentType() method from LocationController class");
        }
        
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removePaymentType() method from LocationController class");
        }
        
        try {
            getLocationManager().removePaymentType(locationCd, paymentTypeId);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in removePaymentType() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePaymentType() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all PaymentType objects from the Location object
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypes(String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getPaymentTypes() method from LocationController class");
        }
        
        try {
            return getLocationManager().getPaymentTypes(locationCd);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in getPaymentTypes() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypes() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the BankAcc object to the Location object
     * @param locationCd a primary key of Location object
     * @param bankAccountCd a primary key of BankAcc object
     */
    public void addBankAcc(String locationCd, Integer bankAccountCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addBankAcc() method from LocationController class");
        }
        
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in addBankAcc() method from LocationController class");
        }
        
        try {
            getLocationManager().addBankAcc(locationCd, bankAccountCd);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in addBankAcc() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addBankAcc() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the BankAcc object to the Location object
     * @param locationCd a primary key of Location object
     * @param bankAccountCd a primary key of BankAcc object
     */
    public void removeBankAcc(String locationCd, Integer bankAccountCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeBankAcc() method from LocationController class");
        }
        
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in removeBankAcc() method from LocationController class");
        }
        
        try {
            getLocationManager().removeBankAcc(locationCd, bankAccountCd);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in removeBankAcc() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeBankAcc() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all BankAcc objects from the Location object
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccs(String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getBankAccs() method from LocationController class");
        }
        
        try {
            return getLocationManager().getBankAccs(locationCd);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in getBankAccs() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankAccs() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the DepTempl object to the Location object
     * @param locationCd a primary key of Location object
     * @param templId a primary key of DepTempl object
     */
    public void addDepTempl(String locationCd, Integer templId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addDepTempl() method from LocationController class");
        }
        
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in addDepTempl() method from LocationController class");
        }
        
        try {
            getLocationManager().addDepTempl(locationCd, templId);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in addDepTempl() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addDepTempl() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the DepTempl object to the Location object
     * @param locationCd a primary key of Location object
     * @param templId a primary key of DepTempl object
     */
    public void removeDepTempl(String locationCd, Integer templId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeDepTempl() method from LocationController class");
        }
        
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removeDepTempl() method from LocationController class");
        }
        
        try {
            getLocationManager().removeDepTempl(locationCd, templId);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all DepTempl objects from the Location object
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getDepTempls(String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in getDepTempls() method from LocationController class");
        }
        
        try {
            return getLocationManager().getDepTempls(locationCd);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred in getDepTempls() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTempls() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllLocations objects
     * @return java.util.Collection - a collection of the Location objects
     */
    public Collection getAllLocations()
        throws BusinessDelegateException {
        try {
            return getLocationManager().getAllLocations();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllLocations() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByCountryCd objects
     * @return java.util.Collection - a collection of the Location objects
     */
    public Collection getLocationByCountryCd(String countryCd)
        throws BusinessDelegateException {
        try {
            return getLocationManager().getLocationByCountryCd(countryCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocationByCountryCd() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllParentLocations objects
     * @return java.util.Collection - a collection of the Location objects
     */
    public Collection getAllParentLocations(String employeeId)
        throws BusinessDelegateException {
        try {
            return getLocationManager().getAllParentLocations(employeeId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllParentLocations() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPossibleParentLocationsByCountry objects
     * @return java.util.Collection - a collection of the Location objects
     */
    public Collection getAllPossibleParentLocationsByCountry(String locCd, String countryCd)
        throws BusinessDelegateException {
        try {
            return getLocationManager().getAllPossibleParentLocationsByCountry(locCd, countryCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPossibleParentLocationsByCountry() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Location object
     * @param locationCd - the Location bean primary key
     */
    public void removeLocation(String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from LocationController class");
        }
        
        try {
            getLocationManager().removeLocation(locationCd);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeLocation() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeLocation() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Location object
     * @param locationVO - the value object of the Location bean
     */
    public void updateLocation(LocationVO locationVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (locationVO == null) {
            throw new IllegalArgumentException("locationVO parameter was null in updateLocation() method from LocationController class");
        }
        
        try {
            getLocationManager().updateLocation(locationVO);
        }
        catch (LocationException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateLocation() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateLocation() method from LocationController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the LocationManager remote interface
     */
    public LocationManager getLocationManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            LocationManagerHome locationManagerHome = (LocationManagerHome)
            service.getEJBHome(ServiceConstants.LOCATIONMANAGER_JNDI, LocationManagerHome.class);
            return locationManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
