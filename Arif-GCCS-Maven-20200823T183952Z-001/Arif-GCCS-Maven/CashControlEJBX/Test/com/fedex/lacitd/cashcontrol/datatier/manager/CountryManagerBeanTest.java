package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.CountryException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryVO;

public class CountryManagerBeanTest {

	CountryManagerBean countryManagerBean = new CountryManagerBean();
	
	CountryVO countryVO = getVO();
	
	public CountryVO getVO() {
		CountryVO countryVO = new CountryVO();
		countryVO.setCodUsedFlag(0);
		countryVO.setCollectlaterFlag(0);
		countryVO.setCountryCd("NO");
		countryVO.setCountryNm("NORWAY");
		return countryVO;
	}
	
	@Test
	public void testSetCountry() throws BusinessDelegateException, CountryException {
		CountryVO countryVO = new CountryVO();
		countryManagerBean.setCountry(countryVO);
	}

	
	@Test
	public void testGetCountry() throws BusinessDelegateException, FinderException {
		String countryCd = "NO";
		countryManagerBean.getCountry(countryCd);
	}
	
	@Test
	public void testGetBanks() throws BusinessDelegateException, CountryException {
		String countryCd = "NO";
		countryManagerBean.getBanks(countryCd);
	}
	
	@Test
	public void testGetCountryCurrency() throws BusinessDelegateException, CountryException {
		String countryCd = "NO";
		countryManagerBean.getCountryCurrency(countryCd);
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException, CountryException {
		String countryCd = "NO";
		countryManagerBean.getLocations(countryCd);
	}
	
	@Test
	public void testGetAllCountry() throws BusinessDelegateException {
		countryManagerBean.getAllCountry();
	}
	
	@Test
	public void testRemoveCountry() throws BusinessDelegateException, RemoveException {
		String countryCd = "NO";
		countryManagerBean.removeCountry(countryCd);
	}
	
	@Test
	public void testUpdateCountry() throws BusinessDelegateException, CountryException {
		CountryVO countryVO = new CountryVO();
		countryManagerBean.updateCountry(countryVO);
	}

}

