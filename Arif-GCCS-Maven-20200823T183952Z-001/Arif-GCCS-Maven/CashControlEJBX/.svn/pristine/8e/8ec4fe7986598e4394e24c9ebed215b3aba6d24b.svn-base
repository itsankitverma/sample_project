/**
 * @(#)LocationBean.java			Tue Aug 02 15:38:49 VET 2005
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

public abstract class LocationBean implements EntityBean {

    private EntityContext _ctx;
    public LocationBean() {
    }
    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public abstract void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public abstract String getLocationCd();

    /**
     * Set the value of locationNm
     * @param locationNm - String of locationNm
     */
    public abstract void setLocationNm(String locationNm);

    /**
     * Get the value of locationNm
     * @return locationNm - String of locationNm
     */
    public abstract String getLocationNm();

    /**
     * Set the value of locationType
     * @param locationType - String of locationType
     */
    public abstract void setLocationType(String locationType);

    /**
     * Get the value of locationType
     * @return locationType - String of locationType
     */
    public abstract String getLocationType();

    /**
     * Set the value of locationTmZn
     * @param locationTmZn - String of locationTmZn
     */
    public abstract void setLocationTmZn(String locationTmZn);

    /**
     * Get the value of locationTmZn
     * @return locationTmZn - String of locationTmZn
     */
    public abstract String getLocationTmZn();

    /**
     * Set the value of locationGmtOffset
     * @param locationGmtOffset - int of locationGmtOffset
     */
    public abstract void setLocationGmtOffset(int locationGmtOffset);

    /**
     * Get the value of locationGmtOffset
     * @return locationGmtOffset - int of locationGmtOffset
     */
    public abstract int getLocationGmtOffset();

    /**
     * Set the value of splitDepBySrc
     * @param splitDepBySrc - int of splitDepBySrc
     */
    public abstract void setSplitDepBySrc(int splitDepBySrc);

    /**
     * Get the value of splitDepBySrc
     * @return splitDepBySrc - int of splitDepBySrc
     */
    public abstract int getSplitDepBySrc();

    /**
     * Set the value of splitDepByCurr
     * @param splitDepByCurr - int of splitDepByCurr
     */
    public abstract void setSplitDepByCurr(int splitDepByCurr);

    /**
     * Get the value of splitDepByCurr
     * @return splitDepByCurr - int of splitDepByCurr
     */
    public abstract int getSplitDepByCurr();

    /**
     * Set the value of splitDepByPymtType
     * @param splitDepByPymtType - int of splitDepByPymtType
     */
    public abstract void setSplitDepByPymtType(int splitDepByPymtType);

    /**
     * Get the value of splitDepByPymtType
     * @return splitDepByPymtType - int of splitDepByPymtType
     */
    public abstract int getSplitDepByPymtType();

    /**
     * Set the value of localDefaultAcc
     * @param localDefaultAcc - int of localDefaultAcc
     */
    public abstract void setLocalDefaultAcc(int localDefaultAcc);

    /**
     * Get the value of localDefaultAcc
     * @return localDefaultAcc - int of localDefaultAcc
     */
    public abstract int getLocalDefaultAcc();

    /**
     * Set the value of usdDefaultAcc
     * @param usdDefaultAcc - int of usdDefaultAcc
     */
    public abstract void setUsdDefaultAcc(int usdDefaultAcc);

    /**
     * Get the value of usdDefaultAcc
     * @return usdDefaultAcc - int of usdDefaultAcc
     */
    public abstract int getUsdDefaultAcc();

    /**
     * Set the value of manCreditCard
     * @param manCreditCard - int of manCreditCard
     */
    public abstract void setManCreditCard(int manCreditCard);

    /**
     * Get the value of manCreditCard
     * @return manCreditCard - int of manCreditCard
     */
    public abstract int getManCreditCard();

    /**
     * Set the value of creditCardPymtType
     * @param creditCardPymtType - String of creditCardPymtType
     */
    public abstract void setCreditCardPymtType(String creditCardPymtType);

    /**
     * Get the value of creditCardPymtType
     * @return creditCardPymtType - String of creditCardPymtType
     */
    public abstract String getCreditCardPymtType();

    /**
     * Set the value of allowPrpDelay
     * @param allowPrpDelay - int of allowPrpDelay
     */
    public abstract void setAllowPrpDelay(int allowPrpDelay);

    /**
     * Get the value of allowPrpDelay
     * @return allowPrpDelay - int of allowPrpDelay
     */
    public abstract int getAllowPrpDelay();

    /**
     * Set the value of activeLocation
     * @param activeLocation - int of activeLocation
     */
    public abstract void setActiveLocation(int activeLocation);

    /**
     * Get the value of activeLocation
     * @return activeLocation - int of activeLocation
     */
    public abstract int getActiveLocation();

    /**
     * Set the value of depoCurrencyDef
     * @param depoCurrencyDef - int of depoCurrencyDef
     */
    public abstract void setDepoCurrencyDef(int depoCurrencyDef);

    /**
     * Get the value of depoCurrencyDef
     * @return depoCurrencyDef - int of depoCurrencyDef
     */
    public abstract int getDepoCurrencyDef();

    /**
     * Set the value of prScanRfshFlg
     * @param prScanRfshFlg - int of prScanRfshFlg
     */
    public abstract void setPrScanRfshFlg(int prScanRfshFlg);

    /**
     * Get the value of prScanRfshFlg
     * @return prScanRfshFlg - int of prScanRfshFlg
     */
    public abstract int getPrScanRfshFlg();

    /**
     * Set the value of prScanRfshIntvlNbr
     * @param prScanRfshIntvlNbr - int of prScanRfshIntvlNbr
     */
    public abstract void setPrScanRfshIntvlNbr(int prScanRfshIntvlNbr);

    /**
     * Get the value of prScanRfshIntvlNbr
     * @return prScanRfshIntvlNbr - int of prScanRfshIntvlNbr
     */
    public abstract int getPrScanRfshIntvlNbr();

    /**
     * Set the value of holdLocation
     * @param holdLocation - int of holdLocation
     */
    public abstract void setHoldLocation(int holdLocation);

    /**
     * Get the value of holdLocation
     * @return holdLocation - int of holdLocation
     */
    public abstract int getHoldLocation();

    /**
     * Set the value of dualCurrFlg
     * @param dualCurrFlg - int of dualCurrFlg
     */
    public abstract void setDualCurrFlg(int dualCurrFlg);

    /**
     * Get the value of dualCurrFlg
     * @return dualCurrFlg - int of dualCurrFlg
     */
    public abstract int getDualCurrFlg();

    /**
     * Set the value of inCageTskIdNbr
     * @param inCageTskIdNbr - int of inCageTskIdNbr
     */
    public abstract void setInCageTskIdNbr(int inCageTskIdNbr);

    /**
     * Get the value of inCageTskIdNbr
     * @return inCageTskIdNbr - int of inCageTskIdNbr
     */
    public abstract int getInCageTskIdNbr();

    /**
     * Set the value of rihTskIdNbr
     * @param rihTskIdNbr - int of rihTskIdNbr
     */
    public abstract void setRihTskIdNbr(int rihTskIdNbr);

    /**
     * Get the value of rihTskIdNbr
     * @return rihTskIdNbr - int of rihTskIdNbr
     */
    public abstract int getRihTskIdNbr();

    /**
     * Set the value of parentLocationCd
     * @param parentLocationCd - String of parentLocationCd
     */
    public abstract void setParentLocationCd(String parentLocationCd);

    /**
     * Get the value of parentLocationCd
     * @return parentLocationCd - String of parentLocationCd
     */
    public abstract String getParentLocationCd();

    /**
     * Add a new Employee
     * @param employee - Employee employee
     */
    public void addEmployee(EmployeeLocal employee) {
        java.util.Set employeesCol = getEmployees();
        employeesCol.add(employee);
    }

    /**
     * Remove a Employee
     * @param employee - Employee employee
     */
    public void removeEmployee(EmployeeLocal employee) {
        java.util.Set employeesCol = getEmployees();
        employeesCol.remove(employee);
    }

    /**
     * Set the value of employees
     * @param employees - java.util.Set of employees
     */
    public abstract void setEmployees(java.util.Set employees);

    /**
     * Get the value of employees
     * @return employees - java.util.Set of employees
     */
    public abstract java.util.Set getEmployees();

    /**
     * Add a new PaymentType
     * @param paymentType - PaymentType paymentType
     */
    public void addPaymentType(PaymentTypeLocal paymentType) {
        java.util.Set paymentTypesCol = getPaymentTypes();
        paymentTypesCol.add(paymentType);
    }

    /**
     * Remove a PaymentType
     * @param paymentType - PaymentType paymentType
     */
    public void removePaymentType(PaymentTypeLocal paymentType) {
        java.util.Set paymentTypesCol = getPaymentTypes();
        paymentTypesCol.remove(paymentType);
    }

    /**
     * Set the value of paymentTypes
     * @param paymentTypes - java.util.Set of paymentTypes
     */
    public abstract void setPaymentTypes(java.util.Set paymentTypes);

    /**
     * Get the value of paymentTypes
     * @return paymentTypes - java.util.Set of paymentTypes
     */
    public abstract java.util.Set getPaymentTypes();

    /**
     * Add a new BankAcc
     * @param bankAcc - BankAcc bankAcc
     */
    public void addBankAcc(BankAccLocal bankAcc) {
        java.util.Set bankAccsCol = getBankAccs();
        bankAccsCol.add(bankAcc);
    }

    /**
     * Remove a BankAcc
     * @param bankAcc - BankAcc bankAcc
     */
    public void removeBankAcc(BankAccLocal bankAcc) {
        java.util.Set bankAccsCol = getBankAccs();
        bankAccsCol.remove(bankAcc);
    }

    /**
     * Set the value of bankAccs
     * @param bankAccs - java.util.Set of bankAccs
     */
    public abstract void setBankAccs(java.util.Set bankAccs);

    /**
     * Get the value of bankAccs
     * @return bankAccs - java.util.Set of bankAccs
     */
    public abstract java.util.Set getBankAccs();

    /**
     * Set the value of country
     * @param country - CountryLocal of country
     */
    public abstract void setCountry(CountryLocal country);

    /**
     * Get the value of country
     * @return country - CountryLocal of country
     */
    public abstract CountryLocal getCountry();

    /**
     * Add a new DepTempl
     * @param depTempl - DepTempl depTempl
     */
    public void addDepTempl(DepTemplLocal depTempl) {
        java.util.Set depTemplsCol = getDepTempls();
        depTemplsCol.add(depTempl);
    }

    /**
     * Remove a DepTempl
     * @param depTempl - DepTempl depTempl
     */
    public void removeDepTempl(DepTemplLocal depTempl) {
        java.util.Set depTemplsCol = getDepTempls();
        depTemplsCol.remove(depTempl);
    }

    /**
     * Set the value of depTempls
     * @param depTempls - java.util.Set of depTempls
     */
    public abstract void setDepTempls(java.util.Set depTempls);

    /**
     * Get the value of depTempls
     * @return depTempls - java.util.Set of depTempls
     */
    public abstract java.util.Set getDepTempls();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.String ejbCreate(String locationCd, String locationNm, String locationType, String locationTmZn, int locationGmtOffset, CountryLocal country, int splitDepBySrc, int splitDepByCurr, int splitDepByPymtType, int localDefaultAcc, int usdDefaultAcc, int manCreditCard, String creditCardPymtType, int allowPrpDelay, int activeLocation, int depoCurrencyDef, int prScanRfshFlg, int prScanRfshIntvlNbr, String parentLocationCd)
        throws CreateException {
        setLocationCd(locationCd);
        setLocationNm(locationNm);
        setLocationType(locationType);
        setLocationTmZn(locationTmZn);
        setLocationGmtOffset(locationGmtOffset);
        setSplitDepBySrc(splitDepBySrc);
        setSplitDepByCurr(splitDepByCurr);
        setSplitDepByPymtType(splitDepByPymtType);
        setLocalDefaultAcc(localDefaultAcc);
        setUsdDefaultAcc(usdDefaultAcc);
        setManCreditCard(manCreditCard);
        setCreditCardPymtType(creditCardPymtType);
        setAllowPrpDelay(allowPrpDelay);
        setActiveLocation(activeLocation);
        setDepoCurrencyDef(depoCurrencyDef);
        setPrScanRfshFlg(prScanRfshFlg);
        setPrScanRfshIntvlNbr(prScanRfshIntvlNbr);
        setParentLocationCd(parentLocationCd);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String locationCd, String locationNm, String locationType, String locationTmZn, int locationGmtOffset, CountryLocal country, int splitDepBySrc, int splitDepByCurr, int splitDepByPymtType, int localDefaultAcc, int usdDefaultAcc, int manCreditCard, String creditCardPymtType, int allowPrpDelay, int activeLocation, int depoCurrencyDef, int prScanRfshFlg, int prScanRfshIntvlNbr, String parentLocationCd)
        throws CreateException {
        setCountry(country);
    }

    /**
     * Called by Container.  Associates this Bean instance with a particular context environment.
     */
    public void setEntityContext(EntityContext ctx) {
        _ctx = ctx;
    }

    /**
     * Called by Container.  Disassociates this Bean instance with a particular 
     * context.  Once done, we can query the Context for environment information
     */
    public void unsetEntityContext() {
        _ctx = null;
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * Called by Container.  Updates the entity bean instance to reflect 
     * the current value stored in the database.
     */
    public void ejbLoad() {
    }

    /**
     * Called by Container.  Updates the database to reflect the current values 
     * of this in-memory Entity Bean instance representation.
     */
    public void ejbStore() {
    }

    /**
     * EJB Container calls this method right before it remove the Entity bean 
     * from the database.  Corresponds to when client calls home.remove().
     */
    public void ejbRemove() {
    }

}
