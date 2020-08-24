/**
 * @(#)PrepaidManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PrepaidManagerBean implements SessionBean {

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
     * This method create new Prepaid object
     * @param prepaidVO a value object the Prepaid bean
     */
    public void setPrepaid(PrepaidVO prepaidVO)
        throws PrepaidException {
        //-- we do not accept null value for the parameter.
        if (prepaidVO == null) {
            throw new IllegalArgumentException("prepaidVO parameter was null in setPrepaid() method from PrepaidManager class");
        }
        
        try {
            
            //-- create new Prepaid object
            getPrepaidLocalHome().create(
                prepaidVO.getCustomerNm(),
                prepaidVO.getAwbDt(),
                prepaidVO.getLocationCd(),
                prepaidVO.getAwbNbr(),
                prepaidVO.getTinUniqId(),
                prepaidVO.getPaymentCurrency(),
                prepaidVO.getCashPaymentAmt(),
                prepaidVO.getOtherPaymentAmt(),
                prepaidVO.getOtherPaymentType(),
                prepaidVO.getOtherDocNbr(),
                prepaidVO.getCoupPymtAmt(),
                prepaidVO.getPux16CashPayment(),
                prepaidVO.getPux16FreightAmt(),
                prepaidVO.getPux16OtherPaymentAmt(),
                prepaidVO.getPux16OtherDocNbr(),
                prepaidVO.getPux16CoupPymtAmt(),
                prepaidVO.getPux16ScanSeqNbr(),
                prepaidVO.getChngStatusEmployeeId(),
                prepaidVO.getChngStatusDt(),
                prepaidVO.getCloseEmployeeId(),
                prepaidVO.getCloseDt(),
                prepaidVO.getEodEmployeeId(),
                prepaidVO.getEodDt(),
                prepaidVO.getLastScanType(),
                prepaidVO.getLastScanDate(),
                prepaidVO.getChkinAgentComment(),
                prepaidVO.getStatusId(),
                prepaidVO.getCashDepositSlipId(),
                prepaidVO.getCashDepositSlipNbr(),
                prepaidVO.getOtherDepositSlipId(),
                prepaidVO.getOtherDepositSlipNbr(),
                prepaidVO.getFreightAmtInVisa(),
                prepaidVO.getVisaMnfstDt(),
                prepaidVO.getVisaMnfstEmpId(),
                prepaidVO.getExchRate(),
                prepaidVO.getCourierId(),
                prepaidVO.getProduct(),
                prepaidVO.getNumberPkgs(),
                prepaidVO.getWeight(),
                prepaidVO.getCreditCardBatchId(),
                prepaidVO.getEodId(),
                prepaidVO.getCouponBatchId(),
                prepaidVO.getPymtImpDt(),
                prepaidVO.getOtherComment(),
                prepaidVO.getRcptNbr(),
                prepaidVO.getOrigRcptNbr(),
                prepaidVO.getRcptChngEmpId(),
                prepaidVO.getOrigEmployeeId(),
                prepaidVO.getReassEmpId(),
                prepaidVO.getDualPrepaidIdNbr(),
                prepaidVO.getbillAccount(),
            	//	Added for the two new fields added
            	prepaidVO.getMiscDate(),
            	prepaidVO.getMiscNbr());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPrepaid() method from PrepaidManager class [" + prepaidVO.getAwbNbr() + "]";
            throw new PrepaidException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPrepaid() method from PrepaidManager class [" + prepaidVO.getAwbNbr() + "]";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Prepaid object
     * @return prepaidVO - a value object of the Prepaid bean
     */
    public PrepaidVO getPrepaid(Integer prepaidId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (prepaidId == null) {
            throw new IllegalArgumentException("prepaidId parameter was null in getPrepaid() method from PrepaidManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PrepaidLocal prepaidLocal = getPrepaidLocalHome().findByPrimaryKey(prepaidId);
            //-- create new value object to store the data
            PrepaidVO prepaidVO = new PrepaidVO();
            //-- populate the new value object
            prepaidVO.setPrepaidId(prepaidLocal.getPrepaidId());
            prepaidVO.setCustomerNm(prepaidLocal.getCustomerNm());
            prepaidVO.setAwbDt(prepaidLocal.getAwbDt());
            prepaidVO.setLocationCd(prepaidLocal.getLocationCd());
            prepaidVO.setAwbNbr(prepaidLocal.getAwbNbr());
            prepaidVO.setTinUniqId(prepaidLocal.getTinUniqId());
            prepaidVO.setPaymentCurrency(prepaidLocal.getPaymentCurrency());
            prepaidVO.setCashPaymentAmt(prepaidLocal.getCashPaymentAmt());
            prepaidVO.setOtherPaymentAmt(prepaidLocal.getOtherPaymentAmt());
            prepaidVO.setOtherPaymentType(prepaidLocal.getOtherPaymentType());
            prepaidVO.setOtherDocNbr(prepaidLocal.getOtherDocNbr());
            prepaidVO.setCoupPymtAmt(prepaidLocal.getCoupPymtAmt());
            prepaidVO.setPux16CashPayment(prepaidLocal.getPux16CashPayment());
            prepaidVO.setPux16FreightAmt(prepaidLocal.getPux16FreightAmt());
            prepaidVO.setPux16OtherPaymentAmt(prepaidLocal.getPux16OtherPaymentAmt());
            prepaidVO.setPux16OtherDocNbr(prepaidLocal.getPux16OtherDocNbr());
            prepaidVO.setPux16CoupPymtAmt(prepaidLocal.getPux16CoupPymtAmt());
            prepaidVO.setPux16ScanSeqNbr(prepaidLocal.getPux16ScanSeqNbr());
            prepaidVO.setChngStatusEmployeeId(prepaidLocal.getChngStatusEmployeeId());
            prepaidVO.setChngStatusDt(prepaidLocal.getChngStatusDt());
            prepaidVO.setCloseEmployeeId(prepaidLocal.getCloseEmployeeId());
            prepaidVO.setCloseDt(prepaidLocal.getCloseDt());
            prepaidVO.setEodEmployeeId(prepaidLocal.getEodEmployeeId());
            prepaidVO.setEodDt(prepaidLocal.getEodDt());
            prepaidVO.setLastScanType(prepaidLocal.getLastScanType());
            prepaidVO.setLastScanDate(prepaidLocal.getLastScanDate());
            prepaidVO.setChkinAgentComment(prepaidLocal.getChkinAgentComment());
            prepaidVO.setStatusId(prepaidLocal.getStatusId());
            prepaidVO.setCashDepositSlipId(prepaidLocal.getCashDepositSlipId());
            prepaidVO.setCashDepositSlipNbr(prepaidLocal.getCashDepositSlipNbr());
            prepaidVO.setOtherDepositSlipId(prepaidLocal.getOtherDepositSlipId());
            prepaidVO.setOtherDepositSlipNbr(prepaidLocal.getOtherDepositSlipNbr());
            prepaidVO.setFreightAmtInVisa(prepaidLocal.getFreightAmtInVisa());
            prepaidVO.setVisaMnfstDt(prepaidLocal.getVisaMnfstDt());
            prepaidVO.setVisaMnfstEmpId(prepaidLocal.getVisaMnfstEmpId());
            prepaidVO.setExchRate(prepaidLocal.getExchRate());
            prepaidVO.setCourierId(prepaidLocal.getCourierId());
            prepaidVO.setProduct(prepaidLocal.getProduct());
            prepaidVO.setNumberPkgs(prepaidLocal.getNumberPkgs());
            prepaidVO.setWeight(prepaidLocal.getWeight());
            prepaidVO.setCreditCardBatchId(prepaidLocal.getCreditCardBatchId());
            prepaidVO.setEodId(prepaidLocal.getEodId());
            prepaidVO.setCouponBatchId(prepaidLocal.getCouponBatchId());
            prepaidVO.setPymtImpDt(prepaidLocal.getPymtImpDt());
            prepaidVO.setOtherComment(prepaidLocal.getOtherComment());
            prepaidVO.setRcptNbr(prepaidLocal.getRcptNbr());
            prepaidVO.setOrigRcptNbr(prepaidLocal.getOrigRcptNbr());
            prepaidVO.setRcptChngEmpId(prepaidLocal.getRcptChngEmpId());
            prepaidVO.setOrigEmployeeId(prepaidLocal.getOrigEmployeeId());
            prepaidVO.setReassEmpId(prepaidLocal.getReassEmpId());
            prepaidVO.setDualPrepaidIdNbr(prepaidLocal.getDualPrepaidIdNbr());
            prepaidVO.setbillAccount(prepaidLocal.getBillAccount());
            //added to add the two new fields miscDate, miscNbr
            prepaidVO.setMiscDate(prepaidLocal.getMiscDate());
            prepaidVO.setMiscNbr(prepaidLocal.getMiscNbr());
            
            return prepaidVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPrepaid() method from PrepaidManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Prepaid object
     * @param prepaidId - the Prepaid bean primary key
     */
    public void removePrepaid(Integer prepaidId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (prepaidId == null) {
            throw new IllegalArgumentException("prepaidId parameter was null in removePrepaid() method from PrepaidManager class");
        }
        
        try {
            getPrepaidLocalHome().remove(prepaidId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePrepaid() method from PrepaidManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Prepaid object
     * @param prepaidVO - the value object of the Prepaid bean
     */
    public void updatePrepaid(PrepaidVO prepaidVO)
        throws PrepaidException {
        //-- we do not accept null value for the parameter.
        if (prepaidVO == null) {
            throw new IllegalArgumentException("prepaidVO parameter was null in updatePrepaid() method from PrepaidManager class");
        }
        
        try {
            Integer prepaidId = prepaidVO.getPrepaidId();
            
            PrepaidLocal prepaidLocal = getPrepaidLocalHome().findByPrimaryKey(prepaidId);
            //-- update Prepaid entity bean
            prepaidLocal.setCustomerNm(prepaidVO.getCustomerNm());
            prepaidLocal.setAwbDt(prepaidVO.getAwbDt());
            prepaidLocal.setLocationCd(prepaidVO.getLocationCd());
            prepaidLocal.setAwbNbr(prepaidVO.getAwbNbr());
            prepaidLocal.setTinUniqId(prepaidVO.getTinUniqId());
            prepaidLocal.setPaymentCurrency(prepaidVO.getPaymentCurrency());
            prepaidLocal.setCashPaymentAmt(prepaidVO.getCashPaymentAmt());
            prepaidLocal.setOtherPaymentAmt(prepaidVO.getOtherPaymentAmt());
            prepaidLocal.setOtherPaymentType(prepaidVO.getOtherPaymentType());
            prepaidLocal.setOtherDocNbr(prepaidVO.getOtherDocNbr());
            prepaidLocal.setCoupPymtAmt(prepaidVO.getCoupPymtAmt());
            prepaidLocal.setPux16CashPayment(prepaidVO.getPux16CashPayment());
            prepaidLocal.setPux16FreightAmt(prepaidVO.getPux16FreightAmt());
            prepaidLocal.setPux16OtherPaymentAmt(prepaidVO.getPux16OtherPaymentAmt());
            prepaidLocal.setPux16OtherDocNbr(prepaidVO.getPux16OtherDocNbr());
            prepaidLocal.setPux16CoupPymtAmt(prepaidVO.getPux16CoupPymtAmt());
            prepaidLocal.setPux16ScanSeqNbr(prepaidVO.getPux16ScanSeqNbr());
            prepaidLocal.setChngStatusEmployeeId(prepaidVO.getChngStatusEmployeeId());
            prepaidLocal.setChngStatusDt(prepaidVO.getChngStatusDt());
            prepaidLocal.setCloseEmployeeId(prepaidVO.getCloseEmployeeId());
            prepaidLocal.setCloseDt(prepaidVO.getCloseDt());
            prepaidLocal.setEodEmployeeId(prepaidVO.getEodEmployeeId());
            prepaidLocal.setEodDt(prepaidVO.getEodDt());
            prepaidLocal.setLastScanType(prepaidVO.getLastScanType());
            prepaidLocal.setLastScanDate(prepaidVO.getLastScanDate());
            prepaidLocal.setChkinAgentComment(prepaidVO.getChkinAgentComment());
            prepaidLocal.setStatusId(prepaidVO.getStatusId());
            prepaidLocal.setCashDepositSlipId(prepaidVO.getCashDepositSlipId());
            prepaidLocal.setCashDepositSlipNbr(prepaidVO.getCashDepositSlipNbr());
            prepaidLocal.setOtherDepositSlipId(prepaidVO.getOtherDepositSlipId());
            prepaidLocal.setOtherDepositSlipNbr(prepaidVO.getOtherDepositSlipNbr());
            prepaidLocal.setFreightAmtInVisa(prepaidVO.getFreightAmtInVisa());
            prepaidLocal.setVisaMnfstDt(prepaidVO.getVisaMnfstDt());
            prepaidLocal.setVisaMnfstEmpId(prepaidVO.getVisaMnfstEmpId());
            prepaidLocal.setExchRate(prepaidVO.getExchRate());
            prepaidLocal.setCourierId(prepaidVO.getCourierId());
            prepaidLocal.setProduct(prepaidVO.getProduct());
            prepaidLocal.setNumberPkgs(prepaidVO.getNumberPkgs());
            prepaidLocal.setWeight(prepaidVO.getWeight());
            prepaidLocal.setCreditCardBatchId(prepaidVO.getCreditCardBatchId());
            prepaidLocal.setEodId(prepaidVO.getEodId());
            prepaidLocal.setCouponBatchId(prepaidVO.getCouponBatchId());
            prepaidLocal.setPymtImpDt(prepaidVO.getPymtImpDt());
            prepaidLocal.setOtherComment(prepaidVO.getOtherComment());
            prepaidLocal.setRcptNbr(prepaidVO.getRcptNbr());
            prepaidLocal.setOrigRcptNbr(prepaidVO.getOrigRcptNbr());
            prepaidLocal.setRcptChngEmpId(prepaidVO.getRcptChngEmpId());
            prepaidLocal.setOrigEmployeeId(prepaidVO.getOrigEmployeeId());
            prepaidLocal.setReassEmpId(prepaidVO.getReassEmpId());
            prepaidLocal.setDualPrepaidIdNbr(prepaidVO.getDualPrepaidIdNbr());
            prepaidLocal.setBillAccount(prepaidVO.getbillAccount());
            //added for the two new fields added miscDate, miscNbr
            prepaidLocal.setMiscDate(prepaidVO.getMiscDate());
            prepaidLocal.setMiscNbr(prepaidVO.getMiscNbr());
            
            
            System.out.println("Prep Mgr Bean - Bill Acct : "+prepaidLocal.getBillAccount());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePrepaid() method from PrepaidManager class";
            throw new PrepaidException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePrepaid() method from PrepaidManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPrepaids objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getAllPrepaids() {
        try {
            //-- gets the local home interface and call the findAllPrepaids method
            Collection prepaidCol = getPrepaidLocalHome().findAllPrepaids();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (prepaidCol != null && prepaidCol.size() > 0) {
                Iterator it = prepaidCol.iterator();
                while (it.hasNext()) {
                    PrepaidLocal prepaidLocal = (PrepaidLocal) it.next();
                    //-- get the primary key of the Prepaid EJB object
                    Integer prepaidId = (Integer)prepaidLocal.getPrimaryKey();
                    //-- get the value object for the Prepaid EJB using the primary key
                    if (prepaidId != null) {
                        PrepaidVO prepaidVO = getPrepaid(prepaidId);
                        //-- add the value object to the collection
                        list.add(prepaidVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPrepaids() method from PrepaidManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPrepaids() method from PrepaidManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findPrepaidByAwbNbr objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPrepaidByAwbNbr(String awbNbr) {
        try {
            //-- gets the local home interface and call the findPrepaidByAwbNbr method
            Collection prepaidCol = getPrepaidLocalHome().findPrepaidByAwbNbr(awbNbr);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (prepaidCol != null && prepaidCol.size() > 0) {
                Iterator it = prepaidCol.iterator();
                while (it.hasNext()) {
                    PrepaidLocal prepaidLocal = (PrepaidLocal) it.next();
                    //-- get the primary key of the Prepaid EJB object
                    Integer prepaidId = (Integer)prepaidLocal.getPrimaryKey();
                    //-- get the value object for the Prepaid EJB using the primary key
                    if (prepaidId != null) {
                        PrepaidVO prepaidVO = getPrepaid(prepaidId);
                        //-- add the value object to the collection
                        list.add(prepaidVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPrepaidPrepaidByAwbNbr() method from PrepaidManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPrepaidPrepaidByAwbNbr() method from PrepaidManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidByEodId(Integer eodId) {
        try {
            //-- gets the local home interface and call the findByEodId method
            Collection prepaidCol = getPrepaidLocalHome().findByEodId(eodId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (prepaidCol != null && prepaidCol.size() > 0) {
                Iterator it = prepaidCol.iterator();
                while (it.hasNext()) {
                    PrepaidLocal prepaidLocal = (PrepaidLocal) it.next();
                    //-- get the primary key of the Prepaid EJB object
                    Integer prepaidId = (Integer)prepaidLocal.getPrimaryKey();
                    //-- get the value object for the Prepaid EJB using the primary key
                    if (prepaidId != null) {
                        PrepaidVO prepaidVO = getPrepaid(prepaidId);
                        //-- add the value object to the collection
                        list.add(prepaidVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPrepaidByEodId() method from PrepaidManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPrepaidByEodId() method from PrepaidManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findPRPWithoutScan objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPRPWithoutScan(String courierId, String locationCd, Integer statusId) {
        try {
            //-- gets the local home interface and call the findPRPWithoutScan method
            Collection prepaidCol = getPrepaidLocalHome().findPRPWithoutScan(courierId, locationCd, statusId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (prepaidCol != null && prepaidCol.size() > 0) {
                Iterator it = prepaidCol.iterator();
                while (it.hasNext()) {
                    PrepaidLocal prepaidLocal = (PrepaidLocal) it.next();
                    //-- get the primary key of the Prepaid EJB object
                    Integer prepaidId = (Integer)prepaidLocal.getPrimaryKey();
                    //-- get the value object for the Prepaid EJB using the primary key
                    if (prepaidId != null) {
                        PrepaidVO prepaidVO = getPrepaid(prepaidId);
                        //-- add the value object to the collection
                        list.add(prepaidVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPrepaidPRPWithoutScan() method from PrepaidManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPrepaidPRPWithoutScan() method from PrepaidManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findPRPQueryCosmos objects
     * @return Collection - a collection of the Prepaid objects
     */
    public Collection getPrepaidPRPQueryCosmos(String locationCd, Integer statusId) {
        try {
            //-- gets the local home interface and call the findPRPQueryCosmos method
            Collection prepaidCol = getPrepaidLocalHome().findPRPQueryCosmos(locationCd, statusId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (prepaidCol != null && prepaidCol.size() > 0) {
                Iterator it = prepaidCol.iterator();
                while (it.hasNext()) {
                    PrepaidLocal prepaidLocal = (PrepaidLocal) it.next();
                    //-- get the primary key of the Prepaid EJB object
                    Integer prepaidId = (Integer)prepaidLocal.getPrimaryKey();
                    //-- get the value object for the Prepaid EJB using the primary key
                    if (prepaidId != null) {
                        PrepaidVO prepaidVO = getPrepaid(prepaidId);
                        //-- add the value object to the collection
                        list.add(prepaidVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPrepaidPRPQueryCosmos() method from PrepaidManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPrepaidPRPQueryCosmos() method from PrepaidManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Prepaid local home interface
     */
    private PrepaidLocalHome getPrepaidLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PrepaidLocalHome) service.getEJBLocalHome(ServiceConstants.PREPAID_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPrepaidLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
