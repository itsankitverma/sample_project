/**
 * @(#)COD_ReceivablesManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface COD_ReceivablesManagerLocal extends EJBLocalObject {

    /**
     * This method create new COD_Receivables object
     * @param COD_receivablesVO a value object the COD_Receivables bean
     */
    public void setCOD_Receivables(COD_ReceivablesVO COD_receivablesVO)
        throws COD_ReceivablesException;

    /**
     * This method gets a COD_Receivables object
     * @param recId - the COD_Receivables bean primary key
     * @return COD_receivablesVO - a value object of the COD_Receivables bean
     */
    public COD_ReceivablesVO getCOD_Receivables(Integer recId)
        throws FinderException;

    /**
     * This method removes an existing COD_Receivables object
     * @param recId - the COD_Receivables bean primary key
     */
    public void removeCOD_Receivables(Integer recId)
        throws RemoveException;

    /**
     * This method updates an existing COD_Receivables object
     * @param COD_receivablesVO - the value object of the COD_Receivables bean
     */
    public void updateCOD_Receivables(COD_ReceivablesVO COD_receivablesVO)
        throws COD_ReceivablesException;

    /**
     * This method gets findAllCOD_Receivables objects
     * @return Collection - a collection of the COD_Receivables objects
     */
    public Collection getAllCOD_Receivables();

    /**
     * This method gets findCOD_ReceivablesByAwbNbr objects
     * @return Collection - a collection of the COD_Receivables objects
     */
    public Collection getCOD_ReceivablesReceivablesByAwbNbr(String awbNbr);

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the COD_Receivables objects
     */
    public Collection getCOD_ReceivablesByEodId(Integer eodId);

}
