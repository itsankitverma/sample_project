/**
 * @(#)PaymentCtgController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PaymentCtgController {

    /**
     * This method create new PaymentCtg object
     * @param paymentCtgVO a value object the PaymentCtg bean
     */
    public void setPaymentCtg(PaymentCtgVO paymentCtgVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (paymentCtgVO == null) {
            throw new IllegalArgumentException("paymentCtgVO parameter was null in setPaymentCtg() method from PaymentCtgController class");
        }
        
        try {
            getPaymentCtgManager().setPaymentCtg(paymentCtgVO);
        }
        catch (PaymentCtgException ex) {
            String errorMsg = "Error occurred in setPaymentCtg() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPaymentCtg() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PaymentCtg object
     * @return paymentCtgVO - a value object of the PaymentCtg bean
     */
    public PaymentCtgVO getPaymentCtg(Integer paymentCtgId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (paymentCtgId == null) {
            throw new IllegalArgumentException("paymentCtgId parameter was null in getPaymentCtg() method from PaymentCtgController class");
        }
        
        try {
            return getPaymentCtgManager().getPaymentCtg(paymentCtgId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPaymentCtg() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentCtg() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPaymentCtgs objects
     * @return java.util.Collection - a collection of the PaymentCtg objects
     */
    public Collection getAllPaymentCtgs()
        throws BusinessDelegateException {
        try {
            return getPaymentCtgManager().getAllPaymentCtgs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPaymentCtgs() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findExtPaymentCtgs objects
     * @return java.util.Collection - a collection of the PaymentCtg objects
     */
    public Collection getPaymentCtgExtPaymentCtgs()
        throws BusinessDelegateException {
        try {
            return getPaymentCtgManager().getPaymentCtgExtPaymentCtgs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentCtgExtPaymentCtgs() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PaymentCtg object
     * @param paymentCtgId - the PaymentCtg bean primary key
     */
    public void removePaymentCtg(Integer paymentCtgId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (paymentCtgId == null) {
            throw new IllegalArgumentException("paymentCtgId parameter was null in removePaymentCtg() method from PaymentCtgController class");
        }
        
        try {
            getPaymentCtgManager().removePaymentCtg(paymentCtgId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePaymentCtg() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePaymentCtg() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PaymentCtg object
     * @param paymentCtgVO - the value object of the PaymentCtg bean
     */
    public void updatePaymentCtg(PaymentCtgVO paymentCtgVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (paymentCtgVO == null) {
            throw new IllegalArgumentException("paymentCtgVO parameter was null in updatePaymentCtg() method from PaymentCtgController class");
        }
        
        try {
            getPaymentCtgManager().updatePaymentCtg(paymentCtgVO);
        }
        catch (PaymentCtgException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePaymentCtg() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePaymentCtg() method from PaymentCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PaymentCtgManager remote interface
     */
    public PaymentCtgManager getPaymentCtgManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PaymentCtgManagerHome paymentCtgManagerHome = (PaymentCtgManagerHome)
            service.getEJBHome(ServiceConstants.PAYMENTCTGMANAGER_JNDI, PaymentCtgManagerHome.class);
            return paymentCtgManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPaymentCtgManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPaymentCtgManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentCtgManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
