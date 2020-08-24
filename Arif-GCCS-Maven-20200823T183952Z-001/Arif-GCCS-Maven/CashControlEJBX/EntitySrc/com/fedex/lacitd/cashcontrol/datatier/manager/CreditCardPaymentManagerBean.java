/**
 * @(#)CreditCardPaymentManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class CreditCardPaymentManagerBean implements SessionBean {

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
     * This method create new CreditCardPayment object
     * @param creditCardPaymentVO a value object the CreditCardPayment bean
     */
    public void setCreditCardPayment(CreditCardPaymentVO creditCardPaymentVO)
        throws CreditCardPaymentException {
        //-- we do not accept null value for the parameter.
        if (creditCardPaymentVO == null) {
            throw new IllegalArgumentException("creditCardPaymentVO parameter was null in setCreditCardPayment() method from CreditCardPaymentManager class");
        }
        
        try {
            
            //-- create new CreditCardPayment object
            getCreditCardPaymentLocalHome().create(
                creditCardPaymentVO.getTotalAmt(),
                creditCardPaymentVO.getTotalReimbursed(),
                creditCardPaymentVO.getPaymentType(),
                creditCardPaymentVO.getPaymentDocNbr(),
                creditCardPaymentVO.getComments(),
                creditCardPaymentVO.getStatusId(),
                creditCardPaymentVO.getLocationCd(),
                creditCardPaymentVO.getEmployeeId(),
                creditCardPaymentVO.getBatchDt(),
                creditCardPaymentVO.getCurrencyCd(),
                creditCardPaymentVO.getDepositSlipId(),
                creditCardPaymentVO.getEodId());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setCreditCardPayment() method from CreditCardPaymentManager class";
            throw new CreditCardPaymentException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setCreditCardPayment() method from CreditCardPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a CreditCardPayment object
     * @return creditCardPaymentVO - a value object of the CreditCardPayment bean
     */
    public CreditCardPaymentVO getCreditCardPayment(Integer creditCardPymtId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (creditCardPymtId == null) {
            throw new IllegalArgumentException("creditCardPymtId parameter was null in getCreditCardPayment() method from CreditCardPaymentManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            CreditCardPaymentLocal creditCardPaymentLocal = getCreditCardPaymentLocalHome().findByPrimaryKey(creditCardPymtId);
            //-- create new value object to store the data
            CreditCardPaymentVO creditCardPaymentVO = new CreditCardPaymentVO();
            //-- populate the new value object
            creditCardPaymentVO.setCreditCardPymtId(creditCardPaymentLocal.getCreditCardPymtId());
            creditCardPaymentVO.setTotalAmt(creditCardPaymentLocal.getTotalAmt());
            creditCardPaymentVO.setTotalReimbursed(creditCardPaymentLocal.getTotalReimbursed());
            creditCardPaymentVO.setPaymentType(creditCardPaymentLocal.getPaymentType());
            creditCardPaymentVO.setPaymentDocNbr(creditCardPaymentLocal.getPaymentDocNbr());
            creditCardPaymentVO.setComments(creditCardPaymentLocal.getComments());
            creditCardPaymentVO.setStatusId(creditCardPaymentLocal.getStatusId());
            creditCardPaymentVO.setLocationCd(creditCardPaymentLocal.getLocationCd());
            creditCardPaymentVO.setEmployeeId(creditCardPaymentLocal.getEmployeeId());
            creditCardPaymentVO.setBatchDt(creditCardPaymentLocal.getBatchDt());
            creditCardPaymentVO.setCurrencyCd(creditCardPaymentLocal.getCurrencyCd());
            creditCardPaymentVO.setDepositSlipId(creditCardPaymentLocal.getDepositSlipId());
            creditCardPaymentVO.setEodId(creditCardPaymentLocal.getEodId());
            return creditCardPaymentVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCreditCardPayment() method from CreditCardPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing CreditCardPayment object
     * @param creditCardPymtId - the CreditCardPayment bean primary key
     */
    public void removeCreditCardPayment(Integer creditCardPymtId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (creditCardPymtId == null) {
            throw new IllegalArgumentException("creditCardPymtId parameter was null in removeCreditCardPayment() method from CreditCardPaymentManager class");
        }
        
        try {
            getCreditCardPaymentLocalHome().remove(creditCardPymtId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeCreditCardPayment() method from CreditCardPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing CreditCardPayment object
     * @param creditCardPaymentVO - the value object of the CreditCardPayment bean
     */
    public void updateCreditCardPayment(CreditCardPaymentVO creditCardPaymentVO)
        throws CreditCardPaymentException {
        //-- we do not accept null value for the parameter.
        if (creditCardPaymentVO == null) {
            throw new IllegalArgumentException("creditCardPaymentVO parameter was null in updateCreditCardPayment() method from CreditCardPaymentManager class");
        }
        
        try {
            Integer creditCardPymtId = creditCardPaymentVO.getCreditCardPymtId();
            
            CreditCardPaymentLocal creditCardPaymentLocal = getCreditCardPaymentLocalHome().findByPrimaryKey(creditCardPymtId);
            //-- update CreditCardPayment entity bean
            creditCardPaymentLocal.setTotalAmt(creditCardPaymentVO.getTotalAmt());
            creditCardPaymentLocal.setTotalReimbursed(creditCardPaymentVO.getTotalReimbursed());
            creditCardPaymentLocal.setPaymentType(creditCardPaymentVO.getPaymentType());
            creditCardPaymentLocal.setPaymentDocNbr(creditCardPaymentVO.getPaymentDocNbr());
            creditCardPaymentLocal.setComments(creditCardPaymentVO.getComments());
            creditCardPaymentLocal.setStatusId(creditCardPaymentVO.getStatusId());
            creditCardPaymentLocal.setLocationCd(creditCardPaymentVO.getLocationCd());
            creditCardPaymentLocal.setEmployeeId(creditCardPaymentVO.getEmployeeId());
            creditCardPaymentLocal.setBatchDt(creditCardPaymentVO.getBatchDt());
            creditCardPaymentLocal.setCurrencyCd(creditCardPaymentVO.getCurrencyCd());
            creditCardPaymentLocal.setDepositSlipId(creditCardPaymentVO.getDepositSlipId());
            creditCardPaymentLocal.setEodId(creditCardPaymentVO.getEodId());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateCreditCardPayment() method from CreditCardPaymentManager class";
            throw new CreditCardPaymentException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateCreditCardPayment() method from CreditCardPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCreditCardPayments objects
     * @return Collection - a collection of the CreditCardPayment objects
     */
    public Collection getAllCreditCardPayments() {
        try {
            //-- gets the local home interface and call the findAllCreditCardPayments method
            Collection creditCardPaymentCol = getCreditCardPaymentLocalHome().findAllCreditCardPayments();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (creditCardPaymentCol != null && creditCardPaymentCol.size() > 0) {
                Iterator it = creditCardPaymentCol.iterator();
                while (it.hasNext()) {
                    CreditCardPaymentLocal creditCardPaymentLocal = (CreditCardPaymentLocal) it.next();
                    //-- get the primary key of the CreditCardPayment EJB object
                    Integer creditCardPymtId = (Integer)creditCardPaymentLocal.getPrimaryKey();
                    //-- get the value object for the CreditCardPayment EJB using the primary key
                    if (creditCardPymtId != null) {
                        CreditCardPaymentVO creditCardPaymentVO = getCreditCardPayment(creditCardPymtId);
                        //-- add the value object to the collection
                        list.add(creditCardPaymentVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllCreditCardPayments() method from CreditCardPaymentManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllCreditCardPayments() method from CreditCardPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the CreditCardPayment objects
     */
    public Collection getCreditCardPaymentByEodId(Integer eodId) {
        try {
            //-- gets the local home interface and call the findByEodId method
            Collection creditCardPaymentCol = getCreditCardPaymentLocalHome().findByEodId(eodId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (creditCardPaymentCol != null && creditCardPaymentCol.size() > 0) {
                Iterator it = creditCardPaymentCol.iterator();
                while (it.hasNext()) {
                    CreditCardPaymentLocal creditCardPaymentLocal = (CreditCardPaymentLocal) it.next();
                    //-- get the primary key of the CreditCardPayment EJB object
                    Integer creditCardPymtId = (Integer)creditCardPaymentLocal.getPrimaryKey();
                    //-- get the value object for the CreditCardPayment EJB using the primary key
                    if (creditCardPymtId != null) {
                        CreditCardPaymentVO creditCardPaymentVO = getCreditCardPayment(creditCardPymtId);
                        //-- add the value object to the collection
                        list.add(creditCardPaymentVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getCreditCardPaymentByEodId() method from CreditCardPaymentManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getCreditCardPaymentByEodId() method from CreditCardPaymentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the CreditCardPayment local home interface
     */
    private CreditCardPaymentLocalHome getCreditCardPaymentLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (CreditCardPaymentLocalHome) service.getEJBLocalHome(ServiceConstants.CREDITCARDPAYMENT_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCreditCardPaymentLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
