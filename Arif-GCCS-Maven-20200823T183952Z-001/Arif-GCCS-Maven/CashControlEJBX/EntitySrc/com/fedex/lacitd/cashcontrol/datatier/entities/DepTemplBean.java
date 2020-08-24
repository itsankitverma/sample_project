/**
 * @(#)DepTemplBean.java			Tue Aug 02 15:38:50 VET 2005
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

public abstract class DepTemplBean implements EntityBean {

    private EntityContext _ctx;
    public DepTemplBean() {
    }
    /**
     * Set the value of templId
     * @param templId - Integer of templId
     */
    public abstract void setTemplId(Integer templId);

    /**
     * Get the value of templId
     * @return templId - Integer of templId
     */
    public abstract Integer getTemplId();

    /**
     * Set the value of templCd
     * @param templCd - String of templCd
     */
    public abstract void setTemplCd(String templCd);

    /**
     * Get the value of templCd
     * @return templCd - String of templCd
     */
    public abstract String getTemplCd();

    /**
     * Set the value of templDesc
     * @param templDesc - String of templDesc
     */
    public abstract void setTemplDesc(String templDesc);

    /**
     * Get the value of templDesc
     * @return templDesc - String of templDesc
     */
    public abstract String getTemplDesc();

    /**
     * Set the value of crcdReimbTypeCd
     * @param crcdReimbTypeCd - String of crcdReimbTypeCd
     */
    public abstract void setCrcdReimbTypeCd(String crcdReimbTypeCd);

    /**
     * Get the value of crcdReimbTypeCd
     * @return crcdReimbTypeCd - String of crcdReimbTypeCd
     */
    public abstract String getCrcdReimbTypeCd();

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
     * Set the value of cntRod
     * @param cntRod - int of cntRod
     */
    public abstract void setCntRod(int cntRod);

    /**
     * Get the value of cntRod
     * @return cntRod - int of cntRod
     */
    public abstract int getCntRod();

    /**
     * Set the value of cntCod
     * @param cntCod - int of cntCod
     */
    public abstract void setCntCod(int cntCod);

    /**
     * Get the value of cntCod
     * @return cntCod - int of cntCod
     */
    public abstract int getCntCod();
   
    
    /**
     * Set the value of cntFtc
     * @param cntFtc - int of cntFtc
     */
    public abstract void setCntFtc(int cntFtc);

    /**
     * Get the value of cntFtc
     * @return cntFtc - int of cntFtc
     */
    public abstract int getCntFtc();
   
    
    
    /**
     * Set the value of cntPrepaid
     * @param cntPrepaid - int of cntPrepaid
     */
    public abstract void setCntPrepaid(int cntPrepaid);

    /**
     * Get the value of cntPrepaid
     * @return cntPrepaid - int of cntPrepaid
     */
    public abstract int getCntPrepaid();

    /**
     * Set the value of cntPoa
     * @param cntPoa - int of cntPoa
     */
    public abstract void setCntPoa(int cntPoa);

    /**
     * Get the value of cntPoa
     * @return cntPoa - int of cntPoa
     */
    public abstract int getCntPoa();

    /**
     * Set the value of cntOther
     * @param cntOther - int of cntOther
     */
    public abstract void setCntOther(int cntOther);

    /**
     * Get the value of cntOther
     * @return cntOther - int of cntOther
     */
    public abstract int getCntOther();

    /**
     * Set the value of disabTempl
     * @param disabTempl - int of disabTempl
     */
    public abstract void setDisabTempl(int disabTempl);

    /**
     * Get the value of disabTempl
     * @return disabTempl - int of disabTempl
     */
    public abstract int getDisabTempl();

    /**
     * Set the value of cntGrnd
     * @param cntGrnd - int of cntGrnd
     */
    public abstract void setCntGrnd(int cntGrnd);

    /**
     * Get the value of cntGrnd
     * @return cntGrnd - int of cntGrnd
     */
    public abstract int getCntGrnd();

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
     * Add a new PaymentType
     * @param paymentType - PaymentType paymentType
     */
    public void addPaymentType(PaymentTypeLocal paymentType) {
        java.util.Set paymentTypesCol = getPaymentTypes();
        paymentTypesCol.add(paymentType);
    }

    /**
     * Remove a PaymentType
     * @param paymentType - PaymentType paymentType
     */
    public void removePaymentType(PaymentTypeLocal paymentType) {
        java.util.Set paymentTypesCol = getPaymentTypes();
        paymentTypesCol.remove(paymentType);
    }

    /**
     * Set the value of paymentTypes
     * @param paymentTypes - java.util.Set of paymentTypes
     */
    public abstract void setPaymentTypes(java.util.Set paymentTypes);

    /**
     * Get the value of paymentTypes
     * @return paymentTypes - java.util.Set of paymentTypes
     */
    public abstract java.util.Set getPaymentTypes();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String templCd, String templDesc, String crcdReimbTypeCd, String currencyType, int cntRod, int cntPrepaid, int cntPoa, int cntOther, int disabTempl, int cntGrnd, int cntCod, int cntFtc)
        throws CreateException {
        setTemplCd(templCd);
        setTemplDesc(templDesc);
        setCrcdReimbTypeCd(crcdReimbTypeCd);
        setCurrencyType(currencyType);
        setCntRod(cntRod);
        setCntPrepaid(cntPrepaid);
        setCntPoa(cntPoa);
        setCntOther(cntOther);
        setDisabTempl(disabTempl);
        setCntGrnd(cntGrnd);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String templCd, String templDesc, String crcdReimbTypeCd, String currencyType, int cntRod, int cntPrepaid, int cntPoa, int cntOther, int disabTempl, int cntGrnd, int cntCod, int cntFtc)
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
