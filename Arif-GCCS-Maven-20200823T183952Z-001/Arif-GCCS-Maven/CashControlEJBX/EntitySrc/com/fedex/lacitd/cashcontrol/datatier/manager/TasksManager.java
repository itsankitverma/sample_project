/**
 * @(#)TasksManager.java			Tue Aug 02 15:38:51 VET 2005
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

public interface TasksManager extends EJBObject {

    /**
     * This method create new Tasks object
     * @param tasksVO a value object the Tasks bean
     */
    public void setTasks(TasksVO tasksVO)
        throws RemoteException, TasksException;

    /**
     * This method gets a Tasks object
     * @param tasksId - the Tasks bean primary key
     * @return tasksVO - a value object of the Tasks bean
     */
    public TasksVO getTasks(Integer tasksId)
        throws RemoteException, FinderException;

    /**
     * This method removes an existing Tasks object
     * @param tasksId - the Tasks bean primary key
     */
    public void removeTasks(Integer tasksId)
        throws RemoteException, RemoveException;

    /**
     * This method updates an existing Tasks object
     * @param tasksVO - the value object of the Tasks bean
     */
    public void updateTasks(TasksVO tasksVO)
        throws RemoteException, TasksException;

    /**
     * This method gets findAllTasks objects
     * @return Collection - a collection of the Tasks objects
     */
    public Collection getAllTasks()
        throws RemoteException;

}
