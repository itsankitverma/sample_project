package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.LocationException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO;
public class LocationManagerBeanTest {

	LocationManagerBean locationManagerBean = new LocationManagerBean();
	
	LocationVO locationVO = getVO();
	
	public LocationVO getVO() {
		LocationVO locationVO = new LocationVO();
		locationVO.setLocationCd("SQLWH");
		return locationVO;
	}
	
	@Test
	public void testSetLocation() throws BusinessDelegateException, LocationException {
		locationManagerBean.setLocation(locationVO);
	}
	
	@Test
	public void testGetLocation() throws BusinessDelegateException, FinderException {
		String locationCd = "SQLWH";
		locationManagerBean.getLocation(locationCd);
	}

	@Test
	public void testAddEmployee() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		String employeeId = null;
		locationManagerBean.addEmployee(locationCd, employeeId);
	}
	
	@Test
	public void testRemoveEmployee() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		String employeeId = null;
		locationManagerBean.removeEmployee(locationCd, employeeId);
	}
	
	@Test
	public void testGetEmployees() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		locationManagerBean.getEmployees(locationCd);
	}
	
	@Test
	public void testAddPaymentType() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		int paymentTypeId = 0;
		locationManagerBean.addPaymentType(locationCd, paymentTypeId);
	}
	
	@Test
	public void testRemovePaymentType() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		int paymentTypeId = 0;
		locationManagerBean.removePaymentType(locationCd, paymentTypeId);
	}
	
	@Test
	public void testGetPaymentTypes() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		locationManagerBean.getPaymentTypes(locationCd);
	}
	
	@Test
	public void testAddBankAcc() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		int bankAccountCd = 0;
		locationManagerBean.addBankAcc(locationCd, bankAccountCd);
	}
	
	@Test
	public void testRemoveBankAcc() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		int bankAccountCd = 0;
		locationManagerBean.removeBankAcc(locationCd, bankAccountCd);
	}
	
	@Test
	public void testGetBankAccs() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		locationManagerBean.getBankAccs(locationCd);
	}
	
	@Test
	public void testAddDepTempl() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		int templId = 0;
		locationManagerBean.addDepTempl(locationCd, templId);
	}
	
	@Test
	public void testRemoveDepTempl() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		int templId = 0;
		locationManagerBean.removeDepTempl(locationCd, templId);
	}
	
	@Test
	public void testGetDepTempls() throws BusinessDelegateException, LocationException {
		String locationCd = "SQLWH";
		locationManagerBean.getDepTempls(locationCd);
	}
	
	@Test
	public void testGetAllLocations() throws BusinessDelegateException {
		locationManagerBean.getAllLocations();
	}
	
	@Test
	public void testGetLocationByCountryCd() throws BusinessDelegateException {
		String countryCd = "SQLWH";
		locationManagerBean.getLocationByCountryCd(countryCd);
	}
	
	@Test
	public void testGetAllParentLocations() throws BusinessDelegateException {
		String employeeId = "945053";
		locationManagerBean.getAllParentLocations(employeeId);
	}
	
	@Test
	public void testGetAllPossibleParentLocationsByCountry() throws BusinessDelegateException {
		String locCd = null;
		String countryCd = "SQLWH";
		locationManagerBean.getAllPossibleParentLocationsByCountry(locCd, countryCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException, RemoveException {
		String locationCd = "SQLWH";
		locationManagerBean.removeLocation(locationCd);
	}
	
	@Test
	public void testUpdateLocation() throws BusinessDelegateException, LocationException {
		locationManagerBean.updateLocation(locationVO);
	}
}
