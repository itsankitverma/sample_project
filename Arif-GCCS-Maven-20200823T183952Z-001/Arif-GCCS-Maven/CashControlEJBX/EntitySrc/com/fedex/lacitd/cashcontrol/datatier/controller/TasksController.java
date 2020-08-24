/**
 * @(#)TasksController.java			Tue Aug 02 15:38:53 VET 2005
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

public class TasksController {

    /**
     * This method create new Tasks object
     * @param tasksVO a value object the Tasks bean
     */
    public void setTasks(TasksVO tasksVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (tasksVO == null) {
            throw new IllegalArgumentException("tasksVO parameter was null in setTasks() method from TasksController class");
        }
        
        try {
            getTasksManager().setTasks(tasksVO);
        }
        catch (TasksException ex) {
            String errorMsg = "Error occurred in setTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Tasks object
     * @return tasksVO - a value object of the Tasks bean
     */
    public TasksVO getTasks(Integer tasksId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (tasksId == null) {
            throw new IllegalArgumentException("tasksId parameter was null in getTasks() method from TasksController class");
        }
        
        try {
            return getTasksManager().getTasks(tasksId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllTasks objects
     * @return java.util.Collection - a collection of the Tasks objects
     */
    public Collection getAllTasks()
        throws BusinessDelegateException {
        try {
            return getTasksManager().getAllTasks();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Tasks object
     * @param tasksId - the Tasks bean primary key
     */
    public void removeTasks(Integer tasksId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (tasksId == null) {
            throw new IllegalArgumentException("tasksId parameter was null in removeTasks() method from TasksController class");
        }
        
        try {
            getTasksManager().removeTasks(tasksId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Tasks object
     * @param tasksVO - the value object of the Tasks bean
     */
    public void updateTasks(TasksVO tasksVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (tasksVO == null) {
            throw new IllegalArgumentException("tasksVO parameter was null in updateTasks() method from TasksController class");
        }
        
        try {
            getTasksManager().updateTasks(tasksVO);
        }
        catch (TasksException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateTasks() method from TasksController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the TasksManager remote interface
     */
    public TasksManager getTasksManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            TasksManagerHome tasksManagerHome = (TasksManagerHome)
            service.getEJBHome(ServiceConstants.TASKSMANAGER_JNDI, TasksManagerHome.class);
            return tasksManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getTasksManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getTasksManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getTasksManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
