/*
 * EmployeeProfile.java
 * @author  ccardenas
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.PrepaidVO;

public class PrepaidScansVO implements java.io.Serializable {

    /**
     * Holds value of property prepaidVO.
     */
    private PrepaidVO prepaidVO;

    /**
     * Holds value of property lastScanSeqNbr.
     */
    private String lastScanSeqNbr = "0";

    /**
     * Holds value of property cosmosScans.
     */
    private java.util.Collection cosmosScans;

    /**
     * Holds value of property awbNbr.
     */
    private String awbNbr;

    public PrepaidScansVO() {
    }

    /**
     * Getter for property prepaidVO.
     *
     * @return Value of property prepaidVO.
     */
    public PrepaidVO getPrepaidVO() {
        return this.prepaidVO;
    }

    /**
     * Setter for property prepaidVO.
     *
     * @param prepaidVO New value of property prepaidVO.
     */
    public void setPrepaidVO(PrepaidVO prepaidVO) {
        this.prepaidVO = prepaidVO;
    }

    /**
     * Getter for property lastScanSeqNbr.
     *
     * @return Value of property lastScanSeqNbr.
     */
    public String getLastScanSeqNbr() {
        return this.lastScanSeqNbr;
    }

    /**
     * Setter for property lastScanSeqNbr.
     *
     * @param lastScanSeqNbr New value of property lastScanSeqNbr.
     */
    public void setLastScanSeqNbr(String lastScanSeqNbr) {
        this.lastScanSeqNbr = lastScanSeqNbr;
    }

    /**
     * Getter for property cosmosScans.
     *
     * @return Value of property cosmosScans.
     */
    public java.util.Collection getCosmosScans() {
        return this.cosmosScans;
    }

    /**
     * Setter for property cosmosScans.
     *
     * @param cosmosScans New value of property cosmosScans.
     */
    public void setCosmosScans(java.util.Collection cosmosScans) {
        this.cosmosScans = cosmosScans;
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
        if (prepaidVO == null) prepaidVO = new PrepaidVO();
        prepaidVO.setAwbNbr(awbNbr);
    }

}
