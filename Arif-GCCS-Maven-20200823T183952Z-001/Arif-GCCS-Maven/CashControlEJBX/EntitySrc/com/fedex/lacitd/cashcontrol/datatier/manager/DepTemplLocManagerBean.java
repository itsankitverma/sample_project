/**
 * @(#)DepTemplLocManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class DepTemplLocManagerBean implements SessionBean {

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
     * This method create new DepTemplLoc object
     * @param depTemplLocVO a value object the DepTemplLoc bean
     */
    public void setDepTemplLoc(DepTemplLocVO depTemplLocVO)
        throws DepTemplLocException {
        //-- we do not accept null value for the parameter.
        if (depTemplLocVO == null) {
            throw new IllegalArgumentException("depTemplLocVO parameter was null in setDepTemplLoc() method from DepTemplLocManager class");
        }
        
        try {
            
            //-- create new DepTemplLoc object
            getDepTemplLocLocalHome().create(
                depTemplLocVO.getLocationCd(),
                depTemplLocVO.getTemplId());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setDepTemplLoc() method from DepTemplLocManager class";
            throw new DepTemplLocException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setDepTemplLoc() method from DepTemplLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a DepTemplLoc object
     * @return depTemplLocVO - a value object of the DepTemplLoc bean
     */
    public DepTemplLocVO getDepTemplLoc(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (depTemplLocPK == null) {
            throw new IllegalArgumentException("depTemplLocPK parameter was null in getDepTemplLoc() method from DepTemplLocManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            DepTemplLocLocal depTemplLocLocal = getDepTemplLocLocalHome().findByPrimaryKey(depTemplLocPK);
            //-- create new value object to store the data
            DepTemplLocVO depTemplLocVO = new DepTemplLocVO();
            //-- populate the new value object
            depTemplLocVO.setLocationCd(depTemplLocLocal.getLocationCd());
            depTemplLocVO.setTemplId(depTemplLocLocal.getTemplId());
            return depTemplLocVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepTemplLoc() method from DepTemplLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing DepTemplLoc object
     * @param depTemplLocPK - the DepTemplLoc bean primary key
     */
    public void removeDepTemplLoc(com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (depTemplLocPK == null) {
            throw new IllegalArgumentException("depTemplLocPK parameter was null in removeDepTemplLoc() method from DepTemplLocManager class");
        }
        
        try {
            getDepTemplLocLocalHome().remove(depTemplLocPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeDepTemplLoc() method from DepTemplLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing DepTemplLoc object
     * @param depTemplLocVO - the value object of the DepTemplLoc bean
     */
    public void updateDepTemplLoc(DepTemplLocVO depTemplLocVO)
        throws DepTemplLocException {
        //-- we do not accept null value for the parameter.
        if (depTemplLocVO == null) {
            throw new IllegalArgumentException("depTemplLocVO parameter was null in updateDepTemplLoc() method from DepTemplLocManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK = depTemplLocVO.getDepTemplLocPK();
            
            DepTemplLocLocal depTemplLocLocal = getDepTemplLocLocalHome().findByPrimaryKey(depTemplLocPK);
            //-- update DepTemplLoc entity bean
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateDepTemplLoc() method from DepTemplLocManager class";
            throw new DepTemplLocException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateDepTemplLoc() method from DepTemplLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllDepTemplLocs objects
     * @return Collection - a collection of the DepTemplLoc objects
     */
    public Collection getAllDepTemplLocs() {
        try {
            //-- gets the local home interface and call the findAllDepTemplLocs method
            Collection depTemplLocCol = getDepTemplLocLocalHome().findAllDepTemplLocs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depTemplLocCol != null && depTemplLocCol.size() > 0) {
                Iterator it = depTemplLocCol.iterator();
                while (it.hasNext()) {
                    DepTemplLocLocal depTemplLocLocal = (DepTemplLocLocal) it.next();
                    //-- get the primary key of the DepTemplLoc EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK = (com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK)depTemplLocLocal.getPrimaryKey();
                    //-- get the value object for the DepTemplLoc EJB using the primary key
                    if (depTemplLocPK != null) {
                        DepTemplLocVO depTemplLocVO = getDepTemplLoc(depTemplLocPK);
                        //-- add the value object to the collection
                        list.add(depTemplLocVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllDepTemplLocs() method from DepTemplLocManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllDepTemplLocs() method from DepTemplLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the DepTemplLoc local home interface
     */
    private DepTemplLocLocalHome getDepTemplLocLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (DepTemplLocLocalHome) service.getEJBLocalHome(ServiceConstants.DEPTEMPLLOC_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepTemplLocLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
