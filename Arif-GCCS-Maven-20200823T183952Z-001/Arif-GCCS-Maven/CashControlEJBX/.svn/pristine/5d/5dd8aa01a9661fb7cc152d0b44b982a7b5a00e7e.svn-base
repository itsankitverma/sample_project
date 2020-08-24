/**
 * @(#)CountryCurrencyBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the country_currency table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class CountryCurrencyBean implements EntityBean {

    private EntityContext _ctx;
    public CountryCurrencyBean() {
    }
    /**
     * Set the value of cntryCurrencyId
     * @param cntryCurrencyId - Integer of cntryCurrencyId
     */
    public abstract void setCntryCurrencyId(Integer cntryCurrencyId);

    /**
     * Get the value of cntryCurrencyId
     * @return cntryCurrencyId - Integer of cntryCurrencyId
     */
    public abstract Integer getCntryCurrencyId();

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
     * Set the value of currencyNm
     * @param currencyNm - String of currencyNm
     */
    public abstract void setCurrencyNm(String currencyNm);

    /**
     * Get the value of currencyNm
     * @return currencyNm - String of currencyNm
     */
    public abstract String getCurrencyNm();

    /**
     * Set the value of currencyValidSince
     * @param currencyValidSince - Date of currencyValidSince
     */
    public abstract void setCurrencyValidSince(Date currencyValidSince);

    /**
     * Get the value of currencyValidSince
     * @return currencyValidSince - Date of currencyValidSince
     */
    public abstract Date getCurrencyValidSince();

    /**
     * Set the value of currencySymbol
     * @param currencySymbol - String of currencySymbol
     */
    public abstract void setCurrencySymbol(String currencySymbol);

    /**
     * Get the value of currencySymbol
     * @return currencySymbol - String of currencySymbol
     */
    public abstract String getCurrencySymbol();

    /**
     * Set the value of exchRateMin
     * @param exchRateMin - double of exchRateMin
     */
    public abstract void setExchRateMin(double exchRateMin);

    /**
     * Get the value of exchRateMin
     * @return exchRateMin - double of exchRateMin
     */
    public abstract double getExchRateMin();

    /**
     * Set the value of exchRateMax
     * @param exchRateMax - double of exchRateMax
     */
    public abstract void setExchRateMax(double exchRateMax);

    /**
     * Get the value of exchRateMax
     * @return exchRateMax - double of exchRateMax
     */
    public abstract double getExchRateMax();

    /**
     * Set the value of exchangeRates
     * @param exchangeRates - java.util.Set of exchangeRates
     */
    public abstract void setExchangeRates(java.util.Set exchangeRates);

    /**
     * Get the value of exchangeRates
     * @return exchangeRates - java.util.Set of exchangeRates
     */
    public abstract java.util.Set getExchangeRates();

    /**
     * Set the value of country
     * @param country - CountryLocal of country
     */
    public abstract void setCountry(CountryLocal country);

    /**
     * Get the value of country
     * @return country - CountryLocal of country
     */
    public abstract CountryLocal getCountry();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String currencyCd, String currencyNm, Date currencyValidSince, String currencySymbol, double exchRateMin, double exchRateMax, CountryLocal country)
        throws CreateException {
        setCurrencyCd(currencyCd);
        setCurrencyNm(currencyNm);
        setCurrencyValidSince(currencyValidSince);
        setCurrencySymbol(currencySymbol);
        setExchRateMin(exchRateMin);
        setExchRateMax(exchRateMax);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String currencyCd, String currencyNm, Date currencyValidSince, String currencySymbol, double exchRateMin, double exchRateMax, CountryLocal country)
        throws CreateException {
        setCountry(country);
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
