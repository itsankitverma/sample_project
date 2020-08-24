/**
 * @(#)RecSurchargesPK.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the rec_surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class RecSurchargesPK implements Serializable {

    private transient int _hashCode = -1;
    public Integer recId;
    public String surchargeCd;
    public RecSurchargesPK() {
    }
    public RecSurchargesPK(Integer recId, String surchargeCd) {
        this.recId = recId;
        this.surchargeCd = surchargeCd;
    }
    /**
     * Returns the RecSurcharges's recId.
     * @return Integer the RecSurcharges's recId
     */
    public Integer getRecId() {
        return recId;
    }

    /**
     * Sets the RecSurcharges's recId.
     */
    public void setRecId(Integer recId) {
        recId = recId;
    }

    /**
     * Returns the RecSurcharges's surchargeCd.
     * @return String the RecSurcharges's surchargeCd
     */
    public String getSurchargeCd() {
        return surchargeCd;
    }

    /**
     * Sets the RecSurcharges's surchargeCd.
     */
    public void setSurchargeCd(String surchargeCd) {
        surchargeCd = surchargeCd;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (recId.hashCode()) ^ (surchargeCd.hashCode());
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
            RecSurchargesPK rhs =(RecSurchargesPK) other;
            return (recId.equals(rhs.recId) && 
				surchargeCd.equals(rhs.surchargeCd));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
