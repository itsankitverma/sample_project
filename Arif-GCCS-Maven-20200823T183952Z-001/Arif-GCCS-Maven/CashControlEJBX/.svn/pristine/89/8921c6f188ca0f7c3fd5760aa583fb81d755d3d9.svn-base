/**
 * @(#)OacController.java			Tue Aug 02 15:38:53 VET 2005
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

public class OacController {

    /**
     * This method create new Oac object
     * @param oacVO a value object the Oac bean
     */
    public void setOac(OacVO oacVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (oacVO == null) {
            throw new IllegalArgumentException("oacVO parameter was null in setOac() method from OacController class");
        }
        
        try {
            getOacManager().setOac(oacVO);
        }
        catch (OacException ex) {
            String errorMsg = "Error occurred in setOac() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setOac() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Oac object
     * @return oacVO - a value object of the Oac bean
     */
    public OacVO getOac(Integer obAncSvcIdNbr)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (obAncSvcIdNbr == null) {
            throw new IllegalArgumentException("obAncSvcIdNbr parameter was null in getOac() method from OacController class");
        }
        
        try {
            return getOacManager().getOac(obAncSvcIdNbr);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getOac() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOac() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllOacs objects
     * @return java.util.Collection - a collection of the Oac objects
     */
    public Collection getAllOacs()
        throws BusinessDelegateException {
        try {
            return getOacManager().getAllOacs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllOacs() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPymtCurrCd objects
     * @return java.util.Collection - a collection of the Oac objects
     */
    public Collection getOacByPymtCurrCd(String pymtCurrCd)
        throws BusinessDelegateException {
        try {
            return getOacManager().getOacByPymtCurrCd(pymtCurrCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOacByPymtCurrCd() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocCd objects
     * @return java.util.Collection - a collection of the Oac objects
     */
    public Collection getOacByLocCd(String locCd)
        throws BusinessDelegateException {
        try {
            return getOacManager().getOacByLocCd(locCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOacByLocCd() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByStatusCd objects
     * @return java.util.Collection - a collection of the Oac objects
     */
    public Collection getOacByStatusCd(Integer statusCd)
        throws BusinessDelegateException {
        try {
            return getOacManager().getOacByStatusCd(statusCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOacByStatusCd() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodIdNbr objects
     * @return java.util.Collection - a collection of the Oac objects
     */
    public Collection getOacByEodIdNbr(Integer eodIdNbr)
        throws BusinessDelegateException {
        try {
            return getOacManager().getOacByEodIdNbr(eodIdNbr);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOacByEodIdNbr() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Oac object
     * @param obAncSvcIdNbr - the Oac bean primary key
     */
    public void removeOac(Integer obAncSvcIdNbr)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (obAncSvcIdNbr == null) {
            throw new IllegalArgumentException("obAncSvcIdNbr parameter was null in removeOac() method from OacController class");
        }
        
        try {
            getOacManager().removeOac(obAncSvcIdNbr);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeOac() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeOac() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Oac object
     * @param oacVO - the value object of the Oac bean
     */
    public void updateOac(OacVO oacVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (oacVO == null) {
            throw new IllegalArgumentException("oacVO parameter was null in updateOac() method from OacController class");
        }
        
        try {
            getOacManager().updateOac(oacVO);
        }
        catch (OacException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateOac() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateOac() method from OacController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the OacManager remote interface
     */
    public OacManager getOacManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            OacManagerHome oacManagerHome = (OacManagerHome)
            service.getEJBHome(ServiceConstants.OACMANAGER_JNDI, OacManagerHome.class);
            return oacManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getOacManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getOacManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOacManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
