/**
 * @(#)EmployeeLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the employee table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface EmployeeLocalHome extends EJBLocalHome {

    public EmployeeLocal findByPrimaryKey(java.lang.String primaryKey)
        throws FinderException;

    public java.util.Collection findAllEmployees()
        throws FinderException;

    public java.util.Collection findAdminEmployees()
        throws FinderException;

    public java.util.Collection findCountryAdminEmployees(java.lang.String countryCd)
        throws FinderException;

    public EmployeeLocal create(String employeeId, String employeeNm, String password, String email, String defaultPage, Date pwdDate, String locked, int lginCntr)
        throws CreateException;

}
