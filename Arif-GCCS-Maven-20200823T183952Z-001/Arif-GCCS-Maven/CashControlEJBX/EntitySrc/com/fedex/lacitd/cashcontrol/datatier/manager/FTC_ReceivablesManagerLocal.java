/**
 * @(#)FTC_ReceivablesManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface FTC_ReceivablesManagerLocal extends EJBLocalObject {

    /**
     * This method create new FTC_Receivables object
     * @param FTC_receivablesVO a value object the FTC_Receivables bean
     */
    public void setFTC_Receivables(FTC_ReceivablesVO FTC_receivablesVO)
        throws FTC_ReceivablesException;

    /**
     * This method gets a FTC_Receivables object
     * @param recId - the FTC_Receivables bean primary key
     * @return FTC_receivablesVO - a value object of the FTC_Receivables bean
     */
    public FTC_ReceivablesVO getFTC_Receivables(Integer recId)
        throws FinderException;

    /**
     * This method removes an existing FTC_Receivables object
     * @param recId - the FTC_Receivables bean primary key
     */
    public void removeFTC_Receivables(Integer recId)
        throws RemoveException;

    /**
     * This method updates an existing FTC_Receivables object
     * @param FTC_receivablesVO - the value object of the FTC_Receivables bean
     */
    public void updateFTC_Receivables(FTC_ReceivablesVO FTC_receivablesVO)
        throws FTC_ReceivablesException;

    /**
     * This method gets findAllFTC_Receivables objects
     * @return Collection - a collection of the FTC_Receivables objects
     */
    public Collection getAllFTC_Receivables();

    /**
     * This method gets findFTC_ReceivablesByAwbNbr objects
     * @return Collection - a collection of the FTC_Receivables objects
     */
    public Collection getFTC_ReceivablesReceivablesByAwbNbr(String awbNbr);

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the FTC_Receivables objects
     */
    public Collection getFTC_ReceivablesByEodId(Integer eodId);

}
