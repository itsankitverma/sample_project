package com.examples;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.FedExEmployee;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.*;



public class TestLDAP
{

public static void main(String[] args)
{
try
{
			Hashtable env = new Hashtable(11);
			//env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
			//env.put(Context.PROVIDER_URL, "ldap://directory.fedex.com/o=fedex,c=us");
            env.put(Context.INITIAL_CONTEXT_FACTORY,Constants.LDAPInitialContextFactory);
            env.put(Context.PROVIDER_URL, Constants.LDAPProvider);

            DirContext ctx = new InitialDirContext(env);

            NamingEnumeration it =ctx.search("ou=people","uid=" + "617880",null);
            while(it.hasMore()) {
                SearchResult sr = (SearchResult) it.next();
                if(sr != null) {

                   Attributes  allAttributes = sr.getAttributes();

                   System.out.println("A:" + allAttributes.get(FedExEmployee.FIRST_NAME) + "--");
                    System.out.println("A:" + allAttributes.get(FedExEmployee.LAST_NAME) + "--");
                    System.out.println("A:" + allAttributes.get(FedExEmployee.COUNTRY_CODE) + "--");
                    System.out.println("A:" + allAttributes.get(FedExEmployee.MAIL) + "--");
                    System.out.println("A:" + allAttributes.get(FedExEmployee.FIRST_NAME) + "--");
                }
            }

			//DirContext ctx = new InitialDirContext(env);

//			BasicAttributes a = new BasicAttributes("password","angela");
//			ctx.bind("uid=145625,ou=people","ou=people", a);
//			ctx.bind("o=fedex,c=us,ou=people,uid=145625","");
//			Attributes as = ctx.getAttributes("uid=145625,ou=people");
			//Attributes as = ctx.getAttributes("uid=486284,ou=people");
			//NamingEnumeration it = as.getAll();
//			System.out.println("CTX:" + ctx);
			//while(it.hasMore())
			//{
			//	Attribute a = (Attribute)it.next();
			//	System.out.println("A:" + a);
			//}

//			ctx.bind(,null,a);

/*
			ctx.bind("uid=145625,ou=people","password","angela");
	        	NamingEnumeration it =ctx.search("ou=people","uid=145625",null);
			while(it.hasMore())
			{
				SearchResult sr = (SearchResult) it.next();
				if(sr != null)
				{
			        	Attributes  allAttributes = sr.getAttributes();
					System.out.println("Attributes:" + allAttributes);

				}
			}*/


}catch(Exception ex)
{
	System.out.println("Ex:" + ex.getMessage());
	ex.printStackTrace();


}


}



}