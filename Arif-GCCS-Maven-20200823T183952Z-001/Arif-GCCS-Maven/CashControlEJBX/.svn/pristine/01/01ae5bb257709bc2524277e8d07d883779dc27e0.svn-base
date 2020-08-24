/**
 * @(#)SurchargesManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class SurchargesManagerBean implements SessionBean {

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
     * This method create new Surcharges object
     * @param surchargesVO a value object the Surcharges bean
     */
    public void setSurcharges(SurchargesVO surchargesVO)
        throws SurchargesException {
        //-- we do not accept null value for the parameter.
        if (surchargesVO == null) {
            throw new IllegalArgumentException("surchargesVO parameter was null in setSurcharges() method from SurchargesManager class");
        }
        
        try {
            
            //-- create new Surcharges object
            getSurchargesLocalHome().create(
                surchargesVO.getSurchargeCd(),
                surchargesVO.getShtDesc());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setSurcharges() method from SurchargesManager class";
            throw new SurchargesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setSurcharges() method from SurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Surcharges object
     * @return surchargesVO - a value object of the Surcharges bean
     */
    public SurchargesVO getSurcharges(String surchargeCd)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (surchargeCd == null) {
            throw new IllegalArgumentException("surchargeCd parameter was null in getSurcharges() method from SurchargesManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            SurchargesLocal surchargesLocal = getSurchargesLocalHome().findByPrimaryKey(surchargeCd);
            //-- create new value object to store the data
            SurchargesVO surchargesVO = new SurchargesVO();
            //-- populate the new value object
            surchargesVO.setSurchargeCd(surchargesLocal.getSurchargeCd());
            surchargesVO.setShtDesc(surchargesLocal.getShtDesc());
            return surchargesVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getSurcharges() method from SurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Surcharges object
     * @param surchargeCd - the Surcharges bean primary key
     */
    public void removeSurcharges(String surchargeCd)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (surchargeCd == null) {
            throw new IllegalArgumentException("surchargeCd parameter was null in removeSurcharges() method from SurchargesManager class");
        }
        
        try {
            getSurchargesLocalHome().remove(surchargeCd);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeSurcharges() method from SurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Surcharges object
     * @param surchargesVO - the value object of the Surcharges bean
     */
    public void updateSurcharges(SurchargesVO surchargesVO)
        throws SurchargesException {
        //-- we do not accept null value for the parameter.
        if (surchargesVO == null) {
            throw new IllegalArgumentException("surchargesVO parameter was null in updateSurcharges() method from SurchargesManager class");
        }
        
        try {
            String surchargeCd = surchargesVO.getSurchargeCd();
            
            SurchargesLocal surchargesLocal = getSurchargesLocalHome().findByPrimaryKey(surchargeCd);
            //-- update Surcharges entity bean
            surchargesLocal.setShtDesc(surchargesVO.getShtDesc());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateSurcharges() method from SurchargesManager class";
            throw new SurchargesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateSurcharges() method from SurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllSurcharges objects
     * @return Collection - a collection of the Surcharges objects
     */
    public Collection getAllSurcharges() {
        try {
            //-- gets the local home interface and call the findAllSurcharges method
            Collection surchargesCol = getSurchargesLocalHome().findAllSurcharges();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (surchargesCol != null && surchargesCol.size() > 0) {
                Iterator it = surchargesCol.iterator();
                while (it.hasNext()) {
                    SurchargesLocal surchargesLocal = (SurchargesLocal) it.next();
                    //-- get the primary key of the Surcharges EJB object
                    String surchargeCd = (String)surchargesLocal.getPrimaryKey();
                    //-- get the value object for the Surcharges EJB using the primary key
                    if (surchargeCd != null) {
                        SurchargesVO surchargesVO = getSurcharges(surchargeCd);
                        //-- add the value object to the collection
                        list.add(surchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllSurcharges() method from SurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllSurcharges() method from SurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByRod objects
     * @return Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByRod(String locationCd) {
        try {
            //-- gets the local home interface and call the findByRod method
            Collection surchargesCol = getSurchargesLocalHome().findByRod(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (surchargesCol != null && surchargesCol.size() > 0) {
                Iterator it = surchargesCol.iterator();
                while (it.hasNext()) {
                    SurchargesLocal surchargesLocal = (SurchargesLocal) it.next();
                    //-- get the primary key of the Surcharges EJB object
                    String surchargeCd = (String)surchargesLocal.getPrimaryKey();
                    //-- get the value object for the Surcharges EJB using the primary key
                    if (surchargeCd != null) {
                        SurchargesVO surchargesVO = getSurcharges(surchargeCd);
                        //-- add the value object to the collection
                        list.add(surchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getSurchargesByRod() method from SurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getSurchargesByRod() method from SurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPrepaid objects
     * @return Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByPrepaid(String locationCd) {
        try {
            //-- gets the local home interface and call the findByPrepaid method
            Collection surchargesCol = getSurchargesLocalHome().findByPrepaid(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (surchargesCol != null && surchargesCol.size() > 0) {
                Iterator it = surchargesCol.iterator();
                while (it.hasNext()) {
                    SurchargesLocal surchargesLocal = (SurchargesLocal) it.next();
                    //-- get the primary key of the Surcharges EJB object
                    String surchargeCd = (String)surchargesLocal.getPrimaryKey();
                    //-- get the value object for the Surcharges EJB using the primary key
                    if (surchargeCd != null) {
                        SurchargesVO surchargesVO = getSurcharges(surchargeCd);
                        //-- add the value object to the collection
                        list.add(surchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getSurchargesByPrepaid() method from SurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getSurchargesByPrepaid() method from SurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPoa objects
     * @return Collection - a collection of the Surcharges objects
     */
    public Collection getSurchargesByPoa(String locationCd) {
        try {
            //-- gets the local home interface and call the findByPoa method
            Collection surchargesCol = getSurchargesLocalHome().findByPoa(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (surchargesCol != null && surchargesCol.size() > 0) {
                Iterator it = surchargesCol.iterator();
                while (it.hasNext()) {
                    SurchargesLocal surchargesLocal = (SurchargesLocal) it.next();
                    //-- get the primary key of the Surcharges EJB object
                    String surchargeCd = (String)surchargesLocal.getPrimaryKey();
                    //-- get the value object for the Surcharges EJB using the primary key
                    if (surchargeCd != null) {
                        SurchargesVO surchargesVO = getSurcharges(surchargeCd);
                        //-- add the value object to the collection
                        list.add(surchargesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getSurchargesByPoa() method from SurchargesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getSurchargesByPoa() method from SurchargesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Surcharges local home interface
     */
    private SurchargesLocalHome getSurchargesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (SurchargesLocalHome) service.getEJBLocalHome(ServiceConstants.SURCHARGES_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getSurchargesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
