/**
 * @(#)SurchargesController.java			Tue Aug 02 15:38:53 VET 2005
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

public class SurchargesController {

    /**
     * This method create new Surcharges object
     * @param surchargesVO a value object the Surcharges bean
     */
    public void setSurcharges(SurchargesVO surchargesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (surchargesVO == null) {
            throw new IllegalArgumentException("surchargesVO parameter was null in setSurcharges() method from SurchargesController class");
        }
        
        try {
            getSurchargesManager().setSurcharges(surchargesVO);
        }
        catch (SurchargesException ex) {
            String errorMsg = "Error occurred in setSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Surcharges object
     * @return surchargesVO - a value object of the Surcharges bean
     */
    public SurchargesVO getSurcharges(String surchargeCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (surchargeCd == null) {
            throw new IllegalArgumentException("surchargeCd parameter was null in getSurcharges() method from SurchargesController class");
        }
        
        try {
            return getSurchargesManager().getSurcharges(surchargeCd);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllSurcharges objects
     * @return java.util.Collection - a collection of the Surcharges objects
     */
    public Collection getAllSurcharges()
        throws BusinessDelegateException {
        try {
            return getSurchargesManager().getAllSurcharges();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByRod objects
     * @return java.util.Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByRod(String locationCd)
        throws BusinessDelegateException {
        try {
            return getSurchargesManager().getSurchargesByRod(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getSurchargesByRod() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPrepaid objects
     * @return java.util.Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByPrepaid(String locationCd)
        throws BusinessDelegateException {
        try {
            return getSurchargesManager().getSurchargesByPrepaid(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getSurchargesByPrepaid() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPoa objects
     * @return java.util.Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByPoa(String locationCd)
        throws BusinessDelegateException {
        try {
            return getSurchargesManager().getSurchargesByPoa(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getSurchargesByPoa() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Surcharges object
     * @param surchargeCd - the Surcharges bean primary key
     */
    public void removeSurcharges(String surchargeCd)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (surchargeCd == null) {
            throw new IllegalArgumentException("surchargeCd parameter was null in removeSurcharges() method from SurchargesController class");
        }
        
        try {
            getSurchargesManager().removeSurcharges(surchargeCd);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Surcharges object
     * @param surchargesVO - the value object of the Surcharges bean
     */
    public void updateSurcharges(SurchargesVO surchargesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (surchargesVO == null) {
            throw new IllegalArgumentException("surchargesVO parameter was null in updateSurcharges() method from SurchargesController class");
        }
        
        try {
            getSurchargesManager().updateSurcharges(surchargesVO);
        }
        catch (SurchargesException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateSurcharges() method from SurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the SurchargesManager remote interface
     */
    public SurchargesManager getSurchargesManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            SurchargesManagerHome surchargesManagerHome = (SurchargesManagerHome)
            service.getEJBHome(ServiceConstants.SURCHARGESMANAGER_JNDI, SurchargesManagerHome.class);
            return surchargesManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getSurchargesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getSurchargesManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getSurchargesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
