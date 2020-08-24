/**
 * AdminUserListAction.java
 *
 * Created on April 17, 2003, 4:54 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.SystemUtilsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.exception.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import java.io.Serializable;
import java.util.*;
import javax.servlet.http.*;

/**
 *
 * @author  Arturo Gonzalez
 */
public class AdminUserListAction extends Action implements Serializable{

    AdminBizDelegate  abd       = new AdminBizDelegate();
    ActionErrors      ae        = new ActionErrors();
    LocationToCompare locComp	= new LocationToCompare();
    RoleToCompare 	  roleComp  = new RoleToCompare();

    /** Creates a new instance of AdminUserListAction */
    public AdminUserListAction() {
    }
    
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
          Collection countries  = null;
          ArrayList  profiles   = null;
          String     country    = null;
          String     userId     = null;
          String     locationCd = null;
          String     action     = null;
          Integer    roleId     = null;
          
          AdminUserListForm frm = (AdminUserListForm)form;
          //Clear Errors
          ae.clear();
         
          if(frm==null) frm=new AdminUserListForm();
          
            
             userId     = request.getParameter("userId");
             locationCd = request.getParameter("locationCd");
             country    = request.getParameter("countrySelected");
             roleId     = null;
            
             if(country==null || country.length()==0)
                country = frm.getCountry();
             
            action = request.getParameter("accion");

          //Here is checks the Session to know if there is an userProfile to follow the workflow
          //If there is not an user Profile return to logout page
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            if(ep==null) return mapping.findForward("logout");

            if("enterEmployee".equals(action))
            {
                request.setAttribute("AdminUserListForm", frm);
                request.setAttribute("countrySelected", country); 
                return mapping.findForward("EnterEmployee");
            }else if("showWindowsOnly".equals(action))
            {
                try{
                    if(request.getSession().getAttribute("countries") == null )
                    {	if(ep.isAdmin() || ep.isFinController()){
                           countries = abd.getAllCountry();
                    	}else {
                            if(ep.isCountryAdmin()){
                            	System.out.println("DerekA DerekA DerekA: "+ep.getEmployeeId());
                                countries = abd.getCountriesForAdminCountryRole(ep.getEmployeeId(),Constants.COUNTRYADMIN);
                            }
                        }

                       int large = 0;
                       if(countries.size()>0)
                       {  
                    	   ArrayList<CountryVO> countryList = (ArrayList<CountryVO>)countries;
                    	   //countries=null; //remove the collection and free the memory, garbage collector will collect it
                          //Iterator<CountryVO> itCont = countries.iterator();
                          
                          for (int i = 0; i < countryList.size(); i++) {
                        	  CountryVO con = countryList.get(i);
                        	  if(con.getCountryNm()!=null)
                              {   large = con.getCountryNm().length();
                                 if(large>14)
                                    con.setCountryNm(con.getCountryNm().substring(0, 13));
                              }else
                                  con.setCountryNm("");

                              CountryToCompare comp = new CountryToCompare();
                              Collections.sort((ArrayList)countries, comp);
                            }
                          /*
                          while(itCont.hasNext())
                          { CountryVO con=(CountryVO)itCont.next();
                            if(con.getCountryNm()!=null)
                            {   large = con.getCountryNm().length();
                               if(large>14)
                                  con.setCountryNm(con.getCountryNm().substring(0, 13));
                            }else
                                con.setCountryNm("");

                            CountryToCompare comp = new CountryToCompare();
                            Collections.sort((ArrayList)countries, comp);
                          }
                          */
                          
                          
                          
                       }
                       request.getSession().setAttribute("countries", countries);
                    }
                }catch(Exception e)                
                 {
                	e.printStackTrace();
                	
                	Constants.logger.debug(Utils.stackTraceToString(e));
                  ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
                  saveErrors(request,ae);
                 }
            }else if("addUser".equals(action) || "seeUser".equals(action))//Call to a new window to add or update a user
            {
                 frm = checkEmployee(request, country);

                 if("addUser".equals(action) && frm.getExtlCustFlg()==1){
                     frm.setExtlCustFlg(0); //Since 3.4 External users are not allowed
                     return mapping.findForward("EnterEmployee");
                 }
                
                 //Gets data from database to show data of the employee
                 if("seeUser".equals(request.getParameter("accion")))
                 {   ae.clear();
                     frm.setReviewLocationRole(false);
                     frm.setReviewData(true);
                 }
                         
                 getAllRoles(request);
                 request.setAttribute("locations",getLocationsToShow(country,request,userId));
                 request.setAttribute("locationSelected", new ArrayList());
                 request.setAttribute("countrySelected", country);
                 request.setAttribute("AdminUserListForm", frm);
                 frm.setCountry(country);
                 return mapping.findForward("NewUpdateUser");

            }else if("addLocationRole".equals(request.getParameter("accion")))
            {
                frm = checkEmployee(request, country);
                //Just show the locations and role have not been entered yet
                
                getAllRoles(request);
                frm.setReviewLocationRole(true);
                request.setAttribute("locations",getLocationsToShow(country,request,userId));
                request.setAttribute("locationSelected", new ArrayList());
                request.setAttribute("AdminUserListForm", frm);
                request.setAttribute("countrySelected", country);
                return mapping.findForward("NewLocationRole");
            }else if("deleteUser".equals(action))
            {   deleteUser(userId, request, country);
            }else if("deleteLocation".equals(action))
            {   deleteLocation(frm.getUserId(),frm.getLocationAlreadySelected(),request);
            }else if("deleteRole".equals(action))
            {   deleteRole(frm.getUserId(),frm.getLocationCd(), frm.getRoleSelected(), request);
            }else if("revokeEmployee".equals(action))
            {	List employeeToRevokeList = Arrays.asList(frm.getRevokeEmployee());
                revokeEmployee(employeeToRevokeList,ep.getEmployeeId(), request);
            }    
            
            if(!("showWindowsOnly".equals(action)))
                  profiles = (ArrayList)showProfiles(country, abd, request);
            
            //Set Current Country
            frm.setCountry(country);
            //Set Collection Profiles
            frm.setProfiles(profiles);
            request.setAttribute("AdminUserListForm",frm);
            return mapping.findForward("Success");
    }
    
    private Collection showProfiles(String country, AdminBizDelegate abd, HttpServletRequest request)
    {    Collection profiles  = null;

         String lastCountry = null;

         try{
             EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
             if(ep.isAdmin() || ep.isCountryAdmin() || ep.isFinController()){
                    profiles  = abd.getUserProfileToAdmin(country,null);
             }else{
                    ArrayList countries=new ArrayList();
                    countries.add(new CountryController().getCountry(ep.getCountryCd()));
                    request.getSession().setAttribute("countries",countries);
                    profiles  = abd.getUserProfileToAdmin(null,ep.getLocationCd());
             }

             lastCountry = (String)request.getSession().getAttribute("lastcountry");

             if(lastCountry == null) lastCountry = "";
             
             //Constants.logger.debug("lastCountry: " + lastCountry);
             //Constants.logger.debug("country: " + country);

             if(country !=  null && !lastCountry.equals( country))
             {
                LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "AdminUserListAction showProfiles()", country, "", true);
                request.getSession().setAttribute("lastcountry", country);
             }

         }catch(Exception e)
          {
        	 
        	 e.printStackTrace();
        	 
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);

            if(lastCountry != null && !lastCountry.equals( country))
            {
               LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_READ, "AdminUserListAction showProfiles()", country, "", false);
            }
          }
       return profiles;
    }
    
    public Collection getLocationsByCountry(String country, HttpServletRequest request)
    {   
         ArrayList locationsByCountry=new ArrayList();

         try{
            locationsByCountry = (ArrayList)abd.getLocationsByCountry(country);
            Collections.sort(locationsByCountry,locComp);
            request.setAttribute("locations", locationsByCountry);
        }catch(BizDelegateException bde)
         { 
        	bde.printStackTrace();
        	
        	Constants.logger.debug(Utils.stackTraceToString(bde));
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetLocationsFromDB"));
            saveErrors(request,ae);
         }
         return locationsByCountry;
    }
    
    public Collection getAllRoles(HttpServletRequest request)
    {    ArrayList roles = new ArrayList();
    	
         try{
             EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
             roles=(ArrayList)abd.getAllRoles();

            //Get the role administrator if user is not admin or country admin
              Iterator rolIt=roles.iterator();
              while(rolIt.hasNext()){
                  RoleVO role = (RoleVO)rolIt.next();
                  if(ep.isCountryAdmin() && (Constants.ADMINROLE.equals(role.getRoleId())|| Constants.COUNTRYADMIN.equals(role.getRoleId())))
                  {  rolIt.remove();}
                  if((!ep.isCountryAdmin() && !ep.isAdmin() && !ep.isFinController()) && (Constants.ADMINROLE.equals(role.getRoleId())|| Constants.COUNTRYADMIN.equals(role.getRoleId())|| Constants.FINCONTROLLER.equals(role.getRoleId())))
                  {  rolIt.remove();}
                  // For Ops Manager - Role Added - Kapil 
                  if(ep.getEmployeeRole().containsKey("Operation Manager") && Constants.OPSMANAGERROLE.equals(role.getRoleId()) ){
                	  rolIt.remove(); 
                  }
                  
                  if(ep.isFinController()){
                	  if(!Constants.OPSCONTROLLERROLE.equals(role.getRoleId())){
                		  rolIt.remove();
                	  }
                  }
                	  
              }
              
            Collections.sort(roles,roleComp);  	
            request.setAttribute("roles", roles);
        }catch(BizDelegateException bde)
         {  
        	bde.printStackTrace();
        	
        	Constants.logger.debug(Utils.stackTraceToString(bde));
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetRolesFromDB"));
            saveErrors(request,ae);
         }
         return roles;
    }
    
    private EmployeeVO getEmployee(String userId) throws BizDelegateException
    {   EmployeeVO employee = null;
        
        try{
             employee = abd.getEmployee(userId);
        }catch(BizDelegateException bde)
         {     throw bde;               }
        return employee;           
    }//Close getEmployee method
    
    
    private AdminUserListForm checkEmployee(HttpServletRequest request, String country)
    {   SystemUtilsBizDelegate subd = new SystemUtilsBizDelegate(); 
        AdminUserListForm frm       = new AdminUserListForm();
        EmployeeVO employee         = null;
        String userId               = null;
        
        try{
            userId   = request.getParameter("userId");
            //First system try to get the employee object from CashControl Database
//           Constants.logger.debug("\n *** primer intento de busqueda de employee *** : " + userId);
            employee = getEmployee(userId);

        }catch(BizDelegateException bde)
         { 
            /***** If employee is not found in CashControl Database then ask to the fedex ldap server *****/
             try{
//               Constants.logger.debug("\n *** segundo intento de busqueda de employee ***");
                 employee = subd.findFedExEmployee(userId);
                 //If employee is null then the user is absolutly new
//                 Constants.logger.debug("\n *** Employee ***" + employee);
                   if(employee == null)
                   {  ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetUser"));
                      saveErrors(request,ae);
                      frm.setExtlCustFlg(1);
                   }
                       
             }catch(BizDelegateException bdeLdap){
            	 bdeLdap.printStackTrace();
 //                Constants.logger.debug("\n *** definitivamente no existe el employee ***");
                 Constants.logger.debug(Utils.stackTraceToString(bdeLdap));
                 ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
                 saveErrors(request,ae);
               //Set employee object as null to ensure that employee was not found and display correct information
                 employee=null;
             }
             frm.setUserId(userId);
             frm.setReviewData(true);
         }
        
         //If employee object is not null try to get locations by employee   
         if(employee != null){
          //Put employee values to the form
            frm.setUserId(employee.getEmployeeId());
            frm.setUserName(employee.getEmployeeNm());
            frm.setEmail(employee.getEmail());
            frm.setPageDetailDefault(employee.getDefaultPage());
            frm.setExtlCustFlg(employee.getExtlCustFlg());
            frm.setDisabledFlg(employee.getEmpStatusCd()==3);//sets true or false
            
            ArrayList locations = new ArrayList(); 
            try{
                //Get Locations as employee profile id. to check if is associated to the current country.
                locations = (ArrayList)abd.getLocationsByEmployee(country,userId);
            }catch(BizDelegateException bdeLocs)
                {
            	bdeLocs.printStackTrace();
            	
            	ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetLocationsFromDB"));
                 saveErrors(request,ae);
                }
            
            if(locations.size()>0)
            {  ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.UserHasLocationRoleDefault"));
               saveErrors(request,ae);
               frm.setReviewLocationRole(false);
               frm.setReviewData(false);  
               return frm;
            }else
                {frm.setReviewData(false);}
         }
       
       //Always get locations and roles information to display 
          //  getLocationsByCountry(country, request);
          //  getAllRoles(request);
            
       frm.setReviewLocationRole(true);
       return frm;
    }//Close checkEmployee method

    //Used to select the locations already selected for the user
    public Collection getLocationsToShow(String country, HttpServletRequest request, String userId)
    {   ArrayList allLocations        = new ArrayList();
        ArrayList profilesByEmployee  = new ArrayList();
        ArrayList locationFreeForUser = new ArrayList();
        
        try{
             
             EmployeeProfile ep = (EmployeeProfile)request.getSession().getAttribute("userProfile");
             if(ep.isCountryAdmin()){
                allLocations  = (ArrayList)abd.getLocationsForAdminCountryRole(ep.getEmployeeId(), Constants.COUNTRYADMIN);
             }else{
                 if(ep.isAdmin() || ep.isFinController()){
                    allLocations = (ArrayList)abd.getLocationsByCountry(country);
                 }else{
                    allLocations=new ArrayList();
                    allLocations.add(new LocationController().getLocation(ep.getLocationCd()));
                 }
             }

             profilesByEmployee = (ArrayList)abd.getLocationsByEmployee(country, userId);
             LocationVO loc     = null;;
             ep = null;
             boolean isHere;   
             for(int i=0; i<allLocations.size();i++)
             { isHere=false; 
               loc = new LocationVO();
               loc = (LocationVO)allLocations.get(i);
               for(int j=0;j<profilesByEmployee.size();j++)
               { ep = new EmployeeProfile();
                 ep = (EmployeeProfile)profilesByEmployee.get(j);
                 if(loc.getLocationCd().equals(ep.getLocationCd()))
                 {    isHere=true; }     
               }
                
               if(!isHere)
               {  locationFreeForUser.add(loc);}   
             }
             
        }catch(Exception bde)
         { 
        	bde.printStackTrace();
        	
        	Constants.logger.debug(Utils.stackTraceToString(bde));
           ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetUser"));
           saveErrors(request,ae);
         }
        
        //Order the Collection
        Collections.sort(locationFreeForUser,new LocationToCompare());
        
        return locationFreeForUser;
    }
    
    private void deleteRole(String userId, String locationCd, Integer[] roleSelected, HttpServletRequest request)
    {
        Integer roleId=null;

        try{
            List roles=Arrays.asList(roleSelected);
            Iterator rolIt = roles.iterator();

            while(rolIt.hasNext())
            {
                roleId = (Integer)rolIt.next();

                abd.deleteRole(userId, locationCd, roleId);

                  if(roleId!= null)
                     LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_REVOKE, "AdminUserListAction deleteRole() rol: " + roleId,
                        locationCd, userId, true);
            }


        }catch(BizDelegateException bde)
         {
           Constants.logger.debug(Utils.stackTraceToString(bde));
           ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errros.messages.CouldNotDeleteData"));
           saveErrors(request, ae);

           if(roleId!= null)
               LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_REVOKE, "AdminUserListAction deleteRole() rol: " + roleId, locationCd, userId, false);
         }
    }
    
    private void deleteLocation(String userId, String[] locationSelected, HttpServletRequest request)
    {
        String locationCd = null;

        try{
             List locations=Arrays.asList(locationSelected);
             Iterator locIt = locations.iterator();
             while(locIt.hasNext())
             {     locationCd = (String)locIt.next();
             	   abd.deleteLocation(userId, locationCd);

                   LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "AdminUserListAction deleteLocation() userId: " + userId, locationCd, true);
             }


        }catch(BizDelegateException bde)
         { Constants.logger.debug(Utils.stackTraceToString(bde));
           ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errros.messages.CouldNotDeleteData"));
           saveErrors(request, ae);

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "AdminUserListAction deleteLocation()" , locationCd, false);
         }
    
    }
    
    private void deleteUser(String userId, HttpServletRequest request, String countryCd)
    {
        try{
            abd.deleteUser(userId, countryCd);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "AdminUserListAction deleteUser() cntry: " + countryCd, userId, true);
        }catch(BizDelegateException bde)
         {
           Constants.logger.debug(Utils.stackTraceToString(bde));
           ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errros.messages.CouldNotDeleteData"));
           saveErrors(request, ae);

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_DELETE, "AdminUserListAction deleteUser()", userId, false);
         }
    }
    
    private void revokeEmployee(List employeeToRevokeList, String adminId, HttpServletRequest request)
    {
        try
        {
        	abd.revokeEmployee(employeeToRevokeList,adminId);	

            String employeeId = null;
            if (employeeToRevokeList != null) {
                Iterator empIt = employeeToRevokeList.iterator();
                while (empIt.hasNext()) {
                    employeeId = (String) empIt.next();

                    LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_REVOKE, "AdminUserListAction revokeEmployee()", adminId, employeeId, true);
                }
            }
    	}
        catch(Exception e)
    	{
          Constants.logger.debug(Utils.stackTraceToString(e));
    	  ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errrors.messages.CouldNotRevokeUser"));
    	  saveErrors(request, ae);
            
          LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_REVOKE, "AdminUserListAction revokeEmployee()", adminId, false);
    	}
    }
}//Close AdminUserListAction class

