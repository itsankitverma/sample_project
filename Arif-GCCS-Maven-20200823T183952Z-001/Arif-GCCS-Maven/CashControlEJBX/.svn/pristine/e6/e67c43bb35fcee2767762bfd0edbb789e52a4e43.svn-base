/**
 * @(#)RecStatusManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface RecStatusManager extends EJBObject {

    /**
     * This method create new RecStatus object
     * @param recStatusVO a value object the RecStatus bean
     */
    public void setRecStatus(RecStatusVO recStatusVO)
        throws RemoteException, RecStatusException;

    /**
     * This method gets a RecStatus object
     * @param statusId - the RecStatus bean primary key
     * @return recStatusVO - a value object of the RecStatus bean
     */
    public RecStatusVO getRecStatus(Integer statusId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing RecStatus object
     * @param statusId - the RecStatus bean primary key
     */
    public void removeRecStatus(Integer statusId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing RecStatus object
     * @param recStatusVO - the value object of the RecStatus bean
     */
    public void updateRecStatus(RecStatusVO recStatusVO)
        throws RemoteException, RecStatusException;

    /**
     * This method gets findAllRecStatus objects
     * @return Collection - a collection of the RecStatus objects
     */
    public Collection getAllRecStatus()
        throws RemoteException;

}
