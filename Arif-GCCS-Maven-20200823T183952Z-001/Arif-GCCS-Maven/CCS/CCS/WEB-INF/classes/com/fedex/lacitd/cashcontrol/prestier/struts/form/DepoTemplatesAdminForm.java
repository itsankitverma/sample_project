package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

/**
 * Deposit templates admin screen form class
 * @author  ccardenas
 */public class DepoTemplatesAdminForm extends ActionForm implements java.io.Serializable{
    private List allTemplates;
    
    
    /** Holds value of property currenttempl. */
    private DepTemplVO currentDepTempl=new DepTemplVO();
    
    /** Holds value of property allLocations. */
    private Object[] allLocations;
    
    /** Holds value of property templLocations. */
    private String[] templLocations;
    
    /** Holds value of property allPaymentTypes. */
    private java.util.Collection allPaymentTypes=new ArrayList();
    
    private java.util.Collection templPaymentTypes=new ArrayList();    
    
    /** Holds value of property templPaymentTypesIds. */
    private Integer[] templPaymentTypesIds;
    
    /** Holds value of property localCurrencySelected. */
    private boolean localCurrencySelected;
    
    /** Holds value of property usdCurrencySelected. */
    private boolean usdCurrencySelected;
    
    public DepoTemplatesAdminForm() {
    }
    
    public void setAllTemplates(List awbs){
        this.allTemplates = ListUtils.lazyList(awbs,new Factory() {
            public Object create() {
                return new DepTemplVO();
            }
        } );
    }
    
    public List getAllTemplates(){
        return allTemplates;
    }
    
    /** Getter for property currentDepTempl.
     * @return Value of property currentDepTempl.
     */
    public DepTemplVO getCurrentDepTempl() {
        return this.currentDepTempl;
    }
    
    /** Setter for property currentDepTempl.
     * @param currentDepTempl New value of property currentDepTempl.
     */
    public void setCurrentDepTempl(DepTemplVO currentDepTempl) {
        this.currentDepTempl = currentDepTempl;
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
    
    /** Getter for property templLocations.
     * @return Value of property templLocations.
     */
    public String[] getTemplLocations() {
        return this.templLocations;
    }
    
    /** Setter for property templLocations.
     * @param templLocations New value of property templLocations.
     */
    public void setTemplLocations(String[] templLocations) {
        this.templLocations = templLocations;
    }
    
    /** Getter for property allPaymentTypes.
     * @return Value of property allPaymentTypes.
     */
    public java.util.Collection getAllPaymentTypes() {
        return this.allPaymentTypes;
    }
    
    /** Setter for property allPaymentTypes.
     * @param allPaymentTypes New value of property allPaymentTypes.
     */
    public void setAllPaymentTypes(java.util.Collection allPaymentTypes) {
        this.allPaymentTypes = allPaymentTypes;
    }
    
    /** Getter for property templPaymentTypes.
     * @return Value of property templPaymentTypes.
     */
    public java.util.Collection getTemplPaymentTypes() {
        return this.templPaymentTypes;
    }
    
    /** Setter for property templPaymentTypes.
     * @param templPaymentTypes New value of property templPaymentTypes.
     */
    public void setTemplPaymentTypes(java.util.Collection templPaymentTypes) {
        this.templPaymentTypes = templPaymentTypes;
    }
    
    /** Getter for property templPaymentTypesIds.
     * @return Value of property templPaymentTypesIds.
     */
    public Integer[] getTemplPaymentTypesIds() {
        return this.templPaymentTypesIds;
    }
    
    /** Setter for property templPaymentTypesIds.
     * @param templPaymentTypesIds New value of property templPaymentTypesIds.
     */
    public void setTemplPaymentTypesIds(Integer[] templPaymentTypesIds) {
        this.templPaymentTypesIds = templPaymentTypesIds;
    }
    
    /** Getter for property localCurrencySelected.
     * @return Value of property localCurrencySelected.
     */
    public boolean isLocalCurrencySelected() {
        return this.localCurrencySelected;
    }
    
    /** Setter for property localCurrencySelected.
     * @param localCurrencySelected New value of property localCurrencySelected.
     */
    public void setLocalCurrencySelected(boolean localCurrencySelected) {
        this.localCurrencySelected = localCurrencySelected;
    }
    
    /** Getter for property usdCurrencySelected.
     * @return Value of property usdCurrencySelected.
     */
    public boolean isUsdCurrencySelected() {
        return this.usdCurrencySelected;
    }
    
    /** Setter for property usdCurrencySelected.
     * @param usdCurrencySelected New value of property usdCurrencySelected.
     */
    public void setUsdCurrencySelected(boolean usdCurrencySelected) {
        this.usdCurrencySelected = usdCurrencySelected;
    }
    
}
