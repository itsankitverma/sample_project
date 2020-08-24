/**
 * @(#)EmployeeClearingManagerLocal.java			Tue Aug 02 15:38:53 VET 2005
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
import javax.ejb.*;
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

public interface EmployeeClearingManagerLocal extends EJBLocalObject {

    /**
     * This method create new EmployeeClearing object
     * @param employeeClearingVO a value object the EmployeeClearing bean
     */
    public void setEmployeeClearing(EmployeeClearingVO employeeClearingVO)
        throws EmployeeClearingException;

    /**
     * This method gets a EmployeeClearing object
     * @param employeeClearingPK - the EmployeeClearing bean primary key
     * @return employeeClearingVO - a value object of the EmployeeClearing bean
     */
    public EmployeeClearingVO getEmployeeClearing(com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK employeeClearingPK)
        throws FinderException;

    /**
     * This method removes an existing EmployeeClearing object
     * @param employeeClearingPK - the EmployeeClearing bean primary key
     */
    public void removeEmployeeClearing(com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK employeeClearingPK)
        throws RemoveException;

    /**
     * This method updates an existing EmployeeClearing object
     * @param employeeClearingVO - the value object of the EmployeeClearing bean
     */
    public void updateEmployeeClearing(EmployeeClearingVO employeeClearingVO)
        throws EmployeeClearingException;

    /**
     * This method gets findAllEmployeeClearings objects
     * @return Collection - a collection of the EmployeeClearing objects
     */
    public Collection getAllEmployeeClearings();

}
