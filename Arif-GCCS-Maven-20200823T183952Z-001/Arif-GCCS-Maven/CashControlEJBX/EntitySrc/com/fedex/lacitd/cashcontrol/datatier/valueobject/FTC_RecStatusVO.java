/**
 * @(#)FTC_RecStatusVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the rec_status table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class FTC_RecStatusVO implements java.io.Serializable {

    private Integer _statusId;
    private String _description;
    private int _ftcPgFlg;
    public FTC_RecStatusVO() {
    }
    public FTC_RecStatusVO(Integer statusId, String description, int ftcPgFlg) {
        _statusId = statusId;
        _description = description;
        _ftcPgFlg = ftcPgFlg;
    }
    /**
     * Set the value of statusId
     */
    public void setStatusId(Integer statusId) {
        _statusId = statusId;
    }

    /**
     * Get the value of statusId
     */
    public Integer getStatusId() {
        return _statusId;
    }

    /**
     * Set the value of description
     */
    public void setDescription(String description) {
        _description = description;
    }

    /**
     * Get the value of description
     */
    public String getDescription() {
        return _description;
    }

    /**
     * Set the value of ftcPgFlg
     */
    public void setFtcPgFlg(int ftcPgFlg) {
        _ftcPgFlg = ftcPgFlg;
    }

    /**
     * Get the value of ftcPgFlg
     */
    public int getFtcPgFlg() {
        return _ftcPgFlg;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getFTC_RecStatusPK() {
        return _statusId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StatusId: " + _statusId);
        stringBuffer.append("Description: " + _description);
        stringBuffer.append("FtcPgFlg: " + _ftcPgFlg);
        return stringBuffer.toString();
    }

}
