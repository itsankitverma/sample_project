/**
 * @(#)GlExchRateManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface GlExchRateManager extends EJBObject {

    /**
     * This method create new GlExchRate object
     * @param glExchRateVO a value object the GlExchRate bean
     */
    public void setGlExchRate(GlExchRateVO glExchRateVO)
        throws RemoteException, GlExchRateException;

    /**
     * This method gets a GlExchRate object
     * @param glExchRatePK - the GlExchRate bean primary key
     * @return glExchRateVO - a value object of the GlExchRate bean
     */
    public GlExchRateVO getGlExchRate(com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK glExchRatePK)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing GlExchRate object
     * @param glExchRatePK - the GlExchRate bean primary key
     */
    public void removeGlExchRate(com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK glExchRatePK)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing GlExchRate object
     * @param glExchRateVO - the value object of the GlExchRate bean
     */
    public void updateGlExchRate(GlExchRateVO glExchRateVO)
        throws RemoteException, GlExchRateException;

    /**
     * This method gets findAllGlExchRate objects
     * @return Collection - a collection of the GlExchRate objects
     */
    public Collection getAllGlExchRate()
        throws RemoteException;

}
