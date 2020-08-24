/**
 * @(#)ScanLocProcManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface ScanLocProcManager extends EJBObject {

    /**
     * This method create new ScanLocProc object
     * @param scanLocProcVO a value object the ScanLocProc bean
     */
    public void setScanLocProc(ScanLocProcVO scanLocProcVO)
        throws RemoteException, ScanLocProcException;

    /**
     * This method gets a ScanLocProc object
     * @param scanLocProcId - the ScanLocProc bean primary key
     * @return scanLocProcVO - a value object of the ScanLocProc bean
     */
    public ScanLocProcVO getScanLocProc(Integer scanLocProcId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing ScanLocProc object
     * @param scanLocProcId - the ScanLocProc bean primary key
     */
    public void removeScanLocProc(Integer scanLocProcId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing ScanLocProc object
     * @param scanLocProcVO - the value object of the ScanLocProc bean
     */
    public void updateScanLocProc(ScanLocProcVO scanLocProcVO)
        throws RemoteException, ScanLocProcException;

    /**
     * This method gets findAllScanLocProcs objects
     * @return Collection - a collection of the ScanLocProc objects
     */
    public Collection getAllScanLocProcs()
        throws RemoteException;

}
