/**
 * @(#)PaymentTypeVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the payment_type table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class PaymentTypeVO implements java.io.Serializable {

    private Integer _paymentTypeId;
    private String _description;
    private String _shtDesc;
    private String _paymentCd;
    private int _rodCombo;
    private int _codCombo;
    private int _ftcCombo;

    private int _prpCombo;
    private int _poaCombo;
    private int _otherCombo;
    private int _canDeact;
    private int _paymentCtgId;
    private int _activePymt;
    private int _gndCombo;
    public PaymentTypeVO() {
    }
    public PaymentTypeVO(Integer paymentTypeId, String description, String shtDesc, String paymentCd, int rodCombo, int prpCombo, int poaCombo, int otherCombo, int canDeact, int paymentCtgId, int activePymt, int gndCombo, int codCombo, int ftcCombo) {
        _paymentTypeId = paymentTypeId;
        _description = description;
        _shtDesc = shtDesc;
        _paymentCd = paymentCd;
        _rodCombo = rodCombo;
        _codCombo = codCombo;
        _ftcCombo = ftcCombo;

        _prpCombo = prpCombo;
        _poaCombo = poaCombo;
        _otherCombo = otherCombo;
        _canDeact = canDeact;
        _paymentCtgId = paymentCtgId;
        _activePymt = activePymt;
        _gndCombo = gndCombo;
    }
    /**
     * Set the value of paymentTypeId
     */
    public void setPaymentTypeId(Integer paymentTypeId) {
        _paymentTypeId = paymentTypeId;
    }

    /**
     * Get the value of paymentTypeId
     */
    public Integer getPaymentTypeId() {
        return _paymentTypeId;
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
     * Set the value of paymentCd
     */
    public void setPaymentCd(String paymentCd) {
        _paymentCd = paymentCd;
    }

    /**
     * Get the value of paymentCd
     */
    public String getPaymentCd() {
        return _paymentCd;
    }

    /**
     * Set the value of rodCombo
     */
    public void setRodCombo(int rodCombo) {
        _rodCombo = rodCombo;
    }

    /**
     * Get the value of rodCombo
     */
    public int getRodCombo() {
        return _rodCombo;
    }


    /**
     * Set the value of codCombo
     */
    public void setCodCombo(int codCombo) {
        _codCombo = codCombo;
    }

    /**
     * Get the value of codCombo
     */
    public int getCodCombo() {
        return _codCombo;
    }

    /**
     * Set the value of ftcCombo
     */
    public void setFtcCombo(int ftcCombo) {
        _ftcCombo = ftcCombo;
    }

    /**
     * Get the value of ftcCombo
     */
    public int getFtcCombo() {
        return _ftcCombo;
    }
    
    
    /**
     * Set the value of prpCombo
     */
    public void setPrpCombo(int prpCombo) {
        _prpCombo = prpCombo;
    }

    /**
     * Get the value of prpCombo
     */
    public int getPrpCombo() {
        return _prpCombo;
    }

    /**
     * Set the value of poaCombo
     */
    public void setPoaCombo(int poaCombo) {
        _poaCombo = poaCombo;
    }

    /**
     * Get the value of poaCombo
     */
    public int getPoaCombo() {
        return _poaCombo;
    }

    /**
     * Set the value of otherCombo
     */
    public void setOtherCombo(int otherCombo) {
        _otherCombo = otherCombo;
    }

    /**
     * Get the value of otherCombo
     */
    public int getOtherCombo() {
        return _otherCombo;
    }

    /**
     * Set the value of canDeact
     */
    public void setCanDeact(int canDeact) {
        _canDeact = canDeact;
    }

    /**
     * Get the value of canDeact
     */
    public int getCanDeact() {
        return _canDeact;
    }

    /**
     * Set the value of paymentCtgId
     */
    public void setPaymentCtgId(int paymentCtgId) {
        _paymentCtgId = paymentCtgId;
    }

    /**
     * Get the value of paymentCtgId
     */
    public int getPaymentCtgId() {
        return _paymentCtgId;
    }

    /**
     * Set the value of activePymt
     */
    public void setActivePymt(int activePymt) {
        _activePymt = activePymt;
    }

    /**
     * Get the value of activePymt
     */
    public int getActivePymt() {
        return _activePymt;
    }

    /**
     * Set the value of gndCombo
     */
    public void setGndCombo(int gndCombo) {
        _gndCombo = gndCombo;
    }

    /**
     * Get the value of gndCombo
     */
    public int getGndCombo() {
        return _gndCombo;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getPaymentTypePK() {
        return _paymentTypeId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PaymentTypeId: " + _paymentTypeId);
        stringBuffer.append("Description: " + _description);
        stringBuffer.append("ShtDesc: " + _shtDesc);
        stringBuffer.append("PaymentCd: " + _paymentCd);
        stringBuffer.append("RodCombo: " + _rodCombo);
        stringBuffer.append("CodCombo: " + _codCombo);
        stringBuffer.append("FtcCombo: " + _ftcCombo);

        stringBuffer.append("PrpCombo: " + _prpCombo);
        stringBuffer.append("PoaCombo: " + _poaCombo);
        stringBuffer.append("OtherCombo: " + _otherCombo);
        stringBuffer.append("CanDeact: " + _canDeact);
        stringBuffer.append("PaymentCtgId: " + _paymentCtgId);
        stringBuffer.append("ActivePymt: " + _activePymt);
        stringBuffer.append("GndCombo: " + _gndCombo);
        return stringBuffer.toString();
    }

}
