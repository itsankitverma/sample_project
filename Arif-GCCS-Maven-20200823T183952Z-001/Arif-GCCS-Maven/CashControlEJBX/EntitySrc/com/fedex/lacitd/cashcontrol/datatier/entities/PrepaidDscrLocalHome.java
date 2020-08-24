/**
 * @(#)PrepaidDscrLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the prepaid_dscr table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface PrepaidDscrLocalHome extends EJBLocalHome {

    public PrepaidDscrLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllPrepaidDscrs()
        throws FinderException;

    public PrepaidDscrLocal create(Date processDt, String locationCd, String awbNbr, String tinUniqId, String courierId, String paymentCurrency, double freightAmtInVisa, int discrepancyFound, double discrepancyAmt, double exchRate, int discrepancyRsn, Date shipDate, double pux16Amount, double couponAmount, String comments, String managerEmpId, int statusId)
        throws CreateException;

}
