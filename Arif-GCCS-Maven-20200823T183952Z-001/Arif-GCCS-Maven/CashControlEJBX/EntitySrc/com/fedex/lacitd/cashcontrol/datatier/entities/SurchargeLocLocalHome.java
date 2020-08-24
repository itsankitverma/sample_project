/**
 * @(#)SurchargeLocLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the surcharge_loc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface SurchargeLocLocalHome extends EJBLocalHome {

    public SurchargeLocLocal findByPrimaryKey(com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK primaryKey)
        throws FinderException;

    public java.util.Collection findAllSurchargeLocs()
        throws FinderException;

    public SurchargeLocLocal create(String surchargeCd, String locationCd, int applyRod, int applyPrepaid, int applyPoa, int applyOrder, int disabSurcharge)
        throws CreateException;

}
