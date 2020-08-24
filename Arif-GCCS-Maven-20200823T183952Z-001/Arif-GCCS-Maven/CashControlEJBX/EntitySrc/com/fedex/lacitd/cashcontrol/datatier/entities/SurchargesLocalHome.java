/**
 * @(#)SurchargesLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface SurchargesLocalHome extends EJBLocalHome {

    public SurchargesLocal findByPrimaryKey(java.lang.String primaryKey)
        throws FinderException;

    public java.util.Collection findAllSurcharges()
        throws FinderException;

    public java.util.Collection findByRod(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByPrepaid(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByPoa(java.lang.String locationCd)
        throws FinderException;

    public SurchargesLocal create(String surchargeCd, String shtDesc)
        throws CreateException;

}
