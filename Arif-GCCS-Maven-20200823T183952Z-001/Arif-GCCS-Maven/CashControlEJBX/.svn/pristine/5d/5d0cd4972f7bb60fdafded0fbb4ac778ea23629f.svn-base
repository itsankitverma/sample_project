/**
 * @(#)OtherPaymentManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class OtherPaymentManagerBean implements SessionBean {

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
     * This method create new OtherPayment object
     * @param otherPaymentVO a value object the OtherPayment bean
     */
    public void setOtherPayment(OtherPaymentVO otherPaymentVO)
        throws OtherPaymentException {
        //-- we do not accept null value for the parameter.
        if (otherPaymentVO == null) {
            throw new IllegalArgumentException("otherPaymentVO parameter was null in setOtherPayment() method from OtherPaymentManager class");
        }
        
        try {
            
            //-- create new OtherPayment object
            getOtherPaymentLocalHome().create(
                otherPaymentVO.getDescription(),
                otherPaymentVO.getPaymentAmt(),
                otherPaymentVO.getPaymentDocNbr(),
                otherPaymentVO.getPaymentType(),
                otherPaymentVO.getPaymentDt(),
                otherPaymentVO.getChkinAgentId(),
                otherPaymentVO.getEodDt(),
                otherPaymentVO.getEodEmployeeId(),
                otherPaymentVO.getDepositSlipId(),
                otherPaymentVO.getCreditCardBatchId(),
                otherPaymentVO.getLocationCd(),
                otherPaymentVO.getPaymentCurrency(),
                otherPaymentVO.getEodId(),
                otherPaymentVO.getPymtImpDt(),
                otherPaymentVO.getOtherComment(),
                otherPaymentVO.getOtherPaymentCtgId(),
            	otherPaymentVO.getAwbNbr(),
            	//new entry for the added field miscDate miscNbr
            	otherPaymentVO.getMiscDate(),
            	otherPaymentVO.getMiscNbr());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setOtherPayment() method from OtherPaymentManager class";
            throw new OtherPaymentException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setOtherPayment() method from OtherPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a OtherPayment object
     * @return otherPaymentVO - a value object of the OtherPayment bean
     */
    public OtherPaymentVO getOtherPayment(Integer otherPymtId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (otherPymtId == null) {
            throw new IllegalArgumentException("otherPymtId parameter was null in getOtherPayment() method from OtherPaymentManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            OtherPaymentLocal otherPaymentLocal = getOtherPaymentLocalHome().findByPrimaryKey(otherPymtId);
            //-- create new value object to store the data
            OtherPaymentVO otherPaymentVO = new OtherPaymentVO();
            //-- populate the new value object
            otherPaymentVO.setOtherPymtId(otherPaymentLocal.getOtherPymtId());
            otherPaymentVO.setDescription(otherPaymentLocal.getDescription());
            otherPaymentVO.setPaymentAmt(otherPaymentLocal.getPaymentAmt());
            otherPaymentVO.setPaymentDocNbr(otherPaymentLocal.getPaymentDocNbr());
            otherPaymentVO.setPaymentType(otherPaymentLocal.getPaymentType());
            otherPaymentVO.setPaymentDt(otherPaymentLocal.getPaymentDt());
            otherPaymentVO.setChkinAgentId(otherPaymentLocal.getChkinAgentId());
            otherPaymentVO.setEodDt(otherPaymentLocal.getEodDt());
            otherPaymentVO.setEodEmployeeId(otherPaymentLocal.getEodEmployeeId());
            otherPaymentVO.setDepositSlipId(otherPaymentLocal.getDepositSlipId());
            otherPaymentVO.setCreditCardBatchId(otherPaymentLocal.getCreditCardBatchId());
            otherPaymentVO.setLocationCd(otherPaymentLocal.getLocationCd());
            otherPaymentVO.setPaymentCurrency(otherPaymentLocal.getPaymentCurrency());
            otherPaymentVO.setEodId(otherPaymentLocal.getEodId());
            otherPaymentVO.setPymtImpDt(otherPaymentLocal.getPymtImpDt());
            otherPaymentVO.setOtherComment(otherPaymentLocal.getOtherComment());
            otherPaymentVO.setOtherPaymentCtgId(otherPaymentLocal.getOtherPaymentCtgId());
            otherPaymentVO.setAwbNbr(otherPaymentLocal.getAwbNbr());
            //getOtherPayment for miscDate miscNbr
            otherPaymentVO.setMiscDate(otherPaymentLocal.getMiscDate());
            otherPaymentVO.setMiscNbr(otherPaymentLocal.getMiscNbr());
            return otherPaymentVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOtherPayment() method from OtherPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing OtherPayment object
     * @param otherPymtId - the OtherPayment bean primary key
     */
    public void removeOtherPayment(Integer otherPymtId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (otherPymtId == null) {
            throw new IllegalArgumentException("otherPymtId parameter was null in removeOtherPayment() method from OtherPaymentManager class");
        }
        
        try {
            getOtherPaymentLocalHome().remove(otherPymtId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeOtherPayment() method from OtherPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing OtherPayment object
     * @param otherPaymentVO - the value object of the OtherPayment bean
     */
    public void updateOtherPayment(OtherPaymentVO otherPaymentVO)
        throws OtherPaymentException {
        //-- we do not accept null value for the parameter.
        if (otherPaymentVO == null) {
            throw new IllegalArgumentException("otherPaymentVO parameter was null in updateOtherPayment() method from OtherPaymentManager class");
        }
        
        try {
            Integer otherPymtId = otherPaymentVO.getOtherPymtId();
            
            OtherPaymentLocal otherPaymentLocal = getOtherPaymentLocalHome().findByPrimaryKey(otherPymtId);
            //-- update OtherPayment entity bean
            otherPaymentLocal.setDescription(otherPaymentVO.getDescription());
            otherPaymentLocal.setPaymentAmt(otherPaymentVO.getPaymentAmt());
            otherPaymentLocal.setPaymentDocNbr(otherPaymentVO.getPaymentDocNbr());
            otherPaymentLocal.setPaymentType(otherPaymentVO.getPaymentType());
            otherPaymentLocal.setPaymentDt(otherPaymentVO.getPaymentDt());
            otherPaymentLocal.setChkinAgentId(otherPaymentVO.getChkinAgentId());
            otherPaymentLocal.setEodDt(otherPaymentVO.getEodDt());
            otherPaymentLocal.setEodEmployeeId(otherPaymentVO.getEodEmployeeId());
            otherPaymentLocal.setDepositSlipId(otherPaymentVO.getDepositSlipId());
            otherPaymentLocal.setCreditCardBatchId(otherPaymentVO.getCreditCardBatchId());
            otherPaymentLocal.setLocationCd(otherPaymentVO.getLocationCd());
            otherPaymentLocal.setPaymentCurrency(otherPaymentVO.getPaymentCurrency());
            otherPaymentLocal.setEodId(otherPaymentVO.getEodId());
            otherPaymentLocal.setPymtImpDt(otherPaymentVO.getPymtImpDt());
            otherPaymentLocal.setOtherComment(otherPaymentVO.getOtherComment());
            otherPaymentLocal.setOtherPaymentCtgId(otherPaymentVO.getOtherPaymentCtgId());
            otherPaymentLocal.setAwbNbr(otherPaymentVO.getAwbNbr());
            //update the two fields miscDate, miscNbr
            otherPaymentLocal.setMiscDate(otherPaymentVO.getMiscDate());
            otherPaymentLocal.setMiscNbr(otherPaymentVO.getMiscNbr());
            
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateOtherPayment() method from OtherPaymentManager class";
            throw new OtherPaymentException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateOtherPayment() method from OtherPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllOtherPayments objects
     * @return Collection - a collection of the OtherPayment objects
     */
    public Collection getAllOtherPayments() {
        try {
            //-- gets the local home interface and call the findAllOtherPayments method
            Collection otherPaymentCol = getOtherPaymentLocalHome().findAllOtherPayments();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (otherPaymentCol != null && otherPaymentCol.size() > 0) {
                Iterator it = otherPaymentCol.iterator();
                while (it.hasNext()) {
                    OtherPaymentLocal otherPaymentLocal = (OtherPaymentLocal) it.next();
                    //-- get the primary key of the OtherPayment EJB object
                    Integer otherPymtId = (Integer)otherPaymentLocal.getPrimaryKey();
                    //-- get the value object for the OtherPayment EJB using the primary key
                    if (otherPymtId != null) {
                        OtherPaymentVO otherPaymentVO = getOtherPayment(otherPymtId);
                        //-- add the value object to the collection
                        list.add(otherPaymentVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllOtherPayments() method from OtherPaymentManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllOtherPayments() method from OtherPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findOpenByLocation objects
     * @return Collection - a collection of the OtherPayment objects
     */
    public Collection getOtherPaymentOpenByLocation(String locationCd) {
        try {
            //-- gets the local home interface and call the findOpenByLocation method
            Collection otherPaymentCol = getOtherPaymentLocalHome().findOpenByLocation(locationCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (otherPaymentCol != null && otherPaymentCol.size() > 0) {
                Iterator it = otherPaymentCol.iterator();
                while (it.hasNext()) {
                    OtherPaymentLocal otherPaymentLocal = (OtherPaymentLocal) it.next();
                    //-- get the primary key of the OtherPayment EJB object
                    Integer otherPymtId = (Integer)otherPaymentLocal.getPrimaryKey();
                    //-- get the value object for the OtherPayment EJB using the primary key
                    if (otherPymtId != null) {
                        OtherPaymentVO otherPaymentVO = getOtherPayment(otherPymtId);
                        //-- add the value object to the collection
                        list.add(otherPaymentVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getOtherPaymentOpenByLocation() method from OtherPaymentManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOtherPaymentOpenByLocation() method from OtherPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the OtherPayment objects
     */
    public Collection getOtherPaymentByEodId(Integer eodId) {
        try {
            //-- gets the local home interface and call the findByEodId method
            Collection otherPaymentCol = getOtherPaymentLocalHome().findByEodId(eodId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (otherPaymentCol != null && otherPaymentCol.size() > 0) {
                Iterator it = otherPaymentCol.iterator();
                while (it.hasNext()) {
                    OtherPaymentLocal otherPaymentLocal = (OtherPaymentLocal) it.next();
                    //-- get the primary key of the OtherPayment EJB object
                    Integer otherPymtId = (Integer)otherPaymentLocal.getPrimaryKey();
                    //-- get the value object for the OtherPayment EJB using the primary key
                    if (otherPymtId != null) {
                        OtherPaymentVO otherPaymentVO = getOtherPayment(otherPymtId);
                        //-- add the value object to the collection
                        list.add(otherPaymentVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getOtherPaymentByEodId() method from OtherPaymentManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOtherPaymentByEodId() method from OtherPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the OtherPayment local home interface
     */
    private OtherPaymentLocalHome getOtherPaymentLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (OtherPaymentLocalHome) service.getEJBLocalHome(ServiceConstants.OTHERPAYMENT_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getOtherPaymentLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
