/**
 * @(#)EmpXLocationXRoleController.java			Tue Aug 02 15:38:53 VET 2005
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

import com.fedex.lacitd.cashcontrol.datatier.common.ServiceConstants;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.EmpXLocationXRoleException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.manager.EmpXLocationXRoleManager;
import com.fedex.lacitd.cashcontrol.datatier.manager.EmpXLocationXRoleManagerHome;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmpXLocationXRoleVO;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import java.rmi.RemoteException;
import java.util.Collection;

public class EmpXLocationXRoleController {

    /**
     * This method create new EmpXLocationXRole object
     * @param empXLocationXRoleVO a value object the EmpXLocationXRole bean
     */
    public void setEmpXLocationXRole(EmpXLocationXRoleVO empXLocationXRoleVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (empXLocationXRoleVO == null) {
            throw new IllegalArgumentException("empXLocationXRoleVO parameter was null in setEmpXLocationXRole() method from EmpXLocationXRoleController class");
        }
        
        try {
            getEmpXLocationXRoleManager().setEmpXLocationXRole(empXLocationXRoleVO);
        }
        catch (EmpXLocationXRoleException ex) {
            String errorMsg = "Error occurred in setEmpXLocationXRole() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setEmpXLocationXRole() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a EmpXLocationXRole object
     * @return empXLocationXRoleVO - a value object of the EmpXLocationXRole bean
     */
    public EmpXLocationXRoleVO getEmpXLocationXRole(com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (empXLocationXRolePK == null) {
            throw new IllegalArgumentException("empXLocationXRolePK parameter was null in getEmpXLocationXRole() method from EmpXLocationXRoleController class");
        }
        
        try {
            return getEmpXLocationXRoleManager().getEmpXLocationXRole(empXLocationXRolePK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRole() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRole() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllEmpXLocationXRoles objects
     * @return java.util.Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getAllEmpXLocationXRoles()
        throws BusinessDelegateException {
        try {
            return getEmpXLocationXRoleManager().getAllEmpXLocationXRoles();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllEmpXLocationXRoles() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByRoleId objects
     * @return java.util.Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByRoleId(Integer roleId)
        throws BusinessDelegateException {
        try {
            return getEmpXLocationXRoleManager().getEmpXLocationXRoleByRoleId(roleId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleByRoleId() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocationCd objects
     * @return java.util.Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByLocationCd(String locationCd)
        throws BusinessDelegateException {
        try {
            return getEmpXLocationXRoleManager().getEmpXLocationXRoleByLocationCd(locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleByLocationCd() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEmployeeId objects
     * @return java.util.Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByEmployeeId(String employeeId)
        throws BusinessDelegateException {
        try {
            return getEmpXLocationXRoleManager().getEmpXLocationXRoleByEmployeeId(employeeId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleByEmployeeId() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEmployeeAndLocation objects
     * @return java.util.Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByEmployeeAndLocation(String employeeId, String locationCd)
        throws BusinessDelegateException {
        try {
            return getEmpXLocationXRoleManager().getEmpXLocationXRoleByEmployeeAndLocation(employeeId, locationCd);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleByEmployeeAndLocation() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing EmpXLocationXRole object
     * @param empXLocationXRolePK - the EmpXLocationXRole bean primary key
     */
    public void removeEmpXLocationXRole(com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (empXLocationXRolePK == null) {
            throw new IllegalArgumentException("empXLocationXRolePK parameter was null in removeEmpXLocationXRole() method from EmpXLocationXRoleController class");
        }
        
        try {
            getEmpXLocationXRoleManager().removeEmpXLocationXRole(empXLocationXRolePK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeEmpXLocationXRole() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeEmpXLocationXRole() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing EmpXLocationXRole object
     * @param empXLocationXRoleVO - the value object of the EmpXLocationXRole bean
     */
    public void updateEmpXLocationXRole(EmpXLocationXRoleVO empXLocationXRoleVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (empXLocationXRoleVO == null) {
            throw new IllegalArgumentException("empXLocationXRoleVO parameter was null in updateEmpXLocationXRole() method from EmpXLocationXRoleController class");
        }
        
        try {
            getEmpXLocationXRoleManager().updateEmpXLocationXRole(empXLocationXRoleVO);
        }
        catch (EmpXLocationXRoleException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateEmpXLocationXRole() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateEmpXLocationXRole() method from EmpXLocationXRoleController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the EmpXLocationXRoleManager remote interface
     */
    public EmpXLocationXRoleManager getEmpXLocationXRoleManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            EmpXLocationXRoleManagerHome empXLocationXRoleManagerHome = (EmpXLocationXRoleManagerHome)
            service.getEJBHome(ServiceConstants.EMPXLOCATIONXROLEMANAGER_JNDI, EmpXLocationXRoleManagerHome.class);
            return empXLocationXRoleManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
