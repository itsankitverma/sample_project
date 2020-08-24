package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.InCageExceptionsException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.InCageExceptionsVO;

public class InCageExceptionsManagerBeanTest {

	InCageExceptionsManagerBean inCageExceptionsManagerBean = new InCageExceptionsManagerBean();
	
	InCageExceptionsVO inCageExceptionsVO = getVO();
	
	public InCageExceptionsVO getVO() {
		InCageExceptionsVO inCageExceptionsVO = new InCageExceptionsVO();
		inCageExceptionsVO.setInCageExcpId(3525);
		return inCageExceptionsVO;
	}
	
	@Test
	public void testSetInCageExceptions() throws BusinessDelegateException, InCageExceptionsException {
		inCageExceptionsManagerBean.setInCageExceptions(inCageExceptionsVO);
	}
	
	@Test
	public void testGetInCageExceptions() throws BusinessDelegateException, FinderException {
		int inCageExcpId = 3525;
		inCageExceptionsManagerBean.getInCageExceptions(inCageExcpId);
	}

	@Test
	public void testGetAllInCageExceptions() throws BusinessDelegateException {
		inCageExceptionsManagerBean.getAllInCageExceptions();
	}
	
	@Test
	public void testRemoveInCageExceptions() throws BusinessDelegateException, RemoveException {
		int inCageExcpId = 3525;
		inCageExceptionsManagerBean.removeInCageExceptions(inCageExcpId);
	}
	
	@Test
	public void testUpdateInCageExceptions() throws BusinessDelegateException, InCageExceptionsException {
		inCageExceptionsManagerBean.updateInCageExceptions(inCageExceptionsVO);
	}
}
