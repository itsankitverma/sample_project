/**
 * @(#)PaymentTypeBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the payment_type table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class PaymentTypeBean implements EntityBean {

    private EntityContext _ctx;
    public PaymentTypeBean() {
    }
    /**
     * Set the value of paymentTypeId
     * @param paymentTypeId - Integer of paymentTypeId
     */
    public abstract void setPaymentTypeId(Integer paymentTypeId);

    /**
     * Get the value of paymentTypeId
     * @return paymentTypeId - Integer of paymentTypeId
     */
    public abstract Integer getPaymentTypeId();

    /**
     * Set the value of description
     * @param description - String of description
     */
    public abstract void setDescription(String description);

    /**
     * Get the value of description
     * @return description - String of description
     */
    public abstract String getDescription();

    /**
     * Set the value of shtDesc
     * @param shtDesc - String of shtDesc
     */
    public abstract void setShtDesc(String shtDesc);

    /**
     * Get the value of shtDesc
     * @return shtDesc - String of shtDesc
     */
    public abstract String getShtDesc();

    /**
     * Set the value of paymentCd
     * @param paymentCd - String of paymentCd
     */
    public abstract void setPaymentCd(String paymentCd);

    /**
     * Get the value of paymentCd
     * @return paymentCd - String of paymentCd
     */
    public abstract String getPaymentCd();

    /**
     * Set the value of rodCombo
     * @param rodCombo - int of rodCombo
     */
    public abstract void setRodCombo(int rodCombo);

    /**
     * Get the value of rodCombo
     * @return rodCombo - int of rodCombo
     */
    public abstract int getRodCombo();

    /**
     * Set the value of codCombo
     * @param codCombo - int of codCombo
     */
    public abstract void setCodCombo(int codCombo);

    /**
     * Get the value of codCombo
     * @return codCombo - int of codCombo
     */
    public abstract int getCodCombo();
    
    /**
     * Set the value of ftcCombo
     * @param ftcCombo - int of ftcCombo
     */
    public abstract void setFtcCombo(int ftcCombo);

    /**
     * Get the value of ftcCombo
     * @return ftcCombo - int of ftcCombo
     */
    public abstract int getFtcCombo();

    /**
     * Set the value of prpCombo
     * @param prpCombo - int of prpCombo
     */
    public abstract void setPrpCombo(int prpCombo);

    /**
     * Get the value of prpCombo
     * @return prpCombo - int of prpCombo
     */
    public abstract int getPrpCombo();

    /**
     * Set the value of poaCombo
     * @param poaCombo - int of poaCombo
     */
    public abstract void setPoaCombo(int poaCombo);

    /**
     * Get the value of poaCombo
     * @return poaCombo - int of poaCombo
     */
    public abstract int getPoaCombo();

    /**
     * Set the value of otherCombo
     * @param otherCombo - int of otherCombo
     */
    public abstract void setOtherCombo(int otherCombo);

    /**
     * Get the value of otherCombo
     * @return otherCombo - int of otherCombo
     */
    public abstract int getOtherCombo();

    /**
     * Set the value of canDeact
     * @param canDeact - int of canDeact
     */
    public abstract void setCanDeact(int canDeact);

    /**
     * Get the value of canDeact
     * @return canDeact - int of canDeact
     */
    public abstract int getCanDeact();

    /**
     * Set the value of paymentCtgId
     * @param paymentCtgId - int of paymentCtgId
     */
    public abstract void setPaymentCtgId(int paymentCtgId);

    /**
     * Get the value of paymentCtgId
     * @return paymentCtgId - int of paymentCtgId
     */
    public abstract int getPaymentCtgId();

    /**
     * Set the value of activePymt
     * @param activePymt - int of activePymt
     */
    public abstract void setActivePymt(int activePymt);

    /**
     * Get the value of activePymt
     * @return activePymt - int of activePymt
     */
    public abstract int getActivePymt();

    /**
     * Set the value of gndCombo
     * @param gndCombo - int of gndCombo
     */
    public abstract void setGndCombo(int gndCombo);

    /**
     * Get the value of gndCombo
     * @return gndCombo - int of gndCombo
     */
    public abstract int getGndCombo();

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
     * Add a new DepTempl
     * @param depTempl - DepTempl depTempl
     */
    public void addDepTempl(DepTemplLocal depTempl) {
        java.util.Set depTemplsCol = getDepTempls();
        depTemplsCol.add(depTempl);
    }

    /**
     * Remove a DepTempl
     * @param depTempl - DepTempl depTempl
     */
    public void removeDepTempl(DepTemplLocal depTempl) {
        java.util.Set depTemplsCol = getDepTempls();
        depTemplsCol.remove(depTempl);
    }

    /**
     * Set the value of depTempls
     * @param depTempls - java.util.Set of depTempls
     */
    public abstract void setDepTempls(java.util.Set depTempls);

    /**
     * Get the value of depTempls
     * @return depTempls - java.util.Set of depTempls
     */
    public abstract java.util.Set getDepTempls();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String description, String shtDesc, String paymentCd, int rodCombo, int prpCombo, int poaCombo, int otherCombo, int canDeact, int paymentCtgId, int activePymt, int gndCombo, int codCombo, int ftcCombo)
        throws CreateException {
        setDescription(description);
        setShtDesc(shtDesc);
        setPaymentCd(paymentCd);
        setRodCombo(rodCombo);
        setPrpCombo(prpCombo);
        setPoaCombo(poaCombo);
        setOtherCombo(otherCombo);
        setCanDeact(canDeact);
        setPaymentCtgId(paymentCtgId);
        setActivePymt(activePymt);
        setGndCombo(gndCombo);
        setCodCombo(codCombo);
        setFtcCombo(ftcCombo);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String description, String shtDesc, String paymentCd, int rodCombo, int prpCombo, int poaCombo, int otherCombo, int canDeact, int paymentCtgId, int activePymt, int gndCombo, int codCombo, int ftcCombo)
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
