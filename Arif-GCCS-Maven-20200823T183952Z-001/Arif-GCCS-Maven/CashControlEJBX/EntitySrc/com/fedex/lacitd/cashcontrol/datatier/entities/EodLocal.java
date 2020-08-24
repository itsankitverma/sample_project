/**
 * @(#)EodLocal.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the eod table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface EodLocal extends EJBLocalObject {

    /**
     * Set the value of eodId
     * @param eodId - Integer of eodId
     */
    public void setEodId(Integer eodId);

    /**
     * Get the value of eodId
     * @return eodId - Integer of eodId
     */
    public Integer getEodId();

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
     * Set the value of eodDt
     * @param eodDt - Date of eodDt
     */
    public void setEodDt(Date eodDt);

    /**
     * Get the value of eodDt
     * @return eodDt - Date of eodDt
     */
    public Date getEodDt();

    /**
     * Set the value of employeeId
     * @param employeeId - String of employeeId
     */
    public void setEmployeeId(String employeeId);

    /**
     * Get the value of employeeId
     * @return employeeId - String of employeeId
     */
    public String getEmployeeId();

}
