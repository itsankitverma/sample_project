package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryVO;

public class CountryControllerTest {

	CountryController countryController = new CountryController();
	
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
	public void testSetCountry() throws BusinessDelegateException {
		CountryVO countryVO = new CountryVO();
		countryController.setCountry(countryVO);
	}

	
	@Test
	public void testGetCountry() throws BusinessDelegateException {
		String countryCd = "NO";
		countryController.getCountry(countryCd);
	}
	
	@Test
	public void testGetBanks() throws BusinessDelegateException {
		String countryCd = "NO";
		countryController.getBanks(countryCd);
	}
	
	@Test
	public void testGetCountryCurrency() throws BusinessDelegateException {
		String countryCd = "NO";
		countryController.getCountryCurrency(countryCd);
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException {
		String countryCd = "NO";
		countryController.getLocations(countryCd);
	}
	
	@Test
	public void testGetAllCountry() throws BusinessDelegateException {
		countryController.getAllCountry();
	}
	
	@Test
	public void testRemoveCountry() throws BusinessDelegateException {
		String countryCd = "NO";
		countryController.removeCountry(countryCd);
	}
	
	@Test
	public void testUpdateCountry() throws BusinessDelegateException {
		CountryVO countryVO = new CountryVO();
		countryController.updateCountry(countryVO);
	}
	
	@Test
	public void testGetCountryManager() throws BusinessDelegateException {
		countryController.getCountryManager();
	}
}
