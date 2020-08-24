/**
 * @(#)CountryCurrencyManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface CountryCurrencyManagerLocal extends EJBLocalObject {

    /**
     * This method create new CountryCurrency object
     * @param countryCurrencyVO a value object the CountryCurrency bean
     */
    public void setCountryCurrency(CountryCurrencyVO countryCurrencyVO)
        throws CountryCurrencyException;

    /**
     * This method gets a CountryCurrency object
     * @param cntryCurrencyId - the CountryCurrency bean primary key
     * @return countryCurrencyVO - a value object of the CountryCurrency bean
     */
    public CountryCurrencyVO getCountryCurrency(Integer cntryCurrencyId)
        throws FinderException;

    /**
     * This method gets ExchangeRate objects from the CountryCurrency object
     * @return Collection - a collection of the ExchangeRate objects
     */
    public Collection getExchangeRates(Integer cntryCurrencyId)
        throws CountryCurrencyException;

    /**
     * This method removes an existing CountryCurrency object
     * @param cntryCurrencyId - the CountryCurrency bean primary key
     */
    public void removeCountryCurrency(Integer cntryCurrencyId)
        throws RemoveException;

    /**
     * This method updates an existing CountryCurrency object
     * @param countryCurrencyVO - the value object of the CountryCurrency bean
     */
    public void updateCountryCurrency(CountryCurrencyVO countryCurrencyVO)
        throws CountryCurrencyException;

    /**
     * This method gets findAllCountryCurrency objects
     * @return Collection - a collection of the CountryCurrency objects
     */
    public Collection getAllCountryCurrency();

}
