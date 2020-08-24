/**
 * @(#)DepTemplPymtTypePK.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the dep_templ_pymt_type table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import java.io.Serializable;
import java.util.*;

public class DepTemplPymtTypePK implements Serializable {

    private transient int _hashCode = -1;
    public Integer paymentTypeId;
    public Integer templId;
    public DepTemplPymtTypePK() {
    }
    public DepTemplPymtTypePK(Integer paymentTypeId, Integer templId) {
        this.paymentTypeId = paymentTypeId;
        this.templId = templId;
    }
    /**
     * Returns the DepTemplPymtType's paymentTypeId.
     * @return Integer the DepTemplPymtType's paymentTypeId
     */
    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    /**
     * Sets the DepTemplPymtType's paymentTypeId.
     */
    public void setPaymentTypeId(Integer paymentTypeId) {
        paymentTypeId = paymentTypeId;
    }

    /**
     * Returns the DepTemplPymtType's templId.
     * @return Integer the DepTemplPymtType's templId
     */
    public Integer getTemplId() {
        return templId;
    }

    /**
     * Sets the DepTemplPymtType's templId.
     */
    public void setTemplId(Integer templId) {
        templId = templId;
    }

    /**
     * Returns a hash code value for the object.
     */
    public int hashCode() {
        if (_hashCode == -1) {
			_hashCode = (paymentTypeId.hashCode()) ^ (templId.hashCode());
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
            DepTemplPymtTypePK rhs =(DepTemplPymtTypePK) other;
            return (paymentTypeId.equals(rhs.paymentTypeId) && 
				templId.equals(rhs.templId));
		} catch (ClassCastException ex) {
		   return false;
        }
    }

}
