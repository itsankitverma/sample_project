/**
 * @(#)TasksLocal.java			Tue Aug 02 15:38:49 VET 2005
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

public interface TasksLocal extends EJBLocalObject {

    /**
     * Set the value of tasksId
     * @param tasksId - Integer of tasksId
     */
    public void setTasksId(Integer tasksId);

    /**
     * Get the value of tasksId
     * @return tasksId - Integer of tasksId
     */
    public Integer getTasksId();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public String getLocationCd();

    /**
     * Set the value of taskTypeCd
     * @param taskTypeCd - int of taskTypeCd
     */
    public void setTaskTypeCd(int taskTypeCd);

    /**
     * Get the value of taskTypeCd
     * @return taskTypeCd - int of taskTypeCd
     */
    public int getTaskTypeCd();

    /**
     * Set the value of emailWarning
     * @param emailWarning - String of emailWarning
     */
    public void setEmailWarning(String emailWarning);

    /**
     * Get the value of emailWarning
     * @return emailWarning - String of emailWarning
     */
    public String getEmailWarning();

    /**
     * Set the value of runSun
     * @param runSun - int of runSun
     */
    public void setRunSun(int runSun);

    /**
     * Get the value of runSun
     * @return runSun - int of runSun
     */
    public int getRunSun();

    /**
     * Set the value of runSunTime
     * @param runSunTime - String of runSunTime
     */
    public void setRunSunTime(String runSunTime);

    /**
     * Get the value of runSunTime
     * @return runSunTime - String of runSunTime
     */
    public String getRunSunTime();

    /**
     * Set the value of runMon
     * @param runMon - int of runMon
     */
    public void setRunMon(int runMon);

    /**
     * Get the value of runMon
     * @return runMon - int of runMon
     */
    public int getRunMon();

    /**
     * Set the value of runMonTime
     * @param runMonTime - String of runMonTime
     */
    public void setRunMonTime(String runMonTime);

    /**
     * Get the value of runMonTime
     * @return runMonTime - String of runMonTime
     */
    public String getRunMonTime();

    /**
     * Set the value of runTue
     * @param runTue - int of runTue
     */
    public void setRunTue(int runTue);

    /**
     * Get the value of runTue
     * @return runTue - int of runTue
     */
    public int getRunTue();

    /**
     * Set the value of runTueTime
     * @param runTueTime - String of runTueTime
     */
    public void setRunTueTime(String runTueTime);

    /**
     * Get the value of runTueTime
     * @return runTueTime - String of runTueTime
     */
    public String getRunTueTime();

    /**
     * Set the value of runWed
     * @param runWed - int of runWed
     */
    public void setRunWed(int runWed);

    /**
     * Get the value of runWed
     * @return runWed - int of runWed
     */
    public int getRunWed();

    /**
     * Set the value of runWedTime
     * @param runWedTime - String of runWedTime
     */
    public void setRunWedTime(String runWedTime);

    /**
     * Get the value of runWedTime
     * @return runWedTime - String of runWedTime
     */
    public String getRunWedTime();

    /**
     * Set the value of runThu
     * @param runThu - int of runThu
     */
    public void setRunThu(int runThu);

    /**
     * Get the value of runThu
     * @return runThu - int of runThu
     */
    public int getRunThu();

    /**
     * Set the value of runThuTime
     * @param runThuTime - String of runThuTime
     */
    public void setRunThuTime(String runThuTime);

    /**
     * Get the value of runThuTime
     * @return runThuTime - String of runThuTime
     */
    public String getRunThuTime();

    /**
     * Set the value of runFri
     * @param runFri - int of runFri
     */
    public void setRunFri(int runFri);

    /**
     * Get the value of runFri
     * @return runFri - int of runFri
     */
    public int getRunFri();

    /**
     * Set the value of runFriTime
     * @param runFriTime - String of runFriTime
     */
    public void setRunFriTime(String runFriTime);

    /**
     * Get the value of runFriTime
     * @return runFriTime - String of runFriTime
     */
    public String getRunFriTime();

    /**
     * Set the value of runSat
     * @param runSat - int of runSat
     */
    public void setRunSat(int runSat);

    /**
     * Get the value of runSat
     * @return runSat - int of runSat
     */
    public int getRunSat();

    /**
     * Set the value of runSatTime
     * @param runSatTime - String of runSatTime
     */
    public void setRunSatTime(String runSatTime);

    /**
     * Get the value of runSatTime
     * @return runSatTime - String of runSatTime
     */
    public String getRunSatTime();

}
