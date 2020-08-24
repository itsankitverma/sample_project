/**
 * @(#)LocationLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the location table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface LocationLocalHome extends EJBLocalHome {

    public LocationLocal findByPrimaryKey(java.lang.String primaryKey)
        throws FinderException;

    public java.util.Collection findAllLocations()
        throws FinderException;

    public java.util.Collection findByCountryCd(java.lang.String countryCd)
        throws FinderException;

    public java.util.Collection findAllParentLocations(java.lang.String employeeId)
        throws FinderException;

    public java.util.Collection findAllPossibleParentLocationsByCountry(java.lang.String locCd, java.lang.String countryCd)
        throws FinderException;

    public LocationLocal create(String locationCd, String locationNm, String locationType, String locationTmZn, int locationGmtOffset, CountryLocal country, int splitDepBySrc, int splitDepByCurr, int splitDepByPymtType, int localDefaultAcc, int usdDefaultAcc, int manCreditCard, String creditCardPymtType, int allowPrpDelay, int activeLocation, int depoCurrencyDef, int prScanRfshFlg, int prScanRfshIntvlNbr, String parentLocationCd)
        throws CreateException;

}
