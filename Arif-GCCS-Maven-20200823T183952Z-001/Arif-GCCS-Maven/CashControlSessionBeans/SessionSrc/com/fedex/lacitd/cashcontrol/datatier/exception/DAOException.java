/**
 * @(#)BusinessDelegateException.java			Tue Jul 09 11:23:08 VET 2002
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
 * @author Cristian C?enas
 * @version 1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.exception;


public class DAOException extends com.fedex.lacitd.cashcontrol.datatier.exception.NestedException {

    public DAOException(String message, Exception originatingException) {
        super(message, originatingException);
    }
}
