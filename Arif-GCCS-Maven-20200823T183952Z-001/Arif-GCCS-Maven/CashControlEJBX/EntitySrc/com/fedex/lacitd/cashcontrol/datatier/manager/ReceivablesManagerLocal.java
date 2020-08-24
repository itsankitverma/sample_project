/**
 * @(#)ReceivablesManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface ReceivablesManagerLocal extends EJBLocalObject {

    /**
     * This method create new Receivables object
     * @param receivablesVO a value object the Receivables bean
     */
    public void setReceivables(ReceivablesVO receivablesVO)
        throws ReceivablesException;

    /**
     * This method gets a Receivables object
     * @param recId - the Receivables bean primary key
     * @return receivablesVO - a value object of the Receivables bean
     */
    public ReceivablesVO getReceivables(Integer recId)
        throws FinderException;

    /**
     * This method removes an existing Receivables object
     * @param recId - the Receivables bean primary key
     */
    public void removeReceivables(Integer recId)
        throws RemoveException;

    /**
     * This method updates an existing Receivables object
     * @param receivablesVO - the value object of the Receivables bean
     */
    public void updateReceivables(ReceivablesVO receivablesVO)
        throws ReceivablesException;

    /**
     * This method gets findAllReceivables objects
     * @return Collection - a collection of the Receivables objects
     */
    public Collection getAllReceivables();

    /**
     * This method gets findReceivablesByAwbNbr objects
     * @return Collection - a collection of the Receivables objects
     */
    public Collection getReceivablesReceivablesByAwbNbr(String awbNbr);

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the Receivables objects
     */
    public Collection getReceivablesByEodId(Integer eodId);

}
