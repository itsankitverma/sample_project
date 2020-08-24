/**
 * @(#)CountryCurrencyLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the country_currency table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface CountryCurrencyLocalHome extends EJBLocalHome {

    public CountryCurrencyLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllCountryCurrency()
        throws FinderException;

    public CountryCurrencyLocal create(String currencyCd, String currencyNm, Date currencyValidSince, String currencySymbol, double exchRateMin, double exchRateMax, CountryLocal country)
        throws CreateException;

}
