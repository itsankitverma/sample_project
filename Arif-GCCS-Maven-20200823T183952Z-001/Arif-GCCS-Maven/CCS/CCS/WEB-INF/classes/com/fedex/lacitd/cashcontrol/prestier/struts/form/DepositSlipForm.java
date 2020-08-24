
package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;


/**
 *  Deposit Slip screen form class
 * @author  ccardenas
 */
public class DepositSlipForm extends ActionForm implements java.io.Serializable{
    private Integer pageNumber;
    private List deposits=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new DepositSlipTableVO();
                                                                          }
                                                                       } );    
    
                                                                       /** Holds value of property comments. */
                                                                       private String comments;
                                                                       
    public DepositSlipForm() {
    }
    
    public void setDeposits(List depos){
        this.deposits = ListUtils.lazyList(depos,new Factory() {
                                                                        public Object create() {
                                                                           return new DepositSlipTableVO();
                                                                        }
                                                                     } );  
    }
    
    public List getDeposits(){
        return deposits;        
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
