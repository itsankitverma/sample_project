package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.EmpXLocationXRolePK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.EmpXLocationXRoleException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmpXLocationXRoleVO;

public class EmpXLocationXRoleManagerBeanTest {
	
	EmpXLocationXRoleManagerBean empXLocationXRoleManagerBean = new EmpXLocationXRoleManagerBean();
	
	EmpXLocationXRoleVO empXLocationXRoleVO = getVO();
	
	public EmpXLocationXRoleVO getVO() {
		EmpXLocationXRoleVO empXLocationXRoleVO = new EmpXLocationXRoleVO();
		empXLocationXRoleVO.setEmployeeId("485731");
		empXLocationXRoleVO.setLocationCd("AAHA");
		empXLocationXRoleVO.setRoleId(5);
		return empXLocationXRoleVO; 
	}
	
	@Test
	public void testSetEmpXLocationXRole() throws BusinessDelegateException, EmpXLocationXRoleException {
		empXLocationXRoleManagerBean.setEmpXLocationXRole(empXLocationXRoleVO);
	}

	@Test
	public void testGetEmpXLocationXRole() throws BusinessDelegateException, FinderException {
		EmpXLocationXRolePK empXLocationXRolePK = new EmpXLocationXRolePK();
		empXLocationXRolePK.setEmployeeId("485731");
		empXLocationXRolePK.setLocationCd("AAHA");
		empXLocationXRolePK.setRoleId(5);
		empXLocationXRoleManagerBean.getEmpXLocationXRole(empXLocationXRolePK);
	}
	
	@Test
	public void testGetAllEmpXLocationXRoles() throws BusinessDelegateException {
		empXLocationXRoleManagerBean.getAllEmpXLocationXRoles();
	}
	
	@Test
	public void testGetEmpXLocationXRoleByRoleId() throws BusinessDelegateException {
		int roleId = 5;
		empXLocationXRoleManagerBean.getEmpXLocationXRoleByRoleId(roleId);
	}
	
	@Test
	public void testGetEmpXLocationXRoleByLocationCd() throws BusinessDelegateException {
		String locationCd = "AAHA";
		empXLocationXRoleManagerBean.getEmpXLocationXRoleByLocationCd(locationCd);
	}
	
	@Test
	public void testGetEmpXLocationXRoleByEmployeeId() throws BusinessDelegateException {
		String employeeId = "485731";
		empXLocationXRoleManagerBean.getEmpXLocationXRoleByEmployeeId(employeeId);
	}
	
	@Test
	public void testGetEmpXLocationXRoleByEmployeeAndLocation() throws BusinessDelegateException {
		String employeeId = "485731";
		String locationCd = "AAHA";
		empXLocationXRoleManagerBean.getEmpXLocationXRoleByEmployeeAndLocation(employeeId, locationCd);
	}
	
	@Test
	public void testRemoveEmpXLocationXRole() throws BusinessDelegateException, RemoveException {
		EmpXLocationXRolePK empXLocationXRolePK = new EmpXLocationXRolePK();
		empXLocationXRolePK.setEmployeeId("485731");
		empXLocationXRolePK.setLocationCd("AAHA");
		empXLocationXRolePK.setRoleId(5);
		empXLocationXRoleManagerBean.removeEmpXLocationXRole(empXLocationXRolePK);
	}
	
	@Test
	public void testUpdateEmpXLocationXRole() throws BusinessDelegateException, EmpXLocationXRoleException {
		empXLocationXRoleManagerBean.updateEmpXLocationXRole(empXLocationXRoleVO);
	}
}
