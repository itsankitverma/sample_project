package com.fedex.lacitd.cashcontrol.datatier.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ExchangeRateVO;

public class ExchangeRateControllerTest {
	
	ExchangeRateController exchangeRateController = new ExchangeRateController();

	ExchangeRateVO exchangeRateVO = getVO();
	
	public ExchangeRateVO getVO() {
		ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
		exchangeRateVO.setCntryCurrencyId(1);
		try {
			exchangeRateVO.setExchRate(new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		exchangeRateVO.setExchRateId(1);
		exchangeRateVO.setExchRateType("C");
		exchangeRateVO.setExchRtByUsd(740);
		return exchangeRateVO;
	}
	
	@Test
	public void testSetExchangeRate() throws BusinessDelegateException {
		exchangeRateController.setExchangeRate(exchangeRateVO);
	}

	@Test
	public void testGetExchangeRate() throws BusinessDelegateException {
		int exchRateId = 1;
		exchangeRateController.getExchangeRate(exchRateId);
	}
	
	@Test
	public void testGetAllExchangeRates() throws BusinessDelegateException {
		exchangeRateController.getAllExchangeRates();
	}
	
	@Test
	public void testRemoveExchangeRate() throws BusinessDelegateException {
		int exchRateId = 1;
		exchangeRateController.removeExchangeRate(exchRateId);
	}
	
	@Test
	public void testUpdateExchangeRate() throws BusinessDelegateException {
		exchangeRateController.updateExchangeRate(exchangeRateVO);
	}
	
	@Test
	public void testGetExchangeRateManager() throws BusinessDelegateException {
		exchangeRateController.getExchangeRateManager();
	}
	
}
