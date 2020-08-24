/**
 * @(#)ScanLocProcLocal.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the scan_loc_proc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface ScanLocProcLocal extends EJBLocalObject {

    /**
     * Set the value of scanLocProcId
     * @param scanLocProcId - Integer of scanLocProcId
     */
    public void setScanLocProcId(Integer scanLocProcId);

    /**
     * Get the value of scanLocProcId
     * @return scanLocProcId - Integer of scanLocProcId
     */
    public Integer getScanLocProcId();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public String getLocationCd();

    /**
     * Set the value of procDate
     * @param procDate - Date of procDate
     */
    public void setProcDate(Date procDate);

    /**
     * Get the value of procDate
     * @return procDate - Date of procDate
     */
    public Date getProcDate();

    /**
     * Set the value of result
     * @param result - int of result
     */
    public void setResult(int result);

    /**
     * Get the value of result
     * @return result - int of result
     */
    public int getResult();

}
