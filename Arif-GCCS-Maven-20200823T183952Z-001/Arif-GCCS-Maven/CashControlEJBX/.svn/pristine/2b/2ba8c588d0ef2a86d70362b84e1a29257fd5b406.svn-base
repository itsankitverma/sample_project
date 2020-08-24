/**
 * @(#)RoleManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class RoleManagerBean implements SessionBean {

    private SessionContext _ctx;
    /**
     * Called by Container. This method initialization the session
     */
    public void ejbCreate() {
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * EJB Container calls this method right before it remove the Session bean 
     */
    public void ejbRemove() {
    }

    /**
     * Called by Container. Associates this Bean instance with a particular context environment.
     */
    public void setSessionContext(SessionContext ctx) {
        _ctx = ctx;
    }

    /**
     * This method create new Role object
     * @param roleVO a value object the Role bean
     */
    public void setRole(RoleVO roleVO)
        throws RoleException {
        //-- we do not accept null value for the parameter.
        if (roleVO == null) {
            throw new IllegalArgumentException("roleVO parameter was null in setRole() method from RoleManager class");
        }
        
        try {
            
            //-- create new Role object
            getRoleLocalHome().create(
                roleVO.getRole(),
                roleVO.getDescription());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setRole() method from RoleManager class";
            throw new RoleException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setRole() method from RoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Role object
     * @return roleVO - a value object of the Role bean
     */
    public RoleVO getRole(Integer roleId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (roleId == null) {
            throw new IllegalArgumentException("roleId parameter was null in getRole() method from RoleManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            RoleLocal roleLocal = getRoleLocalHome().findByPrimaryKey(roleId);
            //-- create new value object to store the data
            RoleVO roleVO = new RoleVO();
            //-- populate the new value object
            roleVO.setRoleId(roleLocal.getRoleId());
            roleVO.setRole(roleLocal.getRole());
            roleVO.setDescription(roleLocal.getDescription());
            return roleVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getRole() method from RoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Role object
     * @param roleId - the Role bean primary key
     */
    public void removeRole(Integer roleId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (roleId == null) {
            throw new IllegalArgumentException("roleId parameter was null in removeRole() method from RoleManager class");
        }
        
        try {
            getRoleLocalHome().remove(roleId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeRole() method from RoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Role object
     * @param roleVO - the value object of the Role bean
     */
    public void updateRole(RoleVO roleVO)
        throws RoleException {
        //-- we do not accept null value for the parameter.
        if (roleVO == null) {
            throw new IllegalArgumentException("roleVO parameter was null in updateRole() method from RoleManager class");
        }
        
        try {
            Integer roleId = roleVO.getRoleId();
            
            RoleLocal roleLocal = getRoleLocalHome().findByPrimaryKey(roleId);
            //-- update Role entity bean
            roleLocal.setRole(roleVO.getRole());
            roleLocal.setDescription(roleVO.getDescription());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateRole() method from RoleManager class";
            throw new RoleException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateRole() method from RoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRoles objects
     * @return Collection - a collection of the Role objects
     */
    public Collection getAllRoles() {
        try {
            //-- gets the local home interface and call the findAllRoles method
            Collection roleCol = getRoleLocalHome().findAllRoles();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (roleCol != null && roleCol.size() > 0) {
                Iterator it = roleCol.iterator();
                while (it.hasNext()) {
                    RoleLocal roleLocal = (RoleLocal) it.next();
                    //-- get the primary key of the Role EJB object
                    Integer roleId = (Integer)roleLocal.getPrimaryKey();
                    //-- get the value object for the Role EJB using the primary key
                    if (roleId != null) {
                        RoleVO roleVO = getRole(roleId);
                        //-- add the value object to the collection
                        list.add(roleVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllRoles() method from RoleManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllRoles() method from RoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Role local home interface
     */
    private RoleLocalHome getRoleLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (RoleLocalHome) service.getEJBLocalHome(ServiceConstants.ROLE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRoleLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
