/**
 * @(#)RodFileProcLogController.java			Tue Aug 02 15:38:53 VET 2005
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

public class RodFileProcLogController {

    /**
     * This method create new RodFileProcLog object
     * @param rodFileProcLogVO a value object the RodFileProcLog bean
     */
    public void setRodFileProcLog(RodFileProcLogVO rodFileProcLogVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (rodFileProcLogVO == null) {
            throw new IllegalArgumentException("rodFileProcLogVO parameter was null in setRodFileProcLog() method from RodFileProcLogController class");
        }
        
        try {
            getRodFileProcLogManager().setRodFileProcLog(rodFileProcLogVO);
        }
        catch (RodFileProcLogException ex) {
            String errorMsg = "Error occurred in setRodFileProcLog() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setRodFileProcLog() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a RodFileProcLog object
     * @return rodFileProcLogVO - a value object of the RodFileProcLog bean
     */
    public RodFileProcLogVO getRodFileProcLog(Integer rodFilePrLogId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (rodFilePrLogId == null) {
            throw new IllegalArgumentException("rodFilePrLogId parameter was null in getRodFileProcLog() method from RodFileProcLogController class");
        }
        
        try {
            return getRodFileProcLogManager().getRodFileProcLog(rodFilePrLogId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getRodFileProcLog() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRodFileProcLog() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRodFileProcLogs objects
     * @return java.util.Collection - a collection of the RodFileProcLog objects
     */
    public Collection getAllRodFileProcLogs()
        throws BusinessDelegateException {
        try {
            return getRodFileProcLogManager().getAllRodFileProcLogs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllRodFileProcLogs() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing RodFileProcLog object
     * @param rodFilePrLogId - the RodFileProcLog bean primary key
     */
    public void removeRodFileProcLog(Integer rodFilePrLogId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (rodFilePrLogId == null) {
            throw new IllegalArgumentException("rodFilePrLogId parameter was null in removeRodFileProcLog() method from RodFileProcLogController class");
        }
        
        try {
            getRodFileProcLogManager().removeRodFileProcLog(rodFilePrLogId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeRodFileProcLog() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeRodFileProcLog() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RodFileProcLog object
     * @param rodFileProcLogVO - the value object of the RodFileProcLog bean
     */
    public void updateRodFileProcLog(RodFileProcLogVO rodFileProcLogVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (rodFileProcLogVO == null) {
            throw new IllegalArgumentException("rodFileProcLogVO parameter was null in updateRodFileProcLog() method from RodFileProcLogController class");
        }
        
        try {
            getRodFileProcLogManager().updateRodFileProcLog(rodFileProcLogVO);
        }
        catch (RodFileProcLogException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateRodFileProcLog() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateRodFileProcLog() method from RodFileProcLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the RodFileProcLogManager remote interface
     */
    public RodFileProcLogManager getRodFileProcLogManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            RodFileProcLogManagerHome rodFileProcLogManagerHome = (RodFileProcLogManagerHome)
            service.getEJBHome(ServiceConstants.RODFILEPROCLOGMANAGER_JNDI, RodFileProcLogManagerHome.class);
            return rodFileProcLogManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRodFileProcLogManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getRodFileProcLogManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRodFileProcLogManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
