/**
 * @(#)PymtImptLogManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PymtImptLogManagerBean implements SessionBean {

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
     * This method create new PymtImptLog object
     * @param pymtImptLogVO a value object the PymtImptLog bean
     */
    public void setPymtImptLog(PymtImptLogVO pymtImptLogVO)
        throws PymtImptLogException {
        //-- we do not accept null value for the parameter.
        if (pymtImptLogVO == null) {
            throw new IllegalArgumentException("pymtImptLogVO parameter was null in setPymtImptLog() method from PymtImptLogManager class");
        }
        
        try {
            
            //-- create new PymtImptLog object
            getPymtImptLogLocalHome().create(
                pymtImptLogVO.getImptFileNm(),
                pymtImptLogVO.getImptDt(),
                pymtImptLogVO.getLocationCd(),
                pymtImptLogVO.getStatusCd(),
                pymtImptLogVO.getMessage());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPymtImptLog() method from PymtImptLogManager class";
            throw new PymtImptLogException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPymtImptLog() method from PymtImptLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PymtImptLog object
     * @return pymtImptLogVO - a value object of the PymtImptLog bean
     */
    public PymtImptLogVO getPymtImptLog(Integer imptId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (imptId == null) {
            throw new IllegalArgumentException("imptId parameter was null in getPymtImptLog() method from PymtImptLogManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PymtImptLogLocal pymtImptLogLocal = getPymtImptLogLocalHome().findByPrimaryKey(imptId);
            //-- create new value object to store the data
            PymtImptLogVO pymtImptLogVO = new PymtImptLogVO();
            //-- populate the new value object
            pymtImptLogVO.setImptId(pymtImptLogLocal.getImptId());
            pymtImptLogVO.setImptFileNm(pymtImptLogLocal.getImptFileNm());
            pymtImptLogVO.setImptDt(pymtImptLogLocal.getImptDt());
            pymtImptLogVO.setLocationCd(pymtImptLogLocal.getLocationCd());
            pymtImptLogVO.setStatusCd(pymtImptLogLocal.getStatusCd());
            pymtImptLogVO.setMessage(pymtImptLogLocal.getMessage());
            return pymtImptLogVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPymtImptLog() method from PymtImptLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets PymtImptErrorDtl objects from the PymtImptLog object
     * @return Collection - a collection of the PymtImptErrorDtl objects
     */
    public Collection getPymtImptErrorDtls(Integer imptId)
        throws PymtImptLogException {
        //-- we do not accept null values for any parameters.
        if (imptId == null) {
            throw new IllegalArgumentException("imptId parameter was null in getPymtImptErrorDtls() method from PymtImptLogManager class");
        }
        
        try {
            PymtImptLogLocal pymtImptLogLocal = getPymtImptLogLocalHome().findByPrimaryKey(imptId);
            Set pymtImptErrorDtlCol = pymtImptLogLocal.getPymtImptErrorDtls();
            Collection list = new ArrayList();
            if (pymtImptErrorDtlCol != null) {
                Iterator it = pymtImptErrorDtlCol.iterator();
                while (it.hasNext()) {
                    PymtImptErrorDtlLocal pymtImptErrorDtlLocal = (PymtImptErrorDtlLocal) it.next();
                    Integer imptErrorDtlId = (Integer)pymtImptErrorDtlLocal.getPrimaryKey();
                    PymtImptErrorDtlVO pymtImptErrorDtlVO = getPymtImptErrorDtlManager().getPymtImptErrorDtl(imptErrorDtlId);
                    list.add(pymtImptErrorDtlVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtls() method from PymtImptLogManager class";
            throw new PymtImptLogException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtls() method from PymtImptLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PymtImptLog object
     * @param imptId - the PymtImptLog bean primary key
     */
    public void removePymtImptLog(Integer imptId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (imptId == null) {
            throw new IllegalArgumentException("imptId parameter was null in removePymtImptLog() method from PymtImptLogManager class");
        }
        
        try {
            getPymtImptLogLocalHome().remove(imptId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePymtImptLog() method from PymtImptLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PymtImptLog object
     * @param pymtImptLogVO - the value object of the PymtImptLog bean
     */
    public void updatePymtImptLog(PymtImptLogVO pymtImptLogVO)
        throws PymtImptLogException {
        //-- we do not accept null value for the parameter.
        if (pymtImptLogVO == null) {
            throw new IllegalArgumentException("pymtImptLogVO parameter was null in updatePymtImptLog() method from PymtImptLogManager class");
        }
        
        try {
            Integer imptId = pymtImptLogVO.getImptId();
            
            PymtImptLogLocal pymtImptLogLocal = getPymtImptLogLocalHome().findByPrimaryKey(imptId);
            //-- update PymtImptLog entity bean
            pymtImptLogLocal.setImptFileNm(pymtImptLogVO.getImptFileNm());
            pymtImptLogLocal.setImptDt(pymtImptLogVO.getImptDt());
            pymtImptLogLocal.setLocationCd(pymtImptLogVO.getLocationCd());
            pymtImptLogLocal.setStatusCd(pymtImptLogVO.getStatusCd());
            pymtImptLogLocal.setMessage(pymtImptLogVO.getMessage());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePymtImptLog() method from PymtImptLogManager class";
            throw new PymtImptLogException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePymtImptLog() method from PymtImptLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPymtImptLogs objects
     * @return Collection - a collection of the PymtImptLog objects
     */
    public Collection getAllPymtImptLogs() {
        try {
            //-- gets the local home interface and call the findAllPymtImptLogs method
            Collection pymtImptLogCol = getPymtImptLogLocalHome().findAllPymtImptLogs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (pymtImptLogCol != null && pymtImptLogCol.size() > 0) {
                Iterator it = pymtImptLogCol.iterator();
                while (it.hasNext()) {
                    PymtImptLogLocal pymtImptLogLocal = (PymtImptLogLocal) it.next();
                    //-- get the primary key of the PymtImptLog EJB object
                    Integer imptId = (Integer)pymtImptLogLocal.getPrimaryKey();
                    //-- get the value object for the PymtImptLog EJB using the primary key
                    if (imptId != null) {
                        PymtImptLogVO pymtImptLogVO = getPymtImptLog(imptId);
                        //-- add the value object to the collection
                        list.add(pymtImptLogVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPymtImptLogs() method from PymtImptLogManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPymtImptLogs() method from PymtImptLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PymtImptLog local home interface
     */
    private PymtImptLogLocalHome getPymtImptLogLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PymtImptLogLocalHome) service.getEJBLocalHome(ServiceConstants.PYMTIMPTLOG_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPymtImptLogLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PymtImptErrorDtlManager remote interface
     */
    public PymtImptErrorDtlManager getPymtImptErrorDtlManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PymtImptErrorDtlManagerHome pymtImptErrorDtlManagerHome = (PymtImptErrorDtlManagerHome)
            service.getEJBHome(ServiceConstants.PYMTIMPTERRORDTLMANAGER_REMOTE_JNDI, PymtImptErrorDtlManagerHome.class);
            return pymtImptErrorDtlManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtlManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtlManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtlManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
