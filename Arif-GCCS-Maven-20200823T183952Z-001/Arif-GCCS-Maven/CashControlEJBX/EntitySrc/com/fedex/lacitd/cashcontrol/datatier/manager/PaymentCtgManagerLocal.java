/**
 * @(#)PaymentCtgManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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

public interface PaymentCtgManagerLocal extends EJBLocalObject {

    /**
     * This method create new PaymentCtg object
     * @param paymentCtgVO a value object the PaymentCtg bean
     */
    public void setPaymentCtg(PaymentCtgVO paymentCtgVO)
        throws PaymentCtgException;

    /**
     * This method gets a PaymentCtg object
     * @param paymentCtgId - the PaymentCtg bean primary key
     * @return paymentCtgVO - a value object of the PaymentCtg bean
     */
    public PaymentCtgVO getPaymentCtg(Integer paymentCtgId)
        throws FinderException;

    /**
     * This method removes an existing PaymentCtg object
     * @param paymentCtgId - the PaymentCtg bean primary key
     */
    public void removePaymentCtg(Integer paymentCtgId)
        throws RemoveException;

    /**
     * This method updates an existing PaymentCtg object
     * @param paymentCtgVO - the value object of the PaymentCtg bean
     */
    public void updatePaymentCtg(PaymentCtgVO paymentCtgVO)
        throws PaymentCtgException;

    /**
     * This method gets findAllPaymentCtgs objects
     * @return Collection - a collection of the PaymentCtg objects
     */
    public Collection getAllPaymentCtgs();

    /**
     * This method gets findExtPaymentCtgs objects
     * @return Collection - a collection of the PaymentCtg objects
     */
    public Collection getPaymentCtgExtPaymentCtgs();

}
