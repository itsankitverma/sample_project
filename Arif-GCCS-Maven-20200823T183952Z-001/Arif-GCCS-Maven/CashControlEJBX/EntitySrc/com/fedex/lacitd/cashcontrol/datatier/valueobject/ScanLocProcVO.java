/**
 * @(#)ScanLocProcVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the scan_loc_proc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class ScanLocProcVO implements java.io.Serializable {

    private Integer _scanLocProcId;
    private String _locationCd;
    private Date _procDate;
    private int _result;
    public ScanLocProcVO() {
    }
    public ScanLocProcVO(Integer scanLocProcId, String locationCd, Date procDate, int result) {
        _scanLocProcId = scanLocProcId;
        _locationCd = locationCd;
        _procDate = procDate;
        _result = result;
    }
    /**
     * Set the value of scanLocProcId
     */
    public void setScanLocProcId(Integer scanLocProcId) {
        _scanLocProcId = scanLocProcId;
    }

    /**
     * Get the value of scanLocProcId
     */
    public Integer getScanLocProcId() {
        return _scanLocProcId;
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
     * Set the value of procDate
     */
    public void setProcDate(Date procDate) {
        _procDate = procDate;
    }

    /**
     * Get the value of procDate
     */
    public Date getProcDate() {
        return _procDate;
    }

    /**
     * Set the value of result
     */
    public void setResult(int result) {
        _result = result;
    }

    /**
     * Get the value of result
     */
    public int getResult() {
        return _result;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getScanLocProcPK() {
        return _scanLocProcId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ScanLocProcId: " + _scanLocProcId);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("ProcDate: " + _procDate);
        stringBuffer.append("Result: " + _result);
        return stringBuffer.toString();
    }

}
