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

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;

import org.apache.struts.action.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * This class is used to manage the
 * request to show the Deposit Slip
 * batchs
 * @author  ccardenas
 */

public class BatchPaymentsAdminAction extends Action implements java.io.Serializable{
    public BatchPaymentsAdminAction() {
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
        if("moveDeposit".equals(request.getParameter("action"))){
            return moveDeposit(mapping,form,request,response);
        }else{
            if("listDeposits".equals(request.getParameter("action"))){
                return list(mapping,form,request,response);
            }else{
                if("moveEOD".equals(request.getParameter("action"))){
                    return moveEOD(mapping,form,request,response);
                }else{
                    if("reopenEOD".equals(request.getParameter("action"))){
                        return reopenEOD(mapping,form,request,response);
                    }else{
                        return show(mapping,form,request,response);
                    }

                }

            }
        }
    }

    /**
     * This methods prepare the information for the
     * page to show the list of Deposit Slips.
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
            BatchPaymentsAdminForm batchForm=null;
            if(form==null){
                batchForm=new BatchPaymentsAdminForm();
            }else{
                batchForm=(BatchPaymentsAdminForm)form;
            }

            batchForm.setLocationCd(ep.getLocationCd());
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            request.setAttribute("TodayDate",sdf.format(Utils.changeDateToTZ(new Date(),ep.getLocationTimeZone())));
            request.setAttribute("BatchPaymentsAdminForm",batchForm);
            request.setAttribute("eodCount",new HashMap());

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "BatchPaymentsAdminAction show()", ep.getLocationCd(), true);

       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "BatchPaymentsAdminAction show()", "", false);

       }
       return mapping.findForward("Success");
    }

    /**
     * This methods prepare the information for the
     * page to show the list of Deposit Slips.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward list(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       try{
            BatchPaymentsAdminForm batchForm=null;
            if(form==null){
                batchForm=new BatchPaymentsAdminForm();
            }else{
                batchForm=(BatchPaymentsAdminForm)form;
            }

            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");

            Date startDate=null;
            Date endDate=null;
            try{
               startDate=sdf.parse(batchForm.getStartDate());
               endDate=sdf.parse(batchForm.getEndDate());
            }catch(Exception e){
                startDate=new Date();
                endDate=startDate;
            }

            batchForm.setStartDate(sdf.format(startDate));
           batchForm.setEndDate(sdf.format(endDate));

            //getting deposit slips
            List depos=(List)bizComm.getBatchesToAdmin(ep.getLocationCd(),new java.sql.Date(startDate.getTime()),new java.sql.Date(endDate.getTime()));

            Map eodCount=new HashMap();
            Iterator iter=depos.iterator();
            int lastEodId=-1;
            int count=0;
            while(iter.hasNext()){
                DepositSlipTableVO dst=(DepositSlipTableVO)iter.next();

                if(lastEodId!=dst.getEodId()){
                    eodCount.put(new Integer(lastEodId),new Integer(count));
                    count=1;
                }else{
                    count++;
                }

                lastEodId=dst.getEodId();
            }

            eodCount.put(new Integer(lastEodId),new Integer(count));


            //getting Bank Accounts
            List accs=(List)bizComm.getBankAccByLocation(ep.getLocationCd());
            batchForm.setDeposits(depos);

            //putting the information in the request
            request.setAttribute("BatchPaymentsAdminForm",batchForm);
            request.setAttribute("BankAccounts",accs);
            request.setAttribute("eodCount",eodCount);
            request.setAttribute("TodayDate",sdf.format(Utils.changeDateToTZ(new Date(),ep.getLocationTimeZone())));

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "BatchPaymentsAdminAction getBatchesToAdmin()", "loc:" + ep.getLocationCd() + " startD:" + startDate + " endD:" + endDate,
                   true);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "BatchPaymentsAdminAction list()", "", false);
       }
       return mapping.findForward("Success");
    }


    /**
     * This method saves the changes deposit Date
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward moveDeposit(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        BatchPaymentsAdminForm batchForm=null;
        try{
             if(form==null){
                batchForm=new BatchPaymentsAdminForm();
             }else{
                batchForm=(BatchPaymentsAdminForm)form;
             }

             CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();
             EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");

             try{
                 SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
                 sdf.parse(batchForm.getNewDate());
                 bizComm.changeDepoPaymentsDate(ep.getLocationCd(),batchForm.getSelectedDepositCd(),batchForm.getNewDate());
             }catch(ParseException p){
                 Constants.logger.debug(Utils.stackTraceToString(p));
                 ActionErrors ae=new ActionErrors();
                 ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.EnteredDateInvalid"));
                 saveErrors(request,ae);
             }

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "BatchPaymentsAdminAction moveDeposit()", "" + batchForm.getSelectedDepositCd(), true);

         }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "BatchPaymentsAdminAction moveDeposit()", "" + batchForm.getSelectedDepositCd(), false);
         }

         return list(mapping,form,request,response);

    }

/**
     * This method saves the changes EOD Date
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward moveEOD(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        BatchPaymentsAdminForm batchForm=null;
        try{
             if(form==null){
                batchForm=new BatchPaymentsAdminForm();
             }else{
                batchForm=(BatchPaymentsAdminForm)form;
             }

             CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();
             EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");

             try{
                 SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
                 sdf.parse(batchForm.getNewDate());
                 bizComm.changePaymentsDate(ep.getLocationCd(),batchForm.getSelectedEodId(),batchForm.getNewDate());
             }catch(ParseException p){
                 Constants.logger.debug(Utils.stackTraceToString(p));
                 ActionErrors ae=new ActionErrors();
                 ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.EnteredDateInvalid"));
                 saveErrors(request,ae);
             }

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "BatchPaymentsAdminAction moveEOD()", "" + batchForm.getSelectedDepositCd(), true);

         }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "BatchPaymentsAdminAction moveEOD()", "" + batchForm.getSelectedDepositCd(), false);
         }

         return list(mapping,form,request,response);

    }

/**
     * This method reopen EOD
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward reopenEOD(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        BatchPaymentsAdminForm batchForm=null;
        try{
             if(form==null){
                batchForm=new BatchPaymentsAdminForm();
             }else{
                batchForm=(BatchPaymentsAdminForm)form;
             }

             CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();
             EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");

             bizComm.openSpecificEndOfDay(ep.getLocationCd(),batchForm.getSelectedEodId());

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "BatchPaymentsAdminAction reopenEOD()", "" + batchForm.getSelectedDepositCd(), true);

         }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "BatchPaymentsAdminAction reopenEOD()", "" + batchForm.getSelectedDepositCd(), false);
         }

         return list(mapping,form,request,response);

    }
}