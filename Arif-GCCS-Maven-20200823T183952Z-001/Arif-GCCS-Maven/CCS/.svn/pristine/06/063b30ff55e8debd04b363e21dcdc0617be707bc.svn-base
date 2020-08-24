package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import java.util.*;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.ListUtils;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.BankVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryCurrencyVO;

/**
 * Admin Bank Account screen form class
 * 
 * @author  Arturo Gonzalez
 */

public class AdminAccountForm extends ActionForm implements java.io.Serializable{
    
    private List bankByCountry=ListUtils.lazyList(new ArrayList(),new Factory() {
        								  public Object create(){
        								      	 return new BankVO();
    									  }});
    
    private List supportedCurrencies=ListUtils.lazyList(new ArrayList(),new Factory() {
		  								public Object create(){
		  								    	return new CountryCurrencyVO();
		  								  }});
    
    private Object[] locationsByCountry;

    private Object[] locationsSelected;
    
    private String country;
    private Integer bankId;
    private String accountNbr;
    private String brach;
    private String currency;
    private Integer accountCd;
    /*
     * Introduced a new field Orgination Number
     * Changes Done By : Kapil R
     */
    private String originationNbr;
    
   // private Object[]  locationsCd;
   // private Object[] locationsCdSelected;
    
    /**
     * @return Returns the accountNbr.
     */
    public String getAccountNbr() {
        return accountNbr;
    }
    /**
     * @param accountNbr The accountNbr to set.
     */
    public void setAccountNbr(String accountNbr) {
        this.accountNbr = accountNbr;
    }
    /**
     * @return Returns the bankbyCountry.
     */
    public List getBankByCountry() {
        return bankByCountry;
    }
    /**
     * @param bankbyCountry The bankbyCountry to set.
     */
    public void setBankByCountry(List bankbyCountry) {
        this.bankByCountry = bankbyCountry;
    }
    /**
     * @return Returns the bankId.
     */
    public Integer getBankId() {
        return bankId;
    }
    /**
     * @param bankId The bankId to set.
     */
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
    /**
     * @return Returns the brach.
     */
    public String getBrach() {
        return brach;
    }
    /**
     * @param brach The brach to set.
     */
    public void setBrach(String brach) {
        this.brach = brach;
    }
    /**
     * @return Returns the country.
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return Returns the currency.
     */
    public String getCurrency() {
        return currency;
    }
    /**
     * @param currency The currency to set.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    /**
     * @return Returns the locationsByCountry.
     */
    public Object[] getLocationsByCountry() {
        return locationsByCountry;
    }
    /**
     * @param locationsByCountry The locationsByCountry to set.
     */
    public void setLocationsByCountry(Object[] locationsByCountry) {
        this.locationsByCountry = locationsByCountry;
    }
    /**
     * @return Returns the locationsSelected.
     */
    public Object[] getLocationsSelected() {
        return locationsSelected;
    }
    /**
     * @param locationsSelected The locationsSelected to set.
     */
    public void setLocationsSelected(Object[] locationsSelected) {
        this.locationsSelected = locationsSelected;
    }
    /**
     * @return Returns the accountCd.
     */
    public Integer getAccountCd() {
        return accountCd;
    }
    /**
     * @param accountCd The accountCd to set.
     */
    public void setAccountCd(Integer accountCd) {
        this.accountCd = accountCd;
    }
    /**
     * @return Returns the supportedCurrencies.
     */
    public List getSupportedCurrencies() {
        return supportedCurrencies;
    }
    /**
     * @param supportedCurrencies The supportedCurrencies to set.
     */
    public void setSupportedCurrencies(List supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }
    
    /**
	 * @return Origination Number
	 */
    public String getOriginationNbr() {
		return originationNbr;
	}
    
    /**
	 * @param Origination
	 *            Number
	 */
	public void setOriginationNbr(String originationNbr) {
		this.originationNbr = originationNbr;
	}
    
 }
