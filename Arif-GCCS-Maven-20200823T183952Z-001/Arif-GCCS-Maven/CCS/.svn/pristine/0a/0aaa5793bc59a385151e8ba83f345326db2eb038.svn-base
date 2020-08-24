/*
 * DepositSlipAction.java
 *
 * Created on 16 de julio de 2002, 04:57 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;


import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;
import com.fedex.lacitd.cashcontrol.biztier.common.StationsAdminVO;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.*;

import java.util.*;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * This class is used to capture the station administrators annual input.
 * @author  638871
 */

public class StationsAdminAction extends Action implements java.io.Serializable{
    public StationsAdminAction() {
    }

    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done.
     *
     * @param    mapping Struts action mapping object
     * @param    form Struts action form object
     * @param    request http request object
     * @param    response http response object
     * @return   Struts action forward
     * @exception Exception
     */
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
        	if("save".equals(request.getParameter("action"))){
        		System.out.println("save.equals(request.getParameter(action)");
        		
        		StationsAdminForm stationsAdminForm=null;
                if(form==null){
                	
                    stationsAdminForm=new StationsAdminForm();
                }else{
                	
                    stationsAdminForm=(StationsAdminForm)form;
                    
                    
                }
                
                return save(mapping,form,request,response);
                
                
                    }else{
                    	System.out.println("StationsAdmin else show(mapping,form,request,response)");
                        return show(mapping,form,request,response);
                    }
                }

         
        
    

    /**
     * This methods prepare the information for the stations admin page.
     * 
     *
     * @param    mapping Struts action mapping object
     * @param    form Struts action form object
     * @param    request http request object
     * @param    response http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward show(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
    	
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            
            StationsAdminForm stations=null;
            if(form==null){
                stations=new StationsAdminForm();
            }else{
                stations=(StationsAdminForm)form;
                stations.setFedexId(ep.getEmployeeId());
                stations.setLocCode(ep.getLocationCd());
            }

            
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            request.setAttribute("TodayDate",sdf.format(Utils.changeDateToTZ(new Date(),ep.getLocationTimeZone())));
            
            request.setAttribute("StationsAdminForm",stations);
            

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "StationsAdminAction show()", ep.getLocationCd(), true);

       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "StationsAdminAction show()", "", false);

       }
       return mapping.findForward("Success");
    }
    /**
     * This method Saves the input from stations admin screen.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward save(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
    	System.out.println("ActionForward save(ActionMapping mapping");
        StationsAdminForm stationsAdminForm=null;
        StationsAdminVO stationsAdminVO= new StationsAdminVO();
        
        try{
             if(form==null){
            	 stationsAdminForm=new StationsAdminForm();
            	 System.out.println("ActionForward save(ActionMapping mapping FORM NULL ");
             }else{
                stationsAdminForm=(StationsAdminForm)form;
                System.out.println("ActionForward save(ActionMapping mapping FORM NOT NULL ");
             }
             System.out.println("BEFORE AdminBizDelegate adminBizDelegate=new AdminBizDelegate() ");
             AdminBizDelegate adminBizDelegate=new AdminBizDelegate();
             System.out.println("AFTER AdminBizDelegate adminBizDelegate=new AdminBizDelegate() ");
             EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
             System.out.println("AFTER EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute ");
             stationsAdminForm.setFedexId(ep.getEmployeeId());
             System.out.println("AFTER stationsAdminForm.setFedexId(ep.getEmployeeId()) ");
             stationsAdminForm.setLocCode(ep.getLocationCd());
             System.out.println("AFTER stationsAdminForm.setLocCode(ep.getLocationCd()) ");
             
             
             
             BeanUtils.copyProperties( stationsAdminVO , stationsAdminForm );
             
             
             System.out.println("AFTER BeanUtils.copyProperties( stationsAdminVO , stationsAdminForm ) ");
             
             	
             System.out.println("in stationsAdmin =  "+stationsAdminVO.getFedexId());
             System.out.println("in stationsAdmin =  "+stationsAdminVO.getDateEntered());
             System.out.println("in stationsAdmin =  "+stationsAdminVO.getStatus());
             System.out.println("in stationsAdmin =  "+stationsAdminVO.getComments());
             //
             System.out.println("in stationsAdmin =  "+stationsAdminVO.getLocCode());
             System.out.println("in stationsAdmin =  "+stationsAdminVO.getCertificationTypeDescription());
          // start with stationsAdminVO saving this
                adminBizDelegate.saveStationsAdminInput(stationsAdminVO);
                System.out.println("adminBizDelegate.saveStationsAdminInput(stationsAdminVO)") ;
             // used to display status and move to menu.jsp
               List messages = new LinkedList();
               messages.add("Thank You");
               messages.add("Done saving input, please continue ..");
               
             request.setAttribute("messages",messages);
             
            

         } catch (IllegalAccessException e1) { 
        	 Constants.logger.debug(Utils.stackTraceToString(e1));
             ActionErrors ae=new ActionErrors();
             ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.IllegalAccessException"));
             saveErrors(request,ae); 
             System.out.println("IllegalAccessException") ;
         } catch (InvocationTargetException e2) { 
        	 Constants.logger.debug(Utils.stackTraceToString(e2));
             ActionErrors ae=new ActionErrors();
             ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.InvocationTargetException"));
             saveErrors(request,ae); 
             System.out.println("InvocationTargetException") ;
         } 
        catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);
            System.out.println("InvocationTargetException") ;           
         }
         return mapping.findForward("Success");
         

    }
    

  
}