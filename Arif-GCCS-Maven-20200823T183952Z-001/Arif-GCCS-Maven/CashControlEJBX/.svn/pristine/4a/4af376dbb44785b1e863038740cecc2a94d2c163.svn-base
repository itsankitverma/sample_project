/**
 * @(#)BankAccBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the bank_acc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class BankAccBean implements EntityBean {

    private EntityContext _ctx;
    public BankAccBean() {
    }
    /**
     * Set the value of bankAccountCd
     * @param bankAccountCd - Integer of bankAccountCd
     */
    public abstract void setBankAccountCd(Integer bankAccountCd);

    /**
     * Get the value of bankAccountCd
     * @return bankAccountCd - Integer of bankAccountCd
     */
    public abstract Integer getBankAccountCd();

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
     * Set the value of bankBranchId
     * @param bankBranchId - String of bankBranchId
     */
    public abstract void setBankBranchId(String bankBranchId);

    /**
     * Get the value of bankBranchId
     * @return bankBranchId - String of bankBranchId
     */
    public abstract String getBankBranchId();

    /**
     * Set the value of currencyType
     * @param currencyType - String of currencyType
     */
    public abstract void setCurrencyType(String currencyType);

    /**
     * Get the value of currencyType
     * @return currencyType - String of currencyType
     */
    public abstract String getCurrencyType();

    /**
     * Set the value of depositSlips
     * @param depositSlips - java.util.Set of depositSlips
     */
    public abstract void setDepositSlips(java.util.Set depositSlips);

    /**
     * Get the value of depositSlips
     * @return depositSlips - java.util.Set of depositSlips
     */
    public abstract java.util.Set getDepositSlips();

    /**
     * Set the value of bank
     * @param bank - BankLocal of bank
     */
    public abstract void setBank(BankLocal bank);

    /**
     * Get the value of bank
     * @return bank - BankLocal of bank
     */
    public abstract BankLocal getBank();

    /**
     * Add a new Location
     * @param location - Location location
     */
    public void addLocation(LocationLocal location) {
        java.util.Set locationsCol = getLocations();
        locationsCol.add(location);
    }

    /**
     * Remove a Location
     * @param location - Location location
     */
    public void removeLocation(LocationLocal location) {
        java.util.Set locationsCol = getLocations();
        locationsCol.remove(location);
    }

    /**
     * Set the value of locations
     * @param locations - java.util.Set of locations
     */
    public abstract void setLocations(java.util.Set locations);

    /**
     * Get the value of locations
     * @return locations - java.util.Set of locations
     */
    public abstract java.util.Set getLocations();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String accountNbr, String bankBranchId, String currencyType, BankLocal bank, String originationNbr)
        throws CreateException {
        setAccountNbr(accountNbr);
        setBankBranchId(bankBranchId);
        setCurrencyType(currencyType);
        setOriginationNbr(originationNbr);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String accountNbr, String bankBranchId, String currencyType, BankLocal bank, String originationNbr)
        throws CreateException {
        setBank(bank);
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
    
    /**
     * Set the value of accountNbr
     * @param OriginationNbr - String of OriginationNbr
     */
    public abstract void setOriginationNbr(String originationNbr);

    /**
     * Get the value of accountNbr
     * @return OriginationNbr - String of OriginationNbr
     */
    public abstract String getOriginationNbr();

}
