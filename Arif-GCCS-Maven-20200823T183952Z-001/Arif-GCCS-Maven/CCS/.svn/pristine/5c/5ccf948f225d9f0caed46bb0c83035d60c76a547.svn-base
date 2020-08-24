/*
 * CreditCardPymtAction.java
 *
 * Created on 16 de julio de 2002, 04:57 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.common.*;
import org.apache.struts.action.*;
import java.util.*;

/**
 * This class is used to manage the
 * request to show the Credit Card Payments
 * batchs 
 * @author  ccardenas
 */
public class CreditCardPymtAction extends Action implements java.io.Serializable{
    public CreditCardPymtAction() {
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
        if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
        if("saveCreditCardBatchs".equals(request.getParameter("action"))){
            return saveCreditCardBatchs(mapping,form,request,response);
        }else{
            return show(mapping,form,request,response);
        }    
    }

    /**
     * This method is prepare all the information
     * for the JSP page that shows the list 
     * of batchs.
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
       try{
            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();            
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            //obtaining the batchs list
            List cc=(List)bizComm.getCreditCardPaymentsBatchs(ep.getLocationCd());
            CreditCardPymtForm ccrForm=new CreditCardPymtForm();
            //publishing the list in the form
            ccrForm.setCreditCardBatchs(cc);
            
            request.setAttribute("CreditCardPymtForm",ccrForm);            
            
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);      
       }
       return mapping.findForward("Success");
    }    
    
    /**
     * This method is used to save the Credit Card
     * Batchs Changes.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */     
    private ActionForward saveCreditCardBatchs(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");                              
            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();             
            CreditCardPymtForm ccrForm=(CreditCardPymtForm)form;
            
            //get the Credit Card Batchs comming from the page
            Collection ccr=ccrForm.getCreditCardBatchs(); 
            Iterator iter=ccr.iterator();
            //Iterate to filter the modified objects
            while(iter.hasNext()){
                CreditCardPymtTableVO dep=(CreditCardPymtTableVO)iter.next();
                if(!dep.isModified()){
                    iter.remove();
                }
            }
            
            //saving the changes
            bizComm.saveCCBatch(ccr,ep.getEmployeeId(),Utils.changeDateToTZ(new java.util.Date(),ep.getLocationTimeZone()));            
            request.setAttribute("CreditCardPymtForm",ccrForm);            
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotSaveCCInformation"));
            saveErrors(request,ae);      
       }
       return show(mapping,form,request,response);
    }
}