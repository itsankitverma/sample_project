/**
 * @(#)DepTemplPymtTypeController.java			Tue Aug 02 15:38:53 VET 2005
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

public class DepTemplPymtTypeController {

    /**
     * This method create new DepTemplPymtType object
     * @param depTemplPymtTypeVO a value object the DepTemplPymtType bean
     */
    public void setDepTemplPymtType(DepTemplPymtTypeVO depTemplPymtTypeVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depTemplPymtTypeVO == null) {
            throw new IllegalArgumentException("depTemplPymtTypeVO parameter was null in setDepTemplPymtType() method from DepTemplPymtTypeController class");
        }
        
        try {
            getDepTemplPymtTypeManager().setDepTemplPymtType(depTemplPymtTypeVO);
        }
        catch (DepTemplPymtTypeException ex) {
            String errorMsg = "Error occurred in setDepTemplPymtType() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setDepTemplPymtType() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a DepTemplPymtType object
     * @return depTemplPymtTypeVO - a value object of the DepTemplPymtType bean
     */
    public DepTemplPymtTypeVO getDepTemplPymtType(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK depTemplPymtTypePK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (depTemplPymtTypePK == null) {
            throw new IllegalArgumentException("depTemplPymtTypePK parameter was null in getDepTemplPymtType() method from DepTemplPymtTypeController class");
        }
        
        try {
            return getDepTemplPymtTypeManager().getDepTemplPymtType(depTemplPymtTypePK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getDepTemplPymtType() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTemplPymtType() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllDepTemplPymtTypes objects
     * @return java.util.Collection - a collection of the DepTemplPymtType objects
     */
    public Collection getAllDepTemplPymtTypes()
        throws BusinessDelegateException {
        try {
            return getDepTemplPymtTypeManager().getAllDepTemplPymtTypes();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllDepTemplPymtTypes() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing DepTemplPymtType object
     * @param depTemplPymtTypePK - the DepTemplPymtType bean primary key
     */
    public void removeDepTemplPymtType(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK depTemplPymtTypePK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depTemplPymtTypePK == null) {
            throw new IllegalArgumentException("depTemplPymtTypePK parameter was null in removeDepTemplPymtType() method from DepTemplPymtTypeController class");
        }
        
        try {
            getDepTemplPymtTypeManager().removeDepTemplPymtType(depTemplPymtTypePK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeDepTemplPymtType() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeDepTemplPymtType() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing DepTemplPymtType object
     * @param depTemplPymtTypeVO - the value object of the DepTemplPymtType bean
     */
    public void updateDepTemplPymtType(DepTemplPymtTypeVO depTemplPymtTypeVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (depTemplPymtTypeVO == null) {
            throw new IllegalArgumentException("depTemplPymtTypeVO parameter was null in updateDepTemplPymtType() method from DepTemplPymtTypeController class");
        }
        
        try {
            getDepTemplPymtTypeManager().updateDepTemplPymtType(depTemplPymtTypeVO);
        }
        catch (DepTemplPymtTypeException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateDepTemplPymtType() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateDepTemplPymtType() method from DepTemplPymtTypeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the DepTemplPymtTypeManager remote interface
     */
    public DepTemplPymtTypeManager getDepTemplPymtTypeManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            DepTemplPymtTypeManagerHome depTemplPymtTypeManagerHome = (DepTemplPymtTypeManagerHome)
            service.getEJBHome(ServiceConstants.DEPTEMPLPYMTTYPEMANAGER_JNDI, DepTemplPymtTypeManagerHome.class);
            return depTemplPymtTypeManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplPymtTypeManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getDepTemplPymtTypeManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTemplPymtTypeManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
