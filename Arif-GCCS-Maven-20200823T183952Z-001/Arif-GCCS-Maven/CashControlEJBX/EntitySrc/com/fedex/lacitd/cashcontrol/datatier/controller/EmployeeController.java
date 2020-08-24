/**
 * @(#)EmployeeController.java			Tue Aug 02 15:38:53 VET 2005
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
import java.util.logging.Logger;

import javax.ejb.*;

public class EmployeeController {

	private final static Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
    /**
     * This method create new Employee object
     * @param employeeVO a value object the Employee bean
     */
    public void setEmployee(EmployeeVO employeeVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (employeeVO == null) {
            throw new IllegalArgumentException("employeeVO parameter was null in setEmployee() method from EmployeeController class");
        }
        
        try {
        	LOGGER.info("employeeVO.getEmployeeId()"+employeeVO.getEmployeeId());
        	LOGGER.info("employeeVO.getEmployeeId()"+employeeVO.getEmployeeId());
        	LOGGER.info("employeeVO.getEmployeeNm()"+employeeVO.getEmployeeNm());  
        	LOGGER.info("employeeVO.getEmail()"+employeeVO.getEmail());  
            getEmployeeManager().setEmployee(employeeVO);
        }
        catch (EmployeeException ex) {
            String errorMsg = "Error occurred in setEmployee() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setEmployee() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Employee object
     * @return employeeVO - a value object of the Employee bean
     */
    public EmployeeVO getEmployee(String employeeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in getEmployee() method from EmployeeController class");
        }
        
        try {
            return getEmployeeManager().getEmployee(employeeId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getEmployee() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmployee() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all DepositSlip objects from the Employee object
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlips(String employeeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in getDepositSlips() method from EmployeeController class");
        }
        
        try {
            return getEmployeeManager().getDepositSlips(employeeId);
        }
        catch (EmployeeException ex) {
            String errorMsg = "Error occurred in getDepositSlips() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlips() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Location object to the Employee object
     * @param employeeId a primary key of Employee object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(String employeeId, String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in addLocation() method from EmployeeController class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addLocation() method from EmployeeController class");
        }
        
        try {
            getEmployeeManager().addLocation(employeeId, locationCd);
        }
        catch (EmployeeException ex) {
            String errorMsg = "Error occurred in addLocation() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in addLocation() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Location object to the Employee object
     * @param employeeId a primary key of Employee object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(String employeeId, String locationCd)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in removeLocation() method from EmployeeController class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from EmployeeController class");
        }
        
        try {
            getEmployeeManager().removeLocation(employeeId, locationCd);
        }
        catch (EmployeeException ex) {
            String errorMsg = "Error occurred in removeLocation() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeLocation() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets all Location objects from the Employee object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(String employeeId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in getLocations() method from EmployeeController class");
        }
        
        try {
            return getEmployeeManager().getLocations(employeeId);
        }
        catch (EmployeeException ex) {
            String errorMsg = "Error occurred in getLocations() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocations() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllEmployees objects
     * @return java.util.Collection - a collection of the Employee objects
     */
    public Collection getAllEmployees()
        throws BusinessDelegateException {
        try {
            return getEmployeeManager().getAllEmployees();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllEmployees() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAdminEmployees objects
     * @return java.util.Collection - a collection of the Employee objects
     */
    public Collection getEmployeeAdminEmployees()
        throws BusinessDelegateException {
        try {
            return getEmployeeManager().getEmployeeAdminEmployees();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmployeeAdminEmployees() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findCountryAdminEmployees objects
     * @return java.util.Collection - a collection of the Employee objects
     */
    public Collection getEmployeeCountryAdminEmployees(String countryCd)
        throws BusinessDelegateException {
        try {
            return getEmployeeManager().getEmployeeCountryAdminEmployees(countryCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmployeeCountryAdminEmployees() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Employee object
     * @param employeeId - the Employee bean primary key
     */
    public void removeEmployee(String employeeId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in removeEmployee() method from EmployeeController class");
        }
        
        try {
            getEmployeeManager().removeEmployee(employeeId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeEmployee() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeEmployee() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Employee object
     * @param employeeVO - the value object of the Employee bean
     */
    public void updateEmployee(EmployeeVO employeeVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (employeeVO == null) {
            throw new IllegalArgumentException("employeeVO parameter was null in updateEmployee() method from EmployeeController class");
        }
        
        try {
            getEmployeeManager().updateEmployee(employeeVO);
        }
        catch (EmployeeException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateEmployee() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateEmployee() method from EmployeeController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the EmployeeManager remote interface
     */
    public EmployeeManager getEmployeeManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            EmployeeManagerHome employeeManagerHome = (EmployeeManagerHome)
            service.getEJBHome(ServiceConstants.EMPLOYEEMANAGER_JNDI, EmployeeManagerHome.class);
            return employeeManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getEmployeeManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmployeeManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
