/**
 * @(#)DepTemplManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface DepTemplManager extends EJBObject {

    /**
     * This method create new DepTempl object
     * @param depTemplVO a value object the DepTempl bean
     */
    public void setDepTempl(DepTemplVO depTemplVO)
        throws RemoteException, DepTemplException;

    /**
     * This method gets a DepTempl object
     * @param templId - the DepTempl bean primary key
     * @return depTemplVO - a value object of the DepTempl bean
     */
    public DepTemplVO getDepTempl(Integer templId)
        throws RemoteException, FinderException;

    /**
     * This method adds the Location object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer templId, String locationCd)
        throws RemoteException, DepTemplException;

    /**
     * This method removes the Location object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer templId, String locationCd)
        throws RemoteException, DepTemplException;

    /**
     * This method gets Location objects from the DepTempl object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer templId)
        throws RemoteException, DepTemplException;

    /**
     * This method adds the PaymentType object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void addPaymentType(Integer templId, Integer paymentTypeId)
        throws RemoteException, DepTemplException;

    /**
     * This method removes the PaymentType object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void removePaymentType(Integer templId, Integer paymentTypeId)
        throws RemoteException, DepTemplException;

    /**
     * This method gets PaymentType objects from the DepTempl object
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypes(Integer templId)
        throws RemoteException, DepTemplException;

    /**
     * This method removes an existing DepTempl object
     * @param templId - the DepTempl bean primary key
     */
    public void removeDepTempl(Integer templId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing DepTempl object
     * @param depTemplVO - the value object of the DepTempl bean
     */
    public void updateDepTempl(DepTemplVO depTemplVO)
        throws RemoteException, DepTemplException;

    /**
     * This method gets findAllDepTempls objects
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getAllDepTempls()
        throws RemoteException;

    /**
     * This method gets findAllActiveDepTempls objects
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getAllActiveDepTempls()
        throws RemoteException;

    /**
     * This method gets findDepTemplsbyCode objects
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getDepTemplDepTemplsbyCode(String templCd)
        throws RemoteException;

}
