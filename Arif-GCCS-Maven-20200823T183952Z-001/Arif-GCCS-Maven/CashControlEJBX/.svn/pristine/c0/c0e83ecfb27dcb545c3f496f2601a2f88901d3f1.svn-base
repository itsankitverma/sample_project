package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaPaymentVO;

public class PoaPaymentControllerTest {

	PoaPaymentController paymentController = new PoaPaymentController();
	
	PoaPaymentVO poaPaymentVO = getVO();
	
	public PoaPaymentVO getVO() {
		PoaPaymentVO poaPaymentVO = new PoaPaymentVO();
		poaPaymentVO.setPoaPaymentsId(4327459);
		return poaPaymentVO;
	}
	
	@Test
	public void testSetPoaPayment() throws BusinessDelegateException {
		paymentController.setPoaPayment(poaPaymentVO);
	}
	
	@Test
	public void testGetPoaPayment() throws BusinessDelegateException {
		int poaPaymentsId = 4327459;
		paymentController.getPoaPayment(poaPaymentsId);
	}
	
	@Test
	public void testGetAllPoaPayments() throws BusinessDelegateException {
		paymentController.getAllPoaPayments();
	}
	
	@Test
	public void testGetPoaPaymentByEodId() throws BusinessDelegateException {
		int eodId = 0;
		paymentController.getPoaPaymentByEodId(eodId);
	}
	
	@Test
	public void testRemovePoaPayment() throws BusinessDelegateException {
		int poaPaymentsId = 4327459;
		paymentController.removePoaPayment(poaPaymentsId);
	}
	
	@Test
	public void testUpdatePoaPayment() throws BusinessDelegateException {
		paymentController.updatePoaPayment(poaPaymentVO);
	}
	
	@Test
	public void testGetPoaPaymentManager() throws BusinessDelegateException {
		paymentController.getPoaPaymentManager();
	}
}
