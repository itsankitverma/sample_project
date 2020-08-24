/**
 * @(#)OtherPaymentBean.java			Tue Aug 02 15:38:50 VET 2005
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

public abstract class OtherPaymentBean implements EntityBean {

    private EntityContext _ctx;
    public OtherPaymentBean() {
    }
    
    //added to add the two new columns miscDate, miscNbr
	public abstract Date getMiscDate();
	public abstract void setMiscDate(Date miscDate) ;
	public abstract String getMiscNbr();
	public abstract void setMiscNbr(String miscNbr);
    
    /**
     * Set the value of otherPymtId
     * @param otherPymtId - Integer of otherPymtId
     */
    public abstract void setOtherPymtId(Integer otherPymtId);

    /**
     * Get the value of otherPymtId
     * @return otherPymtId - Integer of otherPymtId
     */
    public abstract Integer getOtherPymtId();

    /**
     * Set the value of description
     * @param description - String of description
     */
    public abstract void setDescription(String description);

    /**
     * Get the value of description
     * @return description - String of description
     */
    public abstract String getDescription();

    /**
     * Set the value of paymentAmt
     * @param paymentAmt - double of paymentAmt
     */
    public abstract void setPaymentAmt(double paymentAmt);

    /**
     * Get the value of paymentAmt
     * @return paymentAmt - double of paymentAmt
     */
    public abstract double getPaymentAmt();

    /**
     * Set the value of paymentDocNbr
     * @param paymentDocNbr - String of paymentDocNbr
     */
    public abstract void setPaymentDocNbr(String paymentDocNbr);

    /**
     * Get the value of paymentDocNbr
     * @return paymentDocNbr - String of paymentDocNbr
     */
    public abstract String getPaymentDocNbr();

    /**
     * Set the value of paymentType
     * @param paymentType - int of paymentType
     */
    public abstract void setPaymentType(int paymentType);

    /**
     * Get the value of paymentType
     * @return paymentType - int of paymentType
     */
    public abstract int getPaymentType();

    /**
     * Set the value of paymentDt
     * @param paymentDt - Date of paymentDt
     */
    public abstract void setPaymentDt(Date paymentDt);

    /**
     * Get the value of paymentDt
     * @return paymentDt - Date of paymentDt
     */
    public abstract Date getPaymentDt();

    /**
     * Set the value of chkinAgentId
     * @param chkinAgentId - String of chkinAgentId
     */
    public abstract void setChkinAgentId(String chkinAgentId);

    /**
     * Get the value of chkinAgentId
     * @return chkinAgentId - String of chkinAgentId
     */
    public abstract String getChkinAgentId();

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
     * Set the value of depositSlipId
     * @param depositSlipId - int of depositSlipId
     */
    public abstract void setDepositSlipId(int depositSlipId);

    /**
     * Get the value of depositSlipId
     * @return depositSlipId - int of depositSlipId
     */
    public abstract int getDepositSlipId();

    /**
     * Set the value of creditCardBatchId
     * @param creditCardBatchId - int of creditCardBatchId
     */
    public abstract void setCreditCardBatchId(int creditCardBatchId);

    /**
     * Get the value of creditCardBatchId
     * @return creditCardBatchId - int of creditCardBatchId
     */
    public abstract int getCreditCardBatchId();

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
     * Set the value of otherPaymentCtgId
     * @param otherPaymentCtgId - int of otherPaymentCtgId
     */
    public abstract void setOtherPaymentCtgId(int otherPaymentCtgId);

    /**
     * Get the value of otherPaymentCtgId
     * @return otherPaymentCtgId - int of otherPaymentCtgId
     */
    public abstract int getOtherPaymentCtgId();

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
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String description, double paymentAmt, String paymentDocNbr, int paymentType, Date paymentDt, String chkinAgentId, Date eodDt, String eodEmployeeId, int depositSlipId, int creditCardBatchId, String locationCd, String paymentCurrency, int eodId, Date pymtImpDt, String otherComment, int otherPaymentCtgId, String awbNbr,Date miscDate,String miscNbr)
        throws CreateException {
        setDescription(description);
        setPaymentAmt(paymentAmt);
        setPaymentDocNbr(paymentDocNbr);
        setPaymentType(paymentType);
        setPaymentDt(paymentDt);
        setChkinAgentId(chkinAgentId);
        setEodDt(eodDt);
        setEodEmployeeId(eodEmployeeId);
        setDepositSlipId(depositSlipId);
        setCreditCardBatchId(creditCardBatchId);
        setLocationCd(locationCd);
        setPaymentCurrency(paymentCurrency);
        setEodId(eodId);
        setPymtImpDt(pymtImpDt);
        setOtherComment(otherComment);
        setOtherPaymentCtgId(otherPaymentCtgId);
        setAwbNbr(awbNbr);
        //added to add the two new columns miscDate,miscNbr
        setMiscDate(miscDate);
        setMiscNbr(miscNbr);        
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String description, double paymentAmt, String paymentDocNbr, int paymentType, Date paymentDt, String chkinAgentId, Date eodDt, String eodEmployeeId, int depositSlipId, int creditCardBatchId, String locationCd, String paymentCurrency, int eodId, Date pymtImpDt, String otherComment, int otherPaymentCtgId, String awbNbr,Date miscDate,String miscNbr)
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
