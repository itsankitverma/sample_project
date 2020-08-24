/**
 * @(#)RoleController.java			Tue Aug 02 15:38:53 VET 2005
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

public class RoleController {

    /**
     * This method create new Role object
     * @param roleVO a value object the Role bean
     */
    public void setRole(RoleVO roleVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (roleVO == null) {
            throw new IllegalArgumentException("roleVO parameter was null in setRole() method from RoleController class");
        }
        
        try {
            getRoleManager().setRole(roleVO);
        }
        catch (RoleException ex) {
            String errorMsg = "Error occurred in setRole() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setRole() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Role object
     * @return roleVO - a value object of the Role bean
     */
    public RoleVO getRole(Integer roleId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (roleId == null) {
            throw new IllegalArgumentException("roleId parameter was null in getRole() method from RoleController class");
        }
        
        try {
            return getRoleManager().getRole(roleId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getRole() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRole() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRoles objects
     * @return java.util.Collection - a collection of the Role objects
     */
    public Collection getAllRoles()
        throws BusinessDelegateException {
        try {
            return getRoleManager().getAllRoles();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllRoles() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Role object
     * @param roleId - the Role bean primary key
     */
    public void removeRole(Integer roleId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (roleId == null) {
            throw new IllegalArgumentException("roleId parameter was null in removeRole() method from RoleController class");
        }
        
        try {
            getRoleManager().removeRole(roleId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeRole() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeRole() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Role object
     * @param roleVO - the value object of the Role bean
     */
    public void updateRole(RoleVO roleVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (roleVO == null) {
            throw new IllegalArgumentException("roleVO parameter was null in updateRole() method from RoleController class");
        }
        
        try {
            getRoleManager().updateRole(roleVO);
        }
        catch (RoleException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateRole() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateRole() method from RoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the RoleManager remote interface
     */
    public RoleManager getRoleManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            RoleManagerHome roleManagerHome = (RoleManagerHome)
            service.getEJBHome(ServiceConstants.ROLEMANAGER_JNDI, RoleManagerHome.class);
            return roleManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRoleManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getRoleManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRoleManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
