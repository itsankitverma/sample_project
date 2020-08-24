/**
 * @(#)SurchargesVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class SurchargesVO implements java.io.Serializable {

    private String _surchargeCd;
    private String _shtDesc;
    public SurchargesVO() {
    }
    public SurchargesVO(String surchargeCd, String shtDesc) {
        _surchargeCd = surchargeCd;
        _shtDesc = shtDesc;
    }
    /**
     * Set the value of surchargeCd
     */
    public void setSurchargeCd(String surchargeCd) {
        _surchargeCd = surchargeCd;
    }

    /**
     * Get the value of surchargeCd
     */
    public String getSurchargeCd() {
        return _surchargeCd;
    }

    /**
     * Set the value of shtDesc
     */
    public void setShtDesc(String shtDesc) {
        _shtDesc = shtDesc;
    }

    /**
     * Get the value of shtDesc
     */
    public String getShtDesc() {
        return _shtDesc;
    }

    /**
     * Get the value of the primary key
     */
    public String getSurchargesPK() {
        return _surchargeCd;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SurchargeCd: " + _surchargeCd);
        stringBuffer.append("ShtDesc: " + _shtDesc);
        return stringBuffer.toString();
    }

}
