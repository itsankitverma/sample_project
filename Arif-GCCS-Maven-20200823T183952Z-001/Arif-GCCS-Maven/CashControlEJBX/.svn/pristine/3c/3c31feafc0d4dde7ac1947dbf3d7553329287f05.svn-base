/**
 * @(#)PrepaidLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the prepaid table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;

import javax.ejb.*;

public interface PrepaidLocalHome extends EJBLocalHome {

    public PrepaidLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllPrepaids()
        throws FinderException;

    public java.util.Collection findPrepaidByAwbNbr(java.lang.String awbNbr)
        throws FinderException;

    public java.util.Collection findByEodId(java.lang.Integer eodId)
        throws FinderException;

    public java.util.Collection findPRPWithoutScan(java.lang.String courierId, java.lang.String locationCd, java.lang.Integer statusId)
        throws FinderException;

    public java.util.Collection findPRPQueryCosmos(java.lang.String locationCd, java.lang.Integer statusId)
        throws FinderException;

    public PrepaidLocal create(String customerNm, Date awbDt, String locationCd, String awbNbr, String tinUniqId, String paymentCurrency, double cashPaymentAmt, double otherPaymentAmt, int otherPaymentType, String otherDocNbr, double coupPymtAmt, double pux16CashPayment, double pux16FreightAmt, double pux16OtherPaymentAmt, String pux16OtherDocNbr, double pux16CoupPymtAmt, String pux16ScanSeqNbr, String chngStatusEmployeeId, Date chngStatusDt, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String lastScanType, Date lastScanDate, String chkinAgentComment, int statusId, int cashDepositSlipId, String cashDepositSlipNbr, int otherDepositSlipId, String otherDepositSlipNbr, double freightAmtInVisa, Date visaMnfstDt, String visaMnfstEmpId, double exchRate, String courierId, int product, int numberPkgs, double weight, String creditCardBatchId, int eodId, int couponBatchId, Date pymtImpDt, String otherComment, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Integer dualPrepaidIdNbr, String billAccount,Date misc_date,String misc_nbr)
        throws CreateException;

}
