/**
 * @(#)CosmosScanBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the cosmos_scan table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class CosmosScanBean implements EntityBean {

    private EntityContext _ctx;
    public CosmosScanBean() {
    }
    /**
     * Set the value of scanId
     * @param scanId - Integer of scanId
     */
    public abstract void setScanId(Integer scanId);

    /**
     * Get the value of scanId
     * @return scanId - Integer of scanId
     */
    public abstract Integer getScanId();

    /**
     * Set the value of scanLocationCd
     * @param scanLocationCd - String of scanLocationCd
     */
    public abstract void setScanLocationCd(String scanLocationCd);

    /**
     * Get the value of scanLocationCd
     * @return scanLocationCd - String of scanLocationCd
     */
    public abstract String getScanLocationCd();

    /**
     * Set the value of awbNbr
     * @param awbNbr - String of awbNbr
     */
    public abstract void setAwbNbr(String awbNbr);

    /**
     * Get the value of awbNbr
     * @return awbNbr - String of awbNbr
     */
    public abstract String getAwbNbr();

    /**
     * Set the value of tinUniqId
     * @param tinUniqId - String of tinUniqId
     */
    public abstract void setTinUniqId(String tinUniqId);

    /**
     * Get the value of tinUniqId
     * @return tinUniqId - String of tinUniqId
     */
    public abstract String getTinUniqId();

    /**
     * Set the value of scanType
     * @param scanType - String of scanType
     */
    public abstract void setScanType(String scanType);

    /**
     * Get the value of scanType
     * @return scanType - String of scanType
     */
    public abstract String getScanType();

    /**
     * Set the value of scanSeqNbr
     * @param scanSeqNbr - String of scanSeqNbr
     */
    public abstract void setScanSeqNbr(String scanSeqNbr);

    /**
     * Get the value of scanSeqNbr
     * @return scanSeqNbr - String of scanSeqNbr
     */
    public abstract String getScanSeqNbr();

    /**
     * Set the value of scanDt
     * @param scanDt - Date of scanDt
     */
    public abstract void setScanDt(Date scanDt);

    /**
     * Get the value of scanDt
     * @return scanDt - Date of scanDt
     */
    public abstract Date getScanDt();

    /**
     * Set the value of courierId
     * @param courierId - String of courierId
     */
    public abstract void setCourierId(String courierId);

    /**
     * Get the value of courierId
     * @return courierId - String of courierId
     */
    public abstract String getCourierId();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String scanLocationCd, String awbNbr, String tinUniqId, String scanType, String scanSeqNbr, Date scanDt, String courierId)
        throws CreateException {
        setScanLocationCd(scanLocationCd);
        setAwbNbr(awbNbr);
        setTinUniqId(tinUniqId);
        setScanType(scanType);
        setScanSeqNbr(scanSeqNbr);
        setScanDt(scanDt);
        setCourierId(courierId);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String scanLocationCd, String awbNbr, String tinUniqId, String scanType, String scanSeqNbr, Date scanDt, String courierId)
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
