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

public class COD_RecStatusController {

    /**
     * This method create new RecStatus object
     * @param recStatusVO a value object the RecStatus bean
     */
    public void setCOD_RecStatus(COD_RecStatusVO COD_recStatusVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (COD_recStatusVO == null) {
            throw new IllegalArgumentException("COD_recStatusVO parameter was null in setCOD_RecStatus() method from COD_RecStatusController class");
        }
        
        try {
            getCOD_RecStatusManager().setCOD_RecStatus(COD_recStatusVO);
        }
        catch (COD_RecStatusException ex) {
            String errorMsg = "Error occurred in setCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a COD_RecStatus object
     * @return COD_recStatusVO - a value object of the COD_RecStatus bean
     */
    public COD_RecStatusVO getCOD_RecStatus(Integer statusId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in getCOD_RecStatus() method from COD_RecStatusController class");
        }
        
        try {
            return getCOD_RecStatusManager().getCOD_RecStatus(statusId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCOD_RecStatus objects
     * @return java.util.Collection - a collection of the COD_RecStatus objects
     */
    public Collection getAllCOD_RecStatus()
        throws BusinessDelegateException {
        try {
            return getCOD_RecStatusManager().getAllCOD_RecStatus();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing COD_RecStatus object
     * @param statusId - the COD_RecStatus bean primary key
     */
    public void removeCOD_RecStatus(Integer statusId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in removeCOD_RecStatus() method from COD_RecStatusController class");
        }
        
        try {
            getCOD_RecStatusManager().removeCOD_RecStatus(statusId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RecStatus object
     * @param recStatusVO - the value object of the RecStatus bean
     */
    public void updateCOD_RecStatus(COD_RecStatusVO COD_recStatusVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (COD_recStatusVO == null) {
            throw new IllegalArgumentException("COD_recStatusVO parameter was null in updateCOD_RecStatus() method from COD_RecStatusController class");
        }
        
        try {
            getCOD_RecStatusManager().updateCOD_RecStatus(COD_recStatusVO);
        }
        catch (COD_RecStatusException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateCOD_RecStatus() method from COD_RecStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the RecStatusManager remote interface
     */
    public COD_RecStatusManager getCOD_RecStatusManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            COD_RecStatusManagerHome COD_recStatusManagerHome = (COD_RecStatusManagerHome)
            service.getEJBHome(ServiceConstants.COD_RECSTATUSMANAGER_JNDI, COD_RecStatusManagerHome.class);
            return COD_recStatusManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCOD_RecStatusManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getCOD_RecStatusManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCOD_RecStatusManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
