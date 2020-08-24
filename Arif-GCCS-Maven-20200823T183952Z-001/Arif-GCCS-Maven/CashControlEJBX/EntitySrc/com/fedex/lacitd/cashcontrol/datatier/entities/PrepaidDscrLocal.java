/**
 * @(#)PrepaidDscrLocal.java			Tue Aug 02 15:38:50 VET 2005
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

public interface PrepaidDscrLocal extends EJBLocalObject {

    /**
     * Set the value of prepaidDscrId
     * @param prepaidDscrId - Integer of prepaidDscrId
     */
    public void setPrepaidDscrId(Integer prepaidDscrId);

    /**
     * Get the value of prepaidDscrId
     * @return prepaidDscrId - Integer of prepaidDscrId
     */
    public Integer getPrepaidDscrId();

    /**
     * Set the value of processDt
     * @param processDt - Date of processDt
     */
    public void setProcessDt(Date processDt);

    /**
     * Get the value of processDt
     * @return processDt - Date of processDt
     */
    public Date getProcessDt();

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
     * Set the value of discrepancyFound
     * @param discrepancyFound - int of discrepancyFound
     */
    public void setDiscrepancyFound(int discrepancyFound);

    /**
     * Get the value of discrepancyFound
     * @return discrepancyFound - int of discrepancyFound
     */
    public int getDiscrepancyFound();

    /**
     * Set the value of discrepancyAmt
     * @param discrepancyAmt - double of discrepancyAmt
     */
    public void setDiscrepancyAmt(double discrepancyAmt);

    /**
     * Get the value of discrepancyAmt
     * @return discrepancyAmt - double of discrepancyAmt
     */
    public double getDiscrepancyAmt();

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
     * Set the value of discrepancyRsn
     * @param discrepancyRsn - int of discrepancyRsn
     */
    public void setDiscrepancyRsn(int discrepancyRsn);

    /**
     * Get the value of discrepancyRsn
     * @return discrepancyRsn - int of discrepancyRsn
     */
    public int getDiscrepancyRsn();

    /**
     * Set the value of shipDate
     * @param shipDate - Date of shipDate
     */
    public void setShipDate(Date shipDate);

    /**
     * Get the value of shipDate
     * @return shipDate - Date of shipDate
     */
    public Date getShipDate();

    /**
     * Set the value of pux16Amount
     * @param pux16Amount - double of pux16Amount
     */
    public void setPux16Amount(double pux16Amount);

    /**
     * Get the value of pux16Amount
     * @return pux16Amount - double of pux16Amount
     */
    public double getPux16Amount();

    /**
     * Set the value of couponAmount
     * @param couponAmount - double of couponAmount
     */
    public void setCouponAmount(double couponAmount);

    /**
     * Get the value of couponAmount
     * @return couponAmount - double of couponAmount
     */
    public double getCouponAmount();

    /**
     * Set the value of comments
     * @param comments - String of comments
     */
    public void setComments(String comments);

    /**
     * Get the value of comments
     * @return comments - String of comments
     */
    public String getComments();

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
     * Set the value of managerEmpId
     * @param managerEmpId - String of managerEmpId
     */
    public void setManagerEmpId(String managerEmpId);

    /**
     * Get the value of managerEmpId
     * @return managerEmpId - String of managerEmpId
     */
    public String getManagerEmpId();

}
