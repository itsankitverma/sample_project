/**
 * @(#)CreditCardPaymentController.java			Tue Aug 02 15:38:53 VET 2005
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

public class CreditCardPaymentController {

    /**
     * This method create new CreditCardPayment object
     * @param creditCardPaymentVO a value object the CreditCardPayment bean
     */
    public void setCreditCardPayment(CreditCardPaymentVO creditCardPaymentVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (creditCardPaymentVO == null) {
            throw new IllegalArgumentException("creditCardPaymentVO parameter was null in setCreditCardPayment() method from CreditCardPaymentController class");
        }
        
        try {
            getCreditCardPaymentManager().setCreditCardPayment(creditCardPaymentVO);
        }
        catch (CreditCardPaymentException ex) {
            String errorMsg = "Error occurred in setCreditCardPayment() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setCreditCardPayment() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a CreditCardPayment object
     * @return creditCardPaymentVO - a value object of the CreditCardPayment bean
     */
    public CreditCardPaymentVO getCreditCardPayment(Integer creditCardPymtId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (creditCardPymtId == null) {
            throw new IllegalArgumentException("creditCardPymtId parameter was null in getCreditCardPayment() method from CreditCardPaymentController class");
        }
        
        try {
            return getCreditCardPaymentManager().getCreditCardPayment(creditCardPymtId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getCreditCardPayment() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCreditCardPayment() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCreditCardPayments objects
     * @return java.util.Collection - a collection of the CreditCardPayment objects
     */
    public Collection getAllCreditCardPayments()
        throws BusinessDelegateException {
        try {
            return getCreditCardPaymentManager().getAllCreditCardPayments();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllCreditCardPayments() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return java.util.Collection - a collection of the CreditCardPayment objects
     */
    public Collection getCreditCardPaymentByEodId(Integer eodId)
        throws BusinessDelegateException {
        try {
            return getCreditCardPaymentManager().getCreditCardPaymentByEodId(eodId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCreditCardPaymentByEodId() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing CreditCardPayment object
     * @param creditCardPymtId - the CreditCardPayment bean primary key
     */
    public void removeCreditCardPayment(Integer creditCardPymtId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (creditCardPymtId == null) {
            throw new IllegalArgumentException("creditCardPymtId parameter was null in removeCreditCardPayment() method from CreditCardPaymentController class");
        }
        
        try {
            getCreditCardPaymentManager().removeCreditCardPayment(creditCardPymtId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeCreditCardPayment() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeCreditCardPayment() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing CreditCardPayment object
     * @param creditCardPaymentVO - the value object of the CreditCardPayment bean
     */
    public void updateCreditCardPayment(CreditCardPaymentVO creditCardPaymentVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (creditCardPaymentVO == null) {
            throw new IllegalArgumentException("creditCardPaymentVO parameter was null in updateCreditCardPayment() method from CreditCardPaymentController class");
        }
        
        try {
            getCreditCardPaymentManager().updateCreditCardPayment(creditCardPaymentVO);
        }
        catch (CreditCardPaymentException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateCreditCardPayment() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateCreditCardPayment() method from CreditCardPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the CreditCardPaymentManager remote interface
     */
    public CreditCardPaymentManager getCreditCardPaymentManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            CreditCardPaymentManagerHome creditCardPaymentManagerHome = (CreditCardPaymentManagerHome)
            service.getEJBHome(ServiceConstants.CREDITCARDPAYMENTMANAGER_JNDI, CreditCardPaymentManagerHome.class);
            return creditCardPaymentManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCreditCardPaymentManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getCreditCardPaymentManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCreditCardPaymentManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
