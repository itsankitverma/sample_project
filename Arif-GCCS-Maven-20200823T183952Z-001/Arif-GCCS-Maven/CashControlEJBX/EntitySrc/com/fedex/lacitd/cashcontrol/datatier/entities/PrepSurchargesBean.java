/**
 * @(#)PrepSurchargesBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the prep_surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class PrepSurchargesBean implements EntityBean {

    private EntityContext _ctx;
    public PrepSurchargesBean() {
    }
    /**
     * Set the value of prepaidId
     * @param prepaidId - Integer of prepaidId
     */
    public abstract void setPrepaidId(Integer prepaidId);

    /**
     * Get the value of prepaidId
     * @return prepaidId - Integer of prepaidId
     */
    public abstract Integer getPrepaidId();

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
     * Set the value of appliedAmt
     * @param appliedAmt - double of appliedAmt
     */
    public abstract void setAppliedAmt(double appliedAmt);

    /**
     * Get the value of appliedAmt
     * @return appliedAmt - double of appliedAmt
     */
    public abstract double getAppliedAmt();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK ejbCreate(Integer prepaidId, String surchargeCd, double appliedAmt)
        throws CreateException {
        setPrepaidId(prepaidId);
        setSurchargeCd(surchargeCd);
        setAppliedAmt(appliedAmt);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(Integer prepaidId, String surchargeCd, double appliedAmt)
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
