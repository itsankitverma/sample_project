/**
 * @(#)PreStatusController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PreStatusController {

    /**
     * This method create new PreStatus object
     * @param preStatusVO a value object the PreStatus bean
     */
    public void setPreStatus(PreStatusVO preStatusVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (preStatusVO == null) {
            throw new IllegalArgumentException("preStatusVO parameter was null in setPreStatus() method from PreStatusController class");
        }
        
        try {
            getPreStatusManager().setPreStatus(preStatusVO);
        }
        catch (PreStatusException ex) {
            String errorMsg = "Error occurred in setPreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PreStatus object
     * @return preStatusVO - a value object of the PreStatus bean
     */
    public PreStatusVO getPreStatus(Integer statusIdNbr)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (statusIdNbr == null) {
            throw new IllegalArgumentException("statusIdNbr parameter was null in getPreStatus() method from PreStatusController class");
        }
        
        try {
            return getPreStatusManager().getPreStatus(statusIdNbr);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPreStatus objects
     * @return java.util.Collection - a collection of the PreStatus objects
     */
    public Collection getAllPreStatus()
        throws BusinessDelegateException {
        try {
            return getPreStatusManager().getAllPreStatus();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PreStatus object
     * @param statusIdNbr - the PreStatus bean primary key
     */
    public void removePreStatus(Integer statusIdNbr)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (statusIdNbr == null) {
            throw new IllegalArgumentException("statusIdNbr parameter was null in removePreStatus() method from PreStatusController class");
        }
        
        try {
            getPreStatusManager().removePreStatus(statusIdNbr);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PreStatus object
     * @param preStatusVO - the value object of the PreStatus bean
     */
    public void updatePreStatus(PreStatusVO preStatusVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (preStatusVO == null) {
            throw new IllegalArgumentException("preStatusVO parameter was null in updatePreStatus() method from PreStatusController class");
        }
        
        try {
            getPreStatusManager().updatePreStatus(preStatusVO);
        }
        catch (PreStatusException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePreStatus() method from PreStatusController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PreStatusManager remote interface
     */
    public PreStatusManager getPreStatusManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PreStatusManagerHome preStatusManagerHome = (PreStatusManagerHome)
            service.getEJBHome(ServiceConstants.PRESTATUSMANAGER_JNDI, PreStatusManagerHome.class);
            return preStatusManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPreStatusManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPreStatusManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPreStatusManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
