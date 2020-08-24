/**
 * @(#)EodLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the eod table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface EodLocalHome extends EJBLocalHome {

    public EodLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllEods()
        throws FinderException;

    public java.util.Collection findByEodDt(java.util.Date eodDt)
        throws FinderException;

    public java.util.Collection findByLocationCd(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByLocationDt(java.lang.String locationCd, java.util.Date eodDt)
        throws FinderException;

    public EodLocal create(String locationCd, Date eodDt, String employeeId)
        throws CreateException;

}
