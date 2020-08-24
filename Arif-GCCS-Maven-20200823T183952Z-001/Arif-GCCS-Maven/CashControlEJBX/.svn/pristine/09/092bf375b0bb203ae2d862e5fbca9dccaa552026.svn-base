/**
 * @(#)RecStatusVO.java			Tue Aug 02 15:38:50 VET 2005
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

public class RecStatusVO implements java.io.Serializable {

    private Integer _statusId;
    private String _description;
    private int _rodPgFlg;
    public RecStatusVO() {
    }
    public RecStatusVO(Integer statusId, String description, int rodPgFlg) {
        _statusId = statusId;
        _description = description;
        _rodPgFlg = rodPgFlg;
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
     * Set the value of rodPgFlg
     */
    public void setRodPgFlg(int rodPgFlg) {
        _rodPgFlg = rodPgFlg;
    }

    /**
     * Get the value of rodPgFlg
     */
    public int getRodPgFlg() {
        return _rodPgFlg;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getRecStatusPK() {
        return _statusId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StatusId: " + _statusId);
        stringBuffer.append("Description: " + _description);
        stringBuffer.append("RodPgFlg: " + _rodPgFlg);
        return stringBuffer.toString();
    }

}
