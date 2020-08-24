package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.PrepPoaBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.AddOACForm;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.controller.EmployeeController;

/**
 * Created by Reinaldo Alvarez.
 * User: arturog
 * Date: 21-03-2005
 * Time: 12:32:11 PM
 * Description :
 */
public class AddOACAction extends Action implements Serializable {

    PrepPoaBizDelegate ppbd = new PrepPoaBizDelegate();

    public AddOACAction(){
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
        String action=request.getParameter("action");
        if("addNewOac".equals(action)){
            return addNewOac(mapping, form, request, response);
        }else if("delNewOac".equals(action)){
            return delNewOac(mapping, form, request, response);
        }else if("saveOacs".equals(action)){
             return saveOacs(mapping, form, request, response);
        }else{
            return showWindow(mapping, form, request, response);
        }
    }

    private ActionForward saveOacs(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
          String nextPage=null;
            try{
                //checking if the user is logged in
                EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                if(ep==null) return mapping.findForward("logout");

                AddOACForm frm=(AddOACForm)form;

                Collection oacList = frm.getOacList();

                ppbd.saveOacs(oacList, frm.getLocationCd());

            }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ActionErrors ae=new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotSaveTheData"));
                saveErrors(request,ae);
                return showWindow(mapping, form, request, response);
            }

            return mapping.findForward("Success");
    }//Close save Oacs.

    private ActionForward addNewOac(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
        AddOACForm  frm = (AddOACForm)form;
        ActionErrors ae = new ActionErrors();

        try{
            EmployeeProfile ep = (EmployeeProfile)request.getSession().getAttribute("userProfile");
            frm.setCurrencySupported(ep.getSupportedCurrencies());

            OACDetailsTableVO oacVO = frm.getNewOac();
            oacVO.setCourierId(frm.getCourier());
            oacVO.setPaymentCurrency(oacVO.getPaymentCurrency());

            if(frm.getAwbSelected()==null)
               frm.setAwbs(new String[0]);
            else
                frm.setAwbs(frm.getAwbSelected());

            //Check if Exist the courier id
            try{
                EmployeeController empCtrl = new EmployeeController();
                empCtrl.getEmployee(frm.getCourier());
            }catch(Exception ec)
            {  ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.CourierDoesNotExist"));
               saveErrors(request,ae);
               return mapping.findForward("ShowWindow");
            }
            frm.getOacList().add(oacVO);

            frm.setNewOac(new OACDetailsTableVO());
            frm.getNewOac().setAwbs(new String[0]);
            //Set current Date
            String currentDay = new SimpleDateFormat("MM/dd/yyyy",request.getLocale()).format(new Date());
            frm.getNewOac().setOacDateText(currentDay);
            Constants.logger.debug("Curency form => " + frm.getCurrencyCd());
            frm.getNewOac().setPaymentCurrency(frm.getCurrencyCd());

        }catch(Exception e){
             Constants.logger.debug(Utils.stackTraceToString(e));
             ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotAddNewOac"));
             saveErrors(request,ae);
        }
       request.setAttribute("AddOACForm",frm);
       return mapping.findForward("ShowWindow");
    }

    private ActionForward delNewOac(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
        String item=request.getParameter("item");
        AddOACForm  frm = (AddOACForm)form;

        try{
            EmployeeProfile ep = (EmployeeProfile)request.getSession().getAttribute("userProfile");

            OACDetailsTableVO oacVO = (OACDetailsTableVO)frm.getOacList().get(Integer.parseInt(item));
            String[] awbs = oacVO.getAwbs();

            if(frm.getAwbSelected()==null){
               frm.setAwbs(awbs);
            }else{
                    Object[] awbsSelected=frm.getAwbSelected();

                    ArrayList awbsSelectedList = new ArrayList(Arrays.asList(awbsSelected));

                    frm.setAwbs(awbsSelectedList.toArray());
                }

            frm.getOacList().remove(Integer.parseInt(item));
            frm.getNewOac().setAwbs(new String[0]);
            frm.setCurrencySupported(ep.getSupportedCurrencies());
        }catch(Exception e){
             ActionErrors ae = new ActionErrors();
             Constants.logger.debug(Utils.stackTraceToString(e));
              ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotDelNewOac"));
              saveErrors(request,ae);
        }
       request.setAttribute("AddOACForm",frm);
       return mapping.findForward("ShowWindow");
    }

    private ActionForward showWindow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
        AddOACForm  frm = (AddOACForm)form;
        try{
            EmployeeProfile ep = (EmployeeProfile)request.getSession().getAttribute("userProfile");

            if(frm.getCourier()==null || frm.getCurrencyCd()==null){
               frm.setCourier(request.getParameter("courierId"));
               frm.setCurrencyCd(request.getParameter("currencyCd"));
            }

            Collection col = ppbd.getAwbsToOacs(ep.getLocationCd(),frm.getCourier(),frm.getCurrencyCd());
            Object[] list = new ArrayList(col).toArray();

            frm.getNewOac().setAwbs(new String[0]);

            if(list == null)
               list = new String[0];

            frm.setAwbs(list);
            frm.setOacList(new ArrayList());
            frm.setCurrencySupported(ep.getSupportedCurrencies());
            frm.setLocationCd(ep.getLocationCd());

            //Set current Date
            String currentDay = new SimpleDateFormat("MM/dd/yyyy",request.getLocale()).format(new Date());
            frm.getNewOac().setOacDateText(currentDay);

        }catch(Exception e){
             ActionErrors ae = new ActionErrors();
             Constants.logger.debug(Utils.stackTraceToString(e));
              ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotShowWindow"));
              saveErrors(request,ae);
        }
       request.setAttribute("AddOACForm",frm);
       return mapping.findForward("ShowWindow");
    }
}
