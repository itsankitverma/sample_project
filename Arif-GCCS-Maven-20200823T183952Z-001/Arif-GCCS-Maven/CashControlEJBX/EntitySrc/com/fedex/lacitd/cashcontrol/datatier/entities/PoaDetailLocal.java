/**
 * @(#)PoaDetailLocal.java			Tue Aug 02 15:38:50 VET 2005
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

public interface PoaDetailLocal extends EJBLocalObject {

    /**
     * Set the value of poaDetailId
     * @param poaDetailId - Integer of poaDetailId
     */
    public void setPoaDetailId(Integer poaDetailId);

    /**
     * Get the value of poaDetailId
     * @return poaDetailId - Integer of poaDetailId
     */
    public Integer getPoaDetailId();

    /**
     * Set the value of poaPaymentsId
     * @param poaPaymentsId - int of poaPaymentsId
     */
    public void setPoaPaymentsId(int poaPaymentsId);

    /**
     * Get the value of poaPaymentsId
     * @return poaPaymentsId - int of poaPaymentsId
     */
    public int getPoaPaymentsId();

    /**
     * Set the value of invoiceNbr
     * @param invoiceNbr - String of invoiceNbr
     */
    public void setInvoiceNbr(String invoiceNbr);

    /**
     * Get the value of invoiceNbr
     * @return invoiceNbr - String of invoiceNbr
     */
    public String getInvoiceNbr();

    /**
     * Set the value of amount
     * @param amount - double of amount
     */
    public void setAmount(double amount);

    /**
     * Get the value of amount
     * @return amount - double of amount
     */
    public double getAmount();

    /**
     * Set the value of couponAmt
     * @param couponAmt - double of couponAmt
     */
    public void setCouponAmt(double couponAmt);

    /**
     * Get the value of couponAmt
     * @return couponAmt - double of couponAmt
     */
    public double getCouponAmt();

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
     * Set the value of exchRate
     * @param exchRate - double of exchRate
     */
    public void setExchRate(double exchRate);

    /**
     * Get the value of exchRate
     * @return exchRate - double of exchRate
     */
    public double getExchRate();

}
