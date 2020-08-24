package com.fedex.lacitd.cashcontrol.prestier.struts.form;
import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;

/**
 * Credit Card Payments screen form class 
 * @author  ccardenas
 */
public class CreditCardPymtForm extends ActionForm implements java.io.Serializable{
    private List creditCardBatchs=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new CreditCardPymtTableVO();
                                                                          }
                                                                       } );    
    
                                                                       /** Holds value of property comments. */
                                                                       private String comments;
                                                                       
                                                                       public CreditCardPymtForm() {
    }
    
    public void setCreditCardBatchs(List ccr){
        this.creditCardBatchs = ListUtils.lazyList(ccr,new Factory() {
                                                                        public Object create() {
                                                                           return new CreditCardPymtTableVO();
                                                                        }
                                                                     } );  
    }
    
    public List getCreditCardBatchs(){
        return creditCardBatchs;        
    }    
    
}
