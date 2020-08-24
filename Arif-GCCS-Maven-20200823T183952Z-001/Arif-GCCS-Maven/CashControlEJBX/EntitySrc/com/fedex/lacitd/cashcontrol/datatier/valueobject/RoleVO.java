/**
 * @(#)RoleVO.java			Tue Aug 02 15:38:50 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class RoleVO implements java.io.Serializable {

    private Integer _roleId;
    private String _role;
    private String _description;
    public RoleVO() {
    }
    public RoleVO(Integer roleId, String role, String description) {
        _roleId = roleId;
        _role = role;
        _description = description;
    }
    /**
     * Set the value of roleId
     */
    public void setRoleId(Integer roleId) {
        _roleId = roleId;
    }

    /**
     * Get the value of roleId
     */
    public Integer getRoleId() {
        return _roleId;
    }

    /**
     * Set the value of role
     */
    public void setRole(String role) {
        _role = role;
    }

    /**
     * Get the value of role
     */
    public String getRole() {
        return _role;
    }

    /**
     * Set the value of description
     */
    public void setDescription(String description) {
        _description = description;
    }

    /**
     * Get the value of description
     */
    public String getDescription() {
        return _description;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getRolePK() {
        return _roleId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RoleId: " + _roleId);
        stringBuffer.append("Role: " + _role);
        stringBuffer.append("Description: " + _description);
        return stringBuffer.toString();
    }

}
