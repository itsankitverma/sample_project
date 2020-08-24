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
public class PaymentsAdminAction extends Action implements java.io.Serializable{
    public PaymentsAdminAction() {
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
     * for the page that will show the previous payment
     * types and will allow to enter a new one
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
    throws Exception {
       try{
            PaymentsAdminForm paForm=null;
            if(form==null){
                paForm=new PaymentsAdminForm();
            }else{
                paForm=(PaymentsAdminForm)form;
            }
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");           
            PaymentTypeController ptc=new PaymentTypeController();
            PymtTypeLocController ptlc=new PymtTypeLocController();
            LocationController loc=new LocationController();
            PaymentCtgController pctg=new PaymentCtgController();            
            
            //if it is not comming from an error condition
            //it will need to get the info from the db
            if(!fromError){
            	
            	//if it needs to show a previous payment type
                if(paForm.getCurrentPayment()!=null && paForm.getCurrentPayment().getPaymentTypeId()!=null && paForm.getCurrentPayment().getPaymentTypeId().intValue()!=0){
                    paForm.setCurrentPayment(ptc.getPaymentType(paForm.getCurrentPayment().getPaymentTypeId()));

                    Collection colSel=ptlc.getPymtTypeLocLocationsByPayment(paForm.getCurrentPayment().getPaymentTypeId());  
                    String[] arSel=new String[colSel.size()];                
                    Iterator iterSelLoc=colSel.iterator();

                    for(int i=0;iterSelLoc.hasNext();i++){
                        arSel[i]=((PymtTypeLocVO)iterSelLoc.next()).getLocationCd();
                    }

                    Arrays.sort(arSel);
                    paForm.setPaymentLocations(arSel);   
                //if it will allow to enter a new payment type    
                }else{
                    paForm.setCurrentPayment(new PaymentTypeVO());
                }
            }
            Collection colAll=null;
            
            //Check if employee has the country administrator role, then get data only for the countries assignated
            if(ep.isCountryAdmin())
            {  colAll=abd.getLocationsForAdminCountryRole(ep.getEmployeeId(), Constants.COUNTRYADMIN);}
            else{ colAll=loc.getAllLocations();
            	}
            
            String[] arAll=new String[colAll.size()];                
            Iterator iterAllLoc=colAll.iterator();
              
            //preparing the locations lists
            for(int i=0;iterAllLoc.hasNext();i++){
                 arAll[i]=((LocationVO)iterAllLoc.next()).getLocationCd();
            }
                
            Arrays.sort(arAll);
            paForm.setAllLocations(arAll);             
            if(paForm.getPaymentLocations()!=null && paForm.getPaymentLocations().length>0){
                Collection all=new ArrayList(Arrays.asList(paForm.getAllLocations()));
                Collection sel=Arrays.asList(paForm.getPaymentLocations());                
                all.removeAll(sel);
                paForm.setAllLocations(all.toArray());
            }else{
                if(paForm.getPaymentLocations()==null) paForm.setPaymentLocations(new String[0]);
            }
            
            TreeSet ts=new TreeSet(new PaymentsComparator());
            ts.addAll(ptc.getAllActivePaymentTypes());
            paForm.setAllPayments(new ArrayList(ts));            
            
            paForm.setPaymentCtg(pctg.getPaymentCtgExtPaymentCtgs());


            if(paForm.getCurrentPayment().getPaymentTypeId() != null)
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "PaymentsAdminAction show()", paForm.getCurrentPayment().getPaymentTypeId().toString(), true);

       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "PaymentsAdminAction show()", "", false);
       }

       return mapping.findForward("Success");
    }
    
    /**
     * This method is executed to save a new entered
     * payment type
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
       PaymentsAdminForm paForm=null;

       try{
            if(form==null){
                paForm=new PaymentsAdminForm();
            }else{
                paForm=(PaymentsAdminForm)form;
            }

            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");           
            
            PaymentTypeController ptc=new PaymentTypeController();
            PymtTypeLocController ptlc=new PymtTypeLocController();
            
            if(paForm.getCurrentPayment()!=null && paForm.getCurrentPayment().getPaymentTypeId()!=null && paForm.getCurrentPayment().getPaymentTypeId().intValue()!=0){
                PaymentTypeVO fromDB=ptc.getPaymentType(paForm.getCurrentPayment().getPaymentTypeId());
                fromDB.setPaymentCd(paForm.getCurrentPayment().getPaymentCd());
                fromDB.setShtDesc(paForm.getCurrentPayment().getShtDesc());
                fromDB.setDescription(paForm.getCurrentPayment().getDescription());
                fromDB.setPaymentCtgId(paForm.getCurrentPayment().getPaymentCtgId());
                ptc.updatePaymentType(fromDB);

                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "PaymentsAdminAction save()", " " + paForm.getCurrentPayment().getPaymentTypeId(), true);

            }else{
                if(paForm.getCurrentPayment()!=null){
                    paForm.getCurrentPayment().setRodCombo(1);
                    paForm.getCurrentPayment().setPrpCombo(1);
                    paForm.getCurrentPayment().setPoaCombo(1);
                    paForm.getCurrentPayment().setOtherCombo(1);
                    paForm.getCurrentPayment().setCanDeact(1);
                    paForm.getCurrentPayment().setActivePymt(1);
                    ptc.setPaymentType(paForm.getCurrentPayment());
                    paForm.setCurrentPayment((PaymentTypeVO)ptc.getPaymentTypeByCode(paForm.getCurrentPayment().getPaymentCd()).toArray()[0]); //to get the payment type id generated by the sequence.

                    LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "PaymentsAdminAction save()", "" + paForm.getCurrentPayment().getPaymentTypeId(), true);
                }
            }
            
            Integer paymentTypeId=paForm.getCurrentPayment().getPaymentTypeId();
            Object[] paymentLocs=paForm.getPaymentLocations();
            
            Iterator iterAnt=ptlc.getPymtTypeLocLocationsByPayment(paForm.getCurrentPayment().getPaymentTypeId()).iterator();
            while(iterAnt.hasNext()){ //DELETING PRIOR LOCATIONS
                ptlc.removePymtTypeLoc(((PymtTypeLocVO)iterAnt.next()).getPymtTypeLocPK());
            }
            
            if(paymentLocs!=null){
                for(int i=0;i<paymentLocs.length;i++){
                    ptlc.setPymtTypeLoc(new PymtTypeLocVO(paymentTypeId,(String)paymentLocs[i]));
                }            
            }
            
            paForm.setPaymentLocations(null);
            paForm.setCurrentPayment(null);

            return show(mapping,form,request,response,false);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CouldNotSavePaymentType"));
            saveErrors(request,ae);

           if(paForm.getCurrentPayment()!=null && paForm.getCurrentPayment().getPaymentTypeId()!=null && paForm.getCurrentPayment().getPaymentTypeId().intValue()!=0)
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "PaymentsAdminAction save()", "", false);
           else
               LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "PaymentsAdminAction save()", "", false);

            return show(mapping,form,request,response,true);
       }
    }
    
    /**
     * This method is executed to delete a selected
     * payment type
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
       PaymentsAdminForm paForm=null; 
       try{
            
            if(form==null){
                paForm=new PaymentsAdminForm();
            }else{
                paForm=(PaymentsAdminForm)form;
            }

            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");           

            PaymentTypeController ptc=new PaymentTypeController();
            PymtTypeLocController ptlc=new PymtTypeLocController();
            
            Integer paymentTypeId=paForm.getCurrentPayment().getPaymentTypeId();
            Object[] paymentLocs=paForm.getPaymentLocations();
            
            Iterator iterAnt=ptlc.getPymtTypeLocLocationsByPayment(paForm.getCurrentPayment().getPaymentTypeId()).iterator();
            while(iterAnt.hasNext()){ //DELETING PRIOR LOCATIONS
                ptlc.removePymtTypeLoc(((PymtTypeLocVO)iterAnt.next()).getPymtTypeLocPK());
            }
       
            PaymentTypeVO ptVO=ptc.getPaymentType(paymentTypeId);            
            ptVO.setActivePymt(0);
            ptc.updatePaymentType(ptVO);
            
            paForm.setPaymentLocations(null);            
            paForm.setCurrentPayment(null);

            if(paymentTypeId != null)
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "PaymentsAdminAction delete()", paymentTypeId.toString(), true);

            return show(mapping,form,request,response,false);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CouldNotDeletePaymentType"));
            saveErrors(request,ae);
            paForm.setCurrentPayment(null);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "PaymentsAdminAction delete()", "", false);

            return show(mapping,form,request,response,false);
       }

    }
    
    /** 
     * This class is used to manage to compare
     * PaymentTypeVO objects.
     * @author  ccardenas
     */
    private static class PaymentsComparator implements Comparator,Serializable{
           public int compare(Object obj1, Object obj2) {
                try{
                    PaymentTypeVO lvo1=(PaymentTypeVO)obj1;
                    PaymentTypeVO lvo2=(PaymentTypeVO)obj2;                                                
                                                
                    return lvo1.getPaymentCd().compareTo(lvo2.getPaymentCd());

               }catch(Exception pe){
                    Constants.logger.debug(Utils.stackTraceToString(pe));
                    return -1;
               }
           }                
    }    
 
}