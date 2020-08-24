/**
 * @(#)OtherPymtCtgVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the other_pymt_ctg table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class OtherPymtCtgVO implements java.io.Serializable {

    private Integer _otherPaymentCtgId;
    private String _description;
    private String _shortDescription;
    public OtherPymtCtgVO() {
    }
    public OtherPymtCtgVO(Integer otherPaymentCtgId, String description, String shortDescription) {
        _otherPaymentCtgId = otherPaymentCtgId;
        _description = description;
        _shortDescription = shortDescription;
    }
    /**
     * Set the value of otherPaymentCtgId
     */
    public void setOtherPaymentCtgId(Integer otherPaymentCtgId) {
        _otherPaymentCtgId = otherPaymentCtgId;
    }

    /**
     * Get the value of otherPaymentCtgId
     */
    public Integer getOtherPaymentCtgId() {
        return _otherPaymentCtgId;
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
     * Set the value of shortDescription
     */
    public void setShortDescription(String shortDescription) {
        _shortDescription = shortDescription;
    }

    /**
     * Get the value of shortDescription
     */
    public String getShortDescription() {
        return _shortDescription;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getOtherPymtCtgPK() {
        return _otherPaymentCtgId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OtherPaymentCtgId: " + _otherPaymentCtgId);
        stringBuffer.append("Description: " + _description);
        stringBuffer.append("ShortDescription: " + _shortDescription);
        return stringBuffer.toString();
    }

}
