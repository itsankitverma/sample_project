/**
 * @(#)COD_RecStatusManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class COD_RecStatusManagerBean implements SessionBean {

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
     * This method create new COD_RecStatus object
     * @param COD_recStatusVO a value object the COD_RecStatus bean
     */
    public void setCOD_RecStatus(COD_RecStatusVO COD_recStatusVO)
        throws COD_RecStatusException {
        //-- we do not accept null value for the parameter.
        if (COD_recStatusVO == null) {
            throw new IllegalArgumentException("COD_recStatusVO parameter was null in setCOD_RecStatus() method from COD_RecStatusManager class");
        }
        
        try {
            
            //-- create new COD_RecStatus object
            getCOD_RecStatusLocalHome().create(
                COD_recStatusVO.getStatusId(),
                COD_recStatusVO.getDescription(),
                COD_recStatusVO.getCodPgFlg());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setCOD_RecStatus() method from COD_RecStatusManager class";
            throw new COD_RecStatusException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setCOD_RecStatus() method from COD_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a COD_RecStatus object
     * @return COD_recStatusVO - a value object of the COD_RecStatus bean
     */
    public COD_RecStatusVO getCOD_RecStatus(Integer statusId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in getCOD_RecStatus() method from COD_RecStatusManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            COD_RecStatusLocal COD_recStatusLocal = getCOD_RecStatusLocalHome().findByPrimaryKey(statusId);
            //-- create new value object to store the data
            COD_RecStatusVO COD_recStatusVO = new COD_RecStatusVO();
            //-- populate the new value object
            COD_recStatusVO.setStatusId(COD_recStatusLocal.getStatusId());
            COD_recStatusVO.setDescription(COD_recStatusLocal.getDescription());
            COD_recStatusVO.setCodPgFlg(COD_recStatusLocal.getCodPgFlg());
            return COD_recStatusVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCOD_RecStatus() method from COD_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing COD_RecStatus object
     * @param statusId - the COD_RecStatus bean primary key
     */
    public void removeCOD_RecStatus(Integer statusId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in removeCOD_RecStatus() method from COD_RecStatusManager class");
        }
        
        try {
            getCOD_RecStatusLocalHome().remove(statusId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeCOD_RecStatus() method from COD_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing COD_RecStatus object
     * @param COD_recStatusVO - the value object of the COD_RecStatus bean
     */
    public void updateCOD_RecStatus(COD_RecStatusVO COD_recStatusVO)
        throws COD_RecStatusException {
        //-- we do not accept null value for the parameter.
        if (COD_recStatusVO == null) {
            throw new IllegalArgumentException("COD_recStatusVO parameter was null in updateCOD_RecStatus() method from COD_RecStatusManager class");
        }
        
        try {
            Integer statusId = COD_recStatusVO.getStatusId();
            
            COD_RecStatusLocal COD_recStatusLocal = getCOD_RecStatusLocalHome().findByPrimaryKey(statusId);
            //-- update COD_RecStatus entity bean
            COD_recStatusLocal.setDescription(COD_recStatusVO.getDescription());
            COD_recStatusLocal.setCodPgFlg(COD_recStatusVO.getCodPgFlg());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateCOD_RecStatus() method from COD_RecStatusManager class";
            throw new COD_RecStatusException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateCOD_RecStatus() method from COD_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCOD_RecStatus objects
     * @return Collection - a collection of the COD_RecStatus objects
     */
    public Collection getAllCOD_RecStatus() {
        try {
            //-- gets the local home interface and call the findAllCOD_RecStatus method
            Collection COD_recStatusCol = getCOD_RecStatusLocalHome().findAllCOD_RecStatus();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (COD_recStatusCol != null && COD_recStatusCol.size() > 0) {
                Iterator it = COD_recStatusCol.iterator();
                while (it.hasNext()) {
                    COD_RecStatusLocal COD_recStatusLocal = (COD_RecStatusLocal) it.next();
                    //-- get the primary key of the COD_RecStatus EJB object
                    Integer statusId = (Integer)COD_recStatusLocal.getPrimaryKey();
                    //-- get the value object for the COD_RecStatus EJB using the primary key
                    if (statusId != null) {
                        COD_RecStatusVO COD_recStatusVO = getCOD_RecStatus(statusId);
                        //-- add the value object to the collection
                        list.add(COD_recStatusVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllCOD_RecStatus() method from COD_RecStatusManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllCOD_RecStatus() method from COD_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the COD_RecStatus local home interface
     */
    private COD_RecStatusLocalHome getCOD_RecStatusLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (COD_RecStatusLocalHome) service.getEJBLocalHome(ServiceConstants.RECSTATUS_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCOD_RecStatusLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
