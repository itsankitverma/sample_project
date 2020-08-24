/**
 * AdminChangePasswordAction.java
 * Created on June 18, 2003
 * Artur Gonzalez
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.io.Serializable;
import javax.servlet.http.*;

/**
 * @author  Arturo Gonzalez
 */

public class AdminChangePasswordAction extends Action implements Serializable
{
    AdminBizDelegate  abd   = new AdminBizDelegate();
    ActionErrors ae         = new ActionErrors();
    
    /** Creates a new instance of AdminHandler **/
    public AdminChangePasswordAction() {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
          String action   = null;

          ChangePasswordForm frm = (ChangePasswordForm)form;
          if(frm==null) frm=new ChangePasswordForm();
          
          action = request.getParameter("action");
          if(action == null || action.length()==0)
          {  action = (String)request.getAttribute("action");}
 
          //Continue processing
          EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
          if(ep==null) return mapping.findForward("CloseWindow");

          if("expiredPassword".equals(action) || (request.getParameter("action2")!=null && request.getParameter("action2").length()>0))
          {   request.setAttribute("action","expiredPassword");}
          
          if("changePassword".equals(action) || "expiredPassword".equals(action))
          {	  frm.setUserId(ep.getEmployeeId());
              frm.setUserName(ep.getEmployeeName());
              frm.setCheck(true);
              request.setAttribute("ChangePasswordForm",frm);
              return mapping.findForward("ChangePassword");
          }else if("savePassword".equals(action))
          {   		savePassword(frm, request); }
        
        request.setAttribute("ChangePasswordForm", frm);
        return mapping.findForward("SavedPassword");
    }//Close method execute

    
    private void savePassword(ChangePasswordForm frm, HttpServletRequest request)
    {   
        EmployeeVO employee = new EmployeeVO();
        
        //Clear Errors
          ae.clear();
        //The first try check if the old password is right
        try{
            String oldPassword      = null;
            String oldPasswordCoded = null;
            
            employee    = abd.getEmployee(frm.getUserId());
            oldPassword = frm.getPasswordOld();
            
            //Check now
            oldPasswordCoded = abd.getPasswordCoded(frm.getUserId(), oldPassword);

            if(!(oldPasswordCoded.equals(employee.getPassword())))
            {  ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.OldPasswordInvalid"));
               saveErrors(request, ae);
               return;
            }else
                {employee.setPassword(frm.getPasswordNew());
                 frm.setCheck(true);
                }
            
        }catch(Exception e)
         { Constants.logger.debug(Utils.stackTraceToString(e));
           ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotSaveUser"));
           saveErrors(request, ae);
         }
        
        //This try do an update of the employee
        try{
            abd.updateUser(employee);
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.PasswordChanged"));
            saveErrors(request, ae);
        }catch(Exception e)
         { Constants.logger.debug(Utils.stackTraceToString(e));
           ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotSaveUser"));
           saveErrors(request, ae);
         }  
    }
}//Close AdminChangePasswordAction class

