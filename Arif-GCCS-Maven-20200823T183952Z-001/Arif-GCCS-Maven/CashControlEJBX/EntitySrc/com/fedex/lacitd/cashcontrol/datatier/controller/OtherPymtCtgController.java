/**
 * @(#)OtherPymtCtgController.java			Tue Aug 02 15:38:53 VET 2005
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

public class OtherPymtCtgController {

    /**
     * This method create new OtherPymtCtg object
     * @param otherPymtCtgVO a value object the OtherPymtCtg bean
     */
    public void setOtherPymtCtg(OtherPymtCtgVO otherPymtCtgVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (otherPymtCtgVO == null) {
            throw new IllegalArgumentException("otherPymtCtgVO parameter was null in setOtherPymtCtg() method from OtherPymtCtgController class");
        }
        
        try {
            getOtherPymtCtgManager().setOtherPymtCtg(otherPymtCtgVO);
        }
        catch (OtherPymtCtgException ex) {
            String errorMsg = "Error occurred in setOtherPymtCtg() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setOtherPymtCtg() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a OtherPymtCtg object
     * @return otherPymtCtgVO - a value object of the OtherPymtCtg bean
     */
    public OtherPymtCtgVO getOtherPymtCtg(Integer otherPaymentCtgId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (otherPaymentCtgId == null) {
            throw new IllegalArgumentException("otherPaymentCtgId parameter was null in getOtherPymtCtg() method from OtherPymtCtgController class");
        }
        
        try {
            return getOtherPymtCtgManager().getOtherPymtCtg(otherPaymentCtgId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getOtherPymtCtg() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOtherPymtCtg() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllPaymentCtgs objects
     * @return java.util.Collection - a collection of the OtherPymtCtg objects
     */
    public Collection getAllPaymentCtgs()
        throws BusinessDelegateException {
        try {
            return getOtherPymtCtgManager().getAllPaymentCtgs();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllPaymentCtgs() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing OtherPymtCtg object
     * @param otherPaymentCtgId - the OtherPymtCtg bean primary key
     */
    public void removeOtherPymtCtg(Integer otherPaymentCtgId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (otherPaymentCtgId == null) {
            throw new IllegalArgumentException("otherPaymentCtgId parameter was null in removeOtherPymtCtg() method from OtherPymtCtgController class");
        }
        
        try {
            getOtherPymtCtgManager().removeOtherPymtCtg(otherPaymentCtgId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeOtherPymtCtg() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeOtherPymtCtg() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing OtherPymtCtg object
     * @param otherPymtCtgVO - the value object of the OtherPymtCtg bean
     */
    public void updateOtherPymtCtg(OtherPymtCtgVO otherPymtCtgVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (otherPymtCtgVO == null) {
            throw new IllegalArgumentException("otherPymtCtgVO parameter was null in updateOtherPymtCtg() method from OtherPymtCtgController class");
        }
        
        try {
            getOtherPymtCtgManager().updateOtherPymtCtg(otherPymtCtgVO);
        }
        catch (OtherPymtCtgException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateOtherPymtCtg() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateOtherPymtCtg() method from OtherPymtCtgController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the OtherPymtCtgManager remote interface
     */
    public OtherPymtCtgManager getOtherPymtCtgManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            OtherPymtCtgManagerHome otherPymtCtgManagerHome = (OtherPymtCtgManagerHome)
            service.getEJBHome(ServiceConstants.OTHERPYMTCTGMANAGER_JNDI, OtherPymtCtgManagerHome.class);
            return otherPymtCtgManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getOtherPymtCtgManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getOtherPymtCtgManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getOtherPymtCtgManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
