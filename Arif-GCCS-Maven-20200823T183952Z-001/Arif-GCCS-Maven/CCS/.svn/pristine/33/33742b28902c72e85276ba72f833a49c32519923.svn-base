/**
 * AdminAccountAction.java
 *
 * Created on October 18, 2004
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
import java.util.Arrays;
import java.util.ArrayList;
import javax.servlet.http.*;

/**
 * @author  Arturo Gonzalez
 */
public class AdminAccountAction extends Action implements Serializable{

    AdminBizDelegate  abd       = new AdminBizDelegate();
    SystemUtilsBizDelegate subd = new SystemUtilsBizDelegate();
    ActionErrors      ae        = new ActionErrors();
    
    /** Creates a new instance of AdminUserListAction */
    public AdminAccountAction() {
    }
    
    public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {     Collection countries  = null;
          
          //Clear Errors
          ae.clear();
         
          String action  = request.getParameter("action");
          
          //Here is checks the Session to know if there is an userProfile to follow the workflow
          //If there is not an user Profile return to logout page
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            if(ep==null) return mapping.findForward("logout");
            
            if("saveAccount".equals(action))
            {   saveAccount(form, request);
            }else if("deleteAccount".equals(action))
            	  {   deleteAccount(request);	}
            	  else if("showAccounts".equals(action))
            	       {   return closeAccount(mapping, form, request);							   }
            	  	
            	 	
            //Go to show the window
              return showWindow(mapping, form, request);
    }
    
    /**
     * This method fill the AdminBankAccountForm class to return to the screen with the list of Bank Accounts
     * @param mapping
     * @param form
     * @param request
     * @return ActionForward CloseAccount
     */
    private ActionForward closeAccount(ActionMapping mapping, ActionForm form, HttpServletRequest request)
    {   	AdminAccountForm frm = (AdminAccountForm)form;
    		AdminBankAccountForm abafrm= new AdminBankAccountForm();
    		BankController ctrlBank=new BankController();
    		
    		try{
    		    abafrm.setBanks((List)ctrlBank.getBankByCountryCd(frm.getCountry()));
    		}catch(Exception e){
    		    
    		    }
    		if(frm.getLocationsByCountry()!=null)
    		   abafrm.setLocations(Arrays.asList(frm.getLocationsByCountry()));
    		abafrm.setBank(frm.getBankId());
    		
        	request.setAttribute("AdminBankAccountForm",frm);
        	return mapping.findForward("showAccounts");
    }
    
    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @return ActionForward "ShowWindow"
     */
    private ActionForward showWindow(ActionMapping mapping, ActionForm form, HttpServletRequest request)
    {
        AdminAccountForm frm =(AdminAccountForm)form;
        BankAccController ctrlAcc=new BankAccController();
        BankController ctrlBank=new BankController();
        LocationController ctrlLoc = new LocationController();
        
        try{
            if("changeCountry".equals(request.getParameter("action")))
            {	frm.setAccountCd(new Integer(0));
                frm.setAccountNbr("");
                frm.setBrach("");
            }
            
              LocationToCompare comp	=	new LocationToCompare();
      		  List locSelected			=	(List)ctrlAcc.getLocations(frm.getAccountCd());
      		  if(locSelected!=null)
      		     Collections.sort(locSelected, comp); //Order the list
      		  
      		  List locByCountry			= 	(List)ctrlLoc.getLocationByCountryCd(frm.getCountry()); //Order the list
      		  if(locByCountry!=null)
      		     Collections.sort((List)locByCountry,comp);//Order the list
      		  
              if(frm.getAccountCd().intValue()>0)//Then is modification and must 
              {	  //Get locations and compare
              		Iterator it=locByCountry.iterator();
              		while(it.hasNext())
              		{   if((Collections.binarySearch(locSelected,it.next(),comp)>=0))
          	   		 	{	it.remove();}
              		}
              		//
              	frm.setLocationsSelected(locSelected.toArray());
              }
            
              
            frm.setSupportedCurrencies((List)subd.getCountryCurrencies(frm.getCountry()));
            frm.setLocationsByCountry(locByCountry.toArray());
            frm.setBankByCountry((List)ctrlBank.getBankByCountryCd(frm.getCountry()));
            
        }catch(Exception e)
         {	Constants.logger.debug(Utils.stackTraceToString(e));
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotShowAccountBank"));
			saveErrors(request,ae);
         }	
        
        request.setAttribute("AdminAccountForm",frm);
        return mapping.findForward("ShowWindow");
    }
    
    private void saveAccount(ActionForm form, HttpServletRequest request)
    {
        AdminAccountForm frm = (AdminAccountForm)form;
        
        try{
            BankAccVO bankAcc = new BankAccVO();
            bankAcc.setAccountNbr(frm.getAccountNbr());
            bankAcc.setBankId(frm.getBankId());
            bankAcc.setBankBranchId(frm.getBrach());
            bankAcc.setCurrencyType(frm.getCurrency());
            /*
             * Introduced a new field Orgination Number
             * Changes Done Kapil R
             */
            bankAcc.setOriginationNbr(frm.getOriginationNbr());
            
            if(frm.getAccountCd().intValue()==0)
               frm.setAccountCd(null);
            
            bankAcc.setBankAccountCd(frm.getAccountCd());  
            
            //Save the ACCOUNT
            abd.saveBankAccount(bankAcc,Arrays.asList(frm.getLocationsSelected()));
            frm.setAccountCd(bankAcc.getBankAccountCd());

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "AdminAccountAction saveBank() bank: " + getBankName( frm.getBankId()), frm.getAccountNbr(), true);

        }catch(Exception e)
        {	Constants.logger.debug(Utils.stackTraceToString(e));
			ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveAccountBank"));
			saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "AdminAccountAction saveBank() bank: " + getBankName( frm.getBankId()), frm.getAccountNbr(), false);
        }
    }
    
    private void deleteAccount(HttpServletRequest request)
    {
    }

    private String getBankName( Integer bankId)
    {
        BankController ctrlBank  = new BankController();

        if(bankId == null) return "";

        try
        {
            BankVO bankVO = ctrlBank.getBank( bankId);

            return bankVO.getBankNm();
        }
        catch(Exception e)
        {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }

        return "";
    }
}//Close AdminUserListAction class

