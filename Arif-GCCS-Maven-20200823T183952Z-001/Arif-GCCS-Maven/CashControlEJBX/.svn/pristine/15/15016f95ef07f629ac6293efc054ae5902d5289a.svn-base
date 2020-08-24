/**
 * @(#)PymtTypeLocManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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

public interface PymtTypeLocManagerLocal extends EJBLocalObject {

    /**
     * This method create new PymtTypeLoc object
     * @param pymtTypeLocVO a value object the PymtTypeLoc bean
     */
    public void setPymtTypeLoc(PymtTypeLocVO pymtTypeLocVO)
        throws PymtTypeLocException;

    /**
     * This method gets a PymtTypeLoc object
     * @param pymtTypeLocPK - the PymtTypeLoc bean primary key
     * @return pymtTypeLocVO - a value object of the PymtTypeLoc bean
     */
    public PymtTypeLocVO getPymtTypeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK)
        throws FinderException;

    /**
     * This method removes an existing PymtTypeLoc object
     * @param pymtTypeLocPK - the PymtTypeLoc bean primary key
     */
    public void removePymtTypeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK)
        throws RemoveException;

    /**
     * This method updates an existing PymtTypeLoc object
     * @param pymtTypeLocVO - the value object of the PymtTypeLoc bean
     */
    public void updatePymtTypeLoc(PymtTypeLocVO pymtTypeLocVO)
        throws PymtTypeLocException;

    /**
     * This method gets findAllPymtTypeLocs objects
     * @return Collection - a collection of the PymtTypeLoc objects
     */
    public Collection getAllPymtTypeLocs();

    /**
     * This method gets findLocationsByPayment objects
     * @return Collection - a collection of the PymtTypeLoc objects
     */
    public Collection getPymtTypeLocLocationsByPayment(Integer ptId);

}
