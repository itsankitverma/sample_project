/**
 * DataHarvestTasksAction.java
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
 * This class is in charge of show the prepaid discrepancies
 * for the location, and save the changes made to them
 *
 * @author ccardenas
 */
public class PrepaidDiscrepanciesAction extends Action implements java.io.Serializable {
    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done.
     *
     * @param mapping  action mapping object
     * @param form     action form object
     * @param request  object
     * @param response object
     * @return Struts action forward
     * @throws Exception
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("userProfile") == null) return mapping.findForward("logout");
        if ("saveDscr".equals(request.getParameter("action"))) {
            return saveDscr(mapping, form, request, response);
        }
        else {
            return show(mapping, form, request, response);
        }
    }

    /**
     * This method will prepare the data for the page
     * to show the prepaid discrepancies.
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */

    private ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            PrepPoaBizDelegate bizPrP = new PrepPoaBizDelegate();
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            Integer pageNumber = ((PrepaidDiscrepanciesForm) form).getPageNumber();
            if(pageNumber == null)
                pageNumber = new Integer(1); //First page
            Hashtable result =  bizPrP.getPrepaidDiscrepanciesTable(ep.getLocationCd(),pageNumber);
            List dscr = (List) result.get("RESULTSET");
            PrepaidDiscrepanciesForm ccrForm = new PrepaidDiscrepanciesForm();
            ccrForm.setPrepaidDscr(dscr);
            ccrForm.setPageNumber(pageNumber);
            request.setAttribute("PrepaidDiscrepanciesForm", ccrForm);
            request.setAttribute("numberOfPages", result.get("NUMBEROFPAGES"));
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
     * This method will save the changes made
     * to the discrepancies.
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */

    private ActionForward saveDscr(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            PrepPoaBizDelegate biz = new PrepPoaBizDelegate();
            PrepaidDiscrepanciesForm ccrForm = (PrepaidDiscrepanciesForm) form;
            Collection dscr = ccrForm.getPrepaidDscr();
            Iterator iter = dscr.iterator();
            while (iter.hasNext()) {
                PrepaidDscrTableVO dep = (PrepaidDscrTableVO) iter.next();
                if (!dep.isModified()) {
                    iter.remove();
                }
            }
            biz.savePrepaidDscr(dscr, ep.getEmployeeId());
            request.setAttribute("PrepaidDscrTableVO", ccrForm);
        }
        catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveDepositsNumber"));
            saveErrors(request, ae);
        }
        return show(mapping, form, request, response);
    }
}