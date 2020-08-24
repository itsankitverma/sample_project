package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAdminVO;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminTablesManagerForm;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.EntitiesAdminForm;
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
public class EntitiesAdminAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
        if("delete".equals(request.getParameter("action"))){
            return delete(mapping,form,request,response);
        }else{
            if("save".equals(request.getParameter("action"))){
                return save(mapping,form,request,response);
            }else{
                if("newEnt".equals(request.getParameter("action"))){
                    return newEnt(mapping,form,request,response);
                }else{
                    return show(mapping,form,request,response);
                }
            }
        }
    }

    private ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        EntitiesAdminForm eaFrm=null;
        if(form==null){
            eaFrm=new EntitiesAdminForm();
        }else{
            eaFrm=(EntitiesAdminForm)form;
        }

        eaFrm.setLocations("");

        if(!eaFrm.getEntity().getEntCd().equals( ""))
            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "EntitiesAdminAction delete()", eaFrm.getEntity().getEntCd(), true);

        return save(mapping,form,request,response);
    }

    private ActionForward newEnt(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        EntitiesAdminForm eaFrm=null;
        if(form==null){
            eaFrm=new EntitiesAdminForm();
        }else{
            eaFrm=(EntitiesAdminForm)form;
        }

        eaFrm.setLocations("");
        eaFrm.setEntity(new EntityAdminVO());
        eaFrm.setEntities(new ArrayList());

        return show(mapping,form,request,response);
    }

    private ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        EntitiesAdminForm eaFrm=null;
        if(form==null){
            eaFrm=new EntitiesAdminForm();
        }else{
            eaFrm=(EntitiesAdminForm)form;
        }

        try{
            AdminBizDelegate admBiz=new AdminBizDelegate();
            eaFrm.getEntity().setLocations(new ArrayList());

            if(eaFrm.getLocations()!=null){
                String locs=eaFrm.getLocations();
                int idx=-1;
                while((idx=locs.indexOf('\n'))!=-1){
                     eaFrm.getEntity().getLocations().add(locs.substring(0,idx-1).trim());
                     locs=locs.substring(idx+1);
                }

                eaFrm.getEntity().getLocations().add(locs.trim());
            }

            admBiz.setEntity(eaFrm.getEntity());

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "EntitiesAdminAction save()", eaFrm.getEntity().getEntCd(), true);

       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "EntitiesAdminAction save()", eaFrm.getEntity().getEntCd(), false);
       }
        return show(mapping,form,request,response);
    }

    private ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        EntitiesAdminForm eaFrm=null;

        try{
            if(form==null){
                eaFrm=new EntitiesAdminForm();
            }else{
                eaFrm=(EntitiesAdminForm)form;
            }

            AdminBizDelegate admBiz=new AdminBizDelegate();
            eaFrm.setEntities(admBiz.getEntities());

            if(eaFrm.getEntity()!=null && eaFrm.getEntity().getEntCd()!=null && !"".equals(eaFrm.getEntity().getEntCd())){
                eaFrm.setEntity(admBiz.getEntity(eaFrm.getEntity().getEntCd()));
                Iterator iterLocs=eaFrm.getEntity().getLocations().iterator();
                StringBuffer sb=new StringBuffer();
                while(iterLocs.hasNext()){
                    String loc=(String)iterLocs.next();
                    sb.append(loc+"\n");
                }

                eaFrm.setLocations(sb.toString());
            }else{
                eaFrm.setLocations("");
                eaFrm.setEntity(new EntityAdminVO());
            }

            if(eaFrm.getEntity()==null) eaFrm.setEntity(new EntityAdminVO());
            if(eaFrm.getEntities()==null) eaFrm.setEntities(new ArrayList());

            if(eaFrm.getEntity().getEntCd() != null)
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "EntitiesAdminAction show()", eaFrm.getEntity().getEntCd(), true);

            request.setAttribute("EntitiesAdminForm",eaFrm);
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "EntitiesAdminAction show()", eaFrm.getEntity().getEntCd(), false);
       }

       return mapping.findForward("Entities");
    }
}
