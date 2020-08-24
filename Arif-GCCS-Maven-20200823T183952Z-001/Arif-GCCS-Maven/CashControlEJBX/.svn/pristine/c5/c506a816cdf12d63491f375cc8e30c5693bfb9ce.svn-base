/**
 * @(#)BankAccManager.java			Tue Aug 02 15:38:51 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.manager;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public interface BankAccManager extends EJBObject {

    /**
     * This method create new BankAcc object
     * @param bankAccVO a value object the BankAcc bean
     */
    public void setBankAcc(BankAccVO bankAccVO)
        throws RemoteException, BankAccException;

    /**
     * This method gets a BankAcc object
     * @param bankAccountCd - the BankAcc bean primary key
     * @return bankAccVO - a value object of the BankAcc bean
     */
    public BankAccVO getBankAcc(Integer bankAccountCd)
        throws RemoteException, FinderException;

    /**
     * This method gets DepositSlip objects from the BankAcc object
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlips(Integer bankAccountCd)
        throws RemoteException, BankAccException;

    /**
     * This method adds the Location object to the BankAcc object
     * @param bankAccountCd a primary key of BankAcc object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer bankAccountCd, String locationCd)
        throws RemoteException, BankAccException;

    /**
     * This method removes the Location object to the BankAcc object
     * @param bankAccountCd a primary key of BankAcc object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer bankAccountCd, String locationCd)
        throws RemoteException, BankAccException;

    /**
     * This method gets Location objects from the BankAcc object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer bankAccountCd)
        throws RemoteException, BankAccException;

    /**
     * This method removes an existing BankAcc object
     * @param bankAccountCd - the BankAcc bean primary key
     */
    public void removeBankAcc(Integer bankAccountCd)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing BankAcc object
     * @param bankAccVO - the value object of the BankAcc bean
     */
    public void updateBankAcc(BankAccVO bankAccVO)
        throws RemoteException, BankAccException;

    /**
     * This method gets findAllBankAccs objects
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getAllBankAccs()
        throws RemoteException;

    /**
     * This method gets findByBankId objects
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccByBankId(Integer bankId)
        throws RemoteException;

}
