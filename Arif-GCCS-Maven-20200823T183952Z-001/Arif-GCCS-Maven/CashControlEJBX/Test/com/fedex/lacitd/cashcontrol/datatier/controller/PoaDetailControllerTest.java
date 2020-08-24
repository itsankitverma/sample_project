package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaDetailVO;

public class PoaDetailControllerTest {
	
	PoaDetailController poaDetailController = new PoaDetailController();
	
	PoaDetailVO poaDetailVO = getVO();
	
	public PoaDetailVO getVO() {
		PoaDetailVO poaDetailVO = new PoaDetailVO();
		poaDetailVO.setPoaDetailId(4809034);
		return poaDetailVO;
	}

	@Test
	public void testSetPoaDetail() throws BusinessDelegateException {
		poaDetailController.setPoaDetail(poaDetailVO);
	}
	
	@Test
	public void testGetPoaDetail() throws BusinessDelegateException {
		int poaDetailId = 4809034;
		poaDetailController.getPoaDetail(poaDetailId);
	}
	
	@Test
	public void testGetAllPoaDetails() throws BusinessDelegateException {
		poaDetailController.getAllPoaDetails();
	}
	
	@Test
	public void testGetPoaDetailPoaDetails() throws BusinessDelegateException {
		int poaPaymentsId = 4809034;
		poaDetailController.getPoaDetailPoaDetails(poaPaymentsId);
	}
	
	@Test
	public void testRemovePoaDetail() throws BusinessDelegateException {
		int poaDetailId = 4809034;
		poaDetailController.removePoaDetail(poaDetailId);
	}
	
	@Test
	public void testUpdatePoaDetail() throws BusinessDelegateException {
		poaDetailController.updatePoaDetail(poaDetailVO);
	}
	
	@Test
	public void testGetPoaDetailManager() throws BusinessDelegateException {
		poaDetailController.getPoaDetailManager();
	}
}
