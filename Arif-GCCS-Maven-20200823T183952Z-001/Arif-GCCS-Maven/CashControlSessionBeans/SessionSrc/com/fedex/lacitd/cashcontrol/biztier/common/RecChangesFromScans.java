/**
 * @(#)ReceivablesVO.java			Fri Nov 08 09:11:40 VET 2002
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
 * This bean map to the receivables table
 *
 * @author Cristian C?enas
 * @version 1.0
 */
package com.fedex.lacitd.cashcontrol.biztier.common;

import java.util.Collection;
import java.util.Date;

public class RecChangesFromScans implements java.io.Serializable {

    private Integer _recPk;
    private String _recNumber;
    private String _recCustomerName;
    private Date _recDate;
    private double _recAmount;
    private Integer _productCodePk;
    private String _locationCodePk;
    private String _recAwbNumber;
    private double _recExchrateClearanceUsed;
    private String _recComment;
    private String _recEmployeeCodePk;
    private String _recLastScanType;
    private double _recCashPayment;
    private double _recCheckPayment;
    private String _recCheckNumber;
    private double _recDex16CashPayment;
    private double _recDex16FreightAmount;
    private double _recDex16CheckPayment;
    private String _recDex16CheckNumberPayment;
    private String _recDex16CosmosScanSeqNbr;
    private String _recClearRecEmpCodePk;
    private Date _recClearRecDate;
    private String _recCloseCourierEmpCodePk;
    private Date _recCloseCourierDate;
    private String _recProcEodEmpCodePk;
    private Date _recProcEodDate;
    private String _recCurrency;
    private String _recPaymentCurrency;
    private int _recStatusCodePk;

    /**
     * Holds value of property cosmosScans.
     */
    private Collection cosmosScans;

    /**
     * Holds value of property recPk.
     */
    private int recPk;

    /**
     * Holds value of property recTrackingStatus.
     */
    private int recTrackingStatus;

    /**
     * Holds value of property lastScanDate.
     */
    private java.util.Date recLastScanDate;

    /**
     * Holds value of property recLastScan.
     */
    private String recLastScan;

    /**
     * Holds value of property inCage.
     */
    private boolean inCage;

    /**
     * Holds value of property recTinUniqueId.
     */
    private String recTinUniqueId;

    /**
     * Holds value of property otherPaymentType.
     */
    private int otherPaymentType;

    /**
     * Holds value of property rodAmt.
     */
    private double rodAmt;

    /**
     * Holds value of property ancChargeAmt.
     */
    private double ancChargeAmt;

    public RecChangesFromScans() {
    }

    public RecChangesFromScans(Integer recPk, String recNumber, String recCustomerName, Date recDate, double recAmount, Integer productCodePk, String locationCodePk, String recAwbNumber, double recExchrateClearanceUsed, String recComment, String recEmployeeCodePk, String recLastScanType, double recCashPayment, double recCheckPayment, String recCheckNumber, double recDex16CashPayment, double recDex16FreightAmount, double recDex16CheckPayment, String recDex16CheckNumberPayment, String recDex16CosmosScanSeqNbr, String recClearRecEmpCodePk, Date recClearRecDate, String recCloseCourierEmpCodePk, Date recCloseCourierDate, String recProcEodEmpCodePk, Date recProcEodDate, String recCurrency, String recPaymentCurrency, int recStatusCodePk) {
        _recPk = recPk;
        _recNumber = recNumber;
        _recCustomerName = recCustomerName;
        _recDate = recDate;
        _recAmount = recAmount;
        _productCodePk = productCodePk;
        _locationCodePk = locationCodePk;
        _recAwbNumber = recAwbNumber;
        _recExchrateClearanceUsed = recExchrateClearanceUsed;
        _recComment = recComment;
        _recEmployeeCodePk = recEmployeeCodePk;
        _recLastScanType = recLastScanType;
        _recCashPayment = recCashPayment;
        _recCheckPayment = recCheckPayment;
        _recCheckNumber = recCheckNumber;
        _recDex16CashPayment = recDex16CashPayment;
        _recDex16FreightAmount = recDex16FreightAmount;
        _recDex16CheckPayment = recDex16CheckPayment;
        _recDex16CheckNumberPayment = recDex16CheckNumberPayment;
        _recDex16CosmosScanSeqNbr = recDex16CosmosScanSeqNbr;
        _recClearRecEmpCodePk = recClearRecEmpCodePk;
        _recClearRecDate = recClearRecDate;
        _recCloseCourierEmpCodePk = recCloseCourierEmpCodePk;
        _recCloseCourierDate = recCloseCourierDate;
        _recProcEodEmpCodePk = recProcEodEmpCodePk;
        _recProcEodDate = recProcEodDate;
        _recCurrency = recCurrency;
        _recPaymentCurrency = recPaymentCurrency;
        _recStatusCodePk = recStatusCodePk;
    }

    /**
     * Set the value of locationCodePk
     */
    public void setLocationCd(String locationCodePk) {
        _locationCodePk = locationCodePk;
    }

    /**
     * Get the value of locationCodePk
     */
    public String getLocationCd() {
        return _locationCodePk;
    }

    /**
     * Set the value of recAwbNumber
     */
    public void setRecAwbNumber(String recAwbNumber) {
        _recAwbNumber = recAwbNumber;
    }

    /**
     * Get the value of recAwbNumber
     */
    public String getRecAwbNumber() {
        return _recAwbNumber;
    }

    /**
     * Set the value of recEmployeeCodePk
     */
    public void setRecEmployeeId(String recEmployeeCodePk) {
        _recEmployeeCodePk = recEmployeeCodePk;
    }

    /**
     * Get the value of recEmployeeCodePk
     */
    public String getRecEmployeeId() {
        return _recEmployeeCodePk;
    }

    /**
     * Set the value of recLastScanType
     */
    public void setRecLastScanType(String recLastScanType) {
        _recLastScanType = recLastScanType;
    }

    /**
     * Get the value of recLastScanType
     */
    public String getRecLastScanType() {
        return _recLastScanType;
    }

    /**
     * Set the value of recCashPayment
     */
    public void setRecCashPayment(double recCashPayment) {
        _recCashPayment = recCashPayment;
    }

    /**
     * Get the value of recCashPayment
     */
    public double getRecCashPayment() {
        return _recCashPayment;
    }

    /**
     * Set the value of recCheckPayment
     */
    public void setRecOtherPayment(double recCheckPayment) {
        _recCheckPayment = recCheckPayment;
    }

    /**
     * Get the value of recCheckPayment
     */
    public double getRecOtherPayment() {
        return _recCheckPayment;
    }

    /**
     * Set the value of recCheckNumber
     */
    public void setRecOtherDocNumber(String recCheckNumber) {
    	// Changes to remove "9999"
    	if (recCheckNumber=="9999"){
    		_recCheckNumber= "";
    	}
    	else
        _recCheckNumber = recCheckNumber;
    }

    /**
     * Get the value of recCheckNumber
     */
    public String getRecOtherDocNumber() {
        return _recCheckNumber;
    }

    /**
     * Set the value of recDex16CashPayment
     */
    public void setRecDex16CashPayment(double recDex16CashPayment) {
        _recDex16CashPayment = recDex16CashPayment;
    }

    /**
     * Get the value of recDex16CashPayment
     */
    public double getRecDex16CashPayment() {
        return _recDex16CashPayment;
    }

    /**
     * Set the value of recDex16FreightAmount
     */
    public void setRecDex16FreightAmount(double recDex16FreightAmount) {
        _recDex16FreightAmount = recDex16FreightAmount;
    }

    /**
     * Get the value of recDex16FreightAmount
     */
    public double getRecDex16FreightAmount() {
        return _recDex16FreightAmount;
    }

    /**
     * Set the value of recDex16CheckPayment
     */
    public void setRecDex16OtherPayment(double recDex16CheckPayment) {
        _recDex16CheckPayment = recDex16CheckPayment;
    }

    /**
     * Get the value of recDex16CheckPayment
     */
    public double getRecDex16OtherPayment() {
        return _recDex16CheckPayment;
    }

    /**
     * Set the value of recDex16CheckNumberPayment
     */
    public void setRecDex16OtherDocNumber(String recDex16CheckNumberPayment) {
        _recDex16CheckNumberPayment = recDex16CheckNumberPayment;
    }

    /**
     * Get the value of recDex16CheckNumberPayment
     */
    public String getRecDex16OtherDocNumber() {
        return _recDex16CheckNumberPayment;
    }

    /**
     * Set the value of recDex16CosmosScanSeqNbr
     */
    public void setRecDex16CosmosScanSeqNbr(String recDex16CosmosScanSeqNbr) {
        _recDex16CosmosScanSeqNbr = recDex16CosmosScanSeqNbr;
    }

    /**
     * Get the value of recDex16CosmosScanSeqNbr
     */
    public String getRecDex16CosmosScanSeqNbr() {
        return _recDex16CosmosScanSeqNbr;
    }

    /**
     * Set the value of recPaymentCurrency
     */
    public void setRecPaymentCurrency(String recPaymentCurrency) {
        _recPaymentCurrency = recPaymentCurrency;
    }

    /**
     * Get the value of recPaymentCurrency
     */
    public String getRecPaymentCurrency() {
        return _recPaymentCurrency;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RecPk: " + _recPk);
        stringBuffer.append("RecNumber: " + _recNumber);
        stringBuffer.append("RecCustomerName: " + _recCustomerName);
        stringBuffer.append("RecDate: " + _recDate);
        stringBuffer.append("RecAmount: " + _recAmount);
        stringBuffer.append("ProductCodePk: " + _productCodePk);
        stringBuffer.append("LocationCodePk: " + _locationCodePk);
        stringBuffer.append("RecAwbNumber: " + _recAwbNumber);
        stringBuffer.append("RecExchrateClearanceUsed: " + _recExchrateClearanceUsed);
        stringBuffer.append("RecComment: " + _recComment);
        stringBuffer.append("RecEmployeeCodePk: " + _recEmployeeCodePk);
        stringBuffer.append("RecLastScanType: " + _recLastScanType);
        stringBuffer.append("RecCashPayment: " + _recCashPayment);
        stringBuffer.append("RecCheckPayment: " + _recCheckPayment);
        stringBuffer.append("RecCheckNumber: " + _recCheckNumber);
        stringBuffer.append("RecDex16CashPayment: " + _recDex16CashPayment);
        stringBuffer.append("RecDex16FreightAmount: " + _recDex16FreightAmount);
        stringBuffer.append("RecDex16CheckPayment: " + _recDex16CheckPayment);
        stringBuffer.append("RecDex16CheckNumberPayment: " + _recDex16CheckNumberPayment);
        stringBuffer.append("RecDex16CosmosScanSeqNbr: " + _recDex16CosmosScanSeqNbr);
        stringBuffer.append("RecClearRecEmpCodePk: " + _recClearRecEmpCodePk);
        stringBuffer.append("RecClearRecDate: " + _recClearRecDate);
        stringBuffer.append("RecCloseCourierEmpCodePk: " + _recCloseCourierEmpCodePk);
        stringBuffer.append("RecCloseCourierDate: " + _recCloseCourierDate);
        stringBuffer.append("RecProcEodEmpCodePk: " + _recProcEodEmpCodePk);
        stringBuffer.append("RecProcEodDate: " + _recProcEodDate);
        stringBuffer.append("RecCurrency: " + _recCurrency);
        stringBuffer.append("RecPaymentCurrency: " + _recPaymentCurrency);
        stringBuffer.append("RecStatusCodePk: " + _recStatusCodePk);
        return stringBuffer.toString();
    }

    /**
     * Getter for property cosmosScans.
     *
     * @return Value of property cosmosScans.
     */
    public Collection getCosmosScans() {
        return this.cosmosScans;
    }

    /**
     * Setter for property cosmosScans.
     *
     * @param cosmosScans New value of property cosmosScans.
     */
    public void setCosmosScans(Collection cosmosScans) {
        this.cosmosScans = cosmosScans;
    }

    /**
     * Getter for property recPk.
     *
     * @return Value of property recPk.
     */
    public int getRecId() {
        return this.recPk;
    }

    /**
     * Setter for property recPk.
     *
     * @param recPk New value of property recPk.
     */
    public void setRecId(int recPk) {
        this.recPk = recPk;
    }

    /**
     * Getter for property recTrackingStatus.
     *
     * @return Value of property recTrackingStatus.
     */
    public int getRecTrackingStatus() {
        return this.recTrackingStatus;
    }

    /**
     * Setter for property recTrackingStatus.
     *
     * @param recTrackingStatus New value of property recTrackingStatus.
     */
    public void setRecTrackingStatus(int recTrackingStatus) {
        this.recTrackingStatus = recTrackingStatus;
    }

    /**
     * Getter for property lastScanDate.
     *
     * @return Value of property lastScanDate.
     */
    public java.util.Date getRecLastScanDate() {
        return this.recLastScanDate;
    }

    /**
     * Setter for property lastScanDate.
     *
     * @param lastScanDate New value of property lastScanDate.
     */
    public void setRecLastScanDate(java.util.Date recLastScanDate) {
        this.recLastScanDate = recLastScanDate;
    }

    /**
     * Getter for property recLastScan.
     *
     * @return Value of property recLastScan.
     */
    public String getRecLastScan() {
        return this.recLastScan;
    }

    /**
     * Setter for property recLastScan.
     *
     * @param recLastScan New value of property recLastScan.
     */
    public void setRecLastScan(String recLastScan) {
        this.recLastScan = recLastScan;
    }

    /**
     * Getter for property inCage.
     *
     * @return Value of property inCage.
     */
    public boolean isInCage() {
        return this.inCage;
    }

    /**
     * Setter for property inCage.
     *
     * @param inCage New value of property inCage.
     */
    public void setInCage(boolean inCage) {
        this.inCage = inCage;
    }

    /**
     * Getter for property recTinUniqueId.
     *
     * @return Value of property recTinUniqueId.
     */
    public String getRecTinUniqueId() {
        return this.recTinUniqueId;
    }

    /**
     * Setter for property recTinUniqueId.
     *
     * @param recTinUniqueId New value of property recTinUniqueId.
     */
    public void setRecTinUniqueId(String recTinUniqueId) {
        this.recTinUniqueId = recTinUniqueId;
    }

    /**
     * Getter for property otherPaymentType.
     *
     * @return Value of property otherPaymentType.
     */
    public int getOtherPaymentType() {
        return this.otherPaymentType;
    }

    /**
     * Setter for property otherPaymentType.
     *
     * @param otherPaymentType New value of property otherPaymentType.
     */
    public void setOtherPaymentType(int otherPaymentType) {
        this.otherPaymentType = otherPaymentType;
    }

    /**
     * Getter for property _recAmount.
     *
     * @return Value of property otherPaymentType.
     */
    public double getRecAmount() {
        return this._recAmount;
    }

    /**
     * Setter for property _recAmount.
     *
     * @param Value of property _recAmount.
     */
    public void setRecAmount(double recAmount) {
        this._recAmount = recAmount;
    }

    /**
     * Getter for property rodAmt.
     *
     * @return Value of property rodAmt.
     */
    public double getRodAmt() {
        return this.rodAmt;
    }

    /**
     * Setter for property rodAmt.
     *
     * @param rodAmt New value of property rodAmt.
     */
    public void setRodAmt(double rodAmt) {
        this.rodAmt = rodAmt;
    }

    /**
     * Getter for property ancChargeAmt.
     *
     * @return Value of property ancChargeAmt.
     */
    public double getAncChargeAmt() {
        return this.ancChargeAmt;
    }

    /**
     * Setter for property ancChargeAmt.
     *
     * @param ancChargeAmt New value of property ancChargeAmt.
     */
    public void setAncChargeAmt(double ancChargeAmt) {
        this.ancChargeAmt = ancChargeAmt;
    }

}
