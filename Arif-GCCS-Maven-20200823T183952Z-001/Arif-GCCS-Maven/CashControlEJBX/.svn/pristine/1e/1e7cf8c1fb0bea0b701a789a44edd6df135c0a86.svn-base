/**
 * @(#)PoaDetailVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the poa_detail table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class PoaDetailVO implements java.io.Serializable {

    private Integer _poaDetailId;
    private int _poaPaymentsId;
    private String _invoiceNbr;
    private double _amount;
    private double _couponAmt;
    private String _invCurrency;
    private double _exchRate;
    public PoaDetailVO() {
    }
    public PoaDetailVO(Integer poaDetailId, int poaPaymentsId, String invoiceNbr, double amount, double couponAmt, String invCurrency, double exchRate) {
        _poaDetailId = poaDetailId;
        _poaPaymentsId = poaPaymentsId;
        _invoiceNbr = invoiceNbr;
        _amount = amount;
        _couponAmt = couponAmt;
        _invCurrency = invCurrency;
        _exchRate = exchRate;
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
     * Set the value of poaPaymentsId
     */
    public void setPoaPaymentsId(int poaPaymentsId) {
        _poaPaymentsId = poaPaymentsId;
    }

    /**
     * Get the value of poaPaymentsId
     */
    public int getPoaPaymentsId() {
        return _poaPaymentsId;
    }

    /**
     * Set the value of invoiceNbr
     */
    public void setInvoiceNbr(String invoiceNbr) {
        _invoiceNbr = invoiceNbr;
    }

    /**
     * Get the value of invoiceNbr
     */
    public String getInvoiceNbr() {
        return _invoiceNbr;
    }

    /**
     * Set the value of amount
     */
    public void setAmount(double amount) {
        _amount = amount;
    }

    /**
     * Get the value of amount
     */
    public double getAmount() {
        return _amount;
    }

    /**
     * Set the value of couponAmt
     */
    public void setCouponAmt(double couponAmt) {
        _couponAmt = couponAmt;
    }

    /**
     * Get the value of couponAmt
     */
    public double getCouponAmt() {
        return _couponAmt;
    }

    /**
     * Set the value of invCurrency
     */
    public void setInvCurrency(String invCurrency) {
        _invCurrency = invCurrency;
    }

    /**
     * Get the value of invCurrency
     */
    public String getInvCurrency() {
        return _invCurrency;
    }

    /**
     * Set the value of exchRate
     */
    public void setExchRate(double exchRate) {
        _exchRate = exchRate;
    }

    /**
     * Get the value of exchRate
     */
    public double getExchRate() {
        return _exchRate;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getPoaDetailPK() {
        return _poaDetailId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PoaDetailId: " + _poaDetailId);
        stringBuffer.append("PoaPaymentsId: " + _poaPaymentsId);
        stringBuffer.append("InvoiceNbr: " + _invoiceNbr);
        stringBuffer.append("Amount: " + _amount);
        stringBuffer.append("CouponAmt: " + _couponAmt);
        stringBuffer.append("InvCurrency: " + _invCurrency);
        stringBuffer.append("ExchRate: " + _exchRate);
        return stringBuffer.toString();
    }

}
