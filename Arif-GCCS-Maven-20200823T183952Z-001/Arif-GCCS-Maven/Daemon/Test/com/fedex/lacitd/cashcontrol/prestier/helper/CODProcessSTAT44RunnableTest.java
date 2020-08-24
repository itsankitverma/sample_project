package com.fedex.lacitd.cashcontrol.prestier.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.CosmosScanVO;

import java.util.*;

import antlr.collections.impl.Vector;



public class CODProcessSTAT44RunnableTest {
	

	CODProcessSTAT44Runnable codProcess= new CODProcessSTAT44Runnable();
	
	
	@Test 
	public void TestgetErrors(){
		
		codProcess.getErrors();
		
	}
	
	@Test
	public void TestsetErrors(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		codProcess.setErrors(list);
	
}
	@Test
	public void TestgetAwbs(){
		
	codProcess.getAwbs();
	
	}
	
	@Test
	public void TestsetAwbs(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
	
		
		codProcess.setAwbs(list);
		
	}
	
	@Test
	public void TestgetNotProcessed(){
		
		codProcess.getNotProcessed();
	}
		
	@Test
	public void TestsetNotProcessed(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		codProcess.setNotProcessed(list);
		
	}
	
	@Test 
	public void TestprocessLastScans(){
		
		CosmosScanVO csv = new CosmosScanVO();
		Collection localResults = new ArrayList();		
		csv.setAwbNbr("sdfasdf");	
		localResults.add(csv);
		
		Collection cl =codProcess.processLastScans(localResults);
		
	}
	
	@Test
	public void TestGetResults(){
			
	
		codProcess.getResults();
		
	}
	
	@Test
	public void TestSetResults(){
			
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		codProcess.setResults(list);
		
	}
	
	
	
}
