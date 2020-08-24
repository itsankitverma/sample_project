/**
 * @(#)EmployeeBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the employee table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class EmployeeBean implements EntityBean {

    private EntityContext _ctx;
    public EmployeeBean() {
    }
    /**
     * Set the value of employeeId
     * @param employeeId - String of employeeId
     */
    public abstract void setEmployeeId(String employeeId);

    /**
     * Get the value of employeeId
     * @return employeeId - String of employeeId
     */
    public abstract String getEmployeeId();

    /**
     * Set the value of employeeNm
     * @param employeeNm - String of employeeNm
     */
    public abstract void setEmployeeNm(String employeeNm);

    /**
     * Get the value of employeeNm
     * @return employeeNm - String of employeeNm
     */
    public abstract String getEmployeeNm();

    /**
     * Set the value of password
     * @param password - String of password
     */
    public abstract void setPassword(String password);

    /**
     * Get the value of password
     * @return password - String of password
     */
    public abstract String getPassword();

    /**
     * Set the value of email
     * @param email - String of email
     */
    public abstract void setEmail(String email);

    /**
     * Get the value of email
     * @return email - String of email
     */
    public abstract String getEmail();

    /**
     * Set the value of defaultPage
     * @param defaultPage - String of defaultPage
     */
    public abstract void setDefaultPage(String defaultPage);

    /**
     * Get the value of defaultPage
     * @return defaultPage - String of defaultPage
     */
    public abstract String getDefaultPage();

    /**
     * Set the value of pwdDate
     * @param pwdDate - Date of pwdDate
     */
    public abstract void setPwdDate(Date pwdDate);

    /**
     * Get the value of pwdDate
     * @return pwdDate - Date of pwdDate
     */
    public abstract Date getPwdDate();

    /**
     * Set the value of locked
     * @param locked - String of locked
     */
    public abstract void setLocked(String locked);

    /**
     * Get the value of locked
     * @return locked - String of locked
     */
    public abstract String getLocked();

    /**
     * Set the value of lginCntr
     * @param lginCntr - int of lginCntr
     */
    public abstract void setLginCntr(int lginCntr);

    /**
     * Get the value of lginCntr
     * @return lginCntr - int of lginCntr
     */
    public abstract int getLginCntr();

    /**
     * Set the value of empLockTm
     * @param empLockTm - Date of empLockTm
     */
    public abstract void setEmpLockTm(Date empLockTm);

    /**
     * Get the value of empLockTm
     * @return empLockTm - Date of empLockTm
     */
    public abstract Date getEmpLockTm();

    /**
     * Set the value of empMailSent
     * @param empMailSent - int of empMailSent
     */
    public abstract void setEmpMailSent(int empMailSent);

    /**
     * Get the value of empMailSent
     * @return empMailSent - int of empMailSent
     */
    public abstract int getEmpMailSent();

    /**
     * Set the value of extlCustFlg
     * @param extlCustFlg - int of extlCustFlg
     */
    public abstract void setExtlCustFlg(int extlCustFlg);

    /**
     * Get the value of extlCustFlg
     * @return extlCustFlg - int of extlCustFlg
     */
    public abstract int getExtlCustFlg();

    /**
     * Set the value of empRvoDt
     * @param empRvoDt - Date of empRvoDt
     */
    public abstract void setEmpRvoDt(Date empRvoDt);

    /**
     * Get the value of empRvoDt
     * @return empRvoDt - Date of empRvoDt
     */
    public abstract Date getEmpRvoDt();

    /**
     * Set the value of empStatusCd
     * @param empStatusCd - int of empStatusCd
     */
    public abstract void setEmpStatusCd(int empStatusCd);

    /**
     * Get the value of empStatusCd
     * @return empStatusCd - int of empStatusCd
     */
    public abstract int getEmpStatusCd();

    /**
     * Set the value of depositSlips
     * @param depositSlips - java.util.Set of depositSlips
     */
    public abstract void setDepositSlips(java.util.Set depositSlips);

    /**
     * Get the value of depositSlips
     * @return depositSlips - java.util.Set of depositSlips
     */
    public abstract java.util.Set getDepositSlips();

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
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.String ejbCreate(String employeeId, String employeeNm, String password, String email, String defaultPage, Date pwdDate, String locked, int lginCntr)
        throws CreateException {
        setEmployeeId(employeeId);
        setEmployeeNm(employeeNm);
        setPassword(password);
        setEmail(email);
        setDefaultPage(defaultPage);
        setPwdDate(pwdDate);
        setLocked(locked);
        setLginCntr(lginCntr);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String employeeId, String employeeNm, String password, String email, String defaultPage, Date pwdDate, String locked, int lginCntr)
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
