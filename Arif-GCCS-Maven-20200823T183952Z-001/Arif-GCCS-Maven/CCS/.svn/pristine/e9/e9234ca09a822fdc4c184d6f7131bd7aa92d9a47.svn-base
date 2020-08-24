package com.fedex.lacitd.cashcontrol.prestier.struts.form;
 
import org.apache.struts.action.*;  
import org.apache.commons.collections.*;
import java.util.*;

import com.fedex.lacitd.cashcontrol.biztier.common.PoaSummaryTableVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

/**
 * POA Summary screen form class
 * @author  ccardenas
 */
public class PoaSummaryForm extends ActionForm implements java.io.Serializable{
    private List payments=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new PoaSummaryTableVO();
                                                                          }
                                                                        } );

	/**
	 * @return Returns the coupTotal.
	 */
	public double getCoupTotal() {
		return coupTotal;
	}
	/**
	 * @param coupTotal The coupTotal to set.
	 */
	public void setCoupTotal(double coupTotal) {
		this.coupTotal = coupTotal;
	}
    private double coupTotal;
    
    private double checkTotal;

    private double cashTotal;

    private double depositTotal;
    
    private java.util.Collection supportedCurrencies;

    private double totalPayments;
    
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
	 * @return Returns the newLocationCd.
	 */
	public String getNewLocationCd() {
		return newLocationCd;
	}
	/**
	 * @param newLocationCd The newLocationCd to set.
	 */
	public void setNewLocationCd(String newLocationCd) {
		this.newLocationCd = newLocationCd;
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
    
    private String newLocationCd;

    /** Holds value of property currentCurrency. */
    private String currentCurrency;

    /** Holds value of property courier. */
    private String courier;

    /** Holds value of property courierName. */
    private String courierName;

    /** Holds value of property currentlyUsedCurrencies. */
    private java.util.Collection currentlyUsedCurrencies;

    /** Holds value of property creditCardTotal. */
    private double creditCardTotal;
    
    /** Holds value of property previousCurrencyCode. */
    private String previousCurrencyCode;
    
    /** Holds value of property poaPaymentsId. */
    private int poaPaymentsId;
    
    /** Holds value of property employeesWithPayments. */
    private java.util.Collection employeesWithPayments;

    /** Holds value of property paymentTypes. */
    private java.util.Collection paymentTypes;

    public PoaSummaryForm() {
    }

    public void setPayments(List payments){
        this.payments = ListUtils.lazyList(payments,new Factory() {
                                                                        public Object create() {
                                                                           return new PoaPaymentVO();
                                                                        }
                                                                     } );
    }

    public List getPayments(){
        return payments;
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
    public Collection getSupportedCurrencies() {
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
    
    /** Getter for property poaPaymentsId.
     * @return Value of property poaPaymentsId.
     */
    public int getPoaPaymentsId() {
        return this.poaPaymentsId;
    }
    
    /** Setter for property poaPaymentsId.
     * @param poaPaymentsId New value of property poaPaymentsId.
     */
    public void setPoaPaymentsId(int poaPaymentsId) {
        this.poaPaymentsId = poaPaymentsId;
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

    public Collection getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(Collection paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    private Integer pageNumber;
    private Integer numberOfPages;
    private String sortColumn;
    private String sortDirection;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

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

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
