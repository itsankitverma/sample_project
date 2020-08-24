/*
 * CreditCardPymtCommAction.java
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
import java.text.*;


/**
 * This class is used to manage the 
 * requests to enter comments to the
 * Credit Card Payments batchs 
 * @author  ccardenas
 */
public class CreditCardPymtCommAction extends Action implements java.io.Serializable{
    public CreditCardPymtCommAction() {
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
        if("addComment".equals(request.getParameter("action"))){
            return addComment(mapping,form,request,response);
        }else{
            return show(mapping,form,request,response);
        }    
    }

    /**
     * This method forwards the request
     * to the page will allow the comments entering.
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
       request.setAttribute("CreditCardPymtCommForm",form); 
       return mapping.findForward("ShowToEnter");
    }    
    
    /**
     * This method will save the comment entered
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */ 
    private ActionForward addComment(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");                              
            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();             
            CreditCardPymtCommForm ccrForm=(CreditCardPymtCommForm)form;
            String tmstamp=new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(Utils.changeDateToTZ(new java.util.Date(),ep.getLocationTimeZone()));
            String start="";
            if(ccrForm.getOldComment()!=null && !"".equals(ccrForm.getOldComment())){
                start="<br><br>";
                
            }
            
            bizComm.addCCBatchComment(ccrForm.getCurrentBatchId(),start+"<li>Employee "+ep.getEmployeeId()+" ["+tmstamp+"]<br>"+ccrForm.getNewComment());
            
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotSaveComment"));
            saveErrors(request,ae);      
            return show(mapping,form,request,response);
       }
       return mapping.findForward("CloseWindow");
    }
}