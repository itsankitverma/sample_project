/**
 * @(#)PaymentTypeManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface PaymentTypeManagerLocal extends EJBLocalObject {

    /**
     * This method create new PaymentType object
     * @param paymentTypeVO a value object the PaymentType bean
     */
    public void setPaymentType(PaymentTypeVO paymentTypeVO)
        throws PaymentTypeException;

    /**
     * This method gets a PaymentType object
     * @param paymentTypeId - the PaymentType bean primary key
     * @return paymentTypeVO - a value object of the PaymentType bean
     */
    public PaymentTypeVO getPaymentType(Integer paymentTypeId)
        throws FinderException;

    /**
     * This method adds the Location object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer paymentTypeId, String locationCd)
        throws PaymentTypeException;

    /**
     * This method removes the Location object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer paymentTypeId, String locationCd)
        throws PaymentTypeException;

    /**
     * This method gets Location objects from the PaymentType object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer paymentTypeId)
        throws PaymentTypeException;

    /**
     * This method adds the DepTempl object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param templId a primary key of DepTempl object
     */
    public void addDepTempl(Integer paymentTypeId, Integer templId)
        throws PaymentTypeException;

    /**
     * This method removes the DepTempl object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param templId a primary key of DepTempl object
     */
    public void removeDepTempl(Integer paymentTypeId, Integer templId)
        throws PaymentTypeException;

    /**
     * This method gets DepTempl objects from the PaymentType object
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getDepTempls(Integer paymentTypeId)
        throws PaymentTypeException;

    /**
     * This method removes an existing PaymentType object
     * @param paymentTypeId - the PaymentType bean primary key
     */
    public void removePaymentType(Integer paymentTypeId)
        throws RemoveException;

    /**
     * This method updates an existing PaymentType object
     * @param paymentTypeVO - the value object of the PaymentType bean
     */
    public void updatePaymentType(PaymentTypeVO paymentTypeVO)
        throws PaymentTypeException;

    /**
     * This method gets findAllPaymentTypes objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getAllPaymentTypes();

    /**
     * This method gets findAllActivePaymentTypes objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getAllActivePaymentTypes();

    /**
     * This method gets findByRodLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByRodLocation(String locationCd);

    /**
     * This method gets findByPrpLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByPrpLocation(String locationCd);

    /**
     * This method gets findByPoaLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByPoaLocation(String locationCd);

    /**
     * This method gets findByOtherLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByOtherLocation(String locationCd);

    /**
     * This method gets findByLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByLocation(String locationCd);

    /**
     * This method gets findByCode objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByCode(String paymentCd);

    /**
     * This method gets findByGndLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByGndLocation(String locationCd);

}
