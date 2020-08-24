/**
 * @(#)EodManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class EodManagerBean implements SessionBean {

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
     * This method create new Eod object
     * @param eodVO a value object the Eod bean
     */
    public void setEod(EodVO eodVO)
        throws EodException {
        //-- we do not accept null value for the parameter.
        if (eodVO == null) {
            throw new IllegalArgumentException("eodVO parameter was null in setEod() method from EodManager class");
        }
        
        try {
            
            //-- create new Eod object
            getEodLocalHome().create(
                eodVO.getLocationCd(),
                eodVO.getEodDt(),
                eodVO.getEmployeeId());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setEod() method from EodManager class";
            throw new EodException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setEod() method from EodManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Eod object
     * @return eodVO - a value object of the Eod bean
     */
    public EodVO getEod(Integer eodId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (eodId == null) {
            throw new IllegalArgumentException("eodId parameter was null in getEod() method from EodManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            EodLocal eodLocal = getEodLocalHome().findByPrimaryKey(eodId);
            //-- create new value object to store the data
            EodVO eodVO = new EodVO();
            //-- populate the new value object
            eodVO.setEodId(eodLocal.getEodId());
            eodVO.setLocationCd(eodLocal.getLocationCd());
            eodVO.setEodDt(eodLocal.getEodDt());
            eodVO.setEmployeeId(eodLocal.getEmployeeId());
            return eodVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEod() method from EodManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Eod object
     * @param eodId - the Eod bean primary key
     */
    public void removeEod(Integer eodId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (eodId == null) {
            throw new IllegalArgumentException("eodId parameter was null in removeEod() method from EodManager class");
        }
        
        try {
            getEodLocalHome().remove(eodId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeEod() method from EodManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Eod object
     * @param eodVO - the value object of the Eod bean
     */
    public void updateEod(EodVO eodVO)
        throws EodException {
        //-- we do not accept null value for the parameter.
        if (eodVO == null) {
            throw new IllegalArgumentException("eodVO parameter was null in updateEod() method from EodManager class");
        }
        
        try {
            Integer eodId = eodVO.getEodId();
            
            EodLocal eodLocal = getEodLocalHome().findByPrimaryKey(eodId);
            //-- update Eod entity bean
            eodLocal.setLocationCd(eodVO.getLocationCd());
            eodLocal.setEodDt(eodVO.getEodDt());
            eodLocal.setEmployeeId(eodVO.getEmployeeId());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateEod() method from EodManager class";
            throw new EodException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateEod() method from EodManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllEods objects
     * @return Collection - a collection of the Eod objects
     */
    public Collection getAllEods() {
        try {
            //-- gets the local home interface and call the findAllEods method
            Collection eodCol = getEodLocalHome().findAllEods();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (eodCol != null && eodCol.size() > 0) {
                Iterator it = eodCol.iterator();
                while (it.hasNext()) {
                    EodLocal eodLocal = (EodLocal) it.next();
                    //-- get the primary key of the Eod EJB object
                    Integer eodId = (Integer)eodLocal.getPrimaryKey();
                    //-- get the value object for the Eod EJB using the primary key
                    if (eodId != null) {
                        EodVO eodVO = getEod(eodId);
                        //-- add the value object to the collection
                        list.add(eodVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllEods() method from EodManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllEods() method from EodManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodDt objects
     * @return Collection - a collection of the Eod objects
     */
    public Collection getEodByEodDt(Date eodDt) {
        try {
            //-- gets the local home interface and call the findByEodDt method
            Collection eodCol = getEodLocalHome().findByEodDt(eodDt);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (eodCol != null && eodCol.size() > 0) {
                Iterator it = eodCol.iterator();
                while (it.hasNext()) {
                    EodLocal eodLocal = (EodLocal) it.next();
                    //-- get the primary key of the Eod EJB object
                    Integer eodId = (Integer)eodLocal.getPrimaryKey();
                    //-- get the value object for the Eod EJB using the primary key
                    if (eodId != null) {
                        EodVO eodVO = getEod(eodId);
                        //-- add the value object to the collection
                        list.add(eodVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEodByEodDt() method from EodManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEodByEodDt() method from EodManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocationCd objects
     * @return Collection - a collection of the Eod objects
     */
    public Collection getEodByLocationCd(String locationCd) {
        try {
            //-- gets the local home interface and call the findByLocationCd method
            Collection eodCol = getEodLocalHome().findByLocationCd(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (eodCol != null && eodCol.size() > 0) {
                Iterator it = eodCol.iterator();
                while (it.hasNext()) {
                    EodLocal eodLocal = (EodLocal) it.next();
                    //-- get the primary key of the Eod EJB object
                    Integer eodId = (Integer)eodLocal.getPrimaryKey();
                    //-- get the value object for the Eod EJB using the primary key
                    if (eodId != null) {
                        EodVO eodVO = getEod(eodId);
                        //-- add the value object to the collection
                        list.add(eodVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEodByLocationCd() method from EodManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEodByLocationCd() method from EodManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocationDt objects
     * @return Collection - a collection of the Eod objects
     */
    public Collection getEodByLocationDt(String locationCd, Date eodDt) {
        try {
            //-- gets the local home interface and call the findByLocationDt method
            Collection eodCol = getEodLocalHome().findByLocationDt(locationCd, eodDt);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (eodCol != null && eodCol.size() > 0) {
                Iterator it = eodCol.iterator();
                while (it.hasNext()) {
                    EodLocal eodLocal = (EodLocal) it.next();
                    //-- get the primary key of the Eod EJB object
                    Integer eodId = (Integer)eodLocal.getPrimaryKey();
                    //-- get the value object for the Eod EJB using the primary key
                    if (eodId != null) {
                        EodVO eodVO = getEod(eodId);
                        //-- add the value object to the collection
                        list.add(eodVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getEodByLocationDt() method from EodManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getEodByLocationDt() method from EodManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Eod local home interface
     */
    private EodLocalHome getEodLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (EodLocalHome) service.getEJBLocalHome(ServiceConstants.EOD_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEodLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
