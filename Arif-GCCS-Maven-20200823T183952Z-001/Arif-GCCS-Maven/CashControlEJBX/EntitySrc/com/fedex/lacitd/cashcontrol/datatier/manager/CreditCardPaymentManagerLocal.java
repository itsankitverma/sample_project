/**
 * @(#)CreditCardPaymentManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface CreditCardPaymentManagerLocal extends EJBLocalObject {

    /**
     * This method create new CreditCardPayment object
     * @param creditCardPaymentVO a value object the CreditCardPayment bean
     */
    public void setCreditCardPayment(CreditCardPaymentVO creditCardPaymentVO)
        throws CreditCardPaymentException;

    /**
     * This method gets a CreditCardPayment object
     * @param creditCardPymtId - the CreditCardPayment bean primary key
     * @return creditCardPaymentVO - a value object of the CreditCardPayment bean
     */
    public CreditCardPaymentVO getCreditCardPayment(Integer creditCardPymtId)
        throws FinderException;

    /**
     * This method removes an existing CreditCardPayment object
     * @param creditCardPymtId - the CreditCardPayment bean primary key
     */
    public void removeCreditCardPayment(Integer creditCardPymtId)
        throws RemoveException;

    /**
     * This method updates an existing CreditCardPayment object
     * @param creditCardPaymentVO - the value object of the CreditCardPayment bean
     */
    public void updateCreditCardPayment(CreditCardPaymentVO creditCardPaymentVO)
        throws CreditCardPaymentException;

    /**
     * This method gets findAllCreditCardPayments objects
     * @return Collection - a collection of the CreditCardPayment objects
     */
    public Collection getAllCreditCardPayments();

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the CreditCardPayment objects
     */
    public Collection getCreditCardPaymentByEodId(Integer eodId);

}
