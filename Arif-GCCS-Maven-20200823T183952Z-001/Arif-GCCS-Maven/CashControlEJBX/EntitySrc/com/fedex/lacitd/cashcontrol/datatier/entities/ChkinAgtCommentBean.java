/**
 * @(#)ChkinAgtCommentBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the chkin_agt_comment table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class ChkinAgtCommentBean implements EntityBean {

    private EntityContext _ctx;
    public ChkinAgtCommentBean() {
    }
    /**
     * Set the value of commentId
     * @param commentId - Integer of commentId
     */
    public abstract void setCommentId(Integer commentId);

    /**
     * Get the value of commentId
     * @return commentId - Integer of commentId
     */
    public abstract Integer getCommentId();

    /**
     * Set the value of commentCd
     * @param commentCd - String of commentCd
     */
    public abstract void setCommentCd(String commentCd);

    /**
     * Get the value of commentCd
     * @return commentCd - String of commentCd
     */
    public abstract String getCommentCd();

    /**
     * Set the value of commentDesc
     * @param commentDesc - String of commentDesc
     */
    public abstract void setCommentDesc(String commentDesc);

    /**
     * Get the value of commentDesc
     * @return commentDesc - String of commentDesc
     */
    public abstract String getCommentDesc();

    /**
     * Set the value of applyTo
     * @param applyTo - String of applyTo
     */
    public abstract void setApplyTo(String applyTo);

    /**
     * Get the value of applyTo
     * @return applyTo - String of applyTo
     */
    public abstract String getApplyTo();

    /**
     * Set the value of status
     * @param status - String of status
     */
    public abstract void setStatus(String status);

    /**
     * Get the value of status
     * @return status - String of status
     */
    public abstract String getStatus();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String commentCd, String commentDesc, String applyTo, String status)
        throws CreateException {
        setCommentCd(commentCd);
        setCommentDesc(commentDesc);
        setApplyTo(applyTo);
        setStatus(status);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String commentCd, String commentDesc, String applyTo, String status)
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
