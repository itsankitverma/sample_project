/**
 * @(#)PaymentCtgManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PaymentCtgManagerBean implements SessionBean {

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
     * This method create new PaymentCtg object
     * @param paymentCtgVO a value object the PaymentCtg bean
     */
    public void setPaymentCtg(PaymentCtgVO paymentCtgVO)
        throws PaymentCtgException {
        //-- we do not accept null value for the parameter.
        if (paymentCtgVO == null) {
            throw new IllegalArgumentException("paymentCtgVO parameter was null in setPaymentCtg() method from PaymentCtgManager class");
        }
        
        try {
            
            //-- create new PaymentCtg object
            getPaymentCtgLocalHome().create(
                paymentCtgVO.getDescription(),
                paymentCtgVO.getCanCreatePymt());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPaymentCtg() method from PaymentCtgManager class";
            throw new PaymentCtgException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPaymentCtg() method from PaymentCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PaymentCtg object
     * @return paymentCtgVO - a value object of the PaymentCtg bean
     */
    public PaymentCtgVO getPaymentCtg(Integer paymentCtgId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (paymentCtgId == null) {
            throw new IllegalArgumentException("paymentCtgId parameter was null in getPaymentCtg() method from PaymentCtgManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PaymentCtgLocal paymentCtgLocal = getPaymentCtgLocalHome().findByPrimaryKey(paymentCtgId);
            //-- create new value object to store the data
            PaymentCtgVO paymentCtgVO = new PaymentCtgVO();
            //-- populate the new value object
            paymentCtgVO.setPaymentCtgId(paymentCtgLocal.getPaymentCtgId());
            paymentCtgVO.setDescription(paymentCtgLocal.getDescription());
            paymentCtgVO.setCanCreatePymt(paymentCtgLocal.getCanCreatePymt());
            return paymentCtgVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentCtg() method from PaymentCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PaymentCtg object
     * @param paymentCtgId - the PaymentCtg bean primary key
     */
    public void removePaymentCtg(Integer paymentCtgId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (paymentCtgId == null) {
            throw new IllegalArgumentException("paymentCtgId parameter was null in removePaymentCtg() method from PaymentCtgManager class");
        }
        
        try {
            getPaymentCtgLocalHome().remove(paymentCtgId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePaymentCtg() method from PaymentCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PaymentCtg object
     * @param paymentCtgVO - the value object of the PaymentCtg bean
     */
    public void updatePaymentCtg(PaymentCtgVO paymentCtgVO)
        throws PaymentCtgException {
        //-- we do not accept null value for the parameter.
        if (paymentCtgVO == null) {
            throw new IllegalArgumentException("paymentCtgVO parameter was null in updatePaymentCtg() method from PaymentCtgManager class");
        }
        
        try {
            Integer paymentCtgId = paymentCtgVO.getPaymentCtgId();
            
            PaymentCtgLocal paymentCtgLocal = getPaymentCtgLocalHome().findByPrimaryKey(paymentCtgId);
            //-- update PaymentCtg entity bean
            paymentCtgLocal.setDescription(paymentCtgVO.getDescription());
            paymentCtgLocal.setCanCreatePymt(paymentCtgVO.getCanCreatePymt());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePaymentCtg() method from PaymentCtgManager class";
            throw new PaymentCtgException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePaymentCtg() method from PaymentCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPaymentCtgs objects
     * @return Collection - a collection of the PaymentCtg objects
     */
    public Collection getAllPaymentCtgs() {
        try {
            //-- gets the local home interface and call the findAllPaymentCtgs method
            Collection paymentCtgCol = getPaymentCtgLocalHome().findAllPaymentCtgs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentCtgCol != null && paymentCtgCol.size() > 0) {
                Iterator it = paymentCtgCol.iterator();
                while (it.hasNext()) {
                    PaymentCtgLocal paymentCtgLocal = (PaymentCtgLocal) it.next();
                    //-- get the primary key of the PaymentCtg EJB object
                    Integer paymentCtgId = (Integer)paymentCtgLocal.getPrimaryKey();
                    //-- get the value object for the PaymentCtg EJB using the primary key
                    if (paymentCtgId != null) {
                        PaymentCtgVO paymentCtgVO = getPaymentCtg(paymentCtgId);
                        //-- add the value object to the collection
                        list.add(paymentCtgVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPaymentCtgs() method from PaymentCtgManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPaymentCtgs() method from PaymentCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findExtPaymentCtgs objects
     * @return Collection - a collection of the PaymentCtg objects
     */
    public Collection getPaymentCtgExtPaymentCtgs() {
        try {
            //-- gets the local home interface and call the findExtPaymentCtgs method
            Collection paymentCtgCol = getPaymentCtgLocalHome().findExtPaymentCtgs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (paymentCtgCol != null && paymentCtgCol.size() > 0) {
                Iterator it = paymentCtgCol.iterator();
                while (it.hasNext()) {
                    PaymentCtgLocal paymentCtgLocal = (PaymentCtgLocal) it.next();
                    //-- get the primary key of the PaymentCtg EJB object
                    Integer paymentCtgId = (Integer)paymentCtgLocal.getPrimaryKey();
                    //-- get the value object for the PaymentCtg EJB using the primary key
                    if (paymentCtgId != null) {
                        PaymentCtgVO paymentCtgVO = getPaymentCtg(paymentCtgId);
                        //-- add the value object to the collection
                        list.add(paymentCtgVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPaymentCtgExtPaymentCtgs() method from PaymentCtgManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPaymentCtgExtPaymentCtgs() method from PaymentCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PaymentCtg local home interface
     */
    private PaymentCtgLocalHome getPaymentCtgLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PaymentCtgLocalHome) service.getEJBLocalHome(ServiceConstants.PAYMENTCTG_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPaymentCtgLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
