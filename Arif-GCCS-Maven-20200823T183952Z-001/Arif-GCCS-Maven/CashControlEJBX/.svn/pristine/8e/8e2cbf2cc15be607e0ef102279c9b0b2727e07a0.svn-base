/**
 * @(#)COD_ReceivablesLocal.java			Tue Aug 02 15:38:49 VET 2005
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

public interface COD_ReceivablesLocal extends EJBLocalObject {

    /**
     * Set the value of recId
     * @param recId - Integer of recId
     */
	//to add the two new columns miscDate, miscNbr 
	public Date getMiscDate();
	public void setMiscDate(Date miscDate) ;
	public String getMiscNbr();
	public void setMiscNbr(String miscNbr);
	
    public void setRecId(Integer recId);

    /**
     * Get the value of recId
     * @return recId - Integer of recId
     */
    public Integer getRecId();

    /**
     * Set the value of recNbr
     * @param recNbr - String of recNbr
     */
    public void setRecNbr(String recNbr);

    /**
     * Get the value of recNbr
     * @return recNbr - String of recNbr
     */
    public String getRecNbr();

    /**
     * Set the value of customerNm
     * @param customerNm - String of customerNm
     */
    public void setCustomerNm(String customerNm);

    /**
     * Get the value of customerNm
     * @return customerNm - String of customerNm
     */
    public String getCustomerNm();

    /**
     * Set the value of recDt
     * @param recDt - Date of recDt
     */
    public void setRecDt(Date recDt);

    /**
     * Get the value of recDt
     * @return recDt - Date of recDt
     */
    public Date getRecDt();

    /**
     * Set the value of invCurrency
     * @param invCurrency - String of invCurrency
     */
    public void setInvCurrency(String invCurrency);

    /**
     * Get the value of invCurrency
     * @return invCurrency - String of invCurrency
     */
    public String getInvCurrency();

    /**
     * Set the value of codAmt
     * @param codAmt - double of codAmt
     */
    public void setCodAmt(double codAmt);

    /**
     * Get the value of codAmt
     * @return codAmt - double of codAmt
     */
    public double getCodAmt();

    /**
     * Set the value of ancChargeAmt
     * @param ancChargeAmt - double of ancChargeAmt
     */
    public void setAncChargeAmt(double ancChargeAmt);

    /**
     * Get the value of ancChargeAmt
     * @return ancChargeAmt - double of ancChargeAmt
     */
    public double getAncChargeAmt();

    /**
     * Set the value of recAmt
     * @param recAmt - double of recAmt
     */
    public void setRecAmt(double recAmt);

    /**
     * Get the value of recAmt
     * @return recAmt - double of recAmt
     */
    public double getRecAmt();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public String getLocationCd();

    /**
     * Set the value of awbNbr
     * @param awbNbr - String of awbNbr
     */
    public void setAwbNbr(String awbNbr);

    /**
     * Get the value of awbNbr
     * @return awbNbr - String of awbNbr
     */
    public String getAwbNbr();

    /**
     * Set the value of tinUniqId
     * @param tinUniqId - String of tinUniqId
     */
    public void setTinUniqId(String tinUniqId);

    /**
     * Get the value of tinUniqId
     * @return tinUniqId - String of tinUniqId
     */
    public String getTinUniqId();

    /**
     * Set the value of exchRateClnUsed
     * @param exchRateClnUsed - double of exchRateClnUsed
     */
    public void setExchRateClnUsed(double exchRateClnUsed);

    /**
     * Get the value of exchRateClnUsed
     * @return exchRateClnUsed - double of exchRateClnUsed
     */
    public double getExchRateClnUsed();

    /**
     * Set the value of employeeId
     * @param employeeId - String of employeeId
     */
    public void setEmployeeId(String employeeId);

    /**
     * Get the value of employeeId
     * @return employeeId - String of employeeId
     */
    public String getEmployeeId();

    /**
     * Set the value of paymentCurrency
     * @param paymentCurrency - String of paymentCurrency
     */
    public void setPaymentCurrency(String paymentCurrency);

    /**
     * Get the value of paymentCurrency
     * @return paymentCurrency - String of paymentCurrency
     */
    public String getPaymentCurrency();

    /**
     * Set the value of cashPaymentAmt
     * @param cashPaymentAmt - double of cashPaymentAmt
     */
    public void setCashPaymentAmt(double cashPaymentAmt);

    /**
     * Get the value of cashPaymentAmt
     * @return cashPaymentAmt - double of cashPaymentAmt
     */
    public double getCashPaymentAmt();

    /**
     * Set the value of otherPaymentAmt
     * @param otherPaymentAmt - double of otherPaymentAmt
     */
    public void setOtherPaymentAmt(double otherPaymentAmt);

    /**
     * Get the value of otherPaymentAmt
     * @return otherPaymentAmt - double of otherPaymentAmt
     */
    public double getOtherPaymentAmt();

    /**
     * Set the value of otherPaymentType
     * @param otherPaymentType - int of otherPaymentType
     */
    public void setOtherPaymentType(int otherPaymentType);

    /**
     * Get the value of otherPaymentType
     * @return otherPaymentType - int of otherPaymentType
     */
    public int getOtherPaymentType();

    /**
     * Set the value of otherDocNbr
     * @param otherDocNbr - String of otherDocNbr
     */
    public void setOtherDocNbr(String otherDocNbr);

    /**
     * Get the value of otherDocNbr
     * @return otherDocNbr - String of otherDocNbr
     */
    public String getOtherDocNbr();

    /**
     * Set the value of dex11CashPayment
     * @param dex11CashPayment - double of dex11CashPayment
     */
    public void setDex11CashPayment(double dex11CashPayment);

    /**
     * Get the value of dex11CashPayment
     * @return dex11CashPayment - double of dex11CashPayment
     */
    public double getDex11CashPayment();

    /**
     * Set the value of dex11FreightAmt
     * @param dex11FreightAmt - double of dex11FreightAmt
     */
    public void setDex11FreightAmt(double dex11FreightAmt);

    /**
     * Get the value of dex11FreightAmt
     * @return dex11FreightAmt - double of dex11FreightAmt
     */
    public double getDex11FreightAmt();

    /**
     * Set the value of dex11OtherPaymentAmt
     * @param dex11OtherPaymentAmt - double of dex11OtherPaymentAmt
     */
    public void setDex11OtherPaymentAmt(double dex11OtherPaymentAmt);

    /**
     * Get the value of dex11OtherPaymentAmt
     * @return dex11OtherPaymentAmt - double of dex11OtherPaymentAmt
     */
    public double getDex11OtherPaymentAmt();

    /**
     * Set the value of dex11OtherDocNbr
     * @param dex11OtherDocNbr - String of dex11OtherDocNbr
     */
    public void setDex11OtherDocNbr(String dex11OtherDocNbr);

    /**
     * Get the value of dex11OtherDocNbr
     * @return dex11OtherDocNbr - String of dex11OtherDocNbr
     */
    public String getDex11OtherDocNbr();

    /**
     * Set the value of dex11ScanSeqNbr
     * @param dex11ScanSeqNbr - String of dex11ScanSeqNbr
     */
    public void setDex11ScanSeqNbr(String dex11ScanSeqNbr);

    /**
     * Get the value of dex11ScanSeqNbr
     * @return dex11ScanSeqNbr - String of dex11ScanSeqNbr
     */
    public String getDex11ScanSeqNbr();

    /**
     * Set the value of chngStatusEmployeeId
     * @param chngStatusEmployeeId - String of chngStatusEmployeeId
     */
    public void setChngStatusEmployeeId(String chngStatusEmployeeId);

    /**
     * Get the value of chngStatusEmployeeId
     * @return chngStatusEmployeeId - String of chngStatusEmployeeId
     */
    public String getChngStatusEmployeeId();

    /**
     * Set the value of chngStatusDt
     * @param chngStatusDt - Date of chngStatusDt
     */
    public void setChngStatusDt(Date chngStatusDt);

    /**
     * Get the value of chngStatusDt
     * @return chngStatusDt - Date of chngStatusDt
     */
    public Date getChngStatusDt();

    /**
     * Set the value of closeEmployeeId
     * @param closeEmployeeId - String of closeEmployeeId
     */
    public void setCloseEmployeeId(String closeEmployeeId);

    /**
     * Get the value of closeEmployeeId
     * @return closeEmployeeId - String of closeEmployeeId
     */
    public String getCloseEmployeeId();

    /**
     * Set the value of closeDt
     * @param closeDt - Date of closeDt
     */
    public void setCloseDt(Date closeDt);

    /**
     * Get the value of closeDt
     * @return closeDt - Date of closeDt
     */
    public Date getCloseDt();

    /**
     * Set the value of eodEmployeeId
     * @param eodEmployeeId - String of eodEmployeeId
     */
    public void setEodEmployeeId(String eodEmployeeId);

    /**
     * Get the value of eodEmployeeId
     * @return eodEmployeeId - String of eodEmployeeId
     */
    public String getEodEmployeeId();

    /**
     * Set the value of eodDt
     * @param eodDt - Date of eodDt
     */
    public void setEodDt(Date eodDt);

    /**
     * Get the value of eodDt
     * @return eodDt - Date of eodDt
     */
    public Date getEodDt();

    /**
     * Set the value of lastScanType
     * @param lastScanType - String of lastScanType
     */
    public void setLastScanType(String lastScanType);

    /**
     * Get the value of lastScanType
     * @return lastScanType - String of lastScanType
     */
    public String getLastScanType();

    /**
     * Set the value of lastScanDate
     * @param lastScanDate - Date of lastScanDate
     */
    public void setLastScanDate(Date lastScanDate);

    /**
     * Get the value of lastScanDate
     * @return lastScanDate - Date of lastScanDate
     */
    public Date getLastScanDate();

    /**
     * Set the value of chkinAgentComment
     * @param chkinAgentComment - String of chkinAgentComment
     */
    public void setChkinAgentComment(String chkinAgentComment);

    /**
     * Get the value of chkinAgentComment
     * @return chkinAgentComment - String of chkinAgentComment
     */
    public String getChkinAgentComment();

    /**
     * Set the value of trackingStatus
     * @param trackingStatus - int of trackingStatus
     */
    public void setTrackingStatus(int trackingStatus);

    /**
     * Get the value of trackingStatus
     * @return trackingStatus - int of trackingStatus
     */
    public int getTrackingStatus();

    /**
     * Set the value of statusId
     * @param statusId - int of statusId
     */
    public void setStatusId(int statusId);

    /**
     * Get the value of statusId
     * @return statusId - int of statusId
     */
    public int getStatusId();

    /**
     * Set the value of cashDepositSlipId
     * @param cashDepositSlipId - int of cashDepositSlipId
     */
    public void setCashDepositSlipId(int cashDepositSlipId);

    /**
     * Get the value of cashDepositSlipId
     * @return cashDepositSlipId - int of cashDepositSlipId
     */
    public int getCashDepositSlipId();

    /**
     * Set the value of cashDepositSlipNbr
     * @param cashDepositSlipNbr - String of cashDepositSlipNbr
     */
    public void setCashDepositSlipNbr(String cashDepositSlipNbr);

    /**
     * Get the value of cashDepositSlipNbr
     * @return cashDepositSlipNbr - String of cashDepositSlipNbr
     */
    public String getCashDepositSlipNbr();

    /**
     * Set the value of otherDepositSlipId
     * @param otherDepositSlipId - int of otherDepositSlipId
     */
    public void setOtherDepositSlipId(int otherDepositSlipId);

    /**
     * Get the value of otherDepositSlipId
     * @return otherDepositSlipId - int of otherDepositSlipId
     */
    public int getOtherDepositSlipId();

    /**
     * Set the value of otherDepositSlipNbr
     * @param otherDepositSlipNbr - String of otherDepositSlipNbr
     */
    public void setOtherDepositSlipNbr(String otherDepositSlipNbr);

    /**
     * Get the value of otherDepositSlipNbr
     * @return otherDepositSlipNbr - String of otherDepositSlipNbr
     */
    public String getOtherDepositSlipNbr();

    /**
     * Set the value of creditCardBatchId
     * @param creditCardBatchId - String of creditCardBatchId
     */
    public void setCreditCardBatchId(String creditCardBatchId);

    /**
     * Get the value of creditCardBatchId
     * @return creditCardBatchId - String of creditCardBatchId
     */
    public String getCreditCardBatchId();

    /**
     * Set the value of eodId
     * @param eodId - int of eodId
     */
    public void setEodId(int eodId);

    /**
     * Get the value of eodId
     * @return eodId - int of eodId
     */
    public int getEodId();

    /**
     * Set the value of codXmlImpDt
     * @param codXmlImpDt - Date of codXmlImpDt
     */
    public void setCodXmlImpDt(Date codXmlImpDt);

    /**
     * Get the value of codXmlImpDt
     * @return codXmlImpDt - Date of codXmlImpDt
     */
    public Date getCodXmlImpDt();

    /**
     * Set the value of pymtImpDt
     * @param pymtImpDt - Date of pymtImpDt
     */
    public void setPymtImpDt(Date pymtImpDt);

    /**
     * Get the value of pymtImpDt
     * @return pymtImpDt - Date of pymtImpDt
     */
    public Date getPymtImpDt();

    /**
     * Set the value of otherComment
     * @param otherComment - String of otherComment
     */
    public void setOtherComment(String otherComment);

    /**
     * Get the value of otherComment
     * @return otherComment - String of otherComment
     */
    public String getOtherComment();

    /**
     * Set the value of recvPrepyAmt
     * @param recvPrepyAmt - double of recvPrepyAmt
     */
    public void setRecvPrepyAmt(double recvPrepyAmt);

    /**
     * Get the value of recvPrepyAmt
     * @return recvPrepyAmt - double of recvPrepyAmt
     */
    public double getRecvPrepyAmt();

    /**
     * Set the value of origCustNm
     * @param origCustNm - String of origCustNm
     */
    public void setOrigCustNm(String origCustNm);

    /**
     * Get the value of origCustNm
     * @return origCustNm - String of origCustNm
     */
    public String getOrigCustNm();

    /**
     * Set the value of custChngEmpId
     * @param custChngEmpId - String of custChngEmpId
     */
    public void setCustChngEmpId(String custChngEmpId);

    /**
     * Get the value of custChngEmpId
     * @return custChngEmpId - String of custChngEmpId
     */
    public String getCustChngEmpId();

    /**
     * Set the value of origRecAmt
     * @param origRecAmt - double of origRecAmt
     */
    public void setOrigRecAmt(double origRecAmt);

    /**
     * Get the value of origRecAmt
     * @return origRecAmt - double of origRecAmt
     */
    public double getOrigRecAmt();

    /**
     * Set the value of amtChngEmpId
     * @param amtChngEmpId - String of amtChngEmpId
     */
    public void setAmtChngEmpId(String amtChngEmpId);

    /**
     * Get the value of amtChngEmpId
     * @return amtChngEmpId - String of amtChngEmpId
     */
    public String getAmtChngEmpId();

    /**
     * Set the value of rcptNbr
     * @param rcptNbr - String of rcptNbr
     */
    public void setRcptNbr(String rcptNbr);

    /**
     * Get the value of rcptNbr
     * @return rcptNbr - String of rcptNbr
     */
    public String getRcptNbr();

    /**
     * Set the value of origRcptNbr
     * @param origRcptNbr - String of origRcptNbr
     */
    public void setOrigRcptNbr(String origRcptNbr);

    /**
     * Get the value of origRcptNbr
     * @return origRcptNbr - String of origRcptNbr
     */
    public String getOrigRcptNbr();

    /**
     * Set the value of rcptChngEmpId
     * @param rcptChngEmpId - String of rcptChngEmpId
     */
    public void setRcptChngEmpId(String rcptChngEmpId);

    /**
     * Get the value of rcptChngEmpId
     * @return rcptChngEmpId - String of rcptChngEmpId
     */
    public String getRcptChngEmpId();

    /**
     * Set the value of origEmployeeId
     * @param origEmployeeId - String of origEmployeeId
     */
    public void setOrigEmployeeId(String origEmployeeId);

    /**
     * Get the value of origEmployeeId
     * @return origEmployeeId - String of origEmployeeId
     */
    public String getOrigEmployeeId();

    /**
     * Set the value of reassEmpId
     * @param reassEmpId - String of reassEmpId
     */
    public void setReassEmpId(String reassEmpId);

    /**
     * Get the value of reassEmpId
     * @return reassEmpId - String of reassEmpId
     */
    public String getReassEmpId();

    /**
     * Set the value of dualRecIdNbr
     * @param dualRecIdNbr - Integer of dualRecIdNbr
     */
    public void setDualRecIdNbr(Integer dualRecIdNbr);

    /**
     * Get the value of dualRecIdNbr
     * @return dualRecIdNbr - Integer of dualRecIdNbr
     */
    public Integer getDualRecIdNbr();

    /**
     * Set the value of dupAwbFlg
     * @param dupAwbFlg - String of dupAwbFlg
     */
    public void setDupAwbFlg(String dupAwbFlg);

    /**
     * Get the value of dupAwbFlg
     * @return dupAwbFlg - String of dupAwbFlg
     */
    public String getDupAwbFlg();

    /**
     * Set the value of billAccount
     * @param billAccount - String of billAccount
     */
    public void setBillAccount(String billAccount);

    /**
     * Get the value of billAccount
     * @return billAccount - String of billAccount
     */
    public String getBillAccount();
}
