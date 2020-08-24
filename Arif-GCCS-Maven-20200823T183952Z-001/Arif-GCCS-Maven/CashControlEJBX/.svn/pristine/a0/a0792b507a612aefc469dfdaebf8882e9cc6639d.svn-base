/**
 * @(#)SurchargeLocController.java			Tue Aug 02 15:38:53 VET 2005
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

public class SurchargeLocController {

    /**
     * This method create new SurchargeLoc object
     * @param surchargeLocVO a value object the SurchargeLoc bean
     */
    public void setSurchargeLoc(SurchargeLocVO surchargeLocVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (surchargeLocVO == null) {
            throw new IllegalArgumentException("surchargeLocVO parameter was null in setSurchargeLoc() method from SurchargeLocController class");
        }
        
        try {
            getSurchargeLocManager().setSurchargeLoc(surchargeLocVO);
        }
        catch (SurchargeLocException ex) {
            String errorMsg = "Error occurred in setSurchargeLoc() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setSurchargeLoc() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a SurchargeLoc object
     * @return surchargeLocVO - a value object of the SurchargeLoc bean
     */
    public SurchargeLocVO getSurchargeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (surchargeLocPK == null) {
            throw new IllegalArgumentException("surchargeLocPK parameter was null in getSurchargeLoc() method from SurchargeLocController class");
        }
        
        try {
            return getSurchargeLocManager().getSurchargeLoc(surchargeLocPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getSurchargeLoc() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getSurchargeLoc() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllSurchargeLocs objects
     * @return java.util.Collection - a collection of the SurchargeLoc objects
     */
    public Collection getAllSurchargeLocs()
        throws BusinessDelegateException {
        try {
            return getSurchargeLocManager().getAllSurchargeLocs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllSurchargeLocs() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing SurchargeLoc object
     * @param surchargeLocPK - the SurchargeLoc bean primary key
     */
    public void removeSurchargeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (surchargeLocPK == null) {
            throw new IllegalArgumentException("surchargeLocPK parameter was null in removeSurchargeLoc() method from SurchargeLocController class");
        }
        
        try {
            getSurchargeLocManager().removeSurchargeLoc(surchargeLocPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeSurchargeLoc() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeSurchargeLoc() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing SurchargeLoc object
     * @param surchargeLocVO - the value object of the SurchargeLoc bean
     */
    public void updateSurchargeLoc(SurchargeLocVO surchargeLocVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (surchargeLocVO == null) {
            throw new IllegalArgumentException("surchargeLocVO parameter was null in updateSurchargeLoc() method from SurchargeLocController class");
        }
        
        try {
            getSurchargeLocManager().updateSurchargeLoc(surchargeLocVO);
        }
        catch (SurchargeLocException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateSurchargeLoc() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateSurchargeLoc() method from SurchargeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the SurchargeLocManager remote interface
     */
    public SurchargeLocManager getSurchargeLocManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            SurchargeLocManagerHome surchargeLocManagerHome = (SurchargeLocManagerHome)
            service.getEJBHome(ServiceConstants.SURCHARGELOCMANAGER_JNDI, SurchargeLocManagerHome.class);
            return surchargeLocManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getSurchargeLocManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getSurchargeLocManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getSurchargeLocManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
