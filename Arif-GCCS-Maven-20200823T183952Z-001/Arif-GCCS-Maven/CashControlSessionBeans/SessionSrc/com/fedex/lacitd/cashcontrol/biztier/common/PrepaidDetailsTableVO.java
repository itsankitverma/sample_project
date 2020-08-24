/*
 * EmployeeProfile.java
 * @author  ccardenas
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

public class PrepaidDetailsTableVO implements java.io.Serializable {

    /**
     * Holds value of property prepaidId.
     */
    private int prepaidId;

    private boolean selected;
    
    private String miscDate;
    
    public String getMiscDate() {
		return miscDate;
	}

	public void setMiscDate(String miscDate) {
		this.miscDate = miscDate;
	}

	public String getMiscNbr() {
		return miscNbr;
	}

	public void setMiscNbr(String miscNbr) {
		this.miscNbr = miscNbr;
	}

	private String miscNbr;

    /**
     * Holds value of property customerNm.
     */
    private String customerNm;

    /**
     * Holds value of property awbDate.
     */
    private java.util.Date awbDate;

    /**
     * Holds value of property scanAmount.
     */
    private double scanAmount;

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
     * Holds value of property recAwbNumber.
     */
    private String recAwbNumber;

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
     * Holds value of property couponPayment.
     */
    private double couponPayment;

    /**
     * Holds value of property couponPaymentPrev.
     */
    private double couponPaymentPrev;

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

    private String employeeNm;

    private String courierId;

    private String billAccount;
    
    private String billAccountPrev;
    
    public PrepaidDetailsTableVO() {
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
     * Getter for property awbDate.
     *
     * @return Value of property awbDate.
     */
    public java.util.Date getAwbDate() {
        return this.awbDate;
    }

    /**
     * Setter for property awbDate.
     *
     * @param awbDate New value of property awbDate.
     */
    public void setAwbDate(java.util.Date awbDate) {
        this.awbDate = awbDate;
    }

    /**
     * Getter for property scanAmount.
     *
     * @return Value of property scanAmount.
     */
    public double getScanAmount() {
        return this.scanAmount;
    }

    /**
     * Setter for property scanAmount.
     *
     * @param scanAmount New value of property scanAmount.
     */
    public void setScanAmount(double scanAmount) {
        this.scanAmount = scanAmount;
    }

    /**
     * Getter for property cashPayment.
     *
     * @return Value of property cashPayment.
     */
    public double getCashPayment() {
        return this.cashPayment;
    }

    /**
     * Setter for property cashPayment.
     *
     * @param cashPayment New value of property cashPayment.
     */
    public void setCashPayment(double cashPayment) {
        this.cashPayment = cashPayment;
    }

    /**
     * Getter for property otherPayment.
     *
     * @return Value of property otherPayment.
     */
    public double getOtherPayment() {
        return this.otherPayment;
    }

    /**
     * Setter for property otherPayment.
     *
     * @param otherPayment New value of property otherPayment.
     */
    public void setOtherPayment(double otherPayment) {
        this.otherPayment = otherPayment;
    }

    /**
     * Getter for property recCheckNumber.
     *
     * @return Value of property recCheckNumber.
     */
    public String getOtherDocNumber() {
        return this.otherDocNumber;
    }

    /**
     * Setter for property recCheckNumber.
     *
     * @param recCheckNumber New value of property recCheckNumber.
     */
    public void setOtherDocNumber(String otherDocNumber) {
        this.otherDocNumber = otherDocNumber;
    }

    /**
     * Getter for property comment.
     *
     * @return Value of property comment.
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Setter for property comment.
     *
     * @param comment New value of property comment.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter for property statusId.
     *
     * @return Value of property statusId.
     */
    public int getStatusId() {
        return this.statusId;
    }

    /**
     * Setter for property statusId.
     *
     * @param statusId New value of property statusId.
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    /**
     * Getter for property recAwbNumber.
     *
     * @return Value of property recAwbNumber.
     */
    public String getAwbNumber() {
        return this.recAwbNumber;
    }

    /**
     * Setter for property recAwbNumber.
     *
     * @param recAwbNumber New value of property recAwbNumber.
     */
    public void setAwbNumber(String recAwbNumber) {
        this.recAwbNumber = recAwbNumber;
    }

    /**
     * Getter for property recCheckInCashPrev.
     *
     * @return Value of property recCheckInCashPrev.
     */
    public double getCashPaymentPrev() {
        return this.cashPaymentPrev;
    }

    /**
     * Setter for property recCheckInCashPrev.
     *
     * @param recCheckInCashPrev New value of property recCheckInCashPrev.
     */
    public void setCashPaymentPrev(double cashPaymentPrev) {
        this.cashPaymentPrev = cashPaymentPrev;
    }

    /**
     * Getter for property recCheckNumberPrev.
     *
     * @return Value of property recCheckNumberPrev.
     */
    public String getOtherDocNumberPrev() {
        return this.otherDocNumberPrev;
    }

    /**
     * Setter for property recCheckNumberPrev.
     *
     * @param recCheckNumberPrev New value of property recCheckNumberPrev.
     */
    public void setOtherDocNumberPrev(String otherDocNumberPrev) {
        this.otherDocNumberPrev = otherDocNumberPrev;
    }

    /**
     * Getter for property otherPaymentPrev.
     *
     * @return Value of property otherPaymentPrev.
     */
    public double getOtherPaymentPrev() {
        return this.otherPaymentPrev;
    }

    /**
     * Setter for property otherPaymentPrev.
     *
     * @param otherPaymentPrev New value of property otherPaymentPrev.
     */
    public void setOtherPaymentPrev(double otherPaymentPrev) {
        this.otherPaymentPrev = otherPaymentPrev;
    }

    /**
     * Getter for property commentPrev.
     *
     * @return Value of property commentPrev.
     */
    public String getCommentPrev() {
        return this.commentPrev;
    }

    /**
     * Setter for property commentPrev.
     *
     * @param commentPrev New value of property commentPrev.
     */
    public void setCommentPrev(String commentPrev) {
        this.commentPrev = commentPrev;
    }

    /**
     * Getter for property statusIdPrev.
     *
     * @return Value of property statusIdPrev.
     */
    public int getStatusIdPrev() {
        return this.statusIdPrev;
    }

    /**
     * Setter for property statusIdPrev.
     *
     * @param statusIdPrev New value of property statusIdPrev.
     */
    public void setStatusIdPrev(int statusIdPrev) {
        this.statusIdPrev = statusIdPrev;
    }

    public boolean isModified() {
        if (otherDocNumber == null) {
            if (otherDocNumberPrev != null) return true;
        } else {
            if (!otherDocNumber.equals(otherDocNumberPrev)) return true;
        }

        if (rcptNbr == null) {
            if (rcptNbrPrev != null) return true;
        } else {
            if (!rcptNbr.equals(rcptNbrPrev)) return true;
        }

        if (comment == null) {
            if (commentPrev != null) return true;
        } else {
            if (!comment.equals(commentPrev)) return true;
        }

        if (otherComment == null) {
            if (otherCommentPrev != null) return true;
        } else {
            if (!otherComment.equals(otherCommentPrev)) return true;
        }
        
        if (billAccount == null) {
            if (billAccountPrev != null) return true;
        } else {
            if (!billAccount.equals(billAccountPrev)) return true;
        }
        
        return (couponPayment != couponPaymentPrev || cashPayment != cashPaymentPrev || otherPaymentType != otherPaymentTypePrev || otherPayment != otherPaymentPrev || statusId != statusIdPrev);
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
     * Getter for property otherPaymentTypePrev.
     *
     * @return Value of property otherPaymentTypePrev.
     */
    public int getOtherPaymentTypePrev() {
        return this.otherPaymentTypePrev;
    }

    /**
     * Setter for property otherPaymentTypePrev.
     *
     * @param otherPaymentTypePrev New value of property otherPaymentTypePrev.
     */
    public void setOtherPaymentTypePrev(int otherPaymentTypePrev) {
        this.otherPaymentTypePrev = otherPaymentTypePrev;
    }

    /**
     * Getter for property couponPayment.
     *
     * @return Value of property couponPayment.
     */
    public double getCouponPayment() {
        return this.couponPayment;
    }

    /**
     * Setter for property couponPayment.
     *
     * @param couponPayment New value of property couponPayment.
     */
    public void setCouponPayment(double couponPayment) {
        this.couponPayment = couponPayment;
    }

    /**
     * Getter for property couponPaymentPrev.
     *
     * @return Value of property couponPaymentPrev.
     */
    public double getCouponPaymentPrev() {
        return this.couponPaymentPrev;
    }

    /**
     * Setter for property couponPaymentPrev.
     *
     * @param couponPaymentPrev New value of property couponPaymentPrev.
     */
    public void setCouponPaymentPrev(double couponPaymentPrev) {
        this.couponPaymentPrev = couponPaymentPrev;
    }

    /**
     * Getter for property exchRate.
     *
     * @return Value of property exchRate.
     */
    public double getExchRate() {
        return this.exchRate;
    }

    /**
     * Setter for property exchRate.
     *
     * @param exchRate New value of property exchRate.
     */
    public void setExchRate(double exchRate) {
        this.exchRate = exchRate;
    }

    /**
     * Getter for property chngStatusDate.
     *
     * @return Value of property chngStatusDate.
     */
    public java.util.Date getChngStatusDate() {
        return this.chngStatusDate;
    }

    /**
     * Setter for property chngStatusDate.
     *
     * @param chngStatusDate New value of property chngStatusDate.
     */
    public void setChngStatusDate(java.util.Date chngStatusDate) {
        this.chngStatusDate = chngStatusDate;
    }

    /**
     * Getter for property chngStatusEmployeeId.
     *
     * @return Value of property chngStatusEmployeeId.
     */
    public String getChngStatusEmployeeId() {
        return this.chngStatusEmployeeId;
    }

    /**
     * Setter for property chngStatusEmployeeId.
     *
     * @param chngStatusEmployeeId New value of property chngStatusEmployeeId.
     */
    public void setChngStatusEmployeeId(String chngStatusEmployeeId) {
        this.chngStatusEmployeeId = chngStatusEmployeeId;
    }

    /**
     * Getter for property otherComment.
     *
     * @return Value of property otherComment.
     */
    public String getOtherComment() {
        return this.otherComment;
    }

    /**
     * Setter for property otherComment.
     *
     * @param otherComment New value of property otherComment.
     */
    public void setOtherComment(String otherComment) {
        this.otherComment = otherComment;
    }

    /**
     * Getter for property otherCommentPrev.
     *
     * @return Value of property otherCommentPrev.
     */
    public String getOtherCommentPrev() {
        return this.otherCommentPrev;
    }

    /**
     * Setter for property otherCommentPrev.
     *
     * @param otherCommentPrev New value of property otherCommentPrev.
     */
    public void setOtherCommentPrev(String otherCommentPrev) {
        this.otherCommentPrev = otherCommentPrev;
    }

    private double surChargesTotal;

    /**
     * @return Returns the surChargesTotal.
     */
    public double getSurChargesTotal() {
        return surChargesTotal;
    }

    /**
     * @param surChargesTotal The surChargesTotal to set.
     */
    public void setSurChargesTotal(double surChargesTotal) {
        this.surChargesTotal = surChargesTotal;
    }

    /**
     * @return Returns the rcptChngEmpId.
     */
    public String getRcptChngEmpId() {
        return rcptChngEmpId;
    }

    /**
     * @param rcptChngEmpId The rcptChngEmpId to set.
     */
    public void setRcptChngEmpId(String rcptChngEmpId) {
        this.rcptChngEmpId = rcptChngEmpId;
    }

    /**
     * @return Returns the rcptNbr.
     */
    public String getRcptNbr() {
        return rcptNbr;
    }

    /**
     * @param rcptNbr The rcptNbr to set.
     */
    public void setRcptNbr(String rcptNbr) {
        this.rcptNbr = rcptNbr;
    }

    /**
     * @return Returns the rcptNbrPrev.
     */
    public String getRcptNbrPrev() {
        return rcptNbrPrev;
    }

    /**
     * @param rcptNbrPrev The rcptNbrPrev to set.
     */
    public void setRcptNbrPrev(String rcptNbrPrev) {
        this.rcptNbrPrev = rcptNbrPrev;
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

    public void setEmployeeNm(String employeeNm) {
        this.employeeNm = employeeNm;
    }

    public String getEmployeeNm() {
        return employeeNm;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }
    
    public String getBillAccount() {
        return billAccount;
    }

    public void setBillAccount(String billAccount) {
        this.billAccount = billAccount;
    }
    
    public String getBillAccountPrev() {
        return billAccountPrev;
    }

    public void setBillAccountPrev(String billAccountPrev) {
        this.billAccountPrev = billAccountPrev;
    }
}
