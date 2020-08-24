/**
 * @(#)ChkinAgtCommentManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface ChkinAgtCommentManager extends EJBObject {

    /**
     * This method create new ChkinAgtComment object
     * @param chkinAgtCommentVO a value object the ChkinAgtComment bean
     */
    public void setChkinAgtComment(ChkinAgtCommentVO chkinAgtCommentVO)
        throws RemoteException, ChkinAgtCommentException;

    /**
     * This method gets a ChkinAgtComment object
     * @param commentId - the ChkinAgtComment bean primary key
     * @return chkinAgtCommentVO - a value object of the ChkinAgtComment bean
     */
    public ChkinAgtCommentVO getChkinAgtComment(Integer commentId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing ChkinAgtComment object
     * @param commentId - the ChkinAgtComment bean primary key
     */
    public void removeChkinAgtComment(Integer commentId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing ChkinAgtComment object
     * @param chkinAgtCommentVO - the value object of the ChkinAgtComment bean
     */
    public void updateChkinAgtComment(ChkinAgtCommentVO chkinAgtCommentVO)
        throws RemoteException, ChkinAgtCommentException;

    /**
     * This method gets findAllChkinAgtComments objects
     * @return Collection - a collection of the ChkinAgtComment objects
     */
    public Collection getAllChkinAgtComments()
        throws RemoteException;

}
