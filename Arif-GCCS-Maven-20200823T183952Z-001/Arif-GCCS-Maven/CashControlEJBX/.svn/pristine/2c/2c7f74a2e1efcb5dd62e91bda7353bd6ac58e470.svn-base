/**
 * @(#)PrepaidLocal.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the prepaid table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;

import javax.ejb.*;

public interface PrepaidLocal extends EJBLocalObject {

    /**
     * Set the value of prepaidId
     * @param prepaidId - Integer of prepaidId
     */
	
	//to add the two new columns miscDate, miscNbr 
	public Date getMiscDate();
	public void setMiscDate(Date miscDate) ;
	public String getMiscNbr();
	public void setMiscNbr(String miscNbr);
	
    public void setPrepaidId(Integer prepaidId);

    /**
     * Get the value of prepaidId
     * @return prepaidId - Integer of prepaidId
     */
    public Integer getPrepaidId();

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
     * Set the value of awbDt
     * @param awbDt - Date of awbDt
     */
    public void setAwbDt(Date awbDt);

    /**
     * Get the value of awbDt
     * @return awbDt - Date of awbDt
     */
    public Date getAwbDt();

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
     * Set the value of coupPymtAmt
     * @param coupPymtAmt - double of coupPymtAmt
     */
    public void setCoupPymtAmt(double coupPymtAmt);

    /**
     * Get the value of coupPymtAmt
     * @return coupPymtAmt - double of coupPymtAmt
     */
    public double getCoupPymtAmt();

    /**
     * Set the value of pux16CashPayment
     * @param pux16CashPayment - double of pux16CashPayment
     */
    public void setPux16CashPayment(double pux16CashPayment);

    /**
     * Get the value of pux16CashPayment
     * @return pux16CashPayment - double of pux16CashPayment
     */
    public double getPux16CashPayment();

    /**
     * Set the value of pux16FreightAmt
     * @param pux16FreightAmt - double of pux16FreightAmt
     */
    public void setPux16FreightAmt(double pux16FreightAmt);

    /**
     * Get the value of pux16FreightAmt
     * @return pux16FreightAmt - double of pux16FreightAmt
     */
    public double getPux16FreightAmt();

    /**
     * Set the value of pux16OtherPaymentAmt
     * @param pux16OtherPaymentAmt - double of pux16OtherPaymentAmt
     */
    public void setPux16OtherPaymentAmt(double pux16OtherPaymentAmt);

    /**
     * Get the value of pux16OtherPaymentAmt
     * @return pux16OtherPaymentAmt - double of pux16OtherPaymentAmt
     */
    public double getPux16OtherPaymentAmt();

    /**
     * Set the value of pux16OtherDocNbr
     * @param pux16OtherDocNbr - String of pux16OtherDocNbr
     */
    public void setPux16OtherDocNbr(String pux16OtherDocNbr);

    /**
     * Get the value of pux16OtherDocNbr
     * @return pux16OtherDocNbr - String of pux16OtherDocNbr
     */
    public String getPux16OtherDocNbr();

    /**
     * Set the value of pux16CoupPymtAmt
     * @param pux16CoupPymtAmt - double of pux16CoupPymtAmt
     */
    public void setPux16CoupPymtAmt(double pux16CoupPymtAmt);

    /**
     * Get the value of pux16CoupPymtAmt
     * @return pux16CoupPymtAmt - double of pux16CoupPymtAmt
     */
    public double getPux16CoupPymtAmt();

    /**
     * Set the value of pux16ScanSeqNbr
     * @param pux16ScanSeqNbr - String of pux16ScanSeqNbr
     */
    public void setPux16ScanSeqNbr(String pux16ScanSeqNbr);

    /**
     * Get the value of pux16ScanSeqNbr
     * @return pux16ScanSeqNbr - String of pux16ScanSeqNbr
     */
    public String getPux16ScanSeqNbr();

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
     * Set the value of freightAmtInVisa
     * @param freightAmtInVisa - double of freightAmtInVisa
     */
    public void setFreightAmtInVisa(double freightAmtInVisa);

    /**
     * Get the value of freightAmtInVisa
     * @return freightAmtInVisa - double of freightAmtInVisa
     */
    public double getFreightAmtInVisa();

    /**
     * Set the value of visaMnfstDt
     * @param visaMnfstDt - Date of visaMnfstDt
     */
    public void setVisaMnfstDt(Date visaMnfstDt);

    /**
     * Get the value of visaMnfstDt
     * @return visaMnfstDt - Date of visaMnfstDt
     */
    public Date getVisaMnfstDt();

    /**
     * Set the value of visaMnfstEmpId
     * @param visaMnfstEmpId - String of visaMnfstEmpId
     */
    public void setVisaMnfstEmpId(String visaMnfstEmpId);

    /**
     * Get the value of visaMnfstEmpId
     * @return visaMnfstEmpId - String of visaMnfstEmpId
     */
    public String getVisaMnfstEmpId();

    /**
     * Set the value of exchRate
     * @param exchRate - double of exchRate
     */
    public void setExchRate(double exchRate);

    /**
     * Get the value of exchRate
     * @return exchRate - double of exchRate
     */
    public double getExchRate();

    /**
     * Set the value of courierId
     * @param courierId - String of courierId
     */
    public void setCourierId(String courierId);

    /**
     * Get the value of courierId
     * @return courierId - String of courierId
     */
    public String getCourierId();

    /**
     * Set the value of product
     * @param product - int of product
     */
    public void setProduct(int product);

    /**
     * Get the value of product
     * @return product - int of product
     */
    public int getProduct();

    /**
     * Set the value of numberPkgs
     * @param numberPkgs - int of numberPkgs
     */
    public void setNumberPkgs(int numberPkgs);

    /**
     * Get the value of numberPkgs
     * @return numberPkgs - int of numberPkgs
     */
    public int getNumberPkgs();

    /**
     * Set the value of weight
     * @param weight - double of weight
     */
    public void setWeight(double weight);

    /**
     * Get the value of weight
     * @return weight - double of weight
     */
    public double getWeight();

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
     * Set the value of couponBatchId
     * @param couponBatchId - int of couponBatchId
     */
    public void setCouponBatchId(int couponBatchId);

    /**
     * Get the value of couponBatchId
     * @return couponBatchId - int of couponBatchId
     */
    public int getCouponBatchId();

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
     * Set the value of dualPrepaidIdNbr
     * @param dualPrepaidIdNbr - Integer of dualPrepaidIdNbr
     */
    public void setDualPrepaidIdNbr(Integer dualPrepaidIdNbr);

    /**
     * Get the value of dualPrepaidIdNbr
     * @return dualPrepaidIdNbr - Integer of dualPrepaidIdNbr
     */
    public Integer getDualPrepaidIdNbr();
    
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
