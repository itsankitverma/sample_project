/**
 * @(#)RecExpSrchgManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.manager;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public interface RecExpSrchgManagerLocal extends EJBLocalObject {

    /**
     * This method create new RecExpSrchg object
     * @param recExpSrchgVO a value object the RecExpSrchg bean
     */
    public void setRecExpSrchg(RecExpSrchgVO recExpSrchgVO)
        throws RecExpSrchgException;

    /**
     * This method gets a RecExpSrchg object
     * @param recExpSrchgPK - the RecExpSrchg bean primary key
     * @return recExpSrchgVO - a value object of the RecExpSrchg bean
     */
    public RecExpSrchgVO getRecExpSrchg(com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK)
        throws FinderException;

    /**
     * This method removes an existing RecExpSrchg object
     * @param recExpSrchgPK - the RecExpSrchg bean primary key
     */
    public void removeRecExpSrchg(com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK)
        throws RemoveException;

    /**
     * This method updates an existing RecExpSrchg object
     * @param recExpSrchgVO - the value object of the RecExpSrchg bean
     */
    public void updateRecExpSrchg(RecExpSrchgVO recExpSrchgVO)
        throws RecExpSrchgException;

    /**
     * This method gets findAllRecExpSrchgs objects
     * @return Collection - a collection of the RecExpSrchg objects
     */
    public Collection getAllRecExpSrchgs();

    /**
     * This method gets findByReceivable objects
     * @return Collection - a collection of the RecExpSrchg objects
     */
    public Collection getRecExpSrchgByReceivable(Integer recId);

}
