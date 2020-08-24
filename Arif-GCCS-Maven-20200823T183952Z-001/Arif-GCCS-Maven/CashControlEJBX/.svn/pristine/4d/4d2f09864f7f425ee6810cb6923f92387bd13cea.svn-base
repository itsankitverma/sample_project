/**
 * @(#)DepositSlipManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface DepositSlipManager extends EJBObject {

    /**
     * This method create new DepositSlip object
     * @param depositSlipVO a value object the DepositSlip bean
     */
    public void setDepositSlip(DepositSlipVO depositSlipVO)
        throws RemoteException, DepositSlipException;

    /**
     * This method gets a DepositSlip object
     * @param depositSlipCd - the DepositSlip bean primary key
     * @return depositSlipVO - a value object of the DepositSlip bean
     */
    public DepositSlipVO getDepositSlip(Integer depositSlipCd)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing DepositSlip object
     * @param depositSlipCd - the DepositSlip bean primary key
     */
    public void removeDepositSlip(Integer depositSlipCd)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing DepositSlip object
     * @param depositSlipVO - the value object of the DepositSlip bean
     */
    public void updateDepositSlip(DepositSlipVO depositSlipVO)
        throws RemoteException, DepositSlipException;

    /**
     * This method gets findAllDepositSlips objects
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getAllDepositSlips()
        throws RemoteException;

    /**
     * This method gets findByBankAccountCd objects
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByBankAccountCd(Integer bankAccountCd)
        throws RemoteException;

    /**
     * This method gets findByEmployeeId objects
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByEmployeeId(String employeeId)
        throws RemoteException;

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByEodId(Integer eodId)
        throws RemoteException;

}
