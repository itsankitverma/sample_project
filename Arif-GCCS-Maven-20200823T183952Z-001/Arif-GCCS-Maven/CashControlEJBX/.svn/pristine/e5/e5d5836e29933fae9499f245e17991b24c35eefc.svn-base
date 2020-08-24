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

public class COD_ReceivablesController {

    /**
     * This method create new COD_Receivables object
     * @param COD_ReceivablesVO a value object the COD_Receivables bean
     */
    public void setCOD_Receivables(COD_ReceivablesVO COD_receivablesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (COD_receivablesVO == null) {
            throw new IllegalArgumentException("COD_receivablesVO parameter was null in setCOD_Receivables() method from COD_ReceivablesController class");
        }



        /*
            Jorge Quiroz Gonzalez. 2.1.2

         */
        try
        {
            Collection list = getCOD_ReceivablesReceivablesByAwbNbr( COD_receivablesVO.getAwbNbr());

            // more then one record -> Y
            COD_receivablesVO.setDupAwbFlg( (list.size() > 0) ? "Y": "");
            
           // if(list.size() >0)
           //    receivablesVO
        }
        catch(BusinessDelegateException be)
        {
        	String errorMsg = "Error occurred in setCOD_Receivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, be);
        }

        try {
            getCOD_ReceivablesManager().setCOD_Receivables(COD_receivablesVO);
        }
        catch (COD_ReceivablesException ex) {
            String errorMsg = "Error occurred in setCOD_Receivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setCOD_Receivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a COD_Receivables object
     * @return COD_receivablesVO - a value object of the COD_Receivables bean
     */
    public COD_ReceivablesVO getCOD_Receivables(Integer recId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in getCOD_Receivables() method from COD_ReceivablesController class");
        }


        try {
            return getCOD_ReceivablesManager().getCOD_Receivables(recId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getReceivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getReceivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCOD_Receivables objects
     * @return java.util.Collection - a collection of the COD Receivables objects
     */
    public Collection getAllCOD_Receivables()
        throws BusinessDelegateException {
        try {
            return getCOD_ReceivablesManager().getAllCOD_Receivables();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllCOD_Receivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findReceivablesByAwbNbr objects
     * @return java.util.Collection - a collection of the Receivables objects
     */
    public Collection getCOD_ReceivablesReceivablesByAwbNbr(String awbNbr)
        throws BusinessDelegateException {
        try {
            return getCOD_ReceivablesManager().getCOD_ReceivablesReceivablesByAwbNbr(awbNbr);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCOD_ReceivablesReceivablesByAwbNbr() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodId objects
     * @return java.util.Collection - a collection of the Receivables objects
     */
    public Collection getCOD_ReceivablesByEodId(Integer eodId)
        throws BusinessDelegateException {
        try {
            return getCOD_ReceivablesManager().getCOD_ReceivablesByEodId(eodId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCOD_ReceivablesByEodId() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Receivables object
     * @param recId - the Receivables bean primary key
     */
    public void removeCOD_Receivables(Integer recId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (recId == null) {
            throw new IllegalArgumentException("recId parameter was null in removeCOD_Receivables() method from COD_ReceivablesController class");
        }
        
        try {
            getCOD_ReceivablesManager().removeCOD_Receivables(recId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeCOD_Receivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeCOD_Receivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing COD Receivables object
     * @param COD_receivablesVO - the value object of the COD Receivables bean
     */
    public void updateCOD_Receivables(COD_ReceivablesVO COD_receivablesVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (COD_receivablesVO == null) {
            throw new IllegalArgumentException("receivablesVO parameter was null in updateReceivables() method from ReceivablesController class");
        }
        
        try {
            getCOD_ReceivablesManager().updateCOD_Receivables(COD_receivablesVO);
        }
        catch (COD_ReceivablesException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateCOD_Receivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateCOD_Receivables() method from COD_ReceivablesController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the ReceivablesManager remote interface
     */
    public COD_ReceivablesManager getCOD_ReceivablesManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            COD_ReceivablesManagerHome COD_receivablesManagerHome = (COD_ReceivablesManagerHome)
            service.getEJBHome(ServiceConstants.COD_RECEIVABLESMANAGER_JNDI, COD_ReceivablesManagerHome.class);
            return COD_receivablesManagerHome.create();
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
