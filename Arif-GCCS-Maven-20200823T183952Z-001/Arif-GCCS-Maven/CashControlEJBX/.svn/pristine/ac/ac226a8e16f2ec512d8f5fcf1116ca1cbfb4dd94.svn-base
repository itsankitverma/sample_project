/**
 * @(#)PymtTypeLocVO.java			Tue Aug 02 15:38:51 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import java.util.*;

public class PymtTypeLocVO implements java.io.Serializable {

    private Integer _paymentTypeId;
    private String _locationCd;
    public PymtTypeLocVO() {
    }
    public PymtTypeLocVO(Integer paymentTypeId, String locationCd) {
        _paymentTypeId = paymentTypeId;
        _locationCd = locationCd;
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
     * Set the value of locationCd
     */
    public void setLocationCd(String locationCd) {
        _locationCd = locationCd;
    }

    /**
     * Get the value of locationCd
     */
    public String getLocationCd() {
        return _locationCd;
    }

    /**
     * Get the value of the primary key
     */
    public PymtTypeLocPK getPymtTypeLocPK() {
        return new PymtTypeLocPK(_paymentTypeId, _locationCd);
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PaymentTypeId: " + _paymentTypeId);
        stringBuffer.append("LocationCd: " + _locationCd);
        return stringBuffer.toString();
    }

}
