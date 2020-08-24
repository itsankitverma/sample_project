/**
 * @(#)CountryVO.java			Wed Aug 03 13:22:32 VET 2005
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
 * This bean map to the country table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class CountryVO implements java.io.Serializable {

    private String _countryCd;
    private String _countryNm;
    private double _errThldLocCurr;
    private double _errThldUsd;
    private int _quickApplyFlg;
    private int _scanUsdDecNbr;
    private int _scanLocalDecNbr;
    private int _gndUsedFlag;
    private int _oacUsedFlag;
    private int _collectlaterFlag;
    private int _codUsedFlag;
    private int _ftcUsedFlag;
    

    public CountryVO() {
    }
    public CountryVO(String countryCd, String countryNm, double errThldLocCurr, double errThldUsd, int quickApplyFlg, int scanUsdDecNbr, int scanLocalDecNbr, int gndUsedFlag, int oacUsedFlag, int collectlaterFlag, int codUsedFlag, int ftcUsedFlag) {
        _countryCd = countryCd;
        _countryNm = countryNm;
        _errThldLocCurr = errThldLocCurr;
        _errThldUsd = errThldUsd;
        _quickApplyFlg = quickApplyFlg;
        _scanUsdDecNbr = scanUsdDecNbr;
        _scanLocalDecNbr = scanLocalDecNbr;
        _gndUsedFlag = gndUsedFlag;
        _oacUsedFlag = oacUsedFlag;
        _collectlaterFlag = collectlaterFlag;
        _codUsedFlag = codUsedFlag;
        _ftcUsedFlag = ftcUsedFlag;
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
     * Set the value of countryNm
     */
    public void setCountryNm(String countryNm) {
        _countryNm = countryNm;
    }

    /**
     * Get the value of countryNm
     */
    public String getCountryNm() {
        return _countryNm;
    }

    /**
     * Set the value of errThldLocCurr
     */
    public void setErrThldLocCurr(double errThldLocCurr) {
        _errThldLocCurr = errThldLocCurr;
    }

    /**
     * Get the value of errThldLocCurr
     */
    public double getErrThldLocCurr() {
        return _errThldLocCurr;
    }

    /**
     * Set the value of errThldUsd
     */
    public void setErrThldUsd(double errThldUsd) {
        _errThldUsd = errThldUsd;
    }

    /**
     * Get the value of errThldUsd
     */
    public double getErrThldUsd() {
        return _errThldUsd;
    }

    /**
     * Set the value of quickApplyFlg
     */
    public void setQuickApplyFlg(int quickApplyFlg) {
        _quickApplyFlg = quickApplyFlg;
    }

    /**
     * Get the value of quickApplyFlg
     */
    public int getQuickApplyFlg() {
        return _quickApplyFlg;
    }

    /**
     * Set the value of scanUsdDecNbr
     */
    public void setScanUsdDecNbr(int scanUsdDecNbr) {
        _scanUsdDecNbr = scanUsdDecNbr;
    }

    /**
     * Get the value of scanUsdDecNbr
     */
    public int getScanUsdDecNbr() {
        return _scanUsdDecNbr;
    }

    /**
     * Set the value of scanLocalDecNbr
     */
    public void setScanLocalDecNbr(int scanLocalDecNbr) {
        _scanLocalDecNbr = scanLocalDecNbr;
    }

    /**
     * Get the value of scanLocalDecNbr
     */
    public int getScanLocalDecNbr() {
        return _scanLocalDecNbr;
    }

    /**
     * Set the value of gndUsedFlag
     */
    public void setGndUsedFlag(int gndUsedFlag) {
        _gndUsedFlag = gndUsedFlag;
    }

    /**
     * Get the value of gndUsedFlag
     */
    public int getGndUsedFlag() {
        return _gndUsedFlag;
    }

    /**
     * Set the value of codUsedFlag
     */
    public void setCodUsedFlag(int codUsedFlag) {
        _codUsedFlag = codUsedFlag;
    }

    /**
     * Get the value of CODUsedFlag
     */
    public int getCodUsedFlag() {
        return _codUsedFlag;
    }

    
    /**
     * Set the value of ftcUsedFlag
     */
    public void setFtcUsedFlag(int ftcUsedFlag) {
        _ftcUsedFlag = ftcUsedFlag;
    }

    /**
     * Get the value of ftcUsedFlag
     */
    public int getFtcUsedFlag() {
        return _ftcUsedFlag;
    }

    
    /**
     * Set the value of oacUsedFlag
     */
    public void setOacUsedFlag(int oacUsedFlag) {
        _oacUsedFlag = oacUsedFlag;
    }

    /**
     * Get the value of oacUsedFlag
     */
    public int getOacUsedFlag() {
        return _oacUsedFlag;
    }

    /**
     * Set the value of collectlaterFlag
     */
    public void setCollectlaterFlag(int collectlaterFlag) {
        _collectlaterFlag = collectlaterFlag;
    }

    /**
     * Get the value of collectlaterFlag
     */
    public int getCollectlaterFlag() {
        return _collectlaterFlag;
    }
    
    /**
     * Get the value of the primary key
     */
    public String getCountryPK() {
        return _countryCd;
    }

    /**
     * Returns a string representation of the value object.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CountryCd: " + _countryCd);
        stringBuffer.append("CountryNm: " + _countryNm);
        stringBuffer.append("ErrThldLocCurr: " + _errThldLocCurr);
        stringBuffer.append("ErrThldUsd: " + _errThldUsd);
        stringBuffer.append("QuickApplyFlg: " + _quickApplyFlg);
        stringBuffer.append("ScanUsdDecNbr: " + _scanUsdDecNbr);
        stringBuffer.append("ScanLocalDecNbr: " + _scanLocalDecNbr);
        stringBuffer.append("GndUsedFlag: " + _gndUsedFlag);
        stringBuffer.append("OacUsedFlag: " + _oacUsedFlag);
        stringBuffer.append("CollectlaterFlag: " + _collectlaterFlag);
        stringBuffer.append("CODUsedFlag: " + _codUsedFlag);
        stringBuffer.append("FTCUsedFlag: " + _ftcUsedFlag);

        return stringBuffer.toString();
    }

}
