/**
 * @(#)CosmosScanManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface CosmosScanManagerLocal extends EJBLocalObject {

    /**
     * This method create new CosmosScan object
     * @param cosmosScanVO a value object the CosmosScan bean
     */
    public void setCosmosScan(CosmosScanVO cosmosScanVO)
        throws CosmosScanException;

    /**
     * This method gets a CosmosScan object
     * @param scanId - the CosmosScan bean primary key
     * @return cosmosScanVO - a value object of the CosmosScan bean
     */
    public CosmosScanVO getCosmosScan(Integer scanId)
        throws FinderException;

    /**
     * This method removes an existing CosmosScan object
     * @param scanId - the CosmosScan bean primary key
     */
    public void removeCosmosScan(Integer scanId)
        throws RemoveException;

    /**
     * This method updates an existing CosmosScan object
     * @param cosmosScanVO - the value object of the CosmosScan bean
     */
    public void updateCosmosScan(CosmosScanVO cosmosScanVO)
        throws CosmosScanException;

    /**
     * This method gets findAllCosmosScans objects
     * @return Collection - a collection of the CosmosScan objects
     */
    public Collection getAllCosmosScans();

}
