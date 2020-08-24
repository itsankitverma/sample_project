/**
 * @(#)ExchangeRateManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface ExchangeRateManager extends EJBObject {

    /**
     * This method create new ExchangeRate object
     * @param exchangeRateVO a value object the ExchangeRate bean
     */
    public void setExchangeRate(ExchangeRateVO exchangeRateVO)
        throws RemoteException, ExchangeRateException;

    /**
     * This method gets a ExchangeRate object
     * @param exchRateId - the ExchangeRate bean primary key
     * @return exchangeRateVO - a value object of the ExchangeRate bean
     */
    public ExchangeRateVO getExchangeRate(Integer exchRateId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing ExchangeRate object
     * @param exchRateId - the ExchangeRate bean primary key
     */
    public void removeExchangeRate(Integer exchRateId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing ExchangeRate object
     * @param exchangeRateVO - the value object of the ExchangeRate bean
     */
    public void updateExchangeRate(ExchangeRateVO exchangeRateVO)
        throws RemoteException, ExchangeRateException;

    /**
     * This method gets findAllExchangeRates objects
     * @return Collection - a collection of the ExchangeRate objects
     */
    public Collection getAllExchangeRates()
        throws RemoteException;

}
