/**
 * @(#)BankAccController.java			Tue Aug 02 15:38:53 VET 2005
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
import java.util.logging.Logger;

import javax.ejb.*;

public class BankAccController {
	
    /**
     * This method create new BankAcc object
     * @param bankAccVO a value object the BankAcc bean
     */
    public void setBankAcc(BankAccVO bankAccVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (bankAccVO == null) {
            throw new IllegalArgumentException("bankAccVO parameter was null in setBankAcc() method from BankAccController class");
        }
        
        try {
            getBankAccManager().setBankAcc(bankAccVO);
        }
        catch (BankAccException ex) {
            String errorMsg = "Error occurred in setBankAcc() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setBankAcc() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a BankAcc object
     * @return bankAccVO - a value object of the BankAcc bean
     */
    public BankAccVO getBankAcc(Integer bankAccountCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in getBankAcc() method from BankAccController class");
        }
        
        try {
            return getBankAccManager().getBankAcc(bankAccountCd);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getBankAcc() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankAcc() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all DepositSlip objects from the BankAcc object
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlips(Integer bankAccountCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in getDepositSlips() method from BankAccController class");
        }
        
        try {
            return getBankAccManager().getDepositSlips(bankAccountCd);
        }
        catch (BankAccException ex) {
            String errorMsg = "Error occurred in getDepositSlips() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlips() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Location object to the BankAcc object
     * @param bankAccountCd a primary key of BankAcc object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer bankAccountCd, String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in addLocation() method from BankAccController class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addLocation() method from BankAccController class");
        }
        
        try {
            getBankAccManager().addLocation(bankAccountCd, locationCd);
        }
        catch (BankAccException ex) {
            String errorMsg = "Error occurred in addLocation() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addLocation() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Location object to the BankAcc object
     * @param bankAccountCd a primary key of BankAcc object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer bankAccountCd, String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in removeLocation() method from BankAccController class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from BankAccController class");
        }
        
        try {
            getBankAccManager().removeLocation(bankAccountCd, locationCd);
        }
        catch (BankAccException ex) {
            String errorMsg = "Error occurred in removeLocation() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeLocation() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all Location objects from the BankAcc object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer bankAccountCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in getLocations() method from BankAccController class");
        }
        
        try {
            return getBankAccManager().getLocations(bankAccountCd);
        }
        catch (BankAccException ex) {
            String errorMsg = "Error occurred in getLocations() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocations() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllBankAccs objects
     * @return java.util.Collection - a collection of the BankAcc objects
     */
    public Collection getAllBankAccs()
        throws BusinessDelegateException {
        try {
            return getBankAccManager().getAllBankAccs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllBankAccs() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByBankId objects
     * @return java.util.Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccByBankId(Integer bankId)
        throws BusinessDelegateException {
        try {
            return getBankAccManager().getBankAccByBankId(bankId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankAccByBankId() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing BankAcc object
     * @param bankAccountCd - the BankAcc bean primary key
     */
    public void removeBankAcc(Integer bankAccountCd)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in removeBankAcc() method from BankAccController class");
        }
        
        try {
            getBankAccManager().removeBankAcc(bankAccountCd);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeBankAcc() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeBankAcc() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing BankAcc object
     * @param bankAccVO - the value object of the BankAcc bean
     */
    public void updateBankAcc(BankAccVO bankAccVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (bankAccVO == null) {
            throw new IllegalArgumentException("bankAccVO parameter was null in updateBankAcc() method from BankAccController class");
        }
        
        try {
            getBankAccManager().updateBankAcc(bankAccVO);
        }
        catch (BankAccException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateBankAcc() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateBankAcc() method from BankAccController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the BankAccManager remote interface
     */
    public BankAccManager getBankAccManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            BankAccManagerHome bankAccManagerHome = (BankAccManagerHome)
            service.getEJBHome(ServiceConstants.BANKACCMANAGER_JNDI, BankAccManagerHome.class);
            return bankAccManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
