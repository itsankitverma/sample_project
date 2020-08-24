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

public class FTC_RecStatusController {

    /**
     * This method create new RecStatus object
     * @param recStatusVO a value object the RecStatus bean
     */
    public void setFTC_RecStatus(FTC_RecStatusVO FTC_recStatusVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (FTC_recStatusVO == null) {
            throw new IllegalArgumentException("FTC_recStatusVO parameter was null in setFTC_RecStatus() method from FTC_RecStatusController class");
        }
        
        try {
            getFTC_RecStatusManager().setFTC_RecStatus(FTC_recStatusVO);
        }
        catch (FTC_RecStatusException ex) {
            String errorMsg = "Error occurred in setFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a FTC_RecStatus object
     * @return FTC_recStatusVO - a value object of the FTC_RecStatus bean
     */
    public FTC_RecStatusVO getFTC_RecStatus(Integer statusId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in getFTC_RecStatus() method from FTC_RecStatusController class");
        }
        
        try {
            return getFTC_RecStatusManager().getFTC_RecStatus(statusId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllFTC_RecStatus objects
     * @return java.util.Collection - a collection of the FTC_RecStatus objects
     */
    public Collection getAllFTC_RecStatus()
        throws BusinessDelegateException {
        try {
            return getFTC_RecStatusManager().getAllFTC_RecStatus();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing FTC_RecStatus object
     * @param statusId - the FTC_RecStatus bean primary key
     */
    public void removeFTC_RecStatus(Integer statusId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in removeFTC_RecStatus() method from FTC_RecStatusController class");
        }
        
        try {
            getFTC_RecStatusManager().removeFTC_RecStatus(statusId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RecStatus object
     * @param recStatusVO - the value object of the RecStatus bean
     */
    public void updateFTC_RecStatus(FTC_RecStatusVO FTC_recStatusVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (FTC_recStatusVO == null) {
            throw new IllegalArgumentException("FTC_recStatusVO parameter was null in updateFTC_RecStatus() method from FTC_RecStatusController class");
        }
        
        try {
            getFTC_RecStatusManager().updateFTC_RecStatus(FTC_recStatusVO);
        }
        catch (FTC_RecStatusException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateFTC_RecStatus() method from FTC_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the RecStatusManager remote interface
     */
    public FTC_RecStatusManager getFTC_RecStatusManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            FTC_RecStatusManagerHome FTC_recStatusManagerHome = (FTC_RecStatusManagerHome)
            service.getEJBHome(ServiceConstants.FTC_RECSTATUSMANAGER_JNDI, FTC_RecStatusManagerHome.class);
            return FTC_recStatusManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getFTC_RecStatusManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getFTC_RecStatusManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getFTC_RecStatusManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
