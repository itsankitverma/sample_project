/**
 * DepoTemplatesAdminAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;
import org.apache.struts.action.*;

import java.io.Serializable;
import java.util.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;

/**
 * This class is used to manage the
 * request for operations over the deposit templates
 * @author  ccardenas
 */
public class DepoTemplatesAdminAction extends Action implements java.io.Serializable{
    public DepoTemplatesAdminAction() {
    }

    AdminBizDelegate abd=new AdminBizDelegate(); //Bussiness Delegate for Administration
    
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
                if("loadPayments".equals(request.getParameter("action"))){
                    return show(mapping,form,request,response,false);
                }else{
                    return show(mapping,form,request,response,true);
                }   
            }    
        }

    }

    /**
     * This method provides the information to the page
     * showing the Deposit Templates. This page allows to
     * enter a new template and lists the existing templates.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @param    boolean stating if the template is being reloaded
     * @return   Struts action forward 
     * @exception Exception
     */
    private ActionForward show(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response,
    boolean reloadTempl)
    throws Exception {
       try{
            DepoTemplatesAdminForm dtForm=null;
            if(form==null){
                dtForm=new DepoTemplatesAdminForm();
            }else{
                dtForm=(DepoTemplatesAdminForm)form;
            }
            
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");           
            DepTemplController dtc=new DepTemplController();
            PaymentTypeController ptc=new PaymentTypeController();
            LocationController loc=new LocationController();
            
            //if the template is being reloaded  
            if(reloadTempl && dtForm.getCurrentDepTempl()!=null && dtForm.getCurrentDepTempl().getTemplId()!=null && dtForm.getCurrentDepTempl().getTemplId().intValue()!=0)
            {
            		//getting the template
                    dtForm.setCurrentDepTempl(dtc.getDepTempl(dtForm.getCurrentDepTempl().getTemplId()));
                    
                    //setting the values depending on the template information
                    dtForm.setLocalCurrencySelected("LOCAL".equals(dtForm.getCurrentDepTempl().getCurrencyType()) || "ALL".equals(dtForm.getCurrentDepTempl().getCurrencyType()));
                    dtForm.setUsdCurrencySelected("USD".equals(dtForm.getCurrentDepTempl().getCurrencyType()) || "ALL".equals(dtForm.getCurrentDepTempl().getCurrencyType()));
                    
                    //getting the locations where the template is applied
                    Collection colSel=dtc.getLocations(dtForm.getCurrentDepTempl().getTemplId());  
                    String[] arSel=new String[colSel.size()];                
                    Iterator iterSelLoc=colSel.iterator();
                    
                    //setting the location cd list
                    for(int i=0;iterSelLoc.hasNext();i++){
                        arSel[i]=((LocationVO)iterSelLoc.next()).getLocationCd();
                    }

                    //sorting by location
                    Arrays.sort(arSel);
                    dtForm.setTemplLocations(arSel);
                    
                    //getting the payment types
                    dtForm.setTemplPaymentTypes(dtc.getPaymentTypes(dtForm.getCurrentDepTempl().getTemplId()));

                    LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "DepoTemplatesAdminAction show()", dtForm.getCurrentDepTempl().getTemplDesc(), true);
            }else{
            	//if we are just showing the page for the user to enter a new template
                if(reloadTempl && (dtForm.getCurrentDepTempl()==null || dtForm.getCurrentDepTempl().getTemplId()==null || dtForm.getCurrentDepTempl().getTemplId().intValue()==0)){
                    clearForm(dtForm);
                }
            }
            
            //setting the value for Reimbursement type
            if(dtForm.getCurrentDepTempl().getCrcdReimbTypeCd()==null || "".equals(dtForm.getCurrentDepTempl().getCrcdReimbTypeCd())) dtForm.getCurrentDepTempl().setCrcdReimbTypeCd("EFT");            
            
            //getting and sorting all the locations
            if(request.getSession().getAttribute("AllLocations")==null){
                Collection colAll=null;
                
                //Check if employee is an Country Administrator to show only the locations according to his/her country assignated
                  if(ep.isCountryAdmin()){
                     colAll = abd.getLocationsForAdminCountryRole(ep.getEmployeeId(), Constants.COUNTRYADMIN);
                  }else{
                      colAll = loc.getAllLocations();}
                  
                String[] arAll=new String[colAll.size()];                
                Iterator iterAllLoc=colAll.iterator();

                for(int i=0;iterAllLoc.hasNext();i++){
                     arAll[i]=((LocationVO)iterAllLoc.next()).getLocationCd();
                }

                Arrays.sort(arAll);
                
                request.getSession().setAttribute("AllLocations",arAll);                
            }  
            
           
            dtForm.setAllLocations((Object[])((Object[])request.getSession().getAttribute("AllLocations")).clone());             
            
            //deleting the selected locations from all the lcoations
            if(dtForm.getTemplLocations()!=null && dtForm.getTemplLocations().length>0){
                Collection all=new ArrayList(Arrays.asList(dtForm.getAllLocations()));
                Collection sel=Arrays.asList(dtForm.getTemplLocations());                
                all.removeAll(sel);
                dtForm.setAllLocations(all.toArray());
                
                //getting all the payment types and removing the selected
                //payment types from all the payments
                if(dtForm.getAllPaymentTypes()==null) dtForm.setAllPaymentTypes(new ArrayList());
                for(int i=0;i<dtForm.getTemplLocations().length;i++){
                        Iterator itLocPt=ptc.getPaymentTypeByLocation((String)dtForm.getTemplLocations()[i]).iterator();                        
                        while(itLocPt.hasNext()){                            
                            boolean found=false;                            
                            PaymentTypeVO newPt=((PaymentTypeVO)itLocPt.next());
                            Integer locPId=newPt.getPaymentTypeId();
                            Iterator itTempPt=dtForm.getAllPaymentTypes().iterator();    
                            while(itTempPt.hasNext()){   
                               Integer tempPId=((PaymentTypeVO)itTempPt.next()).getPaymentTypeId();
                                if(locPId.equals(tempPId)){                        
                                    found=true;
                                    break;
                                }        
                            }
                            if(!found) dtForm.getAllPaymentTypes().add(newPt);
                        }                         
                }
            }else{
                if(dtForm.getTemplLocations()==null) dtForm.setTemplLocations(new String[0]);
            }

            if(dtForm.getTemplPaymentTypes()==null) dtForm.setTemplPaymentTypes(new ArrayList());
            
            //deleting the selected payment types from all the payment types            
            if((dtForm.getTemplPaymentTypes()!=null && !dtForm.getTemplPaymentTypes().isEmpty()) || //selected payment types comming from db
               (dtForm.getTemplPaymentTypesIds()!=null && dtForm.getTemplPaymentTypesIds().length>0))  //selected payment types comming from the page
               {


                  if(!dtForm.getTemplPaymentTypes().isEmpty()){
                        Iterator tpt=dtForm.getTemplPaymentTypes().iterator();
                        while(tpt.hasNext()){
                            Integer pymtId1=((PaymentTypeVO)tpt.next()).getPaymentTypeId();
                            Iterator allpt=dtForm.getAllPaymentTypes().iterator();
                            while(allpt.hasNext()){                    
                                Integer pymtId2=((PaymentTypeVO)allpt.next()).getPaymentTypeId();
                                if(pymtId1.equals(pymtId2)){                        
                                    allpt.remove();
                                }        
                            }    
                        }
                 }else{
                     if(dtForm.getTemplPaymentTypesIds().length>0){
                           for(int i=0;i<dtForm.getTemplPaymentTypesIds().length;i++){
                                 Iterator allpt=dtForm.getAllPaymentTypes().iterator(); 
                                 Integer pymtId1=dtForm.getTemplPaymentTypesIds()[i];
                                 while(allpt.hasNext()){
                                      PaymentTypeVO ptVO=((PaymentTypeVO)allpt.next());
                                      Integer pymtId2=ptVO.getPaymentTypeId();
                                      if(pymtId1.equals(pymtId2)){                        
                                          dtForm.getTemplPaymentTypes().add(ptVO);
                                          allpt.remove();
                                      }        
                                 }                                     
                           }
                     }
                 }
            }else{
                if(dtForm.getTemplPaymentTypes()==null) dtForm.setTemplPaymentTypes(new ArrayList());
                if(dtForm.getAllPaymentTypes()==null) dtForm.setAllPaymentTypes(new ArrayList());
            }
            
            TreeSet ts=new TreeSet(new TemplatesComparator());
            ts.addAll(dtc.getAllActiveDepTempls());
            dtForm.setAllTemplates(new ArrayList(ts));
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "DepoTemplatesAdminAction show()", "", false);
       }

       return mapping.findForward("Success");
    }
    
    /**
     * This method is used to save the information entered by
     * the Administrator.
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
       DepoTemplatesAdminForm dtForm=null; 
       try{
            if(form==null){
                dtForm=new DepoTemplatesAdminForm(); 
            }else{
                dtForm=(DepoTemplatesAdminForm)form;
            }
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");           
            
           //setting the correct currency type to be persisted in the db 
           if (dtForm.isLocalCurrencySelected() && dtForm.isUsdCurrencySelected()) dtForm.getCurrentDepTempl().setCurrencyType("ALL");
           else if(dtForm.isLocalCurrencySelected()) dtForm.getCurrentDepTempl().setCurrencyType("LOCAL");
           else if(dtForm.isUsdCurrencySelected()) dtForm.getCurrentDepTempl().setCurrencyType("USD");  
           
           //save the template information
           Collection colErrors=new CommonOpsBizDelegate().saveDepTempl(dtForm.getCurrentDepTempl(),dtForm.getTemplLocations(),dtForm.getTemplPaymentTypesIds());            
           
           //preparing the errors to be shown if any
           if(!colErrors.isEmpty()){
               ActionErrors ae=new ActionErrors();
               Iterator iterErrs= colErrors.iterator();
               StringBuffer sb=new StringBuffer();
               while (iterErrs.hasNext()){
                   sb.append((String)iterErrs.next()+"<br>");
               }
               
               ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.TemplOverlapError",sb));               
               
               ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CouldNotSaveTheChanges"));               
               saveErrors(request,ae);
               return show(mapping,form,request,response,false);
               
           }
           
           //clearing the form
           clearForm(dtForm);

           if(dtForm.getCurrentDepTempl().getTemplDesc()!= null && !dtForm.getCurrentDepTempl().getTemplDesc().equals(""))
           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "DepoTemplatesAdminAction save()",
                   dtForm.getCurrentDepTempl().getTemplDesc(), true);

           return show(mapping,form,request,response,false);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CouldNotSaveTemplate"));
            saveErrors(request,ae);


            if(dtForm.getCurrentDepTempl().getTemplDesc()!= null && !dtForm.getCurrentDepTempl().getTemplDesc().equals(""))
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "DepoTemplatesAdminAction save()",
                    dtForm.getCurrentDepTempl().getTemplDesc(), false);

            return show(mapping,form,request,response,false);
       }
    }
    
    /**
     * This method manage the requests to delete a template.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */    
    private ActionForward delete(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       DepoTemplatesAdminForm dtForm=null; 
       try{

            if(form==null){
                dtForm=new DepoTemplatesAdminForm();
            }else{
                dtForm=(DepoTemplatesAdminForm)form;
            }
            
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");           
            
            if(dtForm.getCurrentDepTempl()!=null &&
               dtForm.getCurrentDepTempl().getTemplId()!=null &&
               dtForm.getCurrentDepTempl().getTemplId().intValue()!=0){
                
                Integer templId=dtForm.getCurrentDepTempl().getTemplId();   
                deleteTempl(templId);

                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "DepoTemplatesAdminAction delete()", dtForm.getCurrentDepTempl().getTemplDesc(), true);
            }
            
            clearForm(dtForm);
            return show(mapping,form,request,response,false);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CouldNotDeleteTemplate"));
            saveErrors(request,ae);

            if(dtForm.getCurrentDepTempl()!=null && dtForm.getCurrentDepTempl().getTemplId()!=null)
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "DepoTemplatesAdminAction delete()", dtForm.getCurrentDepTempl().getTemplDesc(), false);

            return show(mapping,form,request,response,true);
       }

    }
    
    
    /**
     * This method clear the form.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */
    private void clearForm(DepoTemplatesAdminForm dtForm){
            dtForm.setTemplPaymentTypes(new ArrayList());
            dtForm.setTemplPaymentTypesIds(null);
            dtForm.setTemplLocations(null);
            dtForm.setCurrentDepTempl(new DepTemplVO());
            dtForm.setLocalCurrencySelected(false);
            dtForm.setUsdCurrencySelected(false);
    }
    
    /**
     * This method deletes the templates and the locations and
     * payment types associated
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */    
    private void deleteTempl(Integer templId)throws Exception{
                DepTemplController dtc=new DepTemplController();
                Iterator iterAnt=dtc.getLocations(templId).iterator();
                while(iterAnt.hasNext()){ //DELETING PRIOR LOCATIONS
                    dtc.removeLocation(templId,((LocationVO)iterAnt.next()).getLocationCd());
                }

                Iterator iterAntPT=dtc.getPaymentTypes(templId).iterator();
                while(iterAntPT.hasNext()){ //DELETING PRIOR PAYMENT TYPES
                    dtc.removePaymentType(templId,((PaymentTypeVO)iterAntPT.next()).getPaymentTypeId());
                }
                
               DepTemplVO dtVO=dtc.getDepTempl(templId);
               dtVO.setDisabTempl(1);
               dtc.updateDepTempl(dtVO);
    }

    /** 
     * This class is used to manage to compare
     * DepTemplVO objects.
     * @author  ccardenas
     */
    private static class TemplatesComparator implements Comparator,Serializable{
           public int compare(Object obj1, Object obj2) {
                try{
                    DepTemplVO lvo1=(DepTemplVO)obj1;
                    DepTemplVO lvo2=(DepTemplVO)obj2;                                                
                                                
                    return lvo1.getTemplCd().compareTo(lvo2.getTemplCd());

               }catch(Exception pe){
                    Constants.logger.debug(Utils.stackTraceToString(pe));
                    return -1;
               }
           }                
    }
    
    
}