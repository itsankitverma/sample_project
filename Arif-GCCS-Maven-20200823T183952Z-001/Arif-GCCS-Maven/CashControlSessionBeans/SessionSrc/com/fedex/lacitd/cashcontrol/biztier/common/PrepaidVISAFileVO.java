/*
 * EmployeeProfile.java
 * @author  ccardenas
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

public class PrepaidVISAFileVO implements java.io.Serializable {

    /**
     * Holds value of property recAwbNumber.
     */
    private String recAwbNumber;

    /**
     * Holds value of property awbNbr.
     */
    private String awbNbr;

    /**
     * Holds value of property origLocation.
     */
    private String origLocation;

    /**
     * Holds value of property origCountry.
     */
    private String origCountry;

    /**
     * Holds value of property shipDate.
     */
    private java.util.Date shipDate;

    /**
     * Holds value of property product.
     */
    private int product;

    /**
     * Holds value of property numberPkgs.
     */
    private int numberPkgs;

    /**
     * Holds value of property weight.
     */
    private double weight;

    /**
     * Holds value of property tinUniqId.
     */
    private String tinUniqId;

    /**
     * Holds value of property cosmosScan.
     */
    private java.util.Collection cosmosScan;

    /**
     * Holds value of property prepaidId.
     */
    private int prepaidId;

    /**
     * Holds value of property locationCd.
     */
    private String locationCd;

    /**
     * Holds value of property courierId.
     */
    private String courierId;

    /**
     * Holds value of property lastScanType.
     */
    private String lastScanType;

    /**
     * Holds value of property lastScanDate.
     */
    private java.util.Date lastScanDate;

    /**
     * Holds value of property cashPaymentAmt.
     */
    private double cashPaymentAmt;

    /**
     * Holds value of property otherPaymentAmt.
     */
    private double otherPaymentAmt;

    /**
     * Holds value of property otherPaymentType.
     */
    private int otherPaymentType;

    /**
     * Holds value of property coupPymtAmt.
     */
    private double coupPymtAmt;

    /**
     * Holds value of property otherDocNbr.
     */
    private String otherDocNbr;

    /**
     * Holds value of property pux16CashPayment.
     */
    private double pux16CashPayment;

    /**
     * Holds value of property pux16OtherPaymentAmt.
     */
    private double pux16OtherPaymentAmt;

    /**
     * Holds value of property pux16OtherDocNbr.
     */
    private String pux16OtherDocNbr;

    /**
     * Holds value of property pux16CoupPymtAmt.
     */
    private double pux16CoupPymtAmt;

    /**
     * Holds value of property paymentCurrency.
     */
    private String paymentCurrency;

    /**
     * Holds value of property pux16ScanSeqNbr.
     */
    private String pux16ScanSeqNbr;

    /**
     * Holds value of property pux16FreightAmt.
     */
    private double pux16FreightAmt;

    /**
     * Holds value of property freightAmtInVisa.
     */
    private double freightAmtInVisa;

    /**
     * Holds value of property delayDscr.
     */
    private boolean delayDscr;

    /**
     * Holds value of property PUX.
     */
    private boolean PUX;

    /**
     * Holds value of property PUP.
     */
    private boolean PUP;

    /**
     * Holds value of property customerNm.
     */
    private String customerNm;

    public int getScansUsdDecs() {
        return scansUsdDecs;
    }

    public void setScansUsdDecs(int scansUsdDecs) {
        this.scansUsdDecs = scansUsdDecs;
    }

    public int getScansLocalDecs() {
        return scansLocalDecs;
    }

    private int scansLocalDecs;
    private int scansUsdDecs;

    public PrepaidVISAFileVO() {
    }

    /**
     * Getter for property awbNbr.
     *
     * @return Value of property awbNbr.
     */
    public String getAwbNbr() {
        return this.awbNbr;
    }

    /**
     * Setter for property awbNbr.
     *
     * @param awbNbr New value of property awbNbr.
     */
    public void setAwbNbr(String awbNbr) {
        this.awbNbr = awbNbr;
    }

    /**
     * Getter for property origLocation.
     *
     * @return Value of property origLocation.
     */
    public String getOrigLocation() {
        return this.origLocation;
    }

    /**
     * Setter for property origLocation.
     *
     * @param origLocation New value of property origLocation.
     */
    public void setOrigLocation(String origLocation) {
        this.origLocation = origLocation;
    }

    /**
     * Getter for property origCountry.
     *
     * @return Value of property origCountry.
     */
    public String getOrigCountry() {
        return this.origCountry;
    }

    /**
     * Setter for property origCountry.
     *
     * @param origCountry New value of property origCountry.
     */
    public void setOrigCountry(String origCountry) {
        this.origCountry = origCountry;
    }

    /**
     * Getter for property shipDate.
     *
     * @return Value of property shipDate.
     */
    public java.util.Date getShipDate() {
        return this.shipDate;
    }

    /**
     * Setter for property shipDate.
     *
     * @param shipDate New value of property shipDate.
     */
    public void setShipDate(java.util.Date shipDate) {
        this.shipDate = shipDate;
    }

    /**
     * Getter for property product.
     *
     * @return Value of property product.
     */
    public int getProduct() {
        return this.product;
    }

    /**
     * Setter for property product.
     *
     * @param product New value of property product.
     */
    public void setProduct(int product) {
        this.product = product;
    }

    /**
     * Getter for property numberPkgs.
     *
     * @return Value of property numberPkgs.
     */
    public int getNumberPkgs() {
        return this.numberPkgs;
    }

    /**
     * Setter for property numberPkgs.
     *
     * @param numberPkgs New value of property numberPkgs.
     */
    public void setNumberPkgs(int numberPkgs) {
        this.numberPkgs = numberPkgs;
    }

    /**
     * Getter for property weight.
     *
     * @return Value of property weight.
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Setter for property weight.
     *
     * @param weight New value of property weight.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Getter for property tinUniqId.
     *
     * @return Value of property tinUniqId.
     */
    public String getTinUniqId() {
        return this.tinUniqId;
    }

    /**
     * Setter for property tinUniqId.
     *
     * @param tinUniqId New value of property tinUniqId.
     */
    public void setTinUniqId(String tinUniqId) {
        this.tinUniqId = tinUniqId;
    }

    /**
     * Getter for property cosmosScan.
     *
     * @return Value of property cosmosScan.
     */
    public java.util.Collection getCosmosScans() {
        return this.cosmosScan;
    }

    /**
     * Setter for property cosmosScan.
     *
     * @param cosmosScan New value of property cosmosScan.
     */
    public void setCosmosScans(java.util.Collection cosmosScan) {
        this.cosmosScan = cosmosScan;
    }

    /**
     * Getter for property prepaidId.
     *
     * @return Value of property prepaidId.
     */
    public int getPrepaidId() {
        return this.prepaidId;
    }

    /**
     * Setter for property prepaidId.
     *
     * @param prepaidId New value of property prepaidId.
     */
    public void setPrepaidId(int prepaidId) {
        this.prepaidId = prepaidId;
    }

    /**
     * Getter for property locationCd.
     *
     * @return Value of property locationCd.
     */
    public String getLocationCd() {
        return this.locationCd;
    }

    /**
     * Setter for property locationCd.
     *
     * @param locationCd New value of property locationCd.
     */
    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }

    /**
     * Getter for property courierId.
     *
     * @return Value of property courierId.
     */
    public String getCourierId() {
        return this.courierId;
    }

    /**
     * Setter for property courierId.
     *
     * @param courierId New value of property courierId.
     */
    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    /**
     * Getter for property lastScanType.
     *
     * @return Value of property lastScanType.
     */
    public String getLastScanType() {
        return this.lastScanType;
    }

    /**
     * Setter for property lastScanType.
     *
     * @param lastScanType New value of property lastScanType.
     */
    public void setLastScanType(String lastScanType) {
        this.lastScanType = lastScanType;
    }

    /**
     * Getter for property lastScanDate.
     *
     * @return Value of property lastScanDate.
     */
    public java.util.Date getLastScanDate() {
        return this.lastScanDate;
    }

    /**
     * Setter for property lastScanDate.
     *
     * @param lastScanDate New value of property lastScanDate.
     */
    public void setLastScanDate(java.util.Date lastScanDate) {
        this.lastScanDate = lastScanDate;
    }

    /**
     * Getter for property cashPaymentAmt.
     *
     * @return Value of property cashPaymentAmt.
     */
    public double getCashPaymentAmt() {
        return this.cashPaymentAmt;
    }

    /**
     * Setter for property cashPaymentAmt.
     *
     * @param cashPaymentAmt New value of property cashPaymentAmt.
     */
    public void setCashPaymentAmt(double cashPaymentAmt) {
        this.cashPaymentAmt = cashPaymentAmt;
    }

    /**
     * Getter for property otherPaymentAmt.
     *
     * @return Value of property otherPaymentAmt.
     */
    public double getOtherPaymentAmt() {
        return this.otherPaymentAmt;
    }

    /**
     * Setter for property otherPaymentAmt.
     *
     * @param otherPaymentAmt New value of property otherPaymentAmt.
     */
    public void setOtherPaymentAmt(double otherPaymentAmt) {
        this.otherPaymentAmt = otherPaymentAmt;
    }

    /**
     * Getter for property otherPaymentType.
     *
     * @return Value of property otherPaymentType.
     */
    public int getOtherPaymentType() {
        return this.otherPaymentType;
    }

    /**
     * Setter for property otherPaymentType.
     *
     * @param otherPaymentType New value of property otherPaymentType.
     */
    public void setOtherPaymentType(int otherPaymentType) {
        this.otherPaymentType = otherPaymentType;
    }

    /**
     * Getter for property coupPymtAmt.
     *
     * @return Value of property coupPymtAmt.
     */
    public double getCoupPymtAmt() {
        return this.coupPymtAmt;
    }

    /**
     * Setter for property coupPymtAmt.
     *
     * @param coupPymtAmt New value of property coupPymtAmt.
     */
    public void setCoupPymtAmt(double coupPymtAmt) {
        this.coupPymtAmt = coupPymtAmt;
    }

    /**
     * Getter for property otherDocNbr.
     *
     * @return Value of property otherDocNbr.
     */
    public String getOtherDocNbr() {
        return this.otherDocNbr;
    }

    /**
     * Setter for property otherDocNbr.
     *
     * @param otherDocNbr New value of property otherDocNbr.
     */
    public void setOtherDocNbr(String otherDocNbr) {
        this.otherDocNbr = otherDocNbr;
    }

    /**
     * Getter for property pux16CashPayment.
     *
     * @return Value of property pux16CashPayment.
     */
    public double getPux16CashPayment() {
        return this.pux16CashPayment;
    }

    /**
     * Setter for property pux16CashPayment.
     *
     * @param pux16CashPayment New value of property pux16CashPayment.
     */
    public void setPux16CashPayment(double pux16CashPayment) {
        this.pux16CashPayment = pux16CashPayment;
    }

    /**
     * Getter for property pux16OtherPaymentAmt.
     *
     * @return Value of property pux16OtherPaymentAmt.
     */
    public double getPux16OtherPaymentAmt() {
        return this.pux16OtherPaymentAmt;
    }

    /**
     * Setter for property pux16OtherPaymentAmt.
     *
     * @param pux16OtherPaymentAmt New value of property pux16OtherPaymentAmt.
     */
    public void setPux16OtherPaymentAmt(double pux16OtherPaymentAmt) {
        this.pux16OtherPaymentAmt = pux16OtherPaymentAmt;
    }

    /**
     * Getter for property pux16OtherDocNbr.
     *
     * @return Value of property pux16OtherDocNbr.
     */
    public String getPux16OtherDocNbr() {
        return this.pux16OtherDocNbr;
    }

    /**
     * Setter for property pux16OtherDocNbr.
     *
     * @param pux16OtherDocNbr New value of property pux16OtherDocNbr.
     */
    public void setPux16OtherDocNbr(String pux16OtherDocNbr) {
        this.pux16OtherDocNbr = pux16OtherDocNbr;
    }

    /**
     * Getter for property pux16CoupPymtAmt.
     *
     * @return Value of property pux16CoupPymtAmt.
     */
    public double getPux16CoupPymtAmt() {
        return this.pux16CoupPymtAmt;
    }

    /**
     * Setter for property pux16CoupPymtAmt.
     *
     * @param pux16CoupPymtAmt New value of property pux16CoupPymtAmt.
     */
    public void setPux16CoupPymtAmt(double pux16CoupPymtAmt) {
        this.pux16CoupPymtAmt = pux16CoupPymtAmt;
    }

    /**
     * Getter for property paymentCurrency.
     *
     * @return Value of property paymentCurrency.
     */
    public String getPaymentCurrency() {
        return this.paymentCurrency;
    }

    /**
     * Setter for property paymentCurrency.
     *
     * @param paymentCurrency New value of property paymentCurrency.
     */
    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    /**
     * Getter for property pux16ScanSeqNbr.
     *
     * @return Value of property pux16ScanSeqNbr.
     */
    public String getPux16ScanSeqNbr() {
        return this.pux16ScanSeqNbr;
    }

    /**
     * Setter for property pux16ScanSeqNbr.
     *
     * @param pux16ScanSeqNbr New value of property pux16ScanSeqNbr.
     */
    public void setPux16ScanSeqNbr(String pux16ScanSeqNbr) {
        this.pux16ScanSeqNbr = pux16ScanSeqNbr;
    }

    /**
     * Getter for property pux16FreightAmt.
     *
     * @return Value of property pux16FreightAmt.
     */
    public double getPux16FreightAmt() {
        return this.pux16FreightAmt;
    }

    /**
     * Setter for property pux16FreightAmt.
     *
     * @param pux16FreightAmt New value of property pux16FreightAmt.
     */
    public void setPux16FreightAmt(double pux16FreightAmt) {
        this.pux16FreightAmt = pux16FreightAmt;
    }

    /**
     * Getter for property delayDscr.
     *
     * @return Value of property delayDscr.
     */
    public boolean isDelayDscr() {
        return this.delayDscr;
    }

    /**
     * Setter for property delayDscr.
     *
     * @param delayDscr New value of property delayDscr.
     */
    public void setDelayDscr(boolean delayDscr) {
        this.delayDscr = delayDscr;
    }

    /**
     * Getter for property PUX.
     *
     * @return Value of property PUX.
     */
    public boolean isPUX() {
        return this.PUX;
    }

    /**
     * Setter for property PUX.
     *
     * @param PUX New value of property PUX.
     */
    public void setPUX(boolean PUX) {
        this.PUX = PUX;
    }

    /**
     * Getter for property PUP.
     *
     * @return Value of property PUP.
     */
    public boolean isPUP() {
        return this.PUP;
    }

    /**
     * Setter for property PUP.
     *
     * @param PUP New value of property PUP.
     */
    public void setPUP(boolean PUP) {
        this.PUP = PUP;
    }

    /**
     * Getter for property customerNm.
     *
     * @return Value of property customerNm.
     */
    public String getCustomerNm() {
        return this.customerNm;
    }

    /**
     * Setter for property customerNm.
     *
     * @param customerNm New value of property customerNm.
     */
    public void setCustomerNm(String customerNm) {
        this.customerNm = customerNm;
    }

    /**
     * @return Returns the freightAmtInVisa.
     */
    public double getFreightAmtInVisa() {
        return freightAmtInVisa;
    }

    /**
     * @param freightAmtInVisa The freightAmtInVisa to set.
     */
    public void setFreightAmtInVisa(double freightAmtInVisa) {
        this.freightAmtInVisa = freightAmtInVisa;
    }

    public void setScansLocalDecs(int scansLocalDecs) {
        this.scansLocalDecs = scansLocalDecs;
    }
}
