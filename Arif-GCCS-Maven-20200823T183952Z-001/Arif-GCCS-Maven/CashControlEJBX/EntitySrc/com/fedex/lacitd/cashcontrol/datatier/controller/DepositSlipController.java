/**
 * @(#)DepositSlipController.java			Tue Aug 02 15:38:53 VET 2005
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

public class DepositSlipController {

    /**
     * This method create new DepositSlip object
     * @param depositSlipVO a value object the DepositSlip bean
     */
    public void setDepositSlip(DepositSlipVO depositSlipVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depositSlipVO == null) {
            throw new IllegalArgumentException("depositSlipVO parameter was null in setDepositSlip() method from DepositSlipController class");
        }
        
        try {
            getDepositSlipManager().setDepositSlip(depositSlipVO);
        }
        catch (DepositSlipException ex) {
            String errorMsg = "Error occurred in setDepositSlip() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setDepositSlip() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a DepositSlip object
     * @return depositSlipVO - a value object of the DepositSlip bean
     */
    public DepositSlipVO getDepositSlip(Integer depositSlipCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (depositSlipCd == null) {
            throw new IllegalArgumentException("depositSlipCd parameter was null in getDepositSlip() method from DepositSlipController class");
        }
        
        try {
            return getDepositSlipManager().getDepositSlip(depositSlipCd);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getDepositSlip() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlip() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllDepositSlips objects
     * @return java.util.Collection - a collection of the DepositSlip objects
     */
    public Collection getAllDepositSlips()
        throws BusinessDelegateException {
        try {
            return getDepositSlipManager().getAllDepositSlips();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllDepositSlips() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByBankAccountCd objects
     * @return java.util.Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByBankAccountCd(Integer bankAccountCd)
        throws BusinessDelegateException {
        try {
            return getDepositSlipManager().getDepositSlipByBankAccountCd(bankAccountCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlipByBankAccountCd() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEmployeeId objects
     * @return java.util.Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByEmployeeId(String employeeId)
        throws BusinessDelegateException {
        try {
            return getDepositSlipManager().getDepositSlipByEmployeeId(employeeId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlipByEmployeeId() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return java.util.Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByEodId(Integer eodId)
        throws BusinessDelegateException {
        try {
            return getDepositSlipManager().getDepositSlipByEodId(eodId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlipByEodId() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing DepositSlip object
     * @param depositSlipCd - the DepositSlip bean primary key
     */
    public void removeDepositSlip(Integer depositSlipCd)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depositSlipCd == null) {
            throw new IllegalArgumentException("depositSlipCd parameter was null in removeDepositSlip() method from DepositSlipController class");
        }
        
        try {
            getDepositSlipManager().removeDepositSlip(depositSlipCd);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeDepositSlip() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeDepositSlip() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing DepositSlip object
     * @param depositSlipVO - the value object of the DepositSlip bean
     */
    public void updateDepositSlip(DepositSlipVO depositSlipVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depositSlipVO == null) {
            throw new IllegalArgumentException("depositSlipVO parameter was null in updateDepositSlip() method from DepositSlipController class");
        }
        
        try {
            getDepositSlipManager().updateDepositSlip(depositSlipVO);
        }
        catch (DepositSlipException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateDepositSlip() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateDepositSlip() method from DepositSlipController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the DepositSlipManager remote interface
     */
    public DepositSlipManager getDepositSlipManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            DepositSlipManagerHome depositSlipManagerHome = (DepositSlipManagerHome)
            service.getEJBHome(ServiceConstants.DEPOSITSLIPMANAGER_JNDI, DepositSlipManagerHome.class);
            return depositSlipManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
