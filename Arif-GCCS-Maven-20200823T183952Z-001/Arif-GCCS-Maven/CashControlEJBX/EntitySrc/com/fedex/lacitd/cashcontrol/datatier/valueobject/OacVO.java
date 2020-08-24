/**
 * @(#)OacVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the oac table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class OacVO implements java.io.Serializable {

    private Integer _obAncSvcIdNbr;
    private Date _obAncSvcDt;
    private String _locationCd;
    private String _pymtCurrCd;
    private double _cashPymtAmt;
    private double _otherPymtAmt;
    private int _otherPymtTypeCd;
    private String _otherDocNbr;
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
    private String _otherComDesc;
    private String _rcptNbr;
    private String _origRcptNbr;
    private String _rcptChngEmpNbr;
    private String _origEmpNbr;
    private String _rsgnEmpNbr;
    private Integer _dualObAncIdNbr;
    public OacVO() {
    }
    public OacVO(Integer obAncSvcIdNbr, Date obAncSvcDt, String locationCd, String pymtCurrCd, double cashPymtAmt, double otherPymtAmt, int otherPymtTypeCd, String otherDocNbr, String chngStatusEmpIdNbr, Date chngStatusDt, String closeEmpIdNbr, Date closeDt, String eodEmpIdNbr, Date eodDt, String chkinAgentComDesc, int statusCd, double exchRateAmt, String courEmpIdNbr, int cashDepSlipIdNbr, int otherDepSlipIdNbr, int eodIdNbr, String otherComDesc, String rcptNbr, String origRcptNbr, String rcptChngEmpNbr, String origEmpNbr, String rsgnEmpNbr, Integer dualObAncIdNbr) {
        _obAncSvcIdNbr = obAncSvcIdNbr;
        _obAncSvcDt = obAncSvcDt;
        _locationCd = locationCd;
        _pymtCurrCd = pymtCurrCd;
        _cashPymtAmt = cashPymtAmt;
        _otherPymtAmt = otherPymtAmt;
        _otherPymtTypeCd = otherPymtTypeCd;
        _otherDocNbr = otherDocNbr;
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
        _otherComDesc = otherComDesc;
        _rcptNbr = rcptNbr;
        _origRcptNbr = origRcptNbr;
        _rcptChngEmpNbr = rcptChngEmpNbr;
        _origEmpNbr = origEmpNbr;
        _rsgnEmpNbr = rsgnEmpNbr;
        _dualObAncIdNbr = dualObAncIdNbr;
    }
    /**
     * Set the value of obAncSvcIdNbr
     */
    public void setObAncSvcIdNbr(Integer obAncSvcIdNbr) {
        _obAncSvcIdNbr = obAncSvcIdNbr;
    }

    /**
     * Get the value of obAncSvcIdNbr
     */
    public Integer getObAncSvcIdNbr() {
        return _obAncSvcIdNbr;
    }

    /**
     * Set the value of obAncSvcDt
     */
    public void setObAncSvcDt(Date obAncSvcDt) {
        _obAncSvcDt = obAncSvcDt;
    }

    /**
     * Get the value of obAncSvcDt
     */
    public Date getObAncSvcDt() {
        return _obAncSvcDt;
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
     * Set the value of pymtCurrCd
     */
    public void setPymtCurrCd(String pymtCurrCd) {
        _pymtCurrCd = pymtCurrCd;
    }

    /**
     * Get the value of pymtCurrCd
     */
    public String getPymtCurrCd() {
        return _pymtCurrCd;
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
     * Set the value of otherComDesc
     */
    public void setOtherComDesc(String otherComDesc) {
        _otherComDesc = otherComDesc;
    }

    /**
     * Get the value of otherComDesc
     */
    public String getOtherComDesc() {
        return _otherComDesc;
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
     * Set the value of dualObAncIdNbr
     */
    public void setDualObAncIdNbr(Integer dualObAncIdNbr) {
        _dualObAncIdNbr = dualObAncIdNbr;
    }

    /**
     * Get the value of dualObAncIdNbr
     */
    public Integer getDualObAncIdNbr() {
        return _dualObAncIdNbr;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getOacPK() {
        return _obAncSvcIdNbr;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ObAncSvcIdNbr: " + _obAncSvcIdNbr);
        stringBuffer.append("ObAncSvcDt: " + _obAncSvcDt);
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("PymtCurrCd: " + _pymtCurrCd);
        stringBuffer.append("CashPymtAmt: " + _cashPymtAmt);
        stringBuffer.append("OtherPymtAmt: " + _otherPymtAmt);
        stringBuffer.append("OtherPymtTypeCd: " + _otherPymtTypeCd);
        stringBuffer.append("OtherDocNbr: " + _otherDocNbr);
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
        stringBuffer.append("OtherComDesc: " + _otherComDesc);
        stringBuffer.append("RcptNbr: " + _rcptNbr);
        stringBuffer.append("OrigRcptNbr: " + _origRcptNbr);
        stringBuffer.append("RcptChngEmpNbr: " + _rcptChngEmpNbr);
        stringBuffer.append("OrigEmpNbr: " + _origEmpNbr);
        stringBuffer.append("RsgnEmpNbr: " + _rsgnEmpNbr);
        stringBuffer.append("DualObAncIdNbr: " + _dualObAncIdNbr);
        return stringBuffer.toString();
    }

}
