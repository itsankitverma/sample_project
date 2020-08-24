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

public class FTC_ReceivablesController {

    /**
     * This method create new FTC_Receivables object
     * @param FTC_ReceivablesVO a value object the FTC_Receivables bean
     */
    public void setFTC_Receivables(FTC_ReceivablesVO FTC_receivablesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (FTC_receivablesVO == null) {
            throw new IllegalArgumentException("FTC_receivablesVO parameter was null in setFTC_Receivables() method from FTC_ReceivablesController class");
        }



        /*
            Jorge Quiroz Gonzalez. 2.1.2

         */
        try
        {
            Collection list = getFTC_ReceivablesReceivablesByAwbNbr( FTC_receivablesVO.getAwbNbr());

            // more then one record -> Y
            FTC_receivablesVO.setDupAwbFlg( (list.size() > 0) ? "Y": "");
            
           // if(list.size() >0)
           //    receivablesVO
        }
        catch(BusinessDelegateException be)
        {
        }

        try {
            getFTC_ReceivablesManager().setFTC_Receivables(FTC_receivablesVO);
        }
        catch (FTC_ReceivablesException ex) {
            String errorMsg = "Error occurred in setFTC_Receivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setFTC_Receivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a FTC_Receivables object
     * @return FTC_receivablesVO - a value object of the FTC_Receivables bean
     */
    public FTC_ReceivablesVO getFTC_Receivables(Integer recId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in getFTC_Receivables() method from FTC_ReceivablesController class");
        }


        try {
            return getFTC_ReceivablesManager().getFTC_Receivables(recId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getReceivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getReceivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllFTC_Receivables objects
     * @return java.util.Collection - a collection of the FTC Receivables objects
     */
    public Collection getAllFTC_Receivables()
        throws BusinessDelegateException {
        try {
            return getFTC_ReceivablesManager().getAllFTC_Receivables();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllFTC_Receivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findReceivablesByAwbNbr objects
     * @return java.util.Collection - a collection of the Receivables objects
     */
    public Collection getFTC_ReceivablesReceivablesByAwbNbr(String awbNbr)
        throws BusinessDelegateException {
        try {
            return getFTC_ReceivablesManager().getFTC_ReceivablesReceivablesByAwbNbr(awbNbr);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesReceivablesByAwbNbr() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return java.util.Collection - a collection of the Receivables objects
     */
    public Collection getFTC_ReceivablesByEodId(Integer eodId)
        throws BusinessDelegateException {
        try {
            return getFTC_ReceivablesManager().getFTC_ReceivablesByEodId(eodId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesByEodId() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Receivables object
     * @param recId - the Receivables bean primary key
     */
    public void removeFTC_Receivables(Integer recId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in removeFTC_Receivables() method from FTC_ReceivablesController class");
        }
        
        try {
            getFTC_ReceivablesManager().removeFTC_Receivables(recId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeFTC_Receivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeFTC_Receivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing FTC Receivables object
     * @param FTC_receivablesVO - the value object of the FTC Receivables bean
     */
    public void updateFTC_Receivables(FTC_ReceivablesVO FTC_receivablesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (FTC_receivablesVO == null) {
            throw new IllegalArgumentException("receivablesVO parameter was null in updateReceivables() method from ReceivablesController class");
        }
        
        try {
            getFTC_ReceivablesManager().updateFTC_Receivables(FTC_receivablesVO);
        }
        catch (FTC_ReceivablesException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateFTC_Receivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateFTC_Receivables() method from FTC_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the ReceivablesManager remote interface
     */
    public FTC_ReceivablesManager getFTC_ReceivablesManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            FTC_ReceivablesManagerHome FTC_receivablesManagerHome = (FTC_ReceivablesManagerHome)
            service.getEJBHome(ServiceConstants.FTC_RECEIVABLESMANAGER_JNDI, FTC_ReceivablesManagerHome.class);
            return FTC_receivablesManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
