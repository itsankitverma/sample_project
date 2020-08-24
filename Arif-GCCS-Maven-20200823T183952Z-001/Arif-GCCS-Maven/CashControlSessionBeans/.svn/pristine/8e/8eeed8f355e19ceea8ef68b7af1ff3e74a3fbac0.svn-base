package com.fedex.lacitd.cashcontrol.biztier.common;

/**
 * Created by IntelliJ IDEA.
 * User: arturog
 * Date: 23-06-2005
 * Time: 01:00:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroundDetailsTableVO implements java.io.Serializable {

    /**
     * Holds value of property prepaidId.
     */
    private int groundId;

    private boolean selected;

    /**
     * Holds value of property custNm.
     */
    private String custNm;

    //added to add the two columns miscDate, miscNbr
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
     * Holds value of property awbDate.
     */
    private java.util.Date trackDate;

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
    private String groundTrackNumber;

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

    public GroundDetailsTableVO() {
    }

    public boolean isModified() {
        if (getOtherDocNumber() == null) {
            if (getOtherDocNumberPrev() != null) return true;
        } else {
            if (!getOtherDocNumber().equals(getOtherDocNumberPrev())) return true;
        }

        if (getCustNm() == null) {
            if (getCustNmPrev() != null) return true;
        } else {
            if (!getCustNm().equals(getCustNmPrev())) return true;
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
        
        if (getBillAccount() == null) {
            if (getBillAccountPrev() != null) return true;
        } else {
            if (!getBillAccount().equals(getBillAccountPrev())) return true;
        }
        
        return (getCouponPayment() != getCouponPaymentPrev() || getCashPayment() != getCashPaymentPrev() || getOtherPaymentType() != getOtherPaymentTypePrev() || getOtherPayment() != getOtherPaymentPrev() || getStatusId() != getStatusIdPrev());
    }


    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getCustNmPrev() {
        return custNmPrev;
    }

    public void setCustNmPrev(String custNmPrev) {
        this.custNmPrev = custNmPrev;
    }

    private String custNmPrev;

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

    public int getGroundId() {
        return groundId;
    }

    public void setGroundId(int groundId) {
        this.groundId = groundId;
    }

    public java.util.Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(java.util.Date trackDate) {
        this.trackDate = trackDate;
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

    public String getGroundTrackNumber() {
        return groundTrackNumber;
    }

    public void setGroundTrackNumber(String groundTrackNumber) {
        this.groundTrackNumber = groundTrackNumber;
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

    public double getCouponPayment() {
        return couponPayment;
    }

    public void setCouponPayment(double couponPayment) {
        this.couponPayment = couponPayment;
    }

    public double getCouponPaymentPrev() {
        return couponPaymentPrev;
    }

    public void setCouponPaymentPrev(double couponPaymentPrev) {
        this.couponPaymentPrev = couponPaymentPrev;
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
}//Close GroundDetailsTableVO
