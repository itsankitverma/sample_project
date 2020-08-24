/*
 * EmployeeProfile.java
 * @author  ccardenas
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

import java.util.Date;

public class PoaOutstInvoicesVO implements java.io.Serializable {
    private boolean selected;
    private String countryCd;
    private String fiscal;
    private int dispute;
    private double amtDue;
    private double amtDueUsd;
    private String currencyCd;
    private String customerNm;
    private double exchRate;
    private String fedexAccountNbr;
    private double invoiceAmt;
    private double invoiceAmtUsd;
    private Date invoiceDt;
    private String invoiceNbr;

    /**
     * @return Returns the amtDue.
     */
    public double getAmtDue() {
        return amtDue;
    }

    /**
     * @param amtDue The amtDue to set.
     */
    public void setAmtDue(double amtDue) {
        this.amtDue = amtDue;
    }

    /**
     * @return Returns the amtDueUsd.
     */
    public double getAmtDueUsd() {
        return amtDueUsd;
    }

    /**
     * @param amtDueUsd The amtDueUsd to set.
     */
    public void setAmtDueUsd(double amtDueUsd) {
        this.amtDueUsd = amtDueUsd;
    }

    /**
     * @return Returns the countryCd.
     */
    public String getCountryCd() {
        return countryCd;
    }

    /**
     * @param countryCd The countryCd to set.
     */
    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    /**
     * @return Returns the currencyCd.
     */
    public String getCurrencyCd() {
        return currencyCd;
    }

    /**
     * @param currencyCd The currencyCd to set.
     */
    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    /**
     * @return Returns the exchRate.
     */
    public double getExchRate() {
        return exchRate;
    }

    /**
     * @param exchRate The exchRate to set.
     */
    public void setExchRate(double exchRate) {
        this.exchRate = exchRate;
    }

    /**
     * @return Returns the fedexAccountNbr.
     */
    public String getFedexAccountNbr() {
        return fedexAccountNbr;
    }

    /**
     * @param fedexAccountNbr The fedexAccountNbr to set.
     */
    public void setFedexAccountNbr(String fedexAccountNbr) {
        this.fedexAccountNbr = fedexAccountNbr;
    }

    /**
     * @return Returns the invoiceAmt.
     */
    public double getInvoiceAmt() {
        return invoiceAmt;
    }

    /**
     * @param invoiceAmt The invoiceAmt to set.
     */
    public void setInvoiceAmt(double invoiceAmt) {
        this.invoiceAmt = invoiceAmt;
    }

    /**
     * @return Returns the invoiceAmtUsd.
     */
    public double getInvoiceAmtUsd() {
        return invoiceAmtUsd;
    }

    /**
     * @param invoiceAmtUsd The invoiceAmtUsd to set.
     */
    public void setInvoiceAmtUsd(double invoiceAmtUsd) {
        this.invoiceAmtUsd = invoiceAmtUsd;
    }

    /**
     * @return Returns the invoiceDt.
     */
    public Date getInvoiceDt() {
        return invoiceDt;
    }

    /**
     * @param invoiceDt The invoiceDt to set.
     */
    public void setInvoiceDt(Date invoiceDt) {
        this.invoiceDt = invoiceDt;
    }

    /**
     * @return Returns the invoiceNbr.
     */
    public String getInvoiceNbr() {
        return invoiceNbr;
    }

    /**
     * @param invoiceNbr The invoiceNbr to set.
     */
    public void setInvoiceNbr(String invoiceNbr) {
        this.invoiceNbr = invoiceNbr;
    }

    /**
     * @return Returns the dispute.
     */
    public int getDispute() {
        return dispute;
    }

    /**
     * @param dispute The dispute to set.
     */
    public void setDispute(int dispute) {
        this.dispute = dispute;
    }

    /**
     * @return Returns the fiscal.
     */
    public String getFiscal() {
        return fiscal;
    }

    /**
     * @param fiscal The fiscal to set.
     */
    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }

    /**
     * @return Returns the customerNm.
     */
    public String getCustomerNm() {
        return customerNm;
    }

    /**
     * @param customerNm The customerNm to set.
     */
    public void setCustomerNm(String customerNm) {
        this.customerNm = customerNm;
    }

    /**
     * @return Returns the selected.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected The selected to set.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
