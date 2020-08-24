/**
 * @(#)PrepSurchargesController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PrepSurchargesController {

    /**
     * This method create new PrepSurcharges object
     * @param prepSurchargesVO a value object the PrepSurcharges bean
     */
    public void setPrepSurcharges(PrepSurchargesVO prepSurchargesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepSurchargesVO == null) {
            throw new IllegalArgumentException("prepSurchargesVO parameter was null in setPrepSurcharges() method from PrepSurchargesController class");
        }
        
        try {
            getPrepSurchargesManager().setPrepSurcharges(prepSurchargesVO);
        }
        catch (PrepSurchargesException ex) {
            String errorMsg = "Error occurred in setPrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PrepSurcharges object
     * @return prepSurchargesVO - a value object of the PrepSurcharges bean
     */
    public PrepSurchargesVO getPrepSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (prepSurchargesPK == null) {
            throw new IllegalArgumentException("prepSurchargesPK parameter was null in getPrepSurcharges() method from PrepSurchargesController class");
        }
        
        try {
            return getPrepSurchargesManager().getPrepSurcharges(prepSurchargesPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPrepSurcharges objects
     * @return java.util.Collection - a collection of the PrepSurcharges objects
     */
    public Collection getAllPrepSurcharges()
        throws BusinessDelegateException {
        try {
            return getPrepSurchargesManager().getAllPrepSurcharges();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPrepaid objects
     * @return java.util.Collection - a collection of the PrepSurcharges objects
     */
    public Collection getPrepSurchargesByPrepaid(Integer prepId)
        throws BusinessDelegateException {
        try {
            return getPrepSurchargesManager().getPrepSurchargesByPrepaid(prepId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepSurchargesByPrepaid() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PrepSurcharges object
     * @param prepSurchargesPK - the PrepSurcharges bean primary key
     */
    public void removePrepSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepSurchargesPK == null) {
            throw new IllegalArgumentException("prepSurchargesPK parameter was null in removePrepSurcharges() method from PrepSurchargesController class");
        }
        
        try {
            getPrepSurchargesManager().removePrepSurcharges(prepSurchargesPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PrepSurcharges object
     * @param prepSurchargesVO - the value object of the PrepSurcharges bean
     */
    public void updatePrepSurcharges(PrepSurchargesVO prepSurchargesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepSurchargesVO == null) {
            throw new IllegalArgumentException("prepSurchargesVO parameter was null in updatePrepSurcharges() method from PrepSurchargesController class");
        }
        
        try {
            getPrepSurchargesManager().updatePrepSurcharges(prepSurchargesVO);
        }
        catch (PrepSurchargesException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePrepSurcharges() method from PrepSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PrepSurchargesManager remote interface
     */
    public PrepSurchargesManager getPrepSurchargesManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PrepSurchargesManagerHome prepSurchargesManagerHome = (PrepSurchargesManagerHome)
            service.getEJBHome(ServiceConstants.PREPSURCHARGESMANAGER_JNDI, PrepSurchargesManagerHome.class);
            return prepSurchargesManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPrepSurchargesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPrepSurchargesManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepSurchargesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
