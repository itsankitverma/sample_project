/**
 * @(#)GroundController.java			Wed Nov 29 10:36:42 VET 2006
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

public class GroundController {

    /**
     * This method create new Ground object
     * @param groundVO a value object the Ground bean
     */
    public void setGround(GroundVO groundVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (groundVO == null) {
            throw new IllegalArgumentException("groundVO parameter was null in setGround() method from GroundController class");
        }
        
        try {
            getGroundManager().setGround(groundVO);
        }
        catch (GroundException ex) {
            String errorMsg = "Error occurred in setGround() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setGround() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Ground object
     * @return groundVO - a value object of the Ground bean
     */
    public GroundVO getGround(Integer grndShpIdNbr)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (grndShpIdNbr == null) {
            throw new IllegalArgumentException("grndShpIdNbr parameter was null in getGround() method from GroundController class");
        }
        
        try {
            return getGroundManager().getGround(grndShpIdNbr);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getGround() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getGround() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllGrounds objects
     * @return java.util.Collection - a collection of the Ground objects
     */
    public Collection getAllGrounds()
        throws BusinessDelegateException {
        try {
            return getGroundManager().getAllGrounds();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllGrounds() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByGrndShpIdNbr objects
     * @return java.util.Collection - a collection of the Ground objects
     */
    public Collection getGroundByGrndShpIdNbr(Integer grndShpIdNbr1)
        throws BusinessDelegateException {
        try {
            return getGroundManager().getGroundByGrndShpIdNbr(grndShpIdNbr1);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getGroundByGrndShpIdNbr() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Ground object
     * @param grndShpIdNbr - the Ground bean primary key
     */
    public void removeGround(Integer grndShpIdNbr)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (grndShpIdNbr == null) {
            throw new IllegalArgumentException("grndShpIdNbr parameter was null in removeGround() method from GroundController class");
        }
        
        try {
            getGroundManager().removeGround(grndShpIdNbr);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeGround() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeGround() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Ground object
     * @param groundVO - the value object of the Ground bean
     */
    public void updateGround(GroundVO groundVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (groundVO == null) {
            throw new IllegalArgumentException("groundVO parameter was null in updateGround() method from GroundController class");
        }
        
        try {
            getGroundManager().updateGround(groundVO);
        }
        catch (GroundException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateGround() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateGround() method from GroundController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the GroundManager remote interface
     */
    public GroundManager getGroundManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            GroundManagerHome groundManagerHome = (GroundManagerHome)
            service.getEJBHome(ServiceConstants.GROUNDMANAGER_JNDI, GroundManagerHome.class);
            return groundManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getGroundManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getGroundManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getGroundManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
