package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.FTC_RecStatusVO;

public class FTC_RecStatusControllerTest {
	
	FTC_RecStatusController ftc_RecStatusController = new FTC_RecStatusController();
	
	FTC_RecStatusVO FTC_recStatusVO = getVO();
	
	public FTC_RecStatusVO getVO() {
		FTC_RecStatusVO FTC_recStatusVO = new FTC_RecStatusVO();
		FTC_recStatusVO.setStatusId(1);
		return FTC_recStatusVO;
	}

	@Test
	public void testSetFTC_RecStatus() throws BusinessDelegateException {
		ftc_RecStatusController.setFTC_RecStatus(FTC_recStatusVO);
	}
	
	@Test
	public void testGetFTC_RecStatus() throws BusinessDelegateException {
		int statusId = 1;
		ftc_RecStatusController.getFTC_RecStatus(statusId);
	}
	
	@Test
	public void testGetAllFTC_RecStatus() throws BusinessDelegateException {
		ftc_RecStatusController.getAllFTC_RecStatus();
	}
	
	@Test
	public void testRemoveFTC_RecStatus() throws BusinessDelegateException {
		int statusId = 1;
		ftc_RecStatusController.removeFTC_RecStatus(statusId);
	}
	
	@Test
	public void testUpdateFTC_RecStatus() throws BusinessDelegateException {
		ftc_RecStatusController.updateFTC_RecStatus(FTC_recStatusVO);
	}
	
	@Test
	public void testGetFTC_RecStatusManager() throws BusinessDelegateException {
		ftc_RecStatusController.getFTC_RecStatusManager();
	}
}
