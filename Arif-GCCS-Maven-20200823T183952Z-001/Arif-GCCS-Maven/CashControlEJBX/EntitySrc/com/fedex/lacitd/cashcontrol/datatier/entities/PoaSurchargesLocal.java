/**
 * @(#)PoaSurchargesLocal.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the poa_surcharges table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface PoaSurchargesLocal extends EJBLocalObject {

    /**
     * Set the value of poaDetailId
     * @param poaDetailId - Integer of poaDetailId
     */
    public void setPoaDetailId(Integer poaDetailId);

    /**
     * Get the value of poaDetailId
     * @return poaDetailId - Integer of poaDetailId
     */
    public Integer getPoaDetailId();

    /**
     * Set the value of surchargeCd
     * @param surchargeCd - String of surchargeCd
     */
    public void setSurchargeCd(String surchargeCd);

    /**
     * Get the value of surchargeCd
     * @return surchargeCd - String of surchargeCd
     */
    public String getSurchargeCd();

    /**
     * Set the value of appliedAmt
     * @param appliedAmt - double of appliedAmt
     */
    public void setAppliedAmt(double appliedAmt);

    /**
     * Get the value of appliedAmt
     * @return appliedAmt - double of appliedAmt
     */
    public double getAppliedAmt();

}
