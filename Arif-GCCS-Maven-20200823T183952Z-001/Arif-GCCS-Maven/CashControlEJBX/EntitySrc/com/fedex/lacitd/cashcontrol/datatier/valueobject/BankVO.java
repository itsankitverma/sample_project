/**
 * @(#)BankVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the bank table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class BankVO implements java.io.Serializable {

    private Integer _bankId;
    private String _bankNm;
    private String _bankCd;
    private String _bankShtDesc;
    private String _countryCd;
    public BankVO() {
    }
    public BankVO(Integer bankId, String bankNm, String bankCd, String bankShtDesc, String countryCd) {
        _bankId = bankId;
        _bankNm = bankNm;
        _bankCd = bankCd;
        _bankShtDesc = bankShtDesc;
        _countryCd = countryCd;
    }
    /**
     * Set the value of bankId
     */
    public void setBankId(Integer bankId) {
        _bankId = bankId;
    }

    /**
     * Get the value of bankId
     */
    public Integer getBankId() {
        return _bankId;
    }

    /**
     * Set the value of bankNm
     */
    public void setBankNm(String bankNm) {
        _bankNm = bankNm;
    }

    /**
     * Get the value of bankNm
     */
    public String getBankNm() {
        return _bankNm;
    }

    /**
     * Set the value of bankCd
     */
    public void setBankCd(String bankCd) {
        _bankCd = bankCd;
    }

    /**
     * Get the value of bankCd
     */
    public String getBankCd() {
        return _bankCd;
    }

    /**
     * Set the value of bankShtDesc
     */
    public void setBankShtDesc(String bankShtDesc) {
        _bankShtDesc = bankShtDesc;
    }

    /**
     * Get the value of bankShtDesc
     */
    public String getBankShtDesc() {
        return _bankShtDesc;
    }

    /**
     * Set the value of countryCd
     */
    public void setCountryCd(String countryCd) {
        _countryCd = countryCd;
    }

    /**
     * Get the value of countryCd
     */
    public String getCountryCd() {
        return _countryCd;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getBankPK() {
        return _bankId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BankId: " + _bankId);
        stringBuffer.append("BankNm: " + _bankNm);
        stringBuffer.append("BankCd: " + _bankCd);
        stringBuffer.append("BankShtDesc: " + _bankShtDesc);
        stringBuffer.append("CountryCd: " + _countryCd);
        return stringBuffer.toString();
    }

}
