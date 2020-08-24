package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAdminVO;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAcctAdminVO;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminTablesManagerForm;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.EntitiesAdminForm;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.EntitiesAcctAdminForm;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.common.monitoring.Monitoring;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.StringReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: paravena
 * Date: 23-mar-2005
 * Time: 11:58:11
 * To change this template use File | Settings | File Templates.
 */
public class EntitiesAcctAdminAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
        if("delete".equals(request.getParameter("action"))){
            return delete(mapping,form,request,response);
        }else{
            if("save".equals(request.getParameter("action"))){
                return save(mapping,form,request,response);
            }else{
                 return show(mapping,form,request,response);
            }
        }
    }

    private ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        EntitiesAcctAdminForm eaFrm=null;
        if(form==null){
            eaFrm=new EntitiesAcctAdminForm();
        }else{
            eaFrm=(EntitiesAcctAdminForm)form;
        }

        try{
            AdminBizDelegate admBiz=new AdminBizDelegate();

            admBiz.removeEntAcct(eaFrm.getEntityAcct());

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "EntitiesAcctAdminAction delete()", "" + eaFrm.getEntityAcct().getBankAccCd(), true);

       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "EntitiesAcctAdminAction delete()", "" + eaFrm.getEntityAcct().getBankAccCd(), false);
       }
        return show(mapping,form,request,response);
    }

    private ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        EntitiesAcctAdminForm eaFrm=null;
        if(form==null){
            eaFrm=new EntitiesAcctAdminForm();
        }else{
            eaFrm=(EntitiesAcctAdminForm)form;
        }

        try{
            AdminBizDelegate admBiz=new AdminBizDelegate();

            admBiz.setEntAcct(eaFrm.getEntityAcct());

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "EntitiesAcctAdminAction save()", "" + eaFrm.getEntityAcct().getEntCd(), true);

       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "EntitiesAcctAdminAction save()", "" + eaFrm.getEntityAcct().getEntCd(), false);
       }
        return show(mapping,form,request,response);
    }

    private ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        EntitiesAcctAdminForm eaFrm=null;

        try{
            if(form==null){
                eaFrm=new EntitiesAcctAdminForm();
            }else{
                eaFrm=(EntitiesAcctAdminForm)form;
            }

            AdminBizDelegate admBiz=new AdminBizDelegate();
            eaFrm.setEntities(admBiz.getEntities());

            if(eaFrm.getEntityAcct()!=null && eaFrm.getEntityAcct().getEntCd()!=null && !"".equals(eaFrm.getEntityAcct().getEntCd())){
                EntityAcctAdminVO eaaVO=admBiz.getEntAcct(eaFrm.getEntityAcct().getEntCd(),eaFrm.getEntityAcct().getBankAccCd());
                if(eaaVO!=null && eaaVO.getEntCd()!=null && !"".equals(eaaVO.getEntCd())){
                    eaFrm.setEntityAcct(eaaVO);
                }

                eaFrm.setAccounts(admBiz.getEntCntryAccounts(eaFrm.getEntityAcct().getEntCd()));
            }else{
                eaFrm.setEntityAcct(new EntityAcctAdminVO());
            }

            if(eaFrm.getEntityAcct()==null) eaFrm.setEntityAcct(new EntityAcctAdminVO());
            if(eaFrm.getEntities()==null) eaFrm.setEntities(new ArrayList());
            if(eaFrm.getAccounts()==null) eaFrm.setAccounts(new ArrayList());

            if(eaFrm.getEntityAcct().getBankAccCd() != 0)
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "EntitiesAcctAdminAction show()", "" + eaFrm.getEntityAcct().getBankAccCd(), true);

            request.setAttribute("EntitiesAcctAdminForm",eaFrm);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "EntitiesAcctAdminAction show()", "" + eaFrm.getEntityAcct().getBankAccCd(), false);
       }
            return mapping.findForward("EntitiesAcct");
    }
}
