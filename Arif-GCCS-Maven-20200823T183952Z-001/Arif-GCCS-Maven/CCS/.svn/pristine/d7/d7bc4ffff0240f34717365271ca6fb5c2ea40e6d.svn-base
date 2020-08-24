
package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import javax.servlet.http.*;


/**
 * Change password screen form class
 * @author  Arturo Gonzalez
 */

public class ChangePasswordForm extends ActionForm implements java.io.Serializable{
    
    /** Holds value of property country. **/
    private String userId;
    private String userName;
    private String passwordOld;
    private String passwordNew;
    private String passwordNewAgain;
        
    /** Holds value of property check. */
    private boolean check=false;
    
    public ChangePasswordForm() {
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
    
    /** Getter for property password1.
     * @return Value of property passwordOld.
     */
    public String getPasswordOld() {
        return this.passwordOld;
    }
    
    /** Setter for property passwordOld.
     * @param password1 New value of property passwordOld.
     */
    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }
    
    /** Getter for property passwordNew.
     * @return Value of property passwordNew.
     */
    public String getPasswordNew() {
        return this.passwordNew;
    }
    
    /** Setter for property passwordNew.
     * @param passwordNew New value of property password.
     */
    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }
    
    /** Getter for property passwordNewAgain.
     * @return Value of property passwordNewAgain.
     */
    public String getPasswordNewAgain() {
        return this.passwordNewAgain;
    }
    
    /** Setter for property passwordNewAgain.
     * @param passwordNew New value of property password.
     */
    public void setPasswordNewAgain(String passwordNewAgain) {
        this.passwordNewAgain = passwordNewAgain;
    }
    
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {   ActionErrors errors = new ActionErrors();
        
        if(this.check)
        {
         if(this.passwordOld==null || this.passwordOld.length()==0)
            errors.add("passwordOld",new ActionError("errors.messages.OldPasswordInvalid"));
         if(this.passwordNew==null || this.passwordNew.length()==0)
            errors.add("passwordNew",new ActionError("app.messages.MustEnterNewInvalid"));            
         if(this.passwordNewAgain==null || this.passwordNewAgain.length()==0)    
            errors.add("passwordNewAgain",new ActionError("app.messages.MustEnterNewAgainInvalid"));
         else if(!(this.passwordNewAgain.equals(this.passwordNew)))
                   errors.add("PasswordsEquals",new ActionError("app.messages.NewPasswordsEquals"));
        }
        
        return errors;
    }

    /** Getter for property check.
     * @return Value of property check.
     */
    public boolean isCheck() {
        return this.check;
    }
    
    /** Setter for property check.
     * @param check New value of property check.
     */
    public void setCheck(boolean check) {
        this.check = check;
    }
    
}
