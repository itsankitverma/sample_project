package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.InCageExceptionsVO;

public class InCageExceptionsControllerTest {

	InCageExceptionsController inCageExceptionsController = new InCageExceptionsController();
	
	InCageExceptionsVO inCageExceptionsVO = getVO();
	
	public InCageExceptionsVO getVO() {
		InCageExceptionsVO inCageExceptionsVO = new InCageExceptionsVO();
		inCageExceptionsVO.setInCageExcpId(3525);
		return inCageExceptionsVO;
	}
	
	@Test
	public void testSetInCageExceptions() throws BusinessDelegateException {
		inCageExceptionsController.setInCageExceptions(inCageExceptionsVO);
	}
	
	@Test
	public void testGetInCageExceptions() throws BusinessDelegateException {
		int inCageExcpId = 3525;
		inCageExceptionsController.getInCageExceptions(inCageExcpId);
	}

	@Test
	public void testGetAllInCageExceptions() throws BusinessDelegateException {
		inCageExceptionsController.getAllInCageExceptions();
	}
	
	@Test
	public void testRemoveInCageExceptions() throws BusinessDelegateException {
		int inCageExcpId = 3525;
		inCageExceptionsController.removeInCageExceptions(inCageExcpId);
	}
	
	@Test
	public void testUpdateInCageExceptions() throws BusinessDelegateException {
		inCageExceptionsController.updateInCageExceptions(inCageExceptionsVO);
	}
	
	@Test
	public void testGetInCageExceptionsManager() throws BusinessDelegateException {
		inCageExceptionsController.getInCageExceptionsManager();
	}
	
}
