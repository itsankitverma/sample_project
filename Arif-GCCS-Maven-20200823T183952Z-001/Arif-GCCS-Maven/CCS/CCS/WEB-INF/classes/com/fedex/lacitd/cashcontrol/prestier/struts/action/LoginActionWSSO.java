package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.FedExEmployee;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.SystemUtilsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CommonOpsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.LoginForm;
import com.fedex.lacitd.cashcontrol.prestier.helper.EmailSender;
import com.fedex.lacitd.cashcontrol.datatier.controller.EmployeeController;
import com.fedex.lacitd.cashcontrol.datatier.controller.CountryController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO;
import com.fedex.lacitd.cashcontrol.common.Utils;

import java.util.*;
import java.io.Serializable;

/**
 * This class is used to manage the requests
 * for login
 * @author  ccardenas
 */

public class LoginActionWSSO extends Action implements java.io.Serializable{

    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done. It has all the code to manage the login of the
     * users
     *
     * @param    Struts action mapping object
     * @param    Struts action form object
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward
     * @exception Exception
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception{

        ActionErrors ae = new ActionErrors();
        HashMap emails = null;
        EmailSender sender=null;
        FedExEmployee fedEmployee = null;
        EmployeeProfile ep = null;

         try{
            int attempts  = 1, loginResult = 0;
            LoginForm logFrm =(LoginForm)form;
            SystemUtilsBizDelegate sysUtils   = new SystemUtilsBizDelegate();
            CommonOpsBizDelegate commonOps    = new CommonOpsBizDelegate();
            AdminBizDelegate adminBizDelegate = new AdminBizDelegate();
            String userIdFromOblix = null;

            //This change is due to WSSO login
            //Getting userId from Oblix session

            // Get LDAP vars from Oblix header variables.
            Enumeration e1 = request.getHeaderNames();
            while (e1.hasMoreElements()) {
                String name = ((String)e1.nextElement()).toUpperCase();

                Enumeration e2 = request.getHeaders(name);
                while (e2.hasMoreElements()) {

                    String value = (String)e2.nextElement();

                    if ("OBLIX_UID".equalsIgnoreCase(name)) {
                        userIdFromOblix = value;
                    }
                } // inner while
            } // outer while

            Constants.logger.debug("User rescued by Oblix:[" + userIdFromOblix + "]");

// WARNING--------------------------------------------------------
//For testing purposes only.Only available in DEV environment for able to bypass WSSO login
            
      
    if("YES".equals(Utils.getProperties("P").getProperty("VALID_USER_DEV"))){
        if(userIdFromOblix==null)
            userIdFromOblix = (String)request.getParameter("FedexId");

        Constants.logger.debug("User used to authenticate:[" + userIdFromOblix + "]");
    }
// END WARNING ---------------------------------------------------

            //Get Results from login process
            //Using userIdFromOblix already authenticated by WSSO
    
            Collection results=sysUtils.login(userIdFromOblix);

            //Check result, if it no has values then user exist in database but must has location and role,
            //then user need to be added by administrator to the user list.
            if(results.size()==0){
               ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.UserMustBeAdded"));
               saveErrors(request,ae);
               return mapping.findForward("Failure");
            }

            Iterator it=results.iterator();
            while(it.hasNext()){
                  loginResult = ((Integer)it.next()).intValue();
                  ep = (EmployeeProfile)it.next();
            }

            //Clean error massage object
            ae.clear();

            //Constants.logger.debug("\n\n**** resultado login **** " + loginResult);

            //Open switch
            switch(loginResult){
                case 1:
                        // Message changed, users not found must be added to the system.
                        //ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.UserNotFound"));
                        ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.UserMustBeAdded"));
                        break;
                case 3:
                        // WARNING NOTE: Even if in new LDAP authentication, users will not be locked.
                        // Should us email managers regarding users still locked.
                        // Those who have got this state before load WSSO CHANGE?
                        emails = new HashMap();

                        //Setting internet email address
                        sender = new EmailSender();
                        sender.setPersonalName(Constants.FROMADDRESS);

                        //Send email to the administrator first if user doesn't have email
                        //Check in ldap
                        try{
                            //Search User Data from fedex ldap storage
                            Collection employees=sysUtils.findUsers(userIdFromOblix);
                            Iterator itFedex = employees.iterator();
                            if(itFedex.hasNext()){
                                fedEmployee = (FedExEmployee)itFedex.next();
                            }
                        } catch(Exception e){e.printStackTrace();}

                        //Send email to the administrator
                        emails = sender.selectEmail(Constants.ADMINROLE_LOCKED,userIdFromOblix, request, null);
                        sender.setEmails(emails);
                        sender.send();

                        //Send email to the user secondly
                        emails = sender.selectEmail(Constants.USERLOCKED, userIdFromOblix, request, null);
                        sender.setEmails(emails);
                        sender.send();


                        ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.UserLocked"));
                        break;
                case 5:
                        // User was set to Inactive due to more than 90 days without login to GCCS
                        Constants.logger.debug("CASE 5:User DISABLED");
                        emails = new HashMap();

                        //Setting internet email address
                        sender = new EmailSender();
                        sender.setPersonalName(Constants.FROMADDRESS);

                        //Send email to the administrator first if user doesn't have email
                        //Check in ldap

                        try{
                            //Search User Data from fedex ldap storage
                            Collection employees=sysUtils.findUsers(userIdFromOblix);
                            Iterator itFedex = employees.iterator();
                            if(itFedex.hasNext()){
                                fedEmployee = (FedExEmployee)itFedex.next();
                            }
                        } catch(Exception e){e.printStackTrace();}


                        //Send email to the administrator
                        emails = sender.selectEmail(Constants.ADMINROLE,userIdFromOblix, request, null);
                        sender.setEmails(emails);
                        //Constants.logger.debug("CASE 5:Sending email to administrator:["+emails+"]");
                        Constants.logger.debug("CASE 5:Sending email to administrator:["+"]");
                        sender.send();

                        //Send email to the user secondly
                        emails = sender.selectEmail(Constants.USERDISABLED, userIdFromOblix, request, null);
                        sender.setEmails(emails);
                        //Constants.logger.debug("CASE 5:Sending email to user:["+emails+"]");
                        Constants.logger.debug("CASE 5:Sending email to user:["+"]");
                        sender.send();

                        ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.UserDisabled"));
                        break;
            }//close switch

            TreeSet ts=new TreeSet(new LoginActionWSSO.LocationComparator());

            if(loginResult < 1){
               ts.addAll(ep.getLocations());
               ts.addAll(adminBizDelegate.getLocationsForAdminCountryRole(ep.getEmployeeId(),Constants.COUNTRYADMIN));
               ep.setLocations(ts);
               request.getSession().setAttribute("userProfile",ep);
               saveErrors(request,ae);

               if(ep.getLocations().size()>1){
                  return mapping.findForward("selectLocation");
               }else{
                     //Get Comments from data base and put it into the session

                       try{
                               String checkDecJS=sysUtils.getCheckDecodeJS(ep.getCountryCd());
                               if(checkDecJS==null || "".equals(checkDecJS)) checkDecJS="function parseDocNbr(obj){}";
                               request.getSession().setAttribute("checkDecodeJS",checkDecJS);


                               if(ep.getCountryCd() != null)
                               {
                                  request.getSession().setAttribute("countryBanks",new CountryController().getBanks(ep.getCountryCd()));
                                  Collection comments = commonOps.getComments(ep.getCountryCd());
                                  request.getSession().setAttribute("comments",comments);
                               }
                               else
                               {
                                   request.getSession().setAttribute("countryBanks", new ArrayList());
                                   request.getSession().setAttribute("comments", new ArrayList());
                               }

                       }catch(Exception e)
                        {Constants.logger.debug(Utils.stackTraceToString(e));}

                     return mapping.findForward("Success");
               }
            }else{
                saveErrors(request,ae);
                Constants.logger.debug("Errors :["+ae+"]");
                return mapping.findForward("Failure");
            }
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.LoginError"));
            saveErrors(request,ae);
            return mapping.findForward("Failure");
        }
    }

    /**
     * This class is used to manage to compare
     * LocationVO objects.
     * @author  ccardenas
     */
    private static class LocationComparator implements Comparator, Serializable {
           public int compare(Object obj1, Object obj2) {
               try{
                    LocationVO lvo1=(LocationVO)obj1;
                    LocationVO lvo2=(LocationVO)obj2;

                    return lvo1.getLocationCd().compareTo(lvo2.getLocationCd());

               }catch(Exception pe){
                    Constants.logger.debug(Utils.stackTraceToString(pe));
                    return -1;
               }
           }
    }
}
