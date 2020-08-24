/**
 * @(#)CountryLocal.java			Wed Aug 03 13:22:30 VET 2005
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
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface CountryLocal extends EJBLocalObject {

    /**
     * Set the value of countryCd
     * @param countryCd - String of countryCd
     */
    public void setCountryCd(String countryCd);

    /**
     * Get the value of countryCd
     * @return countryCd - String of countryCd
     */
    public String getCountryCd();

    /**
     * Set the value of countryNm
     * @param countryNm - String of countryNm
     */
    public void setCountryNm(String countryNm);

    /**
     * Get the value of countryNm
     * @return countryNm - String of countryNm
     */
    public String getCountryNm();

    /**
     * Set the value of errThldLocCurr
     * @param errThldLocCurr - double of errThldLocCurr
     */
    public void setErrThldLocCurr(double errThldLocCurr);

    /**
     * Get the value of errThldLocCurr
     * @return errThldLocCurr - double of errThldLocCurr
     */
    public double getErrThldLocCurr();

    /**
     * Set the value of errThldUsd
     * @param errThldUsd - double of errThldUsd
     */
    public void setErrThldUsd(double errThldUsd);

    /**
     * Get the value of errThldUsd
     * @return errThldUsd - double of errThldUsd
     */
    public double getErrThldUsd();

    /**
     * Set the value of quickApplyFlg
     * @param quickApplyFlg - int of quickApplyFlg
     */
    public void setQuickApplyFlg(int quickApplyFlg);

    /**
     * Get the value of quickApplyFlg
     * @return quickApplyFlg - int of quickApplyFlg
     */
    public int getQuickApplyFlg();

    /**
     * Set the value of scanUsdDecNbr
     * @param scanUsdDecNbr - int of scanUsdDecNbr
     */
    public void setScanUsdDecNbr(int scanUsdDecNbr);

    /**
     * Get the value of scanUsdDecNbr
     * @return scanUsdDecNbr - int of scanUsdDecNbr
     */
    public int getScanUsdDecNbr();

    /**
     * Set the value of scanLocalDecNbr
     * @param scanLocalDecNbr - int of scanLocalDecNbr
     */
    public void setScanLocalDecNbr(int scanLocalDecNbr);

    /**
     * Get the value of scanLocalDecNbr
     * @return scanLocalDecNbr - int of scanLocalDecNbr
     */
    public int getScanLocalDecNbr();

    /**
     * Set the value of gndUsedFlag
     * @param gndUsedFlag - int of gndUsedFlag
     */
    public void setGndUsedFlag(int gndUsedFlag);

    /**
     * Get the value of gndUsedFlag
     * @return gndUsedFlag - int of gndUsedFlag
     */
    public int getGndUsedFlag();

    /**
     * Set the value of codUsedFlag
     * @param codUsedFlag - int of codUsedFlag
     */
    public void setCodUsedFlag(int codUsedFlag);

    /**
     * Get the value of codUsedFlag
     * @return codUsedFlag - int of codUsedFlag
     */
    public int getCodUsedFlag();
        
    /**
     * Set the value of ftcUsedFlag
     * @param codUsedFlag - int of ftcUsedFlag
     */
    public void setFtcUsedFlag(int ftcUsedFlag);

    /**
     * Get the value of ftcUsedFlag
     * @return ftcUsedFlag - int of ftcUsedFlag
     */
    public int getFtcUsedFlag();
    

    /**
     * Set the value of oacUsedFlag
     * @param oacUsedFlag - int of oacUsedFlag
     */
    public void setOacUsedFlag(int oacUsedFlag);

    /**
     * Get the value of oacUsedFlag
     * @return oacUsedFlag - int of oacUsedFlag
     */
    public int getOacUsedFlag();
    
    /**
     * Set the value of collectlaterFlag
     * @param collectlaterFlag - int of collectlaterFlag
     */
    public void setCollectlaterFlag(int collectlaterFlag);

    /**
     * Get the value of collectlaterFlag
     * @return collectlaterFlag - int of collectlaterFlag
     */
    public int getCollectlaterFlag();
    
    /**
     * Set the value of banks
     * @param banks - java.util.Set of banks
     */
    public void setBanks(java.util.Set banks);

    /**
     * Get the value of banks
     * @return banks - java.util.Set of banks
     */
    public java.util.Set getBanks();

    /**
     * Set the value of countryCurrency
     * @param countryCurrency - java.util.Set of countryCurrency
     */
    public void setCountryCurrency(java.util.Set countryCurrency);

    /**
     * Get the value of countryCurrency
     * @return countryCurrency - java.util.Set of countryCurrency
     */
    public java.util.Set getCountryCurrency();

    /**
     * Set the value of locations
     * @param locations - java.util.Set of locations
     */
    public void setLocations(java.util.Set locations);

    /**
     * Get the value of locations
     * @return locations - java.util.Set of locations
     */
    public java.util.Set getLocations();

}
