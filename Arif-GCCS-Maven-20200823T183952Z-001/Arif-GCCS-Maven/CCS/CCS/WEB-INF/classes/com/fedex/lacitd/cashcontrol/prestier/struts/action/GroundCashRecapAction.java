/**
 * GroundCashRecapAction.java
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
import com.fedex.lacitd.cashcontrol.common.*;

import org.apache.struts.action.*;

import java.util.*;

import org.apache.commons.beanutils.ConvertUtils;


/**
 * This class manages the requests for the Prepaid
 * Detail Screen
 * @author  ccardenas
 */
public class GroundCashRecapAction extends Action implements java.io.Serializable{
    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done.
     *
     * @param    mapping object
     * @param    form object
     * @param    request object
     * @param    response object
     * @return   Struts action forward
     * @exception Exception
     */
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        if(request.getSession().getAttribute("userProfile") == null) return mapping.findForward("logout");

        if("ChangePaymentCurr".equals(request.getParameter("action"))) {
            return changePaymentCurr(mapping,form,request,response);
        }
        else if("UpdateInformation".equals(request.getParameter("action"))) {
            return updateInformation(mapping,form,request,response);
        }
        else if("CloseEmployee".equals(request.getParameter("action"))) {
            return closeEmployee(mapping,form,request,response);
        }
        else if("toROD".equals(request.getParameter("action"))) {
            updateInformation(mapping,form,request,response);
            return mapping.findForward("toROD");
        }
        else if("toCOD".equals(request.getParameter("action"))) {
            updateInformation(mapping,form,request,response);
            return mapping.findForward("toCOD");
        }
        else if("toFTC".equals(request.getParameter("action"))) {
            updateInformation(mapping,form,request,response);
            return mapping.findForward("toFTC");
        }
        else if("toPOA".equals(request.getParameter("action"))) {
            updateInformation(mapping,form,request,response);
            return mapping.findForward("toPOA");
        }
        else if("toPrepaid".equals(request.getParameter("action"))) {
            updateInformation(mapping,form,request,response);
            return mapping.findForward("toPrepaid");
        }
        else if("showPage".equals(request.getParameter("action"))) {
            updateInformation(mapping,form,request,response);
            return show(mapping,form,request,response);
        }
        else if("sortTable".equals(request.getParameter("action"))) {
            return show(mapping,form,request,response);
        }
        else if("changeCourier".equals(request.getParameter("action"))) {
            updateInformation(mapping,form,request,response);
            return show(mapping,form,request,response);
        }
        else if ("SplitCurrency".equals(request.getParameter("action"))) {
            return splitCurrency(mapping, form, request, response);
        }
        else if ("ReassignPayments".equals(request.getParameter("action"))){
            return reassignPayments(mapping,form,request,response);
        }
        else{
            return show(mapping,form,request,response);
        }
    }

    /**
     * Method to Split Currency
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

        PrepPoaBizDelegate prepBiz=new PrepPoaBizDelegate();
        GroundCashRecapForm ccrForm = (GroundCashRecapForm) form;

        double exchangeRate   = new Double(request.getParameter("exchangeRate")).doubleValue();
        String amountToChangeString = request.getParameter("amountToChange");
        double amountToChange = 0;
        if(amountToChangeString != null && amountToChangeString.trim().length()>0)
           amountToChange=new Double(request.getParameter("amountToChange")).doubleValue();

        Collection groundsSelected = new ArrayList();
        GroundDetailsTableVO groundCashRecap = null;
        Iterator itRec = ccrForm.getTrackNbrs().iterator();

        while(itRec.hasNext())
        {   groundCashRecap = (GroundDetailsTableVO)itRec.next();
            if(groundCashRecap.isSelected()) {
               groundsSelected.add(groundCashRecap);
            }
        }


        ArrayList currencies = (ArrayList)ccrForm.getSupportedCurrencies();
        SupportedCurrencyVO scVO=null;
        for(int i=0;i<currencies.size();i++)
        {   scVO= (SupportedCurrencyVO)currencies.get(i);
            if(!(ccrForm.getCurrentCurrency().equals(scVO.getCurrencyCode())))
            {  break;}
        }

        prepBiz.splitGroundCurrency(groundsSelected,scVO.getCurrencyCode(),exchangeRate,amountToChange);

        return show(mapping,form,request,response);
    }

    /**
     * This method prepares the information to be showed
     * by the Prepaid Details page.
     *
     * @param    mapping object
     * @param    form object
     * @param    request object
     * @param    response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            GroundCashRecapForm ccrForm=(GroundCashRecapForm) form;
            //////////////////////////////////////
            // Initialization of parameters
            //////////////////////////////////////
            Integer pageNumber = new Integer(1);
            String sortColumn = "awb_nbr";
            String sortDirection = "asc";
            int rowsByPage = 20; //Hard coded !!
            if(ccrForm.getPageNumber() != null)
                 pageNumber = ccrForm.getPageNumber();
            if(ccrForm.getSortColumn() !=null)
                sortColumn = ccrForm.getSortColumn();
            if(ccrForm.getSortDirection() !=null)
                sortDirection = ccrForm.getSortDirection();
            ccrForm.setPageNumber(pageNumber);
            ccrForm.setSortColumn(sortColumn);
            ccrForm.setSortDirection(sortDirection);
            if("ALL".equals(ccrForm.getCourier())) {
                ccrForm.setCourier(null);
                rowsByPage = 40; //Hard coded !!
            }
            /////////////////////////////////
            // Getting employee profile
            /////////////////////////////////
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            /////////////////////////////////
            // Get the supported currencies
            /////////////////////////////////
            ccrForm.setSupportedCurrencies(ep.getSupportedCurrencies());
            ccrForm.setCountryBanks((Collection)request.getSession().getAttribute("countryBanks"));
            PrepPoaBizDelegate biz=new PrepPoaBizDelegate();
            //get the currently used currencies
            Collection colUsedCurr=biz.getGroundUsedCurrencies(ep.getLocationCd(),ccrForm.getCourier());
            Iterator iterSuppCurr=ccrForm.getSupportedCurrencies().iterator();
            ccrForm.setCurrentlyUsedCurrencies(new ArrayList());

            while(iterSuppCurr.hasNext()) {
                SupportedCurrencyVO scVO=(SupportedCurrencyVO)iterSuppCurr.next();
                if(colUsedCurr.contains(scVO.getCurrencyCode())) {
                    ccrForm.getCurrentlyUsedCurrencies().add(scVO);
                }
            }

            if(request.getAttribute("updated")==null &&   //if still it was not updated
               ccrForm.getPreviousCurrencyCode()!=null &&
               !"".equals(ccrForm.getPreviousCurrencyCode()) &&
               ccrForm.getCurrentCurrency()!=null &&
               !"".equals(ccrForm.getCurrentCurrency()) &&
               !ccrForm.getCurrentCurrency().equals(ccrForm.getPreviousCurrencyCode())
            ) {
                updateInformation(mapping,form,request,response);
            }
            /////////////////////////////////
            // Setting the current currency
            /////////////////////////////////

            if("split".equals(ccrForm.getCurrentCurrency())) {
                ////////////////////////////////////////////////////////////
                // Get list of receivables for the location and the courier
                ////////////////////////////////////////////////////////////
                Hashtable result = biz.getSplitGroundTable(ep.getLocationCd(),ccrForm.getCourier(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
                ccrForm.setTrackNbrs((List) result.get("RESULTSET"));
                ccrForm.setNumberOfPages((Integer) result.get("NUMBEROFPAGES"));
                ccrForm.setDualCurrency(true);
            }
            else {
                    if(ccrForm.getCurrentlyUsedCurrencies().size()==1){
                        ccrForm.setCurrentCurrency(((SupportedCurrencyVO)ccrForm.getCurrentlyUsedCurrencies().toArray()[0]).getCurrencyCode());
                    }
                    else {
                        if(ccrForm.getCurrentCurrency()==null) {
                            ccrForm.setCurrentCurrency(ep.getDefaultCurrency());
                        }
                        else {
                            boolean validCurr=false;
                            Iterator iterCurr=ep.getSupportedCurrencies().iterator();
                            while(iterCurr.hasNext()){
                                SupportedCurrencyVO scVO=(SupportedCurrencyVO)iterCurr.next();
                                if(ccrForm.getCurrentCurrency().equalsIgnoreCase(scVO.getCurrencyCode())){
                                    validCurr=true;
                                    break;
                                }
                            }
                            if (!validCurr){
                                ccrForm.setCurrentCurrency(ep.getDefaultCurrency());
                            }
                        }
                    }
                    /////////////////////////
                    // Getting the grounds
                    /////////////////////////

                    Hashtable result = biz.getGroundDetailsTable(ep.getLocationCd(),ccrForm.getCourier(),ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
                    ccrForm.setTrackNbrs((List) result.get("RESULTSET"));
                    ccrForm.setNumberOfPages((Integer) result.get("NUMBEROFPAGES"));
                }
                ////////////////////////////////////////
                // Getting the employees with payments
                ////////////////////////////////////////
                ccrForm.setEmployeesWithPayments(new CommonOpsBizDelegate().getEmployeesWithPayments(ep.getLocationCd()));
                /////////////////////////////
                // Get valid prepaid status
                /////////////////////////////
                /*  Fill status of Ground */
                Collection statusGrn = new ArrayList();

                PreStatusVO statAux = new PreStatusVO();
                statAux.setStatusIdNbr(new Integer(0));
                statAux.setStatusDesc("No clear");
                statusGrn.add(statAux);

                PreStatusVO statAux2 = new PreStatusVO();
                statAux2.setStatusIdNbr(new Integer(1));
                statAux2.setStatusDesc("Clear");
                statusGrn.add(statAux2);

                PreStatusVO statAux3 = new PreStatusVO();
                statAux3.setStatusIdNbr(new Integer(3));   // number ??
                statAux3.setStatusDesc("Bill Account");
                statusGrn.add(statAux3);

                ccrForm.setGrnStatus(statusGrn);//biz.getAllPreStatus());

                //////////////////////////////////////
                // Setting the attributes for paging
                //////////////////////////////////////
                setPagingAttributes(request,rowsByPage);
                ////////////////////////////////////
                // Setting the used payment types
                ////////////////////////////////////
                Collection paymentTypes=new PaymentTypeController().getPaymentTypeByGndLocation(ep.getLocationCd());
                ccrForm.setPaymentTypes(paymentTypes);
                /////////////////////////////////
                // Calculate the total amounts
                /////////////////////////////////
                calcTotals(ccrForm,ep.getLocationCd(),ccrForm.getCourier(),ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage));
                /////////////////////////////////////////////////////
                // Check if there are split record for GROUND.
                /////////////////////////////////////////////////////
                int splittes = new CommonOpsBizDelegate().getSplitCountTable(ep.getLocationCd(), ccrForm.getCourier(),"GROUND");
                if(splittes > 0)
                   ccrForm.setDualCurrency(true); //If splitted records exist then dualCurrency flag is true
                else //If no splitted records then dualCurrency flag is false
                   ccrForm.setDualCurrency(false);
                request.setAttribute("rowsByPage",new Integer(rowsByPage));
                request.setAttribute("GroundCashRecapForm",ccrForm);
        }
        catch(Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);
        }
        return mapping.findForward("Success");
    }


    /**
     * This method changes the currency of the selected
     * prepaid.
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward changePaymentCurr(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        GroundController pc=new GroundController();
        GroundVO pVO=pc.getGround(new Integer(request.getParameter("groundId")));
        pVO.setPaymentCurrency(request.getParameter("newCurr"));
        pc.updateGround(pVO);
        return show(mapping,form,request,response);
    }

    /**
     * This method apply the changes made for the
     * checkin agent in the Prepaid Page.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward updateInformation(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        GroundCashRecapForm ccrForm=(GroundCashRecapForm)form;
        Iterator iterRec=ccrForm.getTrackNbrs().iterator();
        while(iterRec.hasNext()){
            GroundDetailsTableVO rec=(GroundDetailsTableVO)iterRec.next();

            if(!rec.isModified()){
                iterRec.remove();
            }else{
                EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                rec.setChngStatusDate(Utils.changeDateToTZ(new java.util.Date(),ep.getLocationTimeZone()));
                rec.setChngStatusEmployeeId(ep.getEmployeeId());

                if(rec.getCustNm()==null){
                    if (rec.getCustNmPrev()!=null) rec.setRcptChngEmpId(ep.getEmployeeId());
                }else{
                    if (!rec.getCustNm().equals(rec.getCustNmPrev())) rec.setRcptChngEmpId(ep.getEmployeeId());
                    else rec.setRcptChngEmpId(null);
                }

                if(rec.getRcptNbr()==null){
                    if (rec.getRcptNbrPrev()!=null) rec.setRcptChngEmpId(ep.getEmployeeId());
                }else{
                    if (!rec.getRcptNbr().equals(rec.getRcptNbrPrev())) rec.setRcptChngEmpId(ep.getEmployeeId());
                    else rec.setRcptChngEmpId(null);
                }


                if(rec.getOtherPaymentType()==3 && rec.getOtherDocNumber().length()>4)
                    rec.setOtherDocNumber(rec.getOtherDocNumber().substring(rec.getOtherDocNumber().length()-4));
            }

        }

        if(!ccrForm.getTrackNbrs().isEmpty()){
            PrepPoaBizDelegate biz=new PrepPoaBizDelegate();
            biz.applyGroundChanges(ccrForm.getTrackNbrs());
        }

        if("YES".equals(request.getParameter("reload"))){
            request.setAttribute("updated","updated");//it was updated
            return show(mapping,form,request,response);
        }else{
            return mapping.findForward("Summary");
        }
    }

    /**
     * This method is used to reassign payments to another location and courier
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private ActionForward reassignPayments(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
    	GroundCashRecapForm ccrForm=(GroundCashRecapForm)form;
        Iterator iterRec=ccrForm.getTrackNbrs().iterator();
        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");

        if(new EmployeeController().getEmployee(ccrForm.getNewEmployeeId())==null){
        	ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CourierDoesNotExist"));
            saveErrors(request,ae);
            return show(mapping,form,request,response);
        }

        GroundController gc=new GroundController();
        while(iterRec.hasNext()){
            GroundDetailsTableVO gnd=(GroundDetailsTableVO)iterRec.next();

            if(gnd.isSelected()){
            	GroundVO gVO=gc.getGround(new Integer(gnd.getGroundId()));
            	gVO.setOrigEmpNbr(gVO.getCourEmpIdNbr());
            	gVO.setRsgnEmpNbr(ep.getEmployeeId());
            	gVO.setCourEmpIdNbr(ccrForm.getNewEmployeeId());
            	gVO.setLocationCd(ccrForm.getNewReassLocationCd());
            

                //Validate Currency for the country
                String curResult = Utils.validateCountryCurencyInProcess(gVO.getLocationCd(),gVO.getPaymentCurrency());
                if(curResult!=null){
                   gVO.setPaymentCurrency(curResult);
                }

               	gc.updateGround(gVO);
            }
        }

        return updateInformation(mapping,form,request,response);
    }

    /**
     * This method close the current employee.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward closeEmployee(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        updateInformation(mapping,form,request,response);

        GroundCashRecapForm ccrForm=(GroundCashRecapForm)form;
        Collection colCourier=new ArrayList();
        colCourier.add(ccrForm.getCourier());

        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");

        CommonOpsBizDelegate biz=new CommonOpsBizDelegate();
        if(biz.closeCouriers(ep.getEmployeeId(),ep.getLocationCd(),colCourier)){
            return mapping.findForward("Summary");
        }else{
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.AllInvoicesStateToClose"));
            saveErrors(request,ae);
            return show(mapping,form,request,response);
        }
    }

    /**
     * This method put the correct paging attributes values in the request.
     *
     * @param rowsByPage
     * @return   Struts action forward
     * @exception Exception
     */

    private void setPagingAttributes(HttpServletRequest request, int rowsByPage) throws Exception{
        Integer length=null,currentPage=null,offset=null;
        if(request.getParameter("currentPage")!=null) {
            currentPage=((Integer)ConvertUtils.convert((String)request.getParameter("currentPage"),Class.forName("java.lang.Integer")));
            if(currentPage.intValue()==0) currentPage=new Integer(1);
        }
        else
            currentPage=new Integer(1);

        if(request.getParameter("length")!=null){
            length=((Integer)ConvertUtils.convert((String)request.getParameter("length"),Class.forName("java.lang.Integer")));
            if(length.intValue()==0) length=new Integer(rowsByPage);
        }
        else
            length=new Integer(rowsByPage);

        offset = new Integer(length.intValue()*(currentPage.intValue()-1));
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("length",length);
        request.setAttribute("offset",offset);
    }

    /**
     * This method set the attributes to show
     * a particular page from the list of prepaids.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    /*
    private ActionForward showPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        GroundCashRecapForm ccrForm=null;
        if(form==null){
            ccrForm=new GroundCashRecapForm();
        }else{
            ccrForm=(GroundCashRecapForm)form;
        }

        int rowsByPage = 20;
        if("ALL".equals(ccrForm.getCourier()) || ccrForm.getCourier() == null) {
            ccrForm.setCourier(null);
            rowsByPage = 40;
        }

        setPagingAttributes(request, rowsByPage);
        calcTotals(ccrForm,((Integer)request.getAttribute("offset")).intValue(),((Integer)request.getAttribute("length")).intValue());

        request.setAttribute("GroundCashRecapForm",ccrForm);

        return mapping.findForward("Success");
    }
      */
    /**
     * This method re-calculates the totals for the payments.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    private void calcTotals(GroundCashRecapForm ccrForm,
                            String locationCd,
                            String employeeId,
                            String currentCurrencyCd,
                            Integer pageNumber,
                            Integer rowsByPage) throws Exception {
        if(ccrForm.isDualCurrency() && "split".equals(currentCurrencyCd)) {
            calcTotalsSplit(ccrForm,locationCd,employeeId,pageNumber,rowsByPage);
        }
        else {
            PrepPoaBizDelegate delegate = new PrepPoaBizDelegate();
            TotalSummaryVO totalSummaryVO = delegate.getGroundDetailsTotal(locationCd,employeeId,currentCurrencyCd,pageNumber,rowsByPage);
            ccrForm.setCashTotal(totalSummaryVO.getCashTotal().doubleValue());
            ccrForm.setCouponTotal(totalSummaryVO.getCouponTotal().doubleValue());
            ccrForm.setDepositTotal(totalSummaryVO.getDepositTotal().doubleValue());
            ccrForm.setCreditCardTotal(totalSummaryVO.getCreditCardTotal().doubleValue());
            ccrForm.setCheckTotal(totalSummaryVO.getCheckTotal().doubleValue());
            ccrForm.setCashSubTotal(totalSummaryVO.getCashSubTotal().doubleValue());
            ccrForm.setCouponSubTotal(totalSummaryVO.getCouponSubTotal().doubleValue());
            ccrForm.setDepositSubTotal(totalSummaryVO.getDepositSubTotal().doubleValue());
            ccrForm.setCreditCardSubTotal(totalSummaryVO.getCreditCardSubTotal().doubleValue());
            ccrForm.setCheckSubTotal(totalSummaryVO.getCheckSubTotal().doubleValue());
            ccrForm.setCanClose(true);
            if(totalSummaryVO.getStatusCd() != null && totalSummaryVO.getStatusCd().intValue() < 1)
                ccrForm.setCanClose(false);
            ccrForm.setTotalPayments(ccrForm.getCashTotal()+ccrForm.getCheckTotal()+ccrForm.getCouponTotal()+ccrForm.getCreditCardTotal()+ccrForm.getDepositTotal());
        }
    }

    private void calcTotalsSplit(GroundCashRecapForm ccrForm,
                                 String locationCd,
                                 String employeeId,
                                 Integer pageNumber,
                                 Integer rowsByPage) throws Exception {
        PrepPoaBizDelegate delegate = new PrepPoaBizDelegate();
        TotalSummaryVO totalSummaryVO = delegate.getGroundDetailsSplitTotal(locationCd,employeeId,pageNumber,rowsByPage);
        ccrForm.setCashTotal(totalSummaryVO.getCashTotal().doubleValue());
        ccrForm.setCouponTotal(totalSummaryVO.getCouponTotal().doubleValue());
        ccrForm.setDepositTotal(totalSummaryVO.getDepositTotal().doubleValue());
        ccrForm.setCreditCardTotal(totalSummaryVO.getCreditCardTotal().doubleValue());
        ccrForm.setCheckTotal(totalSummaryVO.getCheckTotal().doubleValue());
        ccrForm.setCashSubTotal(totalSummaryVO.getCashSubTotal().doubleValue());
        ccrForm.setCouponSubTotal(totalSummaryVO.getCouponSubTotal().doubleValue());
        ccrForm.setDepositSubTotal(totalSummaryVO.getDepositSubTotal().doubleValue());
        ccrForm.setCreditCardSubTotal(totalSummaryVO.getCreditCardSubTotal().doubleValue());
        ccrForm.setCheckSubTotal(totalSummaryVO.getCheckSubTotal().doubleValue());
        ccrForm.setUsdCashTotal(totalSummaryVO.getUsdCashTotal().doubleValue());
        ccrForm.setUsdCouponTotal(totalSummaryVO.getUsdCouponTotal().doubleValue());
        ccrForm.setUsdDepositTotal(totalSummaryVO.getUsdDepositTotal().doubleValue());
        ccrForm.setUsdCreditCardTotal(totalSummaryVO.getUsdCreditCardTotal().doubleValue());
        ccrForm.setUsdCheckTotal(totalSummaryVO.getUsdCheckTotal().doubleValue());
        ccrForm.setUsdCashSubTotal(totalSummaryVO.getUsdCashSubTotal().doubleValue());
        ccrForm.setUsdCouponSubTotal(totalSummaryVO.getUsdCouponSubTotal().doubleValue());
        ccrForm.setUsdDepositSubTotal(totalSummaryVO.getUsdDepositSubTotal().doubleValue());
        ccrForm.setUsdCreditCardSubTotal(totalSummaryVO.getUsdCreditCardSubTotal().doubleValue());
        ccrForm.setUsdCheckSubTotal(totalSummaryVO.getUsdCheckSubTotal().doubleValue());
        ccrForm.setCanClose(true);
        if(totalSummaryVO.getStatusCd() != null && totalSummaryVO.getStatusCd().intValue() < 1)
            ccrForm.setCanClose(false);
        ccrForm.setTotalPayments(ccrForm.getCashTotal()+ccrForm.getCheckTotal()+ccrForm.getCouponTotal()+ccrForm.getCreditCardTotal()+ccrForm.getDepositTotal());
        ccrForm.setUsdTotalPayments(ccrForm.getUsdCashTotal()+ccrForm.getUsdCheckTotal()+ccrForm.getUsdCouponTotal()+ccrForm.getUsdCreditCardTotal()+ccrForm.getUsdDepositTotal());
    }
}