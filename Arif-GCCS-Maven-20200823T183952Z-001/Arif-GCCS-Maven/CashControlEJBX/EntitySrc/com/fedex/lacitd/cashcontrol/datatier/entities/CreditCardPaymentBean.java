/**
 * @(#)CreditCardPaymentBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the credit_card_payment table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class CreditCardPaymentBean implements EntityBean {

    private EntityContext _ctx;
    public CreditCardPaymentBean() {
    }
    /**
     * Set the value of creditCardPymtId
     * @param creditCardPymtId - Integer of creditCardPymtId
     */
    public abstract void setCreditCardPymtId(Integer creditCardPymtId);

    /**
     * Get the value of creditCardPymtId
     * @return creditCardPymtId - Integer of creditCardPymtId
     */
    public abstract Integer getCreditCardPymtId();

    /**
     * Set the value of totalAmt
     * @param totalAmt - double of totalAmt
     */
    public abstract void setTotalAmt(double totalAmt);

    /**
     * Get the value of totalAmt
     * @return totalAmt - double of totalAmt
     */
    public abstract double getTotalAmt();

    /**
     * Set the value of totalReimbursed
     * @param totalReimbursed - double of totalReimbursed
     */
    public abstract void setTotalReimbursed(double totalReimbursed);

    /**
     * Get the value of totalReimbursed
     * @return totalReimbursed - double of totalReimbursed
     */
    public abstract double getTotalReimbursed();

    /**
     * Set the value of paymentType
     * @param paymentType - String of paymentType
     */
    public abstract void setPaymentType(String paymentType);

    /**
     * Get the value of paymentType
     * @return paymentType - String of paymentType
     */
    public abstract String getPaymentType();

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
     * Set the value of comments
     * @param comments - String of comments
     */
    public abstract void setComments(String comments);

    /**
     * Get the value of comments
     * @return comments - String of comments
     */
    public abstract String getComments();

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
     * Set the value of batchDt
     * @param batchDt - Date of batchDt
     */
    public abstract void setBatchDt(Date batchDt);

    /**
     * Get the value of batchDt
     * @return batchDt - Date of batchDt
     */
    public abstract Date getBatchDt();

    /**
     * Set the value of currencyCd
     * @param currencyCd - String of currencyCd
     */
    public abstract void setCurrencyCd(String currencyCd);

    /**
     * Get the value of currencyCd
     * @return currencyCd - String of currencyCd
     */
    public abstract String getCurrencyCd();

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
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(double totalAmt, double totalReimbursed, String paymentType, String paymentDocNbr, String comments, int statusId, String locationCd, String employeeId, Date batchDt, String currencyCd, int depositSlipId, int eodId)
        throws CreateException {
        setTotalAmt(totalAmt);
        setTotalReimbursed(totalReimbursed);
        setPaymentType(paymentType);
        setPaymentDocNbr(paymentDocNbr);
        setComments(comments);
        setStatusId(statusId);
        setLocationCd(locationCd);
        setEmployeeId(employeeId);
        setBatchDt(batchDt);
        setCurrencyCd(currencyCd);
        setDepositSlipId(depositSlipId);
        setEodId(eodId);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(double totalAmt, double totalReimbursed, String paymentType, String paymentDocNbr, String comments, int statusId, String locationCd, String employeeId, Date batchDt, String currencyCd, int depositSlipId, int eodId)
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
