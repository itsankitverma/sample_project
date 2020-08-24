/**
 * AdminChangePasswordAction.java
 * Created on June 18, 2003
 * Arturo Gonzalez
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.*;

import java.io.Serializable;
import java.util.*;
import javax.servlet.http.*;

import org.apache.oro.text.perl.Perl5Util;

//To use Regular expressions

/**
 * @author Arturo Gonzalez
 */

public class AdminForgotPasswordAction extends Action implements Serializable {
    AdminBizDelegate abd = new AdminBizDelegate();
    SystemUtilsBizDelegate sysUtils = new SystemUtilsBizDelegate();
    ActionErrors ae = new ActionErrors();

    /**
     * Creates a new instance of AdminHandler *
     */
    public AdminForgotPasswordAction() {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        AdminUserListForm frm = (AdminUserListForm) form;

        if (frm == null) frm = new AdminUserListForm();

        String action = request.getParameter("action");


        if (action == null || action.length() == 0) {
            action = (String) request.getAttribute("action");
        }

        //Continue processing
        frm.setReviewData(true);
        frm.setReviewLocationRole(false);

        if ("forgotPassword".equals(action)) {   //Need to recover email
            //frm.setEmail(getEmployeeEmail(frm.getUserId()));

        } else if ("recoverPassword".equals(action)) {
            recoverAndSendPassword(frm, request);
        }

        request.setAttribute("AdminUserListForm", frm);

        return mapping.findForward("ForgotPassword");
    }//Close method execute


    private void recoverAndSendPassword(AdminUserListForm frm, HttpServletRequest request) { //Clear Errors
        ae.clear();

        String password = null;

        try {
            password = Utils.generatePassword(8);
        } catch (Exception e) {
            Constants.logger.debug("\n Cannot generate password because : " + Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.GeneratingPassword"));
            saveErrors(request, ae);
            return;
        }
        String email = null;
        String ccEmail = null;
        String userName = null;
        EmployeeVO employee = null;
        Perl5Util perl = new Perl5Util();
        try {
            //Get and update a employee with the new password
            employee = abd.getEmployee(frm.getUserId());
            if (employee.getEmpStatusCd() == Constants.REVOKEDUSER) {
                ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.UserNotFound"));
                saveErrors(request, ae);
                return;
            }
            employee.setPassword(password);
            abd.updateUser(employee);
        } catch (Exception e) {                                                               
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.UserNotFound"));
            saveErrors(request, ae);
            return;
        }	
		
        //The try send email to notify the new password    
        try {
            //Get body client
            String body = Constants.BODYNEWPASSWORD;

            EmailSender sender = new EmailSender();
            HashMap mails = new HashMap();
            
            //Now get email addresses from LDAP first, from DB of CCS second, or third send email as userId@fedex.com and to the administrator.

            FedExEmployee fedEmployee = null;
            try {
                //Search User Data from fedex ldap storage
                Collection employees = sysUtils.findUsers(frm.getUserId());
                Iterator itFedex = employees.iterator();
                if (itFedex.hasNext()) {
                    fedEmployee = (FedExEmployee) itFedex.next();
                }
            } catch (Exception e) {
            }

            if (fedEmployee != null) {
                if (fedEmployee.get(FedExEmployee.MAIL) != null) {
                    email = fedEmployee.get(FedExEmployee.MAIL);
                    userName = fedEmployee.get(FedExEmployee.FIRST_NAME) + " " + fedEmployee.get(FedExEmployee.LAST_NAME);
                }
            }

            //2 But Get email from CCS DB
            if (email == null || email.length() == 0) {
                email = employee.getEmail();
                userName = employee.getEmployeeNm();
            }
	        
            //3 But email continue null, send email to the administrator and to the user as fedexIdnumber@fedex.com
            if (email == null || email.length() == 0) {
                Collection adminEmp = abd.getAdminEmployees(null);
                if (adminEmp != null) {
                    Iterator itEmp = adminEmp.iterator();
                    //Get employee from ldap directory and then get email to concat into "to" variable
                    EmployeeVO emp = null;
                    email = "";
                    while (itEmp.hasNext()) {
                        emp = (EmployeeVO) itEmp.next();
                        if (emp.getEmail() != null) {
                            email = emp.getEmail();
                            break;
                        }
                    }//Close while
                }//Close if adminEmp
                ccEmail = frm.getUserId() + "@fedex.com";
                body = Constants.BODYADMINNEWPASSWORD;
            }

            mails.put("TO:", email);
            mails.put("CC:", ccEmail);
            mails.put("Subject:", Constants.SUBJECTNEWPASSWORD);

            //Put data on body client
            if (perl.match("/fedexId/", body)) {
                body = perl.substitute("s/fedexId/" + frm.getUserId() + "/", body);
            }
            if (perl.match("/employeePassword/", body)) {
                body = perl.substitute("s/employeePassword/" + password + "/", body);
            }

            mails.put("Body:", body);

            sender.setEmails(mails);
            sender.setPersonalName(Constants.FROMADDRESS);
            sender.send();
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSendMessage"));
            saveErrors(request, ae);
        }

        frm.setUserName(userName);
        frm.setEmail(email);
    }
}//Close AdminChangePasswordAction class

