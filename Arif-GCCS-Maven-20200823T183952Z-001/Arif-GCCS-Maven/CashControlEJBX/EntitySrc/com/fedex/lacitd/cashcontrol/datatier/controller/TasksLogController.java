/**
 * @(#)TasksLogController.java			Tue Aug 02 15:38:53 VET 2005
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

public class TasksLogController {

    /**
     * This method create new TasksLog object
     * @param tasksLogVO a value object the TasksLog bean
     */
    public void setTasksLog(TasksLogVO tasksLogVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (tasksLogVO == null) {
            throw new IllegalArgumentException("tasksLogVO parameter was null in setTasksLog() method from TasksLogController class");
        }
        
        try {
            getTasksLogManager().setTasksLog(tasksLogVO);
        }
        catch (TasksLogException ex) {
            String errorMsg = "Error occurred in setTasksLog() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setTasksLog() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a TasksLog object
     * @return tasksLogVO - a value object of the TasksLog bean
     */
    public TasksLogVO getTasksLog(Integer tasksLogId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (tasksLogId == null) {
            throw new IllegalArgumentException("tasksLogId parameter was null in getTasksLog() method from TasksLogController class");
        }
        
        try {
            return getTasksLogManager().getTasksLog(tasksLogId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getTasksLog() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getTasksLog() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllTasksLogs objects
     * @return java.util.Collection - a collection of the TasksLog objects
     */
    public Collection getAllTasksLogs()
        throws BusinessDelegateException {
        try {
            return getTasksLogManager().getAllTasksLogs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllTasksLogs() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing TasksLog object
     * @param tasksLogId - the TasksLog bean primary key
     */
    public void removeTasksLog(Integer tasksLogId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (tasksLogId == null) {
            throw new IllegalArgumentException("tasksLogId parameter was null in removeTasksLog() method from TasksLogController class");
        }
        
        try {
            getTasksLogManager().removeTasksLog(tasksLogId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeTasksLog() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeTasksLog() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing TasksLog object
     * @param tasksLogVO - the value object of the TasksLog bean
     */
    public void updateTasksLog(TasksLogVO tasksLogVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (tasksLogVO == null) {
            throw new IllegalArgumentException("tasksLogVO parameter was null in updateTasksLog() method from TasksLogController class");
        }
        
        try {
            getTasksLogManager().updateTasksLog(tasksLogVO);
        }
        catch (TasksLogException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateTasksLog() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateTasksLog() method from TasksLogController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the TasksLogManager remote interface
     */
    public TasksLogManager getTasksLogManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            TasksLogManagerHome tasksLogManagerHome = (TasksLogManagerHome)
            service.getEJBHome(ServiceConstants.TASKSLOGMANAGER_JNDI, TasksLogManagerHome.class);
            return tasksLogManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getTasksLogManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getTasksLogManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getTasksLogManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
