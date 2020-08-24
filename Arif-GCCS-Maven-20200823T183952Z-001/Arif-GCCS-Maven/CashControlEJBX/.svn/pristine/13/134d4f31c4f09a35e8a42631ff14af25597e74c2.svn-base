/**
 * @(#)ScanLocProcController.java			Tue Aug 02 15:38:53 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.controller;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.manager.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;

public class ScanLocProcController {

    /**
     * This method create new ScanLocProc object
     * @param scanLocProcVO a value object the ScanLocProc bean
     */
    public void setScanLocProc(ScanLocProcVO scanLocProcVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (scanLocProcVO == null) {
            throw new IllegalArgumentException("scanLocProcVO parameter was null in setScanLocProc() method from ScanLocProcController class");
        }
        
        try {
            getScanLocProcManager().setScanLocProc(scanLocProcVO);
        }
        catch (ScanLocProcException ex) {
            String errorMsg = "Error occurred in setScanLocProc() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setScanLocProc() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a ScanLocProc object
     * @return scanLocProcVO - a value object of the ScanLocProc bean
     */
    public ScanLocProcVO getScanLocProc(Integer scanLocProcId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (scanLocProcId == null) {
            throw new IllegalArgumentException("scanLocProcId parameter was null in getScanLocProc() method from ScanLocProcController class");
        }
        
        try {
            return getScanLocProcManager().getScanLocProc(scanLocProcId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getScanLocProc() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getScanLocProc() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllScanLocProcs objects
     * @return java.util.Collection - a collection of the ScanLocProc objects
     */
    public Collection getAllScanLocProcs()
        throws BusinessDelegateException {
        try {
            return getScanLocProcManager().getAllScanLocProcs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllScanLocProcs() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing ScanLocProc object
     * @param scanLocProcId - the ScanLocProc bean primary key
     */
    public void removeScanLocProc(Integer scanLocProcId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (scanLocProcId == null) {
            throw new IllegalArgumentException("scanLocProcId parameter was null in removeScanLocProc() method from ScanLocProcController class");
        }
        
        try {
            getScanLocProcManager().removeScanLocProc(scanLocProcId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeScanLocProc() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeScanLocProc() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing ScanLocProc object
     * @param scanLocProcVO - the value object of the ScanLocProc bean
     */
    public void updateScanLocProc(ScanLocProcVO scanLocProcVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (scanLocProcVO == null) {
            throw new IllegalArgumentException("scanLocProcVO parameter was null in updateScanLocProc() method from ScanLocProcController class");
        }
        
        try {
            getScanLocProcManager().updateScanLocProc(scanLocProcVO);
        }
        catch (ScanLocProcException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateScanLocProc() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateScanLocProc() method from ScanLocProcController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the ScanLocProcManager remote interface
     */
    public ScanLocProcManager getScanLocProcManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            ScanLocProcManagerHome scanLocProcManagerHome = (ScanLocProcManagerHome)
            service.getEJBHome(ServiceConstants.SCANLOCPROCMANAGER_JNDI, ScanLocProcManagerHome.class);
            return scanLocProcManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getScanLocProcManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getScanLocProcManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getScanLocProcManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
