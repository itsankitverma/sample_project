package com.fedex.lacitd.cashcontrol.prestier.struts.form;
import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

/**
 * Add prepaid awbs screen form class
 * @author  ccardenas
 */
public class AddGrndTrakNbrsForm extends ActionForm implements java.io.Serializable{
    private List trakNbrs=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new GroundVO();
                                                                          }
                                                                       } );

    /** Holds value of property courier. */
    private String courierId;

    /** Holds value of property courierName. */
    private String courierName;

    /** Holds value of property exchRate. */
    private double exchRate;
    
    /** Holds value of property currentCurrency. */
    private String currentCurrency;
    
    public AddGrndTrakNbrsForm() {
    }


    public List getTrakNbrs() {
        return trakNbrs;
    }

    public void setTrakNbrs(List trakNbrs) {
        this.trakNbrs = trakNbrs;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public double getExchRate() {
        return exchRate;
    }

    public void setExchRate(double exchRate) {
        this.exchRate = exchRate;
    }

    public String getCurrentCurrency() {
        return currentCurrency;
    }

    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }
}
