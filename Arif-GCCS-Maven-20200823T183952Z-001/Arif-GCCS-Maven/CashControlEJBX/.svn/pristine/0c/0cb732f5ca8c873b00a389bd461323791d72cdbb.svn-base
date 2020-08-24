/**
 * @(#)InCageExceptionsController.java			Tue Aug 02 15:38:53 VET 2005
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

public class InCageExceptionsController {

    /**
     * This method create new InCageExceptions object
     * @param inCageExceptionsVO a value object the InCageExceptions bean
     */
    public void setInCageExceptions(InCageExceptionsVO inCageExceptionsVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (inCageExceptionsVO == null) {
            throw new IllegalArgumentException("inCageExceptionsVO parameter was null in setInCageExceptions() method from InCageExceptionsController class");
        }
        
        try {
            getInCageExceptionsManager().setInCageExceptions(inCageExceptionsVO);
        }
        catch (InCageExceptionsException ex) {
            String errorMsg = "Error occurred in setInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a InCageExceptions object
     * @return inCageExceptionsVO - a value object of the InCageExceptions bean
     */
    public InCageExceptionsVO getInCageExceptions(Integer inCageExcpId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (inCageExcpId == null) {
            throw new IllegalArgumentException("inCageExcpId parameter was null in getInCageExceptions() method from InCageExceptionsController class");
        }
        
        try {
            return getInCageExceptionsManager().getInCageExceptions(inCageExcpId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllInCageExceptions objects
     * @return java.util.Collection - a collection of the InCageExceptions objects
     */
    public Collection getAllInCageExceptions()
        throws BusinessDelegateException {
        try {
            return getInCageExceptionsManager().getAllInCageExceptions();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing InCageExceptions object
     * @param inCageExcpId - the InCageExceptions bean primary key
     */
    public void removeInCageExceptions(Integer inCageExcpId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (inCageExcpId == null) {
            throw new IllegalArgumentException("inCageExcpId parameter was null in removeInCageExceptions() method from InCageExceptionsController class");
        }
        
        try {
            getInCageExceptionsManager().removeInCageExceptions(inCageExcpId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing InCageExceptions object
     * @param inCageExceptionsVO - the value object of the InCageExceptions bean
     */
    public void updateInCageExceptions(InCageExceptionsVO inCageExceptionsVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (inCageExceptionsVO == null) {
            throw new IllegalArgumentException("inCageExceptionsVO parameter was null in updateInCageExceptions() method from InCageExceptionsController class");
        }
        
        try {
            getInCageExceptionsManager().updateInCageExceptions(inCageExceptionsVO);
        }
        catch (InCageExceptionsException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateInCageExceptions() method from InCageExceptionsController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the InCageExceptionsManager remote interface
     */
    public InCageExceptionsManager getInCageExceptionsManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            InCageExceptionsManagerHome inCageExceptionsManagerHome = (InCageExceptionsManagerHome)
            service.getEJBHome(ServiceConstants.INCAGEEXCEPTIONSMANAGER_JNDI, InCageExceptionsManagerHome.class);
            return inCageExceptionsManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getInCageExceptionsManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getInCageExceptionsManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getInCageExceptionsManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
