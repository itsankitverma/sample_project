/**
 * @(#)CountryBean.java			Wed Aug 03 13:22:30 VET 2005
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

public abstract class CountryBean implements EntityBean {

    private EntityContext _ctx;
    public CountryBean() {
    }
    /**
     * Set the value of countryCd
     * @param countryCd - String of countryCd
     */
    public abstract void setCountryCd(String countryCd);

    /**
     * Get the value of countryCd
     * @return countryCd - String of countryCd
     */
    public abstract String getCountryCd();

    /**
     * Set the value of countryNm
     * @param countryNm - String of countryNm
     */
    public abstract void setCountryNm(String countryNm);

    /**
     * Get the value of countryNm
     * @return countryNm - String of countryNm
     */
    public abstract String getCountryNm();

    /**
     * Set the value of errThldLocCurr
     * @param errThldLocCurr - double of errThldLocCurr
     */
    public abstract void setErrThldLocCurr(double errThldLocCurr);

    /**
     * Get the value of errThldLocCurr
     * @return errThldLocCurr - double of errThldLocCurr
     */
    public abstract double getErrThldLocCurr();

    /**
     * Set the value of errThldUsd
     * @param errThldUsd - double of errThldUsd
     */
    public abstract void setErrThldUsd(double errThldUsd);

    /**
     * Get the value of errThldUsd
     * @return errThldUsd - double of errThldUsd
     */
    public abstract double getErrThldUsd();

    /**
     * Set the value of quickApplyFlg
     * @param quickApplyFlg - int of quickApplyFlg
     */
    public abstract void setQuickApplyFlg(int quickApplyFlg);

    /**
     * Get the value of quickApplyFlg
     * @return quickApplyFlg - int of quickApplyFlg
     */
    public abstract int getQuickApplyFlg();

    /**
     * Set the value of scanUsdDecNbr
     * @param scanUsdDecNbr - int of scanUsdDecNbr
     */
    public abstract void setScanUsdDecNbr(int scanUsdDecNbr);

    /**
     * Get the value of scanUsdDecNbr
     * @return scanUsdDecNbr - int of scanUsdDecNbr
     */
    public abstract int getScanUsdDecNbr();

    /**
     * Set the value of scanLocalDecNbr
     * @param scanLocalDecNbr - int of scanLocalDecNbr
     */
    public abstract void setScanLocalDecNbr(int scanLocalDecNbr);

    /**
     * Get the value of scanLocalDecNbr
     * @return scanLocalDecNbr - int of scanLocalDecNbr
     */
    public abstract int getScanLocalDecNbr();

    /**
     * Set the value of gndUsedFlag
     * @param gndUsedFlag - int of gndUsedFlag
     */
    public abstract void setGndUsedFlag(int gndUsedFlag);

    /**
     * Get the value of gndUsedFlag
     * @return gndUsedFlag - int of gndUsedFlag
     */
    public abstract int getGndUsedFlag();

    /**
     * Set the value of codUsedFlag
     * @param codUsedFlag - int of codUsedFlag
     */
    public abstract void setCodUsedFlag(int codUsedFlag);

    /**
     * Get the value of codUsedFlag
     * @return codUsedFlag - int of codUsedFlag
     */
    public abstract int getCodUsedFlag();
       
    /**
     * Set the value of ftcUsedFlag
     * @param codUsedFlag - int of ftcUsedFlag
     */
    public abstract void setFtcUsedFlag(int ftcUsedFlag);

    /**
     * Get the value of ftcUsedFlag
     * @return ftcUsedFlag - int of ftcUsedFlag
     */
    public abstract int getFtcUsedFlag();
    
    /**
     * Set the value of oacUsedFlag
     * @param oacUsedFlag - int of oacUsedFlag
     */
    public abstract void setOacUsedFlag(int oacUsedFlag);

    /**
     * Get the value of oacUsedFlag
     * @return oacUsedFlag - int of oacUsedFlag
     */
    public abstract int getOacUsedFlag();

    /**
     * Set the value of collectlaterFlag
     * @param collectlaterFlag - int of collectlaterFlag
     */
    public abstract void setCollectlaterFlag(int collectlaterFlag);

    /**
     * Get the value of collectlaterFlag
     * @return collectlaterFlag - int of collectlaterFlag
     */
    public abstract int getCollectlaterFlag();
    
    /**
     * Set the value of banks
     * @param banks - java.util.Set of banks
     */
    public abstract void setBanks(java.util.Set banks);

    /**
     * Get the value of banks
     * @return banks - java.util.Set of banks
     */
    public abstract java.util.Set getBanks();

    /**
     * Set the value of countryCurrency
     * @param countryCurrency - java.util.Set of countryCurrency
     */
    public abstract void setCountryCurrency(java.util.Set countryCurrency);

    /**
     * Get the value of countryCurrency
     * @return countryCurrency - java.util.Set of countryCurrency
     */
    public abstract java.util.Set getCountryCurrency();

    /**
     * Set the value of locations
     * @param locations - java.util.Set of locations
     */
    public abstract void setLocations(java.util.Set locations);

    /**
     * Get the value of locations
     * @return locations - java.util.Set of locations
     */
    public abstract java.util.Set getLocations();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.String ejbCreate(String countryCd, String countryNm, double errThldLocCurr, double errThldUsd, int quickApplyFlg, int scanUsdDecNbr, int scanLocalDecNbr, int gndUsedFlag, int oacUsedFlag, int collectlaterFlag, int codUsedFlag, int ftcUsedFlag)
        throws CreateException {
        setCountryCd(countryCd);
        setCountryNm(countryNm);
        setErrThldLocCurr(errThldLocCurr);
        setErrThldUsd(errThldUsd);
        setQuickApplyFlg(quickApplyFlg);
        setScanUsdDecNbr(scanUsdDecNbr);
        setScanLocalDecNbr(scanLocalDecNbr);
        setGndUsedFlag(gndUsedFlag);
        setOacUsedFlag(oacUsedFlag);
        setCollectlaterFlag(collectlaterFlag);
        setCodUsedFlag(codUsedFlag);
        setFtcUsedFlag(ftcUsedFlag);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String countryCd, String countryNm, double errThldLocCurr, double errThldUsd, int quickApplyFlg, int scanUsdDecNbr, int scanLocalDecNbr, int gndUsedFlag, int oacUsedFlag, int collectlaterFlag, int codUsedFlag, int ftcUsedFlag)
        throws CreateException {
    }

    /**
     * Called by Container.  Associates this Bean instance with a particular context environment.
     */
    public void setEntityContext(EntityContext ctx) {
        _ctx = ctx;
    }

    /**
     * Called by Container.  Disassociates this Bean instance with a particular 
     * context.  Once done, we can query the Context for environment information
     */
    public void unsetEntityContext() {
        _ctx = null;
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * Called by Container.  Updates the entity bean instance to reflect 
     * the current value stored in the database.
     */
    public void ejbLoad() {
    }

    /**
     * Called by Container.  Updates the database to reflect the current values 
     * of this in-memory Entity Bean instance representation.
     */
    public void ejbStore() {
    }

    /**
     * EJB Container calls this method right before it remove the Entity bean 
     * from the database.  Corresponds to when client calls home.remove().
     */
    public void ejbRemove() {
    }

}
