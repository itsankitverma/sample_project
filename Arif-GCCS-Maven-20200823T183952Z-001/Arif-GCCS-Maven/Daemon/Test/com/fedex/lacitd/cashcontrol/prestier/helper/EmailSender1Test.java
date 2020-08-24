package com.fedex.lacitd.cashcontrol.prestier.helper;
import java.io.UnsupportedEncodingException;

import javax.mail.Session;

import org.junit.Test;

import com.oracle.vmm.client.provider.ovm22.ws.lcs.Map;

import static org.junit.Assert.*;
public class EmailSender1Test {
	
	EmailSender1 email = new EmailSender1();
	
//	@Test
//	public void setEmails(){
//		
//		Map<Integer, String> m = new Map<Integer, String>();
//		m.setEmails(m);
//		
//	}
	@Test
	public void getEmail(){
		
		email.getEmails();
		
	}
	
	@Test
	public void getInternetAddressTest(){
		
		email.getInternetAddress();
	}
	
	@Test
	public void setPersonalNameTest() throws UnsupportedEncodingException{
		
		String nm = "Hatem";
		email.setPersonalName(nm);
	}
	@Test
	public void getMimeTest(){
		
		email.getMimeType();
		
	}
	@Test
	public void sendTest(){
		email.send();
	}
	@Test
	public void getCCTest(){
		email.getCc();
				
	}
	@Test
	public void setCCTest(){
		email.setCc("haly@fau.edu");
	}
	@Test
	public void getPersonalNameTest(){
		email.getPersonalName();
	}
	@Test
	public void getSessionTest(){
		email.getSession();
	}
	@Test
	public void setSession(){
	//	Session s = new Session(null, null);
		
	}
	
}	

