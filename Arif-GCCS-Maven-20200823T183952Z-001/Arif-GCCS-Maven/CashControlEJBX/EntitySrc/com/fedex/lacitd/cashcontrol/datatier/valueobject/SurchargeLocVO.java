/**
 * @(#)SurchargeLocVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the surcharge_loc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class SurchargeLocVO implements java.io.Serializable {

    private String _surchargeCd;
    private String _locationCd;
    private int _applyRod;
    private int _applyPrepaid;
    private int _applyPoa;
    private int _applyOrder;
    private int _disabSurcharge;
    public SurchargeLocVO() {
    }
    public SurchargeLocVO(String surchargeCd, String locationCd, int applyRod, int applyPrepaid, int applyPoa, int applyOrder, int disabSurcharge) {
        _surchargeCd = surchargeCd;
        _locationCd = locationCd;
        _applyRod = applyRod;
        _applyPrepaid = applyPrepaid;
        _applyPoa = applyPoa;
        _applyOrder = applyOrder;
        _disabSurcharge = disabSurcharge;
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
     * Set the value of applyRod
     */
    public void setApplyRod(int applyRod) {
        _applyRod = applyRod;
    }

    /**
     * Get the value of applyRod
     */
    public int getApplyRod() {
        return _applyRod;
    }

    /**
     * Set the value of applyPrepaid
     */
    public void setApplyPrepaid(int applyPrepaid) {
        _applyPrepaid = applyPrepaid;
    }

    /**
     * Get the value of applyPrepaid
     */
    public int getApplyPrepaid() {
        return _applyPrepaid;
    }

    /**
     * Set the value of applyPoa
     */
    public void setApplyPoa(int applyPoa) {
        _applyPoa = applyPoa;
    }

    /**
     * Get the value of applyPoa
     */
    public int getApplyPoa() {
        return _applyPoa;
    }

    /**
     * Set the value of applyOrder
     */
    public void setApplyOrder(int applyOrder) {
        _applyOrder = applyOrder;
    }

    /**
     * Get the value of applyOrder
     */
    public int getApplyOrder() {
        return _applyOrder;
    }

    /**
     * Set the value of disabSurcharge
     */
    public void setDisabSurcharge(int disabSurcharge) {
        _disabSurcharge = disabSurcharge;
    }

    /**
     * Get the value of disabSurcharge
     */
    public int getDisabSurcharge() {
        return _disabSurcharge;
    }

    /**
     * Get the value of the primary key
     */
    public SurchargeLocPK getSurchargeLocPK() {
        return new SurchargeLocPK(_surchargeCd, _locationCd);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SurchargeCd: " + _surchargeCd);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("ApplyRod: " + _applyRod);
        stringBuffer.append("ApplyPrepaid: " + _applyPrepaid);
        stringBuffer.append("ApplyPoa: " + _applyPoa);
        stringBuffer.append("ApplyOrder: " + _applyOrder);
        stringBuffer.append("DisabSurcharge: " + _disabSurcharge);
        return stringBuffer.toString();
    }

}
