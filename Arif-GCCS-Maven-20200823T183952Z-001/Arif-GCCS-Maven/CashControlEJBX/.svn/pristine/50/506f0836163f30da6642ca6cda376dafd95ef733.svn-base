/**
 * @(#)CountryManagerLocal.java			Wed Aug 03 13:22:34 VET 2005
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

public interface CountryManagerLocal extends EJBLocalObject {

    /**
     * This method create new Country object
     * @param countryVO a value object the Country bean
     */
    public void setCountry(CountryVO countryVO)
        throws CountryException;

    /**
     * This method gets a Country object
     * @param countryCd - the Country bean primary key
     * @return countryVO - a value object of the Country bean
     */
    public CountryVO getCountry(String countryCd)
        throws FinderException;

    /**
     * This method gets Bank objects from the Country object
     * @return Collection - a collection of the Bank objects
     */
    public Collection getBanks(String countryCd)
        throws CountryException;

    /**
     * This method gets CountryCurrency objects from the Country object
     * @return Collection - a collection of the CountryCurrency objects
     */
    public Collection getCountryCurrency(String countryCd)
        throws CountryException;

    /**
     * This method gets Location objects from the Country object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(String countryCd)
        throws CountryException;

    /**
     * This method removes an existing Country object
     * @param countryCd - the Country bean primary key
     */
    public void removeCountry(String countryCd)
        throws RemoveException;

    /**
     * This method updates an existing Country object
     * @param countryVO - the value object of the Country bean
     */
    public void updateCountry(CountryVO countryVO)
        throws CountryException;

    /**
     * This method gets findAllCountry objects
     * @return Collection - a collection of the Country objects
     */
    public Collection getAllCountry();

}
