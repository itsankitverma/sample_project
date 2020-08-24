/**
 * PaymentsAdminAction.java
 *
 * Created on 16 de julio de 2002, 04:57 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;
import org.apache.struts.action.*;

import java.io.Serializable;
import java.util.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;

/**
 * This class is used to Admin
 * the payments types
 * @author  ccardenas
 */
public class OtherPaymentsCategAdminAction extends Action implements java.io.Serializable{
    public OtherPaymentsCategAdminAction() {
    }

    AdminBizDelegate abd = new AdminBizDelegate();
    
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
        if("delete".equals(request.getParameter("action"))){
            return delete(mapping,form,request,response);
        }else{
            if("save".equals(request.getParameter("action"))){
                return save(mapping,form,request,response);
            }else{
                return show(mapping,form,request,response,false);
            }    
        }

    }

    /**
     * This method is executed to prepare the information
     * for the page that will show the previous Other Payments Categories
     * and will allow to enter a new one
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object,
     * @param    boolean stating if it is comming from an erroneous condition
     * @return   Struts action forward 
     * @exception Exception
     */
    private ActionForward show(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response,
    boolean fromError)
    throws Exception
    {
        OtherPaymentsCategAdminForm paForm=null;

       try{
            if(form==null){
                paForm=new OtherPaymentsCategAdminForm();
            }else{
                paForm=(OtherPaymentsCategAdminForm)form;
            }
            OtherPymtCtgController opcc=new OtherPymtCtgController();            

            //if it needs to show a previous payment type
            if(paForm.getCurrentCtg()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId().intValue()!=0){
            	paForm.setCurrentCtg(opcc.getOtherPymtCtg(paForm.getCurrentCtg().getOtherPaymentCtgId()));

                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "OtherPaymentsCategAdminAction show()", paForm.getCurrentCtg().getOtherPaymentCtgId().toString(), true);
            }

            
            TreeSet ts=new TreeSet(new OtherPaymentCtgComparator());
            ts.addAll(opcc.getAllPaymentCtgs());
            if(paForm.getCurrentCtg()==null)paForm.setCurrentCtg(new OtherPymtCtgVO());			
            paForm.setAllCtgs(new ArrayList(ts));
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

           if(paForm.getCurrentCtg()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId().intValue()!=0){
               LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "OtherPaymentsCategAdminAction show()", paForm.getCurrentCtg().getOtherPaymentCtgId().toString(), true);
           }
       }

       return mapping.findForward("Success");
    }
    
    /**
     * This method is executed to save a new entered
     * Other Payments Category
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object,
     * @return   Struts action forward 
     * @exception Exception
     */    
    private ActionForward save(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception
    {
       OtherPaymentsCategAdminForm paForm=null;

       try{
            if(form==null){
                paForm=new OtherPaymentsCategAdminForm();
            }else{
                paForm=(OtherPaymentsCategAdminForm)form;
            }
            
            if(paForm.getCurrentCtg()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId().intValue()!=0){
            	new OtherPymtCtgController().updateOtherPymtCtg(paForm.getCurrentCtg());

                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "OtherPaymentsCategAdminAction save()", paForm.getCurrentCtg().getOtherPaymentCtgId().toString(), true);

            }else{

                new OtherPymtCtgController().setOtherPymtCtg(paForm.getCurrentCtg());

                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "OtherPaymentsCategAdminAction save()", paForm.getCurrentCtg().getDescription(), true);
            }
            paForm.setCurrentCtg(new OtherPymtCtgVO());

            return show(mapping,form,request,response,false);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CouldNotSavePaymentType"));
            saveErrors(request,ae);

           if(paForm.getCurrentCtg()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId().intValue()!=0)
              LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "OtherPaymentsCategAdminAction save()", "", false);
           else
              LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "OtherPaymentsCategAdminAction save()", "", false);

            return show(mapping,form,request,response,true);
       }
    }
    
    /**
     * This method is executed to delete a selected
     * Other Payments Category
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object,
     * @return   Struts action forward 
     * @exception Exception
     */    
    
    private ActionForward delete(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
    	OtherPaymentsCategAdminForm paForm=null; 
       try{
            
            if(form==null){
                paForm=new OtherPaymentsCategAdminForm();
            }else{
                paForm=(OtherPaymentsCategAdminForm)form;
            }

            new OtherPymtCtgController().removeOtherPymtCtg(paForm.getCurrentCtg().getOtherPaymentCtgId());

            if(paForm.getCurrentCtg()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId() != null)
               LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "OtherPaymentsCategAdminAction delete()", paForm.getCurrentCtg().getOtherPaymentCtgId().toString(), true);

            paForm.setCurrentCtg(new OtherPymtCtgVO());

            return show(mapping,form,request,response,false);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CouldNotDeleteCategory"));
            saveErrors(request,ae);

            if(paForm.getCurrentCtg()!=null && paForm.getCurrentCtg().getOtherPaymentCtgId() != null)
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "OtherPaymentsCategAdminAction delete()", paForm.getCurrentCtg().getOtherPaymentCtgId().toString(), false);

            return show(mapping,form,request,response,false);
       }

    }
    
    /** 
     * This class is used to manage to compare
     * PaymentTypeVO objects.
     * @author  ccardenas
     */
    private static class OtherPaymentCtgComparator implements Comparator,Serializable{
           public int compare(Object obj1, Object obj2) {
                try{
                	OtherPymtCtgVO lvo1=(OtherPymtCtgVO)obj1;
                	OtherPymtCtgVO lvo2=(OtherPymtCtgVO)obj2;                                                
                                                
                    return lvo1.getShortDescription().compareTo(lvo2.getShortDescription());

               }catch(Exception pe){
                    Constants.logger.debug(Utils.stackTraceToString(pe));
                    return -1;
               }
           }                
    }    
 
}