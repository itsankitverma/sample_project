/**
 * @(#)PymtImptLogBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the pymt_impt_log table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class PymtImptLogBean implements EntityBean {

    private EntityContext _ctx;
    public PymtImptLogBean() {
    }
    /**
     * Set the value of imptId
     * @param imptId - Integer of imptId
     */
    public abstract void setImptId(Integer imptId);

    /**
     * Get the value of imptId
     * @return imptId - Integer of imptId
     */
    public abstract Integer getImptId();

    /**
     * Set the value of imptFileNm
     * @param imptFileNm - String of imptFileNm
     */
    public abstract void setImptFileNm(String imptFileNm);

    /**
     * Get the value of imptFileNm
     * @return imptFileNm - String of imptFileNm
     */
    public abstract String getImptFileNm();

    /**
     * Set the value of imptDt
     * @param imptDt - Date of imptDt
     */
    public abstract void setImptDt(Date imptDt);

    /**
     * Get the value of imptDt
     * @return imptDt - Date of imptDt
     */
    public abstract Date getImptDt();

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
     * Set the value of statusCd
     * @param statusCd - int of statusCd
     */
    public abstract void setStatusCd(int statusCd);

    /**
     * Get the value of statusCd
     * @return statusCd - int of statusCd
     */
    public abstract int getStatusCd();

    /**
     * Set the value of message
     * @param message - String of message
     */
    public abstract void setMessage(String message);

    /**
     * Get the value of message
     * @return message - String of message
     */
    public abstract String getMessage();

    /**
     * Set the value of pymtImptErrorDtls
     * @param pymtImptErrorDtls - java.util.Set of pymtImptErrorDtls
     */
    public abstract void setPymtImptErrorDtls(java.util.Set pymtImptErrorDtls);

    /**
     * Get the value of pymtImptErrorDtls
     * @return pymtImptErrorDtls - java.util.Set of pymtImptErrorDtls
     */
    public abstract java.util.Set getPymtImptErrorDtls();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String imptFileNm, Date imptDt, String locationCd, int statusCd, String message)
        throws CreateException {
        setImptFileNm(imptFileNm);
        setImptDt(imptDt);
        setLocationCd(locationCd);
        setStatusCd(statusCd);
        setMessage(message);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String imptFileNm, Date imptDt, String locationCd, int statusCd, String message)
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
