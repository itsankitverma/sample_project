/**
 * @(#)OtherPaymentLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the other_payment table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;

import javax.ejb.*;

public interface OtherPaymentLocalHome extends EJBLocalHome {

    public OtherPaymentLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllOtherPayments()
        throws FinderException;

    public java.util.Collection findOpenByLocation(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByEodId(java.lang.Integer eodId)
        throws FinderException;

    public OtherPaymentLocal create(String description, double paymentAmt, String paymentDocNbr, int paymentType, Date paymentDt, String chkinAgentId, Date eodDt, String eodEmployeeId, int depositSlipId, int creditCardBatchId, String locationCd, String paymentCurrency, int eodId, Date pymtImpDt, String otherComment, int otherPaymentCtgId, String awbNbr,Date misc_date,String misc_nbr)
        throws CreateException;

}
