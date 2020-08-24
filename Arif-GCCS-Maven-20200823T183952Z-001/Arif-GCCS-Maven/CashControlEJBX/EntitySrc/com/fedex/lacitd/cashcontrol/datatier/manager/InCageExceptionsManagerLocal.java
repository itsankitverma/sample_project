/**
 * @(#)InCageExceptionsManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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

public interface InCageExceptionsManagerLocal extends EJBLocalObject {

    /**
     * This method create new InCageExceptions object
     * @param inCageExceptionsVO a value object the InCageExceptions bean
     */
    public void setInCageExceptions(InCageExceptionsVO inCageExceptionsVO)
        throws InCageExceptionsException;

    /**
     * This method gets a InCageExceptions object
     * @param inCageExcpId - the InCageExceptions bean primary key
     * @return inCageExceptionsVO - a value object of the InCageExceptions bean
     */
    public InCageExceptionsVO getInCageExceptions(Integer inCageExcpId)
        throws FinderException;

    /**
     * This method removes an existing InCageExceptions object
     * @param inCageExcpId - the InCageExceptions bean primary key
     */
    public void removeInCageExceptions(Integer inCageExcpId)
        throws RemoveException;

    /**
     * This method updates an existing InCageExceptions object
     * @param inCageExceptionsVO - the value object of the InCageExceptions bean
     */
    public void updateInCageExceptions(InCageExceptionsVO inCageExceptionsVO)
        throws InCageExceptionsException;

    /**
     * This method gets findAllInCageExceptions objects
     * @return Collection - a collection of the InCageExceptions objects
     */
    public Collection getAllInCageExceptions();

}
