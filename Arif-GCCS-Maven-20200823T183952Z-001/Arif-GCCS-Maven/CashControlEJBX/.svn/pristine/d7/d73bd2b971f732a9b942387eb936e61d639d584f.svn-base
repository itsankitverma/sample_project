/**
 * @(#)DepTemplLocVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the dep_templ_loc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class DepTemplLocVO implements java.io.Serializable {

    private String _locationCd;
    private Integer _templId;
    public DepTemplLocVO() {
    }
    public DepTemplLocVO(String locationCd, Integer templId) {
        _locationCd = locationCd;
        _templId = templId;
    }
    /**
     * Set the value of locationCd
     */
    public void setLocationCd(String locationCd) {
        _locationCd = locationCd;
    }

    /**
     * Get the value of locationCd
     */
    public String getLocationCd() {
        return _locationCd;
    }

    /**
     * Set the value of templId
     */
    public void setTemplId(Integer templId) {
        _templId = templId;
    }

    /**
     * Get the value of templId
     */
    public Integer getTemplId() {
        return _templId;
    }

    /**
     * Get the value of the primary key
     */
    public DepTemplLocPK getDepTemplLocPK() {
        return new DepTemplLocPK(_locationCd, _templId);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LocationCd: " + _locationCd);
        stringBuffer.append("TemplId: " + _templId);
        return stringBuffer.toString();
    }

}
