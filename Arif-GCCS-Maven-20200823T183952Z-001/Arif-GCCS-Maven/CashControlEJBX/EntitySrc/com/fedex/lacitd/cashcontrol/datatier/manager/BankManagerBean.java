/**
 * @(#)BankManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class BankManagerBean implements SessionBean {

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
     * This method create new Bank object
     * @param bankVO a value object the Bank bean
     */
    public void setBank(BankVO bankVO)
        throws BankException {
        //-- we do not accept null value for the parameter.
        if (bankVO == null) {
            throw new IllegalArgumentException("bankVO parameter was null in setBank() method from BankManager class");
        }
        
        try {
            //-- get Country local interface
            String countryCd = bankVO.getCountryCd();
            CountryLocal countryLocal = null;
            if (countryCd != null) {
                countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            }
            
            //-- create new Bank object
            getBankLocalHome().create(
                bankVO.getBankNm(),
                bankVO.getBankCd(),
                bankVO.getBankShtDesc(),
                countryLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in find the requested object to create in setBank() method from BankManager class";
            throw new BankException(errorMsg, ex);
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setBank() method from BankManager class";
            throw new BankException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setBank() method from BankManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Bank object
     * @return bankVO - a value object of the Bank bean
     */
    public BankVO getBank(Integer bankId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (bankId == null) {
            throw new IllegalArgumentException("bankId parameter was null in getBank() method from BankManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            BankLocal bankLocal = getBankLocalHome().findByPrimaryKey(bankId);
            //-- create new value object to store the data
            BankVO bankVO = new BankVO();
            //-- populate the new value object
            bankVO.setBankId(bankLocal.getBankId());
            bankVO.setBankNm(bankLocal.getBankNm());
            bankVO.setBankCd(bankLocal.getBankCd());
            bankVO.setBankShtDesc(bankLocal.getBankShtDesc());
            //-- get the primary key of the Country object from the local interface
            CountryLocal countryLocal = bankLocal.getCountry();
            if (countryLocal != null) {
                String countryCd = (String) countryLocal.getPrimaryKey();
                bankVO.setCountryCd(countryCd);
            }
            return bankVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getBank() method from BankManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets BankAcc objects from the Bank object
     * @return Collection - a collection of the BankAcc objects
     */
    public Collection getBankAccs(Integer bankId)
        throws BankException {
        //-- we do not accept null values for any parameters.
        if (bankId == null) {
            throw new IllegalArgumentException("bankId parameter was null in getBankAccs() method from BankManager class");
        }
        
        try {
            BankLocal bankLocal = getBankLocalHome().findByPrimaryKey(bankId);
            Set bankAccCol = bankLocal.getBankAccs();
            Collection list = new ArrayList();
            if (bankAccCol != null) {
                Iterator it = bankAccCol.iterator();
                while (it.hasNext()) {
                    BankAccLocal bankAccLocal = (BankAccLocal) it.next();
                    Integer bankAccountCd = (Integer)bankAccLocal.getPrimaryKey();
                    BankAccVO bankAccVO = getBankAccManager().getBankAcc(bankAccountCd);
                    list.add(bankAccVO);
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getBankAccs() method from BankManager class";
            throw new BankException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getBankAccs() method from BankManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Bank object
     * @param bankId - the Bank bean primary key
     */
    public void removeBank(Integer bankId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (bankId == null) {
            throw new IllegalArgumentException("bankId parameter was null in removeBank() method from BankManager class");
        }
        
        try {
            getBankLocalHome().remove(bankId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeBank() method from BankManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Bank object
     * @param bankVO - the value object of the Bank bean
     */
    public void updateBank(BankVO bankVO)
        throws BankException {
        //-- we do not accept null value for the parameter.
        if (bankVO == null) {
            throw new IllegalArgumentException("bankVO parameter was null in updateBank() method from BankManager class");
        }
        
        try {
            Integer bankId = bankVO.getBankId();
            
            BankLocal bankLocal = getBankLocalHome().findByPrimaryKey(bankId);
            //-- update Bank entity bean
            bankLocal.setBankNm(bankVO.getBankNm());
            bankLocal.setBankCd(bankVO.getBankCd());
            bankLocal.setBankShtDesc(bankVO.getBankShtDesc());
            //-- get country local interface and update Bank entity bean
            //-- depending on your business need...you may have to remove the if statement
            String countryCd = bankVO.getCountryCd();
            CountryLocal countryLocal = null;
            if (countryCd != null) {
                countryLocal = getCountryLocalHome().findByPrimaryKey(countryCd);
            }
            bankLocal.setCountry(countryLocal);
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateBank() method from BankManager class";
            throw new BankException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateBank() method from BankManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllBanks objects
     * @return Collection - a collection of the Bank objects
     */
    public Collection getAllBanks() {
        try {
            //-- gets the local home interface and call the findAllBanks method
            Collection bankCol = getBankLocalHome().findAllBanks();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (bankCol != null && bankCol.size() > 0) {
                Iterator it = bankCol.iterator();
                while (it.hasNext()) {
                    BankLocal bankLocal = (BankLocal) it.next();
                    //-- get the primary key of the Bank EJB object
                    Integer bankId = (Integer)bankLocal.getPrimaryKey();
                    //-- get the value object for the Bank EJB using the primary key
                    if (bankId != null) {
                        BankVO bankVO = getBank(bankId);
                        //-- add the value object to the collection
                        list.add(bankVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllBanks() method from BankManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllBanks() method from BankManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByCountryCd objects
     * @return Collection - a collection of the Bank objects
     */
    public Collection getBankByCountryCd(String countryCd) {
        try {
            //-- gets the local home interface and call the findByCountryCd method
            Collection bankCol = getBankLocalHome().findByCountryCd(countryCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (bankCol != null && bankCol.size() > 0) {
                Iterator it = bankCol.iterator();
                while (it.hasNext()) {
                    BankLocal bankLocal = (BankLocal) it.next();
                    //-- get the primary key of the Bank EJB object
                    Integer bankId = (Integer)bankLocal.getPrimaryKey();
                    //-- get the value object for the Bank EJB using the primary key
                    if (bankId != null) {
                        BankVO bankVO = getBank(bankId);
                        //-- add the value object to the collection
                        list.add(bankVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getBankByCountryCd() method from BankManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getBankByCountryCd() method from BankManager class";
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
     * This methods gets the Country local home interface
     */
    private CountryLocalHome getCountryLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (CountryLocalHome) service.getEJBLocalHome(ServiceConstants.COUNTRY_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCountryLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets the BankAccManager remote interface
     */
    public BankAccManager getBankAccManager() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            BankAccManagerHome bankAccManagerHome = (BankAccManagerHome)
            service.getEJBHome(ServiceConstants.BANKACCMANAGER_REMOTE_JNDI, BankAccManagerHome.class);
            return bankAccManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when lookup the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when create an instance of the remote interface";
            throw new EJBException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getBankAccManager() method when lookup the remote interface ";
            throw new EJBException(errorMsg, ex);
        }
    }

}
