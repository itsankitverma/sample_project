package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.CountryCurrencyException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryCurrencyVO;

public class CountryCurrencyManagerBeanTest {

	CountryCurrencyManagerBean countryCurrencyManagerBean = new CountryCurrencyManagerBean();
		
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
		public void testSetCountryCurrency() throws BusinessDelegateException, CountryCurrencyException {
			countryCurrencyManagerBean.setCountryCurrency(countryCurrencyVO);
		}
		
		@Test
		public void testGetCountryCurrency() throws BusinessDelegateException, FinderException {
			int cntryCurrencyId = 156;
			countryCurrencyManagerBean.getCountryCurrency(cntryCurrencyId);
		}
		
		@Test
		public void testGetExchangeRates() throws BusinessDelegateException, CountryCurrencyException {
			int cntryCurrencyId = 156;
			countryCurrencyManagerBean.getExchangeRates(cntryCurrencyId);
		}
		
		@Test
		public void testGetAllCountryCurrency() throws BusinessDelegateException {
			countryCurrencyManagerBean.getAllCountryCurrency();
		}
		
		@Test
		public void testRemoveCountryCurrency() throws BusinessDelegateException, RemoveException {
			int cntryCurrencyId = 156;
			countryCurrencyManagerBean.removeCountryCurrency(cntryCurrencyId);
		}
		
		@Test
		public void testUpdateCountryCurrency() throws BusinessDelegateException, CountryCurrencyException {
			countryCurrencyManagerBean.updateCountryCurrency(countryCurrencyVO);
		}
		
}
