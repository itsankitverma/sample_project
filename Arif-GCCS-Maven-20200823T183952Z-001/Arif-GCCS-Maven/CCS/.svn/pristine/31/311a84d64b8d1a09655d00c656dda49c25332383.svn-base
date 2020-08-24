package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;

import java.util.*;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.ListUtils;
import javax.servlet.http.HttpServletRequest;
import com.fedex.lacitd.cashcontrol.biztier.common.BankAccountLocationVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.BankVO;

/**
 * Admin Bank Account screen form class
 * 
 * @author  Arturo Gonzalez
 */

public class AdminBankAccountForm extends ActionForm implements java.io.Serializable{
    
    private List banks=ListUtils.lazyList(new ArrayList(),new Factory() {
        								  public Object create(){
        								      	 return new BankVO();
    									  }});
    
    private List locations=ListUtils.lazyList(new ArrayList(),new Factory() {
        									  public Object create() {
        									      	 return new LocationVO();
        									  }});

    private List bankAccounts=ListUtils.lazyList(new ArrayList(), new Factory(){
        										 public Object create(){
        												return new BankAccountLocationVO();
        										 }});
    
    private String country;
    
    private String location;
    
    private Integer bank;
    
    private Integer accountCd;
    
    /**
     * @return Returns the bankAccounts.
     */
    public List getBankAccounts() {
        return bankAccounts;
    }
    /**
     * @param bankAccounts The bankAccounts to set.
     */
    public void setBankAccounts(List bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
    /**
     * @return Returns the banks.
     */
    public List getBanks() {
        return banks;
    }
    /**
     * @param banks The banks to set.
     */
    public void setBanks(List banks) {
        this.banks = banks;
    }
    /**
     * @return Returns the locations.
     */
    public List getLocations() {
        return locations;
    }
    /**
     * @param locations The locations to set.
     */
    public void setLocations(List locations) {
        this.locations = locations;
    }
    /**
     * @return Returns the countryCd.
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param countryCd The countryCd to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return Returns the locationCd.
     */
    public String getLocation() {
        return location;
    }
    /**
     * @param locationCd The locationCd to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * @return Returns the bank.
     */
    public Integer getBank() {
        return bank;
    }
    /**
     * @param bank The bank to set.
     */
    public void setBank(Integer bank) {
        this.bank = bank;
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
 }
