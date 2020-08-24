/**
 * @(#)EmpXLocationXRolePK.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the emp_x_location_x_role table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class EmpXLocationXRolePK implements Serializable {

    private transient int _hashCode = -1;
    public Integer roleId;
    public String locationCd;
    public String employeeId;
    public EmpXLocationXRolePK() {
    }
    public EmpXLocationXRolePK(Integer roleId, String locationCd, String employeeId) {
        this.roleId = roleId;
        this.locationCd = locationCd;
        this.employeeId = employeeId;
    }
    /**
     * Returns the EmpXLocationXRole's roleId.
     * @return Integer the EmpXLocationXRole's roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Sets the EmpXLocationXRole's roleId.
     */
    public void setRoleId(Integer roleId) {
        roleId = roleId;
    }

    /**
     * Returns the EmpXLocationXRole's locationCd.
     * @return String the EmpXLocationXRole's locationCd
     */
    public String getLocationCd() {
        return locationCd;
    }

    /**
     * Sets the EmpXLocationXRole's locationCd.
     */
    public void setLocationCd(String locationCd) {
        locationCd = locationCd;
    }

    /**
     * Returns the EmpXLocationXRole's employeeId.
     * @return String the EmpXLocationXRole's employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the EmpXLocationXRole's employeeId.
     */
    public void setEmployeeId(String employeeId) {
        employeeId = employeeId;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (roleId.hashCode()) ^ (locationCd.hashCode()) ^ (employeeId.hashCode());
		}
		return _hashCode;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     */
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.hashCode() != hashCode()) return false;
        try {
            EmpXLocationXRolePK rhs =(EmpXLocationXRolePK) other;
            return (roleId.equals(rhs.roleId) && 
				locationCd.equals(rhs.locationCd) && 
				employeeId.equals(rhs.employeeId));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
