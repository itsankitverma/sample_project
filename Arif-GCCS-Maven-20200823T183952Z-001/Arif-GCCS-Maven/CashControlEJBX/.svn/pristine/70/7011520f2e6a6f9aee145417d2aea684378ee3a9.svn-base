/**
 * @(#)BankBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the bank table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class BankBean implements EntityBean {

    private EntityContext _ctx;
    public BankBean() {
    }
    /**
     * Set the value of bankId
     * @param bankId - Integer of bankId
     */
    public abstract void setBankId(Integer bankId);

    /**
     * Get the value of bankId
     * @return bankId - Integer of bankId
     */
    public abstract Integer getBankId();

    /**
     * Set the value of bankNm
     * @param bankNm - String of bankNm
     */
    public abstract void setBankNm(String bankNm);

    /**
     * Get the value of bankNm
     * @return bankNm - String of bankNm
     */
    public abstract String getBankNm();

    /**
     * Set the value of bankCd
     * @param bankCd - String of bankCd
     */
    public abstract void setBankCd(String bankCd);

    /**
     * Get the value of bankCd
     * @return bankCd - String of bankCd
     */
    public abstract String getBankCd();

    /**
     * Set the value of bankShtDesc
     * @param bankShtDesc - String of bankShtDesc
     */
    public abstract void setBankShtDesc(String bankShtDesc);

    /**
     * Get the value of bankShtDesc
     * @return bankShtDesc - String of bankShtDesc
     */
    public abstract String getBankShtDesc();

    /**
     * Set the value of bankAccs
     * @param bankAccs - java.util.Set of bankAccs
     */
    public abstract void setBankAccs(java.util.Set bankAccs);

    /**
     * Get the value of bankAccs
     * @return bankAccs - java.util.Set of bankAccs
     */
    public abstract java.util.Set getBankAccs();

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
    public java.lang.Integer ejbCreate(String bankNm, String bankCd, String bankShtDesc, CountryLocal country)
        throws CreateException {
        setBankNm(bankNm);
        setBankCd(bankCd);
        setBankShtDesc(bankShtDesc);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String bankNm, String bankCd, String bankShtDesc, CountryLocal country)
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
