/**
 * @(#)PymtImptLogManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface PymtImptLogManager extends EJBObject {

    /**
     * This method create new PymtImptLog object
     * @param pymtImptLogVO a value object the PymtImptLog bean
     */
    public void setPymtImptLog(PymtImptLogVO pymtImptLogVO)
        throws RemoteException, PymtImptLogException;

    /**
     * This method gets a PymtImptLog object
     * @param imptId - the PymtImptLog bean primary key
     * @return pymtImptLogVO - a value object of the PymtImptLog bean
     */
    public PymtImptLogVO getPymtImptLog(Integer imptId)
        throws RemoteException, FinderException;

    /**
     * This method gets PymtImptErrorDtl objects from the PymtImptLog object
     * @return Collection - a collection of the PymtImptErrorDtl objects
     */
    public Collection getPymtImptErrorDtls(Integer imptId)
        throws RemoteException, PymtImptLogException;

    /**
     * This method removes an existing PymtImptLog object
     * @param imptId - the PymtImptLog bean primary key
     */
    public void removePymtImptLog(Integer imptId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing PymtImptLog object
     * @param pymtImptLogVO - the value object of the PymtImptLog bean
     */
    public void updatePymtImptLog(PymtImptLogVO pymtImptLogVO)
        throws RemoteException, PymtImptLogException;

    /**
     * This method gets findAllPymtImptLogs objects
     * @return Collection - a collection of the PymtImptLog objects
     */
    public Collection getAllPymtImptLogs()
        throws RemoteException;

}
