/**
 * @(#)DepTemplLocController.java			Tue Aug 02 15:38:53 VET 2005
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

public class DepTemplLocController {

    /**
     * This method create new DepTemplLoc object
     * @param depTemplLocVO a value object the DepTemplLoc bean
     */
    public void setDepTemplLoc(DepTemplLocVO depTemplLocVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depTemplLocVO == null) {
            throw new IllegalArgumentException("depTemplLocVO parameter was null in setDepTemplLoc() method from DepTemplLocController class");
        }
        
        try {
            getDepTemplLocManager().setDepTemplLoc(depTemplLocVO);
        }
        catch (DepTemplLocException ex) {
            String errorMsg = "Error occurred in setDepTemplLoc() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setDepTemplLoc() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a DepTemplLoc object
     * @return depTemplLocVO - a value object of the DepTemplLoc bean
     */
    public DepTemplLocVO getDepTemplLoc(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (depTemplLocPK == null) {
            throw new IllegalArgumentException("depTemplLocPK parameter was null in getDepTemplLoc() method from DepTemplLocController class");
        }
        
        try {
            return getDepTemplLocManager().getDepTemplLoc(depTemplLocPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getDepTemplLoc() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTemplLoc() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllDepTemplLocs objects
     * @return java.util.Collection - a collection of the DepTemplLoc objects
     */
    public Collection getAllDepTemplLocs()
        throws BusinessDelegateException {
        try {
            return getDepTemplLocManager().getAllDepTemplLocs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllDepTemplLocs() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing DepTemplLoc object
     * @param depTemplLocPK - the DepTemplLoc bean primary key
     */
    public void removeDepTemplLoc(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depTemplLocPK == null) {
            throw new IllegalArgumentException("depTemplLocPK parameter was null in removeDepTemplLoc() method from DepTemplLocController class");
        }
        
        try {
            getDepTemplLocManager().removeDepTemplLoc(depTemplLocPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeDepTemplLoc() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeDepTemplLoc() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing DepTemplLoc object
     * @param depTemplLocVO - the value object of the DepTemplLoc bean
     */
    public void updateDepTemplLoc(DepTemplLocVO depTemplLocVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depTemplLocVO == null) {
            throw new IllegalArgumentException("depTemplLocVO parameter was null in updateDepTemplLoc() method from DepTemplLocController class");
        }
        
        try {
            getDepTemplLocManager().updateDepTemplLoc(depTemplLocVO);
        }
        catch (DepTemplLocException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateDepTemplLoc() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateDepTemplLoc() method from DepTemplLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the DepTemplLocManager remote interface
     */
    public DepTemplLocManager getDepTemplLocManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            DepTemplLocManagerHome depTemplLocManagerHome = (DepTemplLocManagerHome)
            service.getEJBHome(ServiceConstants.DEPTEMPLLOCMANAGER_JNDI, DepTemplLocManagerHome.class);
            return depTemplLocManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplLocManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getDepTemplLocManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTemplLocManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
