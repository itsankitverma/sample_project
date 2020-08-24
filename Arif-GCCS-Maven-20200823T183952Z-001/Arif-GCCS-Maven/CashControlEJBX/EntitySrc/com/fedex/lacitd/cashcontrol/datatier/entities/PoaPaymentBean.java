/**
 * @(#)PoaPaymentBean.java			Tue Aug 02 15:38:50 VET 2005
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

public abstract class PoaPaymentBean implements EntityBean {

    private EntityContext _ctx;
    public PoaPaymentBean() {
    }
    /**
     * Set the value of poaPaymentsId
     * @param poaPaymentsId - Integer of poaPaymentsId
     */
    public abstract void setPoaPaymentsId(Integer poaPaymentsId);

    /**
     * Get the value of poaPaymentsId
     * @return poaPaymentsId - Integer of poaPaymentsId
     */
    public abstract Integer getPoaPaymentsId();

    /**
     * Set the value of accountNbr
     * @param accountNbr - String of accountNbr
     */
    public abstract void setAccountNbr(String accountNbr);

    /**
     * Get the value of accountNbr
     * @return accountNbr - String of accountNbr
     */
    public abstract String getAccountNbr();

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
     * Set the value of exchRate
     * @param exchRate - double of exchRate
     */
    public abstract void setExchRate(double exchRate);

    /**
     * Get the value of exchRate
     * @return exchRate - double of exchRate
     */
    public abstract double getExchRate();

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
     * Set the value of coupPymtAmt
     * @param coupPymtAmt - double of coupPymtAmt
     */
    public abstract void setCoupPymtAmt(double coupPymtAmt);

    /**
     * Get the value of coupPymtAmt
     * @return coupPymtAmt - double of coupPymtAmt
     */
    public abstract double getCoupPymtAmt();

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
     * Set the value of courierId
     * @param courierId - String of courierId
     */
    public abstract void setCourierId(String courierId);

    /**
     * Get the value of courierId
     * @return courierId - String of courierId
     */
    public abstract String getCourierId();

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
     * Set the value of depositSlipNbr
     * @param depositSlipNbr - String of depositSlipNbr
     */
    public abstract void setDepositSlipNbr(String depositSlipNbr);

    /**
     * Get the value of depositSlipNbr
     * @return depositSlipNbr - String of depositSlipNbr
     */
    public abstract String getDepositSlipNbr();

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
     * Set the value of receivedEmpId
     * @param receivedEmpId - String of receivedEmpId
     */
    public abstract void setReceivedEmpId(String receivedEmpId);

    /**
     * Get the value of receivedEmpId
     * @return receivedEmpId - String of receivedEmpId
     */
    public abstract String getReceivedEmpId();

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
     * Set the value of couponBatchId
     * @param couponBatchId - int of couponBatchId
     */
    public abstract void setCouponBatchId(int couponBatchId);

    /**
     * Get the value of couponBatchId
     * @return couponBatchId - int of couponBatchId
     */
    public abstract int getCouponBatchId();

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
    
    /*
     * New fields introduced at Add POA screen
     * Author : Kapil Rana
     */
    public abstract Date getChequeDt();
	public abstract void setChequeDt(Date chequeDt);
	public abstract String getChequeOrigin();
	public abstract void setChequeOrigin(String chequeOrigin);
	public abstract String getBankName();
	public abstract void setBankName(String bankName);

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String accountNbr, String customerNm, Date paymentDt, String locationCd, String paymentCurrency, double exchRate, double paymentAmt, int paymentType, double coupPymtAmt, String otherDocNbr, String courierId, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String chkinAgentComment, int depositSlipId, String depositSlipNbr, String creditCardBatchId, String receivedEmpId, int eodId, int couponBatchId, Date pymtImpDt, String otherComment, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Date chequeDt, String chequeOrigin, String bankName)
        throws CreateException {
        setAccountNbr(accountNbr);
        setCustomerNm(customerNm);
        setPaymentDt(paymentDt);
        setLocationCd(locationCd);
        setPaymentCurrency(paymentCurrency);
        setExchRate(exchRate);
        setPaymentAmt(paymentAmt);
        setPaymentType(paymentType);
        setCoupPymtAmt(coupPymtAmt);
        setOtherDocNbr(otherDocNbr);
        setCourierId(courierId);
        setCloseEmployeeId(closeEmployeeId);
        setCloseDt(closeDt);
        setEodEmployeeId(eodEmployeeId);
        setEodDt(eodDt);
        setChkinAgentComment(chkinAgentComment);
        setDepositSlipId(depositSlipId);
        setDepositSlipNbr(depositSlipNbr);
        setCreditCardBatchId(creditCardBatchId);
        setReceivedEmpId(receivedEmpId);
        setEodId(eodId);
        setCouponBatchId(couponBatchId);
        setPymtImpDt(pymtImpDt);
        setOtherComment(otherComment);
        setRcptNbr(rcptNbr);
        setOrigRcptNbr(origRcptNbr);
        setRcptChngEmpId(rcptChngEmpId);
        setOrigEmployeeId(origEmployeeId);
        setReassEmpId(reassEmpId);
        /*
         * New fields introduced at Add POA screen
         * Author : Kapil Rana
         */
        setChequeDt(chequeDt);
        setChequeOrigin(chequeOrigin);
        setBankName(bankName);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String accountNbr, String customerNm, Date paymentDt, String locationCd, String paymentCurrency, double exchRate, double paymentAmt, int paymentType, double coupPymtAmt, String otherDocNbr, String courierId, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String chkinAgentComment, int depositSlipId, String depositSlipNbr, String creditCardBatchId, String receivedEmpId, int eodId, int couponBatchId, Date pymtImpDt, String otherComment, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Date chequeDt, String chequeOrigin, String bankName)
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
