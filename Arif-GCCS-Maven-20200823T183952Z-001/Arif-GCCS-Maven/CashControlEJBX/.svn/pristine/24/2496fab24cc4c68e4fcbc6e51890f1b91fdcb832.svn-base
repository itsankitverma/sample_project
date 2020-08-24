/**
 * @(#)BankAccLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the bank_acc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface BankAccLocalHome extends EJBLocalHome {

    public BankAccLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllBankAccs()
        throws FinderException;

    public java.util.Collection findByBankId(java.lang.Integer bankId)
        throws FinderException;

//    public BankAccLocal create(String accountNbr, String bankBranchId, String currencyType, BankLocal bank)
//        throws CreateException;
    public BankAccLocal create(String accountNbr, String bankBranchId, String currencyType, BankLocal bank, String originationNbr)
    throws CreateException;

}
