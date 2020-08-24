/**
 * @(#)PymtTypeLocPK.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the pymt_type_loc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class PymtTypeLocPK implements Serializable {

    private transient int _hashCode = -1;
    public Integer paymentTypeId;
    public String locationCd;
    public PymtTypeLocPK() {
    }
    public PymtTypeLocPK(Integer paymentTypeId, String locationCd) {
        this.paymentTypeId = paymentTypeId;
        this.locationCd = locationCd;
    }
    /**
     * Returns the PymtTypeLoc's paymentTypeId.
     * @return Integer the PymtTypeLoc's paymentTypeId
     */
    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    /**
     * Sets the PymtTypeLoc's paymentTypeId.
     */
    public void setPaymentTypeId(Integer paymentTypeId) {
        paymentTypeId = paymentTypeId;
    }

    /**
     * Returns the PymtTypeLoc's locationCd.
     * @return String the PymtTypeLoc's locationCd
     */
    public String getLocationCd() {
        return locationCd;
    }

    /**
     * Sets the PymtTypeLoc's locationCd.
     */
    public void setLocationCd(String locationCd) {
        locationCd = locationCd;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (paymentTypeId.hashCode()) ^ (locationCd.hashCode());
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
            PymtTypeLocPK rhs =(PymtTypeLocPK) other;
            return (paymentTypeId.equals(rhs.paymentTypeId) && 
				locationCd.equals(rhs.locationCd));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
