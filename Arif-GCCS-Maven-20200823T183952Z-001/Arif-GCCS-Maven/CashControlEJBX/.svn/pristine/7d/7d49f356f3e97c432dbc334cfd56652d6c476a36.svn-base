/**
 * @(#)PymtImptErrorDtlManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface PymtImptErrorDtlManagerLocal extends EJBLocalObject {

    /**
     * This method create new PymtImptErrorDtl object
     * @param pymtImptErrorDtlVO a value object the PymtImptErrorDtl bean
     */
    public void setPymtImptErrorDtl(PymtImptErrorDtlVO pymtImptErrorDtlVO)
        throws PymtImptErrorDtlException;

    /**
     * This method gets a PymtImptErrorDtl object
     * @param imptErrorDtlId - the PymtImptErrorDtl bean primary key
     * @return pymtImptErrorDtlVO - a value object of the PymtImptErrorDtl bean
     */
    public PymtImptErrorDtlVO getPymtImptErrorDtl(Integer imptErrorDtlId)
        throws FinderException;

    /**
     * This method removes an existing PymtImptErrorDtl object
     * @param imptErrorDtlId - the PymtImptErrorDtl bean primary key
     */
    public void removePymtImptErrorDtl(Integer imptErrorDtlId)
        throws RemoveException;

    /**
     * This method updates an existing PymtImptErrorDtl object
     * @param pymtImptErrorDtlVO - the value object of the PymtImptErrorDtl bean
     */
    public void updatePymtImptErrorDtl(PymtImptErrorDtlVO pymtImptErrorDtlVO)
        throws PymtImptErrorDtlException;

    /**
     * This method gets findAllPymtImptErrorDtls objects
     * @return Collection - a collection of the PymtImptErrorDtl objects
     */
    public Collection getAllPymtImptErrorDtls();

}
