/**
 * @(#)PrepaidController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PrepaidController {

    /**
     * This method create new Prepaid object
     * @param prepaidVO a value object the Prepaid bean
     */
    public void setPrepaid(PrepaidVO prepaidVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepaidVO == null) {
            throw new IllegalArgumentException("prepaidVO parameter was null in setPrepaid() method from PrepaidController class");
        }
        
        try {
            getPrepaidManager().setPrepaid(prepaidVO);
        }
        catch (PrepaidException ex) {
            String errorMsg = "Error occurred in setPrepaid() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPrepaid() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Prepaid object
     * @return prepaidVO - a value object of the Prepaid bean
     */
    public PrepaidVO getPrepaid(Integer prepaidId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (prepaidId == null) {
            throw new IllegalArgumentException("prepaidId parameter was null in getPrepaid() method from PrepaidController class");
        }
        
        try {
            return getPrepaidManager().getPrepaid(prepaidId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPrepaid() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepaid() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPrepaids objects
     * @return java.util.Collection - a collection of the Prepaid objects
     */
    public Collection getAllPrepaids()
        throws BusinessDelegateException {
        try {
            return getPrepaidManager().getAllPrepaids();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPrepaids() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findPrepaidByAwbNbr objects
     * @return java.util.Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPrepaidByAwbNbr(String awbNbr)
        throws BusinessDelegateException {
        try {
            return getPrepaidManager().getPrepaidPrepaidByAwbNbr(awbNbr);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepaidPrepaidByAwbNbr() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return java.util.Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidByEodId(Integer eodId)
        throws BusinessDelegateException {
        try {
            return getPrepaidManager().getPrepaidByEodId(eodId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepaidByEodId() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findPRPWithoutScan objects
     * @return java.util.Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPRPWithoutScan(String courierId, String locationCd, Integer statusId)
        throws BusinessDelegateException {
        try {
            return getPrepaidManager().getPrepaidPRPWithoutScan(courierId, locationCd, statusId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepaidPRPWithoutScan() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findPRPQueryCosmos objects
     * @return java.util.Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPRPQueryCosmos(String locationCd, Integer statusId)
        throws BusinessDelegateException {
        try {
            return getPrepaidManager().getPrepaidPRPQueryCosmos(locationCd, statusId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepaidPRPQueryCosmos() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Prepaid object
     * @param prepaidId - the Prepaid bean primary key
     */
    public void removePrepaid(Integer prepaidId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepaidId == null) {
            throw new IllegalArgumentException("prepaidId parameter was null in removePrepaid() method from PrepaidController class");
        }
        
        try {
            getPrepaidManager().removePrepaid(prepaidId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePrepaid() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePrepaid() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Prepaid object
     * @param prepaidVO - the value object of the Prepaid bean
     */
    public void updatePrepaid(PrepaidVO prepaidVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (prepaidVO == null) {
            throw new IllegalArgumentException("prepaidVO parameter was null in updatePrepaid() method from PrepaidController class");
        }
        
        try {
            getPrepaidManager().updatePrepaid(prepaidVO);
        }
        catch (PrepaidException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePrepaid() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePrepaid() method from PrepaidController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PrepaidManager remote interface
     */
    public PrepaidManager getPrepaidManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PrepaidManagerHome prepaidManagerHome = (PrepaidManagerHome)
            service.getEJBHome(ServiceConstants.PREPAIDMANAGER_JNDI, PrepaidManagerHome.class);
            return prepaidManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPrepaidManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPrepaidManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPrepaidManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
