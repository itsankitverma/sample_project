/**
 * @(#)InCageExceptionsVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the in_cage_exceptions table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class InCageExceptionsVO implements java.io.Serializable {

    private Integer _inCageExcpId;
    private String _locationCd;
    private Date _reportDt;
    private String _awbNbr;
    private String _lastDexEmpId;
    private String _lastStat44EmpId;
    private String _description;
    public InCageExceptionsVO() {
    }
    public InCageExceptionsVO(Integer inCageExcpId, String locationCd, Date reportDt, String awbNbr, String lastDexEmpId, String lastStat44EmpId, String description) {
        _inCageExcpId = inCageExcpId;
        _locationCd = locationCd;
        _reportDt = reportDt;
        _awbNbr = awbNbr;
        _lastDexEmpId = lastDexEmpId;
        _lastStat44EmpId = lastStat44EmpId;
        _description = description;
    }
    /**
     * Set the value of inCageExcpId
     */
    public void setInCageExcpId(Integer inCageExcpId) {
        _inCageExcpId = inCageExcpId;
    }

    /**
     * Get the value of inCageExcpId
     */
    public Integer getInCageExcpId() {
        return _inCageExcpId;
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
     * Set the value of reportDt
     */
    public void setReportDt(Date reportDt) {
        _reportDt = reportDt;
    }

    /**
     * Get the value of reportDt
     */
    public Date getReportDt() {
        return _reportDt;
    }

    /**
     * Set the value of awbNbr
     */
    public void setAwbNbr(String awbNbr) {
        _awbNbr = awbNbr;
    }

    /**
     * Get the value of awbNbr
     */
    public String getAwbNbr() {
        return _awbNbr;
    }

    /**
     * Set the value of lastDexEmpId
     */
    public void setLastDexEmpId(String lastDexEmpId) {
        _lastDexEmpId = lastDexEmpId;
    }

    /**
     * Get the value of lastDexEmpId
     */
    public String getLastDexEmpId() {
        return _lastDexEmpId;
    }

    /**
     * Set the value of lastStat44EmpId
     */
    public void setLastStat44EmpId(String lastStat44EmpId) {
        _lastStat44EmpId = lastStat44EmpId;
    }

    /**
     * Get the value of lastStat44EmpId
     */
    public String getLastStat44EmpId() {
        return _lastStat44EmpId;
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
    public Integer getInCageExceptionsPK() {
        return _inCageExcpId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InCageExcpId: " + _inCageExcpId);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("ReportDt: " + _reportDt);
        stringBuffer.append("AwbNbr: " + _awbNbr);
        stringBuffer.append("LastDexEmpId: " + _lastDexEmpId);
        stringBuffer.append("LastStat44EmpId: " + _lastStat44EmpId);
        stringBuffer.append("Description: " + _description);
        return stringBuffer.toString();
    }

}
