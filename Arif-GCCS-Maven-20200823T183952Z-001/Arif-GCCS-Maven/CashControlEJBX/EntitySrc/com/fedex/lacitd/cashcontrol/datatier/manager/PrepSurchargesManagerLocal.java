/**
 * @(#)PrepSurchargesManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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

public interface PrepSurchargesManagerLocal extends EJBLocalObject {

    /**
     * This method create new PrepSurcharges object
     * @param prepSurchargesVO a value object the PrepSurcharges bean
     */
    public void setPrepSurcharges(PrepSurchargesVO prepSurchargesVO)
        throws PrepSurchargesException;

    /**
     * This method gets a PrepSurcharges object
     * @param prepSurchargesPK - the PrepSurcharges bean primary key
     * @return prepSurchargesVO - a value object of the PrepSurcharges bean
     */
    public PrepSurchargesVO getPrepSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK)
        throws FinderException;

    /**
     * This method removes an existing PrepSurcharges object
     * @param prepSurchargesPK - the PrepSurcharges bean primary key
     */
    public void removePrepSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK)
        throws RemoveException;

    /**
     * This method updates an existing PrepSurcharges object
     * @param prepSurchargesVO - the value object of the PrepSurcharges bean
     */
    public void updatePrepSurcharges(PrepSurchargesVO prepSurchargesVO)
        throws PrepSurchargesException;

    /**
     * This method gets findAllPrepSurcharges objects
     * @return Collection - a collection of the PrepSurcharges objects
     */
    public Collection getAllPrepSurcharges();

    /**
     * This method gets findByPrepaid objects
     * @return Collection - a collection of the PrepSurcharges objects
     */
    public Collection getPrepSurchargesByPrepaid(Integer prepId);

}
