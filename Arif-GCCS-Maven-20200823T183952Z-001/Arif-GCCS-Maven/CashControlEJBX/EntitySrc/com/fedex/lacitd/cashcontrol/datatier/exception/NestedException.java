/**
 * @(#)NestedException.java			Tue Aug 02 15:38:54 VET 2005
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
package com.fedex.lacitd.cashcontrol.datatier.exception;

import java.io.*;

public abstract class NestedException extends Exception {

    private Throwable _nestedException;
    public NestedException(String message, Exception nestedException) {
        super(message);
        _nestedException = nestedException;
    }
    public Throwable getOriginatingException() {
        return _nestedException;
    }

    public void printStackTrace() {
        super.printStackTrace();
        if (_nestedException != null) {
            _nestedException.printStackTrace();
        }
    }

    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        if (_nestedException != null) {
            _nestedException.printStackTrace(s);
        }
    }

    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
        if (_nestedException != null) {
            _nestedException.printStackTrace(s);
        }
    }

}
