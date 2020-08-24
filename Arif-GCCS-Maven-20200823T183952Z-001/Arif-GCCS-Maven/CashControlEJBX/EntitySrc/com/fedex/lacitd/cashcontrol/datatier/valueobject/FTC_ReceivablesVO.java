/**
 * @(#)ReceivablesVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;


import java.util.*;

public class FTC_ReceivablesVO implements java.io.Serializable {

	//DTO attribute added for miscDate, miscNbr
	private Date _miscDate;
	private String _miscNbr;	
	
    private Integer _recId;
    private String _recNbr;
    private String _customerNm;
    private Date _recDt;
    private String _invCurrency;
    private double _ftcAmt;
    private double _ancChargeAmt;
    private double _recAmt;
    private String _locationCd;
    private String _awbNbr;
    private String _tinUniqId;
    private double _exchRateClnUsed;
    private String _employeeId;
    private String _paymentCurrency;
    private double _cashPaymentAmt;
    private double _otherPaymentAmt;
    private int _otherPaymentType;
    private String _otherDocNbr;
    private double _dex16CashPayment;
    private double _dex16FreightAmt;
    private double _dex16OtherPaymentAmt;
    private String _dex16OtherDocNbr;
    private String _dex16ScanSeqNbr;
    private String _chngStatusEmployeeId;
    private Date _chngStatusDt;
    private String _closeEmployeeId;
    private Date _closeDt;
    private String _eodEmployeeId;
    private Date _eodDt;
    private String _lastScanType;
    private Date _lastScanDate;
    private String _chkinAgentComment;
    private int _trackingStatus;
    private int _statusId;
    private int _cashDepositSlipId;
    private String _cashDepositSlipNbr;
    private int _otherDepositSlipId;
    private String _otherDepositSlipNbr;
    private String _creditCardBatchId;
    private int _eodId;
    private Date _ftcXmlImpDt;
    private Date _pymtImpDt;
    private String _otherComment;
    private double _recvPrepyAmt;
    private String _origCustNm;
    private String _custChngEmpId;
    private double _origRecAmt;
    private String _amtChngEmpId;
    private String _rcptNbr;
    private String _origRcptNbr;
    private String _rcptChngEmpId;
    private String _origEmployeeId;
    private String _reassEmpId;
    private Integer _dualRecIdNbr;
    private String _dupAwbFlg;
    private String _billAccount;
    public FTC_ReceivablesVO() {
    }
    public FTC_ReceivablesVO(Integer recId, String recNbr, String customerNm, Date recDt, String invCurrency, double ftcAmt, double ancChargeAmt, double recAmt, String locationCd, String awbNbr, String tinUniqId, double exchRateClnUsed, String employeeId, String paymentCurrency, double cashPaymentAmt, double otherPaymentAmt, int otherPaymentType, String otherDocNbr, double dex16CashPayment, double dex16FreightAmt, double dex16OtherPaymentAmt, String dex16OtherDocNbr, String dex16ScanSeqNbr, String chngStatusEmployeeId, Date chngStatusDt, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String lastScanType, Date lastScanDate, String chkinAgentComment, int trackingStatus, int statusId, int cashDepositSlipId, String cashDepositSlipNbr, int otherDepositSlipId, String otherDepositSlipNbr, String creditCardBatchId, int eodId, Date ftcXmlImpDt, Date pymtImpDt, String otherComment, double recvPrepyAmt, String origCustNm, String custChngEmpId, double origRecAmt, String amtChngEmpId, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Integer dualRecIdNbr, String dupAwbFlg, String billAccount,java.util.Date miscDate,String miscNbr) {
        _recId = recId;
        _recNbr = recNbr;
        _customerNm = customerNm;
        _recDt = recDt;
        _invCurrency = invCurrency;
        _ftcAmt = ftcAmt;
        _ancChargeAmt = ancChargeAmt;
        _recAmt = recAmt;
        _locationCd = locationCd;
        _awbNbr = awbNbr;
        _tinUniqId = tinUniqId;
        _exchRateClnUsed = exchRateClnUsed;
        _employeeId = employeeId;
        _paymentCurrency = paymentCurrency;
        _cashPaymentAmt = cashPaymentAmt;
        _otherPaymentAmt = otherPaymentAmt;
        _otherPaymentType = otherPaymentType;
        _otherDocNbr = otherDocNbr;
        _dex16CashPayment = dex16CashPayment;
        _dex16FreightAmt = dex16FreightAmt;
        _dex16OtherPaymentAmt = dex16OtherPaymentAmt;
        _dex16OtherDocNbr = dex16OtherDocNbr;
        _dex16ScanSeqNbr = dex16ScanSeqNbr;
        _chngStatusEmployeeId = chngStatusEmployeeId;
        _chngStatusDt = chngStatusDt;
        _closeEmployeeId = closeEmployeeId;
        _closeDt = closeDt;
        _eodEmployeeId = eodEmployeeId;
        _eodDt = eodDt;
        _lastScanType = lastScanType;
        _lastScanDate = lastScanDate;
        _chkinAgentComment = chkinAgentComment;
        _trackingStatus = trackingStatus;
        _statusId = statusId;
        _cashDepositSlipId = cashDepositSlipId;
        _cashDepositSlipNbr = cashDepositSlipNbr;
        _otherDepositSlipId = otherDepositSlipId;
        _otherDepositSlipNbr = otherDepositSlipNbr;
        _creditCardBatchId = creditCardBatchId;
        _eodId = eodId;
        _ftcXmlImpDt = ftcXmlImpDt;
        _pymtImpDt = pymtImpDt;
        _otherComment = otherComment;
        _recvPrepyAmt = recvPrepyAmt;
        _origCustNm = origCustNm;
        _custChngEmpId = custChngEmpId;
        _origRecAmt = origRecAmt;
        _amtChngEmpId = amtChngEmpId;
        _rcptNbr = rcptNbr;
        _origRcptNbr = origRcptNbr;
        _rcptChngEmpId = rcptChngEmpId;
        _origEmployeeId = origEmployeeId;
        _reassEmpId = reassEmpId;
        _dualRecIdNbr = dualRecIdNbr;
        _dupAwbFlg = dupAwbFlg;
        _billAccount = billAccount;
        //constructor initialization of miscDate,miscNbr
        _miscDate = miscDate;
        _miscNbr = miscNbr;        
    }
    
    //getter setter DTO method for miscDate miscNbr
    public java.util.Date getMiscDate() {
		return _miscDate;
	}
	public void setMiscDate(java.util.Date miscDate) {
		_miscDate = miscDate;
	}
	public String getMiscNbr() {
		return _miscNbr;
	}
	public void setMiscNbr(String miscNbr) {
		_miscNbr = miscNbr;
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
     * Set the value of recNbr
     */
    public void setRecNbr(String recNbr) {
        _recNbr = recNbr;
    }

    /**
     * Get the value of recNbr
     */
    public String getRecNbr() {
        return _recNbr;
    }

    /**
     * Set the value of customerNm
     */
    public void setCustomerNm(String customerNm) {
        _customerNm = customerNm;
    }

    /**
     * Get the value of customerNm
     */
    public String getCustomerNm() {
        return _customerNm;
    }

    /**
     * Set the value of recDt
     */
    public void setRecDt(Date recDt) {
        _recDt = recDt;
    }

    /**
     * Get the value of recDt
     */
    public Date getRecDt() {
        return _recDt;
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
     * Set the value of ftcAmt
     */
    public void setFtcAmt(double ftcAmt) {
        _ftcAmt = ftcAmt;
    }

    /**
     * Get the value of ftcAmt
     */
    public double getFtcAmt() {
        return _ftcAmt;
    }

    /**
     * Set the value of ancChargeAmt
     */
    public void setAncChargeAmt(double ancChargeAmt) {
        _ancChargeAmt = ancChargeAmt;
    }

    /**
     * Get the value of ancChargeAmt
     */
    public double getAncChargeAmt() {
        return _ancChargeAmt;
    }

    /**
     * Set the value of recAmt
     */
    public void setRecAmt(double recAmt) {
        _recAmt = recAmt;
    }

    /**
     * Get the value of recAmt
     */
    public double getRecAmt() {
        return _recAmt;
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
     * Set the value of tinUniqId
     */
    public void setTinUniqId(String tinUniqId) {
        _tinUniqId = tinUniqId;
    }

    /**
     * Get the value of tinUniqId
     */
    public String getTinUniqId() {
        return _tinUniqId;
    }

    /**
     * Set the value of exchRateClnUsed
     */
    public void setExchRateClnUsed(double exchRateClnUsed) {
        _exchRateClnUsed = exchRateClnUsed;
    }

    /**
     * Get the value of exchRateClnUsed
     */
    public double getExchRateClnUsed() {
        return _exchRateClnUsed;
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
     * Set the value of cashPaymentAmt
     */
    public void setCashPaymentAmt(double cashPaymentAmt) {
        _cashPaymentAmt = cashPaymentAmt;
    }

    /**
     * Get the value of cashPaymentAmt
     */
    public double getCashPaymentAmt() {
        return _cashPaymentAmt;
    }

    /**
     * Set the value of otherPaymentAmt
     */
    public void setOtherPaymentAmt(double otherPaymentAmt) {
        _otherPaymentAmt = otherPaymentAmt;
    }

    /**
     * Get the value of otherPaymentAmt
     */
    public double getOtherPaymentAmt() {
        return _otherPaymentAmt;
    }

    /**
     * Set the value of otherPaymentType
     */
    public void setOtherPaymentType(int otherPaymentType) {
        _otherPaymentType = otherPaymentType;
    }

    /**
     * Get the value of otherPaymentType
     */
    public int getOtherPaymentType() {
        return _otherPaymentType;
    }

    /**
     * Set the value of otherDocNbr
     */
    public void setOtherDocNbr(String otherDocNbr) {
        _otherDocNbr = otherDocNbr;
    }

    /**
     * Get the value of otherDocNbr
     */
    public String getOtherDocNbr() {
        return _otherDocNbr;
    }

    /**
     * Set the value of dex16CashPayment
     */
    public void setDex16CashPayment(double dex16CashPayment) {
        _dex16CashPayment = dex16CashPayment;
    }

    /**
     * Get the value of dex16CashPayment
     */
    public double getDex16CashPayment() {
        return _dex16CashPayment;
    }

    /**
     * Set the value of dex16FreightAmt
     */
    public void setDex16FreightAmt(double dex16FreightAmt) {
        _dex16FreightAmt = dex16FreightAmt;
    }

    /**
     * Get the value of dex16FreightAmt
     */
    public double getDex16FreightAmt() {
        return _dex16FreightAmt;
    }

    /**
     * Set the value of dex16OtherPaymentAmt
     */
    public void setDex16OtherPaymentAmt(double dex16OtherPaymentAmt) {
        _dex16OtherPaymentAmt = dex16OtherPaymentAmt;
    }

    /**
     * Get the value of dex16OtherPaymentAmt
     */
    public double getDex16OtherPaymentAmt() {
        return _dex16OtherPaymentAmt;
    }

    /**
     * Set the value of dex16OtherDocNbr
     */
    public void setDex16OtherDocNbr(String dex16OtherDocNbr) {
        _dex16OtherDocNbr = dex16OtherDocNbr;
    }

    /**
     * Get the value of dex16OtherDocNbr
     */
    public String getDex16OtherDocNbr() {
        return _dex16OtherDocNbr;
    }

    /**
     * Set the value of dex16ScanSeqNbr
     */
    public void setDex16ScanSeqNbr(String dex16ScanSeqNbr) {
        _dex16ScanSeqNbr = dex16ScanSeqNbr;
    }

    /**
     * Get the value of dex16ScanSeqNbr
     */
    public String getDex16ScanSeqNbr() {
        return _dex16ScanSeqNbr;
    }

    /**
     * Set the value of chngStatusEmployeeId
     */
    public void setChngStatusEmployeeId(String chngStatusEmployeeId) {
        _chngStatusEmployeeId = chngStatusEmployeeId;
    }

    /**
     * Get the value of chngStatusEmployeeId
     */
    public String getChngStatusEmployeeId() {
        return _chngStatusEmployeeId;
    }

    /**
     * Set the value of chngStatusDt
     */
    public void setChngStatusDt(Date chngStatusDt) {
        _chngStatusDt = chngStatusDt;
    }

    /**
     * Get the value of chngStatusDt
     */
    public Date getChngStatusDt() {
        return _chngStatusDt;
    }

    /**
     * Set the value of closeEmployeeId
     */
    public void setCloseEmployeeId(String closeEmployeeId) {
        _closeEmployeeId = closeEmployeeId;
    }

    /**
     * Get the value of closeEmployeeId
     */
    public String getCloseEmployeeId() {
        return _closeEmployeeId;
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
     * Set the value of eodEmployeeId
     */
    public void setEodEmployeeId(String eodEmployeeId) {
        _eodEmployeeId = eodEmployeeId;
    }

    /**
     * Get the value of eodEmployeeId
     */
    public String getEodEmployeeId() {
        return _eodEmployeeId;
    }

    /**
     * Set the value of eodDt
     */
    public void setEodDt(Date eodDt) {
        _eodDt = eodDt;
    }

    /**
     * Get the value of eodDt
     */
    public Date getEodDt() {
        return _eodDt;
    }

    /**
     * Set the value of lastScanType
     */
    public void setLastScanType(String lastScanType) {
        _lastScanType = lastScanType;
    }

    /**
     * Get the value of lastScanType
     */
    public String getLastScanType() {
        return _lastScanType;
    }

    /**
     * Set the value of lastScanDate
     */
    public void setLastScanDate(Date lastScanDate) {
        _lastScanDate = lastScanDate;
    }

    /**
     * Get the value of lastScanDate
     */
    public Date getLastScanDate() {
        return _lastScanDate;
    }

    /**
     * Set the value of chkinAgentComment
     */
    public void setChkinAgentComment(String chkinAgentComment) {
        _chkinAgentComment = chkinAgentComment;
    }

    /**
     * Get the value of chkinAgentComment
     */
    public String getChkinAgentComment() {
        return _chkinAgentComment;
    }

    /**
     * Set the value of trackingStatus
     */
    public void setTrackingStatus(int trackingStatus) {
        _trackingStatus = trackingStatus;
    }

    /**
     * Get the value of trackingStatus
     */
    public int getTrackingStatus() {
        return _trackingStatus;
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
     * Set the value of cashDepositSlipId
     */
    public void setCashDepositSlipId(int cashDepositSlipId) {
        _cashDepositSlipId = cashDepositSlipId;
    }

    /**
     * Get the value of cashDepositSlipId
     */
    public int getCashDepositSlipId() {
        return _cashDepositSlipId;
    }

    /**
     * Set the value of cashDepositSlipNbr
     */
    public void setCashDepositSlipNbr(String cashDepositSlipNbr) {
        _cashDepositSlipNbr = cashDepositSlipNbr;
    }

    /**
     * Get the value of cashDepositSlipNbr
     */
    public String getCashDepositSlipNbr() {
        return _cashDepositSlipNbr;
    }

    /**
     * Set the value of otherDepositSlipId
     */
    public void setOtherDepositSlipId(int otherDepositSlipId) {
        _otherDepositSlipId = otherDepositSlipId;
    }

    /**
     * Get the value of otherDepositSlipId
     */
    public int getOtherDepositSlipId() {
        return _otherDepositSlipId;
    }

    /**
     * Set the value of otherDepositSlipNbr
     */
    public void setOtherDepositSlipNbr(String otherDepositSlipNbr) {
        _otherDepositSlipNbr = otherDepositSlipNbr;
    }

    /**
     * Get the value of otherDepositSlipNbr
     */
    public String getOtherDepositSlipNbr() {
        return _otherDepositSlipNbr;
    }

    /**
     * Set the value of creditCardBatchId
     */
    public void setCreditCardBatchId(String creditCardBatchId) {
        _creditCardBatchId = creditCardBatchId;
    }

    /**
     * Get the value of creditCardBatchId
     */
    public String getCreditCardBatchId() {
        return _creditCardBatchId;
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
     * Set the value of ftcXmlImpDt
     */
    public void setFtcXmlImpDt(Date ftcXmlImpDt) {
        _ftcXmlImpDt = ftcXmlImpDt;
    }

    /**
     * Get the value of ftcXmlImpDt
     */
    public Date getFtcXmlImpDt() {
        return _ftcXmlImpDt;
    }

    /**
     * Set the value of pymtImpDt
     */
    public void setPymtImpDt(Date pymtImpDt) {
        _pymtImpDt = pymtImpDt;
    }

    /**
     * Get the value of pymtImpDt
     */
    public Date getPymtImpDt() {
        return _pymtImpDt;
    }

    /**
     * Set the value of otherComment
     */
    public void setOtherComment(String otherComment) {
        _otherComment = otherComment;
    }

    /**
     * Get the value of otherComment
     */
    public String getOtherComment() {
        return _otherComment;
    }

    /**
     * Set the value of recvPrepyAmt
     */
    public void setRecvPrepyAmt(double recvPrepyAmt) {
        _recvPrepyAmt = recvPrepyAmt;
    }

    /**
     * Get the value of recvPrepyAmt
     */
    public double getRecvPrepyAmt() {
        return _recvPrepyAmt;
    }

    /**
     * Set the value of origCustNm
     */
    public void setOrigCustNm(String origCustNm) {
        _origCustNm = origCustNm;
    }

    /**
     * Get the value of origCustNm
     */
    public String getOrigCustNm() {
        return _origCustNm;
    }

    /**
     * Set the value of custChngEmpId
     */
    public void setCustChngEmpId(String custChngEmpId) {
        _custChngEmpId = custChngEmpId;
    }

    /**
     * Get the value of custChngEmpId
     */
    public String getCustChngEmpId() {
        return _custChngEmpId;
    }

    /**
     * Set the value of origRecAmt
     */
    public void setOrigRecAmt(double origRecAmt) {
        _origRecAmt = origRecAmt;
    }

    /**
     * Get the value of origRecAmt
     */
    public double getOrigRecAmt() {
        return _origRecAmt;
    }

    /**
     * Set the value of amtChngEmpId
     */
    public void setAmtChngEmpId(String amtChngEmpId) {
        _amtChngEmpId = amtChngEmpId;
    }

    /**
     * Get the value of amtChngEmpId
     */
    public String getAmtChngEmpId() {
        return _amtChngEmpId;
    }

    /**
     * Set the value of rcptNbr
     */
    public void setRcptNbr(String rcptNbr) {
        _rcptNbr = rcptNbr;
    }

    /**
     * Get the value of rcptNbr
     */
    public String getRcptNbr() {
        return _rcptNbr;
    }

    /**
     * Set the value of origRcptNbr
     */
    public void setOrigRcptNbr(String origRcptNbr) {
        _origRcptNbr = origRcptNbr;
    }

    /**
     * Get the value of origRcptNbr
     */
    public String getOrigRcptNbr() {
        return _origRcptNbr;
    }

    /**
     * Set the value of rcptChngEmpId
     */
    public void setRcptChngEmpId(String rcptChngEmpId) {
        _rcptChngEmpId = rcptChngEmpId;
    }

    /**
     * Get the value of rcptChngEmpId
     */
    public String getRcptChngEmpId() {
        return _rcptChngEmpId;
    }

    /**
     * Set the value of origEmployeeId
     */
    public void setOrigEmployeeId(String origEmployeeId) {
        _origEmployeeId = origEmployeeId;
    }

    /**
     * Get the value of origEmployeeId
     */
    public String getOrigEmployeeId() {
        return _origEmployeeId;
    }

    /**
     * Set the value of reassEmpId
     */
    public void setReassEmpId(String reassEmpId) {
        _reassEmpId = reassEmpId;
    }

    /**
     * Get the value of reassEmpId
     */
    public String getReassEmpId() {
        return _reassEmpId;
    }

    /**
     * Set the value of dualRecIdNbr
     */
    public void setDualRecIdNbr(Integer dualRecIdNbr) {
        _dualRecIdNbr = dualRecIdNbr;
    }

    /**
     * Get the value of dualRecIdNbr
     */
    public Integer getDualRecIdNbr() {
        return _dualRecIdNbr;
    }

    /**
     * Set the value of dupAwbFlg
     */
    public void setDupAwbFlg(String dupAwbFlg) {
        _dupAwbFlg = dupAwbFlg;
    }

    /**
     * Get the value of dupAwbFlg
     */
    public String getDupAwbFlg() {
        return _dupAwbFlg;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getReceivablesPK() {
        return _recId;
    }

    public void setbillAccount(String billAccount) {
        _billAccount = billAccount;
    }

    public String getbillAccount() {
        return _billAccount;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RecId: " + _recId);
        stringBuffer.append("RecNbr: " + _recNbr);
        stringBuffer.append("CustomerNm: " + _customerNm);
        stringBuffer.append("RecDt: " + _recDt);
        stringBuffer.append("InvCurrency: " + _invCurrency);
        stringBuffer.append("FtcAmt: " + _ftcAmt);
        stringBuffer.append("AncChargeAmt: " + _ancChargeAmt);
        stringBuffer.append("RecAmt: " + _recAmt);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("AwbNbr: " + _awbNbr);
        stringBuffer.append("TinUniqId: " + _tinUniqId);
        stringBuffer.append("ExchRateClnUsed: " + _exchRateClnUsed);
        stringBuffer.append("EmployeeId: " + _employeeId);
        stringBuffer.append("PaymentCurrency: " + _paymentCurrency);
        stringBuffer.append("CashPaymentAmt: " + _cashPaymentAmt);
        stringBuffer.append("OtherPaymentAmt: " + _otherPaymentAmt);
        stringBuffer.append("OtherPaymentType: " + _otherPaymentType);
        stringBuffer.append("OtherDocNbr: " + _otherDocNbr);
        stringBuffer.append("Dex16CashPayment: " + _dex16CashPayment);
        stringBuffer.append("Dex16FreightAmt: " + _dex16FreightAmt);
        stringBuffer.append("Dex16OtherPaymentAmt: " + _dex16OtherPaymentAmt);
        stringBuffer.append("Dex16OtherDocNbr: " + _dex16OtherDocNbr);
        stringBuffer.append("Dex16ScanSeqNbr: " + _dex16ScanSeqNbr);
        stringBuffer.append("ChngStatusEmployeeId: " + _chngStatusEmployeeId);
        stringBuffer.append("ChngStatusDt: " + _chngStatusDt);
        stringBuffer.append("CloseEmployeeId: " + _closeEmployeeId);
        stringBuffer.append("CloseDt: " + _closeDt);
        stringBuffer.append("EodEmployeeId: " + _eodEmployeeId);
        stringBuffer.append("EodDt: " + _eodDt);
        stringBuffer.append("LastScanType: " + _lastScanType);
        stringBuffer.append("LastScanDate: " + _lastScanDate);
        stringBuffer.append("ChkinAgentComment: " + _chkinAgentComment);
        stringBuffer.append("TrackingStatus: " + _trackingStatus);
        stringBuffer.append("StatusId: " + _statusId);
        stringBuffer.append("CashDepositSlipId: " + _cashDepositSlipId);
        stringBuffer.append("CashDepositSlipNbr: " + _cashDepositSlipNbr);
        stringBuffer.append("OtherDepositSlipId: " + _otherDepositSlipId);
        stringBuffer.append("OtherDepositSlipNbr: " + _otherDepositSlipNbr);
        stringBuffer.append("CreditCardBatchId: " + _creditCardBatchId);
        stringBuffer.append("EodId: " + _eodId);
        stringBuffer.append("FtcXmlImpDt: " + _ftcXmlImpDt);
        stringBuffer.append("PymtImpDt: " + _pymtImpDt);
        stringBuffer.append("OtherComment: " + _otherComment);
        stringBuffer.append("RecvPrepyAmt: " + _recvPrepyAmt);
        stringBuffer.append("OrigCustNm: " + _origCustNm);
        stringBuffer.append("CustChngEmpId: " + _custChngEmpId);
        stringBuffer.append("OrigRecAmt: " + _origRecAmt);
        stringBuffer.append("AmtChngEmpId: " + _amtChngEmpId);
        stringBuffer.append("RcptNbr: " + _rcptNbr);
        stringBuffer.append("OrigRcptNbr: " + _origRcptNbr);
        stringBuffer.append("RcptChngEmpId: " + _rcptChngEmpId);
        stringBuffer.append("OrigEmployeeId: " + _origEmployeeId);
        stringBuffer.append("ReassEmpId: " + _reassEmpId);
        stringBuffer.append("DualRecIdNbr: " + _dualRecIdNbr);
        stringBuffer.append("DupAwbFlg: " + _dupAwbFlg);
        stringBuffer.append("BillAccount: "+ _billAccount);
        return stringBuffer.toString();
    }

}
