/**
 * @(#)PymtImptErrorDtlController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PymtImptErrorDtlController {

    /**
     * This method create new PymtImptErrorDtl object
     * @param pymtImptErrorDtlVO a value object the PymtImptErrorDtl bean
     */
    public void setPymtImptErrorDtl(PymtImptErrorDtlVO pymtImptErrorDtlVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (pymtImptErrorDtlVO == null) {
            throw new IllegalArgumentException("pymtImptErrorDtlVO parameter was null in setPymtImptErrorDtl() method from PymtImptErrorDtlController class");
        }
        
        try {
            getPymtImptErrorDtlManager().setPymtImptErrorDtl(pymtImptErrorDtlVO);
        }
        catch (PymtImptErrorDtlException ex) {
            String errorMsg = "Error occurred in setPymtImptErrorDtl() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPymtImptErrorDtl() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PymtImptErrorDtl object
     * @return pymtImptErrorDtlVO - a value object of the PymtImptErrorDtl bean
     */
    public PymtImptErrorDtlVO getPymtImptErrorDtl(Integer imptErrorDtlId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (imptErrorDtlId == null) {
            throw new IllegalArgumentException("imptErrorDtlId parameter was null in getPymtImptErrorDtl() method from PymtImptErrorDtlController class");
        }
        
        try {
            return getPymtImptErrorDtlManager().getPymtImptErrorDtl(imptErrorDtlId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtl() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtl() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPymtImptErrorDtls objects
     * @return java.util.Collection - a collection of the PymtImptErrorDtl objects
     */
    public Collection getAllPymtImptErrorDtls()
        throws BusinessDelegateException {
        try {
            return getPymtImptErrorDtlManager().getAllPymtImptErrorDtls();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPymtImptErrorDtls() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PymtImptErrorDtl object
     * @param imptErrorDtlId - the PymtImptErrorDtl bean primary key
     */
    public void removePymtImptErrorDtl(Integer imptErrorDtlId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (imptErrorDtlId == null) {
            throw new IllegalArgumentException("imptErrorDtlId parameter was null in removePymtImptErrorDtl() method from PymtImptErrorDtlController class");
        }
        
        try {
            getPymtImptErrorDtlManager().removePymtImptErrorDtl(imptErrorDtlId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePymtImptErrorDtl() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePymtImptErrorDtl() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PymtImptErrorDtl object
     * @param pymtImptErrorDtlVO - the value object of the PymtImptErrorDtl bean
     */
    public void updatePymtImptErrorDtl(PymtImptErrorDtlVO pymtImptErrorDtlVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (pymtImptErrorDtlVO == null) {
            throw new IllegalArgumentException("pymtImptErrorDtlVO parameter was null in updatePymtImptErrorDtl() method from PymtImptErrorDtlController class");
        }
        
        try {
            getPymtImptErrorDtlManager().updatePymtImptErrorDtl(pymtImptErrorDtlVO);
        }
        catch (PymtImptErrorDtlException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePymtImptErrorDtl() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePymtImptErrorDtl() method from PymtImptErrorDtlController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PymtImptErrorDtlManager remote interface
     */
    public PymtImptErrorDtlManager getPymtImptErrorDtlManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PymtImptErrorDtlManagerHome pymtImptErrorDtlManagerHome = (PymtImptErrorDtlManagerHome)
            service.getEJBHome(ServiceConstants.PYMTIMPTERRORDTLMANAGER_JNDI, PymtImptErrorDtlManagerHome.class);
            return pymtImptErrorDtlManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtlManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtlManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtImptErrorDtlManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
