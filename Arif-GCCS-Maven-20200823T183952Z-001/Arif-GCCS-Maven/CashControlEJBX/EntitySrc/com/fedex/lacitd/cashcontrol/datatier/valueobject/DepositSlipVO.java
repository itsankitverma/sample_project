/**
 * @(#)DepositSlipVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the deposit_slip table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class DepositSlipVO implements java.io.Serializable {

    private Integer _depositSlipCd;
    private Date _depositSlipDt;
    private String _depositSlipNbr;
    private double _depositSlipTotAmt;
    private Integer _bankAccountCd;
    private String _employeeId;
    private String _currencyCd;
    private String _srcType;
    private int _pymtType;
    private String _locationCd;
    private int _statusId;
    private String _comments;
    private double _actualAmt;
    private double _bankAmt;
    private String _fedexDepositId;
    private Date _closeDt;
    private Date _depoDt;
    private Date _bankDepoDt;
    private int _eodId;
    private int _templId;
    private String _templCd;
    public DepositSlipVO() {
    }
    public DepositSlipVO(Integer depositSlipCd, Date depositSlipDt, String depositSlipNbr, double depositSlipTotAmt, Integer bankAccountCd, String employeeId, String currencyCd, String srcType, int pymtType, String locationCd, int statusId, String comments, double actualAmt, double bankAmt, String fedexDepositId, Date closeDt, Date depoDt, Date bankDepoDt, int eodId, int templId, String templCd) {
        _depositSlipCd = depositSlipCd;
        _depositSlipDt = depositSlipDt;
        _depositSlipNbr = depositSlipNbr;
        _depositSlipTotAmt = depositSlipTotAmt;
        _bankAccountCd = bankAccountCd;
        _employeeId = employeeId;
        _currencyCd = currencyCd;
        _srcType = srcType;
        _pymtType = pymtType;
        _locationCd = locationCd;
        _statusId = statusId;
        _comments = comments;
        _actualAmt = actualAmt;
        _bankAmt = bankAmt;
        _fedexDepositId = fedexDepositId;
        _closeDt = closeDt;
        _depoDt = depoDt;
        _bankDepoDt = bankDepoDt;
        _eodId = eodId;
        _templId = templId;
        _templCd = templCd;
    }
    /**
     * Set the value of depositSlipCd
     */
    public void setDepositSlipCd(Integer depositSlipCd) {
        _depositSlipCd = depositSlipCd;
    }

    /**
     * Get the value of depositSlipCd
     */
    public Integer getDepositSlipCd() {
        return _depositSlipCd;
    }

    /**
     * Set the value of depositSlipDt
     */
    public void setDepositSlipDt(Date depositSlipDt) {
        _depositSlipDt = depositSlipDt;
    }

    /**
     * Get the value of depositSlipDt
     */
    public Date getDepositSlipDt() {
        return _depositSlipDt;
    }

    /**
     * Set the value of depositSlipNbr
     */
    public void setDepositSlipNbr(String depositSlipNbr) {
        _depositSlipNbr = depositSlipNbr;
    }

    /**
     * Get the value of depositSlipNbr
     */
    public String getDepositSlipNbr() {
        return _depositSlipNbr;
    }

    /**
     * Set the value of depositSlipTotAmt
     */
    public void setDepositSlipTotAmt(double depositSlipTotAmt) {
        _depositSlipTotAmt = depositSlipTotAmt;
    }

    /**
     * Get the value of depositSlipTotAmt
     */
    public double getDepositSlipTotAmt() {
        return _depositSlipTotAmt;
    }

    /**
     * Set the value of bankAccountCd
     */
    public void setBankAccountCd(Integer bankAccountCd) {
        _bankAccountCd = bankAccountCd;
    }

    /**
     * Get the value of bankAccountCd
     */
    public Integer getBankAccountCd() {
        return _bankAccountCd;
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
     * Set the value of srcType
     */
    public void setSrcType(String srcType) {
        _srcType = srcType;
    }

    /**
     * Get the value of srcType
     */
    public String getSrcType() {
        return _srcType;
    }

    /**
     * Set the value of pymtType
     */
    public void setPymtType(int pymtType) {
        _pymtType = pymtType;
    }

    /**
     * Get the value of pymtType
     */
    public int getPymtType() {
        return _pymtType;
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
     * Set the value of actualAmt
     */
    public void setActualAmt(double actualAmt) {
        _actualAmt = actualAmt;
    }

    /**
     * Get the value of actualAmt
     */
    public double getActualAmt() {
        return _actualAmt;
    }

    /**
     * Set the value of bankAmt
     */
    public void setBankAmt(double bankAmt) {
        _bankAmt = bankAmt;
    }

    /**
     * Get the value of bankAmt
     */
    public double getBankAmt() {
        return _bankAmt;
    }

    /**
     * Set the value of fedexDepositId
     */
    public void setFedexDepositId(String fedexDepositId) {
        _fedexDepositId = fedexDepositId;
    }

    /**
     * Get the value of fedexDepositId
     */
    public String getFedexDepositId() {
        return _fedexDepositId;
    }

    /**
     * Set the value of closeDt
     */
    public void setCloseDt(Date closeDt) {
        _closeDt = closeDt;
    }

    /**
     * Get the value of closeDt
     */
    public Date getCloseDt() {
        return _closeDt;
    }

    /**
     * Set the value of depoDt
     */
    public void setDepoDt(Date depoDt) {
        _depoDt = depoDt;
    }

    /**
     * Get the value of depoDt
     */
    public Date getDepoDt() {
        return _depoDt;
    }

    /**
     * Set the value of bankDepoDt
     */
    public void setBankDepoDt(Date bankDepoDt) {
        _bankDepoDt = bankDepoDt;
    }

    /**
     * Get the value of bankDepoDt
     */
    public Date getBankDepoDt() {
        return _bankDepoDt;
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
     * Set the value of templId
     */
    public void setTemplId(int templId) {
        _templId = templId;
    }

    /**
     * Get the value of templId
     */
    public int getTemplId() {
        return _templId;
    }

    /**
     * Set the value of templCd
     */
    public void setTemplCd(String templCd) {
        _templCd = templCd;
    }

    /**
     * Get the value of templCd
     */
    public String getTemplCd() {
        return _templCd;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getDepositSlipPK() {
        return _depositSlipCd;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DepositSlipCd: " + _depositSlipCd);
        stringBuffer.append("DepositSlipDt: " + _depositSlipDt);
        stringBuffer.append("DepositSlipNbr: " + _depositSlipNbr);
        stringBuffer.append("DepositSlipTotAmt: " + _depositSlipTotAmt);
        stringBuffer.append("BankAccountCd: " + _bankAccountCd);
        stringBuffer.append("EmployeeId: " + _employeeId);
        stringBuffer.append("CurrencyCd: " + _currencyCd);
        stringBuffer.append("SrcType: " + _srcType);
        stringBuffer.append("PymtType: " + _pymtType);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("StatusId: " + _statusId);
        stringBuffer.append("Comments: " + _comments);
        stringBuffer.append("ActualAmt: " + _actualAmt);
        stringBuffer.append("BankAmt: " + _bankAmt);
        stringBuffer.append("FedexDepositId: " + _fedexDepositId);
        stringBuffer.append("CloseDt: " + _closeDt);
        stringBuffer.append("DepoDt: " + _depoDt);
        stringBuffer.append("BankDepoDt: " + _bankDepoDt);
        stringBuffer.append("EodId: " + _eodId);
        stringBuffer.append("TemplId: " + _templId);
        stringBuffer.append("TemplCd: " + _templCd);
        return stringBuffer.toString();
    }

}
