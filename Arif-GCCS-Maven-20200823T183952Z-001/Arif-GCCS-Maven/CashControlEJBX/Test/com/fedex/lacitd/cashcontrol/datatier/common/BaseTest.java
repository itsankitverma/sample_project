package com.fedex.lacitd.cashcontrol.datatier.common;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;

public class BaseTest {
	public InitialContext context;
	
	@Before
	public void setup() throws Exception {
		
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        // server user name
        env.put(Context.SECURITY_PRINCIPAL, "weblogic");
        // server password
        env.put(Context.SECURITY_CREDENTIALS, "fedex123");
        //L1 Server
        env.put(Context.PROVIDER_URL, "t3://ije22178.ute.fedex.com:7005");
        this.context = new InitialContext(env);
        
        ServiceLocator service = ServiceLocator.getInstanceForTest(context);
	}

	@After
	public void tearDown() throws Exception {
		if(context !=null){
		   context.close();
		}
		 
	}

	public InitialContext getContext() {
		return context;
	}
}
