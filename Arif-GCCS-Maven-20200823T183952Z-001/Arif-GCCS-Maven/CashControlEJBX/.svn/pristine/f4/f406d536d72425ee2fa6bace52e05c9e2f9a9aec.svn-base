/**
 * @(#)InCageExceptionsManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class InCageExceptionsManagerBean implements SessionBean {

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
     * This method create new InCageExceptions object
     * @param inCageExceptionsVO a value object the InCageExceptions bean
     */
    public void setInCageExceptions(InCageExceptionsVO inCageExceptionsVO)
        throws InCageExceptionsException {
        //-- we do not accept null value for the parameter.
        if (inCageExceptionsVO == null) {
            throw new IllegalArgumentException("inCageExceptionsVO parameter was null in setInCageExceptions() method from InCageExceptionsManager class");
        }
        
        try {
            
            //-- create new InCageExceptions object
            getInCageExceptionsLocalHome().create(
                inCageExceptionsVO.getLocationCd(),
                inCageExceptionsVO.getReportDt(),
                inCageExceptionsVO.getAwbNbr(),
                inCageExceptionsVO.getLastDexEmpId(),
                inCageExceptionsVO.getLastStat44EmpId(),
                inCageExceptionsVO.getDescription());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setInCageExceptions() method from InCageExceptionsManager class";
            throw new InCageExceptionsException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setInCageExceptions() method from InCageExceptionsManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a InCageExceptions object
     * @return inCageExceptionsVO - a value object of the InCageExceptions bean
     */
    public InCageExceptionsVO getInCageExceptions(Integer inCageExcpId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (inCageExcpId == null) {
            throw new IllegalArgumentException("inCageExcpId parameter was null in getInCageExceptions() method from InCageExceptionsManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            InCageExceptionsLocal inCageExceptionsLocal = getInCageExceptionsLocalHome().findByPrimaryKey(inCageExcpId);
            //-- create new value object to store the data
            InCageExceptionsVO inCageExceptionsVO = new InCageExceptionsVO();
            //-- populate the new value object
            inCageExceptionsVO.setInCageExcpId(inCageExceptionsLocal.getInCageExcpId());
            inCageExceptionsVO.setLocationCd(inCageExceptionsLocal.getLocationCd());
            inCageExceptionsVO.setReportDt(inCageExceptionsLocal.getReportDt());
            inCageExceptionsVO.setAwbNbr(inCageExceptionsLocal.getAwbNbr());
            inCageExceptionsVO.setLastDexEmpId(inCageExceptionsLocal.getLastDexEmpId());
            inCageExceptionsVO.setLastStat44EmpId(inCageExceptionsLocal.getLastStat44EmpId());
            inCageExceptionsVO.setDescription(inCageExceptionsLocal.getDescription());
            return inCageExceptionsVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getInCageExceptions() method from InCageExceptionsManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing InCageExceptions object
     * @param inCageExcpId - the InCageExceptions bean primary key
     */
    public void removeInCageExceptions(Integer inCageExcpId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (inCageExcpId == null) {
            throw new IllegalArgumentException("inCageExcpId parameter was null in removeInCageExceptions() method from InCageExceptionsManager class");
        }
        
        try {
            getInCageExceptionsLocalHome().remove(inCageExcpId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeInCageExceptions() method from InCageExceptionsManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing InCageExceptions object
     * @param inCageExceptionsVO - the value object of the InCageExceptions bean
     */
    public void updateInCageExceptions(InCageExceptionsVO inCageExceptionsVO)
        throws InCageExceptionsException {
        //-- we do not accept null value for the parameter.
        if (inCageExceptionsVO == null) {
            throw new IllegalArgumentException("inCageExceptionsVO parameter was null in updateInCageExceptions() method from InCageExceptionsManager class");
        }
        
        try {
            Integer inCageExcpId = inCageExceptionsVO.getInCageExcpId();
            
            InCageExceptionsLocal inCageExceptionsLocal = getInCageExceptionsLocalHome().findByPrimaryKey(inCageExcpId);
            //-- update InCageExceptions entity bean
            inCageExceptionsLocal.setLocationCd(inCageExceptionsVO.getLocationCd());
            inCageExceptionsLocal.setReportDt(inCageExceptionsVO.getReportDt());
            inCageExceptionsLocal.setAwbNbr(inCageExceptionsVO.getAwbNbr());
            inCageExceptionsLocal.setLastDexEmpId(inCageExceptionsVO.getLastDexEmpId());
            inCageExceptionsLocal.setLastStat44EmpId(inCageExceptionsVO.getLastStat44EmpId());
            inCageExceptionsLocal.setDescription(inCageExceptionsVO.getDescription());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateInCageExceptions() method from InCageExceptionsManager class";
            throw new InCageExceptionsException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateInCageExceptions() method from InCageExceptionsManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllInCageExceptions objects
     * @return Collection - a collection of the InCageExceptions objects
     */
    public Collection getAllInCageExceptions() {
        try {
            //-- gets the local home interface and call the findAllInCageExceptions method
            Collection inCageExceptionsCol = getInCageExceptionsLocalHome().findAllInCageExceptions();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (inCageExceptionsCol != null && inCageExceptionsCol.size() > 0) {
                Iterator it = inCageExceptionsCol.iterator();
                while (it.hasNext()) {
                    InCageExceptionsLocal inCageExceptionsLocal = (InCageExceptionsLocal) it.next();
                    //-- get the primary key of the InCageExceptions EJB object
                    Integer inCageExcpId = (Integer)inCageExceptionsLocal.getPrimaryKey();
                    //-- get the value object for the InCageExceptions EJB using the primary key
                    if (inCageExcpId != null) {
                        InCageExceptionsVO inCageExceptionsVO = getInCageExceptions(inCageExcpId);
                        //-- add the value object to the collection
                        list.add(inCageExceptionsVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllInCageExceptions() method from InCageExceptionsManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllInCageExceptions() method from InCageExceptionsManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the InCageExceptions local home interface
     */
    private InCageExceptionsLocalHome getInCageExceptionsLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (InCageExceptionsLocalHome) service.getEJBLocalHome(ServiceConstants.INCAGEEXCEPTIONS_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getInCageExceptionsLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
