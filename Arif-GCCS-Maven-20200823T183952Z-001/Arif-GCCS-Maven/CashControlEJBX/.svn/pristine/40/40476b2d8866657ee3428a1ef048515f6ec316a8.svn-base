/**
 * @(#)RecStatusManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class RecStatusManagerBean implements SessionBean {

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
     * This method create new RecStatus object
     * @param recStatusVO a value object the RecStatus bean
     */
    public void setRecStatus(RecStatusVO recStatusVO)
        throws RecStatusException {
        //-- we do not accept null value for the parameter.
        if (recStatusVO == null) {
            throw new IllegalArgumentException("recStatusVO parameter was null in setRecStatus() method from RecStatusManager class");
        }
        
        try {
            
            //-- create new RecStatus object
            getRecStatusLocalHome().create(
                recStatusVO.getStatusId(),
                recStatusVO.getDescription(),
                recStatusVO.getRodPgFlg());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setRecStatus() method from RecStatusManager class";
            throw new RecStatusException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setRecStatus() method from RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a RecStatus object
     * @return recStatusVO - a value object of the RecStatus bean
     */
    public RecStatusVO getRecStatus(Integer statusId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in getRecStatus() method from RecStatusManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            RecStatusLocal recStatusLocal = getRecStatusLocalHome().findByPrimaryKey(statusId);
            //-- create new value object to store the data
            RecStatusVO recStatusVO = new RecStatusVO();
            //-- populate the new value object
            recStatusVO.setStatusId(recStatusLocal.getStatusId());
            recStatusVO.setDescription(recStatusLocal.getDescription());
            recStatusVO.setRodPgFlg(recStatusLocal.getRodPgFlg());
            return recStatusVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getRecStatus() method from RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing RecStatus object
     * @param statusId - the RecStatus bean primary key
     */
    public void removeRecStatus(Integer statusId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (statusId == null) {
            throw new IllegalArgumentException("statusId parameter was null in removeRecStatus() method from RecStatusManager class");
        }
        
        try {
            getRecStatusLocalHome().remove(statusId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeRecStatus() method from RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RecStatus object
     * @param recStatusVO - the value object of the RecStatus bean
     */
    public void updateRecStatus(RecStatusVO recStatusVO)
        throws RecStatusException {
        //-- we do not accept null value for the parameter.
        if (recStatusVO == null) {
            throw new IllegalArgumentException("recStatusVO parameter was null in updateRecStatus() method from RecStatusManager class");
        }
        
        try {
            Integer statusId = recStatusVO.getStatusId();
            
            RecStatusLocal recStatusLocal = getRecStatusLocalHome().findByPrimaryKey(statusId);
            //-- update RecStatus entity bean
            recStatusLocal.setDescription(recStatusVO.getDescription());
            recStatusLocal.setRodPgFlg(recStatusVO.getRodPgFlg());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateRecStatus() method from RecStatusManager class";
            throw new RecStatusException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateRecStatus() method from RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRecStatus objects
     * @return Collection - a collection of the RecStatus objects
     */
    public Collection getAllRecStatus() {
        try {
            //-- gets the local home interface and call the findAllRecStatus method
            Collection recStatusCol = getRecStatusLocalHome().findAllRecStatus();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (recStatusCol != null && recStatusCol.size() > 0) {
                Iterator it = recStatusCol.iterator();
                while (it.hasNext()) {
                    RecStatusLocal recStatusLocal = (RecStatusLocal) it.next();
                    //-- get the primary key of the RecStatus EJB object
                    Integer statusId = (Integer)recStatusLocal.getPrimaryKey();
                    //-- get the value object for the RecStatus EJB using the primary key
                    if (statusId != null) {
                        RecStatusVO recStatusVO = getRecStatus(statusId);
                        //-- add the value object to the collection
                        list.add(recStatusVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllRecStatus() method from RecStatusManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllRecStatus() method from RecStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the RecStatus local home interface
     */
    private RecStatusLocalHome getRecStatusLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (RecStatusLocalHome) service.getEJBLocalHome(ServiceConstants.RECSTATUS_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRecStatusLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
