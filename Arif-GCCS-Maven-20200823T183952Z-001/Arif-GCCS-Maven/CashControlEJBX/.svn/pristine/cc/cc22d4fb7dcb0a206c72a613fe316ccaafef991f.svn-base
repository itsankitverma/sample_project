/**
 * @(#)ScanLocProcManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class ScanLocProcManagerBean implements SessionBean {

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
     * This method create new ScanLocProc object
     * @param scanLocProcVO a value object the ScanLocProc bean
     */
    public void setScanLocProc(ScanLocProcVO scanLocProcVO)
        throws ScanLocProcException {
        //-- we do not accept null value for the parameter.
        if (scanLocProcVO == null) {
            throw new IllegalArgumentException("scanLocProcVO parameter was null in setScanLocProc() method from ScanLocProcManager class");
        }
        
        try {
            
            //-- create new ScanLocProc object
            getScanLocProcLocalHome().create(
                scanLocProcVO.getLocationCd(),
                scanLocProcVO.getProcDate(),
                scanLocProcVO.getResult());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setScanLocProc() method from ScanLocProcManager class";
            throw new ScanLocProcException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setScanLocProc() method from ScanLocProcManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a ScanLocProc object
     * @return scanLocProcVO - a value object of the ScanLocProc bean
     */
    public ScanLocProcVO getScanLocProc(Integer scanLocProcId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (scanLocProcId == null) {
            throw new IllegalArgumentException("scanLocProcId parameter was null in getScanLocProc() method from ScanLocProcManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            ScanLocProcLocal scanLocProcLocal = getScanLocProcLocalHome().findByPrimaryKey(scanLocProcId);
            //-- create new value object to store the data
            ScanLocProcVO scanLocProcVO = new ScanLocProcVO();
            //-- populate the new value object
            scanLocProcVO.setScanLocProcId(scanLocProcLocal.getScanLocProcId());
            scanLocProcVO.setLocationCd(scanLocProcLocal.getLocationCd());
            scanLocProcVO.setProcDate(scanLocProcLocal.getProcDate());
            scanLocProcVO.setResult(scanLocProcLocal.getResult());
            return scanLocProcVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getScanLocProc() method from ScanLocProcManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing ScanLocProc object
     * @param scanLocProcId - the ScanLocProc bean primary key
     */
    public void removeScanLocProc(Integer scanLocProcId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (scanLocProcId == null) {
            throw new IllegalArgumentException("scanLocProcId parameter was null in removeScanLocProc() method from ScanLocProcManager class");
        }
        
        try {
            getScanLocProcLocalHome().remove(scanLocProcId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeScanLocProc() method from ScanLocProcManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing ScanLocProc object
     * @param scanLocProcVO - the value object of the ScanLocProc bean
     */
    public void updateScanLocProc(ScanLocProcVO scanLocProcVO)
        throws ScanLocProcException {
        //-- we do not accept null value for the parameter.
        if (scanLocProcVO == null) {
            throw new IllegalArgumentException("scanLocProcVO parameter was null in updateScanLocProc() method from ScanLocProcManager class");
        }
        
        try {
            Integer scanLocProcId = scanLocProcVO.getScanLocProcId();
            
            ScanLocProcLocal scanLocProcLocal = getScanLocProcLocalHome().findByPrimaryKey(scanLocProcId);
            //-- update ScanLocProc entity bean
            scanLocProcLocal.setLocationCd(scanLocProcVO.getLocationCd());
            scanLocProcLocal.setProcDate(scanLocProcVO.getProcDate());
            scanLocProcLocal.setResult(scanLocProcVO.getResult());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateScanLocProc() method from ScanLocProcManager class";
            throw new ScanLocProcException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateScanLocProc() method from ScanLocProcManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllScanLocProcs objects
     * @return Collection - a collection of the ScanLocProc objects
     */
    public Collection getAllScanLocProcs() {
        try {
            //-- gets the local home interface and call the findAllScanLocProcs method
            Collection scanLocProcCol = getScanLocProcLocalHome().findAllScanLocProcs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (scanLocProcCol != null && scanLocProcCol.size() > 0) {
                Iterator it = scanLocProcCol.iterator();
                while (it.hasNext()) {
                    ScanLocProcLocal scanLocProcLocal = (ScanLocProcLocal) it.next();
                    //-- get the primary key of the ScanLocProc EJB object
                    Integer scanLocProcId = (Integer)scanLocProcLocal.getPrimaryKey();
                    //-- get the value object for the ScanLocProc EJB using the primary key
                    if (scanLocProcId != null) {
                        ScanLocProcVO scanLocProcVO = getScanLocProc(scanLocProcId);
                        //-- add the value object to the collection
                        list.add(scanLocProcVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllScanLocProcs() method from ScanLocProcManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllScanLocProcs() method from ScanLocProcManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the ScanLocProc local home interface
     */
    private ScanLocProcLocalHome getScanLocProcLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (ScanLocProcLocalHome) service.getEJBLocalHome(ServiceConstants.SCANLOCPROC_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getScanLocProcLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
