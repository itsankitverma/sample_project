/**
 * @(#)DepTemplPymtTypeManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class DepTemplPymtTypeManagerBean implements SessionBean {

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
     * This method create new DepTemplPymtType object
     * @param depTemplPymtTypeVO a value object the DepTemplPymtType bean
     */
    public void setDepTemplPymtType(DepTemplPymtTypeVO depTemplPymtTypeVO)
        throws DepTemplPymtTypeException {
        //-- we do not accept null value for the parameter.
        if (depTemplPymtTypeVO == null) {
            throw new IllegalArgumentException("depTemplPymtTypeVO parameter was null in setDepTemplPymtType() method from DepTemplPymtTypeManager class");
        }
        
        try {
            
            //-- create new DepTemplPymtType object
            getDepTemplPymtTypeLocalHome().create(
                depTemplPymtTypeVO.getPaymentTypeId(),
                depTemplPymtTypeVO.getTemplId());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setDepTemplPymtType() method from DepTemplPymtTypeManager class";
            throw new DepTemplPymtTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setDepTemplPymtType() method from DepTemplPymtTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a DepTemplPymtType object
     * @return depTemplPymtTypeVO - a value object of the DepTemplPymtType bean
     */
    public DepTemplPymtTypeVO getDepTemplPymtType(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK depTemplPymtTypePK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (depTemplPymtTypePK == null) {
            throw new IllegalArgumentException("depTemplPymtTypePK parameter was null in getDepTemplPymtType() method from DepTemplPymtTypeManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            DepTemplPymtTypeLocal depTemplPymtTypeLocal = getDepTemplPymtTypeLocalHome().findByPrimaryKey(depTemplPymtTypePK);
            //-- create new value object to store the data
            DepTemplPymtTypeVO depTemplPymtTypeVO = new DepTemplPymtTypeVO();
            //-- populate the new value object
            depTemplPymtTypeVO.setPaymentTypeId(depTemplPymtTypeLocal.getPaymentTypeId());
            depTemplPymtTypeVO.setTemplId(depTemplPymtTypeLocal.getTemplId());
            return depTemplPymtTypeVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepTemplPymtType() method from DepTemplPymtTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing DepTemplPymtType object
     * @param depTemplPymtTypePK - the DepTemplPymtType bean primary key
     */
    public void removeDepTemplPymtType(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK depTemplPymtTypePK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (depTemplPymtTypePK == null) {
            throw new IllegalArgumentException("depTemplPymtTypePK parameter was null in removeDepTemplPymtType() method from DepTemplPymtTypeManager class");
        }
        
        try {
            getDepTemplPymtTypeLocalHome().remove(depTemplPymtTypePK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeDepTemplPymtType() method from DepTemplPymtTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing DepTemplPymtType object
     * @param depTemplPymtTypeVO - the value object of the DepTemplPymtType bean
     */
    public void updateDepTemplPymtType(DepTemplPymtTypeVO depTemplPymtTypeVO)
        throws DepTemplPymtTypeException {
        //-- we do not accept null value for the parameter.
        if (depTemplPymtTypeVO == null) {
            throw new IllegalArgumentException("depTemplPymtTypeVO parameter was null in updateDepTemplPymtType() method from DepTemplPymtTypeManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK depTemplPymtTypePK = depTemplPymtTypeVO.getDepTemplPymtTypePK();
            
            DepTemplPymtTypeLocal depTemplPymtTypeLocal = getDepTemplPymtTypeLocalHome().findByPrimaryKey(depTemplPymtTypePK);
            //-- update DepTemplPymtType entity bean
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateDepTemplPymtType() method from DepTemplPymtTypeManager class";
            throw new DepTemplPymtTypeException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateDepTemplPymtType() method from DepTemplPymtTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllDepTemplPymtTypes objects
     * @return Collection - a collection of the DepTemplPymtType objects
     */
    public Collection getAllDepTemplPymtTypes() {
        try {
            //-- gets the local home interface and call the findAllDepTemplPymtTypes method
            Collection depTemplPymtTypeCol = getDepTemplPymtTypeLocalHome().findAllDepTemplPymtTypes();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depTemplPymtTypeCol != null && depTemplPymtTypeCol.size() > 0) {
                Iterator it = depTemplPymtTypeCol.iterator();
                while (it.hasNext()) {
                    DepTemplPymtTypeLocal depTemplPymtTypeLocal = (DepTemplPymtTypeLocal) it.next();
                    //-- get the primary key of the DepTemplPymtType EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK depTemplPymtTypePK = (com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK)depTemplPymtTypeLocal.getPrimaryKey();
                    //-- get the value object for the DepTemplPymtType EJB using the primary key
                    if (depTemplPymtTypePK != null) {
                        DepTemplPymtTypeVO depTemplPymtTypeVO = getDepTemplPymtType(depTemplPymtTypePK);
                        //-- add the value object to the collection
                        list.add(depTemplPymtTypeVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllDepTemplPymtTypes() method from DepTemplPymtTypeManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllDepTemplPymtTypes() method from DepTemplPymtTypeManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the DepTemplPymtType local home interface
     */
    private DepTemplPymtTypeLocalHome getDepTemplPymtTypeLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (DepTemplPymtTypeLocalHome) service.getEJBLocalHome(ServiceConstants.DEPTEMPLPYMTTYPE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplPymtTypeLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
