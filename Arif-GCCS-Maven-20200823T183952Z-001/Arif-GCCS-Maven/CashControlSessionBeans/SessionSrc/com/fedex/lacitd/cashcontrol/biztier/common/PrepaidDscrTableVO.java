/**
 * @(#)PrepaidDscrVO.java			Mon May 19 11:20:06 VET 2003
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
 * This bean map to the prepaid_dscr table
 * 
 * @author Cristian C?enas
 * @version 1.0
 */
package com.fedex.lacitd.cashcontrol.biztier.common;

import java.util.Date;

public class PrepaidDscrTableVO implements java.io.Serializable {

    private Integer _prepaidDscrId;
    private Date _processDt;
    private String _locationCd;
    private String _awbNbr;
    private String _courierId;
    private String _paymentCurrency;
    private double _freightAmtInVisa;
    private String _discrepancyFound;
    private double _discrepancyAmt;
    private double _exchRate;
    private String _discrepancyRsn;
    private Date _shipDate;
    private double _pux16Amount;
    private double _couponAmount;
    private String _comments;

    /**
     * Holds value of property statusId.
     */
    private int statusId;

    /**
     * Holds value of property statusIdPrev.
     */
    private int statusIdPrev;

    /**
     * Holds value of property commentsPrev.
     */
    private String commentsPrev;

    public PrepaidDscrTableVO() {
    }

    public PrepaidDscrTableVO(Integer prepaidDscrId, Date processDt, String locationCd, String awbNbr, String courierId, String paymentCurrency, double freightAmtInVisa, String discrepancyFound, double discrepancyAmt, double exchRate, String discrepancyRsn, Date shipDate, double pux16Amount, double couponAmount, String comments) {
        _prepaidDscrId = prepaidDscrId;
        _processDt = processDt;
        _locationCd = locationCd;
        _awbNbr = awbNbr;
        _courierId = courierId;
        _paymentCurrency = paymentCurrency;
        _freightAmtInVisa = freightAmtInVisa;
        _discrepancyFound = discrepancyFound;
        _discrepancyAmt = discrepancyAmt;
        _exchRate = exchRate;
        _discrepancyRsn = discrepancyRsn;
        _shipDate = shipDate;
        _pux16Amount = pux16Amount;
        _couponAmount = couponAmount;
        _comments = comments;
    }

    /**
     * Set the value of prepaidDscrId
     */
    public void setPrepaidDscrId(Integer prepaidDscrId) {
        _prepaidDscrId = prepaidDscrId;
    }

    /**
     * Get the value of prepaidDscrId
     */
    public Integer getPrepaidDscrId() {
        return _prepaidDscrId;
    }

    /**
     * Set the value of processDt
     */
    public void setProcessDt(Date processDt) {
        _processDt = processDt;
    }

    /**
     * Get the value of processDt
     */
    public Date getProcessDt() {
        return _processDt;
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
     * Set the value of awbNbr
     */
    public void setAwbNbr(String awbNbr) {
        _awbNbr = awbNbr;
    }

    /**
     * Get the value of awbNbr
     */
    public String getAwbNbr() {
        return _awbNbr;
    }

    /**
     * Set the value of courierId
     */
    public void setCourierId(String courierId) {
        _courierId = courierId;
    }

    /**
     * Get the value of courierId
     */
    public String getCourierId() {
        return _courierId;
    }

    /**
     * Set the value of paymentCurrency
     */
    public void setPaymentCurrency(String paymentCurrency) {
        _paymentCurrency = paymentCurrency;
    }

    /**
     * Get the value of paymentCurrency
     */
    public String getPaymentCurrency() {
        return _paymentCurrency;
    }

    /**
     * Set the value of freightAmtInVisa
     */
    public void setFreightAmtInVisa(double freightAmtInVisa) {
        _freightAmtInVisa = freightAmtInVisa;
    }

    /**
     * Get the value of freightAmtInVisa
     */
    public double getFreightAmtInVisa() {
        return _freightAmtInVisa;
    }

    /**
     * Set the value of discrepancyFound
     */
    public void setDiscrepancyFound(String discrepancyFound) {
        _discrepancyFound = discrepancyFound;
    }

    /**
     * Get the value of discrepancyFound
     */
    public String getDiscrepancyFound() {
        return _discrepancyFound;
    }

    /**
     * Set the value of discrepancyAmt
     */
    public void setDiscrepancyAmt(double discrepancyAmt) {
        _discrepancyAmt = discrepancyAmt;
    }

    /**
     * Get the value of discrepancyAmt
     */
    public double getDiscrepancyAmt() {
        return _discrepancyAmt;
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
     * Set the value of discrepancyRsn
     */
    public void setDiscrepancyRsn(String discrepancyRsn) {
        _discrepancyRsn = discrepancyRsn;
    }

    /**
     * Get the value of discrepancyRsn
     */
    public String getDiscrepancyRsn() {
        return _discrepancyRsn;
    }

    /**
     * Set the value of shipDate
     */
    public void setShipDate(Date shipDate) {
        _shipDate = shipDate;
    }

    /**
     * Get the value of shipDate
     */
    public Date getShipDate() {
        return _shipDate;
    }

    /**
     * Set the value of pux16Amount
     */
    public void setPux16Amount(double pux16Amount) {
        _pux16Amount = pux16Amount;
    }

    /**
     * Get the value of pux16Amount
     */
    public double getPux16Amount() {
        return _pux16Amount;
    }

    /**
     * Set the value of couponAmount
     */
    public void setCouponAmount(double couponAmount) {
        _couponAmount = couponAmount;
    }

    /**
     * Get the value of couponAmount
     */
    public double getCouponAmount() {
        return _couponAmount;
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
     * Get the value of the primary key
     */
    public Integer getPrepaidDscrPK() {
        return _prepaidDscrId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PrepaidDscrId: " + _prepaidDscrId);
        stringBuffer.append("ProcessDt: " + _processDt);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("AwbNbr: " + _awbNbr);
        stringBuffer.append("CourierId: " + _courierId);
        stringBuffer.append("PaymentCurrency: " + _paymentCurrency);
        stringBuffer.append("FreightAmtInVisa: " + _freightAmtInVisa);
        stringBuffer.append("DiscrepancyFound: " + _discrepancyFound);
        stringBuffer.append("DiscrepancyAmt: " + _discrepancyAmt);
        stringBuffer.append("ExchRate: " + _exchRate);
        stringBuffer.append("DiscrepancyRsn: " + _discrepancyRsn);
        stringBuffer.append("ShipDate: " + _shipDate);
        stringBuffer.append("Pux16Amount: " + _pux16Amount);
        stringBuffer.append("CouponAmount: " + _couponAmount);
        stringBuffer.append("Comments: " + _comments);
        return stringBuffer.toString();
    }

    /**
     * Getter for property statusId.
     *
     * @return Value of property statusId.
     */
    public int getStatusId() {
        return this.statusId;
    }

    /**
     * Setter for property statusId.
     *
     * @param statusId New value of property statusId.
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    /**
     * Getter for property statusIdPrev.
     *
     * @return Value of property statusIdPrev.
     */
    public int getStatusIdPrev() {
        return this.statusIdPrev;
    }

    /**
     * Setter for property statusIdPrev.
     *
     * @param statusIdPrev New value of property statusIdPrev.
     */
    public void setStatusIdPrev(int statusIdPrev) {
        this.statusIdPrev = statusIdPrev;
    }

    /**
     * Getter for property commentsPrev.
     *
     * @return Value of property commentsPrev.
     */
    public String getCommentsPrev() {
        return this.commentsPrev;
    }

    /**
     * Setter for property commentsPrev.
     *
     * @param commentsPrev New value of property commentsPrev.
     */
    public void setCommentsPrev(String commentsPrev) {
        this.commentsPrev = commentsPrev;
    }


    public boolean isModified() {
        if (_comments == null) {
            if (commentsPrev != null) return true;
        } else {
            if (!_comments.equals(commentsPrev)) return true;
        }

        return (statusId != statusIdPrev);

    }

}
