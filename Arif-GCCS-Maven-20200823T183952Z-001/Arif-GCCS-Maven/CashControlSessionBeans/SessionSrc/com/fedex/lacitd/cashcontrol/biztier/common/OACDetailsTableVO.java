package com.fedex.lacitd.cashcontrol.biztier.common;

/**
 * Created by IntelliJ IDEA.
 * User: ralvarez
 * Date: 14-07-2005
 * Time: 05:20:52 PM
 */
public class OACDetailsTableVO implements java.io.Serializable {

    /**
     * Holds value of property oacId.
     */
    private int oacId;

    /**
     * Holds value of property collection of awbs.
     */
    private String[] awbs;

    /**
     * Holds value of property collection of oacAwbs.
     */
    private String[] oacAwbs;

    /**
     * Holds value of property oacDate.
     */
    private java.util.Date oacDate;

    private String oacDateText;

    /**
     * Holds value of property cashPayment.
     */
    private double cashPayment;

    /**
     * Holds value of property otherPayment.
     */
    private double otherPayment;

    /**
     * Holds value of property recCheckNumber.
     */
    private String otherDocNumber;

    /**
     * Holds value of property comment.
     */
    private String comment;

    /**
     * Holds value of property statusId.
     */
    private int statusId;

    /**
     * Holds value of property recCheckInCashPrev.
     */
    private double cashPaymentPrev;

    /**
     * Holds value of property recCheckNumberPrev.
     */
    private String otherDocNumberPrev;

    /**
     * Holds value of property otherPaymentPrev.
     */
    private double otherPaymentPrev;

    /**
     * Holds value of property commentPrev.
     */
    private String commentPrev;

    /**
     * Holds value of property statusIdPrev.
     */
    private int statusIdPrev;

    /**
     * Holds value of property paymentCurrency.
     */
    private String paymentCurrency;

    /**
     * Holds value of property otherPaymentType.
     */
    private int otherPaymentType;

    /**
     * Holds value of property otherPaymentTypePrev.
     */
    private int otherPaymentTypePrev;

    /**
     * Holds value of property exchRate.
     */
    private double exchRate;

    /**
     * Holds value of property chngStatusDate.
     */
    private java.util.Date chngStatusDate;

    /**
     * Holds value of property chngStatusEmployeeId.
     */
    private String chngStatusEmployeeId;

    /**
     * Holds value of property otherComment.
     */
    private String otherComment;

    /**
     * Holds value of property otherCommentPrev.
     */
    private String otherCommentPrev;

    private String rcptNbr;

    private String rcptNbrPrev;

    private String rcptChngEmpId;

    private String courierId;

    private String employeeNm;

    /**
     * Holds value of property selected.
     */
    private boolean selected;

    public OACDetailsTableVO() {
    }

    public boolean isModified() {
        if (getOtherDocNumber() == null) {
            if (getOtherDocNumberPrev() != null) return true;
        } else {
            if (!getOtherDocNumber().equals(getOtherDocNumberPrev())) return true;
        }

        if (getRcptNbr() == null) {
            if (getRcptNbrPrev() != null) return true;
        } else {
            if (!getRcptNbr().equals(getRcptNbrPrev())) return true;
        }

        if (getComment() == null) {
            if (getCommentPrev() != null) return true;
        } else {
            if (!getComment().equals(getCommentPrev())) return true;
        }

        if (getOtherComment() == null) {
            if (getOtherCommentPrev() != null) return true;
        } else {
            if (!getOtherComment().equals(getOtherCommentPrev())) return true;
        }
        return (getCashPayment() != getCashPaymentPrev() || getOtherPaymentType() != getOtherPaymentTypePrev() || getOtherPayment() != getOtherPaymentPrev() || getStatusId() != getStatusIdPrev());
    }

    public int getOacId() {
        return oacId;
    }

    public void setOacId(int oacId) {
        this.oacId = oacId;
    }

    public String[] getAwbs() {
        return awbs;
    }

    public void setAwbs(String[] awbs) {
        this.awbs = awbs;
    }

    public java.util.Date getOacDate() {
        return oacDate;
    }

    public void setOacDate(java.util.Date oacDate) {
        this.oacDate = oacDate;
    }

    public double getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(double cashPayment) {
        this.cashPayment = cashPayment;
    }

    public double getOtherPayment() {
        return otherPayment;
    }

    public void setOtherPayment(double otherPayment) {
        this.otherPayment = otherPayment;
    }

    public String getOtherDocNumber() {
        return otherDocNumber;
    }

    public void setOtherDocNumber(String otherDocNumber) {
        this.otherDocNumber = otherDocNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public double getCashPaymentPrev() {
        return cashPaymentPrev;
    }

    public void setCashPaymentPrev(double cashPaymentPrev) {
        this.cashPaymentPrev = cashPaymentPrev;
    }

    public String getOtherDocNumberPrev() {
        return otherDocNumberPrev;
    }

    public void setOtherDocNumberPrev(String otherDocNumberPrev) {
        this.otherDocNumberPrev = otherDocNumberPrev;
    }

    public double getOtherPaymentPrev() {
        return otherPaymentPrev;
    }

    public void setOtherPaymentPrev(double otherPaymentPrev) {
        this.otherPaymentPrev = otherPaymentPrev;
    }

    public String getCommentPrev() {
        return commentPrev;
    }

    public void setCommentPrev(String commentPrev) {
        this.commentPrev = commentPrev;
    }

    public int getStatusIdPrev() {
        return statusIdPrev;
    }

    public void setStatusIdPrev(int statusIdPrev) {
        this.statusIdPrev = statusIdPrev;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public int getOtherPaymentType() {
        return otherPaymentType;
    }

    public void setOtherPaymentType(int otherPaymentType) {
        this.otherPaymentType = otherPaymentType;
    }

    public int getOtherPaymentTypePrev() {
        return otherPaymentTypePrev;
    }

    public void setOtherPaymentTypePrev(int otherPaymentTypePrev) {
        this.otherPaymentTypePrev = otherPaymentTypePrev;
    }

    public double getExchRate() {
        return exchRate;
    }

    public void setExchRate(double exchRate) {
        this.exchRate = exchRate;
    }

    public java.util.Date getChngStatusDate() {
        return chngStatusDate;
    }

    public void setChngStatusDate(java.util.Date chngStatusDate) {
        this.chngStatusDate = chngStatusDate;
    }

    public String getChngStatusEmployeeId() {
        return chngStatusEmployeeId;
    }

    public void setChngStatusEmployeeId(String chngStatusEmployeeId) {
        this.chngStatusEmployeeId = chngStatusEmployeeId;
    }

    public String getOtherComment() {
        return otherComment;
    }

    public void setOtherComment(String otherComment) {
        this.otherComment = otherComment;
    }

    public String getOtherCommentPrev() {
        return otherCommentPrev;
    }

    public void setOtherCommentPrev(String otherCommentPrev) {
        this.otherCommentPrev = otherCommentPrev;
    }

    public String getRcptNbr() {
        return rcptNbr;
    }

    public void setRcptNbr(String rcptNbr) {
        this.rcptNbr = rcptNbr;
    }

    public String getRcptNbrPrev() {
        return rcptNbrPrev;
    }

    public void setRcptNbrPrev(String rcptNbrPrev) {
        this.rcptNbrPrev = rcptNbrPrev;
    }

    public String getRcptChngEmpId() {
        return rcptChngEmpId;
    }

    public void setRcptChngEmpId(String rcptChngEmpId) {
        this.rcptChngEmpId = rcptChngEmpId;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public void setEmployeeNm(String employeeNm) {
        this.employeeNm = employeeNm;
    }

    public String getEmployeeNm() {
        return employeeNm;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getOacDateText() {
        return oacDateText;
    }

    public void setOacDateText(String oacDateText) {
        this.oacDateText = oacDateText;
    }

    public String[] getOacAwbs() {
        return oacAwbs;
    }

    public void setOacAwbs(String[] oacAwbs) {
        this.oacAwbs = oacAwbs;
    }
}//Close GroundDetailsTableVO
