package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RecStatusVO;

public class RecStatusControllerTest {
	
	RecStatusController recStatusController = new RecStatusController();
	
	RecStatusVO recStatusVO = getVO();
	
	public RecStatusVO getVO() {
		RecStatusVO recStatusVO = new RecStatusVO();
		recStatusVO.setStatusId(1);
		return recStatusVO;
	}
	
	@Test
	public void testSetRecStatus() throws BusinessDelegateException {
		recStatusController.setRecStatus(recStatusVO);
	}

	@Test
	public void testGetRecStatus() throws BusinessDelegateException {
		int statusId = 1;
		recStatusController.getRecStatus(statusId);
	}
	
	@Test
	public void testGetAllRecStatus() throws BusinessDelegateException {
		recStatusController.getAllRecStatus();
	}
	
	@Test
	public void testRemoveRecStatus() throws BusinessDelegateException {
		int statusId = 1;
		recStatusController.removeRecStatus(statusId);
	}
	
	@Test
	public void testUpdateRecStatus() throws BusinessDelegateException {
		recStatusController.updateRecStatus(recStatusVO);
	}
	
	@Test
	public void testGetRecStatusManager() throws BusinessDelegateException {
		recStatusController.getRecStatusManager();
	}
}
