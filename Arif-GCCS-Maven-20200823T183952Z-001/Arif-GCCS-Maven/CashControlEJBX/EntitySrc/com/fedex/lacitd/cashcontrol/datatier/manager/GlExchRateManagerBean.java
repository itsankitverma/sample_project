/**
 * @(#)GlExchRateManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class GlExchRateManagerBean implements SessionBean {

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
     * This method create new GlExchRate object
     * @param glExchRateVO a value object the GlExchRate bean
     */
    public void setGlExchRate(GlExchRateVO glExchRateVO)
        throws GlExchRateException {
        //-- we do not accept null value for the parameter.
        if (glExchRateVO == null) {
            throw new IllegalArgumentException("glExchRateVO parameter was null in setGlExchRate() method from GlExchRateManager class");
        }
        
        try {
            
            //-- create new GlExchRate object
            getGlExchRateLocalHome().create(
                glExchRateVO.getCurrCd(),
                glExchRateVO.getPerdDt(),
                glExchRateVO.getAvgExchRtAmt(),
                glExchRateVO.getCurExchRtAmt());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setGlExchRate() method from GlExchRateManager class";
            throw new GlExchRateException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setGlExchRate() method from GlExchRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a GlExchRate object
     * @return glExchRateVO - a value object of the GlExchRate bean
     */
    public GlExchRateVO getGlExchRate(com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK glExchRatePK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (glExchRatePK == null) {
            throw new IllegalArgumentException("glExchRatePK parameter was null in getGlExchRate() method from GlExchRateManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            GlExchRateLocal glExchRateLocal = getGlExchRateLocalHome().findByPrimaryKey(glExchRatePK);
            //-- create new value object to store the data
            GlExchRateVO glExchRateVO = new GlExchRateVO();
            //-- populate the new value object
            glExchRateVO.setCurrCd(glExchRateLocal.getCurrCd());
            glExchRateVO.setPerdDt(glExchRateLocal.getPerdDt());
            glExchRateVO.setAvgExchRtAmt(glExchRateLocal.getAvgExchRtAmt());
            glExchRateVO.setCurExchRtAmt(glExchRateLocal.getCurExchRtAmt());
            return glExchRateVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getGlExchRate() method from GlExchRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing GlExchRate object
     * @param glExchRatePK - the GlExchRate bean primary key
     */
    public void removeGlExchRate(com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK glExchRatePK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (glExchRatePK == null) {
            throw new IllegalArgumentException("glExchRatePK parameter was null in removeGlExchRate() method from GlExchRateManager class");
        }
        
        try {
            getGlExchRateLocalHome().remove(glExchRatePK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeGlExchRate() method from GlExchRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing GlExchRate object
     * @param glExchRateVO - the value object of the GlExchRate bean
     */
    public void updateGlExchRate(GlExchRateVO glExchRateVO)
        throws GlExchRateException {
        //-- we do not accept null value for the parameter.
        if (glExchRateVO == null) {
            throw new IllegalArgumentException("glExchRateVO parameter was null in updateGlExchRate() method from GlExchRateManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK glExchRatePK = glExchRateVO.getGlExchRatePK();
            
            GlExchRateLocal glExchRateLocal = getGlExchRateLocalHome().findByPrimaryKey(glExchRatePK);
            //-- update GlExchRate entity bean
            glExchRateLocal.setAvgExchRtAmt(glExchRateVO.getAvgExchRtAmt());
            glExchRateLocal.setCurExchRtAmt(glExchRateVO.getCurExchRtAmt());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateGlExchRate() method from GlExchRateManager class";
            throw new GlExchRateException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateGlExchRate() method from GlExchRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllGlExchRate objects
     * @return Collection - a collection of the GlExchRate objects
     */
    public Collection getAllGlExchRate() {
        try {
            //-- gets the local home interface and call the findAllGlExchRate method
            Collection glExchRateCol = getGlExchRateLocalHome().findAllGlExchRate();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (glExchRateCol != null && glExchRateCol.size() > 0) {
                Iterator it = glExchRateCol.iterator();
                while (it.hasNext()) {
                    GlExchRateLocal glExchRateLocal = (GlExchRateLocal) it.next();
                    //-- get the primary key of the GlExchRate EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK glExchRatePK = (com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK)glExchRateLocal.getPrimaryKey();
                    //-- get the value object for the GlExchRate EJB using the primary key
                    if (glExchRatePK != null) {
                        GlExchRateVO glExchRateVO = getGlExchRate(glExchRatePK);
                        //-- add the value object to the collection
                        list.add(glExchRateVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllGlExchRate() method from GlExchRateManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllGlExchRate() method from GlExchRateManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the GlExchRate local home interface
     */
    private GlExchRateLocalHome getGlExchRateLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (GlExchRateLocalHome) service.getEJBLocalHome(ServiceConstants.GLEXCHRATE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getGlExchRateLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
