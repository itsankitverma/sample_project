/**
 * @(#)DepositSlipLocal.java			Tue Aug 02 15:38:49 VET 2005
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

public interface DepositSlipLocal extends EJBLocalObject {

    /**
     * Set the value of depositSlipCd
     * @param depositSlipCd - Integer of depositSlipCd
     */
    public void setDepositSlipCd(Integer depositSlipCd);

    /**
     * Get the value of depositSlipCd
     * @return depositSlipCd - Integer of depositSlipCd
     */
    public Integer getDepositSlipCd();

    /**
     * Set the value of depositSlipDt
     * @param depositSlipDt - Date of depositSlipDt
     */
    public void setDepositSlipDt(Date depositSlipDt);

    /**
     * Get the value of depositSlipDt
     * @return depositSlipDt - Date of depositSlipDt
     */
    public Date getDepositSlipDt();

    /**
     * Set the value of depositSlipNbr
     * @param depositSlipNbr - String of depositSlipNbr
     */
    public void setDepositSlipNbr(String depositSlipNbr);

    /**
     * Get the value of depositSlipNbr
     * @return depositSlipNbr - String of depositSlipNbr
     */
    public String getDepositSlipNbr();

    /**
     * Set the value of depositSlipTotAmt
     * @param depositSlipTotAmt - double of depositSlipTotAmt
     */
    public void setDepositSlipTotAmt(double depositSlipTotAmt);

    /**
     * Get the value of depositSlipTotAmt
     * @return depositSlipTotAmt - double of depositSlipTotAmt
     */
    public double getDepositSlipTotAmt();

    /**
     * Set the value of bankAcc
     * @param bankAcc - BankAccLocal of bankAcc
     */
    public void setBankAcc(BankAccLocal bankAcc);

    /**
     * Get the value of bankAcc
     * @return bankAcc - BankAccLocal of bankAcc
     */
    public BankAccLocal getBankAcc();

    /**
     * Set the value of employee
     * @param employee - EmployeeLocal of employee
     */
    public void setEmployee(EmployeeLocal employee);

    /**
     * Get the value of employee
     * @return employee - EmployeeLocal of employee
     */
    public EmployeeLocal getEmployee();

    /**
     * Set the value of currencyCd
     * @param currencyCd - String of currencyCd
     */
    public void setCurrencyCd(String currencyCd);

    /**
     * Get the value of currencyCd
     * @return currencyCd - String of currencyCd
     */
    public String getCurrencyCd();

    /**
     * Set the value of srcType
     * @param srcType - String of srcType
     */
    public void setSrcType(String srcType);

    /**
     * Get the value of srcType
     * @return srcType - String of srcType
     */
    public String getSrcType();

    /**
     * Set the value of pymtType
     * @param pymtType - int of pymtType
     */
    public void setPymtType(int pymtType);

    /**
     * Get the value of pymtType
     * @return pymtType - int of pymtType
     */
    public int getPymtType();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public String getLocationCd();

    /**
     * Set the value of statusId
     * @param statusId - int of statusId
     */
    public void setStatusId(int statusId);

    /**
     * Get the value of statusId
     * @return statusId - int of statusId
     */
    public int getStatusId();

    /**
     * Set the value of comments
     * @param comments - String of comments
     */
    public void setComments(String comments);

    /**
     * Get the value of comments
     * @return comments - String of comments
     */
    public String getComments();

    /**
     * Set the value of actualAmt
     * @param actualAmt - double of actualAmt
     */
    public void setActualAmt(double actualAmt);

    /**
     * Get the value of actualAmt
     * @return actualAmt - double of actualAmt
     */
    public double getActualAmt();

    /**
     * Set the value of bankAmt
     * @param bankAmt - double of bankAmt
     */
    public void setBankAmt(double bankAmt);

    /**
     * Get the value of bankAmt
     * @return bankAmt - double of bankAmt
     */
    public double getBankAmt();

    /**
     * Set the value of fedexDepositId
     * @param fedexDepositId - String of fedexDepositId
     */
    public void setFedexDepositId(String fedexDepositId);

    /**
     * Get the value of fedexDepositId
     * @return fedexDepositId - String of fedexDepositId
     */
    public String getFedexDepositId();

    /**
     * Set the value of closeDt
     * @param closeDt - Date of closeDt
     */
    public void setCloseDt(Date closeDt);

    /**
     * Get the value of closeDt
     * @return closeDt - Date of closeDt
     */
    public Date getCloseDt();

    /**
     * Set the value of depoDt
     * @param depoDt - Date of depoDt
     */
    public void setDepoDt(Date depoDt);

    /**
     * Get the value of depoDt
     * @return depoDt - Date of depoDt
     */
    public Date getDepoDt();

    /**
     * Set the value of bankDepoDt
     * @param bankDepoDt - Date of bankDepoDt
     */
    public void setBankDepoDt(Date bankDepoDt);

    /**
     * Get the value of bankDepoDt
     * @return bankDepoDt - Date of bankDepoDt
     */
    public Date getBankDepoDt();

    /**
     * Set the value of eodId
     * @param eodId - int of eodId
     */
    public void setEodId(int eodId);

    /**
     * Get the value of eodId
     * @return eodId - int of eodId
     */
    public int getEodId();

    /**
     * Set the value of templId
     * @param templId - int of templId
     */
    public void setTemplId(int templId);

    /**
     * Get the value of templId
     * @return templId - int of templId
     */
    public int getTemplId();

    /**
     * Set the value of templCd
     * @param templCd - String of templCd
     */
    public void setTemplCd(String templCd);

    /**
     * Get the value of templCd
     * @return templCd - String of templCd
     */
    public String getTemplCd();

}
