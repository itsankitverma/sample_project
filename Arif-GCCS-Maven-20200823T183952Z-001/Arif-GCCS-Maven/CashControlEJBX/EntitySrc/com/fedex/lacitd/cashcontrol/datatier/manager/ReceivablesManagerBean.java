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

public class ReceivablesManagerBean implements SessionBean {

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
     * This method create new Receivables object
     * @param receivablesVO a value object the Receivables bean
     */
    public void setReceivables(ReceivablesVO receivablesVO)
        throws ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (receivablesVO == null) {
            throw new IllegalArgumentException("receivablesVO parameter was null in setReceivables() method from ReceivablesManager class");
        }
        
        try {
            
            //-- create new Receivables object
            getReceivablesLocalHome().create(
                receivablesVO.getRecNbr(),
                receivablesVO.getCustomerNm(),
                receivablesVO.getRecDt(),
                receivablesVO.getInvCurrency(),
                receivablesVO.getRodAmt(),
                receivablesVO.getAncChargeAmt(),
                receivablesVO.getRecAmt(),
                receivablesVO.getLocationCd(),
                receivablesVO.getAwbNbr(),
                receivablesVO.getTinUniqId(),
                receivablesVO.getExchRateClnUsed(),
                receivablesVO.getEmployeeId(),
                receivablesVO.getPaymentCurrency(),
                receivablesVO.getCashPaymentAmt(),
                receivablesVO.getOtherPaymentAmt(),
                receivablesVO.getOtherPaymentType(),
                receivablesVO.getOtherDocNbr(),
                receivablesVO.getDex16CashPayment(),
                receivablesVO.getDex16FreightAmt(),
                receivablesVO.getDex16OtherPaymentAmt(),
                receivablesVO.getDex16OtherDocNbr(),
                receivablesVO.getDex16ScanSeqNbr(),
                receivablesVO.getChngStatusEmployeeId(),
                receivablesVO.getChngStatusDt(),
                receivablesVO.getCloseEmployeeId(),
                receivablesVO.getCloseDt(),
                receivablesVO.getEodEmployeeId(),
                receivablesVO.getEodDt(),
                receivablesVO.getLastScanType(),
                receivablesVO.getLastScanDate(),
                receivablesVO.getChkinAgentComment(),
                receivablesVO.getTrackingStatus(),
                receivablesVO.getStatusId(),
                receivablesVO.getCashDepositSlipId(),
                receivablesVO.getCashDepositSlipNbr(),
                receivablesVO.getOtherDepositSlipId(),
                receivablesVO.getOtherDepositSlipNbr(),
                receivablesVO.getCreditCardBatchId(),
                receivablesVO.getEodId(),
                receivablesVO.getRodXmlImpDt(),
                receivablesVO.getPymtImpDt(),
                receivablesVO.getOtherComment(),
                receivablesVO.getRecvPrepyAmt(),
                receivablesVO.getOrigCustNm(),
                receivablesVO.getCustChngEmpId(),
                receivablesVO.getOrigRecAmt(),
                receivablesVO.getAmtChngEmpId(),
                receivablesVO.getRcptNbr(),
                receivablesVO.getOrigRcptNbr(),
                receivablesVO.getRcptChngEmpId(),
                receivablesVO.getOrigEmployeeId(),
                receivablesVO.getReassEmpId(),
                receivablesVO.getDualRecIdNbr(),
                receivablesVO.getDupAwbFlg(),
                receivablesVO.getbillAccount(), 
                //added to add two new columns miscDate,miscNbr
                receivablesVO.getMiscDate(), 
                receivablesVO.getMiscNbr());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setReceivables() method from ReceivablesManager class";
            throw new ReceivablesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setReceivables() method from ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Receivables object
     * @return receivablesVO - a value object of the Receivables bean
     */
    public ReceivablesVO getReceivables(Integer recId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in getReceivables() method from ReceivablesManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            ReceivablesLocal receivablesLocal = getReceivablesLocalHome().findByPrimaryKey(recId);
            //-- create new value object to store the data
            ReceivablesVO receivablesVO = new ReceivablesVO();
            //-- populate the new value object
            receivablesVO.setRecId(receivablesLocal.getRecId());
            receivablesVO.setRecNbr(receivablesLocal.getRecNbr());
            receivablesVO.setCustomerNm(receivablesLocal.getCustomerNm());
            receivablesVO.setRecDt(receivablesLocal.getRecDt());
            receivablesVO.setInvCurrency(receivablesLocal.getInvCurrency());
            receivablesVO.setRodAmt(receivablesLocal.getRodAmt());
            receivablesVO.setAncChargeAmt(receivablesLocal.getAncChargeAmt());
            receivablesVO.setRecAmt(receivablesLocal.getRecAmt());
            receivablesVO.setLocationCd(receivablesLocal.getLocationCd());
            receivablesVO.setAwbNbr(receivablesLocal.getAwbNbr());
            receivablesVO.setTinUniqId(receivablesLocal.getTinUniqId());
            receivablesVO.setExchRateClnUsed(receivablesLocal.getExchRateClnUsed());
            receivablesVO.setEmployeeId(receivablesLocal.getEmployeeId());
            receivablesVO.setPaymentCurrency(receivablesLocal.getPaymentCurrency());
            receivablesVO.setCashPaymentAmt(receivablesLocal.getCashPaymentAmt());
            receivablesVO.setOtherPaymentAmt(receivablesLocal.getOtherPaymentAmt());
            receivablesVO.setOtherPaymentType(receivablesLocal.getOtherPaymentType());
            receivablesVO.setOtherDocNbr(receivablesLocal.getOtherDocNbr());
            receivablesVO.setDex16CashPayment(receivablesLocal.getDex16CashPayment());
            receivablesVO.setDex16FreightAmt(receivablesLocal.getDex16FreightAmt());
            receivablesVO.setDex16OtherPaymentAmt(receivablesLocal.getDex16OtherPaymentAmt());
            receivablesVO.setDex16OtherDocNbr(receivablesLocal.getDex16OtherDocNbr());
            receivablesVO.setDex16ScanSeqNbr(receivablesLocal.getDex16ScanSeqNbr());
            receivablesVO.setChngStatusEmployeeId(receivablesLocal.getChngStatusEmployeeId());
            receivablesVO.setChngStatusDt(receivablesLocal.getChngStatusDt());
            receivablesVO.setCloseEmployeeId(receivablesLocal.getCloseEmployeeId());
            receivablesVO.setCloseDt(receivablesLocal.getCloseDt());
            receivablesVO.setEodEmployeeId(receivablesLocal.getEodEmployeeId());
            receivablesVO.setEodDt(receivablesLocal.getEodDt());
            receivablesVO.setLastScanType(receivablesLocal.getLastScanType());
            receivablesVO.setLastScanDate(receivablesLocal.getLastScanDate());
            receivablesVO.setChkinAgentComment(receivablesLocal.getChkinAgentComment());
            receivablesVO.setTrackingStatus(receivablesLocal.getTrackingStatus());
            receivablesVO.setStatusId(receivablesLocal.getStatusId());
            receivablesVO.setCashDepositSlipId(receivablesLocal.getCashDepositSlipId());
            receivablesVO.setCashDepositSlipNbr(receivablesLocal.getCashDepositSlipNbr());
            receivablesVO.setOtherDepositSlipId(receivablesLocal.getOtherDepositSlipId());
            receivablesVO.setOtherDepositSlipNbr(receivablesLocal.getOtherDepositSlipNbr());
            receivablesVO.setCreditCardBatchId(receivablesLocal.getCreditCardBatchId());
            receivablesVO.setEodId(receivablesLocal.getEodId());
            receivablesVO.setRodXmlImpDt(receivablesLocal.getRodXmlImpDt());
            receivablesVO.setPymtImpDt(receivablesLocal.getPymtImpDt());
            receivablesVO.setOtherComment(receivablesLocal.getOtherComment());
            receivablesVO.setRecvPrepyAmt(receivablesLocal.getRecvPrepyAmt());
            receivablesVO.setOrigCustNm(receivablesLocal.getOrigCustNm());
            receivablesVO.setCustChngEmpId(receivablesLocal.getCustChngEmpId());
            receivablesVO.setOrigRecAmt(receivablesLocal.getOrigRecAmt());
            receivablesVO.setAmtChngEmpId(receivablesLocal.getAmtChngEmpId());
            receivablesVO.setRcptNbr(receivablesLocal.getRcptNbr());
            receivablesVO.setOrigRcptNbr(receivablesLocal.getOrigRcptNbr());
            receivablesVO.setRcptChngEmpId(receivablesLocal.getRcptChngEmpId());
            receivablesVO.setOrigEmployeeId(receivablesLocal.getOrigEmployeeId());
            receivablesVO.setReassEmpId(receivablesLocal.getReassEmpId());
            receivablesVO.setDualRecIdNbr(receivablesLocal.getDualRecIdNbr());
            receivablesVO.setDupAwbFlg(receivablesLocal.getDupAwbFlg());
            receivablesVO.setbillAccount(receivablesLocal.getBillAccount());
            //for the two column added
            receivablesVO.setMiscDate(receivablesLocal.getMiscDate());
            receivablesVO.setMiscNbr(receivablesLocal.getMiscNbr());
            return receivablesVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getReceivables() method from ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Receivables object
     * @param recId - the Receivables bean primary key
     */
    public void removeReceivables(Integer recId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in removeReceivables() method from ReceivablesManager class");
        }
        
        try {
            getReceivablesLocalHome().remove(recId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeReceivables() method from ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Receivables object
     * @param receivablesVO - the value object of the Receivables bean
     */
    public void updateReceivables(ReceivablesVO receivablesVO)
        throws ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (receivablesVO == null) {
            throw new IllegalArgumentException("receivablesVO parameter was null in updateReceivables() method from ReceivablesManager class");
        }
        
        try {
            Integer recId = receivablesVO.getRecId();
            
            ReceivablesLocal receivablesLocal = getReceivablesLocalHome().findByPrimaryKey(recId);
            //-- update Receivables entity bean
            //System.out.println("in ReceivablesManagerBean-apr04-2010");
            //System.out.println("receivablesVO.getbillAccount()=="+receivablesVO.getbillAccount());
            receivablesLocal.setRecNbr(receivablesVO.getRecNbr());
            receivablesLocal.setCustomerNm(receivablesVO.getCustomerNm());
            receivablesLocal.setRecDt(receivablesVO.getRecDt());
            receivablesLocal.setInvCurrency(receivablesVO.getInvCurrency());
            receivablesLocal.setRodAmt(receivablesVO.getRodAmt());
            receivablesLocal.setAncChargeAmt(receivablesVO.getAncChargeAmt());
            receivablesLocal.setRecAmt(receivablesVO.getRecAmt());
            receivablesLocal.setLocationCd(receivablesVO.getLocationCd());
            receivablesLocal.setAwbNbr(receivablesVO.getAwbNbr());
            receivablesLocal.setTinUniqId(receivablesVO.getTinUniqId());
            receivablesLocal.setExchRateClnUsed(receivablesVO.getExchRateClnUsed());
            receivablesLocal.setEmployeeId(receivablesVO.getEmployeeId());
            receivablesLocal.setPaymentCurrency(receivablesVO.getPaymentCurrency());
            receivablesLocal.setCashPaymentAmt(receivablesVO.getCashPaymentAmt());
            receivablesLocal.setOtherPaymentAmt(receivablesVO.getOtherPaymentAmt());
            receivablesLocal.setOtherPaymentType(receivablesVO.getOtherPaymentType());
            receivablesLocal.setOtherDocNbr(receivablesVO.getOtherDocNbr());
            receivablesLocal.setDex16CashPayment(receivablesVO.getDex16CashPayment());
            receivablesLocal.setDex16FreightAmt(receivablesVO.getDex16FreightAmt());
            receivablesLocal.setDex16OtherPaymentAmt(receivablesVO.getDex16OtherPaymentAmt());
            receivablesLocal.setDex16OtherDocNbr(receivablesVO.getDex16OtherDocNbr());
            receivablesLocal.setDex16ScanSeqNbr(receivablesVO.getDex16ScanSeqNbr());
            receivablesLocal.setChngStatusEmployeeId(receivablesVO.getChngStatusEmployeeId());
            receivablesLocal.setChngStatusDt(receivablesVO.getChngStatusDt());
            receivablesLocal.setCloseEmployeeId(receivablesVO.getCloseEmployeeId());
            receivablesLocal.setCloseDt(receivablesVO.getCloseDt());
            receivablesLocal.setEodEmployeeId(receivablesVO.getEodEmployeeId());
            receivablesLocal.setEodDt(receivablesVO.getEodDt());
            receivablesLocal.setLastScanType(receivablesVO.getLastScanType());
            receivablesLocal.setLastScanDate(receivablesVO.getLastScanDate());
            receivablesLocal.setChkinAgentComment(receivablesVO.getChkinAgentComment());
            receivablesLocal.setTrackingStatus(receivablesVO.getTrackingStatus());
            receivablesLocal.setStatusId(receivablesVO.getStatusId());
            receivablesLocal.setCashDepositSlipId(receivablesVO.getCashDepositSlipId());
            receivablesLocal.setCashDepositSlipNbr(receivablesVO.getCashDepositSlipNbr());
            receivablesLocal.setOtherDepositSlipId(receivablesVO.getOtherDepositSlipId());
            receivablesLocal.setOtherDepositSlipNbr(receivablesVO.getOtherDepositSlipNbr());
            receivablesLocal.setCreditCardBatchId(receivablesVO.getCreditCardBatchId());
            receivablesLocal.setEodId(receivablesVO.getEodId());
            receivablesLocal.setRodXmlImpDt(receivablesVO.getRodXmlImpDt());
            receivablesLocal.setPymtImpDt(receivablesVO.getPymtImpDt());
            receivablesLocal.setOtherComment(receivablesVO.getOtherComment());
            receivablesLocal.setRecvPrepyAmt(receivablesVO.getRecvPrepyAmt());
            receivablesLocal.setOrigCustNm(receivablesVO.getOrigCustNm());
            receivablesLocal.setCustChngEmpId(receivablesVO.getCustChngEmpId());
            receivablesLocal.setOrigRecAmt(receivablesVO.getOrigRecAmt());
            receivablesLocal.setAmtChngEmpId(receivablesVO.getAmtChngEmpId());
            receivablesLocal.setRcptNbr(receivablesVO.getRcptNbr());
            receivablesLocal.setOrigRcptNbr(receivablesVO.getOrigRcptNbr());
            receivablesLocal.setRcptChngEmpId(receivablesVO.getRcptChngEmpId());
            receivablesLocal.setOrigEmployeeId(receivablesVO.getOrigEmployeeId());
            receivablesLocal.setReassEmpId(receivablesVO.getReassEmpId());
            receivablesLocal.setDualRecIdNbr(receivablesVO.getDualRecIdNbr());
            receivablesLocal.setDupAwbFlg(receivablesVO.getDupAwbFlg());
            receivablesLocal.setBillAccount(receivablesVO.getbillAccount());
            //change done to add the two column
            receivablesLocal.setMiscDate(receivablesVO.getMiscDate());
            receivablesLocal.setMiscNbr(receivablesVO.getMiscNbr());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateReceivables() method from ReceivablesManager class";
            throw new ReceivablesException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateReceivables() method from ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllReceivables objects
     * @return Collection - a collection of the Receivables objects
     */
    public Collection getAllReceivables() {
        try {
            //-- gets the local home interface and call the findAllReceivables method
            Collection receivablesCol = getReceivablesLocalHome().findAllReceivables();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (receivablesCol != null && receivablesCol.size() > 0) {
                Iterator it = receivablesCol.iterator();
                while (it.hasNext()) {
                    ReceivablesLocal receivablesLocal = (ReceivablesLocal) it.next();
                    //-- get the primary key of the Receivables EJB object
                    Integer recId = (Integer)receivablesLocal.getPrimaryKey();
                    //-- get the value object for the Receivables EJB using the primary key
                    if (recId != null) {
                        ReceivablesVO receivablesVO = getReceivables(recId);
                        //-- add the value object to the collection
                        list.add(receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllReceivables() method from ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllReceivables() method from ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findReceivablesByAwbNbr objects
     * @return Collection - a collection of the Receivables objects
     */
    public Collection getReceivablesReceivablesByAwbNbr(String awbNbr) {
        try {
            //-- gets the local home interface and call the findReceivablesByAwbNbr method
            Collection receivablesCol = getReceivablesLocalHome().findReceivablesByAwbNbr(awbNbr);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (receivablesCol != null && receivablesCol.size() > 0) {
                Iterator it = receivablesCol.iterator();
                while (it.hasNext()) {
                    ReceivablesLocal receivablesLocal = (ReceivablesLocal) it.next();
                    //-- get the primary key of the Receivables EJB object
                    Integer recId = (Integer)receivablesLocal.getPrimaryKey();
                    //-- get the value object for the Receivables EJB using the primary key
                    if (recId != null) {
                        ReceivablesVO receivablesVO = getReceivables(recId);
                        //-- add the value object to the collection
                        list.add(receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getReceivablesReceivablesByAwbNbr() method from ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getReceivablesReceivablesByAwbNbr() method from ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the Receivables objects
     */
    public Collection getReceivablesByEodId(Integer eodId) {
        try {
            //-- gets the local home interface and call the findByEodId method
            Collection receivablesCol = getReceivablesLocalHome().findByEodId(eodId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (receivablesCol != null && receivablesCol.size() > 0) {
                Iterator it = receivablesCol.iterator();
                while (it.hasNext()) {
                    ReceivablesLocal receivablesLocal = (ReceivablesLocal) it.next();
                    //-- get the primary key of the Receivables EJB object
                    Integer recId = (Integer)receivablesLocal.getPrimaryKey();
                    //-- get the value object for the Receivables EJB using the primary key
                    if (recId != null) {
                        ReceivablesVO receivablesVO = getReceivables(recId);
                        //-- add the value object to the collection
                        list.add(receivablesVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getReceivablesByEodId() method from ReceivablesManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getReceivablesByEodId() method from ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Receivables local home interface
     */
    private ReceivablesLocalHome getReceivablesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (ReceivablesLocalHome) service.getEJBLocalHome(ServiceConstants.RECEIVABLES_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getReceivablesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
