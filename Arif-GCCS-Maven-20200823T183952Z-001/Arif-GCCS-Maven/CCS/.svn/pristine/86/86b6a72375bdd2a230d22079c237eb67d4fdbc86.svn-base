
package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;


/**
 *  Deposit Slip screen form class
 * @author  ccardenas
 */
public class BatchPaymentsAdminForm extends ActionForm implements java.io.Serializable{
    public String getLocationCd() {
        return locationCd;
    }

    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    private String locationCd;
    private String startDate;
    private String endDate;
    private String selectedEodId;

    public String getSelectedEodId() {
        return selectedEodId;
    }

    public void setSelectedEodId(String selectedEodId) {
        this.selectedEodId = selectedEodId;
    }

    public int getSelectedDepositCd() {
        return selectedDepositCd;
    }

    public void setSelectedDepositCd(int selectedDepositCd) {
        this.selectedDepositCd = selectedDepositCd;
    }

    private int selectedDepositCd;

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }

    private String newDate;

    private List deposits=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new DepositSlipTableVO();
                                                                          }
                                                                       } );    
    

    public BatchPaymentsAdminForm() {
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


}
