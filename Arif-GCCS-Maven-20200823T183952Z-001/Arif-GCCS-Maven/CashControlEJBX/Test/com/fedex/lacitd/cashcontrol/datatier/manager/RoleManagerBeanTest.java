package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.RoleException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RoleVO;
public class RoleManagerBeanTest {

	RoleManagerBean roleManagerBean = new RoleManagerBean();
	
	RoleVO roleVO = getVO();
	
	public RoleVO getVO() {
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleId(24);
		return roleVO;
	}
	
	@Test
	public void testSetRole() throws BusinessDelegateException, RoleException {
		roleManagerBean.setRole(roleVO);
	}

	@Test
	public void testGetRole() throws BusinessDelegateException, FinderException {
		int roleId = 24;
		roleManagerBean.getRole(roleId);
	}
	
	@Test
	public void testGetAllRoles() throws BusinessDelegateException {
		roleManagerBean.getAllRoles();
	}
	
	@Test
	public void testRemoveRole() throws BusinessDelegateException, RemoveException {
		int roleId = 24;
		roleManagerBean.removeRole(roleId);
	}
	
	@Test
	public void testUpdateRole() throws BusinessDelegateException, RoleException {
		roleManagerBean.updateRole(roleVO);
	}
	
}
