/**
 * @(#)GlExchRatePK.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the gl_exch_rate table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class GlExchRatePK implements Serializable {

    private transient int _hashCode = -1;
    public String currCd;
    public Date perdDt;
    public GlExchRatePK() {
    }
    public GlExchRatePK(String currCd, Date perdDt) {
        this.currCd = currCd;
        this.perdDt = perdDt;
    }
    /**
     * Returns the GlExchRate's currCd.
     * @return String the GlExchRate's currCd
     */
    public String getCurrCd() {
        return currCd;
    }

    /**
     * Sets the GlExchRate's currCd.
     */
    public void setCurrCd(String currCd) {
        currCd = currCd;
    }

    /**
     * Returns the GlExchRate's perdDt.
     * @return Date the GlExchRate's perdDt
     */
    public Date getPerdDt() {
        return perdDt;
    }

    /**
     * Sets the GlExchRate's perdDt.
     */
    public void setPerdDt(Date perdDt) {
        perdDt = perdDt;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (currCd.hashCode()) ^ (perdDt.hashCode());
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
            GlExchRatePK rhs =(GlExchRatePK) other;
            return (currCd.equals(rhs.currCd) && 
				perdDt.equals(rhs.perdDt));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
