/**
 * @(#)CosmosScanManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class CosmosScanManagerBean implements SessionBean {

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
     * This method create new CosmosScan object
     * @param cosmosScanVO a value object the CosmosScan bean
     */
    public void setCosmosScan(CosmosScanVO cosmosScanVO)
        throws CosmosScanException {
        //-- we do not accept null value for the parameter.
        if (cosmosScanVO == null) {
            throw new IllegalArgumentException("cosmosScanVO parameter was null in setCosmosScan() method from CosmosScanManager class");
        }
        
        try {
            
            //-- create new CosmosScan object
            getCosmosScanLocalHome().create(
                cosmosScanVO.getScanLocationCd(),
                cosmosScanVO.getAwbNbr(),
                cosmosScanVO.getTinUniqId(),
                cosmosScanVO.getScanType(),
                cosmosScanVO.getScanSeqNbr(),
                cosmosScanVO.getScanDt(),
                cosmosScanVO.getCourierId());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setCosmosScan() method from CosmosScanManager class";
            throw new CosmosScanException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setCosmosScan() method from CosmosScanManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a CosmosScan object
     * @return cosmosScanVO - a value object of the CosmosScan bean
     */
    public CosmosScanVO getCosmosScan(Integer scanId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (scanId == null) {
            throw new IllegalArgumentException("scanId parameter was null in getCosmosScan() method from CosmosScanManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            CosmosScanLocal cosmosScanLocal = getCosmosScanLocalHome().findByPrimaryKey(scanId);
            //-- create new value object to store the data
            CosmosScanVO cosmosScanVO = new CosmosScanVO();
            //-- populate the new value object
            cosmosScanVO.setScanId(cosmosScanLocal.getScanId());
            cosmosScanVO.setScanLocationCd(cosmosScanLocal.getScanLocationCd());
            cosmosScanVO.setAwbNbr(cosmosScanLocal.getAwbNbr());
            cosmosScanVO.setTinUniqId(cosmosScanLocal.getTinUniqId());
            cosmosScanVO.setScanType(cosmosScanLocal.getScanType());
            cosmosScanVO.setScanSeqNbr(cosmosScanLocal.getScanSeqNbr());
            cosmosScanVO.setScanDt(cosmosScanLocal.getScanDt());
            cosmosScanVO.setCourierId(cosmosScanLocal.getCourierId());
            return cosmosScanVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCosmosScan() method from CosmosScanManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing CosmosScan object
     * @param scanId - the CosmosScan bean primary key
     */
    public void removeCosmosScan(Integer scanId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (scanId == null) {
            throw new IllegalArgumentException("scanId parameter was null in removeCosmosScan() method from CosmosScanManager class");
        }
        
        try {
            getCosmosScanLocalHome().remove(scanId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeCosmosScan() method from CosmosScanManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing CosmosScan object
     * @param cosmosScanVO - the value object of the CosmosScan bean
     */
    public void updateCosmosScan(CosmosScanVO cosmosScanVO)
        throws CosmosScanException {
        //-- we do not accept null value for the parameter.
        if (cosmosScanVO == null) {
            throw new IllegalArgumentException("cosmosScanVO parameter was null in updateCosmosScan() method from CosmosScanManager class");
        }
        
        try {
            Integer scanId = cosmosScanVO.getScanId();
            
            CosmosScanLocal cosmosScanLocal = getCosmosScanLocalHome().findByPrimaryKey(scanId);
            //-- update CosmosScan entity bean
            cosmosScanLocal.setScanLocationCd(cosmosScanVO.getScanLocationCd());
            cosmosScanLocal.setAwbNbr(cosmosScanVO.getAwbNbr());
            cosmosScanLocal.setTinUniqId(cosmosScanVO.getTinUniqId());
            cosmosScanLocal.setScanType(cosmosScanVO.getScanType());
            cosmosScanLocal.setScanSeqNbr(cosmosScanVO.getScanSeqNbr());
            cosmosScanLocal.setScanDt(cosmosScanVO.getScanDt());
            cosmosScanLocal.setCourierId(cosmosScanVO.getCourierId());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateCosmosScan() method from CosmosScanManager class";
            throw new CosmosScanException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateCosmosScan() method from CosmosScanManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCosmosScans objects
     * @return Collection - a collection of the CosmosScan objects
     */
    public Collection getAllCosmosScans() {
        try {
            //-- gets the local home interface and call the findAllCosmosScans method
            Collection cosmosScanCol = getCosmosScanLocalHome().findAllCosmosScans();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (cosmosScanCol != null && cosmosScanCol.size() > 0) {
                Iterator it = cosmosScanCol.iterator();
                while (it.hasNext()) {
                    CosmosScanLocal cosmosScanLocal = (CosmosScanLocal) it.next();
                    //-- get the primary key of the CosmosScan EJB object
                    Integer scanId = (Integer)cosmosScanLocal.getPrimaryKey();
                    //-- get the value object for the CosmosScan EJB using the primary key
                    if (scanId != null) {
                        CosmosScanVO cosmosScanVO = getCosmosScan(scanId);
                        //-- add the value object to the collection
                        list.add(cosmosScanVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllCosmosScans() method from CosmosScanManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllCosmosScans() method from CosmosScanManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the CosmosScan local home interface
     */
    private CosmosScanLocalHome getCosmosScanLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (CosmosScanLocalHome) service.getEJBLocalHome(ServiceConstants.COSMOSSCAN_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCosmosScanLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
