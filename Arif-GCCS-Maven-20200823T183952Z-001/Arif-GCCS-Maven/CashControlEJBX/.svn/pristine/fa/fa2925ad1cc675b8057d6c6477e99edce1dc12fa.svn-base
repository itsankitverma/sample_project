/**
 * @(#)ExchangeRateVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the exchange_rate table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class ExchangeRateVO implements java.io.Serializable {

    private Integer _exchRateId;
    private Date _exchRate;
    private int _exchRtByUsd;
    private String _exchRateType;
    private Integer _cntryCurrencyId;
    public ExchangeRateVO() {
    }
    public ExchangeRateVO(Integer exchRateId, Date exchRate, int exchRtByUsd, String exchRateType, Integer cntryCurrencyId) {
        _exchRateId = exchRateId;
        _exchRate = exchRate;
        _exchRtByUsd = exchRtByUsd;
        _exchRateType = exchRateType;
        _cntryCurrencyId = cntryCurrencyId;
    }
    /**
     * Set the value of exchRateId
     */
    public void setExchRateId(Integer exchRateId) {
        _exchRateId = exchRateId;
    }

    /**
     * Get the value of exchRateId
     */
    public Integer getExchRateId() {
        return _exchRateId;
    }

    /**
     * Set the value of exchRate
     */
    public void setExchRate(Date exchRate) {
        _exchRate = exchRate;
    }

    /**
     * Get the value of exchRate
     */
    public Date getExchRate() {
        return _exchRate;
    }

    /**
     * Set the value of exchRtByUsd
     */
    public void setExchRtByUsd(int exchRtByUsd) {
        _exchRtByUsd = exchRtByUsd;
    }

    /**
     * Get the value of exchRtByUsd
     */
    public int getExchRtByUsd() {
        return _exchRtByUsd;
    }

    /**
     * Set the value of exchRateType
     */
    public void setExchRateType(String exchRateType) {
        _exchRateType = exchRateType;
    }

    /**
     * Get the value of exchRateType
     */
    public String getExchRateType() {
        return _exchRateType;
    }

    /**
     * Set the value of cntryCurrencyId
     */
    public void setCntryCurrencyId(Integer cntryCurrencyId) {
        _cntryCurrencyId = cntryCurrencyId;
    }

    /**
     * Get the value of cntryCurrencyId
     */
    public Integer getCntryCurrencyId() {
        return _cntryCurrencyId;
    }

    /**
     * Get the value of the primary key
     */
    public Integer getExchangeRatePK() {
        return _exchRateId;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExchRateId: " + _exchRateId);
        stringBuffer.append("ExchRate: " + _exchRate);
        stringBuffer.append("ExchRtByUsd: " + _exchRtByUsd);
        stringBuffer.append("ExchRateType: " + _exchRateType);
        stringBuffer.append("CntryCurrencyId: " + _cntryCurrencyId);
        return stringBuffer.toString();
    }

}
