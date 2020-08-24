/**
 * @(#)DepTemplLocPK.java			Tue Aug 02 15:38:50 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class DepTemplLocPK implements Serializable {

    private transient int _hashCode = -1;
    public String locationCd;
    public Integer templId;
    public DepTemplLocPK() {
    }
    public DepTemplLocPK(String locationCd, Integer templId) {
        this.locationCd = locationCd;
        this.templId = templId;
    }
    /**
     * Returns the DepTemplLoc's locationCd.
     * @return String the DepTemplLoc's locationCd
     */
    public String getLocationCd() {
        return locationCd;
    }

    /**
     * Sets the DepTemplLoc's locationCd.
     */
    public void setLocationCd(String locationCd) {
        locationCd = locationCd;
    }

    /**
     * Returns the DepTemplLoc's templId.
     * @return Integer the DepTemplLoc's templId
     */
    public Integer getTemplId() {
        return templId;
    }

    /**
     * Sets the DepTemplLoc's templId.
     */
    public void setTemplId(Integer templId) {
        templId = templId;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (locationCd.hashCode()) ^ (templId.hashCode());
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
            DepTemplLocPK rhs =(DepTemplLocPK) other;
            return (locationCd.equals(rhs.locationCd) && 
				templId.equals(rhs.templId));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
