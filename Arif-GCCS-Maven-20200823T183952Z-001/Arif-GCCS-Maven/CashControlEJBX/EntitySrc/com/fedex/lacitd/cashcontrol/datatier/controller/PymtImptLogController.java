/**
 * @(#)PymtImptLogController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PymtImptLogController {

    /**
     * This method create new PymtImptLog object
     * @param pymtImptLogVO a value object the PymtImptLog bean
     */
    public void setPymtImptLog(PymtImptLogVO pymtImptLogVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (pymtImptLogVO == null) {
            throw new IllegalArgumentException("pymtImptLogVO parameter was null in setPymtImptLog() method from PymtImptLogController class");
        }
        
        try {
            getPymtImptLogManager().setPymtImptLog(pymtImptLogVO);
        }
        catch (PymtImptLogException ex) {
            String errorMsg = "Error occurred in setPymtImptLog() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPymtImptLog() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PymtImptLog object
     * @return pymtImptLogVO - a value object of the PymtImptLog bean
     */
    public PymtImptLogVO getPymtImptLog(Integer imptId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (imptId == null) {
            throw new IllegalArgumentException("imptId parameter was null in getPymtImptLog() method from PymtImptLogController class");
        }
        
        try {
            return getPymtImptLogManager().getPymtImptLog(imptId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPymtImptLog() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtImptLog() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all PymtImptErrorDtl objects from the PymtImptLog object
     * @return Collection - a collection of the PymtImptErrorDtl objects
     */
    public Collection getPymtImptErrorDtls(Integer imptId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (imptId == null) {
            throw new IllegalArgumentException("imptId parameter was null in getPymtImptErrorDtls() method from PymtImptLogController class");
        }
        
        try {
            return getPymtImptLogManager().getPymtImptErrorDtls(imptId);
        }
        catch (PymtImptLogException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtls() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtls() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPymtImptLogs objects
     * @return java.util.Collection - a collection of the PymtImptLog objects
     */
    public Collection getAllPymtImptLogs()
        throws BusinessDelegateException {
        try {
            return getPymtImptLogManager().getAllPymtImptLogs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPymtImptLogs() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PymtImptLog object
     * @param imptId - the PymtImptLog bean primary key
     */
    public void removePymtImptLog(Integer imptId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (imptId == null) {
            throw new IllegalArgumentException("imptId parameter was null in removePymtImptLog() method from PymtImptLogController class");
        }
        
        try {
            getPymtImptLogManager().removePymtImptLog(imptId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePymtImptLog() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePymtImptLog() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PymtImptLog object
     * @param pymtImptLogVO - the value object of the PymtImptLog bean
     */
    public void updatePymtImptLog(PymtImptLogVO pymtImptLogVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (pymtImptLogVO == null) {
            throw new IllegalArgumentException("pymtImptLogVO parameter was null in updatePymtImptLog() method from PymtImptLogController class");
        }
        
        try {
            getPymtImptLogManager().updatePymtImptLog(pymtImptLogVO);
        }
        catch (PymtImptLogException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePymtImptLog() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePymtImptLog() method from PymtImptLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PymtImptLogManager remote interface
     */
    public PymtImptLogManager getPymtImptLogManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PymtImptLogManagerHome pymtImptLogManagerHome = (PymtImptLogManagerHome)
            service.getEJBHome(ServiceConstants.PYMTIMPTLOGMANAGER_JNDI, PymtImptLogManagerHome.class);
            return pymtImptLogManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPymtImptLogManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPymtImptLogManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtImptLogManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
