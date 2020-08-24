/**
 * PRPCourierCashRecapAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.common.j2ee.mcd.MCD;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.*;

import org.apache.struts.action.*;

import java.util.*;
import java.util.logging.Logger;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.FastHashMap;


/**
 * This class manages the requests for the Prepaid
 * Detail Screen
 * @author  ccardenas
 */
public class PRPCourierCashRecapAction extends Action implements java.io.Serializable{
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
    	AppInit.startMcd();
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
        else if("ProcessScans".equals(request.getParameter("action"))) {
            return processScans(mapping,form,request,response);
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
        else if("toGround".equals(request.getParameter("action"))) {
            updateInformation(mapping,form,request,response);
            return mapping.findForward("toGround");
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
        else if ("QuickApplyStatus".equals(request.getParameter("action"))){
            return quickApplyStatus(mapping,form,request,response);
        }
        else if ("ReassignPayments".equals(request.getParameter("action"))){
            return reassignPayments(mapping,form,request,response);
        }
        else if("showScans".equals(request.getParameter("action"))){
            return showScans(mapping,form,request,response);
        }
        else{
            updateInformation(mapping,form,request,response);
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
        PRPCourierCashRecapForm ccrForm = (PRPCourierCashRecapForm) form;

        double exchangeRate   = new Double(request.getParameter("exchangeRate")).doubleValue();
        String amountToChangeString = request.getParameter("amountToChange");
        double amountToChange = 0;
        if(amountToChangeString != null && amountToChangeString.trim().length()>0)
           amountToChange=new Double(request.getParameter("amountToChange")).doubleValue();

        if("FRE".equals(ccrForm.getShowFreightOAC())){
            Collection prepaidsSelected = new ArrayList();
            PrepaidDetailsTableVO prepaidCashRecap = null;
            Iterator itRec = ccrForm.getAwbs().iterator();

            while(itRec.hasNext())
            {   prepaidCashRecap = (PrepaidDetailsTableVO)itRec.next();
                if(prepaidCashRecap.isSelected()) {
                   prepaidsSelected.add(prepaidCashRecap);
                }
            }


            ArrayList currencies = (ArrayList)ccrForm.getSupportedCurrencies();
            SupportedCurrencyVO scVO=null;
            for(int i=0;i<currencies.size();i++)
            {   scVO= (SupportedCurrencyVO)currencies.get(i);
                if(!(ccrForm.getCurrentCurrency().equals(scVO.getCurrencyCode())))
                {  break;}
            }
            prepBiz.splitCurrency(prepaidsSelected,scVO.getCurrencyCode(),exchangeRate,amountToChange);
        }else{//But is OAC
            Collection oacsSelected = new ArrayList();
            OACDetailsTableVO oacCashRecap = null;
            Iterator itRec = ccrForm.getOacs().iterator();

            while(itRec.hasNext())
            {   oacCashRecap = (OACDetailsTableVO)itRec.next();
                if(oacCashRecap.isSelected()) {
                   oacsSelected.add(oacCashRecap);
                }
            }

            ArrayList currencies = (ArrayList)ccrForm.getSupportedCurrencies();
            SupportedCurrencyVO scVO=null;
            for(int i=0;i<currencies.size();i++)
            {   scVO= (SupportedCurrencyVO)currencies.get(i);
                if(!(ccrForm.getCurrentCurrency().equals(scVO.getCurrencyCode())))
                {  break;}
            }

            prepBiz.splitOacCurrency(oacsSelected,scVO.getCurrencyCode(),exchangeRate,amountToChange);
        }

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
            PRPCourierCashRecapForm ccrForm=(PRPCourierCashRecapForm) form;

            /////////////////////////////////
            // Getting employee profile
            /////////////////////////////////
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");

            /*************************************************************************************/
            /** Check if ask for show ancillary outbound, but go ahead with the code of freight **/
            /*************************************************************************************/
            //Constants.logger.debug("\n *** ccrForm.getShowFreightOAC() value = " + ccrForm.getShowFreightOAC());
            if(ep.isOacUsedFlag() && "OAC".equals(ccrForm.getShowFreightOAC()))
            {  return showOac(mapping,form,request,response); }
            else{
                ccrForm.setShowFreightOAC("FRE");
            }

            /***********************/
            /** Code for freight **/
            /**********************/
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
            // Get the supported currencies
            /////////////////////////////////
            ccrForm.setSupportedCurrencies(ep.getSupportedCurrencies());
            ccrForm.setCountryBanks((Collection)request.getSession().getAttribute("countryBanks"));
            
            
            
            /* Start- For Mcd start for Prepaid Detail screen*/
        	long startTime = System.currentTimeMillis() ;
            try {
            	System.out.println("Mcd in prepaid detail");
                // Beginning of request. Inform McD
                MCD.processEvent("server",
                    "GCCS",
                    "PRPCourierCashRecapAction",
                    //AppUtils.getHostname(),
                    AppInit.getHostname(),
                    null,
                    "OR",
                    "PrepaidDetailScreen",
                    null,
                    null,
                    -1,
                    null);
            } catch (Exception e) {
                //AppLogger.error("McD Exception while processing GCCS.PrepaidDetailScreen", e) ;
                System.out.println("McD Exception while processing GCCS.PrepaidDetailScreen") ;
            	e.printStackTrace();
            }
            /* End- For Mcd start for Prepaid Detail screen*/
            
            
            PrepPoaBizDelegate biz=new PrepPoaBizDelegate();
            //get the currently used currencies
            Collection colUsedCurr=biz.getPrepaidUsedCurrencies(ep.getLocationCd(),ccrForm.getCourier());
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
                Hashtable result = biz.getSplitPrepaidTable(ep.getLocationCd(),ccrForm.getCourier(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
                ccrForm.setAwbs((List) result.get("RESULTSET"));
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
                    // Getting the prepaids
                    /////////////////////////
                    Hashtable result = biz.getPrepaidDetailsTable(ep.getLocationCd(),ccrForm.getCourier(),ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
                    ccrForm.setAwbs((List) result.get("RESULTSET"));
                    ccrForm.setNumberOfPages((Integer) result.get("NUMBEROFPAGES"));
                }
            
            
            
            
               /* Start- For Mcd End for Prepaid Detail screen*/            
               try {
                   MCD.processEvent("server",
	                  "GCCS",
	                  "PRPCourierCashRecapAction",
                      //AppUtils.getHostname(),
                      AppInit.getHostname(),
                      null,
                      "IP",
                      "PrepaidDetailScreen",
                      null,
                      null,
                      System.currentTimeMillis() - startTime,
                      null);
                   } catch (Exception e) {
                      //AppLogger.error("McD exception while processing GCCS.PrepaidDetailScreen", e) ;
                      System.out.println("McD Exception while processing GCCS.PrepaidDetailScreen") ;
                  	  e.printStackTrace();
               }            
            
                /* End- For Mcd End for Prepaid Detail screen*/
            
                ////////////////////////////////////////
                // Getting the employees with payments
                ////////////////////////////////////////
                ccrForm.setEmployeesWithPayments(new CommonOpsBizDelegate().getEmployeesWithPayments(ep.getLocationCd()));
                /////////////////////////////
                // Get valid prepaid status
                /////////////////////////////
                ccrForm.setPreStatus(biz.getAllPreStatus());
                //////////////////////////////////////
                // Setting the attributes for paging
                //////////////////////////////////////
                setPagingAttributes(request,rowsByPage);
                ////////////////////////////////////
                // Setting the used payment types
                ////////////////////////////////////
                Collection paymentTypes=new PaymentTypeController().getPaymentTypeByPrpLocation(ep.getLocationCd());
                ccrForm.setPaymentTypes(paymentTypes);
                /////////////////////////////////
                // Calculate the total amounts
                /////////////////////////////////
                calcTotals(ccrForm,ep.getLocationCd(),ccrForm.getCourier(),ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
                /////////////////////////////////////////////////////
                // Check if there are split record for receivables.
                /////////////////////////////////////////////////////
                int splittes = new CommonOpsBizDelegate().getSplitCountTable(ep.getLocationCd(), ccrForm.getCourier(),"PREPAID");
            
                if(splittes > 0)
                   ccrForm.setDualCurrency(true); //If splitted records exist then dualCurrency flag is true
                else //If no splitted records then dualCurrency flag is false
                   ccrForm.setDualCurrency(false);
                request.setAttribute("rowsByPage",new Integer(rowsByPage));
                request.setAttribute("PRPCourierCashRecapForm",ccrForm);
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
        PrepaidController pc=new PrepaidController();
        OacController oc=new OacController();

        String prepType = request.getParameter("prepaidType");

        if("FRE".equals(prepType)){
            PrepaidVO pVO=pc.getPrepaid(new Integer(request.getParameter("prepaidId")));
            pVO.setPaymentCurrency(request.getParameter("newCurr"));
            pc.updatePrepaid(pVO);
        }else{
                OacVO oVO=oc.getOac(new Integer(request.getParameter("oacId")));
                oVO.setPymtCurrCd(request.getParameter("newCurr"));
                oc.updateOac(oVO);
             }
        return show(mapping,form,request,response);
    }
    
    /**
     * This method is used to apply clear status when a DDEX is present.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */

    private ActionForward quickApplyStatus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PRPCourierCashRecapForm ccrForm=null;
        if(form==null){
            ccrForm=new PRPCourierCashRecapForm();
        }else{
            ccrForm=(PRPCourierCashRecapForm)form;
        }

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

        if("ALL".equals(ccrForm.getCourier()) || ccrForm.getCourier() == null) {
            ccrForm.setCourier(null);
            rowsByPage = 40;
        }

        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
        if(ep.isQuickStatus()){
            Iterator iterRec=ccrForm.getAwbs().iterator();
            while(iterRec.hasNext()){
                PrepaidDetailsTableVO rec=(PrepaidDetailsTableVO)iterRec.next();
                if(rec.getScanAmount()>0 && rec.getStatusId()!=1 && rec.getOtherPayment()<=0){
                    rec.setStatusId(1);
                }
            }
        }

        setPagingAttributes(request, rowsByPage);
        calcTotals(ccrForm,ep.getLocationCd(),ccrForm.getCourier(),ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
        request.setAttribute("PRPCourierCashRecapForm",ccrForm);
        return mapping.findForward("Success");
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
        PRPCourierCashRecapForm ccrForm=(PRPCourierCashRecapForm)form;

        if(!(ccrForm.getAwbs().isEmpty()) && "FRE".equals(ccrForm.getShowFreightOAC())){
            Iterator iterRec=ccrForm.getAwbs().iterator();
            while(iterRec.hasNext()){
                PrepaidDetailsTableVO rec=(PrepaidDetailsTableVO)iterRec.next();
                if(!rec.isModified()){
                    iterRec.remove();
                }else{
                    EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                    rec.setChngStatusDate(Utils.changeDateToTZ(new java.util.Date(),ep.getLocationTimeZone()));
                    rec.setChngStatusEmployeeId(ep.getEmployeeId());

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
            PrepPoaBizDelegate biz=new PrepPoaBizDelegate();
            biz.applyPrepaidChanges(ccrForm.getAwbs());

        }else if (!ccrForm.getOacs().isEmpty() && "OAC".equals(ccrForm.getShowFreightOAC())){
                    Iterator iterRec=ccrForm.getOacs().iterator();
                    while(iterRec.hasNext()){
                        OACDetailsTableVO rec=(OACDetailsTableVO)iterRec.next();
                        if(!rec.isModified()){
                            iterRec.remove();
                        }else{
                            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                            rec.setChngStatusDate(Utils.changeDateToTZ(new java.util.Date(),ep.getLocationTimeZone()));
                            rec.setChngStatusEmployeeId(ep.getEmployeeId());

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
                   PrepPoaBizDelegate biz=new PrepPoaBizDelegate();
                   biz.applyOacChanges(ccrForm.getOacs());            
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
    	PRPCourierCashRecapForm ccrForm=(PRPCourierCashRecapForm)form;
        Iterator iterRec=ccrForm.getAwbs().iterator();
        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
        
        if(new EmployeeController().getEmployee(ccrForm.getNewEmployeeId())==null){
        	ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CourierDoesNotExist"));
            saveErrors(request,ae);
            return show(mapping,form,request,response);
        }
        
        PrepaidController rc=new PrepaidController();
        while(iterRec.hasNext()){
            PrepaidDetailsTableVO rec=(PrepaidDetailsTableVO)iterRec.next();
            
            if(rec.isSelected()){
            	PrepaidVO rVO=rc.getPrepaid(new Integer(rec.getPrepaidId()));
            	rVO.setOrigEmployeeId(rVO.getCourierId());
            	rVO.setReassEmpId(ep.getEmployeeId());
            	rVO.setCourierId(ccrForm.getNewEmployeeId());
            	rVO.setLocationCd(ccrForm.getNewReassLocationCd());

                //Validate Currency for the country
                String curResult = Utils.validateCountryCurencyInProcess(rVO.getLocationCd(),rVO.getPaymentCurrency());
                if(curResult!=null){
                   rVO.setPaymentCurrency(curResult);
                }
            	
               	rc.updatePrepaid(rVO);
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
        
        PRPCourierCashRecapForm ccrForm=(PRPCourierCashRecapForm)form;
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
        PRPCourierCashRecapForm ccrForm=null;
        if(form==null){
            ccrForm=new PRPCourierCashRecapForm();
        }else{
            ccrForm=(PRPCourierCashRecapForm)form;
        }

        int rowsByPage = 20;
        if("ALL".equals(ccrForm.getCourier()) || ccrForm.getCourier() == null) {
            ccrForm.setCourier(null);
            rowsByPage = 40;
        }

        setPagingAttributes(request, rowsByPage);
        calcTotals(ccrForm,((Integer)request.getAttribute("offset")).intValue(),((Integer)request.getAttribute("length")).intValue());
        
        request.setAttribute("PRPCourierCashRecapForm",ccrForm);
        
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
    private void calcTotals(PRPCourierCashRecapForm ccrForm,
                            String locationCd,
                            String employeeId,
                            String currentCurrencyCd,
                            Integer pageNumber,
                            Integer rowsByPage,
                            String sortColumn,
                            String sortDirection) throws Exception {
        if(ccrForm.isDualCurrency() && "split".equals(currentCurrencyCd)) {
            calcTotalsSplit(ccrForm,locationCd,employeeId,pageNumber,rowsByPage,sortColumn,sortDirection);
        }
        else {
            PrepPoaBizDelegate delegate = new PrepPoaBizDelegate();

            /**** Freight Totals  ****/
            TotalSummaryVO totalSummaryVO     = delegate.getPrepaidDetailsTotal(locationCd,employeeId,currentCurrencyCd,pageNumber,rowsByPage,sortColumn,sortDirection);
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
            /**** Freight Totals  ****/

            /**** OAC Totals  ****/
            TotalSummaryVO totalOacsSummaryVO = delegate.getOacDetailsTotal(locationCd,employeeId,currentCurrencyCd,pageNumber,rowsByPage,sortColumn,sortDirection);
            ccrForm.setOacCashTotal(totalOacsSummaryVO.getCashTotal().doubleValue());
            ccrForm.setOacDepositTotal(totalOacsSummaryVO.getDepositTotal().doubleValue());
            ccrForm.setOacCreditCardTotal(totalOacsSummaryVO.getCreditCardTotal().doubleValue());
            ccrForm.setOacCheckTotal(totalOacsSummaryVO.getCheckTotal().doubleValue());
            ccrForm.setOacCashSubTotal(totalOacsSummaryVO.getCashSubTotal().doubleValue());
            ccrForm.setOacDepositSubTotal(totalOacsSummaryVO.getDepositSubTotal().doubleValue());
            ccrForm.setOacCreditCardSubTotal(totalOacsSummaryVO.getCreditCardSubTotal().doubleValue());
            ccrForm.setOacCheckSubTotal(totalOacsSummaryVO.getCheckSubTotal().doubleValue());

                ccrForm.setCanClose(true);
                if(totalOacsSummaryVO.getStatusCd() != null && totalOacsSummaryVO.getStatusCd().intValue() < 1)
                    ccrForm.setCanClose(false);

            /**** OAC Totals  ****/

            /** Grand Totals **/
            ccrForm.setTotalPayments(ccrForm.getCashTotal()+ccrForm.getCheckTotal()+ccrForm.getCouponTotal()+ccrForm.getCreditCardTotal()+ccrForm.getDepositTotal());
            ccrForm.setOacTotalPayments(ccrForm.getOacCashTotal()+ccrForm.getOacCheckTotal()+ccrForm.getOacCreditCardTotal()+ccrForm.getOacDepositTotal());
            ccrForm.setGrandCoupon(totalSummaryVO.getCouponTotal().doubleValue());
            ccrForm.setGrandCash(ccrForm.getCashTotal()+ccrForm.getOacCashTotal());
            ccrForm.setGrandCheck(ccrForm.getCheckTotal()+ccrForm.getOacCheckTotal());
            ccrForm.setGrandCreditCard(ccrForm.getCreditCardTotal()+ccrForm.getOacCreditCardTotal());
            ccrForm.setGrandDeposit(ccrForm.getDepositTotal()+ccrForm.getOacDepositTotal());
            ccrForm.setGrandTotal(ccrForm.getTotalPayments()+ccrForm.getOacTotalPayments());
        }
    }

    private void calcTotalsSplit(PRPCourierCashRecapForm ccrForm,
                                 String locationCd,
                                 String employeeId,
                                 Integer pageNumber,
                                 Integer rowsByPage,
                                 String sortColumn,
                                 String sortDirection) throws Exception {
        PrepPoaBizDelegate delegate = new PrepPoaBizDelegate();

        /**** Freigth Totals  ****/
        TotalSummaryVO totalSummaryVO = delegate.getPrepaidDetailsSplitTotal(locationCd,employeeId,pageNumber,rowsByPage,sortColumn,sortDirection);
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
        /**** Freigth Totals  ****/

        /**** OAC Totals  ****/
            TotalSummaryVO totalOacsSummaryVO = delegate.getOacDetailsSplitTotal(locationCd,employeeId,pageNumber,rowsByPage,sortColumn,sortDirection);
            ccrForm.setOacCashTotal(totalOacsSummaryVO.getCashTotal().doubleValue());
            ccrForm.setOacDepositTotal(totalOacsSummaryVO.getDepositTotal().doubleValue());
            ccrForm.setOacCreditCardTotal(totalOacsSummaryVO.getCreditCardTotal().doubleValue());
            ccrForm.setOacCheckTotal(totalOacsSummaryVO.getCheckTotal().doubleValue());
            ccrForm.setOacCashSubTotal(totalOacsSummaryVO.getCashSubTotal().doubleValue());
            ccrForm.setOacDepositSubTotal(totalOacsSummaryVO.getDepositSubTotal().doubleValue());
            ccrForm.setOacCreditCardSubTotal(totalOacsSummaryVO.getCreditCardSubTotal().doubleValue());
            ccrForm.setOacCheckSubTotal(totalOacsSummaryVO.getCheckSubTotal().doubleValue());
            ccrForm.setUsdOacCashTotal(totalOacsSummaryVO.getUsdCashTotal().doubleValue());
            ccrForm.setUsdOacDepositTotal(totalOacsSummaryVO.getUsdDepositTotal().doubleValue());
            ccrForm.setUsdOacCreditCardTotal(totalOacsSummaryVO.getUsdCreditCardTotal().doubleValue());
            ccrForm.setUsdOacCheckTotal(totalOacsSummaryVO.getUsdCheckTotal().doubleValue());
            ccrForm.setUsdOacCashSubTotal(totalOacsSummaryVO.getUsdCashSubTotal().doubleValue());
            ccrForm.setUsdOacDepositSubTotal(totalOacsSummaryVO.getUsdDepositSubTotal().doubleValue());
            ccrForm.setUsdOacCreditCardSubTotal(totalOacsSummaryVO.getUsdCreditCardSubTotal().doubleValue());
            ccrForm.setUsdOacCheckSubTotal(totalOacsSummaryVO.getUsdCheckSubTotal().doubleValue());

            ccrForm.setCanClose(true);
            if(totalOacsSummaryVO.getStatusCd() != null && totalOacsSummaryVO.getStatusCd().intValue() < 1)
               ccrForm.setCanClose(false);
            ccrForm.setOacTotalPayments(ccrForm.getOacCashTotal()+ccrForm.getOacCheckTotal()+ccrForm.getOacCreditCardTotal()+ccrForm.getOacDepositTotal());
            ccrForm.setUsdOacTotalPayments(ccrForm.getUsdOacCashTotal()+ccrForm.getUsdOacCheckTotal()+ccrForm.getUsdOacCreditCardTotal()+ccrForm.getUsdOacDepositTotal());
            /**** OAC Totals  ****/

            /** Grand Totals **/
            ccrForm.setOacTotalPayments(ccrForm.getOacCashTotal()+ccrForm.getOacCheckTotal()+ccrForm.getOacCreditCardTotal()+ccrForm.getOacDepositTotal());
            ccrForm.setUsdOacTotalPayments(ccrForm.getUsdOacCashTotal()+ccrForm.getUsdOacCheckTotal()+ccrForm.getUsdOacCreditCardTotal()+ccrForm.getUsdOacDepositTotal());

            ccrForm.setGrandCoupon(totalSummaryVO.getCouponTotal().doubleValue());
            ccrForm.setGrandCash(ccrForm.getCashTotal()+ccrForm.getOacCashTotal());
            ccrForm.setGrandCheck(ccrForm.getCheckTotal()+ccrForm.getOacCheckTotal());
            ccrForm.setGrandCreditCard(ccrForm.getCreditCardTotal()+ccrForm.getOacCreditCardTotal());
            ccrForm.setGrandDeposit(ccrForm.getDepositTotal()+ccrForm.getOacDepositTotal());

            ccrForm.setUsdGrandCoupon(totalSummaryVO.getUsdCouponTotal().doubleValue());
            ccrForm.setUsdGrandCash(ccrForm.getUsdCashTotal()+ccrForm.getUsdOacCashTotal());
            ccrForm.setUsdGrandCheck(ccrForm.getUsdCheckTotal()+ccrForm.getUsdOacCheckTotal());
            ccrForm.setUsdGrandCreditCard(ccrForm.getUsdCreditCardTotal()+ccrForm.getUsdOacCreditCardTotal());
            ccrForm.setUsdGrandDeposit(ccrForm.getUsdDepositTotal()+ccrForm.getUsdOacDepositTotal());

            ccrForm.setGrandTotal(ccrForm.getTotalPayments()+ccrForm.getOacTotalPayments());
            ccrForm.setUsdGrandTotal(ccrForm.getTotalPayments()+ccrForm.getOacTotalPayments());
    }

    /**
     * This method start the scans processing for the prepaids
     * currently being shown.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */ 
    public ActionForward processScans(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
			PrepPoaBizDelegate biz=new PrepPoaBizDelegate();
			CommonOpsBizDelegate comBiz  = new CommonOpsBizDelegate();
			try{
				EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
				PRPCourierCashRecapForm ccrForm=(PRPCourierCashRecapForm)form;
				
				 long startTime = System.currentTimeMillis() ;
		            try {
		                // Beginning of request. Inform McD
		            	System.out.println("Mcd in Process SCAN TESTT");
		                MCD.processEvent("server",
		                    "GCCS",
		                    "PRPCourierCashRecapAction",
		                    //AppUtils.getHostname(),
		                    AppInit.getHostname(),
		                    null,
		                    "OR",
		                    "processScansPrePaidCourierCashRecap",
		                    null,
		                    null,
		                    -1,
		                    null);
		            } catch (Exception e) {
		                //AppLogger.error("McD Exception while processing processScansPrePaidCourierCashRecap", e) ;
		                System.out.println("McD Exception while processing GCCS.processScansPrePaidCourierCashRecap") ;
		            	e.printStackTrace();
		            }
		            
				PrepaidController pc = new PrepaidController();
				
				Collection awbs		= pc.getPrepaidPRPWithoutScan(ccrForm.getCourier(),ep.getLocationCd(),new Integer(1));
				
				//Constants.logger.debug("\n Nro. de registros en prepaid : " + awbs.size());

				Collection ppScans	= Collections.synchronizedCollection(new ArrayList());
				PrepaidScansVO psvo=null;
				Iterator it=awbs.iterator();
				while(it.hasNext()){
					  PrepaidVO pp=(PrepaidVO)it.next();
					  psvo = new PrepaidScansVO();
					  psvo.setPrepaidVO(pp);
					  ppScans.add(psvo);	
				}

				Collection results=Collections.synchronizedCollection(new ArrayList());               
	               
	            PrepaidScanProcessor sp=new PrepaidScanProcessor();                
	            
	            //Constants.logger.debug("\n Nro. de registros en prepaid para process scans: " + ppScans.size());
	            
	            //Get Scan information 
	            //Collection np=sp.processLastScans(ppScans,results,ep.getLocationCd(), null, ccrForm.getCurrentCurrency(),ep.getLocationTimeZone(),ep.getScansLocalDecs(),ep.getScansUsdDecs());
                sp.processLastScans(ppScans,results,ep.getLocationCd(), null, ccrForm.getCurrentCurrency(),ep.getLocationTimeZone(),ep.getScansLocalDecs(),ep.getScansUsdDecs(),comBiz.getLocationCdByCountry(ep.getCountryCd()));

	            //Update Prepaid information with scan information
	              biz.updatePRPWithScanProcessed(results);
	              
	              
	              // End of request. Inform McD
	              try {
	                  MCD.processEvent("server",
	  	                "GCCS",
	  	                "PRPCourierCashRecapAction",
	                     //AppUtils.getHostname(),
	                     AppInit.getHostname(),
	                     null,
	                     "IP",
	                     "processScansPrePaidCourierCashRecap",
	                     null,
	                     null,
	                     System.currentTimeMillis() - startTime,
	                     null);
	              } catch (Exception e) {
	                  //AppLogger.error("McD exception while processing processScansPrePaidCourierCashRecap", e) ;
	                  System.out.println("McD Exception while processing GCCS.processScansPrePaidCourierCashRecap") ;
		              e.printStackTrace();
	              }
       
			}catch(Exception e){
				Constants.logger.debug(Utils.stackTraceToString(e));
				ActionErrors ae=new ActionErrors();
				ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.ScansProcessingError"));
				saveErrors(request,ae);
			}
			return show(mapping,form,request,response);
    }

    /**
     * This method prepares the information and put it in the
     * request for the ROD Scans Details screen page.
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */ 
    private ActionForward showScans(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            ShowScans ss=new ShowScans();
            ss.setScansLocalDecs(ep.getScansLocalDecs());
            ss.setScansUsdDecs(ep.getScansUsdDecs());

            List colResults=(List)ss.getPrepaidScans(request.getParameter("awbNbr"),ep.getLocationCd());
            Collections.sort(colResults,new Comparator(){
				                public int compare(Object obj1, Object obj2){         
				                	CosmosScansTableVO ccrVO1=(CosmosScansTableVO)obj1;
				                	CosmosScansTableVO ccrVO2=(CosmosScansTableVO)obj2;
				                    return ccrVO1.getScanDtTm()==null?-1:ccrVO2.getScanDtTm().compareTo(ccrVO1.getScanDtTm());
				                }
            				}); 
            
            if(ss.getErrors()!=null && !ss.getErrors().isEmpty()){
            	Iterator iter=ss.getErrors().iterator();
            	if(iter.hasNext()){
            		ScansProcessingError spe=(ScansProcessingError)iter.next();
            		ActionErrors ae=new ActionErrors();
            		ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.CannotFindDetailedScans"));
                    saveErrors(request,ae);
            	}		
            }
            
            request.setAttribute("pageTitle","AWB "+request.getParameter("awbNbr"));
            request.setAttribute("scans",colResults);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);
       }
       return mapping.findForward("showScans");
    }

    /**
     * This method prepares the information to be showed
     * by the OAC Details page.
     *
     * @param    mapping object
     * @param    form object
     * @param    request object
     * @param    response object
     * @return   Struts action forward
     * @exception Exception
     */
    private ActionForward showOac(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            PRPCourierCashRecapForm ccrForm=(PRPCourierCashRecapForm) form;


            /***********************/
            /** Code for oac **/
            /**********************/
            //////////////////////////////////////
            // Initialization of parameters
            //////////////////////////////////////
            Integer pageNumber = new Integer(1);
            String sortColumn = "OB_ANC_SVC_DT";
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
            Collection colUsedCurr=biz.getOacUsedCurrencies(ep.getLocationCd(),ccrForm.getCourier());
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
                Hashtable result = biz.getSplitOacTable(ep.getLocationCd(),ccrForm.getCourier(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
                ccrForm.setOacs((List) result.get("RESULTSET"));

                ccrForm.setNumberOfPages((Integer) result.get("NUMBEROFPAGES"));
                ccrForm.setDualCurrency(true);
            }
            else{
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
                    // Getting the prepaids
                    /////////////////////////
                    Hashtable result = biz.getOacDetailsTable(ep.getLocationCd(),ccrForm.getCourier(),ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
                    ccrForm.setOacs((List) result.get("RESULTSET"));
                    ccrForm.setNumberOfPages((Integer) result.get("NUMBEROFPAGES"));
                }
                ////////////////////////////////////////
                // Getting the employees with payments
                ////////////////////////////////////////
                ccrForm.setEmployeesWithPayments(new CommonOpsBizDelegate().getEmployeesWithPayments(ep.getLocationCd()));
                /////////////////////////////
                // Get valid prepaid status
                /////////////////////////////

                 /*  Fill status of Oac */
                Collection statusOac = new ArrayList();
                statusOac.add(new PreStatusVO(new Integer(0), "No Clear", 0));
                statusOac.add(new PreStatusVO(new Integer(1), "Clear", 0));
                statusOac.add(new PreStatusVO(new Integer(2), "Collect Later", 0));

                ccrForm.setOacStatus(statusOac);//biz.getAllPreStatus());

                //ccrForm.setPreStatus(biz.getAllPreStatus());
                //////////////////////////////////////
                // Setting the attributes for paging
                //////////////////////////////////////
                setPagingAttributes(request,rowsByPage);
                ////////////////////////////////////
                // Setting the used payment types
                ////////////////////////////////////
                Collection paymentTypes=new PaymentTypeController().getPaymentTypeByPrpLocation(ep.getLocationCd());
                ccrForm.setPaymentTypes(paymentTypes);
                /////////////////////////////////
                // Calculate the total amounts
                /////////////////////////////////
                calcTotals(ccrForm,ep.getLocationCd(),ccrForm.getCourier(),ccrForm.getCurrentCurrency(),pageNumber,new Integer(rowsByPage),sortColumn,sortDirection);
                /////////////////////////////////////////////////////
                // Check if there are split record for receivables.
                /////////////////////////////////////////////////////
                int splittes = new CommonOpsBizDelegate().getSplitCountTable(ep.getLocationCd(), ccrForm.getCourier(),"OAC");

                if(splittes > 0)
                   ccrForm.setDualCurrency(true); //If splitted records exist then dualCurrency flag is true
                else //If no splitted records then dualCurrency flag is false
                   ccrForm.setDualCurrency(false);
                request.setAttribute("rowsByPage",new Integer(rowsByPage));
                request.setAttribute("PRPCourierCashRecapForm",ccrForm);
        }
        catch(Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);
        }
        return mapping.findForward("Success");
    }//Close showOac
}