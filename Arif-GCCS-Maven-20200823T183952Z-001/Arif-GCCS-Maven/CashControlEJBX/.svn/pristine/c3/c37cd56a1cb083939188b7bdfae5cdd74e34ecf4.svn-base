/**
 * @(#)COD_ReceivablesLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the receivables table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;

import javax.ejb.*;

public interface COD_ReceivablesLocalHome extends EJBLocalHome {

    public COD_ReceivablesLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllCOD_Receivables()
        throws FinderException;

    public java.util.Collection findCOD_ReceivablesByAwbNbr(java.lang.String awbNbr)
        throws FinderException;

    public java.util.Collection findByEodId(java.lang.Integer eodId)
        throws FinderException;

    public COD_ReceivablesLocal create(String recNbr, String customerNm, Date recDt, String invCurrency, double codAmt, double ancChargeAmt, double recAmt, String locationCd, String awbNbr, String tinUniqId, double exchRateClnUsed, String employeeId, String paymentCurrency, double cashPaymentAmt, double otherPaymentAmt, int otherPaymentType, String otherDocNbr, double dex11CashPayment, double dex11FreightAmt, double dex11OtherPaymentAmt, String dex11OtherDocNbr, String dex11ScanSeqNbr, String chngStatusEmployeeId, Date chngStatusDt, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String lastScanType, Date lastScanDate, String chkinAgentComment, int trackingStatus, int statusId, int cashDepositSlipId, String cashDepositSlipNbr, int otherDepositSlipId, String otherDepositSlipNbr, String creditCardBatchId, int eodId, Date codXmlImpDt, Date pymtImpDt, String otherComment, double recvPrepyAmt, String origCustNm, String custChngEmpId, double origRecAmt, String amtChngEmpId, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Integer dualRecIdNbr, String dupAwbFlg, String billAccount,Date misc_date,String misc_nbr)
        throws CreateException;

}
