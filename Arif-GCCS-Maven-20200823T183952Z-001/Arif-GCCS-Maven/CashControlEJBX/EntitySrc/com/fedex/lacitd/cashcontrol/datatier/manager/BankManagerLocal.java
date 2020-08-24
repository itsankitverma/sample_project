/**
 * @(#)BankManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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

public interface BankManagerLocal extends EJBLocalObject {

    /**
     * This method create new Bank object
     * @param bankVO a value object the Bank bean
     */
    public void setBank(BankVO bankVO)
        throws BankException;

    /**
     * This method gets a Bank object
     * @param bankId - the Bank bean primary key
     * @return bankVO - a value object of the Bank bean
     */
    public BankVO getBank(Integer bankId)
        throws FinderException;

    /**
     * This method gets BankAcc objects from the Bank object
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccs(Integer bankId)
        throws BankException;

    /**
     * This method removes an existing Bank object
     * @param bankId - the Bank bean primary key
     */
    public void removeBank(Integer bankId)
        throws RemoveException;

    /**
     * This method updates an existing Bank object
     * @param bankVO - the value object of the Bank bean
     */
    public void updateBank(BankVO bankVO)
        throws BankException;

    /**
     * This method gets findAllBanks objects
     * @return Collection - a collection of the Bank objects
     */
    public Collection getAllBanks();

    /**
     * This method gets findByCountryCd objects
     * @return Collection - a collection of the Bank objects
     */
    public Collection getBankByCountryCd(String countryCd);

}
