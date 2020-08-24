/**
 * @(#)EodController.java			Tue Aug 02 15:38:53 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.controller;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.manager.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;

public class EodController {

    /**
     * This method create new Eod object
     * @param eodVO a value object the Eod bean
     */
    public void setEod(EodVO eodVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (eodVO == null) {
            throw new IllegalArgumentException("eodVO parameter was null in setEod() method from EodController class");
        }
        
        try {
            getEodManager().setEod(eodVO);
        }
        catch (EodException ex) {
            String errorMsg = "Error occurred in setEod() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setEod() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Eod object
     * @return eodVO - a value object of the Eod bean
     */
    public EodVO getEod(Integer eodId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (eodId == null) {
            throw new IllegalArgumentException("eodId parameter was null in getEod() method from EodController class");
        }
        
        try {
            return getEodManager().getEod(eodId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getEod() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEod() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllEods objects
     * @return java.util.Collection - a collection of the Eod objects
     */
    public Collection getAllEods()
        throws BusinessDelegateException {
        try {
            return getEodManager().getAllEods();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllEods() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodDt objects
     * @return java.util.Collection - a collection of the Eod objects
     */
    public Collection getEodByEodDt(Date eodDt)
        throws BusinessDelegateException {
        try {
            return getEodManager().getEodByEodDt(eodDt);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEodByEodDt() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocationCd objects
     * @return java.util.Collection - a collection of the Eod objects
     */
    public Collection getEodByLocationCd(String locationCd)
        throws BusinessDelegateException {
        try {
            return getEodManager().getEodByLocationCd(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEodByLocationCd() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocationDt objects
     * @return java.util.Collection - a collection of the Eod objects
     */
    public Collection getEodByLocationDt(String locationCd, Date eodDt)
        throws BusinessDelegateException {
        try {
            return getEodManager().getEodByLocationDt(locationCd, eodDt);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEodByLocationDt() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Eod object
     * @param eodId - the Eod bean primary key
     */
    public void removeEod(Integer eodId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (eodId == null) {
            throw new IllegalArgumentException("eodId parameter was null in removeEod() method from EodController class");
        }
        
        try {
            getEodManager().removeEod(eodId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeEod() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeEod() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Eod object
     * @param eodVO - the value object of the Eod bean
     */
    public void updateEod(EodVO eodVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (eodVO == null) {
            throw new IllegalArgumentException("eodVO parameter was null in updateEod() method from EodController class");
        }
        
        try {
            getEodManager().updateEod(eodVO);
        }
        catch (EodException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateEod() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateEod() method from EodController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the EodManager remote interface
     */
    public EodManager getEodManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            EodManagerHome eodManagerHome = (EodManagerHome)
            service.getEJBHome(ServiceConstants.EODMANAGER_JNDI, EodManagerHome.class);
            return eodManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEodManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getEodManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEodManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
