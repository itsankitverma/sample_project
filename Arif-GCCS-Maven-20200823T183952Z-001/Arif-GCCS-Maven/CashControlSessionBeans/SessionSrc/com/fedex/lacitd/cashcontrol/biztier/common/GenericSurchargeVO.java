/*
 * Entry.java
 *
 * Created on 24 de enero de 2003, 12:14
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

/**
 * @author ccardenas
 */
public class GenericSurchargeVO implements java.io.Serializable {
    /**
     * It is the payment id the surcharge is associated with.
     */
    private int paymentId;

    /**
     * It is the code identifying the surcharge.
     */
    private String surchargeCd;

    /**
     * It is the short description of the surcharge.
     */
    private String surchargeDesc;

    /**
     * It is expected amount for the surcharge for that payment.
     */
    private double expectedAmt;

    /**
     * It is applied amount for the surcharge for that payment.
     */
    private double collectedAmt;

    /**
     * It indicates if the surcharge is in the db.
     */
    private boolean newSurcharge;

    /**
     * @return Returns the collectedAmt.
     */
    public double getCollectedAmt() {
        return collectedAmt;
    }

    /**
     * @param collectedAmt The collectedAmt to set.
     */
    public void setCollectedAmt(double collectedAmt) {
        this.collectedAmt = collectedAmt;
    }

    /**
     * @return Returns the expectedAmt.
     */
    public double getExpectedAmt() {
        return expectedAmt;
    }

    /**
     * @param expectedAmt The expectedAmt to set.
     */
    public void setExpectedAmt(double expectedAmt) {
        this.expectedAmt = expectedAmt;
    }

    /**
     * @return Returns the paymentId.
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId The paymentId to set.
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return Returns the surchargeCd.
     */
    public String getSurchargeCd() {
        return surchargeCd;
    }

    /**
     * @param surchargeCd The surchargeCd to set.
     */
    public void setSurchargeCd(String surchargeCd) {
        this.surchargeCd = surchargeCd;
    }

    /**
     * @return Returns the surchargeDesc.
     */
    public String getSurchargeDesc() {
        return surchargeDesc;
    }

    /**
     * @param surchargeDesc The surchargeDesc to set.
     */
    public void setSurchargeDesc(String surchargeDesc) {
        this.surchargeDesc = surchargeDesc;
    }

    /**
     * @return Returns the newSurcharge.
     */
    public boolean isNewSurcharge() {
        return newSurcharge;
    }

    /**
     * @param newSurcharge The newSurcharge to set.
     */
    public void setNewSurcharge(boolean newSurcharge) {
        this.newSurcharge = newSurcharge;
    }

}
