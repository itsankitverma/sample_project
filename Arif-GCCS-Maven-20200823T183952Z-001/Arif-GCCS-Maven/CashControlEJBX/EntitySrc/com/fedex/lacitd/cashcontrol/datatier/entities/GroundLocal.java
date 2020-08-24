/**
 * @(#)GroundLocal.java			Wed Nov 29 10:36:42 VET 2006
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
 * This bean map to the ground table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;

import javax.ejb.*;

public interface GroundLocal extends EJBLocalObject {

	
	//to add the two new columns miscDate, miscNbr 
	public Date getMiscDate();
	public void setMiscDate(Date miscDate) ;
	public String getMiscNbr();
	public void setMiscNbr(String miscNbr);
    /**
     * Set the value of grndShpIdNbr
     * @param grndShpIdNbr - Integer of grndShpIdNbr
     */
    public void setGrndShpIdNbr(Integer grndShpIdNbr);

    /**
     * Get the value of grndShpIdNbr
     * @return grndShpIdNbr - Integer of grndShpIdNbr
     */
    public Integer getGrndShpIdNbr();

    /**
     * Set the value of grndShpDt
     * @param grndShpDt - Date of grndShpDt
     */
    public void setGrndShpDt(Date grndShpDt);

    /**
     * Get the value of grndShpDt
     * @return grndShpDt - Date of grndShpDt
     */
    public Date getGrndShpDt();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public String getLocationCd();

    /**
     * Set the value of grndTrakNbr
     * @param grndTrakNbr - String of grndTrakNbr
     */
    public void setGrndTrakNbr(String grndTrakNbr);

    /**
     * Get the value of grndTrakNbr
     * @return grndTrakNbr - String of grndTrakNbr
     */
    public String getGrndTrakNbr();

    /**
     * Set the value of paymentCurrency
     * @param paymentCurrency - String of paymentCurrency
     */
    public void setPaymentCurrency(String paymentCurrency);

    /**
     * Get the value of paymentCurrency
     * @return paymentCurrency - String of paymentCurrency
     */
    public String getPaymentCurrency();

    /**
     * Set the value of cashPymtAmt
     * @param cashPymtAmt - double of cashPymtAmt
     */
    public void setCashPymtAmt(double cashPymtAmt);

    /**
     * Get the value of cashPymtAmt
     * @return cashPymtAmt - double of cashPymtAmt
     */
    public double getCashPymtAmt();

    /**
     * Set the value of otherPymtAmt
     * @param otherPymtAmt - double of otherPymtAmt
     */
    public void setOtherPymtAmt(double otherPymtAmt);

    /**
     * Get the value of otherPymtAmt
     * @return otherPymtAmt - double of otherPymtAmt
     */
    public double getOtherPymtAmt();

    /**
     * Set the value of otherPymtTypeCd
     * @param otherPymtTypeCd - int of otherPymtTypeCd
     */
    public void setOtherPymtTypeCd(int otherPymtTypeCd);

    /**
     * Get the value of otherPymtTypeCd
     * @return otherPymtTypeCd - int of otherPymtTypeCd
     */
    public int getOtherPymtTypeCd();

    /**
     * Set the value of otherDocNbr
     * @param otherDocNbr - String of otherDocNbr
     */
    public void setOtherDocNbr(String otherDocNbr);

    /**
     * Get the value of otherDocNbr
     * @return otherDocNbr - String of otherDocNbr
     */
    public String getOtherDocNbr();

    /**
     * Set the value of coupnPymtAmt
     * @param coupnPymtAmt - double of coupnPymtAmt
     */
    public void setCoupnPymtAmt(double coupnPymtAmt);

    /**
     * Get the value of coupnPymtAmt
     * @return coupnPymtAmt - double of coupnPymtAmt
     */
    public double getCoupnPymtAmt();

    /**
     * Set the value of chngStatusEmpIdNbr
     * @param chngStatusEmpIdNbr - String of chngStatusEmpIdNbr
     */
    public void setChngStatusEmpIdNbr(String chngStatusEmpIdNbr);

    /**
     * Get the value of chngStatusEmpIdNbr
     * @return chngStatusEmpIdNbr - String of chngStatusEmpIdNbr
     */
    public String getChngStatusEmpIdNbr();

    /**
     * Set the value of chngStatusDt
     * @param chngStatusDt - Date of chngStatusDt
     */
    public void setChngStatusDt(Date chngStatusDt);

    /**
     * Get the value of chngStatusDt
     * @return chngStatusDt - Date of chngStatusDt
     */
    public Date getChngStatusDt();

    /**
     * Set the value of closeEmpIdNbr
     * @param closeEmpIdNbr - String of closeEmpIdNbr
     */
    public void setCloseEmpIdNbr(String closeEmpIdNbr);

    /**
     * Get the value of closeEmpIdNbr
     * @return closeEmpIdNbr - String of closeEmpIdNbr
     */
    public String getCloseEmpIdNbr();

    /**
     * Set the value of closeDt
     * @param closeDt - Date of closeDt
     */
    public void setCloseDt(Date closeDt);

    /**
     * Get the value of closeDt
     * @return closeDt - Date of closeDt
     */
    public Date getCloseDt();

    /**
     * Set the value of eodEmpIdNbr
     * @param eodEmpIdNbr - String of eodEmpIdNbr
     */
    public void setEodEmpIdNbr(String eodEmpIdNbr);

    /**
     * Get the value of eodEmpIdNbr
     * @return eodEmpIdNbr - String of eodEmpIdNbr
     */
    public String getEodEmpIdNbr();

    /**
     * Set the value of eodDt
     * @param eodDt - Date of eodDt
     */
    public void setEodDt(Date eodDt);

    /**
     * Get the value of eodDt
     * @return eodDt - Date of eodDt
     */
    public Date getEodDt();

    /**
     * Set the value of chkinAgentComDesc
     * @param chkinAgentComDesc - String of chkinAgentComDesc
     */
    public void setChkinAgentComDesc(String chkinAgentComDesc);

    /**
     * Get the value of chkinAgentComDesc
     * @return chkinAgentComDesc - String of chkinAgentComDesc
     */
    public String getChkinAgentComDesc();

    /**
     * Set the value of statusCd
     * @param statusCd - int of statusCd
     */
    public void setStatusCd(int statusCd);

    /**
     * Get the value of statusCd
     * @return statusCd - int of statusCd
     */
    public int getStatusCd();

    /**
     * Set the value of exchRateAmt
     * @param exchRateAmt - double of exchRateAmt
     */
    public void setExchRateAmt(double exchRateAmt);

    /**
     * Get the value of exchRateAmt
     * @return exchRateAmt - double of exchRateAmt
     */
    public double getExchRateAmt();

    /**
     * Set the value of courEmpIdNbr
     * @param courEmpIdNbr - String of courEmpIdNbr
     */
    public void setCourEmpIdNbr(String courEmpIdNbr);

    /**
     * Get the value of courEmpIdNbr
     * @return courEmpIdNbr - String of courEmpIdNbr
     */
    public String getCourEmpIdNbr();

    /**
     * Set the value of cashDepSlipIdNbr
     * @param cashDepSlipIdNbr - int of cashDepSlipIdNbr
     */
    public void setCashDepSlipIdNbr(int cashDepSlipIdNbr);

    /**
     * Get the value of cashDepSlipIdNbr
     * @return cashDepSlipIdNbr - int of cashDepSlipIdNbr
     */
    public int getCashDepSlipIdNbr();

    /**
     * Set the value of otherDepSlipIdNbr
     * @param otherDepSlipIdNbr - int of otherDepSlipIdNbr
     */
    public void setOtherDepSlipIdNbr(int otherDepSlipIdNbr);

    /**
     * Get the value of otherDepSlipIdNbr
     * @return otherDepSlipIdNbr - int of otherDepSlipIdNbr
     */
    public int getOtherDepSlipIdNbr();

    /**
     * Set the value of eodIdNbr
     * @param eodIdNbr - int of eodIdNbr
     */
    public void setEodIdNbr(int eodIdNbr);

    /**
     * Get the value of eodIdNbr
     * @return eodIdNbr - int of eodIdNbr
     */
    public int getEodIdNbr();

    /**
     * Set the value of coupnBatchIdNbr
     * @param coupnBatchIdNbr - int of coupnBatchIdNbr
     */
    public void setCoupnBatchIdNbr(int coupnBatchIdNbr);

    /**
     * Get the value of coupnBatchIdNbr
     * @return coupnBatchIdNbr - int of coupnBatchIdNbr
     */
    public int getCoupnBatchIdNbr();

    /**
     * Set the value of otherComDsc
     * @param otherComDsc - String of otherComDsc
     */
    public void setOtherComDsc(String otherComDsc);

    /**
     * Get the value of otherComDsc
     * @return otherComDsc - String of otherComDsc
     */
    public String getOtherComDsc();

    /**
     * Set the value of rcptNbr
     * @param rcptNbr - String of rcptNbr
     */
    public void setRcptNbr(String rcptNbr);

    /**
     * Get the value of rcptNbr
     * @return rcptNbr - String of rcptNbr
     */
    public String getRcptNbr();

    /**
     * Set the value of origRcptNbr
     * @param origRcptNbr - String of origRcptNbr
     */
    public void setOrigRcptNbr(String origRcptNbr);

    /**
     * Get the value of origRcptNbr
     * @return origRcptNbr - String of origRcptNbr
     */
    public String getOrigRcptNbr();

    /**
     * Set the value of rcptChngEmpNbr
     * @param rcptChngEmpNbr - String of rcptChngEmpNbr
     */
    public void setRcptChngEmpNbr(String rcptChngEmpNbr);

    /**
     * Get the value of rcptChngEmpNbr
     * @return rcptChngEmpNbr - String of rcptChngEmpNbr
     */
    public String getRcptChngEmpNbr();

    /**
     * Set the value of origEmpNbr
     * @param origEmpNbr - String of origEmpNbr
     */
    public void setOrigEmpNbr(String origEmpNbr);

    /**
     * Get the value of origEmpNbr
     * @return origEmpNbr - String of origEmpNbr
     */
    public String getOrigEmpNbr();

    /**
     * Set the value of rsgnEmpNbr
     * @param rsgnEmpNbr - String of rsgnEmpNbr
     */
    public void setRsgnEmpNbr(String rsgnEmpNbr);

    /**
     * Get the value of rsgnEmpNbr
     * @return rsgnEmpNbr - String of rsgnEmpNbr
     */
    public String getRsgnEmpNbr();

    /**
     * Set the value of dualGrndShipIdNbr
     * @param dualGrndShipIdNbr - Integer of dualGrndShipIdNbr
     */
    public void setDualGrndShipIdNbr(Integer dualGrndShipIdNbr);

    /**
     * Get the value of dualGrndShipIdNbr
     * @return dualGrndShipIdNbr - Integer of dualGrndShipIdNbr
     */
    public Integer getDualGrndShipIdNbr();

    /**
     * Set the value of custNm
     * @param custNm - String of custNm
     */
    public void setCustNm(String custNm);

    /**
     * Get the value of custNm
     * @return custNm - String of custNm
     */
    public String getCustNm();
    
    /**
     * Set the value of billAccount
     * @param custNm - String of billAccount
     */
    public void setBillAccount(String billAccount);

    /**
     * Get the value of custNm
     * @return custNm - String of custNm
     */
    public String getBillAccount();

}
