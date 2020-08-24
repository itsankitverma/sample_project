package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PaymentCtgException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PaymentCtgVO;
public class PaymentCtgManagerBeanTest {

	PaymentCtgManagerBean PaymentCtgManagerBean = new PaymentCtgManagerBean();
	
	PaymentCtgVO paymentCtgVO = getVO();
	
	public PaymentCtgVO getVO() {
		PaymentCtgVO paymentCtgVO = new PaymentCtgVO();
		paymentCtgVO.setPaymentCtgId(1);
		return paymentCtgVO;
	}
	
	@Test
	public void testSetPaymentCtg() throws BusinessDelegateException, PaymentCtgException {
		PaymentCtgManagerBean.setPaymentCtg(paymentCtgVO);
	}
	
	@Test
	public void testGetPaymentCtg() throws BusinessDelegateException, FinderException {
		int paymentCtgId = 1;
		PaymentCtgManagerBean.getPaymentCtg(paymentCtgId);
	}
	
	@Test
	public void testGetAllPaymentCtgs() throws BusinessDelegateException {
		PaymentCtgManagerBean.getAllPaymentCtgs();
	}

	@Test
	public void testGetPaymentCtgExtPaymentCtgs() throws BusinessDelegateException {
		PaymentCtgManagerBean.getPaymentCtgExtPaymentCtgs();
	}
	
	@Test
	public void testRemovePaymentCtg() throws BusinessDelegateException, RemoveException {
		int paymentCtgId = 1;
		PaymentCtgManagerBean.removePaymentCtg(paymentCtgId);
	}
	
	@Test
	public void testUpdatePaymentCtg() throws BusinessDelegateException, PaymentCtgException {
		PaymentCtgManagerBean.updatePaymentCtg(paymentCtgVO);
	}
}
