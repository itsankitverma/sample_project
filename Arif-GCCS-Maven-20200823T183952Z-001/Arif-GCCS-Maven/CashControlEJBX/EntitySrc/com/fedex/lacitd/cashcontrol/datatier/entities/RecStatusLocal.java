/**
 * @(#)RecStatusLocal.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the rec_status table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface RecStatusLocal extends EJBLocalObject {

    /**
     * Set the value of statusId
     * @param statusId - Integer of statusId
     */
    public void setStatusId(Integer statusId);

    /**
     * Get the value of statusId
     * @return statusId - Integer of statusId
     */
    public Integer getStatusId();

    /**
     * Set the value of description
     * @param description - String of description
     */
    public void setDescription(String description);

    /**
     * Get the value of description
     * @return description - String of description
     */
    public String getDescription();

    /**
     * Set the value of rodPgFlg
     * @param rodPgFlg - int of rodPgFlg
     */
    public void setRodPgFlg(int rodPgFlg);

    /**
     * Get the value of rodPgFlg
     * @return rodPgFlg - int of rodPgFlg
     */
    public int getRodPgFlg();

}
