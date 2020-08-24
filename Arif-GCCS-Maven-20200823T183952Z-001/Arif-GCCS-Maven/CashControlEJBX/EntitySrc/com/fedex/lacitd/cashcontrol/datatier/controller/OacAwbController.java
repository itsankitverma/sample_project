/**
 * @(#)OacAwbController.java			Tue Aug 02 15:38:53 VET 2005
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

public class OacAwbController {

    /**
     * This method create new OacAwb object
     * @param oacAwbVO a value object the OacAwb bean
     */
    public void setOacAwb(OacAwbVO oacAwbVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (oacAwbVO == null) {
            throw new IllegalArgumentException("oacAwbVO parameter was null in setOacAwb() method from OacAwbController class");
        }
        
        try {
            getOacAwbManager().setOacAwb(oacAwbVO);
        }
        catch (OacAwbException ex) {
            String errorMsg = "Error occurred in setOacAwb() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setOacAwb() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a OacAwb object
     * @return oacAwbVO - a value object of the OacAwb bean
     */
    public OacAwbVO getOacAwb(com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (oacAwbPK == null) {
            throw new IllegalArgumentException("oacAwbPK parameter was null in getOacAwb() method from OacAwbController class");
        }
        
        try {
            return getOacAwbManager().getOacAwb(oacAwbPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getOacAwb() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOacAwb() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllOacAwbs objects
     * @return java.util.Collection - a collection of the OacAwb objects
     */
    public Collection getAllOacAwbs()
        throws BusinessDelegateException {
        try {
            return getOacAwbManager().getAllOacAwbs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllOacAwbs() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findOacAwbsByOacId objects
     * @return java.util.Collection - a collection of the OacAwb objects
     */
    public Collection getOacAwbOacAwbsByOacId(Integer oacId)
        throws BusinessDelegateException {
        try {
            return getOacAwbManager().getOacAwbOacAwbsByOacId(oacId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOacAwbOacAwbsByOacId() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing OacAwb object
     * @param oacAwbPK - the OacAwb bean primary key
     */
    public void removeOacAwb(com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (oacAwbPK == null) {
            throw new IllegalArgumentException("oacAwbPK parameter was null in removeOacAwb() method from OacAwbController class");
        }
        
        try {
            getOacAwbManager().removeOacAwb(oacAwbPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeOacAwb() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeOacAwb() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing OacAwb object
     * @param oacAwbVO - the value object of the OacAwb bean
     */
    public void updateOacAwb(OacAwbVO oacAwbVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (oacAwbVO == null) {
            throw new IllegalArgumentException("oacAwbVO parameter was null in updateOacAwb() method from OacAwbController class");
        }
        
        try {
            getOacAwbManager().updateOacAwb(oacAwbVO);
        }
        catch (OacAwbException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateOacAwb() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateOacAwb() method from OacAwbController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the OacAwbManager remote interface
     */
    public OacAwbManager getOacAwbManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            OacAwbManagerHome oacAwbManagerHome = (OacAwbManagerHome)
            service.getEJBHome(ServiceConstants.OACAWBMANAGER_JNDI, OacAwbManagerHome.class);
            return oacAwbManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getOacAwbManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getOacAwbManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOacAwbManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
