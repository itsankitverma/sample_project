/**
 * @(#)PreStatusManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface PreStatusManagerLocal extends EJBLocalObject {

    /**
     * This method create new PreStatus object
     * @param preStatusVO a value object the PreStatus bean
     */
    public void setPreStatus(PreStatusVO preStatusVO)
        throws PreStatusException;

    /**
     * This method gets a PreStatus object
     * @param statusIdNbr - the PreStatus bean primary key
     * @return preStatusVO - a value object of the PreStatus bean
     */
    public PreStatusVO getPreStatus(Integer statusIdNbr)
        throws FinderException;

    /**
     * This method removes an existing PreStatus object
     * @param statusIdNbr - the PreStatus bean primary key
     */
    public void removePreStatus(Integer statusIdNbr)
        throws RemoveException;

    /**
     * This method updates an existing PreStatus object
     * @param preStatusVO - the value object of the PreStatus bean
     */
    public void updatePreStatus(PreStatusVO preStatusVO)
        throws PreStatusException;

    /**
     * This method gets findAllPreStatus objects
     * @return Collection - a collection of the PreStatus objects
     */
    public Collection getAllPreStatus();

}
