/**
 * @(#)OacManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface OacManager extends EJBObject {

    /**
     * This method create new Oac object
     * @param oacVO a value object the Oac bean
     */
    public void setOac(OacVO oacVO)
        throws RemoteException, OacException;

    /**
     * This method gets a Oac object
     * @param obAncSvcIdNbr - the Oac bean primary key
     * @return oacVO - a value object of the Oac bean
     */
    public OacVO getOac(Integer obAncSvcIdNbr)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing Oac object
     * @param obAncSvcIdNbr - the Oac bean primary key
     */
    public void removeOac(Integer obAncSvcIdNbr)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing Oac object
     * @param oacVO - the value object of the Oac bean
     */
    public void updateOac(OacVO oacVO)
        throws RemoteException, OacException;

    /**
     * This method gets findAllOacs objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getAllOacs()
        throws RemoteException;

    /**
     * This method gets findByPymtCurrCd objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getOacByPymtCurrCd(String pymtCurrCd)
        throws RemoteException;

    /**
     * This method gets findByLocCd objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getOacByLocCd(String locCd)
        throws RemoteException;

    /**
     * This method gets findByStatusCd objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getOacByStatusCd(Integer statusCd)
        throws RemoteException;

    /**
     * This method gets findByEodIdNbr objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getOacByEodIdNbr(Integer eodIdNbr)
        throws RemoteException;

}
