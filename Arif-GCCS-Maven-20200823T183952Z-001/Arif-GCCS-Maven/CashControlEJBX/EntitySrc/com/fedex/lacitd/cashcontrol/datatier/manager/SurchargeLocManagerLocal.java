/**
 * @(#)SurchargeLocManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface SurchargeLocManagerLocal extends EJBLocalObject {

    /**
     * This method create new SurchargeLoc object
     * @param surchargeLocVO a value object the SurchargeLoc bean
     */
    public void setSurchargeLoc(SurchargeLocVO surchargeLocVO)
        throws SurchargeLocException;

    /**
     * This method gets a SurchargeLoc object
     * @param surchargeLocPK - the SurchargeLoc bean primary key
     * @return surchargeLocVO - a value object of the SurchargeLoc bean
     */
    public SurchargeLocVO getSurchargeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK)
        throws FinderException;

    /**
     * This method removes an existing SurchargeLoc object
     * @param surchargeLocPK - the SurchargeLoc bean primary key
     */
    public void removeSurchargeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK)
        throws RemoveException;

    /**
     * This method updates an existing SurchargeLoc object
     * @param surchargeLocVO - the value object of the SurchargeLoc bean
     */
    public void updateSurchargeLoc(SurchargeLocVO surchargeLocVO)
        throws SurchargeLocException;

    /**
     * This method gets findAllSurchargeLocs objects
     * @return Collection - a collection of the SurchargeLoc objects
     */
    public Collection getAllSurchargeLocs();

}
