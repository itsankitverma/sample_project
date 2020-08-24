package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PaymentCtgVO;

public class PaymentCtgControllerTest {

	PaymentCtgController paymentCtgController = new PaymentCtgController();
	
	PaymentCtgVO paymentCtgVO = getVO();
	
	public PaymentCtgVO getVO() {
		PaymentCtgVO paymentCtgVO = new PaymentCtgVO();
		paymentCtgVO.setPaymentCtgId(1);
		return paymentCtgVO;
	}
	
	@Test
	public void testSetPaymentCtg() throws BusinessDelegateException {
		paymentCtgController.setPaymentCtg(paymentCtgVO);
	}
	
	@Test
	public void testGetPaymentCtg() throws BusinessDelegateException {
		int paymentCtgId = 1;
		paymentCtgController.getPaymentCtg(paymentCtgId);
	}
	
	@Test
	public void testGetAllPaymentCtgs() throws BusinessDelegateException {
		paymentCtgController.getAllPaymentCtgs();
	}

	@Test
	public void testGetPaymentCtgExtPaymentCtgs() throws BusinessDelegateException {
		paymentCtgController.getPaymentCtgExtPaymentCtgs();
	}
	
	@Test
	public void testRemovePaymentCtg() throws BusinessDelegateException {
		int paymentCtgId = 1;
		paymentCtgController.removePaymentCtg(paymentCtgId);
	}
	
	@Test
	public void testUpdatePaymentCtg() throws BusinessDelegateException {
		paymentCtgController.updatePaymentCtg(paymentCtgVO);
	}
	
	@Test
	public void testGetPaymentCtgManager() throws BusinessDelegateException {
		paymentCtgController.getPaymentCtgManager();
	}
}
