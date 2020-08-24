/**
 * @(#)GlExchRateVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the gl_exch_rate table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class GlExchRateVO implements java.io.Serializable {

    private String _currCd;
    private Date _perdDt;
    private double _avgExchRtAmt;
    private double _curExchRtAmt;
    public GlExchRateVO() {
    }
    public GlExchRateVO(String currCd, Date perdDt, double avgExchRtAmt, double curExchRtAmt) {
        _currCd = currCd;
        _perdDt = perdDt;
        _avgExchRtAmt = avgExchRtAmt;
        _curExchRtAmt = curExchRtAmt;
    }
    /**
     * Set the value of currCd
     */
    public void setCurrCd(String currCd) {
        _currCd = currCd;
    }

    /**
     * Get the value of currCd
     */
    public String getCurrCd() {
        return _currCd;
    }

    /**
     * Set the value of perdDt
     */
    public void setPerdDt(Date perdDt) {
        _perdDt = perdDt;
    }

    /**
     * Get the value of perdDt
     */
    public Date getPerdDt() {
        return _perdDt;
    }

    /**
     * Set the value of avgExchRtAmt
     */
    public void setAvgExchRtAmt(double avgExchRtAmt) {
        _avgExchRtAmt = avgExchRtAmt;
    }

    /**
     * Get the value of avgExchRtAmt
     */
    public double getAvgExchRtAmt() {
        return _avgExchRtAmt;
    }

    /**
     * Set the value of curExchRtAmt
     */
    public void setCurExchRtAmt(double curExchRtAmt) {
        _curExchRtAmt = curExchRtAmt;
    }

    /**
     * Get the value of curExchRtAmt
     */
    public double getCurExchRtAmt() {
        return _curExchRtAmt;
    }

    /**
     * Get the value of the primary key
     */
    public GlExchRatePK getGlExchRatePK() {
        return new GlExchRatePK(_currCd, _perdDt);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CurrCd: " + _currCd);
        stringBuffer.append("PerdDt: " + _perdDt);
        stringBuffer.append("AvgExchRtAmt: " + _avgExchRtAmt);
        stringBuffer.append("CurExchRtAmt: " + _curExchRtAmt);
        return stringBuffer.toString();
    }

}
