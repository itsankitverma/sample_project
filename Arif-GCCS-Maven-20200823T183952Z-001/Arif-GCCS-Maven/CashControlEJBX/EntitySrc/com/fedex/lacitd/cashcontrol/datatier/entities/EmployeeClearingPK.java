/**
 * @(#)EmployeeClearingPK.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the employee_clearing table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class EmployeeClearingPK implements Serializable {

    private transient int _hashCode = -1;
    public String employeeId;
    public Date empClearDt;
    public EmployeeClearingPK() {
    }
    public EmployeeClearingPK(String employeeId, Date empClearDt) {
        this.employeeId = employeeId;
        this.empClearDt = empClearDt;
    }
    /**
     * Returns the EmployeeClearing's employeeId.
     * @return String the EmployeeClearing's employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the EmployeeClearing's employeeId.
     */
    public void setEmployeeId(String employeeId) {
        employeeId = employeeId;
    }

    /**
     * Returns the EmployeeClearing's empClearDt.
     * @return Date the EmployeeClearing's empClearDt
     */
    public Date getEmpClearDt() {
        return empClearDt;
    }

    /**
     * Sets the EmployeeClearing's empClearDt.
     */
    public void setEmpClearDt(Date empClearDt) {
        empClearDt = empClearDt;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (employeeId.hashCode()) ^ (empClearDt.hashCode());
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
            EmployeeClearingPK rhs =(EmployeeClearingPK) other;
            return (employeeId.equals(rhs.employeeId) && 
				empClearDt.equals(rhs.empClearDt));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
