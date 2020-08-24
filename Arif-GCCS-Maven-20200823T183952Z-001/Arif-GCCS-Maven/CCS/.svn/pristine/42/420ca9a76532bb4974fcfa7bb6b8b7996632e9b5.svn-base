package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.OtherPaymentController;
import com.fedex.lacitd.cashcontrol.datatier.controller.OtherPymtCtgController;
import com.fedex.lacitd.cashcontrol.datatier.controller.PaymentTypeController;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateExpressionsUtil;
import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;

/**
 * Add other payments screen form class
 * @author  ccardenas
 */
public class OtherPaymentAddForm extends ActionForm implements java.io.Serializable{
    private Collection payments;
    
    
    //getter setter for miscDate
    private String miscDate;

    public String getMiscDate() {
		return miscDate;
	}

	public void setMiscDate(String miscDate) {
		this.miscDate = miscDate;
	}
	/** Holds value of property newPayment. */
    private OtherPaymentVO newPayment=new OtherPaymentVO();

    /** Holds value of property paymentTypes. */
    private java.util.Collection paymentTypes;

    /** Holds value of property paymentTypes. */
    private java.util.Collection otherPaymentsCtg;

    /** Holds value of property countryBanks. */
    private java.util.Collection countryBanks;

    public void setCountryBanks(Collection cb){
        this.countryBanks=cb;
    }

    public Collection getCountryBanks(){
        return this.countryBanks;
    }

    public OtherPaymentAddForm() {
    }

    public void setPayments(Collection payments){
        this.payments = payments;
    }

    public Collection getPayments(){
        return payments;
    }

    /** Getter for property newPayment.
     * @return Value of property newPayment.
     */
    public OtherPaymentVO getNewPayment() {
        return this.newPayment;
    }

    /** Setter for property newPayment.
     * @param newPayment New value of property newPayment.
     */
    public void setNewPayment(OtherPaymentVO newPayment) {
        this.newPayment = newPayment;
    }

    /** Getter for property paymentTypes.
     * @return Value of property paymentTypes.
     */
    public java.util.Collection getPaymentTypes() {
        return this.paymentTypes;
    }

    /** Setter for property paymentTypes.
     * @param paymentTypes New value of property paymentTypes.
     */
    public void setPaymentTypes(java.util.Collection paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
         /*
         if(newPayment.getPaymentType()==3 && newPayment.getPaymentDocNbr().length()>4)
                  newPayment.setPaymentDocNbr(newPayment.getPaymentDocNbr().substring(newPayment.getPaymentDocNbr().length()-4));                

         return new ActionErrors();
         */
       ActionErrors errors = super.validate(mapping, request);
       ValidateExpressionsUtil valUtil = ValidateExpressionsUtil.getInstance();
       String action = (String)request.getParameter("action");
       if (errors == null) errors = new ActionErrors();

           try {
               if (action != null && action.equals("savePayment"))
               {

                   String expressions[] = {"JavaScriptInjection.bl"};

                   if(!valUtil.isValid(expressions,this.getNewPayment().getDescription()))
                            errors.add("description",new ActionError("wl.error.noValidChars"));

                   if(errors.isEmpty())
                   {
                       String expressions1[] = {"JavaScriptInjection.bl"};

                       if(!valUtil.isValid(expressions1,this.getNewPayment().getPaymentDocNbr()))
                                errors.add("paymentDocNbr",new ActionError("wl.error.noValidChars"));
                   }

                   if(!errors.isEmpty())
                   {
                       EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                       setPayments(new OtherPaymentController().getOtherPaymentOpenByLocation(ep.getLocationCd()));
                       setOtherPaymentsCtg(new OtherPymtCtgController().getAllPaymentCtgs());
                       setCountryBanks((Collection)request.getSession().getAttribute("countryBanks"));
                       setPaymentTypes(new PaymentTypeController().getPaymentTypeByOtherLocation(ep.getLocationCd()));
                   }
                 //set the allowed payment types

               }
           } catch(BusinessDelegateException e)
           {
               e.printStackTrace();
           }
       return errors;
       }



    /**
     * @return Returns the otherPaymentsCtg.
     */
    public java.util.Collection getOtherPaymentsCtg() {
        return otherPaymentsCtg;
    }
    /**
     * @param otherPaymentsCtg The otherPaymentsCtg to set.
     */
    public void setOtherPaymentsCtg(java.util.Collection otherPaymentsCtg) {
        this.otherPaymentsCtg = otherPaymentsCtg;
    }
}
