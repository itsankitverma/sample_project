/**
 * @(#)DepositSlipManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class DepositSlipManagerBean implements SessionBean {

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
     * This method create new DepositSlip object
     * @param depositSlipVO a value object the DepositSlip bean
     */
    public void setDepositSlip(DepositSlipVO depositSlipVO)
        throws DepositSlipException {
        //-- we do not accept null value for the parameter.
        if (depositSlipVO == null) {
            throw new IllegalArgumentException("depositSlipVO parameter was null in setDepositSlip() method from DepositSlipManager class");
        }
        
        try {
            //-- get BankAcc local interface
            Integer bankAccountCd = depositSlipVO.getBankAccountCd();
            BankAccLocal bankAccLocal = null;
            if (bankAccountCd != null) {
                bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            }
            //-- get Employee local interface
            String employeeId = depositSlipVO.getEmployeeId();
            EmployeeLocal employeeLocal = null;
            if (employeeId != null) {
                employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            }
            
            //-- create new DepositSlip object
            getDepositSlipLocalHome().create(
                depositSlipVO.getDepositSlipDt(),
                depositSlipVO.getDepositSlipNbr(),
                depositSlipVO.getDepositSlipTotAmt(),
                bankAccLocal,
                employeeLocal,
                depositSlipVO.getCurrencyCd(),
                depositSlipVO.getSrcType(),
                depositSlipVO.getPymtType(),
                depositSlipVO.getLocationCd(),
                depositSlipVO.getStatusId(),
                depositSlipVO.getComments(),
                depositSlipVO.getActualAmt(),
                depositSlipVO.getBankAmt(),
                depositSlipVO.getFedexDepositId(),
                depositSlipVO.getCloseDt(),
                depositSlipVO.getDepoDt(),
                depositSlipVO.getBankDepoDt(),
                depositSlipVO.getEodId(),
                depositSlipVO.getTemplId(),
                depositSlipVO.getTemplCd());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in find the requested object to create in setDepositSlip() method from DepositSlipManager class";
            throw new DepositSlipException(errorMsg, ex);
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setDepositSlip() method from DepositSlipManager class";
            throw new DepositSlipException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setDepositSlip() method from DepositSlipManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a DepositSlip object
     * @return depositSlipVO - a value object of the DepositSlip bean
     */
    public DepositSlipVO getDepositSlip(Integer depositSlipCd)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (depositSlipCd == null) {
            throw new IllegalArgumentException("depositSlipCd parameter was null in getDepositSlip() method from DepositSlipManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            DepositSlipLocal depositSlipLocal = getDepositSlipLocalHome().findByPrimaryKey(depositSlipCd);
            //-- create new value object to store the data
            DepositSlipVO depositSlipVO = new DepositSlipVO();
            //-- populate the new value object
            depositSlipVO.setDepositSlipCd(depositSlipLocal.getDepositSlipCd());
            depositSlipVO.setDepositSlipDt(depositSlipLocal.getDepositSlipDt());
            depositSlipVO.setDepositSlipNbr(depositSlipLocal.getDepositSlipNbr());
            depositSlipVO.setDepositSlipTotAmt(depositSlipLocal.getDepositSlipTotAmt());
            //-- get the primary key of the BankAcc object from the local interface
            BankAccLocal bankAccLocal = depositSlipLocal.getBankAcc();
            if (bankAccLocal != null) {
                Integer bankAccountCd = (Integer) bankAccLocal.getPrimaryKey();
                depositSlipVO.setBankAccountCd(bankAccountCd);
            }
            //-- get the primary key of the Employee object from the local interface
            EmployeeLocal employeeLocal = depositSlipLocal.getEmployee();
            if (employeeLocal != null) {
                String employeeId = (String) employeeLocal.getPrimaryKey();
                depositSlipVO.setEmployeeId(employeeId);
            }
            depositSlipVO.setCurrencyCd(depositSlipLocal.getCurrencyCd());
            depositSlipVO.setSrcType(depositSlipLocal.getSrcType());
            depositSlipVO.setPymtType(depositSlipLocal.getPymtType());
            depositSlipVO.setLocationCd(depositSlipLocal.getLocationCd());
            depositSlipVO.setStatusId(depositSlipLocal.getStatusId());
            depositSlipVO.setComments(depositSlipLocal.getComments());
            depositSlipVO.setActualAmt(depositSlipLocal.getActualAmt());
            depositSlipVO.setBankAmt(depositSlipLocal.getBankAmt());
            depositSlipVO.setFedexDepositId(depositSlipLocal.getFedexDepositId());
            depositSlipVO.setCloseDt(depositSlipLocal.getCloseDt());
            depositSlipVO.setDepoDt(depositSlipLocal.getDepoDt());
            depositSlipVO.setBankDepoDt(depositSlipLocal.getBankDepoDt());
            depositSlipVO.setEodId(depositSlipLocal.getEodId());
            depositSlipVO.setTemplId(depositSlipLocal.getTemplId());
            depositSlipVO.setTemplCd(depositSlipLocal.getTemplCd());
            return depositSlipVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepositSlip() method from DepositSlipManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing DepositSlip object
     * @param depositSlipCd - the DepositSlip bean primary key
     */
    public void removeDepositSlip(Integer depositSlipCd)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (depositSlipCd == null) {
            throw new IllegalArgumentException("depositSlipCd parameter was null in removeDepositSlip() method from DepositSlipManager class");
        }
        
        try {
            getDepositSlipLocalHome().remove(depositSlipCd);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeDepositSlip() method from DepositSlipManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing DepositSlip object
     * @param depositSlipVO - the value object of the DepositSlip bean
     */
    public void updateDepositSlip(DepositSlipVO depositSlipVO)
        throws DepositSlipException {
        //-- we do not accept null value for the parameter.
        if (depositSlipVO == null) {
            throw new IllegalArgumentException("depositSlipVO parameter was null in updateDepositSlip() method from DepositSlipManager class");
        }
        
        try {
            Integer depositSlipCd = depositSlipVO.getDepositSlipCd();
            
            DepositSlipLocal depositSlipLocal = getDepositSlipLocalHome().findByPrimaryKey(depositSlipCd);
            //-- update DepositSlip entity bean
            depositSlipLocal.setDepositSlipDt(depositSlipVO.getDepositSlipDt());
            depositSlipLocal.setDepositSlipNbr(depositSlipVO.getDepositSlipNbr());
            depositSlipLocal.setDepositSlipTotAmt(depositSlipVO.getDepositSlipTotAmt());
            //-- get bankAcc local interface and update DepositSlip entity bean
            //-- depending on your business need...you may have to remove the if statement
            Integer bankAccountCd = depositSlipVO.getBankAccountCd();
            BankAccLocal bankAccLocal = null;
            if (bankAccountCd != null) {
                bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            }
            depositSlipLocal.setBankAcc(bankAccLocal);
            //-- get employee local interface and update DepositSlip entity bean
            //-- depending on your business need...you may have to remove the if statement
            String employeeId = depositSlipVO.getEmployeeId();
            EmployeeLocal employeeLocal = null;
            if (employeeId != null) {
                employeeLocal = getEmployeeLocalHome().findByPrimaryKey(employeeId);
            }
            depositSlipLocal.setEmployee(employeeLocal);
            depositSlipLocal.setCurrencyCd(depositSlipVO.getCurrencyCd());
            depositSlipLocal.setSrcType(depositSlipVO.getSrcType());
            depositSlipLocal.setPymtType(depositSlipVO.getPymtType());
            depositSlipLocal.setLocationCd(depositSlipVO.getLocationCd());
            depositSlipLocal.setStatusId(depositSlipVO.getStatusId());
            depositSlipLocal.setComments(depositSlipVO.getComments());
            depositSlipLocal.setActualAmt(depositSlipVO.getActualAmt());
            depositSlipLocal.setBankAmt(depositSlipVO.getBankAmt());
            depositSlipLocal.setFedexDepositId(depositSlipVO.getFedexDepositId());
            depositSlipLocal.setCloseDt(depositSlipVO.getCloseDt());
            depositSlipLocal.setDepoDt(depositSlipVO.getDepoDt());
            depositSlipLocal.setBankDepoDt(depositSlipVO.getBankDepoDt());
            depositSlipLocal.setEodId(depositSlipVO.getEodId());
            depositSlipLocal.setTemplId(depositSlipVO.getTemplId());
            depositSlipLocal.setTemplCd(depositSlipVO.getTemplCd());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateDepositSlip() method from DepositSlipManager class";
            throw new DepositSlipException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateDepositSlip() method from DepositSlipManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllDepositSlips objects
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getAllDepositSlips() {
        try {
            //-- gets the local home interface and call the findAllDepositSlips method
            Collection depositSlipCol = getDepositSlipLocalHome().findAllDepositSlips();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depositSlipCol != null && depositSlipCol.size() > 0) {
                Iterator it = depositSlipCol.iterator();
                while (it.hasNext()) {
                    DepositSlipLocal depositSlipLocal = (DepositSlipLocal) it.next();
                    //-- get the primary key of the DepositSlip EJB object
                    Integer depositSlipCd = (Integer)depositSlipLocal.getPrimaryKey();
                    //-- get the value object for the DepositSlip EJB using the primary key
                    if (depositSlipCd != null) {
                        DepositSlipVO depositSlipVO = getDepositSlip(depositSlipCd);
                        //-- add the value object to the collection
                        list.add(depositSlipVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllDepositSlips() method from DepositSlipManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllDepositSlips() method from DepositSlipManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByBankAccountCd objects
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByBankAccountCd(Integer bankAccountCd) {
        try {
            //-- gets the local home interface and call the findByBankAccountCd method
            Collection depositSlipCol = getDepositSlipLocalHome().findByBankAccountCd(bankAccountCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depositSlipCol != null && depositSlipCol.size() > 0) {
                Iterator it = depositSlipCol.iterator();
                while (it.hasNext()) {
                    DepositSlipLocal depositSlipLocal = (DepositSlipLocal) it.next();
                    //-- get the primary key of the DepositSlip EJB object
                    Integer depositSlipCd = (Integer)depositSlipLocal.getPrimaryKey();
                    //-- get the value object for the DepositSlip EJB using the primary key
                    if (depositSlipCd != null) {
                        DepositSlipVO depositSlipVO = getDepositSlip(depositSlipCd);
                        //-- add the value object to the collection
                        list.add(depositSlipVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getDepositSlipByBankAccountCd() method from DepositSlipManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepositSlipByBankAccountCd() method from DepositSlipManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEmployeeId objects
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByEmployeeId(String employeeId) {
        try {
            //-- gets the local home interface and call the findByEmployeeId method
            Collection depositSlipCol = getDepositSlipLocalHome().findByEmployeeId(employeeId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depositSlipCol != null && depositSlipCol.size() > 0) {
                Iterator it = depositSlipCol.iterator();
                while (it.hasNext()) {
                    DepositSlipLocal depositSlipLocal = (DepositSlipLocal) it.next();
                    //-- get the primary key of the DepositSlip EJB object
                    Integer depositSlipCd = (Integer)depositSlipLocal.getPrimaryKey();
                    //-- get the value object for the DepositSlip EJB using the primary key
                    if (depositSlipCd != null) {
                        DepositSlipVO depositSlipVO = getDepositSlip(depositSlipCd);
                        //-- add the value object to the collection
                        list.add(depositSlipVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getDepositSlipByEmployeeId() method from DepositSlipManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepositSlipByEmployeeId() method from DepositSlipManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlipByEodId(Integer eodId) {
        try {
            //-- gets the local home interface and call the findByEodId method
            Collection depositSlipCol = getDepositSlipLocalHome().findByEodId(eodId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (depositSlipCol != null && depositSlipCol.size() > 0) {
                Iterator it = depositSlipCol.iterator();
                while (it.hasNext()) {
                    DepositSlipLocal depositSlipLocal = (DepositSlipLocal) it.next();
                    //-- get the primary key of the DepositSlip EJB object
                    Integer depositSlipCd = (Integer)depositSlipLocal.getPrimaryKey();
                    //-- get the value object for the DepositSlip EJB using the primary key
                    if (depositSlipCd != null) {
                        DepositSlipVO depositSlipVO = getDepositSlip(depositSlipCd);
                        //-- add the value object to the collection
                        list.add(depositSlipVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getDepositSlipByEodId() method from DepositSlipManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepositSlipByEodId() method from DepositSlipManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the DepositSlip local home interface
     */
    private DepositSlipLocalHome getDepositSlipLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (DepositSlipLocalHome) service.getEJBLocalHome(ServiceConstants.DEPOSITSLIP_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepositSlipLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the BankAcc local home interface
     */
    private BankAccLocalHome getBankAccLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (BankAccLocalHome) service.getEJBLocalHome(ServiceConstants.BANKACC_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankAccLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Employee local home interface
     */
    private EmployeeLocalHome getEmployeeLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (EmployeeLocalHome) service.getEJBLocalHome(ServiceConstants.EMPLOYEE_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
