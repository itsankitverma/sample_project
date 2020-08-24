package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryCurrencyVO;

public class CountryCurrencyControllerTest {

	CountryCurrencyController countryCurrencyController = new CountryCurrencyController();
	
	CountryCurrencyVO countryCurrencyVO = getVO();
	
	private CountryCurrencyVO getVO() {
		CountryCurrencyVO countryCurrencyVO = new CountryCurrencyVO();
		countryCurrencyVO.setCntryCurrencyId(156);
		countryCurrencyVO.setCountryCd("IN");
		countryCurrencyVO.setCurrencyCd("INR");
		countryCurrencyVO.setCurrencyNm("Indian Rupee");
		countryCurrencyVO.setCurrencySymbol("$");
		countryCurrencyVO.setCurrencyValidSince(null);
		countryCurrencyVO.setExchRateMax(0.00000001);
		countryCurrencyVO.setExchRateMin(10000000);
		return countryCurrencyVO;
	}
	
	@Test
	public void testSetCountryCurrency() throws BusinessDelegateException {
		countryCurrencyController.setCountryCurrency(countryCurrencyVO);
	}
	
	@Test
	public void testGetCountryCurrency() throws BusinessDelegateException {
		int cntryCurrencyId = 156;
		countryCurrencyController.getCountryCurrency(cntryCurrencyId);
	}
	
	@Test
	public void testGetExchangeRates() throws BusinessDelegateException {
		int cntryCurrencyId = 156;
		countryCurrencyController.getExchangeRates(cntryCurrencyId);
	}
	
	@Test
	public void testGetAllCountryCurrency() throws BusinessDelegateException {
		countryCurrencyController.getAllCountryCurrency();
	}
	
	@Test
	public void testRemoveCountryCurrency() throws BusinessDelegateException {
		int cntryCurrencyId = 156;
		countryCurrencyController.removeCountryCurrency(cntryCurrencyId);
	}
	
	@Test
	public void testUpdateCountryCurrency() throws BusinessDelegateException {
		countryCurrencyController.updateCountryCurrency(countryCurrencyVO);
	}
	
	@Test
	public void testGetCountryCurrencyManager() throws BusinessDelegateException {
		countryCurrencyController.getCountryCurrencyManager();
	}
	
}
