/**
 * @(#)ReceivablesBean.java			Tue Aug 02 15:38:49 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;

import javax.ejb.*;

public abstract class COD_ReceivablesBean implements EntityBean {

    private EntityContext _ctx;
    public COD_ReceivablesBean() {
    }
    /**
     * Set the value of recId
     * @param recId - Integer of recId
     */
    public abstract void setRecId(Integer recId);
    /**
     * Get the value of recId
     * @return recId - Integer of recId
     */
    public abstract Integer getRecId();

    //added to add the two new columns miscDate, miscNbr
	public abstract Date getMiscDate();
	public abstract void setMiscDate(Date miscDate) ;
	public abstract String getMiscNbr();
	public abstract void setMiscNbr(String miscNbr);
    
    /**
     * Set the value of recNbr
     * @param recNbr - String of recNbr
     */
    public abstract void setRecNbr(String recNbr);

    /**
     * Get the value of recNbr
     * @return recNbr - String of recNbr
     */
    public abstract String getRecNbr();

    /**
     * Set the value of customerNm
     * @param customerNm - String of customerNm
     */
    public abstract void setCustomerNm(String customerNm);

    /**
     * Get the value of customerNm
     * @return customerNm - String of customerNm
     */
    public abstract String getCustomerNm();

    /**
     * Set the value of recDt
     * @param recDt - Date of recDt
     */
    public abstract void setRecDt(Date recDt);

    /**
     * Get the value of recDt
     * @return recDt - Date of recDt
     */
    public abstract Date getRecDt();

    /**
     * Set the value of invCurrency
     * @param invCurrency - String of invCurrency
     */
    public abstract void setInvCurrency(String invCurrency);

    /**
     * Get the value of invCurrency
     * @return invCurrency - String of invCurrency
     */
    public abstract String getInvCurrency();

    /**
     * Set the value of codAmt
     * @param codAmt - double of codAmt
     */
    public abstract void setCodAmt(double codAmt);

    /**
     * Get the value of codAmt
     * @return codAmt - double of codAmt
     */
    public abstract double getCodAmt();

    /**
     * Set the value of ancChargeAmt
     * @param ancChargeAmt - double of ancChargeAmt
     */
    public abstract void setAncChargeAmt(double ancChargeAmt);

    /**
     * Get the value of ancChargeAmt
     * @return ancChargeAmt - double of ancChargeAmt
     */
    public abstract double getAncChargeAmt();

    /**
     * Set the value of recAmt
     * @param recAmt - double of recAmt
     */
    public abstract void setRecAmt(double recAmt);

    /**
     * Get the value of recAmt
     * @return recAmt - double of recAmt
     */
    public abstract double getRecAmt();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public abstract void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public abstract String getLocationCd();

    /**
     * Set the value of awbNbr
     * @param awbNbr - String of awbNbr
     */
    public abstract void setAwbNbr(String awbNbr);

    /**
     * Get the value of awbNbr
     * @return awbNbr - String of awbNbr
     */
    public abstract String getAwbNbr();

    /**
     * Set the value of tinUniqId
     * @param tinUniqId - String of tinUniqId
     */
    public abstract void setTinUniqId(String tinUniqId);

    /**
     * Get the value of tinUniqId
     * @return tinUniqId - String of tinUniqId
     */
    public abstract String getTinUniqId();

    /**
     * Set the value of exchRateClnUsed
     * @param exchRateClnUsed - double of exchRateClnUsed
     */
    public abstract void setExchRateClnUsed(double exchRateClnUsed);

    /**
     * Get the value of exchRateClnUsed
     * @return exchRateClnUsed - double of exchRateClnUsed
     */
    public abstract double getExchRateClnUsed();

    /**
     * Set the value of employeeId
     * @param employeeId - String of employeeId
     */
    public abstract void setEmployeeId(String employeeId);

    /**
     * Get the value of employeeId
     * @return employeeId - String of employeeId
     */
    public abstract String getEmployeeId();

    /**
     * Set the value of paymentCurrency
     * @param paymentCurrency - String of paymentCurrency
     */
    public abstract void setPaymentCurrency(String paymentCurrency);

    /**
     * Get the value of paymentCurrency
     * @return paymentCurrency - String of paymentCurrency
     */
    public abstract String getPaymentCurrency();

    /**
     * Set the value of cashPaymentAmt
     * @param cashPaymentAmt - double of cashPaymentAmt
     */
    public abstract void setCashPaymentAmt(double cashPaymentAmt);

    /**
     * Get the value of cashPaymentAmt
     * @return cashPaymentAmt - double of cashPaymentAmt
     */
    public abstract double getCashPaymentAmt();

    /**
     * Set the value of otherPaymentAmt
     * @param otherPaymentAmt - double of otherPaymentAmt
     */
    public abstract void setOtherPaymentAmt(double otherPaymentAmt);

    /**
     * Get the value of otherPaymentAmt
     * @return otherPaymentAmt - double of otherPaymentAmt
     */
    public abstract double getOtherPaymentAmt();

    /**
     * Set the value of otherPaymentType
     * @param otherPaymentType - int of otherPaymentType
     */
    public abstract void setOtherPaymentType(int otherPaymentType);

    /**
     * Get the value of otherPaymentType
     * @return otherPaymentType - int of otherPaymentType
     */
    public abstract int getOtherPaymentType();

    /**
     * Set the value of otherDocNbr
     * @param otherDocNbr - String of otherDocNbr
     */
    public abstract void setOtherDocNbr(String otherDocNbr);

    /**
     * Get the value of otherDocNbr
     * @return otherDocNbr - String of otherDocNbr
     */
    public abstract String getOtherDocNbr();

    /**
     * Set the value of dex11CashPayment
     * @param dex11CashPayment - double of dex11CashPayment
     */
    public abstract void setDex11CashPayment(double dex11CashPayment);

    /**
     * Get the value of dex11CashPayment
     * @return dex11CashPayment - double of dex11CashPayment
     */
    public abstract double getDex11CashPayment();

    /**
     * Set the value of dex11FreightAmt
     * @param dex11FreightAmt - double of dex11FreightAmt
     */
    public abstract void setDex11FreightAmt(double dex11FreightAmt);

    /**
     * Get the value of dex11FreightAmt
     * @return dex11FreightAmt - double of dex11FreightAmt
     */
    public abstract double getDex11FreightAmt();

    /**
     * Set the value of dex11OtherPaymentAmt
     * @param dex11OtherPaymentAmt - double of dex11OtherPaymentAmt
     */
    public abstract void setDex11OtherPaymentAmt(double dex11OtherPaymentAmt);

    /**
     * Get the value of dex11OtherPaymentAmt
     * @return dex11OtherPaymentAmt - double of dex11OtherPaymentAmt
     */
    public abstract double getDex11OtherPaymentAmt();

    /**
     * Set the value of dex11OtherDocNbr
     * @param dex11OtherDocNbr - String of dex11OtherDocNbr
     */
    public abstract void setDex11OtherDocNbr(String dex11OtherDocNbr);

    /**
     * Get the value of dex11OtherDocNbr
     * @return dex11OtherDocNbr - String of dex11OtherDocNbr
     */
    public abstract String getDex11OtherDocNbr();

    /**
     * Set the value of dex11ScanSeqNbr
     * @param dex11ScanSeqNbr - String of dex11ScanSeqNbr
     */
    public abstract void setDex11ScanSeqNbr(String dex11ScanSeqNbr);

    /**
     * Get the value of dex11ScanSeqNbr
     * @return dex11ScanSeqNbr - String of dex11ScanSeqNbr
     */
    public abstract String getDex11ScanSeqNbr();

    /**
     * Set the value of chngStatusEmployeeId
     * @param chngStatusEmployeeId - String of chngStatusEmployeeId
     */
    public abstract void setChngStatusEmployeeId(String chngStatusEmployeeId);

    /**
     * Get the value of chngStatusEmployeeId
     * @return chngStatusEmployeeId - String of chngStatusEmployeeId
     */
    public abstract String getChngStatusEmployeeId();

    /**
     * Set the value of chngStatusDt
     * @param chngStatusDt - Date of chngStatusDt
     */
    public abstract void setChngStatusDt(Date chngStatusDt);

    /**
     * Get the value of chngStatusDt
     * @return chngStatusDt - Date of chngStatusDt
     */
    public abstract Date getChngStatusDt();

    /**
     * Set the value of closeEmployeeId
     * @param closeEmployeeId - String of closeEmployeeId
     */
    public abstract void setCloseEmployeeId(String closeEmployeeId);

    /**
     * Get the value of closeEmployeeId
     * @return closeEmployeeId - String of closeEmployeeId
     */
    public abstract String getCloseEmployeeId();

    /**
     * Set the value of closeDt
     * @param closeDt - Date of closeDt
     */
    public abstract void setCloseDt(Date closeDt);

    /**
     * Get the value of closeDt
     * @return closeDt - Date of closeDt
     */
    public abstract Date getCloseDt();

    /**
     * Set the value of eodEmployeeId
     * @param eodEmployeeId - String of eodEmployeeId
     */
    public abstract void setEodEmployeeId(String eodEmployeeId);

    /**
     * Get the value of eodEmployeeId
     * @return eodEmployeeId - String of eodEmployeeId
     */
    public abstract String getEodEmployeeId();

    /**
     * Set the value of eodDt
     * @param eodDt - Date of eodDt
     */
    public abstract void setEodDt(Date eodDt);

    /**
     * Get the value of eodDt
     * @return eodDt - Date of eodDt
     */
    public abstract Date getEodDt();

    /**
     * Set the value of lastScanType
     * @param lastScanType - String of lastScanType
     */
    public abstract void setLastScanType(String lastScanType);

    /**
     * Get the value of lastScanType
     * @return lastScanType - String of lastScanType
     */
    public abstract String getLastScanType();

    /**
     * Set the value of lastScanDate
     * @param lastScanDate - Date of lastScanDate
     */
    public abstract void setLastScanDate(Date lastScanDate);

    /**
     * Get the value of lastScanDate
     * @return lastScanDate - Date of lastScanDate
     */
    public abstract Date getLastScanDate();

    /**
     * Set the value of chkinAgentComment
     * @param chkinAgentComment - String of chkinAgentComment
     */
    public abstract void setChkinAgentComment(String chkinAgentComment);

    /**
     * Get the value of chkinAgentComment
     * @return chkinAgentComment - String of chkinAgentComment
     */
    public abstract String getChkinAgentComment();

    /**
     * Set the value of trackingStatus
     * @param trackingStatus - int of trackingStatus
     */
    public abstract void setTrackingStatus(int trackingStatus);

    /**
     * Get the value of trackingStatus
     * @return trackingStatus - int of trackingStatus
     */
    public abstract int getTrackingStatus();

    /**
     * Set the value of statusId
     * @param statusId - int of statusId
     */
    public abstract void setStatusId(int statusId);

    /**
     * Get the value of statusId
     * @return statusId - int of statusId
     */
    public abstract int getStatusId();

    /**
     * Set the value of cashDepositSlipId
     * @param cashDepositSlipId - int of cashDepositSlipId
     */
    public abstract void setCashDepositSlipId(int cashDepositSlipId);

    /**
     * Get the value of cashDepositSlipId
     * @return cashDepositSlipId - int of cashDepositSlipId
     */
    public abstract int getCashDepositSlipId();

    /**
     * Set the value of cashDepositSlipNbr
     * @param cashDepositSlipNbr - String of cashDepositSlipNbr
     */
    public abstract void setCashDepositSlipNbr(String cashDepositSlipNbr);

    /**
     * Get the value of cashDepositSlipNbr
     * @return cashDepositSlipNbr - String of cashDepositSlipNbr
     */
    public abstract String getCashDepositSlipNbr();

    /**
     * Set the value of otherDepositSlipId
     * @param otherDepositSlipId - int of otherDepositSlipId
     */
    public abstract void setOtherDepositSlipId(int otherDepositSlipId);

    /**
     * Get the value of otherDepositSlipId
     * @return otherDepositSlipId - int of otherDepositSlipId
     */
    public abstract int getOtherDepositSlipId();

    /**
     * Set the value of otherDepositSlipNbr
     * @param otherDepositSlipNbr - String of otherDepositSlipNbr
     */
    public abstract void setOtherDepositSlipNbr(String otherDepositSlipNbr);

    /**
     * Get the value of otherDepositSlipNbr
     * @return otherDepositSlipNbr - String of otherDepositSlipNbr
     */
    public abstract String getOtherDepositSlipNbr();

    /**
     * Set the value of creditCardBatchId
     * @param creditCardBatchId - String of creditCardBatchId
     */
    public abstract void setCreditCardBatchId(String creditCardBatchId);

    /**
     * Get the value of creditCardBatchId
     * @return creditCardBatchId - String of creditCardBatchId
     */
    public abstract String getCreditCardBatchId();

    /**
     * Set the value of eodId
     * @param eodId - int of eodId
     */
    public abstract void setEodId(int eodId);

    /**
     * Get the value of eodId
     * @return eodId - int of eodId
     */
    public abstract int getEodId();

    /**
     * Set the value of codXmlImpDt
     * @param codXmlImpDt - Date of codXmlImpDt
     */
    public abstract void setCodXmlImpDt(Date codXmlImpDt);

    /**
     * Get the value of codXmlImpDt
     * @return codXmlImpDt - Date of codXmlImpDt
     */
    public abstract Date getCodXmlImpDt();

    /**
     * Set the value of pymtImpDt
     * @param pymtImpDt - Date of pymtImpDt
     */
    public abstract void setPymtImpDt(Date pymtImpDt);

    /**
     * Get the value of pymtImpDt
     * @return pymtImpDt - Date of pymtImpDt
     */
    public abstract Date getPymtImpDt();

    /**
     * Set the value of otherComment
     * @param otherComment - String of otherComment
     */
    public abstract void setOtherComment(String otherComment);

    /**
     * Get the value of otherComment
     * @return otherComment - String of otherComment
     */
    public abstract String getOtherComment();

    /**
     * Set the value of recvPrepyAmt
     * @param recvPrepyAmt - double of recvPrepyAmt
     */
    public abstract void setRecvPrepyAmt(double recvPrepyAmt);

    /**
     * Get the value of recvPrepyAmt
     * @return recvPrepyAmt - double of recvPrepyAmt
     */
    public abstract double getRecvPrepyAmt();

    /**
     * Set the value of origCustNm
     * @param origCustNm - String of origCustNm
     */
    public abstract void setOrigCustNm(String origCustNm);

    /**
     * Get the value of origCustNm
     * @return origCustNm - String of origCustNm
     */
    public abstract String getOrigCustNm();

    /**
     * Set the value of custChngEmpId
     * @param custChngEmpId - String of custChngEmpId
     */
    public abstract void setCustChngEmpId(String custChngEmpId);

    /**
     * Get the value of custChngEmpId
     * @return custChngEmpId - String of custChngEmpId
     */
    public abstract String getCustChngEmpId();

    /**
     * Set the value of origRecAmt
     * @param origRecAmt - double of origRecAmt
     */
    public abstract void setOrigRecAmt(double origRecAmt);

    /**
     * Get the value of origRecAmt
     * @return origRecAmt - double of origRecAmt
     */
    public abstract double getOrigRecAmt();

    /**
     * Set the value of amtChngEmpId
     * @param amtChngEmpId - String of amtChngEmpId
     */
    public abstract void setAmtChngEmpId(String amtChngEmpId);

    /**
     * Get the value of amtChngEmpId
     * @return amtChngEmpId - String of amtChngEmpId
     */
    public abstract String getAmtChngEmpId();

    /**
     * Set the value of rcptNbr
     * @param rcptNbr - String of rcptNbr
     */
    public abstract void setRcptNbr(String rcptNbr);

    /**
     * Get the value of rcptNbr
     * @return rcptNbr - String of rcptNbr
     */
    public abstract String getRcptNbr();

    /**
     * Set the value of origRcptNbr
     * @param origRcptNbr - String of origRcptNbr
     */
    public abstract void setOrigRcptNbr(String origRcptNbr);

    /**
     * Get the value of origRcptNbr
     * @return origRcptNbr - String of origRcptNbr
     */
    public abstract String getOrigRcptNbr();

    /**
     * Set the value of rcptChngEmpId
     * @param rcptChngEmpId - String of rcptChngEmpId
     */
    public abstract void setRcptChngEmpId(String rcptChngEmpId);

    /**
     * Get the value of rcptChngEmpId
     * @return rcptChngEmpId - String of rcptChngEmpId
     */
    public abstract String getRcptChngEmpId();

    /**
     * Set the value of origEmployeeId
     * @param origEmployeeId - String of origEmployeeId
     */
    public abstract void setOrigEmployeeId(String origEmployeeId);

    /**
     * Get the value of origEmployeeId
     * @return origEmployeeId - String of origEmployeeId
     */
    public abstract String getOrigEmployeeId();

    /**
     * Set the value of reassEmpId
     * @param reassEmpId - String of reassEmpId
     */
    public abstract void setReassEmpId(String reassEmpId);

    /**
     * Get the value of reassEmpId
     * @return reassEmpId - String of reassEmpId
     */
    public abstract String getReassEmpId();

    /**
     * Set the value of dualRecIdNbr
     * @param dualRecIdNbr - Integer of dualRecIdNbr
     */
    public abstract void setDualRecIdNbr(Integer dualRecIdNbr);

    /**
     * Get the value of dualRecIdNbr
     * @return dualRecIdNbr - Integer of dualRecIdNbr
     */
    public abstract Integer getDualRecIdNbr();

    /**
     * Set the value of dupAwbFlg
     * @param dupAwbFlg - String of dupAwbFlg
     */
    public abstract void setDupAwbFlg(String dupAwbFlg);

    /**
     * Get the value of dupAwbFlg
     * @return dupAwbFlg - String of dupAwbFlg
     */
    public abstract String getDupAwbFlg();

    /**
     * Set the value of billAccount
     * @param billAccount - String of billAccount
     */
    public abstract void setBillAccount(String billAccount);

    /**
     * Get the value of billAccount
     * @return billAccount - String of billAccount
     */
    public abstract String getBillAccount();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String recNbr, String customerNm, Date recDt, String invCurrency, double codAmt, double ancChargeAmt, double recAmt, String locationCd, String awbNbr, String tinUniqId, double exchRateClnUsed, String employeeId, String paymentCurrency, double cashPaymentAmt, double otherPaymentAmt, int otherPaymentType, String otherDocNbr, double dex11CashPayment, double dex11FreightAmt, double dex11OtherPaymentAmt, String dex11OtherDocNbr, String dex11ScanSeqNbr, String chngStatusEmployeeId, Date chngStatusDt, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String lastScanType, Date lastScanDate, String chkinAgentComment, int trackingStatus, int statusId, int cashDepositSlipId, String cashDepositSlipNbr, int otherDepositSlipId, String otherDepositSlipNbr, String creditCardBatchId, int eodId, Date codXmlImpDt, Date pymtImpDt, String otherComment, double recvPrepyAmt, String origCustNm, String custChngEmpId, double origRecAmt, String amtChngEmpId, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Integer dualRecIdNbr, String dupAwbFlg, String billAccount,Date miscDate,String miscNbr)
        throws CreateException {
        setRecNbr(recNbr);
        setCustomerNm(customerNm);
        setRecDt(recDt);
        setInvCurrency(invCurrency);
        setCodAmt(codAmt);
        setAncChargeAmt(ancChargeAmt);
        setRecAmt(recAmt);
        setLocationCd(locationCd);
        setAwbNbr(awbNbr);
        setTinUniqId(tinUniqId);
        setExchRateClnUsed(exchRateClnUsed);
        setEmployeeId(employeeId);
        setPaymentCurrency(paymentCurrency);
        setCashPaymentAmt(cashPaymentAmt);
        setOtherPaymentAmt(otherPaymentAmt);
        setOtherPaymentType(otherPaymentType);
        setOtherDocNbr(otherDocNbr);
        setDex11CashPayment(dex11CashPayment);
        setDex11FreightAmt(dex11FreightAmt);
        setDex11OtherPaymentAmt(dex11OtherPaymentAmt);
        setDex11OtherDocNbr(dex11OtherDocNbr);
        setDex11ScanSeqNbr(dex11ScanSeqNbr);
        setChngStatusEmployeeId(chngStatusEmployeeId);
        setChngStatusDt(chngStatusDt);
        setCloseEmployeeId(closeEmployeeId);
        setCloseDt(closeDt);
        setEodEmployeeId(eodEmployeeId);
        setEodDt(eodDt);
        setLastScanType(lastScanType);
        setLastScanDate(lastScanDate);
        setChkinAgentComment(chkinAgentComment);
        setTrackingStatus(trackingStatus);
        setStatusId(statusId);
        setCashDepositSlipId(cashDepositSlipId);
        setCashDepositSlipNbr(cashDepositSlipNbr);
        setOtherDepositSlipId(otherDepositSlipId);
        setOtherDepositSlipNbr(otherDepositSlipNbr);
        setCreditCardBatchId(creditCardBatchId);
        setEodId(eodId);
        setCodXmlImpDt(codXmlImpDt);
        setPymtImpDt(pymtImpDt);
        setOtherComment(otherComment);
        setRecvPrepyAmt(recvPrepyAmt);
        setOrigCustNm(origCustNm);
        setCustChngEmpId(custChngEmpId);
        setOrigRecAmt(origRecAmt);
        setAmtChngEmpId(amtChngEmpId);
        setRcptNbr(rcptNbr);
        setOrigRcptNbr(origRcptNbr);
        setRcptChngEmpId(rcptChngEmpId);
        setOrigEmployeeId(origEmployeeId);
        setReassEmpId(reassEmpId);
        setDualRecIdNbr(dualRecIdNbr);
        setDupAwbFlg(dupAwbFlg);
        setBillAccount(billAccount);
        //added to add the two new columns miscDate,miscNbr
        setMiscDate(miscDate);
        setMiscNbr(miscNbr);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String recNbr, String customerNm, Date recDt, String invCurrency, double codAmt, double ancChargeAmt, double recAmt, String locationCd, String awbNbr, String tinUniqId, double exchRateClnUsed, String employeeId, String paymentCurrency, double cashPaymentAmt, double otherPaymentAmt, int otherPaymentType, String otherDocNbr, double dex11CashPayment, double dex11FreightAmt, double dex11OtherPaymentAmt, String dex11OtherDocNbr, String dex11ScanSeqNbr, String chngStatusEmployeeId, Date chngStatusDt, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String lastScanType, Date lastScanDate, String chkinAgentComment, int trackingStatus, int statusId, int cashDepositSlipId, String cashDepositSlipNbr, int otherDepositSlipId, String otherDepositSlipNbr, String creditCardBatchId, int eodId, Date codXmlImpDt, Date pymtImpDt, String otherComment, double recvPrepyAmt, String origCustNm, String custChngEmpId, double origRecAmt, String amtChngEmpId, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Integer dualRecIdNbr, String dupAwbFlg, String billAccount,Date miscDate,String miscNbr)
        throws CreateException {
    }

    /**
     * Called by Container.  Associates this Bean instance with a particular context environment.
     */
    public void setEntityContext(EntityContext ctx) {
        _ctx = ctx;
    }

    /**
     * Called by Container.  Disassociates this Bean instance with a particular
     * context.  Once done, we can query the Context for environment information
     */
    public void unsetEntityContext() {
        _ctx = null;
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * Called by Container.  Updates the entity bean instance to reflect
     * the current value stored in the database.
     */
    public void ejbLoad() {
    }

    /**
     * Called by Container.  Updates the database to reflect the current values
     * of this in-memory Entity Bean instance representation.
     */
    public void ejbStore() {
    }

    /**
     * EJB Container calls this method right before it remove the Entity bean
     * from the database.  Corresponds to when client calls home.remove().
     */
    public void ejbRemove() {
    }

}
