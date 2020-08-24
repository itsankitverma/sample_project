/**
 * @(#)RecExpSrchgLocalHome.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the rec_exp_srchg table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface RecExpSrchgLocalHome extends EJBLocalHome {

    public RecExpSrchgLocal findByPrimaryKey(com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK primaryKey)
        throws FinderException;

    public java.util.Collection findAllRecExpSrchgs()
        throws FinderException;

    public java.util.Collection findByReceivable(java.lang.Integer recId)
        throws FinderException;

    public RecExpSrchgLocal create(Integer recId, String surchargeCd, double appliedAmt)
        throws CreateException;

}
