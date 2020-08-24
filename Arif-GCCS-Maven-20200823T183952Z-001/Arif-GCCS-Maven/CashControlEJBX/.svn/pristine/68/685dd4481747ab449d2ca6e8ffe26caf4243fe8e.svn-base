/**
 * @(#)ChkinAgtCommentController.java			Tue Aug 02 15:38:53 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.controller;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.manager.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.*;

public class ChkinAgtCommentController {

    /**
     * This method create new ChkinAgtComment object
     * @param chkinAgtCommentVO a value object the ChkinAgtComment bean
     */
    public void setChkinAgtComment(ChkinAgtCommentVO chkinAgtCommentVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (chkinAgtCommentVO == null) {
            throw new IllegalArgumentException("chkinAgtCommentVO parameter was null in setChkinAgtComment() method from ChkinAgtCommentController class");
        }
        
        try {
            getChkinAgtCommentManager().setChkinAgtComment(chkinAgtCommentVO);
        }
        catch (ChkinAgtCommentException ex) {
            String errorMsg = "Error occurred in setChkinAgtComment() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setChkinAgtComment() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a ChkinAgtComment object
     * @return chkinAgtCommentVO - a value object of the ChkinAgtComment bean
     */
    public ChkinAgtCommentVO getChkinAgtComment(Integer commentId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (commentId == null) {
            throw new IllegalArgumentException("commentId parameter was null in getChkinAgtComment() method from ChkinAgtCommentController class");
        }
        
        try {
            return getChkinAgtCommentManager().getChkinAgtComment(commentId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getChkinAgtComment() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getChkinAgtComment() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllChkinAgtComments objects
     * @return java.util.Collection - a collection of the ChkinAgtComment objects
     */
    public Collection getAllChkinAgtComments()
        throws BusinessDelegateException {
        try {
            return getChkinAgtCommentManager().getAllChkinAgtComments();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllChkinAgtComments() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing ChkinAgtComment object
     * @param commentId - the ChkinAgtComment bean primary key
     */
    public void removeChkinAgtComment(Integer commentId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (commentId == null) {
            throw new IllegalArgumentException("commentId parameter was null in removeChkinAgtComment() method from ChkinAgtCommentController class");
        }
        
        try {
            getChkinAgtCommentManager().removeChkinAgtComment(commentId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeChkinAgtComment() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeChkinAgtComment() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing ChkinAgtComment object
     * @param chkinAgtCommentVO - the value object of the ChkinAgtComment bean
     */
    public void updateChkinAgtComment(ChkinAgtCommentVO chkinAgtCommentVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (chkinAgtCommentVO == null) {
            throw new IllegalArgumentException("chkinAgtCommentVO parameter was null in updateChkinAgtComment() method from ChkinAgtCommentController class");
        }
        
        try {
            getChkinAgtCommentManager().updateChkinAgtComment(chkinAgtCommentVO);
        }
        catch (ChkinAgtCommentException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateChkinAgtComment() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateChkinAgtComment() method from ChkinAgtCommentController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the ChkinAgtCommentManager remote interface
     */
    public ChkinAgtCommentManager getChkinAgtCommentManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            ChkinAgtCommentManagerHome chkinAgtCommentManagerHome = (ChkinAgtCommentManagerHome)
            service.getEJBHome(ServiceConstants.CHKINAGTCOMMENTMANAGER_JNDI, ChkinAgtCommentManagerHome.class);
            return chkinAgtCommentManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getChkinAgtCommentManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getChkinAgtCommentManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getChkinAgtCommentManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
