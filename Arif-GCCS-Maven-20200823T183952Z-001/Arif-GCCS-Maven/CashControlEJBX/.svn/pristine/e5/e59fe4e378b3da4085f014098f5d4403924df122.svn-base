/**
 * @(#)PoaDetailManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class PoaDetailManagerBean implements SessionBean {

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
     * This method create new PoaDetail object
     * @param poaDetailVO a value object the PoaDetail bean
     */
    public void setPoaDetail(PoaDetailVO poaDetailVO)
        throws PoaDetailException {
        //-- we do not accept null value for the parameter.
        if (poaDetailVO == null) {
            throw new IllegalArgumentException("poaDetailVO parameter was null in setPoaDetail() method from PoaDetailManager class");
        }
        
        try {
            
            //-- create new PoaDetail object
            getPoaDetailLocalHome().create(
                poaDetailVO.getPoaPaymentsId(),
                poaDetailVO.getInvoiceNbr(),
                poaDetailVO.getAmount(),
                poaDetailVO.getCouponAmt(),
                poaDetailVO.getInvCurrency(),
                poaDetailVO.getExchRate());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setPoaDetail() method from PoaDetailManager class";
            throw new PoaDetailException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setPoaDetail() method from PoaDetailManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PoaDetail object
     * @return poaDetailVO - a value object of the PoaDetail bean
     */
    public PoaDetailVO getPoaDetail(Integer poaDetailId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (poaDetailId == null) {
            throw new IllegalArgumentException("poaDetailId parameter was null in getPoaDetail() method from PoaDetailManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            PoaDetailLocal poaDetailLocal = getPoaDetailLocalHome().findByPrimaryKey(poaDetailId);
            //-- create new value object to store the data
            PoaDetailVO poaDetailVO = new PoaDetailVO();
            //-- populate the new value object
            poaDetailVO.setPoaDetailId(poaDetailLocal.getPoaDetailId());
            poaDetailVO.setPoaPaymentsId(poaDetailLocal.getPoaPaymentsId());
            poaDetailVO.setInvoiceNbr(poaDetailLocal.getInvoiceNbr());
            poaDetailVO.setAmount(poaDetailLocal.getAmount());
            poaDetailVO.setCouponAmt(poaDetailLocal.getCouponAmt());
            poaDetailVO.setInvCurrency(poaDetailLocal.getInvCurrency());
            poaDetailVO.setExchRate(poaDetailLocal.getExchRate());
            return poaDetailVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPoaDetail() method from PoaDetailManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PoaDetail object
     * @param poaDetailId - the PoaDetail bean primary key
     */
    public void removePoaDetail(Integer poaDetailId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (poaDetailId == null) {
            throw new IllegalArgumentException("poaDetailId parameter was null in removePoaDetail() method from PoaDetailManager class");
        }
        
        try {
            getPoaDetailLocalHome().remove(poaDetailId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removePoaDetail() method from PoaDetailManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PoaDetail object
     * @param poaDetailVO - the value object of the PoaDetail bean
     */
    public void updatePoaDetail(PoaDetailVO poaDetailVO)
        throws PoaDetailException {
        //-- we do not accept null value for the parameter.
        if (poaDetailVO == null) {
            throw new IllegalArgumentException("poaDetailVO parameter was null in updatePoaDetail() method from PoaDetailManager class");
        }
        
        try {
            Integer poaDetailId = poaDetailVO.getPoaDetailId();
            
            PoaDetailLocal poaDetailLocal = getPoaDetailLocalHome().findByPrimaryKey(poaDetailId);
            //-- update PoaDetail entity bean
            poaDetailLocal.setPoaPaymentsId(poaDetailVO.getPoaPaymentsId());
            poaDetailLocal.setInvoiceNbr(poaDetailVO.getInvoiceNbr());
            poaDetailLocal.setAmount(poaDetailVO.getAmount());
            poaDetailLocal.setCouponAmt(poaDetailVO.getCouponAmt());
            poaDetailLocal.setInvCurrency(poaDetailVO.getInvCurrency());
            poaDetailLocal.setExchRate(poaDetailVO.getExchRate());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updatePoaDetail() method from PoaDetailManager class";
            throw new PoaDetailException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updatePoaDetail() method from PoaDetailManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPoaDetails objects
     * @return Collection - a collection of the PoaDetail objects
     */
    public Collection getAllPoaDetails() {
        try {
            //-- gets the local home interface and call the findAllPoaDetails method
            Collection poaDetailCol = getPoaDetailLocalHome().findAllPoaDetails();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (poaDetailCol != null && poaDetailCol.size() > 0) {
                Iterator it = poaDetailCol.iterator();
                while (it.hasNext()) {
                    PoaDetailLocal poaDetailLocal = (PoaDetailLocal) it.next();
                    //-- get the primary key of the PoaDetail EJB object
                    Integer poaDetailId = (Integer)poaDetailLocal.getPrimaryKey();
                    //-- get the value object for the PoaDetail EJB using the primary key
                    if (poaDetailId != null) {
                        PoaDetailVO poaDetailVO = getPoaDetail(poaDetailId);
                        //-- add the value object to the collection
                        list.add(poaDetailVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllPoaDetails() method from PoaDetailManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllPoaDetails() method from PoaDetailManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findPoaDetails objects
     * @return Collection - a collection of the PoaDetail objects
     */
    public Collection getPoaDetailPoaDetails(int poaPaymentsId) {
        try {
            //-- gets the local home interface and call the findPoaDetails method
            Collection poaDetailCol = getPoaDetailLocalHome().findPoaDetails(poaPaymentsId);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (poaDetailCol != null && poaDetailCol.size() > 0) {
                Iterator it = poaDetailCol.iterator();
                while (it.hasNext()) {
                    PoaDetailLocal poaDetailLocal = (PoaDetailLocal) it.next();
                    //-- get the primary key of the PoaDetail EJB object
                    Integer poaDetailId = (Integer)poaDetailLocal.getPrimaryKey();
                    //-- get the value object for the PoaDetail EJB using the primary key
                    if (poaDetailId != null) {
                        PoaDetailVO poaDetailVO = getPoaDetail(poaDetailId);
                        //-- add the value object to the collection
                        list.add(poaDetailVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getPoaDetailPoaDetails() method from PoaDetailManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getPoaDetailPoaDetails() method from PoaDetailManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the PoaDetail local home interface
     */
    private PoaDetailLocalHome getPoaDetailLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PoaDetailLocalHome) service.getEJBLocalHome(ServiceConstants.POADETAIL_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPoaDetailLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
