/**
 * @(#)RodFileProcLogManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface RodFileProcLogManager extends EJBObject {

    /**
     * This method create new RodFileProcLog object
     * @param rodFileProcLogVO a value object the RodFileProcLog bean
     */
    public void setRodFileProcLog(RodFileProcLogVO rodFileProcLogVO)
        throws RemoteException, RodFileProcLogException;

    /**
     * This method gets a RodFileProcLog object
     * @param rodFilePrLogId - the RodFileProcLog bean primary key
     * @return rodFileProcLogVO - a value object of the RodFileProcLog bean
     */
    public RodFileProcLogVO getRodFileProcLog(Integer rodFilePrLogId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing RodFileProcLog object
     * @param rodFilePrLogId - the RodFileProcLog bean primary key
     */
    public void removeRodFileProcLog(Integer rodFilePrLogId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing RodFileProcLog object
     * @param rodFileProcLogVO - the value object of the RodFileProcLog bean
     */
    public void updateRodFileProcLog(RodFileProcLogVO rodFileProcLogVO)
        throws RemoteException, RodFileProcLogException;

    /**
     * This method gets findAllRodFileProcLogs objects
     * @return Collection - a collection of the RodFileProcLog objects
     */
    public Collection getAllRodFileProcLogs()
        throws RemoteException;

}
