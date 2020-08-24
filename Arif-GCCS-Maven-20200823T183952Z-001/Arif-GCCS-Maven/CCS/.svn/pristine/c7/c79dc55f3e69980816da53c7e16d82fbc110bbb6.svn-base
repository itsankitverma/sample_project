/*
 * DepSlipAddCommentAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;
import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateExpressionsUtil;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;

import org.apache.struts.action.*;
import java.text.*;

/**
 * This class is used to manage the
 * requests for adding/deleting comments
 * to a Deposit Slip
 * @author  ccardenas
 */
public class DepSlipAddCommentAction extends Action implements java.io.Serializable{
    public DepSlipAddCommentAction() {
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
     * This method is executed when the user wants to see 
     * the previous comments and add a new one.
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
       request.setAttribute("DepSlipAddCommentForm",form); 
       return mapping.findForward("ShowToEnter");
    }    

    /**
     * This method is executed to save a new comment
     * entered.
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
    	
    	ActionErrors ae = new ActionErrors();
    	// String columnNewValue = null;
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");                              
            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();            
            DepSlipAddCommentForm ccrForm=(DepSlipAddCommentForm)form;
            String tmstamp=new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(Utils.changeDateToTZ(new java.util.Date(),ep.getLocationTimeZone()));
            String start="";
            if(ccrForm.getOldComment()!=null && !"".equals(ccrForm.getOldComment())){
                start=" ";
                
            }
         /*   
          * code commented by Sri Kalluri on 08/11/2010
          * columnNewValue = ccrForm.getNewComment();
            if(!validateInputData(columnNewValue))
            {
                ae.add("conditionValue", new ActionError("wl.error.noValidCharsN", columnNewValue));
            }
            
            if(ae.size() > 0)
            {
                saveErrors(request, ae);

                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "DepSlipAddCommentAction addComment()", "" + ccrForm.getCurrentDepositSlipId(), false);

                return show(mapping,form,request,response);            }
            else
            { */
            bizComm.addDepositSlipComment(ccrForm.getCurrentDepositSlipId(),start+"Employee "+ep.getEmployeeId()+" ["+tmstamp+"]"+ccrForm.getNewComment());

            
            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "DepSlipAddCommentAction addComment()", "" + ccrForm.getCurrentDepositSlipId(), true);
          //  }
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotSaveComment"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "DepSlipAddCommentAction addComment()", "", false);

            return show(mapping,form,request,response);
       }
       return mapping.findForward("CloseWindow");
    }
    
  /*  code commented by Sri Kalluri on 08/11/2010
   * private boolean validateInputData (String columnNewValue)
    {
        ValidateExpressionsUtil valUtil = ValidateExpressionsUtil.getInstance();

        String [] expressions = { "ForbiddenCharacters02.wl" };

        if(!valUtil.isValid(expressions, columnNewValue))
        {
            return false;
        }

        return true;
    } */
}