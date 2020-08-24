/**
 * @(#)RecStatusLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the rec_status table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface RecStatusLocalHome extends EJBLocalHome {

    public RecStatusLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllRecStatus()
        throws FinderException;

    public RecStatusLocal create(Integer statusId, String description, int rodPgFlg)
        throws CreateException;

}
