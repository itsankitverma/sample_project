/**
 * @(#)OtherPymtCtgManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class OtherPymtCtgManagerBean implements SessionBean {

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
     * This method create new OtherPymtCtg object
     * @param otherPymtCtgVO a value object the OtherPymtCtg bean
     */
    public void setOtherPymtCtg(OtherPymtCtgVO otherPymtCtgVO)
        throws OtherPymtCtgException {
        //-- we do not accept null value for the parameter.
        if (otherPymtCtgVO == null) {
            throw new IllegalArgumentException("otherPymtCtgVO parameter was null in setOtherPymtCtg() method from OtherPymtCtgManager class");
        }
        
        try {
            
            //-- create new OtherPymtCtg object
            getOtherPymtCtgLocalHome().create(
                otherPymtCtgVO.getDescription(),
                otherPymtCtgVO.getShortDescription());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setOtherPymtCtg() method from OtherPymtCtgManager class";
            throw new OtherPymtCtgException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setOtherPymtCtg() method from OtherPymtCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a OtherPymtCtg object
     * @return otherPymtCtgVO - a value object of the OtherPymtCtg bean
     */
    public OtherPymtCtgVO getOtherPymtCtg(Integer otherPaymentCtgId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (otherPaymentCtgId == null) {
            throw new IllegalArgumentException("otherPaymentCtgId parameter was null in getOtherPymtCtg() method from OtherPymtCtgManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            OtherPymtCtgLocal otherPymtCtgLocal = getOtherPymtCtgLocalHome().findByPrimaryKey(otherPaymentCtgId);
            //-- create new value object to store the data
            OtherPymtCtgVO otherPymtCtgVO = new OtherPymtCtgVO();
            //-- populate the new value object
            otherPymtCtgVO.setOtherPaymentCtgId(otherPymtCtgLocal.getOtherPaymentCtgId());
            otherPymtCtgVO.setDescription(otherPymtCtgLocal.getDescription());
            otherPymtCtgVO.setShortDescription(otherPymtCtgLocal.getShortDescription());
            return otherPymtCtgVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOtherPymtCtg() method from OtherPymtCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing OtherPymtCtg object
     * @param otherPaymentCtgId - the OtherPymtCtg bean primary key
     */
    public void removeOtherPymtCtg(Integer otherPaymentCtgId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (otherPaymentCtgId == null) {
            throw new IllegalArgumentException("otherPaymentCtgId parameter was null in removeOtherPymtCtg() method from OtherPymtCtgManager class");
        }
        
        try {
            getOtherPymtCtgLocalHome().remove(otherPaymentCtgId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeOtherPymtCtg() method from OtherPymtCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing OtherPymtCtg object
     * @param otherPymtCtgVO - the value object of the OtherPymtCtg bean
     */
    public void updateOtherPymtCtg(OtherPymtCtgVO otherPymtCtgVO)
        throws OtherPymtCtgException {
        //-- we do not accept null value for the parameter.
        if (otherPymtCtgVO == null) {
            throw new IllegalArgumentException("otherPymtCtgVO parameter was null in updateOtherPymtCtg() method from OtherPymtCtgManager class");
        }
        
        try {
            Integer otherPaymentCtgId = otherPymtCtgVO.getOtherPaymentCtgId();
            
            OtherPymtCtgLocal otherPymtCtgLocal = getOtherPymtCtgLocalHome().findByPrimaryKey(otherPaymentCtgId);
            //-- update OtherPymtCtg entity bean
            otherPymtCtgLocal.setDescription(otherPymtCtgVO.getDescription());
            otherPymtCtgLocal.setShortDescription(otherPymtCtgVO.getShortDescription());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateOtherPymtCtg() method from OtherPymtCtgManager class";
            throw new OtherPymtCtgException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateOtherPymtCtg() method from OtherPymtCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPaymentCtgs objects
     * @return Collection - a collection of the OtherPymtCtg objects
     */
    public Collection getAllPaymentCtgs() {
        try {
            //-- gets the local home interface and call the findAllPaymentCtgs method
            Collection otherPymtCtgCol = getOtherPymtCtgLocalHome().findAllPaymentCtgs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (otherPymtCtgCol != null && otherPymtCtgCol.size() > 0) {
                Iterator it = otherPymtCtgCol.iterator();
                while (it.hasNext()) {
                    OtherPymtCtgLocal otherPymtCtgLocal = (OtherPymtCtgLocal) it.next();
                    //-- get the primary key of the OtherPymtCtg EJB object
                    Integer otherPaymentCtgId = (Integer)otherPymtCtgLocal.getPrimaryKey();
                    //-- get the value object for the OtherPymtCtg EJB using the primary key
                    if (otherPaymentCtgId != null) {
                        OtherPymtCtgVO otherPymtCtgVO = getOtherPymtCtg(otherPaymentCtgId);
                        //-- add the value object to the collection
                        list.add(otherPymtCtgVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPaymentCtgs() method from OtherPymtCtgManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPaymentCtgs() method from OtherPymtCtgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the OtherPymtCtg local home interface
     */
    private OtherPymtCtgLocalHome getOtherPymtCtgLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (OtherPymtCtgLocalHome) service.getEJBLocalHome(ServiceConstants.OTHERPYMTCTG_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getOtherPymtCtgLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
