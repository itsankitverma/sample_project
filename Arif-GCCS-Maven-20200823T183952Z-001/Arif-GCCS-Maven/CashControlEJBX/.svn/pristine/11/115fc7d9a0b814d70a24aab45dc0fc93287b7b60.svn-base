/**
 * @(#)PrepSurchargesVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the prep_surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class PrepSurchargesVO implements java.io.Serializable {

    private Integer _prepaidId;
    private String _surchargeCd;
    private double _appliedAmt;
    public PrepSurchargesVO() {
    }
    public PrepSurchargesVO(Integer prepaidId, String surchargeCd, double appliedAmt) {
        _prepaidId = prepaidId;
        _surchargeCd = surchargeCd;
        _appliedAmt = appliedAmt;
    }
    /**
     * Set the value of prepaidId
     */
    public void setPrepaidId(Integer prepaidId) {
        _prepaidId = prepaidId;
    }

    /**
     * Get the value of prepaidId
     */
    public Integer getPrepaidId() {
        return _prepaidId;
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
     * Set the value of appliedAmt
     */
    public void setAppliedAmt(double appliedAmt) {
        _appliedAmt = appliedAmt;
    }

    /**
     * Get the value of appliedAmt
     */
    public double getAppliedAmt() {
        return _appliedAmt;
    }

    /**
     * Get the value of the primary key
     */
    public PrepSurchargesPK getPrepSurchargesPK() {
        return new PrepSurchargesPK(_prepaidId, _surchargeCd);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PrepaidId: " + _prepaidId);
        stringBuffer.append("SurchargeCd: " + _surchargeCd);
        stringBuffer.append("AppliedAmt: " + _appliedAmt);
        return stringBuffer.toString();
    }

}
