/**
 * @(#)PoaDetailLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the poa_detail table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface PoaDetailLocalHome extends EJBLocalHome {

    public PoaDetailLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllPoaDetails()
        throws FinderException;

    public java.util.Collection findPoaDetails(int poaPaymentsId)
        throws FinderException;

    public PoaDetailLocal create(int poaPaymentsId, String invoiceNbr, double amount, double couponAmt, String invCurrency, double exchRate)
        throws CreateException;

}
