/**
 * @(#)PaymentCtgLocal.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the payment_ctg table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface PaymentCtgLocal extends EJBLocalObject {

    /**
     * Set the value of paymentCtgId
     * @param paymentCtgId - Integer of paymentCtgId
     */
    public void setPaymentCtgId(Integer paymentCtgId);

    /**
     * Get the value of paymentCtgId
     * @return paymentCtgId - Integer of paymentCtgId
     */
    public Integer getPaymentCtgId();

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
     * Set the value of canCreatePymt
     * @param canCreatePymt - int of canCreatePymt
     */
    public void setCanCreatePymt(int canCreatePymt);

    /**
     * Get the value of canCreatePymt
     * @return canCreatePymt - int of canCreatePymt
     */
    public int getCanCreatePymt();

}
