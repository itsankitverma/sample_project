/**
 * @(#)GlExchRateBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the gl_exch_rate table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class GlExchRateBean implements EntityBean {

    private EntityContext _ctx;
    public GlExchRateBean() {
    }
    /**
     * Set the value of currCd
     * @param currCd - String of currCd
     */
    public abstract void setCurrCd(String currCd);

    /**
     * Get the value of currCd
     * @return currCd - String of currCd
     */
    public abstract String getCurrCd();

    /**
     * Set the value of perdDt
     * @param perdDt - Date of perdDt
     */
    public abstract void setPerdDt(Date perdDt);

    /**
     * Get the value of perdDt
     * @return perdDt - Date of perdDt
     */
    public abstract Date getPerdDt();

    /**
     * Set the value of avgExchRtAmt
     * @param avgExchRtAmt - double of avgExchRtAmt
     */
    public abstract void setAvgExchRtAmt(double avgExchRtAmt);

    /**
     * Get the value of avgExchRtAmt
     * @return avgExchRtAmt - double of avgExchRtAmt
     */
    public abstract double getAvgExchRtAmt();

    /**
     * Set the value of curExchRtAmt
     * @param curExchRtAmt - double of curExchRtAmt
     */
    public abstract void setCurExchRtAmt(double curExchRtAmt);

    /**
     * Get the value of curExchRtAmt
     * @return curExchRtAmt - double of curExchRtAmt
     */
    public abstract double getCurExchRtAmt();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK ejbCreate(String currCd, Date perdDt, double avgExchRtAmt, double curExchRtAmt)
        throws CreateException {
        setCurrCd(currCd);
        setPerdDt(perdDt);
        setAvgExchRtAmt(avgExchRtAmt);
        setCurExchRtAmt(curExchRtAmt);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String currCd, Date perdDt, double avgExchRtAmt, double curExchRtAmt)
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
