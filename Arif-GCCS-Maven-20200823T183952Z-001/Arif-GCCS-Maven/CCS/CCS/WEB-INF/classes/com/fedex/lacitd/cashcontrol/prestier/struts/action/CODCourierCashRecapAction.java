/**
 * CODCourierCashRecapAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import com.fedex.common.j2ee.mcd.MCD;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CommonOpsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CODBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.controller.EmployeeController;
import com.fedex.lacitd.cashcontrol.datatier.controller.PaymentTypeController;
import com.fedex.lacitd.cashcontrol.datatier.controller.COD_ReceivablesController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_RecStatusVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_ReceivablesVO;
import com.fedex.lacitd.cashcontrol.prestier.helper.AppInit;
//import com.fedex.lacitd.cashcontrol.prestier.helper.AppLogger;
//import com.fedex.lacitd.cashcontrol.prestier.helper.AppUtils;
import com.fedex.lacitd.cashcontrol.prestier.helper.CODScanProcessor;
import com.fedex.lacitd.cashcontrol.prestier.helper.ShowScans;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.CODCourierCashRecapForm;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * This class manages the requests for the
 * COD detail screen.
 *
 * @author ccardenas
 */
public class CODCourierCashRecapAction extends Action implements java.io.Serializable {
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
                                 HttpServletResponse response)
            throws Exception {
    	AppInit.startMcd();
    	
        ActionForm copyForm = form;
        form = copyForm;
        request.setAttribute("CODCourierCashRecapForm", copyForm);
        if (request.getSession().getAttribute("userProfile") == null) return mapping.findForward("logout");


        if ("ChangeRecPaymentCurr".equals(request.getParameter("action"))) {
            return changeRecPaymentCurr(mapping, form, request, response);
        } else if ("ChangeRecCurr".equals(request.getParameter("action"))) {
            return changeRecCurr(mapping, form, request, response);
        } else if ("UpdateInformation".equals(request.getParameter("action"))) {
            return updateInformation(mapping, form, request, response);
        } else if ("CloseEmployee".equals(request.getParameter("action"))) {
            return closeEmployee(mapping, form, request, response);
        } else if ("ProcessScans".equals(request.getParameter("action"))) {
            return processScans(mapping, form, request, response);
        } else if ("toPrepaid".equals(request.getParameter("action"))) {
            updateInformation(mapping, form, request, response);
            return mapping.findForward("toPrepaid");
        } else if ("toPOA".equals(request.getParameter("action"))) {
            updateInformation(mapping, form, request, response);
            return mapping.findForward("toPOA");
        } else if ("toGround".equals(request.getParameter("action"))) {
            updateInformation(mapping, form, request, response);
            return mapping.findForward("toGround");
        } else if ("toROD".equals(request.getParameter("action"))) {
            updateInformation(mapping, form, request, response);
            return mapping.findForward("toROD");
        } else if ("toFTC".equals(request.getParameter("action"))) {
            updateInformation(mapping, form, request, response);
            return mapping.findForward("toFTC");
        } else if ("showPage".equals(request.getParameter("action"))) {
            updateInformation(mapping, form, request, response);
            return show(mapping, form, request, response);
        } else if ("sortTable".equals(request.getParameter("action"))) {
            return show(mapping, form, request, response);
        } else if ("changeCourier".equals(request.getParameter("action"))) {
            updateInformation(mapping, form, request, response);
            return show(mapping, form, request, response);
        } else if ("ReassignPayments".equals(request.getParameter("action"))) {
            return reassignPayments(mapping, form, request, response);
        } else if ("SplitCurrency".equals(request.getParameter("action"))) {
            return splitCurrency(mapping, form, request, response);
        } else if ("QuickApplyStatus".equals(request.getParameter("action"))) {
            return quickApplyStatus(mapping, form, request, response);
        } else if ("showScans".equals(request.getParameter("action"))) {
            return showScans(mapping, form, request, response);
        } else {
            return show(mapping, form, request, response);
        }
    }

    /**
     * Method to Split Currency
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     * @throws Exception
     */
    private ActionForward splitCurrency(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response)
            throws Exception {

        CODBizDelegate codBiz = new CODBizDelegate();
        CODCourierCashRecapForm ccrForm = (CODCourierCashRecapForm) form;

        double exchangeRate = new Double(request.getParameter("exchangeRate")).doubleValue();
        String amountToChangeString = request.getParameter("amountToChange");
        double amountToChange = 0;

        if (amountToChangeString != null && amountToChangeString.trim().length() > 0)
            amountToChange = new Double(request.getParameter("amountToChange")).doubleValue();

        Collection receivablesSelected = new ArrayList();
        COD_CourierCashRecapTableVO courierCashRecap = null;
        Iterator itRec = ccrForm.getReceivables().iterator();

        while (itRec.hasNext()) {
            courierCashRecap = (COD_CourierCashRecapTableVO) itRec.next();
            if (courierCashRecap.isSelected()) {
                receivablesSelected.add(courierCashRecap);
            }
        }


        ArrayList currencies = (ArrayList) ccrForm.getSupportedCurrencies();
        SupportedCurrencyVO scVO = null;
        for (int i = 0; i < currencies.size(); i++) {
            scVO = (SupportedCurrencyVO) currencies.get(i);
            if (!(ccrForm.getCurrentCurrency().equals(scVO.getCurrencyCode()))) {
                break;
            }
        }

        codBiz.splitCurrency(receivablesSelected, scVO.getCurrencyCode(), exchangeRate, amountToChange);

        return show(mapping, form, request, response);
    }

    /**
     * This method prepares the information and put it in the
     * request for the COD Details screen page.
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
                               HttpServletResponse response)
            throws Exception {
        try {
            CODCourierCashRecapForm ccrForm = (CODCourierCashRecapForm) form;
            Hashtable result = null;


            /* Chaca validaciones monto ingresado 12/2007:

               recupera parametros de numero de veces en que el monto ingresado 
               puede superar al monto esperado.

             */

            Properties prop = Utils.getProperties("P");

            if(prop.containsKey("param.value.higherThanExpected"))
                ccrForm.setParamNTimes( new Integer( Integer.parseInt( prop.getProperty( "param.value.higherThanExpected"))));
            else
                ccrForm.setParamNTimes( new Integer( 10));


            Integer pageNumber = new Integer(1);
            String sortColumn = "awb_nbr";
            String sortDirection = "asc";
            int rowsByPage = 20;
            if (ccrForm.getPageNumber() != null)
                pageNumber = ccrForm.getPageNumber();
            if (ccrForm.getSortColumn() != null)
                sortColumn = ccrForm.getSortColumn();
            if (ccrForm.getSortDirection() != null)
                sortDirection = ccrForm.getSortDirection();
            ccrForm.setPageNumber(pageNumber);
            ccrForm.setSortColumn(sortColumn);
            ccrForm.setSortDirection(sortDirection);
            //Set null if all couriers is selected to execute properly sp.
            if ("ALL".equals(ccrForm.getCourier())) {
                ccrForm.setCourier(null);
                rowsByPage = 40;
            }
            /////////////////////////////////
            // Getting employee profile
            /////////////////////////////////
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            /////////////////////////////////
            // Get the supported currencies
            /////////////////////////////////
            ccrForm.setSupportedCurrencies(ep.getSupportedCurrencies());
            ccrForm.setCountryBanks((Collection) request.getSession().getAttribute("countryBanks"));
            
            
            
            /* Start- For Mcd start for COD Detail screen*/
        	long startTime = System.currentTimeMillis() ;
            try {
            	System.out.println("In Mcd method in Cod detail screen");
                // Beginning of request. Inform McD
                MCD.processEvent("server",
                    "GCCS",
                    "CODCourierCashRecapAction",
                    //AppUtils.getHostname(),
                    AppInit.getHostname(),
                    null,
                    "OR",
                    "CodDetailScreen",
                    null,
                    null,
                    -1,
                    null);
            } catch (Exception e) {
                //AppLogger.error("McD Exception while processing GCCS.CodDetailScreen", e) ;
                System.out.println("McD Exception while processing GCCS.CodDetailScreen") ;
            	e.printStackTrace();
            }
            /* End- For Mcd start for COD Detail screen*/
            
            
            CODBizDelegate biz = new CODBizDelegate();
            //set supported and currently being used currencies for COD
            CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
            Collection colUsedCurr = biz.getCODUsedCurrencies(ep.getLocationCd(), ccrForm.getCourier());
            Iterator iterSuppCurr = ccrForm.getSupportedCurrencies().iterator();
            ccrForm.setCurrentlyUsedCurrencies(new ArrayList());
            while (iterSuppCurr.hasNext()) {
                SupportedCurrencyVO scVO = (SupportedCurrencyVO) iterSuppCurr.next();
                if (colUsedCurr.contains(scVO.getCurrencyCode())) {
                    ccrForm.getCurrentlyUsedCurrencies().add(scVO);
                }
            }

            if (request.getAttribute("updated") == null && //if still it was not updated
                    ccrForm.getPreviousCurrencyCode() != null &&
                    !"".equals(ccrForm.getPreviousCurrencyCode()) &&
                    ccrForm.getCurrentCurrency() != null &&
                    !"".equals(ccrForm.getCurrentCurrency()) &&
                    !ccrForm.getCurrentCurrency().equals(ccrForm.getPreviousCurrencyCode())
                    && !request.getParameter("action").equals("toCOD")) {
                updateInformation(mapping, form, request, response);
            }
            
            //Get list of receivables for the location and the courier
            if ("split".equals(ccrForm.getCurrentCurrency())) {
                result = biz.getSplitCourierCashRecapTable(ep.getLocationCd(), ccrForm.getCourier(), pageNumber, new Integer(rowsByPage), sortColumn, sortDirection);
                ccrForm.setReceivables((List) result.get("RESULTSET"));
                ccrForm.setNumberOfPages((Integer) result.get("NUMBEROFPAGES"));
                ccrForm.setDualCurrency(true);
            } else {
                if (ccrForm.getCurrentlyUsedCurrencies().size() == 1) {
                    ccrForm.setCurrentCurrency(((SupportedCurrencyVO) ccrForm.getCurrentlyUsedCurrencies().toArray()[0]).getCurrencyCode());
                } else {
                    if (ccrForm.getCurrentCurrency() == null) {
                        ccrForm.setCurrentCurrency(ep.getDefaultCurrency());
                    } else {
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
                result = biz.getCourierCashRecapTable(ep.getLocationCd(), ccrForm.getCourier(), ccrForm.getCurrentCurrency(), pageNumber, new Integer(rowsByPage), sortColumn, sortDirection);
                ccrForm.setReceivables((List) result.get("RESULTSET"));
                ccrForm.setNumberOfPages((Integer) result.get("NUMBEROFPAGES"));
            }
            
            
           /* Start- For Mcd End for COD Detail screen*/            
            try {
                MCD.processEvent("server",
	                "GCCS",
	                "CODCourierCashRecapAction",
                    //AppUtils.getHostname(),
                    AppInit.getHostname(),
                    null,
                    "IP",
                    "CodDetailScreen",
                    null,
                    null,
                    System.currentTimeMillis() - startTime,
                    null);
            } catch (Exception e) {
                //AppLogger.error("McD exception while processing GCCS.CodDetailScreen", e) ;
                System.out.println("McD Exception while processing GCCS.CodDetailScreen") ;
            	e.printStackTrace();
            }            
            
            /* End- For Mcd End for COD Detail screen*/
            
            ////////////////////////////////////////
            // Getting the employees with payments
            ////////////////////////////////////////
            ccrForm.setEmployeesWithPayments(bizComm.getEmployeesWithPayments(ep.getLocationCd()));
            /////////////////////////////
            // Get valid COD status
            /////////////////////////////
            //====== the following code is to find out if the user's associate Country
            //====== has set the Collect Later flag, if yes, then remove that option from the Collection
            Collection all_rec_status = biz.getAllCOD_RecStatus();
            
            if(ep.isCollectlaterFlag()==false){
	            Iterator itr = all_rec_status.iterator();
	            COD_RecStatusVO rsVO = new COD_RecStatusVO();
	            while(itr.hasNext()){             
	            	rsVO = (COD_RecStatusVO)itr.next();
		            if(rsVO.getDescription().equals("Collect Later")){
		            	itr.remove();
		            	break;
		            }//end if
	            }//end while
        	}//end if the collect later flag is on
        	
	        ccrForm.setRecStatus(all_rec_status);
            //ccrForm.setRecStatus(biz.getAllRecStatus());
            //////////////////////////////////////
            // Setting the attributes for paging
            //////////////////////////////////////
            setPagingAttributes(request, rowsByPage);
            ////////////////////////////////////
            // Setting the used payment types
            ////////////////////////////////////
            Collection paymentTypes = new PaymentTypeController().getPaymentTypeByCodLocation(ep.getLocationCd());
            ccrForm.setPaymentTypes(paymentTypes);
            /////////////////////////////////
            // Calculate the total amounts
            /////////////////////////////////
            calcTotals(ccrForm, ep.getLocationCd(), ccrForm.getCourier(), ccrForm.getCurrentCurrency(), pageNumber, new Integer(rowsByPage), sortColumn, sortDirection);
            /////////////////////////////////////////////////////
            // Check if there are split record for receivables.
            /////////////////////////////////////////////////////
            int splittes = new CommonOpsBizDelegate().getSplitCountTable(ep.getLocationCd(), ccrForm.getCourier(), "COD");
            if (splittes > 0)
                ccrForm.setDualCurrency(true); //If splitted records exist then dualCurrency flag is true
            else { //If no splitted records then dualCurrency flag is false
                ccrForm.setDualCurrency(false);
            }
            request.setAttribute("rowsByPage", new Integer(rowsByPage));
            request.setAttribute("CODCourierCashRecapForm", ccrForm);
            form=ccrForm;   // this is the trick
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
     * This method changes the currency of the payment.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward changeRecPaymentCurr(ActionMapping mapping,
                                               ActionForm form,
                                               HttpServletRequest request,
                                               HttpServletResponse response)
            throws Exception {
        CODBizDelegate biz = new CODBizDelegate();
        biz.changeRecPaymentCurrency(Integer.parseInt(request.getParameter("recId")), request.getParameter("newCurr"));

        return show(mapping, form, request, response);
    }

    /**
     * This method changes the currency of the invoice.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward changeRecCurr(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response)
            throws Exception {
        CODBizDelegate biz = new CODBizDelegate();
        biz.changeRecCurrency(Integer.parseInt(request.getParameter("recId")), request.getParameter("newCurr"));

        return show(mapping, form, request, response);
    }

    /**
     * This method apply the changes entered by the
     * user to the db.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward updateInformation(ActionMapping mapping,
                                            ActionForm form,
                                            HttpServletRequest request,
                                            HttpServletResponse response)
            throws Exception {
        CODCourierCashRecapForm ccrForm = (CODCourierCashRecapForm) form;
        Iterator iterRec = ccrForm.getReceivables().iterator();

        while (iterRec.hasNext()) {
            COD_CourierCashRecapTableVO rec = (COD_CourierCashRecapTableVO) iterRec.next();

            if (!rec.isModified()) {
                iterRec.remove();
            } else {
                EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
                rec.setRecChngStatusDate(Utils.changeDateToTZ(new java.util.Date(), ep.getLocationTimeZone()));
                rec.setRecChngStatusEmployeeId(ep.getEmployeeId());

                if (rec.getOtherPaymentType() == 3 && rec.getRecOtherDocNumber().length() > 4)
                    rec.setRecOtherDocNumber(rec.getRecOtherDocNumber().substring(rec.getRecOtherDocNumber().length() - 4));

                if (rec.getRcptNbr() == null) {
                    if (rec.getRcptNbrPrev() != null) rec.setRcptChngEmpId(ep.getEmployeeId());
                } else {
                    if (!rec.getRcptNbr().equals(rec.getRcptNbrPrev()))
                        rec.setRcptChngEmpId(ep.getEmployeeId());
                    else
                        rec.setRcptChngEmpId(null);
                }

                if (rec.getCustomerNm() == null) {
                    if (rec.getCustomerNmPrev() != null) rec.setCustChngEmpId(ep.getEmployeeId());
                } else {
                    if (!rec.getCustomerNm().equals(rec.getCustomerNmPrev()))
                        rec.setCustChngEmpId(ep.getEmployeeId());
                    else
                        rec.setCustChngEmpId(null);
                }

                if (rec.getRecAmount() == rec.getRecAmtPrev()) {
                    rec.setAmtChngEmpId(null);
                } else {
                    rec.setAmtChngEmpId(ep.getEmployeeId());
                }
                
            }

        }


        if (!ccrForm.getReceivables().isEmpty()) {
            CODBizDelegate biz = new CODBizDelegate();
            biz.applyCheckinAgentChanges(ccrForm.getReceivables());
        }

        if ("YES".equals(request.getParameter("reload"))) {
            request.setAttribute("updated", "updated");//it was updated
            return show(mapping, form, request, response);
        } else {
            return mapping.findForward("Summary");
        }
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
        CODCourierCashRecapForm ccrForm = (CODCourierCashRecapForm) form;
        Iterator iterRec = ccrForm.getReceivables().iterator();
        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

        if (new EmployeeController().getEmployee(ccrForm.getNewEmployeeId()) == null) {
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.CourierDoesNotExist"));
            saveErrors(request, ae);
            return show(mapping, form, request, response);
        }

       COD_ReceivablesController rc = new COD_ReceivablesController();
        while (iterRec.hasNext()) {
            COD_CourierCashRecapTableVO rec = (COD_CourierCashRecapTableVO) iterRec.next();

            if (rec.isSelected()) {
                COD_ReceivablesVO rVO = rc.getCOD_Receivables(new Integer(rec.getRecId()));
                rVO.setOrigEmployeeId(rVO.getEmployeeId());
                rVO.setReassEmpId(ep.getEmployeeId());
                rVO.setEmployeeId(ccrForm.getNewEmployeeId());
                rVO.setLocationCd(ccrForm.getNewReassLocationCd());

                //Validate Currency for the country
                String curResult = Utils.validateCountryCurencyInProcess(rVO.getLocationCd(), rVO.getPaymentCurrency());
                if (curResult != null) {
                    rVO.setInvCurrency(curResult);
                    rVO.setPaymentCurrency(curResult);
                }
                rc.updateCOD_Receivables(rVO);
            }
        }

        return updateInformation(mapping, form, request, response);
    }

    /**
     * This method closes the current courier.
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
        updateInformation(mapping, form, request, response);

        CODCourierCashRecapForm ccrForm = (CODCourierCashRecapForm) form;
        Collection colCourier = new ArrayList();
        colCourier.add(ccrForm.getCourier());

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

        CommonOpsBizDelegate bizComm = new CommonOpsBizDelegate();
        if (bizComm.closeCouriers(ep.getEmployeeId(), ep.getLocationCd(), colCourier)) {
            return mapping.findForward("Summary");
        } else {
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.AllInvoicesStateToClose"));
            saveErrors(request, ae);
            return show(mapping, form, request, response);
        }
    }

    /**
     * This method starts the scans processing for
     * the current receivables.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    public ActionForward processScans(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response)
            throws Exception {
        CODBizDelegate biz = new CODBizDelegate();
        CommonOpsBizDelegate comBiz = new CommonOpsBizDelegate();
        try {
        	
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            CODCourierCashRecapForm ccrForm = (CODCourierCashRecapForm) form;
            
            System.out.println("Before Mcd in Process SCAN TESTT - CODCourierCashRecapAction.java");
            
            AppInit.startMcd();
            
            long startTime = System.currentTimeMillis() ;
            try {
                // Beginning of request. Inform McD
            	System.out.println("Mcd in Cod Process Scans");
                MCD.processEvent("server",
                    "GCCS",
                    "CODCourierCashRecapAction",
                    //AppUtils.getHostname(),
                    AppInit.getHostname(),
                    null,
                    "OR",
                    "processScansCODCourierCashRecap",
                    null,
                    null,
                    -1,
                    null);
            } catch (Exception e) {
                //AppLogger.error("McD Exception while processing processScansCODCourierCashRecap", e) ;
                System.out.println("McD Exception while processing GCCS.processScansCODCourierCashRecap") ;
            	e.printStackTrace();
            }
            
            Collection awbs = biz.getAwbToQueryCosmos(ep.getLocationCd(), ccrForm.getCourier());

            Collection results = Collections.synchronizedCollection(new ArrayList());
            
            
            //Constants.logger.debug("CODCourierCashRecapActive.java > colAwbs size = "+ awbs.size());
            //Constants.logger.debug("CODCourierCashRecapActive.java > result size = "+ results.size());
            
            CODScanProcessor sp = new CODScanProcessor();

            Collection np = sp.processLastScans(awbs, results, ep.getLocationCd(), comBiz.getLocationCdByCountry(ep.getCountryCd()), ep.getScansLocalDecs(), ep.getScansUsdDecs());

            np.addAll(biz.applyCODScans(results));
            
            
            // End of request. Inform McD
            try {
                MCD.processEvent("server",
	                "GCCS",
	                "CODCourierCashRecapAction",
                    //AppUtils.getHostname(),
                    AppInit.getHostname(),
                    null,
                    "IP",
                    "processScansCODCourierCashRecap",
                    null,
                    null,
                    System.currentTimeMillis() - startTime,
                    null);
            } catch (Exception e) {
                //AppLogger.error("McD exception while processing processScansCODCourierCashRecap", e) ;
                System.out.println("McD Exception while processing GCCS.processScansCODCourierCashRecap") ;
            	e.printStackTrace();
            }
            
            if (np != null && !np.isEmpty()) {
                request.setAttribute("NotProcessed", np);
            }
                                    

        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.ScansProcessingError"));
            saveErrors(request, ae);
        }
        return show(mapping, form, request, response);
    }

    /**
     * This method set the paging attributes on the request.
     *
     * @param rowsByPage
     * @return Struts action forward
     * @throws Exception
     */
    private void setPagingAttributes(HttpServletRequest request, int rowsByPage) throws Exception {
        Integer length = null, currentPage = null, offset = null;
        if (request.getParameter("currentPage") != null) {
            currentPage = ((Integer) ConvertUtils.convert((String) request.getParameter("currentPage"), Class.forName("java.lang.Integer")));

            if (currentPage.intValue() == 0) currentPage = new Integer(1);
        } else
            currentPage = new Integer(1);

        if (request.getParameter("length") != null) {
            length = ((Integer) ConvertUtils.convert((String) request.getParameter("length"), Class.forName("java.lang.Integer")));

            if (length.intValue() == 0) length = new Integer(rowsByPage);
        } else
            length = new Integer(rowsByPage);

        offset = new Integer(length.intValue() * (currentPage.intValue() - 1));

        request.setAttribute("currentPage", currentPage);
        request.setAttribute("length", length);
        request.setAttribute("offset", offset);
    }

    /**
     * This method is used to apply clear status when a DDEX is present.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward quickApplyStatus(ActionMapping mapping,
                                           ActionForm form,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        CODCourierCashRecapForm ccrForm = null;
        if (form == null) {
            ccrForm = new CODCourierCashRecapForm();
        } else {
            ccrForm = (CODCourierCashRecapForm) form;
        }

        Integer pageNumber = new Integer(1);
        String sortColumn = "awb_nbr";
        String sortDirection = "asc";
        int rowsByPage = 20;
        if (ccrForm.getPageNumber() != null)
            pageNumber = ccrForm.getPageNumber();
        if (ccrForm.getSortColumn() != null)
            sortColumn = ccrForm.getSortColumn();
        if (ccrForm.getSortDirection() != null)
            sortDirection = ccrForm.getSortDirection();
        ccrForm.setPageNumber(pageNumber);
        ccrForm.setSortColumn(sortColumn);
        ccrForm.setSortDirection(sortDirection);
        if ("ALL".equals(ccrForm.getCourier()) || ccrForm.getCourier() == null) {
            ccrForm.setCourier(null);
            rowsByPage = 40;
        }
        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
        if (ep.isQuickStatus()) {
            Iterator iterRec = ccrForm.getReceivables().iterator();
            while (iterRec.hasNext()) {
                COD_CourierCashRecapTableVO rec = (COD_CourierCashRecapTableVO) iterRec.next();
                if (rec.getRecDex11Amount() > 0 && rec.getRecStatusId() == 0 && rec.getRecOtherPayment() <= 0) {
                    rec.setRecStatusId(1);
                }
            }
        }
        setPagingAttributes(request, rowsByPage);
        calcTotals(ccrForm, ep.getLocationCd(), ccrForm.getCourier(), ccrForm.getCurrentCurrency(), pageNumber, new Integer(rowsByPage), sortColumn, sortDirection);
        request.setAttribute("CODCourierCashRecapForm", ccrForm);
        return mapping.findForward("Success");
    }

    /**
     * This method shows a particular page of the
     * receivables list.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    /*
    private ActionForward showPage(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {
        CODCourierCashRecapForm ccrForm = null;
        if (form == null) {
            ccrForm = new CODCourierCashRecapForm();
        } else {
            ccrForm = (CODCourierCashRecapForm) form;
        }

        int rowsByPage = 20;
        if ("ALL".equals(ccrForm.getCourier()) || ccrForm.getCourier() == null) {
            ccrForm.setCourier(null);
            rowsByPage = 40;
        }

        setPagingAttributes(request, rowsByPage);
        calcTotals(ccrForm, ((Integer) request.getAttribute("offset")).intValue(), ((Integer) request.getAttribute("length")).intValue());

        request.setAttribute("CODCourierCashRecapForm", ccrForm);

        return mapping.findForward("Success");
    }
    */

    /**
     * This method re-calculate the totals for the
     * receivables list.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private void calcTotals(CODCourierCashRecapForm ccrForm,
                            String locationCd,
                            String employeeId,
                            String currentCurrencyCd,
                            Integer pageNumber,
                            Integer rowsByPage,
                            String sortColumn,
                            String sortDirection) throws Exception {
        if (ccrForm.isDualCurrency() && "split".equals(currentCurrencyCd)) {
            calcTotalsSplit(ccrForm, locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        } else {
            CODBizDelegate delegate = new CODBizDelegate();
            TotalSummaryVO totalSummaryVO = delegate.getCODDetailsTotal(locationCd, employeeId, currentCurrencyCd, pageNumber, rowsByPage, sortColumn, sortDirection);
            ccrForm.setCashTotal(totalSummaryVO.getCashTotal().doubleValue());

            ccrForm.setDepositTotal(totalSummaryVO.getDepositTotal().doubleValue());
            ccrForm.setCreditCardTotal(totalSummaryVO.getCreditCardTotal().doubleValue());
            ccrForm.setCheckTotal(totalSummaryVO.getCheckTotal().doubleValue());
            ccrForm.setCashSubTotal(totalSummaryVO.getCashSubTotal().doubleValue());
            ccrForm.setDepositSubTotal(totalSummaryVO.getDepositSubTotal().doubleValue());
            ccrForm.setCreditCardSubTotal(totalSummaryVO.getCreditCardSubTotal().doubleValue());
            ccrForm.setCheckSubTotal(totalSummaryVO.getCheckSubTotal().doubleValue());
            ccrForm.setCanClose(true);
            if (totalSummaryVO.getStatusCd() != null && totalSummaryVO.getStatusCd().intValue() < 1)
                ccrForm.setCanClose(false);
            ccrForm.setTotalPayments(ccrForm.getCashTotal() + ccrForm.getCheckTotal() + ccrForm.getCreditCardTotal() + ccrForm.getDepositTotal());
        }
    }

    /**
     * This method re-calculate the totals for the
     * receivables list.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private void calcTotalsSplit(CODCourierCashRecapForm ccrForm,
                                 String locationCd,
                                 String employeeId,
                                 Integer pageNumber,
                                 Integer rowsByPage,
                                 String sortColumn,
                                 String sortDirection) throws Exception {
        CODBizDelegate delegate = new CODBizDelegate();
        TotalSummaryVO totalSummaryVO = delegate.getCODDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        ccrForm.setCashTotal(totalSummaryVO.getCashTotal().doubleValue());
        ccrForm.setDepositTotal(totalSummaryVO.getDepositTotal().doubleValue());
        ccrForm.setCreditCardTotal(totalSummaryVO.getCreditCardTotal().doubleValue());
        ccrForm.setCheckTotal(totalSummaryVO.getCheckTotal().doubleValue());
        ccrForm.setCashSubTotal(totalSummaryVO.getCashSubTotal().doubleValue());
        ccrForm.setDepositSubTotal(totalSummaryVO.getDepositSubTotal().doubleValue());
        ccrForm.setCreditCardSubTotal(totalSummaryVO.getCreditCardSubTotal().doubleValue());
        ccrForm.setCheckSubTotal(totalSummaryVO.getCheckSubTotal().doubleValue());
        ccrForm.setUsdCashTotal(totalSummaryVO.getUsdCashTotal().doubleValue());
        ccrForm.setUsdDepositTotal(totalSummaryVO.getUsdDepositTotal().doubleValue());
        ccrForm.setUsdCreditCardTotal(totalSummaryVO.getUsdCreditCardTotal().doubleValue());
        ccrForm.setUsdCheckTotal(totalSummaryVO.getUsdCheckTotal().doubleValue());
        ccrForm.setUsdCashSubTotal(totalSummaryVO.getUsdCashSubTotal().doubleValue());
        ccrForm.setUsdDepositSubTotal(totalSummaryVO.getUsdDepositSubTotal().doubleValue());
        ccrForm.setUsdCreditCardSubTotal(totalSummaryVO.getUsdCreditCardSubTotal().doubleValue());
        ccrForm.setUsdCheckSubTotal(totalSummaryVO.getUsdCheckSubTotal().doubleValue());
        ccrForm.setCanClose(true);
        if (totalSummaryVO.getStatusCd() != null && totalSummaryVO.getStatusCd().intValue() < 1)
            ccrForm.setCanClose(false);
        ccrForm.setTotalPayments(ccrForm.getCashTotal() + ccrForm.getCheckTotal() + ccrForm.getCreditCardTotal() + ccrForm.getDepositTotal());
        ccrForm.setUsdTotalPayments(ccrForm.getUsdCashTotal() + ccrForm.getUsdCheckTotal() + ccrForm.getUsdCreditCardTotal() + ccrForm.getUsdDepositTotal());
    }

    /**
     * This method prepares the information and put it in the
     * request for the COD Scans Details screen page.
     *
     * @param Struts action mapping object
     * @param Struts action form object
     * @param http   request object
     * @param http   response object
     * @return Struts action forward
     * @throws Exception
     */
    private ActionForward showScans(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest request,
                                    HttpServletResponse response)
            throws Exception {
        try {
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            ShowScans ss = new ShowScans();
            ss.setScansLocalDecs(ep.getScansLocalDecs());
            ss.setScansUsdDecs(ep.getScansUsdDecs());

            List colResults = (List) ss.getCODScans(request.getParameter("awbNbr"), ep.getLocationCd());
            Collections.sort(colResults, new Comparator() {
                public int compare(Object obj1, Object obj2) {
                    CosmosScansTableVO ccrVO1 = (CosmosScansTableVO) obj1;
                    CosmosScansTableVO ccrVO2 = (CosmosScansTableVO) obj2;
                    return ccrVO1.getScanDtTm() == null ? -1 : ccrVO2.getScanDtTm().compareTo(ccrVO1.getScanDtTm());
                }
            });

            request.setAttribute("pageTitle", "AWB " + request.getParameter("awbNbr"));
            request.setAttribute("scans", colResults);

            if (ss.getErrors() != null && !ss.getErrors().isEmpty()) {
                Iterator iter = ss.getErrors().iterator();
                if (iter.hasNext()) {
                    ScansProcessingError spe = (ScansProcessingError) iter.next();
                    ActionErrors ae = new ActionErrors();
                    ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.CannotFindDetailedScans"));
                    saveErrors(request, ae);
                }
            }
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request, ae);
        }
        return mapping.findForward("showScans");
    }
}