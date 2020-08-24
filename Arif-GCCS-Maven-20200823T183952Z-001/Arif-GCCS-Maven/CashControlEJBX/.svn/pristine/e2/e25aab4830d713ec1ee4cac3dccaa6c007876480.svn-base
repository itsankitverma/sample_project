/**
 * @(#)RecSurchargesController.java			Tue Aug 02 15:38:53 VET 2005
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

public class RecSurchargesController {

    /**
     * This method create new RecSurcharges object
     * @param recSurchargesVO a value object the RecSurcharges bean
     */
    public void setRecSurcharges(RecSurchargesVO recSurchargesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recSurchargesVO == null) {
            throw new IllegalArgumentException("recSurchargesVO parameter was null in setRecSurcharges() method from RecSurchargesController class");
        }
        
        try {
            getRecSurchargesManager().setRecSurcharges(recSurchargesVO);
        }
        catch (RecSurchargesException ex) {
            String errorMsg = "Error occurred in setRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a RecSurcharges object
     * @return recSurchargesVO - a value object of the RecSurcharges bean
     */
    public RecSurchargesVO getRecSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (recSurchargesPK == null) {
            throw new IllegalArgumentException("recSurchargesPK parameter was null in getRecSurcharges() method from RecSurchargesController class");
        }
        
        try {
            return getRecSurchargesManager().getRecSurcharges(recSurchargesPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRecSurcharges objects
     * @return java.util.Collection - a collection of the RecSurcharges objects
     */
    public Collection getAllRecSurcharges()
        throws BusinessDelegateException {
        try {
            return getRecSurchargesManager().getAllRecSurcharges();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByReceivable objects
     * @return java.util.Collection - a collection of the RecSurcharges objects
     */
    public Collection getRecSurchargesByReceivable(Integer recId)
        throws BusinessDelegateException {
        try {
            return getRecSurchargesManager().getRecSurchargesByReceivable(recId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRecSurchargesByReceivable() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing RecSurcharges object
     * @param recSurchargesPK - the RecSurcharges bean primary key
     */
    public void removeRecSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recSurchargesPK == null) {
            throw new IllegalArgumentException("recSurchargesPK parameter was null in removeRecSurcharges() method from RecSurchargesController class");
        }
        
        try {
            getRecSurchargesManager().removeRecSurcharges(recSurchargesPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RecSurcharges object
     * @param recSurchargesVO - the value object of the RecSurcharges bean
     */
    public void updateRecSurcharges(RecSurchargesVO recSurchargesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recSurchargesVO == null) {
            throw new IllegalArgumentException("recSurchargesVO parameter was null in updateRecSurcharges() method from RecSurchargesController class");
        }
        
        try {
            getRecSurchargesManager().updateRecSurcharges(recSurchargesVO);
        }
        catch (RecSurchargesException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateRecSurcharges() method from RecSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the RecSurchargesManager remote interface
     */
    public RecSurchargesManager getRecSurchargesManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            RecSurchargesManagerHome recSurchargesManagerHome = (RecSurchargesManagerHome)
            service.getEJBHome(ServiceConstants.RECSURCHARGESMANAGER_JNDI, RecSurchargesManagerHome.class);
            return recSurchargesManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRecSurchargesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getRecSurchargesManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRecSurchargesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
