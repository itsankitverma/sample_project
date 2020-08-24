/**
 * @(#)PrepSurchargesLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the prep_surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface PrepSurchargesLocalHome extends EJBLocalHome {

    public PrepSurchargesLocal findByPrimaryKey(com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK primaryKey)
        throws FinderException;

    public java.util.Collection findAllPrepSurcharges()
        throws FinderException;

    public java.util.Collection findByPrepaid(java.lang.Integer prepId)
        throws FinderException;

    public PrepSurchargesLocal create(Integer prepaidId, String surchargeCd, double appliedAmt)
        throws CreateException;

}
