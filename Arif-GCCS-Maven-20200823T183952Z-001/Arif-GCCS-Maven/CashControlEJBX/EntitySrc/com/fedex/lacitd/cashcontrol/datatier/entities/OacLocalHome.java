/**
 * @(#)OacLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the oac table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface OacLocalHome extends EJBLocalHome {

    public OacLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllOacs()
        throws FinderException;

    public java.util.Collection findByPymtCurrCd(java.lang.String pymtCurrCd)
        throws FinderException;

    public java.util.Collection findByLocCd(java.lang.String locCd)
        throws FinderException;

    public java.util.Collection findByStatusCd(java.lang.Integer statusCd)
        throws FinderException;

    public java.util.Collection findByEodIdNbr(java.lang.Integer eodIdNbr)
        throws FinderException;

    public OacLocal create(Date obAncSvcDt, String locationCd, String pymtCurrCd, double cashPymtAmt, double otherPymtAmt, int otherPymtTypeCd, String otherDocNbr, String chngStatusEmpIdNbr, Date chngStatusDt, String closeEmpIdNbr, Date closeDt, String eodEmpIdNbr, Date eodDt, String chkinAgentComDesc, int statusCd, double exchRateAmt, String courEmpIdNbr, int cashDepSlipIdNbr, int otherDepSlipIdNbr, int eodIdNbr, String otherComDesc, String rcptNbr, String origRcptNbr, String rcptChngEmpNbr, String origEmpNbr, String rsgnEmpNbr, Integer dualObAncIdNbr)
        throws CreateException;

}
