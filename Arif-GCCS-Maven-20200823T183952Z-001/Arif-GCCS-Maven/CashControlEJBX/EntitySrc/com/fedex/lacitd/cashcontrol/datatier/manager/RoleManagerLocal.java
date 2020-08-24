/**
 * @(#)RoleManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.manager;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public interface RoleManagerLocal extends EJBLocalObject {

    /**
     * This method create new Role object
     * @param roleVO a value object the Role bean
     */
    public void setRole(RoleVO roleVO)
        throws RoleException;

    /**
     * This method gets a Role object
     * @param roleId - the Role bean primary key
     * @return roleVO - a value object of the Role bean
     */
    public RoleVO getRole(Integer roleId)
        throws FinderException;

    /**
     * This method removes an existing Role object
     * @param roleId - the Role bean primary key
     */
    public void removeRole(Integer roleId)
        throws RemoveException;

    /**
     * This method updates an existing Role object
     * @param roleVO - the value object of the Role bean
     */
    public void updateRole(RoleVO roleVO)
        throws RoleException;

    /**
     * This method gets findAllRoles objects
     * @return Collection - a collection of the Role objects
     */
    public Collection getAllRoles();

}
