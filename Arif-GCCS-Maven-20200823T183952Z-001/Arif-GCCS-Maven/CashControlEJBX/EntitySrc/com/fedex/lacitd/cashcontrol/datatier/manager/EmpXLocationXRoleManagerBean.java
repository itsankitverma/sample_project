/**
 * @(#)EmpXLocationXRoleManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

import com.fedex.lacitd.cashcontrol.datatier.common.ServiceConstants;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRoleLocal;
import com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRoleLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.exception.EmpXLocationXRoleException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmpXLocationXRoleVO;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EmpXLocationXRoleManagerBean implements SessionBean {

    private SessionContext _ctx;
    /**
     * Called by Container. This method initialization the session
     */
    public void ejbCreate() {
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * EJB Container calls this method right before it remove the Session bean 
     */
    public void ejbRemove() {
    }

    /**
     * Called by Container. Associates this Bean instance with a particular context environment.
     */
    public void setSessionContext(SessionContext ctx) {
        _ctx = ctx;
    }

    /**
     * This method create new EmpXLocationXRole object
     * @param empXLocationXRoleVO a value object the EmpXLocationXRole bean
     */
    public void setEmpXLocationXRole(EmpXLocationXRoleVO empXLocationXRoleVO)
        throws EmpXLocationXRoleException {
        //-- we do not accept null value for the parameter.
        if (empXLocationXRoleVO == null) {
            throw new IllegalArgumentException("empXLocationXRoleVO parameter was null in setEmpXLocationXRole() method from EmpXLocationXRoleManager class");
        }
        
        try {
            
            //-- create new EmpXLocationXRole object
            getEmpXLocationXRoleLocalHome().create(
                empXLocationXRoleVO.getRoleId(),
                empXLocationXRoleVO.getLocationCd(),
                empXLocationXRoleVO.getEmployeeId());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setEmpXLocationXRole() method from EmpXLocationXRoleManager class";
            throw new EmpXLocationXRoleException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setEmpXLocationXRole() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a EmpXLocationXRole object
     * @return empXLocationXRoleVO - a value object of the EmpXLocationXRole bean
     */
    public EmpXLocationXRoleVO getEmpXLocationXRole(com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (empXLocationXRolePK == null) {
            throw new IllegalArgumentException("empXLocationXRolePK parameter was null in getEmpXLocationXRole() method from EmpXLocationXRoleManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            EmpXLocationXRoleLocal empXLocationXRoleLocal = getEmpXLocationXRoleLocalHome().findByPrimaryKey(empXLocationXRolePK);
            //-- create new value object to store the data
            EmpXLocationXRoleVO empXLocationXRoleVO = new EmpXLocationXRoleVO();
            //-- populate the new value object
            empXLocationXRoleVO.setRoleId(empXLocationXRoleLocal.getRoleId());
            empXLocationXRoleVO.setLocationCd(empXLocationXRoleLocal.getLocationCd());
            empXLocationXRoleVO.setEmployeeId(empXLocationXRoleLocal.getEmployeeId());
            return empXLocationXRoleVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRole() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing EmpXLocationXRole object
     * @param empXLocationXRolePK - the EmpXLocationXRole bean primary key
     */
    public void removeEmpXLocationXRole(com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (empXLocationXRolePK == null) {
            throw new IllegalArgumentException("empXLocationXRolePK parameter was null in removeEmpXLocationXRole() method from EmpXLocationXRoleManager class");
        }
        
        try {
            getEmpXLocationXRoleLocalHome().remove(empXLocationXRolePK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeEmpXLocationXRole() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing EmpXLocationXRole object
     * @param empXLocationXRoleVO - the value object of the EmpXLocationXRole bean
     */
    public void updateEmpXLocationXRole(EmpXLocationXRoleVO empXLocationXRoleVO)
        throws EmpXLocationXRoleException {
        //-- we do not accept null value for the parameter.
        if (empXLocationXRoleVO == null) {
            throw new IllegalArgumentException("empXLocationXRoleVO parameter was null in updateEmpXLocationXRole() method from EmpXLocationXRoleManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK = empXLocationXRoleVO.getEmpXLocationXRolePK();
            
            EmpXLocationXRoleLocal empXLocationXRoleLocal = getEmpXLocationXRoleLocalHome().findByPrimaryKey(empXLocationXRolePK);
            //-- update EmpXLocationXRole entity bean
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateEmpXLocationXRole() method from EmpXLocationXRoleManager class";
            throw new EmpXLocationXRoleException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateEmpXLocationXRole() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllEmpXLocationXRoles objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getAllEmpXLocationXRoles() {
        try {
            //-- gets the local home interface and call the findAllEmpXLocationXRoles method
            Collection empXLocationXRoleCol = getEmpXLocationXRoleLocalHome().findAllEmpXLocationXRoles();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (empXLocationXRoleCol != null && empXLocationXRoleCol.size() > 0) {
                Iterator it = empXLocationXRoleCol.iterator();
                while (it.hasNext()) {
                    EmpXLocationXRoleLocal empXLocationXRoleLocal = (EmpXLocationXRoleLocal) it.next();
                    //-- get the primary key of the EmpXLocationXRole EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK = (com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK)empXLocationXRoleLocal.getPrimaryKey();
                    //-- get the value object for the EmpXLocationXRole EJB using the primary key
                    if (empXLocationXRolePK != null) {
                        EmpXLocationXRoleVO empXLocationXRoleVO = getEmpXLocationXRole(empXLocationXRolePK);
                        //-- add the value object to the collection
                        list.add(empXLocationXRoleVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllEmpXLocationXRoles() method from EmpXLocationXRoleManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllEmpXLocationXRoles() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByRoleId objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByRoleId(Integer roleId) {
        try {
            //-- gets the local home interface and call the findByRoleId method
            Collection empXLocationXRoleCol = getEmpXLocationXRoleLocalHome().findByRoleId(roleId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (empXLocationXRoleCol != null && empXLocationXRoleCol.size() > 0) {
                Iterator it = empXLocationXRoleCol.iterator();
                while (it.hasNext()) {
                    EmpXLocationXRoleLocal empXLocationXRoleLocal = (EmpXLocationXRoleLocal) it.next();
                    //-- get the primary key of the EmpXLocationXRole EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK = (com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK)empXLocationXRoleLocal.getPrimaryKey();
                    //-- get the value object for the EmpXLocationXRole EJB using the primary key
                    if (empXLocationXRolePK != null) {
                        EmpXLocationXRoleVO empXLocationXRoleVO = getEmpXLocationXRole(empXLocationXRolePK);
                        //-- add the value object to the collection
                        list.add(empXLocationXRoleVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEmpXLocationXRoleByRoleId() method from EmpXLocationXRoleManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleByRoleId() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocationCd objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByLocationCd(String locationCd) {
        try {
            //-- gets the local home interface and call the findByLocationCd method
            Collection empXLocationXRoleCol = getEmpXLocationXRoleLocalHome().findByLocationCd(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (empXLocationXRoleCol != null && empXLocationXRoleCol.size() > 0) {
                Iterator it = empXLocationXRoleCol.iterator();
                while (it.hasNext()) {
                    EmpXLocationXRoleLocal empXLocationXRoleLocal = (EmpXLocationXRoleLocal) it.next();
                    //-- get the primary key of the EmpXLocationXRole EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK = (com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK)empXLocationXRoleLocal.getPrimaryKey();
                    //-- get the value object for the EmpXLocationXRole EJB using the primary key
                    if (empXLocationXRolePK != null) {
                        EmpXLocationXRoleVO empXLocationXRoleVO = getEmpXLocationXRole(empXLocationXRolePK);
                        //-- add the value object to the collection
                        list.add(empXLocationXRoleVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEmpXLocationXRoleByLocationCd() method from EmpXLocationXRoleManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleByLocationCd() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEmployeeId objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByEmployeeId(String employeeId) {
        try {
            //-- gets the local home interface and call the findByEmployeeId method
            Collection empXLocationXRoleCol = getEmpXLocationXRoleLocalHome().findByEmployeeId(employeeId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (empXLocationXRoleCol != null && empXLocationXRoleCol.size() > 0) {
                Iterator it = empXLocationXRoleCol.iterator();
                while (it.hasNext()) {
                    EmpXLocationXRoleLocal empXLocationXRoleLocal = (EmpXLocationXRoleLocal) it.next();
                    //-- get the primary key of the EmpXLocationXRole EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK = (com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK)empXLocationXRoleLocal.getPrimaryKey();
                    //-- get the value object for the EmpXLocationXRole EJB using the primary key
                    if (empXLocationXRolePK != null) {
                        EmpXLocationXRoleVO empXLocationXRoleVO = getEmpXLocationXRole(empXLocationXRolePK);
                        //-- add the value object to the collection
                        list.add(empXLocationXRoleVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEmpXLocationXRoleByEmployeeId() method from EmpXLocationXRoleManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleByEmployeeId() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEmployeeAndLocation objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByEmployeeAndLocation(String employeeId, String locationCd) {
        try {
            //-- gets the local home interface and call the findByEmployeeAndLocation method
            Collection empXLocationXRoleCol = getEmpXLocationXRoleLocalHome().findByEmployeeAndLocation(employeeId, locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (empXLocationXRoleCol != null && empXLocationXRoleCol.size() > 0) {
                Iterator it = empXLocationXRoleCol.iterator();
                while (it.hasNext()) {
                    EmpXLocationXRoleLocal empXLocationXRoleLocal = (EmpXLocationXRoleLocal) it.next();
                    //-- get the primary key of the EmpXLocationXRole EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK = (com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK)empXLocationXRoleLocal.getPrimaryKey();
                    //-- get the value object for the EmpXLocationXRole EJB using the primary key
                    if (empXLocationXRolePK != null) {
                        EmpXLocationXRoleVO empXLocationXRoleVO = getEmpXLocationXRole(empXLocationXRolePK);
                        //-- add the value object to the collection
                        list.add(empXLocationXRoleVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEmpXLocationXRoleByEmployeeAndLocation() method from EmpXLocationXRoleManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleByEmployeeAndLocation() method from EmpXLocationXRoleManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the EmpXLocationXRole local home interface
     */
    private EmpXLocationXRoleLocalHome getEmpXLocationXRoleLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (EmpXLocationXRoleLocalHome) service.getEJBLocalHome(ServiceConstants.EMPXLOCATIONXROLE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmpXLocationXRoleLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
