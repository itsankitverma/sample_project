/**
 * @(#)PoaSurchargesController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PoaSurchargesController {

    /**
     * This method create new PoaSurcharges object
     * @param poaSurchargesVO a value object the PoaSurcharges bean
     */
    public void setPoaSurcharges(PoaSurchargesVO poaSurchargesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaSurchargesVO == null) {
            throw new IllegalArgumentException("poaSurchargesVO parameter was null in setPoaSurcharges() method from PoaSurchargesController class");
        }
        
        try {
            getPoaSurchargesManager().setPoaSurcharges(poaSurchargesVO);
        }
        catch (PoaSurchargesException ex) {
            String errorMsg = "Error occurred in setPoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PoaSurcharges object
     * @return poaSurchargesVO - a value object of the PoaSurcharges bean
     */
    public PoaSurchargesVO getPoaSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (poaSurchargesPK == null) {
            throw new IllegalArgumentException("poaSurchargesPK parameter was null in getPoaSurcharges() method from PoaSurchargesController class");
        }
        
        try {
            return getPoaSurchargesManager().getPoaSurcharges(poaSurchargesPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPoaSurcharges objects
     * @return java.util.Collection - a collection of the PoaSurcharges objects
     */
    public Collection getAllPoaSurcharges()
        throws BusinessDelegateException {
        try {
            return getPoaSurchargesManager().getAllPoaSurcharges();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPoaDetail objects
     * @return java.util.Collection - a collection of the PoaSurcharges objects
     */
    public Collection getPoaSurchargesByPoaDetail(Integer poaDetailId)
        throws BusinessDelegateException {
        try {
            return getPoaSurchargesManager().getPoaSurchargesByPoaDetail(poaDetailId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaSurchargesByPoaDetail() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PoaSurcharges object
     * @param poaSurchargesPK - the PoaSurcharges bean primary key
     */
    public void removePoaSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaSurchargesPK == null) {
            throw new IllegalArgumentException("poaSurchargesPK parameter was null in removePoaSurcharges() method from PoaSurchargesController class");
        }
        
        try {
            getPoaSurchargesManager().removePoaSurcharges(poaSurchargesPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PoaSurcharges object
     * @param poaSurchargesVO - the value object of the PoaSurcharges bean
     */
    public void updatePoaSurcharges(PoaSurchargesVO poaSurchargesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaSurchargesVO == null) {
            throw new IllegalArgumentException("poaSurchargesVO parameter was null in updatePoaSurcharges() method from PoaSurchargesController class");
        }
        
        try {
            getPoaSurchargesManager().updatePoaSurcharges(poaSurchargesVO);
        }
        catch (PoaSurchargesException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePoaSurcharges() method from PoaSurchargesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PoaSurchargesManager remote interface
     */
    public PoaSurchargesManager getPoaSurchargesManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PoaSurchargesManagerHome poaSurchargesManagerHome = (PoaSurchargesManagerHome)
            service.getEJBHome(ServiceConstants.POASURCHARGESMANAGER_JNDI, PoaSurchargesManagerHome.class);
            return poaSurchargesManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPoaSurchargesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPoaSurchargesManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaSurchargesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
