package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.xmlbeans.XmlObject;

import com.fedex.lacitd.cashcontrol.prestier.struts.form.BillToAccountForm;

import com.fedex.lacitd.cashcontrol.prestier.helper.CiamWebService2;


public class BillToAccountAction extends Action implements java.io.Serializable{
	
	private String cfamWSDL = null;
	public String billToAcctNbr = null;
	public String index = null;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws  Exception{
				
			String target = new String("Success");
			
			billToAcctNbr = request.getParameter("billAccount");
			index = request.getParameter("index");					
	   			
			CiamWebService2 	cws2 = new CiamWebService2();
			if (!cws2.getResponse(billToAcctNbr)){
			   //return mapping.findForward("Failure");
			   target = new String("Failure");
			}
	    	else{    				
	    	    request.setAttribute("billToAccount", billToAcctNbr);	   
	    	    request.setAttribute("ind", index);	    	    
	    		//return mapping.findForward("Success");
	    	}			
			return (mapping.findForward(target));		
						
		}	
		
	}

	
	

