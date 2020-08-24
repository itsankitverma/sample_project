/*
 * OtherPaymentAddAction.java
 *
 * Created on 16 de julio de 2002, 04:57 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.common.*;
import java.util.*;

import org.apache.struts.action.*;

/**
 * This class manages the requests for adding and showing
 * and deleting Other Payments 
 * @author  ccardenas
 */
public class OtherPaymentAddAction extends Action implements java.io.Serializable{
    public OtherPaymentAddAction() {
    }
    
    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {        
        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");  
        if(ep==null) return mapping.findForward("CloseWindow");
        
            if("savePayment".equals(request.getParameter("action"))){
                  return savePayment(mapping,form,request,response);                
            }else{
                if("deleteDetail".equals(request.getParameter("action"))){
                      return deleteDetail(mapping,form,request,response);                
                }else{
                      return show(mapping,form,request,response);                
                }         
            }
    }
    
    /**
     * This method is executed when the user
     * request for a delete on Other Payments.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */
    private ActionForward deleteDetail(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
         OtherPaymentAddForm frm=(OtherPaymentAddForm) form;
         if(frm==null) frm=new OtherPaymentAddForm();
         
         try{ 
         	//deleting Other Payment
            new OtherPaymentController().removeOtherPayment(frm.getNewPayment().getOtherPymtId());
         }catch(Exception e){}    
         
         request.setAttribute("submitParent","submitParent");
         return show(mapping,frm,request,response);  
    }     
    
    /**
     * This method is executed to save an Other Payment.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */    
    private ActionForward savePayment(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {   
         EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");          
         
         OtherPaymentAddForm frm=(OtherPaymentAddForm) form;
         if(frm==null) frm=new OtherPaymentAddForm();
         
         OtherPaymentVO opVO=frm.getNewPayment();
         
         //setting the correct employee, location and date
         opVO.setChkinAgentId(ep.getEmployeeId());
         opVO.setLocationCd(ep.getLocationCd());
         opVO.setPaymentDt(Utils.changeDateToTZ(new java.util.Date(),ep.getLocationTimeZone()));
         
         //convert miscDate string to java.util.Date
         
         
         if(frm.getMiscDate().equalsIgnoreCase("") || frm.getMiscDate()==null)
        	 opVO.setMiscDate(null);
         else
        	 opVO.setMiscDate(new java.text.SimpleDateFormat("MM/dd/yyyy").parse(frm.getMiscDate()));
         
         //Inserting an Other Payment
         new OtherPaymentController().setOtherPayment(frm.getNewPayment());         
         
         request.setAttribute("submitParent","submitParent");
         frm.setNewPayment(new OtherPaymentVO());
 
         return show(mapping,frm,request,response);  
    } 
    
    
    /**
     * This method is executed to show a page
     * to enter a new Other Payment.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */    
    private ActionForward show(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
         EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");  
       
         OtherPaymentAddForm frm=(OtherPaymentAddForm) form;
         if(frm==null) frm=new OtherPaymentAddForm();
         
         //set previous payments
         frm.setPayments(new OtherPaymentController().getOtherPaymentOpenByLocation(ep.getLocationCd()));
         
         frm.setOtherPaymentsCtg(new OtherPymtCtgController().getAllPaymentCtgs());
         
         frm.setCountryBanks((Collection)request.getSession().getAttribute("countryBanks"));
         
         //set the allowed payment types
         frm.setPaymentTypes(new PaymentTypeController().getPaymentTypeByOtherLocation(ep.getLocationCd()));
         
         request.setAttribute("OtherPaymentAddForm",frm);
         return mapping.findForward("ShowToEnter"); 
    } 

}