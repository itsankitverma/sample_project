/**
 * @(#)ReceivablesManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class FTC_ReceivablesManagerBean implements SessionBean {

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
     * This method create new FTC_Receivables object
     * @param FTC_receivablesVO a value object the FTC_Receivables bean
     */
    public void setFTC_Receivables(FTC_ReceivablesVO FTC_receivablesVO)
        throws FTC_ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (FTC_receivablesVO == null) {
            throw new IllegalArgumentException("FTC_receivablesVO parameter was null in setFTC_Receivables() method from FTC_ReceivablesManager class");
        }
        
        try {
            
            //-- create new FTC_Receivables object
            getFTC_ReceivablesLocalHome().create(
                FTC_receivablesVO.getRecNbr(),
                FTC_receivablesVO.getCustomerNm(),
                FTC_receivablesVO.getRecDt(),
                FTC_receivablesVO.getInvCurrency(),
                FTC_receivablesVO.getFtcAmt(),
                FTC_receivablesVO.getAncChargeAmt(),
                FTC_receivablesVO.getRecAmt(),
                FTC_receivablesVO.getLocationCd(),
                FTC_receivablesVO.getAwbNbr(),
                FTC_receivablesVO.getTinUniqId(),
                FTC_receivablesVO.getExchRateClnUsed(),
                FTC_receivablesVO.getEmployeeId(),
                FTC_receivablesVO.getPaymentCurrency(),
                FTC_receivablesVO.getCashPaymentAmt(),
                FTC_receivablesVO.getOtherPaymentAmt(),
                FTC_receivablesVO.getOtherPaymentType(),
                FTC_receivablesVO.getOtherDocNbr(),
                FTC_receivablesVO.getDex16CashPayment(),
                FTC_receivablesVO.getDex16FreightAmt(),
                FTC_receivablesVO.getDex16OtherPaymentAmt(),
                FTC_receivablesVO.getDex16OtherDocNbr(),
                FTC_receivablesVO.getDex16ScanSeqNbr(),
                FTC_receivablesVO.getChngStatusEmployeeId(),
                FTC_receivablesVO.getChngStatusDt(),
                FTC_receivablesVO.getCloseEmployeeId(),
                FTC_receivablesVO.getCloseDt(),
                FTC_receivablesVO.getEodEmployeeId(),
                FTC_receivablesVO.getEodDt(),
                FTC_receivablesVO.getLastScanType(),
                FTC_receivablesVO.getLastScanDate(),
                FTC_receivablesVO.getChkinAgentComment(),
                FTC_receivablesVO.getTrackingStatus(),
                FTC_receivablesVO.getStatusId(),
                FTC_receivablesVO.getCashDepositSlipId(),
                FTC_receivablesVO.getCashDepositSlipNbr(),
                FTC_receivablesVO.getOtherDepositSlipId(),
                FTC_receivablesVO.getOtherDepositSlipNbr(),
                FTC_receivablesVO.getCreditCardBatchId(),
                FTC_receivablesVO.getEodId(),
                FTC_receivablesVO.getFtcXmlImpDt(),
                FTC_receivablesVO.getPymtImpDt(),
                FTC_receivablesVO.getOtherComment(),
                FTC_receivablesVO.getRecvPrepyAmt(),
                FTC_receivablesVO.getOrigCustNm(),
                FTC_receivablesVO.getCustChngEmpId(),
                FTC_receivablesVO.getOrigRecAmt(),
                FTC_receivablesVO.getAmtChngEmpId(),
                FTC_receivablesVO.getRcptNbr(),
                FTC_receivablesVO.getOrigRcptNbr(),
                FTC_receivablesVO.getRcptChngEmpId(),
                FTC_receivablesVO.getOrigEmployeeId(),
                FTC_receivablesVO.getReassEmpId(),
                FTC_receivablesVO.getDualRecIdNbr(),
                FTC_receivablesVO.getDupAwbFlg(),
                FTC_receivablesVO.getbillAccount(),	            
                //added to add two new columns miscDate,miscNbr
	            FTC_receivablesVO.getMiscDate(), 
	            FTC_receivablesVO.getMiscNbr());

        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "CreateException ex: Error occurred in setFTC_Receivables() method from FTC_ReceivablesManager class";
            throw new FTC_ReceivablesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Exception ex: Error occurred in setFTC_Receivables() method from FTC_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a FTC_Receivables object
     * @return FTC_receivablesVO - a value object of the FTC_Receivables bean
     */
    public FTC_ReceivablesVO getFTC_Receivables(Integer recId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in getFTC_Receivables() method from FTC_ReceivablesManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            FTC_ReceivablesLocal FTC_receivablesLocal = getFTC_ReceivablesLocalHome().findByPrimaryKey(recId);
            //-- create new value object to store the data
            FTC_ReceivablesVO FTC_receivablesVO = new FTC_ReceivablesVO();
            //-- populate the new value object
            FTC_receivablesVO.setRecId(FTC_receivablesLocal.getRecId());
            FTC_receivablesVO.setRecNbr(FTC_receivablesLocal.getRecNbr());
            FTC_receivablesVO.setCustomerNm(FTC_receivablesLocal.getCustomerNm());
            FTC_receivablesVO.setRecDt(FTC_receivablesLocal.getRecDt());
            FTC_receivablesVO.setInvCurrency(FTC_receivablesLocal.getInvCurrency());
            FTC_receivablesVO.setFtcAmt(FTC_receivablesLocal.getFtcAmt());
            FTC_receivablesVO.setAncChargeAmt(FTC_receivablesLocal.getAncChargeAmt());
            FTC_receivablesVO.setRecAmt(FTC_receivablesLocal.getRecAmt());
            FTC_receivablesVO.setLocationCd(FTC_receivablesLocal.getLocationCd());
            FTC_receivablesVO.setAwbNbr(FTC_receivablesLocal.getAwbNbr());
            FTC_receivablesVO.setTinUniqId(FTC_receivablesLocal.getTinUniqId());
            FTC_receivablesVO.setExchRateClnUsed(FTC_receivablesLocal.getExchRateClnUsed());
            FTC_receivablesVO.setEmployeeId(FTC_receivablesLocal.getEmployeeId());
            FTC_receivablesVO.setPaymentCurrency(FTC_receivablesLocal.getPaymentCurrency());
            FTC_receivablesVO.setCashPaymentAmt(FTC_receivablesLocal.getCashPaymentAmt());
            FTC_receivablesVO.setOtherPaymentAmt(FTC_receivablesLocal.getOtherPaymentAmt());
            FTC_receivablesVO.setOtherPaymentType(FTC_receivablesLocal.getOtherPaymentType());
            FTC_receivablesVO.setOtherDocNbr(FTC_receivablesLocal.getOtherDocNbr());
            FTC_receivablesVO.setDex16CashPayment(FTC_receivablesLocal.getDex16CashPayment());
            FTC_receivablesVO.setDex16FreightAmt(FTC_receivablesLocal.getDex16FreightAmt());
            FTC_receivablesVO.setDex16OtherPaymentAmt(FTC_receivablesLocal.getDex16OtherPaymentAmt());
            FTC_receivablesVO.setDex16OtherDocNbr(FTC_receivablesLocal.getDex16OtherDocNbr());
            FTC_receivablesVO.setDex16ScanSeqNbr(FTC_receivablesLocal.getDex16ScanSeqNbr());
            FTC_receivablesVO.setChngStatusEmployeeId(FTC_receivablesLocal.getChngStatusEmployeeId());
            FTC_receivablesVO.setChngStatusDt(FTC_receivablesLocal.getChngStatusDt());
            FTC_receivablesVO.setCloseEmployeeId(FTC_receivablesLocal.getCloseEmployeeId());
            FTC_receivablesVO.setCloseDt(FTC_receivablesLocal.getCloseDt());
            FTC_receivablesVO.setEodEmployeeId(FTC_receivablesLocal.getEodEmployeeId());
            FTC_receivablesVO.setEodDt(FTC_receivablesLocal.getEodDt());
            FTC_receivablesVO.setLastScanType(FTC_receivablesLocal.getLastScanType());
            FTC_receivablesVO.setLastScanDate(FTC_receivablesLocal.getLastScanDate());
            FTC_receivablesVO.setChkinAgentComment(FTC_receivablesLocal.getChkinAgentComment());
            FTC_receivablesVO.setTrackingStatus(FTC_receivablesLocal.getTrackingStatus());
            FTC_receivablesVO.setStatusId(FTC_receivablesLocal.getStatusId());
            FTC_receivablesVO.setCashDepositSlipId(FTC_receivablesLocal.getCashDepositSlipId());
            FTC_receivablesVO.setCashDepositSlipNbr(FTC_receivablesLocal.getCashDepositSlipNbr());
            FTC_receivablesVO.setOtherDepositSlipId(FTC_receivablesLocal.getOtherDepositSlipId());
            FTC_receivablesVO.setOtherDepositSlipNbr(FTC_receivablesLocal.getOtherDepositSlipNbr());
            FTC_receivablesVO.setCreditCardBatchId(FTC_receivablesLocal.getCreditCardBatchId());
            FTC_receivablesVO.setEodId(FTC_receivablesLocal.getEodId());
            FTC_receivablesVO.setFtcXmlImpDt(FTC_receivablesLocal.getFtcXmlImpDt());
            FTC_receivablesVO.setPymtImpDt(FTC_receivablesLocal.getPymtImpDt());
            FTC_receivablesVO.setOtherComment(FTC_receivablesLocal.getOtherComment());
            FTC_receivablesVO.setRecvPrepyAmt(FTC_receivablesLocal.getRecvPrepyAmt());
            FTC_receivablesVO.setOrigCustNm(FTC_receivablesLocal.getOrigCustNm());
            FTC_receivablesVO.setCustChngEmpId(FTC_receivablesLocal.getCustChngEmpId());
            FTC_receivablesVO.setOrigRecAmt(FTC_receivablesLocal.getOrigRecAmt());
            FTC_receivablesVO.setAmtChngEmpId(FTC_receivablesLocal.getAmtChngEmpId());
            FTC_receivablesVO.setRcptNbr(FTC_receivablesLocal.getRcptNbr());
            FTC_receivablesVO.setOrigRcptNbr(FTC_receivablesLocal.getOrigRcptNbr());
            FTC_receivablesVO.setRcptChngEmpId(FTC_receivablesLocal.getRcptChngEmpId());
            FTC_receivablesVO.setOrigEmployeeId(FTC_receivablesLocal.getOrigEmployeeId());
            FTC_receivablesVO.setReassEmpId(FTC_receivablesLocal.getReassEmpId());
            FTC_receivablesVO.setDualRecIdNbr(FTC_receivablesLocal.getDualRecIdNbr());
            FTC_receivablesVO.setDupAwbFlg(FTC_receivablesLocal.getDupAwbFlg());
            FTC_receivablesVO.setbillAccount(FTC_receivablesLocal.getBillAccount());
            //for the two column added
            FTC_receivablesVO.setMiscDate(FTC_receivablesLocal.getMiscDate());
            FTC_receivablesVO.setMiscNbr(FTC_receivablesLocal.getMiscNbr());
            return FTC_receivablesVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getFTC_Receivables() method from FTC_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing FTC_Receivables object
     * @param recId - the FTC_Receivables bean primary key
     */
    public void removeFTC_Receivables(Integer recId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in removeFTC_Receivables() method from FTC_ReceivablesManager class");
        }
        
        try {
            getFTC_ReceivablesLocalHome().remove(recId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeFTC_Receivables() method from FTC_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing FTC_Receivables object
     * @param FTC_receivablesVO - the value object of the FTC_Receivables bean
     */
    public void updateFTC_Receivables(FTC_ReceivablesVO FTC_receivablesVO)
        throws FTC_ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (FTC_receivablesVO == null) {
            throw new IllegalArgumentException("FTC_receivablesVO parameter was null in updateFTC_Receivables() method from FTC_ReceivablesManager class");
        }
        
        try {
            Integer recId = FTC_receivablesVO.getRecId();
            
            FTC_ReceivablesLocal FTC_receivablesLocal = getFTC_ReceivablesLocalHome().findByPrimaryKey(recId);
            //-- update FTC_Receivables entity bean
            //System.out.println("in FTC_ReceivablesManagerBean-apr04-2010");
            //System.out.println("FTC_receivablesVO.getbillAccount()=="+FTC_receivablesVO.getbillAccount());
            FTC_receivablesLocal.setRecNbr(FTC_receivablesVO.getRecNbr());
            FTC_receivablesLocal.setCustomerNm(FTC_receivablesVO.getCustomerNm());
            FTC_receivablesLocal.setRecDt(FTC_receivablesVO.getRecDt());
            FTC_receivablesLocal.setInvCurrency(FTC_receivablesVO.getInvCurrency());
            FTC_receivablesLocal.setFtcAmt(FTC_receivablesVO.getFtcAmt());
            FTC_receivablesLocal.setAncChargeAmt(FTC_receivablesVO.getAncChargeAmt());
            FTC_receivablesLocal.setRecAmt(FTC_receivablesVO.getRecAmt());
            FTC_receivablesLocal.setLocationCd(FTC_receivablesVO.getLocationCd());
            FTC_receivablesLocal.setAwbNbr(FTC_receivablesVO.getAwbNbr());
            FTC_receivablesLocal.setTinUniqId(FTC_receivablesVO.getTinUniqId());
            FTC_receivablesLocal.setExchRateClnUsed(FTC_receivablesVO.getExchRateClnUsed());
            FTC_receivablesLocal.setEmployeeId(FTC_receivablesVO.getEmployeeId());
            FTC_receivablesLocal.setPaymentCurrency(FTC_receivablesVO.getPaymentCurrency());
            FTC_receivablesLocal.setCashPaymentAmt(FTC_receivablesVO.getCashPaymentAmt());
            FTC_receivablesLocal.setOtherPaymentAmt(FTC_receivablesVO.getOtherPaymentAmt());
            FTC_receivablesLocal.setOtherPaymentType(FTC_receivablesVO.getOtherPaymentType());
            FTC_receivablesLocal.setOtherDocNbr(FTC_receivablesVO.getOtherDocNbr());
            FTC_receivablesLocal.setDex16CashPayment(FTC_receivablesVO.getDex16CashPayment());
            FTC_receivablesLocal.setDex16FreightAmt(FTC_receivablesVO.getDex16FreightAmt());
            FTC_receivablesLocal.setDex16OtherPaymentAmt(FTC_receivablesVO.getDex16OtherPaymentAmt());
            FTC_receivablesLocal.setDex16OtherDocNbr(FTC_receivablesVO.getDex16OtherDocNbr());
            FTC_receivablesLocal.setDex16ScanSeqNbr(FTC_receivablesVO.getDex16ScanSeqNbr());
            FTC_receivablesLocal.setChngStatusEmployeeId(FTC_receivablesVO.getChngStatusEmployeeId());
            FTC_receivablesLocal.setChngStatusDt(FTC_receivablesVO.getChngStatusDt());
            FTC_receivablesLocal.setCloseEmployeeId(FTC_receivablesVO.getCloseEmployeeId());
            FTC_receivablesLocal.setCloseDt(FTC_receivablesVO.getCloseDt());
            FTC_receivablesLocal.setEodEmployeeId(FTC_receivablesVO.getEodEmployeeId());
            FTC_receivablesLocal.setEodDt(FTC_receivablesVO.getEodDt());
            FTC_receivablesLocal.setLastScanType(FTC_receivablesVO.getLastScanType());
            FTC_receivablesLocal.setLastScanDate(FTC_receivablesVO.getLastScanDate());
            FTC_receivablesLocal.setChkinAgentComment(FTC_receivablesVO.getChkinAgentComment());
            FTC_receivablesLocal.setTrackingStatus(FTC_receivablesVO.getTrackingStatus());
            FTC_receivablesLocal.setStatusId(FTC_receivablesVO.getStatusId());
            FTC_receivablesLocal.setCashDepositSlipId(FTC_receivablesVO.getCashDepositSlipId());
            FTC_receivablesLocal.setCashDepositSlipNbr(FTC_receivablesVO.getCashDepositSlipNbr());
            FTC_receivablesLocal.setOtherDepositSlipId(FTC_receivablesVO.getOtherDepositSlipId());
            FTC_receivablesLocal.setOtherDepositSlipNbr(FTC_receivablesVO.getOtherDepositSlipNbr());
            FTC_receivablesLocal.setCreditCardBatchId(FTC_receivablesVO.getCreditCardBatchId());
            FTC_receivablesLocal.setEodId(FTC_receivablesVO.getEodId());
            FTC_receivablesLocal.setFtcXmlImpDt(FTC_receivablesVO.getFtcXmlImpDt());
            FTC_receivablesLocal.setPymtImpDt(FTC_receivablesVO.getPymtImpDt());
            FTC_receivablesLocal.setOtherComment(FTC_receivablesVO.getOtherComment());
            FTC_receivablesLocal.setRecvPrepyAmt(FTC_receivablesVO.getRecvPrepyAmt());
            FTC_receivablesLocal.setOrigCustNm(FTC_receivablesVO.getOrigCustNm());
            FTC_receivablesLocal.setCustChngEmpId(FTC_receivablesVO.getCustChngEmpId());
            FTC_receivablesLocal.setOrigRecAmt(FTC_receivablesVO.getOrigRecAmt());
            FTC_receivablesLocal.setAmtChngEmpId(FTC_receivablesVO.getAmtChngEmpId());
            FTC_receivablesLocal.setRcptNbr(FTC_receivablesVO.getRcptNbr());
            FTC_receivablesLocal.setOrigRcptNbr(FTC_receivablesVO.getOrigRcptNbr());
            FTC_receivablesLocal.setRcptChngEmpId(FTC_receivablesVO.getRcptChngEmpId());
            FTC_receivablesLocal.setOrigEmployeeId(FTC_receivablesVO.getOrigEmployeeId());
            FTC_receivablesLocal.setReassEmpId(FTC_receivablesVO.getReassEmpId());
            FTC_receivablesLocal.setDualRecIdNbr(FTC_receivablesVO.getDualRecIdNbr());
            FTC_receivablesLocal.setDupAwbFlg(FTC_receivablesVO.getDupAwbFlg());
            FTC_receivablesLocal.setBillAccount(FTC_receivablesVO.getbillAccount());
            //change done to add the two column
            FTC_receivablesLocal.setMiscDate(FTC_receivablesVO.getMiscDate());
            FTC_receivablesLocal.setMiscNbr(FTC_receivablesVO.getMiscNbr());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateFTC_Receivables() method from FTC_ReceivablesManager class";
            throw new FTC_ReceivablesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateFTC_Receivables() method from FTC_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllFTC_Receivables objects
     * @return Collection - a collection of the FTC_Receivables objects
     */
    public Collection getAllFTC_Receivables() {
        try {
            //-- gets the local home interface and call the findAllFTC_Receivables method
            Collection FTC_receivablesCol = getFTC_ReceivablesLocalHome().findAllFTC_Receivables();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (FTC_receivablesCol != null && FTC_receivablesCol.size() > 0) {
                Iterator it = FTC_receivablesCol.iterator();
                while (it.hasNext()) {
                    FTC_ReceivablesLocal FTC_receivablesLocal = (FTC_ReceivablesLocal) it.next();
                    //-- get the primary key of the FTC_Receivables EJB object
                    Integer recId = (Integer)FTC_receivablesLocal.getPrimaryKey();
                    //-- get the value object for the FTC_Receivables EJB using the primary key
                    if (recId != null) {
                        FTC_ReceivablesVO FTC_receivablesVO = getFTC_Receivables(recId);
                        //-- add the value object to the collection
                        list.add(FTC_receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllFTC_Receivables() method from FTC_ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllFTC_Receivables() method from FTC_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findFTC_ReceivablesByAwbNbr objects
     * @return Collection - a collection of the FTC_Receivables objects
     */
    public Collection getFTC_ReceivablesReceivablesByAwbNbr(String awbNbr) {
        try {
            //-- gets the local home interface and call the findFTC_ReceivablesByAwbNbr method
            Collection FTC_receivablesCol = getFTC_ReceivablesLocalHome().findFTC_ReceivablesByAwbNbr(awbNbr);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (FTC_receivablesCol != null && FTC_receivablesCol.size() > 0) {
                Iterator it = FTC_receivablesCol.iterator();
                while (it.hasNext()) {
                    FTC_ReceivablesLocal FTC_receivablesLocal = (FTC_ReceivablesLocal) it.next();
                    //-- get the primary key of the FTC_Receivables EJB object
                    Integer recId = (Integer)FTC_receivablesLocal.getPrimaryKey();
                    //-- get the value object for the FTC_Receivables EJB using the primary key
                    if (recId != null) {
                        FTC_ReceivablesVO FTC_receivablesVO = getFTC_Receivables(recId);
                        //-- add the value object to the collection
                        list.add(FTC_receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getFTC_ReceivablesReceivablesByAwbNbr() method from FTC_ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesReceivablesByAwbNbr() method from FTC_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the FTC_Receivables objects
     */
    public Collection getFTC_ReceivablesByEodId(Integer eodId) {
        try {
            //-- gets the local home interface and call the findByEodId method
            Collection FTC_receivablesCol = getFTC_ReceivablesLocalHome().findByEodId(eodId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (FTC_receivablesCol != null && FTC_receivablesCol.size() > 0) {
                Iterator it = FTC_receivablesCol.iterator();
                while (it.hasNext()) {
                    FTC_ReceivablesLocal FTC_receivablesLocal = (FTC_ReceivablesLocal) it.next();
                    //-- get the primary key of the FTC_Receivables EJB object
                    Integer recId = (Integer)FTC_receivablesLocal.getPrimaryKey();
                    //-- get the value object for the FTC_Receivables EJB using the primary key
                    if (recId != null) {
                        FTC_ReceivablesVO FTC_receivablesVO = getFTC_Receivables(recId);
                        //-- add the value object to the collection
                        list.add(FTC_receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getFTC_ReceivablesByEodId() method from FTC_ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesByEodId() method from FTC_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the FTC_Receivables local home interface
     */
    private FTC_ReceivablesLocalHome getFTC_ReceivablesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (FTC_ReceivablesLocalHome) service.getEJBLocalHome(ServiceConstants.FTC_RECEIVABLES_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
