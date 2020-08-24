/**
 * CODAddAwbsForm.java
 *
 * Created on April 10, 2003, 11:28 AM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;

/**
 * Add COD screen form class
 * @author  Arturo Gonzalez
 */
public class CODAddAwbsForm extends ActionForm implements java.io.Serializable{

    /** Creates a new instance of CODAddAwbsForm */
    public CODAddAwbsForm() {
    }
    
    private List awbsList=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new COD_RecChangesFromScans();}
                                                                           });

    /** Holds value of property exchRate. */
    private double exchRate = 1 ; //1 is the default value
    
    /** Holds value of property currentCurrency. */
    private String currentCurrency;
    
    /** Holds value of property payment. */
    private COD_RecChangesFromScans COD_recChangesFromScans=new COD_RecChangesFromScans();
    
    /** Holds value of property delIndex. */
    private int delIndex;

    /** Holds flag for procesing cosmos scans */
    private boolean cosmosScansEnabled = false;


    public void setAwbsList(List awbsList){
        this.awbsList = ListUtils.lazyList(awbsList,new Factory() {
                                                                    public Object create() {
                                                                           return new COD_RecChangesFromScans();}
                                                                   } );
    }

    public List getAwbsList(){
        return awbsList;
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
    
    /** Getter for property payment.
     * @return Value of property payment.
     */
    public COD_RecChangesFromScans getRecChangesFromScans(){
        return this.COD_recChangesFromScans;
    }
    
    /** Setter for property payment.
     * @param payment New value of property payment.
     */
    public void setRecChangesFromScans(COD_RecChangesFromScans COD_recChangesFromScans){
        this.COD_recChangesFromScans = COD_recChangesFromScans;
    }
    
    /** Getter for property delIndex.
     * @return Value of property delIndex.
     */
    public int getDelIndex() {
        return this.delIndex;
    }
    
    /** Setter for property delIndex.
     * @param delIndex New value of property delIndex.
     */
    public void setDelIndex(int delIndex) {
        this.delIndex = delIndex;
    }
    
    
    public double getTotalAmount() {
        if(awbsList==null || awbsList.isEmpty()) return 0.0;
        double total=0.0;
        Iterator iter=awbsList.iterator();
        while(iter.hasNext()){
            COD_RecChangesFromScans rchfs=(COD_RecChangesFromScans)iter.next();
            total= total + rchfs.getRecAmount();
        }
        return total;
    }

    public boolean getCosmosScansEnabled(){
        return cosmosScansEnabled;
    }

    public void setCosmosScansEnabled(boolean cosmosScansEnabled){
        this.cosmosScansEnabled=cosmosScansEnabled;
    }

}