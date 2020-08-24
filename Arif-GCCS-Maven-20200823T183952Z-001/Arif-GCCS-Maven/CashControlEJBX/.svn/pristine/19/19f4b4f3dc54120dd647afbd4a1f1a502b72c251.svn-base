/**
 * @(#)ReceivablesController.java			Tue Aug 02 15:38:53 VET 2005
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

public class ReceivablesController {

    /**
     * This method create new Receivables object
     * @param receivablesVO a value object the Receivables bean
     */
    public void setReceivables(ReceivablesVO receivablesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (receivablesVO == null) {
            throw new IllegalArgumentException("receivablesVO parameter was null in setReceivables() method from ReceivablesController class");
        }



        /*
            Jorge Quiroz Gonzalez. 2.1.2

         */
        try
        {
            Collection list = getReceivablesReceivablesByAwbNbr( receivablesVO.getAwbNbr());

            // more then one record -> Y
            receivablesVO.setDupAwbFlg( (list.size() > 0) ? "Y": "");
            
           // if(list.size() >0)
           //    receivablesVO
        }
        catch(BusinessDelegateException be)
        {
        }

        try {
            getReceivablesManager().setReceivables(receivablesVO);
        }
        catch (ReceivablesException ex) {
            String errorMsg = "Error occurred in setReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Receivables object
     * @return receivablesVO - a value object of the Receivables bean
     */
    public ReceivablesVO getReceivables(Integer recId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in getReceivables() method from ReceivablesController class");
        }


        try {
            return getReceivablesManager().getReceivables(recId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllReceivables objects
     * @return java.util.Collection - a collection of the Receivables objects
     */
    public Collection getAllReceivables()
        throws BusinessDelegateException {
        try {
            return getReceivablesManager().getAllReceivables();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findReceivablesByAwbNbr objects
     * @return java.util.Collection - a collection of the Receivables objects
     */
    public Collection getReceivablesReceivablesByAwbNbr(String awbNbr)
        throws BusinessDelegateException {
        try {
            return getReceivablesManager().getReceivablesReceivablesByAwbNbr(awbNbr);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getReceivablesReceivablesByAwbNbr() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return java.util.Collection - a collection of the Receivables objects
     */
    public Collection getReceivablesByEodId(Integer eodId)
        throws BusinessDelegateException {
        try {
            return getReceivablesManager().getReceivablesByEodId(eodId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getReceivablesByEodId() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Receivables object
     * @param recId - the Receivables bean primary key
     */
    public void removeReceivables(Integer recId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in removeReceivables() method from ReceivablesController class");
        }
        
        try {
            getReceivablesManager().removeReceivables(recId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Receivables object
     * @param receivablesVO - the value object of the Receivables bean
     */
    public void updateReceivables(ReceivablesVO receivablesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (receivablesVO == null) {
            throw new IllegalArgumentException("receivablesVO parameter was null in updateReceivables() method from ReceivablesController class");
        }
        
        try {
            getReceivablesManager().updateReceivables(receivablesVO);
        }
        catch (ReceivablesException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateReceivables() method from ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the ReceivablesManager remote interface
     */
    public ReceivablesManager getReceivablesManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            ReceivablesManagerHome receivablesManagerHome = (ReceivablesManagerHome)
            service.getEJBHome(ServiceConstants.RECEIVABLESMANAGER_JNDI, ReceivablesManagerHome.class);
            return receivablesManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getReceivablesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getReceivablesManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getReceivablesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
