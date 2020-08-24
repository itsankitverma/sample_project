/**
 * @(#)PoaPaymentManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javax.swing.text.DateFormatter;

public class PoaPaymentManagerBean implements SessionBean {

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
     * This method create new PoaPayment object
     * @param poaPaymentVO a value object the PoaPayment bean
     */
    public void setPoaPayment(PoaPaymentVO poaPaymentVO)
        throws PoaPaymentException {
        //-- we do not accept null value for the parameter.
        if (poaPaymentVO == null) {
            throw new IllegalArgumentException("poaPaymentVO parameter was null in setPoaPayment() method from PoaPaymentManager class");
        }
        
        try {
        	DateFormat formatter;
            formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = formatter.parse(poaPaymentVO.getChequeDt()); 
            //-- create new PoaPayment object
            getPoaPaymentLocalHome().create(
                poaPaymentVO.getAccountNbr(),
                poaPaymentVO.getCustomerNm(),
                poaPaymentVO.getPaymentDt(),
                poaPaymentVO.getLocationCd(),
                poaPaymentVO.getPaymentCurrency(),
                poaPaymentVO.getExchRate(),
                poaPaymentVO.getPaymentAmt(),
                poaPaymentVO.getPaymentType(),
                poaPaymentVO.getCoupPymtAmt(),
                poaPaymentVO.getOtherDocNbr(),
                poaPaymentVO.getCourierId(),
                poaPaymentVO.getCloseEmployeeId(),
                poaPaymentVO.getCloseDt(),
                poaPaymentVO.getEodEmployeeId(),
                poaPaymentVO.getEodDt(),
                poaPaymentVO.getChkinAgentComment(),
                poaPaymentVO.getDepositSlipId(),
                poaPaymentVO.getDepositSlipNbr(),
                poaPaymentVO.getCreditCardBatchId(),
                poaPaymentVO.getReceivedEmpId(),
                poaPaymentVO.getEodId(),
                poaPaymentVO.getCouponBatchId(),
                poaPaymentVO.getPymtImpDt(),
                poaPaymentVO.getOtherComment(),
                poaPaymentVO.getRcptNbr(),
                poaPaymentVO.getOrigRcptNbr(),
                poaPaymentVO.getRcptChngEmpId(),
                poaPaymentVO.getOrigEmployeeId(),
                poaPaymentVO.getReassEmpId(),
                // Introduced new fields in POA payment screen Changes Done by Kapil R
                //poaPaymentVO.getChequeDt(),
                date,
                poaPaymentVO.getChequeOrigin(),
                poaPaymentVO.getBankName()
                
            );
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPoaPayment() method from PoaPaymentManager class";
            throw new PoaPaymentException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPoaPayment() method from PoaPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PoaPayment object
     * @return poaPaymentVO - a value object of the PoaPayment bean
     */
    public PoaPaymentVO getPoaPayment(Integer poaPaymentsId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (poaPaymentsId == null) {
            throw new IllegalArgumentException("poaPaymentsId parameter was null in getPoaPayment() method from PoaPaymentManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PoaPaymentLocal poaPaymentLocal = getPoaPaymentLocalHome().findByPrimaryKey(poaPaymentsId);
            //-- create new value object to store the data
            PoaPaymentVO poaPaymentVO = new PoaPaymentVO();
            //-- populate the new value object
            poaPaymentVO.setPoaPaymentsId(poaPaymentLocal.getPoaPaymentsId());
            poaPaymentVO.setAccountNbr(poaPaymentLocal.getAccountNbr());
            poaPaymentVO.setCustomerNm(poaPaymentLocal.getCustomerNm());
            poaPaymentVO.setPaymentDt(poaPaymentLocal.getPaymentDt());
            poaPaymentVO.setLocationCd(poaPaymentLocal.getLocationCd());
            poaPaymentVO.setPaymentCurrency(poaPaymentLocal.getPaymentCurrency());
            poaPaymentVO.setExchRate(poaPaymentLocal.getExchRate());
            poaPaymentVO.setPaymentAmt(poaPaymentLocal.getPaymentAmt());
            poaPaymentVO.setPaymentType(poaPaymentLocal.getPaymentType());
            poaPaymentVO.setCoupPymtAmt(poaPaymentLocal.getCoupPymtAmt());
            poaPaymentVO.setOtherDocNbr(poaPaymentLocal.getOtherDocNbr());
            poaPaymentVO.setCourierId(poaPaymentLocal.getCourierId());
            poaPaymentVO.setCloseEmployeeId(poaPaymentLocal.getCloseEmployeeId());
            poaPaymentVO.setCloseDt(poaPaymentLocal.getCloseDt());
            poaPaymentVO.setEodEmployeeId(poaPaymentLocal.getEodEmployeeId());
            poaPaymentVO.setEodDt(poaPaymentLocal.getEodDt());
            poaPaymentVO.setChkinAgentComment(poaPaymentLocal.getChkinAgentComment());
            poaPaymentVO.setDepositSlipId(poaPaymentLocal.getDepositSlipId());
            poaPaymentVO.setDepositSlipNbr(poaPaymentLocal.getDepositSlipNbr());
            poaPaymentVO.setCreditCardBatchId(poaPaymentLocal.getCreditCardBatchId());
            poaPaymentVO.setReceivedEmpId(poaPaymentLocal.getReceivedEmpId());
            poaPaymentVO.setEodId(poaPaymentLocal.getEodId());
            poaPaymentVO.setCouponBatchId(poaPaymentLocal.getCouponBatchId());
            poaPaymentVO.setPymtImpDt(poaPaymentLocal.getPymtImpDt());
            poaPaymentVO.setOtherComment(poaPaymentLocal.getOtherComment());
            poaPaymentVO.setRcptNbr(poaPaymentLocal.getRcptNbr());
            poaPaymentVO.setOrigRcptNbr(poaPaymentLocal.getOrigRcptNbr());
            poaPaymentVO.setRcptChngEmpId(poaPaymentLocal.getRcptChngEmpId());
            poaPaymentVO.setOrigEmployeeId(poaPaymentLocal.getOrigEmployeeId());
            poaPaymentVO.setReassEmpId(poaPaymentLocal.getReassEmpId());
            // Introduced new fields in POA payment screen Changes Done by Kapil R
            
            if(poaPaymentLocal.getChequeDt()==null){
            	poaPaymentVO.setChequeDt("");
            }
            else {
            	DateFormat formatter;
        		formatter = new SimpleDateFormat("MM/dd/yyyy");
            	poaPaymentVO.setChequeDt(formatter.format(poaPaymentLocal.getChequeDt()).toString());
            }
            poaPaymentVO.setChequeOrigin(poaPaymentLocal.getChequeOrigin());
            poaPaymentVO.setBankName(poaPaymentLocal.getBankName());
            return poaPaymentVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPoaPayment() method from PoaPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PoaPayment object
     * @param poaPaymentsId - the PoaPayment bean primary key
     */
    public void removePoaPayment(Integer poaPaymentsId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (poaPaymentsId == null) {
            throw new IllegalArgumentException("poaPaymentsId parameter was null in removePoaPayment() method from PoaPaymentManager class");
        }
        
        try {
            getPoaPaymentLocalHome().remove(poaPaymentsId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePoaPayment() method from PoaPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PoaPayment object
     * @param poaPaymentVO - the value object of the PoaPayment bean
     */
    public void updatePoaPayment(PoaPaymentVO poaPaymentVO)
        throws PoaPaymentException {
        //-- we do not accept null value for the parameter.
        if (poaPaymentVO == null) {
            throw new IllegalArgumentException("poaPaymentVO parameter was null in updatePoaPayment() method from PoaPaymentManager class");
        }
        
        try {
            Integer poaPaymentsId = poaPaymentVO.getPoaPaymentsId();
            
            PoaPaymentLocal poaPaymentLocal = getPoaPaymentLocalHome().findByPrimaryKey(poaPaymentsId);
            //-- update PoaPayment entity bean
            poaPaymentLocal.setAccountNbr(poaPaymentVO.getAccountNbr());
            poaPaymentLocal.setCustomerNm(poaPaymentVO.getCustomerNm());
            poaPaymentLocal.setPaymentDt(poaPaymentVO.getPaymentDt());
            poaPaymentLocal.setLocationCd(poaPaymentVO.getLocationCd());
            poaPaymentLocal.setPaymentCurrency(poaPaymentVO.getPaymentCurrency());
            poaPaymentLocal.setExchRate(poaPaymentVO.getExchRate());
            poaPaymentLocal.setPaymentAmt(poaPaymentVO.getPaymentAmt());
            poaPaymentLocal.setPaymentType(poaPaymentVO.getPaymentType());
            poaPaymentLocal.setCoupPymtAmt(poaPaymentVO.getCoupPymtAmt());
            poaPaymentLocal.setOtherDocNbr(poaPaymentVO.getOtherDocNbr());
            poaPaymentLocal.setCourierId(poaPaymentVO.getCourierId());
            poaPaymentLocal.setCloseEmployeeId(poaPaymentVO.getCloseEmployeeId());
            poaPaymentLocal.setCloseDt(poaPaymentVO.getCloseDt());
            poaPaymentLocal.setEodEmployeeId(poaPaymentVO.getEodEmployeeId());
            poaPaymentLocal.setEodDt(poaPaymentVO.getEodDt());
            poaPaymentLocal.setChkinAgentComment(poaPaymentVO.getChkinAgentComment());
            poaPaymentLocal.setDepositSlipId(poaPaymentVO.getDepositSlipId());
            poaPaymentLocal.setDepositSlipNbr(poaPaymentVO.getDepositSlipNbr());
            poaPaymentLocal.setCreditCardBatchId(poaPaymentVO.getCreditCardBatchId());
            poaPaymentLocal.setReceivedEmpId(poaPaymentVO.getReceivedEmpId());
            poaPaymentLocal.setEodId(poaPaymentVO.getEodId());
            poaPaymentLocal.setCouponBatchId(poaPaymentVO.getCouponBatchId());
            poaPaymentLocal.setPymtImpDt(poaPaymentVO.getPymtImpDt());
            poaPaymentLocal.setOtherComment(poaPaymentVO.getOtherComment());
            poaPaymentLocal.setRcptNbr(poaPaymentVO.getRcptNbr());
            poaPaymentLocal.setOrigRcptNbr(poaPaymentVO.getOrigRcptNbr());
            poaPaymentLocal.setRcptChngEmpId(poaPaymentVO.getRcptChngEmpId());
            poaPaymentLocal.setOrigEmployeeId(poaPaymentVO.getOrigEmployeeId());
            poaPaymentLocal.setReassEmpId(poaPaymentVO.getReassEmpId());
            
            DateFormat formatter;
            formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = null;
            if(!poaPaymentVO.getChequeDt().equalsIgnoreCase("")){
            	formatter = new SimpleDateFormat("MM/dd/yyyy");
                try{
                	date = formatter.parse(poaPaymentVO.getChequeDt());
                }catch(Exception e){
                	System.out.println("Date parsing error in POA");
                	date = null;
                }
            }
            poaPaymentLocal.setChequeDt(date);
            
            poaPaymentLocal.setChequeOrigin(poaPaymentVO.getChequeOrigin());
            poaPaymentLocal.setBankName(poaPaymentVO.getBankName());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePoaPayment() method from PoaPaymentManager class";
            throw new PoaPaymentException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePoaPayment() method from PoaPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPoaPayments objects
     * @return Collection - a collection of the PoaPayment objects
     */
    public Collection getAllPoaPayments() {
        try {
            //-- gets the local home interface and call the findAllPoaPayments method
            Collection poaPaymentCol = getPoaPaymentLocalHome().findAllPoaPayments();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (poaPaymentCol != null && poaPaymentCol.size() > 0) {
                Iterator it = poaPaymentCol.iterator();
                while (it.hasNext()) {
                    PoaPaymentLocal poaPaymentLocal = (PoaPaymentLocal) it.next();
                    //-- get the primary key of the PoaPayment EJB object
                    Integer poaPaymentsId = (Integer)poaPaymentLocal.getPrimaryKey();
                    //-- get the value object for the PoaPayment EJB using the primary key
                    if (poaPaymentsId != null) {
                        PoaPaymentVO poaPaymentVO = getPoaPayment(poaPaymentsId);
                        //-- add the value object to the collection
                        list.add(poaPaymentVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPoaPayments() method from PoaPaymentManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPoaPayments() method from PoaPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the PoaPayment objects
     */
    public Collection getPoaPaymentByEodId(Integer eodId) {
        try {
            //-- gets the local home interface and call the findByEodId method
            Collection poaPaymentCol = getPoaPaymentLocalHome().findByEodId(eodId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (poaPaymentCol != null && poaPaymentCol.size() > 0) {
                Iterator it = poaPaymentCol.iterator();
                while (it.hasNext()) {
                    PoaPaymentLocal poaPaymentLocal = (PoaPaymentLocal) it.next();
                    //-- get the primary key of the PoaPayment EJB object
                    Integer poaPaymentsId = (Integer)poaPaymentLocal.getPrimaryKey();
                    //-- get the value object for the PoaPayment EJB using the primary key
                    if (poaPaymentsId != null) {
                        PoaPaymentVO poaPaymentVO = getPoaPayment(poaPaymentsId);
                        //-- add the value object to the collection
                        list.add(poaPaymentVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPoaPaymentByEodId() method from PoaPaymentManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPoaPaymentByEodId() method from PoaPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PoaPayment local home interface
     */
    private PoaPaymentLocalHome getPoaPaymentLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PoaPaymentLocalHome) service.getEJBLocalHome(ServiceConstants.POAPAYMENT_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPoaPaymentLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
