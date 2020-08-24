/**
 * @(#)SurchargesManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface SurchargesManager extends EJBObject {

    /**
     * This method create new Surcharges object
     * @param surchargesVO a value object the Surcharges bean
     */
    public void setSurcharges(SurchargesVO surchargesVO)
        throws RemoteException, SurchargesException;

    /**
     * This method gets a Surcharges object
     * @param surchargeCd - the Surcharges bean primary key
     * @return surchargesVO - a value object of the Surcharges bean
     */
    public SurchargesVO getSurcharges(String surchargeCd)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing Surcharges object
     * @param surchargeCd - the Surcharges bean primary key
     */
    public void removeSurcharges(String surchargeCd)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing Surcharges object
     * @param surchargesVO - the value object of the Surcharges bean
     */
    public void updateSurcharges(SurchargesVO surchargesVO)
        throws RemoteException, SurchargesException;

    /**
     * This method gets findAllSurcharges objects
     * @return Collection - a collection of the Surcharges objects
     */
    public Collection getAllSurcharges()
        throws RemoteException;

    /**
     * This method gets findByRod objects
     * @return Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByRod(String locationCd)
        throws RemoteException;

    /**
     * This method gets findByPrepaid objects
     * @return Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByPrepaid(String locationCd)
        throws RemoteException;

    /**
     * This method gets findByPoa objects
     * @return Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByPoa(String locationCd)
        throws RemoteException;

}
