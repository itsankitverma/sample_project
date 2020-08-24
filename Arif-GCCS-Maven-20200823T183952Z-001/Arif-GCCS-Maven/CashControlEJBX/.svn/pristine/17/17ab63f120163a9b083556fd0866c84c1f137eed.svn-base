/**
 * @(#)PymtImptErrorDtlBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the pymt_impt_error_dtl table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class PymtImptErrorDtlBean implements EntityBean {

    private EntityContext _ctx;
    public PymtImptErrorDtlBean() {
    }
    /**
     * Set the value of imptErrorDtlId
     * @param imptErrorDtlId - Integer of imptErrorDtlId
     */
    public abstract void setImptErrorDtlId(Integer imptErrorDtlId);

    /**
     * Get the value of imptErrorDtlId
     * @return imptErrorDtlId - Integer of imptErrorDtlId
     */
    public abstract Integer getImptErrorDtlId();

    /**
     * Set the value of imptMessageDtl
     * @param imptMessageDtl - String of imptMessageDtl
     */
    public abstract void setImptMessageDtl(String imptMessageDtl);

    /**
     * Get the value of imptMessageDtl
     * @return imptMessageDtl - String of imptMessageDtl
     */
    public abstract String getImptMessageDtl();

    /**
     * Set the value of imptError
     * @param imptError - String of imptError
     */
    public abstract void setImptError(String imptError);

    /**
     * Get the value of imptError
     * @return imptError - String of imptError
     */
    public abstract String getImptError();

    /**
     * Set the value of pymtImptLog
     * @param pymtImptLog - PymtImptLogLocal of pymtImptLog
     */
    public abstract void setPymtImptLog(PymtImptLogLocal pymtImptLog);

    /**
     * Get the value of pymtImptLog
     * @return pymtImptLog - PymtImptLogLocal of pymtImptLog
     */
    public abstract PymtImptLogLocal getPymtImptLog();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String imptMessageDtl, String imptError, PymtImptLogLocal pymtImptLog)
        throws CreateException {
        setImptMessageDtl(imptMessageDtl);
        setImptError(imptError);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String imptMessageDtl, String imptError, PymtImptLogLocal pymtImptLog)
        throws CreateException {
        setPymtImptLog(pymtImptLog);
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
