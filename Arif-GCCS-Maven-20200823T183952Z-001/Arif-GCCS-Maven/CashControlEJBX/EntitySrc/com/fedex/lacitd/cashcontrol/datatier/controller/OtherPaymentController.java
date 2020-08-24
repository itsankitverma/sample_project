/**
 * @(#)OtherPaymentController.java			Tue Aug 02 15:38:53 VET 2005
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

public class OtherPaymentController {

    /**
     * This method create new OtherPayment object
     * @param otherPaymentVO a value object the OtherPayment bean
     */
    public void setOtherPayment(OtherPaymentVO otherPaymentVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (otherPaymentVO == null) {
            throw new IllegalArgumentException("otherPaymentVO parameter was null in setOtherPayment() method from OtherPaymentController class");
        }
        
        try {
            getOtherPaymentManager().setOtherPayment(otherPaymentVO);
        }catch(Exception e){
        	e.printStackTrace();
        	throw new BusinessDelegateException("Testing hallo", e);
        }/*
        catch (OtherPaymentException ex) {
            String errorMsg = "Error occurred in setOtherPayment() method from OtherPaymentController class";
            ex.printStackTrace();
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setOtherPayment() method from OtherPaymentController class";
            ex.printStackTrace();
            throw new BusinessDelegateException(errorMsg, ex);
        }*/
    }

    /**
     * This method gets a OtherPayment object
     * @return otherPaymentVO - a value object of the OtherPayment bean
     */
    public OtherPaymentVO getOtherPayment(Integer otherPymtId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (otherPymtId == null) {
            throw new IllegalArgumentException("otherPymtId parameter was null in getOtherPayment() method from OtherPaymentController class");
        }
        
        try {
            return getOtherPaymentManager().getOtherPayment(otherPymtId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getOtherPayment() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOtherPayment() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllOtherPayments objects
     * @return java.util.Collection - a collection of the OtherPayment objects
     */
    public Collection getAllOtherPayments()
        throws BusinessDelegateException {
        try {
            return getOtherPaymentManager().getAllOtherPayments();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllOtherPayments() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findOpenByLocation objects
     * @return java.util.Collection - a collection of the OtherPayment objects
     */
    public Collection getOtherPaymentOpenByLocation(String locationCd)
        throws BusinessDelegateException {
        try {
            return getOtherPaymentManager().getOtherPaymentOpenByLocation(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOtherPaymentOpenByLocation() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return java.util.Collection - a collection of the OtherPayment objects
     */
    public Collection getOtherPaymentByEodId(Integer eodId)
        throws BusinessDelegateException {
        try {
            return getOtherPaymentManager().getOtherPaymentByEodId(eodId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOtherPaymentByEodId() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing OtherPayment object
     * @param otherPymtId - the OtherPayment bean primary key
     */
    public void removeOtherPayment(Integer otherPymtId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (otherPymtId == null) {
            throw new IllegalArgumentException("otherPymtId parameter was null in removeOtherPayment() method from OtherPaymentController class");
        }
        
        try {
            getOtherPaymentManager().removeOtherPayment(otherPymtId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeOtherPayment() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeOtherPayment() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing OtherPayment object
     * @param otherPaymentVO - the value object of the OtherPayment bean
     */
    public void updateOtherPayment(OtherPaymentVO otherPaymentVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (otherPaymentVO == null) {
            throw new IllegalArgumentException("otherPaymentVO parameter was null in updateOtherPayment() method from OtherPaymentController class");
        }
        
        try {
            getOtherPaymentManager().updateOtherPayment(otherPaymentVO);
        }
        catch (OtherPaymentException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateOtherPayment() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateOtherPayment() method from OtherPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the OtherPaymentManager remote interface
     */
    public OtherPaymentManager getOtherPaymentManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            OtherPaymentManagerHome otherPaymentManagerHome = (OtherPaymentManagerHome)
            service.getEJBHome(ServiceConstants.OTHERPAYMENTMANAGER_JNDI, OtherPaymentManagerHome.class);
            return otherPaymentManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getOtherPaymentManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getOtherPaymentManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOtherPaymentManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
