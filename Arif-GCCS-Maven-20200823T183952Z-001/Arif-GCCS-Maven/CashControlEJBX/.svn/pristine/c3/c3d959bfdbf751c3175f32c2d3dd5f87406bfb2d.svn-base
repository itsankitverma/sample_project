/**
 * @(#)PoaDetailManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface PoaDetailManager extends EJBObject {

    /**
     * This method create new PoaDetail object
     * @param poaDetailVO a value object the PoaDetail bean
     */
    public void setPoaDetail(PoaDetailVO poaDetailVO)
        throws RemoteException, PoaDetailException;

    /**
     * This method gets a PoaDetail object
     * @param poaDetailId - the PoaDetail bean primary key
     * @return poaDetailVO - a value object of the PoaDetail bean
     */
    public PoaDetailVO getPoaDetail(Integer poaDetailId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing PoaDetail object
     * @param poaDetailId - the PoaDetail bean primary key
     */
    public void removePoaDetail(Integer poaDetailId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing PoaDetail object
     * @param poaDetailVO - the value object of the PoaDetail bean
     */
    public void updatePoaDetail(PoaDetailVO poaDetailVO)
        throws RemoteException, PoaDetailException;

    /**
     * This method gets findAllPoaDetails objects
     * @return Collection - a collection of the PoaDetail objects
     */
    public Collection getAllPoaDetails()
        throws RemoteException;

    /**
     * This method gets findPoaDetails objects
     * @return Collection - a collection of the PoaDetail objects
     */
    public Collection getPoaDetailPoaDetails(int poaPaymentsId)
        throws RemoteException;

}
