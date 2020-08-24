package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

/**
 * Payment Types Admin screen form class
 * @author  ccardenas
 */
public class PaymentsAdminForm extends ActionForm implements java.io.Serializable{
    private List allPayments;
    
    
    /** Holds value of property paymentCtg. */
    private java.util.Collection paymentCtg;
    
    /** Holds value of property currentPayment. */
    private PaymentTypeVO currentPayment=new PaymentTypeVO();
    
    /** Holds value of property allLocations. */
    private Object[] allLocations;
    
    /** Holds value of property paymentLocations. */
    private Object[] paymentLocations;
    
    public PaymentsAdminForm() {
    }
    
    public void setAllPayments(List awbs){
        this.allPayments = ListUtils.lazyList(awbs,new Factory() {
            public Object create() {
                return new PaymentTypeVO();
            }
        } );
    }
    
    public List getAllPayments(){
        return allPayments;
    }
    
    /** Getter for property paymentCtg.
     * @return Value of property paymentCtg.
     */
    public java.util.Collection getPaymentCtg() {
        return this.paymentCtg;
    }
    
    /** Setter for property paymentCtg.
     * @param paymentCtg New value of property paymentCtg.
     */
    public void setPaymentCtg(java.util.Collection paymentCtg) {
        this.paymentCtg = paymentCtg;
    }
    
    /** Getter for property currentPayment.
     * @return Value of property currentPayment.
     */
    public PaymentTypeVO getCurrentPayment() {
        return this.currentPayment;
    }
    
    /** Setter for property currentPayment.
     * @param currentPayment New value of property currentPayment.
     */
    public void setCurrentPayment(PaymentTypeVO currentPayment) {
        this.currentPayment = currentPayment;
    }
    
    /** Getter for property allLocations.
     * @return Value of property allLocations.
     */
    public Object[] getAllLocations() {
        return this.allLocations;
    }
    
    /** Setter for property allLocations.
     * @param allLocations New value of property allLocations.
     */
    public void setAllLocations(Object[] allLocations) {
        this.allLocations = allLocations;
    }
    
    /** Getter for property paymentLocations.
     * @return Value of property paymentLocations.
     */
    public Object[] getPaymentLocations() {
        return this.paymentLocations;
    }
    
    /** Setter for property paymentLocations.
     * @param paymentLocations New value of property paymentLocations.
     */
    public void setPaymentLocations(Object[] paymentLocations) {
        this.paymentLocations = paymentLocations;
    }
    
}
