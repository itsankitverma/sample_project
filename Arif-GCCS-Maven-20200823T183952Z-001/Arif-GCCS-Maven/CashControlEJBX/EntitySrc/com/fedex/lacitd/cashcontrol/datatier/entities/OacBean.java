/**
 * @(#)OacBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the oac table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class OacBean implements EntityBean {

    private EntityContext _ctx;
    public OacBean() {
    }
    /**
     * Set the value of obAncSvcIdNbr
     * @param obAncSvcIdNbr - Integer of obAncSvcIdNbr
     */
    public abstract void setObAncSvcIdNbr(Integer obAncSvcIdNbr);

    /**
     * Get the value of obAncSvcIdNbr
     * @return obAncSvcIdNbr - Integer of obAncSvcIdNbr
     */
    public abstract Integer getObAncSvcIdNbr();

    /**
     * Set the value of obAncSvcDt
     * @param obAncSvcDt - Date of obAncSvcDt
     */
    public abstract void setObAncSvcDt(Date obAncSvcDt);

    /**
     * Get the value of obAncSvcDt
     * @return obAncSvcDt - Date of obAncSvcDt
     */
    public abstract Date getObAncSvcDt();

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
     * Set the value of pymtCurrCd
     * @param pymtCurrCd - String of pymtCurrCd
     */
    public abstract void setPymtCurrCd(String pymtCurrCd);

    /**
     * Get the value of pymtCurrCd
     * @return pymtCurrCd - String of pymtCurrCd
     */
    public abstract String getPymtCurrCd();

    /**
     * Set the value of cashPymtAmt
     * @param cashPymtAmt - double of cashPymtAmt
     */
    public abstract void setCashPymtAmt(double cashPymtAmt);

    /**
     * Get the value of cashPymtAmt
     * @return cashPymtAmt - double of cashPymtAmt
     */
    public abstract double getCashPymtAmt();

    /**
     * Set the value of otherPymtAmt
     * @param otherPymtAmt - double of otherPymtAmt
     */
    public abstract void setOtherPymtAmt(double otherPymtAmt);

    /**
     * Get the value of otherPymtAmt
     * @return otherPymtAmt - double of otherPymtAmt
     */
    public abstract double getOtherPymtAmt();

    /**
     * Set the value of otherPymtTypeCd
     * @param otherPymtTypeCd - int of otherPymtTypeCd
     */
    public abstract void setOtherPymtTypeCd(int otherPymtTypeCd);

    /**
     * Get the value of otherPymtTypeCd
     * @return otherPymtTypeCd - int of otherPymtTypeCd
     */
    public abstract int getOtherPymtTypeCd();

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
     * Set the value of chngStatusEmpIdNbr
     * @param chngStatusEmpIdNbr - String of chngStatusEmpIdNbr
     */
    public abstract void setChngStatusEmpIdNbr(String chngStatusEmpIdNbr);

    /**
     * Get the value of chngStatusEmpIdNbr
     * @return chngStatusEmpIdNbr - String of chngStatusEmpIdNbr
     */
    public abstract String getChngStatusEmpIdNbr();

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
     * Set the value of closeEmpIdNbr
     * @param closeEmpIdNbr - String of closeEmpIdNbr
     */
    public abstract void setCloseEmpIdNbr(String closeEmpIdNbr);

    /**
     * Get the value of closeEmpIdNbr
     * @return closeEmpIdNbr - String of closeEmpIdNbr
     */
    public abstract String getCloseEmpIdNbr();

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
     * Set the value of eodEmpIdNbr
     * @param eodEmpIdNbr - String of eodEmpIdNbr
     */
    public abstract void setEodEmpIdNbr(String eodEmpIdNbr);

    /**
     * Get the value of eodEmpIdNbr
     * @return eodEmpIdNbr - String of eodEmpIdNbr
     */
    public abstract String getEodEmpIdNbr();

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
     * Set the value of chkinAgentComDesc
     * @param chkinAgentComDesc - String of chkinAgentComDesc
     */
    public abstract void setChkinAgentComDesc(String chkinAgentComDesc);

    /**
     * Get the value of chkinAgentComDesc
     * @return chkinAgentComDesc - String of chkinAgentComDesc
     */
    public abstract String getChkinAgentComDesc();

    /**
     * Set the value of statusCd
     * @param statusCd - int of statusCd
     */
    public abstract void setStatusCd(int statusCd);

    /**
     * Get the value of statusCd
     * @return statusCd - int of statusCd
     */
    public abstract int getStatusCd();

    /**
     * Set the value of exchRateAmt
     * @param exchRateAmt - double of exchRateAmt
     */
    public abstract void setExchRateAmt(double exchRateAmt);

    /**
     * Get the value of exchRateAmt
     * @return exchRateAmt - double of exchRateAmt
     */
    public abstract double getExchRateAmt();

    /**
     * Set the value of courEmpIdNbr
     * @param courEmpIdNbr - String of courEmpIdNbr
     */
    public abstract void setCourEmpIdNbr(String courEmpIdNbr);

    /**
     * Get the value of courEmpIdNbr
     * @return courEmpIdNbr - String of courEmpIdNbr
     */
    public abstract String getCourEmpIdNbr();

    /**
     * Set the value of cashDepSlipIdNbr
     * @param cashDepSlipIdNbr - int of cashDepSlipIdNbr
     */
    public abstract void setCashDepSlipIdNbr(int cashDepSlipIdNbr);

    /**
     * Get the value of cashDepSlipIdNbr
     * @return cashDepSlipIdNbr - int of cashDepSlipIdNbr
     */
    public abstract int getCashDepSlipIdNbr();

    /**
     * Set the value of otherDepSlipIdNbr
     * @param otherDepSlipIdNbr - int of otherDepSlipIdNbr
     */
    public abstract void setOtherDepSlipIdNbr(int otherDepSlipIdNbr);

    /**
     * Get the value of otherDepSlipIdNbr
     * @return otherDepSlipIdNbr - int of otherDepSlipIdNbr
     */
    public abstract int getOtherDepSlipIdNbr();

    /**
     * Set the value of eodIdNbr
     * @param eodIdNbr - int of eodIdNbr
     */
    public abstract void setEodIdNbr(int eodIdNbr);

    /**
     * Get the value of eodIdNbr
     * @return eodIdNbr - int of eodIdNbr
     */
    public abstract int getEodIdNbr();

    /**
     * Set the value of otherComDesc
     * @param otherComDesc - String of otherComDesc
     */
    public abstract void setOtherComDesc(String otherComDesc);

    /**
     * Get the value of otherComDesc
     * @return otherComDesc - String of otherComDesc
     */
    public abstract String getOtherComDesc();

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
     * Set the value of rcptChngEmpNbr
     * @param rcptChngEmpNbr - String of rcptChngEmpNbr
     */
    public abstract void setRcptChngEmpNbr(String rcptChngEmpNbr);

    /**
     * Get the value of rcptChngEmpNbr
     * @return rcptChngEmpNbr - String of rcptChngEmpNbr
     */
    public abstract String getRcptChngEmpNbr();

    /**
     * Set the value of origEmpNbr
     * @param origEmpNbr - String of origEmpNbr
     */
    public abstract void setOrigEmpNbr(String origEmpNbr);

    /**
     * Get the value of origEmpNbr
     * @return origEmpNbr - String of origEmpNbr
     */
    public abstract String getOrigEmpNbr();

    /**
     * Set the value of rsgnEmpNbr
     * @param rsgnEmpNbr - String of rsgnEmpNbr
     */
    public abstract void setRsgnEmpNbr(String rsgnEmpNbr);

    /**
     * Get the value of rsgnEmpNbr
     * @return rsgnEmpNbr - String of rsgnEmpNbr
     */
    public abstract String getRsgnEmpNbr();

    /**
     * Set the value of dualObAncIdNbr
     * @param dualObAncIdNbr - Integer of dualObAncIdNbr
     */
    public abstract void setDualObAncIdNbr(Integer dualObAncIdNbr);

    /**
     * Get the value of dualObAncIdNbr
     * @return dualObAncIdNbr - Integer of dualObAncIdNbr
     */
    public abstract Integer getDualObAncIdNbr();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(Date obAncSvcDt, String locationCd, String pymtCurrCd, double cashPymtAmt, double otherPymtAmt, int otherPymtTypeCd, String otherDocNbr, String chngStatusEmpIdNbr, Date chngStatusDt, String closeEmpIdNbr, Date closeDt, String eodEmpIdNbr, Date eodDt, String chkinAgentComDesc, int statusCd, double exchRateAmt, String courEmpIdNbr, int cashDepSlipIdNbr, int otherDepSlipIdNbr, int eodIdNbr, String otherComDesc, String rcptNbr, String origRcptNbr, String rcptChngEmpNbr, String origEmpNbr, String rsgnEmpNbr, Integer dualObAncIdNbr)
        throws CreateException {
        setObAncSvcDt(obAncSvcDt);
        setLocationCd(locationCd);
        setPymtCurrCd(pymtCurrCd);
        setCashPymtAmt(cashPymtAmt);
        setOtherPymtAmt(otherPymtAmt);
        setOtherPymtTypeCd(otherPymtTypeCd);
        setOtherDocNbr(otherDocNbr);
        setChngStatusEmpIdNbr(chngStatusEmpIdNbr);
        setChngStatusDt(chngStatusDt);
        setCloseEmpIdNbr(closeEmpIdNbr);
        setCloseDt(closeDt);
        setEodEmpIdNbr(eodEmpIdNbr);
        setEodDt(eodDt);
        setChkinAgentComDesc(chkinAgentComDesc);
        setStatusCd(statusCd);
        setExchRateAmt(exchRateAmt);
        setCourEmpIdNbr(courEmpIdNbr);
        setCashDepSlipIdNbr(cashDepSlipIdNbr);
        setOtherDepSlipIdNbr(otherDepSlipIdNbr);
        setEodIdNbr(eodIdNbr);
        setOtherComDesc(otherComDesc);
        setRcptNbr(rcptNbr);
        setOrigRcptNbr(origRcptNbr);
        setRcptChngEmpNbr(rcptChngEmpNbr);
        setOrigEmpNbr(origEmpNbr);
        setRsgnEmpNbr(rsgnEmpNbr);
        setDualObAncIdNbr(dualObAncIdNbr);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(Date obAncSvcDt, String locationCd, String pymtCurrCd, double cashPymtAmt, double otherPymtAmt, int otherPymtTypeCd, String otherDocNbr, String chngStatusEmpIdNbr, Date chngStatusDt, String closeEmpIdNbr, Date closeDt, String eodEmpIdNbr, Date eodDt, String chkinAgentComDesc, int statusCd, double exchRateAmt, String courEmpIdNbr, int cashDepSlipIdNbr, int otherDepSlipIdNbr, int eodIdNbr, String otherComDesc, String rcptNbr, String origRcptNbr, String rcptChngEmpNbr, String origEmpNbr, String rsgnEmpNbr, Integer dualObAncIdNbr)
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
