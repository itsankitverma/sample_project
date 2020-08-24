/**
 * @(#)CountryLocalHome.java			Wed Aug 03 13:22:30 VET 2005
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
 * This bean map to the country table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface CountryLocalHome extends EJBLocalHome {

    public CountryLocal findByPrimaryKey(java.lang.String primaryKey)
        throws FinderException;

    public java.util.Collection findAllCountry()
        throws FinderException;

    public CountryLocal create(String countryCd, String countryNm, double errThldLocCurr, double errThldUsd, int quickApplyFlg, int scanUsdDecNbr, int scanLocalDecNbr, int gndUsedFlag, int oacUsedFlag, int collectlaterFlag, int codUsedFlag, int ftcUsedFlag)
        throws CreateException;

}
