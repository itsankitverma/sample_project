/**
 * @(#)OacAwbManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class OacAwbManagerBean implements SessionBean {

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
     * This method create new OacAwb object
     * @param oacAwbVO a value object the OacAwb bean
     */
    public void setOacAwb(OacAwbVO oacAwbVO)
        throws OacAwbException {
        //-- we do not accept null value for the parameter.
        if (oacAwbVO == null) {
            throw new IllegalArgumentException("oacAwbVO parameter was null in setOacAwb() method from OacAwbManager class");
        }
        
        try {
            
            //-- create new OacAwb object
            getOacAwbLocalHome().create(
                oacAwbVO.getObAncSvcIdNbr(),
                oacAwbVO.getAwbNbr());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setOacAwb() method from OacAwbManager class";
            throw new OacAwbException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setOacAwb() method from OacAwbManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a OacAwb object
     * @return oacAwbVO - a value object of the OacAwb bean
     */
    public OacAwbVO getOacAwb(com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (oacAwbPK == null) {
            throw new IllegalArgumentException("oacAwbPK parameter was null in getOacAwb() method from OacAwbManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            OacAwbLocal oacAwbLocal = getOacAwbLocalHome().findByPrimaryKey(oacAwbPK);
            //-- create new value object to store the data
            OacAwbVO oacAwbVO = new OacAwbVO();
            //-- populate the new value object
            oacAwbVO.setObAncSvcIdNbr(oacAwbLocal.getObAncSvcIdNbr());
            oacAwbVO.setAwbNbr(oacAwbLocal.getAwbNbr());
            return oacAwbVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOacAwb() method from OacAwbManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing OacAwb object
     * @param oacAwbPK - the OacAwb bean primary key
     */
    public void removeOacAwb(com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (oacAwbPK == null) {
            throw new IllegalArgumentException("oacAwbPK parameter was null in removeOacAwb() method from OacAwbManager class");
        }
        
        try {
            getOacAwbLocalHome().remove(oacAwbPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeOacAwb() method from OacAwbManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing OacAwb object
     * @param oacAwbVO - the value object of the OacAwb bean
     */
    public void updateOacAwb(OacAwbVO oacAwbVO)
        throws OacAwbException {
        //-- we do not accept null value for the parameter.
        if (oacAwbVO == null) {
            throw new IllegalArgumentException("oacAwbVO parameter was null in updateOacAwb() method from OacAwbManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK = oacAwbVO.getOacAwbPK();
            
            OacAwbLocal oacAwbLocal = getOacAwbLocalHome().findByPrimaryKey(oacAwbPK);
            //-- update OacAwb entity bean
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateOacAwb() method from OacAwbManager class";
            throw new OacAwbException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateOacAwb() method from OacAwbManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllOacAwbs objects
     * @return Collection - a collection of the OacAwb objects
     */
    public Collection getAllOacAwbs() {
        try {
            //-- gets the local home interface and call the findAllOacAwbs method
            Collection oacAwbCol = getOacAwbLocalHome().findAllOacAwbs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (oacAwbCol != null && oacAwbCol.size() > 0) {
                Iterator it = oacAwbCol.iterator();
                while (it.hasNext()) {
                    OacAwbLocal oacAwbLocal = (OacAwbLocal) it.next();
                    //-- get the primary key of the OacAwb EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK = (com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK)oacAwbLocal.getPrimaryKey();
                    //-- get the value object for the OacAwb EJB using the primary key
                    if (oacAwbPK != null) {
                        OacAwbVO oacAwbVO = getOacAwb(oacAwbPK);
                        //-- add the value object to the collection
                        list.add(oacAwbVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllOacAwbs() method from OacAwbManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllOacAwbs() method from OacAwbManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findOacAwbsByOacId objects
     * @return Collection - a collection of the OacAwb objects
     */
    public Collection getOacAwbOacAwbsByOacId(Integer oacId) {
        try {
            //-- gets the local home interface and call the findOacAwbsByOacId method
            Collection oacAwbCol = getOacAwbLocalHome().findOacAwbsByOacId(oacId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (oacAwbCol != null && oacAwbCol.size() > 0) {
                Iterator it = oacAwbCol.iterator();
                while (it.hasNext()) {
                    OacAwbLocal oacAwbLocal = (OacAwbLocal) it.next();
                    //-- get the primary key of the OacAwb EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK oacAwbPK = (com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK)oacAwbLocal.getPrimaryKey();
                    //-- get the value object for the OacAwb EJB using the primary key
                    if (oacAwbPK != null) {
                        OacAwbVO oacAwbVO = getOacAwb(oacAwbPK);
                        //-- add the value object to the collection
                        list.add(oacAwbVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getOacAwbOacAwbsByOacId() method from OacAwbManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOacAwbOacAwbsByOacId() method from OacAwbManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the OacAwb local home interface
     */
    private OacAwbLocalHome getOacAwbLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (OacAwbLocalHome) service.getEJBLocalHome(ServiceConstants.OACAWB_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getOacAwbLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
