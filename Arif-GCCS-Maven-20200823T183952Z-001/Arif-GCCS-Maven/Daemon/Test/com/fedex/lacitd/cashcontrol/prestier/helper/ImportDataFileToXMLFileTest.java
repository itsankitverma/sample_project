package com.fedex.lacitd.cashcontrol.prestier.helper;
import javax.servlet.ServletContext;

import org.junit.Test;

import antlr.collections.List;

import com.oracle.vmm.client.provider.ovm22.ws.sps.ArrayList;

import static org.junit.Assert.*;

public class ImportDataFileToXMLFileTest {
	
	ImportDataFileToXMLFile imp = new ImportDataFileToXMLFile();
	
	@Test
	public void getPropsAsStringTest(){
		
		imp.getPropsAsString();
	}
	
//	@Test
//	public void getXMLStringTest(){
//		
//		List list = (List) new ArrayList();
//		
//		imp.getXMLString(list);
//		
//	}
	
	@Test
	public void formatXMLDateTest(){
		
		String a = "09/21/2120";
		imp.formatXMLDate(a);
	}
	@Test
	public void formatXMLNumberDecimalTest(){
		
		String a ="12";
		int dec = 12;
		imp.formatXMLNumberDecimal(a, dec);
		
	}
	@Test
	public void getServletCtxTest(){
		
		imp.getServletCtx();
	}
	@Test
	public void setServletCtxTest(){
		ServletContext s = null;
		imp.setServletCtx(s);
	}
	@Test
	public void getThreadTest(){
		imp.getThread();
	}
	@Test
	public void setThreadTest(){
		Thread t = null;
		imp.setThread(t);
		
	}
}	

