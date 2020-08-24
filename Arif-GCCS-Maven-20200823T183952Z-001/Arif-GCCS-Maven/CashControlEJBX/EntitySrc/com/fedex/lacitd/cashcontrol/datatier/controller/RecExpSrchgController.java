/**
 * @(#)RecExpSrchgController.java			Tue Aug 02 15:38:53 VET 2005
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

public class RecExpSrchgController {

    /**
     * This method create new RecExpSrchg object
     * @param recExpSrchgVO a value object the RecExpSrchg bean
     */
    public void setRecExpSrchg(RecExpSrchgVO recExpSrchgVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recExpSrchgVO == null) {
            throw new IllegalArgumentException("recExpSrchgVO parameter was null in setRecExpSrchg() method from RecExpSrchgController class");
        }
        
        try {
            getRecExpSrchgManager().setRecExpSrchg(recExpSrchgVO);
        }
        catch (RecExpSrchgException ex) {
            String errorMsg = "Error occurred in setRecExpSrchg() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setRecExpSrchg() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a RecExpSrchg object
     * @return recExpSrchgVO - a value object of the RecExpSrchg bean
     */
    public RecExpSrchgVO getRecExpSrchg(com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (recExpSrchgPK == null) {
            throw new IllegalArgumentException("recExpSrchgPK parameter was null in getRecExpSrchg() method from RecExpSrchgController class");
        }
        
        try {
            return getRecExpSrchgManager().getRecExpSrchg(recExpSrchgPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getRecExpSrchg() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRecExpSrchg() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRecExpSrchgs objects
     * @return java.util.Collection - a collection of the RecExpSrchg objects
     */
    public Collection getAllRecExpSrchgs()
        throws BusinessDelegateException {
        try {
            return getRecExpSrchgManager().getAllRecExpSrchgs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllRecExpSrchgs() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByReceivable objects
     * @return java.util.Collection - a collection of the RecExpSrchg objects
     */
    public Collection getRecExpSrchgByReceivable(Integer recId)
        throws BusinessDelegateException {
        try {
            return getRecExpSrchgManager().getRecExpSrchgByReceivable(recId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRecExpSrchgByReceivable() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing RecExpSrchg object
     * @param recExpSrchgPK - the RecExpSrchg bean primary key
     */
    public void removeRecExpSrchg(com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recExpSrchgPK == null) {
            throw new IllegalArgumentException("recExpSrchgPK parameter was null in removeRecExpSrchg() method from RecExpSrchgController class");
        }
        
        try {
            getRecExpSrchgManager().removeRecExpSrchg(recExpSrchgPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeRecExpSrchg() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeRecExpSrchg() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RecExpSrchg object
     * @param recExpSrchgVO - the value object of the RecExpSrchg bean
     */
    public void updateRecExpSrchg(RecExpSrchgVO recExpSrchgVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recExpSrchgVO == null) {
            throw new IllegalArgumentException("recExpSrchgVO parameter was null in updateRecExpSrchg() method from RecExpSrchgController class");
        }
        
        try {
            getRecExpSrchgManager().updateRecExpSrchg(recExpSrchgVO);
        }
        catch (RecExpSrchgException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateRecExpSrchg() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateRecExpSrchg() method from RecExpSrchgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the RecExpSrchgManager remote interface
     */
    public RecExpSrchgManager getRecExpSrchgManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            RecExpSrchgManagerHome recExpSrchgManagerHome = (RecExpSrchgManagerHome)
            service.getEJBHome(ServiceConstants.RECEXPSRCHGMANAGER_JNDI, RecExpSrchgManagerHome.class);
            return recExpSrchgManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRecExpSrchgManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getRecExpSrchgManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getRecExpSrchgManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
