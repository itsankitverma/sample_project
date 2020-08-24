/**
 * @(#)CosmosScanController.java			Tue Aug 02 15:38:53 VET 2005
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

public class CosmosScanController {

    /**
     * This method create new CosmosScan object
     * @param cosmosScanVO a value object the CosmosScan bean
     */
    public void setCosmosScan(CosmosScanVO cosmosScanVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (cosmosScanVO == null) {
            throw new IllegalArgumentException("cosmosScanVO parameter was null in setCosmosScan() method from CosmosScanController class");
        }
        
        try {
            getCosmosScanManager().setCosmosScan(cosmosScanVO);
        }
        catch (CosmosScanException ex) {
            String errorMsg = "Error occurred in setCosmosScan() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in setCosmosScan() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets a CosmosScan object
     * @return cosmosScanVO - a value object of the CosmosScan bean
     */
    public CosmosScanVO getCosmosScan(Integer scanId)
        throws BusinessDelegateException {
        //-- we do not accept null values for any parameters.
        if (scanId == null) {
            throw new IllegalArgumentException("scanId parameter was null in getCosmosScan() method from CosmosScanController class");
        }
        
        try {
            return getCosmosScanManager().getCosmosScan(scanId);
        }
        catch (FinderException ex) {
            String errorMsg = "Error occurred in getCosmosScan() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCosmosScan() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllCosmosScans objects
     * @return java.util.Collection - a collection of the CosmosScan objects
     */
    public Collection getAllCosmosScans()
        throws BusinessDelegateException {
        try {
            return getCosmosScanManager().getAllCosmosScans();
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getAllCosmosScans() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing CosmosScan object
     * @param scanId - the CosmosScan bean primary key
     */
    public void removeCosmosScan(Integer scanId)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (scanId == null) {
            throw new IllegalArgumentException("scanId parameter was null in removeCosmosScan() method from CosmosScanController class");
        }
        
        try {
            getCosmosScanManager().removeCosmosScan(scanId);
        }
        catch (RemoveException ex) {
            String errorMsg = "Error occurred in removeCosmosScan() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in removeCosmosScan() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing CosmosScan object
     * @param cosmosScanVO - the value object of the CosmosScan bean
     */
    public void updateCosmosScan(CosmosScanVO cosmosScanVO)
        throws BusinessDelegateException {
        //-- we do not accept null value for the parameter.
        if (cosmosScanVO == null) {
            throw new IllegalArgumentException("cosmosScanVO parameter was null in updateCosmosScan() method from CosmosScanController class");
        }
        
        try {
            getCosmosScanManager().updateCosmosScan(cosmosScanVO);
        }
        catch (CosmosScanException ex) {
            String errorMsg = "Error occurred to locate the valid object in updateCosmosScan() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in updateCosmosScan() method from CosmosScanController class";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

    /**
     * This method gets the CosmosScanManager remote interface
     */
    public CosmosScanManager getCosmosScanManager()
        throws BusinessDelegateException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            CosmosScanManagerHome cosmosScanManagerHome = (CosmosScanManagerHome)
            service.getEJBHome(ServiceConstants.COSMOSSCANMANAGER_JNDI, CosmosScanManagerHome.class);
            return cosmosScanManagerHome.create();
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCosmosScanManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (CreateException ex) {
            String errorMsg = "Error occurred in getCosmosScanManager() method when create an instance of remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
        catch (RemoteException ex) {
            String errorMsg = "Error occurred in getCosmosScanManager() method when lookup the remote interface";
            throw new BusinessDelegateException(errorMsg, ex);
        }
    }

}
