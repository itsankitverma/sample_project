/**
 * @(#)DepTemplController.java			Tue Aug 02 15:38:53 VET 2005
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

public class DepTemplController {

    /**
     * This method create new DepTempl object
     * @param depTemplVO a value object the DepTempl bean
     */
    public void setDepTempl(DepTemplVO depTemplVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depTemplVO == null) {
            throw new IllegalArgumentException("depTemplVO parameter was null in setDepTempl() method from DepTemplController class");
        }
        
        try {
            getDepTemplManager().setDepTempl(depTemplVO);
        }
        catch (DepTemplException ex) {
            String errorMsg = "Error occurred in setDepTempl() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setDepTempl() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a DepTempl object
     * @return depTemplVO - a value object of the DepTempl bean
     */
    public DepTemplVO getDepTempl(Integer templId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in getDepTempl() method from DepTemplController class");
        }
        
        try {
            return getDepTemplManager().getDepTempl(templId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getDepTempl() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTempl() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Location object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer templId, String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in addLocation() method from DepTemplController class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addLocation() method from DepTemplController class");
        }
        
        try {
            getDepTemplManager().addLocation(templId, locationCd);
        }
        catch (DepTemplException ex) {
            String errorMsg = "Error occurred in addLocation() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addLocation() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Location object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer templId, String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removeLocation() method from DepTemplController class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from DepTemplController class");
        }
        
        try {
            getDepTemplManager().removeLocation(templId, locationCd);
        }
        catch (DepTemplException ex) {
            String errorMsg = "Error occurred in removeLocation() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeLocation() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all Location objects from the DepTempl object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer templId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in getLocations() method from DepTemplController class");
        }
        
        try {
            return getDepTemplManager().getLocations(templId);
        }
        catch (DepTemplException ex) {
            String errorMsg = "Error occurred in getLocations() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocations() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the PaymentType object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void addPaymentType(Integer templId, Integer paymentTypeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in addPaymentType() method from DepTemplController class");
        }
        
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in addPaymentType() method from DepTemplController class");
        }
        
        try {
            getDepTemplManager().addPaymentType(templId, paymentTypeId);
        }
        catch (DepTemplException ex) {
            String errorMsg = "Error occurred in addPaymentType() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addPaymentType() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the PaymentType object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void removePaymentType(Integer templId, Integer paymentTypeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removePaymentType() method from DepTemplController class");
        }
        
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removePaymentType() method from DepTemplController class");
        }
        
        try {
            getDepTemplManager().removePaymentType(templId, paymentTypeId);
        }
        catch (DepTemplException ex) {
            String errorMsg = "Error occurred in removePaymentType() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePaymentType() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all PaymentType objects from the DepTempl object
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypes(Integer templId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in getPaymentTypes() method from DepTemplController class");
        }
        
        try {
            return getDepTemplManager().getPaymentTypes(templId);
        }
        catch (DepTemplException ex) {
            String errorMsg = "Error occurred in getPaymentTypes() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypes() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllDepTempls objects
     * @return java.util.Collection - a collection of the DepTempl objects
     */
    public Collection getAllDepTempls()
        throws BusinessDelegateException {
        try {
            return getDepTemplManager().getAllDepTempls();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllDepTempls() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllActiveDepTempls objects
     * @return java.util.Collection - a collection of the DepTempl objects
     */
    public Collection getAllActiveDepTempls()
        throws BusinessDelegateException {
        try {
            return getDepTemplManager().getAllActiveDepTempls();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllActiveDepTempls() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findDepTemplsbyCode objects
     * @return java.util.Collection - a collection of the DepTempl objects
     */
    public Collection getDepTemplDepTemplsbyCode(String templCd)
        throws BusinessDelegateException {
        try {
            return getDepTemplManager().getDepTemplDepTemplsbyCode(templCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTemplDepTemplsbyCode() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing DepTempl object
     * @param templId - the DepTempl bean primary key
     */
    public void removeDepTempl(Integer templId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removeDepTempl() method from DepTemplController class");
        }
        
        try {
            getDepTemplManager().removeDepTempl(templId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing DepTempl object
     * @param depTemplVO - the value object of the DepTempl bean
     */
    public void updateDepTempl(DepTemplVO depTemplVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depTemplVO == null) {
            throw new IllegalArgumentException("depTemplVO parameter was null in updateDepTempl() method from DepTemplController class");
        }
        
        try {
            getDepTemplManager().updateDepTempl(depTemplVO);
        }
        catch (DepTemplException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateDepTempl() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateDepTempl() method from DepTemplController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the DepTemplManager remote interface
     */
    public DepTemplManager getDepTemplManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            DepTemplManagerHome depTemplManagerHome = (DepTemplManagerHome)
            service.getEJBHome(ServiceConstants.DEPTEMPLMANAGER_JNDI, DepTemplManagerHome.class);
            return depTemplManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
