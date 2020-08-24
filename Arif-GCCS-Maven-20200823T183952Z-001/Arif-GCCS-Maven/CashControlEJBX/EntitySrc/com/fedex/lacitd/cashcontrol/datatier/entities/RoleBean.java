/**
 * @(#)RoleBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the role table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class RoleBean implements EntityBean {

    private EntityContext _ctx;
    public RoleBean() {
    }
    /**
     * Set the value of roleId
     * @param roleId - Integer of roleId
     */
    public abstract void setRoleId(Integer roleId);

    /**
     * Get the value of roleId
     * @return roleId - Integer of roleId
     */
    public abstract Integer getRoleId();

    /**
     * Set the value of role
     * @param role - String of role
     */
    public abstract void setRole(String role);

    /**
     * Get the value of role
     * @return role - String of role
     */
    public abstract String getRole();

    /**
     * Set the value of description
     * @param description - String of description
     */
    public abstract void setDescription(String description);

    /**
     * Get the value of description
     * @return description - String of description
     */
    public abstract String getDescription();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String role, String description)
        throws CreateException {
        setRole(role);
        setDescription(description);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String role, String description)
        throws CreateException {
    }

    /**
     * Called by Container.  Associates this Bean instance with a particular context environment.
     */
    public void setEntityContext(EntityContext ctx) {
        _ctx = ctx;
    }

    /**
     * Called by Container.  Disassociates this Bean instance with a particular 
     * context.  Once done, we can query the Context for environment information
     */
    public void unsetEntityContext() {
        _ctx = null;
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
     * Called by Container.  Updates the entity bean instance to reflect 
     * the current value stored in the database.
     */
    public void ejbLoad() {
    }

    /**
     * Called by Container.  Updates the database to reflect the current values 
     * of this in-memory Entity Bean instance representation.
     */
    public void ejbStore() {
    }

    /**
     * EJB Container calls this method right before it remove the Entity bean 
     * from the database.  Corresponds to when client calls home.remove().
     */
    public void ejbRemove() {
    }

}
