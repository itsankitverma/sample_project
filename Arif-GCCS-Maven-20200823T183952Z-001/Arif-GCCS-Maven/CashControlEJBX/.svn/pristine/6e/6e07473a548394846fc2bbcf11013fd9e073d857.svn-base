/**
 * @(#)BankAccManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class BankAccManagerBean implements SessionBean {

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
     * This method create new BankAcc object
     * @param bankAccVO a value object the BankAcc bean
     */
    public void setBankAcc(BankAccVO bankAccVO)
        throws BankAccException {
        //-- we do not accept null value for the parameter.
        if (bankAccVO == null) {
            throw new IllegalArgumentException("bankAccVO parameter was null in setBankAcc() method from BankAccManager class");
        }
        
        try {
            //-- get Bank local interface
            Integer bankId = bankAccVO.getBankId();
            BankLocal bankLocal = null;
            if (bankId != null) {
                bankLocal = getBankLocalHome().findByPrimaryKey(bankId);
            }
            
            //-- create new BankAcc object
            getBankAccLocalHome().create(
                bankAccVO.getAccountNbr(),
                bankAccVO.getBankBranchId(),
                bankAccVO.getCurrencyType(),
                bankLocal,
                bankAccVO.getOriginationNbr());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in find the requested object to create in setBankAcc() method from BankAccManager class";
            throw new BankAccException(errorMsg, ex);
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setBankAcc() method from BankAccManager class";
            throw new BankAccException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setBankAcc() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a BankAcc object
     * @return bankAccVO - a value object of the BankAcc bean
     */
    public BankAccVO getBankAcc(Integer bankAccountCd)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in getBankAcc() method from BankAccManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            BankAccLocal bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            //-- create new value object to store the data
            BankAccVO bankAccVO = new BankAccVO();
            //-- populate the new value object
            bankAccVO.setBankAccountCd(bankAccLocal.getBankAccountCd());
            bankAccVO.setAccountNbr(bankAccLocal.getAccountNbr());
            bankAccVO.setBankBranchId(bankAccLocal.getBankBranchId());
            bankAccVO.setCurrencyType(bankAccLocal.getCurrencyType());
            bankAccVO.setOriginationNbr(bankAccLocal.getOriginationNbr());
            //-- get the primary key of the Bank object from the local interface
            BankLocal bankLocal = bankAccLocal.getBank();
            if (bankLocal != null) {
                Integer bankId = (Integer) bankLocal.getPrimaryKey();
                bankAccVO.setBankId(bankId);
            }
            return bankAccVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getBankAcc() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets DepositSlip objects from the BankAcc object
     * @return Collection - a collection of the DepositSlip objects
     */
    public Collection getDepositSlips(Integer bankAccountCd)
        throws BankAccException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in getDepositSlips() method from BankAccManager class");
        }
        
        try {
            BankAccLocal bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            Set depositSlipCol = bankAccLocal.getDepositSlips();
            Collection list = new ArrayList();
            if (depositSlipCol != null) {
                Iterator it = depositSlipCol.iterator();
                while (it.hasNext()) {
                    DepositSlipLocal depositSlipLocal = (DepositSlipLocal) it.next();
                    Integer depositSlipCd = (Integer)depositSlipLocal.getPrimaryKey();
                    DepositSlipVO depositSlipVO = getDepositSlipManager().getDepositSlip(depositSlipCd);
                    list.add(depositSlipVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getDepositSlips() method from BankAccManager class";
            throw new BankAccException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getDepositSlips() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method adds the Location object to the BankAcc object
     * @param bankAccountCd a primary key of BankAcc object
     * @param locationCd a primary key of Location object
     */
    public void addLocation(Integer bankAccountCd, String locationCd)
        throws BankAccException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in addLocation() method from BankAccManager class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in addLocation() method from BankAccManager class");
        }
        
        try {
            BankAccLocal bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            bankAccLocal.addLocation(locationLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in addLocation() method from BankAccManager class";
            throw new BankAccException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in addLocation() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes the Location object to the BankAcc object
     * @param bankAccountCd a primary key of BankAcc object
     * @param locationCd a primary key of Location object
     */
    public void removeLocation(Integer bankAccountCd, String locationCd)
        throws BankAccException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in removeLocation() method from BankAccManager class");
        }
        
        if (locationCd == null) {
            throw new IllegalArgumentException("locationCd parameter was null in removeLocation() method from BankAccManager class");
        }
        
        try {
            BankAccLocal bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            LocationLocal locationLocal = getLocationLocalHome().findByPrimaryKey(locationCd);
            bankAccLocal.removeLocation(locationLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in removeLocation() method from BankAccManager class";
            throw new BankAccException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeLocation() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets Location objects from the BankAcc object
     * @return Collection - a collection of the Location objects
     */
    public Collection getLocations(Integer bankAccountCd)
        throws BankAccException {
        //-- we do not accept null values for any parameters.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in getLocations() method from BankAccManager class");
        }
        
        try {
            BankAccLocal bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            Set locationCol = bankAccLocal.getLocations();
            Collection list = new ArrayList();
            if (locationCol != null) {
                Iterator it = locationCol.iterator();
                while (it.hasNext()) {
                    LocationLocal locationLocal = (LocationLocal) it.next();
                    String locationCd = (String)locationLocal.getPrimaryKey();
                    LocationVO locationVO = getLocationManager().getLocation(locationCd);
                    list.add(locationVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getLocations() method from BankAccManager class";
            throw new BankAccException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getLocations() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing BankAcc object
     * @param bankAccountCd - the BankAcc bean primary key
     */
    public void removeBankAcc(Integer bankAccountCd)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (bankAccountCd == null) {
            throw new IllegalArgumentException("bankAccountCd parameter was null in removeBankAcc() method from BankAccManager class");
        }
        
        try {
            getBankAccLocalHome().remove(bankAccountCd);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeBankAcc() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing BankAcc object
     * @param bankAccVO - the value object of the BankAcc bean
     */
    public void updateBankAcc(BankAccVO bankAccVO)
        throws BankAccException {
        //-- we do not accept null value for the parameter.
        if (bankAccVO == null) {
            throw new IllegalArgumentException("bankAccVO parameter was null in updateBankAcc() method from BankAccManager class");
        }
        
        try {
            Integer bankAccountCd = bankAccVO.getBankAccountCd();
            
            BankAccLocal bankAccLocal = getBankAccLocalHome().findByPrimaryKey(bankAccountCd);
            //-- update BankAcc entity bean
            bankAccLocal.setAccountNbr(bankAccVO.getAccountNbr());
            bankAccLocal.setBankBranchId(bankAccVO.getBankBranchId());
            bankAccLocal.setCurrencyType(bankAccVO.getCurrencyType());
            bankAccLocal.setOriginationNbr(bankAccVO.getOriginationNbr());
            //-- get bank local interface and update BankAcc entity bean
            //-- depending on your business need...you may have to remove the if statement
            Integer bankId = bankAccVO.getBankId();
            BankLocal bankLocal = null;
            if (bankId != null) {
                bankLocal = getBankLocalHome().findByPrimaryKey(bankId);
            }
            bankAccLocal.setBank(bankLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateBankAcc() method from BankAccManager class";
            throw new BankAccException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateBankAcc() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllBankAccs objects
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getAllBankAccs() {
        try {
            //-- gets the local home interface and call the findAllBankAccs method
            Collection bankAccCol = getBankAccLocalHome().findAllBankAccs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (bankAccCol != null && bankAccCol.size() > 0) {
                Iterator it = bankAccCol.iterator();
                while (it.hasNext()) {
                    BankAccLocal bankAccLocal = (BankAccLocal) it.next();
                    //-- get the primary key of the BankAcc EJB object
                    Integer bankAccountCd = (Integer)bankAccLocal.getPrimaryKey();
                    //-- get the value object for the BankAcc EJB using the primary key
                    if (bankAccountCd != null) {
                        BankAccVO bankAccVO = getBankAcc(bankAccountCd);
                        //-- add the value object to the collection
                        list.add(bankAccVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllBankAccs() method from BankAccManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllBankAccs() method from BankAccManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByBankId objects
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccByBankId(Integer bankId) {
        try {
            //-- gets the local home interface and call the findByBankId method
            Collection bankAccCol = getBankAccLocalHome().findByBankId(bankId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (bankAccCol != null && bankAccCol.size() > 0) {
                Iterator it = bankAccCol.iterator();
                while (it.hasNext()) {
                    BankAccLocal bankAccLocal = (BankAccLocal) it.next();
                    //-- get the primary key of the BankAcc EJB object
                    Integer bankAccountCd = (Integer)bankAccLocal.getPrimaryKey();
                    //-- get the value object for the BankAcc EJB using the primary key
                    if (bankAccountCd != null) {
                        BankAccVO bankAccVO = getBankAcc(bankAccountCd);
                        //-- add the value object to the collection
                        list.add(bankAccVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getBankAccByBankId() method from BankAccManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getBankAccByBankId() method from BankAccManager class";
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
     * This methods gets the Bank local home interface
     */
    private BankLocalHome getBankLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (BankLocalHome) service.getEJBLocalHome(ServiceConstants.BANK_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Location local home interface
     */
    private LocationLocalHome getLocationLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (LocationLocalHome) service.getEJBLocalHome(ServiceConstants.LOCATION_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the DepositSlipManager remote interface
     */
    public DepositSlipManager getDepositSlipManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            DepositSlipManagerHome depositSlipManagerHome = (DepositSlipManagerHome)
            service.getEJBHome(ServiceConstants.DEPOSITSLIPMANAGER_REMOTE_JNDI, DepositSlipManagerHome.class);
            return depositSlipManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getDepositSlipManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the LocationManager remote interface
     */
    public LocationManager getLocationManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            LocationManagerHome locationManagerHome = (LocationManagerHome)
            service.getEJBHome(ServiceConstants.LOCATIONMANAGER_REMOTE_JNDI, LocationManagerHome.class);
            return locationManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getLocationManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
