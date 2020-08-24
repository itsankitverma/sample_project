/**
 * @(#)EmployeeManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class EmployeeManagerBean implements SessionBean {

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
     * This method create new Employee object
     * @param employeeVO a value object the Employee bean
     */
    public void setEmployee(EmployeeVO employeeVO)
        throws EmployeeException {
        //-- we do not accept null value for the parameter.
        if (employeeVO == null) {
            throw new IllegalArgumentException("employeeVO parameter was null in setEmployee() method from EmployeeManager class");
        }
        
        try {
            //-- create new Employee object
            getEmployeeLocalHome().create(
                employeeVO.getEmployeeId(),
                employeeVO.getEmployeeNm(),
                employeeVO.getPassword(),
                employeeVO.getEmail(),
                employeeVO.getDefaultPage(),
                employeeVO.getPwdDate(),
                employeeVO.getLocked(),
                employeeVO.getLginCntr());
                //,
                //employeeVO.getEmpStatusCd());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setEmployee() method from EmployeeManager class";
            throw new EmployeeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setEmployee() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Employee object
     * @return employeeVO - a value object of the Employee bean
     */
    public EmployeeVO getEmployee(String employeeId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in getEmployee() method from EmployeeManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            EmployeeLocal employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            //-- create new value object to store the data
            EmployeeVO employeeVO = new EmployeeVO();
            //-- populate the new value object
            employeeVO.setEmployeeId(employeeLocal.getEmployeeId());
            employeeVO.setEmployeeNm(employeeLocal.getEmployeeNm());
            employeeVO.setPassword(employeeLocal.getPassword());
            employeeVO.setEmail(employeeLocal.getEmail());
            employeeVO.setDefaultPage(employeeLocal.getDefaultPage());
            employeeVO.setPwdDate(employeeLocal.getPwdDate());
            employeeVO.setLocked(employeeLocal.getLocked());
            employeeVO.setLginCntr(employeeLocal.getLginCntr());
            employeeVO.setEmpLockTm(employeeLocal.getEmpLockTm());
            employeeVO.setEmpMailSent(employeeLocal.getEmpMailSent());
            employeeVO.setExtlCustFlg(employeeLocal.getExtlCustFlg());
            employeeVO.setEmpRvoDt(employeeLocal.getEmpRvoDt());
            employeeVO.setEmpStatusCd(employeeLocal.getEmpStatusCd());
            return employeeVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmployee() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets DepositSlip objects from the Employee object
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlips(String employeeId)
        throws EmployeeException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in getDepositSlips() method from EmployeeManager class");
        }
        
        try {
            EmployeeLocal employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            Set depositSlipCol = employeeLocal.getDepositSlips();
            Collection list = new ArrayList();
            if (depositSlipCol != null) {
                Iterator it = depositSlipCol.iterator();
                while (it.hasNext()) {
                    DepositSlipLocal depositSlipLocal = (DepositSlipLocal) it.next();
                    Integer depositSlipCd = (Integer)depositSlipLocal.getPrimaryKey();
                    DepositSlipVO depositSlipVO = getDepositSlipManager().getDepositSlip(depositSlipCd);
                    list.add(depositSlipVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getDepositSlips() method from EmployeeManager class";
            throw new EmployeeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepositSlips() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Location object to the Employee object
     * @param employeeId a primary key of Employee object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(String employeeId, String locationCd)
        throws EmployeeException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in addLocation() method from EmployeeManager class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addLocation() method from EmployeeManager class");
        }
        
        try {
            EmployeeLocal employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            employeeLocal.addLocation(locationLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addLocation() method from EmployeeManager class";
            throw new EmployeeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addLocation() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Location object to the Employee object
     * @param employeeId a primary key of Employee object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(String employeeId, String locationCd)
        throws EmployeeException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in removeLocation() method from EmployeeManager class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from EmployeeManager class");
        }
        
        try {
            EmployeeLocal employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            employeeLocal.removeLocation(locationLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removeLocation() method from EmployeeManager class";
            throw new EmployeeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeLocation() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets Location objects from the Employee object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(String employeeId)
        throws EmployeeException {
        //-- we do not accept null values for any parameters.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in getLocations() method from EmployeeManager class");
        }
        
        try {
            EmployeeLocal employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            Set locationCol = employeeLocal.getLocations();
            Collection list = new ArrayList();
            if (locationCol != null) {
                Iterator it = locationCol.iterator();
                while (it.hasNext()) {
                    LocationLocal locationLocal = (LocationLocal) it.next();
                    String locationCd = (String)locationLocal.getPrimaryKey();
                    LocationVO locationVO = getLocationManager().getLocation(locationCd);
                    list.add(locationVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getLocations() method from EmployeeManager class";
            throw new EmployeeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getLocations() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Employee object
     * @param employeeId - the Employee bean primary key
     */
    public void removeEmployee(String employeeId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId parameter was null in removeEmployee() method from EmployeeManager class");
        }
        
        try {
            getEmployeeLocalHome().remove(employeeId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeEmployee() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Employee object
     * @param employeeVO - the value object of the Employee bean
     */
    public void updateEmployee(EmployeeVO employeeVO)
        throws EmployeeException {
        //-- we do not accept null value for the parameter.
        if (employeeVO == null) {
            throw new IllegalArgumentException("employeeVO parameter was null in updateEmployee() method from EmployeeManager class");
        }
        
        try {
            String employeeId = employeeVO.getEmployeeId();
            
            EmployeeLocal employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            //-- update Employee entity bean
            employeeLocal.setEmployeeNm(employeeVO.getEmployeeNm());
            employeeLocal.setPassword(employeeVO.getPassword());
            employeeLocal.setEmail(employeeVO.getEmail());
            employeeLocal.setDefaultPage(employeeVO.getDefaultPage());
            employeeLocal.setPwdDate(employeeVO.getPwdDate());
            employeeLocal.setLocked(employeeVO.getLocked());
            employeeLocal.setLginCntr(employeeVO.getLginCntr());
            employeeLocal.setEmpLockTm(employeeVO.getEmpLockTm());
            employeeLocal.setEmpMailSent(employeeVO.getEmpMailSent());
            employeeLocal.setExtlCustFlg(employeeVO.getExtlCustFlg());
            employeeLocal.setEmpRvoDt(employeeVO.getEmpRvoDt());
            employeeLocal.setEmpStatusCd(employeeVO.getEmpStatusCd());

            /*
            System.out.println("updateEmployee " + employeeVO.getEmployeeNm());
            System.out.println("updateEmployee " + employeeVO.getPassword());
            System.out.println("updateEmployee " + employeeVO.getEmail());
            System.out.println("updateEmployee " + employeeVO.getDefaultPage());
            System.out.println("updateEmployee " + employeeVO.getPwdDate());
            System.out.println("updateEmployee " + employeeVO.getLocked());
            System.out.println("updateEmployee " + employeeVO.getLginCntr());
            System.out.println("updateEmployee " + employeeVO.getEmpLockTm());
            System.out.println("updateEmployee " + employeeVO.getEmpMailSent());
            System.out.println("updateEmployee " + employeeVO.getExtlCustFlg());
            System.out.println("updateEmployee " + employeeVO.getEmpRvoDt());
            System.out.println("updateEmployee " + employeeVO.getEmpStatusCd());
            */
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateEmployee() method from EmployeeManager class";
            throw new EmployeeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateEmployee() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllEmployees objects
     * @return Collection - a collection of the Employee objects
     */
    public Collection getAllEmployees() {
        try {
        	System.out.println("in getAllEmployees sep 9999!");
            //-- gets the local home interface and call the findAllEmployees method
            Collection employeeCol = getEmployeeLocalHome().findAllEmployees();
            //Collection employeeCol = getEmployeeLocalHome().findAdminEmployees();
            //Collection employeeCol = getEmployeeLocalHome().findAllEmployeesNew();
            
            System.out.println("in getAllEmployees 22222 ");
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            System.out.println("in getAllEmployees 3333 ");
            if (employeeCol != null && employeeCol.size() > 0) {
            	System.out.println("in getAllEmployees 44444 ");
                Iterator it = employeeCol.iterator();
                while (it.hasNext()) {
                    EmployeeLocal employeeLocal = (EmployeeLocal) it.next();
                    //-- get the primary key of the Employee EJB object
                    String employeeId = (String)employeeLocal.getPrimaryKey();
                    //-- get the value object for the Employee EJB using the primary key
                    if (employeeId != null) {
                        EmployeeVO employeeVO = getEmployee(employeeId);
                        //-- add the value object to the collection
                        list.add(employeeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllEmployees() method from EmployeeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllEmployees() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAdminEmployees objects
     * @return Collection - a collection of the Employee objects
     */
    public Collection getEmployeeAdminEmployees() {
        try {
            //-- gets the local home interface and call the findAdminEmployees method
            Collection employeeCol = getEmployeeLocalHome().findAdminEmployees();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (employeeCol != null && employeeCol.size() > 0) {
                Iterator it = employeeCol.iterator();
                while (it.hasNext()) {
                    EmployeeLocal employeeLocal = (EmployeeLocal) it.next();
                    //-- get the primary key of the Employee EJB object
                    String employeeId = (String)employeeLocal.getPrimaryKey();
                    //-- get the value object for the Employee EJB using the primary key
                    if (employeeId != null) {
                        EmployeeVO employeeVO = getEmployee(employeeId);
                        //-- add the value object to the collection
                        list.add(employeeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEmployeeAdminEmployees() method from EmployeeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmployeeAdminEmployees() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findCountryAdminEmployees objects
     * @return Collection - a collection of the Employee objects
     */
    public Collection getEmployeeCountryAdminEmployees(String countryCd) {
        try {
            //-- gets the local home interface and call the findCountryAdminEmployees method
            Collection employeeCol = getEmployeeLocalHome().findCountryAdminEmployees(countryCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (employeeCol != null && employeeCol.size() > 0) {
                Iterator it = employeeCol.iterator();
                while (it.hasNext()) {
                    EmployeeLocal employeeLocal = (EmployeeLocal) it.next();
                    //-- get the primary key of the Employee EJB object
                    String employeeId = (String)employeeLocal.getPrimaryKey();
                    //-- get the value object for the Employee EJB using the primary key
                    if (employeeId != null) {
                        EmployeeVO employeeVO = getEmployee(employeeId);
                        //-- add the value object to the collection
                        list.add(employeeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEmployeeCountryAdminEmployees() method from EmployeeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEmployeeCountryAdminEmployees() method from EmployeeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Employee local home interface
     */
    private EmployeeLocalHome getEmployeeLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (EmployeeLocalHome) service.getEJBLocalHome(ServiceConstants.EMPLOYEE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Location local home interface
     */
    private LocationLocalHome getLocationLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (LocationLocalHome) service.getEJBLocalHome(ServiceConstants.LOCATION_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the DepositSlipManager remote interface
     */
    public DepositSlipManager getDepositSlipManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            DepositSlipManagerHome depositSlipManagerHome = (DepositSlipManagerHome)
            service.getEJBHome(ServiceConstants.DEPOSITSLIPMANAGER_REMOTE_JNDI, DepositSlipManagerHome.class);
            return depositSlipManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the LocationManager remote interface
     */
    public LocationManager getLocationManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            LocationManagerHome locationManagerHome = (LocationManagerHome)
            service.getEJBHome(ServiceConstants.LOCATIONMANAGER_REMOTE_JNDI, LocationManagerHome.class);
            return locationManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
