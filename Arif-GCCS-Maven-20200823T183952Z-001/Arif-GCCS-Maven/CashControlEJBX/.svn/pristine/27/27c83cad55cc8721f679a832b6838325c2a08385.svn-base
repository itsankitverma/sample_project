package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.OtherPymtCtgVO;

public class OtherPymtCtgControllerTest {

	OtherPymtCtgController otherPymtCtgController = new OtherPymtCtgController();
	
	OtherPymtCtgVO otherPymtCtgVO = getVO();
	
	public OtherPymtCtgVO getVO() {
		OtherPymtCtgVO otherPymtCtgVO = new OtherPymtCtgVO();
		otherPymtCtgVO.setOtherPaymentCtgId(301);
		return otherPymtCtgVO;
	}
	
	@Test
	public void testSetOtherPymtCtg() throws BusinessDelegateException {
		otherPymtCtgController.setOtherPymtCtg(otherPymtCtgVO);
	}
	
	public void testGetOtherPymtCtg() throws BusinessDelegateException {
		int otherPaymentCtgId = 301;
		otherPymtCtgController.getOtherPymtCtg(otherPaymentCtgId);
	}
	
	public void testGetAllPaymentCtgs() throws BusinessDelegateException {
		otherPymtCtgController.getAllPaymentCtgs();
	}
	
	public void testRemoveOtherPymtCtg() throws BusinessDelegateException {
		int otherPaymentCtgId = 301;
		otherPymtCtgController.removeOtherPymtCtg(otherPaymentCtgId);
	}
	
	public void testUpdateOtherPymtCtg() throws BusinessDelegateException {
		otherPymtCtgController.updateOtherPymtCtg(otherPymtCtgVO);
	}
	
	public void testGetOtherPymtCtgManager() throws BusinessDelegateException {
		otherPymtCtgController.getOtherPymtCtgManager();
	}
}
