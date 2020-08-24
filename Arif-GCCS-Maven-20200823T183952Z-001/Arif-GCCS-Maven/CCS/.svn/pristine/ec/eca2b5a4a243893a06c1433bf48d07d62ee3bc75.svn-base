package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;

/**
 * Checkin Agent Summary screen form class
 * @author  ccardenas
 */
public class CheckInAgentCashRecapForm extends ActionForm implements java.io.Serializable{

       public List getAwbInv() {
        return awbInv;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    private String currencyCd;

    public String getDocNbr() {
        return docNbr;
    }

    public void setDocNbr(String docNbr) {
        this.docNbr = docNbr;
    }

    public Collection getRodPymtTypes() {
        return rodPymtTypes;
    }
    
    public void setRodPymtTypes(Collection rodPymtTypes) {
        this.rodPymtTypes = rodPymtTypes;
    }


    public Collection getCodPymtTypes() {
        return codPymtTypes;
    }
    
    public void setCodPymtTypes(Collection codPymtTypes) {
        this.codPymtTypes = codPymtTypes;
    }

    public Collection getFtcPymtTypes() {
        return ftcPymtTypes;
    }
    
    public void setFtcPymtTypes(Collection ftcPymtTypes) {
        this.ftcPymtTypes = ftcPymtTypes;
    }

    private Collection rodPymtTypes;

    private Collection codPymtTypes;
    
    private Collection ftcPymtTypes;
    
    private String docNbr;

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    private int paymentType;

    public void setAwbInv(List awbInv) {
        this.awbInv = ListUtils.lazyList(awbInv,new Factory() {
                                                                        public Object create() {
                                                                           return new Entry();
                                                                        }
                                                                     } );
    }

    private List awbInv=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                        public Object create() {
                                                                           return new Entry();
                                                                        }
                                                                     } );     

    public boolean isCash() {
        return isCash;
    }

    public void setCash(boolean cash) {
        isCash = cash;
    }

    public boolean isFindByAwb() {
        return findByAwb;
    }

    public void setFindByAwb(boolean findByAwb) {
        this.findByAwb = findByAwb;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private boolean isCash;

    private boolean findByAwb=true;

    private String comments;

    private List employeeSummaries=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new ExpressCheckinTableVO();
                                                                          }
                                                                       } );
    
	/**
	 * @return Returns the newEmployeeId.
	 */
	public String getNewEmployeeId() {
		return newEmployeeId;
	}
	/**
	 * @param newEmployeeId The newEmployeeId to set.
	 */
	public void setNewEmployeeId(String newEmployeeId) {
		this.newEmployeeId = newEmployeeId;
	}
	/**
	 * @return Returns the newReassLocationCd.
	 */
	public String getNewReassLocationCd() {
		return newReassLocationCd;
	}
	/**
	 * @param newReassLocationCd The newReassLocationCd to set.
	 */
	public void setNewReassLocationCd(String newReassLocationCd) {
		this.newReassLocationCd = newReassLocationCd;
	}
	/**
	 * @return Returns the origEmployeeId.
	 */
	public String getOrigEmployeeId() {
		return origEmployeeId;
	}
	/**
	 * @param origEmployeeId The origEmployeeId to set.
	 */
	public void setOrigEmployeeId(String origEmployeeId) {
		this.origEmployeeId = origEmployeeId;
	}
	/**
	 * @return Returns the reassEmployeeId.
	 */
	public String getReassEmployeeId() {
		return reassEmployeeId;
	}
	/**
	 * @param reassEmployeeId The reassEmployeeId to set.
	 */
	public void setReassEmployeeId(String reassEmployeeId) {
		this.reassEmployeeId = reassEmployeeId;
	}
    private String newReassLocationCd;
    
    private String newEmployeeId;
    
    private String origEmployeeId;
    
    private String reassEmployeeId;
    
    private boolean reassROD;
    
    private boolean reassCOD;

    private boolean reassFTC;

    private boolean reassPRP;
    
    private boolean reassPOA;

    private boolean reassGRN;

    private boolean selected;
    
    
    /** Holds value of property totalLocalExpectedAmount. */
    private double totalLocalExpectedAmount;

    /** Holds value of property totalLocalAppliedAmount. */
    private double totalLocalAppliedAmount;

    /** Holds value of property totalUsdExpectedAmount. */
    private double totalUsdExpectedAmount;

    /** Holds value of property totalUsdAppliedAmount. */
    private double totalUsdAppliedAmount;

    /** Holds value of property totalLocalExpectedAmount_COD. */
    private double totalLocalExpectedAmount_COD;

    /** Holds value of property totalLocalAppliedAmount_COD. */
    private double totalLocalAppliedAmount_COD;

    /** Holds value of property totalUsdExpectedAmount_COD. */
    private double totalUsdExpectedAmount_COD;

    /** Holds value of property totalUsdAppliedAmount_COD. */
    private double totalUsdAppliedAmount_COD;
    
    /** Holds value of property totalLocalExpectedAmount_FTC. */
    private double totalLocalExpectedAmount_FTC;

    /** Holds value of property totalLocalAppliedAmount_FTC. */
    private double totalLocalAppliedAmount_FTC;

    /** Holds value of property totalUsdExpectedAmount_FTC. */
    private double totalUsdExpectedAmount_FTC;

    /** Holds value of property totalUsdAppliedAmount_FTC. */
    private double totalUsdAppliedAmount_FTC;
    
    /** Holds value of property totalPrepaidLocal. */
    private double totalPrepaidLocal;
    
    /** Holds value of property totalPrepaidUsd. */
    private double totalPrepaidUsd;
    
    /** Holds value of property totalPoaLocal. */
    private double totalPoaLocal;
    
    /** Holds value of property totalPoaUsd. */
    private double totalPoaUsd;
    
    /** Holds value of property localOtherPaymentAmt. */
    private double localOtherPaymentAmt;
    
    /** Holds value of property usdOtherPaymentAmt. */
    private double usdOtherPaymentAmt;
    
    public CheckInAgentCashRecapForm() {
    }

    public void setEmployeeSummaries(List employeeSummaries){
        this.employeeSummaries = ListUtils.lazyList(employeeSummaries,new Factory() {
                                                                        public Object create() {
                                                                           return new ExpressCheckinTableVO();
                                                                        }
                                                                     } );
    }

    public List getEmployeeSummaries(){
        return employeeSummaries;
    }

    /** Getter for property totalLocalExpectedAmount.
     * @return Value of property totalLocalExpectedAmount.
     */
    public double getTotalLocalExpectedAmount() {
        return this.totalLocalExpectedAmount;
    }

    /** Setter for property totalLocalExpectedAmount.
     * @param totalLocalExpectedAmount New value of property totalLocalExpectedAmount.
     */
    public void setTotalLocalExpectedAmount(double totalLocalExpectedAmount) {
        this.totalLocalExpectedAmount = totalLocalExpectedAmount;
    }

    /** Getter for property totalLocalAppliedAmount.
     * @return Value of property totalLocalAppliedAmount.
     */
    public double getTotalLocalAppliedAmount() {
        return this.totalLocalAppliedAmount;
    }

    /** Setter for property totalLocalAppliedAmount.
     * @param totalLocalAppliedAmount New value of property totalLocalAppliedAmount.
     */
    public void setTotalLocalAppliedAmount(double totalLocalAppliedAmount) {
        this.totalLocalAppliedAmount = totalLocalAppliedAmount;
    }

    /** Getter for property totalUsdExpectedAmount.
     * @return Value of property totalUsdExpectedAmount.
     */
    public double getTotalUsdExpectedAmount() {
        return this.totalUsdExpectedAmount;
    }

    /** Setter for property totalUsdExpectedAmount.
     * @param totalUsdExpectedAmount New value of property totalUsdExpectedAmount.
     */
    public void setTotalUsdExpectedAmount(double totalUsdExpectedAmount) {
        this.totalUsdExpectedAmount = totalUsdExpectedAmount;
    }

    /** Getter for property totalUsdAppliedAmount.
     * @return Value of property totalUsdAppliedAmount.
     */
    public double getTotalUsdAppliedAmount() {
        return this.totalUsdAppliedAmount;
    }

    /** Setter for property totalUsdAppliedAmount.
     * @param totalUsdAppliedAmount New value of property totalUsdAppliedAmount.
     */
    public void setTotalUsdAppliedAmount(double totalUsdAppliedAmount) {
        this.totalUsdAppliedAmount = totalUsdAppliedAmount;
    }

    
    //========= Start COD =============================//////////
    /** Getter for property totalLocalExpectedAmount_COD.
     * @return Value of property totalLocalExpectedAmount_COD.
     */
    public double getTotalLocalExpectedAmount_COD() {
        return this.totalLocalExpectedAmount_COD;
    }

    /** Setter for property totalLocalExpectedAmount_COD.
     * @param totalLocalExpectedAmount_COD New value of property totalLocalExpectedAmount_COD.
     */
    public void setTotalLocalExpectedAmount_COD(double totalLocalExpectedAmount_COD) {
        this.totalLocalExpectedAmount_COD = totalLocalExpectedAmount_COD;
    }

    /** Getter for property totalLocalAppliedAmount_COD.
     * @return Value of property totalLocalAppliedAmount_COD.
     */
    public double getTotalLocalAppliedAmount_COD() {
        return this.totalLocalAppliedAmount_COD;
    }

    /** Setter for property totalLocalAppliedAmount_COD.
     * @param totalLocalAppliedAmount_COD New value of property totalLocalAppliedAmount_COD.
     */
    public void setTotalLocalAppliedAmount_COD(double totalLocalAppliedAmount_COD) {
        this.totalLocalAppliedAmount_COD = totalLocalAppliedAmount_COD;
    }

    /** Getter for property totalUsdExpectedAmount_COD.
     * @return Value of property totalUsdExpectedAmount_COD.
     */
    public double getTotalUsdExpectedAmount_COD() {
        return this.totalUsdExpectedAmount_COD;
    }

    /** Setter for property totalUsdExpectedAmount_COD.
     * @param totalUsdExpectedAmount_COD New value of property totalUsdExpectedAmount_COD.
     */
    public void setTotalUsdExpectedAmount_COD(double totalUsdExpectedAmount_COD) {
        this.totalUsdExpectedAmount_COD = totalUsdExpectedAmount_COD;
    }

    /** Getter for property totalUsdAppliedAmount_COD.
     * @return Value of property totalUsdAppliedAmount_COD.
     */
    public double getTotalUsdAppliedAmount_COD() {
        return this.totalUsdAppliedAmount_COD;
    }

    /** Setter for property totalUsdAppliedAmount_COD.
     * @param totalUsdAppliedAmount_COD New value of property totalUsdAppliedAmount_COD.
     */
    public void setTotalUsdAppliedAmount_COD(double totalUsdAppliedAmount_COD) {
        this.totalUsdAppliedAmount_COD = totalUsdAppliedAmount_COD;
    }

    
    //=========End Cod ===================================/////////
    
    
    //========= Start FTC =============================//////////
    /** Getter for property totalLocalExpectedAmount_FTC.
     * @return Value of property totalLocalExpectedAmount_FTC.
     */
    public double getTotalLocalExpectedAmount_FTC() {
        return this.totalLocalExpectedAmount_FTC;
    }

    /** Setter for property totalLocalExpectedAmount_FTC.
     * @param totalLocalExpectedAmount_FTC New value of property totalLocalExpectedAmount_FTC.
     */
    public void setTotalLocalExpectedAmount_FTC(double totalLocalExpectedAmount_FTC) {
        this.totalLocalExpectedAmount_FTC = totalLocalExpectedAmount_FTC;
    }

    /** Getter for property totalLocalAppliedAmount_FTC.
     * @return Value of property totalLocalAppliedAmount_FTC.
     */
    public double getTotalLocalAppliedAmount_FTC() {
        return this.totalLocalAppliedAmount_FTC;
    }

    /** Setter for property totalLocalAppliedAmount_FTC.
     * @param totalLocalAppliedAmount_FTC New value of property totalLocalAppliedAmount_FTC.
     */
    public void setTotalLocalAppliedAmount_FTC(double totalLocalAppliedAmount_FTC) {
        this.totalLocalAppliedAmount_FTC = totalLocalAppliedAmount_FTC;
    }

    /** Getter for property totalUsdExpectedAmount_FTC.
     * @return Value of property totalUsdExpectedAmount_FTC.
     */
    public double getTotalUsdExpectedAmount_FTC() {
        return this.totalUsdExpectedAmount_FTC;
    }

    /** Setter for property totalUsdExpectedAmount_FTC.
     * @param totalUsdExpectedAmount_FTC New value of property totalUsdExpectedAmount_FTC.
     */
    public void setTotalUsdExpectedAmount_FTC(double totalUsdExpectedAmount_FTC) {
        this.totalUsdExpectedAmount_FTC = totalUsdExpectedAmount_FTC;
    }

    /** Getter for property totalUsdAppliedAmount_FTC.
     * @return Value of property totalUsdAppliedAmount_FTC.
     */
    public double getTotalUsdAppliedAmount_FTC() {
        return this.totalUsdAppliedAmount_FTC;
    }

    /** Setter for property totalUsdAppliedAmount_FTC.
     * @param totalUsdAppliedAmount_FTC New value of property totalUsdAppliedAmount_FTC.
     */
    public void setTotalUsdAppliedAmount_FTC(double totalUsdAppliedAmount_FTC) {
        this.totalUsdAppliedAmount_FTC = totalUsdAppliedAmount_FTC;
    }

    
    //=========End FTC ===================================/////////
    
    
    /** Getter for property totalPrepaidLocal.
     * @return Value of property totalPrepaidLocal.
     */
    public double getTotalPrepaidLocal() {
        return this.totalPrepaidLocal;
    }
    
    /** Setter for property totalPrepaidLocal.
     * @param totalPrepaidLocal New value of property totalPrepaidLocal.
     */
    public void setTotalPrepaidLocal(double totalPrepaidLocal) {
        this.totalPrepaidLocal = totalPrepaidLocal;
    }
    
    /** Getter for property totalPrepaidUsd.
     * @return Value of property totalPrepaidUsd.
     */
    public double getTotalPrepaidUsd() {
        return this.totalPrepaidUsd;
    }
    
    /** Setter for property totalPrepaidUsd.
     * @param totalPrepaidUsd New value of property totalPrepaidUsd.
     */
    public void setTotalPrepaidUsd(double totalPrepaidUsd) {
        this.totalPrepaidUsd = totalPrepaidUsd;
    }
    
    /** Getter for property totalPoaLocal.
     * @return Value of property totalPoaLocal.
     */
    public double getTotalPoaLocal() {
        return this.totalPoaLocal;
    }
    
    /** Setter for property totalPoaLocal.
     * @param totalPoaLocal New value of property totalPoaLocal.
     */
    public void setTotalPoaLocal(double totalPoaLocal) {
        this.totalPoaLocal = totalPoaLocal;
    }
    
    /** Getter for property totalPoaUsd.
     * @return Value of property totalPoaUsd.
     */
    public double getTotalPoaUsd() {
        return this.totalPoaUsd;
    }
    
    /** Setter for property totalPoaUsd.
     * @param totalPoaUsd New value of property totalPoaUsd.
     */
    public void setTotalPoaUsd(double totalPoaUsd) {
        this.totalPoaUsd = totalPoaUsd;
    }
    
    /** Getter for property localOtherPaymentAmt.
     * @return Value of property localOtherPaymentAmt.
     */
    public double getLocalOtherPaymentAmt() {
        return this.localOtherPaymentAmt;
    }
    
    /** Setter for property localOtherPaymentAmt.
     * @param localOtherPaymentAmt New value of property localOtherPaymentAmt.
     */
    public void setLocalOtherPaymentAmt(double localOtherPaymentAmt) {
        this.localOtherPaymentAmt = localOtherPaymentAmt;
    }
    
    /** Getter for property usdOtherPaymentAmt.
     * @return Value of property usdOtherPaymentAmt.
     */
    public double getUsdOtherPaymentAmt() {
        return this.usdOtherPaymentAmt;
    }
    
    /** Setter for property usdOtherPaymentAmt.
     * @param usdOtherPaymentAmt New value of property usdOtherPaymentAmt.
     */
    public void setUsdOtherPaymentAmt(double usdOtherPaymentAmt) {
        this.usdOtherPaymentAmt = usdOtherPaymentAmt;
    }
    
	/**
	 * @return Returns the reassPOA.
	 */
	public boolean isReassPOA() {
		return reassPOA;
	}
	/**
	 * @param reassPOA The reassPOA to set.
	 */
	public void setReassPOA(boolean reassPOA) {
		this.reassPOA = reassPOA;
	}
	/**
	 * @return Returns the reassPRP.
	 */
	public boolean isReassPRP() {
		return reassPRP;
	}
	/**
	 * @param reassPRP The reassPRP to set.
	 */
	public void setReassPRP(boolean reassPRP) {
		this.reassPRP = reassPRP;
	}
	/**
	 * @return Returns the reassROD.
	 */
	public boolean isReassROD() {
		return reassROD;
	}
	/**
	 * @param reassROD The reassROD to set.
	 */
	public void setReassROD(boolean reassROD) {
		this.reassROD = reassROD;
	}
	
	/**
	 * @return Returns the reassCOD.
	 */
	public boolean isReassCOD() {
		return reassCOD;
	}
	/**
	 * @param reassCOD The reassCOD to set.
	 */
	public void setReassCOD(boolean reassCOD) {
		this.reassCOD = reassCOD;
	}
	

	/**
	 * @return Returns the reassFTC.
	 */
	public boolean isReassFTC() {
		return reassFTC;
	}
	/**
	 * @param reassFTC The reassFTC to set.
	 */
	public void setReassFTC(boolean reassFTC) {
		this.reassFTC = reassFTC;
	}
	
	

    /**
	 * @return Returns the reassGRN.
	 */
	public boolean isReassGRN() {
		return reassGRN;
	}
	/**
	 * @param reassGRN The reassGRN to set.
	 */
	public void setReassGRN(boolean reassGRN) {
		this.reassGRN = reassGRN;
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

    //Fields for Ground payments
    private double totalGroundLocal;
    private double totalGroundUsd;

    public void setTotalGroundLocal(double totalGroundLocal) {
        this.totalGroundLocal = totalGroundLocal;
    }

    public double getTotalGroundLocal() {
        return totalGroundLocal;
    }

    public void setTotalGroundUsd(double totalGroundUsd) {
        this.totalGroundUsd = totalGroundUsd;
    }

    public double getTotalGroundUsd() {
        return totalGroundUsd;
    }
}
