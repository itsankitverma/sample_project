
package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateExpressionsUtil;

/**
 * Add deposit slip comments screen form class
 * @author  ccardenas
 */
public class DepSlipAddCommentForm extends ActionForm implements java.io.Serializable{
    /** Holds value of property comments. */
    private String comments;

    /** Holds value of property oldComment. */

    private String oldComment;

    /** Holds value of property currentDepositSlipId. */
    private int currentDepositSlipId;

    public DepSlipAddCommentForm() {
    }

    /** Getter for property comments.
     * @return Value of property comments.
     */
    public String getNewComment() {
        return this.comments;
    }

    /** Setter for property comments.
     * @param comments New value of property comments.
     */
    public void setNewComment(String comments) {
        this.comments = comments;
    }

    /** Getter for property oldComment.
     * @return Value of property oldComment.
     */
    public String getOldComment() {
        return this.oldComment;
    }

    /** Setter for property oldComment.
     * @param oldComment New value of property oldComment.
     */
    public void setOldComment(String oldComment) {
        this.oldComment = oldComment;
    }

    /** Getter for property currentDepositSlipId.
     * @return Value of property currentDepositSlipId.
     */
    public int getCurrentDepositSlipId() {
        return this.currentDepositSlipId;
    }

    /** Setter for property currentDepositSlipId.
     * @param currentDepositSlipId New value of property currentDepositSlipId.
     */
    public void setCurrentDepositSlipId(int currentDepositSlipId) {
        this.currentDepositSlipId = currentDepositSlipId;
    }


    public ActionErrors validate(ActionMapping mapping,
                                     HttpServletRequest request)
    {
       ActionErrors errors = super.validate(mapping, request);
       ValidateExpressionsUtil valUtil = ValidateExpressionsUtil.getInstance();

       if (errors == null) errors = new ActionErrors();

       String expressions[] = {"JavaScriptInjection.bl"};
       //System.out.println(valUtil.isValid(expressions,this.getNewComment()));
       if(!valUtil.isValid(expressions,this.getNewComment()))
                errors.add("oldComment",new ActionError("wl.error.noValidChars"));

       return errors;
    }

}
