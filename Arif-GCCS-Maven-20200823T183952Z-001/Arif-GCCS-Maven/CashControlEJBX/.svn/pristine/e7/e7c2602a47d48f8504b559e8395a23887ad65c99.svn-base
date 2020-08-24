/**
 * @(#)PaymentTypeLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the payment_type table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface PaymentTypeLocalHome extends EJBLocalHome {

    public PaymentTypeLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllPaymentTypes()
        throws FinderException;

    public java.util.Collection findAllActivePaymentTypes()
        throws FinderException;

    public java.util.Collection findByRodLocation(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByCodLocation(java.lang.String locationCd)
    throws FinderException;

    public java.util.Collection findByFtcLocation(java.lang.String locationCd)
    throws FinderException;
    
    public java.util.Collection findByPrpLocation(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByPoaLocation(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByOtherLocation(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByLocation(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByCode(java.lang.String paymentCd)
        throws FinderException;

    public java.util.Collection findByGndLocation(java.lang.String locationCd)
        throws FinderException;

    public PaymentTypeLocal create(String description, String shtDesc, String paymentCd, int rodCombo, int prpCombo, int poaCombo, int otherCombo, int canDeact, int paymentCtgId, int activePymt, int gndCombo, int codCombo, int ftcCombo)
        throws CreateException;

}
