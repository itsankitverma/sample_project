/**
 * @(#)CreditCardPaymentVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the credit_card_payment table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class CreditCardPaymentVO implements java.io.Serializable {

    private Integer _creditCardPymtId;
    private double _totalAmt;
    private double _totalReimbursed;
    private String _paymentType;
    private String _paymentDocNbr;
    private String _comments;
    private int _statusId;
    private String _locationCd;
    private String _employeeId;
    private Date _batchDt;
    private String _currencyCd;
    private int _depositSlipId;
    private int _eodId;
    public CreditCardPaymentVO() {
    }
    public CreditCardPaymentVO(Integer creditCardPymtId, double totalAmt, double totalReimbursed, String paymentType, String paymentDocNbr, String comments, int statusId, String locationCd, String employeeId, Date batchDt, String currencyCd, int depositSlipId, int eodId) {
        _creditCardPymtId = creditCardPymtId;
        _totalAmt = totalAmt;
        _totalReimbursed = totalReimbursed;
        _paymentType = paymentType;
        _paymentDocNbr = paymentDocNbr;
        _comments = comments;
        _statusId = statusId;
        _locationCd = locationCd;
        _employeeId = employeeId;
        _batchDt = batchDt;
        _currencyCd = currencyCd;
        _depositSlipId = depositSlipId;
        _eodId = eodId;
    }
    /**
     * Set the value of creditCardPymtId
     */
    public void setCreditCardPymtId(Integer creditCardPymtId) {
        _creditCardPymtId = creditCardPymtId;
    }

    /**
     * Get the value of creditCardPymtId
     */
    public Integer getCreditCardPymtId() {
        return _creditCardPymtId;
    }

    /**
     * Set the value of totalAmt
     */
    public void setTotalAmt(double totalAmt) {
        _totalAmt = totalAmt;
    }

    /**
     * Get the value of totalAmt
     */
    public double getTotalAmt() {
        return _totalAmt;
    }

    /**
     * Set the value of totalReimbursed
     */
    public void setTotalReimbursed(double totalReimbursed) {
        _totalReimbursed = totalReimbursed;
    }

    /**
     * Get the value of totalReimbursed
     */
    public double getTotalReimbursed() {
        return _totalReimbursed;
    }

    /**
     * Set the value of paymentType
     */
    public void setPaymentType(String paymentType) {
        _paymentType = paymentType;
    }

    /**
     * Get the value of paymentType
     */
    public String getPaymentType() {
        return _paymentType;
    }

    /**
     * Set the value of paymentDocNbr
     */
    public void setPaymentDocNbr(String paymentDocNbr) {
        _paymentDocNbr = paymentDocNbr;
    }

    /**
     * Get the value of paymentDocNbr
     */
    public String getPaymentDocNbr() {
        return _paymentDocNbr;
    }

    /**
     * Set the value of comments
     */
    public void setComments(String comments) {
        _comments = comments;
    }

    /**
     * Get the value of comments
     */
    public String getComments() {
        return _comments;
    }

    /**
     * Set the value of statusId
     */
    public void setStatusId(int statusId) {
        _statusId = statusId;
    }

    /**
     * Get the value of statusId
     */
    public int getStatusId() {
        return _statusId;
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
     * Set the value of employeeId
     */
    public void setEmployeeId(String employeeId) {
        _employeeId = employeeId;
    }

    /**
     * Get the value of employeeId
     */
    public String getEmployeeId() {
        return _employeeId;
    }

    /**
     * Set the value of batchDt
     */
    public void setBatchDt(Date batchDt) {
        _batchDt = batchDt;
    }

    /**
     * Get the value of batchDt
     */
    public Date getBatchDt() {
        return _batchDt;
    }

    /**
     * Set the value of currencyCd
     */
    public void setCurrencyCd(String currencyCd) {
        _currencyCd = currencyCd;
    }

    /**
     * Get the value of currencyCd
     */
    public String getCurrencyCd() {
        return _currencyCd;
    }

    /**
     * Set the value of depositSlipId
     */
    public void setDepositSlipId(int depositSlipId) {
        _depositSlipId = depositSlipId;
    }

    /**
     * Get the value of depositSlipId
     */
    public int getDepositSlipId() {
        return _depositSlipId;
    }

    /**
     * Set the value of eodId
     */
    public void setEodId(int eodId) {
        _eodId = eodId;
    }

    /**
     * Get the value of eodId
     */
    public int getEodId() {
        return _eodId;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getCreditCardPaymentPK() {
        return _creditCardPymtId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CreditCardPymtId: " + _creditCardPymtId);
        stringBuffer.append("TotalAmt: " + _totalAmt);
        stringBuffer.append("TotalReimbursed: " + _totalReimbursed);
        stringBuffer.append("PaymentType: " + _paymentType);
        stringBuffer.append("PaymentDocNbr: " + _paymentDocNbr);
        stringBuffer.append("Comments: " + _comments);
        stringBuffer.append("StatusId: " + _statusId);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("EmployeeId: " + _employeeId);
        stringBuffer.append("BatchDt: " + _batchDt);
        stringBuffer.append("CurrencyCd: " + _currencyCd);
        stringBuffer.append("DepositSlipId: " + _depositSlipId);
        stringBuffer.append("EodId: " + _eodId);
        return stringBuffer.toString();
    }

}
