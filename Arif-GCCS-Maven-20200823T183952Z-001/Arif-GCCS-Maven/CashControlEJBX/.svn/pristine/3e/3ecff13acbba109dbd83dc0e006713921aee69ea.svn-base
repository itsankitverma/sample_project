/**
 * @(#)TasksLogVO.java			Tue Aug 02 15:38:50 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class TasksLogVO implements java.io.Serializable {

    private Integer _tasksLogId;
    private int _tasksId;
    private Date _runDt;
    private int _result;
    private String _message;
    public TasksLogVO() {
    }
    public TasksLogVO(Integer tasksLogId, int tasksId, Date runDt, int result, String message) {
        _tasksLogId = tasksLogId;
        _tasksId = tasksId;
        _runDt = runDt;
        _result = result;
        _message = message;
    }
    /**
     * Set the value of tasksLogId
     */
    public void setTasksLogId(Integer tasksLogId) {
        _tasksLogId = tasksLogId;
    }

    /**
     * Get the value of tasksLogId
     */
    public Integer getTasksLogId() {
        return _tasksLogId;
    }

    /**
     * Set the value of tasksId
     */
    public void setTasksId(int tasksId) {
        _tasksId = tasksId;
    }

    /**
     * Get the value of tasksId
     */
    public int getTasksId() {
        return _tasksId;
    }

    /**
     * Set the value of runDt
     */
    public void setRunDt(Date runDt) {
        _runDt = runDt;
    }

    /**
     * Get the value of runDt
     */
    public Date getRunDt() {
        return _runDt;
    }

    /**
     * Set the value of result
     */
    public void setResult(int result) {
        _result = result;
    }

    /**
     * Get the value of result
     */
    public int getResult() {
        return _result;
    }

    /**
     * Set the value of message
     */
    public void setMessage(String message) {
        _message = message;
    }

    /**
     * Get the value of message
     */
    public String getMessage() {
        return _message;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getTasksLogPK() {
        return _tasksLogId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TasksLogId: " + _tasksLogId);
        stringBuffer.append("TasksId: " + _tasksId);
        stringBuffer.append("RunDt: " + _runDt);
        stringBuffer.append("Result: " + _result);
        stringBuffer.append("Message: " + _message);
        return stringBuffer.toString();
    }

}
