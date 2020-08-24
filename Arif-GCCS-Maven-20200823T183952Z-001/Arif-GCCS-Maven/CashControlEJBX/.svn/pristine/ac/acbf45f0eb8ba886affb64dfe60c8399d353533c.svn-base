/**
 * @(#)PreStatusManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PreStatusManagerBean implements SessionBean {

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
     * This method create new PreStatus object
     * @param preStatusVO a value object the PreStatus bean
     */
    public void setPreStatus(PreStatusVO preStatusVO)
        throws PreStatusException {
        //-- we do not accept null value for the parameter.
        if (preStatusVO == null) {
            throw new IllegalArgumentException("preStatusVO parameter was null in setPreStatus() method from PreStatusManager class");
        }
        
        try {
            
            //-- create new PreStatus object
            getPreStatusLocalHome().create(
                preStatusVO.getStatusIdNbr(),
                preStatusVO.getStatusDesc(),
                preStatusVO.getPrePgFlg());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPreStatus() method from PreStatusManager class";
            throw new PreStatusException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPreStatus() method from PreStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PreStatus object
     * @return preStatusVO - a value object of the PreStatus bean
     */
    public PreStatusVO getPreStatus(Integer statusIdNbr)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (statusIdNbr == null) {
            throw new IllegalArgumentException("statusIdNbr parameter was null in getPreStatus() method from PreStatusManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PreStatusLocal preStatusLocal = getPreStatusLocalHome().findByPrimaryKey(statusIdNbr);
            //-- create new value object to store the data
            PreStatusVO preStatusVO = new PreStatusVO();
            //-- populate the new value object
            preStatusVO.setStatusIdNbr(preStatusLocal.getStatusIdNbr());
            preStatusVO.setStatusDesc(preStatusLocal.getStatusDesc());
            preStatusVO.setPrePgFlg(preStatusLocal.getPrePgFlg());
            return preStatusVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPreStatus() method from PreStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PreStatus object
     * @param statusIdNbr - the PreStatus bean primary key
     */
    public void removePreStatus(Integer statusIdNbr)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (statusIdNbr == null) {
            throw new IllegalArgumentException("statusIdNbr parameter was null in removePreStatus() method from PreStatusManager class");
        }
        
        try {
            getPreStatusLocalHome().remove(statusIdNbr);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePreStatus() method from PreStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PreStatus object
     * @param preStatusVO - the value object of the PreStatus bean
     */
    public void updatePreStatus(PreStatusVO preStatusVO)
        throws PreStatusException {
        //-- we do not accept null value for the parameter.
        if (preStatusVO == null) {
            throw new IllegalArgumentException("preStatusVO parameter was null in updatePreStatus() method from PreStatusManager class");
        }
        
        try {
            Integer statusIdNbr = preStatusVO.getStatusIdNbr();
            
            PreStatusLocal preStatusLocal = getPreStatusLocalHome().findByPrimaryKey(statusIdNbr);
            //-- update PreStatus entity bean
            preStatusLocal.setStatusDesc(preStatusVO.getStatusDesc());
            preStatusLocal.setPrePgFlg(preStatusVO.getPrePgFlg());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePreStatus() method from PreStatusManager class";
            throw new PreStatusException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePreStatus() method from PreStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPreStatus objects
     * @return Collection - a collection of the PreStatus objects
     */
    public Collection getAllPreStatus() {
        try {
            //-- gets the local home interface and call the findAllPreStatus method
            Collection preStatusCol = getPreStatusLocalHome().findAllPreStatus();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (preStatusCol != null && preStatusCol.size() > 0) {
                Iterator it = preStatusCol.iterator();
                while (it.hasNext()) {
                    PreStatusLocal preStatusLocal = (PreStatusLocal) it.next();
                    //-- get the primary key of the PreStatus EJB object
                    Integer statusIdNbr = (Integer)preStatusLocal.getPrimaryKey();
                    //-- get the value object for the PreStatus EJB using the primary key
                    if (statusIdNbr != null) {
                        PreStatusVO preStatusVO = getPreStatus(statusIdNbr);
                        //-- add the value object to the collection
                        list.add(preStatusVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPreStatus() method from PreStatusManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPreStatus() method from PreStatusManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PreStatus local home interface
     */
    private PreStatusLocalHome getPreStatusLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PreStatusLocalHome) service.getEJBLocalHome(ServiceConstants.PRESTATUS_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPreStatusLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
