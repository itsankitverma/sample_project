/**
 * @(#)EmpXLocationXRoleVO.java			Tue Aug 02 15:38:50 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class EmpXLocationXRoleVO implements java.io.Serializable {

    private Integer _roleId;
    private String _locationCd;
    private String _employeeId;
    public EmpXLocationXRoleVO() {
    }
    public EmpXLocationXRoleVO(Integer roleId, String locationCd, String employeeId) {
        _roleId = roleId;
        _locationCd = locationCd;
        _employeeId = employeeId;
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
     * Set the value of locationCd
     */
    public void setLocationCd(String locationCd) {
        _locationCd = locationCd;
    }

    /**
     * Get the value of locationCd
     */
    public String getLocationCd() {
        return _locationCd;
    }

    /**
     * Set the value of employeeId
     */
    public void setEmployeeId(String employeeId) {
        _employeeId = employeeId;
    }

    /**
     * Get the value of employeeId
     */
    public String getEmployeeId() {
        return _employeeId;
    }

    /**
     * Get the value of the primary key
     */
    public EmpXLocationXRolePK getEmpXLocationXRolePK() {
        return new EmpXLocationXRolePK(_roleId, _locationCd, _employeeId);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RoleId: " + _roleId);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("EmployeeId: " + _employeeId);
        return stringBuffer.toString();
    }

}
