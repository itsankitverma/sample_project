/**
 * @(#)PrepaidBean.java			Tue Aug 02 15:38:49 VET 2005
 * 
 * FedEx
 * Cash Control
 * 
 * FedEx
 * Santiago, Chile
 * 
 * Copyright (c) 2001 FedEx, All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of FedEx. ("Confidential Information").
 * 
 * Visit our website at http://www.fedex.com for more information
 * 
 * This bean map to the prepaid table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;

import javax.ejb.*;

public abstract class PrepaidBean implements EntityBean {

    private EntityContext _ctx;
    public PrepaidBean() {
    }
    /**
     * Set the value of prepaidId
     * @param prepaidId - Integer of prepaidId
     */
    public abstract void setPrepaidId(Integer prepaidId);

    
    //added to add the two new columns miscDate, miscNbr
	public abstract Date getMiscDate();
	public abstract void setMiscDate(Date miscDate) ;
	public abstract String getMiscNbr();
	public abstract void setMiscNbr(String miscNbr);
    
    /**
     * Get the value of prepaidId
     * @return prepaidId - Integer of prepaidId
     */
    public abstract Integer getPrepaidId();

    /**
     * Set the value of customerNm
     * @param customerNm - String of customerNm
     */
    public abstract void setCustomerNm(String customerNm);

    /**
     * Get the value of customerNm
     * @return customerNm - String of customerNm
     */
    public abstract String getCustomerNm();

    /**
     * Set the value of awbDt
     * @param awbDt - Date of awbDt
     */
    public abstract void setAwbDt(Date awbDt);

    /**
     * Get the value of awbDt
     * @return awbDt - Date of awbDt
     */
    public abstract Date getAwbDt();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public abstract void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public abstract String getLocationCd();

    /**
     * Set the value of awbNbr
     * @param awbNbr - String of awbNbr
     */
    public abstract void setAwbNbr(String awbNbr);

    /**
     * Get the value of awbNbr
     * @return awbNbr - String of awbNbr
     */
    public abstract String getAwbNbr();

    /**
     * Set the value of tinUniqId
     * @param tinUniqId - String of tinUniqId
     */
    public abstract void setTinUniqId(String tinUniqId);

    /**
     * Get the value of tinUniqId
     * @return tinUniqId - String of tinUniqId
     */
    public abstract String getTinUniqId();

    /**
     * Set the value of paymentCurrency
     * @param paymentCurrency - String of paymentCurrency
     */
    public abstract void setPaymentCurrency(String paymentCurrency);

    /**
     * Get the value of paymentCurrency
     * @return paymentCurrency - String of paymentCurrency
     */
    public abstract String getPaymentCurrency();

    /**
     * Set the value of cashPaymentAmt
     * @param cashPaymentAmt - double of cashPaymentAmt
     */
    public abstract void setCashPaymentAmt(double cashPaymentAmt);

    /**
     * Get the value of cashPaymentAmt
     * @return cashPaymentAmt - double of cashPaymentAmt
     */
    public abstract double getCashPaymentAmt();

    /**
     * Set the value of otherPaymentAmt
     * @param otherPaymentAmt - double of otherPaymentAmt
     */
    public abstract void setOtherPaymentAmt(double otherPaymentAmt);

    /**
     * Get the value of otherPaymentAmt
     * @return otherPaymentAmt - double of otherPaymentAmt
     */
    public abstract double getOtherPaymentAmt();

    /**
     * Set the value of otherPaymentType
     * @param otherPaymentType - int of otherPaymentType
     */
    public abstract void setOtherPaymentType(int otherPaymentType);

    /**
     * Get the value of otherPaymentType
     * @return otherPaymentType - int of otherPaymentType
     */
    public abstract int getOtherPaymentType();

    /**
     * Set the value of otherDocNbr
     * @param otherDocNbr - String of otherDocNbr
     */
    public abstract void setOtherDocNbr(String otherDocNbr);

    /**
     * Get the value of otherDocNbr
     * @return otherDocNbr - String of otherDocNbr
     */
    public abstract String getOtherDocNbr();

    /**
     * Set the value of coupPymtAmt
     * @param coupPymtAmt - double of coupPymtAmt
     */
    public abstract void setCoupPymtAmt(double coupPymtAmt);

    /**
     * Get the value of coupPymtAmt
     * @return coupPymtAmt - double of coupPymtAmt
     */
    public abstract double getCoupPymtAmt();

    /**
     * Set the value of pux16CashPayment
     * @param pux16CashPayment - double of pux16CashPayment
     */
    public abstract void setPux16CashPayment(double pux16CashPayment);

    /**
     * Get the value of pux16CashPayment
     * @return pux16CashPayment - double of pux16CashPayment
     */
    public abstract double getPux16CashPayment();

    /**
     * Set the value of pux16FreightAmt
     * @param pux16FreightAmt - double of pux16FreightAmt
     */
    public abstract void setPux16FreightAmt(double pux16FreightAmt);

    /**
     * Get the value of pux16FreightAmt
     * @return pux16FreightAmt - double of pux16FreightAmt
     */
    public abstract double getPux16FreightAmt();

    /**
     * Set the value of pux16OtherPaymentAmt
     * @param pux16OtherPaymentAmt - double of pux16OtherPaymentAmt
     */
    public abstract void setPux16OtherPaymentAmt(double pux16OtherPaymentAmt);

    /**
     * Get the value of pux16OtherPaymentAmt
     * @return pux16OtherPaymentAmt - double of pux16OtherPaymentAmt
     */
    public abstract double getPux16OtherPaymentAmt();

    /**
     * Set the value of pux16OtherDocNbr
     * @param pux16OtherDocNbr - String of pux16OtherDocNbr
     */
    public abstract void setPux16OtherDocNbr(String pux16OtherDocNbr);

    /**
     * Get the value of pux16OtherDocNbr
     * @return pux16OtherDocNbr - String of pux16OtherDocNbr
     */
    public abstract String getPux16OtherDocNbr();

    /**
     * Set the value of pux16CoupPymtAmt
     * @param pux16CoupPymtAmt - double of pux16CoupPymtAmt
     */
    public abstract void setPux16CoupPymtAmt(double pux16CoupPymtAmt);

    /**
     * Get the value of pux16CoupPymtAmt
     * @return pux16CoupPymtAmt - double of pux16CoupPymtAmt
     */
    public abstract double getPux16CoupPymtAmt();

    /**
     * Set the value of pux16ScanSeqNbr
     * @param pux16ScanSeqNbr - String of pux16ScanSeqNbr
     */
    public abstract void setPux16ScanSeqNbr(String pux16ScanSeqNbr);

    /**
     * Get the value of pux16ScanSeqNbr
     * @return pux16ScanSeqNbr - String of pux16ScanSeqNbr
     */
    public abstract String getPux16ScanSeqNbr();

    /**
     * Set the value of chngStatusEmployeeId
     * @param chngStatusEmployeeId - String of chngStatusEmployeeId
     */
    public abstract void setChngStatusEmployeeId(String chngStatusEmployeeId);

    /**
     * Get the value of chngStatusEmployeeId
     * @return chngStatusEmployeeId - String of chngStatusEmployeeId
     */
    public abstract String getChngStatusEmployeeId();

    /**
     * Set the value of chngStatusDt
     * @param chngStatusDt - Date of chngStatusDt
     */
    public abstract void setChngStatusDt(Date chngStatusDt);

    /**
     * Get the value of chngStatusDt
     * @return chngStatusDt - Date of chngStatusDt
     */
    public abstract Date getChngStatusDt();

    /**
     * Set the value of closeEmployeeId
     * @param closeEmployeeId - String of closeEmployeeId
     */
    public abstract void setCloseEmployeeId(String closeEmployeeId);

    /**
     * Get the value of closeEmployeeId
     * @return closeEmployeeId - String of closeEmployeeId
     */
    public abstract String getCloseEmployeeId();

    /**
     * Set the value of closeDt
     * @param closeDt - Date of closeDt
     */
    public abstract void setCloseDt(Date closeDt);

    /**
     * Get the value of closeDt
     * @return closeDt - Date of closeDt
     */
    public abstract Date getCloseDt();

    /**
     * Set the value of eodEmployeeId
     * @param eodEmployeeId - String of eodEmployeeId
     */
    public abstract void setEodEmployeeId(String eodEmployeeId);

    /**
     * Get the value of eodEmployeeId
     * @return eodEmployeeId - String of eodEmployeeId
     */
    public abstract String getEodEmployeeId();

    /**
     * Set the value of eodDt
     * @param eodDt - Date of eodDt
     */
    public abstract void setEodDt(Date eodDt);

    /**
     * Get the value of eodDt
     * @return eodDt - Date of eodDt
     */
    public abstract Date getEodDt();

    /**
     * Set the value of lastScanType
     * @param lastScanType - String of lastScanType
     */
    public abstract void setLastScanType(String lastScanType);

    /**
     * Get the value of lastScanType
     * @return lastScanType - String of lastScanType
     */
    public abstract String getLastScanType();

    /**
     * Set the value of lastScanDate
     * @param lastScanDate - Date of lastScanDate
     */
    public abstract void setLastScanDate(Date lastScanDate);

    /**
     * Get the value of lastScanDate
     * @return lastScanDate - Date of lastScanDate
     */
    public abstract Date getLastScanDate();

    /**
     * Set the value of chkinAgentComment
     * @param chkinAgentComment - String of chkinAgentComment
     */
    public abstract void setChkinAgentComment(String chkinAgentComment);

    /**
     * Get the value of chkinAgentComment
     * @return chkinAgentComment - String of chkinAgentComment
     */
    public abstract String getChkinAgentComment();

    /**
     * Set the value of statusId
     * @param statusId - int of statusId
     */
    public abstract void setStatusId(int statusId);

    /**
     * Get the value of statusId
     * @return statusId - int of statusId
     */
    public abstract int getStatusId();

    /**
     * Set the value of cashDepositSlipId
     * @param cashDepositSlipId - int of cashDepositSlipId
     */
    public abstract void setCashDepositSlipId(int cashDepositSlipId);

    /**
     * Get the value of cashDepositSlipId
     * @return cashDepositSlipId - int of cashDepositSlipId
     */
    public abstract int getCashDepositSlipId();

    /**
     * Set the value of cashDepositSlipNbr
     * @param cashDepositSlipNbr - String of cashDepositSlipNbr
     */
    public abstract void setCashDepositSlipNbr(String cashDepositSlipNbr);

    /**
     * Get the value of cashDepositSlipNbr
     * @return cashDepositSlipNbr - String of cashDepositSlipNbr
     */
    public abstract String getCashDepositSlipNbr();

    /**
     * Set the value of otherDepositSlipId
     * @param otherDepositSlipId - int of otherDepositSlipId
     */
    public abstract void setOtherDepositSlipId(int otherDepositSlipId);

    /**
     * Get the value of otherDepositSlipId
     * @return otherDepositSlipId - int of otherDepositSlipId
     */
    public abstract int getOtherDepositSlipId();

    /**
     * Set the value of otherDepositSlipNbr
     * @param otherDepositSlipNbr - String of otherDepositSlipNbr
     */
    public abstract void setOtherDepositSlipNbr(String otherDepositSlipNbr);

    /**
     * Get the value of otherDepositSlipNbr
     * @return otherDepositSlipNbr - String of otherDepositSlipNbr
     */
    public abstract String getOtherDepositSlipNbr();

    /**
     * Set the value of freightAmtInVisa
     * @param freightAmtInVisa - double of freightAmtInVisa
     */
    public abstract void setFreightAmtInVisa(double freightAmtInVisa);

    /**
     * Get the value of freightAmtInVisa
     * @return freightAmtInVisa - double of freightAmtInVisa
     */
    public abstract double getFreightAmtInVisa();

    /**
     * Set the value of visaMnfstDt
     * @param visaMnfstDt - Date of visaMnfstDt
     */
    public abstract void setVisaMnfstDt(Date visaMnfstDt);

    /**
     * Get the value of visaMnfstDt
     * @return visaMnfstDt - Date of visaMnfstDt
     */
    public abstract Date getVisaMnfstDt();

    /**
     * Set the value of visaMnfstEmpId
     * @param visaMnfstEmpId - String of visaMnfstEmpId
     */
    public abstract void setVisaMnfstEmpId(String visaMnfstEmpId);

    /**
     * Get the value of visaMnfstEmpId
     * @return visaMnfstEmpId - String of visaMnfstEmpId
     */
    public abstract String getVisaMnfstEmpId();

    /**
     * Set the value of exchRate
     * @param exchRate - double of exchRate
     */
    public abstract void setExchRate(double exchRate);

    /**
     * Get the value of exchRate
     * @return exchRate - double of exchRate
     */
    public abstract double getExchRate();

    /**
     * Set the value of courierId
     * @param courierId - String of courierId
     */
    public abstract void setCourierId(String courierId);

    /**
     * Get the value of courierId
     * @return courierId - String of courierId
     */
    public abstract String getCourierId();

    /**
     * Set the value of product
     * @param product - int of product
     */
    public abstract void setProduct(int product);

    /**
     * Get the value of product
     * @return product - int of product
     */
    public abstract int getProduct();

    /**
     * Set the value of numberPkgs
     * @param numberPkgs - int of numberPkgs
     */
    public abstract void setNumberPkgs(int numberPkgs);

    /**
     * Get the value of numberPkgs
     * @return numberPkgs - int of numberPkgs
     */
    public abstract int getNumberPkgs();

    /**
     * Set the value of weight
     * @param weight - double of weight
     */
    public abstract void setWeight(double weight);

    /**
     * Get the value of weight
     * @return weight - double of weight
     */
    public abstract double getWeight();

    /**
     * Set the value of creditCardBatchId
     * @param creditCardBatchId - String of creditCardBatchId
     */
    public abstract void setCreditCardBatchId(String creditCardBatchId);

    /**
     * Get the value of creditCardBatchId
     * @return creditCardBatchId - String of creditCardBatchId
     */
    public abstract String getCreditCardBatchId();

    /**
     * Set the value of eodId
     * @param eodId - int of eodId
     */
    public abstract void setEodId(int eodId);

    /**
     * Get the value of eodId
     * @return eodId - int of eodId
     */
    public abstract int getEodId();

    /**
     * Set the value of couponBatchId
     * @param couponBatchId - int of couponBatchId
     */
    public abstract void setCouponBatchId(int couponBatchId);

    /**
     * Get the value of couponBatchId
     * @return couponBatchId - int of couponBatchId
     */
    public abstract int getCouponBatchId();

    /**
     * Set the value of pymtImpDt
     * @param pymtImpDt - Date of pymtImpDt
     */
    public abstract void setPymtImpDt(Date pymtImpDt);

    /**
     * Get the value of pymtImpDt
     * @return pymtImpDt - Date of pymtImpDt
     */
    public abstract Date getPymtImpDt();

    /**
     * Set the value of otherComment
     * @param otherComment - String of otherComment
     */
    public abstract void setOtherComment(String otherComment);

    /**
     * Get the value of otherComment
     * @return otherComment - String of otherComment
     */
    public abstract String getOtherComment();

    /**
     * Set the value of rcptNbr
     * @param rcptNbr - String of rcptNbr
     */
    public abstract void setRcptNbr(String rcptNbr);

    /**
     * Get the value of rcptNbr
     * @return rcptNbr - String of rcptNbr
     */
    public abstract String getRcptNbr();

    /**
     * Set the value of origRcptNbr
     * @param origRcptNbr - String of origRcptNbr
     */
    public abstract void setOrigRcptNbr(String origRcptNbr);

    /**
     * Get the value of origRcptNbr
     * @return origRcptNbr - String of origRcptNbr
     */
    public abstract String getOrigRcptNbr();

    /**
     * Set the value of rcptChngEmpId
     * @param rcptChngEmpId - String of rcptChngEmpId
     */
    public abstract void setRcptChngEmpId(String rcptChngEmpId);

    /**
     * Get the value of rcptChngEmpId
     * @return rcptChngEmpId - String of rcptChngEmpId
     */
    public abstract String getRcptChngEmpId();

    /**
     * Set the value of origEmployeeId
     * @param origEmployeeId - String of origEmployeeId
     */
    public abstract void setOrigEmployeeId(String origEmployeeId);

    /**
     * Get the value of origEmployeeId
     * @return origEmployeeId - String of origEmployeeId
     */
    public abstract String getOrigEmployeeId();

    /**
     * Set the value of reassEmpId
     * @param reassEmpId - String of reassEmpId
     */
    public abstract void setReassEmpId(String reassEmpId);

    /**
     * Get the value of reassEmpId
     * @return reassEmpId - String of reassEmpId
     */
    public abstract String getReassEmpId();

    /**
     * Set the value of dualPrepaidIdNbr
     * @param dualPrepaidIdNbr - Integer of dualPrepaidIdNbr
     */
    public abstract void setDualPrepaidIdNbr(Integer dualPrepaidIdNbr);

    /**
     * Get the value of dualPrepaidIdNbr
     * @return dualPrepaidIdNbr - Integer of dualPrepaidIdNbr
     */
    public abstract Integer getDualPrepaidIdNbr();

    /**
     * Set the value of billAccount
     * @param billAccount - String of billAccount
     */
    public abstract void setBillAccount(String billAccount);

    /**
     * Get the value of billAccount
     * @return billAccount - String of billAccount
     */
    public abstract String getBillAccount();
            
    
    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String customerNm, Date awbDt, String locationCd, String awbNbr, String tinUniqId, String paymentCurrency, double cashPaymentAmt, double otherPaymentAmt, int otherPaymentType, String otherDocNbr, double coupPymtAmt, double pux16CashPayment, double pux16FreightAmt, double pux16OtherPaymentAmt, String pux16OtherDocNbr, double pux16CoupPymtAmt, String pux16ScanSeqNbr, String chngStatusEmployeeId, Date chngStatusDt, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String lastScanType, Date lastScanDate, String chkinAgentComment, int statusId, int cashDepositSlipId, String cashDepositSlipNbr, int otherDepositSlipId, String otherDepositSlipNbr, double freightAmtInVisa, Date visaMnfstDt, String visaMnfstEmpId, double exchRate, String courierId, int product, int numberPkgs, double weight, String creditCardBatchId, int eodId, int couponBatchId, Date pymtImpDt, String otherComment, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Integer dualPrepaidIdNbr, String billAccount,Date miscDate,String miscNbr)
        throws CreateException {
        setCustomerNm(customerNm);
        setAwbDt(awbDt);
        setLocationCd(locationCd);
        setAwbNbr(awbNbr);
        setTinUniqId(tinUniqId);
        setPaymentCurrency(paymentCurrency);
        setCashPaymentAmt(cashPaymentAmt);
        setOtherPaymentAmt(otherPaymentAmt);
        setOtherPaymentType(otherPaymentType);
        setOtherDocNbr(otherDocNbr);
        setCoupPymtAmt(coupPymtAmt);
        setPux16CashPayment(pux16CashPayment);
        setPux16FreightAmt(pux16FreightAmt);
        setPux16OtherPaymentAmt(pux16OtherPaymentAmt);
        setPux16OtherDocNbr(pux16OtherDocNbr);
        setPux16CoupPymtAmt(pux16CoupPymtAmt);
        setPux16ScanSeqNbr(pux16ScanSeqNbr);
        setChngStatusEmployeeId(chngStatusEmployeeId);
        setChngStatusDt(chngStatusDt);
        setCloseEmployeeId(closeEmployeeId);
        setCloseDt(closeDt);
        setEodEmployeeId(eodEmployeeId);
        setEodDt(eodDt);
        setLastScanType(lastScanType);
        setLastScanDate(lastScanDate);
        setChkinAgentComment(chkinAgentComment);
        setStatusId(statusId);
        setCashDepositSlipId(cashDepositSlipId);
        setCashDepositSlipNbr(cashDepositSlipNbr);
        setOtherDepositSlipId(otherDepositSlipId);
        setOtherDepositSlipNbr(otherDepositSlipNbr);
        setFreightAmtInVisa(freightAmtInVisa);
        setVisaMnfstDt(visaMnfstDt);
        setVisaMnfstEmpId(visaMnfstEmpId);
        setExchRate(exchRate);
        setCourierId(courierId);
        setProduct(product);
        setNumberPkgs(numberPkgs);
        setWeight(weight);
        setCreditCardBatchId(creditCardBatchId);
        setEodId(eodId);
        setCouponBatchId(couponBatchId);
        setPymtImpDt(pymtImpDt);
        setOtherComment(otherComment);
        setRcptNbr(rcptNbr);
        setOrigRcptNbr(origRcptNbr);
        setRcptChngEmpId(rcptChngEmpId);
        setOrigEmployeeId(origEmployeeId);
        setReassEmpId(reassEmpId);
        setDualPrepaidIdNbr(dualPrepaidIdNbr);
        setBillAccount(billAccount);
        //added to add the two new columns miscDate,miscNbr
        setMiscDate(miscDate);
        setMiscNbr(miscNbr);        
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String customerNm, Date awbDt, String locationCd, String awbNbr, String tinUniqId, String paymentCurrency, double cashPaymentAmt, double otherPaymentAmt, int otherPaymentType, String otherDocNbr, double coupPymtAmt, double pux16CashPayment, double pux16FreightAmt, double pux16OtherPaymentAmt, String pux16OtherDocNbr, double pux16CoupPymtAmt, String pux16ScanSeqNbr, String chngStatusEmployeeId, Date chngStatusDt, String closeEmployeeId, Date closeDt, String eodEmployeeId, Date eodDt, String lastScanType, Date lastScanDate, String chkinAgentComment, int statusId, int cashDepositSlipId, String cashDepositSlipNbr, int otherDepositSlipId, String otherDepositSlipNbr, double freightAmtInVisa, Date visaMnfstDt, String visaMnfstEmpId, double exchRate, String courierId, int product, int numberPkgs, double weight, String creditCardBatchId, int eodId, int couponBatchId, Date pymtImpDt, String otherComment, String rcptNbr, String origRcptNbr, String rcptChngEmpId, String origEmployeeId, String reassEmpId, Integer dualPrepaidIdNbr, String billAccount,Date miscDate,String miscNbr)
        throws CreateException {
    }

    /**
     * Called by Container.  Associates this Bean instance with a particular context environment.
     */
    public void setEntityContext(EntityContext ctx) {
        _ctx = ctx;
    }

    /**
     * Called by Container.  Disassociates this Bean instance with a particular 
     * context.  Once done, we can query the Context for environment information
     */
    public void unsetEntityContext() {
        _ctx = null;
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * Called by Container.  Updates the entity bean instance to reflect 
     * the current value stored in the database.
     */
    public void ejbLoad() {
    }

    /**
     * Called by Container.  Updates the database to reflect the current values 
     * of this in-memory Entity Bean instance representation.
     */
    public void ejbStore() {
    }

    /**
     * EJB Container calls this method right before it remove the Entity bean 
     * from the database.  Corresponds to when client calls home.remove().
     */
    public void ejbRemove() {
    }

}
