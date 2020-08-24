/**
 * @(#)RecSurchargesManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class RecSurchargesManagerBean implements SessionBean {

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
     * This method create new RecSurcharges object
     * @param recSurchargesVO a value object the RecSurcharges bean
     */
    public void setRecSurcharges(RecSurchargesVO recSurchargesVO)
        throws RecSurchargesException {
        //-- we do not accept null value for the parameter.
        if (recSurchargesVO == null) {
            throw new IllegalArgumentException("recSurchargesVO parameter was null in setRecSurcharges() method from RecSurchargesManager class");
        }
        
        try {
            
            //-- create new RecSurcharges object
            getRecSurchargesLocalHome().create(
                recSurchargesVO.getRecId(),
                recSurchargesVO.getSurchargeCd(),
                recSurchargesVO.getAppliedAmt());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setRecSurcharges() method from RecSurchargesManager class";
            throw new RecSurchargesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setRecSurcharges() method from RecSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a RecSurcharges object
     * @return recSurchargesVO - a value object of the RecSurcharges bean
     */
    public RecSurchargesVO getRecSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (recSurchargesPK == null) {
            throw new IllegalArgumentException("recSurchargesPK parameter was null in getRecSurcharges() method from RecSurchargesManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            RecSurchargesLocal recSurchargesLocal = getRecSurchargesLocalHome().findByPrimaryKey(recSurchargesPK);
            //-- create new value object to store the data
            RecSurchargesVO recSurchargesVO = new RecSurchargesVO();
            //-- populate the new value object
            recSurchargesVO.setRecId(recSurchargesLocal.getRecId());
            recSurchargesVO.setSurchargeCd(recSurchargesLocal.getSurchargeCd());
            recSurchargesVO.setAppliedAmt(recSurchargesLocal.getAppliedAmt());
            return recSurchargesVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getRecSurcharges() method from RecSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing RecSurcharges object
     * @param recSurchargesPK - the RecSurcharges bean primary key
     */
    public void removeRecSurcharges(com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (recSurchargesPK == null) {
            throw new IllegalArgumentException("recSurchargesPK parameter was null in removeRecSurcharges() method from RecSurchargesManager class");
        }
        
        try {
            getRecSurchargesLocalHome().remove(recSurchargesPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeRecSurcharges() method from RecSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RecSurcharges object
     * @param recSurchargesVO - the value object of the RecSurcharges bean
     */
    public void updateRecSurcharges(RecSurchargesVO recSurchargesVO)
        throws RecSurchargesException {
        //-- we do not accept null value for the parameter.
        if (recSurchargesVO == null) {
            throw new IllegalArgumentException("recSurchargesVO parameter was null in updateRecSurcharges() method from RecSurchargesManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK = recSurchargesVO.getRecSurchargesPK();
            
            RecSurchargesLocal recSurchargesLocal = getRecSurchargesLocalHome().findByPrimaryKey(recSurchargesPK);
            //-- update RecSurcharges entity bean
            recSurchargesLocal.setAppliedAmt(recSurchargesVO.getAppliedAmt());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateRecSurcharges() method from RecSurchargesManager class";
            throw new RecSurchargesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateRecSurcharges() method from RecSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRecSurcharges objects
     * @return Collection - a collection of the RecSurcharges objects
     */
    public Collection getAllRecSurcharges() {
        try {
            //-- gets the local home interface and call the findAllRecSurcharges method
            Collection recSurchargesCol = getRecSurchargesLocalHome().findAllRecSurcharges();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (recSurchargesCol != null && recSurchargesCol.size() > 0) {
                Iterator it = recSurchargesCol.iterator();
                while (it.hasNext()) {
                    RecSurchargesLocal recSurchargesLocal = (RecSurchargesLocal) it.next();
                    //-- get the primary key of the RecSurcharges EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK = (com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK)recSurchargesLocal.getPrimaryKey();
                    //-- get the value object for the RecSurcharges EJB using the primary key
                    if (recSurchargesPK != null) {
                        RecSurchargesVO recSurchargesVO = getRecSurcharges(recSurchargesPK);
                        //-- add the value object to the collection
                        list.add(recSurchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllRecSurcharges() method from RecSurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllRecSurcharges() method from RecSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByReceivable objects
     * @return Collection - a collection of the RecSurcharges objects
     */
    public Collection getRecSurchargesByReceivable(Integer recId) {
        try {
            //-- gets the local home interface and call the findByReceivable method
            Collection recSurchargesCol = getRecSurchargesLocalHome().findByReceivable(recId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (recSurchargesCol != null && recSurchargesCol.size() > 0) {
                Iterator it = recSurchargesCol.iterator();
                while (it.hasNext()) {
                    RecSurchargesLocal recSurchargesLocal = (RecSurchargesLocal) it.next();
                    //-- get the primary key of the RecSurcharges EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK = (com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK)recSurchargesLocal.getPrimaryKey();
                    //-- get the value object for the RecSurcharges EJB using the primary key
                    if (recSurchargesPK != null) {
                        RecSurchargesVO recSurchargesVO = getRecSurcharges(recSurchargesPK);
                        //-- add the value object to the collection
                        list.add(recSurchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getRecSurchargesByReceivable() method from RecSurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getRecSurchargesByReceivable() method from RecSurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the RecSurcharges local home interface
     */
    private RecSurchargesLocalHome getRecSurchargesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (RecSurchargesLocalHome) service.getEJBLocalHome(ServiceConstants.RECSURCHARGES_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRecSurchargesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
