package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.OtherPaymentException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.OtherPaymentVO;
public class OtherPaymentManagerBeanTest {

	OtherPaymentManagerBean otherPaymentManagerBean = new OtherPaymentManagerBean();
	
	OtherPaymentVO otherPaymentVO = getVO();
	
	public OtherPaymentVO getVO() {
		OtherPaymentVO otherPaymentVO = new OtherPaymentVO();
		otherPaymentVO.setAwbNbr("802495442150");
		otherPaymentVO.setOtherPymtId(298571);
		return otherPaymentVO;
	}
	
	@Test
	public void testSetOtherPayment() throws BusinessDelegateException, OtherPaymentException {
		otherPaymentManagerBean.setOtherPayment(otherPaymentVO);
	}

	@Test
	public void testGetOtherPayment() throws BusinessDelegateException, FinderException {
		int otherPymtId = 298571;
		otherPaymentManagerBean.getOtherPayment(otherPymtId);
	}
	
	@Test
	public void testGetAllOtherPayments() throws BusinessDelegateException {
		otherPaymentManagerBean.getAllOtherPayments();
	}
	
	@Test
	public void testGetOtherPaymentOpenByLocation() throws BusinessDelegateException {
		String locationCd = null;
		otherPaymentManagerBean.getOtherPaymentOpenByLocation(locationCd);
	}
	
	@Test
	public void testGetOtherPaymentByEodId() throws BusinessDelegateException {
		int eodId = 0;
		otherPaymentManagerBean.getOtherPaymentByEodId(eodId);
	}
	
	@Test
	public void testRemoveOtherPayment() throws BusinessDelegateException, RemoveException {
		int otherPymtId = 298571;
		otherPaymentManagerBean.removeOtherPayment(otherPymtId);
	}
	
	@Test
	public void testUpdateOtherPayment() throws BusinessDelegateException, OtherPaymentException {
		otherPaymentManagerBean.updateOtherPayment(otherPaymentVO);
	}
}
