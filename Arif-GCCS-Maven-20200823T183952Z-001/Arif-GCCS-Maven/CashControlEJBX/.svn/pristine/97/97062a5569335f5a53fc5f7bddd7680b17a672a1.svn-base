/**
 * @(#)InCageExceptionsLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the in_cage_exceptions table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface InCageExceptionsLocalHome extends EJBLocalHome {

    public InCageExceptionsLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllInCageExceptions()
        throws FinderException;

    public InCageExceptionsLocal create(String locationCd, Date reportDt, String awbNbr, String lastDexEmpId, String lastStat44EmpId, String description)
        throws CreateException;

}
