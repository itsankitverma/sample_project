package com.fedex.lacitd.cashcontrol.datatier.controller;

import java.util.Date;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CreditCardPaymentVO;

public class CreditCardPaymentControllerTest {
	
	CreditCardPaymentController creditCardPaymentController = new CreditCardPaymentController();

	CreditCardPaymentVO cardPaymentVO = getVO();
	
	public CreditCardPaymentVO getVO() {
		CreditCardPaymentVO cardPaymentVO = new CreditCardPaymentVO();
		cardPaymentVO.setBatchDt(new Date());
		cardPaymentVO.setComments(null);
		cardPaymentVO.setCreditCardPymtId(548);
		cardPaymentVO.setCurrencyCd("EUR");
		cardPaymentVO.setDepositSlipId(12198);
		cardPaymentVO.setEmployeeId("173618");
		cardPaymentVO.setEodId(0);
		cardPaymentVO.setLocationCd("FDFA");
		cardPaymentVO.setPaymentDocNbr("10/15/2003");
		cardPaymentVO.setPaymentType("EFT");
		cardPaymentVO.setStatusId(1);
		cardPaymentVO.setTotalAmt(1000);
		cardPaymentVO.setTotalReimbursed(100);
		return cardPaymentVO;
	}
	
	@Test
	public void testSetCreditCardPayment() throws BusinessDelegateException {
		CreditCardPaymentVO creditCardPaymentVO = new CreditCardPaymentVO();
		creditCardPaymentController.setCreditCardPayment(creditCardPaymentVO);
	}
	
	@Test
	public void testGetCreditCardPayment() throws BusinessDelegateException {
		int creditCardPymtId = 548;
		creditCardPaymentController.getCreditCardPayment(creditCardPymtId);
	}
	
	@Test
	public void testGetAllCreditCardPayments() throws BusinessDelegateException {
		creditCardPaymentController.getAllCreditCardPayments();
	}
	
	@Test
	public void testGetCreditCardPaymentByEodId() throws BusinessDelegateException {
		int eodId = 548;
		creditCardPaymentController.getCreditCardPaymentByEodId(eodId);
	}
	@Test
	public void testRemoveCreditCardPayment() throws BusinessDelegateException {
		int creditCardPymtId = 548;
		creditCardPaymentController.removeCreditCardPayment(creditCardPymtId);
	}
	
	@Test
	public void testUpdateCreditCardPayment() throws BusinessDelegateException {
		CreditCardPaymentVO creditCardPaymentVO = new CreditCardPaymentVO();
		creditCardPaymentController.updateCreditCardPayment(creditCardPaymentVO);
	}
	
	@Test
	public void testGetCreditCardPaymentManager() throws BusinessDelegateException {
		creditCardPaymentController.getCreditCardPaymentManager();
	}
}
