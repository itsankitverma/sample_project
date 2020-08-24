/**
 * @(#)COD_RecStatusManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface COD_RecStatusManager extends EJBObject {

    /**
     * This method create new COD_RecStatus object
     * @param COD_recStatusVO a value object the COD_RecStatus bean
     */
    public void setCOD_RecStatus(COD_RecStatusVO COD_recStatusVO)
        throws RemoteException, COD_RecStatusException;

    /**
     * This method gets a COD_RecStatus object
     * @param statusId - the COD_RecStatus bean primary key
     * @return COD_recStatusVO - a value object of the COD_RecStatus bean
     */
    public COD_RecStatusVO getCOD_RecStatus(Integer statusId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing COD_RecStatus object
     * @param statusId - the COD_RecStatus bean primary key
     */
    public void removeCOD_RecStatus(Integer statusId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing COD_RecStatus object
     * @param COD_recStatusVO - the value object of the COD_RecStatus bean
     */
    public void updateCOD_RecStatus(COD_RecStatusVO COD_recStatusVO)
        throws RemoteException, COD_RecStatusException;

    /**
     * This method gets findAllCOD_RecStatus objects
     * @return Collection - a collection of the COD_RecStatus objects
     */
    public Collection getAllCOD_RecStatus()
        throws RemoteException;

}
