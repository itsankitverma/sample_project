/**
 * @(#)EmployeeClearingVO.java			Tue Aug 02 15:38:50 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class EmployeeClearingVO implements java.io.Serializable {

    private String _employeeId;
    private Date _empClearDt;
    private int _empClearStatus;
    public EmployeeClearingVO() {
    }
    public EmployeeClearingVO(String employeeId, Date empClearDt, int empClearStatus) {
        _employeeId = employeeId;
        _empClearDt = empClearDt;
        _empClearStatus = empClearStatus;
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
     * Set the value of empClearDt
     */
    public void setEmpClearDt(Date empClearDt) {
        _empClearDt = empClearDt;
    }

    /**
     * Get the value of empClearDt
     */
    public Date getEmpClearDt() {
        return _empClearDt;
    }

    /**
     * Set the value of empClearStatus
     */
    public void setEmpClearStatus(int empClearStatus) {
        _empClearStatus = empClearStatus;
    }

    /**
     * Get the value of empClearStatus
     */
    public int getEmpClearStatus() {
        return _empClearStatus;
    }

    /**
     * Get the value of the primary key
     */
    public EmployeeClearingPK getEmployeeClearingPK() {
        return new EmployeeClearingPK(_employeeId, _empClearDt);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EmployeeId: " + _employeeId);
        stringBuffer.append("EmpClearDt: " + _empClearDt);
        stringBuffer.append("EmpClearStatus: " + _empClearStatus);
        return stringBuffer.toString();
    }

}
