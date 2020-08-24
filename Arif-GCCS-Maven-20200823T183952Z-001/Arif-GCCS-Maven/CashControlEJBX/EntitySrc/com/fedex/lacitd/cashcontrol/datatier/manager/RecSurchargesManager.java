/**
 * @(#)RecSurchargesManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface RecSurchargesManager extends EJBObject {

    /**
     * This method create new RecSurcharges object
     * @param recSurchargesVO a value object the RecSurcharges bean
     */
    public void setRecSurcharges(RecSurchargesVO recSurchargesVO)
        throws RemoteException, RecSurchargesException;

    /**
     * This method gets a RecSurcharges object
     * @param recSurchargesPK - the RecSurcharges bean primary key
     * @return recSurchargesVO - a value object of the RecSurcharges bean
     */
    public RecSurchargesVO getRecSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing RecSurcharges object
     * @param recSurchargesPK - the RecSurcharges bean primary key
     */
    public void removeRecSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing RecSurcharges object
     * @param recSurchargesVO - the value object of the RecSurcharges bean
     */
    public void updateRecSurcharges(RecSurchargesVO recSurchargesVO)
        throws RemoteException, RecSurchargesException;

    /**
     * This method gets findAllRecSurcharges objects
     * @return Collection - a collection of the RecSurcharges objects
     */
    public Collection getAllRecSurcharges()
        throws RemoteException;

    /**
     * This method gets findByReceivable objects
     * @return Collection - a collection of the RecSurcharges objects
     */
    public Collection getRecSurchargesByReceivable(Integer recId)
        throws RemoteException;

}
