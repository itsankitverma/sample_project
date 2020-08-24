/**
 * AdminHandlerAction.java
 *
 * Created on May 7, 2003, 3:36 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;

import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.exception.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK;

import java.io.Serializable;
import java.util.*;
import javax.servlet.http.*;


/**
 * @author Arturo Gonzalez
 */

public class AdminHandlerAction extends Action implements Serializable {
    AdminBizDelegate abd = new AdminBizDelegate();
    ActionErrors ae = new ActionErrors();

    /**
     * Creates a new instance of AdminHandler *
     */
    public AdminHandlerAction() {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        String action = null;
        String userId = request.getParameter("userId");
        String country = request.getParameter("countrySelected");
        String forward = null;
          
        //Clear Errors
        ae.clear();

        AdminUserListForm frm = (AdminUserListForm) form;
        if (frm == null) frm = new AdminUserListForm();

        if (country == null)
            country = frm.getCountry();

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
        if (ep == null) return mapping.findForward("Success");

        action = request.getParameter("accion");

        if ("insertUser".equals(action) || "updateUser".equals(action)) {
            forward = saveUserLocationRole(frm, request, action, ep);

            if (frm.isSendEmail() && !frm.isDisabledFlg()) {
                try {
                    HashMap emails = new HashMap();
                    //Setting internet email address
                    EmailSender sender = new EmailSender();
                    sender.setPersonalName(Constants.FROMADDRESS);
                    //Send email to the administrator first
                    emails = sender.selectEmail(Constants.USERENABLED, userId, request, frm.getPassword1());
                    sender.setEmails(emails);
                    sender.send();
                } catch (Exception e) {
                    Constants.logger.debug(Utils.stackTraceToString(e));
                    ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSendMessage"));
                    saveErrors(request, ae);
                }
            }
        }
        else if ("addLocationRole".equals(action)) {
            forward = addLocationRole(frm, request, ep);
            request.setAttribute("userId", userId);
        }
        else if ("editEmployeeRole".equals(action)) {
            forward = editEmployeeRole(frm,request,ep);
            request.setAttribute("userId", userId);
        }
        else if ("saveEmployeeRole".equals(action)) {
            forward = saveEmployeeRole(frm,request,ep);
            request.setAttribute("userId", userId);
        }

        request.setAttribute("countrySelected", country);
        request.setAttribute("accion", action);
        return mapping.findForward(forward);
    }//Close method execute

    private String saveUserLocationRole(AdminUserListForm frm, HttpServletRequest request, String action, EmployeeProfile ep) {
        //Now before save we'return going to validate data
        String userId, userName, email, pageDetailDefault;
        String[] locationSelected;
        Integer roleDefault;
        String disabledFlag;

        String forward = "";

        userId = frm.getUserId();
        userName = frm.getUserName();
        email = frm.getEmail();
        pageDetailDefault = frm.getPageDetailDefault();
        locationSelected = frm.getLocationAlreadySelected();
        roleDefault = frm.getRoleDefault();
        disabledFlag = frm.isDisabledFlg()?"1":"0";

        //Now we're going to rescue data to form the objects to insert
        try {
            EmployeeVO employee = null;
            if ("insertUser".equals(action)) {
                employee = new EmployeeVO();
            } else {
                employee = new EmployeeController().getEmployee(userId);
            }
            //Put employee data into the value object
            employee.setEmployeeId(userId);
            employee.setEmployeeNm(userName);
            employee.setEmail(email);
            employee.setDefaultPage(pageDetailDefault);
            employee.setExtlCustFlg(frm.getExtlCustFlg());

            if(frm.isDisabledFlg())
                employee.setEmpStatusCd(Constants.DISABLEDUSER);
            else {
                employee.setEmpStatusCd(Constants.ACTIVEUSER);
                employee.setPwdDate(new Date());
            }

            employee.setEmpRvoDt(null);

            ae.clear();

            if ("insertUser".equals(action)) {
                //Now method iterate on the locationDefault Array to insert data
                //of locations and role to the new employee
                //Constants.logger.debug("\n **** antes del for, nro locations selected: " + locationDefault.length);

                //Check if locations belong to the country assignated to the country administrator
                List noBelongLocation = new ArrayList();
                if (ep.isCountryAdmin())
                    noBelongLocation = checkLocationCountry(frm, request);
                if (noBelongLocation.size() > 0) {
                    ae.clear();
                    ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.LocationsOfThisCountryOnly"));
                    saveErrors(request, ae);
                    forward = "SavedUser";
                    return forward;
                } else if(checkAdmin(frm.getUserId()) && (Constants.COUNTRYADMIN.equals(frm.getRoleDefault()))){
                        //Check, employee with admin role cannot be country admin, and vice versa
                          ae.clear();
                          ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.UserCannotBeCountryAdmin"));
                          saveErrors(request, ae);
                          forward = "SavedUser";
                          return forward;
                    } else{
                            for (int i = 0; i < locationSelected.length; i++) {
                                EmpXLocationXRoleVO elr = new EmpXLocationXRoleVO();
                                elr.setEmployeeId(userId);
                                elr.setLocationCd(locationSelected[i]);
                                elr.setRoleId(roleDefault);
                                //Call a method gto insert employee, location, role data
                                //Constants.logger.debug("\n antes de llamar a addUserLocationRole con location : " + locationDefault[i]);
                                abd.addUserLocationRole(employee, elr);

                                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "AdminHandlerAction saveUserLocationRole() loc_cd: " + locationSelected[i] + " rol: " + roleDefault,
                                        userId, true);
                            }
                }
            } else if ("updateUser".equals(action)) {   //Call a method to update employee data
                abd.updateUser(employee);
            }
            ae.clear();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.SavedUser"));
            saveErrors(request, ae);
            forward = "Success";
        } catch (Exception bde) {
            Constants.logger.debug(Utils.stackTraceToString(bde));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveUser"));
            saveErrors(request, ae);
            forward = "SavedUser";

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "AdminHandlerAction saveUserLocationRole()", userId, "", false);
        }

        return forward;
    }


    private String addLocationRole(AdminUserListForm frm, HttpServletRequest request, EmployeeProfile ep) {
        String forward = "";

        try {
            //Check if locations belong to the country assignated to the country administrator
            List noBelongLocation = new ArrayList();
            if (ep.isCountryAdmin())
                noBelongLocation = checkLocationCountry(frm, request);

            if (noBelongLocation.size() > 0) {
                ae.clear();
                ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.LocationsOfThisCountryOnly"));
                forward = "SavedUser";
            }else if(checkAdmin(frm.getUserId()) && (Constants.COUNTRYADMIN.equals(frm.getRoleDefault()))){
                  //Check, employee with admin role cannot be country admin, and vice versa
                    ae.clear();
                    ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.UserCannotBeCountryAdmin"));
                    forward = "SavedUser";
                  }else{
                        String locations[] = frm.getLocationAlreadySelected();
                        //Now we iterate on locations array to get each location assigned to the employee by current role
                        for (int i = 0; i < locations.length; i++) {
                             EmpXLocationXRoleVO empLocRole =
                                                 new EmpXLocationXRoleVO(frm.getRoleDefault(),
                                                                         locations[i],
                                                                         frm.getUserId());
                             abd.addLocationRole(empLocRole);

                             LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "AdminHandlerAction addLocationRole() loc_cd: " + locations[i] + " rol: " + frm.getRoleDefault(),
                                     frm.getUserId(), true);
                        }

                    ae.clear();
                    ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("app.messages.SavedUser"));
                    forward = "Success";
                }

            saveErrors(request, ae);

        } catch (BizDelegateException bde) {
            Constants.logger.debug(Utils.stackTraceToString(bde));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveLocationRole"));
            saveErrors(request, ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_INSERT, "AdminHandlerAction addLocationRole()", frm.getUserId(), false);

            forward = "SavedLocationRole";
        }

        return forward;
    }


    private List checkLocationCountry(AdminUserListForm frm, HttpServletRequest request) {
        boolean belong = false;

        List locsSelected = Arrays.asList(frm.getLocationAlreadySelected());
        List noBelong = new ArrayList();

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

        try {
            List allLocations = (List) abd.getLocationsForAdminCountryRole(ep.getEmployeeId(), Constants.COUNTRYADMIN);
            LocationVO location = null;
            String locToProbe = null;
            Iterator locIt = locsSelected.iterator();
            while (locIt.hasNext()) {
                locToProbe = (String) locIt.next();

                for (int i = 0; i < allLocations.size(); i++) {
                    location = (LocationVO) allLocations.get(i);

                    if (locToProbe.equals(location.getLocationCd())) {
                        belong = true;
                        break;
                    }
                }

                if (!belong) {
                    noBelong.add(locToProbe);
                    break;
                }
                belong = false;
            }
        } catch (BizDelegateException bde) {
            Constants.logger.debug(Utils.stackTraceToString(bde));
        }

        return noBelong;
    }

    private String editEmployeeRole(AdminUserListForm frm, HttpServletRequest request, EmployeeProfile ep) {
        String forward = "EditEmployeeRole";
        try {
            String userId = request.getParameter("userId");
            String locationCd = request.getParameter("locationCd");
            Integer roleId = new Integer(request.getParameter("roleDefault"));
            RoleController roleController = new RoleController();
            EmployeeController employeeController = new EmployeeController();
            EmpXLocationXRoleController empXLocationXRoleController = new EmpXLocationXRoleController();
            EmployeeVO employeeVO = employeeController.getEmployee(userId);
            Object[] rolesSelected = empXLocationXRoleController.getEmpXLocationXRoleByEmployeeAndLocation(employeeVO.getEmployeeId(),locationCd).toArray();
            Collection roles = new ArrayList();
            if(ep.isAdmin()) {
                Collection allRoles = roleController.getAllRoles();
                Iterator it = allRoles.iterator();
                while(it.hasNext()) {
                    RoleVO roleVO = (RoleVO) it.next();
                    boolean included = false;
                    for(int i = 0;i  < rolesSelected.length; i++) {
                        if(((EmpXLocationXRoleVO)rolesSelected[i]).getRoleId().equals(roleVO.getRoleId()))
                            included = true;
                    }
                    if(roleVO.getRoleId().equals(roleId))
                        included=false;
                    if(!included)
                        roles.add(roleVO);
                }
            }
            else if (ep.isCountryAdmin()){
                Collection allRoles = roleController.getAllRoles();
                Iterator it = allRoles.iterator();
                while(it.hasNext()) {
                    RoleVO roleVO = (RoleVO) it.next();
                    if(!Constants.COUNTRYADMIN.equals(roleVO.getRoleId()) && !Constants.ADMINROLE.equals(roleVO.getRoleId())) {
                        boolean included = false;
                        for(int i = 0;i  < rolesSelected.length; i++) {
                            if(((EmpXLocationXRoleVO)rolesSelected[i]).getRoleId().equals(roleVO.getRoleId()))
                                included = true;
                        }
                        if(roleVO.getRoleId().equals(roleId))
                            included=false;
                        if(!included)
                            roles.add(roleVO);
                    }
                }
            }else{
                Collection allRoles = roleController.getAllRoles();
                Iterator it = allRoles.iterator();
                while(it.hasNext()) {
                    RoleVO roleVO = (RoleVO) it.next();

                    if((!ep.isCountryAdmin() && !ep.isAdmin() && !ep.isFinController()) && (Constants.ADMINROLE.equals(roleVO.getRoleId())|| Constants.COUNTRYADMIN.equals(roleVO.getRoleId())|| Constants.FINCONTROLLER.equals(roleVO.getRoleId())))
                    {  it.remove();
                    }else{
                        if(!Constants.COUNTRYADMIN.equals(roleVO.getRoleId()) && !Constants.ADMINROLE.equals(roleVO.getRoleId())) {
                            boolean included = false;
                            for(int i = 0;i  < rolesSelected.length; i++) {
                                if(((EmpXLocationXRoleVO)rolesSelected[i]).getRoleId().equals(roleVO.getRoleId()))
                                    included = true;
                            }
                            if(roleVO.getRoleId().equals(roleId))
                                included=false;
                            if(!included)
                                roles.add(roleVO);
                    }
                    }
                }




            }

            Collections.sort((List) roles,new RoleToCompare());
            request.setAttribute("roles",roles);
            frm.setUserName(employeeVO.getEmployeeNm());
            frm.setUserId(userId);
            frm.setLocationCd(locationCd);
            frm.setRoleDefault(roleId);
            frm.setRoleDefaultBefore(roleId);
        }
        catch (BusinessDelegateException e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
        return forward;
    }

    private String saveEmployeeRole(AdminUserListForm frm, HttpServletRequest request, EmployeeProfile ep) {
        String forward = "Success";
        try {
            String userId = request.getParameter("userId");
            String locationCd = request.getParameter("locationCd");
            Integer roleId = new Integer(request.getParameter("roleDefault"));
            Integer roleIdBefore = new Integer(request.getParameter("roleDefaultBefore"));
            EmployeeController employeeController = new EmployeeController();
            EmployeeVO employeeVO = employeeController.getEmployee(userId);
            EmpXLocationXRoleVO empXLocationXRoleVO = new EmpXLocationXRoleVO(roleId,locationCd,employeeVO.getEmployeeId());
            EmpXLocationXRoleController empXLocationXRoleController = new EmpXLocationXRoleController();
            empXLocationXRoleController.removeEmpXLocationXRole(new EmpXLocationXRolePK(roleIdBefore,locationCd,employeeVO.getEmployeeId()));
            empXLocationXRoleController.setEmpXLocationXRole(empXLocationXRoleVO);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminHandlerAction saveEmployeeRole()", userId + "-" + roleId, true);            
        }
        catch (BusinessDelegateException e) {
            Constants.logger.debug(Utils.stackTraceToString(e));

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminHandlerAction saveEmployeeRole()", "", true);
        }
        //return editEmployeeRole(frm,request,ep);
        return forward;
    }

    /**
     * This method check if a user is Administrator into GCCS
     * @param  userId
     * @return boolean
     */
    private boolean checkAdmin(String userId)
    {
        EmpXLocationXRoleController elrCtrl=new EmpXLocationXRoleController();
        boolean isAdmin=false;

        try{
            Collection admins = elrCtrl.getEmpXLocationXRoleByRoleId(Constants.ADMINROLE);
            Iterator adminIt = admins.iterator();
            EmpXLocationXRoleVO emp=null;
            while(adminIt.hasNext())
            {   emp = new EmpXLocationXRoleVO();
                emp = (EmpXLocationXRoleVO)adminIt.next();

                if(userId.equals(emp.getEmployeeId()))
                {  isAdmin=true; break;              }
            }
        }catch(Exception e)
        { Constants.logger.debug(Utils.stackTraceToString(e));}

        return isAdmin;
    }

}//Close AdminHandlerAction class