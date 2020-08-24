/**
 * @(#)CreditCardPaymentLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the credit_card_payment table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface CreditCardPaymentLocalHome extends EJBLocalHome {

    public CreditCardPaymentLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllCreditCardPayments()
        throws FinderException;

    public java.util.Collection findByEodId(java.lang.Integer eodId)
        throws FinderException;

    public CreditCardPaymentLocal create(double totalAmt, double totalReimbursed, String paymentType, String paymentDocNbr, String comments, int statusId, String locationCd, String employeeId, Date batchDt, String currencyCd, int depositSlipId, int eodId)
        throws CreateException;

}
