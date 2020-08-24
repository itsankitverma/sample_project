/**
 * @(#)PoaPaymentController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PoaPaymentController {

    /**
     * This method create new PoaPayment object
     * @param poaPaymentVO a value object the PoaPayment bean
     */
    public void setPoaPayment(PoaPaymentVO poaPaymentVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaPaymentVO == null) {
            throw new IllegalArgumentException("poaPaymentVO parameter was null in setPoaPayment() method from PoaPaymentController class");
        }
        
        try {
            getPoaPaymentManager().setPoaPayment(poaPaymentVO);
        }
        catch (PoaPaymentException ex) {
            String errorMsg = "Error occurred in setPoaPayment() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPoaPayment() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PoaPayment object
     * @return poaPaymentVO - a value object of the PoaPayment bean
     */
    public PoaPaymentVO getPoaPayment(Integer poaPaymentsId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (poaPaymentsId == null) {
            throw new IllegalArgumentException("poaPaymentsId parameter was null in getPoaPayment() method from PoaPaymentController class");
        }
        
        try {
            return getPoaPaymentManager().getPoaPayment(poaPaymentsId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPoaPayment() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaPayment() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPoaPayments objects
     * @return java.util.Collection - a collection of the PoaPayment objects
     */
    public Collection getAllPoaPayments()
        throws BusinessDelegateException {
        try {
            return getPoaPaymentManager().getAllPoaPayments();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPoaPayments() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return java.util.Collection - a collection of the PoaPayment objects
     */
    public Collection getPoaPaymentByEodId(Integer eodId)
        throws BusinessDelegateException {
        try {
            return getPoaPaymentManager().getPoaPaymentByEodId(eodId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaPaymentByEodId() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PoaPayment object
     * @param poaPaymentsId - the PoaPayment bean primary key
     */
    public void removePoaPayment(Integer poaPaymentsId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaPaymentsId == null) {
            throw new IllegalArgumentException("poaPaymentsId parameter was null in removePoaPayment() method from PoaPaymentController class");
        }
        
        try {
            getPoaPaymentManager().removePoaPayment(poaPaymentsId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePoaPayment() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePoaPayment() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PoaPayment object
     * @param poaPaymentVO - the value object of the PoaPayment bean
     */
    public void updatePoaPayment(PoaPaymentVO poaPaymentVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaPaymentVO == null) {
            throw new IllegalArgumentException("poaPaymentVO parameter was null in updatePoaPayment() method from PoaPaymentController class");
        }
        
        try {
            getPoaPaymentManager().updatePoaPayment(poaPaymentVO);
        }
        catch (PoaPaymentException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePoaPayment() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePoaPayment() method from PoaPaymentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PoaPaymentManager remote interface
     */
    public PoaPaymentManager getPoaPaymentManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PoaPaymentManagerHome poaPaymentManagerHome = (PoaPaymentManagerHome)
            service.getEJBHome(ServiceConstants.POAPAYMENTMANAGER_JNDI, PoaPaymentManagerHome.class);
            return poaPaymentManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPoaPaymentManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPoaPaymentManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaPaymentManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
