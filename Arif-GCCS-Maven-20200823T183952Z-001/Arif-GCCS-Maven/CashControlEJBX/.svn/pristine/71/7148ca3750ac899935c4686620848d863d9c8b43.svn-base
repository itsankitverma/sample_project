/**
 * @(#)DepTemplPymtTypeVO.java			Tue Aug 02 15:38:51 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class DepTemplPymtTypeVO implements java.io.Serializable {

    private Integer _paymentTypeId;
    private Integer _templId;
    public DepTemplPymtTypeVO() {
    }
    public DepTemplPymtTypeVO(Integer paymentTypeId, Integer templId) {
        _paymentTypeId = paymentTypeId;
        _templId = templId;
    }
    /**
     * Set the value of paymentTypeId
     */
    public void setPaymentTypeId(Integer paymentTypeId) {
        _paymentTypeId = paymentTypeId;
    }

    /**
     * Get the value of paymentTypeId
     */
    public Integer getPaymentTypeId() {
        return _paymentTypeId;
    }

    /**
     * Set the value of templId
     */
    public void setTemplId(Integer templId) {
        _templId = templId;
    }

    /**
     * Get the value of templId
     */
    public Integer getTemplId() {
        return _templId;
    }

    /**
     * Get the value of the primary key
     */
    public DepTemplPymtTypePK getDepTemplPymtTypePK() {
        return new DepTemplPymtTypePK(_paymentTypeId, _templId);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PaymentTypeId: " + _paymentTypeId);
        stringBuffer.append("TemplId: " + _templId);
        return stringBuffer.toString();
    }

}
