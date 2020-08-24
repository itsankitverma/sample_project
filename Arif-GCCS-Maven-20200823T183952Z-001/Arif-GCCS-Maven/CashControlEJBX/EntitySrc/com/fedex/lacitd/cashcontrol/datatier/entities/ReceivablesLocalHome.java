/**
 * @(#)ReceivablesLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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

public interface ReceivablesLocalHome extends EJBLocalHome {

    public ReceivablesLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllReceivables()
        throws FinderException;

    public java.util.Collection findReceivablesByAwbNbr(java.lang.String awbNbr)
        throws FinderException;

    public java.util.Collection findByEodId(java.lang.Integer eodId)
        throws FinderException;

    public ReceivablesLocal create(String recNbr, String customerNm, Date recDt, String invCurrency, double rodAmt, double ancChargeAmt, double recAmt, String locationCd, String awbNbr, String tinUniqId, double exchRateClnUsed, String employeeId, String paymentCurrency, double cashPaymentAmt, double otherPaymentAmt, int otherPaymentType, String otherDocNbr, double dex16CashPayment, double dex16FreightAmt, double dex16OtherPaymentAmt, String dex16OtherDocNbr, String dex16ScanSeqNbr, String chngStatusEmployeeId, Date chngStatusDt, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String lastScanType, Date lastScanDate, String chkinAgentComment, int trackingStatus, int statusId, int cashDepositSlipId, String cashDepositSlipNbr, int otherDepositSlipId, String otherDepositSlipNbr, String creditCardBatchId, int eodId, Date rodXmlImpDt, Date pymtImpDt, String otherComment, double recvPrepyAmt, String origCustNm, String custChngEmpId, double origRecAmt, String amtChngEmpId, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Integer dualRecIdNbr, String dupAwbFlg, String billAccount,Date misc_date,String misc_nbr)
        throws CreateException;

}
