/**
 * @(#)PreStatusVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the pre_status table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class PreStatusVO implements java.io.Serializable {

    private Integer _statusIdNbr;
    private String _statusDesc;
    private int _prePgFlg;
    public PreStatusVO() {
    }
    public PreStatusVO(Integer statusIdNbr, String statusDesc, int prePgFlg) {
        _statusIdNbr = statusIdNbr;
        _statusDesc = statusDesc;
        _prePgFlg = prePgFlg;
    }
    /**
     * Set the value of statusIdNbr
     */
    public void setStatusIdNbr(Integer statusIdNbr) {
        _statusIdNbr = statusIdNbr;
    }

    /**
     * Get the value of statusIdNbr
     */
    public Integer getStatusIdNbr() {
        return _statusIdNbr;
    }

    /**
     * Set the value of statusDesc
     */
    public void setStatusDesc(String statusDesc) {
        _statusDesc = statusDesc;
    }

    /**
     * Get the value of statusDesc
     */
    public String getStatusDesc() {
        return _statusDesc;
    }

    /**
     * Set the value of prePgFlg
     */
    public void setPrePgFlg(int prePgFlg) {
        _prePgFlg = prePgFlg;
    }

    /**
     * Get the value of prePgFlg
     */
    public int getPrePgFlg() {
        return _prePgFlg;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getPreStatusPK() {
        return _statusIdNbr;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StatusIdNbr: " + _statusIdNbr);
        stringBuffer.append("StatusDesc: " + _statusDesc);
        stringBuffer.append("PrePgFlg: " + _prePgFlg);
        return stringBuffer.toString();
    }

}
