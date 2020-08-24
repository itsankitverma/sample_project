/**
 * @(#)TasksLogBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the tasks_log table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class TasksLogBean implements EntityBean {

    private EntityContext _ctx;
    public TasksLogBean() {
    }
    /**
     * Set the value of tasksLogId
     * @param tasksLogId - Integer of tasksLogId
     */
    public abstract void setTasksLogId(Integer tasksLogId);

    /**
     * Get the value of tasksLogId
     * @return tasksLogId - Integer of tasksLogId
     */
    public abstract Integer getTasksLogId();

    /**
     * Set the value of tasksId
     * @param tasksId - int of tasksId
     */
    public abstract void setTasksId(int tasksId);

    /**
     * Get the value of tasksId
     * @return tasksId - int of tasksId
     */
    public abstract int getTasksId();

    /**
     * Set the value of runDt
     * @param runDt - Date of runDt
     */
    public abstract void setRunDt(Date runDt);

    /**
     * Get the value of runDt
     * @return runDt - Date of runDt
     */
    public abstract Date getRunDt();

    /**
     * Set the value of result
     * @param result - int of result
     */
    public abstract void setResult(int result);

    /**
     * Get the value of result
     * @return result - int of result
     */
    public abstract int getResult();

    /**
     * Set the value of message
     * @param message - String of message
     */
    public abstract void setMessage(String message);

    /**
     * Get the value of message
     * @return message - String of message
     */
    public abstract String getMessage();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(int tasksId, Date runDt, int result, String message)
        throws CreateException {
        setTasksId(tasksId);
        setRunDt(runDt);
        setResult(result);
        setMessage(message);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(int tasksId, Date runDt, int result, String message)
        throws CreateException {
    }

    /**
     * Called by Container.  Associates this Bean instance with a particular context environment.
     */
    public void setEntityContext(EntityContext ctx) {
        _ctx = ctx;
    }

    /**
     * Called by Container.  Disassociates this Bean instance with a particular 
     * context.  Once done, we can query the Context for environment information
     */
    public void unsetEntityContext() {
        _ctx = null;
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
     * Called by Container.  Updates the entity bean instance to reflect 
     * the current value stored in the database.
     */
    public void ejbLoad() {
    }

    /**
     * Called by Container.  Updates the database to reflect the current values 
     * of this in-memory Entity Bean instance representation.
     */
    public void ejbStore() {
    }

    /**
     * EJB Container calls this method right before it remove the Entity bean 
     * from the database.  Corresponds to when client calls home.remove().
     */
    public void ejbRemove() {
    }

}
