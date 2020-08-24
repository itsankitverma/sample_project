package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ExchangeRateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ExchangeRateVO;

public class ExchangeRateManagerBeanTest {
	
	ExchangeRateManagerBean exchangeRateManagerBean = new ExchangeRateManagerBean();

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
	public void testSetExchangeRate() throws BusinessDelegateException, ExchangeRateException {
		exchangeRateManagerBean.setExchangeRate(exchangeRateVO);
	}

	@Test
	public void testGetExchangeRate() throws BusinessDelegateException, FinderException {
		int exchRateId = 1;
		exchangeRateManagerBean.getExchangeRate(exchRateId);
	}
	
	@Test
	public void testGetAllExchangeRates() throws BusinessDelegateException {
		exchangeRateManagerBean.getAllExchangeRates();
	}
	
	@Test
	public void testRemoveExchangeRate() throws BusinessDelegateException, RemoveException {
		int exchRateId = 1;
		exchangeRateManagerBean.removeExchangeRate(exchRateId);
	}
	
	@Test
	public void testUpdateExchangeRate() throws BusinessDelegateException, ExchangeRateException {
		exchangeRateManagerBean.updateExchangeRate(exchangeRateVO);
	}
}
