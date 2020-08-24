/**
 * @(#)RodFileProcLogManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class RodFileProcLogManagerBean implements SessionBean {

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
     * This method create new RodFileProcLog object
     * @param rodFileProcLogVO a value object the RodFileProcLog bean
     */
    public void setRodFileProcLog(RodFileProcLogVO rodFileProcLogVO)
        throws RodFileProcLogException {
        //-- we do not accept null value for the parameter.
        if (rodFileProcLogVO == null) {
            throw new IllegalArgumentException("rodFileProcLogVO parameter was null in setRodFileProcLog() method from RodFileProcLogManager class");
        }
        
        try {
            
            //-- create new RodFileProcLog object
            getRodFileProcLogLocalHome().create(
                rodFileProcLogVO.getFileNm(),
                rodFileProcLogVO.getLocationCd(),
                rodFileProcLogVO.getProcessDt(),
                rodFileProcLogVO.getStatusCd(),
                rodFileProcLogVO.getMessage(),
                rodFileProcLogVO.getErrorDtlDesc(),
                rodFileProcLogVO.getAwbQty(),
                rodFileProcLogVO.getTotalLocalAmt(),
                rodFileProcLogVO.getTotalUsdAmt());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setRodFileProcLog() method from RodFileProcLogManager class";
            throw new RodFileProcLogException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setRodFileProcLog() method from RodFileProcLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a RodFileProcLog object
     * @return rodFileProcLogVO - a value object of the RodFileProcLog bean
     */
    public RodFileProcLogVO getRodFileProcLog(Integer rodFilePrLogId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (rodFilePrLogId == null) {
            throw new IllegalArgumentException("rodFilePrLogId parameter was null in getRodFileProcLog() method from RodFileProcLogManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            RodFileProcLogLocal rodFileProcLogLocal = getRodFileProcLogLocalHome().findByPrimaryKey(rodFilePrLogId);
            //-- create new value object to store the data
            RodFileProcLogVO rodFileProcLogVO = new RodFileProcLogVO();
            //-- populate the new value object
            rodFileProcLogVO.setRodFilePrLogId(rodFileProcLogLocal.getRodFilePrLogId());
            rodFileProcLogVO.setFileNm(rodFileProcLogLocal.getFileNm());
            rodFileProcLogVO.setLocationCd(rodFileProcLogLocal.getLocationCd());
            rodFileProcLogVO.setProcessDt(rodFileProcLogLocal.getProcessDt());
            rodFileProcLogVO.setStatusCd(rodFileProcLogLocal.getStatusCd());
            rodFileProcLogVO.setMessage(rodFileProcLogLocal.getMessage());
            rodFileProcLogVO.setErrorDtlDesc(rodFileProcLogLocal.getErrorDtlDesc());
            rodFileProcLogVO.setAwbQty(rodFileProcLogLocal.getAwbQty());
            rodFileProcLogVO.setTotalLocalAmt(rodFileProcLogLocal.getTotalLocalAmt());
            rodFileProcLogVO.setTotalUsdAmt(rodFileProcLogLocal.getTotalUsdAmt());
            return rodFileProcLogVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getRodFileProcLog() method from RodFileProcLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing RodFileProcLog object
     * @param rodFilePrLogId - the RodFileProcLog bean primary key
     */
    public void removeRodFileProcLog(Integer rodFilePrLogId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (rodFilePrLogId == null) {
            throw new IllegalArgumentException("rodFilePrLogId parameter was null in removeRodFileProcLog() method from RodFileProcLogManager class");
        }
        
        try {
            getRodFileProcLogLocalHome().remove(rodFilePrLogId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeRodFileProcLog() method from RodFileProcLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing RodFileProcLog object
     * @param rodFileProcLogVO - the value object of the RodFileProcLog bean
     */
    public void updateRodFileProcLog(RodFileProcLogVO rodFileProcLogVO)
        throws RodFileProcLogException {
        //-- we do not accept null value for the parameter.
        if (rodFileProcLogVO == null) {
            throw new IllegalArgumentException("rodFileProcLogVO parameter was null in updateRodFileProcLog() method from RodFileProcLogManager class");
        }
        
        try {
            Integer rodFilePrLogId = rodFileProcLogVO.getRodFilePrLogId();
            
            RodFileProcLogLocal rodFileProcLogLocal = getRodFileProcLogLocalHome().findByPrimaryKey(rodFilePrLogId);
            //-- update RodFileProcLog entity bean
            rodFileProcLogLocal.setFileNm(rodFileProcLogVO.getFileNm());
            rodFileProcLogLocal.setLocationCd(rodFileProcLogVO.getLocationCd());
            rodFileProcLogLocal.setProcessDt(rodFileProcLogVO.getProcessDt());
            rodFileProcLogLocal.setStatusCd(rodFileProcLogVO.getStatusCd());
            rodFileProcLogLocal.setMessage(rodFileProcLogVO.getMessage());
            rodFileProcLogLocal.setErrorDtlDesc(rodFileProcLogVO.getErrorDtlDesc());
            rodFileProcLogLocal.setAwbQty(rodFileProcLogVO.getAwbQty());
            rodFileProcLogLocal.setTotalLocalAmt(rodFileProcLogVO.getTotalLocalAmt());
            rodFileProcLogLocal.setTotalUsdAmt(rodFileProcLogVO.getTotalUsdAmt());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateRodFileProcLog() method from RodFileProcLogManager class";
            throw new RodFileProcLogException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateRodFileProcLog() method from RodFileProcLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllRodFileProcLogs objects
     * @return Collection - a collection of the RodFileProcLog objects
     */
    public Collection getAllRodFileProcLogs() {
        try {
            //-- gets the local home interface and call the findAllRodFileProcLogs method
            Collection rodFileProcLogCol = getRodFileProcLogLocalHome().findAllRodFileProcLogs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (rodFileProcLogCol != null && rodFileProcLogCol.size() > 0) {
                Iterator it = rodFileProcLogCol.iterator();
                while (it.hasNext()) {
                    RodFileProcLogLocal rodFileProcLogLocal = (RodFileProcLogLocal) it.next();
                    //-- get the primary key of the RodFileProcLog EJB object
                    Integer rodFilePrLogId = (Integer)rodFileProcLogLocal.getPrimaryKey();
                    //-- get the value object for the RodFileProcLog EJB using the primary key
                    if (rodFilePrLogId != null) {
                        RodFileProcLogVO rodFileProcLogVO = getRodFileProcLog(rodFilePrLogId);
                        //-- add the value object to the collection
                        list.add(rodFileProcLogVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllRodFileProcLogs() method from RodFileProcLogManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllRodFileProcLogs() method from RodFileProcLogManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the RodFileProcLog local home interface
     */
    private RodFileProcLogLocalHome getRodFileProcLogLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (RodFileProcLogLocalHome) service.getEJBLocalHome(ServiceConstants.RODFILEPROCLOG_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getRodFileProcLogLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
