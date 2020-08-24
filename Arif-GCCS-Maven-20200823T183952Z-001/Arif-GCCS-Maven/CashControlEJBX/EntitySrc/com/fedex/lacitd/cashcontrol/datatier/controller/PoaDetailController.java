/**
 * @(#)PoaDetailController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PoaDetailController {

    /**
     * This method create new PoaDetail object
     * @param poaDetailVO a value object the PoaDetail bean
     */
    public void setPoaDetail(PoaDetailVO poaDetailVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaDetailVO == null) {
            throw new IllegalArgumentException("poaDetailVO parameter was null in setPoaDetail() method from PoaDetailController class");
        }
        
        try {
            getPoaDetailManager().setPoaDetail(poaDetailVO);
        }
        catch (PoaDetailException ex) {
            String errorMsg = "Error occurred in setPoaDetail() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPoaDetail() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PoaDetail object
     * @return poaDetailVO - a value object of the PoaDetail bean
     */
    public PoaDetailVO getPoaDetail(Integer poaDetailId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (poaDetailId == null) {
            throw new IllegalArgumentException("poaDetailId parameter was null in getPoaDetail() method from PoaDetailController class");
        }
        
        try {
            return getPoaDetailManager().getPoaDetail(poaDetailId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPoaDetail() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaDetail() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPoaDetails objects
     * @return java.util.Collection - a collection of the PoaDetail objects
     */
    public Collection getAllPoaDetails()
        throws BusinessDelegateException {
        try {
            return getPoaDetailManager().getAllPoaDetails();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPoaDetails() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findPoaDetails objects
     * @return java.util.Collection - a collection of the PoaDetail objects
     */
    public Collection getPoaDetailPoaDetails(int poaPaymentsId)
        throws BusinessDelegateException {
        try {
            return getPoaDetailManager().getPoaDetailPoaDetails(poaPaymentsId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaDetailPoaDetails() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PoaDetail object
     * @param poaDetailId - the PoaDetail bean primary key
     */
    public void removePoaDetail(Integer poaDetailId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaDetailId == null) {
            throw new IllegalArgumentException("poaDetailId parameter was null in removePoaDetail() method from PoaDetailController class");
        }
        
        try {
            getPoaDetailManager().removePoaDetail(poaDetailId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePoaDetail() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePoaDetail() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PoaDetail object
     * @param poaDetailVO - the value object of the PoaDetail bean
     */
    public void updatePoaDetail(PoaDetailVO poaDetailVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (poaDetailVO == null) {
            throw new IllegalArgumentException("poaDetailVO parameter was null in updatePoaDetail() method from PoaDetailController class");
        }
        
        try {
            getPoaDetailManager().updatePoaDetail(poaDetailVO);
        }
        catch (PoaDetailException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePoaDetail() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePoaDetail() method from PoaDetailController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PoaDetailManager remote interface
     */
    public PoaDetailManager getPoaDetailManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PoaDetailManagerHome poaDetailManagerHome = (PoaDetailManagerHome)
            service.getEJBHome(ServiceConstants.POADETAILMANAGER_JNDI, PoaDetailManagerHome.class);
            return poaDetailManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPoaDetailManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPoaDetailManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPoaDetailManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
