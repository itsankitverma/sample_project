/**
 * @(#)RodFileProcLogBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the rod_file_proc_log table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class RodFileProcLogBean implements EntityBean {

    private EntityContext _ctx;
    public RodFileProcLogBean() {
    }
    /**
     * Set the value of rodFilePrLogId
     * @param rodFilePrLogId - Integer of rodFilePrLogId
     */
    public abstract void setRodFilePrLogId(Integer rodFilePrLogId);

    /**
     * Get the value of rodFilePrLogId
     * @return rodFilePrLogId - Integer of rodFilePrLogId
     */
    public abstract Integer getRodFilePrLogId();

    /**
     * Set the value of fileNm
     * @param fileNm - String of fileNm
     */
    public abstract void setFileNm(String fileNm);

    /**
     * Get the value of fileNm
     * @return fileNm - String of fileNm
     */
    public abstract String getFileNm();

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
     * Set the value of processDt
     * @param processDt - Date of processDt
     */
    public abstract void setProcessDt(Date processDt);

    /**
     * Get the value of processDt
     * @return processDt - Date of processDt
     */
    public abstract Date getProcessDt();

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
     * Set the value of errorDtlDesc
     * @param errorDtlDesc - String of errorDtlDesc
     */
    public abstract void setErrorDtlDesc(String errorDtlDesc);

    /**
     * Get the value of errorDtlDesc
     * @return errorDtlDesc - String of errorDtlDesc
     */
    public abstract String getErrorDtlDesc();

    /**
     * Set the value of awbQty
     * @param awbQty - int of awbQty
     */
    public abstract void setAwbQty(int awbQty);

    /**
     * Get the value of awbQty
     * @return awbQty - int of awbQty
     */
    public abstract int getAwbQty();

    /**
     * Set the value of totalLocalAmt
     * @param totalLocalAmt - double of totalLocalAmt
     */
    public abstract void setTotalLocalAmt(double totalLocalAmt);

    /**
     * Get the value of totalLocalAmt
     * @return totalLocalAmt - double of totalLocalAmt
     */
    public abstract double getTotalLocalAmt();

    /**
     * Set the value of totalUsdAmt
     * @param totalUsdAmt - double of totalUsdAmt
     */
    public abstract void setTotalUsdAmt(double totalUsdAmt);

    /**
     * Get the value of totalUsdAmt
     * @return totalUsdAmt - double of totalUsdAmt
     */
    public abstract double getTotalUsdAmt();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String fileNm, String locationCd, Date processDt, int statusCd, String message, String errorDtlDesc, int awbQty, double totalLocalAmt, double totalUsdAmt)
        throws CreateException {
        setFileNm(fileNm);
        setLocationCd(locationCd);
        setProcessDt(processDt);
        setStatusCd(statusCd);
        setMessage(message);
        setErrorDtlDesc(errorDtlDesc);
        setAwbQty(awbQty);
        setTotalLocalAmt(totalLocalAmt);
        setTotalUsdAmt(totalUsdAmt);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String fileNm, String locationCd, Date processDt, int statusCd, String message, String errorDtlDesc, int awbQty, double totalLocalAmt, double totalUsdAmt)
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
