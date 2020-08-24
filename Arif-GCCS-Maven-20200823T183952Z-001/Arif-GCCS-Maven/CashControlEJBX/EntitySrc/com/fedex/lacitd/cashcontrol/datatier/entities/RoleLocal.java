/**
 * @(#)RoleLocal.java			Tue Aug 02 15:38:49 VET 2005
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

public interface RoleLocal extends EJBLocalObject {

    /**
     * Set the value of roleId
     * @param roleId - Integer of roleId
     */
    public void setRoleId(Integer roleId);

    /**
     * Get the value of roleId
     * @return roleId - Integer of roleId
     */
    public Integer getRoleId();

    /**
     * Set the value of role
     * @param role - String of role
     */
    public void setRole(String role);

    /**
     * Get the value of role
     * @return role - String of role
     */
    public String getRole();

    /**
     * Set the value of description
     * @param description - String of description
     */
    public void setDescription(String description);

    /**
     * Get the value of description
     * @return description - String of description
     */
    public String getDescription();

}
