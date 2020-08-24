/**
 * @(#)PoaDetailBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the poa_detail table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class PoaDetailBean implements EntityBean {

    private EntityContext _ctx;
    public PoaDetailBean() {
    }
    /**
     * Set the value of poaDetailId
     * @param poaDetailId - Integer of poaDetailId
     */
    public abstract void setPoaDetailId(Integer poaDetailId);

    /**
     * Get the value of poaDetailId
     * @return poaDetailId - Integer of poaDetailId
     */
    public abstract Integer getPoaDetailId();

    /**
     * Set the value of poaPaymentsId
     * @param poaPaymentsId - int of poaPaymentsId
     */
    public abstract void setPoaPaymentsId(int poaPaymentsId);

    /**
     * Get the value of poaPaymentsId
     * @return poaPaymentsId - int of poaPaymentsId
     */
    public abstract int getPoaPaymentsId();

    /**
     * Set the value of invoiceNbr
     * @param invoiceNbr - String of invoiceNbr
     */
    public abstract void setInvoiceNbr(String invoiceNbr);

    /**
     * Get the value of invoiceNbr
     * @return invoiceNbr - String of invoiceNbr
     */
    public abstract String getInvoiceNbr();

    /**
     * Set the value of amount
     * @param amount - double of amount
     */
    public abstract void setAmount(double amount);

    /**
     * Get the value of amount
     * @return amount - double of amount
     */
    public abstract double getAmount();

    /**
     * Set the value of couponAmt
     * @param couponAmt - double of couponAmt
     */
    public abstract void setCouponAmt(double couponAmt);

    /**
     * Get the value of couponAmt
     * @return couponAmt - double of couponAmt
     */
    public abstract double getCouponAmt();

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
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(int poaPaymentsId, String invoiceNbr, double amount, double couponAmt, String invCurrency, double exchRate)
        throws CreateException {
        setPoaPaymentsId(poaPaymentsId);
        setInvoiceNbr(invoiceNbr);
        setAmount(amount);
        setCouponAmt(couponAmt);
        setInvCurrency(invCurrency);
        setExchRate(exchRate);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(int poaPaymentsId, String invoiceNbr, double amount, double couponAmt, String invCurrency, double exchRate)
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
