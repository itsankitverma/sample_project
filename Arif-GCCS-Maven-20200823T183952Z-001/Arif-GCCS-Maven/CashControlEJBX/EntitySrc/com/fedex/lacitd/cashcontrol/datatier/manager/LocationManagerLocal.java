/**
 * @(#)LocationManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.manager;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public interface LocationManagerLocal extends EJBLocalObject {

    /**
     * This method create new Location object
     * @param locationVO a value object the Location bean
     */
    public void setLocation(LocationVO locationVO)
        throws LocationException;

    /**
     * This method gets a Location object
     * @param locationCd - the Location bean primary key
     * @return locationVO - a value object of the Location bean
     */
    public LocationVO getLocation(String locationCd)
            throws FinderException;

    /**
     * This method adds the Employee object to the Location object
     * @param locationCd a primary key of Location object
     * @param employeeId a primary key of Employee object
     */
    public void addEmployee(String locationCd, String employeeId)
        throws LocationException;

    /**
     * This method removes the Employee object to the Location object
     * @param locationCd a primary key of Location object
     * @param employeeId a primary key of Employee object
     */
    public void removeEmployee(String locationCd, String employeeId)
        throws LocationException;

    /**
     * This method gets Employee objects from the Location object
     * @return Collection - a collection of the Employee objects
     */
    public Collection getEmployees(String locationCd)
        throws LocationException;

    /**
     * This method adds the PaymentType object to the Location object
     * @param locationCd a primary key of Location object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void addPaymentType(String locationCd, Integer paymentTypeId)
        throws LocationException;

    /**
     * This method removes the PaymentType object to the Location object
     * @param locationCd a primary key of Location object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void removePaymentType(String locationCd, Integer paymentTypeId)
        throws LocationException;

    /**
     * This method gets PaymentType objects from the Location object
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypes(String locationCd)
        throws LocationException;

    /**
     * This method adds the BankAcc object to the Location object
     * @param locationCd a primary key of Location object
     * @param bankAccountCd a primary key of BankAcc object
     */
    public void addBankAcc(String locationCd, Integer bankAccountCd)
        throws LocationException;

    /**
     * This method removes the BankAcc object to the Location object
     * @param locationCd a primary key of Location object
     * @param bankAccountCd a primary key of BankAcc object
     */
    public void removeBankAcc(String locationCd, Integer bankAccountCd)
        throws LocationException;

    /**
     * This method gets BankAcc objects from the Location object
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccs(String locationCd)
        throws LocationException;

    /**
     * This method adds the DepTempl object to the Location object
     * @param locationCd a primary key of Location object
     * @param templId a primary key of DepTempl object
     */
    public void addDepTempl(String locationCd, Integer templId)
        throws LocationException;

    /**
     * This method removes the DepTempl object to the Location object
     * @param locationCd a primary key of Location object
     * @param templId a primary key of DepTempl object
     */
    public void removeDepTempl(String locationCd, Integer templId)
        throws LocationException;

    /**
     * This method gets DepTempl objects from the Location object
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getDepTempls(String locationCd)
        throws LocationException;

    /**
     * This method removes an existing Location object
     * @param locationCd - the Location bean primary key
     */
    public void removeLocation(String locationCd)
        throws RemoveException;

    /**
     * This method updates an existing Location object
     * @param locationVO - the value object of the Location bean
     */
    public void updateLocation(LocationVO locationVO)
        throws LocationException;

    /**
     * This method gets findAllLocations objects
     * @return Collection - a collection of the Location objects
     */
    public Collection getAllLocations();

    /**
     * This method gets findByCountryCd objects
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocationByCountryCd(String countryCd);

    /**
     * This method gets findAllParentLocations objects
     * @return Collection - a collection of the Location objects
     */
    public Collection getAllParentLocations(String employeeId);

    /**
     * This method gets findAllPossibleParentLocationsByCountry objects
     * @return Collection - a collection of the Location objects
     */
    public Collection getAllPossibleParentLocationsByCountry(String locCd, String countryCd);

}
