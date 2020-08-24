package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;

import org.apache.struts.action.*;

import java.util.*;

import com.fedex.lacitd.cashcontrol.common.*;
import org.apache.commons.beanutils.ConvertUtils;

/**
 * This class manage the requests from the POA summary screen
 *
 * @author ccardenas
 */
public class PoaSummaryAction extends Action implements java.io.Serializable {
    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("userProfile") == null) return mapping.findForward("logout");
        if ("ChangePaymentCurr".equals(request.getParameter("action"))) {
            return changePaymentCurr(mapping, form, request, response);
        }
        else if ("DeletePayment".equals(request.getParameter("action"))) {
            return deletePayment(mapping, form, request, response);
        }
        else if ("CloseEmployee".equals(request.getParameter("action"))) {
            return closeEmployee(mapping, form, request, response);
        }
        else if ("toPrepaid".equals(request.getParameter("action"))) {
            return mapping.findForward("toPrepaid");
        }
        else if ("toROD".equals(request.getParameter("action"))) {
            return mapping.findForward("toROD");
        }
        else if ("toCOD".equals(request.getParameter("action"))) {
            return mapping.findForward("toCOD");
        }     
        else if ("toFTC".equals(request.getParameter("action"))) {
            return mapping.findForward("toFTC");
        }     
        else if ("toGround".equals(request.getParameter("action"))) {
            return mapping.findForward("toGround");
        }
        else if ("showPage".equals(request.getParameter("action"))) {
            return show(mapping, form, request, response);
        }
        else if ("sortTable".equals(request.getParameter("action"))) {
            return show(mapping, form, request, response);
        }
        else if ("ReassignPayments".equals(request.getParameter("action"))) {
            return reassignPayments(mapping, form, request, response);
        }
        else {
            return show(mapping, form, request, response);
        }
    }

    /**
     * This method shows the list of POA payments entered for the location
     * and the courier.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward show(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        try {
            PoaSummaryForm ccrForm = (PoaSummaryForm) form;
            ////////////////////////////////
            // Initialization of parameters
            ////////////////////////////////
            Integer pageNumber = new Integer(1);
            String sortColumn = "paymentId";
            String sortDirection = "asc";
            int rowsByPage = 20; //Hard coded !!
            if (ccrForm.getPageNumber() != null)
                pageNumber = ccrForm.getPageNumber();
            if (ccrForm.getSortColumn() != null)
                sortColumn = ccrForm.getSortColumn();
            if (ccrForm.getSortDirection() != null)
                sortDirection = ccrForm.getSortDirection();
            ccrForm.setPageNumber(pageNumber);
            ccrForm.setSortColumn(sortColumn);
            ccrForm.setSortDirection(sortDirection);
            if ("ALL".equals(ccrForm.getCourier())) {
                ccrForm.setCourier(null);
                rowsByPage = 40; //Hard coded !!
            }
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            ////////////////////////////////////
            // Setting the supported currencies
            ////////////////////////////////////
            ccrForm.setSupportedCurrencies(ep.getSupportedCurrencies());

            PrepPoaBizDelegate bizPrP = new PrepPoaBizDelegate();
            CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
            //////////////////////////////////////////
            // Setting the currently used currencies
            //////////////////////////////////////////
            Collection colUsedCurr = bizPrP.getPoaUsedCurrencies(ep.getLocationCd(), ccrForm.getCourier());
            Iterator iterSuppCurr = ccrForm.getSupportedCurrencies().iterator();
            ccrForm.setCurrentlyUsedCurrencies(new ArrayList());
            while (iterSuppCurr.hasNext()) {
                SupportedCurrencyVO scVO = (SupportedCurrencyVO) iterSuppCurr.next();
                if (colUsedCurr.contains(scVO.getCurrencyCode())) {
                    ccrForm.getCurrentlyUsedCurrencies().add(scVO);
                }
            }
            /*
            if (ccrForm.getPreviousCurrencyCode() != null &&
                    !"".equals(ccrForm.getPreviousCurrencyCode()) &&
                    ccrForm.getCurrentCurrency() != null &&
                    !"".equals(ccrForm.getCurrentCurrency()) &&
                    !ccrForm.getCurrentCurrency().equals(ccrForm.getPreviousCurrencyCode())
            ) {
            }
            */

            if (ccrForm.getCurrentlyUsedCurrencies().size() == 1) {
                ccrForm.setCurrentCurrency(((SupportedCurrencyVO) ccrForm.getCurrentlyUsedCurrencies().toArray()[0]).getCurrencyCode());
            }
            else {
                if (ccrForm.getCurrentCurrency() == null) {
                    ccrForm.setCurrentCurrency(ep.getDefaultCurrency());
                }
                else {
                    boolean validCurr = false;
                    Iterator iterCurr = ep.getSupportedCurrencies().iterator();
                    while (iterCurr.hasNext()) {
                        SupportedCurrencyVO scVO = (SupportedCurrencyVO) iterCurr.next();
                        if (ccrForm.getCurrentCurrency().equalsIgnoreCase(scVO.getCurrencyCode())) {
                            validCurr = true;
                            break;
                        }
                    }
                    if (!validCurr) {
                        ccrForm.setCurrentCurrency(ep.getDefaultCurrency());
                    }
                }
            }
            /////////////////////////////
            // Getting the POA payments
            /////////////////////////////
            Hashtable result = bizPrP.getPoaSummaryTable(ep.getLocationCd(), ccrForm.getCourier(), ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
            ccrForm.setPayments((List) result.get("RESULTSET"));
            ccrForm.setNumberOfPages((Integer) result.get("NUMBEROFPAGES"));
            //////////////////////////////////
            // Getting the POA payment types
            //////////////////////////////////
            Collection paymentTypes = new PaymentTypeController().getPaymentTypeByPoaLocation(ep.getLocationCd());
            ccrForm.setPaymentTypes(paymentTypes);
            //////////////////////////////////////////////////////////////////
            // Getting the couriers with payments for the drop down list box
            //////////////////////////////////////////////////////////////////
            ccrForm.setEmployeesWithPayments(bizComm.getEmployeesWithPayments(ep.getLocationCd()));
            /////////////////////////////////////////////////////////////////
            // Totals calculation
            /////////////////////////////////////////////////////////////////
            calcTotals(ccrForm,ep.getLocationCd(),ccrForm.getCourier(),ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage));

            //sort, if it was requested
            /*
            if ("account".equals(request.getParameter("RODSortColumn")) ||
                    "client".equals(request.getParameter("RODSortColumn")) ||
                    "desc".equals(request.getParameter("RODSortDirection"))) {
                sortTable(mapping, form, request, response);
            }
            */
            setPagingAttributes(request);
            request.setAttribute("PoaSummaryForm", ccrForm);
        }
        catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request, ae);
        }
        return mapping.findForward("Success");
    }

    private void calcTotals(PoaSummaryForm ccrForm, String locationCd, String employeeId, String currentCurrencyCd, Integer pageNumber, Integer rowsByPage) throws Exception {
        PrepPoaBizDelegate delegate = new PrepPoaBizDelegate();
        TotalSummaryVO totalSummaryVO = delegate.getPoaDetailsTotal(locationCd,employeeId,currentCurrencyCd,pageNumber,rowsByPage);
        ccrForm.setCashTotal(totalSummaryVO.getCashTotal().doubleValue());
        ccrForm.setCoupTotal(totalSummaryVO.getCouponTotal().doubleValue());
        ccrForm.setDepositTotal(totalSummaryVO.getDepositTotal().doubleValue());
        ccrForm.setCreditCardTotal(totalSummaryVO.getCreditCardTotal().doubleValue());
        ccrForm.setCheckTotal(totalSummaryVO.getCheckTotal().doubleValue());
        ccrForm.setTotalPayments(ccrForm.getCashTotal() + ccrForm.getCoupTotal() + ccrForm.getCheckTotal() + ccrForm.getCreditCardTotal() + ccrForm.getDepositTotal());
    }

    /**
     * This method is used to reassign payments to another location and courier
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward reassignPayments(ActionMapping mapping,
                                           ActionForm form,
                                           HttpServletRequest request,
                                           HttpServletResponse response)
            throws Exception {
        PoaSummaryForm ccrForm = (PoaSummaryForm) form;
        Iterator iterRec = ccrForm.getPayments().iterator();
        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

        if (new EmployeeController().getEmployee(ccrForm.getNewEmployeeId()) == null) {
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.CourierDoesNotExist"));
            saveErrors(request, ae);
            return show(mapping, form, request, response);
        }

        PoaPaymentController rc = new PoaPaymentController();
        while (iterRec.hasNext()) {
            PoaSummaryTableVO rec = (PoaSummaryTableVO) iterRec.next();

            if (rec.isSelected()) {
                PoaPaymentVO rVO = rc.getPoaPayment(rec.getPoaPaymentsId());
                rVO.setOrigEmployeeId(rVO.getCourierId());
                rVO.setReassEmpId(ep.getEmployeeId());
                rVO.setCourierId(ccrForm.getNewEmployeeId());
                rVO.setLocationCd(ccrForm.getNewReassLocationCd());

                //Validate Currency for the country
                String curResult = Utils.validateCountryCurencyInProcess(rVO.getLocationCd(), rVO.getPaymentCurrency());
                if (curResult != null) {
                    rVO.setPaymentCurrency(curResult);
                }

                rc.updatePoaPayment(rVO);
            }
        }

        return show(mapping, form, request, response);
    }

    /**
     * This method changes the currency of the payment.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward changePaymentCurr(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response)
            throws Exception {
        PrepPoaBizDelegate bizPrP = new PrepPoaBizDelegate();
        bizPrP.changePOAPaymentCurrency(Integer.parseInt(request.getParameter("poaPaymentId")), request.getParameter("newCurr"));

        return show(mapping, form, request, response);
    }

    /**
     * Delete a POA payment
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward deletePayment(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response)
            throws Exception {
        PoaSummaryForm frm = null;
        if (form == null) {
            frm = new PoaSummaryForm();
        } else {
            frm = (PoaSummaryForm) form;
        }

        if (frm.getPoaPaymentsId() != 0) {
            new PoaPaymentController().removePoaPayment(new Integer(frm.getPoaPaymentsId()));
        }

        return show(mapping, form, request, response);
    }

    /**
     * Close the current courier.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward closeEmployee(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response)
            throws Exception {
        PoaSummaryForm ccrForm = (PoaSummaryForm) form;
        Collection colCourier = new ArrayList();
        colCourier.add(ccrForm.getCourier());

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

        CommonOpsBizDelegate biz = new CommonOpsBizDelegate();
        if (biz.closeCouriers(ep.getEmployeeId(), ep.getLocationCd(), colCourier)) {
            return mapping.findForward("Summary");
        } else {
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.AllInvoicesStateToClose"));
            saveErrors(request, ae);
            return show(mapping, form, request, response);
        }
    }

    private void setPagingAttributes(HttpServletRequest request) throws Exception {
        Integer length = null, currentPage = null, offset = null;
        if (request.getParameter("currentPage") != null) {
            currentPage = ((Integer) ConvertUtils.convert((String) request.getParameter("currentPage"), Class.forName("java.lang.Integer")));

            if (currentPage.intValue() == 0) currentPage = new Integer(1);
        } else
            currentPage = new Integer(1);

        if (request.getParameter("length") != null) {
            length = ((Integer) ConvertUtils.convert((String) request.getParameter("length"), Class.forName("java.lang.Integer")));

            if (length.intValue() == 0) length = new Integer(20);
        } else
            length = new Integer(20);

        offset = new Integer(length.intValue() * (currentPage.intValue() - 1));

        request.setAttribute("currentPage", currentPage);
        request.setAttribute("length", length);
        request.setAttribute("offset", offset);
    }
}