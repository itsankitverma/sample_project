package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.TasksVO;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminTasksForm;
import com.fedex.lacitd.cashcontrol.common.Utils;

/**
 * Created by Arturo Gonzalez.
 * User: arturog
 * Date: 21-03-2005
 * Time: 12:32:11 PM
 * Description :
 */
public class AdminTasksAction extends Action implements Serializable {

    AdminBizDelegate abd = new AdminBizDelegate();

    public AdminTasksAction()
    {}

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){

        String action=request.getParameter("action");

        if("getTasks".equals(action)){
            return getTasks(mapping, form, request, response);
        }else if("updateTasks".equals(action))
         {        return updateTasks(mapping, form, request, response);}

        return mapping.findForward("ShowWindow");
    }

    private ActionForward updateTasks(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        AdminTasksForm frm = (AdminTasksForm)form;
        ActionErrors ae = new ActionErrors();
        TasksVO tasksVO = new TasksVO();
        try{
             tasksVO.setTasksId(frm.getTasksId());
             tasksVO.setLocationCd(frm.getLocationCd());
             tasksVO.setTaskTypeCd(frm.getTaskTypeCd().intValue());
             tasksVO.setEmailWarning(frm.getEmailWarning());
             tasksVO.setRunSun(frm.getRunSun()!=null?frm.getRunSun().intValue():0);
             tasksVO.setRunSunTime(frm.getRunSunTime());
             tasksVO.setRunMon(frm.getRunMon()!=null?frm.getRunMon().intValue():0);
             tasksVO.setRunMonTime(frm.getRunMonTime());
             tasksVO.setRunTue(frm.getRunTue()!=null?frm.getRunTue().intValue():0);
             tasksVO.setRunTueTime(frm.getRunTueTime());
             tasksVO.setRunWed(frm.getRunWed()!=null?frm.getRunWed().intValue():0);
             tasksVO.setRunWedTime(frm.getRunWedTime());
             tasksVO.setRunThu(frm.getRunThu()!=null?frm.getRunThu().intValue():0);
             tasksVO.setRunThuTime(frm.getRunThuTime());
             tasksVO.setRunFri(frm.getRunFri()!=null?frm.getRunFri().intValue():0);
             tasksVO.setRunFriTime(frm.getRunFriTime());
             tasksVO.setRunSat(frm.getRunSat()!=null?frm.getRunSat().intValue():0);
             tasksVO.setRunSatTime(frm.getRunSatTime());

             abd.updateTasks(tasksVO);

             Constants.logger.debug("\n\n Task Id generated is => " + tasksVO.getTasksId());

             frm.setTasksId(tasksVO.getTasksId());

        }catch(Exception e){
           Constants.logger.debug(Utils.stackTraceToString(e));
    	   ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveTask"));
    	   saveErrors(request,ae);
        }
        return mapping.findForward("ShowWindow");
    }


    private ActionForward getTasks(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
        Integer taskIdNbr = new Integer(request.getParameter("taskId"));
        AdminTasksForm  frm = (AdminTasksForm)form;
        ActionErrors ae = new ActionErrors();

        try{
            TasksVO tasksVO = null;

                 if(taskIdNbr.intValue()==0){
                    tasksVO=new TasksVO();
                    frm.setTaskTypeCd(new Integer(request.getParameter("taskType")));
                    frm.setLocationCd(request.getParameter("locCd"));
                    frm.setEmailWarning(Constants.EMAILADDRTASKS);
                 }else{
                        tasksVO = abd.getTasks(taskIdNbr);

                         frm.setTasksId(tasksVO.getTasksId());
                         frm.setLocationCd(tasksVO.getLocationCd());
                         frm.setTaskTypeCd(new Integer(tasksVO.getTaskTypeCd()));
                         frm.setEmailWarning(tasksVO.getEmailWarning());
                         frm.setRunSun(new Integer(tasksVO.getRunSun()));
                         frm.setRunSunTime(tasksVO.getRunSunTime());
                         frm.setRunMon(new Integer(tasksVO.getRunMon()));
                         frm.setRunMonTime(tasksVO.getRunMonTime());
                         frm.setRunTue(new Integer(tasksVO.getRunTue()));
                         frm.setRunTueTime(tasksVO.getRunTueTime());
                         frm.setRunWed(new Integer(tasksVO.getRunWed()));
                         frm.setRunWedTime(tasksVO.getRunWedTime());
                         frm.setRunThu(new Integer(tasksVO.getRunThu()));
                         frm.setRunThuTime(tasksVO.getRunThuTime());
                         frm.setRunFri(new Integer(tasksVO.getRunFri()));
                         frm.setRunFriTime(tasksVO.getRunFriTime());
                         frm.setRunSat(new Integer(tasksVO.getRunSat()));
                         frm.setRunSatTime(tasksVO.getRunSatTime());
                 }
        }catch(Exception e){
             Constants.logger.debug(Utils.stackTraceToString(e));
    	 	 ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetTask"));
    	 	 saveErrors(request,ae);
        }

       request.setAttribute("AdminTasksForm",frm);
       return mapping.findForward("ShowWindow");
    }

}
