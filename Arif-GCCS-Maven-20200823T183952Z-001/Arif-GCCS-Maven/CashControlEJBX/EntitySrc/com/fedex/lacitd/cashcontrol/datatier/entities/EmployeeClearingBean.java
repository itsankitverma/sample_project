/**
 * @(#)EmployeeClearingBean.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the employee_clearing table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class EmployeeClearingBean implements EntityBean {

    private EntityContext _ctx;
    public EmployeeClearingBean() {
    }
    /**
     * Set the value of employeeId
     * @param employeeId - String of employeeId
     */
    public abstract void setEmployeeId(String employeeId);

    /**
     * Get the value of employeeId
     * @return employeeId - String of employeeId
     */
    public abstract String getEmployeeId();

    /**
     * Set the value of empClearDt
     * @param empClearDt - Date of empClearDt
     */
    public abstract void setEmpClearDt(Date empClearDt);

    /**
     * Get the value of empClearDt
     * @return empClearDt - Date of empClearDt
     */
    public abstract Date getEmpClearDt();

    /**
     * Set the value of empClearStatus
     * @param empClearStatus - int of empClearStatus
     */
    public abstract void setEmpClearStatus(int empClearStatus);

    /**
     * Get the value of empClearStatus
     * @return empClearStatus - int of empClearStatus
     */
    public abstract int getEmpClearStatus();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeClearingPK ejbCreate(String employeeId, Date empClearDt, int empClearStatus)
        throws CreateException {
        setEmployeeId(employeeId);
        setEmpClearDt(empClearDt);
        setEmpClearStatus(empClearStatus);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String employeeId, Date empClearDt, int empClearStatus)
        throws CreateException {
    }

    /**
     * Called by Container.  Associates this Bean instance with a particular context environment.
     */
    public void setEntityContext(EntityContext ctx) {
        _ctx = ctx;
    }

    /**
     * Called by Container.  Disassociates this Bean instance with a particular 
     * context.  Once done, we can query the Context for environment information
     */
    public void unsetEntityContext() {
        _ctx = null;
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * Called by Container.  Updates the entity bean instance to reflect 
     * the current value stored in the database.
     */
    public void ejbLoad() {
    }

    /**
     * Called by Container.  Updates the database to reflect the current values 
     * of this in-memory Entity Bean instance representation.
     */
    public void ejbStore() {
    }

    /**
     * EJB Container calls this method right before it remove the Entity bean 
     * from the database.  Corresponds to when client calls home.remove().
     */
    public void ejbRemove() {
    }

}
