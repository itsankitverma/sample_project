/**
 * AdminBankAccountAction.java
 *
 * Created on April 17, 2003, 4:54 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.SystemUtilsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.exception.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.*;

/**
 * @author  Arturo Gonzalez
 */
public class AdminBankAction extends Action implements Serializable{

    AdminBizDelegate  abd       = new AdminBizDelegate();
    ActionErrors      ae        = new ActionErrors();
    
    /** Creates a new instance of AdminUserListAction */
    public AdminBankAction() {
    }
    
    
    public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {     AdminBankForm frm		= (AdminBankForm)form;
    
          //Clear Errors
          ae.clear();
          
          String action = (String)request.getAttribute("action");
          
          if(action==null)
             action = request.getParameter("action");
          
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            if(ep==null) return mapping.findForward("CloseWindow");  
            
            if("saveBank".equals(action))
            {	saveBank(frm, request);
            }else if("closeBank".equals(action))
            	  {	  return mapping.findForward("CloseWindow");}
            
            return showBank(mapping, form, request, action);
    }
    
    private ActionForward showBank(ActionMapping mapping, ActionForm form, HttpServletRequest request, String action)
    {
        AdminBankForm frm		=	(AdminBankForm)form;
        BankController ctrlBank =	new BankController();
        BankVO bank				=	new BankVO();
        
	 	try{
	 	       String countrySelected = request.getParameter("countrySelected");
	 	       
	 	       if("saveBank".equals(action))
	 	       {   if(frm.getBankId()!=null && frm.getBankId().intValue()!=0)
	           	   {  bank = ctrlBank.getBank(frm.getBankId());}
	           	   else{
	           	  	    bank=new BankVO();
	           	  	    bank.setCountryCd(frm.getCountryCd());
	           	  	}
	 	       }else{
	 	           	String bankId=request.getParameter("bankId");
	 	            if(bankId.length()>0)
	 	            {  bank = ctrlBank.getBank(new Integer(bankId));
	 	            }else{ 
	 	                	bank = new BankVO();
	 	                	bank.setCountryCd(countrySelected);
	 	                 }
	 	       }
	 	        	  
	 	       frm.setBankId(bank.getBankId());
	 	       frm.setBankCd(bank.getBankCd());
	 	       frm.setBankNm(bank.getBankNm());
	 	       frm.setBankShtDesc(bank.getBankShtDesc());
	 	       frm.setCountryCd(bank.getCountryCd());
	 	       frm.setCheck(true);
	 	}catch(Exception e)
	 	 {	   Constants.logger.debug(Utils.stackTraceToString(e));
		  	  ActionErrors      ae        = new ActionErrors();
              ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetBank"));
		  	   saveErrors(request,ae);
		 }
	 	
	 	Constants.logger.debug("\n *** estado check :" + frm.isCheck());
	 	request.setAttribute("AdminBankForm",frm);
	 	return mapping.findForward("ShowWindow");
    }
    
    private void saveBank(AdminBankForm frm, HttpServletRequest request)
    {
        try{
        	BankController ctrlBank = new BankController();
        	BankVO bank				= new BankVO();
        	
        	bank.setBankCd(frm.getBankCd());
       	    bank.setBankNm(frm.getBankNm());
       	    bank.setBankShtDesc(frm.getBankShtDesc());
       	    bank.setCountryCd(frm.getCountryCd());
       	    
        	if(frm.getBankId()==null || frm.getBankId().intValue()==0)
        	{	ctrlBank.setBank(bank);
        	}else{
        	    	bank.setBankId(frm.getBankId());
        	    	ctrlBank.updateBank(bank);
        	     }
        	
            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "AdminBankAction saveBank()", frm.getBankNm(), true);

        }catch(Exception e)
    	 {	   Constants.logger.debug(Utils.stackTraceToString(e));
    	 	   ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveBank"));
    	 	   saveErrors(request,ae);

               LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "AdminBankAction saveBank()", frm.getBankNm(), false);
         }
    }
    
}//Close AdminUserListAction class

