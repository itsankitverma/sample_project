/**
 * @(#)PrepaidManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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

public interface PrepaidManagerLocal extends EJBLocalObject {

    /**
     * This method create new Prepaid object
     * @param prepaidVO a value object the Prepaid bean
     */
    public void setPrepaid(PrepaidVO prepaidVO)
        throws PrepaidException;

    /**
     * This method gets a Prepaid object
     * @param prepaidId - the Prepaid bean primary key
     * @return prepaidVO - a value object of the Prepaid bean
     */
    public PrepaidVO getPrepaid(Integer prepaidId)
        throws FinderException;

    /**
     * This method removes an existing Prepaid object
     * @param prepaidId - the Prepaid bean primary key
     */
    public void removePrepaid(Integer prepaidId)
        throws RemoveException;

    /**
     * This method updates an existing Prepaid object
     * @param prepaidVO - the value object of the Prepaid bean
     */
    public void updatePrepaid(PrepaidVO prepaidVO)
        throws PrepaidException;

    /**
     * This method gets findAllPrepaids objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getAllPrepaids();

    /**
     * This method gets findPrepaidByAwbNbr objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPrepaidByAwbNbr(String awbNbr);

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidByEodId(Integer eodId);

    /**
     * This method gets findPRPWithoutScan objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPRPWithoutScan(String courierId, String locationCd, Integer statusId);

    /**
     * This method gets findPRPQueryCosmos objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPRPQueryCosmos(String locationCd, Integer statusId);

}
