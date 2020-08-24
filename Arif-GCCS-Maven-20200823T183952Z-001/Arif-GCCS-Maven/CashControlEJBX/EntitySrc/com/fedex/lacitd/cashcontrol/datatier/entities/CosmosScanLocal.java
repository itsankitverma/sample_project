/**
 * @(#)CosmosScanLocal.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the cosmos_scan table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface CosmosScanLocal extends EJBLocalObject {

    /**
     * Set the value of scanId
     * @param scanId - Integer of scanId
     */
    public void setScanId(Integer scanId);

    /**
     * Get the value of scanId
     * @return scanId - Integer of scanId
     */
    public Integer getScanId();

    /**
     * Set the value of scanLocationCd
     * @param scanLocationCd - String of scanLocationCd
     */
    public void setScanLocationCd(String scanLocationCd);

    /**
     * Get the value of scanLocationCd
     * @return scanLocationCd - String of scanLocationCd
     */
    public String getScanLocationCd();

    /**
     * Set the value of awbNbr
     * @param awbNbr - String of awbNbr
     */
    public void setAwbNbr(String awbNbr);

    /**
     * Get the value of awbNbr
     * @return awbNbr - String of awbNbr
     */
    public String getAwbNbr();

    /**
     * Set the value of tinUniqId
     * @param tinUniqId - String of tinUniqId
     */
    public void setTinUniqId(String tinUniqId);

    /**
     * Get the value of tinUniqId
     * @return tinUniqId - String of tinUniqId
     */
    public String getTinUniqId();

    /**
     * Set the value of scanType
     * @param scanType - String of scanType
     */
    public void setScanType(String scanType);

    /**
     * Get the value of scanType
     * @return scanType - String of scanType
     */
    public String getScanType();

    /**
     * Set the value of scanSeqNbr
     * @param scanSeqNbr - String of scanSeqNbr
     */
    public void setScanSeqNbr(String scanSeqNbr);

    /**
     * Get the value of scanSeqNbr
     * @return scanSeqNbr - String of scanSeqNbr
     */
    public String getScanSeqNbr();

    /**
     * Set the value of scanDt
     * @param scanDt - Date of scanDt
     */
    public void setScanDt(Date scanDt);

    /**
     * Get the value of scanDt
     * @return scanDt - Date of scanDt
     */
    public Date getScanDt();

    /**
     * Set the value of courierId
     * @param courierId - String of courierId
     */
    public void setCourierId(String courierId);

    /**
     * Get the value of courierId
     * @return courierId - String of courierId
     */
    public String getCourierId();

}
