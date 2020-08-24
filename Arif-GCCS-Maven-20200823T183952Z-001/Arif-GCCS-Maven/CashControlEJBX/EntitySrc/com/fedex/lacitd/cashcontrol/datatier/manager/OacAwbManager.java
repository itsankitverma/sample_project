/**
 * @(#)OacAwbManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface OacAwbManager extends EJBObject {

    /**
     * This method create new OacAwb object
     * @param oacAwbVO a value object the OacAwb bean
     */
    public void setOacAwb(OacAwbVO oacAwbVO)
        throws RemoteException, OacAwbException;

    /**
     * This method gets a OacAwb object
     * @param oacAwbPK - the OacAwb bean primary key
     * @return oacAwbVO - a value object of the OacAwb bean
     */
    public OacAwbVO getOacAwb(com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing OacAwb object
     * @param oacAwbPK - the OacAwb bean primary key
     */
    public void removeOacAwb(com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing OacAwb object
     * @param oacAwbVO - the value object of the OacAwb bean
     */
    public void updateOacAwb(OacAwbVO oacAwbVO)
        throws RemoteException, OacAwbException;

    /**
     * This method gets findAllOacAwbs objects
     * @return Collection - a collection of the OacAwb objects
     */
    public Collection getAllOacAwbs()
        throws RemoteException;

    /**
     * This method gets findOacAwbsByOacId objects
     * @return Collection - a collection of the OacAwb objects
     */
    public Collection getOacAwbOacAwbsByOacId(Integer oacId)
        throws RemoteException;

}
