/**
 * @(#)PymtImptErrorDtlManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PymtImptErrorDtlManagerBean implements SessionBean {

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
     * This method create new PymtImptErrorDtl object
     * @param pymtImptErrorDtlVO a value object the PymtImptErrorDtl bean
     */
    public void setPymtImptErrorDtl(PymtImptErrorDtlVO pymtImptErrorDtlVO)
        throws PymtImptErrorDtlException {
        //-- we do not accept null value for the parameter.
        if (pymtImptErrorDtlVO == null) {
            throw new IllegalArgumentException("pymtImptErrorDtlVO parameter was null in setPymtImptErrorDtl() method from PymtImptErrorDtlManager class");
        }
        
        try {
            //-- get PymtImptLog local interface
            Integer imptId = pymtImptErrorDtlVO.getImptId();
            PymtImptLogLocal pymtImptLogLocal = null;
            if (imptId != null) {
                pymtImptLogLocal = getPymtImptLogLocalHome().findByPrimaryKey(imptId);
            }
            
            //-- create new PymtImptErrorDtl object
            getPymtImptErrorDtlLocalHome().create(
                pymtImptErrorDtlVO.getImptMessageDtl(),
                pymtImptErrorDtlVO.getImptError(),
                pymtImptLogLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in find the requested object to create in setPymtImptErrorDtl() method from PymtImptErrorDtlManager class";
            throw new PymtImptErrorDtlException(errorMsg, ex);
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPymtImptErrorDtl() method from PymtImptErrorDtlManager class";
            throw new PymtImptErrorDtlException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPymtImptErrorDtl() method from PymtImptErrorDtlManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PymtImptErrorDtl object
     * @return pymtImptErrorDtlVO - a value object of the PymtImptErrorDtl bean
     */
    public PymtImptErrorDtlVO getPymtImptErrorDtl(Integer imptErrorDtlId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (imptErrorDtlId == null) {
            throw new IllegalArgumentException("imptErrorDtlId parameter was null in getPymtImptErrorDtl() method from PymtImptErrorDtlManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PymtImptErrorDtlLocal pymtImptErrorDtlLocal = getPymtImptErrorDtlLocalHome().findByPrimaryKey(imptErrorDtlId);
            //-- create new value object to store the data
            PymtImptErrorDtlVO pymtImptErrorDtlVO = new PymtImptErrorDtlVO();
            //-- populate the new value object
            pymtImptErrorDtlVO.setImptErrorDtlId(pymtImptErrorDtlLocal.getImptErrorDtlId());
            pymtImptErrorDtlVO.setImptMessageDtl(pymtImptErrorDtlLocal.getImptMessageDtl());
            pymtImptErrorDtlVO.setImptError(pymtImptErrorDtlLocal.getImptError());
            //-- get the primary key of the PymtImptLog object from the local interface
            PymtImptLogLocal pymtImptLogLocal = pymtImptErrorDtlLocal.getPymtImptLog();
            if (pymtImptLogLocal != null) {
                Integer imptId = (Integer) pymtImptLogLocal.getPrimaryKey();
                pymtImptErrorDtlVO.setImptId(imptId);
            }
            return pymtImptErrorDtlVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtl() method from PymtImptErrorDtlManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PymtImptErrorDtl object
     * @param imptErrorDtlId - the PymtImptErrorDtl bean primary key
     */
    public void removePymtImptErrorDtl(Integer imptErrorDtlId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (imptErrorDtlId == null) {
            throw new IllegalArgumentException("imptErrorDtlId parameter was null in removePymtImptErrorDtl() method from PymtImptErrorDtlManager class");
        }
        
        try {
            getPymtImptErrorDtlLocalHome().remove(imptErrorDtlId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePymtImptErrorDtl() method from PymtImptErrorDtlManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PymtImptErrorDtl object
     * @param pymtImptErrorDtlVO - the value object of the PymtImptErrorDtl bean
     */
    public void updatePymtImptErrorDtl(PymtImptErrorDtlVO pymtImptErrorDtlVO)
        throws PymtImptErrorDtlException {
        //-- we do not accept null value for the parameter.
        if (pymtImptErrorDtlVO == null) {
            throw new IllegalArgumentException("pymtImptErrorDtlVO parameter was null in updatePymtImptErrorDtl() method from PymtImptErrorDtlManager class");
        }
        
        try {
            Integer imptErrorDtlId = pymtImptErrorDtlVO.getImptErrorDtlId();
            
            PymtImptErrorDtlLocal pymtImptErrorDtlLocal = getPymtImptErrorDtlLocalHome().findByPrimaryKey(imptErrorDtlId);
            //-- update PymtImptErrorDtl entity bean
            pymtImptErrorDtlLocal.setImptMessageDtl(pymtImptErrorDtlVO.getImptMessageDtl());
            pymtImptErrorDtlLocal.setImptError(pymtImptErrorDtlVO.getImptError());
            //-- get pymtImptLog local interface and update PymtImptErrorDtl entity bean
            //-- depending on your business need...you may have to remove the if statement
            Integer imptId = pymtImptErrorDtlVO.getImptId();
            PymtImptLogLocal pymtImptLogLocal = null;
            if (imptId != null) {
                pymtImptLogLocal = getPymtImptLogLocalHome().findByPrimaryKey(imptId);
            }
            pymtImptErrorDtlLocal.setPymtImptLog(pymtImptLogLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePymtImptErrorDtl() method from PymtImptErrorDtlManager class";
            throw new PymtImptErrorDtlException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePymtImptErrorDtl() method from PymtImptErrorDtlManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPymtImptErrorDtls objects
     * @return Collection - a collection of the PymtImptErrorDtl objects
     */
    public Collection getAllPymtImptErrorDtls() {
        try {
            //-- gets the local home interface and call the findAllPymtImptErrorDtls method
            Collection pymtImptErrorDtlCol = getPymtImptErrorDtlLocalHome().findAllPymtImptErrorDtls();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (pymtImptErrorDtlCol != null && pymtImptErrorDtlCol.size() > 0) {
                Iterator it = pymtImptErrorDtlCol.iterator();
                while (it.hasNext()) {
                    PymtImptErrorDtlLocal pymtImptErrorDtlLocal = (PymtImptErrorDtlLocal) it.next();
                    //-- get the primary key of the PymtImptErrorDtl EJB object
                    Integer imptErrorDtlId = (Integer)pymtImptErrorDtlLocal.getPrimaryKey();
                    //-- get the value object for the PymtImptErrorDtl EJB using the primary key
                    if (imptErrorDtlId != null) {
                        PymtImptErrorDtlVO pymtImptErrorDtlVO = getPymtImptErrorDtl(imptErrorDtlId);
                        //-- add the value object to the collection
                        list.add(pymtImptErrorDtlVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPymtImptErrorDtls() method from PymtImptErrorDtlManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPymtImptErrorDtls() method from PymtImptErrorDtlManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PymtImptErrorDtl local home interface
     */
    private PymtImptErrorDtlLocalHome getPymtImptErrorDtlLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PymtImptErrorDtlLocalHome) service.getEJBLocalHome(ServiceConstants.PYMTIMPTERRORDTL_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtlLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PymtImptLog local home interface
     */
    private PymtImptLogLocalHome getPymtImptLogLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PymtImptLogLocalHome) service.getEJBLocalHome(ServiceConstants.PYMTIMPTLOG_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPymtImptLogLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
