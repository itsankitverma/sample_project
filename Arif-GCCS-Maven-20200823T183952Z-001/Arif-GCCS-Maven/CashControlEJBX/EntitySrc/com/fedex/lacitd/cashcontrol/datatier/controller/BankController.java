/**
 * @(#)BankController.java			Tue Aug 02 15:38:53 VET 2005
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

public class BankController {

    /**
     * This method create new Bank object
     * @param bankVO a value object the Bank bean
     */
    public void setBank(BankVO bankVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (bankVO == null) {
            throw new IllegalArgumentException("bankVO parameter was null in setBank() method from BankController class");
        }
        
        try {
            getBankManager().setBank(bankVO);
        }
        catch (BankException ex) {
            String errorMsg = "Error occurred in setBank() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setBank() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Bank object
     * @return bankVO - a value object of the Bank bean
     */
    public BankVO getBank(Integer bankId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (bankId == null) {
            throw new IllegalArgumentException("bankId parameter was null in getBank() method from BankController class");
        }
        
        try {
            return getBankManager().getBank(bankId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getBank() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBank() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all BankAcc objects from the Bank object
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccs(Integer bankId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (bankId == null) {
            throw new IllegalArgumentException("bankId parameter was null in getBankAccs() method from BankController class");
        }
        
        try {
            return getBankManager().getBankAccs(bankId);
        }
        catch (BankException ex) {
            String errorMsg = "Error occurred in getBankAccs() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankAccs() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllBanks objects
     * @return java.util.Collection - a collection of the Bank objects
     */
    public Collection getAllBanks()
        throws BusinessDelegateException {
        try {
            return getBankManager().getAllBanks();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllBanks() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByCountryCd objects
     * @return java.util.Collection - a collection of the Bank objects
     */
    public Collection getBankByCountryCd(String countryCd)
        throws BusinessDelegateException {
        try {
            return getBankManager().getBankByCountryCd(countryCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankByCountryCd() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Bank object
     * @param bankId - the Bank bean primary key
     */
    public void removeBank(Integer bankId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (bankId == null) {
            throw new IllegalArgumentException("bankId parameter was null in removeBank() method from BankController class");
        }
        
        try {
            getBankManager().removeBank(bankId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeBank() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeBank() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Bank object
     * @param bankVO - the value object of the Bank bean
     */
    public void updateBank(BankVO bankVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (bankVO == null) {
            throw new IllegalArgumentException("bankVO parameter was null in updateBank() method from BankController class");
        }
        
        try {
            getBankManager().updateBank(bankVO);
        }
        catch (BankException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateBank() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateBank() method from BankController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the BankManager remote interface
     */
    public BankManager getBankManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            BankManagerHome bankManagerHome = (BankManagerHome)
            service.getEJBHome(ServiceConstants.BANKMANAGER_JNDI, BankManagerHome.class);
            return bankManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getBankManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
