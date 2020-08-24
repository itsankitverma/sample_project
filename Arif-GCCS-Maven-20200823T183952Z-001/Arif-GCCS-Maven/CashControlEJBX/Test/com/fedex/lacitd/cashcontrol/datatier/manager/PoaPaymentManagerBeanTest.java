package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PoaPaymentException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaPaymentVO;

public class PoaPaymentManagerBeanTest {

	PoaPaymentManagerBean poaPaymentManagerBean = new PoaPaymentManagerBean();
	
	PoaPaymentVO poaPaymentVO = getVO();
	
	public PoaPaymentVO getVO() {
		PoaPaymentVO poaPaymentVO = new PoaPaymentVO();
		poaPaymentVO.setPoaPaymentsId(4327459);
		return poaPaymentVO;
	}
	
	@Test
	public void testSetPoaPayment() throws BusinessDelegateException, PoaPaymentException {
		poaPaymentManagerBean.setPoaPayment(poaPaymentVO);
	}
	
	@Test
	public void testGetPoaPayment() throws BusinessDelegateException, FinderException {
		int poaPaymentsId = 4327459;
		poaPaymentManagerBean.getPoaPayment(poaPaymentsId);
	}
	
	@Test
	public void testGetAllPoaPayments() throws BusinessDelegateException {
		poaPaymentManagerBean.getAllPoaPayments();
	}
	
	@Test
	public void testGetPoaPaymentByEodId() throws BusinessDelegateException {
		int eodId = 0;
		poaPaymentManagerBean.getPoaPaymentByEodId(eodId);
	}
	
	@Test
	public void testRemovePoaPayment() throws BusinessDelegateException, RemoveException {
		int poaPaymentsId = 4327459;
		poaPaymentManagerBean.removePoaPayment(poaPaymentsId);
	}
	
	@Test
	public void testUpdatePoaPayment() throws BusinessDelegateException, PoaPaymentException {
		poaPaymentManagerBean.updatePoaPayment(poaPaymentVO);
	}
}
