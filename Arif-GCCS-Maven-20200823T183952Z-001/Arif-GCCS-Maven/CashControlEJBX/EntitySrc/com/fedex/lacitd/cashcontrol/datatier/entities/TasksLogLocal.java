/**
 * @(#)TasksLogLocal.java			Tue Aug 02 15:38:49 VET 2005
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

public interface TasksLogLocal extends EJBLocalObject {

    /**
     * Set the value of tasksLogId
     * @param tasksLogId - Integer of tasksLogId
     */
    public void setTasksLogId(Integer tasksLogId);

    /**
     * Get the value of tasksLogId
     * @return tasksLogId - Integer of tasksLogId
     */
    public Integer getTasksLogId();

    /**
     * Set the value of tasksId
     * @param tasksId - int of tasksId
     */
    public void setTasksId(int tasksId);

    /**
     * Get the value of tasksId
     * @return tasksId - int of tasksId
     */
    public int getTasksId();

    /**
     * Set the value of runDt
     * @param runDt - Date of runDt
     */
    public void setRunDt(Date runDt);

    /**
     * Get the value of runDt
     * @return runDt - Date of runDt
     */
    public Date getRunDt();

    /**
     * Set the value of result
     * @param result - int of result
     */
    public void setResult(int result);

    /**
     * Get the value of result
     * @return result - int of result
     */
    public int getResult();

    /**
     * Set the value of message
     * @param message - String of message
     */
    public void setMessage(String message);

    /**
     * Get the value of message
     * @return message - String of message
     */
    public String getMessage();

}
