package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.util.Date;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.CreditCardPaymentException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CreditCardPaymentVO;

public class CreditCardPaymentManagerBeanTest {
	
	CreditCardPaymentManagerBean creditCardPaymentController = new CreditCardPaymentManagerBean();

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
	public void testSetCreditCardPayment() throws BusinessDelegateException, CreditCardPaymentException {
		CreditCardPaymentVO creditCardPaymentVO = new CreditCardPaymentVO();
		creditCardPaymentController.setCreditCardPayment(creditCardPaymentVO);
	}
	
	@Test
	public void testGetCreditCardPayment() throws BusinessDelegateException, FinderException {
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
	public void testRemoveCreditCardPayment() throws BusinessDelegateException, RemoveException {
		int creditCardPymtId = 548;
		creditCardPaymentController.removeCreditCardPayment(creditCardPymtId);
	}
	
	@Test
	public void testUpdateCreditCardPayment() throws BusinessDelegateException, CreditCardPaymentException {
		CreditCardPaymentVO creditCardPaymentVO = new CreditCardPaymentVO();
		creditCardPaymentController.updateCreditCardPayment(creditCardPaymentVO);
	}
	
}
