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

/**
 * This class is used to manage the
 * request to show the Deposit Slip
 * batchs
 *
 * @author ccardenas
 */

public class DepositSlipAction extends Action implements java.io.Serializable {
    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("userProfile") == null) return mapping.findForward("logout");
        if ("saveDeposits".equals(request.getParameter("action"))) {
            return saveDeposits(mapping, form, request, response);
        }
        else {
            return show(mapping, form, request, response);
        }
    }

    /**
     * This methods prepare the information for the
     * page to show the list of Deposit Slips.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            Integer pageNumber = ((DepositSlipForm) form).getPageNumber();
            if(pageNumber == null)
                pageNumber = new Integer(1); //First page
            Hashtable result = bizComm.getDepositSlipReport(ep.getLocationCd(),pageNumber);
            //getting deposit slips
            List depos = (List) result.get("RESULTSET");
            //getting Bank Accounts
            List accs = (List) bizComm.getBankAccByLocation(ep.getLocationCd());
            DepositSlipForm ccrForm = new DepositSlipForm();
            ccrForm.setDeposits(depos);
            ccrForm.setPageNumber(pageNumber);
            //putting the information in the request
            request.setAttribute("DepositSlipForm", ccrForm);
            request.setAttribute("numberOfPages", result.get("NUMBEROFPAGES"));
            request.setAttribute("BankAccounts", accs);
            request.setAttribute("TodayDate", Utils.changeDateToTZ(new java.util.Date(), ep.getLocationTimeZone()));
        }
        catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request, ae);
        }
        return mapping.findForward("Success");
    }

    /**
     * This method saves the changes made on the deposit
     * slips.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward saveDeposits(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
            DepositSlipForm ccrForm = (DepositSlipForm) form;

            //getting the current date at the timezone of the location
            java.util.Date dt = Utils.changeDateToTZ(new java.util.Date(), ep.getLocationTimeZone());

            Collection depos = ccrForm.getDeposits();
            Iterator iter = depos.iterator();

            //iterating over the deposit slips
            while (iter.hasNext()) {
                DepositSlipTableVO dep = (DepositSlipTableVO) iter.next();
                if (!dep.isModified()) {
                    //removing if it is not modified
                    iter.remove();
                }
                else {
                    //validating dates
                   /* if ((dep.getDepoDt() != null && dep.getDepoDt().compareTo(dt) == 1) ||
                            (dep.getBankDepoDt() != null && dep.getBankDepoDt().compareTo(dt) == 1) ||
                            (dep.getDepoDt() != null && dep.getBankDepoDt() != null && dep.getDepoDt().compareTo(dep.getBankDepoDt()) == 1)) {

                        ActionErrors ae = new ActionErrors();
                        ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.DepositDatesProblem"));
                        saveErrors(request, ae);
                        return show(mapping, form, request, response);
                    }*/

                    if (dep.getStatusId() == 1) {
                        if (dep.getDepoDt() == null || dep.getBankDepoDt() == null) {
                            ActionErrors ae = new ActionErrors();
                            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.MustEnterDepositDates"));
                            saveErrors(request, ae);
                            return show(mapping, form, request, response);
                        }
                        dep.setCloseDt(dt);
                    }

                    LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "DepositSlipAction saveDeposits()", "" + dep.getDepositSlipCd(), true);
                }
            }
            //saving the changes to the db
            bizComm.saveDepositSlip(depos, ep.getEmployeeId());
            request.setAttribute("DepositSlipForm", ccrForm);
        }
        catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveDepositsNumber"));

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "DepositSlipAction saveDeposits()", "", false);

            saveErrors(request, ae);
        }
        return show(mapping, form, request, response);
    }
}