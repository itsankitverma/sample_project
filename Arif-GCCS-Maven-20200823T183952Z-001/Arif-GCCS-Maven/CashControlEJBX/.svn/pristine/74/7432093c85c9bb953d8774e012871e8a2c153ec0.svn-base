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

public class COD_ReceivablesManagerBean implements SessionBean {

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
     * This method create new COD_Receivables object
     * @param COD_receivablesVO a value object the COD_Receivables bean
     */
    public void setCOD_Receivables(COD_ReceivablesVO COD_receivablesVO)
        throws COD_ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (COD_receivablesVO == null) {
            throw new IllegalArgumentException("COD_receivablesVO parameter was null in setCOD_Receivables() method from COD_ReceivablesManager class");
        }
        
        try {
            
            //-- create new COD_Receivables object
            getCOD_ReceivablesLocalHome().create(
                COD_receivablesVO.getRecNbr(),
                COD_receivablesVO.getCustomerNm(),
                COD_receivablesVO.getRecDt(),
                COD_receivablesVO.getInvCurrency(),
                COD_receivablesVO.getCodAmt(),
                COD_receivablesVO.getAncChargeAmt(),
                COD_receivablesVO.getRecAmt(),
                COD_receivablesVO.getLocationCd(),
                COD_receivablesVO.getAwbNbr(),
                COD_receivablesVO.getTinUniqId(),
                COD_receivablesVO.getExchRateClnUsed(),
                COD_receivablesVO.getEmployeeId(),
                COD_receivablesVO.getPaymentCurrency(),
                COD_receivablesVO.getCashPaymentAmt(),
                COD_receivablesVO.getOtherPaymentAmt(),
                COD_receivablesVO.getOtherPaymentType(),
                COD_receivablesVO.getOtherDocNbr(),
                COD_receivablesVO.getDex11CashPayment(),
                COD_receivablesVO.getDex11FreightAmt(),
                COD_receivablesVO.getDex11OtherPaymentAmt(),
                COD_receivablesVO.getDex11OtherDocNbr(),
                COD_receivablesVO.getDex11ScanSeqNbr(),
                COD_receivablesVO.getChngStatusEmployeeId(),
                COD_receivablesVO.getChngStatusDt(),
                COD_receivablesVO.getCloseEmployeeId(),
                COD_receivablesVO.getCloseDt(),
                COD_receivablesVO.getEodEmployeeId(),
                COD_receivablesVO.getEodDt(),
                COD_receivablesVO.getLastScanType(),
                COD_receivablesVO.getLastScanDate(),
                COD_receivablesVO.getChkinAgentComment(),
                COD_receivablesVO.getTrackingStatus(),
                COD_receivablesVO.getStatusId(),
                COD_receivablesVO.getCashDepositSlipId(),
                COD_receivablesVO.getCashDepositSlipNbr(),
                COD_receivablesVO.getOtherDepositSlipId(),
                COD_receivablesVO.getOtherDepositSlipNbr(),
                COD_receivablesVO.getCreditCardBatchId(),
                COD_receivablesVO.getEodId(),
                COD_receivablesVO.getCodXmlImpDt(),
                COD_receivablesVO.getPymtImpDt(),
                COD_receivablesVO.getOtherComment(),
                COD_receivablesVO.getRecvPrepyAmt(),
                COD_receivablesVO.getOrigCustNm(),
                COD_receivablesVO.getCustChngEmpId(),
                COD_receivablesVO.getOrigRecAmt(),
                COD_receivablesVO.getAmtChngEmpId(),
                COD_receivablesVO.getRcptNbr(),
                COD_receivablesVO.getOrigRcptNbr(),
                COD_receivablesVO.getRcptChngEmpId(),
                COD_receivablesVO.getOrigEmployeeId(),
                COD_receivablesVO.getReassEmpId(),
                COD_receivablesVO.getDualRecIdNbr(),
                COD_receivablesVO.getDupAwbFlg(),
                COD_receivablesVO.getbillAccount(),
                //changes made to add the two columns miscDate,miscNbr
                COD_receivablesVO.getMiscDate(),
                COD_receivablesVO.getMiscNbr()
                );
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "CreateException ex: Error occurred in setCOD_Receivables() method from COD_ReceivablesManager class";
            throw new COD_ReceivablesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Exception ex: Error occurred in setCOD_Receivables() method from COD_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a COD_Receivables object
     * @return COD_receivablesVO - a value object of the COD_Receivables bean
     */
    public COD_ReceivablesVO getCOD_Receivables(Integer recId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in getCOD_Receivables() method from COD_ReceivablesManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            COD_ReceivablesLocal COD_receivablesLocal = getCOD_ReceivablesLocalHome().findByPrimaryKey(recId);
            //-- create new value object to store the data
            COD_ReceivablesVO COD_receivablesVO = new COD_ReceivablesVO();
            //-- populate the new value object
            COD_receivablesVO.setRecId(COD_receivablesLocal.getRecId());
            COD_receivablesVO.setRecNbr(COD_receivablesLocal.getRecNbr());
            COD_receivablesVO.setCustomerNm(COD_receivablesLocal.getCustomerNm());
            COD_receivablesVO.setRecDt(COD_receivablesLocal.getRecDt());
            COD_receivablesVO.setInvCurrency(COD_receivablesLocal.getInvCurrency());
            COD_receivablesVO.setCodAmt(COD_receivablesLocal.getCodAmt());
            COD_receivablesVO.setAncChargeAmt(COD_receivablesLocal.getAncChargeAmt());
            COD_receivablesVO.setRecAmt(COD_receivablesLocal.getRecAmt());
            COD_receivablesVO.setLocationCd(COD_receivablesLocal.getLocationCd());
            COD_receivablesVO.setAwbNbr(COD_receivablesLocal.getAwbNbr());
            COD_receivablesVO.setTinUniqId(COD_receivablesLocal.getTinUniqId());
            COD_receivablesVO.setExchRateClnUsed(COD_receivablesLocal.getExchRateClnUsed());
            COD_receivablesVO.setEmployeeId(COD_receivablesLocal.getEmployeeId());
            COD_receivablesVO.setPaymentCurrency(COD_receivablesLocal.getPaymentCurrency());
            COD_receivablesVO.setCashPaymentAmt(COD_receivablesLocal.getCashPaymentAmt());
            COD_receivablesVO.setOtherPaymentAmt(COD_receivablesLocal.getOtherPaymentAmt());
            COD_receivablesVO.setOtherPaymentType(COD_receivablesLocal.getOtherPaymentType());
            COD_receivablesVO.setOtherDocNbr(COD_receivablesLocal.getOtherDocNbr());
            COD_receivablesVO.setDex11CashPayment(COD_receivablesLocal.getDex11CashPayment());
            COD_receivablesVO.setDex11FreightAmt(COD_receivablesLocal.getDex11FreightAmt());
            COD_receivablesVO.setDex11OtherPaymentAmt(COD_receivablesLocal.getDex11OtherPaymentAmt());
            COD_receivablesVO.setDex11OtherDocNbr(COD_receivablesLocal.getDex11OtherDocNbr());
            COD_receivablesVO.setDex11ScanSeqNbr(COD_receivablesLocal.getDex11ScanSeqNbr());
            COD_receivablesVO.setChngStatusEmployeeId(COD_receivablesLocal.getChngStatusEmployeeId());
            COD_receivablesVO.setChngStatusDt(COD_receivablesLocal.getChngStatusDt());
            COD_receivablesVO.setCloseEmployeeId(COD_receivablesLocal.getCloseEmployeeId());
            COD_receivablesVO.setCloseDt(COD_receivablesLocal.getCloseDt());
            COD_receivablesVO.setEodEmployeeId(COD_receivablesLocal.getEodEmployeeId());
            COD_receivablesVO.setEodDt(COD_receivablesLocal.getEodDt());
            COD_receivablesVO.setLastScanType(COD_receivablesLocal.getLastScanType());
            COD_receivablesVO.setLastScanDate(COD_receivablesLocal.getLastScanDate());
            COD_receivablesVO.setChkinAgentComment(COD_receivablesLocal.getChkinAgentComment());
            COD_receivablesVO.setTrackingStatus(COD_receivablesLocal.getTrackingStatus());
            COD_receivablesVO.setStatusId(COD_receivablesLocal.getStatusId());
            COD_receivablesVO.setCashDepositSlipId(COD_receivablesLocal.getCashDepositSlipId());
            COD_receivablesVO.setCashDepositSlipNbr(COD_receivablesLocal.getCashDepositSlipNbr());
            COD_receivablesVO.setOtherDepositSlipId(COD_receivablesLocal.getOtherDepositSlipId());
            COD_receivablesVO.setOtherDepositSlipNbr(COD_receivablesLocal.getOtherDepositSlipNbr());
            COD_receivablesVO.setCreditCardBatchId(COD_receivablesLocal.getCreditCardBatchId());
            COD_receivablesVO.setEodId(COD_receivablesLocal.getEodId());
            COD_receivablesVO.setCodXmlImpDt(COD_receivablesLocal.getCodXmlImpDt());
            COD_receivablesVO.setPymtImpDt(COD_receivablesLocal.getPymtImpDt());
            COD_receivablesVO.setOtherComment(COD_receivablesLocal.getOtherComment());
            COD_receivablesVO.setRecvPrepyAmt(COD_receivablesLocal.getRecvPrepyAmt());
            COD_receivablesVO.setOrigCustNm(COD_receivablesLocal.getOrigCustNm());
            COD_receivablesVO.setCustChngEmpId(COD_receivablesLocal.getCustChngEmpId());
            COD_receivablesVO.setOrigRecAmt(COD_receivablesLocal.getOrigRecAmt());
            COD_receivablesVO.setAmtChngEmpId(COD_receivablesLocal.getAmtChngEmpId());
            COD_receivablesVO.setRcptNbr(COD_receivablesLocal.getRcptNbr());
            COD_receivablesVO.setOrigRcptNbr(COD_receivablesLocal.getOrigRcptNbr());
            COD_receivablesVO.setRcptChngEmpId(COD_receivablesLocal.getRcptChngEmpId());
            COD_receivablesVO.setOrigEmployeeId(COD_receivablesLocal.getOrigEmployeeId());
            COD_receivablesVO.setReassEmpId(COD_receivablesLocal.getReassEmpId());
            COD_receivablesVO.setDualRecIdNbr(COD_receivablesLocal.getDualRecIdNbr());
            COD_receivablesVO.setDupAwbFlg(COD_receivablesLocal.getDupAwbFlg());
            COD_receivablesVO.setbillAccount(COD_receivablesLocal.getBillAccount());
            //changes made to add the two columns miscDate,miscNbr
            COD_receivablesVO.setMiscDate(COD_receivablesLocal.getMiscDate());
            COD_receivablesVO.setMiscNbr(COD_receivablesLocal.getMiscNbr());
            
            return COD_receivablesVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCOD_Receivables() method from COD_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing COD_Receivables object
     * @param recId - the COD_Receivables bean primary key
     */
    public void removeCOD_Receivables(Integer recId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in removeCOD_Receivables() method from COD_ReceivablesManager class");
        }
        
        try {
            getCOD_ReceivablesLocalHome().remove(recId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeCOD_Receivables() method from COD_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing COD_Receivables object
     * @param COD_receivablesVO - the value object of the COD_Receivables bean
     */
    public void updateCOD_Receivables(COD_ReceivablesVO COD_receivablesVO)
        throws COD_ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (COD_receivablesVO == null) {
            throw new IllegalArgumentException("COD_receivablesVO parameter was null in updateCOD_Receivables() method from COD_ReceivablesManager class");
        }
        
        try {
            Integer recId = COD_receivablesVO.getRecId();
            
            COD_ReceivablesLocal COD_receivablesLocal = getCOD_ReceivablesLocalHome().findByPrimaryKey(recId);
            //-- update COD_Receivables entity bean
            //System.out.println("in COD_ReceivablesManagerBean-apr04-2010");
            //System.out.println("COD_receivablesVO.getbillAccount()=="+COD_receivablesVO.getbillAccount());
            COD_receivablesLocal.setRecNbr(COD_receivablesVO.getRecNbr());
            COD_receivablesLocal.setCustomerNm(COD_receivablesVO.getCustomerNm());
            COD_receivablesLocal.setRecDt(COD_receivablesVO.getRecDt());
            COD_receivablesLocal.setInvCurrency(COD_receivablesVO.getInvCurrency());
            COD_receivablesLocal.setCodAmt(COD_receivablesVO.getCodAmt());
            COD_receivablesLocal.setAncChargeAmt(COD_receivablesVO.getAncChargeAmt());
            COD_receivablesLocal.setRecAmt(COD_receivablesVO.getRecAmt());
            COD_receivablesLocal.setLocationCd(COD_receivablesVO.getLocationCd());
            COD_receivablesLocal.setAwbNbr(COD_receivablesVO.getAwbNbr());
            COD_receivablesLocal.setTinUniqId(COD_receivablesVO.getTinUniqId());
            COD_receivablesLocal.setExchRateClnUsed(COD_receivablesVO.getExchRateClnUsed());
            COD_receivablesLocal.setEmployeeId(COD_receivablesVO.getEmployeeId());
            COD_receivablesLocal.setPaymentCurrency(COD_receivablesVO.getPaymentCurrency());
            COD_receivablesLocal.setCashPaymentAmt(COD_receivablesVO.getCashPaymentAmt());
            COD_receivablesLocal.setOtherPaymentAmt(COD_receivablesVO.getOtherPaymentAmt());
            COD_receivablesLocal.setOtherPaymentType(COD_receivablesVO.getOtherPaymentType());
            COD_receivablesLocal.setOtherDocNbr(COD_receivablesVO.getOtherDocNbr());
            COD_receivablesLocal.setDex11CashPayment(COD_receivablesVO.getDex11CashPayment());
            COD_receivablesLocal.setDex11FreightAmt(COD_receivablesVO.getDex11FreightAmt());
            COD_receivablesLocal.setDex11OtherPaymentAmt(COD_receivablesVO.getDex11OtherPaymentAmt());
            COD_receivablesLocal.setDex11OtherDocNbr(COD_receivablesVO.getDex11OtherDocNbr());
            COD_receivablesLocal.setDex11ScanSeqNbr(COD_receivablesVO.getDex11ScanSeqNbr());
            COD_receivablesLocal.setChngStatusEmployeeId(COD_receivablesVO.getChngStatusEmployeeId());
            COD_receivablesLocal.setChngStatusDt(COD_receivablesVO.getChngStatusDt());
            COD_receivablesLocal.setCloseEmployeeId(COD_receivablesVO.getCloseEmployeeId());
            COD_receivablesLocal.setCloseDt(COD_receivablesVO.getCloseDt());
            COD_receivablesLocal.setEodEmployeeId(COD_receivablesVO.getEodEmployeeId());
            COD_receivablesLocal.setEodDt(COD_receivablesVO.getEodDt());
            COD_receivablesLocal.setLastScanType(COD_receivablesVO.getLastScanType());
            COD_receivablesLocal.setLastScanDate(COD_receivablesVO.getLastScanDate());
            COD_receivablesLocal.setChkinAgentComment(COD_receivablesVO.getChkinAgentComment());
            COD_receivablesLocal.setTrackingStatus(COD_receivablesVO.getTrackingStatus());
            COD_receivablesLocal.setStatusId(COD_receivablesVO.getStatusId());
            COD_receivablesLocal.setCashDepositSlipId(COD_receivablesVO.getCashDepositSlipId());
            COD_receivablesLocal.setCashDepositSlipNbr(COD_receivablesVO.getCashDepositSlipNbr());
            COD_receivablesLocal.setOtherDepositSlipId(COD_receivablesVO.getOtherDepositSlipId());
            COD_receivablesLocal.setOtherDepositSlipNbr(COD_receivablesVO.getOtherDepositSlipNbr());
            COD_receivablesLocal.setCreditCardBatchId(COD_receivablesVO.getCreditCardBatchId());
            COD_receivablesLocal.setEodId(COD_receivablesVO.getEodId());
            COD_receivablesLocal.setCodXmlImpDt(COD_receivablesVO.getCodXmlImpDt());
            COD_receivablesLocal.setPymtImpDt(COD_receivablesVO.getPymtImpDt());
            COD_receivablesLocal.setOtherComment(COD_receivablesVO.getOtherComment());
            COD_receivablesLocal.setRecvPrepyAmt(COD_receivablesVO.getRecvPrepyAmt());
            COD_receivablesLocal.setOrigCustNm(COD_receivablesVO.getOrigCustNm());
            COD_receivablesLocal.setCustChngEmpId(COD_receivablesVO.getCustChngEmpId());
            COD_receivablesLocal.setOrigRecAmt(COD_receivablesVO.getOrigRecAmt());
            COD_receivablesLocal.setAmtChngEmpId(COD_receivablesVO.getAmtChngEmpId());
            COD_receivablesLocal.setRcptNbr(COD_receivablesVO.getRcptNbr());
            COD_receivablesLocal.setOrigRcptNbr(COD_receivablesVO.getOrigRcptNbr());
            COD_receivablesLocal.setRcptChngEmpId(COD_receivablesVO.getRcptChngEmpId());
            COD_receivablesLocal.setOrigEmployeeId(COD_receivablesVO.getOrigEmployeeId());
            COD_receivablesLocal.setReassEmpId(COD_receivablesVO.getReassEmpId());
            COD_receivablesLocal.setDualRecIdNbr(COD_receivablesVO.getDualRecIdNbr());
            COD_receivablesLocal.setDupAwbFlg(COD_receivablesVO.getDupAwbFlg());
            COD_receivablesLocal.setBillAccount(COD_receivablesVO.getbillAccount());
            //to make the changes for the two columns miscDate, miscNbr
            COD_receivablesLocal.setMiscDate(COD_receivablesVO.getMiscDate());
            COD_receivablesLocal.setMiscNbr(COD_receivablesVO.getMiscNbr());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateCOD_Receivables() method from COD_ReceivablesManager class";
            throw new COD_ReceivablesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateCOD_Receivables() method from COD_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCOD_Receivables objects
     * @return Collection - a collection of the COD_Receivables objects
     */
    public Collection getAllCOD_Receivables() {
        try {
            //-- gets the local home interface and call the findAllCOD_Receivables method
            Collection COD_receivablesCol = getCOD_ReceivablesLocalHome().findAllCOD_Receivables();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (COD_receivablesCol != null && COD_receivablesCol.size() > 0) {
                Iterator it = COD_receivablesCol.iterator();
                while (it.hasNext()) {
                    COD_ReceivablesLocal COD_receivablesLocal = (COD_ReceivablesLocal) it.next();
                    //-- get the primary key of the COD_Receivables EJB object
                    Integer recId = (Integer)COD_receivablesLocal.getPrimaryKey();
                    //-- get the value object for the COD_Receivables EJB using the primary key
                    if (recId != null) {
                        COD_ReceivablesVO COD_receivablesVO = getCOD_Receivables(recId);
                        //-- add the value object to the collection
                        list.add(COD_receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllCOD_Receivables() method from COD_ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllCOD_Receivables() method from COD_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findCOD_ReceivablesByAwbNbr objects
     * @return Collection - a collection of the COD_Receivables objects
     */
    public Collection getCOD_ReceivablesReceivablesByAwbNbr(String awbNbr) {
        try {
            //-- gets the local home interface and call the findCOD_ReceivablesByAwbNbr method
            Collection COD_receivablesCol = getCOD_ReceivablesLocalHome().findCOD_ReceivablesByAwbNbr(awbNbr);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (COD_receivablesCol != null && COD_receivablesCol.size() > 0) {
                Iterator it = COD_receivablesCol.iterator();
                while (it.hasNext()) {
                    COD_ReceivablesLocal COD_receivablesLocal = (COD_ReceivablesLocal) it.next();
                    //-- get the primary key of the COD_Receivables EJB object
                    Integer recId = (Integer)COD_receivablesLocal.getPrimaryKey();
                    //-- get the value object for the COD_Receivables EJB using the primary key
                    if (recId != null) {
                        COD_ReceivablesVO COD_receivablesVO = getCOD_Receivables(recId);
                        //-- add the value object to the collection
                        list.add(COD_receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getCOD_ReceivablesReceivablesByAwbNbr() method from COD_ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCOD_ReceivablesReceivablesByAwbNbr() method from COD_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the COD_Receivables objects
     */
    public Collection getCOD_ReceivablesByEodId(Integer eodId) {
        try {
            //-- gets the local home interface and call the findByEodId method
            Collection COD_receivablesCol = getCOD_ReceivablesLocalHome().findByEodId(eodId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (COD_receivablesCol != null && COD_receivablesCol.size() > 0) {
                Iterator it = COD_receivablesCol.iterator();
                while (it.hasNext()) {
                    COD_ReceivablesLocal COD_receivablesLocal = (COD_ReceivablesLocal) it.next();
                    //-- get the primary key of the COD_Receivables EJB object
                    Integer recId = (Integer)COD_receivablesLocal.getPrimaryKey();
                    //-- get the value object for the COD_Receivables EJB using the primary key
                    if (recId != null) {
                        COD_ReceivablesVO COD_receivablesVO = getCOD_Receivables(recId);
                        //-- add the value object to the collection
                        list.add(COD_receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getCOD_ReceivablesByEodId() method from COD_ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCOD_ReceivablesByEodId() method from COD_ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the COD_Receivables local home interface
     */
    private COD_ReceivablesLocalHome getCOD_ReceivablesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (COD_ReceivablesLocalHome) service.getEJBLocalHome(ServiceConstants.COD_RECEIVABLES_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCOD_ReceivablesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
