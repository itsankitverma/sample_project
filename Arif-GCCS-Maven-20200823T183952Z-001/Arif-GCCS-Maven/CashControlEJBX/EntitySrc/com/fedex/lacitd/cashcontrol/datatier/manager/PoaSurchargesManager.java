/**
 * @(#)PoaSurchargesManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface PoaSurchargesManager extends EJBObject {

    /**
     * This method create new PoaSurcharges object
     * @param poaSurchargesVO a value object the PoaSurcharges bean
     */
    public void setPoaSurcharges(PoaSurchargesVO poaSurchargesVO)
        throws RemoteException, PoaSurchargesException;

    /**
     * This method gets a PoaSurcharges object
     * @param poaSurchargesPK - the PoaSurcharges bean primary key
     * @return poaSurchargesVO - a value object of the PoaSurcharges bean
     */
    public PoaSurchargesVO getPoaSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing PoaSurcharges object
     * @param poaSurchargesPK - the PoaSurcharges bean primary key
     */
    public void removePoaSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing PoaSurcharges object
     * @param poaSurchargesVO - the value object of the PoaSurcharges bean
     */
    public void updatePoaSurcharges(PoaSurchargesVO poaSurchargesVO)
        throws RemoteException, PoaSurchargesException;

    /**
     * This method gets findAllPoaSurcharges objects
     * @return Collection - a collection of the PoaSurcharges objects
     */
    public Collection getAllPoaSurcharges()
        throws RemoteException;

    /**
     * This method gets findByPoaDetail objects
     * @return Collection - a collection of the PoaSurcharges objects
     */
    public Collection getPoaSurchargesByPoaDetail(Integer poaDetailId)
        throws RemoteException;

}
