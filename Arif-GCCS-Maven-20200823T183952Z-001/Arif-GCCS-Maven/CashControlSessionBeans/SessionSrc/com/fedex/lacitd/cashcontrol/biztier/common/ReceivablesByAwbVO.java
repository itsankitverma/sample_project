/*
 * EmployeeProfile.java
 * @author  ccardenas
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

public class ReceivablesByAwbVO implements java.io.Serializable {

    private boolean selected;

    /**
     * Holds value of property recPk.
     */
    private int recPk;

    /**
     * Holds value of property recCustomerName.
     */
    private String recCustomerName;

    /**
     * Holds value of property recAwbNumber.
     */
    private String recAwbNumber;

    /**
     * Holds value of property recNumber.
     */
    private String recNumber;

    /**
     * Holds value of property recDate.
     */
    private java.util.Date recDate;

    /**
     * Holds value of property recAmount.
     */
    private String recAmount;

    /**
     * Holds value of property statusId.
     */
    private int statusId;

    /**
     * Holds value of property statusDesc.
     */
    private String statusDesc;
    private String locCd;

    public ReceivablesByAwbVO() {
    }

    /**
     * Getter for property recPk.
     *
     * @return Value of property recPk.
     */
    public int getRecId() {
        return this.recPk;
    }

    /**
     * Setter for property recPk.
     *
     * @param recPk New value of property recPk.
     */
    public void setRecId(int recPk) {
        this.recPk = recPk;
    }

    /**
     * Getter for property recCustomerName.
     *
     * @return Value of property recCustomerName.
     */
    public String getRecCustomerName() {
        return this.recCustomerName;
    }

    /**
     * Setter for property recCustomerName.
     *
     * @param recCustomerName New value of property recCustomerName.
     */
    public void setRecCustomerName(String recCustomerName) {
        this.recCustomerName = recCustomerName;
    }

    /**
     * Getter for property recAwbNumber.
     *
     * @return Value of property recAwbNumber.
     */
    public String getRecAwbNumber() {
        return this.recAwbNumber;
    }

    /**
     * Setter for property recAwbNumber.
     *
     * @param recAwbNumber New value of property recAwbNumber.
     */
    public void setRecAwbNumber(String recAwbNumber) {
        this.recAwbNumber = recAwbNumber;
    }

    /**
     * Getter for property recNumber.
     *
     * @return Value of property recNumber.
     */
    public String getRecNumber() {
        return this.recNumber;
    }

    /**
     * Setter for property recNumber.
     *
     * @param recNumber New value of property recNumber.
     */
    public void setRecNumber(String recNumber) {
        this.recNumber = recNumber;
    }

    /**
     * Getter for property recDate.
     *
     * @return Value of property recDate.
     */
    public java.util.Date getRecDate() {
        return this.recDate;
    }

    /**
     * Setter for property recDate.
     *
     * @param recDate New value of property recDate.
     */
    public void setRecDate(java.util.Date recDate) {
        this.recDate = recDate;
    }

    /**
     * Getter for property recAmount.
     *
     * @return Value of property recAmount.
     */
    public String getRecAmount() {
        return this.recAmount;
    }

    /**
     * Setter for property recAmount.
     *
     * @param recAmount New value of property recAmount.
     */
    public void setRecAmount(String recAmount) {
        this.recAmount = recAmount;
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
     * Getter for property statusDesc.
     *
     * @return Value of property statusDesc.
     */
    public String getStatusDesc() {
        return this.statusDesc;
    }

    /**
     * Setter for property statusDesc.
     *
     * @param statusDesc New value of property statusDesc.
     */
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    public String getLocCd() {
        return this.locCd;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
