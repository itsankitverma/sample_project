/**
 * @(#)RecExpSrchgManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class RecExpSrchgManagerBean implements SessionBean {

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
     * This method create new RecExpSrchg object
     * @param recExpSrchgVO a value object the RecExpSrchg bean
     */
    public void setRecExpSrchg(RecExpSrchgVO recExpSrchgVO)
        throws RecExpSrchgException {
        //-- we do not accept null value for the parameter.
        if (recExpSrchgVO == null) {
            throw new IllegalArgumentException("recExpSrchgVO parameter was null in setRecExpSrchg() method from RecExpSrchgManager class");
        }
        
        try {
            
            //-- create new RecExpSrchg object
            getRecExpSrchgLocalHome().create(
                recExpSrchgVO.getRecId(),
                recExpSrchgVO.getSurchargeCd(),
                recExpSrchgVO.getAppliedAmt());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setRecExpSrchg() method from RecExpSrchgManager class";
            throw new RecExpSrchgException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setRecExpSrchg() method from RecExpSrchgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a RecExpSrchg object
     * @return recExpSrchgVO - a value object of the RecExpSrchg bean
     */
    public RecExpSrchgVO getRecExpSrchg(com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (recExpSrchgPK == null) {
            throw new IllegalArgumentException("recExpSrchgPK parameter was null in getRecExpSrchg() method from RecExpSrchgManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            RecExpSrchgLocal recExpSrchgLocal = getRecExpSrchgLocalHome().findByPrimaryKey(recExpSrchgPK);
            //-- create new value object to store the data
            RecExpSrchgVO recExpSrchgVO = new RecExpSrchgVO();
            //-- populate the new value object
            recExpSrchgVO.setRecId(recExpSrchgLocal.getRecId());
            recExpSrchgVO.setSurchargeCd(recExpSrchgLocal.getSurchargeCd());
            recExpSrchgVO.setAppliedAmt(recExpSrchgLocal.getAppliedAmt());
            return recExpSrchgVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getRecExpSrchg() method from RecExpSrchgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing RecExpSrchg object
     * @param recExpSrchgPK - the RecExpSrchg bean primary key
     */
    public void removeRecExpSrchg(com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (recExpSrchgPK == null) {
            throw new IllegalArgumentException("recExpSrchgPK parameter was null in removeRecExpSrchg() method from RecExpSrchgManager class");
        }
        
        try {
            getRecExpSrchgLocalHome().remove(recExpSrchgPK);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeRecExpSrchg() method from RecExpSrchgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RecExpSrchg object
     * @param recExpSrchgVO - the value object of the RecExpSrchg bean
     */
    public void updateRecExpSrchg(RecExpSrchgVO recExpSrchgVO)
        throws RecExpSrchgException {
        //-- we do not accept null value for the parameter.
        if (recExpSrchgVO == null) {
            throw new IllegalArgumentException("recExpSrchgVO parameter was null in updateRecExpSrchg() method from RecExpSrchgManager class");
        }
        
        try {
            com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK = recExpSrchgVO.getRecExpSrchgPK();
            
            RecExpSrchgLocal recExpSrchgLocal = getRecExpSrchgLocalHome().findByPrimaryKey(recExpSrchgPK);
            //-- update RecExpSrchg entity bean
            recExpSrchgLocal.setAppliedAmt(recExpSrchgVO.getAppliedAmt());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateRecExpSrchg() method from RecExpSrchgManager class";
            throw new RecExpSrchgException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateRecExpSrchg() method from RecExpSrchgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRecExpSrchgs objects
     * @return Collection - a collection of the RecExpSrchg objects
     */
    public Collection getAllRecExpSrchgs() {
        try {
            //-- gets the local home interface and call the findAllRecExpSrchgs method
            Collection recExpSrchgCol = getRecExpSrchgLocalHome().findAllRecExpSrchgs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (recExpSrchgCol != null && recExpSrchgCol.size() > 0) {
                Iterator it = recExpSrchgCol.iterator();
                while (it.hasNext()) {
                    RecExpSrchgLocal recExpSrchgLocal = (RecExpSrchgLocal) it.next();
                    //-- get the primary key of the RecExpSrchg EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK = (com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK)recExpSrchgLocal.getPrimaryKey();
                    //-- get the value object for the RecExpSrchg EJB using the primary key
                    if (recExpSrchgPK != null) {
                        RecExpSrchgVO recExpSrchgVO = getRecExpSrchg(recExpSrchgPK);
                        //-- add the value object to the collection
                        list.add(recExpSrchgVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllRecExpSrchgs() method from RecExpSrchgManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllRecExpSrchgs() method from RecExpSrchgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByReceivable objects
     * @return Collection - a collection of the RecExpSrchg objects
     */
    public Collection getRecExpSrchgByReceivable(Integer recId) {
        try {
            //-- gets the local home interface and call the findByReceivable method
            Collection recExpSrchgCol = getRecExpSrchgLocalHome().findByReceivable(recId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (recExpSrchgCol != null && recExpSrchgCol.size() > 0) {
                Iterator it = recExpSrchgCol.iterator();
                while (it.hasNext()) {
                    RecExpSrchgLocal recExpSrchgLocal = (RecExpSrchgLocal) it.next();
                    //-- get the primary key of the RecExpSrchg EJB object
                    com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK = (com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK)recExpSrchgLocal.getPrimaryKey();
                    //-- get the value object for the RecExpSrchg EJB using the primary key
                    if (recExpSrchgPK != null) {
                        RecExpSrchgVO recExpSrchgVO = getRecExpSrchg(recExpSrchgPK);
                        //-- add the value object to the collection
                        list.add(recExpSrchgVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getRecExpSrchgByReceivable() method from RecExpSrchgManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getRecExpSrchgByReceivable() method from RecExpSrchgManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the RecExpSrchg local home interface
     */
    private RecExpSrchgLocalHome getRecExpSrchgLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (RecExpSrchgLocalHome) service.getEJBLocalHome(ServiceConstants.RECEXPSRCHG_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRecExpSrchgLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
