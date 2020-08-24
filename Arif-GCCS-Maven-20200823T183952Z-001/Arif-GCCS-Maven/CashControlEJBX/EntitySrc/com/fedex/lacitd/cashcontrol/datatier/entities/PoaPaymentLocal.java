/**
 * @(#)PoaPaymentLocal.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the poa_payment table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface PoaPaymentLocal extends EJBLocalObject {

    /**
     * Set the value of poaPaymentsId
     * @param poaPaymentsId - Integer of poaPaymentsId
     */
    public void setPoaPaymentsId(Integer poaPaymentsId);

    /**
     * Get the value of poaPaymentsId
     * @return poaPaymentsId - Integer of poaPaymentsId
     */
    public Integer getPoaPaymentsId();

    /**
     * Set the value of accountNbr
     * @param accountNbr - String of accountNbr
     */
    public void setAccountNbr(String accountNbr);

    /**
     * Get the value of accountNbr
     * @return accountNbr - String of accountNbr
     */
    public String getAccountNbr();

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
     * Set the value of paymentDt
     * @param paymentDt - Date of paymentDt
     */
    public void setPaymentDt(Date paymentDt);

    /**
     * Get the value of paymentDt
     * @return paymentDt - Date of paymentDt
     */
    public Date getPaymentDt();

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
     * Set the value of paymentAmt
     * @param paymentAmt - double of paymentAmt
     */
    public void setPaymentAmt(double paymentAmt);

    /**
     * Get the value of paymentAmt
     * @return paymentAmt - double of paymentAmt
     */
    public double getPaymentAmt();

    /**
     * Set the value of paymentType
     * @param paymentType - int of paymentType
     */
    public void setPaymentType(int paymentType);

    /**
     * Get the value of paymentType
     * @return paymentType - int of paymentType
     */
    public int getPaymentType();

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
     * Set the value of depositSlipId
     * @param depositSlipId - int of depositSlipId
     */
    public void setDepositSlipId(int depositSlipId);

    /**
     * Get the value of depositSlipId
     * @return depositSlipId - int of depositSlipId
     */
    public int getDepositSlipId();

    /**
     * Set the value of depositSlipNbr
     * @param depositSlipNbr - String of depositSlipNbr
     */
    public void setDepositSlipNbr(String depositSlipNbr);

    /**
     * Get the value of depositSlipNbr
     * @return depositSlipNbr - String of depositSlipNbr
     */
    public String getDepositSlipNbr();

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
     * Set the value of receivedEmpId
     * @param receivedEmpId - String of receivedEmpId
     */
    public void setReceivedEmpId(String receivedEmpId);

    /**
     * Get the value of receivedEmpId
     * @return receivedEmpId - String of receivedEmpId
     */
    public String getReceivedEmpId();

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

    /*
     * New fields introduced at Add POA screen
     * Author : Kapil Rana
     */
    public Date getChequeDt();
	public void setChequeDt(Date chequeDt);
	public String getChequeOrigin();
	public void setChequeOrigin(String chequeOrigin);
	public String getBankName();
	public void setBankName(String bankName);

}
