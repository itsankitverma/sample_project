package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.OtherPaymentVO;

public class OtherPaymentControllerTest {

	OtherPaymentController otherPaymentController = new OtherPaymentController();
	
	OtherPaymentVO otherPaymentVO = getVO();
	
	public OtherPaymentVO getVO() {
		OtherPaymentVO otherPaymentVO = new OtherPaymentVO();
		otherPaymentVO.setAwbNbr("802495442150");
		otherPaymentVO.setOtherPymtId(298571);
		return otherPaymentVO;
	}
	
	@Test
	public void testSetOtherPayment() throws BusinessDelegateException {
		otherPaymentController.setOtherPayment(otherPaymentVO);
	}

	@Test
	public void testGetOtherPayment() throws BusinessDelegateException {
		int otherPymtId = 298571;
		otherPaymentController.getOtherPayment(otherPymtId);
	}
	
	@Test
	public void testGetAllOtherPayments() throws BusinessDelegateException {
		otherPaymentController.getAllOtherPayments();
	}
	
	@Test
	public void testGetOtherPaymentOpenByLocation() throws BusinessDelegateException {
		String locationCd = null;
		otherPaymentController.getOtherPaymentOpenByLocation(locationCd);
	}
	
	@Test
	public void testGetOtherPaymentByEodId() throws BusinessDelegateException {
		int eodId = 0;
		otherPaymentController.getOtherPaymentByEodId(eodId);
	}
	
	@Test
	public void testRemoveOtherPayment() throws BusinessDelegateException {
		int otherPymtId = 298571;
		otherPaymentController.removeOtherPayment(otherPymtId);
	}
	
	@Test
	public void testUpdateOtherPayment() throws BusinessDelegateException {
		otherPaymentController.updateOtherPayment(otherPaymentVO);
	}
	
	@Test
	public void testGetOtherPaymentManager() throws BusinessDelegateException {
		otherPaymentController.getOtherPaymentManager();
	}
}
