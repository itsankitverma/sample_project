/**
 * @(#)RecStatusController.java			Tue Aug 02 15:38:53 VET 2005
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

public class RecStatusController {

    /**
     * This method create new RecStatus object
     * @param recStatusVO a value object the RecStatus bean
     */
    public void setRecStatus(RecStatusVO recStatusVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recStatusVO == null) {
            throw new IllegalArgumentException("recStatusVO parameter was null in setRecStatus() method from RecStatusController class");
        }
        
        try {
            getRecStatusManager().setRecStatus(recStatusVO);
        }
        catch (RecStatusException ex) {
            String errorMsg = "Error occurred in setRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a RecStatus object
     * @return recStatusVO - a value object of the RecStatus bean
     */
    public RecStatusVO getRecStatus(Integer statusId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in getRecStatus() method from RecStatusController class");
        }
        
        try {
            return getRecStatusManager().getRecStatus(statusId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRecStatus objects
     * @return java.util.Collection - a collection of the RecStatus objects
     */
    public Collection getAllRecStatus()
        throws BusinessDelegateException {
        try {
            return getRecStatusManager().getAllRecStatus();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing RecStatus object
     * @param statusId - the RecStatus bean primary key
     */
    public void removeRecStatus(Integer statusId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in removeRecStatus() method from RecStatusController class");
        }
        
        try {
            getRecStatusManager().removeRecStatus(statusId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RecStatus object
     * @param recStatusVO - the value object of the RecStatus bean
     */
    public void updateRecStatus(RecStatusVO recStatusVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recStatusVO == null) {
            throw new IllegalArgumentException("recStatusVO parameter was null in updateRecStatus() method from RecStatusController class");
        }
        
        try {
            getRecStatusManager().updateRecStatus(recStatusVO);
        }
        catch (RecStatusException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateRecStatus() method from RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the RecStatusManager remote interface
     */
    public RecStatusManager getRecStatusManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            RecStatusManagerHome recStatusManagerHome = (RecStatusManagerHome)
            service.getEJBHome(ServiceConstants.RECSTATUSMANAGER_JNDI, RecStatusManagerHome.class);
            return recStatusManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRecStatusManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getRecStatusManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRecStatusManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
