package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.util.*;

import org.apache.oro.text.perl.Perl5Util;
import com.fedex.lacitd.cashcontrol.prestier.struts.action.*;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;

/**
 * Admin user list screen form class
 * 
 * @author  Arturo Gonzalez
 */

public class AdminUserListForm extends ActionForm implements java.io.Serializable{
    
    /** Holds value of property country. **/
    private AdminUserListAction userListAction = null;
    private String country;
    private String userId;
    private String locationCd;
    private String userName;
    private String password1;
    private String email;
    private boolean reviewLocationRole = false;
    private boolean reviewData         = false;

    
    /** Holds value of property password2. */
    private String password2;
    
    /** Holds value of property locationDefault. */
    private String[] locationDefault;
    
    /** Holds value of property roleDefault. */
    private Integer roleDefault;
    private Integer roleDefaultBefore;

    /** Holds value of property locations. */
    private Collection profiles;
    
    /** Holds value of property locations. */
    private Collection locations;
    
    /** Holds value of property roles. */
    private Collection roles;
    
    /** Holds value of property pageDetailDefault. */
    private java.lang.String pageDetailDefault;
    
    /** Holds value of property sendEmail. */
    private boolean sendEmail;
    
    /** Holds value of property extlCustFlg. */
    private int extlCustFlg;
    
    /** Holds value of property reviewName. */
    private boolean reviewName = true;
    
    /** Holds value of property locationSelected. */
    private Collection locationSelected;
    
    /** Holds value of property locationAlreadySelected. */
    private String[] locationAlreadySelected;
    
    /** Holds value of property otherLocations. */
    private String otherLocations;
    
    /** Holds value of property revokeEmployee. */
    private String[] revokeEmployee;
    
    /** Holds value of property roleSelected. */
    private Integer[] roleSelected;

    /** Holds value of property enabled */
    private boolean disabledFlg;

    
    public AdminUserListForm() {
    }

    public void setReviewLocationRole(boolean reviewLocationRole){
        this.reviewLocationRole = reviewLocationRole;
    }
    
    public boolean getReviewLocationRole(){
        return this.reviewLocationRole;
    }
    
    public void setReviewData(boolean reviewData){
        this.reviewData = reviewData;
    }
    
     public boolean getReviewData(){
        return this.reviewData;
    }
     
    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }
    
    /** Getter for property userId.
     * @return Value of property userId.
     */
    public String getUserId() {
        return this.userId;
    }
    
    /** Setter for property userId.
     * @param userId New value of property userId.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /** Getter for property userName.
     * @return Value of property userName.
     */
    public String getUserName() {
        return this.userName;
    }
    
    /** Setter for property userName.
     * @param userName New value of property userName.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /** Getter for property email.
     * @return Value of property email.
     */
    public String getEmail() {
        return this.email;
    }
    
    /** Setter for property email.
     * @param email New value of property email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /** Getter for property password1.
     * @return Value of property password1.
     */
    public String getPassword1() {
        return this.password1;
    }
    
    /** Setter for property password1.
     * @param password1 New value of property password1.
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    
    /** Getter for property password2.
     * @return Value of property password2.
     */
    public String getPassword2() {
        return this.password2;
    }
    
    /** Setter for property password2.
     * @param password2 New value of property password2.
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    /** Getter for property locationDefault.
     * @return Value of property locationDefault.
     */
    public String[] getLocationDefault() {
        return this.locationDefault;
    }
    
    /** Setter for property locationDefault.
     * @param locationDefault New value of property locationDefault.
     */
    public void setLocationDefault(String[] locationDefault) {
        this.locationDefault = locationDefault;
    }
    
    /** Getter for property roleDefault.
     * @return Value of property roleDefault.
     */
    public Integer getRoleDefault() {
        return this.roleDefault;
    }
    
    /** Setter for property roleDefault.
     * @param roleDefault New value of property roleDefault.
     */
    public void setRoleDefault(Integer roleDefault) {
        this.roleDefault = roleDefault;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {   userListAction      = new AdminUserListAction();
        ActionErrors errors = new ActionErrors();
        
        String  userId, userName, email, password1, password2;
        String [] locationDefault; 
        String[] locationSelected;
        Integer roleDefault;
        
        userId      = getUserId();
        userName    = getUserName();   
        email       = getEmail();
        password1   = getPassword1();
        password2   = getPassword2();
        locationDefault  = getLocationDefault();
        locationAlreadySelected = getLocationAlreadySelected();
        roleDefault      = getRoleDefault();

        if(reviewData)
        {   
            if((password1!=null && !"".equals(password1)) || (password2!=null && !"".equals(password2))){
                  if((password1!=null && !password1.equals(password2)) || (password2!=null && !password2.equals(password1))){
                      errors.add("password",new ActionError("app.messages.NotValidPassword"));
                  }      
                
            }     
            
            if(userId==null || userId.length() == 0)
               errors.add("userId",new ActionError("app.messages.MustEnterFedexId"));
            
            if(!validateNumber(userId))
               errors.add("userId",new ActionError("app_messages.MustEnterOnlyNumbers"));
          
            if(getReviewName())
            {	if(userName==null || userName.length() == 0)
            	   errors.add("userName",new ActionError("app.messages.MustEnterUserName"));
            
            	if(email!=null && email.trim().length() > 0)
            	{
            		if(!validateEmail(email))
            		{errors.add("email",new ActionError("app.messages.EmailInvalid"));}
            	}//close if email
            }//close if review name	
        }    
        
        if(reviewLocationRole)
        {   if(locationAlreadySelected==null || locationAlreadySelected.length==0 ||
               roleDefault==null || roleDefault.intValue() == 0)
            {   errors.add("roleId",new ActionError("app.messages.MustSelectARole"));
                errors.add("locationCd",new ActionError("app.messages.MustSelectALocation"));
            }
            request.setAttribute("locations",userListAction.getLocationsToShow(country,request,userId));
            request.setAttribute("locationSelected", new ArrayList());
            request.setAttribute("roles", userListAction.getAllRoles(request));
        }
        
        if(errors.size()>0)
           request.setAttribute("countrySelected", country);    
       
        return errors;
    }

    /** Getter for property locations.
     * @return Value of property locations.
     */
    public Collection getProfiles() {
        return this.profiles;
    }
    
    /** Setter for property locations.
     * @param profiles New value of property locations.
     */
    public void setProfiles(Collection profiles) {
        this.profiles = profiles;
    }

   /**
    * This method is used to validate if a property value is number or not
    */ 
    private boolean validateNumber(String n)
    {   Perl5Util perl = new Perl5Util();
	boolean number = true;
        if(n!=null)
        {   if(perl.match("/^[0-9]+$/",n))
               number=true;
            else
                number=false;
        }
        
        return number;
    }
    
    /**
    * This method is used to validate email format
    */ 
    private boolean validateEmail(String email)
    {   Perl5Util perl = new Perl5Util();
	boolean valid  = true;
        if(email!=null)
        {   if(perl.match("/^[a-zA-Z0-9._-]+@([a-zA-Z0-9._-]+\\.)+([a-zA-Z0-9_-]){2,3}$/",email))
               valid=true;
            else
                valid=false;
        }
        
        return valid;
    }
    
    /** Getter for property locations.
     * @return Value of property locations.
     */
    public Collection getLocations() {
        return this.locations;
    }
    
    /** Setter for property locations.
     * @param locations New value of property locations.
     */
    public void setLocations(Collection locations) {
        this.locations = locations;
    }
    
    /** Getter for property roles.
     * @return Value of property roles.
     */
    public Collection getRoles() {
        return this.roles;
    }
    
    /** Setter for property roles.
     * @param roles New value of property roles.
     */
    public void setRoles(Collection roles) {
        this.roles = roles;
    }
    
    /** Getter for property pageDetailDefault.
     * @return Value of property pageDetailDefault.
     */
    public java.lang.String getPageDetailDefault() {
        return this.pageDetailDefault;
    }
    
    /** Setter for property pageDetailDefault.
     * @param pageDetailDefault New value of property pageDetailDefault.
     */
    public void setPageDetailDefault(java.lang.String pageDetailDefault) {
        this.pageDetailDefault = pageDetailDefault;
    }
    
    /** Getter for property sendEmail.
     * @return Value of property sendEmail.
     */
    public boolean isSendEmail() {
        return this.sendEmail;
    }
    
    /** Setter for property sendEmail.
     * @param sendEmail New value of property sendEmail.
     */
    public void setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
    }
    
	/**
	 * @return Returns the reviewName.
	 */
	public boolean getReviewName() {
		return reviewName;
	}
	/**
	 * @param reviewName The reviewName to set.
	 */
	public void setReviewName(boolean reviewName) {
		this.reviewName = reviewName;
	}
    /**
     * @return Returns the locationSelected.
     */
    public Collection getLocationSelected() {
        return locationSelected;
    }
    /**
     * @param locationSelected The locationSelected to set.
     */
    public void setLocationSelected(Collection locationSelected) {
        this.locationSelected = locationSelected;
    }
    /**
     * @return Returns the locationAlreadySelected.
     */
    public String[] getLocationAlreadySelected() {
        return locationAlreadySelected;
    }
    /**
     * @param locationAlreadySelected The locationAlreadySelected to set.
     */
    public void setLocationAlreadySelected(String[] locationAlreadySelected) {
        this.locationAlreadySelected = locationAlreadySelected;
    }
    /**
     * @return Returns the otherLocations.
     */
    public String getOtherLocations() {
        return otherLocations;
    }
    /**
     * @param otherLocations The otherLocations to set.
     */
    public void setOtherLocations(String otherLocations) {
        this.otherLocations = otherLocations;
    }
    /**
     * @return Returns the revokeEmployee.
     */
    public String[] getRevokeEmployee() {
        return revokeEmployee;
    }
    /**
     * @param revokeEmployee The revokeEmployee to set.
     */
    public void setRevokeEmployee(String[] revokeEmployee) {
        this.revokeEmployee = revokeEmployee;
    }
    /**
     * @return Returns the roleSelected.
     */
    public Integer[] getRoleSelected() {
        return roleSelected;
    }
    /**
     * @param roleSelected The roleSelected to set.
     */
    public void setRoleSelected(Integer[] roleSelected) {
        this.roleSelected = roleSelected;
    }
    /**
     * @return Returns the locationCd.
     */
    public String getLocationCd() {
        return locationCd;
    }
    /**
     * @param locationCd The locationCd to set.
     */
    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }
    /**
     * @return Returns the extlCustFlg.
     */
    public int getExtlCustFlg() {
        return extlCustFlg;
    }
    /**
     * @param extlCustFlg The extlCustFlg to set.
     */
    public void setExtlCustFlg(int extlCustFlg) {
        this.extlCustFlg = extlCustFlg;
    }

    public Integer getRoleDefaultBefore() {
        return roleDefaultBefore;
    }

    public void setRoleDefaultBefore(Integer roleDefaultBefore) {
        this.roleDefaultBefore = roleDefaultBefore;
    }

    public boolean isDisabledFlg() {
        return disabledFlg;
    }

    public void setDisabledFlg(boolean disabledFlg) {
        this.disabledFlg = disabledFlg;
    }
}
