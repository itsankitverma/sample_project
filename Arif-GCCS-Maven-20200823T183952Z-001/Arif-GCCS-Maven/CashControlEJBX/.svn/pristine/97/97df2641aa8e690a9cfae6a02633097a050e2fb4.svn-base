/**
 * @(#)PoaSurchargesPK.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the poa_surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class PoaSurchargesPK implements Serializable {

    private transient int _hashCode = -1;
    public Integer poaDetailId;
    public String surchargeCd;
    public PoaSurchargesPK() {
    }
    public PoaSurchargesPK(Integer poaDetailId, String surchargeCd) {
        this.poaDetailId = poaDetailId;
        this.surchargeCd = surchargeCd;
    }
    /**
     * Returns the PoaSurcharges's poaDetailId.
     * @return Integer the PoaSurcharges's poaDetailId
     */
    public Integer getPoaDetailId() {
        return poaDetailId;
    }

    /**
     * Sets the PoaSurcharges's poaDetailId.
     */
    public void setPoaDetailId(Integer poaDetailId) {
        poaDetailId = poaDetailId;
    }

    /**
     * Returns the PoaSurcharges's surchargeCd.
     * @return String the PoaSurcharges's surchargeCd
     */
    public String getSurchargeCd() {
        return surchargeCd;
    }

    /**
     * Sets the PoaSurcharges's surchargeCd.
     */
    public void setSurchargeCd(String surchargeCd) {
        surchargeCd = surchargeCd;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (poaDetailId.hashCode()) ^ (surchargeCd.hashCode());
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
            PoaSurchargesPK rhs =(PoaSurchargesPK) other;
            return (poaDetailId.equals(rhs.poaDetailId) && 
				surchargeCd.equals(rhs.surchargeCd));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
