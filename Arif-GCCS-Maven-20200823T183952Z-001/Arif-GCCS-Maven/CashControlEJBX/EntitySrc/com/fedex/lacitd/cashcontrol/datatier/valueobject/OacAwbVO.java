/**
 * @(#)OacAwbVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the oac_awb table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class OacAwbVO implements java.io.Serializable {

    private Integer _obAncSvcIdNbr;
    private String _awbNbr;
    public OacAwbVO() {
    }
    public OacAwbVO(Integer obAncSvcIdNbr, String awbNbr) {
        _obAncSvcIdNbr = obAncSvcIdNbr;
        _awbNbr = awbNbr;
    }
    /**
     * Set the value of obAncSvcIdNbr
     */
    public void setObAncSvcIdNbr(Integer obAncSvcIdNbr) {
        _obAncSvcIdNbr = obAncSvcIdNbr;
    }

    /**
     * Get the value of obAncSvcIdNbr
     */
    public Integer getObAncSvcIdNbr() {
        return _obAncSvcIdNbr;
    }

    /**
     * Set the value of awbNbr
     */
    public void setAwbNbr(String awbNbr) {
        _awbNbr = awbNbr;
    }

    /**
     * Get the value of awbNbr
     */
    public String getAwbNbr() {
        return _awbNbr;
    }

    /**
     * Get the value of the primary key
     */
    public OacAwbPK getOacAwbPK() {
        return new OacAwbPK(_obAncSvcIdNbr, _awbNbr);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ObAncSvcIdNbr: " + _obAncSvcIdNbr);
        stringBuffer.append("AwbNbr: " + _awbNbr);
        return stringBuffer.toString();
    }

}
