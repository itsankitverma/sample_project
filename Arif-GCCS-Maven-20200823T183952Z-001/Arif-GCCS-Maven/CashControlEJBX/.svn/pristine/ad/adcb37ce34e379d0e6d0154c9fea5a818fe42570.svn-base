/**
 * @(#)EmployeeClearingController.java			Tue Aug 02 15:38:53 VET 2005
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

public class EmployeeClearingController {

    /**
     * This method create new EmployeeClearing object
     * @param employeeClearingVO a value object the EmployeeClearing bean
     */
    public void setEmployeeClearing(EmployeeClearingVO employeeClearingVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (employeeClearingVO == null) {
            throw new IllegalArgumentException("employeeClearingVO parameter was null in setEmployeeClearing() method from EmployeeClearingController class");
        }
        
        try {
            getEmployeeClearingManager().setEmployeeClearing(employeeClearingVO);
        }
        catch (EmployeeClearingException ex) {
            String errorMsg = "Error occurred in setEmployeeClearing() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setEmployeeClearing() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a EmployeeClearing object
     * @return employeeClearingVO - a value object of the EmployeeClearing bean
     */
    public EmployeeClearingVO getEmployeeClearing(com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK employeeClearingPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (employeeClearingPK == null) {
            throw new IllegalArgumentException("employeeClearingPK parameter was null in getEmployeeClearing() method from EmployeeClearingController class");
        }
        
        try {
            return getEmployeeClearingManager().getEmployeeClearing(employeeClearingPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getEmployeeClearing() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmployeeClearing() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllEmployeeClearings objects
     * @return java.util.Collection - a collection of the EmployeeClearing objects
     */
    public Collection getAllEmployeeClearings()
        throws BusinessDelegateException {
        try {
            return getEmployeeClearingManager().getAllEmployeeClearings();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllEmployeeClearings() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing EmployeeClearing object
     * @param employeeClearingPK - the EmployeeClearing bean primary key
     */
    public void removeEmployeeClearing(com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK employeeClearingPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (employeeClearingPK == null) {
            throw new IllegalArgumentException("employeeClearingPK parameter was null in removeEmployeeClearing() method from EmployeeClearingController class");
        }
        
        try {
            getEmployeeClearingManager().removeEmployeeClearing(employeeClearingPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeEmployeeClearing() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeEmployeeClearing() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing EmployeeClearing object
     * @param employeeClearingVO - the value object of the EmployeeClearing bean
     */
    public void updateEmployeeClearing(EmployeeClearingVO employeeClearingVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (employeeClearingVO == null) {
            throw new IllegalArgumentException("employeeClearingVO parameter was null in updateEmployeeClearing() method from EmployeeClearingController class");
        }
        
        try {
            getEmployeeClearingManager().updateEmployeeClearing(employeeClearingVO);
        }
        catch (EmployeeClearingException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateEmployeeClearing() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateEmployeeClearing() method from EmployeeClearingController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the EmployeeClearingManager remote interface
     */
    public EmployeeClearingManager getEmployeeClearingManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            EmployeeClearingManagerHome employeeClearingManagerHome = (EmployeeClearingManagerHome)
            service.getEJBHome(ServiceConstants.EMPLOYEECLEARINGMANAGER_JNDI, EmployeeClearingManagerHome.class);
            return employeeClearingManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeClearingManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getEmployeeClearingManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmployeeClearingManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
