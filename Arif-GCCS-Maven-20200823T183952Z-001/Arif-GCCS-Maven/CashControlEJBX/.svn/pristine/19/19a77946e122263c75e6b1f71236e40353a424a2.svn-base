package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.EmployeeException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;
public class EmployeeManagerBeanTest {
	
	EmployeeManagerBean employeeManagerBean = new EmployeeManagerBean();
	
	EmployeeVO employeeVO = getVO(); 
	
	public EmployeeVO getVO() {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmployeeId("458395");
		employeeVO.setEmployeeNm("Desi-Lee Bonterre");
		return employeeVO;
	}

	@Test
	public void testSetEmployee() throws BusinessDelegateException, EmployeeException {
		employeeManagerBean.setEmployee(employeeVO);
	}

	@Test
	public void testGetEmployee() throws BusinessDelegateException, FinderException {
		String employeeId = "458395";
		employeeManagerBean.getEmployee(employeeId);
	}
	
	@Test
	public void testGetDepositSlips() throws BusinessDelegateException, EmployeeException {
		String employeeId = "458395";
		employeeManagerBean.getDepositSlips(employeeId);
	}
	
	@Test
	public void testAddLocation() throws BusinessDelegateException, EmployeeException {
		String employeeId = "458395";
		String locationCd = "BOMA";
		employeeManagerBean.addLocation(employeeId, locationCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException, EmployeeException {
		String employeeId = "458395";
		String locationCd = "BOMA";
		employeeManagerBean.removeLocation(employeeId, locationCd);
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException, EmployeeException {
		String employeeId = "458395";
		employeeManagerBean.getLocations(employeeId);
	}
	
	@Test
	public void testGetAllEmployees() throws BusinessDelegateException {
		employeeManagerBean.getAllEmployees();
	}
	
	@Test
	public void testGetEmployeeAdminEmployees() throws BusinessDelegateException {
		employeeManagerBean.getEmployeeAdminEmployees();
	}
	
	@Test
	public void testGetEmployeeCountryAdminEmployees() throws BusinessDelegateException {
		String countryCd = "NO";
		employeeManagerBean.getEmployeeCountryAdminEmployees(countryCd);
	}

	@Test
	public void testRemoveEmployee() throws BusinessDelegateException, RemoveException {
		String employeeId = "458395";
		employeeManagerBean.removeEmployee(employeeId);
	}
	
	@Test
	public void testUpdateEmployee() throws BusinessDelegateException, EmployeeException {
		employeeManagerBean.updateEmployee(employeeVO);
	}
}

