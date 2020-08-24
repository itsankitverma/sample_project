package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arturo Gonzalez.
 * User: arturog
 * Date: 21-03-2005
 * Time: 05:02:03 PM
 * Description :
 */
public class AdminTasksForm extends ActionForm implements java.io.Serializable{

    /** Creates a new instance of AdminTasksForm */
    public AdminTasksForm() {
    }

    private Integer tasksId;
    private String locationCd;
    private Integer taskTypeCd;
    private String emailWarning;
    private Integer runSun;
    private String runSunTime;
    private Integer runMon;
    private String runMonTime;
    private Integer runTue;
    private String runTueTime;
    private Integer runWed;
    private String runWedTime;
    private Integer runThu;
    private String runThuTime;
    private Integer runFri;
    private String runFriTime;
    private Integer runSat;
    private String runSatTime;

    public Integer getTasksId() {
        return tasksId;
    }

    public void setTasksId(Integer tasksId) {
        this.tasksId = tasksId;
    }

    public String getLocationCd() {
        return locationCd;
    }

    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }

    public Integer getTaskTypeCd() {
        return taskTypeCd;
    }

    public void setTaskTypeCd(Integer taskTypeCd) {
        this.taskTypeCd = taskTypeCd;
    }

    public String getEmailWarning() {
        return emailWarning;
    }

    public void setEmailWarning(String emailWarning) {
        this.emailWarning = emailWarning;
    }

    public Integer getRunSun() {
        return runSun;
    }

    public void setRunSun(Integer runSun) {
        this.runSun = runSun;
    }

    public String getRunSunTime() {
        return runSunTime;
    }

    public void setRunSunTime(String runSunTime) {
        this.runSunTime = runSunTime;
    }

    public Integer getRunMon() {
        return runMon;
    }

    public void setRunMon(Integer runMon) {
        this.runMon = runMon;
    }

    public String getRunMonTime() {
        return runMonTime;
    }

    public void setRunMonTime(String runMonTime) {
        this.runMonTime = runMonTime;
    }

    public Integer getRunTue() {
        return runTue;
    }

    public void setRunTue(Integer runTue) {
        this.runTue = runTue;
    }

    public String getRunTueTime() {
        return runTueTime;
    }

    public void setRunTueTime(String runTueTime) {
        this.runTueTime = runTueTime;
    }

    public Integer getRunWed() {
        return runWed;
    }

    public void setRunWed(Integer runWed) {
        this.runWed = runWed;
    }

    public String getRunWedTime() {
        return runWedTime;
    }

    public void setRunWedTime(String runWedTime) {
        this.runWedTime = runWedTime;
    }

    public Integer getRunThu() {
        return runThu;
    }

    public void setRunThu(Integer runThu) {
        this.runThu = runThu;
    }

    public String getRunThuTime() {
        return runThuTime;
    }

    public void setRunThuTime(String runThuTime) {
        this.runThuTime = runThuTime;
    }

    public Integer getRunFri() {
        return runFri;
    }

    public void setRunFri(Integer runFri) {
        this.runFri = runFri;
    }

    public String getRunFriTime() {
        return runFriTime;
    }

    public void setRunFriTime(String runFriTime) {
        this.runFriTime = runFriTime;
    }

    public Integer getRunSat() {
        return runSat;
    }

    public void setRunSat(Integer runSat) {
        this.runSat = runSat;
    }

    public String getRunSatTime() {
        return runSatTime;
    }

    public void setRunSatTime(String runSatTime) {
        this.runSatTime = runSatTime;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {   ActionErrors errors = new ActionErrors();

        if(getRunSun()==null) setRunSun(new Integer("0"));
        if(getRunMon()==null) setRunMon(new Integer("0"));
        if(getRunTue()==null) setRunTue(new Integer("0"));
        if(getRunWed()==null) setRunWed(new Integer("0"));
        if(getRunThu()==null) setRunThu(new Integer("0"));
        if(getRunFri()==null) setRunFri(new Integer("0"));
        if(getRunSat()==null) setRunSat(new Integer("0"));


        if(getRunSun().intValue() == 1 && !validateTime(getRunSunTime()))
            errors.add("RunSunTime",new ActionError("errors.messages.RunSunTimeBadEntered"));
        if(getRunMon().intValue() == 1 && !validateTime(getRunMonTime()))
            errors.add("RunMonTime",new ActionError("errors.messages.RunMonTimeBadEntered"));
        if(getRunTue().intValue() == 1 && !validateTime(getRunTueTime()))
            errors.add("RunTueTime",new ActionError("errors.messages.RunTueTimeBadEntered"));
        if(getRunWed().intValue() == 1 && !validateTime(getRunWedTime()))
            errors.add("RunWedTime",new ActionError("errors.messages.RunWedTimeBadEntered"));
        if(getRunThu().intValue() == 1 && !validateTime(getRunThuTime()))
            errors.add("RunThuTime",new ActionError("errors.messages.RunThuTimeBadEntered"));
        if(getRunFri().intValue() == 1 && !validateTime(getRunFriTime()))
            errors.add("RunFriTime",new ActionError("errors.messages.RunFriTimeBadEntered"));
        if(getRunSat().intValue() == 1 && !validateTime(getRunSatTime()))
            errors.add("RunSatTime",new ActionError("errors.messages.RunSatTimeBadEntered"));

        return errors;
    }

    private boolean validateTime(String time){
        try{
            String[] baseTime = time.split(":");
            int hh = Integer.parseInt(baseTime[0]);
            int mm = Integer.parseInt(baseTime[1]);

            if( ( hh < 0  || hh > 24 ) || (mm < 0 || mm > 59))
                return false;
            else
                if(hh==24 && mm > 0)
                    return false;
                else
                    return true;
        }catch(Exception e) {
            return false;
        }
    }
}
