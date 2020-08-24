package com.fedex.lacitd.cashcontrol.prestier.helper;

import org.junit.Test;

import com.bea.httppubsub.util.*;
import com.maverick.util.Base64.InputStream;

import java.io.FileInputStream;
import java.util.*;

import javax.servlet.ServletContext;

public class ProcessVISAFileRunnableTest {
	

	ProcessVISAFileRunnable process = new ProcessVISAFileRunnable();
	
	@Test
	public void getServletCtx(){
		
		process.getServletCtx();
		
	}
	
	@Test 
	public void setServletCtx(){
		
		ServletContext Ctx = null;
		process.setServletCtx(Ctx);
	}
	
	@Test
	public void getThread(){
		
		process.getThread();
		
	}
	@Test
	public void setThread(){
		
		Thread t= null;
		process.setThread(t);
	}
	
//	@Test
//	public void notifyError(){
//		
//		String a = "Test";
//		String b = "Help";
//				
//		process.notifyError(a,b);
//	}

}
