/**
 * @(#)PymtTypeLocManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PymtTypeLocManagerBean implements SessionBean {

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
     * This method create new PymtTypeLoc object
     * @param pymtTypeLocVO a value object the PymtTypeLoc bean
     */
    public void setPymtTypeLoc(PymtTypeLocVO pymtTypeLocVO)
        throws PymtTypeLocException {
        //-- we do not accept null value for the parameter.
        if (pymtTypeLocVO == null) {
            throw new IllegalArgumentException("pymtTypeLocVO parameter was null in setPymtTypeLoc() method from PymtTypeLocManager class");
        }
        
        try {
            
            //-- create new PymtTypeLoc object
            getPymtTypeLocLocalHome().create(
                pymtTypeLocVO.getPaymentTypeId(),
                pymtTypeLocVO.getLocationCd());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPymtTypeLoc() method from PymtTypeLocManager class";
            throw new PymtTypeLocException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPymtTypeLoc() method from PymtTypeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PymtTypeLoc object
     * @return pymtTypeLocVO - a value object of the PymtTypeLoc bean
     */
    public PymtTypeLocVO getPymtTypeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (pymtTypeLocPK == null) {
            throw new IllegalArgumentException("pymtTypeLocPK parameter was null in getPymtTypeLoc() method from PymtTypeLocManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PymtTypeLocLocal pymtTypeLocLocal = getPymtTypeLocLocalHome().findByPrimaryKey(pymtTypeLocPK);
            //-- create new value object to store the data
            PymtTypeLocVO pymtTypeLocVO = new PymtTypeLocVO();
            //-- populate the new value object
            pymtTypeLocVO.setPaymentTypeId(pymtTypeLocLocal.getPaymentTypeId());
            pymtTypeLocVO.setLocationCd(pymtTypeLocLocal.getLocationCd());
            return pymtTypeLocVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPymtTypeLoc() method from PymtTypeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PymtTypeLoc object
     * @param pymtTypeLocPK - the PymtTypeLoc bean primary key
     */
    public void removePymtTypeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (pymtTypeLocPK == null) {
            throw new IllegalArgumentException("pymtTypeLocPK parameter was null in removePymtTypeLoc() method from PymtTypeLocManager class");
        }
        
        try {
            getPymtTypeLocLocalHome().remove(pymtTypeLocPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePymtTypeLoc() method from PymtTypeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PymtTypeLoc object
     * @param pymtTypeLocVO - the value object of the PymtTypeLoc bean
     */
    public void updatePymtTypeLoc(PymtTypeLocVO pymtTypeLocVO)
        throws PymtTypeLocException {
        //-- we do not accept null value for the parameter.
        if (pymtTypeLocVO == null) {
            throw new IllegalArgumentException("pymtTypeLocVO parameter was null in updatePymtTypeLoc() method from PymtTypeLocManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK = pymtTypeLocVO.getPymtTypeLocPK();
            
            PymtTypeLocLocal pymtTypeLocLocal = getPymtTypeLocLocalHome().findByPrimaryKey(pymtTypeLocPK);
            //-- update PymtTypeLoc entity bean
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePymtTypeLoc() method from PymtTypeLocManager class";
            throw new PymtTypeLocException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePymtTypeLoc() method from PymtTypeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPymtTypeLocs objects
     * @return Collection - a collection of the PymtTypeLoc objects
     */
    public Collection getAllPymtTypeLocs() {
        try {
            //-- gets the local home interface and call the findAllPymtTypeLocs method
            Collection pymtTypeLocCol = getPymtTypeLocLocalHome().findAllPymtTypeLocs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (pymtTypeLocCol != null && pymtTypeLocCol.size() > 0) {
                Iterator it = pymtTypeLocCol.iterator();
                while (it.hasNext()) {
                    PymtTypeLocLocal pymtTypeLocLocal = (PymtTypeLocLocal) it.next();
                    //-- get the primary key of the PymtTypeLoc EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK = (com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK)pymtTypeLocLocal.getPrimaryKey();
                    //-- get the value object for the PymtTypeLoc EJB using the primary key
                    if (pymtTypeLocPK != null) {
                        PymtTypeLocVO pymtTypeLocVO = getPymtTypeLoc(pymtTypeLocPK);
                        //-- add the value object to the collection
                        list.add(pymtTypeLocVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPymtTypeLocs() method from PymtTypeLocManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPymtTypeLocs() method from PymtTypeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findLocationsByPayment objects
     * @return Collection - a collection of the PymtTypeLoc objects
     */
    public Collection getPymtTypeLocLocationsByPayment(Integer ptId) {
        try {
            //-- gets the local home interface and call the findLocationsByPayment method
            Collection pymtTypeLocCol = getPymtTypeLocLocalHome().findLocationsByPayment(ptId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (pymtTypeLocCol != null && pymtTypeLocCol.size() > 0) {
                Iterator it = pymtTypeLocCol.iterator();
                while (it.hasNext()) {
                    PymtTypeLocLocal pymtTypeLocLocal = (PymtTypeLocLocal) it.next();
                    //-- get the primary key of the PymtTypeLoc EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK = (com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK)pymtTypeLocLocal.getPrimaryKey();
                    //-- get the value object for the PymtTypeLoc EJB using the primary key
                    if (pymtTypeLocPK != null) {
                        PymtTypeLocVO pymtTypeLocVO = getPymtTypeLoc(pymtTypeLocPK);
                        //-- add the value object to the collection
                        list.add(pymtTypeLocVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPymtTypeLocLocationsByPayment() method from PymtTypeLocManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPymtTypeLocLocationsByPayment() method from PymtTypeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PymtTypeLoc local home interface
     */
    private PymtTypeLocLocalHome getPymtTypeLocLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PymtTypeLocLocalHome) service.getEJBLocalHome(ServiceConstants.PYMTTYPELOC_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPymtTypeLocLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
