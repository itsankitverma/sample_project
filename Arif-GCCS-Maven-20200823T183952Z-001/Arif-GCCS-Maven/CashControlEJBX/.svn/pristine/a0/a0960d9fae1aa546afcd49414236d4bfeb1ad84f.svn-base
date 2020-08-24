/**
 * @(#)OacAwbPK.java			Tue Aug 02 15:38:50 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class OacAwbPK implements Serializable {

    private transient int _hashCode = -1;
    public Integer obAncSvcIdNbr;
    public String awbNbr;
    public OacAwbPK() {
    }
    public OacAwbPK(Integer obAncSvcIdNbr, String awbNbr) {
        this.obAncSvcIdNbr = obAncSvcIdNbr;
        this.awbNbr = awbNbr;
    }
    /**
     * Returns the OacAwb's obAncSvcIdNbr.
     * @return Integer the OacAwb's obAncSvcIdNbr
     */
    public Integer getObAncSvcIdNbr() {
        return obAncSvcIdNbr;
    }

    /**
     * Sets the OacAwb's obAncSvcIdNbr.
     */
    public void setObAncSvcIdNbr(Integer obAncSvcIdNbr) {
        obAncSvcIdNbr = obAncSvcIdNbr;
    }

    /**
     * Returns the OacAwb's awbNbr.
     * @return String the OacAwb's awbNbr
     */
    public String getAwbNbr() {
        return awbNbr;
    }

    /**
     * Sets the OacAwb's awbNbr.
     */
    public void setAwbNbr(String awbNbr) {
        awbNbr = awbNbr;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (obAncSvcIdNbr.hashCode()) ^ (awbNbr.hashCode());
		}
		return _hashCode;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     */
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.hashCode() != hashCode()) return false;
        try {
            OacAwbPK rhs =(OacAwbPK) other;
            return (obAncSvcIdNbr.equals(rhs.obAncSvcIdNbr) && 
				awbNbr.equals(rhs.awbNbr));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
