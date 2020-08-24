/**
 * @(#)EodVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the eod table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class EodVO implements java.io.Serializable {

    private Integer _eodId;
    private String _locationCd;
    private Date _eodDt;
    private String _employeeId;
    public EodVO() {
    }
    public EodVO(Integer eodId, String locationCd, Date eodDt, String employeeId) {
        _eodId = eodId;
        _locationCd = locationCd;
        _eodDt = eodDt;
        _employeeId = employeeId;
    }
    /**
     * Set the value of eodId
     */
    public void setEodId(Integer eodId) {
        _eodId = eodId;
    }

    /**
     * Get the value of eodId
     */
    public Integer getEodId() {
        return _eodId;
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
     * Set the value of eodDt
     */
    public void setEodDt(Date eodDt) {
        _eodDt = eodDt;
    }

    /**
     * Get the value of eodDt
     */
    public Date getEodDt() {
        return _eodDt;
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
    public Integer getEodPK() {
        return _eodId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EodId: " + _eodId);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("EodDt: " + _eodDt);
        stringBuffer.append("EmployeeId: " + _employeeId);
        return stringBuffer.toString();
    }

}
