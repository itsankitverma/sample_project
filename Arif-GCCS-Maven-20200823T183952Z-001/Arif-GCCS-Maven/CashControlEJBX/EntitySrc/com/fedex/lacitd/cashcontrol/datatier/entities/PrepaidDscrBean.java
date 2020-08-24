/**
 * @(#)PrepaidDscrBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the prepaid_dscr table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class PrepaidDscrBean implements EntityBean {

    private EntityContext _ctx;
    public PrepaidDscrBean() {
    }
    /**
     * Set the value of prepaidDscrId
     * @param prepaidDscrId - Integer of prepaidDscrId
     */
    public abstract void setPrepaidDscrId(Integer prepaidDscrId);

    /**
     * Get the value of prepaidDscrId
     * @return prepaidDscrId - Integer of prepaidDscrId
     */
    public abstract Integer getPrepaidDscrId();

    /**
     * Set the value of processDt
     * @param processDt - Date of processDt
     */
    public abstract void setProcessDt(Date processDt);

    /**
     * Get the value of processDt
     * @return processDt - Date of processDt
     */
    public abstract Date getProcessDt();

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
     * Set the value of freightAmtInVisa
     * @param freightAmtInVisa - double of freightAmtInVisa
     */
    public abstract void setFreightAmtInVisa(double freightAmtInVisa);

    /**
     * Get the value of freightAmtInVisa
     * @return freightAmtInVisa - double of freightAmtInVisa
     */
    public abstract double getFreightAmtInVisa();

    /**
     * Set the value of discrepancyFound
     * @param discrepancyFound - int of discrepancyFound
     */
    public abstract void setDiscrepancyFound(int discrepancyFound);

    /**
     * Get the value of discrepancyFound
     * @return discrepancyFound - int of discrepancyFound
     */
    public abstract int getDiscrepancyFound();

    /**
     * Set the value of discrepancyAmt
     * @param discrepancyAmt - double of discrepancyAmt
     */
    public abstract void setDiscrepancyAmt(double discrepancyAmt);

    /**
     * Get the value of discrepancyAmt
     * @return discrepancyAmt - double of discrepancyAmt
     */
    public abstract double getDiscrepancyAmt();

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
     * Set the value of discrepancyRsn
     * @param discrepancyRsn - int of discrepancyRsn
     */
    public abstract void setDiscrepancyRsn(int discrepancyRsn);

    /**
     * Get the value of discrepancyRsn
     * @return discrepancyRsn - int of discrepancyRsn
     */
    public abstract int getDiscrepancyRsn();

    /**
     * Set the value of shipDate
     * @param shipDate - Date of shipDate
     */
    public abstract void setShipDate(Date shipDate);

    /**
     * Get the value of shipDate
     * @return shipDate - Date of shipDate
     */
    public abstract Date getShipDate();

    /**
     * Set the value of pux16Amount
     * @param pux16Amount - double of pux16Amount
     */
    public abstract void setPux16Amount(double pux16Amount);

    /**
     * Get the value of pux16Amount
     * @return pux16Amount - double of pux16Amount
     */
    public abstract double getPux16Amount();

    /**
     * Set the value of couponAmount
     * @param couponAmount - double of couponAmount
     */
    public abstract void setCouponAmount(double couponAmount);

    /**
     * Get the value of couponAmount
     * @return couponAmount - double of couponAmount
     */
    public abstract double getCouponAmount();

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
     * Set the value of managerEmpId
     * @param managerEmpId - String of managerEmpId
     */
    public abstract void setManagerEmpId(String managerEmpId);

    /**
     * Get the value of managerEmpId
     * @return managerEmpId - String of managerEmpId
     */
    public abstract String getManagerEmpId();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(Date processDt, String locationCd, String awbNbr, String tinUniqId, String courierId, String paymentCurrency, double freightAmtInVisa, int discrepancyFound, double discrepancyAmt, double exchRate, int discrepancyRsn, Date shipDate, double pux16Amount, double couponAmount, String comments, String managerEmpId, int statusId)
        throws CreateException {
    	System.out.println("1");
        setProcessDt(processDt);
        System.out.println("2");
    	setLocationCd(locationCd);
    	System.out.println("3");
    	setAwbNbr(awbNbr);
    	System.out.println("4");
    	setTinUniqId(tinUniqId);
    	System.out.println("5");
    	setCourierId(courierId);
    	System.out.println("6");
    	setPaymentCurrency(paymentCurrency);
    	System.out.println("7");
    	setFreightAmtInVisa(freightAmtInVisa);
    	System.out.println("8");
    	setDiscrepancyFound(discrepancyFound);
    	System.out.println("9");
        setDiscrepancyAmt(discrepancyAmt);
        System.out.println("0");
        setExchRate(exchRate);
        System.out.println("9");
        setDiscrepancyRsn(discrepancyRsn);
        System.out.println("8");
        setShipDate(shipDate);
        System.out.println("7");
        setPux16Amount(pux16Amount);
        System.out.println("6");
        setCouponAmount(couponAmount);
        System.out.println("5");
        setComments(comments);
        System.out.println("4");
        setManagerEmpId(managerEmpId);
        System.out.println("3");
        setStatusId(statusId);
        System.out.println("2");
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(Date processDt, String locationCd, String awbNbr, String tinUniqId, String courierId, String paymentCurrency, double freightAmtInVisa, int discrepancyFound, double discrepancyAmt, double exchRate, int discrepancyRsn, Date shipDate, double pux16Amount, double couponAmount, String comments, String managerEmpId, int statusId)
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
