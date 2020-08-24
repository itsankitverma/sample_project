/**
 * @(#)OtherPymtCtgManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface OtherPymtCtgManager extends EJBObject {

    /**
     * This method create new OtherPymtCtg object
     * @param otherPymtCtgVO a value object the OtherPymtCtg bean
     */
    public void setOtherPymtCtg(OtherPymtCtgVO otherPymtCtgVO)
        throws RemoteException, OtherPymtCtgException;

    /**
     * This method gets a OtherPymtCtg object
     * @param otherPaymentCtgId - the OtherPymtCtg bean primary key
     * @return otherPymtCtgVO - a value object of the OtherPymtCtg bean
     */
    public OtherPymtCtgVO getOtherPymtCtg(Integer otherPaymentCtgId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing OtherPymtCtg object
     * @param otherPaymentCtgId - the OtherPymtCtg bean primary key
     */
    public void removeOtherPymtCtg(Integer otherPaymentCtgId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing OtherPymtCtg object
     * @param otherPymtCtgVO - the value object of the OtherPymtCtg bean
     */
    public void updateOtherPymtCtg(OtherPymtCtgVO otherPymtCtgVO)
        throws RemoteException, OtherPymtCtgException;

    /**
     * This method gets findAllPaymentCtgs objects
     * @return Collection - a collection of the OtherPymtCtg objects
     */
    public Collection getAllPaymentCtgs()
        throws RemoteException;

}
