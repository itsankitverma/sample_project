/**
 * @(#)OtherPaymentManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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

public interface OtherPaymentManagerLocal extends EJBLocalObject {

    /**
     * This method create new OtherPayment object
     * @param otherPaymentVO a value object the OtherPayment bean
     */
    public void setOtherPayment(OtherPaymentVO otherPaymentVO)
        throws OtherPaymentException;

    /**
     * This method gets a OtherPayment object
     * @param otherPymtId - the OtherPayment bean primary key
     * @return otherPaymentVO - a value object of the OtherPayment bean
     */
    public OtherPaymentVO getOtherPayment(Integer otherPymtId)
        throws FinderException;

    /**
     * This method removes an existing OtherPayment object
     * @param otherPymtId - the OtherPayment bean primary key
     */
    public void removeOtherPayment(Integer otherPymtId)
        throws RemoveException;

    /**
     * This method updates an existing OtherPayment object
     * @param otherPaymentVO - the value object of the OtherPayment bean
     */
    public void updateOtherPayment(OtherPaymentVO otherPaymentVO)
        throws OtherPaymentException;

    /**
     * This method gets findAllOtherPayments objects
     * @return Collection - a collection of the OtherPayment objects
     */
    public Collection getAllOtherPayments();

    /**
     * This method gets findOpenByLocation objects
     * @return Collection - a collection of the OtherPayment objects
     */
    public Collection getOtherPaymentOpenByLocation(String locationCd);

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the OtherPayment objects
     */
    public Collection getOtherPaymentByEodId(Integer eodId);

}
