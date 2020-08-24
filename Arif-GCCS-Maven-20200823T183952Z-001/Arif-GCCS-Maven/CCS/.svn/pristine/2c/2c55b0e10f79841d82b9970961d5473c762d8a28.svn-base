package com.examples;
import java.io.*;
import java.util.*;

/**
 *
 * @author  ccardenas
 */
public class Properties2 {



    /**
     * @param args the command line arguments
     */
public static void main(String[] args)throws Exception
{
	Properties propEn=new Properties();
	Properties propAll=new Properties();
	propEn.load(new  FileInputStream("J:\\CCS\\WEB-INF\\classes\\ApplicationResources.properties"));
	propAll.load(new  FileInputStream("J:\\CCS\\WEB-INF\\classes\\ApplicationResources_th.properties"));
	
	Enumeration enum2=propEn.keys();
	
	while(enum2.hasMoreElements()){
		String key=(String)enum2.nextElement();
		
		String value=propAll.getProperty(key);
		
		if(!propAll.containsKey(key)){
			value=(String)propEn.get(key);
			System.out.println(key+"="+value);
		}
	}
	
	System.out.println("fin.");

}

}