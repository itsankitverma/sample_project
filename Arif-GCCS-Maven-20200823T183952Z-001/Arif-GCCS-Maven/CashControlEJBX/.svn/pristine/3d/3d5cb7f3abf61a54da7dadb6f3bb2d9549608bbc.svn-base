/**
 * @(#)GroundLocalHome.java			Wed Nov 29 10:36:42 VET 2006
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
 * This bean map to the ground table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;

import javax.ejb.*;

public interface GroundLocalHome extends EJBLocalHome {

    public GroundLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllGrounds()
        throws FinderException;

    public java.util.Collection findByGrndShpIdNbr(java.lang.Integer grndShpIdNbr1)
        throws FinderException;

    public GroundLocal create(Date grndShpDt, String locationCd, String grndTrakNbr, String paymentCurrency, double cashPymtAmt, double otherPymtAmt, int otherPymtTypeCd, String otherDocNbr, double coupnPymtAmt, String chngStatusEmpIdNbr, Date chngStatusDt, String closeEmpIdNbr, Date closeDt, String eodEmpIdNbr, Date eodDt, String chkinAgentComDesc, int statusCd, double exchRateAmt, String courEmpIdNbr, int cashDepSlipIdNbr, int otherDepSlipIdNbr, int eodIdNbr, int coupnBatchIdNbr, String otherComDsc, String rcptNbr, String origRcptNbr, String rcptChngEmpNbr, String origEmpNbr, String rsgnEmpNbr, Integer dualGrndShipIdNbr, String custNm,Date misc_date,String misc_nbr)
        throws CreateException;

}
