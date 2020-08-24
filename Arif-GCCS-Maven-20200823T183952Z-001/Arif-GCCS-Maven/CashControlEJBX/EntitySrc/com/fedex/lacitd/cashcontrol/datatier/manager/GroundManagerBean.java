/**
 * @(#)GroundManagerBean.java			Wed Nov 29 10:36:42 VET 2006
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

public class GroundManagerBean implements SessionBean {

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
     * This method create new Ground object
     * @param groundVO a value object the Ground bean
     */
    public void setGround(GroundVO groundVO)
        throws GroundException {
        //-- we do not accept null value for the parameter.
        if (groundVO == null) {
            throw new IllegalArgumentException("groundVO parameter was null in setGround() method from GroundManager class");
        }
        
        try {
            
            //-- create new Ground object
            getGroundLocalHome().create(
                groundVO.getGrndShpDt(),
                groundVO.getLocationCd(),
                groundVO.getGrndTrakNbr(),
                groundVO.getPaymentCurrency(),
                groundVO.getCashPymtAmt(),
                groundVO.getOtherPymtAmt(),
                groundVO.getOtherPymtTypeCd(),
                groundVO.getOtherDocNbr(),
                groundVO.getCoupnPymtAmt(),
                groundVO.getChngStatusEmpIdNbr(),
                groundVO.getChngStatusDt(),
                groundVO.getCloseEmpIdNbr(),
                groundVO.getCloseDt(),
                groundVO.getEodEmpIdNbr(),
                groundVO.getEodDt(),
                groundVO.getChkinAgentComDesc(),
                groundVO.getStatusCd(),
                groundVO.getExchRateAmt(),
                groundVO.getCourEmpIdNbr(),
                groundVO.getCashDepSlipIdNbr(),
                groundVO.getOtherDepSlipIdNbr(),
                groundVO.getEodIdNbr(),
                groundVO.getCoupnBatchIdNbr(),
                groundVO.getOtherComDsc(),
                groundVO.getRcptNbr(),
                groundVO.getOrigRcptNbr(),
                groundVO.getRcptChngEmpNbr(),
                groundVO.getOrigEmpNbr(),
                groundVO.getRsgnEmpNbr(),
                groundVO.getDualGrndShipIdNbr(),
                groundVO.getCustNm(),
                //added to add two new column miscDate,miscNbr
            	groundVO.getMiscDate(),
            	groundVO.getMiscNbr()
            );
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setGround() method from GroundManager class";
            throw new GroundException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setGround() method from GroundManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Ground object
     * @return groundVO - a value object of the Ground bean
     */
    public GroundVO getGround(Integer grndShpIdNbr)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (grndShpIdNbr == null) {
            throw new IllegalArgumentException("grndShpIdNbr parameter was null in getGround() method from GroundManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            GroundLocal groundLocal = getGroundLocalHome().findByPrimaryKey(grndShpIdNbr);
            //-- create new value object to store the data
            GroundVO groundVO = new GroundVO();
            //-- populate the new value object
            groundVO.setGrndShpIdNbr(groundLocal.getGrndShpIdNbr());
            groundVO.setGrndShpDt(groundLocal.getGrndShpDt());
            groundVO.setLocationCd(groundLocal.getLocationCd());
            groundVO.setGrndTrakNbr(groundLocal.getGrndTrakNbr());
            groundVO.setPaymentCurrency(groundLocal.getPaymentCurrency());
            groundVO.setCashPymtAmt(groundLocal.getCashPymtAmt());
            groundVO.setOtherPymtAmt(groundLocal.getOtherPymtAmt());
            groundVO.setOtherPymtTypeCd(groundLocal.getOtherPymtTypeCd());
            groundVO.setOtherDocNbr(groundLocal.getOtherDocNbr());
            groundVO.setCoupnPymtAmt(groundLocal.getCoupnPymtAmt());
            groundVO.setChngStatusEmpIdNbr(groundLocal.getChngStatusEmpIdNbr());
            groundVO.setChngStatusDt(groundLocal.getChngStatusDt());
            groundVO.setCloseEmpIdNbr(groundLocal.getCloseEmpIdNbr());
            groundVO.setCloseDt(groundLocal.getCloseDt());
            groundVO.setEodEmpIdNbr(groundLocal.getEodEmpIdNbr());
            groundVO.setEodDt(groundLocal.getEodDt());
            groundVO.setChkinAgentComDesc(groundLocal.getChkinAgentComDesc());
            groundVO.setStatusCd(groundLocal.getStatusCd());
            groundVO.setExchRateAmt(groundLocal.getExchRateAmt());
            groundVO.setCourEmpIdNbr(groundLocal.getCourEmpIdNbr());
            groundVO.setCashDepSlipIdNbr(groundLocal.getCashDepSlipIdNbr());
            groundVO.setOtherDepSlipIdNbr(groundLocal.getOtherDepSlipIdNbr());
            groundVO.setEodIdNbr(groundLocal.getEodIdNbr());
            groundVO.setCoupnBatchIdNbr(groundLocal.getCoupnBatchIdNbr());
            groundVO.setOtherComDsc(groundLocal.getOtherComDsc());
            groundVO.setRcptNbr(groundLocal.getRcptNbr());
            groundVO.setOrigRcptNbr(groundLocal.getOrigRcptNbr());
            groundVO.setRcptChngEmpNbr(groundLocal.getRcptChngEmpNbr());
            groundVO.setOrigEmpNbr(groundLocal.getOrigEmpNbr());
            groundVO.setRsgnEmpNbr(groundLocal.getRsgnEmpNbr());
            groundVO.setDualGrndShipIdNbr(groundLocal.getDualGrndShipIdNbr());
            groundVO.setCustNm(groundLocal.getCustNm());
            //added to add two new columns miscDate,miscNbr
            groundVO.setMiscDate(groundLocal.getMiscDate());
            groundVO.setMiscNbr(groundLocal.getMiscNbr());
            
            return groundVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getGround() method from GroundManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Ground object
     * @param grndShpIdNbr - the Ground bean primary key
     */
    public void removeGround(Integer grndShpIdNbr)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (grndShpIdNbr == null) {
            throw new IllegalArgumentException("grndShpIdNbr parameter was null in removeGround() method from GroundManager class");
        }
        
        try {
            getGroundLocalHome().remove(grndShpIdNbr);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeGround() method from GroundManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Ground object
     * @param groundVO - the value object of the Ground bean
     */
    public void updateGround(GroundVO groundVO)
        throws GroundException {
        //-- we do not accept null value for the parameter.
        if (groundVO == null) {
            throw new IllegalArgumentException("groundVO parameter was null in updateGround() method from GroundManager class");
        }
        
        try {
            Integer grndShpIdNbr = groundVO.getGrndShpIdNbr();
            
            GroundLocal groundLocal = getGroundLocalHome().findByPrimaryKey(grndShpIdNbr);
            //-- update Ground entity bean
            groundLocal.setGrndShpDt(groundVO.getGrndShpDt());
            groundLocal.setLocationCd(groundVO.getLocationCd());
            groundLocal.setGrndTrakNbr(groundVO.getGrndTrakNbr());
            groundLocal.setPaymentCurrency(groundVO.getPaymentCurrency());
            groundLocal.setCashPymtAmt(groundVO.getCashPymtAmt());
            groundLocal.setOtherPymtAmt(groundVO.getOtherPymtAmt());
            groundLocal.setOtherPymtTypeCd(groundVO.getOtherPymtTypeCd());
            groundLocal.setOtherDocNbr(groundVO.getOtherDocNbr());
            groundLocal.setCoupnPymtAmt(groundVO.getCoupnPymtAmt());
            groundLocal.setChngStatusEmpIdNbr(groundVO.getChngStatusEmpIdNbr());
            groundLocal.setChngStatusDt(groundVO.getChngStatusDt());
            groundLocal.setCloseEmpIdNbr(groundVO.getCloseEmpIdNbr());
            groundLocal.setCloseDt(groundVO.getCloseDt());
            groundLocal.setEodEmpIdNbr(groundVO.getEodEmpIdNbr());
            groundLocal.setEodDt(groundVO.getEodDt());
            groundLocal.setChkinAgentComDesc(groundVO.getChkinAgentComDesc());
            groundLocal.setStatusCd(groundVO.getStatusCd());
            groundLocal.setExchRateAmt(groundVO.getExchRateAmt());
            groundLocal.setCourEmpIdNbr(groundVO.getCourEmpIdNbr());
            groundLocal.setCashDepSlipIdNbr(groundVO.getCashDepSlipIdNbr());
            groundLocal.setOtherDepSlipIdNbr(groundVO.getOtherDepSlipIdNbr());
            groundLocal.setEodIdNbr(groundVO.getEodIdNbr());
            groundLocal.setCoupnBatchIdNbr(groundVO.getCoupnBatchIdNbr());
            groundLocal.setOtherComDsc(groundVO.getOtherComDsc());
            groundLocal.setRcptNbr(groundVO.getRcptNbr());
            groundLocal.setOrigRcptNbr(groundVO.getOrigRcptNbr());
            groundLocal.setRcptChngEmpNbr(groundVO.getRcptChngEmpNbr());
            groundLocal.setOrigEmpNbr(groundVO.getOrigEmpNbr());
            groundLocal.setRsgnEmpNbr(groundVO.getRsgnEmpNbr());
            groundLocal.setDualGrndShipIdNbr(groundVO.getDualGrndShipIdNbr());
            groundLocal.setCustNm(groundVO.getCustNm());
            groundLocal.setBillAccount(groundVO.getBillAccount());
            //change done to add two new column
            groundLocal.setMiscDate(groundVO.getMiscDate());
            groundLocal.setMiscNbr(groundVO.getMiscNbr());
            
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateGround() method from GroundManager class";
            throw new GroundException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateGround() method from GroundManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllGrounds objects
     * @return Collection - a collection of the Ground objects
     */
    public Collection getAllGrounds() {
        try {
            //-- gets the local home interface and call the findAllGrounds method
            Collection groundCol = getGroundLocalHome().findAllGrounds();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (groundCol != null && groundCol.size() > 0) {
                Iterator it = groundCol.iterator();
                while (it.hasNext()) {
                    GroundLocal groundLocal = (GroundLocal) it.next();
                    //-- get the primary key of the Ground EJB object
                    Integer grndShpIdNbr = (Integer)groundLocal.getPrimaryKey();
                    //-- get the value object for the Ground EJB using the primary key
                    if (grndShpIdNbr != null) {
                        GroundVO groundVO = getGround(grndShpIdNbr);
                        //-- add the value object to the collection
                        list.add(groundVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllGrounds() method from GroundManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllGrounds() method from GroundManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByGrndShpIdNbr objects
     * @return Collection - a collection of the Ground objects
     */
    public Collection getGroundByGrndShpIdNbr(Integer grndShpIdNbr1) {
        try {
            //-- gets the local home interface and call the findByGrndShpIdNbr method
            Collection groundCol = getGroundLocalHome().findByGrndShpIdNbr(grndShpIdNbr1);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (groundCol != null && groundCol.size() > 0) {
                Iterator it = groundCol.iterator();
                while (it.hasNext()) {
                    GroundLocal groundLocal = (GroundLocal) it.next();
                    //-- get the primary key of the Ground EJB object
                    Integer grndShpIdNbr = (Integer)groundLocal.getPrimaryKey();
                    //-- get the value object for the Ground EJB using the primary key
                    if (grndShpIdNbr != null) {
                        GroundVO groundVO = getGround(grndShpIdNbr);
                        //-- add the value object to the collection
                        list.add(groundVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getGroundByGrndShpIdNbr() method from GroundManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getGroundByGrndShpIdNbr() method from GroundManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Ground local home interface
     */
    private GroundLocalHome getGroundLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (GroundLocalHome) service.getEJBLocalHome(ServiceConstants.GROUND_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getGroundLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
