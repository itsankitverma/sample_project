/**
 * @(#)PoaSurchargesVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the poa_surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class PoaSurchargesVO implements java.io.Serializable {

    private Integer _poaDetailId;
    private String _surchargeCd;
    private double _appliedAmt;
    public PoaSurchargesVO() {
    }
    public PoaSurchargesVO(Integer poaDetailId, String surchargeCd, double appliedAmt) {
        _poaDetailId = poaDetailId;
        _surchargeCd = surchargeCd;
        _appliedAmt = appliedAmt;
    }
    /**
     * Set the value of poaDetailId
     */
    public void setPoaDetailId(Integer poaDetailId) {
        _poaDetailId = poaDetailId;
    }

    /**
     * Get the value of poaDetailId
     */
    public Integer getPoaDetailId() {
        return _poaDetailId;
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
    public PoaSurchargesPK getPoaSurchargesPK() {
        return new PoaSurchargesPK(_poaDetailId, _surchargeCd);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PoaDetailId: " + _poaDetailId);
        stringBuffer.append("SurchargeCd: " + _surchargeCd);
        stringBuffer.append("AppliedAmt: " + _appliedAmt);
        return stringBuffer.toString();
    }

}
