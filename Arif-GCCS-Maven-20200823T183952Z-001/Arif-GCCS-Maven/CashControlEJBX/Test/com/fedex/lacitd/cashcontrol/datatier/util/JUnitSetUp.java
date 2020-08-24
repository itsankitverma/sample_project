package com.fedex.lacitd.cashcontrol.datatier.util;

import java.util.Hashtable;

import javax.naming.Context;

import org.junit.Before;

import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;


public class JUnitSetUp {
	
	@Before 
	public void setServiceContext() {
        try{
        	Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
            env.put(Context.SECURITY_PRINCIPAL, "weblogic");
            env.put(Context.SECURITY_CREDENTIALS, "syntel123$");
            env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7005");
    		ServiceLocator.getInstance(env);	
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}
