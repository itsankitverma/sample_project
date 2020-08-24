/**
 * @(#)DepTemplManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class DepTemplManagerBean implements SessionBean {

    private SessionContext _ctx;
    /**
     * Called by Container. This method initialization the session
     */
    public void ejbCreate() {
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
     * EJB Container calls this method right before it remove the Session bean 
     */
    public void ejbRemove() {
    }

    /**
     * Called by Container. Associates this Bean instance with a particular context environment.
     */
    public void setSessionContext(SessionContext ctx) {
        _ctx = ctx;
    }

    /**
     * This method create new DepTempl object
     * @param depTemplVO a value object the DepTempl bean
     */
    public void setDepTempl(DepTemplVO depTemplVO)
        throws DepTemplException {
        //-- we do not accept null value for the parameter.
        if (depTemplVO == null) {
            throw new IllegalArgumentException("depTemplVO parameter was null in setDepTempl() method from DepTemplManager class");
        }
        
        try {
            
            //-- create new DepTempl object
            getDepTemplLocalHome().create(
                depTemplVO.getTemplCd(),
                depTemplVO.getTemplDesc(),
                depTemplVO.getCrcdReimbTypeCd(),
                depTemplVO.getCurrencyType(),
                depTemplVO.getCntRod(),
                depTemplVO.getCntPrepaid(),
                depTemplVO.getCntPoa(),
                depTemplVO.getCntOther(),
                depTemplVO.getDisabTempl(),
                depTemplVO.getCntGrnd(),
                depTemplVO.getCntCod(),
                depTemplVO.getCntFtc());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setDepTempl() method from DepTemplManager class";
            throw new DepTemplException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setDepTempl() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a DepTempl object
     * @return depTemplVO - a value object of the DepTempl bean
     */
    public DepTemplVO getDepTempl(Integer templId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in getDepTempl() method from DepTemplManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            //-- create new value object to store the data
            DepTemplVO depTemplVO = new DepTemplVO();
            //-- populate the new value object
            depTemplVO.setTemplId(depTemplLocal.getTemplId());
            depTemplVO.setTemplCd(depTemplLocal.getTemplCd());
            depTemplVO.setTemplDesc(depTemplLocal.getTemplDesc());
            depTemplVO.setCrcdReimbTypeCd(depTemplLocal.getCrcdReimbTypeCd());
            depTemplVO.setCurrencyType(depTemplLocal.getCurrencyType());
            depTemplVO.setCntRod(depTemplLocal.getCntRod());
            depTemplVO.setCntPrepaid(depTemplLocal.getCntPrepaid());
            depTemplVO.setCntPoa(depTemplLocal.getCntPoa());
            depTemplVO.setCntOther(depTemplLocal.getCntOther());
            depTemplVO.setDisabTempl(depTemplLocal.getDisabTempl());
            depTemplVO.setCntGrnd(depTemplLocal.getCntGrnd());
            depTemplVO.setCntCod(depTemplLocal.getCntCod());
            depTemplVO.setCntFtc(depTemplLocal.getCntFtc());
            return depTemplVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepTempl() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Location object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer templId, String locationCd)
        throws DepTemplException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in addLocation() method from DepTemplManager class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addLocation() method from DepTemplManager class");
        }
        
        try {
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            depTemplLocal.addLocation(locationLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addLocation() method from DepTemplManager class";
            throw new DepTemplException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addLocation() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Location object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer templId, String locationCd)
        throws DepTemplException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removeLocation() method from DepTemplManager class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from DepTemplManager class");
        }
        
        try {
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            depTemplLocal.removeLocation(locationLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removeLocation() method from DepTemplManager class";
            throw new DepTemplException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeLocation() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets Location objects from the DepTempl object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer templId)
        throws DepTemplException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in getLocations() method from DepTemplManager class");
        }
        
        try {
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            Set locationCol = depTemplLocal.getLocations();
            Collection list = new ArrayList();
            if (locationCol != null) {
                Iterator it = locationCol.iterator();
                while (it.hasNext()) {
                    LocationLocal locationLocal = (LocationLocal) it.next();
                    String locationCd = (String)locationLocal.getPrimaryKey();
                    LocationVO locationVO = getLocationManager().getLocation(locationCd);
                    list.add(locationVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getLocations() method from DepTemplManager class";
            throw new DepTemplException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getLocations() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the PaymentType object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void addPaymentType(Integer templId, Integer paymentTypeId)
        throws DepTemplException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in addPaymentType() method from DepTemplManager class");
        }
        
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in addPaymentType() method from DepTemplManager class");
        }
        
        try {
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            depTemplLocal.addPaymentType(paymentTypeLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addPaymentType() method from DepTemplManager class";
            throw new DepTemplException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addPaymentType() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the PaymentType object to the DepTempl object
     * @param templId a primary key of DepTempl object
     * @param paymentTypeId a primary key of PaymentType object
     */
    public void removePaymentType(Integer templId, Integer paymentTypeId)
        throws DepTemplException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removePaymentType() method from DepTemplManager class");
        }
        
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removePaymentType() method from DepTemplManager class");
        }
        
        try {
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            depTemplLocal.removePaymentType(paymentTypeLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removePaymentType() method from DepTemplManager class";
            throw new DepTemplException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePaymentType() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets PaymentType objects from the DepTempl object
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypes(Integer templId)
        throws DepTemplException {
        //-- we do not accept null values for any parameters.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in getPaymentTypes() method from DepTemplManager class");
        }
        
        try {
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            Set paymentTypeCol = depTemplLocal.getPaymentTypes();
            Collection list = new ArrayList();
            if (paymentTypeCol != null) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    PaymentTypeVO paymentTypeVO = getPaymentTypeManager().getPaymentType(paymentTypeId);
                    list.add(paymentTypeVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPaymentTypes() method from DepTemplManager class";
            throw new DepTemplException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypes() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing DepTempl object
     * @param templId - the DepTempl bean primary key
     */
    public void removeDepTempl(Integer templId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removeDepTempl() method from DepTemplManager class");
        }
        
        try {
            getDepTemplLocalHome().remove(templId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing DepTempl object
     * @param depTemplVO - the value object of the DepTempl bean
     */
    public void updateDepTempl(DepTemplVO depTemplVO)
        throws DepTemplException {
        //-- we do not accept null value for the parameter.
        if (depTemplVO == null) {
            throw new IllegalArgumentException("depTemplVO parameter was null in updateDepTempl() method from DepTemplManager class");
        }
        
        try {
            Integer templId = depTemplVO.getTemplId();
            
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            //-- update DepTempl entity bean
            depTemplLocal.setTemplCd(depTemplVO.getTemplCd());
            depTemplLocal.setTemplDesc(depTemplVO.getTemplDesc());
            depTemplLocal.setCrcdReimbTypeCd(depTemplVO.getCrcdReimbTypeCd());
            depTemplLocal.setCurrencyType(depTemplVO.getCurrencyType());
            depTemplLocal.setCntRod(depTemplVO.getCntRod());
            depTemplLocal.setCntPrepaid(depTemplVO.getCntPrepaid());
            depTemplLocal.setCntPoa(depTemplVO.getCntPoa());
            depTemplLocal.setCntOther(depTemplVO.getCntOther());
            depTemplLocal.setDisabTempl(depTemplVO.getDisabTempl());
            depTemplLocal.setCntGrnd(depTemplVO.getCntGrnd());
            depTemplLocal.setCntCod(depTemplVO.getCntCod());
            depTemplLocal.setCntFtc(depTemplVO.getCntFtc());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateDepTempl() method from DepTemplManager class";
            throw new DepTemplException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateDepTempl() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllDepTempls objects
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getAllDepTempls() {
        try {
            //-- gets the local home interface and call the findAllDepTempls method
            Collection depTemplCol = getDepTemplLocalHome().findAllDepTempls();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depTemplCol != null && depTemplCol.size() > 0) {
                Iterator it = depTemplCol.iterator();
                while (it.hasNext()) {
                    DepTemplLocal depTemplLocal = (DepTemplLocal) it.next();
                    //-- get the primary key of the DepTempl EJB object
                    Integer templId = (Integer)depTemplLocal.getPrimaryKey();
                    //-- get the value object for the DepTempl EJB using the primary key
                    if (templId != null) {
                        DepTemplVO depTemplVO = getDepTempl(templId);
                        //-- add the value object to the collection
                        list.add(depTemplVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllDepTempls() method from DepTemplManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllDepTempls() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllActiveDepTempls objects
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getAllActiveDepTempls() {
        try {
            //-- gets the local home interface and call the findAllActiveDepTempls method
            Collection depTemplCol = getDepTemplLocalHome().findAllActiveDepTempls();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depTemplCol != null && depTemplCol.size() > 0) {
                Iterator it = depTemplCol.iterator();
                while (it.hasNext()) {
                    DepTemplLocal depTemplLocal = (DepTemplLocal) it.next();
                    //-- get the primary key of the DepTempl EJB object
                    Integer templId = (Integer)depTemplLocal.getPrimaryKey();
                    //-- get the value object for the DepTempl EJB using the primary key
                    if (templId != null) {
                        DepTemplVO depTemplVO = getDepTempl(templId);
                        //-- add the value object to the collection
                        list.add(depTemplVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllActiveDepTempls() method from DepTemplManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllActiveDepTempls() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findDepTemplsbyCode objects
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getDepTemplDepTemplsbyCode(String templCd) {
        try {
            //-- gets the local home interface and call the findDepTemplsbyCode method
            Collection depTemplCol = getDepTemplLocalHome().findDepTemplsbyCode(templCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depTemplCol != null && depTemplCol.size() > 0) {
                Iterator it = depTemplCol.iterator();
                while (it.hasNext()) {
                    DepTemplLocal depTemplLocal = (DepTemplLocal) it.next();
                    //-- get the primary key of the DepTempl EJB object
                    Integer templId = (Integer)depTemplLocal.getPrimaryKey();
                    //-- get the value object for the DepTempl EJB using the primary key
                    if (templId != null) {
                        DepTemplVO depTemplVO = getDepTempl(templId);
                        //-- add the value object to the collection
                        list.add(depTemplVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getDepTemplDepTemplsbyCode() method from DepTemplManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepTemplDepTemplsbyCode() method from DepTemplManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the DepTempl local home interface
     */
    private DepTemplLocalHome getDepTemplLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (DepTemplLocalHome) service.getEJBLocalHome(ServiceConstants.DEPTEMPL_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Location local home interface
     */
    private LocationLocalHome getLocationLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (LocationLocalHome) service.getEJBLocalHome(ServiceConstants.LOCATION_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PaymentType local home interface
     */
    private PaymentTypeLocalHome getPaymentTypeLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PaymentTypeLocalHome) service.getEJBLocalHome(ServiceConstants.PAYMENTTYPE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPaymentTypeLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the LocationManager remote interface
     */
    public LocationManager getLocationManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            LocationManagerHome locationManagerHome = (LocationManagerHome)
            service.getEJBHome(ServiceConstants.LOCATIONMANAGER_REMOTE_JNDI, LocationManagerHome.class);
            return locationManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PaymentTypeManager remote interface
     */
    public PaymentTypeManager getPaymentTypeManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PaymentTypeManagerHome paymentTypeManagerHome = (PaymentTypeManagerHome)
            service.getEJBHome(ServiceConstants.PAYMENTTYPEMANAGER_REMOTE_JNDI, PaymentTypeManagerHome.class);
            return paymentTypeManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPaymentTypeManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
