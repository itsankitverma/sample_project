/**
 * @(#)PymtTypeLocController.java			Tue Aug 02 15:38:53 VET 2005
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

public class PymtTypeLocController {

    /**
     * This method create new PymtTypeLoc object
     * @param pymtTypeLocVO a value object the PymtTypeLoc bean
     */
    public void setPymtTypeLoc(PymtTypeLocVO pymtTypeLocVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (pymtTypeLocVO == null) {
            throw new IllegalArgumentException("pymtTypeLocVO parameter was null in setPymtTypeLoc() method from PymtTypeLocController class");
        }
        
        try {
            getPymtTypeLocManager().setPymtTypeLoc(pymtTypeLocVO);
        }
        catch (PymtTypeLocException ex) {
            String errorMsg = "Error occurred in setPymtTypeLoc() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setPymtTypeLoc() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a PymtTypeLoc object
     * @return pymtTypeLocVO - a value object of the PymtTypeLoc bean
     */
    public PymtTypeLocVO getPymtTypeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (pymtTypeLocPK == null) {
            throw new IllegalArgumentException("pymtTypeLocPK parameter was null in getPymtTypeLoc() method from PymtTypeLocController class");
        }
        
        try {
            return getPymtTypeLocManager().getPymtTypeLoc(pymtTypeLocPK);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getPymtTypeLoc() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtTypeLoc() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPymtTypeLocs objects
     * @return java.util.Collection - a collection of the PymtTypeLoc objects
     */
    public Collection getAllPymtTypeLocs()
        throws BusinessDelegateException {
        try {
            return getPymtTypeLocManager().getAllPymtTypeLocs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPymtTypeLocs() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findLocationsByPayment objects
     * @return java.util.Collection - a collection of the PymtTypeLoc objects
     */
    public Collection getPymtTypeLocLocationsByPayment(Integer ptId)
        throws BusinessDelegateException {
        try {
            return getPymtTypeLocManager().getPymtTypeLocLocationsByPayment(ptId);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtTypeLocLocationsByPayment() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing PymtTypeLoc object
     * @param pymtTypeLocPK - the PymtTypeLoc bean primary key
     */
    public void removePymtTypeLoc(com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (pymtTypeLocPK == null) {
            throw new IllegalArgumentException("pymtTypeLocPK parameter was null in removePymtTypeLoc() method from PymtTypeLocController class");
        }
        
        try {
            getPymtTypeLocManager().removePymtTypeLoc(pymtTypeLocPK);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removePymtTypeLoc() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removePymtTypeLoc() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing PymtTypeLoc object
     * @param pymtTypeLocVO - the value object of the PymtTypeLoc bean
     */
    public void updatePymtTypeLoc(PymtTypeLocVO pymtTypeLocVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (pymtTypeLocVO == null) {
            throw new IllegalArgumentException("pymtTypeLocVO parameter was null in updatePymtTypeLoc() method from PymtTypeLocController class");
        }
        
        try {
            getPymtTypeLocManager().updatePymtTypeLoc(pymtTypeLocVO);
        }
        catch (PymtTypeLocException ex) {
            String errorMsg = "Error occurred to locate the valid object in updatePymtTypeLoc() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updatePymtTypeLoc() method from PymtTypeLocController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the PymtTypeLocManager remote interface
     */
    public PymtTypeLocManager getPymtTypeLocManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            PymtTypeLocManagerHome pymtTypeLocManagerHome = (PymtTypeLocManagerHome)
            service.getEJBHome(ServiceConstants.PYMTTYPELOCMANAGER_JNDI, PymtTypeLocManagerHome.class);
            return pymtTypeLocManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPymtTypeLocManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getPymtTypeLocManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getPymtTypeLocManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
