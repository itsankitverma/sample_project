package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PreStatusVO;

public class PreStatusControllerTest {
	
	PreStatusController preStatusController = new PreStatusController();

	PreStatusVO preStatusVO = getVO();
	
	public PreStatusVO getVO() {
		PreStatusVO preStatusVO = new PreStatusVO();
		preStatusVO.setStatusIdNbr(1);
		return preStatusVO;
	}
	
	@Test
	public void testSetPreStatus() throws BusinessDelegateException {
		preStatusController.setPreStatus(preStatusVO);
	}
	
	@Test
	public void testGetPreStatus() throws BusinessDelegateException {
		int statusIdNbr = 1;
		preStatusController.getPreStatus(statusIdNbr);
	}
	
	@Test
	public void testGetAllPreStatus() throws BusinessDelegateException {
		preStatusController.getAllPreStatus();
	}
	
	@Test
	public void testRemovePreStatus() throws BusinessDelegateException {
		int statusIdNbr = 1;
		preStatusController.removePreStatus(statusIdNbr);
	}
	
	@Test
	public void testUpdatePreStatus() throws BusinessDelegateException {
		preStatusController.updatePreStatus(preStatusVO);
	}
	
	@Test
	public void testGetPreStatusManager() throws BusinessDelegateException {
		preStatusController.getPreStatusManager();
	}
}
