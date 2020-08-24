/**
 * @(#)PoaPaymentManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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

public interface PoaPaymentManagerLocal extends EJBLocalObject {

    /**
     * This method create new PoaPayment object
     * @param poaPaymentVO a value object the PoaPayment bean
     */
    public void setPoaPayment(PoaPaymentVO poaPaymentVO)
        throws PoaPaymentException;

    /**
     * This method gets a PoaPayment object
     * @param poaPaymentsId - the PoaPayment bean primary key
     * @return poaPaymentVO - a value object of the PoaPayment bean
     */
    public PoaPaymentVO getPoaPayment(Integer poaPaymentsId)
        throws FinderException;

    /**
     * This method removes an existing PoaPayment object
     * @param poaPaymentsId - the PoaPayment bean primary key
     */
    public void removePoaPayment(Integer poaPaymentsId)
        throws RemoveException;

    /**
     * This method updates an existing PoaPayment object
     * @param poaPaymentVO - the value object of the PoaPayment bean
     */
    public void updatePoaPayment(PoaPaymentVO poaPaymentVO)
        throws PoaPaymentException;

    /**
     * This method gets findAllPoaPayments objects
     * @return Collection - a collection of the PoaPayment objects
     */
    public Collection getAllPoaPayments();

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the PoaPayment objects
     */
    public Collection getPoaPaymentByEodId(Integer eodId);

}
