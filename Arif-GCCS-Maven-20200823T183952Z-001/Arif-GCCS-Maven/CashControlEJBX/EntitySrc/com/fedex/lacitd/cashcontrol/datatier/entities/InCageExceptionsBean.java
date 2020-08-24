/**
 * @(#)InCageExceptionsBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the in_cage_exceptions table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class InCageExceptionsBean implements EntityBean {

    private EntityContext _ctx;
    public InCageExceptionsBean() {
    }
    /**
     * Set the value of inCageExcpId
     * @param inCageExcpId - Integer of inCageExcpId
     */
    public abstract void setInCageExcpId(Integer inCageExcpId);

    /**
     * Get the value of inCageExcpId
     * @return inCageExcpId - Integer of inCageExcpId
     */
    public abstract Integer getInCageExcpId();

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
     * Set the value of reportDt
     * @param reportDt - Date of reportDt
     */
    public abstract void setReportDt(Date reportDt);

    /**
     * Get the value of reportDt
     * @return reportDt - Date of reportDt
     */
    public abstract Date getReportDt();

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
     * Set the value of lastDexEmpId
     * @param lastDexEmpId - String of lastDexEmpId
     */
    public abstract void setLastDexEmpId(String lastDexEmpId);

    /**
     * Get the value of lastDexEmpId
     * @return lastDexEmpId - String of lastDexEmpId
     */
    public abstract String getLastDexEmpId();

    /**
     * Set the value of lastStat44EmpId
     * @param lastStat44EmpId - String of lastStat44EmpId
     */
    public abstract void setLastStat44EmpId(String lastStat44EmpId);

    /**
     * Get the value of lastStat44EmpId
     * @return lastStat44EmpId - String of lastStat44EmpId
     */
    public abstract String getLastStat44EmpId();

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
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String locationCd, Date reportDt, String awbNbr, String lastDexEmpId, String lastStat44EmpId, String description)
        throws CreateException {
        setLocationCd(locationCd);
        setReportDt(reportDt);
        setAwbNbr(awbNbr);
        setLastDexEmpId(lastDexEmpId);
        setLastStat44EmpId(lastStat44EmpId);
        setDescription(description);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String locationCd, Date reportDt, String awbNbr, String lastDexEmpId, String lastStat44EmpId, String description)
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
