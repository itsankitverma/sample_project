/**
 * @(#)ExchangeRateBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the exchange_rate table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class ExchangeRateBean implements EntityBean {

    private EntityContext _ctx;
    public ExchangeRateBean() {
    }
    /**
     * Set the value of exchRateId
     * @param exchRateId - Integer of exchRateId
     */
    public abstract void setExchRateId(Integer exchRateId);

    /**
     * Get the value of exchRateId
     * @return exchRateId - Integer of exchRateId
     */
    public abstract Integer getExchRateId();

    /**
     * Set the value of exchRate
     * @param exchRate - Date of exchRate
     */
    public abstract void setExchRate(Date exchRate);

    /**
     * Get the value of exchRate
     * @return exchRate - Date of exchRate
     */
    public abstract Date getExchRate();

    /**
     * Set the value of exchRtByUsd
     * @param exchRtByUsd - int of exchRtByUsd
     */
    public abstract void setExchRtByUsd(int exchRtByUsd);

    /**
     * Get the value of exchRtByUsd
     * @return exchRtByUsd - int of exchRtByUsd
     */
    public abstract int getExchRtByUsd();

    /**
     * Set the value of exchRateType
     * @param exchRateType - String of exchRateType
     */
    public abstract void setExchRateType(String exchRateType);

    /**
     * Get the value of exchRateType
     * @return exchRateType - String of exchRateType
     */
    public abstract String getExchRateType();

    /**
     * Set the value of countryCurrency
     * @param countryCurrency - CountryCurrencyLocal of countryCurrency
     */
    public abstract void setCountryCurrency(CountryCurrencyLocal countryCurrency);

    /**
     * Get the value of countryCurrency
     * @return countryCurrency - CountryCurrencyLocal of countryCurrency
     */
    public abstract CountryCurrencyLocal getCountryCurrency();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(Date exchRate, int exchRtByUsd, String exchRateType, CountryCurrencyLocal countryCurrency)
        throws CreateException {
        setExchRate(exchRate);
        setExchRtByUsd(exchRtByUsd);
        setExchRateType(exchRateType);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(Date exchRate, int exchRtByUsd, String exchRateType, CountryCurrencyLocal countryCurrency)
        throws CreateException {
        setCountryCurrency(countryCurrency);
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
