/**
 * @(#)PrepaidDscrManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface PrepaidDscrManager extends EJBObject {

    /**
     * This method create new PrepaidDscr object
     * @param prepaidDscrVO a value object the PrepaidDscr bean
     */
    public void setPrepaidDscr(PrepaidDscrVO prepaidDscrVO)
        throws RemoteException, PrepaidDscrException;

    /**
     * This method gets a PrepaidDscr object
     * @param prepaidDscrId - the PrepaidDscr bean primary key
     * @return prepaidDscrVO - a value object of the PrepaidDscr bean
     */
    public PrepaidDscrVO getPrepaidDscr(Integer prepaidDscrId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing PrepaidDscr object
     * @param prepaidDscrId - the PrepaidDscr bean primary key
     */
    public void removePrepaidDscr(Integer prepaidDscrId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing PrepaidDscr object
     * @param prepaidDscrVO - the value object of the PrepaidDscr bean
     */
    public void updatePrepaidDscr(PrepaidDscrVO prepaidDscrVO)
        throws RemoteException, PrepaidDscrException;

    /**
     * This method gets findAllPrepaidDscrs objects
     * @return Collection - a collection of the PrepaidDscr objects
     */
    public Collection getAllPrepaidDscrs()
        throws RemoteException;

}
