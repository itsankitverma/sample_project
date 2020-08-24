/**
 * @(#)TasksBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the tasks table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class TasksBean implements EntityBean {

    private EntityContext _ctx;
    public TasksBean() {
    }
    /**
     * Set the value of tasksId
     * @param tasksId - Integer of tasksId
     */
    public abstract void setTasksId(Integer tasksId);

    /**
     * Get the value of tasksId
     * @return tasksId - Integer of tasksId
     */
    public abstract Integer getTasksId();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public abstract void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public abstract String getLocationCd();

    /**
     * Set the value of taskTypeCd
     * @param taskTypeCd - int of taskTypeCd
     */
    public abstract void setTaskTypeCd(int taskTypeCd);

    /**
     * Get the value of taskTypeCd
     * @return taskTypeCd - int of taskTypeCd
     */
    public abstract int getTaskTypeCd();

    /**
     * Set the value of emailWarning
     * @param emailWarning - String of emailWarning
     */
    public abstract void setEmailWarning(String emailWarning);

    /**
     * Get the value of emailWarning
     * @return emailWarning - String of emailWarning
     */
    public abstract String getEmailWarning();

    /**
     * Set the value of runSun
     * @param runSun - int of runSun
     */
    public abstract void setRunSun(int runSun);

    /**
     * Get the value of runSun
     * @return runSun - int of runSun
     */
    public abstract int getRunSun();

    /**
     * Set the value of runSunTime
     * @param runSunTime - String of runSunTime
     */
    public abstract void setRunSunTime(String runSunTime);

    /**
     * Get the value of runSunTime
     * @return runSunTime - String of runSunTime
     */
    public abstract String getRunSunTime();

    /**
     * Set the value of runMon
     * @param runMon - int of runMon
     */
    public abstract void setRunMon(int runMon);

    /**
     * Get the value of runMon
     * @return runMon - int of runMon
     */
    public abstract int getRunMon();

    /**
     * Set the value of runMonTime
     * @param runMonTime - String of runMonTime
     */
    public abstract void setRunMonTime(String runMonTime);

    /**
     * Get the value of runMonTime
     * @return runMonTime - String of runMonTime
     */
    public abstract String getRunMonTime();

    /**
     * Set the value of runTue
     * @param runTue - int of runTue
     */
    public abstract void setRunTue(int runTue);

    /**
     * Get the value of runTue
     * @return runTue - int of runTue
     */
    public abstract int getRunTue();

    /**
     * Set the value of runTueTime
     * @param runTueTime - String of runTueTime
     */
    public abstract void setRunTueTime(String runTueTime);

    /**
     * Get the value of runTueTime
     * @return runTueTime - String of runTueTime
     */
    public abstract String getRunTueTime();

    /**
     * Set the value of runWed
     * @param runWed - int of runWed
     */
    public abstract void setRunWed(int runWed);

    /**
     * Get the value of runWed
     * @return runWed - int of runWed
     */
    public abstract int getRunWed();

    /**
     * Set the value of runWedTime
     * @param runWedTime - String of runWedTime
     */
    public abstract void setRunWedTime(String runWedTime);

    /**
     * Get the value of runWedTime
     * @return runWedTime - String of runWedTime
     */
    public abstract String getRunWedTime();

    /**
     * Set the value of runThu
     * @param runThu - int of runThu
     */
    public abstract void setRunThu(int runThu);

    /**
     * Get the value of runThu
     * @return runThu - int of runThu
     */
    public abstract int getRunThu();

    /**
     * Set the value of runThuTime
     * @param runThuTime - String of runThuTime
     */
    public abstract void setRunThuTime(String runThuTime);

    /**
     * Get the value of runThuTime
     * @return runThuTime - String of runThuTime
     */
    public abstract String getRunThuTime();

    /**
     * Set the value of runFri
     * @param runFri - int of runFri
     */
    public abstract void setRunFri(int runFri);

    /**
     * Get the value of runFri
     * @return runFri - int of runFri
     */
    public abstract int getRunFri();

    /**
     * Set the value of runFriTime
     * @param runFriTime - String of runFriTime
     */
    public abstract void setRunFriTime(String runFriTime);

    /**
     * Get the value of runFriTime
     * @return runFriTime - String of runFriTime
     */
    public abstract String getRunFriTime();

    /**
     * Set the value of runSat
     * @param runSat - int of runSat
     */
    public abstract void setRunSat(int runSat);

    /**
     * Get the value of runSat
     * @return runSat - int of runSat
     */
    public abstract int getRunSat();

    /**
     * Set the value of runSatTime
     * @param runSatTime - String of runSatTime
     */
    public abstract void setRunSatTime(String runSatTime);

    /**
     * Get the value of runSatTime
     * @return runSatTime - String of runSatTime
     */
    public abstract String getRunSatTime();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String locationCd, int taskTypeCd, String emailWarning, int runSun, String runSunTime, int runMon, String runMonTime, int runTue, String runTueTime, int runWed, String runWedTime, int runThu, String runThuTime, int runFri, String runFriTime, int runSat, String runSatTime)
        throws CreateException {
        setLocationCd(locationCd);
        setTaskTypeCd(taskTypeCd);
        setEmailWarning(emailWarning);
        setRunSun(runSun);
        setRunSunTime(runSunTime);
        setRunMon(runMon);
        setRunMonTime(runMonTime);
        setRunTue(runTue);
        setRunTueTime(runTueTime);
        setRunWed(runWed);
        setRunWedTime(runWedTime);
        setRunThu(runThu);
        setRunThuTime(runThuTime);
        setRunFri(runFri);
        setRunFriTime(runFriTime);
        setRunSat(runSat);
        setRunSatTime(runSatTime);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String locationCd, int taskTypeCd, String emailWarning, int runSun, String runSunTime, int runMon, String runMonTime, int runTue, String runTueTime, int runWed, String runWedTime, int runThu, String runThuTime, int runFri, String runFriTime, int runSat, String runSatTime)
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
