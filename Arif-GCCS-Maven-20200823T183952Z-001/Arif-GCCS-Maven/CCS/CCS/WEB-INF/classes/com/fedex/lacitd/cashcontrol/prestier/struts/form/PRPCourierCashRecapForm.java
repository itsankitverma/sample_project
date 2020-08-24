package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;

/**
 * Prepaid detail screen form class
 * @author  ccardenas
 */
public class PRPCourierCashRecapForm extends ActionForm implements java.io.Serializable{
    private List awbs=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new PrepaidDetailsTableVO();
                                                                          }
                                                                       } );

    private List oacs=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new OACDetailsTableVO();
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

    private double checkTotal;

    /** Holds value of property totalLocalAppliedAmount. */
    private double cashTotal;

    /** Holds value of property totalUsdExpectedAmount. */
    private java.util.Collection supportedCurrencies;

    /** Holds value of property totalUsdAppliedAmount. */
    private double totalPayments;

    /** Holds value of property currentCurrency. */
    private String currentCurrency;

    /** Holds value of property courier. */
    private String courier;

    /** Holds value of property recStatus. */
    private java.util.Collection preStatus;

    /** Holds value of property recStatus. */
    private java.util.Collection oacStatus;

    /** Holds value of property courierName. */
    private String courierName;

    /** Holds value of property currentlyUsedCurrencies. */
    private java.util.Collection currentlyUsedCurrencies;

    /** Holds value of property creditCardTotal. */
    private double creditCardTotal;
    
    /** Holds value of property couponTotal. */
    private double couponTotal;
    
    /** Holds value of property previousCurrencyCode. */
    private String previousCurrencyCode;
    
    /** Holds value of property canClose. */
    private boolean canClose;
    
    /** Holds value of property cashSubTotal. */
    private double cashSubTotal;
    
    /** Holds value of property checkSubTotal. */
    private double checkSubTotal;
    
    /** Holds value of property couponSubTotal. */
    private double couponSubTotal;
    
    /** Holds value of property creditCardSubTotal. */
    private double creditCardSubTotal;
    
    /** Holds value of property employeesWithPayments. */
    private java.util.Collection employeesWithPayments;
    
    /** Holds value of property paymentTypes. */
    private java.util.Collection paymentTypes;
    
    private double depositSubTotal;
    
    private double depositTotal;
    
    /** Holds value of property countryBanks. */
    private java.util.Collection countryBanks;

    private boolean dualCurrency=false;

    public void setCountryBanks(Collection cb){
    	this.countryBanks=cb;
    }
    
    public Collection getCountryBanks(){
    	return this.countryBanks;
    }    
    
    public PRPCourierCashRecapForm() {
    }

    public void setAwbs(List awbs){
        this.awbs = ListUtils.lazyList(awbs,new Factory() {
                                                                        public Object create() {
                                                                           return new PrepaidDetailsTableVO();
                                                                        }
                                                                     } );
    }

    private Integer pageNumber;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    private Integer numberOfPages;

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    public List getAwbs(){
        return awbs;
    }

    /** Getter for property totalLocalExpectedAmount.
     * @return Value of property totalLocalExpectedAmount.
     */
    public double getCheckTotal() {
        return this.checkTotal;
    }

    /** Setter for property totalLocalExpectedAmount.
     * @param totalLocalExpectedAmount New value of property totalLocalExpectedAmount.
     */
    public void setCheckTotal(double checkTotal) {
        this.checkTotal = checkTotal;
    }

    /** Getter for property totalLocalAppliedAmount.
     * @return Value of property totalLocalAppliedAmount.
     */
    public double getCashTotal() {
        return this.cashTotal;
    }

    /** Setter for property totalLocalAppliedAmount.
     * @param totalLocalAppliedAmount New value of property totalLocalAppliedAmount.
     */
    public void setCashTotal(double cashTotal) {
        this.cashTotal = cashTotal;
    }

    /** Getter for property totalUsdExpectedAmount.
     * @return Value of property totalUsdExpectedAmount.
     */
    public java.util.Collection getSupportedCurrencies() {
        return this.supportedCurrencies;
    }

    /** Setter for property totalUsdExpectedAmount.
     * @param totalUsdExpectedAmount New value of property totalUsdExpectedAmount.
     */
    public void setSupportedCurrencies(java.util.Collection supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    /** Getter for property totalUsdAppliedAmount.
     * @return Value of property totalUsdAppliedAmount.
     */
    public double getTotalPayments() {
        return this.totalPayments;
    }

    /** Setter for property totalUsdAppliedAmount.
     * @param totalUsdAppliedAmount New value of property totalUsdAppliedAmount.
     */
    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }

    /** Getter for property currentCurrency.
     * @return Value of property currentCurrency.
     */
    public String getCurrentCurrency() {
        return this.currentCurrency;
    }

    /** Setter for property currentCurrency.
     * @param currentCurrency New value of property currentCurrency.
     */
    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    /** Getter for property courier.
     * @return Value of property courier.
     */
    public String getCourier() {
        return this.courier;
    }

    /** Setter for property courier.
     * @param courier New value of property courier.
     */
    public void setCourier(String courier) {
        this.courier = courier;
    }

    /** Getter for property courierName.
     * @return Value of property courierName.
     */
    public String getCourierName() {
        return this.courierName;
    }

    /** Setter for property courierName.
     * @param courierName New value of property courierName.
     */
    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    /** Getter for property currentlyUsedCurrencies.
     * @return Value of property currentlyUsedCurrencies.
     */
    public java.util.Collection getCurrentlyUsedCurrencies() {
        return this.currentlyUsedCurrencies;
    }

    /** Setter for property currentlyUsedCurrencies.
     * @param currentlyUsedCurrencies New value of property currentlyUsedCurrencies.
     */
    public void setCurrentlyUsedCurrencies(java.util.Collection currentlyUsedCurrencies) {
        this.currentlyUsedCurrencies = currentlyUsedCurrencies;
    }

    /** Getter for property creditCardTotal.
     * @return Value of property creditCardTotal.
     */
    public double getCreditCardTotal() {
        return this.creditCardTotal;
    }
    
    /** Setter for property creditCardTotal.
     * @param creditCardTotal New value of property creditCardTotal.
     */
    public void setCreditCardTotal(double creditCardTotal) {
        this.creditCardTotal = creditCardTotal;
    }
    
    /** Getter for property couponTotal.
     * @return Value of property couponTotal.
     */
    public double getCouponTotal() {
        return this.couponTotal;
    }
    
    /** Setter for property couponTotal.
     * @param couponTotal New value of property couponTotal.
     */
    public void setCouponTotal(double couponTotal) {
        this.couponTotal = couponTotal;
    }
    
    /** Getter for property previousCurrencyCode.
     * @return Value of property previousCurrencyCode.
     */
    public String getPreviousCurrencyCode() {
        return this.previousCurrencyCode;
    }
    
    /** Setter for property previousCurrencyCode.
     * @param previousCurrencyCode New value of property previousCurrencyCode.
     */
    public void setPreviousCurrencyCode(String previousCurrencyCode) {
        this.previousCurrencyCode = previousCurrencyCode;
    }
    
    /** Getter for property canClose.
     * @return Value of property canClose.
     */
    public boolean isCanClose() {
        return this.canClose;
    }
    
    /** Setter for property canClose.
     * @param canClose New value of property canClose.
     */
    public void setCanClose(boolean canClose) {
        this.canClose = canClose;
    }
    
    /** Getter for property cashSubTotal.
     * @return Value of property cashSubTotal.
     */
    public double getCashSubTotal() {
        return this.cashSubTotal;
    }
    
    /** Setter for property cashSubTotal.
     * @param cashSubTotal New value of property cashSubTotal.
     */
    public void setCashSubTotal(double cashSubTotal) {
        this.cashSubTotal = cashSubTotal;
    }
    
    /** Getter for property checkSubTotal.
     * @return Value of property checkSubTotal.
     */
    public double getCheckSubTotal() {
        return this.checkSubTotal;
    }
    
    /** Setter for property checkSubTotal.
     * @param checkSubTotal New value of property checkSubTotal.
     */
    public void setCheckSubTotal(double checkSubTotal) {
        this.checkSubTotal = checkSubTotal;
    }
    
    /** Getter for property couponSubTotal.
     * @return Value of property couponSubTotal.
     */
    public double getCouponSubTotal() {
        return this.couponSubTotal;
    }
    
    /** Setter for property couponSubTotal.
     * @param couponSubTotal New value of property couponSubTotal.
     */
    public void setCouponSubTotal(double couponSubTotal) {
        this.couponSubTotal = couponSubTotal;
    }
    
    /** Getter for property creditCardSubTotal.
     * @return Value of property creditCardSubTotal.
     */
    public double getCreditCardSubTotal() {
        return this.creditCardSubTotal;
    }
    
    /** Setter for property creditCardSubTotal.
     * @param creditCardSubTotal New value of property creditCardSubTotal.
     */
    public void setCreditCardSubTotal(double creditCardSubTotal) {
        this.creditCardSubTotal = creditCardSubTotal;
    }
    
    /** Getter for property employeesWithPayments.
     * @return Value of property employeesWithPayments.
     */
    public java.util.Collection getEmployeesWithPayments() {
        return this.employeesWithPayments;
    }
    
    /** Setter for property employeesWithPayments.
     * @param employeesWithPayments New value of property employeesWithPayments.
     */
    public void setEmployeesWithPayments(java.util.Collection employeesWithPayments) {
        this.employeesWithPayments = employeesWithPayments;
    }
    
    /** Getter for property paymentTypes.
     * @return Value of property paymentTypes.
     */
    public java.util.Collection getPaymentTypes() {
        return this.paymentTypes;
    }
    
    /** Setter for property paymentTypes.
     * @param paymentTypes New value of property paymentTypes.
     */
    public void setPaymentTypes(java.util.Collection paymentTypes) {
        this.paymentTypes = paymentTypes;
    }
    
	/**
	 * @return Returns the depositTotal.
	 */
	public double getDepositTotal() {
		return depositTotal;
	}

	/**
	 * @param depositTotal The depositTotal to set.
	 */
	public void setDepositTotal(double depositTotal) {
		this.depositTotal = depositTotal;
	}

	/**
	 * @return Returns the depositSubTotal.
	 */
	public double getDepositSubTotal() {
		return depositSubTotal;
	}

	/**
	 * @param depositSubTotal The depositSubTotal to set.
	 */
	public void setDepositSubTotal(double depositSubTotal) {
		this.depositSubTotal = depositSubTotal;
	}

    public boolean isDualCurrency() {
        return dualCurrency;
    }

    public void setDualCurrency(boolean dualCurrency) {
        this.dualCurrency = dualCurrency;
    }

    public void setUsdCashTotal(double usdCashTotal) {
        this.usdCashTotal = usdCashTotal;
    }

    public void setUsdCheckTotal(double usdCheckTotal) {
        this.usdCheckTotal = usdCheckTotal;
    }

    public void setUsdCreditCardTotal(double usdCreditCardTotal) {
        this.usdCreditCardTotal = usdCreditCardTotal;
    }

    public void setUsdCouponTotal(double usdCouponTotal) {
        this.usdCouponTotal = usdCouponTotal;
    }

    public void setUsdDepositTotal(double usdDepositTotal) {
        this.usdDepositTotal = usdDepositTotal;
    }

    public void setUsdTotalPayments(double usdTotalPayments) {
        this.usdTotalPayments = usdTotalPayments;
    }

    public void setUsdCashSubTotal(double usdCashSubTotal) {
        this.usdCashSubTotal = usdCashSubTotal;
    }

    public void setUsdCheckSubTotal(double usdCheckSubTotal) {
        this.usdCheckSubTotal = usdCheckSubTotal;
    }

    public void setUsdCreditCardSubTotal(double usdCreditCardSubTotal) {
        this.usdCreditCardSubTotal = usdCreditCardSubTotal;
    }

    public void setUsdCouponSubTotal(double usdCouponSubTotal) {
        this.usdCouponSubTotal = usdCouponSubTotal;
    }

    public void setUsdDepositSubTotal(double usdDepositSubTotal) {
        this.usdDepositSubTotal = usdDepositSubTotal;
    }

    private double usdCashTotal;

    public double getUsdCashTotal() {
        return usdCashTotal;
    }

    public double getUsdCheckTotal() {
        return usdCheckTotal;
    }

    public double getUsdCreditCardTotal() {
        return usdCreditCardTotal;
    }

    public double getUsdCouponTotal() {
        return usdCouponTotal;
    }

    public double getUsdDepositTotal() {
        return usdDepositTotal;
    }

    public double getUsdTotalPayments() {
        return usdTotalPayments;
    }

    public double getUsdCashSubTotal() {
        return usdCashSubTotal;
    }

    public double getUsdCheckSubTotal() {
        return usdCheckSubTotal;
    }

    public double getUsdCreditCardSubTotal() {
        return usdCreditCardSubTotal;
    }

    public double getUsdCouponSubTotal() {
        return usdCouponSubTotal;
    }

    public double getUsdDepositSubTotal() {
        return usdDepositSubTotal;
    }

    private double usdCheckTotal;
    private double usdCreditCardTotal;
    private double usdCouponTotal;
    private double usdDepositTotal;
    private double usdTotalPayments;
    private double usdCashSubTotal;
    private double usdCheckSubTotal;
    private double usdCreditCardSubTotal;
    private double usdCouponSubTotal;
    private double usdDepositSubTotal;
    /** Holds value of property recStatus. */
    public Collection getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Collection preStatus) {
        this.preStatus = preStatus;
    }

    private String sortColumn;
    private String sortDirection;

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    // Field for select Freight or OAC values
    // It will show Freight by default

    private String showFreightOAC = "FRE";

    public String getShowFreightOAC() {
        return showFreightOAC;
    }

    public void setShowFreightOAC(String showFreightOAC) {
        this.showFreightOAC = showFreightOAC;
    }

    public List getOacs() {
        return oacs;
    }

    public void setOacs(List oacs) {
        this.oacs = oacs;
    }

    public Collection getOacStatus() {
        return oacStatus;
    }

    public void setOacStatus(Collection oacStatus) {
        this.oacStatus = oacStatus;
    }

    /** TOTALS FIELDS FOR OACS PAYMENTS **/
        private double oacCashTotal;
        private double oacDepositTotal;
        private double oacCreditCardTotal;
        private double oacCheckTotal;
        private double oacCashSubTotal;
        private double oacDepositSubTotal;
        private double oacCreditCardSubTotal;
        private double oacCheckSubTotal;

        private double usdOacCashTotal;
        private double usdOacDepositTotal;
        private double usdOacCreditCardTotal;
        private double usdOacCheckTotal;
        private double usdOacCashSubTotal;
        private double usdOacDepositSubTotal;
        private double usdOacCreditCardSubTotal;
        private double usdOacCheckSubTotal;

        private double oacTotalPayments;
        private double usdOacTotalPayments;

    public void setOacCashTotal(double oacCashTotal) {
        this.oacCashTotal = oacCashTotal;
    }

    public void setOacDepositTotal(double oacDepositTotal) {
        this.oacDepositTotal = oacDepositTotal;
    }

    public void setOacCheckTotal(double oacCheckTotal) {
        this.oacCheckTotal = oacCheckTotal;
    }

    public void setOacCreditCardTotal(double oacCreditCardTotal) {
        this.oacCreditCardTotal = oacCreditCardTotal;
    }

    public void setOacCashSubTotal(double oacCashSubTotal) {
        this.oacCashSubTotal = oacCashSubTotal;
    }

    public void setOacDepositSubTotal(double oacDepositSubTotal) {
        this.oacDepositSubTotal = oacDepositSubTotal;
    }

    public void setOacCreditCardSubTotal(double oacCreditCardSubTotal) {
        this.oacCreditCardSubTotal = oacCreditCardSubTotal;
    }

    public void setOacCheckSubTotal(double oacCheckSubTotal) {
        this.oacCheckSubTotal = oacCheckSubTotal;
    }

    public void setOacTotalPayments(double oacTotalPayments) {
        this.oacTotalPayments = oacTotalPayments;
    }

    public double getOacCashTotal() {
        return oacCashTotal;
    }

    public double getOacDepositTotal() {
        return oacDepositTotal;
    }

    public double getOacCreditCardTotal() {
        return oacCreditCardTotal;
    }

    public double getOacCheckTotal() {
        return oacCheckTotal;
    }

    public double getOacCashSubTotal() {
        return oacCashSubTotal;
    }

    public double getOacDepositSubTotal() {
        return oacDepositSubTotal;
    }

    public double getOacCreditCardSubTotal() {
        return oacCreditCardSubTotal;
    }

    public double getOacCheckSubTotal() {
        return oacCheckSubTotal;
    }

    public double getOacTotalPayments() {
        return oacTotalPayments;
    }

    public void setUsdOacCashTotal(double usdOacCashTotal) {
        this.usdOacCashTotal = usdOacCashTotal;
    }

    public void setUsdOacDepositTotal(double usdOacDepositTotal) {
        this.usdOacDepositTotal = usdOacDepositTotal;
    }

    public void setUsdOacCreditCardTotal(double usdOacCreditCardTotal) {
        this.usdOacCreditCardTotal = usdOacCreditCardTotal;
    }

    public void setUsdOacCheckTotal(double usdOacCheckTotal) {
        this.usdOacCheckTotal = usdOacCheckTotal;
    }

    public void setUsdOacCashSubTotal(double usdOacCashSubTotal) {
        this.usdOacCashSubTotal = usdOacCashSubTotal;
    }

    public void setUsdOacDepositSubTotal(double usdOacDepositSubTotal) {
        this.usdOacDepositSubTotal = usdOacDepositSubTotal;
    }

    public void setUsdOacCreditCardSubTotal(double usdOacCreditCardSubTotal) {
        this.usdOacCreditCardSubTotal = usdOacCreditCardSubTotal;
    }

    public double getUsdOacCashSubTotal() {
        return usdOacCashSubTotal;
    }

    public double getUsdOacDepositSubTotal() {
        return usdOacDepositSubTotal;
    }

    public double getUsdOacCreditCardSubTotal() {
        return usdOacCreditCardSubTotal;
    }

    public double getUsdOacTotalPayments() {
        return usdOacTotalPayments;
    }

    public void setUsdOacTotalPayments(double usdOacTotalPayments) {
        this.usdOacTotalPayments = usdOacTotalPayments;
    }

    public double getUsdOacCashTotal() {
        return usdOacCashTotal;
    }

    public double getUsdOacDepositTotal() {
        return usdOacDepositTotal;
    }

    public double getUsdOacCreditCardTotal() {
        return usdOacCreditCardTotal;
    }

    public double getUsdOacCheckTotal() {
        return usdOacCheckTotal;
    }

    public void setUsdOacCheckSubTotal(double usdOacCheckSubTotal) {
        this.usdOacCheckSubTotal = usdOacCheckSubTotal;
    }

    public double getUsdOacCheckSubTotal() {
        return usdOacCheckSubTotal;
    }

    /** GRAND TOTALS**/
    private double grandTotal;
    private double usdGrandTotal;

    private double grandCoupon;
    private double grandCash;
    private double grandCheck;
    private double grandCreditCard;
    private double grandDeposit;

    private double usdGrandCoupon;
    private double usdGrandCash;
    private double usdGrandCheck;
    private double usdGrandCreditCard;
    private double usdGrandDeposit;

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setUsdGrandTotal(double usdGrandTotal) {
        this.usdGrandTotal = usdGrandTotal;
    }

    public double getUsdGrandTotal() {
        return usdGrandTotal;
    }

    public void setGrandCoupon(double grandCoupon) {
        this.grandCoupon = grandCoupon;
    }

    public void setGrandCash(double grandCash) {
        this.grandCash = grandCash;
    }

    public void setGrandCreditCard(double grandCreditCard) {
        this.grandCreditCard = grandCreditCard;
    }

    public void setGrandCheck(double grandCheck) {
        this.grandCheck = grandCheck;
    }

    public void setGrandDeposit(double grandDeposit) {
        this.grandDeposit = grandDeposit;
    }

    public void setUsdGrandCoupon(double usdGrandCoupon) {
        this.usdGrandCoupon = usdGrandCoupon;
    }

    public void setUsdGrandCash(double usdGrandCash) {
        this.usdGrandCash = usdGrandCash;
    }

    public void setUsdGrandCheck(double usdGrandCheck) {
        this.usdGrandCheck = usdGrandCheck;
    }

    public void setUsdGrandCreditCard(double usdGrandCreditCard) {
        this.usdGrandCreditCard = usdGrandCreditCard;
    }

    public void setUsdGrandDeposit(double usdGrandDeposit) {
        this.usdGrandDeposit = usdGrandDeposit;
    }

    public double getGrandCoupon() {
        return grandCoupon;
    }

    public double getGrandCash() {
        return grandCash;
    }

    public double getGrandCheck() {
        return grandCheck;
    }

    public double getGrandCreditCard() {
        return grandCreditCard;
    }

    public double getGrandDeposit() {
        return grandDeposit;
    }

    public double getUsdGrandCoupon() {
        return usdGrandCoupon;
    }

    public double getUsdGrandCash() {
        return usdGrandCash;
    }

    public double getUsdGrandCheck() {
        return usdGrandCheck;
    }

    public double getUsdGrandCreditCard() {
        return usdGrandCreditCard;
    }

    public double getUsdGrandDeposit() {
        return usdGrandDeposit;
    }  
}

