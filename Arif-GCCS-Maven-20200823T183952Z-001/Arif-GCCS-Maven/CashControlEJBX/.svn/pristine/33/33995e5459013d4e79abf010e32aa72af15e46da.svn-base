/**
 * @(#)TasksLogManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface TasksLogManager extends EJBObject {

    /**
     * This method create new TasksLog object
     * @param tasksLogVO a value object the TasksLog bean
     */
    public void setTasksLog(TasksLogVO tasksLogVO)
        throws RemoteException, TasksLogException;

    /**
     * This method gets a TasksLog object
     * @param tasksLogId - the TasksLog bean primary key
     * @return tasksLogVO - a value object of the TasksLog bean
     */
    public TasksLogVO getTasksLog(Integer tasksLogId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing TasksLog object
     * @param tasksLogId - the TasksLog bean primary key
     */
    public void removeTasksLog(Integer tasksLogId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing TasksLog object
     * @param tasksLogVO - the value object of the TasksLog bean
     */
    public void updateTasksLog(TasksLogVO tasksLogVO)
        throws RemoteException, TasksLogException;

    /**
     * This method gets findAllTasksLogs objects
     * @return Collection - a collection of the TasksLog objects
     */
    public Collection getAllTasksLogs()
        throws RemoteException;

}
