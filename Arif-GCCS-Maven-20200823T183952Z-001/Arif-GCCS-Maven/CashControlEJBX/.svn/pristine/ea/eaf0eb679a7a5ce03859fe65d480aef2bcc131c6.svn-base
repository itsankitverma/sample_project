/**
 * @(#)PaymentTypeManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PaymentTypeManagerBean implements SessionBean {

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
     * This method create new PaymentType object
     * @param paymentTypeVO a value object the PaymentType bean
     */
    public void setPaymentType(PaymentTypeVO paymentTypeVO)
        throws PaymentTypeException {
        //-- we do not accept null value for the parameter.
        if (paymentTypeVO == null) {
            throw new IllegalArgumentException("paymentTypeVO parameter was null in setPaymentType() method from PaymentTypeManager class");
        }
        
        try {
            
            //-- create new PaymentType object
            getPaymentTypeLocalHome().create(
                paymentTypeVO.getDescription(),
                paymentTypeVO.getShtDesc(),
                paymentTypeVO.getPaymentCd(),
                paymentTypeVO.getRodCombo(),
                paymentTypeVO.getPrpCombo(),
                paymentTypeVO.getPoaCombo(),
                paymentTypeVO.getOtherCombo(),
                paymentTypeVO.getCanDeact(),
                paymentTypeVO.getPaymentCtgId(),
                paymentTypeVO.getActivePymt(),
                paymentTypeVO.getGndCombo(),
                paymentTypeVO.getCodCombo(),
                paymentTypeVO.getFtcCombo());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPaymentType() method from PaymentTypeManager class";
            throw new PaymentTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPaymentType() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PaymentType object
     * @return paymentTypeVO - a value object of the PaymentType bean
     */
    public PaymentTypeVO getPaymentType(Integer paymentTypeId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in getPaymentType() method from PaymentTypeManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            //-- create new value object to store the data
            PaymentTypeVO paymentTypeVO = new PaymentTypeVO();
            //-- populate the new value object
            paymentTypeVO.setPaymentTypeId(paymentTypeLocal.getPaymentTypeId());
            paymentTypeVO.setDescription(paymentTypeLocal.getDescription());
            paymentTypeVO.setShtDesc(paymentTypeLocal.getShtDesc());
            paymentTypeVO.setPaymentCd(paymentTypeLocal.getPaymentCd());
            paymentTypeVO.setRodCombo(paymentTypeLocal.getRodCombo());
            paymentTypeVO.setCodCombo(paymentTypeLocal.getCodCombo());
            paymentTypeVO.setFtcCombo(paymentTypeLocal.getFtcCombo());
            paymentTypeVO.setPrpCombo(paymentTypeLocal.getPrpCombo());
            paymentTypeVO.setPoaCombo(paymentTypeLocal.getPoaCombo());
            paymentTypeVO.setOtherCombo(paymentTypeLocal.getOtherCombo());
            paymentTypeVO.setCanDeact(paymentTypeLocal.getCanDeact());
            paymentTypeVO.setPaymentCtgId(paymentTypeLocal.getPaymentCtgId());
            paymentTypeVO.setActivePymt(paymentTypeLocal.getActivePymt());
            paymentTypeVO.setGndCombo(paymentTypeLocal.getGndCombo());
            
            return paymentTypeVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentType() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Location object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer paymentTypeId, String locationCd)
        throws PaymentTypeException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in addLocation() method from PaymentTypeManager class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addLocation() method from PaymentTypeManager class");
        }
        
        try {
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            paymentTypeLocal.addLocation(locationLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addLocation() method from PaymentTypeManager class";
            throw new PaymentTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Location object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer paymentTypeId, String locationCd)
        throws PaymentTypeException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removeLocation() method from PaymentTypeManager class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from PaymentTypeManager class");
        }
        
        try {
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            paymentTypeLocal.removeLocation(locationLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removeLocation() method from PaymentTypeManager class";
            throw new PaymentTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets Location objects from the PaymentType object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer paymentTypeId)
        throws PaymentTypeException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in getLocations() method from PaymentTypeManager class");
        }
        
        try {
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            Set locationCol = paymentTypeLocal.getLocations();
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
            String errorMsg = "Error occurred in getLocations() method from PaymentTypeManager class";
            throw new PaymentTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getLocations() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the DepTempl object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param templId a primary key of DepTempl object
     */
    public void addDepTempl(Integer paymentTypeId, Integer templId)
        throws PaymentTypeException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in addDepTempl() method from PaymentTypeManager class");
        }
        
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in addDepTempl() method from PaymentTypeManager class");
        }
        
        try {
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            paymentTypeLocal.addDepTempl(depTemplLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addDepTempl() method from PaymentTypeManager class";
            throw new PaymentTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addDepTempl() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the DepTempl object to the PaymentType object
     * @param paymentTypeId a primary key of PaymentType object
     * @param templId a primary key of DepTempl object
     */
    public void removeDepTempl(Integer paymentTypeId, Integer templId)
        throws PaymentTypeException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removeDepTempl() method from PaymentTypeManager class");
        }
        
        if (templId == null) {
            throw new IllegalArgumentException("templId parameter was null in removeDepTempl() method from PaymentTypeManager class");
        }
        
        try {
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            DepTemplLocal depTemplLocal = getDepTemplLocalHome().findByPrimaryKey(templId);
            paymentTypeLocal.removeDepTempl(depTemplLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removeDepTempl() method from PaymentTypeManager class";
            throw new PaymentTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeDepTempl() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets DepTempl objects from the PaymentType object
     * @return Collection - a collection of the DepTempl objects
     */
    public Collection getDepTempls(Integer paymentTypeId)
        throws PaymentTypeException {
        //-- we do not accept null values for any parameters.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in getDepTempls() method from PaymentTypeManager class");
        }
        
        try {
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            Set depTemplCol = paymentTypeLocal.getDepTempls();
            Collection list = new ArrayList();
            if (depTemplCol != null) {
                Iterator it = depTemplCol.iterator();
                while (it.hasNext()) {
                    DepTemplLocal depTemplLocal = (DepTemplLocal) it.next();
                    Integer templId = (Integer)depTemplLocal.getPrimaryKey();
                    DepTemplVO depTemplVO = getDepTemplManager().getDepTempl(templId);
                    list.add(depTemplVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getDepTempls() method from PaymentTypeManager class";
            throw new PaymentTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepTempls() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PaymentType object
     * @param paymentTypeId - the PaymentType bean primary key
     */
    public void removePaymentType(Integer paymentTypeId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (paymentTypeId == null) {
            throw new IllegalArgumentException("paymentTypeId parameter was null in removePaymentType() method from PaymentTypeManager class");
        }
        
        try {
            getPaymentTypeLocalHome().remove(paymentTypeId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePaymentType() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PaymentType object
     * @param paymentTypeVO - the value object of the PaymentType bean
     */
    public void updatePaymentType(PaymentTypeVO paymentTypeVO)
        throws PaymentTypeException {
        //-- we do not accept null value for the parameter.
        if (paymentTypeVO == null) {
            throw new IllegalArgumentException("paymentTypeVO parameter was null in updatePaymentType() method from PaymentTypeManager class");
        }
        
        try {
            Integer paymentTypeId = paymentTypeVO.getPaymentTypeId();
            
            PaymentTypeLocal paymentTypeLocal = getPaymentTypeLocalHome().findByPrimaryKey(paymentTypeId);
            //-- update PaymentType entity bean
            paymentTypeLocal.setDescription(paymentTypeVO.getDescription());
            paymentTypeLocal.setShtDesc(paymentTypeVO.getShtDesc());
            paymentTypeLocal.setPaymentCd(paymentTypeVO.getPaymentCd());
            paymentTypeLocal.setRodCombo(paymentTypeVO.getRodCombo());
            paymentTypeLocal.setCodCombo(paymentTypeVO.getCodCombo());
            paymentTypeLocal.setFtcCombo(paymentTypeVO.getFtcCombo());
            paymentTypeLocal.setPrpCombo(paymentTypeVO.getPrpCombo());
            paymentTypeLocal.setPoaCombo(paymentTypeVO.getPoaCombo());
            paymentTypeLocal.setOtherCombo(paymentTypeVO.getOtherCombo());
            paymentTypeLocal.setCanDeact(paymentTypeVO.getCanDeact());
            paymentTypeLocal.setPaymentCtgId(paymentTypeVO.getPaymentCtgId());
            paymentTypeLocal.setActivePymt(paymentTypeVO.getActivePymt());
            paymentTypeLocal.setGndCombo(paymentTypeVO.getGndCombo());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePaymentType() method from PaymentTypeManager class";
            throw new PaymentTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePaymentType() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPaymentTypes objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getAllPaymentTypes() {
        try {
            //-- gets the local home interface and call the findAllPaymentTypes method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findAllPaymentTypes();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPaymentTypes() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPaymentTypes() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllActivePaymentTypes objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getAllActivePaymentTypes() {
        try {
            //-- gets the local home interface and call the findAllActivePaymentTypes method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findAllActivePaymentTypes();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllActivePaymentTypes() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllActivePaymentTypes() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByRodLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByRodLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findByRodLocation method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByRodLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByRodLocation() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByRodLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }


    /**
     * This method gets findByCodLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByCodLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findByRodLocation method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByCodLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByCodLocation() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByCodLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }    
    
    
    /**
     * This method gets findByFtcLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByFtcLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findByRodLocation method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByFtcLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByFtcLocation() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByFtcLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }    
    
    
    /**
     * This method gets findByPrpLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByPrpLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findByPrpLocation method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByPrpLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByPrpLocation() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByPrpLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPoaLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByPoaLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findByPoaLocation method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByPoaLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByPoaLocation() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByPoaLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByOtherLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByOtherLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findByOtherLocation method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByOtherLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByOtherLocation() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByOtherLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findByLocation method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByLocation() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByLocation() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByCode objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByCode(String paymentCd) {
        try {
            //-- gets the local home interface and call the findByCode method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByCode(paymentCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByCode() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByCode() method from PaymentTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByGndLocation objects
     * @return Collection - a collection of the PaymentType objects
     */
    public Collection getPaymentTypeByGndLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findByGndLocation method
            Collection paymentTypeCol = getPaymentTypeLocalHome().findByGndLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentTypeCol != null && paymentTypeCol.size() > 0) {
                Iterator it = paymentTypeCol.iterator();
                while (it.hasNext()) {
                    PaymentTypeLocal paymentTypeLocal = (PaymentTypeLocal) it.next();
                    //-- get the primary key of the PaymentType EJB object
                    Integer paymentTypeId = (Integer)paymentTypeLocal.getPrimaryKey();
                    //-- get the value object for the PaymentType EJB using the primary key
                    if (paymentTypeId != null) {
                        PaymentTypeVO paymentTypeVO = getPaymentType(paymentTypeId);
                        //-- add the value object to the collection
                        list.add(paymentTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentTypeByGndLocation() method from PaymentTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentTypeByGndLocation() method from PaymentTypeManager class";
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
     * This method gets the DepTemplManager remote interface
     */
    public DepTemplManager getDepTemplManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            DepTemplManagerHome depTemplManagerHome = (DepTemplManagerHome)
            service.getEJBHome(ServiceConstants.DEPTEMPLMANAGER_REMOTE_JNDI, DepTemplManagerHome.class);
            return depTemplManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepTemplManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
