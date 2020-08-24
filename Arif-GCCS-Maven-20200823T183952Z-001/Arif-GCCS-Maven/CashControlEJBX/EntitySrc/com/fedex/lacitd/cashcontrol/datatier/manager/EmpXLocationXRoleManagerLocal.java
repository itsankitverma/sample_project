/**
 * @(#)EmpXLocationXRoleManagerLocal.java			Tue Aug 02 15:38:52 VET 2005
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

public interface EmpXLocationXRoleManagerLocal extends EJBLocalObject {

    /**
     * This method create new EmpXLocationXRole object
     * @param empXLocationXRoleVO a value object the EmpXLocationXRole bean
     */
    public void setEmpXLocationXRole(EmpXLocationXRoleVO empXLocationXRoleVO)
        throws EmpXLocationXRoleException;

    /**
     * This method gets a EmpXLocationXRole object
     * @param empXLocationXRolePK - the EmpXLocationXRole bean primary key
     * @return empXLocationXRoleVO - a value object of the EmpXLocationXRole bean
     */
    public EmpXLocationXRoleVO getEmpXLocationXRole(com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK)
        throws FinderException;

    /**
     * This method removes an existing EmpXLocationXRole object
     * @param empXLocationXRolePK - the EmpXLocationXRole bean primary key
     */
    public void removeEmpXLocationXRole(com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK empXLocationXRolePK)
        throws RemoveException;

    /**
     * This method updates an existing EmpXLocationXRole object
     * @param empXLocationXRoleVO - the value object of the EmpXLocationXRole bean
     */
    public void updateEmpXLocationXRole(EmpXLocationXRoleVO empXLocationXRoleVO)
        throws EmpXLocationXRoleException;

    /**
     * This method gets findAllEmpXLocationXRoles objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getAllEmpXLocationXRoles();

    /**
     * This method gets findByRoleId objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByRoleId(Integer roleId);

    /**
     * This method gets findByLocationCd objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByLocationCd(String locationCd);

    /**
     * This method gets findByEmployeeId objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByEmployeeId(String employeeId);

    /**
     * This method gets findByEmployeeAndLocation objects
     * @return Collection - a collection of the EmpXLocationXRole objects
     */
    public Collection getEmpXLocationXRoleByEmployeeAndLocation(String employeeId, String locationCd);

}
