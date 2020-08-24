/**
 * @(#)EmployeeLocal.java			Tue Aug 02 15:38:49 VET 2005
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

public interface EmployeeLocal extends EJBLocalObject {

    /**
     * Set the value of employeeId
     * @param employeeId - String of employeeId
     */
    public void setEmployeeId(String employeeId);

    /**
     * Get the value of employeeId
     * @return employeeId - String of employeeId
     */
    public String getEmployeeId();

    /**
     * Set the value of employeeNm
     * @param employeeNm - String of employeeNm
     */
    public void setEmployeeNm(String employeeNm);

    /**
     * Get the value of employeeNm
     * @return employeeNm - String of employeeNm
     */
    public String getEmployeeNm();

    /**
     * Set the value of password
     * @param password - String of password
     */
    public void setPassword(String password);

    /**
     * Get the value of password
     * @return password - String of password
     */
    public String getPassword();

    /**
     * Set the value of email
     * @param email - String of email
     */
    public void setEmail(String email);

    /**
     * Get the value of email
     * @return email - String of email
     */
    public String getEmail();

    /**
     * Set the value of defaultPage
     * @param defaultPage - String of defaultPage
     */
    public void setDefaultPage(String defaultPage);

    /**
     * Get the value of defaultPage
     * @return defaultPage - String of defaultPage
     */
    public String getDefaultPage();

    /**
     * Set the value of pwdDate
     * @param pwdDate - Date of pwdDate
     */
    public void setPwdDate(Date pwdDate);

    /**
     * Get the value of pwdDate
     * @return pwdDate - Date of pwdDate
     */
    public Date getPwdDate();

    /**
     * Set the value of locked
     * @param locked - String of locked
     */
    public void setLocked(String locked);

    /**
     * Get the value of locked
     * @return locked - String of locked
     */
    public String getLocked();

    /**
     * Set the value of lginCntr
     * @param lginCntr - int of lginCntr
     */
    public void setLginCntr(int lginCntr);

    /**
     * Get the value of lginCntr
     * @return lginCntr - int of lginCntr
     */
    public int getLginCntr();

    /**
     * Set the value of empLockTm
     * @param empLockTm - Date of empLockTm
     */
    public void setEmpLockTm(Date empLockTm);

    /**
     * Get the value of empLockTm
     * @return empLockTm - Date of empLockTm
     */
    public Date getEmpLockTm();

    /**
     * Set the value of empMailSent
     * @param empMailSent - int of empMailSent
     */
    public void setEmpMailSent(int empMailSent);

    /**
     * Get the value of empMailSent
     * @return empMailSent - int of empMailSent
     */
    public int getEmpMailSent();

    /**
     * Set the value of extlCustFlg
     * @param extlCustFlg - int of extlCustFlg
     */
    public void setExtlCustFlg(int extlCustFlg);

    /**
     * Get the value of extlCustFlg
     * @return extlCustFlg - int of extlCustFlg
     */
    public int getExtlCustFlg();

    /**
     * Set the value of empRvoDt
     * @param empRvoDt - Date of empRvoDt
     */
    public void setEmpRvoDt(Date empRvoDt);

    /**
     * Get the value of empRvoDt
     * @return empRvoDt - Date of empRvoDt
     */
    public Date getEmpRvoDt();

    /**
     * Set the value of empStatusCd
     * @param empStatusCd - int of empStatusCd
     */
    public void setEmpStatusCd(int empStatusCd);

    /**
     * Get the value of empStatusCd
     * @return empStatusCd - int of empStatusCd
     */
    public int getEmpStatusCd();

    /**
     * Set the value of depositSlips
     * @param depositSlips - java.util.Set of depositSlips
     */
    public void setDepositSlips(java.util.Set depositSlips);

    /**
     * Get the value of depositSlips
     * @return depositSlips - java.util.Set of depositSlips
     */
    public java.util.Set getDepositSlips();

    /**
     * Adds a new Location
     * @param location - Location location
     */
    public void addLocation(LocationLocal location);

    /**
     * Removes a Location
     * @param location - Location location
     */
    public void removeLocation(LocationLocal location);

    /**
     * Set the value of locations
     * @param locations - java.util.Set of locations
     */
    public void setLocations(java.util.Set locations);

    /**
     * Get the value of locations
     * @return locations - java.util.Set of locations
     */
    public java.util.Set getLocations();

}
