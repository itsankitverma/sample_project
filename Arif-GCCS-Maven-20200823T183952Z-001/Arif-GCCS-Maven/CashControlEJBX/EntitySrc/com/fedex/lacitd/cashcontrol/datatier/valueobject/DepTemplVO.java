/**
 * @(#)DepTemplVO.java			Tue Aug 02 15:38:51 VET 2005
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
 * This bean map to the dep_templ table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class DepTemplVO implements java.io.Serializable {

    private Integer _templId;
    private String _templCd;
    private String _templDesc;
    private String _crcdReimbTypeCd;
    private String _currencyType;
    private int _cntRod;
    private int _cntPrepaid;
    private int _cntPoa;
    private int _cntOther;
    private int _disabTempl;
    private int _cntGrnd;
    private int _cntCod;
    private int _cntFtc;

    public DepTemplVO() {
    }
    public DepTemplVO(Integer templId, String templCd, String templDesc, String crcdReimbTypeCd, String currencyType, int cntRod, int cntPrepaid, int cntPoa, int cntOther, int disabTempl, int cntGrnd, int cntCod, int cntFtc) {
        _templId = templId;
        _templCd = templCd;
        _templDesc = templDesc;
        _crcdReimbTypeCd = crcdReimbTypeCd;
        _currencyType = currencyType;
        _cntRod = cntRod;
        _cntPrepaid = cntPrepaid;
        _cntPoa = cntPoa;
        _cntOther = cntOther;
        _disabTempl = disabTempl;
        _cntGrnd = cntGrnd;
        _cntCod = cntCod;  
        _cntFtc = cntFtc;  
        
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
     * Set the value of templCd
     */
    public void setTemplCd(String templCd) {
        _templCd = templCd;
    }

    /**
     * Get the value of templCd
     */
    public String getTemplCd() {
        return _templCd;
    }

    /**
     * Set the value of templDesc
     */
    public void setTemplDesc(String templDesc) {
        _templDesc = templDesc;
    }

    /**
     * Get the value of templDesc
     */
    public String getTemplDesc() {
        return _templDesc;
    }

    /**
     * Set the value of crcdReimbTypeCd
     */
    public void setCrcdReimbTypeCd(String crcdReimbTypeCd) {
        _crcdReimbTypeCd = crcdReimbTypeCd;
    }

    /**
     * Get the value of crcdReimbTypeCd
     */
    public String getCrcdReimbTypeCd() {
        return _crcdReimbTypeCd;
    }

    /**
     * Set the value of currencyType
     */
    public void setCurrencyType(String currencyType) {
        _currencyType = currencyType;
    }

    /**
     * Get the value of currencyType
     */
    public String getCurrencyType() {
        return _currencyType;
    }

    /**
     * Set the value of cntRod
     */
    public void setCntRod(int cntRod) {
        _cntRod = cntRod;
    }

    /**
     * Get the value of cntRod
     */
    public int getCntRod() {
        return _cntRod;
    }

    /**
     * Set the value of cntPrepaid
     */
    public void setCntPrepaid(int cntPrepaid) {
        _cntPrepaid = cntPrepaid;
    }

    /**
     * Get the value of cntPrepaid
     */
    public int getCntPrepaid() {
        return _cntPrepaid;
    }

    /**
     * Set the value of cntPoa
     */
    public void setCntPoa(int cntPoa) {
        _cntPoa = cntPoa;
    }

    /**
     * Get the value of cntPoa
     */
    public int getCntPoa() {
        return _cntPoa;
    }

    /**
     * Set the value of cntOther
     */
    public void setCntOther(int cntOther) {
        _cntOther = cntOther;
    }

    /**
     * Get the value of cntOther
     */
    public int getCntOther() {
        return _cntOther;
    }

    /**
     * Set the value of disabTempl
     */
    public void setDisabTempl(int disabTempl) {
        _disabTempl = disabTempl;
    }

    /**
     * Get the value of disabTempl
     */
    public int getDisabTempl() {
        return _disabTempl;
    }

    /**
     * Set the value of cntGrnd
     */
    public void setCntGrnd(int cntGrnd) {
        _cntGrnd = cntGrnd;
    }

    /**
     * Get the value of cntGrnd
     */
    public int getCntGrnd() {
        return _cntGrnd;
    }

    /**
     * Set the value of cntCod
     */
    public void setCntCod(int cntCod) {
        _cntCod = cntCod;
    }

    /**
     * Get the value of cntCod
     */
    public int getCntCod() {
        return _cntCod;
    }

    /**
     * Set the value of cntFtc
     */
    public void setCntFtc(int cntFtc) {
        _cntFtc = cntFtc;
    }

    /**
     * Get the value of cntFtc
     */
    public int getCntFtc() {
        return _cntFtc;
    }
    
    /**
     * Get the value of the primary key
     */
    public Integer getDepTemplPK() {
        return _templId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TemplId: " + _templId);
        stringBuffer.append("TemplCd: " + _templCd);
        stringBuffer.append("TemplDesc: " + _templDesc);
        stringBuffer.append("CrcdReimbTypeCd: " + _crcdReimbTypeCd);
        stringBuffer.append("CurrencyType: " + _currencyType);
        stringBuffer.append("CntRod: " + _cntRod);
        stringBuffer.append("CntPrepaid: " + _cntPrepaid);
        stringBuffer.append("CntPoa: " + _cntPoa);
        stringBuffer.append("CntOther: " + _cntOther);
        stringBuffer.append("DisabTempl: " + _disabTempl);
        stringBuffer.append("CntGrnd: " + _cntGrnd);
        stringBuffer.append("CntCod: " + _cntCod);
        stringBuffer.append("CntFtc: " + _cntFtc);
        return stringBuffer.toString();
    }

}
