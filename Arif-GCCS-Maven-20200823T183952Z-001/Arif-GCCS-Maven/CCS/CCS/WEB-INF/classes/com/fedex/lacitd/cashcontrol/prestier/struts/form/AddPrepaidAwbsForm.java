package com.fedex.lacitd.cashcontrol.prestier.struts.form;
import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;

/**
 * Add prepaid awbs screen form class
 * @author  ccardenas
 */
public class AddPrepaidAwbsForm extends ActionForm implements java.io.Serializable{
    private List awbs=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new PrepaidScansVO();
                                                                          }
                                                                       } );

    /** Holds value of property courier. */
    private String courier;

    /** Holds value of property courierName. */
    private String courierName;

    /** Holds value of property exchRate. */
    private double exchRate;
    
    /** Holds value of property currentCurrency. */
    private String currentCurrency;
    
    public AddPrepaidAwbsForm() {
    }

    public void setAwbs(List awbs){
        this.awbs = ListUtils.lazyList(awbs,new Factory() {
                                                                        public Object create() {
                                                                           return new PrepaidScansVO();
                                                                        }
                                                                     } );
    }

    public List getAwbs(){
        return awbs;
    }

    /** Getter for property courier.
     * @return Value of property courier.
     */
    public String getCourierId() {
        return this.courier;
    }

    /** Setter for property courier.
     * @param courier New value of property courier.
     */
    public void setCourierId(String courier) {
        this.courier = courier;
    }

    /** Getter for property courierName.
     * @return Value of property courierName.
     */
    public String getCourierName() {
        return this.courierName;
    }

    /** Setter for property courierName.
     * @param courierName New value of property courierName.
     */
    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    /** Getter for property exchRate.
     * @return Value of property exchRate.
     */
    public double getExchRate() {
        return this.exchRate;
    }
    
    /** Setter for property exchRate.
     * @param exchRate New value of property exchRate.
     */
    public void setExchRate(double exchRate) {
        this.exchRate = exchRate;
    }
    
    /** Getter for property currentCurrency.
     * @return Value of property currentCurrency.
     */
    public String getCurrentCurrency() {
        return this.currentCurrency;
    }
    
    /** Setter for property currentCurrency.
     * @param currentCurrency New value of property currentCurrency.
     */
    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }
    
}
