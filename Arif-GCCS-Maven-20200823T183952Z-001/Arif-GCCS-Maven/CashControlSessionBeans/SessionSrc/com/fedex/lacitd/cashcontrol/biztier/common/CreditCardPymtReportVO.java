package com.fedex.lacitd.cashcontrol.biztier.common;

/**
 * Created by IntelliJ IDEA.
 * User: clazo
 * Date: 26-07-2005
 * Time: 04:05:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreditCardPymtReportVO implements java.io.Serializable {

    private String locationCd;
    private String batchId;
    private String awbNbr;
    private String acctNbr;
    private String closeDt;
    private String paymentAmt;
    private String paymentType;
    private String otherNbr;
    private String creditCardNbr;
    private String gndTkNbr;

    public String getGndTkNbr() {
        return gndTkNbr;
    }

    public void setGndTkNbr(String gndTkNbr) {
        this.gndTkNbr = gndTkNbr;
    }

    public String getCreditCardNbr() {
        return creditCardNbr;
    }

    public void setCreditCardNbr(String creditCardNbr) {
        this.creditCardNbr = creditCardNbr;
    }

    public String getCreditCardExpDt() {
        return creditCardExpDt;
    }

    public void setCreditCardExpDt(String creditCardExpDt) {
        this.creditCardExpDt = creditCardExpDt;
    }

    private String creditCardExpDt;

    public String getLocationCd() {
        return locationCd;
    }

    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getAwbNbr() {
        return awbNbr;
    }

    public void setAwbNbr(String awbNbr) {
        this.awbNbr = awbNbr;
    }

    public String getAcctNbr() {
        return acctNbr;
    }

    public void setAcctNbr(String acctNbr) {
        this.acctNbr = acctNbr;
    }

    public String getCloseDt() {
        return closeDt;
    }

    public void setCloseDt(String closeDt) {
        this.closeDt = closeDt;
    }

    public String getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(String paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getOtherNbr() {
        return otherNbr;
    }

    public void setOtherNbr(String otherNbr) {
        this.otherNbr = otherNbr;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String statusId;
    private String comment;
    private String description;


}
