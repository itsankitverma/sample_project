package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO;

public class LocationControllerTest {

	LocationController locationController = new LocationController();
	
	LocationVO locationVO = getVO();
	
	public LocationVO getVO() {
		LocationVO locationVO = new LocationVO();
		locationVO.setLocationCd("SQLWH");
		return locationVO;
	}
	
	@Test
	public void testSetLocation() throws BusinessDelegateException {
		locationController.setLocation(locationVO);
	}
	
	@Test
	public void testGetLocation() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		locationController.getLocation(locationCd);
	}

	@Test
	public void testAddEmployee() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		String employeeId = null;
		locationController.addEmployee(locationCd, employeeId);
	}
	
	@Test
	public void testRemoveEmployee() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		String employeeId = null;
		locationController.removeEmployee(locationCd, employeeId);
	}
	
	@Test
	public void testGetEmployees() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		locationController.getEmployees(locationCd);
	}
	
	@Test
	public void testAddPaymentType() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		int paymentTypeId = 0;
		locationController.addPaymentType(locationCd, paymentTypeId);
	}
	
	@Test
	public void testRemovePaymentType() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		int paymentTypeId = 0;
		locationController.removePaymentType(locationCd, paymentTypeId);
	}
	
	@Test
	public void testGetPaymentTypes() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		locationController.getPaymentTypes(locationCd);
	}
	
	@Test
	public void testAddBankAcc() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		int bankAccountCd = 0;
		locationController.addBankAcc(locationCd, bankAccountCd);
	}
	
	@Test
	public void testRemoveBankAcc() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		int bankAccountCd = 0;
		locationController.removeBankAcc(locationCd, bankAccountCd);
	}
	
	@Test
	public void testGetBankAccs() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		locationController.getBankAccs(locationCd);
	}
	
	@Test
	public void testAddDepTempl() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		int templId = 0;
		locationController.addDepTempl(locationCd, templId);
	}
	
	@Test
	public void testRemoveDepTempl() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		int templId = 0;
		locationController.removeDepTempl(locationCd, templId);
	}
	
	@Test
	public void testGetDepTempls() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		locationController.getDepTempls(locationCd);
	}
	
	@Test
	public void testGetAllLocations() throws BusinessDelegateException {
		locationController.getAllLocations();
	}
	
	@Test
	public void testGetLocationByCountryCd() throws BusinessDelegateException {
		String countryCd = "SQLWH";
		locationController.getLocationByCountryCd(countryCd);
	}
	
	@Test
	public void testGetAllParentLocations() throws BusinessDelegateException {
		String employeeId = "945053";
		locationController.getAllParentLocations(employeeId);
	}
	
	@Test
	public void testGetAllPossibleParentLocationsByCountry() throws BusinessDelegateException {
		String locCd = null;
		String countryCd = "SQLWH";
		locationController.getAllPossibleParentLocationsByCountry(locCd, countryCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException {
		String locationCd = "SQLWH";
		locationController.removeLocation(locationCd);
	}
	
	@Test
	public void testUpdateLocation() throws BusinessDelegateException {
		locationController.updateLocation(locationVO);
	}
	
	@Test
	public void testGetLocationManager() throws BusinessDelegateException {
		locationController.getLocationManager();
	}
}
