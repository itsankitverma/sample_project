/**
 * @(#)GroundVO.java			Wed Nov 29 10:36:42 VET 2006
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
 * This bean map to the ground table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class GroundVO implements java.io.Serializable {

	//changes done to add to column
	private Date _miscDate;
	private String _miscNbr;
	
    private Integer _grndShpIdNbr;
    private Date _grndShpDt;
    private String _locationCd;
    private String _grndTrakNbr;
    private String _paymentCurrency;
    private double _cashPymtAmt;
    private double _otherPymtAmt;
    private int _otherPymtTypeCd;
    private String _otherDocNbr;
    private double _coupnPymtAmt;
    private String _chngStatusEmpIdNbr;
    private Date _chngStatusDt;
    private String _closeEmpIdNbr;
    private Date _closeDt;
    private String _eodEmpIdNbr;
    private Date _eodDt;
    private String _chkinAgentComDesc;
    private int _statusCd;
    private double _exchRateAmt;
    private String _courEmpIdNbr;
    private int _cashDepSlipIdNbr;
    private int _otherDepSlipIdNbr;
    private int _eodIdNbr;
    private int _coupnBatchIdNbr;
    private String _otherComDsc;
    private String _rcptNbr;
    private String _origRcptNbr;
    private String _rcptChngEmpNbr;
    private String _origEmpNbr;
    private String _rsgnEmpNbr;
    private Integer _dualGrndShipIdNbr;
    private String _custNm;
    private String _billAccount;
    public GroundVO() {
    }
    public GroundVO(Integer grndShpIdNbr, Date grndShpDt, String locationCd, String grndTrakNbr, String paymentCurrency, double cashPymtAmt, double otherPymtAmt, int otherPymtTypeCd, String otherDocNbr, double coupnPymtAmt, String chngStatusEmpIdNbr, Date chngStatusDt, String closeEmpIdNbr, Date closeDt, String eodEmpIdNbr, Date eodDt, String chkinAgentComDesc, int statusCd, double exchRateAmt, String courEmpIdNbr, int cashDepSlipIdNbr, int otherDepSlipIdNbr, int eodIdNbr, int coupnBatchIdNbr, String otherComDsc, String rcptNbr, String origRcptNbr, String rcptChngEmpNbr, String origEmpNbr, String rsgnEmpNbr, Integer dualGrndShipIdNbr, String custNm, String billAccount,java.util.Date miscDate,String miscNbr) {
        _grndShpIdNbr = grndShpIdNbr;
        _grndShpDt = grndShpDt;
        _locationCd = locationCd;
        _grndTrakNbr = grndTrakNbr;
        _paymentCurrency = paymentCurrency;
        _cashPymtAmt = cashPymtAmt;
        _otherPymtAmt = otherPymtAmt;
        _otherPymtTypeCd = otherPymtTypeCd;
        _otherDocNbr = otherDocNbr;
        _coupnPymtAmt = coupnPymtAmt;
        _chngStatusEmpIdNbr = chngStatusEmpIdNbr;
        _chngStatusDt = chngStatusDt;
        _closeEmpIdNbr = closeEmpIdNbr;
        _closeDt = closeDt;
        _eodEmpIdNbr = eodEmpIdNbr;
        _eodDt = eodDt;
        _chkinAgentComDesc = chkinAgentComDesc;
        _statusCd = statusCd;
        _exchRateAmt = exchRateAmt;
        _courEmpIdNbr = courEmpIdNbr;
        _cashDepSlipIdNbr = cashDepSlipIdNbr;
        _otherDepSlipIdNbr = otherDepSlipIdNbr;
        _eodIdNbr = eodIdNbr;
        _coupnBatchIdNbr = coupnBatchIdNbr;
        _otherComDsc = otherComDsc;
        _rcptNbr = rcptNbr;
        _origRcptNbr = origRcptNbr;
        _rcptChngEmpNbr = rcptChngEmpNbr;
        _origEmpNbr = origEmpNbr;
        _rsgnEmpNbr = rsgnEmpNbr;
        _dualGrndShipIdNbr = dualGrndShipIdNbr;
        _custNm = custNm;
        _billAccount = billAccount;
        //added to add the two new columns miscDate,miscNbr
        _miscDate = miscDate;
        _miscNbr = miscNbr;
    }
    
    //function added to add the two new columns miscDate,miscNbr
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
     * Set the value of grndShpIdNbr
     */
    public void setGrndShpIdNbr(Integer grndShpIdNbr) {
        _grndShpIdNbr = grndShpIdNbr;
    }

    /**
     * Get the value of grndShpIdNbr
     */
    public Integer getGrndShpIdNbr() {
        return _grndShpIdNbr;
    }

    /**
     * Set the value of grndShpDt
     */
    public void setGrndShpDt(Date grndShpDt) {
        _grndShpDt = grndShpDt;
    }

    /**
     * Get the value of grndShpDt
     */
    public Date getGrndShpDt() {
        return _grndShpDt;
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
     * Set the value of grndTrakNbr
     */
    public void setGrndTrakNbr(String grndTrakNbr) {
        _grndTrakNbr = grndTrakNbr;
    }

    /**
     * Get the value of grndTrakNbr
     */
    public String getGrndTrakNbr() {
        return _grndTrakNbr;
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
     * Set the value of cashPymtAmt
     */
    public void setCashPymtAmt(double cashPymtAmt) {
        _cashPymtAmt = cashPymtAmt;
    }

    /**
     * Get the value of cashPymtAmt
     */
    public double getCashPymtAmt() {
        return _cashPymtAmt;
    }

    /**
     * Set the value of otherPymtAmt
     */
    public void setOtherPymtAmt(double otherPymtAmt) {
        _otherPymtAmt = otherPymtAmt;
    }

    /**
     * Get the value of otherPymtAmt
     */
    public double getOtherPymtAmt() {
        return _otherPymtAmt;
    }

    /**
     * Set the value of otherPymtTypeCd
     */
    public void setOtherPymtTypeCd(int otherPymtTypeCd) {
        _otherPymtTypeCd = otherPymtTypeCd;
    }

    /**
     * Get the value of otherPymtTypeCd
     */
    public int getOtherPymtTypeCd() {
        return _otherPymtTypeCd;
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
     * Set the value of coupnPymtAmt
     */
    public void setCoupnPymtAmt(double coupnPymtAmt) {
        _coupnPymtAmt = coupnPymtAmt;
    }

    /**
     * Get the value of coupnPymtAmt
     */
    public double getCoupnPymtAmt() {
        return _coupnPymtAmt;
    }

    /**
     * Set the value of chngStatusEmpIdNbr
     */
    public void setChngStatusEmpIdNbr(String chngStatusEmpIdNbr) {
        _chngStatusEmpIdNbr = chngStatusEmpIdNbr;
    }

    /**
     * Get the value of chngStatusEmpIdNbr
     */
    public String getChngStatusEmpIdNbr() {
        return _chngStatusEmpIdNbr;
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
     * Set the value of closeEmpIdNbr
     */
    public void setCloseEmpIdNbr(String closeEmpIdNbr) {
        _closeEmpIdNbr = closeEmpIdNbr;
    }

    /**
     * Get the value of closeEmpIdNbr
     */
    public String getCloseEmpIdNbr() {
        return _closeEmpIdNbr;
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
     * Set the value of eodEmpIdNbr
     */
    public void setEodEmpIdNbr(String eodEmpIdNbr) {
        _eodEmpIdNbr = eodEmpIdNbr;
    }

    /**
     * Get the value of eodEmpIdNbr
     */
    public String getEodEmpIdNbr() {
        return _eodEmpIdNbr;
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
     * Set the value of chkinAgentComDesc
     */
    public void setChkinAgentComDesc(String chkinAgentComDesc) {
        _chkinAgentComDesc = chkinAgentComDesc;
    }

    /**
     * Get the value of chkinAgentComDesc
     */
    public String getChkinAgentComDesc() {
        return _chkinAgentComDesc;
    }

    /**
     * Set the value of statusCd
     */
    public void setStatusCd(int statusCd) {
        _statusCd = statusCd;
    }

    /**
     * Get the value of statusCd
     */
    public int getStatusCd() {
        return _statusCd;
    }

    /**
     * Set the value of exchRateAmt
     */
    public void setExchRateAmt(double exchRateAmt) {
        _exchRateAmt = exchRateAmt;
    }

    /**
     * Get the value of exchRateAmt
     */
    public double getExchRateAmt() {
        return _exchRateAmt;
    }

    /**
     * Set the value of courEmpIdNbr
     */
    public void setCourEmpIdNbr(String courEmpIdNbr) {
        _courEmpIdNbr = courEmpIdNbr;
    }

    /**
     * Get the value of courEmpIdNbr
     */
    public String getCourEmpIdNbr() {
        return _courEmpIdNbr;
    }

    /**
     * Set the value of cashDepSlipIdNbr
     */
    public void setCashDepSlipIdNbr(int cashDepSlipIdNbr) {
        _cashDepSlipIdNbr = cashDepSlipIdNbr;
    }

    /**
     * Get the value of cashDepSlipIdNbr
     */
    public int getCashDepSlipIdNbr() {
        return _cashDepSlipIdNbr;
    }

    /**
     * Set the value of otherDepSlipIdNbr
     */
    public void setOtherDepSlipIdNbr(int otherDepSlipIdNbr) {
        _otherDepSlipIdNbr = otherDepSlipIdNbr;
    }

    /**
     * Get the value of otherDepSlipIdNbr
     */
    public int getOtherDepSlipIdNbr() {
        return _otherDepSlipIdNbr;
    }

    /**
     * Set the value of eodIdNbr
     */
    public void setEodIdNbr(int eodIdNbr) {
        _eodIdNbr = eodIdNbr;
    }

    /**
     * Get the value of eodIdNbr
     */
    public int getEodIdNbr() {
        return _eodIdNbr;
    }

    /**
     * Set the value of coupnBatchIdNbr
     */
    public void setCoupnBatchIdNbr(int coupnBatchIdNbr) {
        _coupnBatchIdNbr = coupnBatchIdNbr;
    }

    /**
     * Get the value of coupnBatchIdNbr
     */
    public int getCoupnBatchIdNbr() {
        return _coupnBatchIdNbr;
    }

    /**
     * Set the value of otherComDsc
     */
    public void setOtherComDsc(String otherComDsc) {
        _otherComDsc = otherComDsc;
    }

    /**
     * Get the value of otherComDsc
     */
    public String getOtherComDsc() {
        return _otherComDsc;
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
     * Set the value of rcptChngEmpNbr
     */
    public void setRcptChngEmpNbr(String rcptChngEmpNbr) {
        _rcptChngEmpNbr = rcptChngEmpNbr;
    }

    /**
     * Get the value of rcptChngEmpNbr
     */
    public String getRcptChngEmpNbr() {
        return _rcptChngEmpNbr;
    }

    /**
     * Set the value of origEmpNbr
     */
    public void setOrigEmpNbr(String origEmpNbr) {
        _origEmpNbr = origEmpNbr;
    }

    /**
     * Get the value of origEmpNbr
     */
    public String getOrigEmpNbr() {
        return _origEmpNbr;
    }

    /**
     * Set the value of rsgnEmpNbr
     */
    public void setRsgnEmpNbr(String rsgnEmpNbr) {
        _rsgnEmpNbr = rsgnEmpNbr;
    }

    /**
     * Get the value of rsgnEmpNbr
     */
    public String getRsgnEmpNbr() {
        return _rsgnEmpNbr;
    }

    /**
     * Set the value of dualGrndShipIdNbr
     */
    public void setDualGrndShipIdNbr(Integer dualGrndShipIdNbr) {
        _dualGrndShipIdNbr = dualGrndShipIdNbr;
    }

    /**
     * Get the value of dualGrndShipIdNbr
     */
    public Integer getDualGrndShipIdNbr() {
        return _dualGrndShipIdNbr;
    }

    /**
     * Set the value of custNm
     */
    public void setCustNm(String custNm) {
        _custNm = custNm;
    }

    /**
     * Get the value of custNm
     */
    public String getCustNm() {
        return _custNm;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getGroundPK() {
        return _grndShpIdNbr;
    }

    /**
     * Set the value of billAccount
     */
    public void setBillAccount(String billAccount) {
        _billAccount = billAccount;
    }

    /**
     * Get the value of billAccount
     */
    public String getBillAccount() {
        return _billAccount;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GrndShpIdNbr: " + _grndShpIdNbr);
        stringBuffer.append("GrndShpDt: " + _grndShpDt);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("GrndTrakNbr: " + _grndTrakNbr);
        stringBuffer.append("PaymentCurrency: " + _paymentCurrency);
        stringBuffer.append("CashPymtAmt: " + _cashPymtAmt);
        stringBuffer.append("OtherPymtAmt: " + _otherPymtAmt);
        stringBuffer.append("OtherPymtTypeCd: " + _otherPymtTypeCd);
        stringBuffer.append("OtherDocNbr: " + _otherDocNbr);
        stringBuffer.append("CoupnPymtAmt: " + _coupnPymtAmt);
        stringBuffer.append("ChngStatusEmpIdNbr: " + _chngStatusEmpIdNbr);
        stringBuffer.append("ChngStatusDt: " + _chngStatusDt);
        stringBuffer.append("CloseEmpIdNbr: " + _closeEmpIdNbr);
        stringBuffer.append("CloseDt: " + _closeDt);
        stringBuffer.append("EodEmpIdNbr: " + _eodEmpIdNbr);
        stringBuffer.append("EodDt: " + _eodDt);
        stringBuffer.append("ChkinAgentComDesc: " + _chkinAgentComDesc);
        stringBuffer.append("StatusCd: " + _statusCd);
        stringBuffer.append("ExchRateAmt: " + _exchRateAmt);
        stringBuffer.append("CourEmpIdNbr: " + _courEmpIdNbr);
        stringBuffer.append("CashDepSlipIdNbr: " + _cashDepSlipIdNbr);
        stringBuffer.append("OtherDepSlipIdNbr: " + _otherDepSlipIdNbr);
        stringBuffer.append("EodIdNbr: " + _eodIdNbr);
        stringBuffer.append("CoupnBatchIdNbr: " + _coupnBatchIdNbr);
        stringBuffer.append("OtherComDsc: " + _otherComDsc);
        stringBuffer.append("RcptNbr: " + _rcptNbr);
        stringBuffer.append("OrigRcptNbr: " + _origRcptNbr);
        stringBuffer.append("RcptChngEmpNbr: " + _rcptChngEmpNbr);
        stringBuffer.append("OrigEmpNbr: " + _origEmpNbr);
        stringBuffer.append("RsgnEmpNbr: " + _rsgnEmpNbr);
        stringBuffer.append("DualGrndShipIdNbr: " + _dualGrndShipIdNbr);
        stringBuffer.append("CustNm: " + _custNm);
        stringBuffer.append("BillAccount: "+ _billAccount);
        return stringBuffer.toString();
    }

}
