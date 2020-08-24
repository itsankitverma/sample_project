/**
 * @(#)TasksLogManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class TasksLogManagerBean implements SessionBean {

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
     * This method create new TasksLog object
     * @param tasksLogVO a value object the TasksLog bean
     */
    public void setTasksLog(TasksLogVO tasksLogVO)
        throws TasksLogException {
        //-- we do not accept null value for the parameter.
        if (tasksLogVO == null) {
            throw new IllegalArgumentException("tasksLogVO parameter was null in setTasksLog() method from TasksLogManager class");
        }
        
        try {
            
            //-- create new TasksLog object
            getTasksLogLocalHome().create(
                tasksLogVO.getTasksId(),
                tasksLogVO.getRunDt(),
                tasksLogVO.getResult(),
                tasksLogVO.getMessage());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setTasksLog() method from TasksLogManager class";
            throw new TasksLogException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setTasksLog() method from TasksLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a TasksLog object
     * @return tasksLogVO - a value object of the TasksLog bean
     */
    public TasksLogVO getTasksLog(Integer tasksLogId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (tasksLogId == null) {
            throw new IllegalArgumentException("tasksLogId parameter was null in getTasksLog() method from TasksLogManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            TasksLogLocal tasksLogLocal = getTasksLogLocalHome().findByPrimaryKey(tasksLogId);
            //-- create new value object to store the data
            TasksLogVO tasksLogVO = new TasksLogVO();
            //-- populate the new value object
            tasksLogVO.setTasksLogId(tasksLogLocal.getTasksLogId());
            tasksLogVO.setTasksId(tasksLogLocal.getTasksId());
            tasksLogVO.setRunDt(tasksLogLocal.getRunDt());
            tasksLogVO.setResult(tasksLogLocal.getResult());
            tasksLogVO.setMessage(tasksLogLocal.getMessage());
            return tasksLogVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getTasksLog() method from TasksLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing TasksLog object
     * @param tasksLogId - the TasksLog bean primary key
     */
    public void removeTasksLog(Integer tasksLogId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (tasksLogId == null) {
            throw new IllegalArgumentException("tasksLogId parameter was null in removeTasksLog() method from TasksLogManager class");
        }
        
        try {
            getTasksLogLocalHome().remove(tasksLogId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeTasksLog() method from TasksLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing TasksLog object
     * @param tasksLogVO - the value object of the TasksLog bean
     */
    public void updateTasksLog(TasksLogVO tasksLogVO)
        throws TasksLogException {
        //-- we do not accept null value for the parameter.
        if (tasksLogVO == null) {
            throw new IllegalArgumentException("tasksLogVO parameter was null in updateTasksLog() method from TasksLogManager class");
        }
        
        try {
            Integer tasksLogId = tasksLogVO.getTasksLogId();
            
            TasksLogLocal tasksLogLocal = getTasksLogLocalHome().findByPrimaryKey(tasksLogId);
            //-- update TasksLog entity bean
            tasksLogLocal.setTasksId(tasksLogVO.getTasksId());
            tasksLogLocal.setRunDt(tasksLogVO.getRunDt());
            tasksLogLocal.setResult(tasksLogVO.getResult());
            tasksLogLocal.setMessage(tasksLogVO.getMessage());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateTasksLog() method from TasksLogManager class";
            throw new TasksLogException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateTasksLog() method from TasksLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllTasksLogs objects
     * @return Collection - a collection of the TasksLog objects
     */
    public Collection getAllTasksLogs() {
        try {
            //-- gets the local home interface and call the findAllTasksLogs method
            Collection tasksLogCol = getTasksLogLocalHome().findAllTasksLogs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (tasksLogCol != null && tasksLogCol.size() > 0) {
                Iterator it = tasksLogCol.iterator();
                while (it.hasNext()) {
                    TasksLogLocal tasksLogLocal = (TasksLogLocal) it.next();
                    //-- get the primary key of the TasksLog EJB object
                    Integer tasksLogId = (Integer)tasksLogLocal.getPrimaryKey();
                    //-- get the value object for the TasksLog EJB using the primary key
                    if (tasksLogId != null) {
                        TasksLogVO tasksLogVO = getTasksLog(tasksLogId);
                        //-- add the value object to the collection
                        list.add(tasksLogVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllTasksLogs() method from TasksLogManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllTasksLogs() method from TasksLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the TasksLog local home interface
     */
    private TasksLogLocalHome getTasksLogLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (TasksLogLocalHome) service.getEJBLocalHome(ServiceConstants.TASKSLOG_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getTasksLogLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
