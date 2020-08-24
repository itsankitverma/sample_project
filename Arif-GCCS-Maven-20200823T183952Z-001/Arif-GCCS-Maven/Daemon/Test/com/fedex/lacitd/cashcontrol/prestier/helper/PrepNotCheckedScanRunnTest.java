package com.fedex.lacitd.cashcontrol.prestier.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bea.httppubsub.util.*;
import com.maverick.util.Base64.InputStream;

import java.io.FileInputStream;
import java.util.*;

public class PrepNotCheckedScanRunnTest {
	
	PrepNotCheckedScanRunn prep = new PrepNotCheckedScanRunn();
	
	@Test
	public void getErrors(){
		
		prep.getErrors();
	}
	
	@Test
	public void setErrors(){
		
		ArrayList<String> list = new ArrayList<String>();
		prep.setErrors(list);
		
	}
	
	@Test
	public void getAwbs(){
		prep.getAwbs();
		
	}
	@Test
	public void setAwbs(){
		
		ArrayList<String> list = new ArrayList<String>();
		prep.setAwbs(list);
		
	}
	@Test
	public void setNotProcessed(){
		
		ArrayList<String> list = new ArrayList<String>();
		prep.setNotProcessed(list);
		
	}
	@Test
	public void getNotProcessed(){
		prep.getNotProcessed();
		
	}
	@Test
	public void setResults(){
		ArrayList<String> list = new ArrayList<String>();
		prep.setResults(list);
			
	}
	@Test
	public void getResults(){
		prep.getResults();
		
	}
	
//	@Test
//	public void processLastScans() throws Exception{
//		ArrayList<String> list = new ArrayList<String>();
//		prep.processLastScans(list);
//		
//	}

}
