/**
 * @(#)DepTemplLocal.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the dep_templ table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface DepTemplLocal extends EJBLocalObject {

    /**
     * Set the value of templId
     * @param templId - Integer of templId
     */
    public void setTemplId(Integer templId);

    /**
     * Get the value of templId
     * @return templId - Integer of templId
     */
    public Integer getTemplId();

    /**
     * Set the value of templCd
     * @param templCd - String of templCd
     */
    public void setTemplCd(String templCd);

    /**
     * Get the value of templCd
     * @return templCd - String of templCd
     */
    public String getTemplCd();

    /**
     * Set the value of templDesc
     * @param templDesc - String of templDesc
     */
    public void setTemplDesc(String templDesc);

    /**
     * Get the value of templDesc
     * @return templDesc - String of templDesc
     */
    public String getTemplDesc();

    /**
     * Set the value of crcdReimbTypeCd
     * @param crcdReimbTypeCd - String of crcdReimbTypeCd
     */
    public void setCrcdReimbTypeCd(String crcdReimbTypeCd);

    /**
     * Get the value of crcdReimbTypeCd
     * @return crcdReimbTypeCd - String of crcdReimbTypeCd
     */
    public String getCrcdReimbTypeCd();

    /**
     * Set the value of currencyType
     * @param currencyType - String of currencyType
     */
    public void setCurrencyType(String currencyType);

    /**
     * Get the value of currencyType
     * @return currencyType - String of currencyType
     */
    public String getCurrencyType();

    /**
     * Set the value of cntRod
     * @param cntRod - int of cntRod
     */
    public void setCntRod(int cntRod);

    /**
     * Get the value of cntRod
     * @return cntRod - int of cntRod
     */
    public int getCntRod();

    /**
     * Set the value of cntPrepaid
     * @param cntPrepaid - int of cntPrepaid
     */
    public void setCntPrepaid(int cntPrepaid);

    /**
     * Get the value of cntPrepaid
     * @return cntPrepaid - int of cntPrepaid
     */
    public int getCntPrepaid();

    /**
     * Set the value of cntPoa
     * @param cntPoa - int of cntPoa
     */
    public void setCntPoa(int cntPoa);

    /**
     * Get the value of cntPoa
     * @return cntPoa - int of cntPoa
     */
    public int getCntPoa();

    /**
     * Set the value of cntOther
     * @param cntOther - int of cntOther
     */
    public void setCntOther(int cntOther);

    /**
     * Get the value of cntOther
     * @return cntOther - int of cntOther
     */
    public int getCntOther();

    /**
     * Set the value of disabTempl
     * @param disabTempl - int of disabTempl
     */
    
    
    /**
     * Set the value of cntCod
     * @param cntCod - int of cntCod
     */
    public void setCntCod(int cntCod);

    /**
     * Get the value of cntCod
     * @return cntCod - int of cntCod
     */
    public int getCntCod();

    
    /**
     * Set the value of cntFtc
     * @param cntFtc - int of cntFtc
     */
    public void setCntFtc(int cntFtc);

    /**
     * Get the value of cntFtc
     * @return cntFtc - int of cntFtc
     */
    public int getCntFtc();
    
    
    /**
     * Set the value of disabTempl
     * @param disabTempl - int of disabTempl
     */
    
    public void setDisabTempl(int disabTempl);

    /**
     * Get the value of disabTempl
     * @return disabTempl - int of disabTempl
     */
    public int getDisabTempl();

    /**
     * Set the value of cntGrnd
     * @param cntGrnd - int of cntGrnd
     */
    public void setCntGrnd(int cntGrnd);

    /**
     * Get the value of cntGrnd
     * @return cntGrnd - int of cntGrnd
     */
    public int getCntGrnd();

    /**
     * Adds a new Location
     * @param location - Location location
     */
    public void addLocation(LocationLocal location);

    /**
     * Removes a Location
     * @param location - Location location
     */
    public void removeLocation(LocationLocal location);

    /**
     * Set the value of locations
     * @param locations - java.util.Set of locations
     */
    public void setLocations(java.util.Set locations);

    /**
     * Get the value of locations
     * @return locations - java.util.Set of locations
     */
    public java.util.Set getLocations();

    /**
     * Adds a new PaymentType
     * @param paymentType - PaymentType paymentType
     */
    public void addPaymentType(PaymentTypeLocal paymentType);

    /**
     * Removes a PaymentType
     * @param paymentType - PaymentType paymentType
     */
    public void removePaymentType(PaymentTypeLocal paymentType);

    /**
     * Set the value of paymentTypes
     * @param paymentTypes - java.util.Set of paymentTypes
     */
    public void setPaymentTypes(java.util.Set paymentTypes);

    /**
     * Get the value of paymentTypes
     * @return paymentTypes - java.util.Set of paymentTypes
     */
    public java.util.Set getPaymentTypes();

}
