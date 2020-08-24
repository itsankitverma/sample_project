package com.fedex.lacitd.cashcontrol.prestier.helper;

import org.junit.Test;
import java.util.*;

public class RODProcessSTAT44TRunnableTest {
	
	RODProcessSTAT44Runnable rod = new RODProcessSTAT44Runnable();
	
	@Test
	public void getErrorsTest(){
		
		rod.getErrors();
	}
	
	@Test
	public void setErrorsTest(){
		
		ArrayList<String> list = new ArrayList<String>();
		rod.setErrors(list);
	}
	
	@Test
	public void TestgetAwbs(){
		
	rod.getAwbs();
	
	}
	
	@Test
	public void TestsetAwbs(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
	
		
		rod.setAwbs(list);
		
	}
	
	@Test
	public void TestgetNotProcessed(){
		
		rod.getNotProcessed();
	}
		
	@Test
	public void TestsetNotProcessed(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		rod.setNotProcessed(list);
		
	}
	
	@Test
	public void getResultsTest(){
		
	rod.getResults();
	
	}
	
	@Test
	public void setResultsTest(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
	
		
		rod.setResults(list);
		
	}
}
