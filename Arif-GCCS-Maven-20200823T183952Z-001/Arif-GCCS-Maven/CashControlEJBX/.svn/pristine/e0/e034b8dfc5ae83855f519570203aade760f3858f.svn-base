package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmpXLocationXRoleVO;

public class EmpXLocationXRoleControllerTest {
	
	EmpXLocationXRoleController empXLocationXRoleController = new EmpXLocationXRoleController();
	
	EmpXLocationXRoleVO empXLocationXRoleVO = getVO();
	
	public EmpXLocationXRoleVO getVO() {
		EmpXLocationXRoleVO empXLocationXRoleVO = new EmpXLocationXRoleVO();
		empXLocationXRoleVO.setEmployeeId("485731");
		empXLocationXRoleVO.setLocationCd("AAHA");
		empXLocationXRoleVO.setRoleId(5);
		return empXLocationXRoleVO; 
	}
	
	@Test
	public void testSetEmpXLocationXRole() throws BusinessDelegateException {
		empXLocationXRoleController.setEmpXLocationXRole(empXLocationXRoleVO);
	}

	@Test
	public void testGetEmpXLocationXRole() throws BusinessDelegateException {
		EmpXLocationXRolePK empXLocationXRolePK = new EmpXLocationXRolePK();
		empXLocationXRolePK.setEmployeeId("485731");
		empXLocationXRolePK.setLocationCd("AAHA");
		empXLocationXRolePK.setRoleId(5);
		empXLocationXRoleController.getEmpXLocationXRole(empXLocationXRolePK);
	}
	
	@Test
	public void testGetAllEmpXLocationXRoles() throws BusinessDelegateException {
		empXLocationXRoleController.getAllEmpXLocationXRoles();
	}
	
	@Test
	public void testGetEmpXLocationXRoleByRoleId() throws BusinessDelegateException {
		int roleId = 5;
		empXLocationXRoleController.getEmpXLocationXRoleByRoleId(roleId);
	}
	
	@Test
	public void testGetEmpXLocationXRoleByLocationCd() throws BusinessDelegateException {
		String locationCd = "AAHA";
		empXLocationXRoleController.getEmpXLocationXRoleByLocationCd(locationCd);
	}
	
	@Test
	public void testGetEmpXLocationXRoleByEmployeeId() throws BusinessDelegateException {
		String employeeId = "485731";
		empXLocationXRoleController.getEmpXLocationXRoleByEmployeeId(employeeId);
	}
	
	@Test
	public void testGetEmpXLocationXRoleByEmployeeAndLocation() throws BusinessDelegateException {
		String employeeId = "485731";
		String locationCd = "AAHA";
		empXLocationXRoleController.getEmpXLocationXRoleByEmployeeAndLocation(employeeId, locationCd);
	}
	
	@Test
	public void testRemoveEmpXLocationXRole() throws BusinessDelegateException {
		EmpXLocationXRolePK empXLocationXRolePK = new EmpXLocationXRolePK();
		empXLocationXRolePK.setEmployeeId("485731");
		empXLocationXRolePK.setLocationCd("AAHA");
		empXLocationXRolePK.setRoleId(5);
		empXLocationXRoleController.removeEmpXLocationXRole(empXLocationXRolePK);
	}
	
	@Test
	public void testUpdateEmpXLocationXRole() throws BusinessDelegateException {
		empXLocationXRoleController.updateEmpXLocationXRole(empXLocationXRoleVO);
	}
	
	@Test
	public void testGetEmpXLocationXRoleManager() throws BusinessDelegateException {
		empXLocationXRoleController.getEmpXLocationXRoleManager();
	}
	
}
