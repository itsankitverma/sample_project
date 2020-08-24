/*
 * EmployeeProfile.java
 * @author  ccardenas
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaDetailVO;

public class PoaDetailSurchargesVO implements java.io.Serializable {

    /**
     * Holds value of property prepaidVO.
     */
    private double usdAmount;
    private double surChargesTotal;
    private PoaDetailVO poaDetail = new PoaDetailVO();

    /**
     * @return Returns the poaDetail.
     */
    public PoaDetailVO getPoaDetail() {
        return poaDetail;
    }

    /**
     * @param poaDetail The poaDetail to set.
     */
    public void setPoaDetail(PoaDetailVO poaDetail) {
        this.poaDetail = poaDetail;
    }

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
     * @return Returns the usdAmount.
     */
    public double getUsdAmount() {
        return usdAmount;
    }

    /**
     * @param usdAmount The usdAmount to set.
     */
    public void setUsdAmount(double usdAmount) {
        this.usdAmount = usdAmount;
    }

}
