/**
 * @(#)PaymentCtgVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the payment_ctg table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class PaymentCtgVO implements java.io.Serializable {

    private Integer _paymentCtgId;
    private String _description;
    private int _canCreatePymt;
    public PaymentCtgVO() {
    }
    public PaymentCtgVO(Integer paymentCtgId, String description, int canCreatePymt) {
        _paymentCtgId = paymentCtgId;
        _description = description;
        _canCreatePymt = canCreatePymt;
    }
    /**
     * Set the value of paymentCtgId
     */
    public void setPaymentCtgId(Integer paymentCtgId) {
        _paymentCtgId = paymentCtgId;
    }

    /**
     * Get the value of paymentCtgId
     */
    public Integer getPaymentCtgId() {
        return _paymentCtgId;
    }

    /**
     * Set the value of description
     */
    public void setDescription(String description) {
        _description = description;
    }

    /**
     * Get the value of description
     */
    public String getDescription() {
        return _description;
    }

    /**
     * Set the value of canCreatePymt
     */
    public void setCanCreatePymt(int canCreatePymt) {
        _canCreatePymt = canCreatePymt;
    }

    /**
     * Get the value of canCreatePymt
     */
    public int getCanCreatePymt() {
        return _canCreatePymt;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getPaymentCtgPK() {
        return _paymentCtgId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PaymentCtgId: " + _paymentCtgId);
        stringBuffer.append("Description: " + _description);
        stringBuffer.append("CanCreatePymt: " + _canCreatePymt);
        return stringBuffer.toString();
    }

}
