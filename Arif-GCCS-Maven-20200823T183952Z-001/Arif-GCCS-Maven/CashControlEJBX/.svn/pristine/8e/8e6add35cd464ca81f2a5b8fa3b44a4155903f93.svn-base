/**
 * @(#)EodManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface EodManager extends EJBObject {

    /**
     * This method create new Eod object
     * @param eodVO a value object the Eod bean
     */
    public void setEod(EodVO eodVO)
        throws RemoteException, EodException;

    /**
     * This method gets a Eod object
     * @param eodId - the Eod bean primary key
     * @return eodVO - a value object of the Eod bean
     */
    public EodVO getEod(Integer eodId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing Eod object
     * @param eodId - the Eod bean primary key
     */
    public void removeEod(Integer eodId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing Eod object
     * @param eodVO - the value object of the Eod bean
     */
    public void updateEod(EodVO eodVO)
        throws RemoteException, EodException;

    /**
     * This method gets findAllEods objects
     * @return Collection - a collection of the Eod objects
     */
    public Collection getAllEods()
        throws RemoteException;

    /**
     * This method gets findByEodDt objects
     * @return Collection - a collection of the Eod objects
     */
    public Collection getEodByEodDt(Date eodDt)
        throws RemoteException;

    /**
     * This method gets findByLocationCd objects
     * @return Collection - a collection of the Eod objects
     */
    public Collection getEodByLocationCd(String locationCd)
        throws RemoteException;

    /**
     * This method gets findByLocationDt objects
     * @return Collection - a collection of the Eod objects
     */
    public Collection getEodByLocationDt(String locationCd, Date eodDt)
        throws RemoteException;

}
