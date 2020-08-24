/**
 * @(#)DepositSlipLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
import java.util.*;
import javax.ejb.*;

public interface DepositSlipLocalHome extends EJBLocalHome {

    public DepositSlipLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllDepositSlips()
        throws FinderException;

    public java.util.Collection findByBankAccountCd(java.lang.Integer bankAccountCd)
        throws FinderException;

    public java.util.Collection findByEmployeeId(java.lang.String employeeId)
        throws FinderException;

    public java.util.Collection findByEodId(java.lang.Integer eodId)
        throws FinderException;

    public DepositSlipLocal create(Date depositSlipDt, String depositSlipNbr, double depositSlipTotAmt, BankAccLocal bankAcc, EmployeeLocal employee, String currencyCd, String srcType, int pymtType, String locationCd, int statusId, String comments, double actualAmt, double bankAmt, String fedexDepositId, Date closeDt, Date depoDt, Date bankDepoDt, int eodId, int templId, String templCd)
        throws CreateException;

}
