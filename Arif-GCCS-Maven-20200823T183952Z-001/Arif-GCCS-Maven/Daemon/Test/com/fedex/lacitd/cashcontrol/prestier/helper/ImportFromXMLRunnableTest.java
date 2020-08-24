package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.junit.Test;

public class ImportFromXMLRunnableTest {
	
	ImportFromXMLRunnable im = new ImportFromXMLRunnable();
	
	@Test 
	public void testCleanInputStream() throws IOException{
		
		byte [] a = {(byte)0x31,(byte)0x33,(byte)0x32,(byte)0x30};
		
		im.cleanInputStream(a);
	}
	
	@Test
	public void testGetServletCtx(){
		
		im.getServletCtx();
		
	}
	
	@Test
	public void testSetServletCtx(){
		
		ServletContext Ctx = null;
		
		im.setServletCtx(Ctx);
	}
	
	@Test
	public void testGetThread(){
		
		im.getThread();
	}
	
	@Test
	public void testSetThread(){
		
		Thread t = null;
		im.setThread(t);
	}
	
//	@Test
//	public void testnotifyError(){
//		
//		String a ="test";
//		String b = "Helper";
//		
//		im.notifyError(a,b);
//	}
}
