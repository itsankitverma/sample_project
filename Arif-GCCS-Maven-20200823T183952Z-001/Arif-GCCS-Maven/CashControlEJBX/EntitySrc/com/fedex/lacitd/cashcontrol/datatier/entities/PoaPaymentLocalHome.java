/**
 * @(#)PoaPaymentLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the poa_payment table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface PoaPaymentLocalHome extends EJBLocalHome {

    public PoaPaymentLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllPoaPayments()
        throws FinderException;

    public java.util.Collection findByEodId(java.lang.Integer eodId)
        throws FinderException;

    public PoaPaymentLocal create(String accountNbr, String customerNm, Date paymentDt, String locationCd, String paymentCurrency, double exchRate, double paymentAmt, int paymentType, double coupPymtAmt, String otherDocNbr, String courierId, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String chkinAgentComment, int depositSlipId, String depositSlipNbr, String creditCardBatchId, String receivedEmpId, int eodId, int couponBatchId, Date pymtImpDt, String otherComment, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Date chequeDt, String chequeOrigin, String bankName)
        throws CreateException;

}
