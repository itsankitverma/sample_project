/**
 * @(#)SurchargeLocManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class SurchargeLocManagerBean implements SessionBean {

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
     * This method create new SurchargeLoc object
     * @param surchargeLocVO a value object the SurchargeLoc bean
     */
    public void setSurchargeLoc(SurchargeLocVO surchargeLocVO)
        throws SurchargeLocException {
        //-- we do not accept null value for the parameter.
        if (surchargeLocVO == null) {
            throw new IllegalArgumentException("surchargeLocVO parameter was null in setSurchargeLoc() method from SurchargeLocManager class");
        }
        
        try {
            
            //-- create new SurchargeLoc object
            getSurchargeLocLocalHome().create(
                surchargeLocVO.getSurchargeCd(),
                surchargeLocVO.getLocationCd(),
                surchargeLocVO.getApplyRod(),
                surchargeLocVO.getApplyPrepaid(),
                surchargeLocVO.getApplyPoa(),
                surchargeLocVO.getApplyOrder(),
                surchargeLocVO.getDisabSurcharge());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setSurchargeLoc() method from SurchargeLocManager class";
            throw new SurchargeLocException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setSurchargeLoc() method from SurchargeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a SurchargeLoc object
     * @return surchargeLocVO - a value object of the SurchargeLoc bean
     */
    public SurchargeLocVO getSurchargeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (surchargeLocPK == null) {
            throw new IllegalArgumentException("surchargeLocPK parameter was null in getSurchargeLoc() method from SurchargeLocManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            SurchargeLocLocal surchargeLocLocal = getSurchargeLocLocalHome().findByPrimaryKey(surchargeLocPK);
            //-- create new value object to store the data
            SurchargeLocVO surchargeLocVO = new SurchargeLocVO();
            //-- populate the new value object
            surchargeLocVO.setSurchargeCd(surchargeLocLocal.getSurchargeCd());
            surchargeLocVO.setLocationCd(surchargeLocLocal.getLocationCd());
            surchargeLocVO.setApplyRod(surchargeLocLocal.getApplyRod());
            surchargeLocVO.setApplyPrepaid(surchargeLocLocal.getApplyPrepaid());
            surchargeLocVO.setApplyPoa(surchargeLocLocal.getApplyPoa());
            surchargeLocVO.setApplyOrder(surchargeLocLocal.getApplyOrder());
            surchargeLocVO.setDisabSurcharge(surchargeLocLocal.getDisabSurcharge());
            return surchargeLocVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getSurchargeLoc() method from SurchargeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing SurchargeLoc object
     * @param surchargeLocPK - the SurchargeLoc bean primary key
     */
    public void removeSurchargeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (surchargeLocPK == null) {
            throw new IllegalArgumentException("surchargeLocPK parameter was null in removeSurchargeLoc() method from SurchargeLocManager class");
        }
        
        try {
            getSurchargeLocLocalHome().remove(surchargeLocPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeSurchargeLoc() method from SurchargeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing SurchargeLoc object
     * @param surchargeLocVO - the value object of the SurchargeLoc bean
     */
    public void updateSurchargeLoc(SurchargeLocVO surchargeLocVO)
        throws SurchargeLocException {
        //-- we do not accept null value for the parameter.
        if (surchargeLocVO == null) {
            throw new IllegalArgumentException("surchargeLocVO parameter was null in updateSurchargeLoc() method from SurchargeLocManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK = surchargeLocVO.getSurchargeLocPK();
            
            SurchargeLocLocal surchargeLocLocal = getSurchargeLocLocalHome().findByPrimaryKey(surchargeLocPK);
            //-- update SurchargeLoc entity bean
            surchargeLocLocal.setApplyRod(surchargeLocVO.getApplyRod());
            surchargeLocLocal.setApplyPrepaid(surchargeLocVO.getApplyPrepaid());
            surchargeLocLocal.setApplyPoa(surchargeLocVO.getApplyPoa());
            surchargeLocLocal.setApplyOrder(surchargeLocVO.getApplyOrder());
            surchargeLocLocal.setDisabSurcharge(surchargeLocVO.getDisabSurcharge());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateSurchargeLoc() method from SurchargeLocManager class";
            throw new SurchargeLocException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateSurchargeLoc() method from SurchargeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllSurchargeLocs objects
     * @return Collection - a collection of the SurchargeLoc objects
     */
    public Collection getAllSurchargeLocs() {
        try {
            //-- gets the local home interface and call the findAllSurchargeLocs method
            Collection surchargeLocCol = getSurchargeLocLocalHome().findAllSurchargeLocs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (surchargeLocCol != null && surchargeLocCol.size() > 0) {
                Iterator it = surchargeLocCol.iterator();
                while (it.hasNext()) {
                    SurchargeLocLocal surchargeLocLocal = (SurchargeLocLocal) it.next();
                    //-- get the primary key of the SurchargeLoc EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK = (com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK)surchargeLocLocal.getPrimaryKey();
                    //-- get the value object for the SurchargeLoc EJB using the primary key
                    if (surchargeLocPK != null) {
                        SurchargeLocVO surchargeLocVO = getSurchargeLoc(surchargeLocPK);
                        //-- add the value object to the collection
                        list.add(surchargeLocVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllSurchargeLocs() method from SurchargeLocManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllSurchargeLocs() method from SurchargeLocManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the SurchargeLoc local home interface
     */
    private SurchargeLocLocalHome getSurchargeLocLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (SurchargeLocLocalHome) service.getEJBLocalHome(ServiceConstants.SURCHARGELOC_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getSurchargeLocLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
