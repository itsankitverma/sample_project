/**
 * @(#)OtherPaymentLocal.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the other_payment table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;

import javax.ejb.*;

public interface OtherPaymentLocal extends EJBLocalObject {

	//to add the two new columns miscDate, miscNbr 
	public Date getMiscDate();
	public void setMiscDate(Date miscDate) ;
	public String getMiscNbr();
	public void setMiscNbr(String miscNbr);	
	
    /**
     * Set the value of otherPymtId
     * @param otherPymtId - Integer of otherPymtId
     */
    public void setOtherPymtId(Integer otherPymtId);

    /**
     * Get the value of otherPymtId
     * @return otherPymtId - Integer of otherPymtId
     */
    public Integer getOtherPymtId();

    /**
     * Set the value of description
     * @param description - String of description
     */
    public void setDescription(String description);

    /**
     * Get the value of description
     * @return description - String of description
     */
    public String getDescription();

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
     * Set the value of paymentDocNbr
     * @param paymentDocNbr - String of paymentDocNbr
     */
    public void setPaymentDocNbr(String paymentDocNbr);

    /**
     * Get the value of paymentDocNbr
     * @return paymentDocNbr - String of paymentDocNbr
     */
    public String getPaymentDocNbr();

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
     * Set the value of chkinAgentId
     * @param chkinAgentId - String of chkinAgentId
     */
    public void setChkinAgentId(String chkinAgentId);

    /**
     * Get the value of chkinAgentId
     * @return chkinAgentId - String of chkinAgentId
     */
    public String getChkinAgentId();

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
     * Set the value of creditCardBatchId
     * @param creditCardBatchId - int of creditCardBatchId
     */
    public void setCreditCardBatchId(int creditCardBatchId);

    /**
     * Get the value of creditCardBatchId
     * @return creditCardBatchId - int of creditCardBatchId
     */
    public int getCreditCardBatchId();

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
     * Set the value of otherPaymentCtgId
     * @param otherPaymentCtgId - int of otherPaymentCtgId
     */
    public void setOtherPaymentCtgId(int otherPaymentCtgId);

    /**
     * Get the value of otherPaymentCtgId
     * @return otherPaymentCtgId - int of otherPaymentCtgId
     */
    public int getOtherPaymentCtgId();

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
}
