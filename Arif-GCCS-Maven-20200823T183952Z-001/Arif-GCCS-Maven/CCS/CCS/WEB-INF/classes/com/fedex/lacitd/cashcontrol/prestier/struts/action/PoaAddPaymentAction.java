/**
 * PoaAddPaymentAction.java
 *
 *
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK;
//import com.fedex.lacitd.cashcontrol.interfaces.importPayments.PoaDetail;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import org.apache.struts.action.*;

import java.util.*;

/**
 * This class is in charge of the POA
 * payments entering, deleting and showing
 *
 * @author ccardenas
 */
public class PoaAddPaymentAction extends Action implements java.io.Serializable {
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
        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
        if (ep == null) return mapping.findForward("CloseWindow");
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();
        //make sure this request is not a duplicate request
        Integer requestID = (Integer) request.getSession().getAttribute("requestID");
        if (requestID == null || requestID.intValue() <= 0)
            request.getSession().setAttribute("requestID", new Integer(-1));
        else {
            String requestIDParamStr = request.getParameter("requestID");
            int requestIDParam = -1;
            try {
                requestIDParam = Integer.parseInt(requestIDParamStr);
            }
            catch (Exception e) {
                requestIDParam = -1;
            }
            if (requestID.intValue() != requestIDParam) {
                PoaAddPaymentForm frmNew = new PoaAddPaymentForm();
                frmNew.getPayment().setCourierId(frm.getPayment().getCourierId());
                frmNew.getPayment().setPaymentCurrency(frm.getPayment().getPaymentCurrency());
                request.getSession().removeAttribute("POASurCharges");
                return show(mapping, frmNew, request, response);
            }
            request.getSession().setAttribute("requestID", new Integer(requestID.intValue() + 1));
        }

        if ("addDetail".equals(request.getParameter("action"))) {
            return addDetail(mapping, form, request, response);
        }
        else if ("savePayment".equals(request.getParameter("action"))) {
            return savePayment(mapping, form, request, response);
        }
        else if ("deleteDetail".equals(request.getParameter("action"))) {
            return deleteDetail(mapping, form, request, response);
        }
        else if ("findInvoice".equals(request.getParameter("action"))) {
            return findInvoice(mapping, form, request, response);
        }
        else if ("findCustomer".equals(request.getParameter("action"))) {
            return findCustomer(mapping, form, request, response);
        }
        else if ("findInvoicesByAccount".equals(request.getParameter("action"))) {
            return findInvoicesByAccount(mapping, form, request, response);
        }
        else if ("addFoundDetails".equals(request.getParameter("action"))) {
            return addFoundDetails(mapping, form, request, response);
        }
        else {
            return show(mapping, form, request, response);
        }
    }
    /**
     * This method is executed to add an invoice to the
     * current POA payment.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward addDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

        PoaDetailSurchargesVO pdsVO = new PoaDetailSurchargesVO();
        pdsVO.getPoaDetail().setInvCurrency(frm.getCurrentCurrency());
        
        String invoiceNo = ((PoaDetailSurchargesVO) frm.getDetails().get(0)).getPoaDetail().getInvoiceNbr();
        //Validate whether the invoice number matches the Fedex account number
        if (!invoiceNo.equals("999999999") && !validateInvoice(frm)){        	
        	// To reset the values if there is invalid invoice
        	pdsVO = (PoaDetailSurchargesVO) frm.getDetails().get(0);
        	pdsVO.getPoaDetail().setAmount(0.00);
        	pdsVO.getPoaDetail().setCouponAmt(0.00);
        	pdsVO.setUsdAmount(0.00);
        	request.setAttribute("InvoiceMatch", "false");
        	ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.InvalidInvoice", invoiceNo));
            saveErrors(request, ae);
        }else{
        	//add a new PoaDetail to contain the next invoice
            frm.getDetails().add(0, pdsVO);	
        }
        
        Collection paymentTypes = new PaymentTypeController().getPaymentTypeByPoaLocation(ep.getLocationCd());
        frm.setPaymentTypes(paymentTypes);

        request.setAttribute("PoaAddPaymentForm", frm);

        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));

        return mapping.findForward("ShowToEnter");
    }

    /**
     * This method is executed to delete an invoice on the
     * current POA payment.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward deleteDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

        Collection paymentTypes = new PaymentTypeController().getPaymentTypeByPoaLocation(ep.getLocationCd());
        frm.setPaymentTypes(paymentTypes);

        Map mapSC = (Map) request.getSession().getAttribute("POASurCharges");
        if (mapSC != null && !mapSC.isEmpty()) {
            mapSC.remove(((PoaDetailSurchargesVO) frm.getDetails().get(frm.getDelIndex())).getPoaDetail().getInvoiceNbr());
        }

        //delete the selected PoaDetail (invoice)
        frm.getDetails().remove(frm.getDelIndex());

        request.setAttribute("PoaAddPaymentForm", frm);

        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));

        return mapping.findForward("ShowToEnter");
    }

    /**
     * This method is executed to add an invoice on the
     * current POA payment. The invoice was found and selected
     * from the outstanding invoices list
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward addFoundDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();
        Iterator iterFound = frm.getInvoices().iterator();
        //iterating over the invoices
        while (iterFound.hasNext()) {
            PoaOutstInvoicesVO poiVO = (PoaOutstInvoicesVO) iterFound.next();
            if (!"USD".equals(poiVO.getCurrencyCd())) { // Code introduced to manage the situtions where the currency code from OCEAN are diff than in GCCS.
                String localCurrCd = null;
                Iterator iterCurrs = ep.getSupportedCurrencies().iterator();
                while (iterCurrs.hasNext()) {
                    SupportedCurrencyVO sVO = (SupportedCurrencyVO) iterCurrs.next();
                    localCurrCd = sVO.getCurrencyCode();
                    if (!"USD".equals(localCurrCd)) {
                        break;
                    } else {
                        localCurrCd = null;
                    }
                }
                if (localCurrCd != null) poiVO.setCurrencyCd(localCurrCd);
            }
            //if the invoice is selected it will add it to the current POA payment
            if (poiVO.isSelected()) {
                //creating a new detail object
                PoaDetailSurchargesVO pdcVO = new PoaDetailSurchargesVO();
                //setting the properties
                pdcVO.getPoaDetail().setPoaDetailId(new Integer(0));
                pdcVO.getPoaDetail().setInvoiceNbr(poiVO.getInvoiceNbr());
                pdcVO.getPoaDetail().setInvCurrency(poiVO.getCurrencyCd());
                pdcVO.getPoaDetail().setPoaPaymentsId(frm.getPayment().getPoaPaymentsId().intValue());

                //if the account was not assigned, get the account from the invoices
                if (frm.getPayment().getAccountNbr() == null || "".equals(frm.getPayment().getAccountNbr())) {
                    frm.getPayment().setAccountNbr(poiVO.getFedexAccountNbr());
                    frm.getPayment().setCustomerNm(poiVO.getCustomerNm());
                }

                //selecting the proper exchange rate
                if (frm.getPayment().getExchRate() == 0 || frm.getPayment().getExchRate() == 1) {
                    frm.getPayment().setExchRate(1 / poiVO.getExchRate());
                }

                //set amounts
                if (frm.getPayment().getPaymentCurrency().equals(poiVO.getCurrencyCd())) {
                    pdcVO.getPoaDetail().setAmount(poiVO.getAmtDue());
                } else {

                    if ("USD".equals(frm.getPayment().getPaymentCurrency())) {
                        pdcVO.getPoaDetail().setAmount(poiVO.getAmtDue() / frm.getPayment().getExchRate());
                    } else {
                        pdcVO.getPoaDetail().setAmount(poiVO.getAmtDue() * frm.getPayment().getExchRate());
                    }
                }

                if ("USD".equals(frm.getPayment().getPaymentCurrency())) {
                    pdcVO.setUsdAmount(pdcVO.getPoaDetail().getAmount());
                } else {
                    pdcVO.setUsdAmount(pdcVO.getPoaDetail().getAmount() / frm.getPayment().getExchRate());
                }
                frm.getDetails().add(pdcVO);
            }

        }

        Collection paymentTypes = new PaymentTypeController().getPaymentTypeByPoaLocation(ep.getLocationCd());
        frm.setPaymentTypes(paymentTypes);
        request.setAttribute("PoaAddPaymentForm", frm);
        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));
        return mapping.findForward("ShowToEnter");
    }

    /**
     * This method is executed to get the outstanding
     * invoices for an account number.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward findInvoicesByAccount(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Constants.logger.debug("findInvoicesByAccount() method called");
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();
        Integer pageNumber = frm.getPageNumber();
        if (pageNumber == null)
            pageNumber = new Integer(1);
        PrepPoaBizDelegate biz = new PrepPoaBizDelegate();

        Constants.logger.debug("payment.accountNbr: " + frm.getPayment().getAccountNbr());

        Hashtable result = biz.getPoaOustInvoices(frm.getPayment().getAccountNbr(), null, pageNumber);

        Collection colInv = (Collection) result.get("RESULTSET");
        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));
        frm.setInvoices((List) colInv);
        frm.setPageNumber(pageNumber);
        request.setAttribute("PoaAddPaymentForm", frm);
        request.setAttribute("numberOfPages", result.get("NUMBEROFPAGES"));
        return mapping.findForward("FindInvoices");
    }

    /**
     * This method is executed to get an invoice
     * by the invoice number.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward findInvoice(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();
        Integer pageNumber = frm.getPageNumber();
        if (pageNumber == null)
            pageNumber = new Integer(1);
        PrepPoaBizDelegate biz = new PrepPoaBizDelegate();
        Hashtable result = biz.getPoaOustInvoices(null, frm.getFilter(), pageNumber);
        Collection colInv = (Collection) result.get("RESULTSET");
        frm.setInvoices((List) colInv);
        request.setAttribute("PoaAddPaymentForm", frm);
        request.setAttribute("numberOfPages", result.get("NUMBEROFPAGES"));
        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));
        frm.setPageNumber(pageNumber);
        return mapping.findForward("FindInvoices");
    }

    /**
     * This method is executed to get information of an
     * account number.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward findCustomer(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();
        PrepPoaBizDelegate biz = new PrepPoaBizDelegate();
        Hashtable result = biz.getPoaOustInvoices(frm.getFilter(), null, new Integer(1)); //the first ocurrence
        Collection colInv = (Collection) result.get("RESULTSET");
        if (colInv == null || colInv.isEmpty()) {
            request.setAttribute("CustomerInvoice", null);
        } else {
            PoaOutstInvoicesVO poi = (PoaOutstInvoicesVO) ((List) colInv).get(0);
            request.setAttribute("CustomerInvoice", ((List) colInv).get(0));
        }
        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));
        return mapping.findForward("FindCustomer");
    }

    /**
     * This method is executed to get information of an
     * account number.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward findCustomerService(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;

        PrepPoaBizDelegate biz = new PrepPoaBizDelegate();

        String filter = request.getParameter("filter");

        Hashtable result = biz.getPoaOustInvoices(filter, null, new Integer(1)); //the first ocurrence

        Collection colInv = (Collection) result.get("RESULTSET");

        if (colInv == null || colInv.isEmpty())
        {
            request.setAttribute("CustomerInvoice", null);
        }
        else
        {
            PoaOutstInvoicesVO poi = (PoaOutstInvoicesVO) ((List) colInv).get(0);
            request.setAttribute("CustomerInvoice", ((List) colInv).get(0));
        }

        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));

        return mapping.findForward("FindCustomerService");
    }

    /**
     * This method is executed to save the
     * current POA payment.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward savePayment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();
        PoaDetailVO pdVO = ((PoaDetailSurchargesVO) frm.getDetails().get(0)).getPoaDetail();
        if ((pdVO.getInvoiceNbr() == null || "".equals(pdVO.getInvoiceNbr()))
                || pdVO.getAmount() + pdVO.getCouponAmt() <= 0
        ) {
            frm.getDetails().remove(0);//removing the empty detail
        }

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
        //setting location,employee and coupon amount
        frm.getPayment().setLocationCd(ep.getLocationCd());
        frm.getPayment().setReceivedEmpId(ep.getEmployeeId());
        frm.getPayment().setCoupPymtAmt(frm.getTotalCoupon());
        int poaPaymentId = 0;

        //if it is an update of an existing payment
        if (frm.getPayment().getPoaPaymentsId() != null && frm.getPayment().getPoaPaymentsId().intValue() != 0) {

            if ((frm.getPayment().getRcptNbr() == null)) {
                if (frm.getRcptNbrPrev() != null) {
                    frm.getPayment().setRcptChngEmpId(ep.getEmployeeId());
                    frm.getPayment().setOrigRcptNbr(frm.getRcptNbrPrev());
                }
            } else {
                if (!frm.getPayment().getRcptNbr().equals(frm.getRcptNbrPrev())) {
                    frm.getPayment().setRcptChngEmpId(ep.getEmployeeId());
                    frm.getPayment().setOrigRcptNbr(frm.getRcptNbrPrev());
                }
            }

            poaPaymentId = frm.getPayment().getPoaPaymentsId().intValue();
            
        	/*
        	 * 
             * Release4.6-New Top issues
             * 
             * Issue #251            	 * 
        	 * 
        	 * To make all the modification inside the same trx
        	 * the caller must send a Collection of PoaDetailVO
        	 */
            
            Collection details = makeNewCollectionDetails( frm.getDetails());

            new PrepPoaBizDelegate().updatePoaPayment(frm.getPayment(), details);

        } else {
            //inserting the POA Payment
            CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
            SystemUtilsBizDelegate sysBiz = new SystemUtilsBizDelegate();
            int result = bizComm.existsEmployeeLocation(frm.getPayment().getLocationCd(), frm.getPayment().getCourierId());
            switch (result) {
                case 0:
                    break;
                case 1:
                    {
                        EmployeeVO empVO = sysBiz.findFedExEmployee(frm.getPayment().getCourierId());
                        if (empVO == null) {
                            empVO = new EmployeeVO(frm.getPayment().getCourierId(), "Unknown Employee", "", "", "ROD", new java.util.Date(), "0", 0, null, 0, 0, null, 1);
                        }
                        new EmployeeController().setEmployee(empVO);
                    }
                    break;
                default:
                    {
                        ActionErrors ae = new ActionErrors();
                        ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.LocationNonExist", frm.getPayment().getLocationCd()));
                        saveErrors(request, ae);
                        request.setAttribute("PoaAddPaymentForm", frm);

                        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));

                        return mapping.findForward("ShowToEnter");
                    }
            }
            frm.getPayment().setLocationCd(ep.getLocationCd());
            if ((frm.getPayment().getRcptNbr() == null)) {
                if (frm.getRcptNbrPrev() != null) {
                    frm.getPayment().setRcptChngEmpId(ep.getEmployeeId());
                    frm.getPayment().setOrigRcptNbr(frm.getRcptNbrPrev());
                }
            } else {
                if (!frm.getPayment().getRcptNbr().equals(frm.getRcptNbrPrev())) {
                    frm.getPayment().setRcptChngEmpId(ep.getEmployeeId());
                    frm.getPayment().setOrigRcptNbr(frm.getRcptNbrPrev());
                }
            }

/* check for a valid request */
            if (isTokenValid(request))
            {
                resetToken(request);

            	/*
            	 * 
	             * Release4.6-New Top issues
	             * 
	             * Issue #251            	 * 
            	 * 
            	 * To make all the modification inside the same trx
            	 * the caller must send a Collection of PoaDetailVO
            	 */
                
                Collection details = makeNewCollectionDetails( frm.getDetails());
                
                poaPaymentId = new PrepPoaBizDelegate().savePoaPayment(frm.getPayment(), details);

            }
            else
            {
                System.out.println(" not a valid token !!." );
            }
        }
        Map mapSC = (Map) request.getSession().getAttribute("POASurCharges");
        if (mapSC != null && !mapSC.isEmpty()) {
            saveSurcharges(poaPaymentId, mapSC); //saving the surcharges
        }
        request.setAttribute("submitParent", "submitParent");
        PoaAddPaymentForm frmNew = new PoaAddPaymentForm();
        frmNew.getPayment().setCourierId(frm.getPayment().getCourierId());
        frmNew.getPayment().setPaymentCurrency(frm.getPayment().getPaymentCurrency());

        request.getSession().removeAttribute("POASurCharges");
        return show(mapping, frmNew, request, response);
    }

    /**
     * This method is executed to show the page
     * with info of the current POA payment being entered
     * or modified.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Constants.logger.debug("show() method called");
        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
        PoaAddPaymentForm frm = (PoaAddPaymentForm) form;
        if (frm == null) frm = new PoaAddPaymentForm();

        //If I enter for first time I delete the SurCharges (if any is in session)
        if (frm.getDetails() == null || frm.getDetails().isEmpty()) request.getSession().removeAttribute("POASurCharges");
        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));

        if (frm.getPayment().getPoaPaymentsId() != null && frm.getPayment().getPoaPaymentsId().intValue() != 0) {
            PoaDetailController pdc = new PoaDetailController();
            PrepPoaBizDelegate ppbd = new PrepPoaBizDelegate();
            frm.setPayment(new PoaPaymentController().getPoaPayment(frm.getPayment().getPoaPaymentsId()));
            frm.setRcptNbrPrev(frm.getPayment().getRcptNbr());

            Iterator iterPd = pdc.getPoaDetailPoaDetails(frm.getPayment().getPoaPaymentsId().intValue()).iterator();
            Collection colPdSur = new ArrayList();

            while (iterPd.hasNext()) {
                PoaDetailVO pdVO = (PoaDetailVO) iterPd.next();

                PoaDetailSurchargesVO pdsVO = new PoaDetailSurchargesVO();
                pdsVO.setPoaDetail(pdVO);

                if ("USD".equals(frm.getPayment().getPaymentCurrency())) {
                    pdsVO.setUsdAmount(pdVO.getAmount() + pdVO.getCouponAmt());
                } else {
                    double exchRate = frm.getPayment().getExchRate() == 0 ? 1.0 : frm.getPayment().getExchRate();
                    pdsVO.setUsdAmount((pdVO.getAmount() + pdVO.getCouponAmt()) / exchRate);
                }
                pdsVO.setSurChargesTotal(ppbd.getSurchargesTotalByPoaDetail(pdVO.getPoaDetailId().intValue()));
                colPdSur.add(pdsVO);
            }
            frm.setDetails((List) colPdSur);
        }
        PoaDetailSurchargesVO pdsVO = new PoaDetailSurchargesVO();
        frm.getDetails().add(0, pdsVO);
        Collection paymentTypes = new PaymentTypeController().getPaymentTypeByPoaLocation(ep.getLocationCd());
        frm.setPaymentTypes(paymentTypes);
        request.setAttribute("PoaAddPaymentForm", frm);
        frm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));


            saveToken(request);
        
        return mapping.findForward("ShowToEnter");
    }

    /**
     * This method is executed to save the surcharges
     * associated to a POA payment.
     *
     * @param poaPaymentId
     * @param mapSC
     * @throws Exception
     */
    private void saveSurcharges(int poaPaymentId, Map mapSC) throws Exception {
        PoaDetailController pdc = new PoaDetailController();
        PoaSurchargesController psc = new PoaSurchargesController();
        Iterator iterPD = pdc.getPoaDetailPoaDetails(poaPaymentId).iterator();
        while (iterPD.hasNext()) {
            PoaDetailVO pdVO = (PoaDetailVO) iterPD.next();
            Collection colAllSC = (Collection) mapSC.get(pdVO.getInvoiceNbr());
            if (colAllSC != null && !colAllSC.isEmpty()) {
                Iterator iterSC = colAllSC.iterator();
                while (iterSC.hasNext()) {
                    GenericSurchargeVO gsVO = (GenericSurchargeVO) iterSC.next();
                    if (gsVO.getCollectedAmt() > 0 || !gsVO.isNewSurcharge()) {
                        PoaSurchargesVO rsVO = new PoaSurchargesVO();
                        rsVO.setPoaDetailId(pdVO.getPoaDetailId());
                        rsVO.setSurchargeCd(gsVO.getSurchargeCd());
                        rsVO.setAppliedAmt(gsVO.getCollectedAmt());
                        if (gsVO.isNewSurcharge()) {
                            psc.setPoaSurcharges(rsVO);
                        } else {
                            if (gsVO.getCollectedAmt() > 0) {
                                psc.updatePoaSurcharges(rsVO);
                            } else {
                                psc.removePoaSurcharges(new PoaSurchargesPK(pdVO.getPoaDetailId(), rsVO.getSurchargeCd()));
                            }
                        }
                    }
                }
            }
        }
    }
    

	/*
	 * 
     * Release4.6-New Top issues
     * 
     * Issue #251            	 * 
	 * 
	 * To make all the modification inside the same trx
	 * the caller must send a Collection of PoaDetailVO
	 */
    
    private Collection makeNewCollectionDetails(Collection details)
    {
    	if (details == null) return null;
    	
    	Collection lst = new ArrayList();
    	
    	Iterator item = details.iterator();
    	
    	while(item.hasNext())
    	{
    		PoaDetailSurchargesVO detail = (PoaDetailSurchargesVO) item.next();
    		
            PoaDetailVO poaDetail = new PoaDetailVO();
            
          	poaDetail.setInvoiceNbr( detail.getPoaDetail().getInvoiceNbr());
          	poaDetail.setAmount( detail.getPoaDetail().getAmount());          //   **
          	poaDetail.setCouponAmt( detail.getPoaDetail().getCouponAmt());   //**

          	poaDetail.setPoaDetailId( new Integer(0));
          	
          	lst.add( poaDetail);
    	}
    	
    	return lst; 
    }
    
    /*
     * 
     * Data Integrity BRS #1.1   	 * 
	 * 
	 * To validate the Invoice and Fedex account number
	 * authour: Sendil
	 */
    public boolean validateInvoice(PoaAddPaymentForm frm) throws Exception{
        PrepPoaBizDelegate biz = new PrepPoaBizDelegate();
        PoaDetailSurchargesVO pdsVO = (PoaDetailSurchargesVO) frm.getDetails().get(0);
        boolean result = biz.isInvoiceFedexAcctMatch(frm.getPayment().getAccountNbr(), pdsVO.getPoaDetail().getInvoiceNbr());
        return result;
    }
}