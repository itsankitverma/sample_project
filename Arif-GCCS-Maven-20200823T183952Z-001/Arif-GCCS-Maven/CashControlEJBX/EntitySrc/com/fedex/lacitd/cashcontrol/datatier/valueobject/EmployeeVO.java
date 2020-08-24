/**
 * @(#)EmployeeVO.java			Tue Aug 02 15:38:50 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class EmployeeVO implements java.io.Serializable {

    private String _employeeId;
    private String _employeeNm;
    private String _password;
    private String _email;
    private String _defaultPage;
    private Date _pwdDate;
    private String _locked;
    private int _lginCntr;
    private Date _empLockTm;
    private int _empMailSent;
    private int _extlCustFlg;
    private Date _empRvoDt;
    private int _empStatusCd;
    public EmployeeVO() {
    }
    public EmployeeVO(String employeeId, String employeeNm, String password, String email, String defaultPage, Date pwdDate, String locked, int lginCntr, Date empLockTm, int empMailSent, int extlCustFlg, Date empRvoDt, int empStatusCd) {
        _employeeId = employeeId;
        _employeeNm = employeeNm;
        _password = password;
        _email = email;
        _defaultPage = defaultPage;
        _pwdDate = pwdDate;
        _locked = locked;
        _lginCntr = lginCntr;
        _empLockTm = empLockTm;
        _empMailSent = empMailSent;
        _extlCustFlg = extlCustFlg;
        _empRvoDt = empRvoDt;
        _empStatusCd = empStatusCd;
    }
    /**
     * Set the value of employeeId
     */
    public void setEmployeeId(String employeeId) {
        _employeeId = employeeId;
    }

    /**
     * Get the value of employeeId
     */
    public String getEmployeeId() {
        return _employeeId;
    }

    /**
     * Set the value of employeeNm
     */
    public void setEmployeeNm(String employeeNm) {
        _employeeNm = employeeNm;
    }

    /**
     * Get the value of employeeNm
     */
    public String getEmployeeNm() {
        return _employeeNm;
    }

    /**
     * Set the value of password
     */
    public void setPassword(String password) {
        _password = password;
    }

    /**
     * Get the value of password
     */
    public String getPassword() {
        return _password;
    }

    /**
     * Set the value of email
     */
    public void setEmail(String email) {
        _email = email;
    }

    /**
     * Get the value of email
     */
    public String getEmail() {
        return _email;
    }

    /**
     * Set the value of defaultPage
     */
    public void setDefaultPage(String defaultPage) {
        _defaultPage = defaultPage;
    }

    /**
     * Get the value of defaultPage
     */
    public String getDefaultPage() {
        return _defaultPage;
    }

    /**
     * Set the value of pwdDate
     */
    public void setPwdDate(Date pwdDate) {
        _pwdDate = pwdDate;
    }

    /**
     * Get the value of pwdDate
     */
    public Date getPwdDate() {
        return _pwdDate;
    }

    /**
     * Set the value of locked
     */
    public void setLocked(String locked) {
        _locked = locked;
    }

    /**
     * Get the value of locked
     */
    public String getLocked() {
        return _locked;
    }

    /**
     * Set the value of lginCntr
     */
    public void setLginCntr(int lginCntr) {
        _lginCntr = lginCntr;
    }

    /**
     * Get the value of lginCntr
     */
    public int getLginCntr() {
        return _lginCntr;
    }

    /**
     * Set the value of empLockTm
     */
    public void setEmpLockTm(Date empLockTm) {
        _empLockTm = empLockTm;
    }

    /**
     * Get the value of empLockTm
     */
    public Date getEmpLockTm() {
        return _empLockTm;
    }

    /**
     * Set the value of empMailSent
     */
    public void setEmpMailSent(int empMailSent) {
        _empMailSent = empMailSent;
    }

    /**
     * Get the value of empMailSent
     */
    public int getEmpMailSent() {
        return _empMailSent;
    }

    /**
     * Set the value of extlCustFlg
     */
    public void setExtlCustFlg(int extlCustFlg) {
        _extlCustFlg = extlCustFlg;
    }

    /**
     * Get the value of extlCustFlg
     */
    public int getExtlCustFlg() {
        return _extlCustFlg;
    }

    /**
     * Set the value of empRvoDt
     */
    public void setEmpRvoDt(Date empRvoDt) {
        _empRvoDt = empRvoDt;
    }

    /**
     * Get the value of empRvoDt
     */
    public Date getEmpRvoDt() {
        return _empRvoDt;
    }

    /**
     * Set the value of empStatusCd
     */
    public void setEmpStatusCd(int empStatusCd) {
        _empStatusCd = empStatusCd;
    }

    /**
     * Get the value of empStatusCd
     */
    public int getEmpStatusCd() {
        return _empStatusCd;
    }

    /**
     * Get the value of the primary key
     */
    public String getEmployeePK() {
        return _employeeId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EmployeeId: " + _employeeId);
        stringBuffer.append("EmployeeNm: " + _employeeNm);
        stringBuffer.append("Password: " + _password);
        stringBuffer.append("Email: " + _email);
        stringBuffer.append("DefaultPage: " + _defaultPage);
        stringBuffer.append("PwdDate: " + _pwdDate);
        stringBuffer.append("Locked: " + _locked);
        stringBuffer.append("LginCntr: " + _lginCntr);
        stringBuffer.append("EmpLockTm: " + _empLockTm);
        stringBuffer.append("EmpMailSent: " + _empMailSent);
        stringBuffer.append("ExtlCustFlg: " + _extlCustFlg);
        stringBuffer.append("EmpRvoDt: " + _empRvoDt);
        stringBuffer.append("EmpStatusCd: " + _empStatusCd);
        return stringBuffer.toString();
    }

}
