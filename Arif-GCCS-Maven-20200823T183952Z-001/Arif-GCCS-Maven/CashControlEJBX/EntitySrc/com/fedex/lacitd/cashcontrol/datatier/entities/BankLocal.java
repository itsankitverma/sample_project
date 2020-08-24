/**
 * @(#)BankLocal.java			Tue Aug 02 15:38:49 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface BankLocal extends EJBLocalObject {

    /**
     * Set the value of bankId
     * @param bankId - Integer of bankId
     */
    public void setBankId(Integer bankId);

    /**
     * Get the value of bankId
     * @return bankId - Integer of bankId
     */
    public Integer getBankId();

    /**
     * Set the value of bankNm
     * @param bankNm - String of bankNm
     */
    public void setBankNm(String bankNm);

    /**
     * Get the value of bankNm
     * @return bankNm - String of bankNm
     */
    public String getBankNm();

    /**
     * Set the value of bankCd
     * @param bankCd - String of bankCd
     */
    public void setBankCd(String bankCd);

    /**
     * Get the value of bankCd
     * @return bankCd - String of bankCd
     */
    public String getBankCd();

    /**
     * Set the value of bankShtDesc
     * @param bankShtDesc - String of bankShtDesc
     */
    public void setBankShtDesc(String bankShtDesc);

    /**
     * Get the value of bankShtDesc
     * @return bankShtDesc - String of bankShtDesc
     */
    public String getBankShtDesc();

    /**
     * Set the value of bankAccs
     * @param bankAccs - java.util.Set of bankAccs
     */
    public void setBankAccs(java.util.Set bankAccs);

    /**
     * Get the value of bankAccs
     * @return bankAccs - java.util.Set of bankAccs
     */
    public java.util.Set getBankAccs();

    /**
     * Set the value of country
     * @param country - CountryLocal of country
     */
    public void setCountry(CountryLocal country);

    /**
     * Get the value of country
     * @return country - CountryLocal of country
     */
    public CountryLocal getCountry();

}
