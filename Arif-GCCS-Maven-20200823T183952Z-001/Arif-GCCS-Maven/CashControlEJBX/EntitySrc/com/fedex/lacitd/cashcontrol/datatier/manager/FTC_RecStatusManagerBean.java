/**
 * @(#)FTC_RecStatusManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class FTC_RecStatusManagerBean implements SessionBean {

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
     * This method create new FTC_RecStatus object
     * @param FTC_recStatusVO a value object the FTC_RecStatus bean
     */
    public void setFTC_RecStatus(FTC_RecStatusVO FTC_recStatusVO)
        throws FTC_RecStatusException {
        //-- we do not accept null value for the parameter.
        if (FTC_recStatusVO == null) {
            throw new IllegalArgumentException("FTC_recStatusVO parameter was null in setFTC_RecStatus() method from FTC_RecStatusManager class");
        }
        
        try {
            
            //-- create new FTC_RecStatus object
            getFTC_RecStatusLocalHome().create(
                FTC_recStatusVO.getStatusId(),
                FTC_recStatusVO.getDescription(),
                FTC_recStatusVO.getFtcPgFlg());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setFTC_RecStatus() method from FTC_RecStatusManager class";
            throw new FTC_RecStatusException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setFTC_RecStatus() method from FTC_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a FTC_RecStatus object
     * @return FTC_recStatusVO - a value object of the FTC_RecStatus bean
     */
    public FTC_RecStatusVO getFTC_RecStatus(Integer statusId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in getFTC_RecStatus() method from FTC_RecStatusManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            FTC_RecStatusLocal FTC_recStatusLocal = getFTC_RecStatusLocalHome().findByPrimaryKey(statusId);
            //-- create new value object to store the data
            FTC_RecStatusVO FTC_recStatusVO = new FTC_RecStatusVO();
            //-- populate the new value object
            FTC_recStatusVO.setStatusId(FTC_recStatusLocal.getStatusId());
            FTC_recStatusVO.setDescription(FTC_recStatusLocal.getDescription());
            FTC_recStatusVO.setFtcPgFlg(FTC_recStatusLocal.getFtcPgFlg());
            return FTC_recStatusVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getFTC_RecStatus() method from FTC_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing FTC_RecStatus object
     * @param statusId - the FTC_RecStatus bean primary key
     */
    public void removeFTC_RecStatus(Integer statusId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in removeFTC_RecStatus() method from FTC_RecStatusManager class");
        }
        
        try {
            getFTC_RecStatusLocalHome().remove(statusId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeFTC_RecStatus() method from FTC_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing FTC_RecStatus object
     * @param FTC_recStatusVO - the value object of the FTC_RecStatus bean
     */
    public void updateFTC_RecStatus(FTC_RecStatusVO FTC_recStatusVO)
        throws FTC_RecStatusException {
        //-- we do not accept null value for the parameter.
        if (FTC_recStatusVO == null) {
            throw new IllegalArgumentException("FTC_recStatusVO parameter was null in updateFTC_RecStatus() method from FTC_RecStatusManager class");
        }
        
        try {
            Integer statusId = FTC_recStatusVO.getStatusId();
            
            FTC_RecStatusLocal FTC_recStatusLocal = getFTC_RecStatusLocalHome().findByPrimaryKey(statusId);
            //-- update FTC_RecStatus entity bean
            FTC_recStatusLocal.setDescription(FTC_recStatusVO.getDescription());
            FTC_recStatusLocal.setFtcPgFlg(FTC_recStatusVO.getFtcPgFlg());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateFTC_RecStatus() method from FTC_RecStatusManager class";
            throw new FTC_RecStatusException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateFTC_RecStatus() method from FTC_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllFTC_RecStatus objects
     * @return Collection - a collection of the FTC_RecStatus objects
     */
    public Collection getAllFTC_RecStatus() {
        try {
            //-- gets the local home interface and call the findAllFTC_RecStatus method
            Collection FTC_recStatusCol = getFTC_RecStatusLocalHome().findAllFTC_RecStatus();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (FTC_recStatusCol != null && FTC_recStatusCol.size() > 0) {
                Iterator it = FTC_recStatusCol.iterator();
                while (it.hasNext()) {
                    FTC_RecStatusLocal FTC_recStatusLocal = (FTC_RecStatusLocal) it.next();
                    //-- get the primary key of the FTC_RecStatus EJB object
                    Integer statusId = (Integer)FTC_recStatusLocal.getPrimaryKey();
                    //-- get the value object for the FTC_RecStatus EJB using the primary key
                    if (statusId != null) {
                        FTC_RecStatusVO FTC_recStatusVO = getFTC_RecStatus(statusId);
                        //-- add the value object to the collection
                        list.add(FTC_recStatusVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllFTC_RecStatus() method from FTC_RecStatusManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllFTC_RecStatus() method from FTC_RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the FTC_RecStatus local home interface
     */
    private FTC_RecStatusLocalHome getFTC_RecStatusLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (FTC_RecStatusLocalHome) service.getEJBLocalHome(ServiceConstants.RECSTATUS_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getFTC_RecStatusLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
