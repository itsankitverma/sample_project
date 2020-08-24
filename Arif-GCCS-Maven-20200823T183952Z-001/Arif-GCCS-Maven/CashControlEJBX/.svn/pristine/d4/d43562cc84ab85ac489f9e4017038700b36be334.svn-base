package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RoleVO;

public class RoleControllerTest {

	RoleController roleController = new RoleController();
	
	RoleVO roleVO = getVO();
	
	public RoleVO getVO() {
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleId(24);
		return roleVO;
	}
	
	@Test
	public void testSetRole() throws BusinessDelegateException {
		roleController.setRole(roleVO);
	}

	@Test
	public void testGetRole() throws BusinessDelegateException {
		int roleId = 24;
		roleController.getRole(roleId);
	}
	
	@Test
	public void testGetAllRoles() throws BusinessDelegateException {
		roleController.getAllRoles();
	}
	
	@Test
	public void testRemoveRole() throws BusinessDelegateException {
		int roleId = 24;
		roleController.removeRole(roleId);
	}
	
	@Test
	public void testUpdateRole() throws BusinessDelegateException {
		roleController.updateRole(roleVO);
	}
	
	@Test
	public void testGetRoleManager() throws BusinessDelegateException {
		roleController.getRoleManager();
	}
	
}
