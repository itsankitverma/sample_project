/**
 * @(#)PymtImptErrorDtlVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the pymt_impt_error_dtl table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class PymtImptErrorDtlVO implements java.io.Serializable {

    private Integer _imptErrorDtlId;
    private String _imptMessageDtl;
    private String _imptError;
    private Integer _imptId;
    public PymtImptErrorDtlVO() {
    }
    public PymtImptErrorDtlVO(Integer imptErrorDtlId, String imptMessageDtl, String imptError, Integer imptId) {
        _imptErrorDtlId = imptErrorDtlId;
        _imptMessageDtl = imptMessageDtl;
        _imptError = imptError;
        _imptId = imptId;
    }
    /**
     * Set the value of imptErrorDtlId
     */
    public void setImptErrorDtlId(Integer imptErrorDtlId) {
        _imptErrorDtlId = imptErrorDtlId;
    }

    /**
     * Get the value of imptErrorDtlId
     */
    public Integer getImptErrorDtlId() {
        return _imptErrorDtlId;
    }

    /**
     * Set the value of imptMessageDtl
     */
    public void setImptMessageDtl(String imptMessageDtl) {
        _imptMessageDtl = imptMessageDtl;
    }

    /**
     * Get the value of imptMessageDtl
     */
    public String getImptMessageDtl() {
        return _imptMessageDtl;
    }

    /**
     * Set the value of imptError
     */
    public void setImptError(String imptError) {
        _imptError = imptError;
    }

    /**
     * Get the value of imptError
     */
    public String getImptError() {
        return _imptError;
    }

    /**
     * Set the value of imptId
     */
    public void setImptId(Integer imptId) {
        _imptId = imptId;
    }

    /**
     * Get the value of imptId
     */
    public Integer getImptId() {
        return _imptId;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getPymtImptErrorDtlPK() {
        return _imptErrorDtlId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ImptErrorDtlId: " + _imptErrorDtlId);
        stringBuffer.append("ImptMessageDtl: " + _imptMessageDtl);
        stringBuffer.append("ImptError: " + _imptError);
        stringBuffer.append("ImptId: " + _imptId);
        return stringBuffer.toString();
    }

}
