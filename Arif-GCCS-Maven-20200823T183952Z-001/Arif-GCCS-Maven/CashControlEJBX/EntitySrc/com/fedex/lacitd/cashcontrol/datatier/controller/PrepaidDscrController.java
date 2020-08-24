/**
 * @(#)PrepaidDscrController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PrepaidDscrController {

    /**
     * This method create new PrepaidDscr object
     * @param prepaidDscrVO a value object the PrepaidDscr bean
     */
    public void setPrepaidDscr(PrepaidDscrVO prepaidDscrVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepaidDscrVO == null) {
            throw new IllegalArgumentException("prepaidDscrVO parameter was null in setPrepaidDscr() method from PrepaidDscrController class");
        }
        
        try {
            getPrepaidDscrManager().setPrepaidDscr(prepaidDscrVO);
        }
        catch (PrepaidDscrException ex) {
            String errorMsg = "Error occurred in setPrepaidDscr() method from PrepaidDscrController class";
            ex.printStackTrace();
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPrepaidDscr() method from PrepaidDscrController class";
            ex.printStackTrace();
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PrepaidDscr object
     * @return prepaidDscrVO - a value object of the PrepaidDscr bean
     */
    public PrepaidDscrVO getPrepaidDscr(Integer prepaidDscrId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (prepaidDscrId == null) {
            throw new IllegalArgumentException("prepaidDscrId parameter was null in getPrepaidDscr() method from PrepaidDscrController class");
        }
        
        try {
            return getPrepaidDscrManager().getPrepaidDscr(prepaidDscrId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPrepaidDscr() method from PrepaidDscrController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepaidDscr() method from PrepaidDscrController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPrepaidDscrs objects
     * @return java.util.Collection - a collection of the PrepaidDscr objects
     */
    public Collection getAllPrepaidDscrs()
        throws BusinessDelegateException {
        try {
            return getPrepaidDscrManager().getAllPrepaidDscrs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPrepaidDscrs() method from PrepaidDscrController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PrepaidDscr object
     * @param prepaidDscrId - the PrepaidDscr bean primary key
     */
    public void removePrepaidDscr(Integer prepaidDscrId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepaidDscrId == null) {
            throw new IllegalArgumentException("prepaidDscrId parameter was null in removePrepaidDscr() method from PrepaidDscrController class");
        }
        
        try {
            getPrepaidDscrManager().removePrepaidDscr(prepaidDscrId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePrepaidDscr() method from PrepaidDscrController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePrepaidDscr() method from PrepaidDscrController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PrepaidDscr object
     * @param prepaidDscrVO - the value object of the PrepaidDscr bean
     */
    public void updatePrepaidDscr(PrepaidDscrVO prepaidDscrVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepaidDscrVO == null) {
            throw new IllegalArgumentException("prepaidDscrVO parameter was null in updatePrepaidDscr() method from PrepaidDscrController class");
        }
        
        try {
            getPrepaidDscrManager().updatePrepaidDscr(prepaidDscrVO);
        }
        catch (PrepaidDscrException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePrepaidDscr() method from PrepaidDscrController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePrepaidDscr() method from PrepaidDscrController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PrepaidDscrManager remote interface
     */
    public PrepaidDscrManager getPrepaidDscrManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PrepaidDscrManagerHome prepaidDscrManagerHome = (PrepaidDscrManagerHome)
            service.getEJBHome(ServiceConstants.PREPAIDDSCRMANAGER_JNDI, PrepaidDscrManagerHome.class);
            return prepaidDscrManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPrepaidDscrManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPrepaidDscrManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepaidDscrManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
