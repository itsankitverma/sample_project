/**
 * @(#)EmployeeManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.manager;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public interface EmployeeManagerLocal extends EJBLocalObject {

    /**
     * This method create new Employee object
     * @param employeeVO a value object the Employee bean
     */
    public void setEmployee(EmployeeVO employeeVO)
        throws EmployeeException;

    /**
     * This method gets a Employee object
     * @param employeeId - the Employee bean primary key
     * @return employeeVO - a value object of the Employee bean
     */
    public EmployeeVO getEmployee(String employeeId)
        throws FinderException;

    /**
     * This method gets DepositSlip objects from the Employee object
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlips(String employeeId)
        throws EmployeeException;

    /**
     * This method adds the Location object to the Employee object
     * @param employeeId a primary key of Employee object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(String employeeId, String locationCd)
        throws EmployeeException;

    /**
     * This method removes the Location object to the Employee object
     * @param employeeId a primary key of Employee object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(String employeeId, String locationCd)
        throws EmployeeException;

    /**
     * This method gets Location objects from the Employee object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(String employeeId)
        throws EmployeeException;

    /**
     * This method removes an existing Employee object
     * @param employeeId - the Employee bean primary key
     */
    public void removeEmployee(String employeeId)
        throws RemoveException;

    /**
     * This method updates an existing Employee object
     * @param employeeVO - the value object of the Employee bean
     */
    public void updateEmployee(EmployeeVO employeeVO)
        throws EmployeeException;

    /**
     * This method gets findAllEmployees objects
     * @return Collection - a collection of the Employee objects
     */
    public Collection getAllEmployees();

    /**
     * This method gets findAdminEmployees objects
     * @return Collection - a collection of the Employee objects
     */
    public Collection getEmployeeAdminEmployees();

    /**
     * This method gets findCountryAdminEmployees objects
     * @return Collection - a collection of the Employee objects
     */
    public Collection getEmployeeCountryAdminEmployees(String countryCd);

}
