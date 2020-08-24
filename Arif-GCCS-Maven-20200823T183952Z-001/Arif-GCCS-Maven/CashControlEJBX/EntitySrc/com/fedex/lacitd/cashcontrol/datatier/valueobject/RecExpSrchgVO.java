/**
 * @(#)RecExpSrchgVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the rec_exp_srchg table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class RecExpSrchgVO implements java.io.Serializable {

    private Integer _recId;
    private String _surchargeCd;
    private double _appliedAmt;
    public RecExpSrchgVO() {
    }
    public RecExpSrchgVO(Integer recId, String surchargeCd, double appliedAmt) {
        _recId = recId;
        _surchargeCd = surchargeCd;
        _appliedAmt = appliedAmt;
    }
    /**
     * Set the value of recId
     */
    public void setRecId(Integer recId) {
        _recId = recId;
    }

    /**
     * Get the value of recId
     */
    public Integer getRecId() {
        return _recId;
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
    public RecExpSrchgPK getRecExpSrchgPK() {
        return new RecExpSrchgPK(_recId, _surchargeCd);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RecId: " + _recId);
        stringBuffer.append("SurchargeCd: " + _surchargeCd);
        stringBuffer.append("AppliedAmt: " + _appliedAmt);
        return stringBuffer.toString();
    }

}
