/**
 * @(#)GroundManager.java			Wed Nov 29 10:36:42 VET 2006
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

public interface GroundManager extends EJBObject {

    /**
     * This method create new Ground object
     * @param groundVO a value object the Ground bean
     */
    public void setGround(GroundVO groundVO)
        throws RemoteException, GroundException;

    /**
     * This method gets a Ground object
     * @param grndShpIdNbr - the Ground bean primary key
     * @return groundVO - a value object of the Ground bean
     */
    public GroundVO getGround(Integer grndShpIdNbr)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing Ground object
     * @param grndShpIdNbr - the Ground bean primary key
     */
    public void removeGround(Integer grndShpIdNbr)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing Ground object
     * @param groundVO - the value object of the Ground bean
     */
    public void updateGround(GroundVO groundVO)
        throws RemoteException, GroundException;

    /**
     * This method gets findAllGrounds objects
     * @return Collection - a collection of the Ground objects
     */
    public Collection getAllGrounds()
        throws RemoteException;

    /**
     * This method gets findByGrndShpIdNbr objects
     * @return Collection - a collection of the Ground objects
     */
    public Collection getGroundByGrndShpIdNbr(Integer grndShpIdNbr1)
        throws RemoteException;

}
