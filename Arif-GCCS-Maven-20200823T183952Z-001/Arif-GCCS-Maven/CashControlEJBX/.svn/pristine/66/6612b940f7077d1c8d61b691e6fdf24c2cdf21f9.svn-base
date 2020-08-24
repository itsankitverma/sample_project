/**
 * @(#)EmployeeClearingManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class EmployeeClearingManagerBean implements SessionBean {

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
     * This method create new EmployeeClearing object
     * @param employeeClearingVO a value object the EmployeeClearing bean
     */
    public void setEmployeeClearing(EmployeeClearingVO employeeClearingVO)
        throws EmployeeClearingException {
        //-- we do not accept null value for the parameter.
        if (employeeClearingVO == null) {
            throw new IllegalArgumentException("employeeClearingVO parameter was null in setEmployeeClearing() method from EmployeeClearingManager class");
        }
        
        try {
            
            //-- create new EmployeeClearing object
            getEmployeeClearingLocalHome().create(
                employeeClearingVO.getEmployeeId(),
                employeeClearingVO.getEmpClearDt(),
                employeeClearingVO.getEmpClearStatus());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setEmployeeClearing() method from EmployeeClearingManager class";
            throw new EmployeeClearingException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setEmployeeClearing() method from EmployeeClearingManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a EmployeeClearing object
     * @return employeeClearingVO - a value object of the EmployeeClearing bean
     */
    public EmployeeClearingVO getEmployeeClearing(com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK employeeClearingPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (employeeClearingPK == null) {
            throw new IllegalArgumentException("employeeClearingPK parameter was null in getEmployeeClearing() method from EmployeeClearingManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            EmployeeClearingLocal employeeClearingLocal = getEmployeeClearingLocalHome().findByPrimaryKey(employeeClearingPK);
            //-- create new value object to store the data
            EmployeeClearingVO employeeClearingVO = new EmployeeClearingVO();
            //-- populate the new value object
            employeeClearingVO.setEmployeeId(employeeClearingLocal.getEmployeeId());
            employeeClearingVO.setEmpClearDt(employeeClearingLocal.getEmpClearDt());
            employeeClearingVO.setEmpClearStatus(employeeClearingLocal.getEmpClearStatus());
            return employeeClearingVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmployeeClearing() method from EmployeeClearingManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing EmployeeClearing object
     * @param employeeClearingPK - the EmployeeClearing bean primary key
     */
    public void removeEmployeeClearing(com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK employeeClearingPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (employeeClearingPK == null) {
            throw new IllegalArgumentException("employeeClearingPK parameter was null in removeEmployeeClearing() method from EmployeeClearingManager class");
        }
        
        try {
            getEmployeeClearingLocalHome().remove(employeeClearingPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeEmployeeClearing() method from EmployeeClearingManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing EmployeeClearing object
     * @param employeeClearingVO - the value object of the EmployeeClearing bean
     */
    public void updateEmployeeClearing(EmployeeClearingVO employeeClearingVO)
        throws EmployeeClearingException {
        //-- we do not accept null value for the parameter.
        if (employeeClearingVO == null) {
            throw new IllegalArgumentException("employeeClearingVO parameter was null in updateEmployeeClearing() method from EmployeeClearingManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK employeeClearingPK = employeeClearingVO.getEmployeeClearingPK();
            
            EmployeeClearingLocal employeeClearingLocal = getEmployeeClearingLocalHome().findByPrimaryKey(employeeClearingPK);
            //-- update EmployeeClearing entity bean
            employeeClearingLocal.setEmpClearStatus(employeeClearingVO.getEmpClearStatus());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateEmployeeClearing() method from EmployeeClearingManager class";
            throw new EmployeeClearingException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateEmployeeClearing() method from EmployeeClearingManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllEmployeeClearings objects
     * @return Collection - a collection of the EmployeeClearing objects
     */
    public Collection getAllEmployeeClearings() {
        try {
            //-- gets the local home interface and call the findAllEmployeeClearings method
            Collection employeeClearingCol = getEmployeeClearingLocalHome().findAllEmployeeClearings();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (employeeClearingCol != null && employeeClearingCol.size() > 0) {
                Iterator it = employeeClearingCol.iterator();
                while (it.hasNext()) {
                    EmployeeClearingLocal employeeClearingLocal = (EmployeeClearingLocal) it.next();
                    //-- get the primary key of the EmployeeClearing EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK employeeClearingPK = (com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK)employeeClearingLocal.getPrimaryKey();
                    //-- get the value object for the EmployeeClearing EJB using the primary key
                    if (employeeClearingPK != null) {
                        EmployeeClearingVO employeeClearingVO = getEmployeeClearing(employeeClearingPK);
                        //-- add the value object to the collection
                        list.add(employeeClearingVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllEmployeeClearings() method from EmployeeClearingManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllEmployeeClearings() method from EmployeeClearingManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the EmployeeClearing local home interface
     */
    private EmployeeClearingLocalHome getEmployeeClearingLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (EmployeeClearingLocalHome) service.getEJBLocalHome(ServiceConstants.EMPLOYEECLEARING_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeClearingLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
