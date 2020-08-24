/**
 * @(#)PoaSurchargesManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PoaSurchargesManagerBean implements SessionBean {

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
     * This method create new PoaSurcharges object
     * @param poaSurchargesVO a value object the PoaSurcharges bean
     */
    public void setPoaSurcharges(PoaSurchargesVO poaSurchargesVO)
        throws PoaSurchargesException {
        //-- we do not accept null value for the parameter.
        if (poaSurchargesVO == null) {
            throw new IllegalArgumentException("poaSurchargesVO parameter was null in setPoaSurcharges() method from PoaSurchargesManager class");
        }
        
        try {
            
            //-- create new PoaSurcharges object
            getPoaSurchargesLocalHome().create(
                poaSurchargesVO.getPoaDetailId(),
                poaSurchargesVO.getSurchargeCd(),
                poaSurchargesVO.getAppliedAmt());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPoaSurcharges() method from PoaSurchargesManager class";
            throw new PoaSurchargesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPoaSurcharges() method from PoaSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PoaSurcharges object
     * @return poaSurchargesVO - a value object of the PoaSurcharges bean
     */
    public PoaSurchargesVO getPoaSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (poaSurchargesPK == null) {
            throw new IllegalArgumentException("poaSurchargesPK parameter was null in getPoaSurcharges() method from PoaSurchargesManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PoaSurchargesLocal poaSurchargesLocal = getPoaSurchargesLocalHome().findByPrimaryKey(poaSurchargesPK);
            //-- create new value object to store the data
            PoaSurchargesVO poaSurchargesVO = new PoaSurchargesVO();
            //-- populate the new value object
            poaSurchargesVO.setPoaDetailId(poaSurchargesLocal.getPoaDetailId());
            poaSurchargesVO.setSurchargeCd(poaSurchargesLocal.getSurchargeCd());
            poaSurchargesVO.setAppliedAmt(poaSurchargesLocal.getAppliedAmt());
            return poaSurchargesVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPoaSurcharges() method from PoaSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PoaSurcharges object
     * @param poaSurchargesPK - the PoaSurcharges bean primary key
     */
    public void removePoaSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (poaSurchargesPK == null) {
            throw new IllegalArgumentException("poaSurchargesPK parameter was null in removePoaSurcharges() method from PoaSurchargesManager class");
        }
        
        try {
            getPoaSurchargesLocalHome().remove(poaSurchargesPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePoaSurcharges() method from PoaSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PoaSurcharges object
     * @param poaSurchargesVO - the value object of the PoaSurcharges bean
     */
    public void updatePoaSurcharges(PoaSurchargesVO poaSurchargesVO)
        throws PoaSurchargesException {
        //-- we do not accept null value for the parameter.
        if (poaSurchargesVO == null) {
            throw new IllegalArgumentException("poaSurchargesVO parameter was null in updatePoaSurcharges() method from PoaSurchargesManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK = poaSurchargesVO.getPoaSurchargesPK();
            
            PoaSurchargesLocal poaSurchargesLocal = getPoaSurchargesLocalHome().findByPrimaryKey(poaSurchargesPK);
            //-- update PoaSurcharges entity bean
            poaSurchargesLocal.setAppliedAmt(poaSurchargesVO.getAppliedAmt());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePoaSurcharges() method from PoaSurchargesManager class";
            throw new PoaSurchargesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePoaSurcharges() method from PoaSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPoaSurcharges objects
     * @return Collection - a collection of the PoaSurcharges objects
     */
    public Collection getAllPoaSurcharges() {
        try {
            //-- gets the local home interface and call the findAllPoaSurcharges method
            Collection poaSurchargesCol = getPoaSurchargesLocalHome().findAllPoaSurcharges();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (poaSurchargesCol != null && poaSurchargesCol.size() > 0) {
                Iterator it = poaSurchargesCol.iterator();
                while (it.hasNext()) {
                    PoaSurchargesLocal poaSurchargesLocal = (PoaSurchargesLocal) it.next();
                    //-- get the primary key of the PoaSurcharges EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK = (com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK)poaSurchargesLocal.getPrimaryKey();
                    //-- get the value object for the PoaSurcharges EJB using the primary key
                    if (poaSurchargesPK != null) {
                        PoaSurchargesVO poaSurchargesVO = getPoaSurcharges(poaSurchargesPK);
                        //-- add the value object to the collection
                        list.add(poaSurchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPoaSurcharges() method from PoaSurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPoaSurcharges() method from PoaSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPoaDetail objects
     * @return Collection - a collection of the PoaSurcharges objects
     */
    public Collection getPoaSurchargesByPoaDetail(Integer poaDetailId) {
        try {
            //-- gets the local home interface and call the findByPoaDetail method
            Collection poaSurchargesCol = getPoaSurchargesLocalHome().findByPoaDetail(poaDetailId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (poaSurchargesCol != null && poaSurchargesCol.size() > 0) {
                Iterator it = poaSurchargesCol.iterator();
                while (it.hasNext()) {
                    PoaSurchargesLocal poaSurchargesLocal = (PoaSurchargesLocal) it.next();
                    //-- get the primary key of the PoaSurcharges EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK = (com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK)poaSurchargesLocal.getPrimaryKey();
                    //-- get the value object for the PoaSurcharges EJB using the primary key
                    if (poaSurchargesPK != null) {
                        PoaSurchargesVO poaSurchargesVO = getPoaSurcharges(poaSurchargesPK);
                        //-- add the value object to the collection
                        list.add(poaSurchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPoaSurchargesByPoaDetail() method from PoaSurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPoaSurchargesByPoaDetail() method from PoaSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PoaSurcharges local home interface
     */
    private PoaSurchargesLocalHome getPoaSurchargesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PoaSurchargesLocalHome) service.getEJBLocalHome(ServiceConstants.POASURCHARGES_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPoaSurchargesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
