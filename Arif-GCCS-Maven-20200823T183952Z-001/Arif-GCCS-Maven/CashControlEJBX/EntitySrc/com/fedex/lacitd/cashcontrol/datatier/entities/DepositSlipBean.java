/**
 * @(#)DepositSlipBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the deposit_slip table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class DepositSlipBean implements EntityBean {

    private EntityContext _ctx;
    public DepositSlipBean() {
    }
    /**
     * Set the value of depositSlipCd
     * @param depositSlipCd - Integer of depositSlipCd
     */
    public abstract void setDepositSlipCd(Integer depositSlipCd);

    /**
     * Get the value of depositSlipCd
     * @return depositSlipCd - Integer of depositSlipCd
     */
    public abstract Integer getDepositSlipCd();

    /**
     * Set the value of depositSlipDt
     * @param depositSlipDt - Date of depositSlipDt
     */
    public abstract void setDepositSlipDt(Date depositSlipDt);

    /**
     * Get the value of depositSlipDt
     * @return depositSlipDt - Date of depositSlipDt
     */
    public abstract Date getDepositSlipDt();

    /**
     * Set the value of depositSlipNbr
     * @param depositSlipNbr - String of depositSlipNbr
     */
    public abstract void setDepositSlipNbr(String depositSlipNbr);

    /**
     * Get the value of depositSlipNbr
     * @return depositSlipNbr - String of depositSlipNbr
     */
    public abstract String getDepositSlipNbr();

    /**
     * Set the value of depositSlipTotAmt
     * @param depositSlipTotAmt - double of depositSlipTotAmt
     */
    public abstract void setDepositSlipTotAmt(double depositSlipTotAmt);

    /**
     * Get the value of depositSlipTotAmt
     * @return depositSlipTotAmt - double of depositSlipTotAmt
     */
    public abstract double getDepositSlipTotAmt();

    /**
     * Set the value of bankAcc
     * @param bankAcc - BankAccLocal of bankAcc
     */
    public abstract void setBankAcc(BankAccLocal bankAcc);

    /**
     * Get the value of bankAcc
     * @return bankAcc - BankAccLocal of bankAcc
     */
    public abstract BankAccLocal getBankAcc();

    /**
     * Set the value of employee
     * @param employee - EmployeeLocal of employee
     */
    public abstract void setEmployee(EmployeeLocal employee);

    /**
     * Get the value of employee
     * @return employee - EmployeeLocal of employee
     */
    public abstract EmployeeLocal getEmployee();

    /**
     * Set the value of currencyCd
     * @param currencyCd - String of currencyCd
     */
    public abstract void setCurrencyCd(String currencyCd);

    /**
     * Get the value of currencyCd
     * @return currencyCd - String of currencyCd
     */
    public abstract String getCurrencyCd();

    /**
     * Set the value of srcType
     * @param srcType - String of srcType
     */
    public abstract void setSrcType(String srcType);

    /**
     * Get the value of srcType
     * @return srcType - String of srcType
     */
    public abstract String getSrcType();

    /**
     * Set the value of pymtType
     * @param pymtType - int of pymtType
     */
    public abstract void setPymtType(int pymtType);

    /**
     * Get the value of pymtType
     * @return pymtType - int of pymtType
     */
    public abstract int getPymtType();

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
     * Set the value of statusId
     * @param statusId - int of statusId
     */
    public abstract void setStatusId(int statusId);

    /**
     * Get the value of statusId
     * @return statusId - int of statusId
     */
    public abstract int getStatusId();

    /**
     * Set the value of comments
     * @param comments - String of comments
     */
    public abstract void setComments(String comments);

    /**
     * Get the value of comments
     * @return comments - String of comments
     */
    public abstract String getComments();

    /**
     * Set the value of actualAmt
     * @param actualAmt - double of actualAmt
     */
    public abstract void setActualAmt(double actualAmt);

    /**
     * Get the value of actualAmt
     * @return actualAmt - double of actualAmt
     */
    public abstract double getActualAmt();

    /**
     * Set the value of bankAmt
     * @param bankAmt - double of bankAmt
     */
    public abstract void setBankAmt(double bankAmt);

    /**
     * Get the value of bankAmt
     * @return bankAmt - double of bankAmt
     */
    public abstract double getBankAmt();

    /**
     * Set the value of fedexDepositId
     * @param fedexDepositId - String of fedexDepositId
     */
    public abstract void setFedexDepositId(String fedexDepositId);

    /**
     * Get the value of fedexDepositId
     * @return fedexDepositId - String of fedexDepositId
     */
    public abstract String getFedexDepositId();

    /**
     * Set the value of closeDt
     * @param closeDt - Date of closeDt
     */
    public abstract void setCloseDt(Date closeDt);

    /**
     * Get the value of closeDt
     * @return closeDt - Date of closeDt
     */
    public abstract Date getCloseDt();

    /**
     * Set the value of depoDt
     * @param depoDt - Date of depoDt
     */
    public abstract void setDepoDt(Date depoDt);

    /**
     * Get the value of depoDt
     * @return depoDt - Date of depoDt
     */
    public abstract Date getDepoDt();

    /**
     * Set the value of bankDepoDt
     * @param bankDepoDt - Date of bankDepoDt
     */
    public abstract void setBankDepoDt(Date bankDepoDt);

    /**
     * Get the value of bankDepoDt
     * @return bankDepoDt - Date of bankDepoDt
     */
    public abstract Date getBankDepoDt();

    /**
     * Set the value of eodId
     * @param eodId - int of eodId
     */
    public abstract void setEodId(int eodId);

    /**
     * Get the value of eodId
     * @return eodId - int of eodId
     */
    public abstract int getEodId();

    /**
     * Set the value of templId
     * @param templId - int of templId
     */
    public abstract void setTemplId(int templId);

    /**
     * Get the value of templId
     * @return templId - int of templId
     */
    public abstract int getTemplId();

    /**
     * Set the value of templCd
     * @param templCd - String of templCd
     */
    public abstract void setTemplCd(String templCd);

    /**
     * Get the value of templCd
     * @return templCd - String of templCd
     */
    public abstract String getTemplCd();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(Date depositSlipDt, String depositSlipNbr, double depositSlipTotAmt, BankAccLocal bankAcc, EmployeeLocal employee, String currencyCd, String srcType, int pymtType, String locationCd, int statusId, String comments, double actualAmt, double bankAmt, String fedexDepositId, Date closeDt, Date depoDt, Date bankDepoDt, int eodId, int templId, String templCd)
        throws CreateException {
        setDepositSlipDt(depositSlipDt);
        setDepositSlipNbr(depositSlipNbr);
        setDepositSlipTotAmt(depositSlipTotAmt);
        setCurrencyCd(currencyCd);
        setSrcType(srcType);
        setPymtType(pymtType);
        setLocationCd(locationCd);
        setStatusId(statusId);
        setComments(comments);
        setActualAmt(actualAmt);
        setBankAmt(bankAmt);
        setFedexDepositId(fedexDepositId);
        setCloseDt(closeDt);
        setDepoDt(depoDt);
        setBankDepoDt(bankDepoDt);
        setEodId(eodId);
        setTemplId(templId);
        setTemplCd(templCd);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(Date depositSlipDt, String depositSlipNbr, double depositSlipTotAmt, BankAccLocal bankAcc, EmployeeLocal employee, String currencyCd, String srcType, int pymtType, String locationCd, int statusId, String comments, double actualAmt, double bankAmt, String fedexDepositId, Date closeDt, Date depoDt, Date bankDepoDt, int eodId, int templId, String templCd)
        throws CreateException {
        setBankAcc(bankAcc);
        setEmployee(employee);
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
