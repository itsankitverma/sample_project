/**
 * @(#)PrepSurchargesPK.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the prep_surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class PrepSurchargesPK implements Serializable {

    private transient int _hashCode = -1;
    public Integer prepaidId;
    public String surchargeCd;
    public PrepSurchargesPK() {
    }
    public PrepSurchargesPK(Integer prepaidId, String surchargeCd) {
        this.prepaidId = prepaidId;
        this.surchargeCd = surchargeCd;
    }
    /**
     * Returns the PrepSurcharges's prepaidId.
     * @return Integer the PrepSurcharges's prepaidId
     */
    public Integer getPrepaidId() {
        return prepaidId;
    }

    /**
     * Sets the PrepSurcharges's prepaidId.
     */
    public void setPrepaidId(Integer prepaidId) {
        prepaidId = prepaidId;
    }

    /**
     * Returns the PrepSurcharges's surchargeCd.
     * @return String the PrepSurcharges's surchargeCd
     */
    public String getSurchargeCd() {
        return surchargeCd;
    }

    /**
     * Sets the PrepSurcharges's surchargeCd.
     */
    public void setSurchargeCd(String surchargeCd) {
        surchargeCd = surchargeCd;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (prepaidId.hashCode()) ^ (surchargeCd.hashCode());
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
            PrepSurchargesPK rhs =(PrepSurchargesPK) other;
            return (prepaidId.equals(rhs.prepaidId) && 
				surchargeCd.equals(rhs.surchargeCd));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
