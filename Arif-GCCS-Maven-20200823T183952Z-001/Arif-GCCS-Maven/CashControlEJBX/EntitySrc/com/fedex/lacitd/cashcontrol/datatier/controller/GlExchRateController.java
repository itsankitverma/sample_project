/**
 * @(#)GlExchRateController.java			Tue Aug 02 15:38:53 VET 2005
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

public class GlExchRateController {

    /**
     * This method create new GlExchRate object
     * @param glExchRateVO a value object the GlExchRate bean
     */
    public void setGlExchRate(GlExchRateVO glExchRateVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (glExchRateVO == null) {
            throw new IllegalArgumentException("glExchRateVO parameter was null in setGlExchRate() method from GlExchRateController class");
        }
        
        try {
            getGlExchRateManager().setGlExchRate(glExchRateVO);
        }
        catch (GlExchRateException ex) {
            String errorMsg = "Error occurred in setGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a GlExchRate object
     * @return glExchRateVO - a value object of the GlExchRate bean
     */
    public GlExchRateVO getGlExchRate(com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK glExchRatePK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (glExchRatePK == null) {
            throw new IllegalArgumentException("glExchRatePK parameter was null in getGlExchRate() method from GlExchRateController class");
        }
        
        try {
            return getGlExchRateManager().getGlExchRate(glExchRatePK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllGlExchRate objects
     * @return java.util.Collection - a collection of the GlExchRate objects
     */
    public Collection getAllGlExchRate()
        throws BusinessDelegateException {
        try {
            return getGlExchRateManager().getAllGlExchRate();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing GlExchRate object
     * @param glExchRatePK - the GlExchRate bean primary key
     */
    public void removeGlExchRate(com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK glExchRatePK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (glExchRatePK == null) {
            throw new IllegalArgumentException("glExchRatePK parameter was null in removeGlExchRate() method from GlExchRateController class");
        }
        
        try {
            getGlExchRateManager().removeGlExchRate(glExchRatePK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing GlExchRate object
     * @param glExchRateVO - the value object of the GlExchRate bean
     */
    public void updateGlExchRate(GlExchRateVO glExchRateVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (glExchRateVO == null) {
            throw new IllegalArgumentException("glExchRateVO parameter was null in updateGlExchRate() method from GlExchRateController class");
        }
        
        try {
            getGlExchRateManager().updateGlExchRate(glExchRateVO);
        }
        catch (GlExchRateException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateGlExchRate() method from GlExchRateController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the GlExchRateManager remote interface
     */
    public GlExchRateManager getGlExchRateManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            GlExchRateManagerHome glExchRateManagerHome = (GlExchRateManagerHome)
            service.getEJBHome(ServiceConstants.GLEXCHRATEMANAGER_JNDI, GlExchRateManagerHome.class);
            return glExchRateManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getGlExchRateManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getGlExchRateManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getGlExchRateManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
