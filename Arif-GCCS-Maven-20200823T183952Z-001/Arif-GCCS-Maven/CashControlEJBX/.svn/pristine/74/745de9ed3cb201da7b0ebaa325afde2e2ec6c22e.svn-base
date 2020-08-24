/**
 * @(#)SurchargeLocPK.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the surcharge_loc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class SurchargeLocPK implements Serializable {

    private transient int _hashCode = -1;
    public String surchargeCd;
    public String locationCd;
    public SurchargeLocPK() {
    }
    public SurchargeLocPK(String surchargeCd, String locationCd) {
        this.surchargeCd = surchargeCd;
        this.locationCd = locationCd;
    }
    /**
     * Returns the SurchargeLoc's surchargeCd.
     * @return String the SurchargeLoc's surchargeCd
     */
    public String getSurchargeCd() {
        return surchargeCd;
    }

    /**
     * Sets the SurchargeLoc's surchargeCd.
     */
    public void setSurchargeCd(String surchargeCd) {
        surchargeCd = surchargeCd;
    }

    /**
     * Returns the SurchargeLoc's locationCd.
     * @return String the SurchargeLoc's locationCd
     */
    public String getLocationCd() {
        return locationCd;
    }

    /**
     * Sets the SurchargeLoc's locationCd.
     */
    public void setLocationCd(String locationCd) {
        locationCd = locationCd;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (surchargeCd.hashCode()) ^ (locationCd.hashCode());
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
            SurchargeLocPK rhs =(SurchargeLocPK) other;
            return (surchargeCd.equals(rhs.surchargeCd) && 
				locationCd.equals(rhs.locationCd));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
