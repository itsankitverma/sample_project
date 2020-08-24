package com.fedex.lacitd.cashcontrol.biztier.common;

import java.util.Date;

/**
 * @author ccardenas
 */
public class CosmosScansTableVO implements java.io.Serializable {
    /**
     * @return Returns the details.
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details The details to set.
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return Returns the employeeId.
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId The employeeId to set.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return Returns the locationCd.
     */
    public String getLocationCd() {
        return locationCd;
    }

    /**
     * @param locationCd The locationCd to set.
     */
    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }

    /**
     * @return Returns the scanDtTm.
     */
    public Date getScanDtTm() {
        return scanDtTm;
    }

    /**
     * @param scanDtTm The scanDtTm to set.
     */
    public void setScanDtTm(Date scanDtTm) {
        this.scanDtTm = scanDtTm;
    }

    /**
     * @return Returns the scanDtTmStr.
     */
    public String getScanDtTmStr() {
        return scanDtTmStr;
    }

    /**
     * @param scanDtTmStr The scanDtTmStr to set.
     */
    public void setScanDtTmStr(String scanDtTmStr) {
        this.scanDtTmStr = scanDtTmStr;
    }

    /**
     * @return Returns the scanType.
     */
    public String getScanType() {
        return scanType;
    }

    /**
     * @param scanType The scanType to set.
     */
    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    private String scanType;
    private String scanDtTmStr;
    private String locationCd;
    private String employeeId;
    private String details;
    private Date scanDtTm;
    private String fontColor;

    /**
     * @return Returns the fontColor.
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * @param fontColor The fontColor to set.
     */
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }
}
