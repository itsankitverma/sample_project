/**
 * @(#)TasksManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class TasksManagerBean implements SessionBean {

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
     * This method create new Tasks object
     * @param tasksVO a value object the Tasks bean
     */
    public void setTasks(TasksVO tasksVO)
        throws TasksException {
        //-- we do not accept null value for the parameter.
        if (tasksVO == null) {
            throw new IllegalArgumentException("tasksVO parameter was null in setTasks() method from TasksManager class");
        }
        
        try {
            
            //-- create new Tasks object
            getTasksLocalHome().create(
                tasksVO.getLocationCd(),
                tasksVO.getTaskTypeCd(),
                tasksVO.getEmailWarning(),
                tasksVO.getRunSun(),
                tasksVO.getRunSunTime(),
                tasksVO.getRunMon(),
                tasksVO.getRunMonTime(),
                tasksVO.getRunTue(),
                tasksVO.getRunTueTime(),
                tasksVO.getRunWed(),
                tasksVO.getRunWedTime(),
                tasksVO.getRunThu(),
                tasksVO.getRunThuTime(),
                tasksVO.getRunFri(),
                tasksVO.getRunFriTime(),
                tasksVO.getRunSat(),
                tasksVO.getRunSatTime());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setTasks() method from TasksManager class";
            throw new TasksException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setTasks() method from TasksManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Tasks object
     * @return tasksVO - a value object of the Tasks bean
     */
    public TasksVO getTasks(Integer tasksId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (tasksId == null) {
            throw new IllegalArgumentException("tasksId parameter was null in getTasks() method from TasksManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            TasksLocal tasksLocal = getTasksLocalHome().findByPrimaryKey(tasksId);
            //-- create new value object to store the data
            TasksVO tasksVO = new TasksVO();
            //-- populate the new value object
            tasksVO.setTasksId(tasksLocal.getTasksId());
            tasksVO.setLocationCd(tasksLocal.getLocationCd());
            tasksVO.setTaskTypeCd(tasksLocal.getTaskTypeCd());
            tasksVO.setEmailWarning(tasksLocal.getEmailWarning());
            tasksVO.setRunSun(tasksLocal.getRunSun());
            tasksVO.setRunSunTime(tasksLocal.getRunSunTime());
            tasksVO.setRunMon(tasksLocal.getRunMon());
            tasksVO.setRunMonTime(tasksLocal.getRunMonTime());
            tasksVO.setRunTue(tasksLocal.getRunTue());
            tasksVO.setRunTueTime(tasksLocal.getRunTueTime());
            tasksVO.setRunWed(tasksLocal.getRunWed());
            tasksVO.setRunWedTime(tasksLocal.getRunWedTime());
            tasksVO.setRunThu(tasksLocal.getRunThu());
            tasksVO.setRunThuTime(tasksLocal.getRunThuTime());
            tasksVO.setRunFri(tasksLocal.getRunFri());
            tasksVO.setRunFriTime(tasksLocal.getRunFriTime());
            tasksVO.setRunSat(tasksLocal.getRunSat());
            tasksVO.setRunSatTime(tasksLocal.getRunSatTime());
            return tasksVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getTasks() method from TasksManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Tasks object
     * @param tasksId - the Tasks bean primary key
     */
    public void removeTasks(Integer tasksId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (tasksId == null) {
            throw new IllegalArgumentException("tasksId parameter was null in removeTasks() method from TasksManager class");
        }
        
        try {
            getTasksLocalHome().remove(tasksId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeTasks() method from TasksManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Tasks object
     * @param tasksVO - the value object of the Tasks bean
     */
    public void updateTasks(TasksVO tasksVO)
        throws TasksException {
        //-- we do not accept null value for the parameter.
        if (tasksVO == null) {
            throw new IllegalArgumentException("tasksVO parameter was null in updateTasks() method from TasksManager class");
        }
        
        try {
            Integer tasksId = tasksVO.getTasksId();
            
            TasksLocal tasksLocal = getTasksLocalHome().findByPrimaryKey(tasksId);
            //-- update Tasks entity bean
            tasksLocal.setLocationCd(tasksVO.getLocationCd());
            tasksLocal.setTaskTypeCd(tasksVO.getTaskTypeCd());
            tasksLocal.setEmailWarning(tasksVO.getEmailWarning());
            tasksLocal.setRunSun(tasksVO.getRunSun());
            tasksLocal.setRunSunTime(tasksVO.getRunSunTime());
            tasksLocal.setRunMon(tasksVO.getRunMon());
            tasksLocal.setRunMonTime(tasksVO.getRunMonTime());
            tasksLocal.setRunTue(tasksVO.getRunTue());
            tasksLocal.setRunTueTime(tasksVO.getRunTueTime());
            tasksLocal.setRunWed(tasksVO.getRunWed());
            tasksLocal.setRunWedTime(tasksVO.getRunWedTime());
            tasksLocal.setRunThu(tasksVO.getRunThu());
            tasksLocal.setRunThuTime(tasksVO.getRunThuTime());
            tasksLocal.setRunFri(tasksVO.getRunFri());
            tasksLocal.setRunFriTime(tasksVO.getRunFriTime());
            tasksLocal.setRunSat(tasksVO.getRunSat());
            tasksLocal.setRunSatTime(tasksVO.getRunSatTime());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateTasks() method from TasksManager class";
            throw new TasksException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateTasks() method from TasksManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllTasks objects
     * @return Collection - a collection of the Tasks objects
     */
    public Collection getAllTasks() {
        try {
            //-- gets the local home interface and call the findAllTasks method
            Collection tasksCol = getTasksLocalHome().findAllTasks();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (tasksCol != null && tasksCol.size() > 0) {
                Iterator it = tasksCol.iterator();
                while (it.hasNext()) {
                    TasksLocal tasksLocal = (TasksLocal) it.next();
                    //-- get the primary key of the Tasks EJB object
                    Integer tasksId = (Integer)tasksLocal.getPrimaryKey();
                    //-- get the value object for the Tasks EJB using the primary key
                    if (tasksId != null) {
                        TasksVO tasksVO = getTasks(tasksId);
                        //-- add the value object to the collection
                        list.add(tasksVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllTasks() method from TasksManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllTasks() method from TasksManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Tasks local home interface
     */
    private TasksLocalHome getTasksLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (TasksLocalHome) service.getEJBLocalHome(ServiceConstants.TASKS_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getTasksLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
