/**
 * @(#)ChkinAgtCommentManagerBean.java			Tue Aug 02 15:38:51 VET 2005
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

public class ChkinAgtCommentManagerBean implements SessionBean {

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
     * This method create new ChkinAgtComment object
     * @param chkinAgtCommentVO a value object the ChkinAgtComment bean
     */
    public void setChkinAgtComment(ChkinAgtCommentVO chkinAgtCommentVO)
        throws ChkinAgtCommentException {
        //-- we do not accept null value for the parameter.
        if (chkinAgtCommentVO == null) {
            throw new IllegalArgumentException("chkinAgtCommentVO parameter was null in setChkinAgtComment() method from ChkinAgtCommentManager class");
        }
        
        try {
            
            //-- create new ChkinAgtComment object
            getChkinAgtCommentLocalHome().create(
                chkinAgtCommentVO.getCommentCd(),
                chkinAgtCommentVO.getCommentDesc(),
                chkinAgtCommentVO.getApplyTo(),
                chkinAgtCommentVO.getStatus());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setChkinAgtComment() method from ChkinAgtCommentManager class";
            throw new ChkinAgtCommentException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setChkinAgtComment() method from ChkinAgtCommentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a ChkinAgtComment object
     * @return chkinAgtCommentVO - a value object of the ChkinAgtComment bean
     */
    public ChkinAgtCommentVO getChkinAgtComment(Integer commentId)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (commentId == null) {
            throw new IllegalArgumentException("commentId parameter was null in getChkinAgtComment() method from ChkinAgtCommentManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            ChkinAgtCommentLocal chkinAgtCommentLocal = getChkinAgtCommentLocalHome().findByPrimaryKey(commentId);
            //-- create new value object to store the data
            ChkinAgtCommentVO chkinAgtCommentVO = new ChkinAgtCommentVO();
            //-- populate the new value object
            chkinAgtCommentVO.setCommentId(chkinAgtCommentLocal.getCommentId());
            chkinAgtCommentVO.setCommentCd(chkinAgtCommentLocal.getCommentCd());
            chkinAgtCommentVO.setCommentDesc(chkinAgtCommentLocal.getCommentDesc());
            chkinAgtCommentVO.setApplyTo(chkinAgtCommentLocal.getApplyTo());
            chkinAgtCommentVO.setStatus(chkinAgtCommentLocal.getStatus());
            return chkinAgtCommentVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getChkinAgtComment() method from ChkinAgtCommentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing ChkinAgtComment object
     * @param commentId - the ChkinAgtComment bean primary key
     */
    public void removeChkinAgtComment(Integer commentId)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (commentId == null) {
            throw new IllegalArgumentException("commentId parameter was null in removeChkinAgtComment() method from ChkinAgtCommentManager class");
        }
        
        try {
            getChkinAgtCommentLocalHome().remove(commentId);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeChkinAgtComment() method from ChkinAgtCommentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing ChkinAgtComment object
     * @param chkinAgtCommentVO - the value object of the ChkinAgtComment bean
     */
    public void updateChkinAgtComment(ChkinAgtCommentVO chkinAgtCommentVO)
        throws ChkinAgtCommentException {
        //-- we do not accept null value for the parameter.
        if (chkinAgtCommentVO == null) {
            throw new IllegalArgumentException("chkinAgtCommentVO parameter was null in updateChkinAgtComment() method from ChkinAgtCommentManager class");
        }
        
        try {
            Integer commentId = chkinAgtCommentVO.getCommentId();
            
            ChkinAgtCommentLocal chkinAgtCommentLocal = getChkinAgtCommentLocalHome().findByPrimaryKey(commentId);
            //-- update ChkinAgtComment entity bean
            chkinAgtCommentLocal.setCommentCd(chkinAgtCommentVO.getCommentCd());
            chkinAgtCommentLocal.setCommentDesc(chkinAgtCommentVO.getCommentDesc());
            chkinAgtCommentLocal.setApplyTo(chkinAgtCommentVO.getApplyTo());
            chkinAgtCommentLocal.setStatus(chkinAgtCommentVO.getStatus());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateChkinAgtComment() method from ChkinAgtCommentManager class";
            throw new ChkinAgtCommentException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateChkinAgtComment() method from ChkinAgtCommentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllChkinAgtComments objects
     * @return Collection - a collection of the ChkinAgtComment objects
     */
    public Collection getAllChkinAgtComments() {
        try {
            //-- gets the local home interface and call the findAllChkinAgtComments method
            Collection chkinAgtCommentCol = getChkinAgtCommentLocalHome().findAllChkinAgtComments();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (chkinAgtCommentCol != null && chkinAgtCommentCol.size() > 0) {
                Iterator it = chkinAgtCommentCol.iterator();
                while (it.hasNext()) {
                    ChkinAgtCommentLocal chkinAgtCommentLocal = (ChkinAgtCommentLocal) it.next();
                    //-- get the primary key of the ChkinAgtComment EJB object
                    Integer commentId = (Integer)chkinAgtCommentLocal.getPrimaryKey();
                    //-- get the value object for the ChkinAgtComment EJB using the primary key
                    if (commentId != null) {
                        ChkinAgtCommentVO chkinAgtCommentVO = getChkinAgtComment(commentId);
                        //-- add the value object to the collection
                        list.add(chkinAgtCommentVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllChkinAgtComments() method from ChkinAgtCommentManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllChkinAgtComments() method from ChkinAgtCommentManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the ChkinAgtComment local home interface
     */
    private ChkinAgtCommentLocalHome getChkinAgtCommentLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (ChkinAgtCommentLocalHome) service.getEJBLocalHome(ServiceConstants.CHKINAGTCOMMENT_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getChkinAgtCommentLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
