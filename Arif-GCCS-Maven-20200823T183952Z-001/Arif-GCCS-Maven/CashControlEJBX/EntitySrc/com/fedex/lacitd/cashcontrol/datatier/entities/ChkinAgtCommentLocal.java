/**
 * @(#)ChkinAgtCommentLocal.java			Tue Aug 02 15:38:50 VET 2005
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

public interface ChkinAgtCommentLocal extends EJBLocalObject {

    /**
     * Set the value of commentId
     * @param commentId - Integer of commentId
     */
    public void setCommentId(Integer commentId);

    /**
     * Get the value of commentId
     * @return commentId - Integer of commentId
     */
    public Integer getCommentId();

    /**
     * Set the value of commentCd
     * @param commentCd - String of commentCd
     */
    public void setCommentCd(String commentCd);

    /**
     * Get the value of commentCd
     * @return commentCd - String of commentCd
     */
    public String getCommentCd();

    /**
     * Set the value of commentDesc
     * @param commentDesc - String of commentDesc
     */
    public void setCommentDesc(String commentDesc);

    /**
     * Get the value of commentDesc
     * @return commentDesc - String of commentDesc
     */
    public String getCommentDesc();

    /**
     * Set the value of applyTo
     * @param applyTo - String of applyTo
     */
    public void setApplyTo(String applyTo);

    /**
     * Get the value of applyTo
     * @return applyTo - String of applyTo
     */
    public String getApplyTo();

    /**
     * Set the value of status
     * @param status - String of status
     */
    public void setStatus(String status);

    /**
     * Get the value of status
     * @return status - String of status
     */
    public String getStatus();

}
