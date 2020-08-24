package com.fedex.lacitd.cashcontrol.prestier.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bea.httppubsub.util.*;
import com.maverick.util.Base64.InputStream;

import java.io.FileInputStream;
import java.util.*;
import javax.servlet.*;


import javax.servlet.ServletContext;

public class ExtPaymentProcessRunnableTest {
	
	ExtPaymentProcessRunnable ext = new ExtPaymentProcessRunnable();
	
	@Test
	public void TestgetServletCtx(){
		
		ext.getServletCtx();
		
	}
	
	@Test
	public void TestsetServletCtx(){
		ServletContext Ctx = null;
		
		ext.setServletCtx(Ctx);
		
	}
	
	@Test
	public void TestgetThread(){
		ext.getThread();
		
	}
	
	@Test
	public void TestsetThread(){
		Thread t= null;
		ext.setThread(t);
		
	}
}
