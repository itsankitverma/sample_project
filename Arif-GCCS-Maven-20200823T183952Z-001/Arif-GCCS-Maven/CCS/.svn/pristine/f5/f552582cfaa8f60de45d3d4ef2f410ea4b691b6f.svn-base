package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import com.fedex.lacitd.cashcontrol.biztier.common.GroundDetailsTableVO;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.ListUtils;
import org.apache.struts.action.ActionForm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Ground detail screen form class
 *
 * @author arturog
 */
public class GroundCashRecapForm extends ActionForm implements java.io.Serializable {
    private List trackNbrs = ListUtils.lazyList(new ArrayList(), new Factory() {
        public Object create() {
            return new GroundDetailsTableVO();
        }
    });

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

    /*
    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    private String custNm;

    public String getCustNmPrev() {
        return custNmPrev;
    }

    public void setCustNmPrev(String custNmPrev) {
        this.custNmPrev = custNmPrev;
    }

    private String  custNmPrev ;
    */
    private double checkTotal;

    /**
     * Holds value of property totalLocalAppliedAmount.
     */
    private double cashTotal;

    /**
     * Holds value of property totalUsdExpectedAmount.
     */
    private java.util.Collection supportedCurrencies;

    /**
     * Holds value of property totalUsdAppliedAmount.
     */
    private double totalPayments;

    /**
     * Holds value of property currentCurrency.
     */
    private String currentCurrency;

    /**
     * Holds value of property courier.
     */
    private String courier;

    /**
     * Holds value of property grnStatus.
     */
    private java.util.Collection grnStatus;

    /**
     * Holds value of property courierName.
     */
    private String courierName;

    /**
     * Holds value of property currentlyUsedCurrencies.
     */
    private java.util.Collection currentlyUsedCurrencies;

    /**
     * Holds value of property creditCardTotal.
     */
    private double creditCardTotal;

    /**
     * Holds value of property couponTotal.
     */
    private double couponTotal;

    /**
     * Holds value of property previousCurrencyCode.
     */
    private String previousCurrencyCode;

    /**
     * Holds value of property canClose.
     */
    private boolean canClose;

    /**
     * Holds value of property cashSubTotal.
     */
    private double cashSubTotal;

    /**
     * Holds value of property checkSubTotal.
     */
    private double checkSubTotal;

    /**
     * Holds value of property couponSubTotal.
     */
    private double couponSubTotal;

    /**
     * Holds value of property creditCardSubTotal.
     */
    private double creditCardSubTotal;

    /**
     * Holds value of property employeesWithPayments.
     */
    private java.util.Collection employeesWithPayments;

    /**
     * Holds value of property paymentTypes.
     */
    private java.util.Collection paymentTypes;

    private double depositSubTotal;

    private double depositTotal;

    /**
     * Holds value of property countryBanks.
     */
    private java.util.Collection countryBanks;

    private boolean dualCurrency = false;

    public void setCountryBanks(Collection cb) {
        this.countryBanks = cb;
    }

    public Collection getCountryBanks() {
        return this.countryBanks;
    }

    public GroundCashRecapForm() {
    }

    public void setTrackNbrs(List trackNbrs) {
        this.trackNbrs = ListUtils.lazyList(trackNbrs, new Factory() {
            public Object create() {
                return new GroundDetailsTableVO();
            }
        });
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

    public List getTrackNbrs() {
        return trackNbrs;
    }

    /**
     * Getter for property totalLocalExpectedAmount.
     *
     * @return Value of property totalLocalExpectedAmount.
     */
    public double getCheckTotal() {
        return this.checkTotal;
    }

    /**
     * Setter for property totalLocalExpectedAmount.
     *
     * @param totalLocalExpectedAmount New value of property totalLocalExpectedAmount.
     */
    public void setCheckTotal(double checkTotal) {
        this.checkTotal = checkTotal;
    }

    /**
     * Getter for property totalLocalAppliedAmount.
     *
     * @return Value of property totalLocalAppliedAmount.
     */
    public double getCashTotal() {
        return this.cashTotal;
    }

    /**
     * Setter for property totalLocalAppliedAmount.
     *
     * @param totalLocalAppliedAmount New value of property totalLocalAppliedAmount.
     */
    public void setCashTotal(double cashTotal) {
        this.cashTotal = cashTotal;
    }

    /**
     * Getter for property totalUsdExpectedAmount.
     *
     * @return Value of property totalUsdExpectedAmount.
     */
    public java.util.Collection getSupportedCurrencies() {
        return this.supportedCurrencies;
    }

    /**
     * Setter for property totalUsdExpectedAmount.
     *
     * @param totalUsdExpectedAmount New value of property totalUsdExpectedAmount.
     */
    public void setSupportedCurrencies(java.util.Collection supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    /**
     * Getter for property totalUsdAppliedAmount.
     *
     * @return Value of property totalUsdAppliedAmount.
     */
    public double getTotalPayments() {
        return this.totalPayments;
    }

    /**
     * Setter for property totalUsdAppliedAmount.
     *
     * @param totalUsdAppliedAmount New value of property totalUsdAppliedAmount.
     */
    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }

    /**
     * Getter for property currentCurrency.
     *
     * @return Value of property currentCurrency.
     */
    public String getCurrentCurrency() {
        return this.currentCurrency;
    }

    /**
     * Setter for property currentCurrency.
     *
     * @param currentCurrency New value of property currentCurrency.
     */
    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    /**
     * Getter for property courier.
     *
     * @return Value of property courier.
     */
    public String getCourier() {
        return this.courier;
    }

    /**
     * Setter for property courier.
     *
     * @param courier New value of property courier.
     */
    public void setCourier(String courier) {
        this.courier = courier;
    }

    /**
     * Getter for property courierName.
     *
     * @return Value of property courierName.
     */
    public String getCourierName() {
        return this.courierName;
    }

    /**
     * Setter for property courierName.
     *
     * @param courierName New value of property courierName.
     */
    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    /**
     * Getter for property currentlyUsedCurrencies.
     *
     * @return Value of property currentlyUsedCurrencies.
     */
    public java.util.Collection getCurrentlyUsedCurrencies() {
        return this.currentlyUsedCurrencies;
    }

    /**
     * Setter for property currentlyUsedCurrencies.
     *
     * @param currentlyUsedCurrencies New value of property currentlyUsedCurrencies.
     */
    public void setCurrentlyUsedCurrencies(java.util.Collection currentlyUsedCurrencies) {
        this.currentlyUsedCurrencies = currentlyUsedCurrencies;
    }

    /**
     * Getter for property creditCardTotal.
     *
     * @return Value of property creditCardTotal.
     */
    public double getCreditCardTotal() {
        return this.creditCardTotal;
    }

    /**
     * Setter for property creditCardTotal.
     *
     * @param creditCardTotal New value of property creditCardTotal.
     */
    public void setCreditCardTotal(double creditCardTotal) {
        this.creditCardTotal = creditCardTotal;
    }

    /**
     * Getter for property couponTotal.
     *
     * @return Value of property couponTotal.
     */
    public double getCouponTotal() {
        return this.couponTotal;
    }

    /**
     * Setter for property couponTotal.
     *
     * @param couponTotal New value of property couponTotal.
     */
    public void setCouponTotal(double couponTotal) {
        this.couponTotal = couponTotal;
    }

    /**
     * Getter for property previousCurrencyCode.
     *
     * @return Value of property previousCurrencyCode.
     */
    public String getPreviousCurrencyCode() {
        return this.previousCurrencyCode;
    }

    /**
     * Setter for property previousCurrencyCode.
     *
     * @param previousCurrencyCode New value of property previousCurrencyCode.
     */
    public void setPreviousCurrencyCode(String previousCurrencyCode) {
        this.previousCurrencyCode = previousCurrencyCode;
    }

    /**
     * Getter for property canClose.
     *
     * @return Value of property canClose.
     */
    public boolean isCanClose() {
        return this.canClose;
    }

    /**
     * Setter for property canClose.
     *
     * @param canClose New value of property canClose.
     */
    public void setCanClose(boolean canClose) {
        this.canClose = canClose;
    }

    /**
     * Getter for property cashSubTotal.
     *
     * @return Value of property cashSubTotal.
     */
    public double getCashSubTotal() {
        return this.cashSubTotal;
    }

    /**
     * Setter for property cashSubTotal.
     *
     * @param cashSubTotal New value of property cashSubTotal.
     */
    public void setCashSubTotal(double cashSubTotal) {
        this.cashSubTotal = cashSubTotal;
    }

    /**
     * Getter for property checkSubTotal.
     *
     * @return Value of property checkSubTotal.
     */
    public double getCheckSubTotal() {
        return this.checkSubTotal;
    }

    /**
     * Setter for property checkSubTotal.
     *
     * @param checkSubTotal New value of property checkSubTotal.
     */
    public void setCheckSubTotal(double checkSubTotal) {
        this.checkSubTotal = checkSubTotal;
    }

    /**
     * Getter for property couponSubTotal.
     *
     * @return Value of property couponSubTotal.
     */
    public double getCouponSubTotal() {
        return this.couponSubTotal;
    }

    /**
     * Setter for property couponSubTotal.
     *
     * @param couponSubTotal New value of property couponSubTotal.
     */
    public void setCouponSubTotal(double couponSubTotal) {
        this.couponSubTotal = couponSubTotal;
    }

    /**
     * Getter for property creditCardSubTotal.
     *
     * @return Value of property creditCardSubTotal.
     */
    public double getCreditCardSubTotal() {
        return this.creditCardSubTotal;
    }

    /**
     * Setter for property creditCardSubTotal.
     *
     * @param creditCardSubTotal New value of property creditCardSubTotal.
     */
    public void setCreditCardSubTotal(double creditCardSubTotal) {
        this.creditCardSubTotal = creditCardSubTotal;
    }

    /**
     * Getter for property employeesWithPayments.
     *
     * @return Value of property employeesWithPayments.
     */
    public java.util.Collection getEmployeesWithPayments() {
        return this.employeesWithPayments;
    }

    /**
     * Setter for property employeesWithPayments.
     *
     * @param employeesWithPayments New value of property employeesWithPayments.
     */
    public void setEmployeesWithPayments(java.util.Collection employeesWithPayments) {
        this.employeesWithPayments = employeesWithPayments;
    }

    /**
     * Getter for property paymentTypes.
     *
     * @return Value of property paymentTypes.
     */
    public java.util.Collection getPaymentTypes() {
        return this.paymentTypes;
    }

    /**
     * Setter for property paymentTypes.
     *
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

    /**
     * Holds value of property grnStatus.
     */
    public Collection getGrnStatus() {
        return grnStatus;
    }

    public void setGrnStatus(Collection grnStatus) {
        this.grnStatus = grnStatus;
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
}
