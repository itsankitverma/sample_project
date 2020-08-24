/**
 * @(#)PrepaidDscrManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PrepaidDscrManagerBean implements SessionBean {

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
     * This method create new PrepaidDscr object
     * @param prepaidDscrVO a value object the PrepaidDscr bean
     */
    public void setPrepaidDscr(PrepaidDscrVO prepaidDscrVO)
        throws PrepaidDscrException {
        //-- we do not accept null value for the parameter.
        if (prepaidDscrVO == null) {
            throw new IllegalArgumentException("prepaidDscrVO parameter was null in setPrepaidDscr() method from PrepaidDscrManager class");
        }
        
        try {
            
            //-- create new PrepaidDscr object
            getPrepaidDscrLocalHome().create(
                prepaidDscrVO.getProcessDt(),
                prepaidDscrVO.getLocationCd(),
                prepaidDscrVO.getAwbNbr(),
                prepaidDscrVO.getTinUniqId(),
                prepaidDscrVO.getCourierId(),
                prepaidDscrVO.getPaymentCurrency(),
                prepaidDscrVO.getFreightAmtInVisa(),
                prepaidDscrVO.getDiscrepancyFound(),
                prepaidDscrVO.getDiscrepancyAmt(),
                prepaidDscrVO.getExchRate(),
                prepaidDscrVO.getDiscrepancyRsn(),
                prepaidDscrVO.getShipDate(),
                prepaidDscrVO.getPux16Amount(),
                prepaidDscrVO.getCouponAmount(),
                prepaidDscrVO.getComments(),
                prepaidDscrVO.getManagerEmpId(),
                prepaidDscrVO.getStatusId());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPrepaidDscr() method from PrepaidDscrManager class";
            throw new PrepaidDscrException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPrepaidDscr() method from PrepaidDscrManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PrepaidDscr object
     * @return prepaidDscrVO - a value object of the PrepaidDscr bean
     */
    public PrepaidDscrVO getPrepaidDscr(Integer prepaidDscrId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (prepaidDscrId == null) {
            throw new IllegalArgumentException("prepaidDscrId parameter was null in getPrepaidDscr() method from PrepaidDscrManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PrepaidDscrLocal prepaidDscrLocal = getPrepaidDscrLocalHome().findByPrimaryKey(prepaidDscrId);
            //-- create new value object to store the data
            PrepaidDscrVO prepaidDscrVO = new PrepaidDscrVO();
            //-- populate the new value object
            prepaidDscrVO.setPrepaidDscrId(prepaidDscrLocal.getPrepaidDscrId());
            prepaidDscrVO.setProcessDt(prepaidDscrLocal.getProcessDt());
            prepaidDscrVO.setLocationCd(prepaidDscrLocal.getLocationCd());
            prepaidDscrVO.setAwbNbr(prepaidDscrLocal.getAwbNbr());
            prepaidDscrVO.setTinUniqId(prepaidDscrLocal.getTinUniqId());
            prepaidDscrVO.setCourierId(prepaidDscrLocal.getCourierId());
            prepaidDscrVO.setPaymentCurrency(prepaidDscrLocal.getPaymentCurrency());
            prepaidDscrVO.setFreightAmtInVisa(prepaidDscrLocal.getFreightAmtInVisa());
            prepaidDscrVO.setDiscrepancyFound(prepaidDscrLocal.getDiscrepancyFound());
            prepaidDscrVO.setDiscrepancyAmt(prepaidDscrLocal.getDiscrepancyAmt());
            prepaidDscrVO.setExchRate(prepaidDscrLocal.getExchRate());
            prepaidDscrVO.setDiscrepancyRsn(prepaidDscrLocal.getDiscrepancyRsn());
            prepaidDscrVO.setShipDate(prepaidDscrLocal.getShipDate());
            prepaidDscrVO.setPux16Amount(prepaidDscrLocal.getPux16Amount());
            prepaidDscrVO.setCouponAmount(prepaidDscrLocal.getCouponAmount());
            prepaidDscrVO.setComments(prepaidDscrLocal.getComments());
            prepaidDscrVO.setStatusId(prepaidDscrLocal.getStatusId());
            prepaidDscrVO.setManagerEmpId(prepaidDscrLocal.getManagerEmpId());
            return prepaidDscrVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPrepaidDscr() method from PrepaidDscrManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PrepaidDscr object
     * @param prepaidDscrId - the PrepaidDscr bean primary key
     */
    public void removePrepaidDscr(Integer prepaidDscrId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (prepaidDscrId == null) {
            throw new IllegalArgumentException("prepaidDscrId parameter was null in removePrepaidDscr() method from PrepaidDscrManager class");
        }
        
        try {
            getPrepaidDscrLocalHome().remove(prepaidDscrId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePrepaidDscr() method from PrepaidDscrManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PrepaidDscr object
     * @param prepaidDscrVO - the value object of the PrepaidDscr bean
     */
    public void updatePrepaidDscr(PrepaidDscrVO prepaidDscrVO)
        throws PrepaidDscrException {
        //-- we do not accept null value for the parameter.
        if (prepaidDscrVO == null) {
            throw new IllegalArgumentException("prepaidDscrVO parameter was null in updatePrepaidDscr() method from PrepaidDscrManager class");
        }
        
        try {
            Integer prepaidDscrId = prepaidDscrVO.getPrepaidDscrId();
            
            PrepaidDscrLocal prepaidDscrLocal = getPrepaidDscrLocalHome().findByPrimaryKey(prepaidDscrId);
            //-- update PrepaidDscr entity bean
            prepaidDscrLocal.setProcessDt(prepaidDscrVO.getProcessDt());
            prepaidDscrLocal.setLocationCd(prepaidDscrVO.getLocationCd());
            prepaidDscrLocal.setAwbNbr(prepaidDscrVO.getAwbNbr());
            prepaidDscrLocal.setTinUniqId(prepaidDscrVO.getTinUniqId());
            prepaidDscrLocal.setCourierId(prepaidDscrVO.getCourierId());
            prepaidDscrLocal.setPaymentCurrency(prepaidDscrVO.getPaymentCurrency());
            prepaidDscrLocal.setFreightAmtInVisa(prepaidDscrVO.getFreightAmtInVisa());
            prepaidDscrLocal.setDiscrepancyFound(prepaidDscrVO.getDiscrepancyFound());
            prepaidDscrLocal.setDiscrepancyAmt(prepaidDscrVO.getDiscrepancyAmt());
            prepaidDscrLocal.setExchRate(prepaidDscrVO.getExchRate());
            prepaidDscrLocal.setDiscrepancyRsn(prepaidDscrVO.getDiscrepancyRsn());
            prepaidDscrLocal.setShipDate(prepaidDscrVO.getShipDate());
            prepaidDscrLocal.setPux16Amount(prepaidDscrVO.getPux16Amount());
            prepaidDscrLocal.setCouponAmount(prepaidDscrVO.getCouponAmount());
            prepaidDscrLocal.setComments(prepaidDscrVO.getComments());
            prepaidDscrLocal.setStatusId(prepaidDscrVO.getStatusId());
            prepaidDscrLocal.setManagerEmpId(prepaidDscrVO.getManagerEmpId());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePrepaidDscr() method from PrepaidDscrManager class";
            throw new PrepaidDscrException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePrepaidDscr() method from PrepaidDscrManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPrepaidDscrs objects
     * @return Collection - a collection of the PrepaidDscr objects
     */
    public Collection getAllPrepaidDscrs() {
        try {
            //-- gets the local home interface and call the findAllPrepaidDscrs method
            Collection prepaidDscrCol = getPrepaidDscrLocalHome().findAllPrepaidDscrs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (prepaidDscrCol != null && prepaidDscrCol.size() > 0) {
                Iterator it = prepaidDscrCol.iterator();
                while (it.hasNext()) {
                    PrepaidDscrLocal prepaidDscrLocal = (PrepaidDscrLocal) it.next();
                    //-- get the primary key of the PrepaidDscr EJB object
                    Integer prepaidDscrId = (Integer)prepaidDscrLocal.getPrimaryKey();
                    //-- get the value object for the PrepaidDscr EJB using the primary key
                    if (prepaidDscrId != null) {
                        PrepaidDscrVO prepaidDscrVO = getPrepaidDscr(prepaidDscrId);
                        //-- add the value object to the collection
                        list.add(prepaidDscrVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPrepaidDscrs() method from PrepaidDscrManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPrepaidDscrs() method from PrepaidDscrManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PrepaidDscr local home interface
     */
    private PrepaidDscrLocalHome getPrepaidDscrLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PrepaidDscrLocalHome) service.getEJBLocalHome(ServiceConstants.PREPAIDDSCR_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPrepaidDscrLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
