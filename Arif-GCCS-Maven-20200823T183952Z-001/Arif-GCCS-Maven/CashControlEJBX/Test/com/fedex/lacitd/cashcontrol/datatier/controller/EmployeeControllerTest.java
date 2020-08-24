package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;

public class EmployeeControllerTest {
	
	EmployeeController employeeController = new EmployeeController();
	
	EmployeeVO employeeVO = getVO(); 
	
	public EmployeeVO getVO() {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmployeeId("458395");
		employeeVO.setEmployeeNm("Desi-Lee Bonterre");
		return employeeVO;
	}

	@Test
	public void testSetEmployee() throws BusinessDelegateException {
		employeeController.setEmployee(employeeVO);
	}

	@Test
	public void testGetEmployee() throws BusinessDelegateException {
		String employeeId = "458395";
		employeeController.getEmployee(employeeId);
	}
	
	@Test
	public void testGetDepositSlips() throws BusinessDelegateException {
		String employeeId = "458395";
		employeeController.getDepositSlips(employeeId);
	}
	
	@Test
	public void testAddLocation() throws BusinessDelegateException {
		String employeeId = "458395";
		String locationCd = "BOMA";
		employeeController.addLocation(employeeId, locationCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException {
		String employeeId = "458395";
		String locationCd = "BOMA";
		employeeController.removeLocation(employeeId, locationCd);
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException {
		String employeeId = "458395";
		employeeController.getLocations(employeeId);
	}
	
	@Test
	public void testGetAllEmployees() throws BusinessDelegateException {
		employeeController.getAllEmployees();
	}
	
	@Test
	public void testGetEmployeeAdminEmployees() throws BusinessDelegateException {
		employeeController.getEmployeeAdminEmployees();
	}
	
	@Test
	public void testGetEmployeeCountryAdminEmployees() throws BusinessDelegateException {
		String countryCd = "NO";
		employeeController.getEmployeeCountryAdminEmployees(countryCd);
	}

	@Test
	public void testRemoveEmployee() throws BusinessDelegateException {
		String employeeId = "458395";
		employeeController.removeEmployee(employeeId);
	}
	
	@Test
	public void testUpdateEmployee() throws BusinessDelegateException {
		employeeController.updateEmployee(employeeVO);
	}
	
	@Test
	public void testGetEmployeeManager() throws BusinessDelegateException {
		employeeController.getEmployeeManager();
	}
}
