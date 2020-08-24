/**
 * @(#)RecExpSrchgPK.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the rec_exp_srchg table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class RecExpSrchgPK implements Serializable {

    private transient int _hashCode = -1;
    public Integer recId;
    public String surchargeCd;
    public RecExpSrchgPK() {
    }
    public RecExpSrchgPK(Integer recId, String surchargeCd) {
        this.recId = recId;
        this.surchargeCd = surchargeCd;
    }
    /**
     * Returns the RecExpSrchg's recId.
     * @return Integer the RecExpSrchg's recId
     */
    public Integer getRecId() {
        return recId;
    }

    /**
     * Sets the RecExpSrchg's recId.
     */
    public void setRecId(Integer recId) {
        recId = recId;
    }

    /**
     * Returns the RecExpSrchg's surchargeCd.
     * @return String the RecExpSrchg's surchargeCd
     */
    public String getSurchargeCd() {
        return surchargeCd;
    }

    /**
     * Sets the RecExpSrchg's surchargeCd.
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
            RecExpSrchgPK rhs =(RecExpSrchgPK) other;
            return (recId.equals(rhs.recId) && 
				surchargeCd.equals(rhs.surchargeCd));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
