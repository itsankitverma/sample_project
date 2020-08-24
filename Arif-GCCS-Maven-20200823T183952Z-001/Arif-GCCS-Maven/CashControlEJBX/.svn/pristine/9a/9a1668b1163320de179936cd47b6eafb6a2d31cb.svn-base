/**
 * @(#)SurchargeLocBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the surcharge_loc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class SurchargeLocBean implements EntityBean {

    private EntityContext _ctx;
    public SurchargeLocBean() {
    }
    /**
     * Set the value of surchargeCd
     * @param surchargeCd - String of surchargeCd
     */
    public abstract void setSurchargeCd(String surchargeCd);

    /**
     * Get the value of surchargeCd
     * @return surchargeCd - String of surchargeCd
     */
    public abstract String getSurchargeCd();

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
     * Set the value of applyRod
     * @param applyRod - int of applyRod
     */
    public abstract void setApplyRod(int applyRod);

    /**
     * Get the value of applyRod
     * @return applyRod - int of applyRod
     */
    public abstract int getApplyRod();

    /**
     * Set the value of applyPrepaid
     * @param applyPrepaid - int of applyPrepaid
     */
    public abstract void setApplyPrepaid(int applyPrepaid);

    /**
     * Get the value of applyPrepaid
     * @return applyPrepaid - int of applyPrepaid
     */
    public abstract int getApplyPrepaid();

    /**
     * Set the value of applyPoa
     * @param applyPoa - int of applyPoa
     */
    public abstract void setApplyPoa(int applyPoa);

    /**
     * Get the value of applyPoa
     * @return applyPoa - int of applyPoa
     */
    public abstract int getApplyPoa();

    /**
     * Set the value of applyOrder
     * @param applyOrder - int of applyOrder
     */
    public abstract void setApplyOrder(int applyOrder);

    /**
     * Get the value of applyOrder
     * @return applyOrder - int of applyOrder
     */
    public abstract int getApplyOrder();

    /**
     * Set the value of disabSurcharge
     * @param disabSurcharge - int of disabSurcharge
     */
    public abstract void setDisabSurcharge(int disabSurcharge);

    /**
     * Get the value of disabSurcharge
     * @return disabSurcharge - int of disabSurcharge
     */
    public abstract int getDisabSurcharge();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK ejbCreate(String surchargeCd, String locationCd, int applyRod, int applyPrepaid, int applyPoa, int applyOrder, int disabSurcharge)
        throws CreateException {
        setSurchargeCd(surchargeCd);
        setLocationCd(locationCd);
        setApplyRod(applyRod);
        setApplyPrepaid(applyPrepaid);
        setApplyPoa(applyPoa);
        setApplyOrder(applyOrder);
        setDisabSurcharge(disabSurcharge);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String surchargeCd, String locationCd, int applyRod, int applyPrepaid, int applyPoa, int applyOrder, int disabSurcharge)
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
