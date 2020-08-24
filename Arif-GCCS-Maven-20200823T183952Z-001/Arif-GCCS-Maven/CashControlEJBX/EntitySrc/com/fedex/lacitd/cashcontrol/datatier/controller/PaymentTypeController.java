/**
 * @(#)PaymentTypeController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PaymentTypeController {

    /**
     * This method create new PaymentType object
     * @param paymentTypeVO a value object the PaymentType bean
     */
    public void setPaymentType(PaymentTypeVO paymentTypeVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (paymentTypeVO == null) {
            throw new IllegalArgumentException("paymentTypeVO parameter was null in setPaymentType() method from PaymentTypeController class");
        }
        
        try {
            getPaymentTypeManager().setPaymentType(paymentTypeVO);
        }
        catch (PaymentTypeException ex) {
            String errorMsg = "Error occurred in setPaymentType() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPaymentType() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PaymentType object
     * @return paymentTypeVO - a value object of the PaymentType bean
     */
    public PaymentTypeVO getPaymentType(Integer paymentTypeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in getPaymentType() method from PaymentTypeController class");
        }
        
        try {
            return getPaymentTypeManager().getPaymentType(paymentTypeId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPaymentType() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentType() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Location object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer paymentTypeId, String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in addLocation() method from PaymentTypeController class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addLocation() method from PaymentTypeController class");
        }
        
        try {
            getPaymentTypeManager().addLocation(paymentTypeId, locationCd);
        }
        catch (PaymentTypeException ex) {
            String errorMsg = "Error occurred in addLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Location object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer paymentTypeId, String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removeLocation() method from PaymentTypeController class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from PaymentTypeController class");
        }
        
        try {
            getPaymentTypeManager().removeLocation(paymentTypeId, locationCd);
        }
        catch (PaymentTypeException ex) {
            String errorMsg = "Error occurred in removeLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all Location objects from the PaymentType object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer paymentTypeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in getLocations() method from PaymentTypeController class");
        }
        
        try {
            return getPaymentTypeManager().getLocations(paymentTypeId);
        }
        catch (PaymentTypeException ex) {
            String errorMsg = "Error occurred in getLocations() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocations() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the DepTempl object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param templId a primary key of DepTempl object
     */
    public void addDepTempl(Integer paymentTypeId, Integer templId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in addDepTempl() method from PaymentTypeController class");
        }
        
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in addDepTempl() method from PaymentTypeController class");
        }
        
        try {
            getPaymentTypeManager().addDepTempl(paymentTypeId, templId);
        }
        catch (PaymentTypeException ex) {
            String errorMsg = "Error occurred in addDepTempl() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addDepTempl() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the DepTempl object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param templId a primary key of DepTempl object
     */
    public void removeDepTempl(Integer paymentTypeId, Integer templId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removeDepTempl() method from PaymentTypeController class");
        }
        
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removeDepTempl() method from PaymentTypeController class");
        }
        
        try {
            getPaymentTypeManager().removeDepTempl(paymentTypeId, templId);
        }
        catch (PaymentTypeException ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all DepTempl objects from the PaymentType object
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getDepTempls(Integer paymentTypeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in getDepTempls() method from PaymentTypeController class");
        }
        
        try {
            return getPaymentTypeManager().getDepTempls(paymentTypeId);
        }
        catch (PaymentTypeException ex) {
            String errorMsg = "Error occurred in getDepTempls() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTempls() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPaymentTypes objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getAllPaymentTypes()
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getAllPaymentTypes();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPaymentTypes() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllActivePaymentTypes objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getAllActivePaymentTypes()
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getAllActivePaymentTypes();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllActivePaymentTypes() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByRodLocation objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByRodLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByRodLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByRodLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByCodLocation objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByCodLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByCodLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByCodLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }
    
    /**
     * This method gets findByFtcLocation objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByFtcLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByFtcLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByFtcLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }
    
    
    /**
     * This method gets findByPrpLocation objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByPrpLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByPrpLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByPrpLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPoaLocation objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByPoaLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByPoaLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByPoaLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByOtherLocation objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByOtherLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByOtherLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByOtherLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocation objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByCode objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByCode(String paymentCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByCode(paymentCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByCode() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByGndLocation objects
     * @return java.util.Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByGndLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getPaymentTypeManager().getPaymentTypeByGndLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeByGndLocation() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PaymentType object
     * @param paymentTypeId - the PaymentType bean primary key
     */
    public void removePaymentType(Integer paymentTypeId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removePaymentType() method from PaymentTypeController class");
        }
        
        try {
            getPaymentTypeManager().removePaymentType(paymentTypeId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePaymentType() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePaymentType() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PaymentType object
     * @param paymentTypeVO - the value object of the PaymentType bean
     */
    public void updatePaymentType(PaymentTypeVO paymentTypeVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (paymentTypeVO == null) {
            throw new IllegalArgumentException("paymentTypeVO parameter was null in updatePaymentType() method from PaymentTypeController class");
        }
        
        try {
            getPaymentTypeManager().updatePaymentType(paymentTypeVO);
        }
        catch (PaymentTypeException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePaymentType() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePaymentType() method from PaymentTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PaymentTypeManager remote interface
     */
    public PaymentTypeManager getPaymentTypeManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PaymentTypeManagerHome paymentTypeManagerHome = (PaymentTypeManagerHome)
            service.getEJBHome(ServiceConstants.PAYMENTTYPEMANAGER_JNDI, PaymentTypeManagerHome.class);
            return paymentTypeManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
