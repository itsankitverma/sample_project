/**
 * @(#)FTC_RecStatusManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface FTC_RecStatusManagerLocal extends EJBLocalObject {

    /**
     * This method create new FTC_RecStatus object
     * @param FTC_recStatusVO a value object the FTC_RecStatus bean
     */
    public void setFTC_RecStatus(FTC_RecStatusVO FTC_recStatusVO)
        throws FTC_RecStatusException;

    /**
     * This method gets a FTC_RecStatus object
     * @param statusId - the FTC_RecStatus bean primary key
     * @return FTC_recStatusVO - a value object of the FTC_RecStatus bean
     */
    public FTC_RecStatusVO getFTC_RecStatus(Integer statusId)
        throws FinderException;

    /**
     * This method removes an existing FTC_RecStatus object
     * @param statusId - the FTC_RecStatus bean primary key
     */
    public void removeFTC_RecStatus(Integer statusId)
        throws RemoveException;

    /**
     * This method updates an existing FTC_RecStatus object
     * @param FTC_recStatusVO - the value object of the FTC_RecStatus bean
     */
    public void updateFTC_RecStatus(FTC_RecStatusVO FTC_recStatusVO)
        throws FTC_RecStatusException;

    /**
     * This method gets findAllFTC_RecStatus objects
     * @return Collection - a collection of the FTC_RecStatus objects
     */
    public Collection getAllFTC_RecStatus();

}
