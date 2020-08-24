/**
 * @(#)EmpXLocationXRoleLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the emp_x_location_x_role table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface EmpXLocationXRoleLocalHome extends EJBLocalHome {

    public EmpXLocationXRoleLocal findByPrimaryKey(com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK primaryKey)
        throws FinderException;

    public java.util.Collection findAllEmpXLocationXRoles()
        throws FinderException;

    public java.util.Collection findByRoleId(java.lang.Integer roleId)
        throws FinderException;

    public java.util.Collection findByLocationCd(java.lang.String locationCd)
        throws FinderException;

    public java.util.Collection findByEmployeeId(java.lang.String employeeId)
        throws FinderException;

    public java.util.Collection findByEmployeeAndLocation(java.lang.String employeeId, java.lang.String locationCd)
        throws FinderException;

    public EmpXLocationXRoleLocal create(Integer roleId, String locationCd, String employeeId)
        throws CreateException;

}
