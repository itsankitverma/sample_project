/**
 * @(#)LocationLocal.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the location table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public interface LocationLocal extends EJBLocalObject {

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
     * Set the value of locationNm
     * @param locationNm - String of locationNm
     */
    public void setLocationNm(String locationNm);

    /**
     * Get the value of locationNm
     * @return locationNm - String of locationNm
     */
    public String getLocationNm();

    /**
     * Set the value of locationType
     * @param locationType - String of locationType
     */
    public void setLocationType(String locationType);

    /**
     * Get the value of locationType
     * @return locationType - String of locationType
     */
    public String getLocationType();

    /**
     * Set the value of locationTmZn
     * @param locationTmZn - String of locationTmZn
     */
    public void setLocationTmZn(String locationTmZn);

    /**
     * Get the value of locationTmZn
     * @return locationTmZn - String of locationTmZn
     */
    public String getLocationTmZn();

    /**
     * Set the value of locationGmtOffset
     * @param locationGmtOffset - int of locationGmtOffset
     */
    public void setLocationGmtOffset(int locationGmtOffset);

    /**
     * Get the value of locationGmtOffset
     * @return locationGmtOffset - int of locationGmtOffset
     */
    public int getLocationGmtOffset();

    /**
     * Set the value of splitDepBySrc
     * @param splitDepBySrc - int of splitDepBySrc
     */
    public void setSplitDepBySrc(int splitDepBySrc);

    /**
     * Get the value of splitDepBySrc
     * @return splitDepBySrc - int of splitDepBySrc
     */
    public int getSplitDepBySrc();

    /**
     * Set the value of splitDepByCurr
     * @param splitDepByCurr - int of splitDepByCurr
     */
    public void setSplitDepByCurr(int splitDepByCurr);

    /**
     * Get the value of splitDepByCurr
     * @return splitDepByCurr - int of splitDepByCurr
     */
    public int getSplitDepByCurr();

    /**
     * Set the value of splitDepByPymtType
     * @param splitDepByPymtType - int of splitDepByPymtType
     */
    public void setSplitDepByPymtType(int splitDepByPymtType);

    /**
     * Get the value of splitDepByPymtType
     * @return splitDepByPymtType - int of splitDepByPymtType
     */
    public int getSplitDepByPymtType();

    /**
     * Set the value of localDefaultAcc
     * @param localDefaultAcc - int of localDefaultAcc
     */
    public void setLocalDefaultAcc(int localDefaultAcc);

    /**
     * Get the value of localDefaultAcc
     * @return localDefaultAcc - int of localDefaultAcc
     */
    public int getLocalDefaultAcc();

    /**
     * Set the value of usdDefaultAcc
     * @param usdDefaultAcc - int of usdDefaultAcc
     */
    public void setUsdDefaultAcc(int usdDefaultAcc);

    /**
     * Get the value of usdDefaultAcc
     * @return usdDefaultAcc - int of usdDefaultAcc
     */
    public int getUsdDefaultAcc();

    /**
     * Set the value of manCreditCard
     * @param manCreditCard - int of manCreditCard
     */
    public void setManCreditCard(int manCreditCard);

    /**
     * Get the value of manCreditCard
     * @return manCreditCard - int of manCreditCard
     */
    public int getManCreditCard();

    /**
     * Set the value of creditCardPymtType
     * @param creditCardPymtType - String of creditCardPymtType
     */
    public void setCreditCardPymtType(String creditCardPymtType);

    /**
     * Get the value of creditCardPymtType
     * @return creditCardPymtType - String of creditCardPymtType
     */
    public String getCreditCardPymtType();

    /**
     * Set the value of allowPrpDelay
     * @param allowPrpDelay - int of allowPrpDelay
     */
    public void setAllowPrpDelay(int allowPrpDelay);

    /**
     * Get the value of allowPrpDelay
     * @return allowPrpDelay - int of allowPrpDelay
     */
    public int getAllowPrpDelay();

    /**
     * Set the value of activeLocation
     * @param activeLocation - int of activeLocation
     */
    public void setActiveLocation(int activeLocation);

    /**
     * Get the value of activeLocation
     * @return activeLocation - int of activeLocation
     */
    public int getActiveLocation();

    /**
     * Set the value of depoCurrencyDef
     * @param depoCurrencyDef - int of depoCurrencyDef
     */
    public void setDepoCurrencyDef(int depoCurrencyDef);

    /**
     * Get the value of depoCurrencyDef
     * @return depoCurrencyDef - int of depoCurrencyDef
     */
    public int getDepoCurrencyDef();

    /**
     * Set the value of prScanRfshFlg
     * @param prScanRfshFlg - int of prScanRfshFlg
     */
    public void setPrScanRfshFlg(int prScanRfshFlg);

    /**
     * Get the value of prScanRfshFlg
     * @return prScanRfshFlg - int of prScanRfshFlg
     */
    public int getPrScanRfshFlg();

    /**
     * Set the value of prScanRfshIntvlNbr
     * @param prScanRfshIntvlNbr - int of prScanRfshIntvlNbr
     */
    public void setPrScanRfshIntvlNbr(int prScanRfshIntvlNbr);

    /**
     * Get the value of prScanRfshIntvlNbr
     * @return prScanRfshIntvlNbr - int of prScanRfshIntvlNbr
     */
    public int getPrScanRfshIntvlNbr();

    /**
     * Set the value of holdLocation
     * @param holdLocation - int of holdLocation
     */
    public void setHoldLocation(int holdLocation);

    /**
     * Get the value of holdLocation
     * @return holdLocation - int of holdLocation
     */
    public int getHoldLocation();

    /**
     * Set the value of dualCurrFlg
     * @param dualCurrFlg - int of dualCurrFlg
     */
    public void setDualCurrFlg(int dualCurrFlg);

    /**
     * Get the value of dualCurrFlg
     * @return dualCurrFlg - int of dualCurrFlg
     */
    public int getDualCurrFlg();

    /**
     * Set the value of inCageTskIdNbr
     * @param inCageTskIdNbr - int of inCageTskIdNbr
     */
    public void setInCageTskIdNbr(int inCageTskIdNbr);

    /**
     * Get the value of inCageTskIdNbr
     * @return inCageTskIdNbr - int of inCageTskIdNbr
     */
    public int getInCageTskIdNbr();

    /**
     * Set the value of rihTskIdNbr
     * @param rihTskIdNbr - int of rihTskIdNbr
     */
    public void setRihTskIdNbr(int rihTskIdNbr);

    /**
     * Get the value of rihTskIdNbr
     * @return rihTskIdNbr - int of rihTskIdNbr
     */
    public int getRihTskIdNbr();

    /**
     * Set the value of parentLocationCd
     * @param parentLocationCd - String of parentLocationCd
     */
    public void setParentLocationCd(String parentLocationCd);

    /**
     * Get the value of parentLocationCd
     * @return parentLocationCd - String of parentLocationCd
     */
    public String getParentLocationCd();

    /**
     * Adds a new Employee
     * @param employee - Employee employee
     */
    public void addEmployee(EmployeeLocal employee);

    /**
     * Removes a Employee
     * @param employee - Employee employee
     */
    public void removeEmployee(EmployeeLocal employee);

    /**
     * Set the value of employees
     * @param employees - java.util.Set of employees
     */
    public void setEmployees(java.util.Set employees);

    /**
     * Get the value of employees
     * @return employees - java.util.Set of employees
     */
    public java.util.Set getEmployees();

    /**
     * Adds a new PaymentType
     * @param paymentType - PaymentType paymentType
     */
    public void addPaymentType(PaymentTypeLocal paymentType);

    /**
     * Removes a PaymentType
     * @param paymentType - PaymentType paymentType
     */
    public void removePaymentType(PaymentTypeLocal paymentType);

    /**
     * Set the value of paymentTypes
     * @param paymentTypes - java.util.Set of paymentTypes
     */
    public void setPaymentTypes(java.util.Set paymentTypes);

    /**
     * Get the value of paymentTypes
     * @return paymentTypes - java.util.Set of paymentTypes
     */
    public java.util.Set getPaymentTypes();

    /**
     * Adds a new BankAcc
     * @param bankAcc - BankAcc bankAcc
     */
    public void addBankAcc(BankAccLocal bankAcc);

    /**
     * Removes a BankAcc
     * @param bankAcc - BankAcc bankAcc
     */
    public void removeBankAcc(BankAccLocal bankAcc);

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

    /**
     * Adds a new DepTempl
     * @param depTempl - DepTempl depTempl
     */
    public void addDepTempl(DepTemplLocal depTempl);

    /**
     * Removes a DepTempl
     * @param depTempl - DepTempl depTempl
     */
    public void removeDepTempl(DepTemplLocal depTempl);

    /**
     * Set the value of depTempls
     * @param depTempls - java.util.Set of depTempls
     */
    public void setDepTempls(java.util.Set depTempls);

    /**
     * Get the value of depTempls
     * @return depTempls - java.util.Set of depTempls
     */
    public java.util.Set getDepTempls();

}
