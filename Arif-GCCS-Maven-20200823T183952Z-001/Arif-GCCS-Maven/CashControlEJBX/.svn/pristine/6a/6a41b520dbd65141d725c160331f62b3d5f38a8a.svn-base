/**
 * @(#)DepTemplLocManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface DepTemplLocManager extends EJBObject {

    /**
     * This method create new DepTemplLoc object
     * @param depTemplLocVO a value object the DepTemplLoc bean
     */
    public void setDepTemplLoc(DepTemplLocVO depTemplLocVO)
        throws RemoteException, DepTemplLocException;

    /**
     * This method gets a DepTemplLoc object
     * @param depTemplLocPK - the DepTemplLoc bean primary key
     * @return depTemplLocVO - a value object of the DepTemplLoc bean
     */
    public DepTemplLocVO getDepTemplLoc(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing DepTemplLoc object
     * @param depTemplLocPK - the DepTemplLoc bean primary key
     */
    public void removeDepTemplLoc(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing DepTemplLoc object
     * @param depTemplLocVO - the value object of the DepTemplLoc bean
     */
    public void updateDepTemplLoc(DepTemplLocVO depTemplLocVO)
        throws RemoteException, DepTemplLocException;

    /**
     * This method gets findAllDepTemplLocs objects
     * @return Collection - a collection of the DepTemplLoc objects
     */
    public Collection getAllDepTemplLocs()
        throws RemoteException;

}
