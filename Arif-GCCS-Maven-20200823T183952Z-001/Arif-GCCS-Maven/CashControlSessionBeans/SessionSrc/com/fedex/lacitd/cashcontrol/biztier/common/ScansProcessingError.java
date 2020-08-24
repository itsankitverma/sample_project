/*
 * EmployeeProfile.java
 * @author  ccardenas
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

public class ScansProcessingError implements java.io.Serializable {

    /**
     * Holds value of property awbNumber.
     */
    private String awbNumber;

    /**
     * Holds value of property errorMessage.
     */
    private String errorMessage;

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    /**
     * Holds value of property errorMessage.
     */
    private String errorDetails;

    /**
     * Holds value of property arg0.
     */
    private String arg0;

    /**
     * Holds value of property arg1.
     */
    private String arg1;

    private String arg2;

    private boolean prepaid;

    public ScansProcessingError() {
    }

    public ScansProcessingError(String awbNumber, String errorMessage, String errorDetails, String arg0, String arg1, String arg2) {
        this.arg0 = arg0;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.awbNumber = awbNumber;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }

    /**
     * Getter for property awbNumber.
     *
     * @return Value of property awbNumber.
     */
    public String getAwbNumber() {
        return this.awbNumber;
    }

    /**
     * Setter for property awbNumber.
     *
     * @param awbNumber New value of property awbNumber.
     */
    public void setAwbNumber(String awbNumber) {
        this.awbNumber = awbNumber;
    }

    /**
     * Getter for property errorMessage.
     *
     * @return Value of property errorMessage.
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Setter for property errorMessage.
     *
     * @param errorMessage New value of property errorMessage.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Getter for property arg0.
     *
     * @return Value of property arg0.
     */
    public String getArg0() {
        return this.arg0;
    }

    /**
     * Setter for property arg0.
     *
     * @param arg0 New value of property arg0.
     */
    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    /**
     * Getter for property arg1.
     *
     * @return Value of property arg1.
     */
    public String getArg1() {
        return this.arg1;
    }

    /**
     * Setter for property arg1.
     *
     * @param arg1 New value of property arg1.
     */
    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    /**
     * Getter for property arg2.
     *
     * @return Value of property arg2.
     */
    public String getArg2() {
        return this.arg2;
    }

    /**
     * Setter for property arg2.
     *
     * @param arg2 New value of property arg2.
     */
    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    /**
     * @return Returns the prepaid.
     */
    public boolean isPrepaid() {
        return prepaid;
    }

    /**
     * @param prepaid The prepaid to set.
     */
    public void setPrepaid(boolean prepaid) {
        this.prepaid = prepaid;
    }
}
