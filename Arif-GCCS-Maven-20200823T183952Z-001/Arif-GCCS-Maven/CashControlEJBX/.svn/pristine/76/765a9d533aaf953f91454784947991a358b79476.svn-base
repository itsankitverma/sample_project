/**
 * @(#)BankAccVO.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the bank_acc table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.valueobject;

import java.util.*;

public class BankAccVO implements java.io.Serializable {

	private Integer _bankAccountCd;
	private String _accountNbr;
	private String _bankBranchId;
	private String _currencyType;
	private Integer _bankId;
	/*
     * Introduced a new field Orgination Number
     * Changes Done Kapil R
     */
	private String _originationNbr;

	public BankAccVO() {
	}

	public BankAccVO(Integer bankAccountCd, String accountNbr,
			String bankBranchId, String currencyType, Integer bankId) {
		_bankAccountCd = bankAccountCd;
		_accountNbr = accountNbr;
		_bankBranchId = bankBranchId;
		_currencyType = currencyType;
		_bankId = bankId;
	}
	
	/*
     * Introduced a new field Orgination Number
     * Changes Done Kapil R
     */
	public BankAccVO(Integer bankAccountCd, String accountNbr,
			String bankBranchId, String currencyType, Integer bankId, String originationNbr) {
		_bankAccountCd = bankAccountCd;
		_accountNbr = accountNbr;
		_bankBranchId = bankBranchId;
		_currencyType = currencyType;
		_bankId = bankId;
		_originationNbr = originationNbr;
	}

	/**
	 * Set the value of bankAccountCd
	 */
	public void setBankAccountCd(Integer bankAccountCd) {
		_bankAccountCd = bankAccountCd;
	}

	/**
	 * Get the value of bankAccountCd
	 */
	public Integer getBankAccountCd() {
		return _bankAccountCd;
	}

	/**
	 * Set the value of accountNbr
	 */
	public void setAccountNbr(String accountNbr) {
		_accountNbr = accountNbr;
	}

	/**
	 * Get the value of accountNbr
	 */
	public String getAccountNbr() {
		return _accountNbr;
	}

	/**
	 * Set the value of bankBranchId
	 */
	public void setBankBranchId(String bankBranchId) {
		_bankBranchId = bankBranchId;
	}

	/**
	 * Get the value of bankBranchId
	 */
	public String getBankBranchId() {
		return _bankBranchId;
	}

	/**
	 * Set the value of currencyType
	 */
	public void setCurrencyType(String currencyType) {
		_currencyType = currencyType;
	}

	/**
	 * Get the value of currencyType
	 */
	public String getCurrencyType() {
		return _currencyType;
	}

	/**
	 * Set the value of bankId
	 */
	public void setBankId(Integer bankId) {
		_bankId = bankId;
	}

	/**
	 * Get the value of bankId
	 */
	public Integer getBankId() {
		return _bankId;
	}

	/**
	 * Get the value of the primary key
	 */
	public Integer getBankAccPK() {
		return _bankAccountCd;
	}

	/**
	 * @return Origination Number
	 */
	public String getOriginationNbr() {
		return _originationNbr;
	}

	/**
	 * @param Origination
	 *            Number
	 */
	public void setOriginationNbr(String _originationNbr) {
		this._originationNbr = _originationNbr;
	}

	/**
	 * Returns a string representation of the value object.
	 */
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("BankAccountCd: " + _bankAccountCd);
		stringBuffer.append("AccountNbr: " + _accountNbr);
		stringBuffer.append("BankBranchId: " + _bankBranchId);
		stringBuffer.append("CurrencyType: " + _currencyType);
		stringBuffer.append("BankId: " + _bankId);
		return stringBuffer.toString();
	}

}
