/**
 * @(#)PrepSurchargesManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PrepSurchargesManagerBean implements SessionBean {

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
     * This method create new PrepSurcharges object
     * @param prepSurchargesVO a value object the PrepSurcharges bean
     */
    public void setPrepSurcharges(PrepSurchargesVO prepSurchargesVO)
        throws PrepSurchargesException {
        //-- we do not accept null value for the parameter.
        if (prepSurchargesVO == null) {
            throw new IllegalArgumentException("prepSurchargesVO parameter was null in setPrepSurcharges() method from PrepSurchargesManager class");
        }
        
        try {
            
            //-- create new PrepSurcharges object
            getPrepSurchargesLocalHome().create(
                prepSurchargesVO.getPrepaidId(),
                prepSurchargesVO.getSurchargeCd(),
                prepSurchargesVO.getAppliedAmt());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPrepSurcharges() method from PrepSurchargesManager class";
            throw new PrepSurchargesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPrepSurcharges() method from PrepSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PrepSurcharges object
     * @return prepSurchargesVO - a value object of the PrepSurcharges bean
     */
    public PrepSurchargesVO getPrepSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (prepSurchargesPK == null) {
            throw new IllegalArgumentException("prepSurchargesPK parameter was null in getPrepSurcharges() method from PrepSurchargesManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PrepSurchargesLocal prepSurchargesLocal = getPrepSurchargesLocalHome().findByPrimaryKey(prepSurchargesPK);
            //-- create new value object to store the data
            PrepSurchargesVO prepSurchargesVO = new PrepSurchargesVO();
            //-- populate the new value object
            prepSurchargesVO.setPrepaidId(prepSurchargesLocal.getPrepaidId());
            prepSurchargesVO.setSurchargeCd(prepSurchargesLocal.getSurchargeCd());
            prepSurchargesVO.setAppliedAmt(prepSurchargesLocal.getAppliedAmt());
            return prepSurchargesVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPrepSurcharges() method from PrepSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PrepSurcharges object
     * @param prepSurchargesPK - the PrepSurcharges bean primary key
     */
    public void removePrepSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (prepSurchargesPK == null) {
            throw new IllegalArgumentException("prepSurchargesPK parameter was null in removePrepSurcharges() method from PrepSurchargesManager class");
        }
        
        try {
            getPrepSurchargesLocalHome().remove(prepSurchargesPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePrepSurcharges() method from PrepSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PrepSurcharges object
     * @param prepSurchargesVO - the value object of the PrepSurcharges bean
     */
    public void updatePrepSurcharges(PrepSurchargesVO prepSurchargesVO)
        throws PrepSurchargesException {
        //-- we do not accept null value for the parameter.
        if (prepSurchargesVO == null) {
            throw new IllegalArgumentException("prepSurchargesVO parameter was null in updatePrepSurcharges() method from PrepSurchargesManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK = prepSurchargesVO.getPrepSurchargesPK();
            
            PrepSurchargesLocal prepSurchargesLocal = getPrepSurchargesLocalHome().findByPrimaryKey(prepSurchargesPK);
            //-- update PrepSurcharges entity bean
            prepSurchargesLocal.setAppliedAmt(prepSurchargesVO.getAppliedAmt());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePrepSurcharges() method from PrepSurchargesManager class";
            throw new PrepSurchargesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePrepSurcharges() method from PrepSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPrepSurcharges objects
     * @return Collection - a collection of the PrepSurcharges objects
     */
    public Collection getAllPrepSurcharges() {
        try {
            //-- gets the local home interface and call the findAllPrepSurcharges method
            Collection prepSurchargesCol = getPrepSurchargesLocalHome().findAllPrepSurcharges();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (prepSurchargesCol != null && prepSurchargesCol.size() > 0) {
                Iterator it = prepSurchargesCol.iterator();
                while (it.hasNext()) {
                    PrepSurchargesLocal prepSurchargesLocal = (PrepSurchargesLocal) it.next();
                    //-- get the primary key of the PrepSurcharges EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK = (com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK)prepSurchargesLocal.getPrimaryKey();
                    //-- get the value object for the PrepSurcharges EJB using the primary key
                    if (prepSurchargesPK != null) {
                        PrepSurchargesVO prepSurchargesVO = getPrepSurcharges(prepSurchargesPK);
                        //-- add the value object to the collection
                        list.add(prepSurchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPrepSurcharges() method from PrepSurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPrepSurcharges() method from PrepSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPrepaid objects
     * @return Collection - a collection of the PrepSurcharges objects
     */
    public Collection getPrepSurchargesByPrepaid(Integer prepId) {
        try {
            //-- gets the local home interface and call the findByPrepaid method
            Collection prepSurchargesCol = getPrepSurchargesLocalHome().findByPrepaid(prepId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (prepSurchargesCol != null && prepSurchargesCol.size() > 0) {
                Iterator it = prepSurchargesCol.iterator();
                while (it.hasNext()) {
                    PrepSurchargesLocal prepSurchargesLocal = (PrepSurchargesLocal) it.next();
                    //-- get the primary key of the PrepSurcharges EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK = (com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK)prepSurchargesLocal.getPrimaryKey();
                    //-- get the value object for the PrepSurcharges EJB using the primary key
                    if (prepSurchargesPK != null) {
                        PrepSurchargesVO prepSurchargesVO = getPrepSurcharges(prepSurchargesPK);
                        //-- add the value object to the collection
                        list.add(prepSurchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPrepSurchargesByPrepaid() method from PrepSurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPrepSurchargesByPrepaid() method from PrepSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PrepSurcharges local home interface
     */
    private PrepSurchargesLocalHome getPrepSurchargesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PrepSurchargesLocalHome) service.getEJBLocalHome(ServiceConstants.PREPSURCHARGES_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPrepSurchargesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
